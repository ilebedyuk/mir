package com.example.demo.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MirotvoretchParser parser;

    public List<FullNameUrlDto> parse(List<String> fullNames) {
        List<FullNameUrlDto> dtos = new ArrayList<>();
        for (String fullName : fullNames) {
            Optional<String> urlByFullName = parser.getUrlByFullName(fullName);
            urlByFullName.ifPresent(url -> dtos.add(FullNameUrlDto.builder().fullName(fullName).url(url).build()));
        }
        return dtos;
    }
}

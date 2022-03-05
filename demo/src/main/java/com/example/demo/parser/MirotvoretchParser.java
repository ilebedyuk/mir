package com.example.demo.parser;

import lombok.SneakyThrows;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Optional;

@Component
public class MirotvoretchParser {

    @SneakyThrows
    public Optional<String> getUrlByFullName(String fullName) {
        var url = "https://myrotvorets.center/criminal/?cf%5Bname%5D=" + fullName + "&cf%5Bcountry%5D=&cf%5Baddress%5D=&cf%5Bphone%5D=&cf%5Bdesc%5D=";
        Document doc = Jsoup.connect(url).get();
        Elements notFound = doc.select(".not-found");
        if (notFound.isEmpty()) {
            return Optional.of(url);
        }
        return Optional.empty();
    }
}

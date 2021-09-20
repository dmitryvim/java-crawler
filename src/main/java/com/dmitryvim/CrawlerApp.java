package com.dmitryvim;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;

public class CrawlerApp {

    public static void main(String[] args) {
        var processor = new Processor();
        // TODO parametrise app

//        var result = processor.crawl(URI.create(args[0]));
        var result = processor.crawl(URI.create("https://www.java.com/en/"));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.valueToTree(result));

    }
}

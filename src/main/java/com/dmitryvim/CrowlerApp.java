package com.dmitryvim;

import java.net.URI;

public class CrowlerApp {

    public static void main(String[] args) {
        var processor = new Processor();
        // TODO parametrise app
        processor.crawl(URI.create("https://www.java.com/en/"));
    }
}

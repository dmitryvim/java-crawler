package com.dmitryvim;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Processor {


    private Set<URI> parsed = new HashSet<>();
    private Map<URI, List<URI>> edges = new HashMap<>();

    // TODO check fuxed capacity
    private ArrayBlockingQueue<URI> queue = new ArrayBlockingQueue<>(100);

    private final PageLoader pageLoader = new PageLoader();
    private final PageParser pageReader = new PageParser();
    private final Verificator verificator = new Verificator();

    public Map<URI, List<URI>> crawl(URI uri) {
        parsed.add(uri);
        queue.add(uri);
        while(!queue.isEmpty()) {
            step();
        }
        return edges;
    }

    private void step() {
        var uri = queue.poll();
        var content = pageLoader.load(uri);
        var children = pageReader.parse(uri, content);
        add(uri, children);
    }

    private void add(URI parent, List<URI> children) {
        edges.put(parent, children);
        children.forEach(ch -> {
            if (verificator.verify(ch) && parsed.add(ch)) {
                queue.add(ch);
            }
        });
    }
}

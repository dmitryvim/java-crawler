package com.dmitryvim;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Processor {


    private AtomicInteger pagesLoading = new AtomicInteger(0);

    private Set<URI> parsed = new HashSet<>();
    private Map<URI, Set<URI>> edges = new HashMap<>();

    // TODO check fixed capacity
    private ArrayBlockingQueue<URI> queue = new ArrayBlockingQueue<>(1000);

    // TODO add ctor params
    private final PageLoader pageLoader = new PageLoader();
    private final PageParser pageReader = new PageParser();
    private final Verificator verificator = new Verificator();

    public Map<URI, Set<URI>> crawl(URI uri) {
        addFirst(uri);

        ExecutorService service = Executors.newFixedThreadPool(4);
        while(!queue.isEmpty() || pagesLoading.get() > 0) {
            if (!queue.isEmpty()) service.submit(this::step);
        }
        service.shutdown();

        return getEdges();
    }

    private void step() {
        if (queue.isEmpty()) return;

        pagesLoading.incrementAndGet();
        var uri = queue.poll();
        var content = pageLoader.load(uri);
        var children = pageReader.parse(uri, content);
        add(uri, children);
        pagesLoading.decrementAndGet();
    }

    private synchronized void addFirst(URI uri) {
        parsed.add(uri);
        queue.add(uri);

    }

    private synchronized void add(URI parent, Set<URI> children) {
        edges.put(parent, children);
        children.forEach(ch -> {
            if (verificator.verify(ch) && parsed.add(ch)) {
                queue.add(ch);
            }
        });
    }

    private synchronized Map<URI, Set<URI>> getEdges() {
        return edges;
    }
}

package com.dmitryvim;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private final URI uri;

    private final List<Node> children = new ArrayList<>();

    private final boolean duplicate;

    public Node(URI uri, List<Node> children, boolean duplicate) {
        this.uri = uri;
        this.duplicate = duplicate;
    }

    // TODO do not forget about concur
    public void append(Node node) {
        children.add(node);
    }
}

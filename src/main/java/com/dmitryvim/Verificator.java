package com.dmitryvim;

import java.net.URI;
import java.util.Set;

public class Verificator {

    private static final Set<String> allowedProtocols = Set.of("http", "https");

    private static final Set<String> allowedHosts = Set.of("java.com", "coffeecup.com");

    public boolean verify(URI uri) {
        return uri.isAbsolute()
                && allowedProtocols.contains(uri.getScheme())
                && allowedHosts.stream().anyMatch(uri.getHost()::endsWith);
    }
}

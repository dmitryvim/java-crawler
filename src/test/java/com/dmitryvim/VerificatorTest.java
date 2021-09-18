package com.dmitryvim;

import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class VerificatorTest {

    Verificator verificator = new Verificator();

    @Test
    public void should_verify_java_domain_and_subdomains() {
        // java
        assertTrue(verificator.verify(URI.create("https://www.java.com/ru/")));
        assertTrue(verificator.verify(URI.create("https://asb.cver.java.com/en/")));
        assertTrue(verificator.verify(URI.create("https://www.java.com/en/htsd?gbejkv=frew")));
        assertTrue(verificator.verify(URI.create("http://www.java.com/en/")));
    }

    @Test
    public void should_not_verify_not_http_https() {
        assertFalse(verificator.verify(URI.create("ftp://www.java.com/en/")));
        assertFalse(verificator.verify(URI.create("udp://anv.java.com/en/")));
        assertFalse(verificator.verify(URI.create("/a/v/c/d")));
    }

    @Test
    public void should_verify_other_domains() {
        assertTrue(verificator.verify(URI.create("https://www.coffeecup.com/njfenrf")));
        assertTrue(verificator.verify(URI.create("http://gw4jn.ger.er.coffeecup.com/")));
        assertTrue(verificator.verify(URI.create("https://a.cv.d.coffeecup.com/")));
    }
}
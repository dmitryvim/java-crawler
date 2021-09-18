package com.dmitryvim;

import javax.xml.transform.URIResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PageParser {

    public Set<URI> parse(URI parent, String content) {
        // TODO Jsoup can be used for a proper HTML parsing
        return Pattern.compile("<a[^>]+href=[\"']?([^\"']+)[\"']?[^>]*>(.+?)</a>",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL)
                .matcher(content).results()
                .map(r -> r.group(1))
                .map(parent::resolve)
                .collect(Collectors.toSet());
    }

}

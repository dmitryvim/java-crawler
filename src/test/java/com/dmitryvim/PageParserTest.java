package com.dmitryvim;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PageParserTest {

    PageParser parser = new PageParser();

    @Test
    public void should_parse_full_links() {
        var insecLink = "http://acfds.bsda/c";
        var secLink = "https://dfsa.cfasdgwergvqw.ef/a";
        var notLink = "https://drfear.c/af";
        var list = parser.parse(URI.create("https://java.net"), withA(insecLink) + " kthngr; " + withA(secLink) + "jgtrns;gjntrbsj" + notLink);

        assertThat(list).containsExactlyInAnyOrder(URI.create(insecLink), URI.create(secLink));
    }

    // TODO add tests from real html page with more A variety

    @Test
    public void should_parse_links_without_host() {
        var relatedLink = "/c";
        var expectedLink = "https://java.net/c";
        var list = parser.parse(URI.create("https://java.net"), "berwhjbg5j4" + withA(relatedLink) + "jgrbelwgjke https://grbeh.vrn/");

        assertThat(list).containsExactlyInAnyOrder(URI.create(expectedLink));
    }


    private static String withA(String link) {
        return "<a param=\"" + UUID.randomUUID() + "\" href=\"" + link + "\">some text</a>";
    }
}

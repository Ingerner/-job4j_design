package ru.job4j.io;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void whenWithComments() {
        String path = "./data/with_comments_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("surname"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairMismatch() {
        String path = "./data/does_not_match_pattern.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("surname"));
    }

}

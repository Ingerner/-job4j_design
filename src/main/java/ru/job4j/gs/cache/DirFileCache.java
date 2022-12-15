package ru.job4j.gs.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
       String read = null;
        try {
            read = Files.readString(Paths.get(cachingDir, key));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return read;
    }
}

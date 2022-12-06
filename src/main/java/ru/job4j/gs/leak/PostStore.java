package ru.job4j.gs.leak;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
хранилище постов
 */
public class PostStore {

    private  Map<Integer, Post> posts = new HashMap<>();

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        Integer id = atomicInteger.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}

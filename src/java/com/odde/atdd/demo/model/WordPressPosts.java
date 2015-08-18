package com.odde.atdd.demo.model;

import com.odde.atdd.demo.adaptor.WordPressAdaptor;

import java.util.function.Consumer;

public class WordPressPosts implements Posts {
    private final WordPressAdaptor wordPressAdaptor;

    public WordPressPosts(WordPressAdaptor wordPressAdaptor) {
        this.wordPressAdaptor = wordPressAdaptor;
    }

    public void processAllPosts(final Consumer<Post> onEachPost) {
        Credential admin = CredentialFactory.createAdmin();

        wordPressAdaptor.getAllPosts(admin, (Post post) -> {
            onEachPost.accept(post);
        });
    }
}
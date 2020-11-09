package com.ccbedoya.BlogBackend.controller;

import com.ccbedoya.BlogBackend.model.Post;
import com.ccbedoya.BlogBackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    Iterable<Post> all() {
        return postRepository.findAll();
    }

    @PostMapping("/posts")
    Post newPost (@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }
}

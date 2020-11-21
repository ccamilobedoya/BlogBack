package com.ccbedoya.BlogBackend.controller;

import com.ccbedoya.BlogBackend.model.Post;
import com.ccbedoya.BlogBackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts/all")
    Iterable<Post> all() {
        return postRepository.findAll();
    }

    @GetMapping("/posts")
    Page<Post> all(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        return postRepository.findAll(pageable);
    }

    @PostMapping("/post")
    Post newPost (@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }

    @GetMapping("/post")
    Optional<Post> getPost (@RequestParam(value = "id") Long id) {
        return postRepository.findById(id);
    }

    @GetMapping("/posts/count")
    Long getPostsCount () {
        return postRepository.count();
    }

    @PutMapping("/post/like")
    void likePost (@RequestParam(value = "id") Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        Post post = optionalPost.get();
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
    }

    @DeleteMapping("/post")
    void deletePost (@RequestParam(value = "id") Long id) { postRepository.deleteById(id);}

}

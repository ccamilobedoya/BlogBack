package com.ccbedoya.BlogBackend.controller;

import com.ccbedoya.BlogBackend.model.Author;
import com.ccbedoya.BlogBackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    Iterable<Author> all() { return authorRepository.findAll(); }

    @PostMapping("/author")
    Author newAuthor (@RequestBody Author newAuthor) { return authorRepository.save(newAuthor); }

    @DeleteMapping("/author")
    void deleteAuthor (@RequestParam(value = "email") String email) {
        authorRepository.deleteById(email);
    }
}

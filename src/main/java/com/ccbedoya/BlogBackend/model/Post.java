package com.ccbedoya.BlogBackend.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

import java.sql.Timestamp;

@Entity(name = "posts")
public class Post {

    @Id
    Long id;
    String title;
    String imageUrl;
    String text;
    Timestamp createdDate;
    Long likes;
    @Reference
    Author author;

    public Post(String title, String imageUrl, String text) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.likes = 0l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

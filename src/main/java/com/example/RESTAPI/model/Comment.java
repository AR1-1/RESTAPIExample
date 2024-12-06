package com.example.RESTAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private  String text;
    private String author;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private Blog blogPost;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(Blog blogPost) {
        this.blogPost = blogPost;
    }

    public String getText() {
        return  text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(Blog blogPost) {
        this.text = text;
    }
    public void setAuthor(Blog blogPost) {
        this.author = author;
    }
}

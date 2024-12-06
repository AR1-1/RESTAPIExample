package com.example.RESTAPI.controller;

import com.example.RESTAPI.model.Blog;
import com.example.RESTAPI.service.Impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> createBlogPost(@RequestBody Blog blogPost) {
        try {
            return ResponseEntity.ok(blogService.createBlogPost(blogPost));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogPosts() {
        try {
            return ResponseEntity.ok(blogService.getAllBlogPosts());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogPostById(@PathVariable Long id) {
        Optional<Blog> blogPost = blogService.getBlogPostById(id);
        if (blogPost.isPresent()) {
            return ResponseEntity.ok(blogPost.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlogPost(@PathVariable Long id, @RequestBody Blog blogPost) {
        try {
            return ResponseEntity.ok(blogService.updateBlog(id, blogPost));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        try {
            blogService.deleteBlogPost(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

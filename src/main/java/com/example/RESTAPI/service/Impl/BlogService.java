package com.example.RESTAPI.service.Impl;

import com.example.RESTAPI.model.Blog;
import com.example.RESTAPI.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public Blog createBlogPost(Blog blogPost) {
        try {
            return blogPostRepository.save(blogPost);
        } catch (Exception e) {
            throw new RuntimeException("Error creating blog post", e);
        }
    }

    public List<Blog> getAllBlogPosts() {
        try {
            return blogPostRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving blog posts", e);
        }
    }

    public Optional<Blog> getBlogPostById(Long id) {
        try {
            return blogPostRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving blog post", e);
        }
    }

    public Blog updateBlog(Long id, Blog blogPost) {
        try {
            if (blogPostRepository.existsById(id)) {
                blogPost.setId(id);
                return blogPostRepository.save(blogPost);
            }
            throw new RuntimeException("Blog post not found");
        } catch (Exception e) {
            throw new RuntimeException("Error updating blog post", e);
        }
    }

    public void deleteBlogPost(Long id) {
        try {
            blogPostRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting blog post", e);
        }
    }
}

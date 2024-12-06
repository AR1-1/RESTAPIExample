package com.example.RESTAPI.service.Impl;

import com.example.RESTAPI.model.Comment;
import com.example.RESTAPI.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException("Error creating comment", e);
        }
    }

    public List<Comment> getCommentsByBlogPost(Long blogPostId) {
        try {
            return commentRepository.findByBlogPostId(blogPostId); // Get comments by blog post ID
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving comments", e);
        }
    }

    public void deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting comment", e);
        }
    }
}

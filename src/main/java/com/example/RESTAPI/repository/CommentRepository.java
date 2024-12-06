package com.example.RESTAPI.repository;

import com.example.RESTAPI.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPostId(Long blogPostId);
}

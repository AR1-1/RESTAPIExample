package com.example.RESTAPI.repository;

import com.example.RESTAPI.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<Blog, Long> {
}

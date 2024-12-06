package com.example.RESTAPI.controller;

import com.example.RESTAPI.model.Blog;
import com.example.RESTAPI.service.Impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogViewController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String getAllBlogPosts(Model model) {
        List<Blog> blogPosts = blogService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "blog";
    }
}

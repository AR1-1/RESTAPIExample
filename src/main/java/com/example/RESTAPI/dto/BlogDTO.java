package com.example.RESTAPI.dto;

import com.example.RESTAPI.model.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BlogDTO {


    private String title;
    private String content;
    private MultipartFile thumbnail;

    private Long id;
    private String thumbnailUrl;
    private List<CommentDTO> comments;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MultipartFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    // Getters and Setters for Response DTO fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }


    public static BlogDTO fromEntity(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setThumbnailUrl("/api/images/" + blog.getId());
        dto.setComments(blog.getComments().stream()
                .map(CommentDTO::fromEntity)
                .toList());
        return dto;
    }

}

package com.example.RESTAPI.dto;

import com.example.RESTAPI.model.Comment;

public class CommentDTO {
    private Long id;
    private String text;
    private String author;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static CommentDTO fromEntity(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setAuthor(comment.getAuthor());
        return dto;
    }
}

package com.example.feedback_service.api.dto;

import java.time.OffsetDateTime;

public class FeedbackResponse {

    private Long id;
    private String email;
    private String content;
    private OffsetDateTime createdAt;

    public FeedbackResponse(Long id, String email, String content, OffsetDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}

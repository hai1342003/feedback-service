package com.example.feedback_service.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FeedbackRequest {

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 2000)
    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

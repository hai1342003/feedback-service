package com.example.feedback_service.mapper;

import com.example.feedback_service.api.dto.FeedbackResponse;
import com.example.feedback_service.domain.Feedback;

public final class FeedbackMapper {

    private FeedbackMapper() {}

    public static FeedbackResponse toResponse(Feedback feedback) {
        return new FeedbackResponse(
                feedback.getId(),
                feedback.getEmail(),
                feedback.getContent(),
                feedback.getCreatedAt()
        );
    }
}

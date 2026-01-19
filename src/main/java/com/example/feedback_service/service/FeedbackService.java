package com.example.feedback_service.service;

import com.example.feedback_service.api.dto.FeedbackRequest;
import com.example.feedback_service.api.dto.FeedbackResponse;
import com.example.feedback_service.domain.Feedback;
import com.example.feedback_service.mapper.FeedbackMapper;
import com.example.feedback_service.repository.FeedbackRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FeedbackResponse create(FeedbackRequest request) {
        Feedback feedback = new Feedback(
                request.getEmail(),
                request.getContent()
        );

        Feedback saved = repository.save(feedback);

        return FeedbackMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public Page<FeedbackResponse> getAll(Pageable pageable) {
        Pageable resolvedPageable = pageable.isUnpaged()
                ? PageRequest.of(0, 20, Sort.by("createdAt").descending())
                : pageable;

        return repository.findAll(resolvedPageable)
                .map(FeedbackMapper::toResponse);
    }

}

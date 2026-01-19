package com.example.feedback_service.api;

import com.example.feedback_service.api.dto.FeedbackRequest;
import com.example.feedback_service.api.dto.FeedbackResponse;
import com.example.feedback_service.domain.Feedback;
import com.example.feedback_service.mapper.FeedbackMapper;
import com.example.feedback_service.repository.FeedbackRepository;
import com.example.feedback_service.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FeedbackResponse> create(
            @Valid @RequestBody FeedbackRequest request
    ) {
        FeedbackResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public Page<FeedbackResponse> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }
}

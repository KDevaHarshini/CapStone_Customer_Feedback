package com.example.feedback_backend.controller;

import com.example.feedback_backend.model.Feedback;
import com.example.feedback_backend.service.FeedbackService;
import jakarta.validation.Valid; // Required for Validation marks
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService; 

    
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@Valid @RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

   
    @GetMapping("/filter/{rating}")
    public ResponseEntity<List<Feedback>> getFeedbackByRating(@PathVariable Integer rating) {
        return ResponseEntity.ok(feedbackService.getFeedbackByRating(rating));
    }

    @GetMapping("/test-error")
    public void testError() {
        throw new RuntimeException("This is a custom error message for the examiner!");
    }
}
package com.example.feedback_backend.service;

import com.example.feedback_backend.model.Feedback;
import com.example.feedback_backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

   
    public List<Feedback> getFeedbackByRating(Integer rating) {
        return feedbackRepository.findByRating(rating);
    }
}
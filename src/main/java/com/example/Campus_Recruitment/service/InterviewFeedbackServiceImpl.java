package com.example.Campus_Recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Campus_Recruitment.model.InterviewFeedback;
import com.example.Campus_Recruitment.repository.InterviewFeedbackRepository;



@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    @Autowired
    private InterviewFeedbackRepository repository;

    @Override
    public InterviewFeedback addFeedback(InterviewFeedback feedback) {
        return repository.save(feedback);
    }

    @Override
    public List<InterviewFeedback> getAllFeedbacks() {
        return repository.findAll();
    }

    @Override
    public InterviewFeedback getFeedbackById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback) {
        InterviewFeedback existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setContent(feedback.getContent());
            existing.setIsInternal(feedback.getIsInternal());
            existing.setInterviewRound(feedback.getInterviewRound());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) {
        return repository.findByJobApplicationApplicationId(applicationId);
    }
}
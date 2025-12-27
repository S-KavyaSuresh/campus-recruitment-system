package com.example.Campus_Recruitment.service;

import java.util.List;

import com.example.Campus_Recruitment.model.InterviewFeedback;


public interface InterviewFeedbackService {
    InterviewFeedback addFeedback(InterviewFeedback feedback);
    List<InterviewFeedback> getAllFeedbacks();
    InterviewFeedback getFeedbackById(Long id);
    InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback);
    List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId);
}
package com.example.Campus_Recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Campus_Recruitment.model.InterviewFeedback;
import com.example.Campus_Recruitment.service.InterviewFeedbackService;


@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackService service;

    @PostMapping
    public ResponseEntity<InterviewFeedback> addFeedback(@RequestBody InterviewFeedback feedback) {
        return new ResponseEntity<>(service.addFeedback(feedback), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllFeedbacks() {
        return ResponseEntity.ok(service.getAllFeedbacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getFeedbackById(@PathVariable Long id) {
        InterviewFeedback feedback = service.getFeedbackById(id);
        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> updateFeedback(@PathVariable Long id, @RequestBody InterviewFeedback feedback) {
        InterviewFeedback updated = service.updateFeedback(id, feedback);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(@PathVariable Long applicationId) {
        return ResponseEntity.ok(service.getFeedbacksByApplicationId(applicationId));
    }
}
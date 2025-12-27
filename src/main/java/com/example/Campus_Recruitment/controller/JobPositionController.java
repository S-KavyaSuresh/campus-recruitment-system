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

import com.example.Campus_Recruitment.model.JobPosition;
import com.example.Campus_Recruitment.service.JobPositionService;


@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    @Autowired
    private JobPositionService service;

    
     @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(
            @RequestBody JobPosition jobPosition) {

        return new ResponseEntity<>(
                service.addJobPosition(jobPosition),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        return ResponseEntity.ok(service.getAllJobPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getJobPositionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(
            @PathVariable Long id,
            @RequestBody JobPosition jobPosition) {

        return ResponseEntity.ok(
                service.updateJobPosition(id, jobPosition)
        );
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<JobPosition>> searchJobPositions(
            @PathVariable String keyword) {

        return ResponseEntity.ok(
                service.searchJobPositions(keyword)
        );
    }
}

package com.example.Campus_Recruitment.service;

import java.util.List;

import com.example.Campus_Recruitment.model.JobPosition;

public interface JobPositionService {
    JobPosition addJobPosition(JobPosition jobPosition);
    List<JobPosition> getAllJobPositions();
    JobPosition getJobPositionById(Long id);
    JobPosition updateJobPosition(Long id, JobPosition jobPosition);
    List<JobPosition> searchJobPositions(String keyword);
}

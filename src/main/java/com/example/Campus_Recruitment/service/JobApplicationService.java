package com.example.Campus_Recruitment.service;

import java.util.List;

import com.example.Campus_Recruitment.model.JobApplication;

public interface JobApplicationService {
    JobApplication addJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
    JobApplication getJobApplicationById(Long id);
    JobApplication updateJobApplication(Long id, JobApplication jobApplication);
}
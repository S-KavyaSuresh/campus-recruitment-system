package com.example.Campus_Recruitment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Campus_Recruitment.model.Department;
import com.example.Campus_Recruitment.model.JobPosition;
import com.example.Campus_Recruitment.repository.DepartmentRepository;
import com.example.Campus_Recruitment.repository.JobPositionRepository;


@Service
public class JobPositionServiceImpl implements JobPositionService {

    

    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) {
        if (jobPosition.getDepartment() != null &&
            jobPosition.getDepartment().getDepartmentId() != null) {

            Department dept = departmentRepository
                    .findById(jobPosition.getDepartment().getDepartmentId())
                    .orElse(null);
            jobPosition.setDepartment(dept);
        }
        return jobPositionRepository.save(jobPosition);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }

    @Override
    public JobPosition getJobPositionById(Long id) {
        return jobPositionRepository.findById(id).orElse(null);
    }

    @Override
    public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
        JobPosition existing = jobPositionRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setPositionTitle(jobPosition.getPositionTitle());
        existing.setDescription(jobPosition.getDescription());
        existing.setLocation(jobPosition.getLocation());
        existing.setExperienceRequired(jobPosition.getExperienceRequired());
        existing.setOpenings(jobPosition.getOpenings());
        return jobPositionRepository.save(existing);
    }

    @Override
public List<JobPosition> searchJobPositions(String keyword) {
    List<JobPosition> allJobs = jobPositionRepository.findAll();
    
    List<JobPosition> result = new ArrayList<>();
    String key = keyword.toLowerCase();

    for (JobPosition jp : allJobs) {
        if ((jp.getPositionTitle() != null && jp.getPositionTitle().toLowerCase().contains(key)) ||
            (jp.getDescription() != null && jp.getDescription().toLowerCase().contains(key))) {
            
            result.add(jp);
        }
    }
    return result;
}
}

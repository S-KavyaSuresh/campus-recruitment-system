package com.example.Campus_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Campus_Recruitment.model.JobPosition;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long>{
    
}
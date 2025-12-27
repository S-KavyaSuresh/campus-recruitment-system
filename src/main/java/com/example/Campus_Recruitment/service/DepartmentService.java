package com.example.Campus_Recruitment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.Campus_Recruitment.model.Department;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
    Page<Department> getDepartmentsWithPagination(int page, int size);
}
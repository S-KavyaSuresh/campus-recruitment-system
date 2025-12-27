package com.example.Campus_Recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Campus_Recruitment.model.Department;
import com.example.Campus_Recruitment.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existing = departmentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setDepartmentName(department.getDepartmentName());
            existing.setContactEmail(department.getContactEmail());
            existing.setContactPhone(department.getContactPhone());
            return departmentRepository.save(existing);
        }

        return null;
    }

    @Override
    public Page<Department> getDepartmentsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return departmentRepository.findAll(pageable);
    }
}


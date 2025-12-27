package com.example.Campus_Recruitment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Campus_Recruitment.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Department> departments = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public Department addDepartment(Department department) {
        if (department.getDepartmentId() == null) {
            department.setDepartmentId(counter.getAndIncrement());
        }
        departments.add(department);
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return new ArrayList<>(departments);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departments.stream()
                .filter(d -> d.getDepartmentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(id)) {
                d.setDepartmentName(department.getDepartmentName());
                d.setContactEmail(department.getContactEmail());
                d.setContactPhone(department.getContactPhone());
                return d;
            }
        }
        return null;
    }

    @Override
    public Page<Department> getDepartmentsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), departments.size());

        if (start > departments.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, departments.size());
        }

        return new PageImpl<>(departments.subList(start, end), pageable, departments.size());
    }
}
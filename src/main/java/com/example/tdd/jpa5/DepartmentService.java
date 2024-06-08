package com.example.tdd.jpa5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void insertDepartment(Department department) {
        departmentRepository.insertDepartment(department);
    }

    public Department getDepartment(Department department) {
        return departmentRepository.getDepartment(department);
    }
}

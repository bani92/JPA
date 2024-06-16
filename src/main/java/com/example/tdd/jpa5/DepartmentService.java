package com.example.tdd.jpa5;

import com.example.tdd.jpa5.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deptService")
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void insertDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartment(Department department) {
        return departmentRepository.findById(department.getDeptId()).get();
    }
}

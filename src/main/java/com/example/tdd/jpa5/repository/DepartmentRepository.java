package com.example.tdd.jpa5.repository;

import com.example.tdd.jpa5.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}

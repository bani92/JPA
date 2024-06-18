package com.example.tdd.jpa5.repository;

import com.example.tdd.jpa5.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Page<Employee> findByNameContaining(String name, Pageable pageing);

    List<Employee> findByNameContainingOrMailIdContaining(String name, String mailId);

    List<Employee> findByMailIdContainingOrderByNameDesc(String mailId);

    @Query("SELECT emp.id, emp.name, emp.salary "
            + "FROM Employee emp "
            + "WHERE emp.name like %:name% "
            + " ORDER BY emp.id DESC")
    List<Object[]> findByJPQL(@Param("name") String name);
}

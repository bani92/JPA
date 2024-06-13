package com.example.tdd.jpa5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("empService")
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee getEmployee(Employee employee) {
        return employeeRepository.findById(employee.getId()).get();
    }

    public List<Employee> getEmployeeList(Employee employee) {
        return (List<Employee>)employeeRepository.findAll();
    }
}

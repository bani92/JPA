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
        employeeRepository.insertEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
    }

    public Employee getEmployee(Employee employee) {
        return employeeRepository.getEmployee(employee);
    }

    public List<Employee> getEmployeeList(Employee employee) {
        return employeeRepository.getEmployeeList(employee);
    }
}

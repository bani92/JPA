package com.example.tdd.jpa5;

import com.example.tdd.jpa5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Employee> getEmployeeList(Employee employee, int pageNumber) {
        Pageable paging = PageRequest.of(pageNumber - 1, 3);
        return (List<Employee>)employeeRepository.findByNameContaining(employee.getMailId(),paging);
    }
}

package com.example.tdd.jpa5;

import com.example.tdd.jpa5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Object[]> getEmployeeList(Employee employee) {
        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "id");

        return employeeRepository.findByJPQL(employee.getName(), paging);
        // return employeeRepository.findByNativeQuery(employee.getName());
    }
    public Page<Employee> getEmployeeList(Employee employee, int pageNumber) {
        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "id");
//        Pageable paging = PageRequest.of(pageNumber - 1, 3, Sort.by(new Sort.Order(Sort.Direction.DESC,"mailId"),
//                new Sort.Order(Sort.Direction.ASC, "salary")));
        return employeeRepository.findByNameContaining(employee.getName(),paging);
    }
}

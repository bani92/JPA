package com.example.tdd.jpa5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

public class QueryMethodClient {

    public static void main(String[] args) {

        // GenericXmlApplicationContext container = new GenericXmlApplicationContext("spring/business-layer.xml");
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);

     //   DepartmentService deptService = (DepartmentService) container.getBean("deptService");
        EmployeeService employeeService = (EmployeeService) container.getBean("empService");

     //   dataInsert(deptService, employeeService);
        dataSelect(employeeService);

        container.close();

    }

    private static void dataSelect(EmployeeService employeeService) {
        Employee employee = new Employee();
         employee.setName("");
        employee.setMailId("Dev");

        List<Employee> resultList = employeeService.getEmployeeList(employee,1);
        System.out.println("직원 목록");
        for (Employee result : resultList) {
            System.out.println("---> " + result.toString());

        }

    }

//    private static void dataSelect(DepartmentService departmentService) {
//        /**
//         * 직원 목록 조회
//         */
////        List<Employee> employeeList = employeeService.getEmployeeList(new Employee());
////
////        System.out.println("직원 목록");
////        for (Employee employee : employeeList) {
////            System.out.println("---> " + employee.getName() + "의 부서명 : " + employee.getDept().getName());
////        }
//        Department department = new Department();
//        department.setDeptId(1L);
//        Department findDept = departmentService.getDepartment(department);
//
//        System.out.println("부서명 : " + findDept.getName());
//        System.out.println("직원 목록");
//        for (Employee employee : findDept.getEmployeeList()) {
//            System.out.println("---> " + employee.toString());
//        }
//    }

}

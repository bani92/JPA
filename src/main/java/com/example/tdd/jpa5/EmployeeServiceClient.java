//package com.example.tdd.jpa5;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.aspectj.SpringConfiguredConfiguration;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//import java.util.List;
//
//public class EmployeeServiceClient {
//
//    public static void main(String[] args) {
//
//        // GenericXmlApplicationContext container = new GenericXmlApplicationContext("spring/business-layer.xml");
//        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//
//        DepartmentService deptService = (DepartmentService) container.getBean("deptService");
//        EmployeeService employeeService = (EmployeeService) container.getBean("empService");
//
//     //   dataInsert(deptService, employeeService);
//        dataSelect(deptService);
//
//        container.close();
//
//    }
//
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
//
//    private static void dataInsert(DepartmentService departmentService, EmployeeService employeeService) {
//        Department department = new Department();
//        department.setName("개발부");
//        departmentService.insertDepartment(department);
//
//        Department department1 = new Department();
//        department1.setName("영업부");
//        departmentService.insertDepartment(department1);
//
//        for(int i = 1; i <= 5; i++) {
//            Employee employee = new Employee();
//            employee.setName("개발직원 " + i);
//            employee.setSalary(i * 12700.00);
//            employee.setMailId("Dev-" + i);
//            employee.setDept(department);
//            employeeService.insertEmployee(employee);
//        }
//
//        for(int i = 1; i <= 7; i++) {
//            Employee employee = new Employee();
//            employee.setName("영업직원 " + i);
//            employee.setSalary(i * 24300.00);
//            employee.setMailId("Sales-" + i);
//            employee.setDept(department1);
//            employeeService.insertEmployee(employee);
//        }
//    }
//}

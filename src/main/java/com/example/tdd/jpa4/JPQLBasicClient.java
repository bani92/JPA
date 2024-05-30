package com.example.tdd.jpa4;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JPQLBasicClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter06");
        try {
            dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emf.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Employee e WHERE e.id = 1L";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

        // 1번 직원 검색
        Employee findEmp1 = query.getSingleResult();

        // 1번 직원 검색
        Employee findEmp2 = query.getSingleResult();

        if(findEmp1 == findEmp2) {
            System.out.println("두 객체의 주소는 동일하다.");
        }
//        String jpql = "SELECT id, name, title, deptName, salary FROM Employee " +
//                      " WHERE id = :employeeId AND name = :employeeName";
//
//        Query query = em.createQuery(jpql);
//        query.setParameter("employeeId", 1L);
//        query.setParameter("employeeName", "직원 1");
//
//        Object[] result = (Object[]) query.getSingleResult();
//        System.out.println(result[0] + "번 직원의 정보");
//        System.out.println(Arrays.toString(result));


        // JPQL
//        String jpql = "SELECT id, name, deptName, salary FROM Employee";

        // NEW 생성자 사용시 패키지 경로가 포함된 전체 경로를 지정
//        String jpql = "SELECT " + "NEW com.example.tdd.jpa4.EmployeeSalaryData(id, salary, " +
//                "commissionPct) FROM Employee";
//
//        TypedQuery<EmployeeSalaryData> query = em.createQuery(jpql, EmployeeSalaryData.class);
//
//        List<EmployeeSalaryData> resultList = query.getResultList();


        // JPQL 전송 - 영속 컨테이너에 전송할 JPQL , JPQL 실행 결과를 매핑할 엔티티타입
//        Query query = em.createQuery(jpql);
//        List<Object[]> resultList = query.getResultList();
        // TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        //List<Employee> resultList = query.getResultList();

        // 검색 결과 처리
//        System.out.println("검색된 직원 목록");
//        for (EmployeeSalaryData result : resultList) {
//            System.out.println("---> " + result.toString());
//        }
        em.close();
    }

    private static void dataInsert(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 10명의 직원 정보 등록
        for(int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setName("직원 " + i);
            employee.setMailId("anti-corona" + i);
            employee.setDeptName("개발부");
            employee.setSalary(12700.00 * i);
            employee.setStartDate(new Date());
            employee.setTitle("사원");
            employee.setCommissionPct(15.00);
            em.persist(employee);
        }

        em.getTransaction().commit();
        em.close();
    }
}

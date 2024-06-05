package com.example.tdd.jpa4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CriteriaSearchClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter07");
        try {
       //     dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emf.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        // 검색 정보 설정
        String searchCondition = "TITLE";
        String searchKeyword = "과장";

        // 크라이테리어 빌더 생성
        CriteriaBuilder builder = em.getCriteriaBuilder();

        // 크라이테리어 쿼리 생성
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        // CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);

        // FROM Employee emp
        Root<Employee> emp = criteriaQuery.from(Employee.class);

        // SELECT emp.id, emp.name, emp.salary
        criteriaQuery.multiselect(emp.get("id"), emp.get("name"), emp.get("salary"));

        // SELECT emp
//        criteriaQuery.select(emp);
//
//        if(searchCondition.equals("NAME")) {
//            criteriaQuery.where(builder.equal(emp.get("name"), searchKeyword));
//        } else if(searchCondition.equals("MAILID")) {
//            criteriaQuery.where(builder.equal(emp.get("mailId"), searchKeyword));
//        }

        TypedQuery<Object[]> query = em.createQuery(criteriaQuery);
        List<Object[]> resultList = query.getResultList();
        for (Object[] result : resultList) {
            System.out.println("---> " + Arrays.toString(result));
        }


//        // 검색 관련 쿼리
//        String jpqlByMailId = "SELECT e FROM Employee e WHERE e.mailId=:searchKeyword";
//        String jpqlByName = "SELECT e FROM Employee e WHERE e.name=:searchKeyword";
//
//        TypedQuery<Employee> query = null;
//
//        // 검색 조건에 따른 분기 처리
//        if(searchCondition.equals("NAME")) {
//            query = em.createQuery(jpqlByName, Employee.class);
//        } else if(searchCondition.equals("MAILID")) {
//            query = em.createQuery(jpqlByMailId, Employee.class);
//        }





        em.close();
    }

    private static void dataInsert(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 직원 정보 등록
        for(int i= 1; i <= 3; i++) {
            Employee employee = new Employee();
            employee.setName("개발맨 " + i);
            employee.setMailId("Corona" + i);
            employee.setDeptName("개발부");
            employee.setSalary(12700.00 * i);
            employee.setStartDate(new Date());
            employee.setTitle("사원");
            employee.setCommissionPct(10.00);
            em.persist(employee);
        }

        // 부서 정보가 없는 직원 등록
        Employee employee = new Employee();
        employee.setName("아르바이트");
        employee.setMailId("Alba-01");
        employee.setSalary(10000.00);
        em.persist(employee);

        em.getTransaction().commit();
        em.close();
    }
}

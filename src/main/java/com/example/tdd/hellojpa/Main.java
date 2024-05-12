package com.example.tdd.hellojpa;

import com.example.tdd.hellojpa.entity.Member;
import com.example.tdd.hellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            team.getMembers().add(member);  // 순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력
            member.setTeam(team);       // member team 추가됨
            em.persist(member);

//            team.getMembers().add(member);
//            위와 같이 적어도 member에 team 추가되지않고 null
            tx.commit();
            /**
             * 영속성 컨텍스트를 비우지 않음
             * 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
             * 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면됨
             */
            em.clear();

            /**
             * 준영속 상태로 만드는 방법
             * em.detach(entity)
             * 특정 엔티티만 준영속 상태로 전환
             *
             * em.clear()
             * 영속성 컨텍스트를 완전히 초기화
             *
             * em.close()
             * 영속성 컨텍스트를 종료
             */

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            em.clear();
            findTeam.getName();
            System.out.println("findTeam = " + findTeam);
//
//            List<Member> members = findTeam.getMembers();
//
//            for (Member member1 : members) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Team findTeam2 = em.find(Team.class, team.getId());
//            int size = findTeam2.getMembers().size();
//            System.out.println("size = " + size);


            em.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

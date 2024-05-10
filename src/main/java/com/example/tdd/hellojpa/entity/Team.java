package com.example.tdd.hellojpa.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 연관관계의 주인을 정해야한다. - 외래키가 있는 테이블이 주인
    // 연관관계의 주인만이 외래 키를 관리(등록, 수정)
    // 주인이 아닌쪽은 조회만 가능
    // 주인은 mappedBy 속성 사용X
    // 주인이 아니면 mappedBy 속성으로 주인 지정
    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<>();
}

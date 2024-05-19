package com.example.tdd.jpa2;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "S_EMP_CARD")
public class EmployeeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long cardId;    // 사원증 아이디

    @Column(name = "EXPIRE_DATE")
    private Date expireDate;    // 사원증 만료 기간

    private String role;    // 권한

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_CARD_ID")
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
        employee.setCard(this);
    }
}

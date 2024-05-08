package com.example.tdd.hellojpa.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Data
@Table(name = "team")
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

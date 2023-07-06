package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "members")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String numberDocument;

    @Column(unique = true, nullable = false, length = 20)
    private String codeEmployee;

    @Column(nullable = false)
    private Long idMultiplex;

    @Column(nullable = false)
    private int salary;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate dateContract;

    @Column(nullable = false)
    private String password;

}

package com.example.OWProjekat.model.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private String jmbg;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private LocalDateTime dateOfRegistration;

    @Column
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column
    private String vaccination;

}

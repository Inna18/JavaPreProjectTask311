package com.inna.spring_boot.practicaltask311.model;

import com.inna.spring_boot.practicaltask311.validation.UniqueEmail;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "User name cannot be empty")
    private String name;

    @Column
    @NotEmpty(message = "User surname cannot be empty")
    private String surname;

    @Column
    @Min(value = 0, message = "User age should be greater than 0")
    private int age;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    @UniqueEmail
    private String email;

}

package com.example.exercise18.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not empty")
    @Size(min = 5 , message = "name should be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;

    @NotEmpty(message = "username should be not empty")
    @Size(min = 5 , message = "name should be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "email should be not empty")
    @Email(message = "email should be formatted correctly")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull(message = "age should be not empty")
    @Positive(message = "age should be a number")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "role should be not empty")
    @Pattern(regexp = "^(admin|user)$")
    @Column(columnDefinition = "varchar(20) not null")
    @Check(constraints = "role=admin or role=user")
    private String role;
}

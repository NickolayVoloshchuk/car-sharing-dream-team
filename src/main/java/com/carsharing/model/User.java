package com.carsharing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    private String password;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "ENUM('MANAGER', 'COSTUMER')", nullable = false)
    private Role role;

    public enum Role {
        MANAGER, CUSTOMER
    }
}

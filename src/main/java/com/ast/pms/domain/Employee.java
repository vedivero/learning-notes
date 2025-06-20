package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String headquarter;

    @Column(nullable = false)
    private String team;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "resign_date")
    private LocalDate resignDate;

    @Column(nullable = false)
    private String position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<License> licenses = new ArrayList<>();

    @Column(name = "phone_number")
    private String phoneNumber;

    private String extension;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String gender;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "password_changed_at")
    private LocalDateTime passwordChangedAt;

    @Column(name = "account_enabled", nullable = false)
    private boolean accountEnabled;

    // 시큐리티 인증 시 사용할 식별자
    public String getId() {
        return loginId;
    }

    public boolean isEnabled() {
        return accountEnabled;
    }
}

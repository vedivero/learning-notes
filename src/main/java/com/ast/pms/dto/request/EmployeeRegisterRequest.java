package com.ast.pms.dto.request;

import lombok.*;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRegisterRequest {

    private String password;
    private String email;
    private String name;
    private String headquarter;
    private String team;
    private String license_1;
    private String license_2;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String position;
    private String role;
}

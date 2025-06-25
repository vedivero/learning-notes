package com.ast.pms.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String position;
    private String role;

    private List<EmployeeLicenseRequest> licenses;
}

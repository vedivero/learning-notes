package com.ast.pms.dto.request.employee;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeLicenseRequest {
    private String name;
    private LocalDate acquiredAt;
    private String issuedBy;
}

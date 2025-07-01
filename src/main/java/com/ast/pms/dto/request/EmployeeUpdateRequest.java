package com.ast.pms.dto.request;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeUpdateRequest implements EmployeeRequestBase {

    private Integer employeeId;
    private String password;
    private String email;
    private String name;
    private String headquarter;
    private String team;
    private String phoneNumber;
    private String level;
    private String position;
    private String role;
    private String workType;
    private String remark;

    private List<EmployeeLicenseRequest> licenses;
}

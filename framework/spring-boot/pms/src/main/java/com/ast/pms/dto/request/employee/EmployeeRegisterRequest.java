package com.ast.pms.dto.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRegisterRequest implements EmployeeRequestBase {

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

package com.ast.pms.dto.request.employee;

import java.util.List;

public interface EmployeeRequestBase {
    String getPassword();

    String getEmail();

    String getName();

    String getHeadquarter();

    String getTeam();

    String getPhoneNumber();

    String getLevel();

    String getPosition();

    String getRole();

    String getWorkType();

    String getRemark();

    List<EmployeeLicenseRequest> getLicenses();
}

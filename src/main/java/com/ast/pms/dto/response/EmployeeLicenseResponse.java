package com.ast.pms.dto.response;

import com.ast.pms.domain.EmployeeLicense;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class EmployeeLicenseResponse {
    private String name;

    public static EmployeeLicenseResponse from(EmployeeLicense license) {
        return EmployeeLicenseResponse.builder()
                .name(license.getName())
                .build();
    }
}

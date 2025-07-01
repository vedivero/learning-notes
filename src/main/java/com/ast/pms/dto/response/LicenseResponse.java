package com.ast.pms.dto.response;

import com.ast.pms.domain.EmployeeLicense;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class LicenseResponse {
    private String name;

    public static LicenseResponse from(EmployeeLicense license) {
        return LicenseResponse.builder()
                .name(license.getName())
                .build();
    }
}

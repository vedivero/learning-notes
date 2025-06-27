package com.ast.pms.dto.response;

import com.ast.pms.domain.License;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class LicenseResponse {
    private String name;

    public static LicenseResponse from(License license) {
        return LicenseResponse.builder()
                .name(license.getName())
                .build();
    }
}

package com.ast.pms.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class LicenseNameResponse {

    private Integer licenseId;
    private String licenseName;

}
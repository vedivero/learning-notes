package com.ast.pms.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRegisterRequest {
    private String loginId;
    private String password;
    private String userName;
    private String role;
    private LocalDate createdAt;
    private LocalDateTime passwordChangedAt;

}

package com.ast.pms.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class EmployeeListResponse {

    private Integer employeeId; // 사원 ID (PK)
    private String name; // 이름
    private String email; // 이메일
    private String phoneNumber; // 전화번호
    private String extension; // 내선번호
    private String headquarter; // 본부
    private String team; // 팀
    private String position; // 직급
    private String role; // 역할
    private String level; // 직급
    private String workType; // 근무 형태
    private String status; // 상태 (재직 / 퇴사 등)
    private String remark; // 비고

    private LocalDate hireDate; // 입사일
    private LocalDate resignDate; // 퇴사일

    private LocalDateTime createdAt; // 생성일시
    private LocalDateTime updatedAt; // 수정일시

    private List<String> licenseNames; // 자격증
}

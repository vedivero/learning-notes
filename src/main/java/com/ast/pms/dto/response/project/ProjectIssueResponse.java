package com.ast.pms.dto.response.project;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectIssueResponse {

    private Long id; // 식별자 (primary key)
    private String issueNote; // 이슈 내용
    private String writerId; // 작성자 ID
    private LocalDateTime createdAt; // 작성일시
    private LocalDateTime updatedAt; // 수정일시

    public static ProjectIssueResponse from(com.ast.pms.domain.ProjectIssue issue) {
        return ProjectIssueResponse.builder()
                .issueNote(issue.getIssueNote())
                .writerId(issue.getWriterId())
                .createdAt(issue.getCreatedAt())
                .updatedAt(issue.getUpdatedAt())
                .build();
    }
}

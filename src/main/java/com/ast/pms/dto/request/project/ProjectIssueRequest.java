package com.ast.pms.dto.request.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectIssueRequest {

    private String issueNote; // 이슈 내용
    private String writerId; // 작성자 ID
}

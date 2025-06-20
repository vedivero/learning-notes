package com.ast.pms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAttachmentRequest {

    private String fileName; // 파일명
    private String filePath; // 파일경로
    private Long fileSize; // 파일크기 (Byte 단위)
    private String fileType; // 파일유형 (예: PDF, DOCX, PNG 등)
}

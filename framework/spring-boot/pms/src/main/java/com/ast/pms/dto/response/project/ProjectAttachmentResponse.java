package com.ast.pms.dto.response.project;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAttachmentResponse {

    private Long id; // 첨부파일 ID
    private String fileName; // 파일명
    private String filePath; // 파일경로
    private Long fileSize; // 파일크기 (Byte 단위)
    private String fileType; // 파일유형
    private LocalDateTime uploadedAt; // 업로드 시간

    public static ProjectAttachmentResponse from(com.ast.pms.domain.ProjectAttachment attachment) {
        return ProjectAttachmentResponse.builder()
                .fileName(attachment.getFileName())
                .filePath(attachment.getFilePath())
                .fileSize(attachment.getFileSize())
                .fileType(attachment.getFileType())
                .uploadedAt(attachment.getUploadedAt())
                .build();
    }
}

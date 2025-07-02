package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "project_attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Integer attachmentId; // 첨부파일ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "file_name")
    private String fileName; // 파일명

    @Column(name = "file_path")
    private String filePath; // 파일경로

    @Column(name = "file_size")
    private Long fileSize; // 파일크기

    @Column(name = "file_type")
    private String fileType; // 파일유형

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt; // 업로드일시
}

package com.ast.pms.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectAttachment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final String uploadDir = System.getProperty("user.dir") + "/data/uploads/";

    public List<ProjectAttachment> storeProejctFiles(Project project, MultipartFile[] files) {
        List<ProjectAttachment> attachments = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String originalName = file.getOriginalFilename();
                    if (originalName == null || originalName.isBlank()) {
                        originalName = "unknown";
                    }
                    String safeName = originalName.replaceAll("[\\\\/:*?\"<>|]", "_").replaceAll("\\s+", "_");
                    String uuid = UUID.randomUUID().toString();
                    String storedName = uuid + "-" + safeName;

                    String filePath = uploadDir + storedName;

                    File destFile = new File(filePath);
                    File parentDir = destFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    file.transferTo(destFile);

                    ProjectAttachment attachment = ProjectAttachment.builder()
                            .project(project)
                            .fileName(storedName)
                            .filePath(filePath)
                            .fileSize(file.getSize())
                            .fileType(file.getContentType())
                            .uploadedAt(LocalDateTime.now())
                            .build();

                    attachments.add(attachment);

                } catch (Exception e) {
                    throw new RuntimeException("파일 업로드 실패 : " + e.getMessage(), e);
                }
            }
        }

        return attachments;
    }
}

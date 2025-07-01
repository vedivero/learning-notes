package com.ast.pms.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.service.LicenseService;

import lombok.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/license")
public class LicenseApiController {

    private final LicenseService licenseService;

    @GetMapping("/search")
    public ResponseEntity getLicenseName(
            @RequestParam("keyword") String keyword) {
        try {
            List<String> response = licenseService.searchLicenseNames(keyword);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("자격증 검색 중 오류가 발생했습니다." + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createLicense(@RequestParam("keyword") String keyword) {

        try {
            licenseService.createLicense(keyword);
            return ResponseEntity.ok().body("자격증이 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("자격증 등록 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

}

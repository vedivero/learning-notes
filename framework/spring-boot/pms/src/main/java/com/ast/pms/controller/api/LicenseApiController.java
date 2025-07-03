package com.ast.pms.controller.api;

import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.service.LicenseService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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

    @DeleteMapping("/{license_id}")
    public ResponseEntity deleteLicense(@PathVariable("license_id") int license_id) {
        licenseService.deleteLicense(license_id);
        return ResponseEntity.ok().body("자격증이 삭제되었습니다.");
    }
}

package com.ast.pms.service;

import com.ast.pms.domain.License;
import com.ast.pms.repository.LicenseRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public List<String> searchLicenseNames(String keyword) {
        List<License> licenses = licenseRepository.findByLicenseNameContaining(keyword);
        return licenses.stream().map(License::getLicenseName).collect(Collectors.toList());
    }

    public void createLicense(String keyword) {

        boolean exists = licenseRepository.existsByLicenseName(keyword);
        if (exists) {
            throw new IllegalArgumentException("이미 존재하는 자격증입니다.");
        }
        License license = new License();
        license.setLicenseName(keyword);

        licenseRepository.save(license);
    }

    public void deleteLicense(int id) {
        if (!licenseRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 자격증이 존재하지 않습니다.");
        }
        licenseRepository.deleteById(id);
    }
}

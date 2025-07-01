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
}

package com.ast.pms.repository;

import com.ast.pms.domain.License;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Integer> {
    List<License> findByLicenseNameContaining(String keyword);

    boolean existsByLicenseName(String licenseName);

}

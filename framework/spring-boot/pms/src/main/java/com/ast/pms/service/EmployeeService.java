package com.ast.pms.service;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.EmployeeLicense;
import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.dto.request.EmployeeUpdateRequest;
import com.ast.pms.dto.response.EmployeeDetailResponse;
import com.ast.pms.dto.response.EmployeeListResponse;
import com.ast.pms.dto.response.LicenseNameResponse;
import com.ast.pms.mapper.EmployeeListResponseMapper;
import com.ast.pms.mapper.EmployeeRequestMapper;
import com.ast.pms.repository.EmployeeLicenseRepository;
import com.ast.pms.repository.EmployeeRepository;
import com.ast.pms.repository.EmployeeSpecification;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

        private final EmployeeRepository employeeRepository;
        private final EmployeeLicenseRepository employeeLicenseRepository;

        public void registerEmployee(EmployeeRegisterRequest request) {
                Employee employee = EmployeeRequestMapper.toNewEmployee(request);

                List<EmployeeLicense> licenses = EmployeeRequestMapper.toLicenseList(request, employee);
                employee.setLicenses(licenses);
                employeeRepository.save(employee);
        }

        public EmployeeDetailResponse getEmployeeDetailById(int employeeId) {

                Employee employee = employeeRepository.findById(employeeId)
                                .orElseThrow(() -> new IllegalArgumentException("해당 직원이 존재하지 않습니다." + employeeId));

                return EmployeeDetailResponse.from(employee);
        }

        public List<EmployeeListResponse> getAllEmployees() {
                return employeeRepository.findAll().stream()
                                .map(EmployeeListResponseMapper::from)
                                .collect(Collectors.toList());
        }

        public Page<EmployeeListResponse> searchEmployees(String keyword, Pageable pageable) {
                return employeeRepository.findAll(EmployeeSpecification.containsKeywordInFields(keyword), pageable)
                                .map(EmployeeListResponseMapper::from);
        }

        public void updateProject(EmployeeUpdateRequest request) {

                Employee employee = employeeRepository.findById(request.getEmployeeId())
                                .orElseThrow(() -> new IllegalArgumentException("해당 직원이 존재하지 않습니다."));

                EmployeeRequestMapper.updateEmployeeFields(employee, request);
                employee.getLicenses().size();
                employee.getLicenses().clear();
                List<EmployeeLicense> licenses = EmployeeRequestMapper.toLicenseList(request, employee);
                employee.getLicenses().addAll(licenses);

                employeeLicenseRepository.deleteByEmployee(employee);
        }

}
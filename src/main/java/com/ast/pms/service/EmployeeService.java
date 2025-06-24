package com.ast.pms.service;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.License;
import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void register(EmployeeRegisterRequest request) {
        Employee employee = Employee.builder()
                .email(request.getEmail())
                .name(request.getName())
                .headquarter(request.getHeadquarter())
                .team(request.getTeam())
                .hireDate(LocalDate.now())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .role(request.getRole())
                .status("ACTIVE")
                .createdAt(LocalDateTime.now())
                .build();

        if (request.getLicenses() != null && !request.getLicenses().isEmpty()) {
            List<License> licenses = request.getLicenses().stream()
                    .map(dto -> License.builder()
                            .name(dto.getName())
                            .employee(employee)
                            .createdAt(LocalDateTime.now())
                            .build())
                    .toList();
            employee.setLicenses(licenses);
        }
        employeeRepository.save(employee);
    }
}

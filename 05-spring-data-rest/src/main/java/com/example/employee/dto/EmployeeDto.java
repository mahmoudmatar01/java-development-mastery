package com.example.employee.dto;

import lombok.Builder;

@Builder
public record EmployeeDto(
        Long id,
        String firstName,
        String lastName
) {
}

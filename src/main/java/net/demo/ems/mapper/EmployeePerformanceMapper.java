package net.demo.ems.mapper;

import java.time.LocalDate;

import net.demo.ems.entity.EmployeePerformance;
import net.demo.ems.response.EmployeePerformanceResponse;

public class EmployeePerformanceMapper {

    public static EmployeePerformanceResponse mapToResponse(EmployeePerformance employeePerformance) {
        EmployeePerformanceResponse response = new EmployeePerformanceResponse();
        response.setId(employeePerformance.getId());
        response.setEmployeeId(employeePerformance.getEmployeeId());
        response.setPerformanceRating(employeePerformance.getPerformanceRating());
        response.setPerformanceDate(employeePerformance.getPerformanceDate());
        return response;
    }

    public static EmployeePerformance mapToEntity(Long employeeId,
           Double performanceRating) {
        EmployeePerformance entity = new EmployeePerformance();
        entity.setEmployeeId(employeeId);
        entity.setPerformanceRating(performanceRating);
        entity.setPerformanceDate(LocalDate.now()); // Assuming the current date for simplicity
        return entity;
    }
}

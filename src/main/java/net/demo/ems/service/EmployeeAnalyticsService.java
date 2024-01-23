package net.demo.ems.service;

import net.demo.ems.dto.EmployeePerformancePredictionDto;

public interface EmployeeAnalyticsService {
    public EmployeePerformancePredictionDto predictEmployeePerformance(Long employeeId);

 
}
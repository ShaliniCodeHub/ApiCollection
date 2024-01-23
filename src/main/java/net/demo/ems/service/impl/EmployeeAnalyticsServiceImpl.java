package net.demo.ems.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.demo.ems.dto.EmployeePerformancePredictionDto;
import net.demo.ems.entity.EmployeePerformance;
import net.demo.ems.service.EmployeeAnalyticsService;
import net.demo.ems.service.EmployeePerformanceService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAnalyticsServiceImpl implements EmployeeAnalyticsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAnalyticsServiceImpl.class);

    private final EmployeePerformanceService employeePerformanceService;

    @Autowired
    public EmployeeAnalyticsServiceImpl(EmployeePerformanceService employeePerformanceService) {
        this.employeePerformanceService = employeePerformanceService;
    }

    @Override
    public EmployeePerformancePredictionDto predictEmployeePerformance(Long employeeId) {
        LOGGER.info("Predicting employee performance for employeeId: {}", employeeId);

        try {
            // Call the EmployeePerformanceMicroservice to get the employee's performance history
            List<EmployeePerformance> performanceResponses = employeePerformanceService.getPerformanceHistory(employeeId);

            // Perform your analytics logic here using the performance history
            // For illustration purposes, let's calculate the average performance
            // Extract performance ratings from responses
            List<Double> performanceHistory = extractPerformanceRatings(performanceResponses);

            // Performing logic here using the performance history
            double averagePerformance = calculateAveragePerformance(performanceHistory);

            // Map the result to a DTO
            EmployeePerformancePredictionDto predictionDto = new EmployeePerformancePredictionDto(
            		employeeId, averagePerformance, suggestImprovements(averagePerformance)
            );

            LOGGER.info("Prediction successful for employeeId: {}", employeeId);
            return predictionDto;
        } catch (Exception e) {
            LOGGER.error("Error predicting employee performance for employeeId: {}", employeeId, e);
            throw e;
        }
    }

    private List<Double> extractPerformanceRatings(List<EmployeePerformance> performanceResponses) {
        return performanceResponses.stream()
                .map(EmployeePerformance::getPerformanceRating)
                .collect(Collectors.toList());
    }

    private double calculateAveragePerformance(List<Double> performanceHistory) {
        if (performanceHistory.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Double performance : performanceHistory) {
            sum += performance;
        }
        return sum / performanceHistory.size();
    }

    private List<String> suggestImprovements(double averagePerformance) {
        List<String> suggestedImprovements = new ArrayList<>();

        // Example logic: If average performance is below 4.0, suggest additional training
        if (averagePerformance < 4.0) {
            suggestedImprovements.add("Advanced Spring Boot Concepts");
            suggestedImprovements.add("Leadership Training");
        } else {
            suggestedImprovements.add("kafka");
            suggestedImprovements.add("cloud");
            suggestedImprovements.add("Service deployment on cloud");
        }

        return suggestedImprovements;
    }
    
 
    
//    public int calculateYearsOfService(LocalDate joiningDate) {
//        LocalDate currentDate = LocalDate.now();
//        Period period = Period.between(joiningDate, currentDate);
//        return period.getYears();
//    }
}

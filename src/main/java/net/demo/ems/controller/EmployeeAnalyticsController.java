package net.demo.ems.controller;

import net.demo.ems.dto.EmployeePerformancePredictionDto;
import net.demo.ems.service.EmployeeAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee-analytics")
public class EmployeeAnalyticsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAnalyticsController.class);

    private final EmployeeAnalyticsService employeeAnalyticsService;

    @Autowired
    public EmployeeAnalyticsController(EmployeeAnalyticsService employeeAnalyticsService) {
        this.employeeAnalyticsService = employeeAnalyticsService;
    }

    @PostMapping("/predict-performance")
    public ResponseEntity<EmployeePerformancePredictionDto> predictEmployeePerformance(
            @RequestParam Long employeeId) {
        LOGGER.info("Predicting employee performance for employeeId: {}", employeeId);

        try {
            EmployeePerformancePredictionDto predictionDto = employeeAnalyticsService.predictEmployeePerformance(employeeId);

            LOGGER.info("Prediction successful for employeeId: {}", employeeId);
            return ResponseEntity.ok(predictionDto);
        } catch (Exception e) {
            LOGGER.error("Error predicting employee performance for employeeId: {}", employeeId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

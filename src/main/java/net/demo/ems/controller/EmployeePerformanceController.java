package net.demo.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import net.demo.ems.entity.EmployeePerformance;
import net.demo.ems.response.EmployeePerformanceResponse;
import net.demo.ems.service.EmployeePerformanceService;

import org.apache.logging.log4j.Logger;
import net.demo.ems.logger.AppLogger;

@RestController
@RequestMapping("/api/employee-performance")
public class EmployeePerformanceController {

    private final EmployeePerformanceService performanceService;
    private static final Logger LOGGER = AppLogger.getLogger(EmployeePerformanceController.class);

    @Autowired
    public EmployeePerformanceController(EmployeePerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @PostMapping("/track")
    public ResponseEntity<EmployeePerformanceResponse> trackPerformance(
            @RequestParam Long employeeId,
            @RequestParam Double performanceRating) {
        LOGGER.info("POST | @Controller - START - trackPerformance ...| employeeId: {} | performanceRating: {}",
                employeeId, performanceRating);
        EmployeePerformance trackedPerformance = performanceService.trackPerformance(employeeId, performanceRating);
        EmployeePerformanceResponse response = new EmployeePerformanceResponse(trackedPerformance);
        LOGGER.info("POST | @Controller - END   - trackPerformance ...| employeeId: {} | performanceRating: {}",
                employeeId, performanceRating);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/history/{employeeId}")
    public ResponseEntity<List<EmployeePerformanceResponse>> getPerformanceHistory(
            @PathVariable Long employeeId) {
        LOGGER.info("GET | @Controller - START - getPerformanceHistory ...| employeeId: {}", employeeId);
        List<EmployeePerformance> performanceHistory = performanceService.getPerformanceHistory(employeeId);
        List<EmployeePerformanceResponse> responseList = performanceHistory.stream()
                .map(EmployeePerformanceResponse::new)
                .collect(Collectors.toList());
        LOGGER.info("GET | @Controller - END - getPerformanceHistory ...| employeeId: {}", employeeId);
        return ResponseEntity.ok(responseList);
    }
}

package net.demo.ems.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.demo.ems.entity.EmployeePerformance;
import net.demo.ems.repository.EmployeePerformanceRepository;
import net.demo.ems.service.EmployeePerformanceService;

import org.apache.logging.log4j.Logger;
import net.demo.ems.logger.AppLogger;

import java.util.List;

@Service
public class EmployeePerformanceServiceImpl implements EmployeePerformanceService {

    private final EmployeePerformanceRepository performanceRepository;
    private static final Logger LOGGER = AppLogger.getLogger(EmployeePerformanceServiceImpl.class);

    @Autowired
    public EmployeePerformanceServiceImpl(EmployeePerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    @Override
    public EmployeePerformance trackPerformance(Long employeeId, Double performanceRating) {
        LOGGER.info("Service - START - trackPerformance ...| employeeId: {} | performanceRating: {}", employeeId, performanceRating);
        
        EmployeePerformance employeePerformance = new EmployeePerformance();
        employeePerformance.setEmployeeId(employeeId);
        employeePerformance.setPerformanceRating(performanceRating);
        employeePerformance.setPerformanceDate(LocalDate.now());

        EmployeePerformance savedPerformance = performanceRepository.save(employeePerformance);

        LOGGER.info("Service - END   - trackPerformance ...| employeeId: {} | performanceRating: {}", employeeId, performanceRating);

        return savedPerformance;
    }

    @Override
    public List<EmployeePerformance> getPerformanceHistory(Long employeeId) {
        LOGGER.info("Service - START - getPerformanceHistory ...| employeeId: {}", employeeId);
        List<EmployeePerformance> performanceHistory = performanceRepository.findByEmployeeId(employeeId);
        LOGGER.info("Service - END - getPerformanceHistory ...| employeeId: {}", employeeId);
        return performanceHistory;
    }
}

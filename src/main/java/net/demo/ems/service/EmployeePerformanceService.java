package net.demo.ems.service;
import java.util.*;
import net.demo.ems.entity.EmployeePerformance;

public interface EmployeePerformanceService {
	EmployeePerformance trackPerformance(Long employeeId, Double performanceRating);

    List<EmployeePerformance> getPerformanceHistory(Long employeeId);

}

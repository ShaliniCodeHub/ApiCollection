package net.demo.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import net.demo.ems.entity.EmployeePerformance;

public interface EmployeePerformanceRepository extends JpaRepository<EmployeePerformance, Long> {
    List<EmployeePerformance> findByEmployeeId(Long employeeId);
}
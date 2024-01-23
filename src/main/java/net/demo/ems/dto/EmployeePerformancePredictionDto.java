package net.demo.ems.dto;

import java.util.List;

public class EmployeePerformancePredictionDto {

    private Long employeeId;
    private Double predictedPerformance;
    private List<String> suggestedImprovements;

    // Constructors, getters, and setters

    public EmployeePerformancePredictionDto() {
    }

    public EmployeePerformancePredictionDto(Long employeeId, Double predictedPerformance, List<String> suggestedImprovements) {
        this.employeeId = employeeId;
        this.predictedPerformance = predictedPerformance;
        this.suggestedImprovements = suggestedImprovements;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Double getPredictedPerformance() {
        return predictedPerformance;
    }

    public void setPredictedPerformance(Double predictedPerformance) {
        this.predictedPerformance = predictedPerformance;
    }

    public List<String> getSuggestedImprovements() {
        return suggestedImprovements;
    }

    public void setSuggestedImprovements(List<String> suggestedImprovements) {
        this.suggestedImprovements = suggestedImprovements;
    }
}

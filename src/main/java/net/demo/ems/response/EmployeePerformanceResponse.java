package net.demo.ems.response;

import java.time.LocalDate;

import net.demo.ems.entity.EmployeePerformance;

public class EmployeePerformanceResponse {
	private Long id;
    private Long employeeId;
    private Double performanceRating;
    private LocalDate performanceDate;

   

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}



	public Double getPerformanceRating() {
		return performanceRating;
	}



	public void setPerformanceRating(Double performanceRating) {
		this.performanceRating = performanceRating;
	}



	public LocalDate getPerformanceDate() {
		return performanceDate;
	}



	public void setPerformanceDate(LocalDate performanceDate) {
		this.performanceDate = performanceDate;
	}



	public EmployeePerformanceResponse(EmployeePerformance employeePerformance) {
        this.id = employeePerformance.getId();
        this.employeeId = employeePerformance.getEmployeeId();
        this.performanceRating = employeePerformance.getPerformanceRating();
        this.performanceDate = employeePerformance.getPerformanceDate();
    }



	public EmployeePerformanceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
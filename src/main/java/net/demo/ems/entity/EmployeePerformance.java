package net.demo.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "employee_performance")
	public class EmployeePerformance {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "employee_id")
	    private Long employeeId;

	    @Column(name = "performance_rating")
	    private Double performanceRating;

	    @Column(name = "performance_date")
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

		@Override
		public String toString() {
			return "EmployeePerformance [id=" + id + ", employeeId=" + employeeId + ", performanceRating="
					+ performanceRating + ", performanceDate=" + performanceDate + "]";
		}

	   
	}




# Employee Analytics Service

## Overview

Welcome to the Employee Analytics Service, a component of the Employee Tracking System. This microservice is designed to handle performance-related functionalities and analytics for employees.

## Employee Analytics Service API

### 1. Get Employee Performance Prediction

- **Endpoint:**
  - `POST /api/analytics/employees/predict-performance`
- **Request Body:**
  ```json
  {
    "employeeId": 123,
    "previousPerformance": 4.5,
    "yearsOfService": 3,
    "skills": ["Java", "Spring Boot", "Microservices"]
  }
  - **Response Body:**
    ```json
  {
  "employeeId": 123,
  "predictedPerformance": 4.8,
  "suggestedImprovements": ["Advanced Spring Boot Concepts", "Leadership Training"]
}
### 1. Get Employee Insights

  - **Endpoint:**
  - `GET /api/analytics/employees/{employeeId}/insights`
- **Response Body:**
  ```json
  {
  "employeeId": 123,
  "topSkills": ["Java", "Spring Boot"],
  "projectsContributed": 10,
  "feedbackScore": 4.5,
  "averageTaskCompletionTime": "2 days"
}
### 1. Get Top Performers

  - **Endpoint:**
  - GET /api/analytics/employees/top-performers
  - QueryParam  Number of top performers to retrieve.
- **Response Body:**
  ```json
  [
  {
    "employeeId": 123,
    "predictedPerformance": 4.8,
    "firstName": "John",
    "lastName": "Doe"
  },
]





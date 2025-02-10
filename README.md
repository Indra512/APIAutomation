# API Automation Framework

## Introduction to API Testing

API testing is a crucial aspect of software testing that focuses on verifying the functionality, reliability, performance, and security of APIs (Application Programming Interfaces). Unlike UI testing, which validates user interactions, API testing ensures seamless communication between software components, making it essential for modern applications.

## Key Objectives of API Testing

- Validate API responses for accuracy and correctness
- Ensure APIs handle various HTTP methods (GET, POST, PUT, DELETE, etc.) correctly
- Test API performance and response times
- Verify authentication and authorization mechanisms
- Validate data integrity and structure in requests and responses
- Identify security vulnerabilities such as unauthorized access

## Benefits of API Testing

- Faster execution compared to UI testing
- Independent of the UI, allowing earlier defect detection
- Ensures data consistency and proper integration between services
- Enables parallel execution for efficient test coverage
- Helps validate business logic at the service level

## About This Framework

This project is a complete end-to-end (E2E) API automation framework built using **Java**, **RestAssured**, and **TestNG**. It is designed to facilitate automated API testing, improve test maintainability, and integrate seamlessly with CI/CD pipelines.

### Key Features

- **Service Object Model & Builder Pattern**: Enhances modularity and reusability of API request structures.
- **RestAssured Filters**: Captures logs for better debugging and reporting.
- **POJO (Plain Old Java Objects) for Requests and Responses**: Ensures structured and easy-to-maintain test data.
- **Logging Functionality**: Uses Log4j for structured logging and debugging.
- **CI/CD Integration with GitHub Actions**: Runs tests automatically and publishes **basic TestNG results**.

## Prerequisites

Before running the automation, ensure you have the following installed:

- Java 11 or later
- Maven
- Git
- Any REST client for manual API testing (e.g., Postman, cURL)

## How to Execute Tests

To run the tests, execute the following command from the terminal:

```sh
mvn clean test -Dsuite=suite
```

This will trigger API test execution based on the configured **TestNG suite**.

## Dependencies Used

The framework utilizes the following dependencies:

- **TestNG** - For test execution and reporting
- **RestAssured** - For API request handling
- **Jackson Databind** - For JSON serialization and deserialization
- **Log4j** - For logging and debugging
- **ExtentReports** - For generating test reports

## My Thoughts

This framework is designed to be scalable, maintainable, and CI/CD-friendly. The use of design patterns like the **Service Object Model** and **Builder Pattern** ensures clean and modular test scripts. With **logging, reporting, and CI/CD integration**, it provides a robust automation solution for API testing.

I hope this README helps you get started with the framework. Happy testing!

---

**Author:** [Indra]\
Feel free to contribute or raise issues in the repository!


# Project
CURA Healthcare Service Testing Project
##
This project is an automated testing framework designed to validate the functionality of a web application. It includes tests for login functionality, appointment booking, and cross-browser compatibility. Screenshots are captured for failed tests, and setup/teardown tasks are managed using hooks.


## Features

- **Login Functionality**: Automated tests verify the login process with valid credentials and handle scenarios with invalid credentials.

- **Appointment Booking**: Tests ensure that users can successfully book appointments, and error handling is in place for invalid data entry.

- **Cross-Browser Testing**: Chrome and Firefox browsers are used for cross-browser testing to ensure compatibility across different environments.

- **Screenshots on Failed Tests**: Screenshots are captured automatically for failed tests, aiding in debugging and identifying issues.

- **Separate Step Definitions**: Each test scenario is organized into separate step definitions, enhancing readability and maintainability.

- **Hooks**: Setup and teardown tasks are managed using hooks, providing a clean and organized structure for test execution.

- **Test Reports**: Html Cucumber reports are generated in Test Runner file 

## Challenges Faced

Implementing step definitions in separate files and managing WebDriver instances posed significant challenges during the development process. To address this, a singleton pattern was utilized to ensure a single instance of WebDriver is shared across step definitions. Extensive research was conducted to understand best practices for structuring step definitions and managing WebDriver instances effectively.

Integrating screenshot capture functionality for failed tests and managing driver invocation were additional challenges encountered. These required thorough exploration of Selenium WebDriver capabilities and handling exceptions effectively to capture screenshots on test failures.

## Features to Implement in the Future

- **Enhanced Reporting**: Implement a comprehensive reporting mechanism to provide detailed insights into test execution results, including metrics such as test pass/fail rates, execution time, and failure analysis.

- **Parallelised Tests**: Extend test scenarios to include parallelisation for improved test performance.

- **Use Jenkins**: Implement CI/CD pipelines to automate test execution and provide immediate feedback.

- **Test Data Management**: Develop mechanisms for managing test data more effectively, including data generation, manipulation, and cleanup, to ensure consistency and reliability of tests.


## Technologies Used

- Selenium WebDriver
- Cucumber
- Java
- ChromeDriver
- GeckoDriver (for Firefox)
- Maven (for project management)

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository:

```
git clone https://github.com/honey-s01/CURATestingProject.git


```
2. Install dependencies:

- **Selenium Java**:
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.8.3</version>
</dependency>
```
- Cucumber JVM:
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-jvm-deps</artifactId>
    <version>1.0.6</version>
    <scope>provided</scope>
</dependency>
```
- JUnit:
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```
- Cucumber JUnit:
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.15.0</version>
    <scope>test</scope>
</dependency>
```
- Hamcrest All:
```xml
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
    <version>1.3</version>
</dependency>
```
- CommonsIO:
```xml
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.0</version>
</dependency>
```
- Log4j:
```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

3. Install Plugins:

- **Gherkin**:
- **Cucumber for Java**:
- - **Cucumber+**:
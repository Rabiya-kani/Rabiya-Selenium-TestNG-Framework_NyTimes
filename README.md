# Selenium WebDriver TestNG Framework
**Overview**
This project is a Selenium TestNG framework designed for testing the New York Times website. It includes:

-ExtentReports for detailed test reporting.
-Support for multiple browsers (Chrome, Firefox, Edge).
-TestNG Listeners for better test reporting and logging.
-Screenshot functionality on test failures.
-CI/CD integration with GitLab.
## Tools  & Libraries
- Java
- Selenium WebDriver
- TestNG 
- Maven
- Extent Reports and logging

## Prerequisites
- IDE 
- JDK 
- Maven configuration


## How to run tests
In terminal:
```
git clone https://github.com/Rabiya-kani/Rabiya-Selenium-TestNG-Framework_NyTimes.git
```
Change directory to the location of cloned project folder and run Maven clean
```
mvn clean
```
To run the test
```
mvn test
```

## Project components
- Page objects are in the directory *src/main/java/pages*
- Test classes are in the the directory *src/test/java/tests*
- Listener and test data class is in the directory *src/main/java/util*

## Highlights
- This framework supports multiple browser
- Screenshot on test failure: A screenshot of the active browser is captured and stored in the screenshots folder
- Extent reporting and logging: After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the 'report' folder

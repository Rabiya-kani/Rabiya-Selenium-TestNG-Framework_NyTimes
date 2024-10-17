# Selenium WebDriver TestNG Framework
**Overview**
This project is a Selenium TestNG framework designed for testing the New York Times website. It includes:

- ExtentReports for detailed test reporting.
- Support for multiple browsers (Chrome, Firefox, Edge).
- TestNG Listeners for better test reporting and logging.
- Screenshot functionality on test failures.
- CI/CD integration with GitLab.
- Support Data Driven Framework

## Tools  & Libraries
- Java
- Selenium WebDriver
- TestNG 
- Maven
- Extent Reports and logging

## Technologies Used
- Framework Type: Data Driven Framework
- Selenium WebDriver: For browser automation.
- TestNG: For organizing and running test cases.
- Maven: For dependency management , Project life cycle and build automation.
- Java: Primary programming language.
- Design Pattern: Page Object Model and Inbuilt Custom annotations.
- HTML, CSS, JavaScript,XML: For web interactions.

## Prerequisites
- IDE 
- JDK 
- Maven configuration


## How to run tests
In terminal:
```
git clone https://github.com/Rabiya-kani/Rabiya-Selenium-TestNG-Framework_NyTimes.git
```
Navigate to the project directory:
```
cd NYTimesJava
```
Change directory to the location of cloned project folder and run Maven clean
```
mvn clean
```
To run the test
```
mvn test
```
In Local IDE:
```
Execute the tests using TestNG:
```
Right-click on TestSuite.xml.
- Select "Run 'TestSuite.xml'".
- Select "Run 'multipleBrowser.xml'" for run Suite in Different Browser

## Project Structure
- Page objects are in the directory *src/main/java/pages*
- Test classes are in the the directory *src/test/java/tests*
- Listener and test data class is in the directory *src/main/java/util*
- .gitignore: Git ignore file.
- pom.xml: Maven project file for managing dependencies.
- testng.xml: TestNG configuration file.
- multipleBrowser.xml: TestNG Suite Execution in Different Browser
- Results : report/Tests_Results.html
- Failed TCs SCreenshot : screenshots/testLogin.png
- .gitlab-ci.yml : CI/CD Configurations

## Highlights
- **This framework supports multiple browser**
- Screenshot on test failure: A screenshot of the active browser is captured and stored in the screenshots folder
- Extent reporting and logging: After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the 'report' folder

## Test Cases Overview
Below mentioned 7 Test cases were covered under 1 Test classes:

1. NYHomePageTest :
- verifyTitle() : This will validate the Title of the home screen.
- verifyLogo()  : This will validate the Logo of the WebApplication
- testLatestNews() : This Test Validate the Latest News on the NY HomePage
- verifyAnyDropdown() : This Test Validate Dropdown Option of Any Section (like U.S, World..)
- testSearchForArticle() : This Test Validate the Searching functionality (like Breaking News, Flash News...)
- testTopStoriesForGivenTab() : This will validate the TopStories Section in Any Tab
- testSubscribe() : This Will validate the subcribe functionality

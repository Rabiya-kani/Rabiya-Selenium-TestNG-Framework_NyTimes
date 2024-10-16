package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BasePage{
	
	@Test(priority=0)
	public void navigateToLoginPage() {
		logger = report.startTest("navigateToLoginPage");

		HomePage homePage = new HomePage(driver);
		homePage.clickLogInLink();
		logger.log(LogStatus.INFO, "Clicking the 'Log in' link");
	}
	
	//* Test invalid login attempts using data from DataProvider
	@DataProvider(name="accounts")
	public Object[][] getData(){
		return new Object[][] {
				{"rabiyakanij@gmail.com", "InvalidPassword2"}, // Correct email, Invalid password
				{"InvalidEmail@gmail.com", "User@123"} // Invalid email, correct password
		};
	}
	
	@Test(priority=1, dataProvider="accounts")
	public void verifyInvalidLoginCredentials(String testUsername, String testPassword) {
		logger=report.startTest("verifyInvalidLoginCredentials");
		LoginPage login = new LoginPage(driver);
		navigateToLoginPage();
		login.typeUsername(testUsername);
		logger.log(LogStatus.INFO, "Entering valid username");
		login.clickContinueButton();
		login.typePassword(testPassword);
		logger.log(LogStatus.INFO, "Entering invalid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Log in button");
		logger.log(LogStatus.PASS, "Log in with invalid crendentials failed");
	}
	
	@Test(priority=2)
	@Parameters({"username", "password"})
	public void verifyLogin(String username, String password) {
		logger=report.startTest("verifyLogin");
		LoginPage login = new LoginPage(driver);
		login.typeUsername(username);
		logger.log(LogStatus.INFO, "Entering valid username");
		login.typePassword(password);
		logger.log(LogStatus.INFO, "Entering valid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
	}
}	

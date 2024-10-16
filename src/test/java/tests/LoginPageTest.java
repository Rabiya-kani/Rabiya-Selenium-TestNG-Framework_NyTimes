package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import util.ExcelUtils;
import util.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class LoginPageTest extends BasePage{
	
	@Test(priority=0)
	public void navigateToLoginPage() {
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
		LoginPage login = new LoginPage(driver);
		login.typeUsername(username);
		logger.log(LogStatus.INFO, "Entering valid username");
		login.typePassword(password);
		logger.log(LogStatus.INFO, "Entering valid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
	}
	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		String excelPath = "D:\\Java\\NYTimesJava\\src\\test\\resources\\testData.xlsx"; // Path to your Excel file
		ExcelUtils excelUtils = new ExcelUtils(excelPath, "Sheet1");
		int rowCount = excelUtils.getRowCount();

		Object[][] data = new Object[rowCount][2];
		for (int i = 1; i < rowCount; i++) {
			data[i][0] = excelUtils.getCellData(i, 0); // Username from first column
			data[i][1] = excelUtils.getCellData(i, 1); // Password from second column
		}
		excelUtils.close();
		return data;
	}

	@Test(dataProvider = "loginData")
	public void testLogin(String username, String password) {
		logger.log(LogStatus.INFO, "Opened New York Times home page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		loginPage.typeUsername(username);
		loginPage.clickContinueButton();
		loginPage.typePassword(password);
		loginPage.clickSignIn();
		logger.log(LogStatus.INFO, "Attempted login with username: " + username);

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed for user: " + username);
	}
	}

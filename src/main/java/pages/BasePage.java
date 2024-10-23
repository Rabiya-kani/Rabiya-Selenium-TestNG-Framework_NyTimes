package pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.nytimes.com";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun = true)
//	@Parameters("browser")
	public void setup(ITestContext context) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
//		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//		} else if (browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
		// Initialize ExtentReports
		report = new ExtentReports("./report/Tests_Results.html", true);
		//driver.findElement(By.xpath("//div[@class='css-hqisq1']//button")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
//		report.flush();
//		report.close();
	}

	public static String captureScreenshot(String testName) {
		String filePath = "./screenshots/" + testName + ".png";
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(screenshot.toPath(), Paths.get(filePath));
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

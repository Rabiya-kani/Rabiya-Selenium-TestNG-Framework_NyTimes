package util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;

public class ExtentReportListener extends BasePage implements ITestListener, ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		BasePage.logger = BasePage.report.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		BasePage.logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " - Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = BasePage.captureScreenshot(result.getMethod().getMethodName());
		BasePage.logger.log(LogStatus.FAIL, result.getMethod().getMethodName() + " - Failed");
		BasePage.logger.log(LogStatus.FAIL, result.getThrowable());
		if (screenshotPath != null) {
			BasePage.logger.log(LogStatus.FAIL, "Screenshot: " + BasePage.logger.addScreenCapture(screenshotPath));
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		BasePage.logger.log(LogStatus.SKIP, result.getMethod().getMethodName() + " - Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		BasePage.report.flush();
	}
}

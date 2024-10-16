package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;
import pages.HomePage;

import java.util.List;

public class HomePageTest extends BasePage{

	@Test(priority=0)
	public void verifyTitle() {
		logger = report.startTest("verifyTitle");

		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "The New York Times - Breaking News, US News, World News and Videos", "Title does not match");
		logger.log(LogStatus.PASS, "Title matches with title from DOM");
	}

	@Test(priority=1)
	public void verifyLogo() {
		logger = report.startTest("verifyLogo");
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking if logo is present");
		Assert.assertTrue(homePage.getLogo());
		logger.log(LogStatus.PASS, "Logo is present");
	}

	@Test(priority=2)
	public void testLatestNews() {
		logger = report.startTest("testLatestNews");

		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Opened home page");

		String latestNews = homePage.getLatestNewsText();
		Assert.assertNotNull(latestNews, "Latest news should not be null");
		logger.log(LogStatus.INFO, "Retrieved latest news: " + latestNews);
		System.out.println("Latest News is:"+latestNews);
		logger.log(LogStatus.PASS, "Test passed");
	}
	@Test(priority=3)
	public void verifyAnyDropdown() {
		logger = report.startTest("verifyAnyDropdown");

		HomePage homePage = new HomePage(driver);
		homePage.hoverOverTab("U.S.");
		logger.log(LogStatus.INFO, "Hovering over particular tab");
	}
	@Test(priority=4)
	public void testSearchForArticle() {
		logger = report.startTest("testSearchForArticle");

		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Opened home page");

		homePage.searchForArticle("Breaking News");
		logger.log(LogStatus.INFO, "Searched for 'Breaking News'");
		Assert.assertTrue(homePage.getSearchPage().contains("Breaking News"), "Title should contain 'Breaking News'");

	}

	@Test
	public void testTopStories() {
		logger = report.startTest("testTopStories");
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Opened home page");
		homePage.hoverOverTab("U.S.");
		String topStories = homePage.getTopStoriesText();
		Assert.assertNotNull(topStories, "Top stories should not be null");
		logger.log(LogStatus.INFO, "Retrieved top stories: " + topStories);
	}

	@Test
	public void testSubscribe() {
		logger = report.startTest("testSubscribe");
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Opened home page");

		homePage.clickSubscribeAndVerifyMessage();
		logger.log(LogStatus.INFO, "Clicked subscribe button");

		//assertions to verify subscription success, e.g., checking for confirmation message
		Assert.assertTrue(homePage.clickSubscribeAndVerifyMessage().contains("Enjoy all of The Times."), "Subscription should be successful");
	}
}


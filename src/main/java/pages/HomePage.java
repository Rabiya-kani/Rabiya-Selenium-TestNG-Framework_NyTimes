package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	private By latestNews = By.xpath("(//div[@class='css-xdandi']/p)[1]"); // Update with actual selector
	By nyLogo = By.xpath("//section/div/a[@data-testid='masthead-mobile-logo']");
	By signinLink = By.xpath("//a[(.= 'Log in')]");

	private By searchButton = By.xpath("//button[.='SEARCH']");
	private By searchInput = By.xpath("//input[@placeholder='SEARCH']");
	private By topStories = By.xpath(".top-stories");
	private By subscribeButton = By.xpath("//div[@id='js-nav-actions']/a[.='Subscribe']");

	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getLogo() {
		 return driver.findElement(nyLogo).isEnabled();
	}
	public String getLatestNewsText() {
		return driver.findElement(latestNews).getText();
	}
	public void clickLogInLink() {
		 driver.findElement(signinLink).click();
	}
	public void hoverOverTab(String tabName) {
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//ul[@class='css-17j7fe1']/li/a[.='"+tabName+"']"))).perform();

	}public void searchForArticle(String article) {
		driver.findElement(searchButton).click(); // Click the search button to open the input field
		driver.findElement(searchInput).sendKeys(article); // Type the article name
		driver.findElement(By.xpath("//button[.='Go']")).click(); // Click the 'Go' button to submit the search
	}
	public String getSearchPage() {
		return driver.findElement(By.xpath("(//p/span)[1]/following-sibling::span")).getText();
	}
	public String getTopStoriesText(String tabName) {
		return driver.findElement(By.xpath("//div[@class='css-10u7rti']//div[@aria-label='"+tabName+" submenu']//div[4]//div[1]//h3[1]")).getText();
	}

	public void clickSubscribe() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='nytcp-opt css-1kj7lfb']//span[@class='css-1ahxtak'][normalize-space()='PLAY SPELLING BEE']")).click();
		driver.findElement(subscribeButton).click();
	}
	public String verifySubscribe() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(By.xpath("//h2[@class='css-i3x217']")).getText();
	}


}
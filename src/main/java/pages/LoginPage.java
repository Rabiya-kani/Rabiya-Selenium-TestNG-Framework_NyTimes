package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	By usernameField = By.id("email");
	By passwordField = By.id("password");
	By continueButton = By.xpath("//button[.='Continue']");

	By signInButton = By.id("sign_in");

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}
	public void clickLoginButton(){
		driver.findElement(By.xpath("//a[@class='css-1kj7lfb']/span")).click();
	}
	public void typeUsername(String username) {
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void typePassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHomePage {
	
	WebDriver driver;
	
	By signUpButton = By.linkText("SignUp");
	By loginButton = By.linkText("Login");
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminSignupPage navigateToAdminSignupPage() {
		driver.findElement(signUpButton).click();
		return new AdminSignupPage(driver);
	}
	
	public void navigateToAdminLoginPage() {
		driver.findElement(loginButton).click();
	}

}

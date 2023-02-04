package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	
	WebDriver driver;
	
	By usernameTextbox = By.id("id_username");
	By passwordTextbox = By.id("id_password");
	By submitButton = By.className("btnSubmit");
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminDashboardPage adminLogin(String username, String password) {
		driver.findElement(usernameTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(submitButton).click();
		return new AdminDashboardPage(driver);
	}

}

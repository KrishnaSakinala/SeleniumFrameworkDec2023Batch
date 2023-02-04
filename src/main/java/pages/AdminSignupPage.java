package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.TestData;

public class AdminSignupPage {
	
	WebDriver driver;
	
	By firstNameTextbox = By.id("id_first_name");
	By lastNameTextbox = By.id("id_last_name");
	By usernameTextbox = By.id("id_username");
	By passwordTextbox = By.id("id_password");
	By submitButton = By.className("btnSubmit");
	
	public AdminSignupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminLoginPage createAdmin(String username, String password, String firstName) {
		
		driver.findElement(firstNameTextbox).sendKeys(firstName);
		driver.findElement(lastNameTextbox).sendKeys(TestData.lastName());
		driver.findElement(usernameTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(password);
		driver.findElement(submitButton).click();
		
		return new AdminLoginPage(driver);
	}

}

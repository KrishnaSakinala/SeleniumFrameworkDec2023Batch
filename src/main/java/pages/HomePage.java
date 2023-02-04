package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	WebDriver driver;
	
	// capture the elements
	By adminLink = By.linkText("Admin");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// perform the actions	
	public AdminHomePage navigateToAdminHomePage() {
		driver.findElement(adminLink).click();
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		return adminHomePage;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
	
	WebDriver driver;
	
	By adminFirstName = By.tagName("h2");
	
	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAdminFirstName() {
		return driver.findElement(adminFirstName).getText();
	}

}

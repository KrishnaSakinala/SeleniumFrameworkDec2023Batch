package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Backup {

	@Test(description = "Create Admin and verify login.")
	public void verifyAdminCreation() throws InterruptedException {

		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// navigate to ur application url
		driver.get("http://localhost:8000/");

		// click on admin link on home page
		driver.findElement(By.linkText("Admin")).click();

		// click on sign up button on admin home page
		driver.findElement(By.linkText("SignUp")).click();

		// admin signup
		driver.findElement(By.id("id_first_name")).sendKeys("Sumona");
		driver.findElement(By.id("id_last_name")).sendKeys("Rehman");
		driver.findElement(By.id("id_username")).sendKeys("Sumona");
		driver.findElement(By.id("id_password")).sendKeys("password");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(5000);

		// admin login
		driver.findElement(By.id("id_username")).sendKeys("Sumona");
		driver.findElement(By.id("id_password")).sendKeys("password");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// admin verification
		String nameFromApplication = driver.findElement(By.tagName("h2")).getText();

		Assert.assertEquals(nameFromApplication, "Sumona");

		driver.quit();
	}
}

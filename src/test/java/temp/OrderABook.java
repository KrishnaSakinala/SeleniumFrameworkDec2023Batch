package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderABook {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.automationtesting.in/");

		driver.findElement(By.id("s")).sendKeys("JavaScript");
		driver.findElement(By.id("s")).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@title='Mastering JavaScript']")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='content']/div[1]/a")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Proceed to Checkout")).click();
		
	}

}

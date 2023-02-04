package temp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchABookAndVerify {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.automationtesting.in/");

		driver.findElement(By.id("s")).sendKeys("JavaScript");
		driver.findElement(By.id("s")).sendKeys(Keys.ENTER);

		List<WebElement> searchedBooks = driver.findElements(By.xpath("//div[@id='loops-wrapper']//h2/a"));

		for (WebElement searchBook : searchedBooks) {
			String bookName = searchBook.getText();

			if (bookName.contains("JavaScript") || bookName.contains("JS")) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}
		}

	}

}

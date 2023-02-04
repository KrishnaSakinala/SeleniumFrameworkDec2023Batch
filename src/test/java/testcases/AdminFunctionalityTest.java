package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import pages.HomePage;
import util.TestData;

public class AdminFunctionalityTest extends BaseTest {

	@Test(description = "Create Admin and verify admin login.")
	public void verifyAdminCreation() {

		extentTest = extentReports.createTest("verifyAdminCreation");

		String username = TestData.userName();
		String password = TestData.password();
		String firstName = TestData.firstName();

		String adminFirstName = new HomePage(driver).navigateToAdminHomePage().navigateToAdminSignupPage()
				.createAdmin(username, password, firstName).adminLogin(username, password).getAdminFirstName();

		Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/admin-dashboard");

		Assert.assertEquals(adminFirstName, firstName);
	}

	@Test
	public void testToShowFailure() {
		extentTest = extentReports.createTest("testToShowFailure");

		Assert.assertEquals(driver.getTitle(), "Hospital Management");
	}
	
	@Test
	public void testToShowSkip() {
		throw new SkipException("Skipping this test...");
	}
}
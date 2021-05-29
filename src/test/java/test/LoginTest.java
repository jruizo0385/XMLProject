package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {

	WebDriver driver;
	
	@Test
	@Parameters({"username", "password"})
	public void validUserShouldBeAbleToLogin(String userName, String password) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		dashBoard.verifyDashboardPage();

		BrowserFactory.tearDown();

	}

}

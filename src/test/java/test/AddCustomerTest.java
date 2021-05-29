package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
		
	//@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToCreateCustomer(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class); 	
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.ClickSaveButtonOnAddContact();
		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
	}
	
	@Test
	@Parameters({"username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToUseAddCustomerOnListCustomerPage(String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickListCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class); 
		addCustomerPage.clickAddCustomerOnListCustomerPage();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.ClickSaveButtonOnAddContact();
		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		addCustomerPage.insertNameOnSearchBarOnListCustomer();
		addCustomerPage.verifySearchBarAndSummaryButtonOnListCustomer();
		addCustomerPage.verifySummaryPage();
		
		BrowserFactory.tearDown();
		
	}

}

package testscenaios;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_Login extends BaseClass{
	
	@BeforeTest
	public void testSetup() {
		excelFile = "TC01";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage(driver)
				.verifyElement();
				assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestData")
	public void loginWithValidCredential(String userName,String password) {
		boolean result = new LoginPage(driver)
			.enterUserName(userName)
			.enterPassword(password)
			.clickOnSignInButton()
			.validateHomePage()
			.clickonLogout()
			.verifyElement();
		assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("Mathan")
		.enterPassword("test123")
		.clickOnSignInButtonWithInvalid()
		.validateLoginFailedText();
		assertTrue(result);
	}

}

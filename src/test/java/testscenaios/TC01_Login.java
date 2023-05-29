package testscenaios;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage()
							.verifyElement();
						assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidCredential() {
		boolean result = new LoginPage()
			.enterUserName("Mathan")
			.enterPassword("Testing123")
			.clickOnSignInButton()
			.validateHomePage()
			.clickonLogout()
			.verifyElement();
		assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("test123")
		.clickOnSignInButtonWithInvalid()
		.validateLoginFailedText();
		assertTrue(result);
	}

}

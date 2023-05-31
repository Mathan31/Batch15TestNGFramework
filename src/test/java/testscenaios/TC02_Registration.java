package testscenaios;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.FakerDataFactory;

public class TC02_Registration extends BaseClass{
	
	@Test(priority = 1)
	public void registrationFieldValiation() {
		boolean resultRegistation = new LoginPage(driver)
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
		
		boolean resultLogin = new RegistrationPage(driver)
		.clickOnUILogo()
		.verifyElement();
		
		assertTrue(resultRegistation);
		assertTrue(resultLogin);
	}
	
	@Test(priority = 2)
	public void registrationWithMandatoryFields() {
		boolean resultLogin = new LoginPage(driver)
		.clickOnRegistrationLink()
		.enterFirstName(FakerDataFactory.getFirstName())
		.selectTitle(FakerDataFactory.getTitle())
		.enterMiddleName(FakerDataFactory.getMiddleName())
		.enterLastName(FakerDataFactory.getLastName())
		.selectGender(FakerDataFactory.getGender())
		.enterUserName(FakerDataFactory.getUserName())
		.enterEmail(FakerDataFactory.getEmailAddress())
		.enterPassword(FakerDataFactory.getPassword())
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.verifyElement();
		
		assertTrue(resultLogin);
	}
	
	
	//@Test(priority = 3)
	public void registrationWithAllFields() {
		
	}

}

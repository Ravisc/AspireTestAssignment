package test;


import org.testng.annotations.Test;


import page.HomePage;
import page.LoginPage;

import util.PropertyFileReader;


import static org.testng.Assert.assertTrue;

import static util.driver.DriverHolder.getDriver;



public class ApplicationTest extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;


	@Test(description = "Verify ebanq application")
	public void testEbanqApplication() {

		
		
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());

		// Login to application with valid credentials
		
		loginPage.setUsername(PropertyFileReader.getProperty("username"));
		loginPage.setPassword(PropertyFileReader.getProperty("password"));
		loginPage.clickSignIn();

		// User successfully logged in to the  home page  
		
		// User clicks on Transfer 
		homePage.clickTransfer();
		
		// User clicks on TransferBetweenUsers 
		homePage.clickTransferBetweenUsers();
		
		// User selects the 'Mary Johnson' from `Debit from`
		homePage.selectdebitfromUserDropdown(PropertyFileReader.getProperty("debitusername"));
		
		// User selects the available Debit Account from `Debit from`
		homePage.selectdebitAccountDropdown();
		
		// User selects the credit to user from `Credit to`
		homePage.selectcreditToUserDropdown(PropertyFileReader.getProperty("creditusername"));
		
		// User selects the available  Account from `Credit to`
		homePage.selectcreditToAccountDropdown();
		
		//User enters amount into `Amount to transfer` text field.
		homePage.setAmountToTransfer(PropertyFileReader.getProperty("amountValue"));
		
		//User enters description into `Description` text field.
		homePage.setdescriptionTextField(PropertyFileReader.getProperty("descriptionTextField"));
		
		//User clicks on Continue button.
		homePage.clickContinueButton();
		
		//User clicks on Confirm button.
		homePage.clickConfirmButton();
		
		// Verify that success message is present
		homePage.getsuccessMessage().trim();

		assertTrue(homePage.getsuccessMessage().trim().contains("Transfer has been executed successfully."));
	}

}

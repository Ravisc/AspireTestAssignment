package page;

import static util.driver.DriverHolder.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	@FindBy(xpath = "//div[ @_ngcontent-c14 and @ng-reflect-router-link='/transfer']")
	public WebElement transferText;

	@FindBy(xpath = "//div[@ng-reflect-router-link='admin/transfer-between-users']")
	public WebElement TransferBetweenUsers;

	@FindBy(xpath = "(//*[@class='input-field select-container native-select user-select'])[1]")
	public WebElement debitfromUserDropdown;

	@FindBy(xpath = "//span[.='Mary Johnson (mjohnson)']")
	public WebElement debitfromUserDropdownValue;

	@FindBy(xpath = "(//*[@class='input-field select-container native-select user-select'])[2]")
	public WebElement creditToUserDropdown;

	@FindBy(xpath = "//span[.='Jack White (jwhite)']")
	public WebElement creditToUserDropdownValue;

	@FindBy(xpath = "(//div[.='Select account'])[1]")
	public WebElement debitSelectAccountDropdown;

	@FindBy(xpath = "(//div[.='Select account'])[4]")
	public WebElement creditToSelectAccountDropdown;

	@FindBy(xpath = "//span[.='EBQ12123423456']")
	public WebElement firstdebitSelectAccountDropdownvalue;

	@FindBy(xpath = "//span[.='EBQ22123412345']")
	public WebElement firstCreditSelectAccountDropdownvalue;

	@FindBy(xpath = "//input[@ng-reflect-name='outgoingAmount']")
	public WebElement amountToTransferText;

	@FindBy(xpath = "//textarea[@id='description']")
	public WebElement descriptionTextField;

	@FindBy(xpath = "//button[.=' Continue ']")
	public WebElement continueButton;
	
	@FindBy(xpath = "//button[.=' Confirm ']")
	public WebElement confirmButton;
	
	//button[.=' Confirm ']

	@FindBy(xpath = "//div[text()=' Transfer has been executed successfully. ']")
	public WebElement successMessage;

	Actions actions = new Actions(getDriver());

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickTransfer() {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		transferText.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(transferText));

		transferText.sendKeys(Keys.ENTER);
		transferText.click();
	}

	public void clickTransferBetweenUsers() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TransferBetweenUsers.isDisplayed();
		TransferBetweenUsers.sendKeys(Keys.ENTER);
		TransferBetweenUsers.click();
	}

	public void selectdebitfromUserDropdown(String DropdownName) {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BasePage.waitUntilElementVisible(debitfromUserDropdown);
		BasePage.clickAction(getDriver(), debitfromUserDropdown);

		actions.moveToElement(debitfromUserDropdown).sendKeys(DropdownName).build().perform();
		actions.moveToElement(debitfromUserDropdownValue).click().build().perform();

	}

	public void selectdebitAccountDropdown() {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BasePage.waitUntilElementVisible(debitSelectAccountDropdown);
		BasePage.clickAction(getDriver(), debitSelectAccountDropdown);
		BasePage.clickAction(getDriver(), firstdebitSelectAccountDropdownvalue);

	}

	public void selectcreditToUserDropdown(String DropdownName) {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BasePage.waitUntilElementVisible(creditToUserDropdown);
		BasePage.clickAction(getDriver(), creditToUserDropdown);

		actions.moveToElement(creditToUserDropdown).sendKeys(DropdownName).build().perform();
		actions.moveToElement(creditToUserDropdownValue).click().build().perform();

	}

	public void selectcreditToAccountDropdown() {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BasePage.waitUntilElementVisible(creditToSelectAccountDropdown);
		BasePage.clickAction(getDriver(), creditToSelectAccountDropdown);
		BasePage.clickAction(getDriver(), firstCreditSelectAccountDropdownvalue);

	}

	public void setAmountToTransfer(String value) {

		amountToTransferText.sendKeys(value);

	}

	public void setdescriptionTextField(String value) {

		descriptionTextField.sendKeys(value);

	}

	public void clickContinueButton() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BasePage.scrollIntoView(continueButton);
		BasePage.waitUntilElementVisible(continueButton);
		continueButton.isDisplayed();

		actions.moveToElement(continueButton).doubleClick().build().perform();
	//	actions.moveToElement(continueButton).doubleClick(continueButton).build().perform();

	}

	public void clickConfirmButton() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		BasePage.waitUntilElementVisible(confirmButton);
		confirmButton.isDisplayed();

		actions.moveToElement(confirmButton).doubleClick().build().perform();
		actions.moveToElement(confirmButton).doubleClick(confirmButton).build().perform();

	}
	
	
	public String getsuccessMessage() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		successMessage.isDisplayed();
		return successMessage.getText().trim();
	}

}

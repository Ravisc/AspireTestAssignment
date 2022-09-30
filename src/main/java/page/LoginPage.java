package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@placeholder='Enter username or email address']")
	public WebElement usernameTextBox;

	@FindBy(xpath = "//input[@placeholder='Enter password']")
	public WebElement passwordTextBox;

	@FindBy(xpath = "//button[.=' Sign In ']")
	public WebElement signInButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setUsername(String username) {

		usernameTextBox.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickSignIn() {
		signInButton.click();
	}

}

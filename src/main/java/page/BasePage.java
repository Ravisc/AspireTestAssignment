package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static util.driver.DriverHolder.getDriver;

public class BasePage {

	// public static WebDriver driver;

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void clickAction(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(("arguments[0].scrollIntoView(true);"), element);
	}

	public static void waitUntilElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectFromDropdown(WebElement element, String DropdownName) {
		Select skillsDropdown = new Select(element);
		skillsDropdown.selectByVisibleText(DropdownName);

	}

}

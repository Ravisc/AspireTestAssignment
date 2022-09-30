package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.ExtentReportListener;
import util.driver.DriverFactory;

import static util.PropertyFileReader.getProperty;
import static util.driver.DriverHolder.getDriver;
import static util.driver.DriverHolder.setDriver;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentReportListener.class)
public class BaseTest {

	@BeforeMethod
	public void before() {
		setDriver(DriverFactory.getNewDriverInstance(getProperty("browser")));
		getDriver().manage().window().maximize();
		getDriver().get(getProperty("application_url"));
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void after() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import io.appium.java_client.android.AndroidDriver;
import library.Utils;

public class CapabilitiesSetup {
	AndroidDriver driver;

	@BeforeClass
	public void setAuto() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.4.13.1");
		capabilities.setCapability("platformName", "Android");
		File app = new File("tiketandroid-1.11.7-debug-01032017.apk");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("deviceName", "F4AZCY09Y468");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("app", app.getAbsolutePath());
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utils.captureScreenshot(driver, result.getName());
		}
	}

}

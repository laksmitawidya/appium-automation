import org.testng.annotations.Test;

import io.appium.java_client.android.Connection;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Add @Test annotation before run testcase
 * TestCase : Search Autocomplete
 */


public class SearchAutoComplete extends CapabilitiesSetup {

	public void searchspecifichotel() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
	}

	public void searchpopularcity() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Yogyakarta");
		WebElement populararea = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']"));
		populararea.click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
	}

	public void verifypopularcity() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Yogyakarta");
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]"))
				.click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='15']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_guest")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
		String popularcity = driver.findElement(By.id("com.tiket.gits:id/tv_location")).getText();
		Assert.assertEquals(popularcity, "Yogyakarta, Yogyakarta ");
	}

	public void emptyhotel() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='15']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_guest")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
		String popularcity = driver.findElement(By.id("com.tiket.gits:id/tv_location")).getText();
		AssertJUnit.assertEquals(popularcity, "Nearby Hotels");
	}

	
	public void searchrecommendedhotel() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Semarang");
		scrollTo("Recommended Hotel");
		driver.hideKeyboard();
		String expectedHotel = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[6]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Thread.sleep(5000);
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[6]/android.widget.LinearLayout[1]"))
				.click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
		Thread.sleep(10000);
		String hotelName = driver.findElement(By.id("com.tiket.gits:id/tv_hotel_name")).getText();
		Assert.assertEquals(expectedHotel, hotelName);
	}
	
	
	public void searchbyhotelcity() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Bandung");
		driver.hideKeyboard();
		String cities = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(cities, "Cities");
		String populararea = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(populararea, "Popular Area");
		scrollTo("Recommended Hotel");
		String recommendedHtl = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(recommendedHtl, "Recommended Hotel");
	}
	
	
	public void searchbyhotelcountry() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Indo");
		driver.hideKeyboard();
		String cities = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(cities, "Cities");
		String populararea = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(populararea, "Popular Area");
		String provinces = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(provinces, "Provinces");
		scrollTo("Country");
		String country = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(country, "Country");
		String recommendedHtl = driver
				.findElement(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		Assert.assertEquals(recommendedHtl, "Recommended Hotel");
		
	}
	
	public void settinglanguagebahasa() {

		driver.findElement(By.id("com.tiket.gits:id/action_settings")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_lang")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Indonesian']")).click();

	}

	public void settinglanguageenglish() {

		driver.findElement(By.id("com.tiket.gits:id/action_settings")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_lang")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='English']")).click();

	}

	public void fillnamehotelwithnumber() {

		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("fave68");
		String actual=driver.findElement(By.id("com.tiket.gits:id/tv_error_handling")).getText();
		String expected="Sorry, we could not find what you were looking for";
		Assert.assertEquals(actual, expected);
	}
	
	
	public void searchhotelbydisconnect() throws InterruptedException{
	    
	    driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
	    driver.setConnection(Connection.NONE);
	    driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
	    driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
	    String expected="We can't reach our network now\nPlease check your connection";
	    String actual = driver.findElement(By.id("com.tiket.gits:id/tv_error_handling")).getText();
	    Assert.assertEquals(actual, expected);

	}
	
	
	public void searchhotelwhileloading () {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Bandung");
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]"))
				.click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='15']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_guest")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='2']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		
	}
	
	public void backtohome() {
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();

	}

	public WebElement scrollTo(String keyword) {
		HashMap scrollObject = new HashMap();
		RemoteWebElement element = (RemoteWebElement) driver.findElementByAndroidUIAutomator(
				"new UiSelector().className(\"android.support.v7.widget.RecyclerView\")");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String webElementId = ((RemoteWebElement) element).getId();
		System.out.println(webElementId);
		System.out.println(element);
		scrollObject.put("text", keyword);
		scrollObject.put("element", webElementId);
		js.executeScript("mobile: scrollTo", scrollObject);
		return element;
	}
}

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ChooseRoom extends CapabilitiesSetup {
	private SearchAutoComplete search;
	
	
	public void settingLanguageBahasa() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/action_settings")).click();
		WebElement bahasa = driver.findElement(By.id("android:id/text1"));
		if (bahasa.getText().contains("English")) {
			System.out.println(bahasa);
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Indonesian']")).click();
		} else if (bahasa.getText().contains("Indonesia")) {
			System.out.println(bahasa);
			driver.navigate().back();
		}


		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
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
		driver.findElement(By.id("com.tiket.gits:id/btn_choose_room")).click();
		String durasiexpected = driver.findElement(By.id("com.tiket.gits:id/tv_room_duration")).getText();
		String durasiactual = "Malam";
		Assert.assertTrue(durasiexpected.contains(durasiactual));
		String kamarexpected = driver.findElement(By.id("com.tiket.gits:id/tv_room_room")).getText();
		String kamaractual = "Kamar";
		Assert.assertTrue(kamarexpected.contains(kamaractual));
		String btnPilihExpected = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Button[1]")).getText();
		String btnPilihActual = "Pilih";
		Assert.assertTrue(btnPilihExpected.contains(btnPilihActual));
	}
	
	
	public void settingLanguageEnglish() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/action_settings")).click();
		WebElement bahasa = driver.findElement(By.id("android:id/text1"));
		if (bahasa.getText().contains("Indonesian")) {
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='English']")).click();
		} else if (bahasa.getText().contains("English")) {
			System.out.println(bahasa);
			driver.navigate().back();
		}

		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
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
		driver.findElement(By.id("com.tiket.gits:id/btn_choose_room")).click();
		String durasiexpected = driver.findElement(By.id("com.tiket.gits:id/tv_room_duration")).getText();
		String durasiactual = "Nights";
		Assert.assertTrue(durasiexpected.contains(durasiactual));
		String kamarexpected = driver.findElement(By.id("com.tiket.gits:id/tv_room_room")).getText();
		String kamaractual = "Room";
		Assert.assertTrue(kamarexpected.contains(kamaractual));
		String btnPilihExpected = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Button[1]")).getText();
		String btnPilihActual = "Choose";
		Assert.assertTrue(btnPilihExpected.contains(btnPilihActual));
	}
	
	public void verifycheckindate() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Yogyakarta");
		WebElement populararea = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']"));
		populararea.click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		int checkindate = 15;
		int checkoutdate = checkindate + 9;
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + checkindate + "']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + checkoutdate + "']")).click();
		WebElement checkout = driver.findElement(By.xpath("//android.widget.TextView[@text='" + checkoutdate + "']"));
		Assert.assertFalse(checkout.isSelected());
	}

	public void verifynight() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("Yogyakarta");
		WebElement populararea = driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']"));
		populararea.click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		int checkindate = 15;
		int checkoutdate = 17;
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + checkindate + "']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + checkoutdate + "']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		int maxnight = 7;
		driver.findElement(By.id("com.tiket.gits:id/inp_guest")).click();
		WebElement night = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + maxnight + "']"));
		Assert.assertFalse(night.isSelected());
	}

	//	gabisa di inspect -> change date checkin, duration, total room
	public void changedatacheckin() {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
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
		driver.findElement(By.id("com.tiket.gits:id/btn_choose_room")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_room_detail")).click();
		driver.findElement(By.id("com.tiket.gits:id/ll_room_checkin")).click();

	}


	
	public void seedetailroom() throws InterruptedException {
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
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
		driver.findElement(By.id("com.tiket.gits:id/btn_choose_room")).click();

		String roomname = driver
				.findElement(By
						.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.getText();
		System.out.println(roomname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
		String roomdetailname = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.TextView[1]")).getText();
		System.out.println(roomdetailname);
		Assert.assertEquals(roomname, roomdetailname);
	}

	
	public void chooseroom(){
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
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
		driver.findElement(By.id("com.tiket.gits:id/btn_choose_room")).click();
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.Button[1]")).click();
		WebElement contacttitle=driver.findElement(By.id("android:id/title"));
		Assert.assertTrue(contacttitle.isDisplayed());
	}
	
	@Test(priority=0)
	public void validation(){
		driver.findElement(By.id("com.tiket.gits:id/btn_hotel")).click();
		driver.findElement(By.id("com.tiket.gits:id/tv_location")).click();
		driver.findElement(By.id("com.tiket.gits:id/et_search")).sendKeys("The Sunset Hotel & Restaurant");
		driver.findElement(By.id("com.tiket.gits:id/tv_area")).click();
		driver.findElement(By.id("com.tiket.gits:id/lin_checkin_date")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.id("com.tiket.gits:id/calendar_right_arrow")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='15']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
		driver.findElement(By.id("com.tiket.gits:id/btn_positive")).click();
		driver.findElement(By.id("com.tiket.gits:id/inp_guest")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='6']")).click();

		driver.findElement(By.id("com.tiket.gits:id/btn_search")).click();
		WebElement errhandling = driver.findElement(By.id("com.tiket.gits:id/tv_error_handling"));
		Assert.assertTrue(errhandling.isDisplayed());
	}

}

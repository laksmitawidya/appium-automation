package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;

public class Utils{
	public static void captureScreenshot(AppiumDriver wd,String screenshotName){
		try {
				TakesScreenshot ts = (TakesScreenshot)wd;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
				System.out.println("Screenshot taken "+screenshotName);
			}
		catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
						} 
			}
	public static void swipeUp(AppiumDriver wd){
		Dimension dimension = wd.manage().window().getSize();
		int width = dimension.getWidth();
		int height = dimension.getHeight();
		wd.swipe((int) (width*(0.50)), (int) (height*(0.70)), (int) (width*(0.50)), (int) (height*(0.30)), 6000);
	}
}
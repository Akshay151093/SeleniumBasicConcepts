package at.ScreenshotsAutomation;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotsWithDifferentNames {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
	// Setup
	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	driver.get("https://www.facebook.com/");
	Thread.sleep(1500);
	captureScreenshot();

	driver.get("https://www.amazon.in/");
	Thread.sleep(1500);
	captureScreenshot();

	driver.get("https://www.flipkart.com/");
	Thread.sleep(1500);
	captureScreenshot();

    }

    // Function to capture screenshot
    public static void captureScreenshot() throws IOException {
	// To get diffrent name for every screenshot
	Calendar cal = Calendar.getInstance();
	String timestamp = Long.toString(cal.getTimeInMillis());

	// ScreenShot code
	String path = "E:\\STUDY\\Eclipse Workplace\\SeleniumBasicConcepts\\at.Screenshots\\";
	TakesScreenshot ts = (TakesScreenshot) driver;
	File ss = ts.getScreenshotAs(OutputType.FILE);
	File des = new File(path + driver.getTitle() + timestamp + ".png");
	FileHandler.copy(ss, des);
    }
}

package at.ScreenshotsAutomation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotCode {

    public static void main(String[] args) throws InterruptedException, IOException {

	// Setup
	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.facebook.com/");

	Thread.sleep(1500);

	// Screen shot code
	String path = "E:\\STUDY\\Eclipse Workplace\\SeleniumBasicConcepts\\at.Screenshots\\";
	TakesScreenshot ts = (TakesScreenshot) driver;
	File ss = ts.getScreenshotAs(OutputType.FILE);
	File des = new File(path + driver.getTitle() + ".png");
	FileHandler.copy(ss, des);
    }
}

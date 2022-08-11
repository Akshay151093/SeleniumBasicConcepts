package at.ScreenshotsAutomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotOfFailedTestCases {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
	ScreenshotOfFailedTestCases sc = new ScreenshotOfFailedTestCases();

	// Setup
	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.saucedemo.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	// test case
	sc.toVerifyUserAbletoLogInWithValidCredentials();
    }

    // Test case
    public void toVerifyUserAbletoLogInWithValidCredentials() throws IOException {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	String actualTitle = driver.getTitle();
	String expectedTitle = "Swag Labs";
	if (actualTitle.equalsIgnoreCase(expectedTitle)) {
	    System.out.println("Test case pass");
	} else {
	    System.out.println("Test case fail");
	    captureScreenshot();
	}

    }

    // Screen shot function
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
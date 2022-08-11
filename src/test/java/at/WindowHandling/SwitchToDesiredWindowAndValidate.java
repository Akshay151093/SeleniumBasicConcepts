package at.WindowHandling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToDesiredWindowAndValidate {
    static WebDriver driver;

    public static void main(String[] args) {

	SwitchToDesiredWindowAndValidate sw = new SwitchToDesiredWindowAndValidate();

	// Setup
	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	// Get parent window handle
	String parenthandle = driver.getWindowHandle();

	// Open multiple window
	driver.findElement(By.xpath(
		"//body/div[@id='wrapper']/div[@id='content']/div[@id='footer']/div[@id='social-icons']/a[1]/img[1]"))
		.click();
	driver.findElement(By.xpath(
		"//body/div[@id='wrapper']/div[@id='content']/div[@id='footer']/div[@id='social-icons']/a[2]/img[1]"))
		.click();
	driver.findElement(By.xpath(
		"//body/div[@id='wrapper']/div[@id='content']/div[@id='footer']/div[@id='social-icons']/a[3]/img[1]"))
		.click();
	driver.findElement(By.xpath(
		"//body/div[@id='wrapper']/div[@id='content']/div[@id='footer']/div[@id='social-icons']/a[4]/img[1]"))
		.click();

	// Get all window handles
	Set<String> setAllHandles = driver.getWindowHandles();

	// Convert set into list
	List<String> listAllHandles = new ArrayList<>(setAllHandles);

	// Switching to desired window
	sw.switchToWindow(listAllHandles, "LinkedIn");

	// Switching to parent
	sw.switchToParentWindow(parenthandle);

	// Switching to desired window
	sw.switchToWindow(listAllHandles, "YouTube");

	// Switching to parent
	sw.switchToParentWindow(parenthandle);

	driver.quit();

    }

    public void switchToWindow(List<String> list, String windowTitle) {
	for (String wh : list) {
	    String title = driver.switchTo().window(wh).getTitle();
	    if (title.contains(windowTitle)) {
		System.out.println("Found right window : " + title);
		break;
	    }
	}
    }

    public void switchToParentWindow(String parent) {
	String title = driver.switchTo().window(parent).getTitle();
	System.out.println("Switched to parent window : " + title);
    }
}

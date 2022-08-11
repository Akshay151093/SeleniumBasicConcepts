package at.WindowHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

    public static void main(String[] args) throws InterruptedException {

	// Setup
	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().deleteAllCookies();
	Thread.sleep(1500);

	// Get handle of parent window
	String parentHandle = driver.getWindowHandle();

	// Open Multiple window
	driver.findElement(By.xpath("//div[@id='social-icons']/a[1]/img")).click();
	driver.findElement(By.xpath("//div[@id='social-icons']/a[2]/img")).click();
	driver.findElement(By.xpath("//div[@id='social-icons']/a[3]/img")).click();
	driver.findElement(By.xpath("//div[@id='social-icons']/a[4]/img")).click();
	Thread.sleep(1500);

	// Get handles of all window
	Set<String> allhandles = driver.getWindowHandles();

	// Switch between windows
	for (String w : allhandles) {
	    if (!w.equals(parentHandle)) {
		driver.switchTo().window(w);
		Thread.sleep(1500);
		System.out.println("Switched to : " + driver.getTitle());
		driver.close();
	    }
	}

	// Switch to parent window
	driver.switchTo().window(parentHandle);
	Thread.sleep(1500);

	driver.quit();
    }

}

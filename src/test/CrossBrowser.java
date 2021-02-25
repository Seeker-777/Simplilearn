package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	WebDriver chromedriver;
	WebDriver firefoxdriver;
	
	@Test
	public void LaunchChrome() {
		
		System.setProperty("webdriver.chrome.driver","/home/shashikumartecn/Downloads/chromedriver");
		
		chromedriver = new ChromeDriver();
	
		chromedriver.get("https://www.simplilearn.com/");
		
		chromedriver.manage().window().maximize();
		
		chromedriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	}
	@Test(dependsOnMethods="LaunchChrome")
	public void testcase1() {
		
		WebElement linklogin = chromedriver.findElement(By.linkText("Log in"));
		
		linklogin.click();
		}
		
		
	@Test
	public void LaunchFirefox() {
	
		System.setProperty("webdriver.gecko.driver","/home/shashikumartecn/Downloads/geckodriver");
		
		firefoxdriver = new FirefoxDriver();
		
		firefoxdriver.get("https://www.simplilearn.com/");
		
		firefoxdriver.manage().window().maximize();
		
		firefoxdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
		}
	@Test(dependsOnMethods="LaunchFirefox")	
	public void testcase2() {
		
		WebElement linklogin = firefoxdriver.findElement(By.linkText("Log in"));
		
		linklogin.click();
		
		
	}
	
	
	
	

}

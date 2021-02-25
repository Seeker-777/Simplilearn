package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	
	
	WebDriver driver;
	
	SoftAssert assertobj = new SoftAssert();
	
	ExtentReports extend;
	
	ExtentTest test;
	
	@BeforeMethod
	public void setup() {
		
		
		
		System.setProperty("webdriver.chrome.driver","/home/shashikumartecn/Downloads/chromedriver");
		
		extend = new ExtentReports("ExtendReport.html", true);

		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	}

	
	
	
	@Parameters ({"username","password"})
	@Test
	public void testcase(String Username, String Password) {
		
		
		test = extend.startTest("Negative Login Test");
		WebElement linklogin = driver.findElement(By.linkText("Log in"));
		
		linklogin.click();
		
		
		WebElement editUsername = driver.findElement(By.name("user_login"));
		
		editUsername.sendKeys(Username);
		test.log(LogStatus.PASS, "Entered Username");
		
		WebElement editPwd = driver.findElement(By.name("user_pwd"));
		
		editPwd.sendKeys(Password);
		
		test.log(LogStatus.PASS, "Entered Password");
		
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		
		chkBox.click();
		
		test.log(LogStatus.PASS, "Clicked on Remember Me");
		
		WebElement btnPwd = driver.findElement(By.name("btn_login"));
		
		btnPwd.click();
		
		test.log(LogStatus.PASS, "Clicked on Login Button");
		
		WebElement error = driver.findElement(By.id("msg_box"));
        
        String ActError = error.getText();
        
        String ExpError = "The email or password you have entered is invalid.";
        
        //Assert.assertEquals(ActError, ExpError);
        
        assertobj.assertEquals(ActError, ExpError);
        
        System.out.println("After Failiure");

		
		
	}
	
	@AfterMethod
	public void teardown() {
		
	driver.quit();
												
	extend.endTest(test);
	extend.flush();
	extend.close();
		
		
	}
}

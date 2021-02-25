package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExcelRead {
	
	WebDriver driver;
	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		
		
		System.setProperty("webdriver.chrome.driver","/home/shashikumartecn/Downloads/chromedriver");
		

		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		FileInputStream file = new FileInputStream("exceldata.xlsx");
		
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet("datasheet");
		
		
		
		
		
	}

	
	
	
	@Test
	public void testcase() {
		
		
		
		WebElement linklogin = driver.findElement(By.linkText("Log in"));
		
		linklogin.click();
		
		
		WebElement editUsername = driver.findElement(By.name("user_login"));
		
		String username = sheet.getRow(1).getCell(0).getStringCellValue(); 
				
		editUsername.sendKeys(username);
		
		WebElement editPwd = driver.findElement(By.name("user_pwd"));
		
		String password = sheet.getRow(1).getCell(0).getStringCellValue(); 
		
		editPwd.sendKeys(password);
		
		
		
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		
		chkBox.click();
		
		
		WebElement btnPwd = driver.findElement(By.name("btn_login"));
		
		btnPwd.click();
	}
	

}

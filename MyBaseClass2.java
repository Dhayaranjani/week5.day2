package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyBaseClass2 {
	
	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pwd) {//(@Optional("DemoCSR") String uName) used in case of passing value from here
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		//Create an object for the Chromedriver
		driver = new ChromeDriver();
		//1. Launch the URL
		driver.get(url);
		//maximize the browser window
		driver.manage().window().maximize();
		//Identify WebElement
		//2. Enter UserName and Password Using Id Locator
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		//3. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException{
		return ReadExcel_DynamicFile.readData(fileName);
	}
	
}

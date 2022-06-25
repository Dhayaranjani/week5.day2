package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnAttrDataPro_ReadExcelDynData extends MyBaseClass2  {
	
	@Test(dataProvider = "getData")
	public void createLead(String cName, String fName, String lName) throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException{
		return ReadExcel2D.readData();
	}
}

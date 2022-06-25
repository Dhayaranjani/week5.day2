package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class Learn_ReadExcelDynamicFile extends MyBaseClass2{
	
	@BeforeClass
	public void setData() {
		fileName = "CreateLead";
	}
	
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

	//Since it is repeated so moved to Baseclass
/*	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException{
		return ReadExcel_DynamicFile.readData("CreateLead");
	}*/
}

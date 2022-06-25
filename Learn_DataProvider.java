package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*Class Activity 2. 
 * Implement Data provider for create lead test case
 * Steps used are
 * --------------
 * 1) Create a method fetchData() with 2Dimentional array
 * 2) Connect the method with @Test
 * 3) Create a XML file and execute from there
 * */
public class Learn_DataProvider extends MyBaseClass2{
	
	//@Test(dataProvider = "getData") //incase if use name 
	//@Test(dataProvider = "fetchData", dataProviderClass = Login.class) //if fetching from someother class
	
	@Test(dataProvider = "fetchData")
	public void createLead(String cName, String fName, String lName) throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		
		// select conference in source dropdown
		WebElement eleSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(eleSource);
		dd.selectByVisibleText("Conference");
		
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(2000);
		
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(firstName);
		
		if(firstName.equals("Dhaya")) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}
	
	//The below can be used if needed
	//@DataProvider(name = "getData", indices = 1)
	@DataProvider
	public String[][] fetchData() {
		//TestLeaf Dhaya S
		//CanadaPost Prsna C
		String[][] data = new String[2][3];
		data[0][0] = "TestLeaf";
		data[0][1] = "Dhaya";
		data[0][2] = "S";
		
		data[1][0] = "CanadaPost";
		data[1][1] = "Prsna";
		data[1][2] = "C";
		
		return data;
	}
}
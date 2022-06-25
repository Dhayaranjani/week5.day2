package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
/*========================================================================
Steps to use Annatation @parameters: => fetch the Static value 
1) Extend the BaseClass in the testcase 
2) Convert the testcase file into xml file
3) In the xml add the <parameter> tag add all the constant values
4) In the BaseClass add the Annotation @Parameters  
   eg. @Parameters({"url", "username", "password"}) - this name should match     with the xml file
4)Add any string val in the arguments of the method preCondition
  preCondition(String url, String uName, String pwd) 

//If you want to pass static info from your test case itself
//@Optional("DemoCSR") String uName, - 
//But it takes only if the value is not present in the xml file
=======================================================================
 * Execute from the xml file
=======================================================================
*/
public class ClassAct1_LearnParameters extends MyBaseClass2 {
	@Test
	public void runCreateLead() throws InterruptedException {
		//4. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on Leads button		
		driver.findElement(By.linkText("Leads")).click();
		
		//6. Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();
		
		//7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		//8.Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhayaranjani");
		
		//9. Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Subbiah");
		
		//10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Dhaya");
		
		//11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Information Technology");
		
		//12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is the TestLeaf test data for the description.");
		
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("dhayaranjani@gmail.com");
		
		//14. Select State/Province as NewYork Using Visible Text
		//1. Identify the dropdrown element (Select tag)
		WebElement selState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//2. Create an object for Select class and link with the dropdown element
		Select dropdownState = new Select(selState);
		//b) Choose the option based on visible text
		dropdownState.selectByVisibleText("New York");
		
		//Select Conference in the dropdown
		//1. Identify the dropdrown element (Select tag)
		WebElement eleSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		//2.Create an object for Select class and link with the dropdown element
		Select dropdownSource = new Select(eleSource); //pass the element to the constructor		
		//a) Choose the option based on value
		dropdownSource.selectByValue("LEAD_CONFERENCE");
		//b) Choose the option based on visible text
		//dd.selectByVisibleText("UFT/QTP");
		//c) Choose the option based on index
		//dd.selectByValue("1");		

		//15. Click on Create Button
		driver.findElement(By.name("submitButton")).click();
		
		//Thread.sleep(5000);
		//To get the firstName in the output Log file		
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(firstName);

		//16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
	}
}

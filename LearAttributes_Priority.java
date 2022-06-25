package week5.day2;

import org.testng.annotations.Test;
//default priority value is 0 even if no value is set
//-ve goes to highest priority (-ve to positive=> -2,-1,0,1,2) 

public class LearAttributes_Priority {
	@Test (priority=-2, enabled=false) //this test will not be executed even high priority
	public void createLead() {
		System.out.println("Create Lead");
	}
	
	@Test(priority=-1)
	public void editLead() {
		System.out.println("Edit Lead");
	}

	@Test(priority=2)
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
	
	@Test(priority=1)
	public void duplicateLead() {
		System.out.println("Duplicate Lead");
	}
}

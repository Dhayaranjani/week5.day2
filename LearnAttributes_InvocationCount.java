package week5.day2;

import org.testng.annotations.Test;
//If you want a testcase to run multiple times then use invocationCount
//It see's the enabled first, priority 2nd and third comes invocationCount = 5

public class LearnAttributes_InvocationCount {
	@Test(enabled = false)//by default True
	public void createLead() {
		System.out.println("Create Lead");
	}
	
	@Test(priority=-1, invocationCount = 5)
	public void editLead() {
		System.out.println("Edit Lead");
	}

	@Test
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
}

package week5.day2;

import org.testng.annotations.Test;
//Learn Annotation enabled
public class LearnAttributes_Enabled {
	
	@Test(enabled = false)//by default True
	public void createLead() {
		System.out.println("Create Lead");
	}
	
	@Test
	public void editLead() {
		System.out.println("Edit Lead");
	}

	@Test
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
	
}

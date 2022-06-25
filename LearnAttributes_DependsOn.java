package week5.day2;
//Inject a Dependency (dependsOnMethods - high priority)
//now priority goes meaningless
//if from different package then include {"week2.day2.Login.createLead"}
//if multiple method then we can give dependsOnMethods = {"createLead", "deleteLead"}
import org.testng.annotations.Test;

public class LearnAttributes_DependsOn {
	@Test
	public void createLead() {
		System.out.println("Create Lead");
		throw new RuntimeException();
	}
	
	@Test(priority=-1, dependsOnMethods = {"createLead", "duplicateLead"})
	public void editLead() {
		System.out.println("Edit Lead");
	}

	@Test(priority=-2, invocationCount = 5)
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
	
	@Test(priority=1)
	public void duplicateLead() {
		System.out.println("Duplicate Lead");
	}
}


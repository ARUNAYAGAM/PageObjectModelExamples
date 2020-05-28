package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterizationexample {
	
	
	@Test
	@Parameters({"bikename","carname"})
	public void bikename(String bike, String car) {
		
		System.out.println("Name of my bike is: "+bike);
		
		System.out.println("Name of my bike is: "+car);
	}

}

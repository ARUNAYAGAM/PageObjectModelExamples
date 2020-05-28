package TestNG;

import org.testng.annotations.Test;

public class handledependencies {

@Test(enabled=true)
	public void goto_airport() {

		System.out.println("Go to Airport");
	}

@Test(dependsOnMethods="goto_airport")
	public void take_a_flight() {

		System.out.println("Take a flight");

	}

@Test(dependsOnMethods= "take_a_flight")
	public void travelto_india() {

		System.out.println("Travel to India");

	}
}

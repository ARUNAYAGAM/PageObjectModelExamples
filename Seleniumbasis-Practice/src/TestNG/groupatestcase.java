package TestNG;

import org.testng.annotations.Test;

public class groupatestcase {

@Test (groups= {"bike"})
	public void bike1() {
		System.out.println("bike1");

	}

@Test (groups= {"bike"})
	public void bike2() {

		System.out.println("bike2");
	}

@Test (groups= {"car"})

	public void car1() {

		System.out.println("car1");
	}

@Test (groups= {"car"})
	public void car2() {
		
		System.out.println("car2");

	}

@Test (groups= {"bus"})

	public void bus1() {

		System.out.println("bus1");
	}

@Test (groups= {"bus"})
	public void bus2() {
		
		System.out.println("bus2");

	}

}

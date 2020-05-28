package selenium.practise.basis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumBasicCommands {

	WebDriver driver;
	
@Test
public void invokebrowser() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	//Get Command
	driver.get("https://www.flipkart.com/");
	
	System.out.println("Flipkart opened Sucessfully");
	
	//GetTitle Command

	String PageTitle = driver.getTitle();
	
	System.out.println("Title of the Page is: "+PageTitle);
	
	//GetURL Command:
	
	String CurrentURL = driver.getCurrentUrl();
	System.out.println("Current URL of the Page is: "+CurrentURL);
	
	
	/* Get PageSource Command:
	
	String Pagesource = driver.getPageSource();
	System.out.println("Page Source is: "+Pagesource); */
	
	
	//Navigate to
	driver.navigate().to("https://www.youtube.com/watch?v=k2FAPFn7HrQ");
	Thread.sleep(2000);
	
	//Navigate Back
	driver.navigate().back();
	Thread.sleep(1000);
	
	//Navigate forward
	
	driver.navigate().forward();
	
	Thread.sleep(1000);
	
	driver.navigate().back();
	
	//Refresh Command
	driver.navigate().refresh();
	Thread.sleep(1000);
	
	System.out.println("Refresh happened Sucessfully");
	
	//Clear Command
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		Thread.sleep(1000);
		
	//Send key Command
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("apple mobiles");
		Thread.sleep(2000);

	//Click Command
		
		Actions act= new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//button[@class='vh79eN']//*[local-name()='svg']"))).click().build().perform();
			
		System.out.println("Home page is displayed");
		
			
	//GetText Command
		
		String PhoneText = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 11 (White, 128 GB)')]")).getText();
		
		System.out.println("Text of the phone is: "+PhoneText);
		
	//is displayed Command	
   
		boolean display = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 11 (White, 128 GB)')]")).isDisplayed();
		
		System.out.println("Name of the Mobile Phone is displayed: "+display);
		
		System.out.println("All Basic Commands are executed sucessfully");
		
		driver.quit();
	
	
	
	
}
	

}

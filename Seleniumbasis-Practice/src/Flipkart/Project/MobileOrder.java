package Flipkart.Project;

import java.util.ArrayList;
 
import java.util.Set;
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobileOrder {
	
	WebDriver driver;
	
@BeforeTest
public void invokebrowser() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com");
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//a[@class='_3Ep39l']")).click();
      
    driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("9003729038");
  
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("arunayagam!@34");
  
    driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
    
    System.out.println("Login Successfully");
      
   Thread.sleep(2000);
}

@Test
public void mobileorder() throws InterruptedException {
	
    String Parent = driver.getWindowHandle();
	
	System.out.println("Parent Window ID is: "+Parent);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Actions act = new Actions(driver);
	
	act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().build().perform();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[(text()='Home Audio Speakers')]")).click();
	
	System.out.println("Home Page is displayed");
	
	driver.findElement(By.xpath("//a[contains(text(),'F&D 203G 11 W Portable Laptop')]")).click();
	
	System.out.println("Home Audio Speaker is selected");
	
	//Multiple Tabs Handle
	
    Set<String> allwindows = driver.getWindowHandles();
    
    ArrayList<String> tabs = new ArrayList<>(allwindows);
    
	driver.switchTo().window(tabs.get(1));
	
	System.out.println("Title of the Page is: "+driver.getTitle());
	
	
	act.moveToElement(driver.findElement(By.xpath(" //div[@class='_3MF26o SGxMsH']//div[@class='_2_AcLJ']"))).click().build().perform();
	
	System.out.println("Image is clicked");
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	
	System.out.println("Added to Cart");
		
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']")).click();
	
	System.out.println("Submitted Sucessfully");

	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Arun");
	
	//Dropdown selection
	
	WebElement State = driver.findElement(By.xpath("//select[@name='state']"));
		
    Select State_Select = new Select(State);
	
    State_Select.selectByVisibleText("Tamil Nadu");
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("//button[@class='_2AkmmA EqjTfe _7UHT_c']")).click();
    
       
}




	

}

package selenium.practise.basis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class AltersFunctions {
	
	WebDriver driver;
	
@Test
public void Alerts_Manager() throws InterruptedException {
		
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/Register.html");
	
	//Alerts Functionalities Type1
	
	driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Alerts')]")).click();
	
	driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	
	Alert alert = driver.switchTo().alert();
	
	String alertmessage = driver.switchTo().alert().getText();
	
	System.out.println(alertmessage);
	
	Thread.sleep(1000);
	
	alert.accept();
	
	
	 System.out.println("Alert Type1 is executed");
	
	
	//Alert Type 2
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
	
	
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	
	alert.dismiss();
	
	Thread.sleep(1000);
	
	String alertcancel = driver.findElement(By.id("demo")).getText();
	
	System.out.println(alertcancel);
	
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	
	alert.accept();
	
	Thread.sleep(1000);
	
	String alertok = driver.findElement(By.id("demo")).getText();
	
	System.out.println(alertok);
	
	System.out.println("Alert Type2 is executed");

	//Alert Type 3
		
	driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
	
	driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	
	driver.switchTo().alert().sendKeys("Automation Testing");
	
	alert.accept();
	
	Thread.sleep(1000);
	
    String alertprompt = driver.findElement(By.id("demo1")).getText();
	
	System.out.println(alertprompt);
	
	
	System.out.println("Alert Type3 is executed");
	
	
	}

}

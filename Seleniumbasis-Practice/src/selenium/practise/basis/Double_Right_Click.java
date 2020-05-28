package selenium.practise.basis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Double_Right_Click {
	
	WebDriver driver; 
	
	@Test
	public void clicks() throws InterruptedException {
		

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//a[contains(text(),'WebTable')]")).click();
		
		Thread.sleep(1000);
		
		//Right Click
		
		Actions act = new Actions (driver);
		
		act.contextClick(driver.findElement(By.xpath(" //div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-000B')]//i[contains(@class,'fa fa-trash-o')]"))).build().perform();
				
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000B']//button[@class='btn btn-danger btn-xs'][contains(text(),'Delete')]")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
		
		//Double Click
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//a[contains(text(),'WebTable')]")).click();
		
		Thread.sleep(1000);
		
		act.doubleClick(driver.findElement(By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000B']//i[@class='fa fa-pencil']"))).build().perform();
		
		driver.findElement(By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-0009']//div[2]/input")).clear();
		
		driver.findElement(By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-0009']//div[2]/input")).sendKeys("1234567890");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000B']//button[@class='btn btn-danger'][contains(text(),'Cancel')]")).click();
		
		Thread.sleep(1000);
		
		System.out.println("Double click performed successfully");
		
		 	
		
		 
		
		
		
			
	}

}

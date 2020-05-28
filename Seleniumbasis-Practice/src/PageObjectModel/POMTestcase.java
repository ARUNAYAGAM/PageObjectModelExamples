package PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class POMTestcase {
	
	@Test
	public void testcase() throws InterruptedException{
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.ae");
		System.out.println("Website opened sucessfully");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
		System.out.println("Search occured successfully");
		 Thread.sleep(3000);
		driver.findElement(By.className("nav-input")).click();
 		driver.findElement(By.xpath("//*[@id=\"p_85/15602504031\"]/span/a/div/label/i")).click();
		System.out.println("Amzon prime filtered");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,600)");
		driver.findElement(By.xpath("//li[@id='p_n_feature_nine_browse-bin/15412929031']//i[@class='a-icon a-icon-checkbox']")).click();
		System.out.println("Language selected");
		driver.findElement(By.xpath("//span[contains(text(),'The Sheikh CEO - Lessons in Leadership from Mohamm')]")).click();
		System.out.println("Book is selected successfully");
		
		 
	}

}



package selenium.practise.basis;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 

public class TestNGParallaltest {

	WebDriver driver; 
	
	 
	
@Parameters("browsername")	
@BeforeTest	 
public void setup(String browsername) {
		
	System.out.println("Name of the Browser is: "+browsername);
	 if (browsername.equals("chrome")) {
 
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
	 }
		 
	 else if (browsername.equals("firefox") ) {
			System.setProperty("webdriver.gecko.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
		 
	 }
	 
	}

@Test

public void function() throws Exception {
		
	driver.get("https://www.amazon.ae");
	Thread.sleep(3000);
	System.out.println("Website opened sucessfully");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
	System.out.println("Search occured successfully");
	Thread.sleep(3000);
	driver.findElement(By.className("nav-input")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"p_85/15602504031\"]/span/a/div/label/i")).click();
	System.out.println("Amzon prime filtered");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[@id='p_n_feature_nine_browse-bin/15412929031']//i[@class='a-icon a-icon-checkbox']")).click();
	System.out.println("Language selected");
	driver.findElement(By.xpath("//span[contains(text(),'The Sheikh CEO - Lessons in Leadership from Mohamm')]")).click();
	System.out.println("Book Selected");
	
}


@AfterTest

public void close() {
	
	driver.close();
	System.out.println("Browser closed");
	}


}

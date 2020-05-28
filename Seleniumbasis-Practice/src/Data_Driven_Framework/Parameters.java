package Data_Driven_Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
 
import org.testng.annotations.Test;

public class Parameters {
WebDriver driver;

	@Test
	@org.testng.annotations.Parameters({"username","password"})
	 
	public void openbrowser(String uname, String pwd) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		
		driver.findElement(By.id("btnLogin")).click();
		 
		


	}

}

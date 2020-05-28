package PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class POMTestcase_update {
	JavascriptExecutor jse;
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

		Amazonpageobjects.searchbox(driver).sendKeys("books");
		System.out.println("Search occured successfully");
		Thread.sleep(3000);

		Amazonpageobjects.searchbutton(driver).click();

		Amazonpageobjects.amazonfilter(driver).click();
		System.out.println("Amzon prime filtered");
		
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,600)");
		
		Amazonpageobjects.language(driver).click();
		System.out.println("Language selected");
		
		Amazonpageobjects.book(driver).click();
		System.out.println("Book is selected successfully");


	}

}



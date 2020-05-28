package selenium.practise.basis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class Multiple_Frames {
	 WebDriver driver;

	@Test
	public void Frames() throws InterruptedException {
		
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//Single Frame
		
		driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Frames')]")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		
		driver.switchTo().frame(frame);
		
		
		WebElement textbox = driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input[@type='text']"));
		
		textbox.sendKeys("Selenium Testing");
		
		System.out.println("Single Frame is executed");
		
		textbox.clear();
		
		driver.switchTo().defaultContent();
		
		//Iframes within frame
		
		WebElement frame1 = driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]"));
		
		frame1.click();
		
		WebElement Parentframe = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/iframe[1]"));
		
		driver.switchTo().frame(Parentframe);
		
		Thread.sleep(1000);
		
		System.out.println("Parentframe is executed");
		
		WebElement childframe = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/iframe[1]"));
		
		driver.switchTo().frame(childframe);
		
		WebElement childtextbox = driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input[@type='text']"));
		
		childtextbox.sendKeys("Selenium Testing in Child textbox");
				
		Thread.sleep(1000);
		
		System.out.println("Childframe is executed");
		
				
		driver.switchTo().defaultContent();
		
		System.out.println("All Frames executed sucessfully");
		
		
				
				
		
	}
	
	
}

package selenium.practise.basis;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Takesscreenshot {
	
	WebDriver driver;
	
	
	@Test
	public void screenshot() throws InterruptedException, IOException, AWTException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.ae/");
		
		//Take Screenshot using normal method
		
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destinationfile = new File ("G:\\ARUN\\Selenium\\Workspace\\Lesson1-Basis\\Seleniumbasis-Practice\\Screenshots\\Sample.png");
				
		FileHandler.copy(sourcefile, destinationfile);		
		
		Thread.sleep(1000);
		
		 System.out.println("Normal Screenshot is taken succesfully");
		 
		  		 
		 //Take Screenshot using Fileutilis
		 
		 driver.navigate().to("https://www.flipkart.com/");
		 
		 TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		 
		 File sourcefile1 =  screenshot1.getScreenshotAs(OutputType.FILE);
		 
		 File destinationfile1 = new File ("G:\\ARUN\\Selenium\\Workspace\\Lesson1-Basis\\Seleniumbasis-Practice\\Screenshots\\Sample1.png");
		 
		 FileUtils.copyFile(sourcefile1, destinationfile1);
		 
		 Thread.sleep(1000);
		 
		 System.out.println("Screenshot using Fileutilis is taken succssfully");
		 
		 
		 //Take Screenshot using Robot class - Full Screen capture
		 
		 driver.navigate().to("https://www.skyscanner.ae/");
		 
		 Robot robot = new Robot();
		 
		 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		 Rectangle rectangle = new Rectangle(screensize);
		 
		 BufferedImage sourcefile2 =  robot.createScreenCapture(rectangle);	
		 
		 File destinationfile2 =  new File ("G:\\ARUN\\Selenium\\Workspace\\Lesson1-Basis\\Seleniumbasis-Practice\\Screenshots\\Sample2.png");
		 
		 ImageIO.write(sourcefile2,"png", destinationfile2);
		 
		 Thread.sleep(1000); 
		 
		 System.out.println("Screenshot using Robot class is taken succssfully");
		 
		 	}

}

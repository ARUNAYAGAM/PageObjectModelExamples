package selenium.practise.basis;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

@Test
public class Multiple_Windows_Tabs {
	
	WebDriver driver;
	
	public void windows() throws InterruptedException {
			
	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/Register.html");
	
	//Multiple Windows
	
	driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]")).click();
	
	String Parent = driver.getWindowHandle();
	
	System.out.println("Parent window id is: "+Parent);
	
	driver.findElement(By.xpath("//button[@onclick='newwindow()']")).click();
	
	Set<String> allwindows =driver.getWindowHandles();
	
	int count = allwindows.size();
	
	System.out.println("Total size of the Window is: "+count);
			
	for(String child:allwindows) {
	
	if(!Parent.equalsIgnoreCase(child)) {
		
		driver.switchTo().window(child);
		
		System.out.println("Title of the Window is: "+driver.getTitle());
		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[@class='active'][contains(text(),'Home')]")).click();
		
		Thread.sleep(2000);
		
		driver.close();
	}
			
	}

	driver.switchTo().window(Parent);
	
	System.out.println("Title of the Parent Window is: "+driver.getTitle());
	
	//Multiple Tabs
	driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();
	
	ArrayList<String> tabs =new ArrayList<>(allwindows);
	
	driver.findElement(By.xpath("//div[@id='Tabbed']//button[@class='btn btn-info'][contains(text(),'click')]")).click();
	
	//driver.switchTo().window(tabs.get(1));
	
	System.out.println("Title of the tab1 is: "+driver.getTitle());
	
	
	driver.switchTo().window(tabs.get(0));
	
	System.out.println("Title of the tab0 is: "+driver.getTitle());
	
	
}

}
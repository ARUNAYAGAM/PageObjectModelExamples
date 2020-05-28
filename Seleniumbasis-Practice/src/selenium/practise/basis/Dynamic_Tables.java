package selenium.practise.basis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class Dynamic_Tables {

	@Test
	public void tables() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/table.html");
		
		List<WebElement> columncount= driver.findElements(By.tagName("th"));
		
		int columnsize = columncount.size();
		
		System.out.println("Total number of columns: "+columnsize);
		
		List<WebElement> rowcount= driver.findElements(By.tagName("tr"));
		
		int rowsize = rowcount.size();
		
		System.out.println("Total number of rows: "+rowsize);
		
		
		WebElement progress = 
	   driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		
		String progresvalue = progress.getText();
		
		System.out.println("Progress Value is: "+progresvalue);
		
		List<WebElement> secondrow= driver.findElements(By.xpath("//td[2]"));
		
		List<Integer> numerlist= new ArrayList<Integer>();
		
		for (WebElement rownumbers : secondrow) {
			
			String individualnumber=rownumbers.getText().replace("%", "");
				
			numerlist.add(Integer.parseInt(individualnumber));
					
		}
		
		System.out.println("Final list is: "+numerlist);
		
		int smallnumber = Collections.min(numerlist);
		
		System.out.println("Minium Value is: "+smallnumber);
		
		
		String smallnumberstring = Integer.toString(smallnumber)+"%";
		
		String finalxpath = "//td[normalize-space()="+"\""+smallnumberstring+"\""+"]"+"//following::td[1]//input";
		
		System.out.println("FinalXpath is: "+finalxpath);
		
		WebElement checkbox = driver.findElement(By.xpath(finalxpath));
		
		checkbox.click();
		
		System.out.println("All tasks has been executed successfully");
				
	}
}

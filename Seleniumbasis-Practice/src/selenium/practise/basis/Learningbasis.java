package selenium.practise.basis;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class Learningbasis {
	
WebDriver driver;
JavascriptExecutor jse;

	public void invokebrowser(){
		
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.ae");
			System.out.println("Website opened sucessfully");
			textsearch();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Website is not opened sucessfully");
			
		}
	}
	
	public void textsearch() {
		
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
			System.out.println("Search occured successfully");
			 Thread.sleep(3000);
			driver.findElement(By.className("nav-input")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"p_85/15602504031\"]/span/a/div/label/i")).click();
			System.out.println("Amzon prime filtered");
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,600)");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/span/div/div[6]/ul[1]/li[1]/span/a/div/label/i")).click();
			System.out.println("Language selected");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/span[4]/div[1]/div[2]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).click();
			
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
			System.out.println("Search not occured sucessfully");
		}
	}
	
	public static void main(String[] args) {
		Learningbasis myobj1 = new Learningbasis();
		myobj1.invokebrowser();

	}

}

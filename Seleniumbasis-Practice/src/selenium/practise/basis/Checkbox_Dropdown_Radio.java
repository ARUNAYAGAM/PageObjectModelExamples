package selenium.practise.basis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Checkbox_Dropdown_Radio {

	 WebDriver driver;
@Test	 
	public void boxes() throws InterruptedException {

	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/Register.html");
	
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Selenium");
	
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Testing");
	
	driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid-email ng-invalid ng-invalid-required']")).sendKeys("123@tet.com");
	
	driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required ng-valid-pattern']")).sendKeys("1234567890");
	
	
	//Radio Button
	
	boolean Radiodefault = driver.findElement(By.xpath("//label[1]//input[1]")).isSelected();
	
	System.out.println("Default selection of the Radio button is: "+Radiodefault);
	
	driver.findElement(By.xpath("//label[1]//input[1]")).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//label[2]//input[1]")).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//label[1]//input[1]")).click();
	
	Thread.sleep(1000);
	
	boolean Radioselected = driver.findElement(By.xpath("//label[1]//input[1]")).isSelected();
	
	System.out.println("After selection of the Radio button is: "+Radioselected);
	
	 	
	//Checkbox
	
   boolean Checkboxdefault = driver.findElement(By.xpath("//input[@id='checkbox1']")).isSelected();
	
	System.out.println("Default selection of the Checkbox is: "+Checkboxdefault);
	
	
	driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@id='checkbox3']")).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@id='checkbox3']")).click();
	 
	Thread.sleep(1000);
	
	boolean Checkboxselected = driver.findElement(By.xpath("//input[@id='checkbox1']")).isSelected();
	
	System.out.println("After selection of the Checkbox is: "+Checkboxselected);
	
	//Dropdown box
	
	WebElement Skills = driver.findElement(By.id("Skills"));
	
	Select Skillssel= new Select (Skills);
	
	Skillssel.selectByVisibleText("Software");
	
	 WebElement Selectedskill = Skillssel.getFirstSelectedOption();
	 
	 System.out.println("Selected Skill is: "+Selectedskill.getText());
	 
	 
	WebElement Country = driver.findElement(By.id("countries"));
	
	Select Countrysel = new Select (Country);
	
	Countrysel.selectByVisibleText("India");
	
	WebElement Selectedcountry = Countrysel.getFirstSelectedOption();
	 
	 System.out.println("Selected Skill is: "+Selectedcountry.getText());
	
	 //To Print all the options in drop downbox
	 List<WebElement> Allcountry = Countrysel.getOptions();
	 
	 for(WebElement Countries:Allcountry) {
		 
		 System.out.println("Name of the Countries are: "+Countries.getText());
	 }
		
	 WebElement year = driver.findElement(By.id("yearbox"));
	 
	 Select Yearsel = new Select (year);
	 
	 Yearsel.selectByVisibleText("1994");
	 
	 WebElement Month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		 
	 Select Monthsel = new Select (Month);
	 
	 Monthsel.selectByVisibleText("March");
	 
	 WebElement Day = driver.findElement(By.id("daybox"));
	 
	 Select Daysel = new Select (Day);
	 
	 Daysel.selectByVisibleText("15");
	 
	 driver.findElement(By.id("firstpassword")).sendKeys("Qw12345");
	 
	 driver.findElement(By.id("secondpassword")).sendKeys("Qw12345");
	 	 	 
	 Thread.sleep(1000);
	 
	 driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\MAZHAVIKA\\Downloads\\Test.jpg");
	 
	 Thread.sleep(1000);
	 
	 System.out.println("File uploaded sucessfully");
	 
	 driver.findElement(By.id("submitbtn")).submit();
	 
	 
	}
}

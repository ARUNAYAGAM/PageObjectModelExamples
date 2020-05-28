package selenium.practise.basis;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Drag_Drop_Resize_Actions {
	
	WebDriver driver; 
	
	@Test
	public void Actions() throws InterruptedException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
			 
		Actions act = new Actions (driver);
		
		//Drag and Drop with Target
				
		WebElement drag = driver.findElement(By.id("draggable"));
		
	 	WebElement drop = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(drag, drop).perform();
		
		Thread.sleep(1000);
		  
		System.out.println("Drag and drop is performed");
		 
		/*
		//Drag and Drop without Target
		
		driver.navigate().to("https://jqueryui.com/draggable/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
				
		WebElement drag1 = driver.findElement(By.id("draggable"));
		
		act.dragAndDropBy(drag1, 100, 60).perform();
		
		System.out.println("Drag and drop without target is performed");
		
		
		//Click and Hold
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		WebElement drag2 = driver.findElement(By.id("draggable"));
		
	 	WebElement drop1 = driver.findElement(By.id("droppable"));
		
		act.clickAndHold(drag2).moveToElement(drop1).release(drop1).build().perform();
		
		System.out.println("Click and Hold function is performed");
		
		
		//	Resizable	
		
		driver.navigate().to("https://jqueryui.com/resizable/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		WebElement Resize = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		
		act.clickAndHold(Resize).moveByOffset(100, 60).release(Resize).build().perform();
		
		System.out.println("Resize function is performed");
		
		//Slider
		
		driver.navigate().to("https://jqueryui.com/slider/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]"));
		
		act.clickAndHold(slider).moveByOffset(60, 0).release(slider).build().perform();
		
		act.clickAndHold(slider).moveByOffset(-30, 0).release(slider).build().perform();
		
		System.out.println("Slider function is performed");
		
		//Selectable
		
		driver.navigate().to("https://jqueryui.com/selectable/#default");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"))).perform();
		
		Thread.sleep(1000);
		
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"))).perform();
		
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"))).perform();
		
		act.keyUp(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"))).perform();
		
		Thread.sleep(1000);
		 
		System.out.println("Multi Selectable function is performed");
		 
		 
		//Sortable 
		
		driver.navigate().to("https://jqueryui.com/sortable/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		List<WebElement> sortele = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		
		int total= sortele.size();
		
		System.out.println("Total Elements in the list is: "+total);
		
		WebElement fromelement = sortele.get(1);
		
		WebElement toelement = sortele.get(5);
		
		act.clickAndHold(fromelement).moveToElement(toelement).release(toelement).build().perform();
		
		Thread.sleep(1000);
		
		System.out.println("Sortable function is performed");
		
		 //Autocomplete 
		
		driver.navigate().to("https://jqueryui.com/autocomplete/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("tags")).sendKeys("J");
		
		Thread.sleep(1000);
		
		List<WebElement> options =driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		
		System.out.println("Count of the options is: "+options.size());
		
		for (WebElement sel : options) {
			
			if(sel.getText().equals("Java")) {
				
				System.out.println("Selected autocomplete option is: "+sel.getText());
				sel.click();
				break;
		}
		
		}
		
		System.out.println("Autocomplete Actions is performed"); 
		

		//Calender 
		
		driver.navigate().to("https://jqueryui.com/datepicker/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		WebElement datebox = driver.findElement(By.id("datepicker"));
		
		datebox.click();
		
		WebElement month= driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		
		month.click();
		
		WebElement month1= driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		month1.click();
		
		WebElement date =driver.findElement(By.xpath("//a[contains(text(),'14')]"));
		
		date.click();
		
		System.out.println("Calender Function is executed successfully");
		
		Thread.sleep(1000);
		
		//Another Type of Calender
		
		driver.navigate().to("https://jqueryui.com/datepicker/#date-range");
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
				
		Thread.sleep(2000);
		
		WebElement from= driver.findElement(By.xpath("//*[@id='from']"));
		
		from.click();
				 
		Select frommonth = new Select (driver.findElement(By.className("ui-datepicker-month")));
		
		frommonth.selectByVisibleText("Jul");
		
		WebElement fromdate =driver.findElement(By.xpath("//a[contains(text(),'14')]"));
		
		fromdate.click();
		
		System.out.println("Calender1 function is executed successfully");
		
		//Tooltip 
		
		driver.navigate().to("https://jqueryui.com/tooltip/");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		
		WebElement Tooltip = driver.findElement(By.id("age"));
		
		System.out.println("Tooltip is: "+Tooltip.getAttribute("title"));
		
		WebElement check = driver.findElement(By.xpath("//a[contains(text(),'ThemeRoller')]"));
	
		 act.moveToElement(check);
		 
		 System.out.println("Tooltip in the link: "+check.getAttribute("title"));
		 
		 System.out.println("Tooltip function is executed successfully");
		 
		 //Download and check the file  
		 
		driver.navigate().to("http://demo.automationtesting.in/FileDownload.html");
			
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
		File Downloadfile = new File ("C:\\Users\\MAZHAVIKA\\Downloads");
		
		Thread.sleep(1000);
		 
		File[] Totalfiles= Downloadfile.listFiles();
		
		for (File file : Totalfiles) {
			
			if(file.getName().equals("samplefile.pdf")) {
				
				System.out.println("File is downloaded");
				break;
			} 
			
		}
		
		System.out.println("Download and check the file function is executed successfully");
		 
		 //Broken Image */
		
		driver.navigate().to("http://the-internet.herokuapp.com/broken_images");
		
		Thread.sleep(1000);
		
		 List<WebElement> images=driver.findElements(By.xpath("//div[@class='example']/img"));
		 
		 int Totalimages = images.size();
		 
		 System.out.println("Total size of the image is: "+Totalimages);
		 
		for (WebElement webElement : images) {

			if (webElement.getAttribute("naturalWidth").equals("0")) {
				System.out.println("Images are broken");
				break;
			}

		}

		 System.out.println("Broken Image function is executed successfully");
		 
	}
	
}

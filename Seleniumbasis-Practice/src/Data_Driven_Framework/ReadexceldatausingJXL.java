package Data_Driven_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadexceldatausingJXL {
	WebDriver driver;

	String [] [] data= null;
	 

	@DataProvider(name="credentials")
	public String[][] logindata() throws BiffException, IOException {

		System.out.println("Started reading excel");
		data = readexcel();
		return data; 
	} 
	
	
	public String[][] readexcel() throws BiffException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\MAZHAVIKA\\Desktop\\CredentialsTest.xls");
		
		System.out.println("Excel opened");
		
		Workbook wb = Workbook.getWorkbook(file);
		
		Sheet sh = wb.getSheet(0);
		
		int rowcount = sh.getRows();	
		
		int columncount = sh.getColumns();
		
		System.out.println("Total number of rows: "+rowcount);
		
		System.out.println("Total number of columns: "+columncount);
	
	
		String testdata [][] = new String [rowcount-1][columncount];
		
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {
				
				testdata[i-1][j] =sh.getCell(j, i).getContents();
			}
		}
		
		System.out.println("Data returned");
	return testdata;
		 
	}
	
	
@BeforeTest
	public void openbrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		System.out.println("Browser opened successflly");
	}

	@Test(dataProvider = "credentials")
	public void function(String uname, String pwd) {
 		

		driver.findElement(By.id("txtUsername")).sendKeys(uname);

		driver.findElement(By.id("txtPassword")).sendKeys(pwd);

		driver.findElement(By.id("btnLogin")).click();




	}

}

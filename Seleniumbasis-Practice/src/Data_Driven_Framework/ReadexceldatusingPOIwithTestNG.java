package Data_Driven_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class ReadexceldatusingPOIwithTestNG {

	WebDriver driver;

	String [][] data= null;

	@DataProvider(name="credentials")
	public String[][] logindata() throws BiffException, IOException {

		System.out.println("Started reading excel");
		data = readexcel();
		return data; 
	} 



	public String[][] readexcel() throws IOException {

		FileInputStream fis = new FileInputStream ("C:\\\\Users\\\\MAZHAVIKA\\\\Desktop\\\\Credentials.xlsx");

		Workbook wb = new XSSFWorkbook(fis);

		Sheet sh = wb.getSheetAt(0);

		int rowcount = sh.getLastRowNum();

		int columncount = sh.getRow(0).getLastCellNum();

		System.out.println("Row count is:"+rowcount);

		System.out.println(columncount);

		String testdata [][] = new String[rowcount][columncount];

		System.out.println("Empty Array created");

		for (int i=1;i<=rowcount;i++) {

			for (int j=0;j<columncount;j++) {


				testdata[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}

		}
		
		/*testdata[0][0] = sh.getRow(1).getCell(0).getStringCellValue();
		
		testdata[0][1] = sh.getRow(1).getCell(1).getStringCellValue();
		
		testdata[1][0] = sh.getRow(2).getCell(0).getStringCellValue();
		
		testdata[1][1] = sh.getRow(2).getCell(1).getStringCellValue();		
		
		testdata[2][0] = sh.getRow(3).getCell(0).getStringCellValue();
		
		testdata[2][1] = sh.getRow(3).getCell(1).getStringCellValue();	 
		
		testdata[3][0] = sh.getRow(4).getCell(0).getStringCellValue();
		
		testdata[3][1] = sh.getRow(4).getCell(1).getStringCellValue();	
		
		testdata[4][0] = sh.getRow(5).getCell(0).getStringCellValue();
		
		testdata[4][1] = sh.getRow(5).getCell(1).getStringCellValue();	*/
				
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
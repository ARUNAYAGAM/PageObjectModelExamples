package Data_Driven_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ReadexceldatusingPOI {

	static ArrayList<String> usernameList = new ArrayList<String>();
 
	static ArrayList<String> passwordList = new ArrayList<String>();

	public void readexcel() throws IOException {


		FileInputStream file = new FileInputStream("C:\\Users\\MAZHAVIKA\\Desktop\\Credentials.xlsx");

		Workbook wb = new XSSFWorkbook(file);

		Sheet sheet = wb.getSheetAt(0);

		Iterator<Row> rowiterator= sheet.iterator();

		//To Skip first row - Heading

		rowiterator.next();

		while(rowiterator.hasNext()) {

			Row rowvalue= rowiterator.next();

			Iterator<Cell> columniterator = rowvalue.iterator();

			int i = 2;
			while(columniterator.hasNext()) {

				if(i%2==0) {
				usernameList.add(columniterator.next().toString());
 
				}else {
					passwordList.add(columniterator.next().toString());
					 
				}
			i++;	 
			}

		}
	}

	public void executetest() {
		
		for(int i=0;i<usernameList.size();i++) {
			
			login(usernameList.get(i),passwordList.get(i));
		}
		
	}
	
	public void login(String uname,String pwd) {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.driver", "G:\\ARUN\\Selenium\\Softwares\\Webdrivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		System.out.println("Browser opened successflly");
		
		driver.findElement(By.id("txtUsername")).sendKeys(uname);

		driver.findElement(By.id("txtPassword")).sendKeys(pwd);

		driver.findElement(By.id("btnLogin")).click();
	}

	public static void main(String[] args) throws IOException {

		ReadexceldatusingPOI POI = new ReadexceldatusingPOI();

		POI.readexcel();
		
		System.out.println("Username are: "+usernameList);
		
		System.out.println("Passwordname are: "+passwordList);
		
		POI.executetest();
	}

}

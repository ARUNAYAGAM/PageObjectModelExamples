package Data_Driven_Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedatatoexcel {



	public void writeexcel() throws IOException {

		FileInputStream fis = new FileInputStream ("C:\\\\Users\\\\MAZHAVIKA\\\\Desktop\\\\Credentials.xlsx");

		Row row= null;
		
		Cell cell = null;

		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheetAt(0);	
		
		int rowcount = sh.getLastRowNum();

		row = sh.getRow(0);

		int columncount = sh.getRow(0).getLastCellNum();
		
		System.out.println("Column number is: "+columncount);

		int colNum = -1;

		for(int i =0;i<columncount;i++) {

			if(row.getCell(i).getStringCellValue().trim().equals("Result")) {

				colNum = i;
				
				System.out.println("Value of i is: "+colNum);
			}

		}
		
		
		for(int j= 1;j<=rowcount;j++) {
			
			sh.getRow(j).createCell(colNum).setCellValue("PASS");
		}

		/* row = sh.getRow(1);
		 		 	 
		 cell = row.createCell(colNum);
		  
		 cell.setCellValue("PASS");
		*/ 
		
		 System.out.println("Data updated successfully");
		 		 
		 FileOutputStream fos = new FileOutputStream ("C:\\\\Users\\\\MAZHAVIKA\\\\Desktop\\\\Credentials.xlsx");
		 		 
		 wb.write(fos);
		 
		 fos.close();

	}



	public static void main(String[] args) throws IOException {
		
		Writedatatoexcel write = new Writedatatoexcel();
		
		write.writeexcel();
		


	}

}

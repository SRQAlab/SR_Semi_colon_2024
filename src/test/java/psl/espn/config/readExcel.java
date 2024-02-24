/**
 * 
 */
package psl.espn.config;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Swanand
 *
 */
public class readExcel {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
			  // Specify the path of file
			  File src=new File(System.getProperty("user.dir") +"\\src\\test\\resources\\Excel_Operations.xlsx");
			 
			   // load file
			   FileInputStream fis=new FileInputStream(src);
			 
			   // Load workbook
			   XSSFWorkbook wb=new XSSFWorkbook(fis);
			   
			   // Load sheet- Here we are loading first sheetonly
			      XSSFSheet sh1= wb.getSheetAt(0);
			 
			  // getRow() specify which row we want to read.			 
			  // and getCell() specify which column to read.
			  // getStringCellValue() specify that we are reading String data.
			      
			 System.out.println(sh1.getRow(0).getCell(0).getNumericCellValue());
					 
			 System.out.println(sh1.getRow(1).getCell(0).getNumericCellValue());
			 
			 System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
			 
			 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());

		 	}
		 	catch (Exception e) {
			 
			   System.out.println(e.getMessage());
			 
			  }
	}

}
	

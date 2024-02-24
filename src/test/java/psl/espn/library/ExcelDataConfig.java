package psl.espn.library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public  ExcelDataConfig(String excelpath)
	{
	try {
		// Specify the path of file
		File src = new File(excelpath);

		// load file
		FileInputStream fis = new FileInputStream(src);

		// Load workbook
		wb = new XSSFWorkbook(fis);

		// Load sheet- Here we are loading first sheetonly
		//sheet1 = wb.getSheetAt(0);

	}
	catch(Exception e){
		e.getMessage();
	}
	
	}
	
	public String getData(int sheetNumber, int row, int column)
	{
		
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue().toString();
		
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row+1;
		return row;
	}
}

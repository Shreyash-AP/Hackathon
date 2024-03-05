package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	
	public static void write(String sheetName, int rownum, int colnum, String data)throws IOException {
		//Opening the excel file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\write.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(file); 

		//Creating the sheet if it does not exist
		if(book.getSheetIndex(sheetName)==-1) {
			book.createSheet(sheetName);              
		}
		XSSFSheet sheet=book.getSheet(sheetName);
		if(sheet.getRow(rownum)==null)
		{
			sheet.createRow(rownum);
		}
		XSSFRow row =sheet.getRow(rownum);   
		// Creating cell
		XSSFCell cell=row.createCell(colnum); 
		//Setting the data in the column
		cell.setCellValue(data); 
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\write.xlsx");
		book.write(fo);
		book.close();
		file.close();
		fo.close(); 
	}
	
	public static String[] read(){
		String[] str=new String[5];
		try {
		String path=System.getProperty("user.dir")+"\\testData\\read.xlsx";
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook book=new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		for(int i=0;i<5;i++) {
			DataFormatter formatter = new DataFormatter();
			XSSFCell cell = row.getCell(i);
			str[i]=formatter.formatCellValue(cell);
		}
		file.close();
		book.close();
		}catch(Exception e) {
		}
		return str;
	}
 


}

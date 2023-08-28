package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromeExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//step1: Convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/testdataexcel.xlsx");
		
		//step2: open workbook
		Workbook workbook= WorkbookFactory.create(fis);
		
		//step3: Get control over sheet
		Sheet sheet=workbook.getSheet("Sheet1");
		
		//step4: Get control over Row
		Row row=sheet.getRow(0);
		Row row1=sheet.getRow(1);
		Row row3=sheet.getRow(2);
		Row row2=sheet.getRow(3);
		
		//step5: Get control over cell
		Cell cell=row.getCell(1);
		Cell cell1=row1.getCell(1);
		Cell cell2=row2.getCell(1);
		Cell cell3=row3.getCell(1);
		
		//step6: fetch data
		System.out.println(cell.getStringCellValue());
		System.out.println(cell1.getStringCellValue());
		System.out.println(cell3.getStringCellValue());
		System.out.println(cell2.getNumericCellValue());
		
		//step7: close workbook
		workbook.close();
		
	}
}

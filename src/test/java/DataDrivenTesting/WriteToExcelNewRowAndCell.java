package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelNewRowAndCell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1: Convert physical file into java readable object
				FileInputStream fis=new FileInputStream("./src/test/resources/testdataexcel.xlsx");
				
				//step2: open workbook
				Workbook workbook= WorkbookFactory.create(fis);
				
				//step3: Get control over sheet
				Sheet sheet=workbook.getSheet("Sheet1");
				
				//step4: Create new row
				Row row=sheet.createRow(4);
				
				//step5: Create new Cell
				Cell cell=row.createCell(0);
				
				//step6: set data into excel
				cell.setCellValue("username2");
				
				//step7: save data to excel
				FileOutputStream fos=new FileOutputStream("./src/test/resources/testdataexcel.xlsx");
				workbook.write(fos);
				
				//step8: close workbook
				workbook.close();

	}

}

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

public class WriteIntoExcelNewCell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
FileInputStream fis=new FileInputStream("./src/test/resources/testdataexcel.xlsx");

Workbook workbook=WorkbookFactory.create(fis);

Sheet sheet=workbook.getSheet("Sheet1");

Row row=sheet.getRow(4);

Cell cell=row.createCell(1);

cell.setCellValue("trainee");

FileOutputStream fos=new FileOutputStream("./src/test/resources/testdataexcel.xlsx");
workbook.write(fos);

workbook.close();

	}

}

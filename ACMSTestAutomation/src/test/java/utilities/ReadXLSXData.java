package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSXData {

	@DataProvider(name="tdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream inp = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sht = wb.getSheet(excelSheetName);

		int totalRows = sht.getLastRowNum();
//		System.out.println(totalRows);
		Row rowCells = sht.getRow(0);
		int totalCols = rowCells.getLastCellNum();
//		System.out.println(totalCols);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sht.getRow(i).getCell(j));
//				System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}

}

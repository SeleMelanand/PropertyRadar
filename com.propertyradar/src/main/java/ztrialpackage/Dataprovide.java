package ztrialpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataprovide {

	public static Object[][] getSheet() throws IOException {

		Object[][] data = null;

		FileInputStream fis = new FileInputStream(new File("./testdata/sampledata.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// get the number of rows
		int rowCount = sheet.getLastRowNum();

		// get the number of columns
		int columnCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];
		// loop through the rows
		for (int i = 1; i < rowCount + 1; i++) {

			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) { // loop through the
													// columns

				String cellValue = row.getCell(j).getStringCellValue();

				data[i - 1][j] = cellValue; // add to the data array
			}
		}

		fis.close();

		return data;

	}
}

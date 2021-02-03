package raghvendra.TestNG.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Work2 {
	
	@Test
	public static String[][] dataLogin1(String filename ,String Sheetname) throws IOException {
		/*String filename = "data.xlsx";
		String Sheetname = "Sheet1";*/
		String filepath = "C:\\Java Selenium\\Oct22\\SeleniumTechnoOct2020\\Raghv_testData\\" + filename;
		File file = new File(filepath);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputstream);
		/*
		 * if(filename.contains(".xlsx")) wb=new HSSFWorkbook(); else wb=new
		 * XSSFWorkbook();
		 */
		/*
		 * wb.getSheet("Sheet1"); wb.getSheetAt(1);
		 */
		Sheet sheet = wb.getSheet(Sheetname);
		int totalRows = sheet.getLastRowNum();
		int totalcolumn = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[totalRows][totalcolumn];
		for (int rows = 1; rows <= totalRows; rows++) {
			for (int col = 0; col < totalcolumn; col++) {
				Cell cell = sheet.getRow(rows).getCell(col);
				if (cell.getCellType() == CellType.NUMERIC)
					data[rows - 1][col] = String.valueOf((int) cell.getNumericCellValue());
				else if (cell.getCellType() == CellType.BOOLEAN)
					data[rows - 1][col] = String.valueOf(cell.getBooleanCellValue());
				else if (cell.getCellType() == CellType.STRING)
					data[rows - 1][col] = cell.getStringCellValue();
				else if (cell.getCellType() == CellType.BLANK)
					data[rows - 1][col] = "";
				System.out.println(data[rows - 1][col]);

			}

		}
		System.out.println(data);
		return data;
}
	
}

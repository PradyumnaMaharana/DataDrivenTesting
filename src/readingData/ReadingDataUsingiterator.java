package readingData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataUsingiterator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String excelpath = "./Resources\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Getting sheet using index
		// XSSFSheet sheet = workbook.getSheetAt(0);
		// Getting sheet using sheetname
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		System.out.println("No. of rows : " + rows + " and no. of columns : " + cols);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			XSSFRow row = (XSSFRow) it.next();
			Iterator<Cell> cit = row.cellIterator();
			while (cit.hasNext()) {
				XSSFCell cell = (XSSFCell) cit.next();
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		fis.close();
		workbook.close();
	}
}

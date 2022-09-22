package excelOperations;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromPwdProtected {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String excelpath = "./Resources\\customers.xlsx";
		String password="test123";
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(fis, password);
		// Getting sheet using index
		// XSSFSheet sheet = workbook.getSheetAt(0);
		// Getting sheet using sheetname
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Using loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		//Using iterator
		/*Iterator<Row> it = sheet.iterator();
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
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}*/
		workbook.close();
		fis.close();
	}

}

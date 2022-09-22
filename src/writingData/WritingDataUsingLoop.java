package writingData;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataUsingLoop {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("EMP Info");
		Object empdata[][] = { { "EmpID", "Name", "Job" }, { "101", "Ram", "Doctor" }, { "102", "Sita", "Engineer" },
				{ "103", "Ajay", "Teacher" } };
		int rows = empdata.length;
		int cols = empdata[0].length;
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = empdata[r][c];
				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}
			}
		}
		String filepath = ".\\Resources\\abc.xlsx";
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		workbook.close();
		fos.close();
		System.out.println("...DONE...");
	}
}

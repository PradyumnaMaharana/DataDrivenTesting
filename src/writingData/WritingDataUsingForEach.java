package writingData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataUsingForEach {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("EMP Info");
		ArrayList<Object[]> empdata = new ArrayList<Object[]>();
		empdata.add(new Object[] { "EmpID", "Name", "Job" });
		empdata.add(new Object[] { "101", "Ajay", "Teacher" });
		empdata.add(new Object[] { "102", "Abhay", "Doctor" });
		empdata.add(new Object[] { "103", "Rama", "Engineer" });
		int rowCount = 0;
		for (Object[] emp : empdata) {
			XSSFRow row = sheet.createRow(rowCount++);
			int colCount = 0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(colCount++);
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
		String filepath = ".\\Resources\\def.xlsx";
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		workbook.close();
		fos.close();
		System.out.println("...DONE...");
	}
}

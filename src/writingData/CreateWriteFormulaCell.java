package writingData;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWriteFormulaCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Numbers");
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		row.createCell(3).setCellFormula("A1*B1*C1");
		String filepath = "./Resources\\ghi.xlsx";
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}

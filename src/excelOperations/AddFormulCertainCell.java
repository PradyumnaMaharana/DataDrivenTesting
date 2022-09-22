package excelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddFormulCertainCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String excelpath = "./Resources\\Book3.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.getRow(4).getCell(2).setCellFormula("SUM(C2:C4)");
		fis.close();
		FileOutputStream fos = new FileOutputStream(excelpath);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}

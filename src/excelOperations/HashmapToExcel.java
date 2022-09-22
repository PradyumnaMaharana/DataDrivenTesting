package excelOperations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashmapToExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Student Data");
		Map<String,String> data=new HashMap<String,String>();
		data.put("101", "John");
		data.put("102", "Ray");
		data.put("103", "Hailey");
		data.put("104", "Mark");
		data.put("105", "Smith");
		int rowno=0;
		for(Entry<String, String> entry:data.entrySet()) {
			XSSFRow row=sheet.createRow(rowno++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());
		}
		FileOutputStream fos=new FileOutputStream("./Resources\\student.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
}

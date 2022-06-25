package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_DynamicFile {
	
	public static String[][] readData(String fileName) throws IOException {
		//Step: 1 Setup the path for the workbook
		//Create an object for the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./TestngData/"+ fileName +".xlsx");
		
		//Step: 2 Get into the respective sheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		//wb.getSheet(0);
		
		//To get the rowCount
		int rowCount = ws.getLastRowNum();//it excludes header
		//System.out.println(rowCount);
		
		//To get the column count
		int cellCount  = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];
		
		//To get no.of rows (exclude header) from a single column
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j<cellCount; j++) {
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
		//Close the excel workbook
		wb.close();
		
		return data;
	}

}

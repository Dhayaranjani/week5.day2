package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//Read the values from excel file and print
//Execute here.
public class ClassAct2_ReadExcel {

	public static void main(String[] args) throws IOException {
		//Step: 1 Setup the path for the workbook
		//Create an object for the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./TestngData/CreateLead.xlsx");
		
		//Step: 2 Get into the respective sheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		//wb.getSheet(0);
		
		//To get the rowCount
		int rowCount = ws.getLastRowNum();//it excludes header
		//System.out.println(rowCount);
		
		//To get the column count
		int cellCount  = ws.getRow(0).getLastCellNum();
		
		//To get no.of rows (exclude header) from a single column
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j<cellCount; j++) {
				String data = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
		
		//Close the excel workbook
		wb.close();

	}

}

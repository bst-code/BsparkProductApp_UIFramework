package common;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	public String testID =null;
	public String testName =null;
	public String testDescription =null;
	public String testData =null;
	public String sheetName = null;
	
	public ExcelConfig(String sh) 
	{
		this.sheetName = sh;
	}

	public void getData(String expectedTestID) throws Exception 
	{
		File file = new File("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);

		for(int i = 1; i<= sh.getLastRowNum();i++)
		{
			testID = sh.getRow(i).getCell(0).getStringCellValue();
			if(testID.equals(expectedTestID))
			{
				testName = sh.getRow(i).getCell(1).getStringCellValue();
				testDescription = sh.getRow(i).getCell(2).getStringCellValue();
				testData = sh.getRow(i).getCell(3).getStringCellValue();
				break;
			}
		}
		
		ExtentReport.setTestCaseName(testName, testDescription);
		//testData = "UserName=admin,Password=admin,expectedText=product-management"
		splitDataAndStoreInMap(testData);

	}
	
	
	public void splitDataAndStoreInMap(String data) 
	{
		//"UserName=admin,Password=admin,expectedText=product-management"
		
		for(int i =0; i<data.split(",").length ;i++)
		{
			String keyValue = data.split(",")[i]; //UserName=admin
			String key = keyValue.split("=")[0];  //UserName
			String value = keyValue.split("=")[1]; //admin
			SeleniumGenerics.hmap.put(key, value);
		}
		PrintUtills.logMsg("Testdata :: "+ SeleniumGenerics.hmap.entrySet());
	}


}

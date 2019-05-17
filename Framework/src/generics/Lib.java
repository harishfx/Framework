package generics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Lib implements IAutoConstant
{
	public static Workbook wb;
	
	public static String getCellValue(String sheetname, int rowNum, int colNum)
	{
		String cellValue="";
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue = wb.getSheet(sheetname).getRow(rowNum).getCell(colNum).toString();
			
		} 
		catch (Exception e) 
		{
			
		} 
		return cellValue;
	}
	
	public static String getPropertyValue(String propertyName)
	{
		String propertyValue="";
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue = prop.getProperty(propertyName);
		}
		catch (Exception e) 
		{
			
		} 
		return propertyValue;
		
	}
	
	public static int getRowCount(String sheetname)
	{
		int rowCount=0;
		
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount= wb.getSheet(sheetname).getLastRowNum();
		} 
		catch (Exception e) 
		{
			
		} 
		
		return rowCount;
	}
	
	public static void captureScreenshot(WebDriver driver,String testMethod)
	{
		
		try 
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			Date date=new Date();
			String currentDateAndTime=date.toString().replaceAll(":", "_");
			File destFile=new File(SCREENSHOTS+testMethod+"_"+currentDateAndTime+".png");
			Files.copy(srcFile, destFile);
		} 
		catch (Exception e) 
		{
			
		}
		
		
	}

}

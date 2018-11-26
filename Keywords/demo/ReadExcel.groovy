package demo

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import java.io.FileInputStream
import java.io.FileOutputStream
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy

public class ReadExcel {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static MissingCellPolicy xRow;

	@Keyword
	def setExcelFile(String Path,String SheetName)throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}
	
	@Keyword
	def getCellData(int RowNum, int ColNum) throws Exception{
		
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			switch(Cell.getCellType()){
			case Cell.CELL_TYPE_STRING:
				String CellData = Cell.getStringCellValue();
				return CellData;
				break;		
			case Cell.CELL_TYPE_NUMERIC:
				int CellData = Cell.getNumericCellValue();
				return CellData;	
		}
	}
	
	@Keyword
	def getRowCount(String SheetName){
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number=ExcelWSheet.getLastRowNum()+1;
		return number;
	}
	@Keyword
	def getColumnCount(String SheetName, int RowNum){
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		Row  = ExcelWSheet.getRow(RowNum);
		int number = Row.getLastCellNum();
		return number;
	}
}

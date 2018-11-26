import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.testng.Assert as Assert

String downloadPath = 'C:\\Users\\longnguyen\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.xlsx'
String sheetname = 'Sheet1'
int total_excel_row,excel_column
String Name,Position,Office,StartDate,Salary,Age

WebUI.openBrowser('')

WebUI.navigateToUrl('file:///E:/WORK/PassPulFramework/PassPul/PassPul/SeleniumEasy/www.seleniumeasy.com/test/table-data-download-demo.html')

WebUI.maximizeWindow()

WebUI.delay(1)

WebUI.click(findTestObject('Demo/Upload_Download/a_Excel'))
WebUI.delay(2)

CustomKeywords.'demo.ReadExcel.setExcelFile'(downloadPath, sheetname)
total_excel_row = CustomKeywords.'demo.ReadExcel.getRowCount'(sheetname)
println(total_excel_row)
for (int row = 1; row < total_excel_row; row++) {
	excel_column = CustomKeywords.'demo.ReadExcel.getColumnCount'(sheetname,row)
	println(excel_column)
	int column = 0
	     Name = CustomKeywords.'demo.ReadExcel.getCellData'(row, 0)
	     Position = CustomKeywords.'demo.ReadExcel.getCellData'(row,  1)
	     Office = CustomKeywords.'demo.ReadExcel.getCellData'(row,  2)
	     Age = CustomKeywords.'demo.ReadExcel.getCellData'(row, 3)
	     StartDate = CustomKeywords.'demo.ReadExcel.getCellData'(row, 4)
	     Salary = CustomKeywords.'demo.ReadExcel.getCellData'(row, 5)
	     println(Name + " " + Position + " " + Office + " " + Age + " " + StartDate + " " + Salary)
		 WebUI.verifyMatch(Name, findTestData('Demo/Data_Table').getValue(column + 1, row), false, FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.verifyMatch(Position, findTestData('Demo/Data_Table').getValue(column + 2, row), false, FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.verifyMatch(Office, findTestData('Demo/Data_Table').getValue(column + 3, row), false, FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.verifyMatch(Age, findTestData('Demo/Data_Table').getValue(column + 4, row), false, FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.verifyMatch(StartDate, findTestData('Demo/Data_Table').getValue(column + 5, row), false, FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.verifyMatch(Salary, findTestData('Demo/Data_Table').getValue(column + 6, row), false, FailureHandling.CONTINUE_ON_FAILURE)
}

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

String downloadPath = 'C:\\Users\\longnguyen\\Downloads'
String filename = 'Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.xlsx'
WebUI.openBrowser('')

WebUI.navigateToUrl('file:///E:/WORK/PassPulFramework/PassPul/PassPul/SeleniumEasy/www.seleniumeasy.com/test/table-data-download-demo.html')

WebUI.maximizeWindow()

WebUI.delay(1)

WebUI.click(findTestObject('Demo/Upload_Download/a_Excel'))

WebUI.delay(2)

Assert.assertTrue(CustomKeywords.'demo.Downloadfile.isFileDownloaded'(downloadPath,filename), 
    'File downloaded in incorrect folder or wrong filename ')


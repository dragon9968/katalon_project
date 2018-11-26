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

try {
	
def response = WS.sendRequest(findTestObject('Demo/Webservices/getWarehouseProductInventoryByItemID'))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 15), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 15))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 16), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 16))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 17), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 17))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 18), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 18))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 19), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 19))

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 20), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 20))
}
catch (Exception e) {
	throw e
}


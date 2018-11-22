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

def response = WS.sendRequest(findTestObject('Demo/Webservices/SOAP_getBankinfo'))

WS.verifyElementText(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 9), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 9))

WS.verifyElementText(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 10), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 10))

WS.verifyElementText(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 11), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 11))

WS.verifyElementText(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 12), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 12))


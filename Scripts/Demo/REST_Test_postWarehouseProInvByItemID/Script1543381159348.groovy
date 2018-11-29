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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder as RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

def response = WS.sendRequest(findTestObject('Demo/Webservices/REST_postWarehouseProductInventoryByItemID'))

JsonSlurper slurper = new JsonSlurper()

Map parsedJson = slurper.parseText(response.getResponseBodyContent())

println(parsedJson)

WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 15), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 15), FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 16), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 16), FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 17), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 17), FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 18), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 18), FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 19), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 19), FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyElementPropertyValue(response, findTestData('Demo/Sample_TC_Text_xlsx').getValue(14, 20), findTestData('Demo/Sample_TC_Text_xlsx').getValue(
        15, 20), FailureHandling.CONTINUE_ON_FAILURE)

'Verify [itemKeyTypeCode] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].itemKeyTypeCode[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 15),FailureHandling.CONTINUE_ON_FAILURE)

'Verify [whseLocTypeCcde] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].whseLocTypeCcde[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 16),FailureHandling.CONTINUE_ON_FAILURE)

'Verify [whseLocNbr] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].whseLocNbr[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 17),FailureHandling.CONTINUE_ON_FAILURE)

'Verify [onHandQty] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].onHandQty[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 18),FailureHandling.CONTINUE_ON_FAILURE)

'Verify [billQty] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].billQty[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 19),FailureHandling.CONTINUE_ON_FAILURE)

'Verify [offsiteQty] value return from WS match with expected value test'
WebUI.verifyEqual(parsedJson.whseProductInventory.whseOnHandQty[0].offsiteQty[1], findTestData('Demo/Sample_TC_Text_xlsx').getValue(
	15, 20),FailureHandling.CONTINUE_ON_FAILURE)


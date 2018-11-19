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

def response = WS.sendRequest(findTestObject('Demo/Webservices/getWarehouseProductInventoryByItemID'))
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].itemKeyTypeCode[1]', 'ITMCD')
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].whseLocTypeCcde[1]', 'W')
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].whseLocNbr[1]', '407')
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].onHandQty[1]', '143')
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].billQty[1]', '143')
WS.verifyElementPropertyValue(response, 'whseProductInventory.whseOnHandQty[0].offsiteQty[1]', '0.0')





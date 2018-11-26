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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/a_Make Appointment'))
WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Username_username'), 'John Doe')
WebUI.delay(1)
WebUI.setEncryptedText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Password_password'), 
    'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/button_Login'))
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/select_Tokyo CURA Healthcare C'), 
    'Seoul CURA Healthcare Center', true)
WebUI.delay(1)
WebUI.check(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Apply for hospital readm'))
WebUI.delay(1)
WebUI.verifyElementChecked(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Apply for hospital readm'), 
    20)
WebUI.delay(1)
WebUI.check(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Medicaid_programs'))
WebUI.delay(1)
WebUI.verifyElementChecked(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Medicaid_programs'), 20)
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/td_28'), '28/11/2018')
WebUI.delay(1)
String datepicker_value = WebUI.getAttribute(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/td_28'), 'value', 
    FailureHandling.CONTINUE_ON_FAILURE)

println(datepicker_value)
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/textarea_Comment_comment'), 'Long test')

WebUI.click(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/button_Book Appointment'))


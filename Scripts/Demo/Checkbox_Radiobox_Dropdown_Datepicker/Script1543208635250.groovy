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

WebUI.callTestCase(findTestCase('Demo/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/select_Tokyo CURA Healthcare C'), 
    facility, true)

String Option_Value = WebUI.getAttribute(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/select_Tokyo CURA Healthcare C'), 
    value, FailureHandling.CONTINUE_ON_FAILURE)

println(Option_Value)

WebUI.delay(1)

WebUI.check(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Apply for hospital readm'))

WebUI.delay(1)

WebUI.verifyElementChecked(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Apply for hospital readm'), 
    20)

String Element_Checked = WebUI.getAttribute(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Apply for hospital readm'), 
    value, FailureHandling.CONTINUE_ON_FAILURE)

println(Element_Checked)

WebUI.delay(1)

WebUI.check(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Medicaid_programs'))

WebUI.delay(1)

WebUI.verifyElementChecked(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Medicaid_programs'), 20)

String Health_Program = WebUI.getAttribute(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/input_Medicaid_programs'), 
    value, FailureHandling.CONTINUE_ON_FAILURE)

println(Health_Program)

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/td_28'), visit_date)

WebUI.delay(1)

String datepicker_value = WebUI.getAttribute(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/td_28'), 
    value, FailureHandling.CONTINUE_ON_FAILURE)

println(datepicker_value)

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/textarea_Comment_comment'), comment)

WebUI.click(findTestObject('Object Repository/Demo/Checkbox_Radiobox_Dropdown_Datepicker/button_Book Appointment'))

WebUI.verifyElementText(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/p_Seoul CURA Healthcare Center'), Option_Value, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/p_Yes'), Element_Checked, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/p_Medicaid'), Health_Program, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/div_28112018'), datepicker_value, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Demo/Checkbox_Radiobox_Dropdown_Datepicker/p_Long test'), comment, FailureHandling.CONTINUE_ON_FAILURE)
//String a ="E:\\WORK\\Katalon_CURA Testproject\\Screenshot\\"
//a = WebUI.takeScreenshot('bbbb.jpg')


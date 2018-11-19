import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.lang.Thread as Thread
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.maximizeWindow()

CustomKeywords.'dcm_function.WriteExcel.writeToExcel'(1, 9, GlobalVariable.Test_Step_Pass)

Thread.sleep(2000)

WebUI.setText(findTestObject('DCM/Login_Obj/username'), GlobalVariable.username)

CustomKeywords.'dcm_function.WriteExcel.writeToExcel'(2, 9, GlobalVariable.Test_Step_Pass)

Thread.sleep(1000)

WebUI.setText(findTestObject('DCM/Login_Obj/password'), GlobalVariable.password)

CustomKeywords.'dcm_function.WriteExcel.writeToExcel'(3, 9, GlobalVariable.Test_Step_Pass)

Thread.sleep(1000)

WebUI.click(findTestObject('DCM/Login_Obj/button_Login'))

Thread.sleep(10000)

WebUI.verifyTextPresent(GlobalVariable.check_login_success, false)

CustomKeywords.'dcm_function.WriteExcel.writeToExcel'(5, 9, GlobalVariable.Test_Step_Pass)


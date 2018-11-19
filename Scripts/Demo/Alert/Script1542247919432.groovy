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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

'Go to Alert Demo Screen'
WebUI.navigateToUrl(alert_demo_url)

WebUI.maximizeWindow()

WebUI.delay(1)

'Click on the second [Click me!] button'
WebUI.click(findTestObject('Demo/Alert/button_Click me'))

WebDriver driver = DriverFactory.getWebDriver()

'Get Alert Text'
String AlertText = driver.switchTo().alert().getText()

String Expected_AlertText = 'Press a button!'

'Verify Alert Text'
WebUI.verifyEqual(AlertText, Expected_AlertText)

WebUI.delay(2)

'Click on [OK] from Alert'
WebUI.acceptAlert()

String Expected_Press_Ok = 'You pressed OK!'

'Verify you clicked on [OK]'
WebUI.verifyTextPresent(Expected_Press_Ok, false)

WebUI.delay(1)

'Click on the second [Click me!] button'
WebUI.click(findTestObject('Demo/Alert/button_Click me'))

WebUI.delay(2)

'Click on [Cancel] from Alert'
WebUI.dismissAlert()

String Expected_Press_Cancel = 'You pressed Cancel!'

'Verify you clicked on [Cancel]'
WebUI.verifyTextPresent(Expected_Press_Cancel, false)

WebUI.delay(2)

'Click on [Click for Prompt Box] button'
WebUI.click(findTestObject('Demo/Alert/button_Click for Prompt Box'))

WebUI.delay(1)

'Input text into prompt popup'
driver.switchTo().alert().sendKeys('LongNguyen')

WebUI.delay(2)

WebUI.acceptAlert()

String Expected_Text_Entered = 'You have entered \'LongNguyen\' !'

'Verify inputted text'
WebUI.verifyTextPresent(Expected_Text_Entered, false)

WebUI.delay(1)

WebUI.closeBrowser()


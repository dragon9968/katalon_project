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
import demo.Database as Database
import java.sql.ResultSet as ResultSet
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

'Go to [Simple Form Demo] Screen'
WebUI.navigateToUrl(textbox_url_demo)

WebUI.delay(2)

'Enter message'
WebUI.setText(findTestObject('Object Repository/Demo/Textbox/input_Enter message_user-messa'), message_input)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Demo/Textbox/button_Show Message'))

'Verify the value of textbox with sepcified value'
WebUI.verifyTextPresent(message_input, false, FailureHandling.STOP_ON_FAILURE)

Thread.sleep(2000)

'Connect Database'
WebUI.callTestCase(findTestCase('Demo/ConnectDatabase'), [:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'demo.Database.connectDB'('db4free.net', 'mrvautotestdb', '3306', 'mrvautotestdb', 'mrvautotestdb')
'Query message from database'
ResultSet rs = CustomKeywords.'demo.Database.executeQuery'(query_message_from_db)

String description

while (rs.next()) {
    description = rs.getString(1)

    println(description)
}

CustomKeywords.'demo.Database.closeDatabaseConnection'()

'Verify message input on page with message getting from database'
WebUI.verifyTextPresent(description, false)

WebUI.verifyElementText(findTestObject('Demo/Textbox/message_show'), findTestData('Demo/Static_Content_Table').getValue(
        1, 2))


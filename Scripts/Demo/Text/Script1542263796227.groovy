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

WebUI.openBrowser('')

'Go to [Simple Form Demo] Screen'
WebUI.navigateToUrl(text_demo_url)

WebUI.maximizeWindow()

'Verify text [This would be your first example to start with Selenium.] with specified value'
WebUI.verifyTextPresent(expected_text_show, false)

Thread.sleep(2000)

'Connect Database'
WebUI.callTestCase(findTestCase('Demo/ConnectDatabase'), [:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'demo.Database.connectDB'('db4free.net', 'mrvautotestdb', '3306', 'mrvautotestdb', 'mrvautotestdb')
'Query expected text from database'
ResultSet rs = CustomKeywords.'demo.Database.executeQuery'(query_text_from_db)

String description

while (rs.next()) {
    description = rs.getString(1)

    System.out.println(description)
}

CustomKeywords.'demo.Database.closeDatabaseConnection'()

'Verify text [This would be your first example to start with Selenium.] with result getting from database'
WebUI.verifyTextPresent(description, false)

def response = WS.sendRequest(findTestObject('Demo/Webservices/REST_getUser', [('status') : 'available']))

WS.verifyResponseStatusCode(response, 200)


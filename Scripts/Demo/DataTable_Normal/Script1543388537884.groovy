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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.text.ParseException as ParseException
import java.util.List as List
import org.junit.After as After
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

'Open Browser and Navigate to DataTable Page'
WebUI.openBrowser('')

WebUI.navigateToUrl('file:///E:/WORK/PassPulFramework/PassPul/PassPul/SeleniumEasy/www.seleniumeasy.com/test/table-data-download-demo.html')

WebUI.maximizeWindow()

WebUI.scrollToPosition(250, 250)

WebDriver driver = DriverFactory.getWebDriver()

'Get Table Locator and count row and column total'
try {
    List<WebElement> row_table = driver.findElements(By.xpath('.//*[@id=\'example\']/tbody/tr'))

    int row_count = row_table.size()

    println('No of rows of page are : ' + row_count)

    for (int row = 0; row < row_count; row++) {
        List<WebElement> column_table = row_table.get(row).findElements(By.tagName('td'))
        int column_count = column_table.size()
        println((('No of cell in rows : ' + row) + ' are ') + column_count)
		
        'Fetch through each row and column to get data'
        for (int column = 0; column < column_count; column++) {
            String cell_text = column_table.get(column).getText()
            println((((('Cell value of row : ' + row) + ' and cell ') + column) + ' is ') + cell_text)
			
			'Mapping (Compare) data on Table with Database'
            WebUI.verifyMatch(cell_text, findTestData('Demo/Data_Table').getValue(column + 1, row + 1), false, FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}
catch (Exception e) {
    throw e.getMessage()
} 


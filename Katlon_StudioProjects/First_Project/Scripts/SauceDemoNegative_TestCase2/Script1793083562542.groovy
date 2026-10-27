import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys

def data = findTestData('LoginSauceDemoNegative')


for(int row=1; row<= data.getRowNumbers(); row++) {
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase1/Page_Swag Labs/input_Username'), data.getValue('username',row))

WebUI.setText(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase1/Page_Swag Labs/input_Password'), data.getValue('password',row))

WebUI.sendKeys(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase1/Page_Swag Labs/input_Password'), Keys.chord(Keys.ENTER))

String currentUrl = WebUI.getUrl()

if (currentUrl.equals("https://www.saucedemo.com/")) {
    KeywordUtil.markPassed("Negative test passed: User remained on login page due to invalid credentials.")
} else {
    KeywordUtil.markFailed("Test failed: User logged in with invalid credentials. Current URL: " + currentUrl)
}

WebUI.closeBrowser()
}


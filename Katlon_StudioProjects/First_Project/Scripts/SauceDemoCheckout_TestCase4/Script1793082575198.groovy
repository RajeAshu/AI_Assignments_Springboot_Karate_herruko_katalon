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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/SauceBaseLogin_TestCase1'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_add-to-cart-sauce-labs-backpack'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_add-to-cart-sauce-labs-bolt-t-shirt'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_add-to-cart-sauce-labs-onesie'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_add-to-cart-test.allthethings()-t-shirt-('))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/a_Cart, 4 items'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_checkout'))

def data = findTestData('Sauce_Demo_TestData')

int row = 1

WebUI.setText(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/input_First Name'), data.getValue('firstname', 
        row))

WebUI.setText(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/input_Last Name'), data.getValue('lastname', 
        row))

WebUI.setText(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/input_Zip_Postal Code'), data.getValue(
        'zipcode', row))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/input_continue'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_finish'))

WebUI.click(findTestObject('Sauce_Demo/SauceDemoPositive_TestCase4/Page_Swag Labs/button_generate-pdf-order'))

WebUI.closeBrowser()


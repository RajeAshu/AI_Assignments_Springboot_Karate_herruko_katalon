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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def data = findTestData('LoginTestData')


for(int row=1; row<= data.getRowNumbers(); row++) {
	
	WebUI.openBrowser('')
	
	WebUI.navigateToUrl('file:///D:/PlayWright_Docs/login.html')
	
	WebUI.setText(findTestObject('Page_Login/input_Enter username'), data.getValue('username',row))
	
	WebUI.setText(findTestObject('Page_Login/input_Enter password'), data.getValue('password',row))
	
	WebUI.click(findTestObject('Page_Login/button_Sign In'))
	
	WebUI.switchToWindowTitle('Student Performance Report')
	
	if (WebUI.getWindowTitle()== 'Student Performance Report') {
		KeywordUtil.markPassed()
	 }else {
		 KeywordUtil.markFailed('Wrong window title: '+ WebUI.getWindowTitle() )
	 }
	
	
	WebUI.selectOptionByLabel(findTestObject('Page_Student Performance Report/select_Modules'), data.getValue('Modules', row), false)
	
	
	WebUI.click(findTestObject('Page_Student Performance Report/td_td'))
	
	WebUI.setText(findTestObject('Page_Student Performance Report/input_number'), data.getValue('Student 1',row))
	
	WebUI.setText(findTestObject('Page_Student Performance Report/input_number_1'), data.getValue('Student 2',row))
	
	WebUI.setText(findTestObject('Page_Student Performance Report/input_number_2'), data.getValue('Student 3',row))
	
	WebUI.setText(findTestObject('Page_Student Performance Report/input_number_3'), data.getValue('Student 4',row))
	
	WebUI.click(findTestObject('Page_Student Performance Report/button_saveButton'))
	
	
	WebUI.closeBrowser()
	
}
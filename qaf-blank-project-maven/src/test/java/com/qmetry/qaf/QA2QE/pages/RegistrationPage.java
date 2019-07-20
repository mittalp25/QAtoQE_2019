package com.qmetry.qaf.QA2QE.pages;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.QA2QE.databean.RegisterDataBean;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class RegistrationPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
	}
	
	@FindBy(locator="rg.firstname.input")
	public QAFWebElement inputFirstName;
	
	@FindBy(locator="rg.lastname.input")
	public QAFWebElement inputLastName;
	
	@FindBy(locator="rg.email.input")
	public QAFWebElement inputEmail;
	
	@FindBy(locator="rg.phone.input")
	public QAFWebElement inputPhone;
	
	@FindBy(locator="rg.addr1.input")
	public QAFWebElement inputAddr1;
	
	@FindBy(locator="rg.addr2.input")
	public QAFWebElement inputAddr2;
	
	@FindBy(locator="rg.city.input")
	public QAFWebElement inputCity;
	
	@FindBy(locator="rg.state.input")
	public QAFWebElement inputState;
	
	@FindBy(locator="rg.zip.input")
	public QAFWebElement inputZip;
	
	@FindBy(locator="rg.country.select")
	public QAFWebElement dropDownCountry;
	
	@FindBy(locator="rg.username.input")
	public QAFWebElement inputUsername;
	
	@FindBy(locator="rg.password.input")
	public QAFWebElement inputPassword;
	
	@FindBy(locator="rg.confirmPwd.input")
	public QAFWebElement inputConfirmPwd;
	
	@FindBy(locator="rg.submit.button")
	public QAFWebElement buttonSubmit;	
	
	public void clickRegister() {
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.linkRegister.click();
	}

	public void registerNewUserXML() throws InterruptedException {
		
		RegisterDataBean registerXmlForm = new RegisterDataBean();
		registerXmlForm.fillFromConfig("data.register.user");
	//	registerXmlForm.fillUiElements("data.register.user");

		//Fill in all the XML data using above locator fields.
		//RegisterFormDataBean fields (variable names) should match XML tag names and it fetches values from there
		inputFirstName.sendKeys(registerXmlForm.fName);
		inputLastName.sendKeys(registerXmlForm.lName);
		inputEmail.sendKeys(registerXmlForm.email);
		inputPhone.sendKeys(registerXmlForm.phone);
		inputAddr1.sendKeys(registerXmlForm.addresss1);
		inputAddr2.sendKeys(registerXmlForm.addresss2);
		inputCity.sendKeys(registerXmlForm.city);
		inputState.sendKeys(registerXmlForm.state);
		inputZip.sendKeys(registerXmlForm.postal);
		dropDownCountry.sendKeys(registerXmlForm.country);
		inputUsername.sendKeys(registerXmlForm.username);
		inputPassword.sendKeys(registerXmlForm.password);
		inputConfirmPwd.sendKeys(registerXmlForm.confirmpassword);
	}
	
	public void invalidDataTest(Map<String, Object> data1) throws InterruptedException {
		//System.out.println("Inside page:" + data1.get("Phone"));

		//Casting is required from Object to String for "sendKeys" function
		String fname = (String) data1.get("Firstname");
		inputFirstName.sendKeys(fname);

		inputLastName.sendKeys((String) data1.get("Lastname"));
		inputPhone.sendKeys(String.valueOf(data1.get("Phone")));
		inputEmail.sendKeys((String) data1.get("Email"));
			
		
	}
		
}


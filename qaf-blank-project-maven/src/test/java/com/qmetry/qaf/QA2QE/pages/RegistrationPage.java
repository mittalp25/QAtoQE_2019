package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.QA2QE.databean.RegisterFormDataBean;
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
	
	
	public void RegisterNewUser() {
		
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.linkRegister.click();
		
		RegisterFormDataBean registerXmlForm = new RegisterFormDataBean();
		registerXmlForm.fillFromConfig("data.register.user");					
				
	    //Fill in all the data using above locator fields		
	}
	
}

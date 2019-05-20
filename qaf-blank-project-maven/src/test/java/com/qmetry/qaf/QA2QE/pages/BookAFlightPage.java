package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class BookAFlightPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");		
	}
	
	@FindBy(locator="bookflight.fname.input")
	public QAFWebElement inputFName;
	
	@FindBy(locator="bookflight.lname.input")
	public QAFWebElement inputLName;
	
	@FindBy(locator="bookflight.creditcard.input")
	public QAFWebElement inputCreditCardNo;

	@FindBy(locator="bookflight.securePurchase.button")
	public QAFWebElement buttonSecurePurchase;
	 
}

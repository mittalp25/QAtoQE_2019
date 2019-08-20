package com.qmetry.qaf.QA2QE.pages;

import java.util.Map;

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
	
	public String getWindowName(){		
		return driver.getTitle();
	}
	
	public void setPurchase(Map<String, Object> data1){
		String fName = String.valueOf(data1.get("FirstName"));
		String lName = String.valueOf(data1.get("LastName"));
		String cc = String.valueOf(data1.get("Card Number"));
		inputFName.sendKeys(fName);
		inputLName.sendKeys(lName);
		inputCreditCardNo.sendKeys(cc);
	}	
	
	@FindBy(locator="bookflight.fname.input")
	public QAFWebElement inputFName;
	
	@FindBy(locator="bookflight.lname.input")
	public QAFWebElement inputLName;
	
	@FindBy(locator="bookflight.creditcard.input")
	public QAFWebElement inputCreditCardNo;

	@FindBy(locator="bookflight.securePurchase.button")
	public QAFWebElement buttonSecurePurchase;
	
	/** All verification locators **/
	@FindBy(locator="bookflight.summary.city1")
	public QAFWebElement textCity1;
	
	@FindBy(locator="bookflight.summary.date1")
	public QAFWebElement textDate1;
	
	@FindBy(locator="bookflight.summary.flight1")
	public QAFWebElement textFlight1;
	
	@FindBy(locator="bookflight.summary.city2")
	public QAFWebElement textCity2;
	
	@FindBy(locator="bookflight.summary.date2")
	public QAFWebElement textDate2;
	
	@FindBy(locator="bookflight.summary.flight2")
	public QAFWebElement textFlight2;
		
	@FindBy(locator="bookflight.summary.passenger")
	public QAFWebElement textPassenger;
	
	@FindBy(locator="bookflight.summary.price")
	public QAFWebElement textPrice;
}

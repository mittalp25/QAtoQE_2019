package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlightConfirmationPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");		
	}
	
	public String getWindowTitle(){
		return driver.getTitle();
	}
	
	
	public void navigateBack() throws InterruptedException {
		
		driver.navigate().back();
		Thread.sleep(4000);
		
	}
	@FindBy(locator="flightConfirm.logout.button")
	public QAFWebElement buttonLogout;
	
	@FindBy(locator="flightConfirm.backToFlight.button")
	public QAFWebElement buttonBackToFlight;
	
}

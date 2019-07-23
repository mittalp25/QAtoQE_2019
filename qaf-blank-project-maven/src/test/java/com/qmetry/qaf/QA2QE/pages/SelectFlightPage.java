package com.qmetry.qaf.QA2QE.pages;

import java.util.List;

import com.qmetry.qaf.QA2QE.component.SelectFlightComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SelectFlightPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");		
	}

	@FindBy(locator="selectflight.continue.button")
	public QAFWebElement buttonContinue;
	
	@FindBy(locator="selectflight.radioButtons.list")
	public List<SelectFlightComponent> radioButtons;
			
	@FindBy(locator="selectflight.flightName.list")
	public List<SelectFlightComponent> flightName;
	
	@FindBy(locator="selectflight.depart.name")
	public QAFWebElement departFlightname;
		
	/*** Functions ***/
	
	public void selectFlights(String radioFN) {
		SelectFlightComponent fn = new SelectFlightComponent("selectflight.radioButtons.list");
		fn.getXpath(radioFN).click();	
	}
	
}

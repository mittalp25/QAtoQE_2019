package com.qmetry.qaf.QA2QE.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
public class SelectFlightComponent extends QAFWebComponent{
	
	public SelectFlightComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(locator="selectflight.radioButtons.list")
	public QAFWebElement radioButtons;
	
	@FindBy(locator="selectflight.flightName.list")
	public QAFWebElement flightName;
	
	public QAFExtendedWebElement getXpath(String flighRadio) {	
	 return findElement("xpath=//tr/td/input[@type='radio'][@value='" + flighRadio + "']");
	}
}
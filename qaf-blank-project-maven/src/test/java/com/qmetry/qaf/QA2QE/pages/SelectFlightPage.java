package com.qmetry.qaf.QA2QE.pages;

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
}

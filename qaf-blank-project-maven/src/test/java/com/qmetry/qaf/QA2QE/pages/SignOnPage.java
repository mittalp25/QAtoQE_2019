package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SignOnPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator="failed.login.text")
	public QAFWebElement textWelcomeMsg;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");		
	}
}

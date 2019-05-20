package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ContactPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");		
	}

	@FindBy(locator="contact.title.img")
	public QAFWebElement imgTitleContact;
	
	@FindBy(locator="contact.textmsg.text ")
	public QAFWebElement textParagraph;
	
	@FindBy(locator="contact.backToHome.buttonImg")
	public QAFWebElement buttonBackToHome;
	
	public String getWindowTitle(){
		return driver.getTitle();
	}
}

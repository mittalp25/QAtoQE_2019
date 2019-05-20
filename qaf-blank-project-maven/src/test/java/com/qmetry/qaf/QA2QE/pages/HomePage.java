package com.qmetry.qaf.QA2QE.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	public String getWindowTitle(){
		return driver.getTitle();
	}
		
	//Elements of Login - Encapsulation
	@FindBy(locator="login.username.text")
	private QAFWebElement inputUserName;
	
	@FindBy(locator="login.password.text")
	private QAFWebElement inputPassword;
	
	@FindBy(locator="login.signin.button")
	private QAFWebElement buttonSignIn;
	
	//All the getters methods for private elements
	public QAFWebElement getInputUserName() {
		return inputUserName;
	}

	public QAFWebElement getInputPassword() {
		return inputPassword;
	}

	public QAFWebElement getButtonSignIn() {
		return buttonSignIn;
	}

	public void doLogin(String uname, String pwd) {
		getInputUserName().sendKeys(uname);
		getInputPassword().sendKeys(pwd);
		getButtonSignIn().click();
	}	
	
	//Home Page all image links
	
	@FindBy(locator="home.featureddest.img")
	public QAFWebElement imgFeaturedDestination;
	
	@FindBy(locator="home.specials.img")
	public QAFWebElement imgSpecials;
	
	@FindBy(locator="home.tourtips.img")
	public QAFWebElement imgTourTips;
	
	@FindBy(locator="home.destinations.img")
	public QAFWebElement imgDestination;
	
	@FindBy(locator="home.findaflight.img")
	public QAFWebElement imgFindAFlight;
	
	@FindBy(locator="home.vacations.img")
	public QAFWebElement imgVacation;
	
	@FindBy(locator="home.register.img")
	public QAFWebElement imgRegister;
	
	@FindBy(locator="home.links.img")
	public QAFWebElement imgLinks;
	
	//Home Page Left Menu links
	
	@FindBy(locator="home.leftmenu.home.link")
	public QAFWebElement linkHome;
	
	@FindBy(locator="home.leftmenu.hotels.link")
	public QAFWebElement linkHotels;
	
	@FindBy(locator="home.leftmenu.cruises.link")
	public QAFWebElement linkCruises;
	
	//Home Page Top Menu links
	
	@FindBy(locator="home.topemenu.signon.link")
	public QAFWebElement linkSignOn;
	
	@FindBy(locator="home.topemenu.register.link")
	public QAFWebElement linkRegister;
	
	@FindBy(locator="home.topemenu.support.link")
	public QAFWebElement linkSupport;
	
	@FindBy(locator="home.topemenu.contact.link")
	public QAFWebElement linkContact;
}


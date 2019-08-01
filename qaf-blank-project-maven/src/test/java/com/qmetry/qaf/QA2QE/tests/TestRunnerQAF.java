package com.qmetry.qaf.QA2QE.tests;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.QA2QE.databean.FlightDetailFormDataBean;
import com.qmetry.qaf.QA2QE.pages.BookAFlightPage;
import com.qmetry.qaf.QA2QE.pages.ContactPage;
import com.qmetry.qaf.QA2QE.pages.FlightConfirmationPage;
import com.qmetry.qaf.QA2QE.pages.FlightFinderPage;
import com.qmetry.qaf.QA2QE.pages.HomePage;
import com.qmetry.qaf.QA2QE.pages.RegistrationPage;
import com.qmetry.qaf.QA2QE.pages.SelectFlightPage;
import com.qmetry.qaf.QA2QE.pages.SignOnPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TestRunnerQAF extends WebDriverTestCase{
	
	@Test (description="Verify home page links/components")
	public void QEO14140(){
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
	
		//Compared text and verified
		verifyTrue(homePage.imgFeaturedDestination.getAttribute("alt").equals("Featured Destination: Aruba"), "Fail: Featured Destination link is NOT displayed.","Pass: Featured Destination link is displayed.");
		verifyTrue(homePage.imgSpecials.getAttribute("alt").equals("Specials"), "Fail: Special link is NOT displayed.","Pass: Special link is displayed.");
		verifyTrue(homePage.imgTourTips.getAttribute("alt").equals("Tour Tips"), "Fail: Tour Tips link is NOT displayed.","Pass: Tour Tips link is displayed.");
		verifyTrue(homePage.imgFindAFlight.getAttribute("alt").equals("Find a Flight"), "Fail: Find A Flight link is NOT displayed.","Pass: Find A Flight link is displayed.");
		verifyTrue(homePage.imgDestination.getAttribute("alt").equals("Desinations"), "Fail: Destination link is NOT displayed.","Pass: Destination link is displayed.");
		verifyTrue(homePage.imgVacation.getAttribute("alt").equals("vacations"), "Fail: Vacation link is NOT displayed.","Pass: Vacation link is displayed.");
		verifyTrue(homePage.imgRegister.getAttribute("alt").equals("Register"), "Fail: Register link is NOT displayed.","Pass: Register link is displayed.");
		verifyTrue(homePage.imgLinks.getAttribute("alt").equals("Links"), "Fail: Links link is NOT displayed.","Pass: Links link is displayed.");
	
		//Compared visibility of links 
		verifyTrue(homePage.linkHome.isPresent(), "Fail: Home link is NOT visible", "Pass: Home link is visible");
		verifyTrue(homePage.linkCruises.isPresent(), "Fail: Cruises link is NOT visible", "Pass: Cruises link is visible");
		verifyTrue(homePage.linkHotels.isPresent(), "Fail: Hotels link is NOT visible", "Pass: Hotels link is visible");
		verifyTrue(homePage.linkSignOn.isPresent(), "Fail: SIGN-ON link is NOT visible", "Pass: SIGN-ON link is visible");
		verifyTrue(homePage.linkRegister.isPresent(), "Fail: Register link is NOT visible", "Pass: Register link is visible");
		verifyTrue(homePage.linkSupport.isPresent(), "Fail: Support link is NOT visible", "Pass: Support link is visible");		
	}	
	
	@Test (description="Login successfully.")
	public void QEO14141(){
		HomePage homePage = new HomePage();
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		//Verify it logs in and lands on Flight finder page
		FlightFinderPage flightFinder = new FlightFinderPage();
		flightFinder.waitForPageToLoad();
		flightFinder.getTextTopWelcomePara().verifyText("Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.");
		Reporter.log("Login test"); //Practicing logs
	}
	
	@Test (description="Verify Logout button navigation from flight confirmation.")
	public void QEO14142() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		FlightFinderPage flightFinder = new FlightFinderPage();
		flightFinder.waitForPageToLoad();
		verifyTrue(flightFinder.getWindowTitle().equals("Find a Flight: Mercury Tours:"), "Fail: Could't sign in.", "Pass: Signed in successfully.");
		
		flightFinder.radioOneWayTrip.click();
		flightFinder.selectPassengerCount("2 ");
		flightFinder.selectFromCity("San Francisco");
		flightFinder.selectDepartMonth("June");
		flightFinder.selectDepartDay("21");
		flightFinder.selectToCity("Zurich");
		flightFinder.selectReturnMonth("July");
		flightFinder.selectReturnDay("1");
		flightFinder.radioBusiness.click();
		flightFinder.selectAirlines("Blue Skies Airlines");
		
		Thread.sleep(4000);
		
		flightFinder.buttonContinue.click();
		
		SelectFlightPage selectFlight = new SelectFlightPage();
		selectFlight.waitForPageToLoad();
		selectFlight.buttonContinue.click();		
		
		BookAFlightPage bookFlight = new BookAFlightPage();
		bookFlight.waitForPageToLoad();
		bookFlight.inputFName.sendKeys("Mittal Test");
		bookFlight.inputLName.sendKeys("Patel");
		bookFlight.inputCreditCardNo.sendKeys("4400987867670101");
		
		Thread.sleep(4000);
		
		bookFlight.buttonSecurePurchase.click();	
		
		FlightConfirmationPage flightConfirm = new FlightConfirmationPage();
		assertTrue(flightConfirm.getWindowTitle().equals("Flight Confirmation: Mercury Tours"), "Failed: Not on confirmation page:" , "Pass: On Flight confirmation page");
		flightConfirm.buttonLogout.click();
		
		SignOnPage signOn = new SignOnPage();
		assertTrue(signOn.getWindowTitle().equals("Sign-on: Mercury Tours"), "Failed: Not on sign on page:" , "Pass: On Sign on page");
				
	}	
	
	@QAFDataProvider(key="InvalidLogin.data") //Data file path is not required here. Give just xml tag keys after "root"
	@Test(description = "Cannot login using Invalid credentials.")
	public void QEO14143(Map<String, String> xmlData) throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.waitForPageToLoad();
		homePage.doLogin(xmlData.get("username"), xmlData.get("pwd"));
		SignOnPage signPage = new SignOnPage();
		verifyTrue(signPage.textWelcomeMsg.getText().equals("Welcome back to Mercury Tours!"), "Fail:", "Pass:  Please enter correct user-pwd.");
	}

	@Test
	public void QEO14144() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.linkContact.click();	
		
		Thread.sleep(2000);
		
		ContactPage contactPage = new ContactPage();
		contactPage.waitForPageToLoad();
		assertTrue(contactPage.getWindowTitle().equals("Under Construction: Mercury Tours"), "Fail:", "Pass:");
		//System.out.println(contactPage.textParagraph.getText());
		//verifyTrue(contactPage.textParagraph.getText().equals("This section of our web site is currently under construction.   Sorry for any inconvienece."), "Fail:", "Pass:");
		contactPage.buttonBackToHome.click();
		
		Thread.sleep(2000);
		
		HomePage homePage1 = new HomePage();
		homePage1.waitForPageToLoad();
		assertTrue(homePage1.getWindowTitle().equals("Welcome: Mercury Tours"), "Fail" , "Pass");	
	}
	
	@Test (description = "Register form: XML databean concept")
	public void QEO14145() throws InterruptedException{
		
		RegistrationPage register = new RegistrationPage();
		register.clickRegister();
		register.registerNewUserXML();		
	}
	
	@QAFDataProvider (dataFile = "resources/Testdata/QEO14146.xls") //xlsx is not compatible with QMETRY v14
	@Test (description = "Register form: Invalid data: Excel databean concept")
	public void QEO14146(Map<String, Object> data) throws InterruptedException {
		
		RegistrationPage register = new RegistrationPage();
		register.clickRegister();
		register.invalidDataTest(data); //It passes 3 rows data and QAF automatically runs TC 3 times. Each time it fills one row of data
		Thread.sleep(3000);	
	}
	
	
	@Test(description = "Form data bean")
	public void QEO14147() throws InterruptedException  {
		
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		FlightDetailFormDataBean fb = new FlightDetailFormDataBean();
		//fb.setTripType("oneway");
		fb.setTripType("roundtrip");
		fb.setPassengerCount(1);
		fb.setDepartureCity("Portland");
		fb.setArrivalCity("New York");
				
		//Date currentDate = new Date(); Do NOT Use. Deprecated
		Calendar date = Calendar.getInstance();
	
		fb.setDepartureMonth(date.get(Calendar.MONTH));
		fb.setDepartureDate(date.get(Calendar.DAY_OF_MONTH));
		fb.setReturnMonth(date.get(Calendar.MONTH));
		fb.setReturnDate(date.get(Calendar.DAY_OF_MONTH) + 5);
		
		fb.fillUiElements();
		Thread.sleep(3000);
		
		FlightFinderPage fb2 = new FlightFinderPage();
		fb2.buttonContinue.click();
						
		SelectFlightPage sf = new SelectFlightPage();
		sf.selectFlights("Unified Airlines$563$125$11:24");
		sf.selectFlights("Blue Skies Airlines$651$99$14:30");
		Thread.sleep(2000);
		sf.buttonContinue.click();
		
		BookAFlightPage bookFL = new BookAFlightPage();
			
		verifyTrue(bookFL.textCity1.getText().equals("Portland to New York"), "Fail: City1", "Pass: City1");
		verifyTrue(bookFL.textDate1.getText().equals("6/19/2019"), "Fail: Date1", "Pass: Date1");
		verifyTrue(bookFL.textFlight1.getText().equals("Unified Airlines 563"), "Fail: Flight1", "Pass: Flight1");
		
		verifyTrue(bookFL.textCity2.getText().equals("New York to Portland"), "Fail: City2", "Pass: City2");
		verifyTrue(bookFL.textDate2.getText().equals("6/24/2019"), "Fail: Date2", "Pass: Date2");
		verifyTrue(bookFL.textFlight2.getText().equals("Blue Skies Airlines 651"), "Fail: Flight2", "Pass: Flight2");
		
		verifyTrue(bookFL.textPassenger.getText().equals("1"), "Fail: Passenger count", "Pass: Passenger count");
		verifyTrue(bookFL.textPrice.getText().equals("$242"), "Fail: Total Price", "Pass: Total Price");
		
		bookFL.inputFName.sendKeys("Test FName");
		bookFL.inputLName.sendKeys("Test LName");
		bookFL.inputCreditCardNo.sendKeys("4666829312341359");
		
		bookFL.buttonSecurePurchase.click();
		
		FlightConfirmationPage confirm = new FlightConfirmationPage();
		verifyTrue(confirm.getWindowTitle().equals("Flight Confirmation: Mercury Tours"), "Fail: No confirm screen." , "Pass: On confirm screen.");
	}		
	
	
	@Test(description = "Continue to next page with same details")
	public void QEO14148() throws InterruptedException  {
		
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		FlightDetailFormDataBean fb = new FlightDetailFormDataBean();
		//fb.setTripType("oneway");
		fb.setTripType("roundtrip");
		fb.setPassengerCount(1);
		fb.setDepartureCity("London");
		fb.setArrivalCity("London");
				
		//Date currentDate = new Date(); Do NOT Use. Deprecated		
			
		System.out.println("Date is: " + LocalDate.now().getMonthValue());
		
		fb.setDepartureMonth(LocalDate.now().getMonthValue());
		fb.setDepartureDate(LocalDate.now().getDayOfMonth() + 1);
		fb.setReturnMonth(LocalDate.now().getMonthValue());
		fb.setReturnDate(LocalDate.now().getDayOfMonth() + 1 + 5);
		
		fb.fillUiElements();
		Thread.sleep(3000);
		
		FlightFinderPage fb2 = new FlightFinderPage();
		fb2.buttonContinue.click();
						
		SelectFlightPage sf = new SelectFlightPage();
		System.out.println(sf.departFlightname.getText());
		verifyTrue(sf.departFlightname.getText().equals("London to London 7/23/2019"), "Fail: City1", "Pass: City1");
		
		sf.buttonContinue.click();
		BookAFlightPage bookFL = new BookAFlightPage();
		System.out.println("Window is: " + bookFL.getWindowName());
		verifyTrue(bookFL.getWindowName().equals("Book a Flight: Mercury Tours"), "Fail: No title.", "Pass: Title appears.");
	}
	
	@QAFDataProvider (dataFile = "resources/Testdata/QEO14149.xls") //xlsx is not compatible with QMETRY v14
	@Test (description = "Depart Arrival on different data points.")
	public void QEO14149(Map<String, Object> data) throws InterruptedException {
		
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		FlightFinderPage fb = new FlightFinderPage();
		//fb.setTripType("oneway");
		fb.setdepartReturnDate(data);
		fb.buttonContinue.click();		
		Thread.sleep(3000);
	}
	
	
	@QAFDataProvider (dataFile = "resources/Testdata/QEO14150.xls") //xlsx is not compatible with QMETRY v14
	@Test (description = "Depart Arrival on different data points.")
	public void QEO14150(Map<String, Object> data) throws InterruptedException {
		
		HomePage homePage = new HomePage();
		homePage.launchPage(null);
		homePage.waitForPageToLoad();
		homePage.doLogin("guest", "guest");
		
		FlightDetailFormDataBean fb = new FlightDetailFormDataBean();
		//fb.setTripType("oneway");
		fb.setTripType("roundtrip");
		fb.setPassengerCount(1);
		fb.setDepartureCity("Portland");
		fb.setArrivalCity("New York");
				
		fb.setDepartureMonth(8);
		fb.setDepartureDate(1);
		fb.setReturnMonth(8);
		fb.setReturnDate(10);
		
		fb.fillUiElements();
		//Thread.sleep(3000);
		
		FlightFinderPage fb2 = new FlightFinderPage();
		fb2.buttonContinue.click();
						
		SelectFlightPage sf = new SelectFlightPage();
		sf.selectFlights("Unified Airlines$563$125$11:24");
		sf.selectFlights("Blue Skies Airlines$651$99$14:30");
		//Thread.sleep(2000);
		sf.buttonContinue.click();
		
		BookAFlightPage bookFL = new BookAFlightPage();
		bookFL.setPurchase(data);
		bookFL.buttonSecurePurchase.click();
		//Thread.sleep(2000);
		
		FlightConfirmationPage confirm = new FlightConfirmationPage();
		assertTrue(confirm.getWindowTitle().equals("Flight Confirmation: Mercury Tours"), "Failed: Not on confirmation page:" , "Pass: On Flight confirmation page");
		
	}		
}



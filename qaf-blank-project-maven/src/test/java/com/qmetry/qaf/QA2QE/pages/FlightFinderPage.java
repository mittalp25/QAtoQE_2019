package com.qmetry.qaf.QA2QE.pages;

import java.util.List;
import java.util.Map;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlightFinderPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");	
		
	}
	
	public void setdepartReturnDate(Map<String, Object> data1){
		String departDay = String.valueOf(data1.get("DepartOn"));
		String returnDay = String.valueOf(data1.get("Return On"));
		selectDepartDay(departDay);	
		selectReturnDay(returnDay);
	}
		
	
	@FindBy(locator="flightfind.welcomepara.text")
	private QAFWebElement textTopWelcomePara;
	
	@FindBy(locator="flightfifnd.oneWayTrip.radioButtons")
	public QAFWebElement radioOneWayTrip;

	@FindBy(locator="flightfifnd.roundTrip.radioButtons")
	public QAFWebElement radioRoundTrip;
	
	@FindBy(locator="flightfind.selectPassenger.dropdown")
	public List<QAFWebElement> listPassgengerCount;
	
	@FindBy(locator="flightfind.fromCity.dropdown")
	public List<QAFWebElement> listFromCity;
	
	@FindBy(locator="flightfind.toCity.dropdown")
	public List<QAFWebElement> listToCity;
	
	@FindBy(locator="flightfind.departMonth.dropdown")
	public List<QAFWebElement> listDepartMonth;
	
	@FindBy(locator="flightfind.departDay.dropdown")
	public List<QAFWebElement> listDepartDay;
	
	@FindBy(locator="flightfind.returnMonth.dropdown")
	public List<QAFWebElement> listReturnMonth;
	
	@FindBy(locator="flightfind.returnDay.dropdown")
	public List<QAFWebElement> listReturnDay;
	
	@FindBy(locator="flightfind.economy.radio")
	public QAFWebElement radioEconomy;
	
	@FindBy(locator="flightfind.business.radio")
	public QAFWebElement radioBusiness;
	
	@FindBy(locator="flightfind.first.radio")
	public QAFWebElement radioFirst;
	
	@FindBy(locator="flightfind.airline.dropdown")
	public List<QAFWebElement> listAirlines;
	
	@FindBy(locator="flightfind.continue.button")
	public QAFWebElement buttonContinue;	
		
	/** Functions */
	public QAFWebElement getTextTopWelcomePara() {
		System.out.println("Inside fn:" + textTopWelcomePara.getText());
		return textTopWelcomePara;
	}	
	
	public String getWindowTitle(){
		return driver.getTitle();
	}
	
	public void selectPassengerCount(String count) {
		
		for(QAFWebElement option: listPassgengerCount ) {
			if (option.getText().equals(count)) {
				option.click();
			}
		}
	}	
	
	public void selectFromCity(String city) {
		for(QAFWebElement option: listFromCity ) {
			if (option.getText().equals(city)) {
				option.click();
			}
		}
	}	
	
	public void selectToCity(String toCity) {
		for(QAFWebElement option: listToCity ) {
			if (option.getText().equals(toCity)) {
				option.click();
			}
		}
	}
	
	public void selectDepartMonth(String departCity) {
		for(QAFWebElement option: listDepartMonth ) {
			if (option.getText().equals(departCity)) {
				option.click();
			}
		}
	}	
	
	public void selectDepartDay(String departDate) {
		for(QAFWebElement option: listDepartDay ) {
			if (option.getText().equals(departDate)) {
				option.click();				
			}
		}
	}
			
	public void selectReturnMonth(String returnMonth) {
		for(QAFWebElement option: listReturnMonth ) {
			if (option.getText().equals(returnMonth)) {
				option.click();
			}
		}
	}
	
	public void selectReturnDay(String returnDay) {
		for(QAFWebElement option: listReturnDay ) {
			if (option.getText().equals(returnDay)) {
				option.click();
			}
		}
	}		
	
	public void selectAirlines(String airlines) {
		for(QAFWebElement option: listAirlines ) {
			if (option.getText().equals(airlines)) {
				option.click();
			}
		}
	}
	
	
	
	
	
}

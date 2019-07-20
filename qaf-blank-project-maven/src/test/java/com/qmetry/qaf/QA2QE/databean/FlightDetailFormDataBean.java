package com.qmetry.qaf.QA2QE.databean;

import com.qmetry.qaf.QA2QE.pages.HomePage;
import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.annotations.UiElement.Type;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

//Here we use Base"Form"DataBean
public class FlightDetailFormDataBean extends BaseFormDataBean {

	@UiElement(fieldLoc="tripType", fieldType=Type.optionbox)
	String tripType; // Custom variable names
	
	//Here it converts locator into //*[@name or @id or @value = <string> that I passed in fieldLoc. Hence do not put full xPath.
	//Then, use setter method to pass the value in the field
	@UiElement(fieldLoc="passCount", fieldType=Type.selectbox)
	int passengerCount;
	
	@UiElement (fieldLoc = "fromPort", fieldType=Type.selectbox )
	String departureCity;
	
	@UiElement(fieldLoc="toPort", fieldType=Type.selectbox)
	String arrivalCity;
	
	@UiElement(fieldLoc="fromMonth", fieldType=Type.selectbox)
	Integer departureMonth;

	@UiElement(fieldLoc="toMonth", fieldType=Type.selectbox)
	Integer returnMonth;
	
	@UiElement(fieldLoc="fromDay", fieldType=Type.selectbox)
	Integer departureDate;
	
	@UiElement(fieldLoc="toDay", fieldType=Type.selectbox)
	Integer returnDate;
	
	public String getTripType() {
		return tripType;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	
	public Integer getDepartureMonth() {
		return departureMonth;
	}
	public int getDepartureDate() {
		return departureDate;
	}
	public Integer getReturnMonth() {
		return returnMonth;
	}
	public int getReturnDate() {
		return returnDate;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public void setDepartureMonth(Integer departureMonth) {
		this.departureMonth = departureMonth;
	}
	public void setDepartureDate(int departureDate) {
		this.departureDate = departureDate;
	}
	public void setReturnMonth(Integer returnMonth) {
		this.returnMonth = returnMonth;
	}
	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}
	
}
package org.test.adactin2.adactin2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	static WebDriver driver;

	@FindBy(xpath = "//*[text()='Logout']")
	private WebElement btnLogOut;

	@FindBy(id = "location")
	private WebElement dpdLocation;
	@FindBy(id = "hotels")
	private WebElement dpdHotel;
	@FindBy(id = "room_type")
	private WebElement dpdRoomType;
	@FindBy(id = "room_nos")
	private WebElement dpdNumberofRoom;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckinDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement dpdAdult;
	@FindBy(id = "child_room")
	private WebElement dpdChild;
	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(WebElement btnLogOut) {
		this.btnLogOut = btnLogOut;
	}

	public WebElement getDpdLocation() {
		return dpdLocation;
	}

	public void setDpdLocation(WebElement dpdLocation) {
		this.dpdLocation = dpdLocation;
	}

	public WebElement getDpdHotel() {
		return dpdHotel;
	}

	public void setDpdHotel(WebElement dpdHotel) {
		this.dpdHotel = dpdHotel;
	}

	public WebElement getDpdRoomType() {
		return dpdRoomType;
	}

	public void setDpdRoomType(WebElement dpdRoomType) {
		this.dpdRoomType = dpdRoomType;
	}

	public WebElement getDpdNumberofRoom() {
		return dpdNumberofRoom;
	}

	public void setDpdNumberofRoom(WebElement dpdNumberofRoom) {
		this.dpdNumberofRoom = dpdNumberofRoom;
	}

	public WebElement getTxtCheckinDate() {
		return txtCheckinDate;
	}

	public void setTxtCheckinDate(WebElement txtCheckinDate) {
		this.txtCheckinDate = txtCheckinDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public void setTxtCheckOutDate(WebElement txtCheckOutDate) {
		this.txtCheckOutDate = txtCheckOutDate;
	}

	public WebElement getDpdAdult() {
		return dpdAdult;
	}

	public void setDpdAdult(WebElement dpdAdult) {
		this.dpdAdult = dpdAdult;
	}

	public WebElement getDpdChild() {
		return dpdChild;
	}

	public void setDpdChild(WebElement dpdChild) {
		this.dpdChild = dpdChild;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(WebElement btnSearch) {
		this.btnSearch = btnSearch;
	}

	public SearchPage(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

}

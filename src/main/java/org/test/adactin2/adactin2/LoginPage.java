package org.test.adactin2.adactin2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;
	@FindBy(xpath=".//*[@id='username']")
	private WebElement txtUserName;
	
	@FindBy(xpath=".//*[@id='password']")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement btnLogin;
	
	@FindBy(xpath="//*[@alt='AdactIn Group']") 
	private WebElement imgAdactinLogo;
	
	@FindBy(xpath="//*[@class='header_title']") 
	private WebElement imgHeader; 
	
	@FindBy(xpath="//*[text()='Welcome to AdactIn Group of Hotels']") 
	private WebElement imgWelcome; 
	
	@FindBy(xpath="//*[@alt='Hotel Image 1']") 
	private WebElement imgHotel1; 
	
	@FindBy(xpath="//*[@alt='Hotel Image 2']") 
	private WebElement imgHotel2;
	
	@FindBy(xpath="//*[@alt='Hotel Image 3']") 
	private WebElement imgHotel3; 
	
	@FindBy(xpath="//*[@alt='Hotel Image 4']") 
	private WebElement imgHotel4; 
	
	@FindBy(xpath="//*[text()='Existing User Login - Build 1']") 
	private WebElement txtExistingUser; 
	
	@FindBy(xpath="//*[text()='Forgot Password?']") 
	private WebElement txtForgotPassword; 
	
	@FindBy(xpath="//*[text()='New User Register Here']") 
	private WebElement txtNewUserRegister; 
	
	@FindBy(xpath="//*[text()='Important Note:']") 
	private WebElement txtImportantNote;
	
	
	
	public LoginPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(WebElement txtUserName) {
		this.txtUserName = txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	public WebElement getImgAdactinLogo() {
		return imgAdactinLogo;
	}

	public void setImgAdactinLogo(WebElement imgAdactinLogo) {
		this.imgAdactinLogo = imgAdactinLogo;
	}

	public WebElement getImgHeader() {
		return imgHeader;
	}

	public void setImgHeader(WebElement imgHeader) {
		this.imgHeader = imgHeader;
	}

	public WebElement getImgWelcome() {
		return imgWelcome;
	}

	public void setImgWelcome(WebElement imgWelcome) {
		this.imgWelcome = imgWelcome;
	}

	public WebElement getImgHotel1() {
		return imgHotel1;
	}

	public void setImgHotel1(WebElement imgHotel1) {
		this.imgHotel1 = imgHotel1;
	}

	public WebElement getImgHotel2() {
		return imgHotel2;
	}

	public void setImgHotel2(WebElement imgHotel2) {
		this.imgHotel2 = imgHotel2;
	}

	public WebElement getImgHotel3() {
		return imgHotel3;
	}

	public void setImgHotel3(WebElement imgHotel3) {
		this.imgHotel3 = imgHotel3;
	}

	public WebElement getImgHotel4() {
		return imgHotel4;
	}

	public void setImgHotel4(WebElement imgHotel4) {
		this.imgHotel4 = imgHotel4;
	}

	public WebElement getTxtExistingUser() {
		return txtExistingUser;
	}

	public void setTxtExistingUser(WebElement txtExistingUser) {
		this.txtExistingUser = txtExistingUser;
	}

	public WebElement getTxtForgotPassword() {
		return txtForgotPassword;
	}

	public void setTxtForgotPassword(WebElement txtForgotPassword) {
		this.txtForgotPassword = txtForgotPassword;
	}

	public WebElement getTxtNewUserRegister() {
		return txtNewUserRegister;
	}

	public void setTxtNewUserRegister(WebElement txtNewUserRegister) {
		this.txtNewUserRegister = txtNewUserRegister;
	}

	public WebElement getTxtImportantNote() {
		return txtImportantNote;
	}

	public void setTxtImportantNote(WebElement txtImportantNote) {
		this.txtImportantNote = txtImportantNote;
	}

	

	
	
}

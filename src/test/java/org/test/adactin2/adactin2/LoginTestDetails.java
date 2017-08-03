package org.test.adactin2.adactin2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.runners.MethodSorters;
//import org.test.adactin.SearchHotel;
import org.test.adactin2.adactin2.LoginPage;
import org.test.adactin2.adactin2.SearchPage;

import utility.Base;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTestDetails extends Base {
	static WebDriver driver;
	//static Base base;
	LoginPage loginPage;
	SearchPage searchpage;
	//SearchPage searchPage;
	Base base = new Base();
	@BeforeClass	
	public static void launchBrowser() {		
		driver = getDriver();		
	}
//	@Test
//	public void VerifyLoginDetails() {
//		
//		loginPage = new LoginPage(driver);
//		searchPage = new SearchPage(driver);
//		Assert.assertTrue(base.elementFound(driver,1,loginPage.getImgAdactinLogo()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgAdactinLogo()));
//		
//		Assert.assertTrue(base.elementFound(loginPage.getImgHeader()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgWelcome()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgHotel1()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgHotel2()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgHotel3()));
//		Assert.assertTrue(base.elementFound(loginPage.getImgHotel4()));
//		
//		Assert.assertTrue(base.elementFound(loginPage.getTxtExistingUser()));
//		Assert.assertTrue(base.elementFound(loginPage.getTxtForgotPassword()));
//		Assert.assertTrue(base.elementFound(loginPage.getTxtNewUserRegister()));
//		Assert.assertTrue(base.elementFound(loginPage.getTxtImportantNote()));
//		
//		base.setText(loginPage.getTxtUserName(), "ramyakavi");
//		Assert.assertEquals("ramyakavi", base.getText(loginPage.getTxtUserName()));
//		
//		base.setText(loginPage.getTxtPassword(), "ramya12345");
//		Assert.assertEquals("ramya12345", base.getText(loginPage.getTxtPassword()));
//		
//		loginPage.getTxtPassword().sendKeys(Keys.ENTER); 
//		base.elementToBeVisible(driver, 20, loginPage.getBtnLogin()); 
//		base.clickBtn(loginPage.getBtnLogin()); 
//		base.elementToBeVisible(driver, 20, searchPage.getBtnLogOut()); 
//		Assert.assertTrue(base.elementFound(driver, 20, searchPage.getBtnLogOut()));
//		
//		
//		//loginPage.setTxtUserName("ramyakavi");		
//		//Assert.assertEquals("ramyakavi", loginPage.getTxtUserName());
//
//		
//		//loginPage.setTxtPassword("ramya12345");
//		//Assert.assertEquals("ramya12345", loginPage.getTxtPassword());
//		//dropDownSelect(searchpage.getDpdLocation(), "London");
	//dropDownSelect(searchpage.getDpdHotel(), "Hotel Sunshine");
	//dropDownSelect(searchpage.getDpdRoomType(), "Standard");
//		//loginPage.getBtnLogin().click();
//		//loginPage.getTdBlank().click();
//		
//		//Assert.assertTrue(searchPage.getBtnLogOut().isDisplayed());
//	}
	
	
	@Test
	public void averifyLogin() {
		loginPage = new LoginPage(driver);
		
		setText(loginPage.getTxtUserName(), readValueFromExcelSheet().get(1).get("UserName"));
		setText(loginPage.getTxtPassword(), readValueFromExcelSheet().get(1).get("Password"));
		loginPage.getTxtPassword().sendKeys(Keys.ENTER);
		getScreenShot("Login");
		elementToBeVisible(driver, 20, loginPage.getBtnLogin());
		clickBtn(loginPage.getBtnLogin());
		System.out.println("Success");

	}
	@Test
	public void bsearchHotel1() {
		searchpage = new SearchPage(driver);		
		//Assert.assertTrue(elementFound(driver, 10, searchpage.getBtnLogOut()));
		
		dropDownSelect(searchpage.getDpdLocation(), readValueFromExcelSheet().get(1).get("Location"));		
		dropDownSelect(searchpage.getDpdHotel(), readValueFromExcelSheet().get(1).get("Hotel"));		
		dropDownSelect(searchpage.getDpdRoomType(), readValueFromExcelSheet().get(1).get("RoomType"));
	    dropDownSelect(searchpage.getDpdNumberofRoom(), "5");
		//dropDownSelect(searchpage.getDpdNumberofRoom(),  readValueFromExcelSheet().get(1).get("RoomNumber"));
		setText(searchpage.getTxtCheckinDate(), readValueFromExcelSheet().get(1).get("CheckInDate"));
		setText(searchpage.getTxtCheckOutDate(), readValueFromExcelSheet().get(1).get("CheckOutDate"));
		dropDownSelect(searchpage.getDpdAdult(), "2");
		//dropDownSelect(searchpage.getDpdAdult(), readValueFromExcelSheet().get(1).get("AdultRoom"));
	    dropDownSelect(searchpage.getDpdChild(), "1");
		//dropDownSelect(searchpage.getDpdChild(), readValueFromExcelSheet().get(1).get("ChildrenRoom"));
		getScreenShot("Hotelsearch");
		clickBtn(searchpage.getBtnSearch());

	}

	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}

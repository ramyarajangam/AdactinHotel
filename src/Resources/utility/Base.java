package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.adactin2.adactin2.LoginPage;


public class Base {
	static WebDriver driver;
	WebDriverWait wait;

	public static WebDriver getBrowser(String browser) {
		if (browser.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/ramya/workspace/adactin2/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/ramya/workspace/adactin2/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:/Users/ramya/workspace/adactin2/Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://www.adactin.com/HotelApp/");
		return driver;
	}

	public boolean elementToBeVisible(WebDriver driver, int time,
			WebElement element) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean alertIsPresent(WebDriver driver, int time) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.alertIsPresent());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean elementToBeClickable(WebDriver driver, int time,
			WebElement element) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean elementFound(WebDriver driver, int time, WebElement element) {
		boolean res = false;
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		try {

			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;

	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null && elementFound(element)) {
			element.clear();
			element.sendKeys(name);
		}

	}

	public String getText(WebElement element) {
		String name = null;
		if (elementFound(element)) {
			name = element.getAttribute("value");
		}
		return name;

	}

	public void clickBtn(WebElement element) {
		if (elementFound(element)) {
			element.click();
		}
	}
	public void dropDownSelect(WebElement element,String name) {
		Select s=new Select(element) ;
		s.selectByValue(name);
	}
	public static void getScreenShot(String screenShotFileName) {
		File screenShotLocation = new File("./screenshot/" + screenShotFileName
				+ ".png");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, screenShotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<LoginPage> getTableInfo() {
		List<LoginPage> login = new ArrayList<LoginPage>();
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/selenium_schema", "root", "");
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM tbl_login WHERE fd_id = '4'");
			ResultSet rs = ps.executeQuery();
			LoginPage lp = new LoginPage(driver);
			while (rs.next()) {
				int id = rs.getInt("fd_id");
				String name = rs.getString("fd_user_name");
				String pass = rs.getString("fd_password");
				String ph = rs.getString("fd_phone");
				
				//lp.setTxtUserName(id);
				//lp.setName(name);
				//lp.setPassword(pass);
				//lp.setPhonenumber(ph);
				//login.add(lp);
				System.out.println("sucess");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}
	public static List<HashMap<String, String>> readValueFromExcelSheet() {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		try {
			File excelLocaltion = new File("./Excel/adactin.xlsx");

			String sheetName = "Data";

			FileInputStream f = new FileInputStream(
					excelLocaltion.getAbsolutePath());
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								currentCell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								String.valueOf(currentCell
										.getNumericCellValue()));

						break;

					}
				}

				mapDatasList.add(mapDatas);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return mapDatasList;

	}

}

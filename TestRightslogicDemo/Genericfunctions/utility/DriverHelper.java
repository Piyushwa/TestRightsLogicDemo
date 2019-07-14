package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import locators.AssetMaintenanceLocators;
import locators.CommonLocators;
import locators.FinanceLocators;
import locators.ListMaintenanceLocators;
import locators.RightsInLocators;
import locators.RightsOutLocators;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import excelDataBinding.Common_ExcelData;
import excelDataBinding.Excel_Reader;


public class DriverHelper implements Common_ExcelData,CommonLocators,RightsOutLocators,AssetMaintenanceLocators,RightsInLocators,ListMaintenanceLocators,FinanceLocators{


	public static WebDriver driver;
	/**
	 * className : It is used which excel file need to be accessed for Test Data
	 * e.g: AM_TestData.xlsx for AM related test classes
	 * RI_TestData.xlsx for RI related test classes
	 */
	public static String className;
	public Class<?> classObject;
	public static boolean TestCaseStatus = true; // true >> Passed, // false >> failed
	public static String TestMethodName = ""; 
	public static int NumberOfFailures = 0; 
	public static ExtentReports logger;
	public static Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\AM_TestData.xlsx");
	public static String ClientData = PropertyReader.readApplicationFile("Client");
   
	
	
	public static String downloadPath = "C:\\Downloads";
	public static String ClientName   = PropertyReader.readApplicationFile("Client");
	public static String URL          =  xlsInputData.getCellData("Login", ClientData, 2);
	public static String Username     =  xlsInputData.getCellData("Login", ClientData, 3);
	public static String Password     =  xlsInputData.getCellData("Login", ClientData, 4);
	public static String Browser      =  PropertyReader.readApplicationFile("Browser");
	public static Excel_Reader Current_xls ;
	public static List<String> ActualDropdownValues = new ArrayList<String>();
	public static List<String> ExpectedDropdownValues = new ArrayList<String>();
	public static int ImageNameForFramesFailures = 0;
	public static int ScreenshotFailureNumber = 0; 
	

	@BeforeSuite
	public void startLog(){
		
		logger = ExtentReports.get(classObject);
		logger.init(System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\" + className + "_" +getDateStamp().replace("/", "") + ".html", true);
		ExecutionLog.Log("********************Started Executiong the Test Suite at " + getTimeStamp()  +"******************");
	}

	public String locator_EditTAB_ColumnHeader;
	public String locator_EditTAB_ColumnDataRow;
	public String locator_ViewModeTAB_ColumnHeader;
	public String locator_ViewMode_ColumnDataRow;

	// This constructor is used to assign the locator of columns of Edit/View TAB specific to TAB
	public DriverHelper(String loc_EditTAB_ColumnHeader,
			String loc_EditTAB_ColumnDataRow,
			String loc_ViewModeTAB_ColumnHeader,
			String loc_ViewMode_ColumnDataRow) {

		locator_EditTAB_ColumnHeader = loc_EditTAB_ColumnHeader;
		locator_EditTAB_ColumnDataRow = loc_EditTAB_ColumnDataRow;
		locator_ViewModeTAB_ColumnHeader = loc_ViewModeTAB_ColumnHeader;
		locator_ViewMode_ColumnDataRow = loc_ViewMode_ColumnDataRow;
	}
	
	
	
	public DriverHelper() {

	}
	
	public static WebDriver getBrowser() throws Exception {
		if(className.contains("AM")) {
			Current_xls	= new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\AM_TestData.xlsx");
		} else if(className.contains("RI")) {
			Current_xls	= new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\RI_TestData.xlsx");
		} else if(className.contains("RO")) {
			Current_xls	= new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\RO_TestData.xlsx");
		}
		if (Browser.equalsIgnoreCase("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			ffprofile.setEnableNativeEvents(false);
			ffprofile.setPreference("browser.download.folderList", 2);
			ffprofile.setPreference("browser.download.manager.showWhenStarting", false);
			ffprofile.setPreference("browser.download.dir", downloadPath);
			ffprofile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			ffprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
			ffprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			ffprofile.setPreference("browser.download.manager.focusWhenStarting", false);
			ffprofile.setPreference("browser.download.manager.useWindow", false);
			ffprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
			ffprofile.setPreference("browser.download.manager.closeWhenDone", false);
			driver = new FirefoxDriver(ffprofile);
		} else if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			//driver=new ChromeDriver();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + System.getProperty("file.separator") + "IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			//caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			//caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability("unexpectedAlertBehaviour", "accept");
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("enablePersistentHover", false);
			caps.setCapability("requireWindowFocus", true);
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents",false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Initialization of global variables
		ExecutionLog.Log("Client: " + ClientName);
		ExecutionLog.Log("URL: " + URL);
		ExecutionLog.Log("UserName: " + Username);
		ExecutionLog.Log("Password: " + Password);

		// Navigate to Application and Login
		driver.navigate().to(URL);
		// Login into Application
		sendKeys("Loginctrl1_txtUserName", Username, "User Name","");
		clickOn("Loginctrl1_txtTempBox", "Temporary Check Box");
		sendKeys_WithoutClear("Loginctrl1_txtPassword", Password, "Password","");
		clickOn("Loginctrl1_LOGINBUTNEW", "LoginButton");
		Thread.sleep(6000);
		return driver;

	}	

	// To make use for future for parallel running
	public WebDriver getDriver() {
		return driver;
	}
	
	public static String getTimeStamp()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
		String dateTime =  dateFormat.format(cal.getTime());
		return dateTime;
	}
	

	public static void getScreenShotOnCheckpointFailure(String Methodname) throws IOException { 
		TestCaseStatus = false;
		NumberOfFailures++;
		Methodname = Methodname.replace("*", "").replace(":", "").replace(":", "").replace("+", "").replace(" ", "");
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String formattedDate1 = sdf1.format(date);
		String formattedDate2 = sdf2.format(date);
		String formattedDate3 = sdf3.format(date);
		String fileSeperator = System.getProperty("file.separator");

		String folderName1= formattedDate1;
		String folderName2= formattedDate2;
		String imagePath1 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator;
		String imagePath2 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator+"\\"+folderName2+fileSeperator;
		String imagePath3 = System.getProperty("user.dir")+"\\test-output\\AdvanceReport\\Screenshots\\";

		String imageName=Methodname.replace("*", "")+"_CheckpointFailure_"+formattedDate3+".jpg";


		File file1 = new File(imagePath1);
		if (!file1.exists()) {
			ExecutionLog.Log("File created " + file1);
			file1.mkdir();

			File file2 = new File(imagePath2);
			if (!file2.exists()) {
				ExecutionLog.Log("File created " + file2);
				file2.mkdir();
			}
		}

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File(imagePath2+imageName)); 
		FileUtils.copyFile(scrFile, new File(imagePath3+imageName));
		logger.attachScreenshot("./Screenshots/"+imageName);
		ExecutionLog.Log("ScreenShot of CheckPoint Failure: " + imagePath2+imageName);
		Reporter.log("<html><body><a href=\""+ imagePath2+imageName +"\"><img src=\"file:///" + imagePath2+imageName + "\" alt=\"\""+ "height='120' width='120'/></a> "+"<br></br></html></body>");
		
	} 

	/**
	 * @author Rajuddin
	 * @throws IOException 
	 * @description click on the given locator on the web Page
	 */
	public static void clickOn(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws IOException {

		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				driver.findElement(ByLocator(Locator)).click();
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				driver.findElement(ByLocator(Locator)).click();
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * 
	 * @param element
	 * @param WebElementName
	 * @param checkStatusFromExcel
	 * @throws IOException
	 */
	public static void clickOn(WebElement element, String WebElementName, Object... checkStatusFromExcel) throws IOException {

		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				element.click();
				ExecutionLog.Log("Clicked on the '" + WebElementName + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				element.click();
				ExecutionLog.Log("Clicked on the '" + WebElementName + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}

	}

	/**
	 * @author Rajuddin
	 * @description click on the given locator on the web Page
	 */
	public static void clickOnDisplayedElement(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) {
		List<WebElement> allElements = driver.findElements(ByLocator(Locator));
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				for(WebElement elem : allElements){
					if(elem.isDisplayed()){
						elem.click();
						ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
						break;
					}
				}

			}
		} catch (IndexOutOfBoundsException e) {
			// Click the object if nothing is passed in the clickStatus
			driver.findElement(ByLocator(Locator)).click();
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
		}

	}

	/**
	 * @author Rajuddin
	 * @description return the By of the passed locator in the parameter
	 * @param Locator
	 * @return By
	 */
	public static By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	/**
	 * @author Rajuddin
	 * @throws Exception 
	 * @description Enter the given value in the input field
	 */
	public static void sendKeys(String Locator, String TestData, String WebElementNameOfLocator, String LabelNameFromExcel) throws Exception {

		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Assert.assertTrue(isElementPresent(Locator));

				WebElement elem;
				try {
					elem = driver.findElement(ByLocator(Locator));
					elem.clear();
				} catch (Exception e) {

				}
				elem = driver.findElement(ByLocator(Locator));
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	}

	/**
	 * @author Rajuddin
	 * @throws Exception 
	 * @description Enter the given value in the input field
	 */
	public static void sendKeys_WithoutClear(String Locator, String TestData, String WebElementNameOfLocator, String LabelNameFromExcel) throws Exception {

		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Assert.assertTrue(isElementPresent(Locator));
				WebElement elem = driver.findElement(ByLocator(Locator));
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	}

	/**
	 * @author Rajuddin
	 * @throws IOException 
	 * @description click using Java Script Executor
	 */
	public static void clickUsingJSExecutor(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws IOException {
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click(true)",driver.findElement(ByLocator(Locator)));
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			}
		} catch (IndexOutOfBoundsException e) {			
			try {
				// Click the object if nothing is passed in the clickStatus
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(ByLocator(Locator)));
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e1.printStackTrace();
			} 
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}

	/**
	 * @author Rajuddin
	 * @description Move mouse over the WebElement
	 */
	public static void moveMouse(String Locator, String WebElementNameOfLocator) {
		try {
			Actions act = new Actions(driver);
			WebElement elem = driver.findElement(ByLocator(Locator));
			act.moveToElement(elem).build().perform();
			ExecutionLog.Log("Moved Mouse over '" + WebElementNameOfLocator + "'");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @author Rajuddin
	 * @throws IOException 
	 * @description Double Click on the Webelement
	 */
	public static void doubleClick(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws Exception {


		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.doubleClick(elem).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.doubleClick(elem).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");
			} catch (Exception e2) {  
				// If the locator is not foundExecutionLog.Log("Could not find the locator: " + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
				
			}

		} catch (Exception e) { // If the locator is not found
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param element
	 * @param WebElementName
	 * @param checkStatusFromExcel
	 * @throws IOException
	 */
	public static void doubleClick(WebElement element, String WebElementName, Object... checkStatusFromExcel) throws IOException {

		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				Actions act = new Actions(driver);
				act.doubleClick(element).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementName + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				Actions act = new Actions(driver);
				act.doubleClick(element).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementName + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}

	}
	
	/**
	 * @author Rajuddin
	 * @description Verify that the text is present on the webpage
	 * @return Elemet Status, true: if present on the page else false
	 */
	public static Boolean isElementPresent(String Locator) {
		boolean flag = false;
		List<WebElement> elemList = driver.findElements(ByLocator(Locator));
		if(elemList.size()>0) {
			flag = true;
		}
		return flag;

	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @throws Exception
	 *  @description Verify that the Webelement is present on the webpage
	 */
	public static void verifyElementPresent(String Locator, String NameOfLocator, Object... checkStatusFromExcel) throws Exception {
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))){
				try {
					Assert.assertTrue(isElementPresent(Locator));
					logger.log(LogStatus.PASS, "\"" + NameOfLocator + "\" is Present");
					ExecutionLog.Log ("\"" + NameOfLocator + "\" is Present");
				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL, "====Failed==== \""+NameOfLocator+"\"  does not exist.");
					ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
					getScreenShotOnCheckpointFailure(NameOfLocator);
					e.printStackTrace();
				}
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				Assert.assertTrue(isElementPresent(Locator));
				logger.log(LogStatus.PASS,"\"" + NameOfLocator + "\" is Present" );
				ExecutionLog.Log ("\"" + NameOfLocator + "\" is Present");
			} catch (AssertionError e1) {
				ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
				logger.log(LogStatus.FAIL, "====Failed==== \""+NameOfLocator+"\"  does not exist.");
				getScreenShotOnCheckpointFailure(NameOfLocator);
				e1.printStackTrace();
			}
		}

	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param ElementName
	 * @param runStatusFromExcel
	 * @throws Exception
	 */
	public static void verifyElementDisplayed(String Locator, String ElementName, String runStatusFromExcel) throws Exception {
		if(!runStatusFromExcel.contains("N/A")){
			try {
				if(isElementPresent(Locator)) {

					try {
						Assert.assertTrue(driver.findElement(ByLocator(Locator)).isDisplayed());
						logger.log(LogStatus.PASS,"Verified that Expected value :["+ElementName+"] is displayed" );
						ExecutionLog.Log ("Verified that Expected value :["+ElementName+"] is displayed");

					} catch (AssertionError e) {
						logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+ElementName+"] is not displayed"  );
						ExecutionLog.Log("====Failed==== Expected value is:["+ElementName+"] is not displayed" );
						getScreenShotOnCheckpointFailure(ElementName);
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				logger.log(LogStatus.FAIL,"====Failed====\"" + ElementName + "\" is not Present");
				ExecutionLog.Log("====Failed====\"" + ElementName + "\" is not Present");
				getScreenShotOnCheckpointFailure(ElementName);
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param ElementName
	 * @param runStatusFromExcel
	 * @description VErify that Element is present on the page but Not Displayed to the end-user
	 * @throws Exception
	 */
	public static void verifyElementNotDisplayed(String Locator, String ElementName, String runStatusFromExcel) throws Exception {
		if(!runStatusFromExcel.contains("N/A")){
			try {
				try {
					Assert.assertFalse(driver.findElement(ByLocator(Locator)).isDisplayed());
					logger.log(LogStatus.PASS,"Verified that ["+ElementName+"] is not displayed");
					ExecutionLog.Log ("Verified that ["+ElementName+"] is not displayed");

				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL,"====Failed==== ["+ElementName+"] is displayed");
					ExecutionLog.Log("====Failed==== ["+ElementName+"] is displayed" );
					getScreenShotOnCheckpointFailure(ElementName);
					e.printStackTrace();
				}
			} catch (Exception e) {
				logger.log(LogStatus.FAIL,"====Failed====\"" + ElementName + "\" is Present OR Locator Issue");
				ExecutionLog.Log("====Failed====\"" + ElementName + "\" is Present OR Locator Issue");
				getScreenShotOnCheckpointFailure(ElementName);
				e.printStackTrace();
			}

		}
	}

	/**
	 * @author Rajuddin
	 * @param Actual : used getText from the application
	 * @param Expected
	 * @throws Exception
	 * 
	 * This method is used to verify the values in the row of any edit/View window of any TAB
	 *  
	 */
	public static void verifyFieldValueOfHeader(String Locator, String Expected , String WebElementNameOfLocator, String HeaderNameFromExcel) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ActualText = getText(Locator);
					Assert.assertTrue(ActualText.length()==0);
					logger.log(LogStatus.PASS, "Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL,"====Failed====\"Either Expected Value is not given OR '" + WebElementNameOfLocator + "'\" Element is not Present");
					ExecutionLog.Log("====Failed====\"Either Expected Value is not given OR '" + WebElementNameOfLocator + "'\" Element is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {

				try {
					Assert.assertTrue(isElementPresent(Locator));  // Will throw Assertion Error if failed
					ActualText = getText(Locator);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.PASS,"Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");
					ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]");
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}


	}

	/**
	 * @author Rajuddin
	 * @param Actual : used getText from the application
	 * @param Expected
	 * @throws Exception
	 * 
	 * This method is used to verify the values in the row of any edit/View window of any TAB
	 *  
	 */
	public static void verifyFieldValueOfHeader(String Locator, String Expected, String WebElementNameOfLocator, String HeaderNameFromExcel, String attributeValue) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ActualText = getAttribute(Locator,attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					logger.log(LogStatus.PASS, "Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					logger.log(LogStatus.FAIL, "====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {
				try {
					Assert.assertTrue(isElementPresent(Locator));  // Will throw Assertion Error if failed
					ActualText = getAttribute(Locator,attributeValue);// Will throw Exception if failed
					if(!Expected.equals("null") ) {
						Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						logger.log(LogStatus.PASS,"Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}
					else if(Expected.equals("null") ) { // Is very useful for the verification of check boxes at deal agreement
						ActualText = ActualText + "";
						boolean conditionCheck =false;
						if(ActualText.equals("null")) {
							conditionCheck = true;
						}
						Assert.assertTrue(conditionCheck);
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}

				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]" );
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
}
	

	/**
	 * @author Rajuddin
	 * @param Actual : used getText from the application
	 * @param Expected
	 * @throws Exception
	 * 
	 * This method is used to verify the values in the row of any edit/View window of any TAB
	 *  
	 */
	public static void verifyFieldValueOfHeader(WebElement elem, String Expected, String WebElementNameOfLocator, String HeaderNameFromExcel, String attributeValue) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {

					ActualText = elem.getAttribute(attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					logger.log(LogStatus.PASS, "Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					logger.log(LogStatus.FAIL, "====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {

				try {
					ActualText = elem.getAttribute(attributeValue);// Will throw Exception if failed
					if(!Expected.equals("null") ) {
						Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						logger.log(LogStatus.PASS,"Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}
					else if(Expected.equals("null") ) { // Is very useful for the verification of check boxes at deal agreement
						ActualText = ActualText + "";
						boolean conditionCheck =false;
						if(ActualText.equals("null")) {
							conditionCheck = true;
						}
						Assert.assertTrue(conditionCheck);
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}

				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]" );
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					logger.log(LogStatus.FAIL,"====Failed====\"" + WebElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
}
	
	/**
	 * @author Rajuddin
	 * @param Actual 
	 * @param expected
	 * @throws Exception
	 */
	public static void verifyTextMatches(String locator, String webElementNameOfLocator, String expected, String attributeValue) throws Exception {
		String ActualText = "";
		if(!expected.contains("N/A")){
			if(expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(locator));
					ActualText = getAttribute(locator,attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);

				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					logger.log(LogStatus.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else { 

				try {
					Assert.assertTrue(isElementPresent(locator));  // Will throw Assertion Error if failed
					ActualText = getAttribute(locator,attributeValue);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.PASS, "Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
					ExecutionLog.Log ("Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present" );
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * @author Rajuddin
	 * @param Actual : used getText from the application
	 * @param expected
	 * @throws Exception
	 */
	public static void verifyTextMatches(String locator, String webElementNameOfLocator, String expected) throws Exception {
		String ActualText ="";
		if(!expected.contains("N/A")){
			if(expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(locator));
					ActualText = getText(locator);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					logger.log(LogStatus.PASS, "Verified that \"" + webElementNameOfLocator + "\" is Blank");

				} catch (Exception e) {
					logger.log(LogStatus.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (AssertionError e) {
					logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is ["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {
				try {
					Assert.assertTrue(isElementPresent(locator));  // Will throw Assertion Error if failed
					ActualText = getText(locator);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.PASS, "Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
					ExecutionLog.Log ("Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					logger.log(LogStatus.FAIL, "====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * @author Rajuddin
	 * @param locator
	 * @param webElementNameOfLocator
	 * @throws Exception
	 * @description Verify that the Element is not present on the webpage
	 */
	public static void verifyElementNotPresent(String locator, String webElementNameOfLocator) throws Exception {
		try {
			Assert.assertFalse(isElementPresent(locator));
			logger.log(LogStatus.PASS,"\"" + webElementNameOfLocator + "\" is disable or not Present" );
			ExecutionLog.Log ("\"" + webElementNameOfLocator + "\" is disable or not Present");
		} catch (AssertionError e) {
			ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
			logger.log(LogStatus.FAIL,"====Failed==== \""+webElementNameOfLocator+"\"  should not be shown" );
			ExecutionLog.Log("====Failed==== \""+webElementNameOfLocator+"\"  should not be shown");
			getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}
	}

	/**
	 * @author Rajuddin
	 * @param LocatorOfFrame
	 * @throws IOException 
	 * @description Switch the driver into the frame
	 */
	public static void switchIntoFrame(String LocatorOfFrame, Object... objects ) throws IOException {
		try {
			if(!(objects[0].equals("N/A"))){
				driver.switchTo().defaultContent();
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));

			}
			// if throwing exception then switch into frame
		} catch (IndexOutOfBoundsException e) {
			try {
				driver.switchTo().defaultContent();
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));
			} catch (Exception e2) {
				ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
				getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
				ExecutionLog.Log(e2.getMessage());
				ImageNameForFramesFailures++;
			}

		} catch(Exception e1) {
			ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
			getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
			e1.printStackTrace();
			ImageNameForFramesFailures++;
		}

	}

	public static void switchIntoChildFrame(String LocatorOfFrame, Object... objects) throws Exception {
		try {
			if(!(objects[0].equals("N/A"))){
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));

			}
			// if throwing exception then switch into frame
		} catch (IndexOutOfBoundsException e) {
			try {
				WebElement frameParent = null;
				if (LocatorOfFrame.startsWith("//")) {
					frameParent = driver.findElement(ByLocator(LocatorOfFrame));
				} else {
					frameParent = driver.findElement(By.cssSelector(LocatorOfFrame));
				}
				driver.switchTo().frame(frameParent.findElement(By.tagName("iframe")));
			} catch (Exception e2) {
				ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
				getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
				e2.printStackTrace();
				ImageNameForFramesFailures++;
			}

		} catch(Exception e1) {
			ExecutionLog.Log("====Failed==== \" Could not find the Frame: " + LocatorOfFrame);
			getScreenShotOnCheckpointFailure("FrameSwitchingFailed" + ImageNameForFramesFailures);
			e1.printStackTrace();
			ImageNameForFramesFailures++;
		}
	}

	/**
	 * @author Rajuddin
	 * @param LocatorOfFrame
	 * @description Switch the driver out from the current frame
	 */
	public static void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @return Text of the Webelement
	 */
	public static String getText(String Locator){
		String text = "==========Failed==========No Text Available on Web Page";
		if(isElementPresent(Locator)) {
			text = driver.findElement(ByLocator(Locator)).getText();
		}
		return text;
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @return value of the attribute of Webelement
	 */
	public static String getAttribute(String Locator, String Attribute){
		String AttributeValue = "No element is present on Web Page (DriverHelper.getAttribute())";
		if(isElementPresent(Locator)) {
			AttributeValue = driver.findElement(ByLocator(Locator)).getAttribute(Attribute);
		}
		return AttributeValue;
	}
	/**
	 * @author Rajuddin
	 * @return the time stamp in format MM/dd/yyyy
	 */
	public static String getDateStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 *  @description : Valid for the elements which are tagged with "Select and Options" TAG
	 * @return return All available values of the Drop Down
	 * @throws Exception 
	 * 
	 */
	public static String getAllOptions(String Locator, String WebElementNameOfLocator) throws Exception{
		StringBuffer allText = new StringBuffer();
		try {
			Select select = new Select(driver.findElement(ByLocator(Locator)));
			List<WebElement> allOptions = select.getOptions();
			
			for( WebElement elem : allOptions) {
				allText.append(elem.getText());
				allText.append("\n");

			}
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
		}
		
		//ExecutionLog.Log("All Drop Down values of " + NameOfLocator + " are:");
		ExecutionLog.Log(allText+"");

		return allText + "";
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param DropDownValue : Pass the Text of Dropdown
	 * @throws Exception 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 * Select the value in the drop down list
	 */
	public static void selectDropdownValue(String DropDownLocator, String DropDownLabelName, String DropDownValue, String LabelNameFromExcel) throws Exception{
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				select.selectByVisibleText(DropDownValue);
				ExecutionLog.Log("Selected \"" + DropDownValue + "\" in \"" +DropDownLabelName + "\" drop down");
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== \"" + DropDownValue + "\" is not present in '" + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param DropDownValue : Pass the Text of Dropdown
	 * @throws Exception 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 * Select the value in the drop down list
	 */
	public static void selectDropdownValueByIndex(String DropDownLocator, String DropDownLabelName, int indexNumber, String LabelNameFromExcel) throws Exception{
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				select.selectByIndex(indexNumber);
				ExecutionLog.Log("Selected \"" + indexNumber + "\" number's value in \"" +DropDownLabelName + "\" drop down");
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== \"" + indexNumber + "\" number's value is not present in '" + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}
	}

	
	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param DropDownValue : Pass the Text of Dropdown
	 * @throws Exception 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 *  Verify the First Value of the drop down
	 */
	public static void verifyFirstSelectedDropdownValue(String DropDownLocator, String DropDownLabelName, String ExpectedValue, String LabelNameFromExcel) throws Exception{
		String actualSelectedValue = "no element on the web Page";
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				actualSelectedValue = new Select(driver.findElement(ByLocator(DropDownLocator))).getFirstSelectedOption().getText().trim();
				Assert.assertEquals(actualSelectedValue, ExpectedValue.trim());
				logger.log(LogStatus.PASS,"Verified that Expected value :["+ExpectedValue+"] is matched with Actual value :["+actualSelectedValue+"]" );
				ExecutionLog.Log ("Verified that Expected value :["+ExpectedValue+"] is matched with Actual value :["+actualSelectedValue+"]");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]" );
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
			catch (Exception e) {
				logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]");
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param DropDownValue : Pass the Text of Dropdown
	 * @throws Exception 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 *  Verify the First Value of the drop down
	 */
	public static void verifyFirstSelectedDropdownValue(String DropDownLocator, String DropDownLabelName, String ExpectedValue, String LabelNameFromExcel, String AttibuteValue) throws Exception{
		String actualSelectedValue = "no element on the web Page";
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				actualSelectedValue = new Select(driver.findElement(ByLocator(DropDownLocator))).getFirstSelectedOption().getAttribute(AttibuteValue);
				Assert.assertEquals(actualSelectedValue, ExpectedValue);
				logger.log(LogStatus.PASS,"Verified that Expected value :["+ExpectedValue+"] is matched with Actual value :["+actualSelectedValue+"]" );
				ExecutionLog.Log ("Verified that Expected value :["+ExpectedValue+"] is matched with Actual value :["+actualSelectedValue+"]");
			} catch (AssertionError e) {
				logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]" );
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
			catch (Exception e) {
				logger.log(LogStatus.FAIL,"====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]]" );
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @return return All Selected Values of the Drop Down
	 */
	public static String getAllSeletedOptions(String Locator, String NameOfLocator){
		Select select = new Select(driver.findElement(ByLocator(Locator)));
		List<WebElement> allOptionsSelected = select.getAllSelectedOptions();
		StringBuffer allText = new StringBuffer();
		for( WebElement elem : allOptionsSelected) {
			allText.append(elem.getText());
			allText.append("\n");
		}
		ExecutionLog.Log("All Drop Down values of " + NameOfLocator + " are:\n");
		ExecutionLog.Log(allText+"");
		return allText + "";
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @return return All Selected Values of the Drop Down
	 * @throws Exception 
	 */
	public static void verifySeletedOptions(String Locator, String ExpectedValue, String NameOfLocator) throws Exception{

		try {
			Select select = new Select(driver.findElement(ByLocator(Locator)));
			List<WebElement> allOptionsSelected = select.getAllSelectedOptions();
			StringBuffer allText = new StringBuffer();
			for( WebElement elem : allOptionsSelected) {
				allText.append(elem.getText());
				allText.append("\n");
			}
			String allSelectedText = allText + "";
			Assert.assertTrue(allSelectedText.contains(ExpectedValue));
			logger.log(LogStatus.PASS,"Verified that"+ ExpectedValue + " is selected in drop down "+ NameOfLocator );
			ExecutionLog.Log("Verified that"+ ExpectedValue + " is selected in drop down "+ NameOfLocator);
		} catch (AssertionError e) {
			logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]");
			ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]. Please check the screenshot with name: \"" + NameOfLocator +"\" for more details" );
			getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
			e.printStackTrace();
		}  catch (Exception e1) {
			logger.log(LogStatus.FAIL, "====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]");
			ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]. Please check the screenshot with name: \"" + NameOfLocator +"\" for more details. " );
			getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
			e1.printStackTrace();
		}


	}
	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @return return all Values of the Drop Down
	 */
	public static String getAll(String Locator, String NameOfLocator){
		Select select = new Select(driver.findElement(ByLocator(Locator)));
		List<WebElement> allOptionsSelected = select.getOptions();
		StringBuffer allText = new StringBuffer();
		for( WebElement elem : allOptionsSelected) {
			allText.append(elem.getText());
			allText.append("\n");
		}
		ExecutionLog.Log("All Drop Down values of " + NameOfLocator + " are:\n");
		ExecutionLog.Log(allText+"");
		return allText + "";
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @return All Selected Values of the Drop Down
	 * @throws Exception 
	 * 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 * Verify All available drop down values
	 */
	public static void verifyDropDownValues(String Locator, String NameOfLocator, String SheetName, int RowNumstart, int RowNumEnd) throws Exception{
		ActualDropdownValues.clear();
		ExpectedDropdownValues.clear();
		if(!(Current_xls.getCellData(SheetName, ClientData, RowNumstart).contains("N/A"))) {
			Select select = new Select(driver.findElement(ByLocator(Locator)));
			List<WebElement> allOptionsSelected = select.getOptions();
			for( WebElement elem : allOptionsSelected) {
				ActualDropdownValues.add(elem.getText());
			}
			int data =0;
			for(int i = RowNumstart; i<=RowNumEnd; i++) {
				if(Current_xls.getCellData(SheetName, ClientData, i).contains("N/A")){
					break;
				}
				ExpectedDropdownValues.add(Current_xls.getCellData(SheetName, ClientData, i));
				data++;
			}
			ExecutionLog.Log("Drop Down values of " + NameOfLocator +" are: ");
			ExecutionLog.Log("Actual Drop Down Values are: \n" + ActualDropdownValues);
			ExecutionLog.Log("Expected Drop Down Values are: \n" + ExpectedDropdownValues);
			try {
				Assert.assertTrue(ActualDropdownValues.size()==ExpectedDropdownValues.size(), "=========Failed=======Actual Dropdown values of "+ NameOfLocator + " drop down are:[" + ActualDropdownValues.size()+ "]" + " BUT Expected Dropdown values are:[" + ExpectedDropdownValues.size()+ "]");

			} catch (AssertionError e) {
				getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
				e.printStackTrace();;
			}
			ExecutionLog.Log("Total Number of Dropdown Valus in " + NameOfLocator + ":" +ActualDropdownValues.size());
			for ( int j = 0; j<ActualDropdownValues.size(); j++) {
				try {
					Assert.assertTrue(ExpectedDropdownValues.contains(ActualDropdownValues.get(j)));
					ExecutionLog.Log("Verified that [" + ActualDropdownValues.get(j) +"] is present in the dropdown " +  NameOfLocator);

				} catch (AssertionError e) {
					ExecutionLog.Log("=========Failed=======Actual Dropdown values of "+ NameOfLocator + "Does not match Expected ["+ExpectedDropdownValues.get(j)+"]" +"But Actual is [" + ActualDropdownValues.get(j) +"]");
					getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
					e.printStackTrace();;
				}
			}
		}

	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @return All Selected Values of the Drop Down
	 * @throws Exception 
	 * 
	 * @description : Valid for the elements which are tagged with "Select and Options" TAG
	 * Verify the Expected value is present in the Drop down
	 */
	public static void verifyDropDownValues(String Locator, String NameOfLocator, String Expected) throws Exception{
		ActualDropdownValues.clear();
		if(!(Expected.contains("N/A"))) {
			try {
				Select select = new Select(driver.findElement(ByLocator(Locator)));
				List<WebElement> allOptionsSelected = select.getOptions();
				for( WebElement elem : allOptionsSelected) {
					ActualDropdownValues.add(elem.getText());
				}
				Assert.assertTrue(ActualDropdownValues.contains(Expected));
				ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is present in the " + NameOfLocator + " drop down");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] is not present in the " + NameOfLocator + " drop down. please see the screenshot: " + Expected +"for more details" );
				getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));	
				e.printStackTrace();
			}

			catch (Exception e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] is not present in the " + NameOfLocator + " drop down. please see the screenshot: " + Expected +"for more details" );
				getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));	
				e.printStackTrace();		
			}
		}
	}

	/**
	 * @author Rajuddin
	 * @param Locator
	 * @param NameOfLocator
	 * @throws Exception 
	 * @description : verify all values of ul and li TAG
	 */
	public static void verifyAllAvailableValues(String Locator, String NameOfLocator, String SheetName, int RowNumstart, String runStatus_ExcelData) throws Exception{

		if(!(runStatus_ExcelData.contains("N/A"))){
			List<WebElement> Versiontypedropdown = driver.findElements(ByLocator(Locator)); 
			for (WebElement element: Versiontypedropdown) {
				String expectedValue = Current_xls.getCellData(SheetName, ClientData, RowNumstart);
				if(!(expectedValue.contains("N/A"))){
					String actualValue = element.getAttribute("innerHTML");
					try {
						Assert.assertTrue(actualValue.contains(expectedValue));
						ExecutionLog.Log("Verified that Expected value :[" + expectedValue + "] is matched with Actual value :[" + actualValue + "]");
					} catch (AssertionError e) {
						ExecutionLog.Log("=====Failed===== Expected value :[" + expectedValue + "] is matched with Actual value :[" + actualValue + "]");
						getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
						e.printStackTrace();
					}

				}  if(expectedValue.contains("N/A")){
					break;

				}
				RowNumstart = RowNumstart + 1;
			}

		}
	}

	public static void WaitForModalPanel() {
		try {
		driver.switchTo().window(driver.getWindowHandle());
		String element_xpath = "//*[@id='WebDialogWindow_RL_Progress']";
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element_xpath)));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static WebElement WaitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
	}
	
	public static void WaitForElementPresent(String locator, Object...runStatusFromExcel) throws Exception{
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					WebDriverWait wait = new WebDriverWait(driver,90);
					wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
				} catch (Exception e) {
					ExecutionLog.Log("===Failed=== Could not find the locator: " + locator);
					getScreenShotOnCheckpointFailure("WaitForElement" + ScreenshotFailureNumber);
					e.printStackTrace();	
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}


	} 

	public static WebElement WaitForElementToClickable(By locator){
		WebDriverWait wait = new WebDriverWait(driver,90);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void WaitForElementToClickable(String locator, Object...runStatusFromExcel) throws Exception{
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					sleepTime(4);
					WebDriverWait wait = new WebDriverWait(driver,90);
					wait.until(ExpectedConditions.elementToBeClickable(ByLocator(locator)));
				} catch (Exception e) {
					ExecutionLog.Log("Could Not find the element with Locator:" + locator);
					getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
					e.printStackTrace();	
				}	
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				WebDriverWait wait = new WebDriverWait(driver,90);
				wait.until(ExpectedConditions.elementToBeClickable(ByLocator(locator)));
			} catch (Exception e2) {
				ExecutionLog.Log("Could Not find the element with Locator:" + locator);
				getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
				e.printStackTrace();	
			}	
		} catch(Exception e) {
			ExecutionLog.Log("Could Not find the element with Locator:" + locator);
			getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
			e.printStackTrace();
		}
		
	}

	// This method need to be replaced
	public static void AlertMessage (WebElement Ele, String AlertName) throws IOException {
		WebElement alert = Ele;
		if (alert.isDisplayed()){
			ExecutionLog.Log("Alert message is Pass");
			String Alertmsg = Ele.getText();
			ExecutionLog.Log( Alertmsg);
		}
		else
		{
			ExecutionLog.Log("Alert message is Fail");
			getScreenShotOnCheckpointFailure(AlertName.replace("*", ""));
		}

	}

	public static void acceptAlert(Object...runStatusFromExcel) throws IOException {
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					ExecutionLog.Log("Accepted Alert");
				} catch (Exception e) {
					ExecutionLog.Log("=======Passing this Message instead of Exception to avoid PAUSE of execution=====");
					ExecutionLog.Log("Alert was not Present");
				}

			}
		} catch (Exception e) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				ExecutionLog.Log("Accepted Alert");
			} catch (Exception e2) {
				ExecutionLog.Log("=======Passing this Message instead of Exception to avoid PAUSE of execution=====");
				ExecutionLog.Log("Alert was not Present");
			}
		}

	}

	/**
	 * @author Rajuddin
	 * @param rowNumber: row number from the table of Application 
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(locator_EditTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

	public String getLocator_ViewTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(locator_ViewModeTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = locator_ViewMode_ColumnDataRow + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

	//To get the Grid column key name and its index values 
	protected static Map<String, Integer> GridColumns = new HashMap<>();

	public static void SetupGridColumns(String GridPath) throws Exception
	{
		List<WebElement> Columnssize = driver.findElements(By.xpath(GridPath));
		System.out.println("Display the key/value of HashMap.");
		for (int getcolvalue=1; getcolvalue <= Columnssize.size();getcolvalue++){
			WebElement Scrollcolumn = driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]"));
			scrollElementIntoView(Scrollcolumn);
			if(driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]")).isDisplayed()){
				String Keyvalues = driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]")).getAttribute("key");

				GridColumns.put(Keyvalues,getcolvalue);
			}

		}
		
	}

	protected Map<String, Integer> GridColumns_Child = new HashMap<>();
	
	public void SetupGridColumns_Child(String GridPath) throws Exception {
		List<WebElement> Columnssize = driver.findElements(By.xpath(GridPath));

		for (int getcolvalue=1; getcolvalue <= Columnssize.size();getcolvalue++){
			WebElement Scrollcolumn = driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]"));
			scrollElementIntoView(Scrollcolumn);
			if(driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]")).isDisplayed()){
				String Keyvalues = driver.findElement(By.xpath(GridPath+"["+getcolvalue+"]")).getAttribute("key");
				GridColumns_Child.put(Keyvalues,getcolvalue);
			}

		}
	}

	public void PrintGridColumns()
	{
		for (Entry<String, Integer> entry : GridColumns.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.printf("%S %S\n", key, value);
		}
	}

	public static void scrollElementIntoView(WebElement element, Object... checkStatusFromExcel) throws Exception {
		ScreenshotFailureNumber++;
		// This try block handles Index out of Bound exception
		try {
			if(!checkStatusFromExcel[0].toString().contains("N/A")) {
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				} catch (Exception e) {
					ExecutionLog.Log("Could not Scroll Element in View Range: " + checkStatusFromExcel[0]);
					getScreenShotOnCheckpointFailure("ScrollIssue" + ScreenshotFailureNumber);	
					e.printStackTrace();
				}
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e1) {
				getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
				e1.printStackTrace();
			} 
		} catch (Exception e2) {
			getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
			e2.printStackTrace();	
		}

	}
	
	public static void scrollElementIntoView(String Locator, Object... checkStatusFromExcel_HorizontalScrollLocator) throws Exception {
		ScreenshotFailureNumber++;
		// This try block handles Index out of Bound exception
		try {
			if(!checkStatusFromExcel_HorizontalScrollLocator[0].toString().contains("N/A")) {
				
				if(Browser.equalsIgnoreCase("firefox")) {
				  WebElement Image = driver.findElement(By.xpath(Locator));			        
			        //Used points class to get x and y coordinates of element.
			        Point point = Image.getLocation();
			        int xcord = point.getX();
					Actions builder =new Actions(driver);
					builder.dragAndDropBy(driver.findElement(By.xpath(checkStatusFromExcel_HorizontalScrollLocator[1].toString())),xcord,0).build().perform();
				} 
				else{
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ByLocator(Locator)));
					} catch (Exception e) {
						ExecutionLog.Log("Could not Scroll Element in View Range: " + checkStatusFromExcel_HorizontalScrollLocator[0]);
						getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
						e.printStackTrace();
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ByLocator(Locator)));
			} catch (Exception e1) {
				ExecutionLog.Log("Could not Scroll Element in View Range: ");
				getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
				e1.printStackTrace();
			}
		} catch (Exception e2) {
			ExecutionLog.Log("Could not Scroll Element in View Range: ");
			getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
			e2.printStackTrace();
		}

	}

	/**
	 * @author Rajuddin
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return The idx value of the header	 
	 * @description default =1 to avoid null Pointer Exception if the header is not available. 
	 * Th Format to use to click on the field of respective Header:
	 * String loc_NetworkHeaderFirstRow = DataRow1XpathAMVersionEdit + "[rowNumber]/td[contains(@aria-describedby,'"+ getIDxValue+"')]";
	 * 
	 * you can remove rownumber if not required
	 */
	public String getIDxValue(String headerPath, String keyValue, String ExcelFromHeader){
		String idxValue = "2";
		if(!(ExcelFromHeader.contains("N/A"))){
			String loc_NWHeader = headerPath+"[@key='"+keyValue+"']";
			idxValue =  getAttribute(loc_NWHeader, "idx");
		} 
		return idxValue;
	}

	/**
	 * Observation : When more than 2 classes are used in the Header then 2nd last class is common with the class of data row
	 * @param ClassValue
	 * @return
	 */
	public static String loc_FilterClassValue(String ClassValue) {
		String[] hexClass = ClassValue.split(" ");
		String requiredClass = "filterClassValue(String ClassValue)";
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					requiredClass = hexValue;
					break;
				}
				requiredClass = "No_Attribute_Value";
			}
		} else {
			requiredClass = hexClass[1];
			
		}
		return requiredClass;
	}
	
	/**
	 * @author Rajuddin
	 * @param text
	 * @return colored text(blue)
	 * @description : This method is used inside the ExecutionLog.Log()
	 * It will color the text in the Test NG Report
	 */
	public static String color(String color, String text) {
		String coloredtext  = "<span style=\"color:"+ color + ";\">"+text+"</span>";
		return coloredtext;
	}

	public static void Enter(){
		
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	public static void ValidationMessageInPage (String ActualText, String ExpectedText, String WebElementName) throws IOException{
		try
		{
			Assert.assertEquals(ActualText, ExpectedText);
			ExecutionLog.Log("Verifying the data of " + WebElementName.replace("*", "") + "does not match");
			ExecutionLog.Log ("Verified that Expected value :["+ExpectedText+"] is matched with Actual value :["+ActualText+"]");

		}
		catch (AssertionError e)
		{
			ExecutionLog.Log("Verifying the data of " + WebElementName.replace("*", ""));
			ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedText+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + ExpectedText +"for more details" );
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}
		
	}
	
	

	public static void verifyFalseCondition (boolean condition, String WebElementName) throws IOException{
		try
		{
			Assert.assertFalse(condition);
			logger.log(LogStatus.PASS,"Verified the data of " + WebElementName.replace("*", "") );
			ExecutionLog.Log("Verified the data of " + WebElementName.replace("*", ""));

		}
		catch (AssertionError e)
		{
			logger.log(LogStatus.FAIL,"Verifying the data of " + WebElementName.replace("*", "") );
			ExecutionLog.Log("Verifying the data of " + WebElementName.replace("*", ""));
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}
		
	}
	
	public static void verifyTrueCondition (boolean condition, String WebElementName) throws IOException{
		try
		{
			Assert.assertTrue(condition);
			logger.log(LogStatus.PASS,"Verified the data of " + WebElementName.replace("*", "") );
			ExecutionLog.Log("Verified the data of " + WebElementName.replace("*", ""));

		}
		catch (AssertionError e)
		{
			logger.log(LogStatus.FAIL,"Verifying the data of " + WebElementName.replace("*", "") );
			ExecutionLog.Log("Verifying the data of " + WebElementName.replace("*", ""));
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}
		
	}

	public String getClassValue(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_NWHeader = headerPath+"[@key='"+keyValue+"']";
			classValue =  getAttribute(loc_NWHeader, "class");
		} 
		return classValue;
	}
	
	public void scriptStatus() {
		// if TestCaseStatus is false(failed) then fail terminate the test case
		if(!TestCaseStatus) {			
			//ExecutionLog.Log();
			throw new TestException("\"" + NumberOfFailures + "\" Validations are Failed in the Test Case: \"" + TestMethodName + "\"" + " of Module \"" + className + "\"");
			
		}
	}
	
	public static void sleepTime(int TimeInSeconds) throws Exception{
		Thread.sleep(TimeInSeconds*1000);
	}

	/**
	 * @author Rajuddin
	 * Pass the parameters(days,month,year) which need to added in the given date(date_StringFormat)
	 * @param date_StringFormat :  <b><span style="color:blue";>MM/dd/yyyy </span></b>
	 * @param month  : Pass the number of month which needs to be added in @param date_StringFormat
	 * @param days   : Pass the number of days which needs to be added in @param date_StringFormat
	 * @param year   : Pass the number of year which needs to be added in @param date_StringFormat
	 * @return
	 * 
	 * {@link Description} : Pass the value in Minus if There is a requirement to subtract day,month or year
	 */
	public static String addDays(String date_StringFormat, int month, int days,  int year) throws Exception {
		DateFormat dateFormat ;
		if(ClientData.contains("VMN") ||ClientData.contains("AMCN") ) {
			// Change the String into Date Data Type in the given Format
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			System.out.println("For Other");
			// Change the String into Date Data Type in the given Format
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		
		Date Date_DateFormat = dateFormat.parse(date_StringFormat); 
		// Parse Method converts a "String" into a "Date" Data Type in the given Format
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(Date_DateFormat);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_MONTH, days);
		// Change the "Date" Data Type into the "String" Data Type in the given Format
		return dateFormat.format(cal.getTime());
		
	}
	
	public static void WaitForModalPanel(String loc)
	{
		driver.switchTo().window(driver.getWindowHandle()); 
		try {
		String element_xpath = loc;
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element_xpath)));
		Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void keyboard() throws Exception{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		sleepTime(3);

	}

	public static String ChangeHrstoMin (String str) throws InterruptedException {
		String[] h1=str.split(":");
		int hour=Integer.parseInt(h1[0]);
		int minute=Integer.parseInt(h1[1]);
		int second=Integer.parseInt(h1[2]);
		int temp;
		temp = (60 * hour) + minute ;
		return String.format("%02d:%02d",temp,second);
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception 
	 * @description Enter the given value in the input field
	 */
	public static void sendKeysOnDisplayedElement(String Locator, String TestData, String WebElementNameOfLocator, String LabelNameFromExcel) throws Exception {

		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Assert.assertTrue(isElementPresent(Locator));

				WebElement elem;
				try {
					elem = driver.findElement(ByLocator(Locator));
					elem.clear();
				} catch (Exception e) {

				}
				elem = getDisplayedElement(Locator, WebElementNameOfLocator, LabelNameFromExcel);
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception 
	 * @description click on the given locator on the web Page
	 */
	public static WebElement getDisplayedElement(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws Exception {
		List<WebElement> allElements = driver.findElements(ByLocator(Locator));
		WebElement dispElem = allElements.get(0);
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				for(WebElement elem : allElements){
					if(elem.isDisplayed()){
						dispElem  = elem;
						return dispElem;
					}
				}

			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator);
			e1.printStackTrace();
			
		}

		return dispElem;
	}


}

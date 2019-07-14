package assetMaintenance;
/*Script conditions  - 02/24/2016
TC5 - Due to issue in document tab unable to execute VMN & Turner
TC6 & TC7 - Due to issue in application, unable to execute for turner
 */
import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
@Listeners ()
public class AM_ReturnLastSearch extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	
	@BeforeClass
	public void TC1_LaunchBrowser() throws Exception {
		getBrowser();
	}
	@Test(priority =2,enabled= true,description = "Return to last search from asset.")
	public void TC2_RtnLstSrchMenu() throws Exception {
		System.out.println("*********************Start Testcase - TC2_RtnLstSrchMenu *********************");
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		
		
		System.out.println(CreatedSeriesAssetTitle1);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		//Return Last Search Menu
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);

		//Search
		clickUsingJSExecutor(SearchXpath, "Search Menu Icon");

		verifyTextMatches(AM_Asset1_Under_SearchMenu, "Asset1_Under_SearchMenu", AssetSearch_Asset1, "innerHTML");
		verifyTextMatches(AM_Asset2_Under_SearchMenu, "Asset2_Under_SearchMenu", AssetSearch_Asset2, "innerHTML");
		verifyTextMatches(AM_Asset3_Under_SearchMenu, "Asset3_Under_SearchMenu", AssetSearch_Asset3, "innerHTML");
		verifyTextMatches(AM_Asset4_Under_SearchMenu, "Asset4_Under_SearchMenu", AssetSearch_Asset4, "innerHTML");
		
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
		//TC_AM_AS_010
		clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));
		
		
		Thread.sleep(2000);
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1, "Enter Asset", "");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.xpath(loc_SearchedAsset));
		clickOn(loc_SearchedAsset, "Select Search Asse", "");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_ViewAsset, "View Asset", "");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.xpath(Loc_RetunrToLastSearchButton));
		Thread.sleep(3000);
		verifyTextMatches(Loc_RetunrToLastSearchButton, "Retun to last Search Button", ReturntoLastSearch);
		clickUsingJSExecutor(Loc_RetunrToLastSearchButton, "Return to Last Search Button", ""); 
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.xpath(loc_SearchedAsset));
		verifyTextMatches(loc_AssetTitle, "Asset Title", CreatedSeriesAssetTitle1, "value");
		verifyTextMatches(loc_SearchedAsset, "Search Asst", CreatedSeriesAssetTitle1,"title");
		System.out.println("*********************End Testcase - TC2_RtnLstSrchMenu *********************");
	}
	@Test(priority =3,enabled= true,description = "Search a Series Asset after updating the Asset information.")
	public void TC3_RtnLstSrchUpdateSeries() throws Exception, AWTException, IOException{}
	
	@Test(priority =4,enabled= false,description = "Search a Movie Asset after updating the Asset information.")

	public void TC4_RtnLstSrchUpdateMovie() throws Exception, AWTException, IOException{}
	@Test(priority =5,enabled= false,description = "Search a Element Asset after updating the Asset information.")
	public void TC5_RtnLstSrchUpdateElement() throws Exception, AWTException, IOException{}
	@Test(priority =6,enabled= false,description = "Create a new Series Asset from search and the go to the last search.")
	public void TC6_RtnLstSrchNewSeries() throws Exception, AWTException, IOException{}
	@Test(priority =7,enabled= false,description = "Create a new Movie asset from search and the go to the last search.")
	public void TC7_RtnLstSrchNewMovies() throws Exception, AWTException{}
	@Test(priority =8,enabled= false,description = "Create a new Element Asset from search and the go to the last search.")
	public void TC8_RtnLstSrchNewElement() throws Exception, AWTException{}
	@Test(priority =9,enabled= false,description = "Go to the Return to last search from Series Asset.")
	public void TC9_RtnLstSrchSeries() throws Exception, AWTException{}
	@Test(priority =10,enabled= false,description = "Go to the Return to last search from Element Asset.")
	public void TC10_RtnLstSrchElement() throws Exception, AWTException{}
	@Test(priority =11,enabled= false,description = "Update Property title on General tab and Go to the Return to last search from Series Asset.")
	public void TC11_RtnLstSrchUpdateTitle() throws Exception, AWTException, IOException{}
	
	@Test(priority =12,enabled= false,description = "Add Standalone to Series Asset then go to the Return to last search from Series Asset.")
	public void TC12_RtnLstSrchAddStandaloneAsset() throws Exception, AWTException, IOException{}
	@Test(priority =13,enabled= false,description = "Change the Asset type then go to the Return to last search")
	public void TC13_RtnLstSrchUpdateAssetType() throws Exception, AWTException, IOException{}
	@Test(priority =14,enabled= false,description = "Last search should not be cleared when a user logout into Rights Logic.")
	public void TC14_RtnLstSrchLogout() throws Exception, AWTException, IOException{}
	@Test(priority =15,enabled= false,description = "Last search should be blank when a new user logs into Rights Logic.")
	public void TC15_RtnLstSrchNewUser() throws Exception, AWTException, IOException{}
	@Test(priority =16,enabled= false,description = "Go to Return to Last search after navigate away from the module.")
	public void TC16_RtnLstSrchNaviOtherModule() throws Exception, AWTException, IOException{}

	@AfterClass
	public void Driverclose() {
		driver.quit();
	}
}

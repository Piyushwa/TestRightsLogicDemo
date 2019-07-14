package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class AM_Premiere extends MultiClient_SupportingFunctions {

	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();

	public AM_Premiere() {
		
		super(loc_AM_Premiere_ColumnXpath_EditMode, loc_AM_Premiere_DataRowXpath_EditMode, loc_AM_Premiere_ColumnXpath_ViewMode,  loc_AM_Premiere_DataRowXpath_ViewMode);
		className = this.getClass().getName();
		classObject = this.getClass();
	}


	@Test(priority =2,enabled= true,description = " Premiere Tab")
	public void TC2_PremiereUI() throws Exception {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";         
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		String CreatedDealname1 = "AUT_Deal1_" +formattedDate+"";
		//Deal Required only for AMCN , CORUS ,SKY
		if (!AM_Premiere_DealName.contains("N/A")){
			ExecutionLog.Log(CreatedDealname1);		
			rightsIN.createDeal(CreatedDealname1);
			rightsIN.associateAssetWithDeal(CreatedDealname1, CreatedSeriesAssetTitle1);
		}
		//search Created Asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		
		switchIntoFrame(frameParent2Xpath);
		clickOn(LocPremiereTab, "Premiere Tab");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name(loc_Edit));
		//Columns
		ExecutionLog.Log("**********Verify Columns Header Name of Premiere TAB in View Mode********");
		verifyFieldValueOfHeader("//th[@key='"+AM_Premiere_AssetName_Key +"']", AM_Premiere_AssetName, "Asset Name", AM_Premiere_AssetName);
		//Edit
		clickUsingJSExecutor(Loc_EditButton, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		//Columns
		ExecutionLog.Log("**********Verify Columns Header Name of Premiere TAB in Edit Mode********");
		verifyFieldValueOfHeader("//th[@key='"+AM_Premiere_DealName_Key +"']", AM_Premiere_DealName, "Deal Name", AM_Premiere_DealName);
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_DealDescription_Key +"']", AM_Premiere_DealDescription, "Deal Description", AM_Premiere_DealDescription, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_OrigNetwork_Key +"']", AM_Premiere_OrigNetwork, "Orig Network", AM_Premiere_OrigNetwork, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_AirNetwork_Key +"']", AM_Premiere_AirNetwork, "Air Network", AM_Premiere_AirNetwork, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_ProductOffering_Key +"']", AM_Premiere_ProductOffering, "Product Offering", AM_Premiere_ProductOffering, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_MediaPlatform_Key +"']", AM_Premiere_MediaPlatform, "Media Platform", AM_Premiere_MediaPlatform, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_RightsType_Key +"']", AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_Country_Key +"']", AM_Premiere_Country, "Country", AM_Premiere_Country, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_PlatformFlag_Key +"']", AM_Premiere_PlatformFlag, "Platform Flag", AM_Premiere_PlatformFlag, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_PremiereDate_Key +"']", AM_Premiere_PremiereDate, "Premiere Date", AM_Premiere_PremiereDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_PremiereTime_Key +"']", AM_Premiere_PremiereTime, "Premiere Time", AM_Premiere_PremiereTime, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_Duration_Key +"']", AM_Premiere_Duration, "Duration", AM_Premiere_Duration, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_FromSystem_Key +"']", AM_Premiere_FromSystem, "From System", AM_Premiere_FromSystem, "innerHTML");
		ExecutionLog.Log("**********Verify Button Name of Premiere TAB in view Mode********");
		verifyTextMatches(Loc_NewButton, "Add button", AM_Premiere_Add,"Value");
		verifyTextMatches(loc_Delete, "Delete Button", AM_Premiere_Delete,"Value");
		verifyTextMatches(loc_Save, "Save Button", AM_Premiere_Save,"Value");
		verifyTextMatches(loc_Cancel, "Cancel Button", AM_Premiere_Cancel,"Value");
		//Add
		clickUsingJSExecutor(Loc_NewButton, "New Button");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForElementPresent(Loc_ErrorMsg);
		Thread.sleep(3000);
		verifyTextMatches(Loc_ErrorMsg, "Without entering any data", AM_Premiere_WithoutEnteringAnyData);

		
		//Orig. Network
		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_OrigNetwork_Key, AM_Premiere_OrigNetwork), "Orig. Network",AM_Premiere_OrigNetwork);
		sendKeys(Loc_AM_Premiere_OrigNetworkInput, AM_Premiere_OrigNetworkData, "Orig Networkatform Input", AM_Premiere_OrigNetwork);

		
		//TC_AM_PRM_031
		//Deal Name
		if (!AM_Premiere_DealName.contains("N/A")) {
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_DealNameImg_Key, AM_Premiere_DealName)+"/img",  "Deal Name 1st row", AM_Premiere_DealName);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(Loc_DealName);
		Thread.sleep(2000);
		sendKeys(Loc_DealName, CreatedDealname1, "Deal Name", AM_Premiere_DealName);
		clickUsingJSExecutor(Loc_SearchButton, "Fine Button",AM_Premiere_DealName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(Loc_Toggle);
		clickOn(Loc_Toggle, "Toggle",AM_Premiere_DealName);
		WaitForElementPresent(loc_SearchedAsset);
		Thread.sleep(2000);
		clickOn(loc_SearchedAsset, "Search Asset",AM_Premiere_DealName);
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_LinkAsset, "Link Asset",AM_Premiere_DealName);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_AM_Premiere_1Row);
		Thread.sleep(3000);	
		}
		
		//Air Network  //Air Channel
		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_AirNetwork_Key, AM_Premiere_AirNetwork), "Air Network",AM_Premiere_AirNetwork);
		sendKeys(Loc_AM_Premiere_AirNetWorkInput, AM_Premiere_AirNetworkData, "Air Network Input", AM_Premiere_AirNetwork);
		
		//Product Offering //Only for SKY
		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_ProductOffering_Key, AM_Premiere_ProductOffering), "Product Offering",AM_Premiere_ProductOffering);
		sendKeys(loc_AM_Premiere_ProductOfferingInput, AM_Premiere_ProductOfferingData, "Product Offering", AM_Premiere_ProductOffering);
		
		
		
		//TC_AM_PRM_046
		//Air Date /Premiere Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_PremiereDate_Key, AM_Premiere_PremiereDate), "Air Date",AM_Premiere_PremiereDate);
		sendKeys(Loc_AM_Premiere_PremiereDateInput, AM_Premiere_PremiereData, "Premiere Date Input", AM_Premiere_PremiereDate);
		
		
		//Premiere Platform Flag //Only for VMN
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_PlatformFlag_Key, AM_Premiere_PlatformFlag), "Premiere Platform Flag", AM_Premiere_PlatformFlag);

		
		//TC_AM_PRM_047
		//Rights Type
		if (!ClientName.contains("VMN")){
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), "Rights Type",AM_Premiere_RightsType);
			sendKeys(Loc_AM_Premiere_RightsTypeInput, AM_Premiere_RightsTypeData, "Rights Type Input", AM_Premiere_RightsType);
		}
		else{
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), "Rights Type",AM_Premiere_RightsType);
			sendKeys(Loc_AM_Premiere_RightsType1Input, AM_Premiere_RightsTypeData, "Rights Type Input", AM_Premiere_RightsType);

		}
		
		
		//TC_AM_PRM_048
		//Country
		if(!AM_Premiere_Country.contains("N/A")){
			if(!ClientName.contains("SALESDEMO")){
				clickOn(getLocator_EditTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), "Country",AM_Premiere_Country);
				sendKeys(Loc_AM_Premiere_CountryInput, AM_Premiere_CountryData, "Country Input", AM_Premiere_Country);
			}
			else{
				clickOn(getLocator_EditTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), "Country",AM_Premiere_Country);
				sendKeys("//input[@data-ig='x:371968211.2:mkr:Input']", AM_Premiere_CountryData, "Country Input", AM_Premiere_Country);
			}
			Enter();
		}
		
		
		//Premiere Time
		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_PremiereTime_Key, AM_Premiere_PremiereTime), "Premiere Time",AM_Premiere_PremiereTime);
		sendKeys(Loc_AM_Premiere_PremiereTimeInput, AM_Premiere_PremiereTimeData, "Premiere Time Input", AM_Premiere_PremiereTime);
		
		
		//Duration
		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_Duration_Key, AM_Premiere_Duration), "Premiere Time",AM_Premiere_Duration);
		sendKeys(Loc_AM_Premiere_DurationInput, AM_Premiere_DurationData, "Duration Input", AM_Premiere_Duration);
		Enter();
	
		//From System
//		clickOn(getLocator_EditTAB_DataRow(AM_Premiere_FromSystem_Key, AM_Premiere_FromSystem)+"/img", "From System",AM_Premiere_FromSystem);   //Application Functnlity 
		
		
		//TC_AM_PRM_052
		//User is not able to edit. This is freeze.
		//Edit Mode
		ExecutionLog.Log("**********Premiere TAB in Edit Mode********");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), CreatedDealname1, "Deal Name", AM_Premiere_DealName, "innerHTML");
		if(ClientName.contains("SKY")){   // In Sky not accept more then 6 Character 
//			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), "AUT", "Deal Code", AM_Premiere_DealDescription, "innerHTML");	
		}else{
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), CreatedDealname1+"_desc", "Deal Description", AM_Premiere_DealDescription, "innerHTML");
		}
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_OrigNetwork_Key, AM_Premiere_OrigNetwork), AM_Premiere_OrigNetworkData, "Orig Network ", AM_Premiere_OrigNetwork, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_AirNetwork_Key, AM_Premiere_AirNetwork), AM_Premiere_AirNetworkData, "Air Network", AM_Premiere_AirNetwork, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_MediaPlatform_Key, AM_Premiere_MediaPlatform), AM_Premiere_MediaData, "Media Platform", AM_Premiere_MediaPlatform, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), AM_Premiere_Country, "Country", AM_Premiere_Country, "innerHTML");
		verifyElementPresent(getLocator_EditTAB_DataRow(AM_Premiere_PlatformFlag_Key, AM_Premiere_PlatformFlag)+"/img", "From System is Uncheked in Edit Mode",AM_Premiere_PlatformFlag);			
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_PremiereDate_Key, AM_Premiere_PremiereDate), AM_Premiere_PremiereData, "Premiere Date", AM_Premiere_PremiereDate, "innerHTML");		
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_FromSystem_Key, AM_Premiere_FromSystem)+"/img", "Unchecked", "'From System' Check box status of First Data Row", AM_Premiere_FromSystem, "title");
		
		
		//TC_AM_PRM_053
		//Save
		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		//View Mode
		ExecutionLog.Log("**********Premiere TAB in View Mode********");
		//Columns
		ExecutionLog.Log("**********Verify Columns Header Name of Premiere TAB in View Mode********");
		verifyFieldValueOfHeader("//th[@key='" +AM_Premiere_DealName_Key +"']", AM_Premiere_DealName.replace("*", ""), "Deal Name", AM_Premiere_DealName);
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_DealDescription_Key +"']", AM_Premiere_DealDescription, "Deal Description", AM_Premiere_DealDescription, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_OrigNetwork_Key +"']", AM_Premiere_OrigNetwork, "Orig Network", AM_Premiere_OrigNetwork, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_AirNetwork_Key +"']", AM_Premiere_AirNetwork, "Air Network", AM_Premiere_AirNetwork, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_MediaPlatform_Key +"']", AM_Premiere_MediaPlatform, "Media Platform", AM_Premiere_MediaPlatform, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_RightsType_Key +"']", AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_Country_Key +"']", AM_Premiere_Country, "Country", AM_Premiere_Country, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_PlatformFlag_Key +"']", AM_Premiere_PlatformFlag, "Platform Flag", AM_Premiere_PlatformFlag, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_PremiereDate_Key +"']", AM_Premiere_PremiereDate.replace("*", ""), "Premiere Date", AM_Premiere_PremiereDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + AM_Premiere_FromSystem_Key +"']", AM_Premiere_FromSystem, "From System", AM_Premiere_FromSystem, "innerHTML");
        
		verifyFieldValueOfHeader(loc_AM_Premiere_AssetInViewMode, CreatedSeriesAssetTitle1, "Title", AM_Premiere_AssetName);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), CreatedDealname1,  "DealName", AM_Premiere_DealName);
		if(ClientName.contains("SKY")){   // In Sky not accept more then 6 Character 
//			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), "AUT", "Deal Code", AM_Premiere_DealDescription);	
		}else{
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), CreatedDealname1+"_desc", "Deal Description", AM_Premiere_DealDescription, "innerHTML");
		}
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_OrigNetwork_Key, AM_Premiere_OrigNetwork), AM_Premiere_OrigNetworkData, "OrigNetwork ", AM_Premiere_OrigNetwork);		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_MediaPlatform_Key, AM_Premiere_MediaPlatform), AM_Premiere_MediaData, "Media Platform", AM_Premiere_MediaPlatform);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_AirTerritory_Key, AM_Premiere_AirTerritory), AM_Premiere_AirTerritory, "Air Territory", AM_Premiere_AirTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), AM_Premiere_Country, "Country", AM_Premiere_Country);
		verifyElementPresent(getLocator_ViewTAB_DataRow(AM_Premiere_PlatformFlag_Key, AM_Premiere_PlatformFlag)+"/img", "From System is checked in View Mode",AM_Premiere_PlatformFlag);			
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_PremiereDate_Key, AM_Premiere_PremiereDate), AM_Premiere_PremiereData, "Premiere Date", AM_Premiere_PremiereDate);				
		verifyElementNotPresent(getLocator_ViewTAB_DataRow(AM_Premiere_FromSystem_Key, AM_Premiere_FromSystem)+"/img", "From System is Unchecked in View Mode");
				
		clickUsingJSExecutor(Loc_EditButton, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		//Edit Mode
		ExecutionLog.Log("**********Premiere TAB in Edit Mode********");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), CreatedDealname1, "Deal Name", AM_Premiere_DealName, "innerHTML");
		if(ClientName.contains("SKY")){   // In Sky not accept more then 6 Character 
//			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), "AUT", "Deal Code", AM_Premiere_DealDescription, "innerHTML");	
		}else{
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), CreatedDealname1+"_desc", "Deal Description", AM_Premiere_DealDescription, "innerHTML");
		}
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_OrigNetwork_Key, AM_Premiere_OrigNetwork), AM_Premiere_OrigNetworkData, "OrigNetwork ", AM_Premiere_OrigNetwork, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_AirNetwork_Key, AM_Premiere_AirNetwork), AM_Premiere_AirNetworkData, "Air Network", AM_Premiere_AirNetwork, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), AM_Premiere_Country, "Country", AM_Premiere_Country, "innerHTML");	
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(AM_Premiere_FromSystem_Key, AM_Premiere_FromSystem)+"/img", "Unchecked", "'From System' Check box status of First Data Row", AM_Premiere_FromSystem, "title");
		ExecutionLog.Log("********************************************************************");
		//Delete Row  
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Without Seleting row click Delete Button Alert Msg", AM_Premiere_DeleteBtnWithoutSelectingRow);
		Thread.sleep(1000);
		clickUsingJSExecutor(OKAlertButtonXpath, "Alert Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(Loc_AM_Premiere_1Row, "Select 1 Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", AM_Premiere_ConfirmAlertForDeleteRow);
		Thread.sleep(1000);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Confirm Cancel");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", AM_Premiere_ConfirmAlertForDeleteRow);
		Thread.sleep(1000);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm OK");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Cancel, "Cencel Button");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		scrollElementIntoView(loc_Edit);
		Thread.sleep(3000);
		verifyElementPresent(getLocator_ViewTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), "Row Not Deleted");
		clickUsingJSExecutor(Loc_EditButton, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		Thread.sleep(1000);
		clickUsingJSExecutor(Loc_AM_Premiere_1Row, "Select 1 Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", AM_Premiere_ConfirmAlertForDeleteRow);
		Thread.sleep(1000);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Aler Ok");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		verifyElementNotPresent(getLocator_ViewTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), "Row Deleted");
	}

	@Test(priority =3,enabled= true ,description = "Premiere Tab to capture Premiere date for Product Offering along with Channel based on Deal")
	public void TC3_PremiereInitialAirDate2() throws Exception {
		if (!AM_Premiere_DealName.contains("N/A")){
			AssetMaintenance assetMaintenance = new AssetMaintenance(); 
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
			ExecutionLog.Log(CreatedSeriesAssetTitle1);
			assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType); 
			assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		
			String MasterDealname = "AUT_Deal_MasterDeal" +formattedDate+"";
			ExecutionLog.Log(MasterDealname);
			rightsIN.defaultDealCreation(MasterDealname,"Master Agreement");
			String Dealname1 = "AUT_STDeal1_" +formattedDate+"";
			ExecutionLog.Log(Dealname1);
			rightsIN.createDeal(Dealname1);
			rightsIN.associateAssetWithDeal(Dealname1, CreatedSeriesAssetTitle1);
			String Dealname2 = "AUT_STDeal2_" +formattedDate+"";
			ExecutionLog.Log(Dealname2);
			rightsIN.createDeal(Dealname2);
			rightsIN.associateAssetWithDeal(Dealname2, CreatedSeriesAssetTitle1);
			String Dealname4 = "AUT_STDeal4_" +formattedDate+"";
			ExecutionLog.Log(Dealname4);
			rightsIN.createDeal(Dealname4);
			//Searching  the Series Asset 
			assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
			switchIntoFrame(frameParent2Xpath);
			clickOn(LocPremiereTab, "Premiere Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(By.name(loc_Edit));
			clickUsingJSExecutor(Loc_EditButton, "Edit button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);	
			//Add Row
			clickUsingJSExecutor(Loc_NewButton, "new");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);	
			//Deal Name  Master Deal
			
			if (!AM_Premiere_DealName.contains("N/A")) {
				clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_DealNameImg_Key, AM_Premiere_DealName)+"/img",  "Deal Name 1st row", AM_Premiere_DealName);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_DealName);
				sendKeys(Loc_DealName, MasterDealname, "Deal Name", "");
				clickUsingJSExecutor(Loc_SearchButton, "Fine Button");
				Thread.sleep(300);
				driver.switchTo().window(driver.getWindowHandle());
				verifyTextMatches(OKAlertXpath, "Alert Message While Searching Master Deal", AM_Premiere_MasterDeallinkedAlert);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert Message While Searching Master Deal"); 
				switchIntoFrame(frameParent4Xpath);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(1000);
				clickOn(Loc_AM_Premiere_DealNameSearchHederClose, "Deal Name S earch Heder Close");
				switchIntoFrame(frameParent3Xpath);
			}
			//Deal Name AUT_STDeal 

			if (!AM_Premiere_DealName.contains("N/A")) {
				clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_DealNameImg_Key, AM_Premiere_DealName)+"/img",  "Deal Name 1st row", AM_Premiere_DealName);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_DealName);
				sendKeys(Loc_DealName, formattedDate, "Deal Name", "");
				clickUsingJSExecutor(Loc_SearchButton, "Fine Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_Toggle);
				clickOn(Loc_Toggle, "Toggle");
				WaitForElementPresent(loc_SearchedAsset);
				verifyTextMatches(Loc_AM_Premiere_DealNameVerif.replace("@var", Dealname2), "Deal 2", Dealname2,"title");
				verifyTextMatches(Loc_AM_Premiere_DealNameVerif.replace("@var", Dealname1), "Deal 1", Dealname1,"title");
				verifyTextMatches(Loc_AM_Premiere_DealNameVerif.replace("@var", Dealname4), "Deal 4", Dealname4,"title");
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(1000);
				clickOn(Loc_AM_Premiere_DealNameSearchHederClose, "Deal Name S earch Heder Close");
				switchIntoFrame(frameParent3Xpath);
			}
			//Deal Name 04

			if (!AM_Premiere_DealName.contains("N/A")) {
				clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_DealNameImg_Key, AM_Premiere_DealName)+"/img",  "Deal Name 1st row", AM_Premiere_DealName);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_DealName);
				sendKeys(Loc_DealName, Dealname4, "Deal Name", "");
				clickUsingJSExecutor(Loc_SearchButton, "Fine Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_Toggle);
				clickOn(Loc_Toggle, "Toggle");
				WaitForElementPresent(loc_SearchedAsset);
				clickUsingJSExecutor(loc_SearchedAsset, "Search Asset");
				Thread.sleep(3000);
				clickUsingJSExecutor(Loc_LinkAsset, "Link Asset");
				
				acceptAlert();
//				driver.switchTo().window(driver.getWindowHandle());			
//				verifyTextMatches(AlertValidationMessgeText, "Alert Message While Copying the Episode", AM_Premiere_AssetNotlinked);
//				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While Searching Dealname4 "); 
//				switchIntoFrame(frameParent4Xpath);
				driver.switchTo().window(driver.getWindowHandle());
				Thread.sleep(1000);
				clickOn(Loc_AM_Premiere_DealNameSearchHederClose, "Deal Name S earch Heder Close");
				switchIntoFrame(frameParent3Xpath);
			}
			//Deal Name 01
			if (!AM_Premiere_DealName.contains("N/A")) {
				clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_DealNameImg_Key, AM_Premiere_DealName)+"/img",  "Deal Name 1st row", AM_Premiere_DealName);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_DealName);
				sendKeys(Loc_DealName, Dealname1, "Deal Name", "");
				clickUsingJSExecutor(Loc_SearchButton, "Fine Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Loc_Toggle);
				clickOn(Loc_Toggle, "Toggle");
				WaitForElementPresent(loc_SearchedAsset);
				clickUsingJSExecutor(loc_SearchedAsset, "Search Asset");
				Thread.sleep(3000);
				clickUsingJSExecutor(Loc_LinkAsset, "Link Asset");
				switchIntoFrame(frameParent3Xpath);
			}
			
			//Air Network  //Air Channel
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_AirNetwork_Key, AM_Premiere_AirNetwork), "Air Network",AM_Premiere_AirNetwork);
			sendKeys(Loc_AM_Premiere_AirNetWorkInput, AM_Premiere_AirNetworkData, "Air Network Input", AM_Premiere_AirNetwork);
			
			//Product Offering //Only for SKY
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_ProductOffering_Key, AM_Premiere_ProductOffering), "Product Offering",AM_Premiere_ProductOffering);
			sendKeys(loc_AM_Premiere_ProductOfferingInput, AM_Premiere_ProductOfferingData, "Product Offering", AM_Premiere_ProductOffering);
			
			//TC_AM_PRM_046
			//Air Date /Premiere Date
			clickUsingJSExecutor(getLocator_EditTAB_DataRow(AM_Premiere_PremiereDate_Key, AM_Premiere_PremiereDate), "Air Date",AM_Premiere_PremiereDate);
			sendKeys(Loc_AM_Premiere_PremiereDateInput, AM_Premiere_PremiereData, "Premiere Date Input", AM_Premiere_PremiereDate);
			
			//Premiere Time
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_PremiereTime_Key, AM_Premiere_PremiereTime), "Premiere Time",AM_Premiere_PremiereTime);
			sendKeys(Loc_AM_Premiere_PremiereTimeInput, AM_Premiere_PremiereTimeData, "Premiere Time Input", AM_Premiere_PremiereTime);
			
			
			//Duration
			clickOn(getLocator_EditTAB_DataRow(AM_Premiere_Duration_Key, AM_Premiere_Duration), "Premiere Time",AM_Premiere_Duration);
			sendKeys(Loc_AM_Premiere_DurationInput, AM_Premiere_DurationData, "Duration Input", AM_Premiere_Duration);
			Enter();

			//Save
			clickUsingJSExecutor(loc_Save, "Save");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(By.name(loc_Edit));
			Thread.sleep(2000);

			verifyFieldValueOfHeader(loc_AM_Premiere_AssetInViewMode, CreatedSeriesAssetTitle1, "Title", AM_Premiere_AssetName);
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealName_Key, AM_Premiere_DealName), Dealname1,  "DealName", AM_Premiere_DealName);
			if(ClientName.contains("SKY")){   // In Sky not accept more then 6 Character 
//				verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), "AUT", "Deal Code", AM_Premiere_DealDescription);	
			}else{
				verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_DealDescription_Key, AM_Premiere_DealDescription), Dealname1+"_desc", "Deal Description", AM_Premiere_DealDescription, "innerHTML");
			}
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_OrigNetwork_Key, AM_Premiere_OrigNetwork), AM_Premiere_OrigNetworkData, "OrigNetwork ", AM_Premiere_OrigNetwork);		
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_MediaPlatform_Key, AM_Premiere_MediaPlatform), AM_Premiere_MediaData, "Media Platform", AM_Premiere_MediaPlatform);
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_AirTerritory_Key, AM_Premiere_AirTerritory), AM_Premiere_AirTerritory, "Air Territory", AM_Premiere_AirTerritory);
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_RightsType_Key, AM_Premiere_RightsType), AM_Premiere_RightsType, "Rights Type", AM_Premiere_RightsType);
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_Country_Key, AM_Premiere_Country), AM_Premiere_Country, "Country", AM_Premiere_Country);
			verifyElementPresent(getLocator_ViewTAB_DataRow(AM_Premiere_PlatformFlag_Key, AM_Premiere_PlatformFlag)+"/img", "From System is checked in View Mode",AM_Premiere_PlatformFlag);			
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow(AM_Premiere_PremiereDate_Key, AM_Premiere_PremiereDate), AM_Premiere_PremiereData, "Premiere Date", AM_Premiere_PremiereDate);				
			verifyElementNotPresent(getLocator_ViewTAB_DataRow(AM_Premiere_FromSystem_Key, AM_Premiere_FromSystem)+"/img", "From System is Unchecked in View Mode");

		}else{
			throw new SkipException("Deal Name is not Present for : " + ClientData);
		}
	}

	public String getLocator_EditTAB_DataRow(String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_AM_Premiere_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_AM_Premiere_DataRowXpath_EditMode + "//td[contains(@class,'"+(classValue)+"')]";
		locator = loc_AM_Premiere_DataRowXpath_EditMode + "//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
	public String getLocator_ViewTAB_DataRow(String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_AM_Premiere_ColumnXpath_ViewMode, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_AM_Premiere_DataRowXpath_ViewMode + "//td[contains(@class,'"+(classValue)+"')]";
		locator = loc_AM_Premiere_DataRowXpath_ViewMode + "//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}

}

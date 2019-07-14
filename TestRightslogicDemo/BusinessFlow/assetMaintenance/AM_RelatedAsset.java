package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
@Listeners(utility.ListenerClass.class)
public class AM_RelatedAsset extends MultiClient_SupportingFunctions {
	public AM_RelatedAsset() {
		className = this.getClass().getName();
		classObject = this.getClass();
	}
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_"+formattedDate+"";
	String CreatedSeriesAssetTitle2 = "AUT_AssetSeries2_"+formattedDate+"";
	String CreatedEleAssetTitle1 = "AUT_AssetElement_"+formattedDate+"";
	String CreatedMovieAssetTitle = "AUT_AssetMovie_"+formattedDate+"";  

	
	@BeforeTest
	public void runStatus() {
		if(ClientData.equals("CORUS") || ClientData.equals("VMN")) {
			throw new SkipException("Script of \"RelatedAsset TAB\" is Not Applicable for "+ ClientData);
		}
	}
	
	@Test(priority =1,enabled= true,description = "Validate Related Assets tab")
	public void TC2_ValidateRelatedAssetsTab() throws Exception {
		System.out.println("*********************Start Testcase - TC2_Validate Related Assets tab *********************");
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		ExecutionLog.Log(CreatedSeriesAssetTitle1);
		
		//Create Series
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		
		//Create Movie
		ExecutionLog.Log(CreatedMovieAssetTitle);
		assetMaintenance.createProgramAsset(CreatedMovieAssetTitle, AssetType_ProgrameMovie);
		
		if(!ClientName.contains("SKY")){
		//create Element
		ExecutionLog.Log(CreatedEleAssetTitle1);
		assetMaintenance.createElementAsset(CreatedEleAssetTitle1, AssetType_Element_Talent, AssetType_Element);
		
		//Searching  the Element Asset
		assetMaintenance.searchCreatedAsset(CreatedEleAssetTitle1,AssetType_Element);
		}else{
			assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		}
	
		switchIntoFrame(frameParent2Xpath);
		//Related Assets Tab
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//Edit
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		ExecutionLog.Log("---------------------Below fields are displayed in Edit window---------------------");
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AppliesTo_Key +"']", AM_RelatedAsset_AppliesTo, "Applies To", AM_RelatedAsset_AppliesTo);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetTitle_Key +"']", AM_RelatedAsset_AssetTitle, "Asset Title", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_ROLE_Key +"']", AM_RelatedAsset_ROLE, "ROLE", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_GUILD_Key +"']", AM_RelatedAsset_GUILD, "ROLE", AM_RelatedAsset_GUILD);
	
		ExecutionLog.Log("---------------------Buttons----------------------------");
		verifyTextMatches(LocAdd, "Add",AM_RelatedAsset_Add,"value");
		verifyTextMatches(loc_Copy, "Copy",AM_RelatedAsset_Copy,"value");
		verifyTextMatches(loc_Delete, "Delete",AM_RelatedAsset_Delete,"value");
		verifyTextMatches(loc_Save, "Save",AM_RelatedAsset_Save,"value");
		verifyTextMatches(loc_Cancel, "Cancel",AM_RelatedAsset_Cancel,"value");
		ExecutionLog.Log("--------------------------------------------------------");
		//Add
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		Thread.sleep(3000);
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		Thread.sleep(3000);
		verifyTextMatches(LocErrorMgs, "Validation Msg", AM_RelatedAsset_ValidationMsg);
		
		//Applies to
        clickOn(getLocator_EditTAB_DataRow("1",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), "Applies To", AM_RelatedAsset_AppliesTo);
        if(!ClientName.contains("SKY")){
		sendKeys(RelAssetApplesToInput, CreatedEleAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
        }else{
        	sendKeys(RelAssetApplesToInput, CreatedSeriesAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
        }
        Enter();
		//Start time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), "Start Time Code", AM_RelatedAsset_StartTimeCode);
		sendKeys_WithoutClear(RelatedAssetStartTimeCodeinput, AM_RelatedAsset_StartTimeCodeData1, "Start Time Code input", AM_RelatedAsset_StartTimeCode);
		//End time code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), "End Time Code", AM_RelatedAsset_EndTimeCode);
		sendKeys(RelatedAssetEndTimeCodeinput, AM_RelatedAsset_EndTimeCodeData1, "End Time Code input", AM_RelatedAsset_EndTimeCode); 
		
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		verifyTextMatches(LocErrorMgs, "Validation Msg", AM_RelatedAsset_ValidationMsg);
		//Asset title pop up
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(RelAssetAssetTitle1RowImg, "Asset Title Img", "");
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickOn(loc_AssetTitle, "Asset Title", "");
		sendKeys(loc_AssetTitle, CreatedMovieAssetTitle, "Asset Title", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Now Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		Thread.sleep(1000);
		WaitForElementPresent(loc_SearchedAsset);
		clickUsingJSExecutor(loc_SearchedAsset, "Select Asset", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(Loc_LinkAsset, "Link Asset", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		Thread.sleep(3000);
		//Viewmode 
		//Header
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AppliesTo_Key +"']", AM_RelatedAsset_AppliesTo.replace("*", ""), "Applies To", AM_RelatedAsset_AppliesTo);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetTitle_Key +"']", AM_RelatedAsset_AssetTitle.replace("*", ""), "Asset Title", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetType_Key +"']", AM_RelatedAsset_AssetType, "Asset Type", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetID_Key +"']", AM_RelatedAsset_AssetID, "Asset ID", AM_RelatedAsset_AssetID);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_EpisodeNumber_Key +"']", AM_RelatedAsset_EpisodeNumber, "Episode Number", AM_RelatedAsset_EpisodeNumber);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_SourceSystem_Key +"']", AM_RelatedAsset_SourceSystem, "Source System", AM_RelatedAsset_SourceSystem);
		//Data
		if(!ClientName.contains("SKY")){
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedEleAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);
		}else{
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedSeriesAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		}
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedMovieAssetTitle, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_MovieAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
		
		//Add duplicate
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Applies to
		clickOn(getLocator_EditTAB_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), "Applies To", AM_RelatedAsset_AppliesTo);
		if(!ClientName.contains("SKY")){
		sendKeys(RelAssetApplesToInput, CreatedEleAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}else{
			sendKeys(RelAssetApplesToInput, CreatedSeriesAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}
		//Asset title pop up
		clickUsingJSExecutor(RelAssetAssetTitle2RowImg, "Asset Title Img", "");
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickOn(loc_AssetTitle, "Asset Title", "");
		sendKeys(loc_AssetTitle, CreatedMovieAssetTitle, "Asset Title", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Now Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		Thread.sleep(1000);
		WaitForElementPresent(loc_SearchedAsset);
		clickUsingJSExecutor(loc_SearchedAsset, "Select Asset", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(Loc_LinkAsset, "Link Asset", "");
		switchIntoFrame(frameParent4Xpath);
		//Save Duplicate popup
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Duplicate Msg", AM_RelatedAsset_AlertDuplicateMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Close
		clickUsingJSExecutor(LocCancel, "Cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//TC_AM_RAT_027
		//Search Movie
		assetMaintenance.searchCreatedAsset(CreatedMovieAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		
		//Viewmode 
		//Header
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AppliesTo_Key +"']", AM_RelatedAsset_AppliesTo.replace("*", ""), "Applies To", AM_RelatedAsset_AppliesTo);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetTitle_Key +"']", AM_RelatedAsset_AssetTitle.replace("*", ""), "Asset Title", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetType_Key +"']", AM_RelatedAsset_AssetType, "Asset Type", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetID_Key +"']", AM_RelatedAsset_AssetID, "Asset ID", AM_RelatedAsset_AssetID);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_EpisodeNumber_Key +"']", AM_RelatedAsset_EpisodeNumber, "Episode Number", AM_RelatedAsset_EpisodeNumber);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_SourceSystem_Key +"']", AM_RelatedAsset_SourceSystem, "Source System", AM_RelatedAsset_SourceSystem);
		//Data
		if(!ClientName.contains("SKY")){
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedEleAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);
		}else{
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedMovieAssetTitle, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		}
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedSeriesAssetTitle1, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_SeriesAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
		
		//TC_AM_RAT_029
		//Search Element
		if(!ClientName.contains("SKY")){
		assetMaintenance.searchCreatedAsset(CreatedEleAssetTitle1,AssetType_Element);	
		}else{
			assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		}
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//Edit 
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Applies to
		clickOn(getLocator_EditTAB_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), "Applies To", AM_RelatedAsset_AppliesTo);
		if(!ClientName.contains("SKY")){
		sendKeys(RelAssetApplesToInput, CreatedEleAssetTitle1+" . Episode101", "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}else{
			sendKeys(RelAssetApplesToInput, CreatedSeriesAssetTitle1+" . Episode101", "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}
		Enter();
		//Asset title pop up
		clickUsingJSExecutor(RelAssetAssetTitle1RowImg, "Asset Title Img", "");
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickOn(loc_AssetTitle, "Asset Title");
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1, "Asset Title", "");
		if(ClientName.contains("TURNER")){
	    clickUsingJSExecutor(UnckeckDisplaySeasons, "Unckeck Display Seasons", "");
		}
		clickUsingJSExecutor(Loc_SearchButton, "Find Now Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		Thread.sleep(1000);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(AseetExpand1, "Asset Expand", "");
		Thread.sleep(2000);
		clickOn(SeasonExpand1, "Season Expand", "");
		Thread.sleep(2000);
		
		doubleClick(Epi101Select, "Epi101 Select", "");
		Thread.sleep(6000);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//TC_AM_RAT_038
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		//You have related the same title to itself. Please delete the redundant entry by selecting the row and clicking the Delete button.	Add
		verifyTextMatches(LocErrorMgs, "Validation Msg", AM_RelatedAsset_AlertSameAssetMsg);
		clickUsingJSExecutor(loc_Cancel, "Cancel button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		//Edit 
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Applies to
		clickOn(getLocator_EditTAB_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), "Applies To", AM_RelatedAsset_AppliesTo);
		if(!ClientName.contains("SKY")){
			sendKeys(RelAssetApplesToInput, CreatedEleAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}else{
			sendKeys(RelAssetApplesToInput, CreatedSeriesAssetTitle1, "ApplesTo Input", AM_RelatedAsset_AppliesTo);
		}
		Enter();
		//Asset title pop up
		clickUsingJSExecutor(RelAssetAssetTitle1RowImg, "Asset Title Img", "");
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickOn(loc_AssetTitle, "Asset Title");
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1, "Asset Title", "");
		if(ClientName.contains("TURNER")){
			clickUsingJSExecutor(UnckeckDisplaySeasons, "Unckeck Display Seasons", "");
		}
		clickUsingJSExecutor(Loc_SearchButton, "Find Now Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		Thread.sleep(1000);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(AseetExpand1, "Asset Expand", "");
		Thread.sleep(2000);
		clickOn(SeasonExpand1, "Season Expand", "");
		Thread.sleep(2000);

		doubleClick(Epi101Select, "Epi101 Select", "");
		Thread.sleep(6000);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		Thread.sleep(6000);
		//TC_AM_RAT_039
		//View mode 
		//Data
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedSeriesAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedMovieAssetTitle, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_MovieAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
		
		//3rd Line 
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle,"1"), CreatedSeriesAssetTitle1+" . Episode101", "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType,"1"), AM_RelatedAsset_EpisodeAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_EpisodeNumber_Key, AM_RelatedAsset_EpisodeNumber,"1"), "101", " Episode To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE,"1"), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD,"1"), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode,"1"), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode,"1"), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem,"1"), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
		
		//4th
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("4",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedSeriesAssetTitle1+" . Episode101", "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedSeriesAssetTitle1, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_SeriesAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
		
		//Edit 
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		//TC_AM_RAT_042
		//Add
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Save WithOut data 
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		verifyTextMatches(LocErrorMgs, "Validation Msg", AM_RelatedAsset_ValidationMsg);
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button"); 
		//Close
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(LocCancel, "Cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		System.out.println("*********************End Testcase - TC2_Validate Related Assets tab *********************");	
	}
	
	@Test(priority =2,enabled= true,description = "Validate the data in associated assets in related tab of program-element")
	public void TC3_ValidateDataInAssociatedAssets() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC3_ValidateDataInAssociatedAssets *********************");
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		//Create new Series
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle2, Series_AssetType);
		//Search movie asset
		assetMaintenance.searchCreatedAsset(CreatedMovieAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		
		//Viewmode 
		//Header
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AppliesTo_Key +"']", AM_RelatedAsset_AppliesTo.replace("*", ""), "Applies To", AM_RelatedAsset_AppliesTo);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetTitle_Key +"']", AM_RelatedAsset_AssetTitle.replace("*", ""), "Asset Title", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetType_Key +"']", AM_RelatedAsset_AssetType, "Asset Type", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetID_Key +"']", AM_RelatedAsset_AssetID, "Asset ID", AM_RelatedAsset_AssetID);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_EpisodeNumber_Key +"']", AM_RelatedAsset_EpisodeNumber, "Episode Number", AM_RelatedAsset_EpisodeNumber);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_SourceSystem_Key +"']", AM_RelatedAsset_SourceSystem, "Source System", AM_RelatedAsset_SourceSystem);
		//Data
		if(!ClientName.contains("SKY")){
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedEleAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);
		}else{
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedMovieAssetTitle, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		}
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedSeriesAssetTitle1, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_SeriesAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);
	

		//Search series asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//Viewmode 
		//Header
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AppliesTo_Key +"']", AM_RelatedAsset_AppliesTo.replace("*", ""), "Applies To", AM_RelatedAsset_AppliesTo);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetTitle_Key +"']", AM_RelatedAsset_AssetTitle.replace("*", ""), "Asset Title", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetType_Key +"']", AM_RelatedAsset_AssetType, "Asset Type", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_AssetID_Key +"']", AM_RelatedAsset_AssetID, "Asset ID", AM_RelatedAsset_AssetID);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_EpisodeNumber_Key +"']", AM_RelatedAsset_EpisodeNumber, "Episode Number", AM_RelatedAsset_EpisodeNumber);
		verifyFieldValueOfHeader("//th[@key='"+AM_RelatedAsset_SourceSystem_Key +"']", AM_RelatedAsset_SourceSystem, "Source System", AM_RelatedAsset_SourceSystem);
        //Data
		

		//Validate associated episode
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name(Loc_EditButton1));
		Thread.sleep(2000);
		selectDropdownValue(loc_Episodes_Filter1DropDown, "Episodes Filter", "(Select All)", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name(Loc_EditButton1));
		Thread.sleep(2000);
		
		clickOn(Epi1Row, "Epi 1Row", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Episodes_EditEpisodes, "Edit Epi", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//View mode 
		//Data
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedSeriesAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedSeriesAssetTitle1, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_SeriesAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);

	
		

		//4th
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("4",AM_RelatedAsset_AppliesTo_Key, AM_RelatedAsset_AppliesTo), CreatedSeriesAssetTitle1, "Applies To View Mode", AM_RelatedAsset_AppliesTo);	
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_AssetTitle_Key, AM_RelatedAsset_AssetTitle), CreatedMovieAssetTitle, "Asset title To View Mode", AM_RelatedAsset_AssetTitle);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_AssetType_Key, AM_RelatedAsset_AssetType), AM_RelatedAsset_MovieAssetTypeData, "Asset Type To View Mode", AM_RelatedAsset_AssetType);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_ROLE_Key, AM_RelatedAsset_ROLE), AM_RelatedAsset_RoleData, "Role View Mode", AM_RelatedAsset_ROLE);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_GUILD_Key, AM_RelatedAsset_GUILD), AM_RelatedAsset_GuildData, "Guild View Mode", AM_RelatedAsset_GUILD);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_StartTimeCode_Key, AM_RelatedAsset_StartTimeCode), AM_RelatedAsset_StartTimeCodeData1, "Guild View Mode", AM_RelatedAsset_StartTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_EndTimeCode_Key, AM_RelatedAsset_EndTimeCode), AM_RelatedAsset_EndTimeCodeData1, "Guild View Mode", AM_RelatedAsset_EndTimeCode);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5",AM_RelatedAsset_SourceSystem_Key, AM_RelatedAsset_SourceSystem), "RL", "Source System View Mode", AM_RelatedAsset_SourceSystem);





		//Copy rows  CreatedEleAssetTitle1
		//TC_AM_RAT_009
		//Searching  the Element Asset 
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);	
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(2000);
		clickOn(loc_Tab.replace("@var", "Related Titles"), "Related Assets");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
		//Copy
		clickUsingJSExecutor(loc_Copy, "Copy Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Without selecting row click on copy button", AM_RelatedAsset_AlertCopyMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(RelAsset2Row, "Select 2 Row", "");
		clickUsingJSExecutor(loc_Copy, "Copy Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent4Xpath);
		verifyElementDisplayed(RelAsset3Row, "Copy Row created","");
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "After copy ", AM_RelatedAsset_AlertDuplicateMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(RelAsset3Row, "Select 3 Row", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Delete, "Deleet Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Row", AM_RelatedAsset_ConfDeleteMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);

		//Automation Asset replace not working properly 

		clickUsingJSExecutor(RelAsset2Row, "Select 2 Row", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Copy, "Copy Button", "");
		Thread.sleep(3000);
		verifyElementDisplayed(RelAsset3Row, "RelAsset 3Row", "");
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "After copy ", AM_RelatedAsset_AlertDuplicateMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		//Asset title pop up
		clickUsingJSExecutor(RelAssetAssetTitle3RowImg, "Asset Title Img", "");
		switchIntoFrame(frameParent5Xpath);
		Thread.sleep(5000);
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickOn(loc_AssetTitle, "Asset Title", "");
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle2, "Asset Title", "");
		
		clickUsingJSExecutor(Loc_SearchButton, "Find Now Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickUsingJSExecutor(Loc_Toggle, "Toggle", "");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_SearchedAssetDetails.replace("@var", CreatedSeriesAssetTitle2), CreatedSeriesAssetTitle2);
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_LinkAsset, "Link Asset", "");
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(6000);
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		//Delete functionality
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent((loc_Delete));
		Thread.sleep(3000);
		//Delete	
		clickUsingJSExecutor(loc_Delete, "Delete Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Before Delete Msg", AM_RelatedAsset_AlertBeforeDeleteMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(RelAsset2Row, "Select2rd Row ", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Delete, "Deleet Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Row", AM_RelatedAsset_ConfDeleteMsg);
	    clickUsingJSExecutor(Loc_ConfirmCancel, "Confirm Cancel", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(loc_Delete, "Deleet Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Row", AM_RelatedAsset_ConfDeleteMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(LocCancel, "Cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit button", "");
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		verifyElementDisplayed(RelAsset2Row, "RelAsset 2Row", "");
		Thread.sleep(1000);
		clickUsingJSExecutor(RelAsset2Row, "Select2rd Row ", "");
		clickUsingJSExecutor(loc_Delete, "Deleet Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Row", AM_RelatedAsset_ConfDeleteMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button", "");
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		ExecutionLog.Log("*********************End Testcase - TC3_ValidateDataInAssociatedAssets *********************");
	}
	
	
	public String getLocator_EditTAB_DataRow(String RowNum,String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_AM_RelatedAsset_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_AM_RelatedAsset_DataRowXpath_EditMode + "[" + RowNum +"]//td[contains(@class,'"+(classValue)+"')]";
		locator = loc_AM_RelatedAsset_DataRowXpath_EditMode + "[" + RowNum +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
	


	
	
	
	/**
	 * Parent Row starts from : 2,4,6,8
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_Parent_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueParent(loc_AM_RelatedAsset_ParentRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}

		return locator;
	}

	/**
	 * Child Row starts from : 3,5,7,9
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_Child_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueChild(loc_AM_RelatedAsset_ChildRow+ "[" + rowNumber +"]//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}

	/**
	 * Parent Row starts from : 3,5,7,9
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @param SiblingRow Starts from 1,2,3,4...
	 * 
	 * Example: If you want to verify the second allocation row of First Parent then pass
	 * rowNumber = 3
	 * SiblingRow = 1
	 * @return
	 */
	public String getLocator_Child_DataRow_UnderSameParentRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String SiblingRow){
		String locator = "";
		String classValue = getClassValueChild(loc_AM_RelatedAsset_ChildRow+ "//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_AM_RelatedAsset_ChildRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	public String getClassValueChild(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";

		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_Header = headerPath+"[@key='"+keyValue+"']";
			classValue =  getAttribute(loc_Header, "class");
		} 
		return classValue;
	}
	
	public String getClassValueParent(String headerLocator, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			classValue =  getAttribute(headerLocator, "class");
		} 
		return classValue;
	}
}
































package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_MediaRights extends DriverHelper implements I_RI_MediaRights{
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = "0324201725457";//sdf.format(date);
	
	
	String CreatedSeriesAssetTitleTC1 	= "AUT_AssetSeries_TC1_" +formattedDate+"";
	String CreatedSeriesAssetTitleTC3 	= "AUT_AssetSeries_TC3_" +formattedDate+"";
	String CreatedSeriesAssetTitleTC4 	= "AUT_AssetSeries_TC4_" +formattedDate+"";
	String CreatedMovieAssetTitleTC4 	= "AUT_AssetMovie_TC4_" +formattedDate+"";
	String CreatedSeriesAssetTitleTC6 	= "AUT_AssetSeries_TC6_" +formattedDate+"";
	String CreatedSeriesAssetTitleTC10 	= "AUT_AssetSeries_TC10_" +formattedDate+"";
	
	String CreatedDealTC1 		= "AUT_Deal_TC1_" +formattedDate+"";
	String CreatedDealTC2 		= "AUT_Deal_TC2_" +formattedDate+"";
	String CreatedDealTC3 		= "AUT_Deal_TC3_" +formattedDate+"";
	String CreatedDealTC3_2 	= "AUT_Deal_TC3_2_" +formattedDate+"";
	String CreatedDealTC4 		= "AUT_Deal_TC4_" +formattedDate+"";
	String CreatedDealTC6 		= "AUT_Deal_TC6_" +formattedDate+"";
	String CreatedDealTC7 		= "AUT_Deal_TC7_" +formattedDate+"";
	String CreatedDealTC9 		= "AUT_Deal_TC9_" +formattedDate+"";
	String CreatedDealTC10 		= "AUT_Deal_TC10_" +formattedDate+"";
	
	public RI_MediaRights() {
		super(loc_RI_MediaRights_ColumnXpath_EditMode, loc_RI_MediaRights_DataRowXpath_EditMode, 
				loc_RI_MediaRights_ColumnXpath_ViewMode, loc_RI_MediaRights_DataRowXpath_ViewMode);
		className = this.getClass().getName();
		classObject = this.getClass();	
		}
	
	//@Test
	public void create_PreRequisites_AllDeal_Assets() throws Exception{
		
		ExecutionLog.Log("All Assets are:");
		ExecutionLog.Log("CreatedSeriesAssetTitleTC1 = \"" + CreatedSeriesAssetTitleTC1+ "\";");
		ExecutionLog.Log("CreatedSeriesAssetTitleTC3 = \"" + CreatedSeriesAssetTitleTC3+ "\";");
		ExecutionLog.Log("CreatedSeriesAssetTitleTC4 = \"" + CreatedSeriesAssetTitleTC4+ "\";");
		ExecutionLog.Log("CreatedSeriesAssetTitleTC6 = \"" + CreatedSeriesAssetTitleTC6+ "\";");
		ExecutionLog.Log("CreatedSeriesAssetTitleTC10 = \"" + CreatedSeriesAssetTitleTC10+ "\";");
		ExecutionLog.Log("CreatedMovieAssetTitleTC4 = \"" + CreatedMovieAssetTitleTC4+ "\";");
		
		ExecutionLog.Log("All Deals used are:");
		ExecutionLog.Log("CreatedDealTC1 = \"" + CreatedDealTC1+ "\";");
		ExecutionLog.Log("CreatedDealTC2 = \"" + CreatedDealTC2+ "\";");
		ExecutionLog.Log("CreatedDealTC3 = \"" + CreatedDealTC3+ "\";");
		ExecutionLog.Log("CreatedDealTC3_2 = \"" + CreatedDealTC3_2+ "\";");
		ExecutionLog.Log("CreatedDealTC4 = \"" + CreatedDealTC4+ "\";");
		ExecutionLog.Log("CreatedDealTC6 = \"" + CreatedDealTC6+ "\";");
		ExecutionLog.Log("CreatedDealTC7 = \"" + CreatedDealTC7+ "\";");
		ExecutionLog.Log("CreatedDealTC9 = \"" + CreatedDealTC9+ "\";");
		ExecutionLog.Log("CreatedDealTC10 = \"" + CreatedDealTC10+ "\";");
		 
		
		// TC1
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC1);
		rightsIN.createDeal(CreatedDealTC1);
		rightsIN.searchCreatedDeal(CreatedDealTC1);
		rightsIN.associateAssetWithDeal(CreatedDealTC1,CreatedSeriesAssetTitleTC1);
		
		//TC2
		rightsIN.createDeal(CreatedDealTC2);
		
		//TC3
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC3,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC3);
		rightsIN.createDeal(CreatedDealTC3);
		rightsIN.searchCreatedDeal(CreatedDealTC3);
		rightsIN.associateAssetWithDeal(CreatedDealTC3,CreatedSeriesAssetTitleTC3);
		
		// TC4
		rightsIN.createDeal(CreatedDealTC4);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC4,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC4);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_EpisodeAdd));
		
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"101-103","Add Episode input field", Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "5").replace("@col", "3")+"/img", "user defined check box", Episode_SeasonValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to check user-defined check box");
		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "5").replace("@col", "4"), "Episode 003's season field", Episode_SeasonValue);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(ByLocator(OKButton));
		sendKeys(loc_Episodes_EditSeason_userDefined_InputField, "Season 3: user defined", "Episodes_EditSeason_userDefined Field", Episode_SeasonValue);
		selectDropdownValue(loc_Episodes_EditEpisodes_Userdefined_EditSeasonDropDown, "Episodes_EditEpisodes_Userdefined_EditSeason", "Original Version", Episodes_EditEpisodes_Userdefined_EditSeasonLabel);

		clickUsingJSExecutor(loc_OkButton, "OKButton at EditSeason pop-up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_EpisodeAdd));
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		
		assetMaintenance.createProgramAsset(CreatedMovieAssetTitleTC4,	AssetType_ProgrameMovie);
		rightsIN.searchCreatedDeal(CreatedDealTC4);
		rightsIN.associateAssetWithDeal(CreatedDealTC4,CreatedSeriesAssetTitleTC4);
		rightsIN.associateAssetWithDeal(CreatedDealTC4,CreatedMovieAssetTitleTC4);
		
		//TC6
		 //Asset of TC1 is used
		rightsIN.createDeal(CreatedDealTC6);
		rightsIN.associateAssetWithDeal(CreatedDealTC6,CreatedSeriesAssetTitleTC1);
		
		//TC7
		rightsIN.createDeal(CreatedDealTC7);
		rightsIN.associateAssetWithDeal(CreatedDealTC7,CreatedSeriesAssetTitleTC1);
		
		//TC9
		rightsIN.createDeal(CreatedDealTC9);
		rightsIN.associateAssetWithDeal(CreatedDealTC9,CreatedSeriesAssetTitleTC1);
		
		// TC10
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC10,Series_AssetType);
		rightsIN.createDeal(CreatedDealTC10);
		
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitleTC10);
		
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
		WaitForModalPanel();
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"101-170","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		WaitForModalPanel();	
		sleepTime(5);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode101");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);			
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		sleepTime(6);
		
		
		rightsIN.searchCreatedDeal(CreatedDealTC10);
		rightsIN.associateAssetWithDeal(CreatedDealTC10,CreatedSeriesAssetTitleTC10);
		
	}
	
	/**
	 * Total Steps 164 Steps<br></br>
	 * Can Not Automate Steps: #12 Steps. TC_RI_MR_130 , TC_RI_MR_131 and From TC_RI_MR_161 to TC_RI_MR_170<br></br>
	 * Obsolete: #2 Steps. TC_RI_MR_138 And TC_RI_MR_139


	 * @throws Exception
	 */
	@Test(priority =1,enabled = true,description = "To verify all UI Elements of RightsIn Media Rights Tab in View mode and Edit mode")
	public void TC1_MediaRightsUI () throws Exception {
		if(!(Browser.contains("firefox") || Browser.contains("chrome"))){
			
			rightsIN.searchCreatedDeal(CreatedDealTC1);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			
			//TC_RI_MR_01
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_01");
			ExecutionLog.Log("*****Verify all the buttons, drop down available in View Mode at the Media Rights TAB*****"); 
			verifyFieldValueOfHeader(loc_RI_MediaRights_AppliesToLabel, 				RI_MediaRights_AppliesToLabel, 		"RI_MediaRights_AppliesToLabel", 		RI_MediaRights_AppliesToLabel, 		"innerHTML");
			verifyFieldValueOfHeader(loc_RI_MediaRights_ClearFiltersButton, 			RI_MediaRights_ClearFiltersButton, 	"RI_MediaRights_ClearFiltersButton", 	RI_MediaRights_ClearFiltersButton, 	"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_ShowAllRowsLabel, 				RI_MediaRights_ShowAllRowsLabel, 	"RI_MediaRights_ShowAllRowsLabel", 		RI_MediaRights_ShowAllRowsLabel, 	"innerHTML");
			
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_APPLIESTO_Key+"']", 	RI_MediaRights_ViewMode_APPLIESTO_HeaderName, "AppliesTo_ViewMode","innerHTML");
			verifyElementPresent(loc_RI_MediaRights_SendReminderIcon, "loc_RI_MediaRights_SendReminderIcon", RI_MediaRights_SendReminderIcon);
			
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_RI_MediaRights_EditMode_AddButton));
			
			//TC_RI_MR_01
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_01");
			ExecutionLog.Log("*****Verify all the buttons, drop down available in Edit Mode at the Media Rights TAB*****"); 
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_CopyColumns_Button, 	RI_MediaRights_EditMode_CopyColumns_Button, 	"RI_MediaRights_EditMode_CopyColumns_Button", 	RI_MediaRights_EditMode_CopyColumns_Button, 	"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_CopyRows_Buttons, 		RI_MediaRights_EditMode_CopyRows_Buttons, 		"RI_MediaRights_EditMode_CopyRows_Buttons", 	RI_MediaRights_EditMode_CopyRows_Buttons, 		"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_AddButton, 			RI_MediaRights_EditMode_AddButton, 				"RI_MediaRights_EditMode_AddButton", 			RI_MediaRights_EditMode_AddButton, 				"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_DeleteButton, 			RI_MediaRights_EditMode_DeleteButton, 			"RI_MediaRights_EditMode_DeleteButton", 		RI_MediaRights_EditMode_DeleteButton, 			"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_SaveButton, 			RI_MediaRights_EditMode_SaveButton, 			"RI_MediaRights_EditMode_SaveButton", 			RI_MediaRights_EditMode_SaveButton, 			"value");
			verifyFieldValueOfHeader(loc_RI_closeButton, 			RI_MediaRights_EditMode_closeButton, 			"RI_MediaRights_EditMode_closeButton", 			RI_MediaRights_EditMode_closeButton, 			"value");

			//TC_RI_MR_05
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_05");
			ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Media Rights TAB*****"); 
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_APPLIESTO_Key+"']", 				RI_MediaRights_EditMode_APPLIESTO_HeaderName, 							"RI_MediaRights_EditMode_APPLIESTO_HeaderName",					RI_MediaRights_EditMode_APPLIESTO_HeaderName,				"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_PARTY_Key+"']", 					RI_MediaRights_EditMode_PARTY_HeaderName, 								"RI_MediaRights_EditMode_PARTY_HeaderName",						RI_MediaRights_EditMode_PARTY_HeaderName,					"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_MEDIA_TEMPLATE_Key+"']", 			RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 						"RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName",			RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName,			"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_ENDUSER_RIGHTS_TEMPLATE_Key+"']",	RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName,				"RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName",	RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName,	"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_VENUE_TEMPLATE_Key+"']", 			RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 						"RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName",			RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key+"']", 	RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName, 				"RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName", 	RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName, 	"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_TOUCHPOINT_TEMPLATE_Key+"']", 	RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 				"RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName", 		RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 	"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key+"']",RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 			"RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName", 	RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName,"innerHTML");
		
			scrollElementIntoView("//th[@key='"+RI_MediaRights_TERRITORY_TEMPLATE_Key+"']", 			RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName);
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_TERRITORY_TEMPLATE_Key+"']",	 	RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 					"RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName", 		RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 		"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_LANGUAGE_TEMLATE_Key+"']", 		RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 					"RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName", 		RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_FLAG_PERPETUITY_Key+"']", 		RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName, 					"RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName", 			RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName, 		"innerHTML");
		
			scrollElementIntoView("//th[@key='"+RI_MediaRights_BUSINESS_TERMS_Key+"']", 			RI_BUSINESS_TERMS_HeaderName);
			
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_TERM_FROM_DATE_Key+"']", 			RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName, 						"RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName", 				RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName, 				"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_TERM_TO_DATE_Key+"']", 			RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, 						"RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName", 					RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, 				"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_FLAG_EXCLUSIVITY_Key+"']", 		RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName, 					"RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName", 		RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName, 		"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_FLAG_RESTRICTION_TYPE_Key+"']", 	RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName, 				"RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName", 		RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName, 		"innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_FLAG_THIRD_PARTY_SUBLICENSE_Key+"']", RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName, 	"RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName", 	RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='"+RI_MediaRights_BUSINESS_TERMS_Key+"']", 			RI_BUSINESS_TERMS_HeaderName, 						"RI_MediaRights_EditMode_BUSINESS_TERMS_HeaderName",				RI_BUSINESS_TERMS_HeaderName, 				"innerHTML");

			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);

			//TC_RI_MR_09
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  Applies To  *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_09");
			
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), "RI_MediaRights_EditMode_APPLIESTO_Header Field",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Applis to Drop Down Image",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "RI_MediaRights_EditMode_AppliesToDropDown_ValueAll",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", CreatedSeriesAssetTitleTC1), CreatedSeriesAssetTitleTC1, CreatedSeriesAssetTitleTC1 , RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Season1), RI_MediaRights_Season1, "RI_MediaRights_EditMode_AppliesToDropDown_Season1",RI_MediaRights_Season1, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Episode101), RI_MediaRights_Episode101, "RI_MediaRights_EditMode_AppliesToDropDown_Episode101",RI_MediaRights_Episode101, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Episode102), RI_MediaRights_Episode102, "RI_MediaRights_EditMode_AppliesToDropDown_Episode102",RI_MediaRights_Episode102, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Season2), RI_MediaRights_Season2, "RI_MediaRights_EditMode_AppliesToDropDown_Season2",RI_MediaRights_Season2, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Episode201), RI_MediaRights_Episode201, "RI_MediaRights_EditMode_AppliesToDropDown_Episode201",RI_MediaRights_Episode201, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Episode202), RI_MediaRights_Episode202, "RI_MediaRights_EditMode_AppliesToDropDown_Episode202",RI_MediaRights_Episode202, "innerHTML");


			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "RI_MediaRights_EditMode_AppliesToDropDown_ValueAll",RI_MediaRights_EditMode_APPLIESTO_HeaderName, "innerHTML");


			
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_POPUP_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName)+"/img", "RI_MediaRights_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_APPLIESTO_Pick List ",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Checked Nodes of Assets ");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");

			// Check the Epi 101, 102 and verify that season 2 is also gets checked
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode102), "RI_EditMode_AppliesToDropDown_Episode101",RI_MediaRights_EditMode_APPLIESTO_HeaderName);

			// Verify Epi 101, 102 and season 1 are checked
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), "Checked Episode101 ");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode102), "Checked Episode102 ");
			
			if(ClientData.contains("TURNER") || ClientData.contains("VMN")) {
				// Parent is not getting selected on selecting all child
				verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), "Checked Season1 ");
			} else {
				verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), "Checked Season1 ");
			}
			

			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");

			//TC_RI_MR_15
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_15");
			ExecutionLog.Log("Check All the seasons and verify all the episodes are also gets checked");
			//Select all the Seasons under Series Asset
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",	RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season2), "RI_EditMode_AppliesToDropDown_Episode101",			RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 		"Checked Season1");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked Episode101");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode102), 	"Checked Episode102");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season2), 		"Checked Season2");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode201), 	"Checked Episode201");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode202), 	"Checked Episode201");
			
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "UnChecked Nodes of Assets ");

			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "RI_EditMode_AppliesToDropDown_" + CreatedSeriesAssetTitleTC1 + " Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			if(ClientData.contains("TURNER") || ClientData.contains("VMN")) {
				// Parent is not getting selected on selecting all child

				verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "UnChecked "+RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			} else {

				verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "Checked "+RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
				verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "UnChecked Nodes of Assets ");			

			}



			sleepTime(3);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"),	 "UnChecked Nodes of Assets ");
			
			
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
			WaitForModalPanel();
			ExecutionLog.Log("");
			verifyFieldValueOfHeader(AlertValidationMessgeText, RI_MediaRights_EditMode_SelectAtLeastOneElement, "Alert Message on RI_EditMode_APPLIESTO_Pick List", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			switchIntoFrame(frameParent4Xpath,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			
			//TC_RI_MR_21
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_21");
			ExecutionLog.Log("Select \"All\" checkbox in Applies To from pick list window");
			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll+ " check box");
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Checked Nodes of Assets ");

			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "RI_MediaRights_EditMode_AppliesToDropDown_ValueAll",RI_MediaRights_EditMode_APPLIESTO_HeaderName, "innerHTML");

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
			
			//TC_RI_MR_24
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  Party   *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_24");
			switchIntoFrame(frameParent3Xpath,RI_MediaRights_EditMode_PARTY_HeaderName);
			ExecutionLog.Log("************Select the Party from the drop down and verify the selected party************");
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_PARTY_Key, RI_MediaRights_EditMode_PARTY_HeaderName), "RI_MediaRights_EditMode_PARTY_Header Field",RI_MediaRights_EditMode_PARTY_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Party Drop Down Image", RI_MediaRights_EditMode_PARTY_HeaderName);
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_PartyName1), RI_PartyName1, RI_PartyName1,RI_MediaRights_EditMode_PARTY_HeaderName, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_PartyName2), RI_PartyName2, RI_PartyName2 , RI_MediaRights_EditMode_PARTY_HeaderName, "innerHTML");
			
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_PartyName1),	RI_PartyName1,	RI_MediaRights_EditMode_PARTY_HeaderName);
			String rowNoumberLocator = getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName);
			clickOn(rowNoumberLocator, 	"Support Click on ROW_NO_HeaderName",	RI_MediaRights_EditMode_PARTY_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_PARTY_Key, RI_MediaRights_EditMode_PARTY_HeaderName), RI_PartyName1, "RI_MediaRights_EditMode_PARTYDropDown_ValueAll",	RI_MediaRights_EditMode_PARTY_HeaderName, "innerHTML");

			if(!RI_MediaRights_EditMode_PARTY_HeaderName.contains("N/A")) {
				ExecutionLog.Log("");
				ExecutionLog.Log("************Party Pick List >> Select All >> verify Check Box >> Deselect All >> Verify Check boxes >> Click Apply and Verify Validation message************");
				switchIntoFrame(frameParent3Xpath);
				sleepTime(3);
				//moveMouse(getLocator_EditTAB_DataRow("1", RI_MediaRights_PARTY_POPUP_Key, RI_MediaRights_EditMode_PARTY_HeaderName)+"/img", "Party pick List Icon");
				doubleClick(getLocator_EditTAB_DataRow("1", RI_MediaRights_PARTY_POPUP_Key, RI_MediaRights_EditMode_PARTY_HeaderName)+"/img", "RI_MediaRights_EditMode_PARTY Pick List",RI_MediaRights_EditMode_PARTY_HeaderName);
				switchIntoFrame(frameParent4Xpath,RI_MediaRights_EditMode_PARTY_HeaderName);

				clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_Party_Pick List ",RI_MediaRights_EditMode_PARTY_HeaderName);
				verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "Unchecked Party ");
				verifyElementPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "Checked Parties ");

				clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_Party_Pick List",RI_MediaRights_EditMode_PARTY_HeaderName);
				verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "Checked Parties ");
				verifyElementPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "Unchecked Party ");
				doubleClick(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Appply button");
				WaitForModalPanel();
				verifyFieldValueOfHeader(AlertValidationMessgeText, RI_MediaRights_EditMode_SelectAtLeastOneElement, "Alert Message RI_MediaRights_EditMode_Party_Pick List", RI_MediaRights_EditMode_PARTY_HeaderName);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_MediaRights_EditMode_PARTY_HeaderName);
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
				clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_Party_Pick List ",RI_MediaRights_EditMode_PARTY_HeaderName);
				verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "Unchecked Party ");
				verifyElementPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "Checked Parties ");

				verifyFieldValueOfHeader(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked.replace("@var", RI_PartyName1), "Checked", RI_PartyName1 + "check Box", RI_MediaRights_EditMode_PARTY_HeaderName, "title");
				verifyFieldValueOfHeader(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked.replace("@var", RI_PartyName2), "Checked", RI_PartyName2 + "check Box", RI_MediaRights_EditMode_PARTY_HeaderName, "title");

				clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Appply button");
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath,RI_MediaRights_EditMode_PARTY_HeaderName);
				verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_PARTY_Key, RI_MediaRights_EditMode_PARTY_HeaderName), RI_PartyName1 + ";  " + RI_PartyName2, "Parties selected at Party field", RI_MediaRights_EditMode_PARTY_HeaderName, "innerHTML");

			}

			templateFunctionality(RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			"TC_RI_MR_42", 	RI_MediaRights_MEDIA_UD_POPUP_Key, 			RI_MediaRights_MediaType_Search,		RI_MediaRights_MediaType_DropDownValues,		RI_MediaRights_MEDIA_TEMPLATE_Key);
			templateFunctionality(RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			"TC_RI_MR_54", 	RI_MediaRights_VENUE_UD_POPUP_Key, 			RI_MediaRights_Venue_Search,			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		    templateFunctionality(RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName,	"TC_RI_MR_66", 	RI_MediaRights_PKGING_RIGHTS_UD_POPUP_Key, 	RI_MediaRights_Platform_Search,			RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
			templateFunctionality(RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 		"TC_RI_MR_78", 	RI_MediaRights_TOUCHPOINT_UD_POPUP_Key, 	RI_MediaRights_Restriction_Search,		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
			templateFunctionality(RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	"TC_RI_MR_90", 	RI_MediaRights_BUSINESS_OUTLET_UD_POPUP_Key,RI_MediaRights_BusinessOutLet_Search,	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
			
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName), 		
					RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			
			//scrollElementIntoView("//th[@key='"+RI_MediaRights_TERRITORY_TEMPLATE_Key+"']", 			RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName);
			templateFunctionality(RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 		"TC_RI_MR_102", RI_MediaRights_TERRITORY_UD_POPUP_Key, 		RI_MediaRights_Territory_Search,		RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
			templateFunctionality(RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		"TC_RI_MR_114", RI_MediaRights_LANGUAGE_UD_POPUP_Key, 		RI_MediaRights_Language_Search,			RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);

			
			enterDataInFieldEditMode("1", RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName, 			RI_MediaRights_EndUsersRights_DropDownValue,	 	RI_MediaRights_ENDUSER_RIGHTS_TEMPLATE_Key);

			//TC_RI_MR_126
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  PERPETUITY, TERM_FROM_DATE, TERM_TO_DATE, EXCLUSIVITY  *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_126");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath,	RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		
					"Term From Field",			RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img", 		"PERPETUITY Check Box",				RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
			
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 	RI_MediaRights_TermToDefaultData, 	"RI_MediaRights_EditMode_" + RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName,		RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, 	"innerHTML");


			// Enter Term From : 01/01/2008
			// And Term To : 01/01/2007
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		
															"Term From Field",			RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			switchIntoFrame(frameParent3Xpath,	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			sleepTime(3);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermToTestData, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			
			
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
					"Term To Field",			RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermFromTestData, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_TermToGreaterThanTermFrom_ValidationMessage);
			

			// Enter Term From : 01/01/2007
			// And Term To : 01/01/2008
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		
					"Term From Field",			RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			switchIntoFrame(frameParent3Xpath,	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			sleepTime(3);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermFromTestData, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermFromTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);


			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
					"Term To Field",			RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermToTestData, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);


			//TC_RI_MR_128
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
			
			verifyElementPresent(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img[@title='Unchecked']", "PERPETUITY check box gets unchecked on enterintg data in Term 'From'", RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
			//TC_RI_MR_132
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName), "EXCLUSIVITY Check Box", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			verifyElementPresent(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName)+"/img[@title='Checked']", "EXCLUSIVITY check box gets Checked", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			sleepTime(3);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName), "EXCLUSIVITY Check Box", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			verifyElementPresent(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName)+"/img[@title='Unchecked']", "EXCLUSIVITY check box gets Unchecked", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			sleepTime(3);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName), "EXCLUSIVITY Check Box", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			verifyElementPresent(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName)+"/img[@title='Checked']", "EXCLUSIVITY check box gets Checked", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			
			
			//TC_RI_MR_136
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  HoldBack/Restrictions  *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_136");
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_RESTRICTION_TYPE_Key, RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName), "RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName Field",RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Restrictions Drop Down Image",RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName);
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Restriction_DropDownValues1), RI_MediaRights_Restriction_DropDownValues1, "RI_MediaRights_Restriction_DropDownValues1",RI_MediaRights_Restriction_DropDownValues1, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Restriction_DropDownValues2), RI_MediaRights_Restriction_DropDownValues2, "RI_MediaRights_Restriction_DropDownValues2",RI_MediaRights_Restriction_DropDownValues2, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Restriction_DropDownValues3), RI_MediaRights_Restriction_DropDownValues3, "RI_MediaRights_Restriction_DropDownValues3",RI_MediaRights_Restriction_DropDownValues3, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Restriction_DropDownValues4), RI_MediaRights_Restriction_DropDownValues4, "RI_MediaRights_Restriction_DropDownValues4",RI_MediaRights_Restriction_DropDownValues4, "innerHTML");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Restriction_DropDownValues1), RI_MediaRights_Restriction_DropDownValues1 ,RI_MediaRights_Restriction_DropDownValues1);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_Restriction_DropDownValues1);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_RESTRICTION_TYPE_Key, RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName), RI_MediaRights_Restriction_DropDownValues1, "RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName",RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName, "innerHTML");

			//TC_RI_MR_138
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  Sublicense *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_138");
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_THIRD_PARTY_SUBLICENSE_Key, RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName), "RI_MediaRights_EditMode_FLAG_SubLicense_TYPE_HeaderName Field",RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "SubLicenses Drop Down Image",RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName);
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues1), RI_MediaRights_SubLicense_DropDownValues1, "RI_MediaRights_SubLicense_DropDownValues1",RI_MediaRights_SubLicense_DropDownValues1, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues2), RI_MediaRights_SubLicense_DropDownValues2, "RI_MediaRights_SubLicense_DropDownValues2",RI_MediaRights_SubLicense_DropDownValues2, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues3), RI_MediaRights_SubLicense_DropDownValues3, "RI_MediaRights_SubLicense_DropDownValues3",RI_MediaRights_SubLicense_DropDownValues3, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues4), RI_MediaRights_SubLicense_DropDownValues4, "RI_MediaRights_SubLicense_DropDownValues4",RI_MediaRights_SubLicense_DropDownValues4, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues5), RI_MediaRights_SubLicense_DropDownValues5, "RI_MediaRights_SubLicense_DropDownValues5",RI_MediaRights_SubLicense_DropDownValues5, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues6), RI_MediaRights_SubLicense_DropDownValues6, "RI_MediaRights_SubLicense_DropDownValues6",RI_MediaRights_SubLicense_DropDownValues6, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues7), RI_MediaRights_SubLicense_DropDownValues7, "RI_MediaRights_SubLicense_DropDownValues7",RI_MediaRights_SubLicense_DropDownValues7, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues8), RI_MediaRights_SubLicense_DropDownValues8, "RI_MediaRights_SubLicense_DropDownValues8",RI_MediaRights_SubLicense_DropDownValues8, "innerHTML");
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues9), RI_MediaRights_SubLicense_DropDownValues9, "RI_MediaRights_SubLicense_DropDownValues9",RI_MediaRights_SubLicense_DropDownValues9, "innerHTML");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_SubLicense_DropDownValues1), RI_MediaRights_SubLicense_DropDownValues1 ,RI_MediaRights_SubLicense_DropDownValues1);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_SubLicense_DropDownValues1);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_THIRD_PARTY_SUBLICENSE_Key, RI_MediaRights_SubLicense_DropDownValues1), RI_MediaRights_SubLicense_DropDownValues1, "RI_MediaRights_SubLicense_DropDownValues1",RI_MediaRights_SubLicense_DropDownValues1, "innerHTML");
			

			//TC_RI_MR_140
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  Notes *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_140");
			switchIntoFrame(frameParent3Xpath,	RI_BUSINESS_TERMS_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_BUSINESS_TERMS_Key, RI_BUSINESS_TERMS_HeaderName) + "/img", "RI_MediaRights_EditMode_BUSINESS_TERMS_HeaderName",RI_BUSINESS_TERMS_HeaderName);

			switchIntoFrame(frameParent4Xpath,	RI_BUSINESS_TERMS_HeaderName);
			verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header1+"']", 	RI_BUSINESS_TERMS_Header1, 	"RI_MediaRights_EditMode_BUSINESS_TERMS_Header1",	RI_BUSINESS_TERMS_Header1,				"innerHTML");
			verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header2+"']", 	RI_BUSINESS_TERMS_Header2, 	"RI_MediaRights_EditMode_BUSINESS_TERMS_Header2",	RI_BUSINESS_TERMS_Header2,				"innerHTML");
			verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header3+"']", 	RI_BUSINESS_TERMS_Header3, 	"RI_MediaRights_EditMode_BUSINESS_TERMS_Header3",	RI_BUSINESS_TERMS_Header3,				"innerHTML");
			verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header4+"']", 	RI_BUSINESS_TERMS_Header4, 	"RI_MediaRights_EditMode_BUSINESS_TERMS_Header4",	RI_BUSINESS_TERMS_Header4,				"innerHTML");
			
			verifyFieldValueOfHeader(LocAdd, 			RI_NoteWindow_AddButton, 		"RI_MediaRights_NoteWindow_AddButton", 		RI_NoteWindow_AddButton, 		"value");
			verifyFieldValueOfHeader(loc_Delete, 		RI_NoteWindow_DeleteButton, 	"RI_MediaRights_NoteWindow_DeleteButton", 	RI_NoteWindow_DeleteButton, 	"value");
			verifyFieldValueOfHeader(loc_Save, 			RI_NoteWindow_SaveButton, 		"RI_MediaRights_NoteWindow_SaveButton", 	RI_NoteWindow_SaveButton, 		"value");
			verifyFieldValueOfHeader(loc_Cancel, 		RI_NoteWindow_CancelButton, 	"RI_MediaRights_NoteWindow_CancelButton", 	RI_NoteWindow_CancelButton, 	"value");
			clickOn(LocAdd, "Add Button at Notes Window",RI_BUSINESS_TERMS_HeaderName);

			clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
			
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), "Business Term Field",	RI_MediaRights_NoteWind_Category_HeaderName);
			clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Business Term Drop Down image",	RI_MediaRights_NoteWind_Category_HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Note_BusinessTerm1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "Use Template Field",	RI_MediaRights_NoteWind_Template_HeaderName);
			clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Use Template Drop Down image",	RI_MediaRights_NoteWind_Template_HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Note_UseTemplate1), RI_MediaRights_Note_UseTemplate1 ,RI_MediaRights_NoteWind_Template_HeaderName);
			
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Notes_Key, RI_MediaRights_NoteWind_Notes_HeaderName), "Term Description Field",	RI_MediaRights_NoteWind_Notes_HeaderName);
			sendKeys(loc_RI_MediaRights_NoteWind_Descrip_InputField, "RSG@$@$@#$@%@#%$'; ", "Term Description Data", RI_MediaRights_NoteWind_Notes_HeaderName);
			
			// Verify Restriction check box
			ExecutionLog.Log("");
			ExecutionLog.Log("*********Verify Restriction check box*******");
			clickUsingJSExecutor(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);

			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");
			
			
			sleepTime(3);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Unchecked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");

			sleepTime(3);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");

			// Verify includeInReport check box.
			ExecutionLog.Log("");
			ExecutionLog.Log("*********Verify includeInReport check box*******");
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
			verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Unchecked']", "NoteWind_includeInReport Check Box is Checked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
			sleepTime(3);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
			verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Checked']", "NoteWind_includeInReport Check Box is Unchecked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
			sleepTime(3);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
			verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Unchecked']", "NoteWind_includeInReport Check Box is Checked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
			
			// Verify the entered data is shown at the Note Window
			switchIntoFrame(frameParent4Xpath);
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), RI_MediaRights_Note_BusinessTerm1, "RI_MediaRights_NoteWind_Category_HeaderName",RI_MediaRights_NoteWind_Category_HeaderName, "innerHTML");
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "", "RI_MediaRights_NoteWind_Template_HeaderName",RI_MediaRights_NoteWind_Template_HeaderName, "innerHTML");
			clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			
			verifyElementNotPresent(frameParent4Xpath, "Note Window");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSaved);

		} else {
			throw new SkipException("TC1 is can not autoamted for FF and Chrome");
		}
	}
	
	/**
	 * Total Steps 33 Steps
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =2,enabled = true,description = "To verify behavior of fields RightsIn Media Rights Tab - View Mode" )
	public void TC2_MediaRightsView () throws Exception {
		if(!(Browser.contains("firefox") || Browser.contains("chrome"))){
			rightsIN.searchCreatedDeal(CreatedDealTC2);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			// Enter the data for Row1
			enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
			
			
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img", "PERPETUITY check box ", RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName)+"/img", "EXCLUSIVITY check box ", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);
			switchIntoFrame(frameParent3Xpath,	RI_BUSINESS_TERMS_HeaderName);
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_BUSINESS_TERMS_Key, RI_BUSINESS_TERMS_HeaderName) + "/img");

			// Adding Note
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_BUSINESS_TERMS_Key, RI_BUSINESS_TERMS_HeaderName) + "/img", "RI_MediaRights_EditMode_BUSINESS_TERMS_HeaderName",RI_BUSINESS_TERMS_HeaderName);
			switchIntoFrame(frameParent4Xpath);
			clickOn(LocAdd, "Add Button at Notes Window",RI_BUSINESS_TERMS_HeaderName);
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), "Business Term Field",	RI_MediaRights_NoteWind_Category_HeaderName);
			clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Business Term Drop Down image",	RI_MediaRights_NoteWind_Category_HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Note_BusinessTerm1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);

			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Notes_Key, RI_MediaRights_NoteWind_Notes_HeaderName), "Term Description Field",	RI_MediaRights_NoteWind_Notes_HeaderName);
			sendKeys(loc_RI_MediaRights_NoteWind_Descrip_InputField, "RSG@$@$@#$@%@#%$'; ", "Term Description Data", RI_MediaRights_NoteWind_Notes_HeaderName);
			clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), "Business Term Field",	RI_MediaRights_NoteWind_Category_HeaderName);

			clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			WaitForModalPanel();


			ExecutionLog.Log("Verifying the data in View Mode");
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_MEDIA_TEMPLATE_Key, RI_MediaRights_EditMode_Template_MediaType_HeaderName, RI_MediaRights_MediaType_PickListValues, RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_VENUE_TEMPLATE_Key, RI_MediaRights_EditMode_Template_Venue_HeaderName, RI_MediaRights_Venue_PickListValues, RI_MediaRights_EditMode_Template_Venue_HeaderName);
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key, RI_MediaRights_EditMode_Template_PlatformRestriction_HeaderName, RI_MediaRights_Platform_PickListValues, RI_MediaRights_EditMode_Template_PlatformRestriction_HeaderName);
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_TOUCHPOINT_TEMPLATE_Key, RI_MediaRights_EditMode_Template_Restriction_HeaderName, RI_MediaRights_Restriction_PickListValues, 	RI_MediaRights_EditMode_Template_Restriction_HeaderName);
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key, RI_MediaRights_EditMode_Template_Business_HeaderName,RI_MediaRights_BusinessOutLet_PickListValues,	RI_MediaRights_EditMode_Template_Business_HeaderName);
			
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_EditMode_Template_Territory_HeaderName, RI_MediaRights_Territory_PickListValues,	RI_MediaRights_EditMode_Template_Territory_HeaderName);
			clickDataRowViewMode_VerifyHeaderName_CloseWindow(RI_MediaRights_LANGUAGE_TEMLATE_Key, RI_MediaRights_EditMode_Template_Language_HeaderName, RI_MediaRights_Language_PickListValues,	RI_MediaRights_EditMode_Template_Language_HeaderName);


			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			doubleClick(getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_BUSINESS_TERMS_Key, RI_MediaRights_EditMode_Template_NoteWindow_HeaderName), RI_MediaRights_EditMode_Template_NoteWindow_HeaderName, RI_MediaRights_EditMode_Template_NoteWindow_HeaderName);
			WaitForModalPanel();
			verifyTextMatches(loc_RI_MediaRights_HeaderAtViewMode, "Header Name", RI_MediaRights_EditMode_Template_NoteWindow_HeaderName);

			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), RI_MediaRights_Note_BusinessTerm1, "RI_MediaRights_NoteWind_Category_HeaderName",RI_MediaRights_NoteWind_Category_HeaderName, "innerHTML");
			verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "", "RI_MediaRights_NoteWind_Template_HeaderName",RI_MediaRights_NoteWind_Template_HeaderName, "innerHTML");
			clickOn(Loc_Cancel + " | " + loc_RI_closeButton,"Ok button at" + RI_MediaRights_EditMode_Template_NoteWindow_HeaderName + "Window");
			ExecutionLog.Log("");

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyElementPresent(getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img", "PERPETUITY check box is Checked", RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
			verifyElementPresent(getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_FLAG_EXCLUSIVITY_Key, RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName)+"/img", "EXCLUSIVITY check box is Checked", RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName);

			doubleClick(getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName at View Mode",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
			WaitForModalPanel();
			verifyTextMatches(loc_RI_MediaRights_HeaderAtViewMode, "Header Name", RI_MediaRights_EditMode_Template_TermEvent_HeaderName);
			switchIntoFrame(frameParent3Xpath);
			clickOn(LocCancel,"Cancel button at Term Event Window");
			ExecutionLog.Log("");

		} else {
			throw new SkipException("TC1 is can not autoamted for FF and Chrome");
		}
	}
	
	/**
	 * Total Steps 6 Steps
	 * Can Not Automate Steps: #01 Steps. TC_RI_MR_03 
	 * Obsolete: #01 Steps. TC_RI_MR_04 And TC_RI_MR_139
	 * @throws Exception
	 */
	@Test(priority =3,enabled = true,description = "Functionality of Row Number in Media Rights Tab")
	public void TC3_MediaRightsMultiple() throws Exception {
		if(!ClientData.contains("VMN")) {
			rightsIN.searchCreatedDeal(CreatedDealTC3);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			// Enter the data for Row 1
			enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			// Enter the data for Row 2
			enterDatainAllFields("2", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);


			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("3", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "1", "Row Number 1", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("2", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "2", "Row Number 2", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "3", "Row Number 3", RI_MediaRights_EditMode_ROW_NO_HeaderName);

			clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "3rd row of Edit Media Rights TAB");
			clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
			driver.switchTo().window(driver.getWindowHandle());
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);

			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("3", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "4", "Row Number 3", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			WaitForModalPanel();


			//TC_RI_MR_02
			ExecutionLog.Log("");
			ExecutionLog.Log("*****  Audit Trail *****"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_02");
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(loc_PageLink.replace("@var", "Reports"),"Reports");
			clickUsingJSExecutor(loc_AuditTrail,"Audit Trail");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_DealName, CreatedDealTC3, "Deal Name Field", "");
			clickUsingJSExecutor(Loc_SearchButton, "Search Button", "");
			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_ExpandDeal_Icon,"Expand Icon");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyElementPresent(loc_AuditTrail_RowDeleted, "3rd Row of Media right");


			//TC_RI_MR_05
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_05");
			ExecutionLog.Log("***** Create Three Row >> Delete 3rd Row without saving >> Create 3rd Row >> Save >> Verify that 3rd row is shown with Row no. '3'*****"); 


			rightsIN.createDeal(CreatedDealTC3_2);
			rightsIN.associateAssetWithDeal(CreatedDealTC3_2,CreatedSeriesAssetTitleTC3);
			rightsIN.searchCreatedDeal(CreatedDealTC3_2);


			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("2", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("3", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);


			clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "3rd row of Edit Media Rights TAB");
			clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
			driver.switchTo().window(driver.getWindowHandle());
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "", "Row Number 1", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("2", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "", "Row Number 2", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyElementNotPresent(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName),"3rd Row");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("3", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();

			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "1", "Row Number 1", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("2", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "2", "Row Number 2", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "3", "Row Number 3", RI_MediaRights_EditMode_ROW_NO_HeaderName);


		} else {
			throw new SkipException("Audit Trail Functionality is not available for VMN");
		}

	}
	
	/**
	 * Total Steps 24 Steps
	 * Need to Automated #2 Steps (Bug ID : 21050)
	 * @throws Exception
	 */
	@Test(priority =4,enabled = true,description = "Create multiple rows with different assets in Applies To")
	public void TC4_MediaRightsCreateMultipleRows() throws Exception {
		
		rightsIN.searchCreatedDeal(CreatedDealTC4);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
	

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		

		if(!ClientData.contains("VMN")) {
			//TC_RI_MR_06
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_06");
			ExecutionLog.Log("*****  Adding 2nd Row(Fill data in 2nd Row) >> Close >> Cancel(Confirm Pop up) >> Close >> OK(Confirm Pop up) *****"); 
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			enterDatainAllFields("2", RI_MediaRights_Season1);
			
			switchIntoFrame(frameParent3Xpath);
			
			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			WaitForModalPanel();
			verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_NavigateAwayPopup, "Alert Message on clicking 'Remove Button'", RI_MediaRights_EditMode_closeButton);
			clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			WaitForModalPanel();
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
			
			
			//TC_RI_MR_11
			ExecutionLog.Log("");
			ExecutionLog.Log("******Change Party >> Close >> Cancel(Confirm Pop up) >> Save >> Verify Successfully saved Message******"); 
			ExecutionLog.Log("From Manual Test Step : TC_RI_MR_11");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			enterDataInFieldEditMode("1", RI_MediaRights_EditMode_PARTY_HeaderName, 					RI_PartyName2,	 								RI_MediaRights_PARTY_Key);
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			driver.switchTo().window(driver.getWindowHandle());	
			clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		} 
		
		
		//TC_RI_MR_17
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_17");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		enterDatainAllFields("2", CreatedMovieAssetTitleTC4);
	
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_APPLIESTO_POPUP_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName)+"/img", "RI_MediaRights_EditMode_APPLIESTO_HeaderName List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		switchIntoFrame(frameParent4Xpath, RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_Party_Pick List",RI_MediaRights_EditMode_PARTY_HeaderName);
		sleepTime(5);
			
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "RI_MediaRights_Season1");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_UserDefinedSeason), "RI_MediaRights_UserDefinedSeason");
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), 	RI_MediaRights_Season1 + "," + RI_MediaRights_UserDefinedSeason , "RI_MediaRights_EditMode_",		RI_MediaRights_Season1 + "," + RI_MediaRights_UserDefinedSeason, 	"innerHTML");
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_PARTY_HeaderName, 					RI_PartyName1,	 								RI_MediaRights_PARTY_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName,	RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		scrollElementIntoView(getLocator_EditTAB_DataRow("3", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);

		clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermFromTestData, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermFromTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermToTestData, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow("3", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyElementPresent(getLocator_EditTAB_DataRow("3", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img[@title='Unchecked']", "PERPETUITY check box gets unchecked on enterintg data in Term 'From'", RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
		switchIntoFrame(frameParent3Xpath);
		

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("4", RI_MediaRights_APPLIESTO_POPUP_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName)+"/img", "RI_MediaRights_EditMode_APPLIESTO_HeaderName List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		switchIntoFrame(frameParent4Xpath, RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ RI_MediaRights_EditMode_APPLIESTO_HeaderName + "",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
		//verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets at "+ RI_MediaRights_EditMode_APPLIESTO_HeaderName + "");
		//verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), 	"Unchecked Nodes of Assets at "+ RI_MediaRights_EditMode_APPLIESTO_HeaderName + "");

		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_MediaRights_Episode101");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode102), "RI_MediaRights_Episode102");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode201), "RI_MediaRights_Episode103");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode202), "RI_MediaRights_Episode104");
		
		
		
		
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		switchIntoFrame(frameParent3Xpath);
		
		String AppliesToValue = RI_MediaRights_Season1 + "," + RI_MediaRights_Season2; 
		
		if(ClientData.contains("TURNER") || ClientData.contains("VMN")) {
			// Parent is not getting selected on selecting all child
			AppliesToValue = RI_MediaRights_Episode101 + "," + RI_MediaRights_Episode102+ "," + RI_MediaRights_Episode201+ "," + RI_MediaRights_Episode202; 
		}
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("4", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), 	AppliesToValue , "RI_MediaRights_EditMode_" + RI_MediaRights_EditMode_APPLIESTO_HeaderName,		RI_MediaRights_Season1 + "," + RI_MediaRights_UserDefinedSeason, 	"innerHTML");
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_PARTY_HeaderName, 					RI_PartyName1,	 								RI_MediaRights_PARTY_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName,	RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		scrollElementIntoView(getLocator_EditTAB_DataRow("4", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);


			clickOn(getLocator_EditTAB_DataRow("4", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermFromTestData, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow("4", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("4", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermFromTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		clickOn(getLocator_EditTAB_DataRow("4", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermToTestData, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow("4", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("4", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyElementPresent(getLocator_EditTAB_DataRow("4", RI_MediaRights_FLAG_PERPETUITY_Key, RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName)+"/img[@title='Unchecked']", "PERPETUITY check box gets unchecked on enterintg data in Term 'From'", RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName);
		switchIntoFrame(frameParent3Xpath);
		
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		
		
	}
	
	/**
	 * Total Steps 5 Steps
	 * @throws Exception
	 */
	@Test(priority =5,enabled = true,description = "Delete an Asset from the Deal that has been used in Applies To")
	public void TC5_DeleteAssetsFromDeal() throws Exception {
		
		
		rightsIN.searchCreatedDeal(CreatedDealTC4);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator", "");
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(By.xpath(ListDealNavigatorDeal));
		//clickOn(loc_AssetAtDealNavigator.replace("@var", CreatedMovieAssetTitleTC4), "Asset " + CreatedMovieAssetTitleTC4 + "at Deal Navigator Window");
		Actions oAction = new Actions(driver);
		oAction.contextClick(driver.findElement(ByLocator(loc_AssetAtDealNavigator.replace("@var", CreatedMovieAssetTitleTC4)))).build().perform();
		clickOn(loc_MenuAtDealNavigator.replace("@var", "Delete"), "DeleteMenuAtDealNavigator");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg while unlinking asset from the deal", RI_MediaRights_AssetUnlinkFromDeal_ValidationMessage);
		sleepTime(1);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Ok Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(By.xpath(ListDealNavigatorDeal));
		verifyElementNotPresent(loc_AssetAtDealNavigator.replace("@var", CreatedMovieAssetTitleTC4), "Asset" + CreatedMovieAssetTitleTC4);

	}

	/**
	 * Total Steps 12 Steps
	 * @throws Exception
	 */
	@Test(priority =6,enabled = true,description = "Verify Copy Functionality")
	public void TC6_MediaRightsCopyRow() throws Exception {

		
		rightsIN.searchCreatedDeal(CreatedDealTC6);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		
		enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		
		//////////////Created Asset For TC6////////////////////////
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);		
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_SelectRowToCopy_ValidationMessage, "Alert Message RI_MediaRights_Copy rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);		
		WaitForModalPanel();
		verifyFieldValueOfHeader(PromptAlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_ValidationMessage, "Alert Message RI_MediaRights_Copy rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		sendKeys(PromptAlertInputBox, "20", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_InvalidNumber_ValidationMessage, "Alert Message RI_MediaRights_Copy rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		sendKeys(PromptAlertInputBox, "10", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		
		
		
		
		
		
		//TC_RI_MR_10
		ExecutionLog.Log("");
		ExecutionLog.Log("Verifying the data of Each copied row in Edit Mode Before Saving");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_10");


		switchIntoFrame(frameParent3Xpath);
		verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("2",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("3",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("4",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("5",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("6",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("7",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("8",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("9",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("10",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("11",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		WaitForModalPanel();
		
		//TC_RI_MR_10
		ExecutionLog.Log("");
		ExecutionLog.Log("Verifying the data of Each copied row in Edit Mode After Saving");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_10");


		switchIntoFrame(frameParent3Xpath,RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("2",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("3",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("4",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("5",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("6",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("7",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("8",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("9",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("10",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("11",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		

		//TC_RI_MR_14
		ExecutionLog.Log("");
		ExecutionLog.Log("Verifying the data of Each copied row in View Mode");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_14");


		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyAllAvailableFields_ViewMode("2");
		verifyAllAvailableFields_ViewMode("3");
		verifyAllAvailableFields_ViewMode("4");
		verifyAllAvailableFields_ViewMode("5");
		verifyAllAvailableFields_ViewMode("6");
		verifyAllAvailableFields_ViewMode("7");
		verifyAllAvailableFields_ViewMode("8");
		verifyAllAvailableFields_ViewMode("9");
		verifyAllAvailableFields_ViewMode("10");
		verifyAllAvailableFields_ViewMode("11");
		verifyAllAvailableFields_ViewMode("12");
		
		
		
	}
	
	/**
	 * Total Steps 13 Steps
	 * @throws Exception
	 */
	@Test(priority =7,enabled = true,description = "Verify Copy Column Functionality")
	public void TC7_MediaRightsCopyColumn() throws Exception {

		rightsIN.searchCreatedDeal(CreatedDealTC7);
		
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		// Enter Data in Row 1
		enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
	
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		
		///////////////////////////////////////////////////
		
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_CopyColumns_Button, "Copy Columns Button", RI_MediaRights_EditMode_CopyColumns_Button);		
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_SelectRowBeforeCopyColumn_ValidationMessage, "Alert Message RI_MediaRights_Columns rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_MediaRights_EditMode_CopyColumns_Button);
		switchIntoFrame(frameParent3Xpath);
		
		// add 3 blank row
		switchIntoFrame(frameParent3Xpath);
	// 2nd Row
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
	// 3rd row
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
	//4th Row
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		
		// enter data for 2nd row
		//TC_RI_MR_04
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_04");
		ExecutionLog.Log("");
		ExecutionLog.Log("Enter the data for 2nd Row  >> Click Copy column >> Verify 'SaveRowBeforeCopyColumn' Validation message");
		// Enter Data in Row 2
		enterDatainAllFields("2", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		
		// click copy column and verify validation msg
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_CopyColumns_Button, "Copy Columns Button", RI_MediaRights_EditMode_CopyColumns_Button);		
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_SaveRowBeforeCopyColumn_ValidationMessage, "Alert Message RI_MediaRights_Columns rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_MediaRights_EditMode_CopyColumns_Button);
		
	
		
		

		//TC_RI_MR_06
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_06");
		ExecutionLog.Log("");
		ExecutionLog.Log("Select Saved First Row >> Copy Column >> Verify check boxes >> Apply >> Verify the data is copied in below rows");
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_DataRowXpath_EditMode+"/th", "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);

		// verify available field's check boxes at Copy Column Window
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_CopyColumns_Button, "Copy Columns Button", RI_MediaRights_EditMode_CopyColumns_Button);	
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_APPLIESTO_HeaderName.replace("*", "")), "Applies To", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_PARTY_HeaderName.replace("*", "")), "Party", RI_MediaRights_EditMode_PARTY_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName.replace("*", "")), "Media", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName.replace("*", "")), "Venue", RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName.replace("*", "")), "Packeging Rights", RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName.replace("*", "")), "Restriction", RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName.replace("*", "")), "Business Outlet", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName.replace("*", "")), "TERRITORY", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName);
		verifyElementPresent(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName.replace("*", "")), "LANGUAGE", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName);
		clickOn(Applybutton_AtSBUWindow, "Apply button at Copy Columns Window");
		
		
		
		switchIntoFrame(frameParent3Xpath);
		verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("2",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("3",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyAllAvailableFields_EditMode("4",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		//// TODO Need to verify the check boxes
		


		//TC_RI_MR_08
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_08");
		ExecutionLog.Log("Click Add Button >> Select Saved First Row >> Copy Column >> Check MEDIA,BUSINESS,TERRITORY,lANGUAGE Check boxes >> Apply >> Verify the data is copied in below rows");
		
		switchIntoFrame(frameParent3Xpath);
	// 5th Row
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_CopyColumns_Button, "Copy Columns Button", RI_MediaRights_EditMode_CopyColumns_Button);	
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelect All Check Boxes at Copy Column Window");
		
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName.replace("*", "")),"MEDIA");
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName.replace("*", "")),"BUSINESS_OUTLET");
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName.replace("*", "")),"TERRITORY_TEMPLATE");
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName.replace("*", "")),"LANGUAGE_TEMPLATE");
		
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", "")),"Term From");
		clickOn(loc_RI_MediaRights_LabelsCopyColumnWindow.replace("@var", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName.replace("*", "")),"Term To");
		clickOn(Applybutton_AtSBUWindow, "Apply button at Copy Columns Window");
		
		switchIntoFrame(frameParent3Xpath);
		

		verifyFieldValue_EditMode("5", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		verifyFieldValue_EditMode("5", RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		verifyFieldValue_EditMode("5", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		verifyFieldValue_EditMode("5", RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);
		scrollElementIntoView(getLocator_EditTAB_DataRow("5", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("5", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermFromTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("5", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		verifyAllAvailableFields_ViewMode("2");
	}
	
	/**
	 * Total Steps 15 Steps
	 * @throws Exception
	 */
	@Test(priority =8,enabled = true,description = "Verify Delete Functionality")
	public void TC8_MediaRightsDelete() throws Exception {

		rightsIN.searchCreatedDeal(CreatedDealTC7);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_SelectRowToDelete_ValidationMessage, "Alert Message do not select the row and click Delete", RI_MediaRights_EditMode_DeleteButton);
		
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath");
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage, "Alert Message RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage, "Alert Message RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		
		//TC_RI_MR_07
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_NavigateAwayPopup, "Alert Message RI_MediaRights_EditMode_NavigateAwayPopup", RI_MediaRights_EditMode_DeleteButton);
		sleepTime(3);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		
		
		// AMCN : Need to click Two times to click on Ok Button at Navigate away from the page pop-up
		if(Browser.contains("ie") && (ClientData.contains("AMCN") || ClientData.contains("CORUS"))) {
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
			WaitForModalPanel();
			verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_NavigateAwayPopup, "Alert Message RI_MediaRights_EditMode_NavigateAwayPopup", RI_MediaRights_EditMode_DeleteButton);
			sleepTime(3);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");

			
		}
		
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage, "Alert Message RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_NavigateAwayPopup, "Alert Message RI_MediaRights_EditMode_NavigateAwayPopup", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");

		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		verifyElementNotPresent(frameParent3Xpath,"Edit Media Rights Window");
	}

	/***
	 * Total Steps 35 Steps
	 * Obsolete Steps: #10
	 * @throws Exception
	 */
	@Test(priority =9,enabled = true,description = "Media Rights Filter")
	public void TC9_MediaRightsFilter() throws Exception {
		
		rightsIN.searchCreatedDeal(CreatedDealTC9);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		
		enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
	
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		
		//TC_RI_MR_12
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfullyWithUpdatedFilter);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter ", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesToFilter_LabelName);
	
		
		//TC_RI_MR_14
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_14");
		ExecutionLog.Log("Copy Three Rows >> Save >> Verify the value in the Asset Filter >> Select All Asset Filter >> Verify Respective Assets are shown only");
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);		
		WaitForModalPanel();
		verifyFieldValueOfHeader(PromptAlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_ValidationMessage, "Alert Message RI_MediaRights_Copy rows", RI_MediaRights_EditMode_CopyRows_Buttons);
		sendKeys(PromptAlertInputBox, "3", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
		enterDataInFieldEditMode("2", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode101,	 	RI_MediaRights_APPLIESTO_Key);
		enterDataInFieldEditMode("3", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode102,	 	RI_MediaRights_APPLIESTO_Key);
		enterDataInFieldEditMode("4", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode201,	 	RI_MediaRights_APPLIESTO_Key);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfullyWithUpdatedFilter);
		String ValueInAssetFilter = 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll + "," + RI_MediaRights_Episode101 + "," + RI_MediaRights_Episode102 + "," + RI_MediaRights_Episode201;
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter ", ValueInAssetFilter, RI_MediaRights_EditMode_AppliesTo_DropDown, "title"); // tile is not working in VMN
		

		
		//TC_RI_MR_16
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_16");
		ExecutionLog.Log("Close Edit Window >> Verify the Filter value in View Mode  >> Change the value of Filter >> Edit >> verify Filter Value in Edit Mod");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter ", ValueInAssetFilter, RI_MediaRights_EditMode_AppliesTo_DropDown, "title");
		// Change the Filter value in View mode and verify in Edit Mode
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesTo_DropDown);
		
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter ", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesTo_DropDown, "title");

		
		verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		verifyElementNotPresent(getLocator_EditTAB_DataRow("2", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), "Second Row at Edit Mode");

		//TC_RI_MR_20
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_20");
		ExecutionLog.Log("Clear Filter >> Verify All Rows of Assets are shown >> Filter with Alphabate 'A' >> Verify the Values shown in Edit Media Rights Window");
		switchIntoFrame(frameParent3Xpath);
		scrollElementIntoView(loc_RI_MediaRights_ClearFiltersButton, RI_MediaRights_ClearFiltersButton);
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "All in First Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("2", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_Episode101, "Episode101 in Second Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_Episode102, "Episode102 in Third Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("4", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_Episode201, "Episode201 in Forth Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		
		clickOn(loc_RI_MediaRights_EditMode_AlphabateFilterPickList, "AlphabateFilter PickList");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", "A"), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "'All' in First Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(getLocator_EditTAB_DataRow("2", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), "Second Row at Edit Mode");

		//TC_RI_MR_23
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_23");
		ExecutionLog.Log("Change Filter from 'A' to 'All' >> Verify Msg >> Cancel ");

		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter At Edit Mode", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesTo_DropDown);
		driver.switchTo().window(driver.getWindowHandle());	
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_MediaRights_EditMode_ChangeFilterConfirmation_ValidationMessage, "Alert Message on Changing Filter From 'A' to 'All'", "");
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Alphabate Filter ", "A", RI_MediaRights_EditMode_Alphabet_DropDown, "title");

		//TC_RI_MR_25
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_25");
		ExecutionLog.Log("Change Filter from 'A' to 'All' >> Verify Msg >> OK ");
		
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter At Edit Mode", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesTo_DropDown);
		driver.switchTo().window(driver.getWindowHandle());	
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_MediaRights_EditMode_ChangeFilterConfirmation_ValidationMessage, "Alert Message on clicking 'Remove Button'", document_DeleteDocumentValue);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Aphabate Filter ", "(Select One)", RI_MediaRights_EditMode_Alphabet_DropDown, "title");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter ", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_AppliesTo_DropDown, "title");

		//TC_RI_MR_28
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_28");
		ExecutionLog.Log("Apply Episodes 202 in Filter >> Verify 'No Matched' Validation Msg");
		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter At Edit Mode", RI_MediaRights_Episode202, RI_MediaRights_EditMode_AppliesTo_DropDown);
		WaitForModalPanel();
		
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_NoMathingFound_ValidationMessage);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter At Edit Mode", RI_MediaRights_Episode201, RI_MediaRights_EditMode_AppliesTo_DropDown);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Episodes 201 is shown at row number 1 after applying filter for Episodes 201
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_Episode201, "Episode201 in Forth Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		
		
		rightsIN.searchCreatedDeal(CreatedDealTC9);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		if(ClientData.contains("TURNER")) {
			ExecutionLog.Log("Bug Id:21156");
		}
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "All in First Row", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		//Only one row is shown which has 'All' Asset

	}

	/**
	 * Total Steps 9 Steps
	 * Obsolete : #01 Steps
	 * @throws Exception
	 */
	@Test(priority =10,enabled = false,description = "Media Rights View Mode Pagination")
	public void TC10_MediaRightsPagination() throws Exception {
		
		rightsIN.searchCreatedDeal(CreatedDealTC10);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
	
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		
		
		switchIntoFrame(frameParent3Xpath);
		
		clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);		
		WaitForModalPanel();
		sendKeys(PromptAlertInputBox, "10", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		
			
		// Adding 70 Rows
		int EpisodeNo = 101;
		for(int i = 1; i <= 70; i++) {
			switchIntoFrame(frameParent3Xpath);
			//i : check the last row is displayed if not them make it displayed
			if(!driver.findElement(ByLocator(getLocator_EditTAB_DataRow(i + "", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName))).isDisplayed()) {
				scrollElementIntoView(getLocator_EditTAB_DataRow(i + "", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName));
			}	
			enterDataInFieldEditMode(i + "", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				"Episode"+EpisodeNo,	 	RI_MediaRights_APPLIESTO_Key);
			
			if(EpisodeNo%10==0) {
				switchIntoFrame(frameParent3Xpath);
				clickOn(getLocator_EditTAB_DataRow(i+"", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
				doubleClick(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);		
				WaitForModalPanel();
				sendKeys(PromptAlertInputBox, "10", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
				clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
							
			}
			EpisodeNo++;
		}
		
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		//close > Clear Filter >> Frame switch >> Verify Pages
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_ClearFiltersButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyElementPresent(loc_RI_MediaRights_ViewMode_CurrentPage.replace("@var", "1"), "Page 1");
		verifyElementPresent(loc_RI_MediaRights_ViewMode_PageLink.replace("@var", "2"), "Page 2 Link");
		clickOn(loc_RI_MediaRights_ViewMode_PageLink.replace("@var", "2"), "Page 2 Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyElementPresent(loc_RI_MediaRights_ViewMode_CurrentPage.replace("@var", "2"), "Current Page : 2");
		verifyElementPresent(loc_RI_MediaRights_ViewMode_PageLink.replace("@var", "1"), "Page 1 Link");
	}
	
	
	
	//////////////////////////////////////////////Utility Methods which are specific to Media Rights TAB///////////////////////////////////////////////////////////////////////////////
	/**
	 * @author Rajuddin
	 * @param rowNumber
	 * @param AssetName
	 * @param StartDate_EndDate_DealType   : Program Deal OR Element Deal etc. 
	 * @throws Exception
	 * @description : Note: Currently StartDate and EndDate are not used in this method
	 */
	public void enterDatainAllFields(String rowNumber, String AssetName, Object...StartDate_EndDate_DealType) throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("----------Enter the data in all Fields of Media Rights in Row:" + rowNumber);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				AssetName,	 	RI_MediaRights_APPLIESTO_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_PARTY_HeaderName, 					RI_PartyName1,	 								RI_MediaRights_PARTY_Key);
		
		// deciding to select asset in Property field OR Element field
		try {			
				if(StartDate_EndDate_DealType[2].toString().length() >0) {
					System.out.println(StartDate_EndDate_DealType[2].toString().length() + "\n" + StartDate_EndDate_DealType[2].toString());
					if(StartDate_EndDate_DealType[2].toString().contains("Element")) {
						enterDataInFieldEditMode(rowNumber, RI_Property_ElementAsset_HeaderName, 	AssetName,	 	RI_Property_ElementAsset_Key);
					}
				}			
		} catch (Exception e) {
			// TODO: handle exception
		}

		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName, 			RI_MediaRights_EndUsersRights_DropDownValue,	 	RI_MediaRights_ENDUSER_RIGHTS_TEMPLATE_Key);

		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName,	RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		if(!ClientData.contains("VMN")){
			scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
					RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		}

		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		enterDataInFieldEditMode(rowNumber, RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);



		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermFromTestData, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_MediaRights_TermFromTestData, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_MediaRights_TermToTestData, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);

		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_MediaRights_TermToTestData, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);


	}
	
	/**
	 * @author Rajuddin
	 * 
	 * @param rowNumber     : The Media Rights Row Number e.g.:"1,2,3,.."
	 * @param HeaderName    : If it is "N/A" then this method will not enter the value in the field
	 * @param DropDownValue : This value will be selected in the drop down
	 * @param HeaderKey     : The value of Key attribute to locate the respective field
	 * throws Exception
	 * <br></br>
	 * {@link Description}
	 * <b><span style="color:blue";>Click on the respective field >> Drop down Icon>> Select Value >> >> Verify that Value is selected in drop down"</span></b>
	 *  
	 */
	public void enterDataInFieldEditMode(String rowNumber, String HeaderName, String DropDownValue, String HeaderKey) throws Exception {
		if(!HeaderName.contains("N/A")) {
			ExecutionLog.Log("----------Enter the data in \"" + HeaderName +"\" Field of Media Rights ");
			switchIntoFrame(frameParent3Xpath, HeaderName);
			sleepTime(2);
			doubleClick(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), "RI_MediaRights_EditMode_"+HeaderName.replace("*", ""),	HeaderName);
			sleepTime(2);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, HeaderName + "Drop Down Image",	HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", DropDownValue), DropDownValue ,	HeaderName);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath, HeaderName);
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",HeaderName);

			//Enter();
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), 	DropDownValue, "RI_MediaRights_EditMode_" + HeaderName,		HeaderName, 	"innerHTML");

		}

	}
	
	public void enterDataInFieldEditMode_FromPickList(String rowNumber, String HeaderName, String PickListValue, String HeaderKey, String PickList_PopUpKey) throws Exception {
		switchIntoFrame(frameParent3Xpath, HeaderName);
	
		clickOn(getLocator_EditTAB_DataRow(rowNumber, PickList_PopUpKey, HeaderName)+"/img", "RI_MediaRights_EditMode_MEDIA_TEMPLATE List",HeaderName);
		switchIntoFrame(frameParent4Xpath, HeaderName);
		
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
		
		
		clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", PickListValue),"PickListValue " + PickListValue);
		sleepTime(3);
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", PickListValue), "Checked" + PickListValue);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath, HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), PickListValue, HeaderName + "Data", HeaderName);

	}
	
	/**
	 * Starts from 1st Row
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_MediaRights_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_MediaRights_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_MediaRights_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	
	/**
	 * Applies TO's Assets row: Starts from 0th Row
	 * rowNumber_Asset > =0
	 * 
	 * The Data of the respective Asset starts from 2nd Row	
	 * rowNumber_Data > =2
	 *  
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_ViewTAB_DataRow(String rowNumber_Asset, String rowNumber_Data, String KeyValueFromExcel, String HeadeNameFromExcel){
		String classValue = getClassValue(loc_RI_MediaRights_ColumnXpath_ViewMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_MediaRights_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_MediaRights_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	
	public void templateFunctionality(String HeaderName, String TestStep, String PickList_PopUpKey, String searchText, String DropDownValue, String HeaderKey) throws Exception {
		if(!HeaderName.contains("N/A")) {

			//TC_RI_MR_42
			ExecutionLog.Log("");
			ExecutionLog.Log("***************" + HeaderName + " Template*****");
			ExecutionLog.Log("From Manual Test Step : " + TestStep);
			switchIntoFrame(frameParent3Xpath, HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", HeaderKey, HeaderName), "RI_MediaRights_EditMode_"+HeaderName.replace("*", ""),	HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, HeaderName + "Drop Down Image",	HeaderName);

			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", DropDownValue), DropDownValue ,	HeaderName);
			clickOn(getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",HeaderName);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", HeaderKey, HeaderName), 	DropDownValue, "RI_MediaRights_EditMode_" + HeaderName,		HeaderName, 	"innerHTML");


			ExecutionLog.Log("");
			ExecutionLog.Log("**********Verify all Buttons availables on the Template**********");
			switchIntoFrame(frameParent3Xpath, HeaderName);
			ExecutionLog.Log("Verify Buttons available at the Media Template Window");

			clickOn(getLocator_EditTAB_DataRow("1", PickList_PopUpKey, HeaderName)+"/img", "RI_MediaRights_EditMode_MEDIA_TEMPLATE List",HeaderName);
			switchIntoFrame(frameParent4Xpath, HeaderName);

			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 		RI_MediaRights_EditMode_ExpandAll_Button, 	"RI_MediaRights_EditMode_ExpandAll_Button",		RI_MediaRights_EditMode_ExpandAll_Button, 	"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 	RI_MediaRights_EditMode_CollapseAll_Button, "RI_MediaRights_EditMode_CollapseAll_Button",	RI_MediaRights_EditMode_CollapseAll_Button, "value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 		RI_MediaRights_EditMode_SelectAll_Button, 	"RI_MediaRights_EditMode_SelectAll_Button",		RI_MediaRights_EditMode_SelectAll_Button, 	"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, 	RI_MediaRights_EditMode_DeSelectAll_Button, "RI_MediaRights_EditMode_DeSelectAll_Button",	RI_MediaRights_EditMode_DeSelectAll_Button, "value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 			RI_MediaRights_EditMode_Apply_Button, 		"RI_MediaRights_EditMode_Apply_Button",			RI_MediaRights_EditMode_Apply_Button, 		"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Cancel, 		RI_MediaRights_EditMode_Cancel_Button, 		"RI_MediaRights_EditMode_Cancel_Button",		RI_MediaRights_EditMode_Cancel_Button, 		"value");
			verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search, RI_MediaRights_EditMode_Search_Button, 		"RI_MediaRights_EditMode_Search_Button", 		RI_MediaRights_EditMode_Search_Button);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, "Collapsed Icons", RI_MediaRights_EditMode_Search_Button);
			verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, "Expand Icon");

			sendKeys(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search_InputField, searchText, "RI_MediaRights_"+ HeaderName + "_Search", RI_MediaRights_EditMode_Search_Button);
			verifyElementPresent(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Searched_Result.replace("@var", searchText), "Searched Data '" + searchText + "'", RI_MediaRights_EditMode_Search_Button);

			ExecutionLog.Log("");
			ExecutionLog.Log("**********Verify Expand/Collapse functionality**********");
			ExecutionLog.Log("*****  Click On Collapse All and verify that collapse(minus) icons are not shown *****"); 
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 			"'Collapse' RI_MediaRights_EditMode_"+ HeaderName + " List",RI_MediaRights_EditMode_CollapseAll_Button);
			verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, 	"Collapsed Icons");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, 		"Expand Icons", 	RI_MediaRights_EditMode_CollapseAll_Button);

			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 				"'Expand' RI_MediaRights_EditMode at "+ HeaderName + " Edit Window",	RI_MediaRights_EditMode_ExpandAll_Button);
			verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, 	"Expand Icons  at "+ HeaderName + " Edit Window");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, 	"Collapse Icons at "+ HeaderName + " Edit Window", 	RI_MediaRights_EditMode_ExpandAll_Button);

			ExecutionLog.Log("");
			ExecutionLog.Log("**********Verify Select/DeSelecting functionality**********");
			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets at "+ HeaderName + " ");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), 	"Checked Nodes of Assets at "+ HeaderName + "");


			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets at "+ HeaderName + "");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), 	"Unchecked Nodes of Assets at "+ HeaderName + "");

			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, "Appply button");
			ExecutionLog.Log("**********Validation message on clikcing apply button without select any check box**********");
			WaitForModalPanel();
			verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_EditMode_MediaType_SelectAtLeastOneElement, "Alert Message RI_MediaRights_EditMode_"+ HeaderName + "", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			switchIntoFrame(frameParent4Xpath, 	RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);

			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 	"'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
			switchIntoFrame(frameParent3Xpath, HeaderName);

		}

	}

	// For Test Case2
	public void clickDataRowViewMode_VerifyHeaderName_CloseWindow(String key, String WindowHeaderName, String testData, String runStatusFromxcel) throws Exception{
		if(!runStatusFromxcel.contains("N/A")) {
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			doubleClick(getLocator_ViewTAB_DataRow("0", "2",key, runStatusFromxcel), WindowHeaderName, runStatusFromxcel); // Please read the desc of method getLocator_ViewTAB_DataRow
			WaitForModalPanel();
			
			
			// verify the test data
			verifyTextMatches(loc_RI_MediaRights_HeaderAtViewMode, "Header Name", WindowHeaderName);
			switchIntoFrame(frameParent3Xpath);
			verifyElementPresent(loc_RI_MediaRights_CheckedDataViewMode.replace("@var", testData), runStatusFromxcel);
			switchIntoFrame(frameParent3Xpath);
			doubleClick(Loc_Cancel + " | " + loc_RI_closeButton,"Ok button at" + WindowHeaderName + "Window");
			ExecutionLog.Log("");
		}
		
	}
	
	public void verifyAllAvailableFields_EditMode(String rowNumber, String AssetName) throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("Started Verifying the data for row:" + rowNumber);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				AssetName,	 	RI_MediaRights_APPLIESTO_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_PARTY_HeaderName, 					RI_PartyName1,	 								RI_MediaRights_PARTY_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName, 			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName,	RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		verifyFieldValue_EditMode(rowNumber, RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName, 		RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);
	}
	
	public void verifyFieldValue_EditMode(String rowNumber, String HeaderName, String DropDownValue, String HeaderKey) throws Exception {
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), 	DropDownValue, "RI_MediaRights_EditMode_" + HeaderName,		HeaderName, 	"innerHTML");

	}
	
	/**
	 *  Row rowNumber_Data > =2
	 * @param rowNumber
	 * @throws Exception
	 */
	public void verifyAllAvailableFields_ViewMode(String rowNumber) throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("Started Verifying the data for row:" + rowNumber);
		//verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_APPLIESTO_HeaderName, 				RI_MediaRights_EditMode_AppliesToDropDown_ValueAll,	 	RI_MediaRights_APPLIESTO_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_PARTY_HeaderName, 						RI_PartyName1,	 								RI_MediaRights_PARTY_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_MEDIA_TEMPLATE_HeaderName, 			RI_MediaRights_MediaType_DropDownValues,	 	RI_MediaRights_MEDIA_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_VENUE_TEMPLATE_HeaderName, 			RI_MediaRights_Venue_DropDownValues,			RI_MediaRights_VENUE_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_PKGING_RIGHTS_TEMPLATE_HeaderName,		RI_MediaRights_Platform_DropDownValues,			RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_TOUCHPOINT_TEMPLATE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues,		RI_MediaRights_TOUCHPOINT_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_BUSINESS_OUTLET_TEMPLATE_HeaderName, 	RI_MediaRights_BusinessOutLet_DropDownValues, 	RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_TERRITORY_TEMPLATE_HeaderName, 	 	RI_MediaRights_Territory_DropDownValues, 		RI_MediaRights_TERRITORY_TEMPLATE_Key);
		verifyFieldValue_ViewMode(rowNumber, RI_MediaRights_ViewMode_LANGUAGE_TEMPLATE_HeaderName, 			RI_MediaRights_Language_DropDownValues, 		RI_MediaRights_LANGUAGE_TEMLATE_Key);
	}
	
	public void verifyFieldValue_ViewMode(String rowNumber, String HeaderName, String DropDownValue, String HeaderKey) throws Exception {
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("0", rowNumber, HeaderKey, HeaderName), 	DropDownValue, "RI_MediaRights_EditMode_" + HeaderName,		HeaderName, 	"title");

	}

	/**
	 * @description : Open Pop-up >> DeSelect All >> Enter Value in Search Field >> Select Searched Value >> Check the Check Box
	 * @param rowNumber
	 * @param HeaderName
	 * @param PickListValue
	 * @param HeaderKey
	 * @param PickList_PopUpKey
	 * @throws Exception
	 */
	public void enterDataInFieldEditMode_FromPickList_SearchField(String rowNumber, String HeaderName, String PickListValue, String HeaderKey, String PickList_PopUpKey) throws Exception {
		System.out.println(getLocator_EditTAB_DataRow(rowNumber, PickList_PopUpKey, HeaderName)+"/img");
		switchIntoFrame(frameParent3Xpath, HeaderName);
		doubleClick(getLocator_EditTAB_DataRow(rowNumber, PickList_PopUpKey, HeaderName)+"/img", "RI_MediaRights_EditMode_" + HeaderName,HeaderName);
		switchIntoFrame(frameParent4Xpath, HeaderName);
		sleepTime(5);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName);
		sendKeys(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search_InputField, PickListValue, "RI_MediaRights_"+ HeaderName + "_Search", RI_MediaRights_EditMode_Search_Button);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Searched_Result.replace("@var", PickListValue), 	"Searched Data '" 	+ PickListValue + "'");
		clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", PickListValue),	"PickListValue " 	+ PickListValue);
		sleepTime(3);
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", PickListValue), "Checked" + PickListValue);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath, HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), PickListValue, HeaderName + "Data", HeaderName);

	}
	
	/**
	 * This method is specific to Media Rights TAB
	 * @param locator
	 */
	public void verticallyScroll_EditMode(String locator) {

		WebElement Image = driver.findElement(ByLocator(locator));
		//Used points class to get x and y coordinates of element.
		Point point = Image.getLocation();
		int ycord = point.getY();
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(driver.findElement(By.xpath("//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[contains(@style,'vertical-align')]/div")), 0, ycord).build().perform();
		System.out.println("Scrolled Vertically");
		
	}

	}

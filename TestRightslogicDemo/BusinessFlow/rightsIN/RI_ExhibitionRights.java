package rightsIN;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_ExhibitionRights extends DriverHelper {
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	RI_MediaRights mediaRights = new RI_MediaRights();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date); 
//	String formattedDate = "0201201724550";
	
	
	String CreatedSeriesAssetTitleTC1 	= "AUT_AssetSeries_TC1_" +formattedDate+"";
	String CreatedSeriesAssetTitleTC6 	= "AUT_AssetSeries_TC6_" +formattedDate+"";
	String TheatreAssetTitleTC6_1 	= "AUT_AssetTheatre_TC61_" +formattedDate+"";
	String TheatreAssetTitleTC6_2 	= "AUT_AssetTheatre_TC62_" +formattedDate+"";
	String CreatedDealTC1 			= 	"AUT_Deal_TC1_" +formattedDate+"";
	String CreatedDealTC6 			= 	"AUT_Deal_TC6_" +formattedDate+"";
	String CreatedDealTC7 			= 	"AUT_Deal_TC7_" +formattedDate+"";
	String CreatedDealTC7_1 		= 	"AUT_Deal_TC7_1_" +formattedDate+"";
	String CreatedDealTC12 			= 	"AUT_Deal_TC12_1_" +formattedDate+"";

	String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";


	public RI_ExhibitionRights() {
		className = this.getClass().getName(); 
	}

	@Test
	public void createData() throws Exception{

		//TC1-TC5
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC1);
		rightsIN.createDeal(CreatedDealTC1);
		rightsIN.searchCreatedDeal(CreatedDealTC1);
		rightsIN.associateAssetWithDeal(CreatedDealTC1,CreatedSeriesAssetTitleTC1);

		//TC6 
		//Note: Asset created for TC1 is also used in TC6
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC6,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC6);
		if(!ClientData.contains("VMN")) {
			assetMaintenance.createTheatricalAsset(TheatreAssetTitleTC6_1, AssetType_Theatrical_FeatureLength, AssetType_Theatrical);
			assetMaintenance.createTheatricalAsset(TheatreAssetTitleTC6_2, AssetType_Theatrical_FeatureLength, AssetType_Theatrical);

		}

		rightsIN.createDeal(CreatedDealTC6);
		rightsIN.searchCreatedDeal(CreatedDealTC6);
		rightsIN.associateAssetWithDeal(CreatedDealTC6,CreatedSeriesAssetTitleTC1);
		rightsIN.associateAssetWithDeal(CreatedDealTC6,CreatedSeriesAssetTitleTC6);
		if(!ClientData.contains("VMN")) {
			rightsIN.associateAssetWithDeal(CreatedDealTC6,TheatreAssetTitleTC6_1, AssetType_Theatrical);
			rightsIN.associateAssetWithDeal(CreatedDealTC6,TheatreAssetTitleTC6_2, AssetType_Theatrical);
		}
		//TC7
		rightsIN.createDeal(CreatedDealTC7);
		rightsIN.associateAssetWithDeal(CreatedDealTC7,CreatedSeriesAssetTitleTC1);

		//TC7_ExhibRights_Filter
		rightsIN.createDeal(CreatedDealTC7_1);
		rightsIN.associateAssetWithDeal(CreatedDealTC7_1,CreatedSeriesAssetTitleTC1);

		//TC7_ExhibRights_Filter
		rightsIN.createDeal(CreatedDealTC12);
		rightsIN.associateAssetWithDeal(CreatedDealTC12,CreatedSeriesAssetTitleTC1);

	}

	/**
	 * Covered Test Step : 7
	 * @throws Exception
	 */
	// Create Four Rows in Media rights TAB
	@Test(priority =1, enabled = true , description = "Exhibition Rights flow")
	public void TC1_MediaRightsRow() throws Exception {
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row1
		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row2
		mediaRights.enterDatainAllFields("2", CreatedSeriesAssetTitleTC1);


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row3
		mediaRights.enterDatainAllFields("3", RI_MediaRights_Season1);


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row4
		mediaRights.enterDatainAllFields("4", RI_MediaRights_Episode101);


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		// Verifying the entered data
		mediaRights.verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		mediaRights.verifyAllAvailableFields_EditMode("2",CreatedSeriesAssetTitleTC1);
		mediaRights.verifyAllAvailableFields_EditMode("3",RI_MediaRights_Season1);
		mediaRights.verifyAllAvailableFields_EditMode("4",RI_MediaRights_Episode101);
		scriptStatus();
	}

	/**
	 * Covered Test Step : 2
	 * @throws Exception
	 */
	// Verify Parent Headers, Headers of Allocated Row, all the buttons available in View/Edit Mode
	@Test(priority =2, enabled = true , description = "Exhib. Rights Tab - UI Verification")
	public void TC2_Exhibition_UI_Verification() throws Exception {
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		verifyParentHeaders();

		verifyAllButtons_ViewMode();

		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		switchIntoFrame(frameParent3Xpath);

		verifyParentHeaders();

		ExecutionLog.Log("**********checking Mandatory field in Edit Mode**********");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_EXHIBITIONDATEUPDATE_Key+"']", 			RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header, 	"EXHIBIT DATE UPDATE Header",		RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_EXHIBITIONDAYSCOPE_Key+"']", 			RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header	, 		"RI_Exh_ViewMode_EXHIBITIONDAYSCOPE_Header",		RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header,	"innerHTML");

		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

		// Add Media Rights TAB in Exhibition TAB
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);		

		verifyChildHeaders_EditMode();

		ExecutionLog.Log("");
		ExecutionLog.Log("*****Verify all the buttons in Edit Mode of Exhibition TAB *****"); 
		verifyFieldValueOfHeader(loc_RI_Exh_EditMode_CopyColumns_Button,	RI_Exh_EditMode_CopyColumns_Button, 	"RI_Exh_EditMode_CopyRows_Buttons", 	RI_Exh_EditMode_CopyColumns_Button, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_CopyRows_Buttons,RI_Exh_EditMode_CopyRows_Buttons, 	"RI_Exh_EditMode_CopyRows_Buttons", 	RI_Exh_EditMode_CopyRows_Buttons, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_AddButton,		RI_Exh_EditMode_AddButton, 			 	"RI_Exh_EditMode_AddButton", 			RI_Exh_EditMode_AddButton, 				"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_DeleteButton,	RI_Exh_EditMode_DeleteButton, 			"RI_Exh_EditMode_DeleteButton", 		RI_Exh_EditMode_DeleteButton, 			"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_SaveButton,	RI_Exh_EditMode_SaveButton, 			"RI_Exh_EditMode_SaveButton", 			RI_Exh_EditMode_SaveButton, 			"value");
		verifyFieldValueOfHeader(loc_RI_closeButton,	RI_Exh_EditMode_closeButton, 			"RI_Exh_EditMode_closeButton", 			RI_Exh_EditMode_closeButton, 			"value");
		verifyFieldValueOfHeader(loc_RI_Exh_ViewMode_ExpandButton,			RI_Exh_EditMode_ExpandButton, 			"RI_Exh_EditMode_ExpandButton", 		RI_Exh_EditMode_DeleteButton, 			"value");
		verifyFieldValueOfHeader(loc_RI_Exh_ViewMode_CollapseButton,		RI_Exh_EditMode_CollapseButton, 		"RI_Exh_EditMode_CollapseButton", 		RI_Exh_EditMode_SaveButton, 			"value");
		verifyFieldValueOfHeader(loc_RI_Exh_AllocateButton,		RI_Exh_EditMode_AllocateButton, 		"RI_Exh_EditMode_AllocateButton", 		RI_Exh_EditMode_closeButton, 			"value");

		scriptStatus();
	}

	/**
	 * Covered Test Step : 9
	 * @throws Exception
	 */
	@Test(priority =3, enabled = true , description = "Exhib. Rights Validations when User click on 'Allocate'/'Copy'/'Delete' buttons with no row in Exhib. Rights tab")
	public void TC3_ValidationsMsgs_Allocate_Copy_Delete() throws Exception {
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");


		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC5 AND TC_RI_EX_130");
		ExecutionLog.Log("Do not select row >> Click Allocate >> Verify Validation Message");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AllocateButton);
		clickOn(loc_RI_Exh_AllocateButton, "Allocate Button", RI_Exh_EditMode_AllocateButton);
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_Exh_Allocate_ValidationMsg, "Alert Message on clicking Allocate Button", RI_Exh_EditMode_AllocateButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_Allocate_ValidationMsg);


		ExecutionLog.Log("");
		ExecutionLog.Log("Do not select row >> Click Copy >> Verify Validation Message");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_CopyRows_Buttons);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Button", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_Exh_Copy_ValidationMsg, "Alert Message on clicking copy Button", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_CopyRows_Buttons);


		ExecutionLog.Log("");
		ExecutionLog.Log("Do not select row >> Click Delete >> Verify Validation Message");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_DeleteButton);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_Exh_Delete_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_DeleteButton);

		ExecutionLog.Log("");
		ExecutionLog.Log("Add Button >> double click on Territory field >> Verify that Territory Template window is opened");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName),"TERRITORY Field of Media Right Window under Exhibition TAB");
		switchIntoFrame(frameParent5Xpath, RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName);
		ExecutionLog.Log("As Template window is opening on double click on Territory field hence Territory field is \"No-editable\"");


		driver.switchTo().window(driver.getWindowHandle()); 
		List<WebElement> elms = driver.findElements(ByLocator("//*[contains(@src,'Close.gif')]"));
		System.out.println(elms.size());
		for(int i = 1; i <=elms.size(); i++) {
			if(elms.get(elms.size()-i).isDisplayed()) {
				clickOn(elms.get(elms.size()-i), "Close");
				break;
			}
		}

		ExecutionLog.Log("Select Two rows of different Assets in Media Rights's opened window  >> Verify Alert Message");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		//Test Cases 4: User should not be able to select multiple media rights row where the “Applies To” of the selected media rights row does not match
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		Alert alert = driver.switchTo().alert();
		ValidationMessageInPage(alert.getText(), RI_Exh_AlertMsg_SameMediaRowSelect, "Alert Message Same Media Row Select");

		scriptStatus();
	}

	/**
	 * Total Steps 	: 109
	 * Can not Automate : 3
	 * Obsolute 	: 3
	 * In Progress 	: 1
	 * @throws Exception
	 */
	@Test(priority =4, enabled = true , description = "User should be able to select a media rights row while defining exhib. Rights")
	public void TC5_SelectMediaRow_WhileDefiningExhRights() throws Exception {
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		
		//TC_13
		ExecutionLog.Log("");
		ExecutionLog.Log("Add Button >> Select Media Rights's rows ");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		sleepTime(3);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyParentHeaders();
		verifyChildHeaders_EditMode();
		switchIntoFrame(frameParent3Xpath);

		// Verify Default values for the parent row
		//TC_14
		ExecutionLog.Log("Verify the default data of Parent Row");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, 	"Applies to",		RI_Exh_EditMode_ExhibitAPPLIESTO_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDATEUPDATE_Key, RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header), 	RI_Exh_Update_DefaultValue, 	"EXHIBITIONDATEUPDATE",		RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, RI_Exh_EditMode_STARTDATE_Header), 	RI_MediaRights_TermFromTestData, 	"STARTDATE",			RI_Exh_EditMode_STARTDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, RI_Exh_EditMode_ENDDATE_Header), 		RI_MediaRights_TermToTestData, 		"ENDDATE",				RI_Exh_EditMode_ENDDATE_Header, 	"innerHTML");

		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_UNLIMITED_Key, RI_Exh_EditMode_UNLIMITED_Header)+"/img", 	"Checked", 	"UNLIMITED Check box",				RI_Exh_EditMode_UNLIMITED_Header, 	"title");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"Checked", 	"POOLED Check box",		RI_Exh_EditMode_POOLED_Header, 	"title");

		// Verify Default values for the parent row
		//TC_14
		ExecutionLog.Log("Verify the default data of Child Row");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOW_TYPE_Key, RI_Exh_EditMode_Child_WINDOW_TYPE_Header), 			RI_Exh_WinType_DefaultValue, 		"Window Type",		RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, RI_Exh_EditMode_Child_STARTDATECHILD_Header), 	RI_MediaRights_TermFromTestData, 		"Start Date Child",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ENDDATECHILD_Key, RI_Exh_EditMode_Child_ENDDATECHILD_Header), 		RI_MediaRights_TermToTestData, 			"End Date Child",	RI_Exh_EditMode_Child_ENDDATECHILD_Header, 		 "innerHTML");
		//VMN does not has the default value expect Start/End date
		if(!ClientData.contains("VMN")) {
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), 	RI_Exh_Plays_DefaultValue, 	"PLAYS",			RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, "innerHTML");
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), 		RI_Exh_DayType_DefaultValue, "Day Type",		RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header,  "innerHTML");
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), 	RI_Exh_DayPeriod_DefaultValue, 	"Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header,"innerHTML");
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), 		RI_Exh_AddExhi_DefaultValue, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");
		}

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_Exh_EnterRequiredFields_ValidationMsg);

		//RI_Exh_EXHIBITIONDAYSCOPE_Key
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Series), RI_Exh_ExhiScope_Series, RI_Exh_ExhiScope_Series, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Season), RI_Exh_ExhiScope_Season, RI_Exh_ExhiScope_Season, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Episodes), RI_Exh_ExhiScope_Episodes, RI_Exh_ExhiScope_Episodes, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Asset), RI_Exh_ExhiScope_Asset, RI_Exh_ExhiScope_Asset, 	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, "innerHTML");

		String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Series), "'Series' in Exhi Scope field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Series, "ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");

		// Type Window Name
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), "Window Name Field");
		sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName, "Win Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");


		// Open Rights Type window and check Linear Check Box
		ExecutionLog.Log("Open Rights Type window and check Linear Check Box");
		doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key, RI_Exh_EditMode_Child_RIGHTSTYPE_Header)+"/img", "RIGHTSTYPE Look up icon",RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		"Check Box " + RI_ExhibitionRights_EditMode_Linear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_NonLinear), 		"Check Box " + RI_ExhibitionRights_EditMode_NonLinear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		sleepTime(5);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear),"Check box " + RI_ExhibitionRights_EditMode_Linear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		RI_ExhibitionRights_EditMode_Linear + " Check box is checked", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Apply Button at RIGHTSTYPE_POPUP", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RIGHTSTYPE_Key_EditMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");

		// Day Type
		ExecutionLog.Log("");
		ExecutionLog.Log("Day Type");
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), "Day Type Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Type Drop Down");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Consecutive), RI_Exh_DayType_Consecutive, RI_Exh_DayType_Consecutive, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Programming), RI_Exh_DayType_Programming, RI_Exh_DayType_Programming, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, "innerHTML");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Consecutive), RI_Exh_DayType_Consecutive +" in Exhi Days Type field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), RI_Exh_DayType_Consecutive, "Day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");


		// Day Period
		ExecutionLog.Log("");
		ExecutionLog.Log("Day Period");
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), "Day Period Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Period Drop Down");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value1), RI_Exh_DayPeriod_Value1, RI_Exh_DayPeriod_Value1, RI_Exh_DayPeriod_Value1, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value2), RI_Exh_DayPeriod_Value2, RI_Exh_DayPeriod_Value2, RI_Exh_DayPeriod_Value2, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value3), RI_Exh_DayPeriod_Value3, RI_Exh_DayPeriod_Value3, RI_Exh_DayPeriod_Value3, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value4), RI_Exh_DayPeriod_Value4, RI_Exh_DayPeriod_Value4, RI_Exh_DayPeriod_Value4, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value5), RI_Exh_DayPeriod_Value5, RI_Exh_DayPeriod_Value5, RI_Exh_DayPeriod_Value5, "innerHTML");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value1), RI_Exh_DayPeriod_Value1 +" in Day Period field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value1, "Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");



		// Plays
		ExecutionLog.Log("");
		ExecutionLog.Log("Day Type");
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), "Plays Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Plays Drop Down");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value1), RI_Exh_Plays_Value1, RI_Exh_Plays_Value1, RI_Exh_Plays_Value1, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value2), RI_Exh_Plays_Value2, RI_Exh_Plays_Value2, RI_Exh_Plays_Value2, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value3), RI_Exh_Plays_Value3, RI_Exh_Plays_Value3, RI_Exh_Plays_Value3, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value4), RI_Exh_Plays_Value4, RI_Exh_Plays_Value4, RI_Exh_Plays_Value4, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value5), RI_Exh_Plays_Value5, RI_Exh_Plays_Value5, RI_Exh_Plays_Value5, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value6), RI_Exh_Plays_Value6, RI_Exh_Plays_Value6, RI_Exh_Plays_Value6, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value7), RI_Exh_Plays_Value7, RI_Exh_Plays_Value7, RI_Exh_Plays_Value7, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value8), RI_Exh_Plays_Value8, RI_Exh_Plays_Value8, RI_Exh_Plays_Value8, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value9), RI_Exh_Plays_Value9, RI_Exh_Plays_Value9, RI_Exh_Plays_Value9, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value10), RI_Exh_Plays_Value10, RI_Exh_Plays_Value10, RI_Exh_Plays_Value10, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value11), RI_Exh_Plays_Value11, RI_Exh_Plays_Value11, RI_Exh_Plays_Value11, "innerHTML");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value1), RI_Exh_Plays_Value1 +" in Plays field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");

		sleepTime(3);

		// Evaluation
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_RI_EX_081");
		ExecutionLog.Log("Evaluation");
		scrollElementIntoView(getLocator_Child_DataRow("3"	, RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), "Evaution Field Row", loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(getLocator_Child_DataRow("3"	, RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), "Evaluation Field", RI_Exh_EditMode_Child_RID_RATING_Header);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Evaluation Drop Down", RI_Exh_EditMode_Child_RID_RATING_Header);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", "A+"), "\"A+\" in Evaluation field", RI_Exh_EditMode_Child_RID_RATING_Header);
		//clickOn(supportClickLoctor,"Support Click", RI_Exh_EditMode_Child_RID_RATING_Header);
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.TAB);
        keyboard.releaseKey(Keys.TAB);
        sleepTime(2);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), "A+", "\"A+\" in Evaluation field",	RI_Exh_EditMode_Child_RID_RATING_Header, 	 "innerHTML");


		// Add Exhibition
		ExecutionLog.Log("");
		ExecutionLog.Log("Add Exhibition");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		scrollElementIntoView(getLocator_Child_DataRow("3", RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), RI_Exh_EditMode_Child_RID_RATING_Header, loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), "Add Exhibition");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Add Exhibition Drop Down");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1, RI_Exh_AddExh_Value1, RI_Exh_AddExh_Value1, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value2), RI_Exh_AddExh_Value2, RI_Exh_AddExh_Value2, RI_Exh_AddExh_Value2, "innerHTML");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1 +" in Add Exhibition field");
		scrollElementIntoView(supportClickLoctor, "Media Parent Row", loc_RI_ExhibitionRights_HorizontalScroll);

		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value1, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		// Exhibition Network
		//TC_RI_EX_040
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_EX_040");
		ExecutionLog.Log("Exhibition Rights Network Dialog Window");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		ExecutionLog.Log("********Verify Labels at Exhibition Network window********");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_AppliesTO, RI_Exh_NetworkWindow_AppliesTO_Label, RI_Exh_NetworkWindow_AppliesTO_Label, RI_Exh_NetworkWindow_AppliesTO_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_MediaType_Label, 		RI_Exh_NetworkWindow_MediaType_Label, 	RI_Exh_NetworkWindow_MediaType_Label, 	RI_Exh_NetworkWindow_MediaType_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_NetworkType_Label, 	RI_Exh_NetworkWindow_NetworkType_Label, RI_Exh_NetworkWindow_NetworkType_Label, RI_Exh_NetworkWindow_NetworkType_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefined_Label, 	RI_Exh_NetworkWindow_UserDefined_Label, RI_Exh_NetworkWindow_UserDefined_Label, RI_Exh_NetworkWindow_UserDefined_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefinedNetwork_Label, RI_Exh_NetworkWindow_UserDefinedNetwork_Label, RI_Exh_NetworkWindow_UserDefinedNetwork_Label, RI_Exh_NetworkWindow_UserDefinedNetwork_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_ExhibNetwork_Label, 	RI_Exh_NetworkWindow_ExhibNetwork_Label, RI_Exh_NetworkWindow_ExhibNetwork_Label, RI_Exh_NetworkWindow_ExhibNetwork_Label, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_OutLetNumber_Label, 	RI_Exh_NetworkWindow_OutLetNumber_Label, RI_Exh_NetworkWindow_OutLetNumber_Label, RI_Exh_NetworkWindow_OutLetNumber_Label, "innerHTML");

		ExecutionLog.Log("********Verify Buttons at Exhibition Network window********");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_DeSelectAll_Button, RI_Exh_NetworkWindow_DeselectAllButton, RI_Exh_NetworkWindow_DeselectAllButton, RI_Exh_NetworkWindow_DeselectAllButton, "value");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_SelectAll_Button, RI_Exh_NetworkWindow_SelectAllButton, RI_Exh_NetworkWindow_SelectAllButton, RI_Exh_NetworkWindow_SelectAllButton, "value");
		verifyFieldValueOfHeader(OKButton, RI_Exh_NetworkWindow_OKButton, RI_Exh_NetworkWindow_OKButton, RI_Exh_NetworkWindow_OKButton, "value");
		verifyFieldValueOfHeader("name="+loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Cancel, RI_Exh_NetworkWindow_CancelButton, RI_Exh_NetworkWindow_CancelButton, RI_Exh_NetworkWindow_CancelButton, "value");


		ExecutionLog.Log("");
		ExecutionLog.Log("Appliest TO : All >> Verify Linear is default value in Media Type >> verify UserDefinedNetwork_input in disabled");
		ExecutionLog.Log(" >> UserDefined_Input field is disable");
		ExecutionLog.Log(" >> OK >> Validation msg >> Select Primaty in Network Type >> Verify Primary is shown Network Type");
		ExecutionLog.Log(" >> Check UserDefined_CheckBox >> Verify UserDefined_CheckBox is checked");
		ExecutionLog.Log(" >> UserDefined_Input field is enabled >> AND Exh Network becomes Disabled");

		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);

		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_AppliesTO, "All", RI_Exh_NetworkWindow_AppliesTO_Label, RI_Exh_NetworkWindow_AppliesTO_Label, "innerHTML");
		verifyFirstSelectedDropdownValue(loc_RI_Exh_NetworkWindow_MediaType_DropDown, "Media Type", RI_Exh_NetworkWindow_MediaType_DropDownValue2, RI_Exh_NetworkWindow_MediaType_Label);
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefinedNetwork_input, "true", RI_Exh_NetworkWindow_UserDefinedNetwork_Label+" is disabled", RI_Exh_NetworkWindow_UserDefinedNetwork_Label, "disabled");
		//VMN: could not click on OK button		
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		doubleClick(OKButton,"Ok button");
		WaitForModalPanel();
		ExecutionLog.Log("");
		if(ClientData.contains("VMN")) {
			ExecutionLog.Log(color("red","===VMN: BUG ID 21602==="));	
		}
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_ExhNet_EnterOutlet_ValidationMsg, "Alert Message on clicking Ok Button", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		selectDropdownValue(loc_RI_Exh_NetworkWindow_NetworkType_DropDown, "NetworkType_DropDown", RI_Exh_NetworkWindow_NetworkType_DropDownValue1, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(5);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		verifySeletedOptions(loc_RI_Exh_NetworkWindow_NetworkType_DropDown, RI_Exh_NetworkWindow_NetworkType_DropDownValue1,  "NetworkType_DropDown");

		moveMouse(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox,"UserDefined_CheckBox");
		clickOn(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox,"UserDefined_CheckBox", RI_Exh_NetworkWindow_UserDefined_CheckBox);
		sleepTime(2);
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox, "true", "UserDefined_CheckBox is checked", RI_Exh_NetworkWindow_UserDefined_CheckBox, "checked");

		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_DeSelectAll_Button, "true", RI_Exh_NetworkWindow_DeselectAllButton, RI_Exh_NetworkWindow_DeselectAllButton, "disabled");
		// need to verify
		//verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefinedNetwork_input, "enabled", RI_Exh_NetworkWindow_UserDefinedNetwork_Label, RI_Exh_NetworkWindow_UserDefinedNetwork_Label, "disabled");
		clickOn(OKButton,"Ok button");
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_Exh_EnterUserDefined_ValidationMsg, "Alert Message on clicking Ok Button", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sendKeys(loc_RI_Exh_NetworkWindow_UserDefinedNetwork_input, RI_Exh_NetWorkWindow_TestData, "NetworkWindow_UserDefinedNetwork", RI_Exh_NetworkWindow_UserDefinedNetwork_Label);
		clickOn(OKButton,"Ok button");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_NetWorkWindow_TestData, "Exhibition Network",	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		// Verify N/w pop up opens with previously saved data
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox, "true", "UserDefined_CheckBox", RI_Exh_NetworkWindow_UserDefined_CheckBox, "checked");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_DeSelectAll_Button, "true", RI_Exh_NetworkWindow_DeselectAllButton, RI_Exh_NetworkWindow_DeselectAllButton, "disabled");
		verifyFirstSelectedDropdownValue(loc_RI_Exh_NetworkWindow_MediaType_DropDown, "Media Type", RI_Exh_NetworkWindow_MediaType_DropDownValue2, RI_Exh_NetworkWindow_MediaType_Label);
		verifySeletedOptions(loc_RI_Exh_NetworkWindow_NetworkType_DropDown, RI_Exh_NetworkWindow_NetworkType_DropDownValue1,  "NetworkType_DropDown");
		sendKeys(loc_RI_Exh_NetworkWindow_OutLetNumber_input, "10", "NetworkWindow_OutLetNumber", RI_Exh_NetworkWindow_OutLetNumber_Label);
		clickOn(OKButton,"Ok button");
		WaitForModalPanel();
		ExecutionLog.Log("");
		if(ClientData.contains("VMN")) {
			ExecutionLog.Log("===BUG ID 21602===");	
		}
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_ExhNet_EnterOutlet_ValidationMsg, "Alert Message on clicking Ok Button", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickOn(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox,"UserDefined_CheckBox");
		//verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox, "false", "UserDefined_CheckBox", RI_Exh_NetworkWindow_UserDefined_CheckBox, "checked");
		verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefinedNetwork_input, "true", RI_Exh_NetworkWindow_UserDefinedNetwork_Label+" is disabled", RI_Exh_NetworkWindow_UserDefinedNetwork_Label, "disabled");
		clickOn(OKButton,"Ok button");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), " Outlets: 10", "Exhibition Network",	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		// Verify N/w pop up opens with previously saved data
		//verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_UserDefined_CheckBox, "true", "UserDefined_CheckBox", RI_Exh_NetworkWindow_UserDefined_CheckBox, "checked");
		//verifyFieldValueOfHeader(loc_RI_Exh_NetworkWindow_DeSelectAll_Button, "true", RI_Exh_NetworkWindow_DeselectAllButton, RI_Exh_NetworkWindow_DeselectAllButton, "disabled");
		verifyFirstSelectedDropdownValue(loc_RI_Exh_NetworkWindow_MediaType_DropDown, "Media Type", RI_Exh_NetworkWindow_MediaType_DropDownValue2, RI_Exh_NetworkWindow_MediaType_Label);
		verifySeletedOptions(loc_RI_Exh_NetworkWindow_NetworkType_DropDown, RI_Exh_NetworkWindow_NetworkType_DropDownValue1,  "NetworkType_DropDown");
		clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel1),"Selected Channel " + RI_Exh_ExhNetworkChannel1);
		clickOn(OKButton,"Ok button");
		WaitForModalPanel();
		ExecutionLog.Log("");
		if(ClientData.contains("VMN")) {
			ExecutionLog.Log("===BUG ID 21602===");	
		}
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_ExhNet_EnterOutlet_ValidationMsg, "Alert Message on clicking Ok Button", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sendKeys(loc_RI_Exh_NetworkWindow_OutLetNumber_input, "", "NetworkWindow_OutLetNumber", RI_Exh_NetworkWindow_OutLetNumber_Label);
		clickOn(OKButton,"Ok button");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel1, "Exhibition Network",	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");
		doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(3);
		// Change the Media Type : From Non-Linear to Linear(Linear was selected by default) : Need to confirm
		clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel2),"Selected Channel " + RI_Exh_ExhNetworkChannel2);
		clickOn(OKButton,"Ok button");
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel1 , "Exhibition Network",	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel2, "Exhibition Network",	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");

		scrollElementIntoView(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", RI_Exh_EditMode_POOLED_Header, loc_RI_ExhibitionRights_HorizontalScroll);

		// Uncheck POOLED Check Box
		ExecutionLog.Log("POOLED Check Box >> Save >> Verify Validation Message" +  RI_Exh_ValidationMsg_ExhDayMustBePooled);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "Pooled Check Box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"Unchecked", 	"POOLED Check box",	RI_Exh_EditMode_POOLED_Header, 	"title");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_ExhDayMustBePooled), "Exh days must be pooled when unlimited is checked Validation message", RI_Exh_EnterRequiredFields_ValidationMsg);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");

		// Uncheck Unlimited Check Box
		ExecutionLog.Log("Unlimited Check Box >> Save >> Verify Validation Message" +  RI_Exh_ValidationMsg_ExhDayEqualToReservedDays);
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_UNLIMITED_Key, RI_Exh_EditMode_UNLIMITED_Header)+"/img" , "UNLIMITED Check Box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_UNLIMITED_Key, RI_Exh_EditMode_UNLIMITED_Header)+"/img", 	"Unchecked", 	"UNLIMITED Check box",	RI_Exh_EditMode_UNLIMITED_Header, 	"title");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_ExhDayEqualToReservedDays), "Exh days must be equal to reserved days when unlimited is checked Validation message", RI_Exh_EnterRequiredFields_ValidationMsg);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");


		//Enter data in exhibition_days field in parent row
		ExecutionLog.Log("Enter 12 in Exh days of Parent Row >> Save >> Verify Validation Message" +  RI_Exh_ValidationMsg_ExhDayEqualToReservedDays);
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), "EXHIBITION_DAYS Field");
		sendKeys(loc_RI_ExhRights_InputField, "12", "RI_Exh_EditMode_EXHIBITION_DAYS_Header", RI_Exh_EditMode_EXHIBITION_DAYS_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), 	"12", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_EXHIBITION_DAYS_Header, 	"innerHTML");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch), "RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch", RI_Exh_EnterRequiredFields_ValidationMsg);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");


		//TC_56
		//Enter data in exhibition_days field in Allocation row
		ExecutionLog.Log("Manual Test Step: TC_56");
		ExecutionLog.Log("Enter 12 in Exh days of Child Row");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key, RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header), "EXHIBITION_DAYS Field");
		sendKeys(loc_RI_ExhRights_InputField, "12", "RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header", RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key, RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header), 	"12", 	"EXHIBITION",	RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header, 	"innerHTML");

		ExecutionLog.Log("Manual Test Step :TC_57");
		ExecutionLog.Log("Enter data in Reserved exhibition_days >> Save >> Validation >> Enter Exhi days in allocation row ");
		//Enter data in Reserved exhibition_days field in parent row
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_RESERVED_EXHIBITION_DAYS_Key, RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header), "EXHIBITION_DAYS Field");
		sendKeys(loc_RI_ExhRights_InputField, "2", "RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header", RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_RESERVED_EXHIBITION_DAYS_Key, RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header), 	"2", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header, 	"innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch2), "RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch", RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch2);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");


		ExecutionLog.Log("Enter 12 in Exh days of Child Row");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key, RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header), "EXHIBITION_DAYS Field");
		sendKeys(loc_RI_ExhRights_InputField, "10", "RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header", RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key, RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header), 	"10", 	"EXHIBITION",	RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header, 	"innerHTML");


		doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_ExhibitTERRITORY_UD_POPUP_Key, RI_Exh_EditMode_Child_TERRITORY_Header)+"/img", "TERRITORY");
		functionalityOf_TerritoryWindow("TC_65", RI_Exh_EditMode_Child_TERRITORY_Header);


		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), "EXHIBITIONDAYPERIOD Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Period Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value3), RI_Exh_DayPeriod_Value3 + " in EXHIBITION DAY PERIOD field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value3, "EXHIBITION DAY PERIOD",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();

		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_ExhDayPeriodMustBeValid), "RI_Exh_ValidationMsg_ExhDayPeriodMustBeValid", RI_Exh_ValidationMsg_ExhDayPeriodMustBeValid);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");



		// Select Exhibition Day Period
		ExecutionLog.Log("Select "  + RI_Exh_DayPeriod_Value2 + " in Exhibition Day Period");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), "Exhibition Day Period Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Period Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value2), RI_Exh_DayPeriod_Value2 + " in Exhi day Period field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value2, "Exhi day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");

		// Select Exhibition Day Type
		ExecutionLog.Log("Select 'Programming' Exhibition Day Type >> Save >> Verify '" + RI_Exh_ValidationMsg_ExhPeriodMustBe_NA + "'");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), "Exhibition Day Type Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Period Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Programming), RI_Exh_DayType_Programming + " in Exhi day Type field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), RI_Exh_DayType_Programming, "Exhi day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();

		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_ExhPeriodMustBe_NA), "RI_Exh_ValidationMsg_AddExhiMustBeSameNetwork", RI_Exh_ValidationMsg_AddExhiMustBeSameNetwork);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");

		ExecutionLog.Log("");
		ExecutionLog.Log("Select '" + RI_Exh_AddExh_Value2 + "' Add Exhibition Day >> Save >> Verify '" + RI_Exh_ValidationMsg_AddExhiMustBeSameNetwork + "'");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), "Additional Exhibition Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Period Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value2), RI_Exh_AddExh_Value2 + " in Additional Exhibition field");//Across N/w
		scrollElementIntoView(supportClickLoctor, "Media Parent Row", loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value2, "Additional Exhibition Field",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_AddExhiMustBeSameNetwork), "RI_Exh_ValidationMsg_ExhPeriodMustBe_N/A", RI_Exh_ValidationMsg_ExhPeriodMustBe_NA);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");

		ExecutionLog.Log("");
		ExecutionLog.Log("Check Pool Check Box >> Select 'N/A' in EXHIBITION DAY PERIOD' >> Save >> Veify Successfully saved message");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "Pooled Check Box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"Checked", 	"POOLED Check box",	RI_Exh_EditMode_POOLED_Header, 	"title");
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), "EXHIBITIONDAYPERIOD Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Period Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value3), RI_Exh_DayPeriod_Value3 + " in EXHIBITION DAY PERIOD field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value3, "EXHIBITION DAY PERIOD",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_ExhibitBUSINESS_TERMS_Key, RI_Exh_EditMode_ExhibitBUSINESS_TERMS_Header) + "/img", "RI_Exh_EditMode_ExhibitBUSINESS_TERMS_Header",RI_Exh_EditMode_ExhibitBUSINESS_TERMS_Header);
		rightsIN.noteFunctionlity("___% of ___ from Merchandising; ___% of ___ from all other exploitation");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(LocCancel,"Cancel button");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//TC_102	
		ExecutionLog.Log("Manual Test Step: TC_102");
		ExecutionLog.Log("");
		ExecutionLog.Log("View Mode: Verify the Data in Parent Row ");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, 	"Applies to",		RI_Exh_EditMode_ExhibitAPPLIESTO_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDATEUPDATE_Key, RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header), 	RI_Exh_Update_DefaultValue, 	"Applies to",		RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), 	"12", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_EXHIBITION_DAYS_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_RESERVED_EXHIBITION_DAYS_Key, RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header), 	"2", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header, 	"innerHTML");
		verifyElementPresent(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "POOLED Check box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Series, "ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, RI_Exh_EditMode_STARTDATE_Header), 	RI_MediaRights_TermFromTestData, 	"STARTDATE",			RI_Exh_EditMode_STARTDATE_Header, 	"innerHTML");

		ExecutionLog.Log(color("red", "=====BUG ID======: 21562"));
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, RI_Exh_EditMode_ENDDATE_Header), 		RI_MediaRights_TermToTestData, 		"ENDDATE",				RI_Exh_EditMode_ENDDATE_Header, 	"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("View Mode: Verify the Data in CHILD Row ");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOW_TYPE_Key, RI_Exh_EditMode_Child_WINDOW_TYPE_Header), 			RI_Exh_WinType_DefaultValue, 		"Window Type",		RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RIGHTSTYPE_Key_ViewMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");
		verifyElementPresent(getLocator_Child_DataRow("3", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"POOLED Check box",		RI_Exh_EditMode_POOLED_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key, RI_Exh_EditMode_Child_STARTDATECHILD_Header), 	RI_MediaRights_TermFromTestData + " - " + RI_MediaRights_TermToTestData, 		"'From - To' Date",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");
		//Exh Networks
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel1, "Exhibition Network " + RI_Exh_ExhNetworkChannel1,	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "title");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel2, "Exhibition Network " + RI_Exh_ExhNetworkChannel2,	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "title");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_TERRITORY_Key, RI_Exh_EditMode_Child_TERRITORY_Header), RI_MediaRights_Territory_PickListValues, "Territory " + RI_MediaRights_Territory_PickListValues,	RI_Exh_EditMode_Child_TERRITORY_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), RI_Exh_DayType_Programming, "Day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value3, "Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value2, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		switchIntoFrame(frameParent3Xpath);

		//TC_103	
		ExecutionLog.Log("Manual Test Step: TC_103");
		ExecutionLog.Log("");
		ExecutionLog.Log("Edit Mode: Verify the Data in PARENT Row ");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, 	"Applies to",		RI_Exh_EditMode_ExhibitAPPLIESTO_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDATEUPDATE_Key, RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header), 	RI_Exh_Update_DefaultValue, 	"Applies to",		RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), 	"12", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_EXHIBITION_DAYS_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_RESERVED_EXHIBITION_DAYS_Key, RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header), 	"2", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header, 	"innerHTML");
		verifyElementPresent(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "POOLED Check box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Series, "ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, RI_Exh_EditMode_STARTDATE_Header), 	RI_MediaRights_TermFromTestData, 	"STARTDATE",			RI_Exh_EditMode_STARTDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, RI_Exh_EditMode_ENDDATE_Header), 		RI_MediaRights_TermToTestData, 		"ENDDATE",				RI_Exh_EditMode_ENDDATE_Header, 	"innerHTML");




		ExecutionLog.Log("");
		ExecutionLog.Log("Edit Mode: Verify the Data in CHILD Row ");
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOW_TYPE_Key, RI_Exh_EditMode_Child_WINDOW_TYPE_Header), 			RI_Exh_WinType_DefaultValue, 		"Window Type",		RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RIGHTSTYPE_Key_EditMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");
		verifyElementPresent(getLocator_Child_DataRow("3", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"POOLED Check box",		RI_Exh_EditMode_POOLED_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, RI_Exh_EditMode_Child_STARTDATECHILD_Header), 	RI_MediaRights_TermFromTestData, 		"Start Date",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");		
		//Exh Networks
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel1, "Exhibition Network " + RI_Exh_ExhNetworkChannel1 +", " + RI_Exh_ExhNetworkChannel2,	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_TERRITORY_Key, RI_Exh_EditMode_Child_TERRITORY_Header), RI_MediaRights_Territory_PickListValues, "Territory " + RI_MediaRights_Territory_PickListValues,	RI_Exh_EditMode_Child_TERRITORY_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), RI_Exh_DayType_Programming, "Day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value3, "Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value2, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_104" );
		ExecutionLog.Log("Edit Mode: Validation on Entering Invalid Dates in Parent Row ");
		dateFunctionality_ForParentRows(RI_Exh_StartDate2016, "N/A", RI_Exh_ValidationMsg_EnterValidDateRange);
		dateFunctionality_ForParentRows(RI_Exh_StartDate2017, "N/A", RI_MediaRights_EditMode_DataSavedSuccessfully);
		dateFunctionality_ForParentRows("N/A", RI_Exh_ENDDate2021, RI_Exh_ValidationMsg_EnterValidDateRange);
		dateFunctionality_ForParentRows("N/A", RI_MediaRights_TermToTestData, RI_MediaRights_EditMode_DataSavedSuccessfully);


		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_108" );
		ExecutionLog.Log("Edit Mode: Validation on Entering Invalid Dates in Child Row ");
		dateFunctionality_ForChildRows(RI_Exh_StartDate2016, "N/A", RI_Exh_ValidationMsg_NotWithInValidDateRange);
		dateFunctionality_ForChildRows(RI_Exh_StartDate2017, "N/A", RI_MediaRights_EditMode_DataSavedSuccessfully);
		dateFunctionality_ForChildRows("N/A", RI_Exh_ENDDate2021, RI_Exh_ValidationMsg_NotWithInValidDateRange);
		dateFunctionality_ForChildRows("N/A", RI_MediaRights_TermToTestData, RI_MediaRights_EditMode_DataSavedSuccessfully);

		dateFunctionality_ForParentRows(RI_Exh_StartDate2016, RI_Exh_ENDDate2016, RI_Exh_ValidationMsg_EnterValidDateRange);
		dateFunctionality_ForParentRows(RI_Exh_StartDate2017, RI_MediaRights_TermToTestData, RI_MediaRights_EditMode_DataSavedSuccessfully);
		dateFunctionality_ForChildRows(RI_Exh_StartDate2016, RI_Exh_ENDDate2016, RI_Exh_ValidationMsg_NotWithInValidDateRange);
		dateFunctionality_ForChildRows(RI_Exh_StartDate2017, RI_MediaRights_TermToTestData, RI_MediaRights_EditMode_DataSavedSuccessfully);
		// TearDown : Entering the start and and date from media rights 
		//dateFunctionality_ForParentRows(RI_MediaRights_TermFromTestData, RI_MediaRights_TermToTestData, RI_MediaRights_EditMode_DataSavedSuccessfully);
		dateFunctionality_ForParentRows(RI_Exh_StartDate2018_1, RI_Exh_ENDDate2018_2, RI_Exh_ValidationMsg_NotWithInValidDateRange);// Issue: mentioned in Excel file
		dateFunctionality_ForChildRows(RI_Exh_StartDate2018_2, RI_Exh_ENDDate2018_2, RI_MediaRights_EditMode_DataSavedSuccessfully);
		switchIntoFrame(frameParent3Xpath);
		clickOn(LocCancel,"Cancel button");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, RI_Exh_EditMode_STARTDATE_Header), 	RI_Exh_StartDate2018_1, 	"STARTDATE",			RI_Exh_EditMode_STARTDATE_Header, 	"innerHTML");
		ExecutionLog.Log(color("red", "=====BUG ID======: 21562"));
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, RI_Exh_EditMode_ENDDATE_Header), 		RI_Exh_ENDDate2018_2, 		"ENDDATE",				RI_Exh_EditMode_ENDDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key, RI_Exh_EditMode_Child_STARTDATECHILD_Header), 	RI_Exh_StartDate2018_2 + " - " + RI_Exh_ENDDate2018_2, 		"'From - To' Date",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");

		scriptStatus();
	}

	/**
	 * Total Steps 	: 15
	 * @throws Exception
	 */
	@Test(priority =5, enabled = true, description = "Copy Functionality")
	public void TC6_CopyFunctionality() throws Exception {
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");

		//TC_RI_EX_040
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_EX_130");
		ExecutionLog.Log("Select Row >> Copy button >> Validation msg");
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_ExhRights_Child_ColumnXpath_EditMode, "Child Row");
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy button", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		verifyFieldValueOfHeader(PromptAlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_ValidationMessage, "Alert Message Copy rows", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertCancelButton, 	"Cancel Button at Prompt Alert", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);	

		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy button", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		verifyFieldValueOfHeader(PromptAlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_ValidationMessage, "Alert Message Copy rows", RI_Exh_EditMode_CopyRows_Buttons);
		sendKeys(PromptAlertInputBox, "20", "Number of Copies", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 		"OK Button at Prompt Alert", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_InvalidNumber_ValidationMessage, "Alert Message RI_MediaRights_Copy rows", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", RI_Exh_EditMode_CopyRows_Buttons);
		//TC_RI_EX_137
		sendKeys(PromptAlertInputBox, "1", "Number of Copies", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_Exh_EditMode_CopyRows_Buttons);

		// Type Window Name
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);	
		String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";
		String loc_SecondChildRow = getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header, "1");
		clickOn(loc_SecondChildRow, "Window Name Field");
		sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName2, "Win Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(loc_SecondChildRow, RI_Exh_WinName2, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		clickOn(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "Pooled Check Box");
		// Enter 5 in Exh days of Child
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), "EXHIBITION_DAYS Field");
		sendKeys(loc_RI_ExhRights_InputField, "5", "RI_Exh_EditMode_EXHIBITION_DAYS_Header", RI_Exh_EditMode_EXHIBITION_DAYS_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header), 	"5", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_EXHIBITION_DAYS_Header, 	"innerHTML");

		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header,"1"), "EXHIBITION_DAYS Second ChildField");
		sendKeys(loc_RI_ExhRights_InputField, "5", "RI_Exh_EditMode_EXHIBITION_DAYS_Header", RI_Exh_EditMode_EXHIBITION_DAYS_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_EXHIBITION_DAYS_Key, RI_Exh_EditMode_EXHIBITION_DAYS_Header, "1"), 	"5", 	"EXHIBITION_DAYS",	RI_Exh_EditMode_EXHIBITION_DAYS_Header, 	"innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyElementPresent(RI_DeliveryScheduleText.replace("@var", RI_Exh_ValidationMsg_NotPooledThenSameNetwork), "RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch", RI_Exh_EnterRequiredFields_ValidationMsg);
		clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");
		
		sleepTime(5);
		switchIntoFrame(frameParent3Xpath);

		scrollElementIntoView(getLocator_Child_DataRow("3", RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), RI_Exh_EditMode_Child_RID_RATING_Header, loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), "Add Exhibition");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Add Exhibition Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1 +" in Add Exhibition field");
		scrollElementIntoView(supportClickLoctor, "Media Parent Row", loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value1, "Add Exhibition for Win 2",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		scrollElementIntoView(getLocator_Child_DataRow("3", RI_Exh_Child_RID_RATING_Key, RI_Exh_EditMode_Child_RID_RATING_Header), RI_Exh_EditMode_Child_RID_RATING_Header, loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, "1"), "Add Exhibition");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Add Exhibition Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1 +" in Add Exhibition field");
		scrollElementIntoView(supportClickLoctor, "Media Parent Row", loc_RI_ExhibitionRights_HorizontalScroll);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, "1"), RI_Exh_AddExh_Value1, "Add Exhibition for Win 2",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);


		scriptStatus();
	}

	/**
	 * Total Steps 	: 75
	 * In Progress 	: 5
	 * @throws Exception
	 */
	@Test(priority =6, enabled = true, description = "Exhib.Day Scope validations")
	public void TC6_ExhibDayScope_validations() throws Exception {

		if(!ClientData.contains("VMN")) {

			//---------------------------------Started creating pre-requisites------------------------------------------------------------------//
			ExecutionLog.Log("---------------------------------Started creating pre-requisites------------------------------------------------------------------");
			rightsIN.selectDeal(CreatedDealTC6);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			switchIntoFrame(frameParent3Xpath);

			// Media Rights for "All"
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window", RI_Exh_EditMode_closeButton);


			rightsIN.selectDeal(CreatedDealTC6);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");


			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
			clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

			clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
			clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);



			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "PickListValue " + CreatedSeriesAssetTitleTC1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_1), "PickListValue " + TheatreAssetTitleTC6_1);
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), 	"Checked "+ CreatedSeriesAssetTitleTC1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_1), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");


			// Enter Exhibition Scope in Parent Window
			switchIntoFrame(frameParent3Xpath);
			clickOn(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Season), "'Season' in Exhi Scope field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Season, RI_Exh_ExhiScope_Season + " in ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");


			// Window name in Allocation row
			clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), "Window Name Field");
			sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName, "Win Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");


			// Rights Type in Allocation row
			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key, RI_Exh_EditMode_Child_RIGHTSTYPE_Header)+"/img", "Window Name Field");
			switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
			sleepTime(3);
			clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear),"Check box " + RI_ExhibitionRights_EditMode_Linear);
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		RI_ExhibitionRights_EditMode_Linear + " Check box is checked");
			sleepTime(3);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Apply Button at RIGHTSTYPE_POPUP");

			// Exhibition Network in Allocation row
			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
			switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel1),"Selected Channel " + RI_Exh_ExhNetworkChannel1);
			clickOn(OKButton,"Ok button at Exhibtion Network Window");
			WaitForModalPanel();



			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_MediaRights_EditMode_DataSavedSuccessfully);


			//TC_10
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_10");
			ExecutionLog.Log("Select " + CreatedSeriesAssetTitleTC1  + " and " + CreatedSeriesAssetTitleTC6 + " in Applies to Field \n and verify the different validations with diff combi. of Exhi. scope");
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "PickListValue " + CreatedSeriesAssetTitleTC1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC6), "PickListValue " + TheatreAssetTitleTC6_1);
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), 	"Checked "+ CreatedSeriesAssetTitleTC1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC6), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");


			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);


			//TC_18
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_18");
			ExecutionLog.Log("Select " + RI_MediaRights_Episode101  + " and " + RI_MediaRights_Episode201 + " in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "PickListValue of Episode101");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode201), "PickListValue of Episode201");

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode201), 	"Checked "+ RI_MediaRights_Episode201 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);


			//TC_31
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_31");
			ExecutionLog.Log("Select " + CreatedSeriesAssetTitleTC1  + " and " + RI_MediaRights_Season1 + " in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "PickListValue " + CreatedSeriesAssetTitleTC1);

			WebElement element = driver.findElements(ByLocator(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1))).get(1);
			clickOn(element, "PickListValue " + RI_MediaRights_Season1);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), 	"Checked "+ CreatedSeriesAssetTitleTC1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 	"Checked "+ RI_MediaRights_Season1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);


			//TC_36
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_36");
			ExecutionLog.Log("Select '" + CreatedSeriesAssetTitleTC1  + "' and '" + RI_MediaRights_Episode101 + "' of Series2 in Applies to Field");
			ExecutionLog.Log(" and verify the different validations with diff combi. of Exhi. scope");
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "PickListValue " + CreatedSeriesAssetTitleTC1);

			element = driver.findElements(ByLocator(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101))).get(1);
			clickOn(element, "PickListValue " + RI_MediaRights_Episode101);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), 	"Checked "+ CreatedSeriesAssetTitleTC1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);




			//TC_41
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_41");
			ExecutionLog.Log("Select '" + RI_MediaRights_Season1  + "' of Series1 and '" + RI_MediaRights_Season1 + "' of Series2 in Applies to Field ");
			ExecutionLog.Log(" and verify the different validations with diff combi. of Exhi. scope");
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "PickListValue " + RI_MediaRights_Season1);

			element = driver.findElements(ByLocator(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1))).get(1);
			clickOn(element, "PickListValue " + RI_MediaRights_Season1);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 	"Checked "+ RI_MediaRights_Season1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 	"Checked "+ RI_MediaRights_Season1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);



			//TC_46
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_46");
			ExecutionLog.Log("Select '" + RI_MediaRights_Season1  + "' and '" + RI_MediaRights_Episode101 + "' of Series2 in Applies to Field");
			ExecutionLog.Log(" and verify the different validations with diff combi. of Exhi. scope");
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "PickListValue " + RI_MediaRights_Season1);

			element = driver.findElements(ByLocator(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101))).get(1);
			clickOn(element, "PickListValue " + RI_MediaRights_Episode101);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 	"Checked "+ RI_MediaRights_Season1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);

			//TC_51
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_51");
			ExecutionLog.Log("Select '" + RI_MediaRights_Episode101  + "' of Series1 and '" + RI_MediaRights_Episode101 + "' of Series2 in Applies to Field");
			ExecutionLog.Log(" and verify the different validations with diff combi. of Exhi. scope");
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "PickListValue " + RI_MediaRights_Episode101);

			element = driver.findElements(ByLocator(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101))).get(1);
			clickOn(element, "PickListValue " + RI_MediaRights_Episode101);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_MediaRights_EditMode_DataSavedSuccessfully);


			//TC_56
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_56");
			ExecutionLog.Log("Select '" + TheatreAssetTitleTC6_1  + "' and '" + TheatreAssetTitleTC6_2 + "' in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_1), "PickListValue " + TheatreAssetTitleTC6_1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_2), "PickListValue " + TheatreAssetTitleTC6_2);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_1), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_2), 	"Checked "+ TheatreAssetTitleTC6_2 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_MediaRights_EditMode_DataSavedSuccessfully);



			//TC_61
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_61");
			ExecutionLog.Log("Select '" + TheatreAssetTitleTC6_1  + "' and '" + CreatedSeriesAssetTitleTC1 + "' in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_1), "PickListValue " + TheatreAssetTitleTC6_1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "PickListValue " + CreatedSeriesAssetTitleTC1);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_1), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), 	"Checked "+ CreatedSeriesAssetTitleTC1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_MediaRights_EditMode_DataSavedSuccessfully);

			//TC_61
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_61");
			ExecutionLog.Log("Select '" + TheatreAssetTitleTC6_1  + "' and '" + RI_MediaRights_Season1 + "' in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_1), "PickListValue " + TheatreAssetTitleTC6_1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "PickListValue " + RI_MediaRights_Season1);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_1), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 	"Checked "+ RI_MediaRights_Season1 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_MediaRights_EditMode_DataSavedSuccessfully);





			//TC_71
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_71");
			ExecutionLog.Log("Select '" + TheatreAssetTitleTC6_1  + "' and '" + RI_MediaRights_Episode101 + "' in Applies to Field and verify the different validations with diff combi. of Exhi. scope");		
			switchIntoFrame(frameParent3Xpath);
			doubleClick(loc_RI_Exh_AppliesTOPickList, "Applies to Pop up");

			switchIntoFrame(frameParent4Xpath);
			clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "DeSelectAll");
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", TheatreAssetTitleTC6_1), "PickListValue " + TheatreAssetTitleTC6_1);
			clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "PickListValue " + RI_MediaRights_Episode101);

			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", TheatreAssetTitleTC6_1), 	"Checked "+ TheatreAssetTitleTC6_1 + " on Applies to Pop up");
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked "+ RI_MediaRights_Episode101 + " on Applies to Pop up");
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Series, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Season, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Episodes, RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset);
			ChangeExhScopeAndVerifyValidation(RI_Exh_ExhiScope_Asset, RI_MediaRights_EditMode_DataSavedSuccessfully);

		}
		scriptStatus();
	}

	/**
	 * Total Steps 	: 15
	 * @throws Exception
	 */
	@Test(priority =7, enabled = true, description = "Delete Functionality")
	public void TC7_DeleteFunctionality() throws Exception {
		String FirstAllocationRow_EditMode = loc_RI_ExhRights_ChildRow + "[@role='row']//th";
		
		//---------------------------------Started creating pre-requisites------------------------------------------------------------------//
		ExecutionLog.Log("---------------------------------Started creating pre-requisites------------------------------------------------------------------");
		rightsIN.selectDeal(CreatedDealTC7);
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
		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row2
		mediaRights.enterDatainAllFields("2", CreatedSeriesAssetTitleTC1);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		// Verifying the entered data
		mediaRights.verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		mediaRights.verifyAllAvailableFields_EditMode("2",CreatedSeriesAssetTitleTC1);
		clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window", RI_Exh_EditMode_closeButton);
		WaitForModalPanel();

		ExecutionLog.Log("---------------------------------Adding Media in Exhibition Rights------------------------------------------------------------------");
		rightsIN.selectDeal(CreatedDealTC7);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Adding Media Rows into the Exhibition Row
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();

		EnterMandatoryData(2);

		switchIntoFrame(frameParent3Xpath);		
		doubleClick(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		doubleClick(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();

		EnterMandatoryData(4);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		switchIntoFrame(frameParent3Xpath);


		//---------------------------------------------Actual Manual Test Steps from TC_1 of "Delete Functionalities------------------------------------------------------//
		ExecutionLog.Log("---------------------------------Execute Manual Test Steps from TC_1 of \"Delete Functionalities\"------------------------------------------------------------------");

		// Two Parent Headers and Two Allocation rows are shown
		// The locator to select complete rows are same hence using List API to locate all the rows
		List<WebElement> rowSelector = driver.findElements(ByLocator(FirstAllocationRow_EditMode));
		WebElement Parent1_Child1_RowSelector = rowSelector.get(1);
		WebElement Parent2_RowSelector = rowSelector.get(2);
		WebElement Parent2_Child1_RowSelector = rowSelector.get(3);

		sleepTime(5);
		ExecutionLog.Log("");
		ExecutionLog.Log("Do not select row >> Click Delete >> Verify Alert Message >> Click OK Button");
		switchIntoFrame(frameParent3Xpath);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_Exh_Delete_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_DeleteButton);

		ExecutionLog.Log("");
		ExecutionLog.Log("Select Allocation Row >> Click Delete >> Verify Confirm Message >> Click Cancel");
		switchIntoFrame(frameParent3Xpath);
		//clickOn(FirstAllocationRow_EditMode , "First Allocation Row");
		clickOn(Parent1_Child1_RowSelector , "First Allocation Row");
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_Delete_Conrimation_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up", RI_Exh_EditMode_DeleteButton);

		ExecutionLog.Log("");
		ExecutionLog.Log("Click Delete >> Verify Confirm Message >> Click OK Button");
		switchIntoFrame(frameParent3Xpath);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_Delete_Conrimation_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		ExecutionLog.Log("");
		ExecutionLog.Log("Click Close Btn at Edit Window>> Verify 'Navigate away 'Confirm Message >> Click OK Button >> Verify Row is not deleted and shown in view mode");
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window", RI_Exh_EditMode_closeButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_NavigateAwayPopup, "Alert Message on clicking 'Delete Button'", RI_Exh_EditMode_closeButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		sleepTime(3);
		verifyElementPresent(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), "Allocation Row in View Mode");

		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");

		//verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("Select Parent 2 >> Child 1 >> Click Delete >> Verify Confirm Message >> Click OK");
		switchIntoFrame(frameParent3Xpath);
		sleepTime(3);
		rowSelector = driver.findElements(ByLocator(FirstAllocationRow_EditMode));
		Parent2_Child1_RowSelector = rowSelector.get(3);

		doubleClick(Parent2_Child1_RowSelector, "Parent2_Child1_RowSelector");
		//clickOn(Parent2_Child1_RowSelector, "Parent2_Child1_RowSelector");
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);

		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_Delete_Conrimation_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();

		ExecutionLog.Log("");
		ExecutionLog.Log("Select Parent 2 >> Click Delete >> Verify Confirm Message >> Click OK");
		switchIntoFrame(frameParent3Xpath);
		rowSelector = driver.findElements(ByLocator(FirstAllocationRow_EditMode));
		Parent2_RowSelector = rowSelector.get(2);
		clickOn(Parent2_RowSelector, "Parent2_RowSelector");
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", RI_Exh_EditMode_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_Delete_ParentConrimation_ValidationMsg, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert", RI_Exh_EditMode_DeleteButton);

		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		scriptStatus();
	}

	/**
	 * Total Steps 			 : 38
	 * Total Automated Steps : 23
	 * Obsolete 			 : 11 
	 * Can not automate 	 : 2
	 * In Progress 			 : 2
	 * 
	 * @throws Exception
	 */
	@Test(priority =9, enabled = true, description = "Exhibition Rights tab:Exhibition Rights Filter")
	public void TC7_ExhibRights_Filter() throws Exception {
		ExecutionLog.Log("---------------------------------Started creating pre-requisites------------------------------------------------------------------");
		ExecutionLog.Log("---------------------------------Add Media Row------------------------------------------------------------------");
		String FirstRow_EditMode = loc_RI_ExhRights_ChildRow + "[@role='row']//th";
		ExecutionLog.Log("");
		rightsIN.selectDeal(CreatedDealTC7_1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		sleepTime(5);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row1
		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window", RI_Exh_EditMode_closeButton);
		WaitForModalPanel();

		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------Add Media Row in Exhibition Rights TAB------------------------------------------------------------------");
		rightsIN.selectDeal(CreatedDealTC7_1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");

		// Adding Media Rows into the Exhibition Row
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		EnterMandatoryData(2);

		// Changing the Exhibition Scope from 'Season' to 'Episode' in Parent Window
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Episodes), RI_Exh_ExhiScope_Episodes + " in Exhi Scope field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Episodes, RI_Exh_ExhiScope_Episodes + " in ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");

		switchIntoFrame(frameParent3Xpath);	
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------Execute the test cases------------------------------------------------------------------");

		//TC_1
		ExecutionLog.Log("Manual test Step : TC_1");
		ExecutionLog.Log("Verify Default Drop down values of Filters");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Default value of Alphabate Filter ", "(Select One)", RI_Exh_EditMode_Alphabet_MultiSelect, "title");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_Exh_EditMode_AppliesToMultiSelect, "title");
		ExecutionLog.Log("Verify MultiSelect Icons of Filters are present");
		verifyElementPresent(loc_RI_MediaRights_EditMode_AlphabateFilterPickList, "Alphabate Filter Pick List",RI_Exh_EditMode_Alphabet_MultiSelect);
		verifyElementPresent(loc_RI_MediaRights_EditMode_AssetFilterPickList, "Assets Filter Pick List",RI_Exh_EditMode_AppliesToMultiSelect);

		switchIntoFrame(frameParent3Xpath);
		clickOn(FirstRow_EditMode , "First Parent Row");
		clickOn(FirstRow_EditMode , "First Parent Row");
		doubleClick(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button");

		WaitForModalPanel();
		sendKeys(PromptAlertInputBox, "3", "Number of Copies", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);

		//TC_6
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_6");

		List<WebElement> appliesTOPickList = driver.findElements(ByLocator(loc_RI_Exh_AppliesTOPickList));
		WebElement appliesToParent0 = appliesTOPickList.get(0);
		WebElement appliesToParent1 = appliesTOPickList.get(1);
		WebElement appliesToParent2 = appliesTOPickList.get(2);
		WebElement appliesToParent3 = appliesTOPickList.get(3);

		doubleClick(appliesToParent1, "Applies to Pop up Parent1");
		//clickOn(appliesToParent1, "Applies to Pop up Parent1");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", CreatedSeriesAssetTitleTC1), "RI_EditMode_AppliesToDropDown_" + CreatedSeriesAssetTitleTC1, RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", CreatedSeriesAssetTitleTC1), RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(appliesToParent2, "Applies to Pop up Parent2");
		//clickOn(appliesToParent2, "Applies to Pop up Parent2");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_Episode101, RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(appliesToParent3, "Applies to Pop up Parent3");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode102), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_Episode102, RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode102), RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);	
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		ExecutionLog.Log(color("red","===BUG ID 21557==="));	
		String FilterValue = RI_MediaRights_EditMode_AppliesToDropDown_ValueAll + "," + RI_MediaRights_Episode101 + "," + RI_MediaRights_Episode102;
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ",FilterValue , RI_Exh_EditMode_AppliesToMultiSelect, "title");

		switchIntoFrame(frameParent3Xpath);	
		//TC_8
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_8");
		//clear filter 
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter", RI_Exh_ClearFiltersButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Default value of Alphabate Filter ", "(Select One)", RI_Exh_EditMode_Alphabet_MultiSelect, "title");

		// TC9
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_9");
		doubleClick(loc_RI_MediaRights_EditMode_AlphabateFilterPickList, "MultiSelect Alphabet Filter Icon");
		//clickOn(loc_RI_MediaRights_EditMode_AlphabateFilterPickList, "MultiSelect Alphabet Filter Icon");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", "A"), "'A' RI_EditMode_AppliesToDropDown Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, 	"Applies to",		RI_Exh_EditMode_ExhibitAPPLIESTO_Header, 	"innerHTML");
		verifyElementNotPresent(getLocator_Parent_DataRow("6", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), "Third Parent Row");

		//TC_11
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_11");
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_APPLIESTO_HeaderName);


		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_OnChangingFilter, "Alert Message on changing Filter", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");

		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_OnChangingFilter, "Alert Message on clicking Delete Button", RI_Exh_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up", RI_Exh_EditMode_DeleteButton);

		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Value of Asset Filter ", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_Exh_EditMode_AppliesToMultiSelect, "title");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Default value of Alphabate Filter ", "(Select One)", RI_Exh_EditMode_Alphabet_MultiSelect, "title");

		//TC_25
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_25");
		ExecutionLog.Log("Asset Filter (Select  All) >> Change the Asset from Episode101 >> Save >> Verify the value in the filter");
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter", RI_Exh_ClearFiltersButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Default value of Alphabate Filter ", "(Select One)", RI_Exh_EditMode_Alphabet_MultiSelect, "title");

		List<WebElement> appliesTOPickList1 = driver.findElements(ByLocator(loc_RI_Exh_AppliesTOPickList));
		appliesToParent0 = appliesTOPickList1.get(0);
		appliesToParent1 = appliesTOPickList1.get(1);
		appliesToParent2 = appliesTOPickList1.get(2);
		appliesToParent3 = appliesTOPickList1.get(3);

		doubleClick(appliesToParent0, "Applies to Pop up Parent0");
		//clickOn(appliesToParent0, "Applies to Pop up Parent0");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_Episode101, RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);	
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		WaitForModalPanel();


		switchIntoFrame(frameParent3Xpath);
		FilterValue =  RI_MediaRights_Episode101 + "," + RI_MediaRights_EditMode_AppliesToDropDown_ValueAll + "," + RI_MediaRights_Episode102;
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ",FilterValue , RI_Exh_EditMode_AppliesToMultiSelect, "title");

		//TC_27
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_27");
		ExecutionLog.Log("Asset Filter (Select  All) >> Change the Asset from Episode101 >> Save >> Verify the value in the filter");

		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		// REassigning to handle Stale Element Reference Exception
		List<WebElement> appliesTOPickList2 = driver.findElements(ByLocator(loc_RI_Exh_AppliesTOPickList));
		appliesToParent0 = appliesTOPickList2.get(0);
		doubleClick(appliesToParent0, "Applies to Pop up Parent0");
		//clickOn(appliesToParent0, "Applies to Pop up Parent0");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_Episode101, RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), RI_Exh_EditMode_ExhibitAPPLIESTO_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);	
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		WaitForModalPanel();


		switchIntoFrame(frameParent3Xpath);
		FilterValue =  RI_MediaRights_EditMode_AppliesToDropDown_ValueAll + "," + RI_MediaRights_Episode101 ;
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ",FilterValue , RI_Exh_EditMode_AppliesToMultiSelect, "title");



		//TC_29
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_29");
		ExecutionLog.Log("No Matching Results");
		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_Season1, RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_Exh_ValidationMsg_OnSelectAssetWithNoRow);

		selectDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Alphabet Filter", "Z", RI_Exh_EditMode_Alphabet_DropDown);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_OnChangingFilter, "Alert Message on changing Filter", RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up", RI_Exh_EditMode_Alphabet_DropDown);


		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_Exh_ValidationMsg_OnSelectAssetWithNoRow);
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter", RI_Exh_ClearFiltersButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		//TC_12
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_12");
		doubleClick(FirstRow_EditMode, "Parent Row");
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy button", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		verifyFieldValueOfHeader(PromptAlertValidationMessgeText, 	RI_MediaRights_EnterNoOfCopies_ValidationMessage, "Alert Message Copy rows", RI_Exh_EditMode_CopyRows_Buttons);
		sendKeys(PromptAlertInputBox, "1", "Number of Copies", RI_Exh_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 		"OK Button at Prompt Alert", RI_Exh_EditMode_CopyRows_Buttons);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_AssetFilter, "Asset Filter", RI_MediaRights_Season1, RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_NavigateAwayPopup, "Alert Message on selecting Season 1 in asset filter", RI_Exh_EditMode_closeButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_RI_MediaRights_EditMode_AlphabateFilterDropDown, "Alphabet Filter", "A", RI_Exh_EditMode_Alphabet_DropDown);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_NavigateAwayPopup, "Alert Message on selecting 'A' in Alphabate filter", RI_Exh_EditMode_closeButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");

		switchIntoFrame(frameParent3Xpath);
		doubleClick(loc_RI_MediaRights_EditMode_AlphabateFilterPickList, "Alphabate Filter Pick List");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_ExhRights_EditMode_");
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of alphabets at alphabate MultiSelect Window");
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_NavigateAwayPopup, "Alert Message on selecting 'All Alphabates' in Alphabate filter", RI_Exh_EditMode_closeButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");

		switchIntoFrame(frameParent3Xpath);
		doubleClick(loc_RI_MediaRights_EditMode_AssetFilterPickList, "Asset Filter Pick List");
		sleepTime(5);
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_ExhRights_EditMode_");
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Asset at Asset MultiSelect Window");
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_Exh_ValidationMsg_NavigateAwayPopup, "Alert Message on selecting 'All Asset' in Alphabate filter", RI_Exh_EditMode_closeButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		FilterValue = RI_MediaRights_EditMode_AppliesToDropDown_ValueAll + "," + CreatedSeriesAssetTitleTC1 + "," + RI_MediaRights_Season1 + "," +	RI_MediaRights_Episode101 + "," + RI_MediaRights_Episode102
				+ "," + RI_MediaRights_Season2 + "," +	RI_MediaRights_Episode201 + "," + RI_MediaRights_Episode202;
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ",FilterValue , RI_Exh_EditMode_AppliesToMultiSelect, "title");


		scriptStatus();
	}

	/**
	 * Total Steps 			 : 10
	 * @throws Exception
	 */
	@Test(priority =10, enabled = true, description = "If user adds additional episodes to series linked to production deal,it should get updated in both media rights tab and exhibition tab.")
	public void TC9_UpdateEpisodeInDealNavigator() throws Exception {
		rightsIN.selectDeal(CreatedDealTC7_1);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator", "");
		sleepTime(6);

		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(By.xpath(ListDealNavigatorDeal));
		clickOn(loc_AssetAtDealNavigator.replace("@var", CreatedSeriesAssetTitleTC1), "Asset '" + CreatedSeriesAssetTitleTC1 + "'");
		doubleClick(loc_AssetAtDealNavigator.replace("@var", CreatedSeriesAssetTitleTC1), "Asset '" + CreatedSeriesAssetTitleTC1 + "'");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);

		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"103","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");

		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);

		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "5"), "Season Field of Fifth Row");
		sleepTime(1);
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");


		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_Exh_ValidationMsg_DalNav_EpispdeTAB);
		WaitForModalPanel();
		// Close All associated windows
		ExecutionLog.Log("Close All Associated Window");		
		List<WebElement> elms = driver.findElements(ByLocator("//*[contains(@src,'Close.gif')]"));
		for(int i = 1; i <=elms.size(); i++) {
			if(elms.get(elms.size()-i).isDisplayed()) {
				clickOn(elms.get(elms.size()-i), "Close");
				WaitForModalPanel();
			}

		}

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();


		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_APPLIESTO_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, RI_MediaRights_EditMode_APPLIESTO_HeaderName + "Drop Down Image",	RI_MediaRights_EditMode_APPLIESTO_HeaderName);


		if(ClientData.contains("VMN")) {
			switchIntoFrame(frameParent3Xpath);
			String loc_mediaRightsSupportClick = mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_UserDefinedSeasonEpisode103), "Episode103" ,	RI_MediaRights_EditMode_APPLIESTO_HeaderName);
			clickOn(loc_mediaRightsSupportClick,"Support Click");
			verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), 	RI_MediaRights_UserDefinedSeasonEpisode103, "RI_MediaRights_EditMode_" + RI_MediaRights_EditMode_APPLIESTO_HeaderName,		RI_MediaRights_EditMode_APPLIESTO_HeaderName, 	"innerHTML");	
		} else {
			verifyElementNotPresent(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_UserDefinedSeasonEpisode103), "Episode103");
		}

		scriptStatus();
	}

	/**
	 * @author Rajuddin
	 * Total Steps		: 22
	 * Steps Automated 	: 22
	 * @Description: 
	 * @throws Exception
	 */
	@Test(priority =11, enabled = true, description = "'Expand All' and 'Collapse All' functionality")
	public void TC10_ExpandCollapseFunctionality() throws Exception {
		rightsIN.selectDeal(CreatedDealTC7_1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");


		String FirstRow_EditMode = loc_RI_ExhRights_ChildRow + "[@role='row']//th";
		switchIntoFrame(frameParent3Xpath);
		clickOn(FirstRow_EditMode , "First Parent Row");
		clickOn(FirstRow_EditMode , "First Parent Row");
		doubleClick(loc_RI_Exh_AllocateButton, "Copy Allocate Button");

		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"1"), "Window Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName, "Win Name for Second Allocation Row", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"1"), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");

		// N/A for VMN
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key, RI_Exh_EditMode_Child_RIGHTSTYPE_Header,"1")+"/img", "Window Name Field", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear),"Check box " + RI_ExhibitionRights_EditMode_Linear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		RI_ExhibitionRights_EditMode_Linear + " Check box is checked", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Apply Button at RIGHTSTYPE_POPUP", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RIGHTSTYPE_Key_EditMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");

		EnterMandatoryData_UnderSameParent(2);


		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header,"1")+"/img", "Network pop up icon");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel1),"Selected Channel " + RI_Exh_ExhNetworkChannel1);
		clickOn(OKButton,"Ok button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		clickOn(loc_RI_closeButton, "Close Button at Exhibition rights Pop up Window", RI_Exh_EditMode_closeButton);


		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Collapse/Expand All Buttons functionality");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickOn(loc_RI_Exh_ViewMode_CollapseButton, "Collapse All Button");
		verifyElementDisplayed(loc_RI_Exh_ViewMode_ExpandIcon, "Icon To Expnad Rows", RI_Exh_ViewMode_CollapseButton);
		verifyElementNotPresent(loc_RI_Exh_ViewMode_CollapseIcon, "Icon To Collapse Rows");

		clickOn(loc_RI_Exh_ViewMode_ExpandButton, "Expand Button");
		verifyElementDisplayed(loc_RI_Exh_ViewMode_CollapseIcon, "Icon To Collapse Rows", RI_Exh_ViewMode_ExpandButton);
		verifyElementNotPresent(loc_RI_Exh_ViewMode_ExpandIcon, "Icon To Expand Rows");

		ExecutionLog.Log("");
		ExecutionLog.Log("Go to Edit Exhibition >> Close Edit Window >> Verify the Collapse/Expand All Buttons functionality");
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");
		clickOn(loc_RI_closeButton, "Close Button at Exhibition rights Pop up Window", RI_Exh_EditMode_closeButton);	

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickOn(loc_RI_Exh_ViewMode_CollapseButton, "Collapse All Button");
		verifyElementDisplayed(loc_RI_Exh_ViewMode_ExpandIcon, "Icon To Expnad Rows", RI_Exh_ViewMode_CollapseButton);
		verifyElementNotPresent(loc_RI_Exh_ViewMode_CollapseIcon, "Icon To Collapse Rows");

		clickOn(loc_RI_Exh_ViewMode_ExpandButton, "Expand Button");
		verifyElementDisplayed(loc_RI_Exh_ViewMode_CollapseIcon, "Icon To Collapse Rows", RI_Exh_ViewMode_ExpandButton);
		verifyElementNotPresent(loc_RI_Exh_ViewMode_ExpandIcon, "Icon To Expand Rows");

		scriptStatus();
	}

	/**
	 * @author Rajuddin
	 * Total Steps		: 15
	 * Steps Automated 	: 15
	 * @Description: 
	 * @throws Exception
	 */
	// Marked this test case as deferred as the functionality is not cleared after discussion with Jitin
	@Test(priority =12, enabled = false , description = "The dialog to select media rights row will  allow the user to select a negative media rights")
	public void TC11_() throws Exception {

		if(!ClientData.contains("AMCN")) {
			rightsIN.selectDeal(CreatedDealTC6);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			WaitForModalPanel();

			ExecutionLog.Log("");
			ExecutionLog.Log("Enter 'HoldBack' in Restrction Field");
			switchIntoFrame(frameParent3Xpath);
			mediaRights.enterDataInFieldEditMode("2", RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName, 		RI_MediaRights_Restriction_DropDownValues1,		RI_MediaRights_FLAG_RESTRICTION_TYPE_Key);
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			clickOn(loc_RI_closeButton, "Close Button at Exhibition rights Pop up Window", RI_Exh_EditMode_closeButton);


			ExecutionLog.Log("");
			ExecutionLog.Log("Exhibition Rights TAB >> Edit >> Add >> Verify that check boxSecond row is disabled");
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");

		} else {
			throw new SkipException("This Test Case is \"N/A\" for AMCN");
		}

	}

	/**
	 * @author Rajuddin
	 * Total Steps		: 18
	 * Obsolete			: 01
	 * @Description: 
	 * @throws Exception
	 */
	// Deal 7 needs Two Rows in Media Rights hence This test step is Adding one more row 
	@Test(priority =13, enabled = true, description = "Without” Media Rights Row : Unique list of all the Territory selected in Media Rights rows")
	public void TC12_UniqueListOfTerritories() throws Exception {
		if(!(Browser.contains("chrome") || Browser.contains("firefox"))) {
			rightsIN.selectDeal(CreatedDealTC12);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);

			sleepTime(5);
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			// Enter the data for Row1
			mediaRights.enterDatainAllFields("1", RI_MediaRights_Season1);

			switchIntoFrame(frameParent3Xpath);
			clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
			clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);	
			WaitForModalPanel();
			sendKeys(PromptAlertInputBox, "1", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
			clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);

			mediaRights.enterDataInFieldEditMode_FromPickList_SearchField("1", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, RI_Exh_Terr1, RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_TERRITORY_UD_POPUP_Key);
			mediaRights.enterDataInFieldEditMode_FromPickList_SearchField("2", RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName, RI_Exh_Terr2, RI_MediaRights_TERRITORY_TEMPLATE_Key, RI_MediaRights_TERRITORY_UD_POPUP_Key);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window");


			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFirstSelectedDropdownValue(loc_RI_MediaRights_AssetFilter, "Default value of Asset Filter ", "(Select All)", RI_Exh_EditMode_AppliesToMultiSelect, "title");


			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
			clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);

			clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box of Row 1",	RI_Exh_MediaWindow_SelectHeader);
			clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box of Row 2",	RI_Exh_MediaWindow_SelectHeader);

			doubleClick(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);

			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			EnterMandatoryData(2);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();

			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_TERRITORY_Header);
			sleepTime(3);
			clickUsingJSExecutor(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_ExhibitTERRITORY_UD_POPUP_Key, RI_Exh_EditMode_Child_TERRITORY_Header)+"/img", "Territory pop up icon");
			doubleClick(getLocator_Child_DataRow("3", RI_Exh_EditMode_Child_ExhibitTERRITORY_UD_POPUP_Key, RI_Exh_EditMode_Child_TERRITORY_Header)+"/img", "Territory pop up icon");
			switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_TERRITORY_Header);
			sleepTime(3);

			String ElementEnableStatus = getAttribute(loc_RI_EditMode_Applies_TemplateWindow_Asset.replace("@var", RI_Exh_Terr1), "class");
			Assert.assertFalse(ElementEnableStatus.contains("Disabled"));
			ExecutionLog.Log("Verified that \"" + RI_Exh_Terr1 + "\" is Enabled");


			ElementEnableStatus = getAttribute(loc_RI_EditMode_Applies_TemplateWindow_Asset.replace("@var", RI_Exh_Terr2), "class");
			Assert.assertFalse(ElementEnableStatus.contains("Disabled"));
			ExecutionLog.Log("Verified that \"" + RI_Exh_Terr2 + "\" is Enabled");

			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_"+ RI_Exh_EditMode_Child_TERRITORY_Header + " ",RI_Exh_EditMode_Child_TERRITORY_Header);
			verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), 	"Checked Nodes of Assets at "+ RI_Exh_EditMode_Child_TERRITORY_Header + "");

			clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");


			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_TERRITORY_Key, RI_Exh_EditMode_Child_TERRITORY_Header), RI_Exh_Terr1 + ", " + RI_Exh_Terr2, "",	RI_Exh_EditMode_Child_TERRITORY_Header, 	 "innerHTML");

			clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window",RI_MediaRights_EditMode_SaveButton);
			WaitForModalPanel();

			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
			clickOn(loc_RI_closeButton, "Close Button at Media rights Pop up Window");

			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_TERRITORY_Key, RI_Exh_EditMode_Child_TERRITORY_Header), RI_Exh_Terr1 + ", " + RI_Exh_Terr2, RI_Exh_EditMode_Child_TERRITORY_Header,	RI_Exh_EditMode_Child_TERRITORY_Header, 	 "innerHTML");

		} else {
			throw new SkipException("Need to do R&D on HOW to click on 'Pick List' of Edit MediaRights POP-UP for FF and Chrome Browser");
		}

		scriptStatus();
	}

	/**
	 * Enter the row number for Parent Row(Starts from 2)
	 * @param ParentRowNumber
	 * @throws Exception
	 */
	public void EnterMandatoryData(int ParentRowNumber) throws Exception {

		int temp = ParentRowNumber/2;
		ExecutionLog.Log("----------Enter the data in the fields of Parent row: \"" + temp +"\" Field of Exhibition Rights----------");
		// Enter Exhibition Scope in Parent Window
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow(ParentRowNumber+"", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Season), "'Season' in Exhi Scope field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow(ParentRowNumber+"", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Season, RI_Exh_ExhiScope_Season + " in ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");


		int temp_Child = (ParentRowNumber-1)/2;
		ExecutionLog.Log("----------Enter the data in the fields of Child row: \"" + temp_Child +"\" of Exhibition Rights----------");
		// Window name in Allocation row
		clickOn(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), "Window Name Field");
		sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName, "Win Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");


		// Rights Type in Allocation row(VMN :  N/A)
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		doubleClick(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key, RI_Exh_EditMode_Child_RIGHTSTYPE_Header)+"/img", "Window Name Field", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		sleepTime(3);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear),"Check box " + RI_ExhibitionRights_EditMode_Linear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		RI_ExhibitionRights_EditMode_Linear + " Check box is checked", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		sleepTime(3);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Apply Button at RIGHTSTYPE_POPUP", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);

		// Exhibition Network in Allocation row
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(3);
		clickUsingJSExecutor(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		doubleClick(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header)+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(3);
		clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel1),"Selected Channel " + RI_Exh_ExhNetworkChannel1);
		sleepTime(2);
		clickOn(OKButton,"Ok button at Exhibtion Network Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		if(ClientData.contains("VMN")) {
			// Day Type
			ExecutionLog.Log("");
			ExecutionLog.Log("Day Type");
			clickOn(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), "Day Type Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Type Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Consecutive), RI_Exh_DayType_Consecutive +" in Exhi Days Type field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header), RI_Exh_DayType_Consecutive, "Day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");


			// Day Period
			ExecutionLog.Log("");
			ExecutionLog.Log("Day Period");
			clickOn(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), "Day Period Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Period Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value1), RI_Exh_DayPeriod_Value1 +" in Day Period field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header), RI_Exh_DayPeriod_Value1, "Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");


			// Plays
			ExecutionLog.Log("");
			ExecutionLog.Log("Plays");
			clickOn(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), "Plays Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Plays Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value1), RI_Exh_Plays_Value1 +" in Plays field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");

			// Add Exhibition
			ExecutionLog.Log("");
			ExecutionLog.Log("Add Exhibition");
			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			clickOn(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), "Add Exhibition");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Add Exhibition Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1 +" in Add Exhibition field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow(ParentRowNumber+1+"", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header), RI_Exh_AddExh_Value1, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		}

	}

	/**
	 * Enter the row number for Parent Row(Starts from 2)
	 * @param ParentRowNumber
	 * @throws Exception
	 */
	// This method is basically required for VMN
	// As The allocated row does not copy the data from the first Allocated row as done in the AMCn 
	public void EnterMandatoryData_UnderSameParent(int ParentRowNumber) throws Exception {


		// Enter Exhibition Scope in Parent Window
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow(ParentRowNumber+"", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_ExhiScope_Season), "'Season' in Exhi Scope field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow(ParentRowNumber+"", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Season, RI_Exh_ExhiScope_Season + " in ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");


		// Window name in Allocation row
		clickOn(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header, "1"), "Window Name Field");
		sendKeys(loc_RI_ExhRights_InputField, RI_Exh_WinName, "Win Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header, "1"), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");


		// Rights Type in Allocation row(VMN :  N/A)
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		doubleClick(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key, RI_Exh_EditMode_Child_RIGHTSTYPE_Header, "1")+"/img", "Window Name Field", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		sleepTime(3);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear),"Check box " + RI_ExhibitionRights_EditMode_Linear, RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_ExhibitionRights_EditMode_Linear), 		RI_ExhibitionRights_EditMode_Linear + " Check box is checked", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);
		sleepTime(3);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Apply Button at RIGHTSTYPE_POPUP", RI_Exh_EditMode_Child_RIGHTSTYPE_Header);

		// Exhibition Network in Allocation row
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(3);
		clickUsingJSExecutor(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, "1")+"/img", "Network pop up icon");
		doubleClick(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_EditMode_Child_NETWORK_POPUP_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, "1")+"/img", "Network pop up icon");
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
		sleepTime(3);
		clickOn(RI_DeliveryScheduleText.replace("@var", RI_Exh_ExhNetworkChannel1),"Selected Channel " + RI_Exh_ExhNetworkChannel1);
		sleepTime(2);
		clickOn(OKButton,"Ok button at Exhibition Network Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		if(ClientData.contains("VMN")) {
			// Day Type
			ExecutionLog.Log("");
			ExecutionLog.Log("Day Type");
			clickOn(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, "1"), "Day Type Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Type Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayType_Consecutive), RI_Exh_DayType_Consecutive +" in Exhi Days Type field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYTYPE_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, "1"), RI_Exh_DayType_Consecutive, "Day Type",	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header, 	 "innerHTML");


			// Day Period
			ExecutionLog.Log("");
			ExecutionLog.Log("Day Period");
			clickOn(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, "1"), "Day Period Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "DAYS Period Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_DayPeriod_Value1), RI_Exh_DayPeriod_Value1 +" in Day Period field");
			clickOn(supportClickLoctor,"Support Click");
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_EXHIBITIONDAYPERIOD_Key, RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, "1"), RI_Exh_DayPeriod_Value1, "Day Period",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	 "innerHTML");


			// Plays
			ExecutionLog.Log("");
			ExecutionLog.Log("Plays");
			clickOn(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, "1"), "Plays Field", RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Plays Drop Down", RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_Plays_Value1), RI_Exh_Plays_Value1 +" in Plays field", RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header);
			clickOn(supportClickLoctor, "Support Click", RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, "1"), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");

			// Add Exhibition
			ExecutionLog.Log("");
			ExecutionLog.Log("Add Exhibition");
			switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			clickOn(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, "1"), "Add Exhibition", RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Add Exhibition Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Exh_AddExh_Value1), RI_Exh_AddExh_Value1 +" in Add Exhibition field",RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header);
			clickOn(supportClickLoctor, "Support Click", RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow(ParentRowNumber+1+"", RI_Exh_Child_ADDLNETWORKUSAGE_Key, RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, "1"), RI_Exh_AddExh_Value1, "Add Exhibition",	RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 	 "innerHTML");

		}

	}

	/**
	 * 
	 * @param ExhibitionScope
	 * @param validation
	 * @throws Exception
	 * 
	 * change the 
	 */
	public void ChangeExhScopeAndVerifyValidation(String ExhibitionScope, String validation) throws Exception{
		String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";

		// Enter Exhibition Scope in Parent Window
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), "Exhibition Day Scope Field");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Exhibition Day Scope Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var",  ExhibitionScope), "'" +ExhibitionScope + "' in Exhi Scope field");
		clickOn(supportClickLoctor,"Support Click");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header),  ExhibitionScope,  ExhibitionScope + " in ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		if(validation.contains(RI_MediaRights_EditMode_DataSavedSuccessfully)) {
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", validation);
		} else {
			// The Error messages is shown in a separate window
			switchIntoFrame(frameParent4Xpath);
			verifyElementPresent(RI_DeliveryScheduleText.replace("@var", validation), validation + " Validation message", validation);
			clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");
			switchIntoFrame(frameParent3Xpath);
		}

	}

	/**
	 * @author Rajuddin
	 * @param StartDate: Pass "N/A" if do not want to enter the data
	 * @param EndDate  : Pass "N/A" if do not want to enter the data
	 * @param ValidationMsg
	 * @throws Exception
	 */
	public void dateFunctionality_ForParentRows(String StartDate, String EndDate, String ValidationMsg)  throws Exception {		
		String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";
		switchIntoFrame(frameParent3Xpath);		
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, StartDate), "STARTDATE Field", StartDate);
		sendKeys_WithoutClear(loc_RI_ExhRights_InputField, StartDate, "Start Date", StartDate);
		clickOn(supportClickLoctor,"Support Click", StartDate);		
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, StartDate), 	StartDate, "Start Date",	StartDate, 	 "innerHTML");
		clickOn(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, EndDate), "EndDate Field", EndDate);
		sendKeys_WithoutClear(loc_RI_ExhRights_InputField, EndDate, "Start Date", EndDate);
		clickOn(supportClickLoctor,"Support Click", EndDate);		
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, EndDate), 	EndDate, "Start Date",	EndDate, 	 "innerHTML");

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();

		if(ValidationMsg.contains(RI_MediaRights_EditMode_DataSavedSuccessfully)) {
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", ValidationMsg);
		} else {
			switchIntoFrame(frameParent4Xpath);
			verifyElementPresent(RI_DeliveryScheduleText.replace("@var", ValidationMsg), ValidationMsg + " Validation message", ValidationMsg);
			clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");
			switchIntoFrame(frameParent3Xpath);
		}
	}

	/**
	 * @author Rajuddin
	 * @param StartDate: Pass "N/A" if do not want to enter the data
	 * @param EndDate  : Pass "N/A" if do not want to enter the data
	 * @param ValidationMsg
	 * @throws Exception
	 */
	public void dateFunctionality_ForChildRows(String StartDate, String EndDate, String ValidationMsg)  throws Exception {		
		String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";
		switchIntoFrame(frameParent3Xpath);		
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, StartDate), "STARTDATE Field", StartDate);
		sendKeys_WithoutClear(loc_RI_ExhRights_InputField, StartDate, "Start Date", StartDate);
		clickOn(supportClickLoctor,"Support Click", StartDate);		
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, StartDate), 	StartDate, "Start Date",	StartDate, 	 "innerHTML");
		clickOn(getLocator_Child_DataRow("3", RI_Exh_Child_ENDDATECHILD_Key_EditMode, EndDate), "EndDate Field", EndDate);
		sendKeys_WithoutClear(loc_RI_ExhRights_InputField, EndDate, "Start Date", EndDate);
		clickOn(supportClickLoctor,"Support Click", EndDate);		
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_ENDDATECHILD_Key_EditMode, EndDate), 	EndDate, "Start Date",	EndDate, 	 "innerHTML");

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();

		if(ValidationMsg.contains(RI_MediaRights_EditMode_DataSavedSuccessfully)) {
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", ValidationMsg);
		} else {
			switchIntoFrame(frameParent4Xpath);
			verifyElementPresent(RI_DeliveryScheduleText.replace("@var", ValidationMsg), ValidationMsg + " Validation message", ValidationMsg);
			clickOn(loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply, "Ok Button at Error message Window");
			switchIntoFrame(frameParent3Xpath);
		}
	}

	public void functionalityOf_TerritoryWindow( String TestStep, String HeaderName) throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("***************" + HeaderName + " Template*****");
		ExecutionLog.Log("From Manual Test Step : " + TestStep);

		switchIntoFrame(frameParent4Xpath, HeaderName);
		sleepTime(3);
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 		RI_MediaRights_EditMode_ExpandAll_Button, 	"RI_MediaRights_EditMode_ExpandAll_Button",		RI_MediaRights_EditMode_ExpandAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 	RI_MediaRights_EditMode_CollapseAll_Button, "RI_MediaRights_EditMode_CollapseAll_Button",	RI_MediaRights_EditMode_CollapseAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 		RI_MediaRights_EditMode_SelectAll_Button, 	"RI_MediaRights_EditMode_SelectAll_Button",		RI_MediaRights_EditMode_SelectAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, 	RI_MediaRights_EditMode_DeSelectAll_Button, "RI_MediaRights_EditMode_DeSelectAll_Button",	RI_MediaRights_EditMode_DeSelectAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 			RI_MediaRights_EditMode_Apply_Button, 		"RI_MediaRights_EditMode_Apply_Button",			RI_MediaRights_EditMode_Apply_Button, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Cancel, 		RI_MediaRights_EditMode_Cancel_Button, 		"RI_MediaRights_EditMode_Cancel_Button",		RI_MediaRights_EditMode_Cancel_Button, 		"value");

		//verifyElementNotDisplayed(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, "Collapsed Icons", HeaderName);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, "Expand Icon");

		ExecutionLog.Log("");
		ExecutionLog.Log("**********Verify Expand/Collapse functionality**********");
		ExecutionLog.Log("*****  Click On Collapse All and verify that collapse(minus) icons are not shown *****"); 
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 			"'Collapse' RI_MediaRights_EditMode_"+ HeaderName + " List",RI_ExhibitionRights_EditMode_CollapseAll_Button);  
		sleepTime(3);
		//verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, 	"Collapsed Icons");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, 		"Expand Icons", 	RI_ExhibitionRights_EditMode_CollapseAll_Button);

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 				"'Expand' RI_MediaRights_EditMode at "+ HeaderName + " Edit Window",	RI_ExhibitionRights_EditMode_ExpandAll_Button);
		sleepTime(5);
		//verifyElementNotDisplayed(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, 	"Expand Icons  at "+ HeaderName + " Edit Window", HeaderName);
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, 	"Collapse Icons at "+ HeaderName + " Edit Window", 	RI_ExhibitionRights_EditMode_ExpandAll_Button);

		ExecutionLog.Log("");
		ExecutionLog.Log("**********Verify Select/DeSelecting functionality**********");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",HeaderName);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets at "+ HeaderName + " ");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), 	"Checked Nodes of Assets at "+ HeaderName + "");


		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",HeaderName);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets at "+ HeaderName + "");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), 	"Unchecked Nodes of Assets at "+ HeaderName + "");

		clickOn(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Territory_PickListValues),"PickListValue " + RI_MediaRights_Territory_PickListValues);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

	}

	/**
	 * The Headers of View/ Edit mode are same
	 * This method can be used for headers of view mode and edit mode
	 * @throws Exception
	 */
	public void verifyParentHeaders() throws Exception{
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Headers of Parent Row");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_MEDIA_ROW_Parent_Key+"']", 		RI_Exh_ViewMode_MEDIA_ROW_Parent_Header, 		"Media Row Number",				RI_Exh_ViewMode_MEDIA_ROW_Parent_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_ExhibitAPPLIESTO_Key+"']", 		RI_Exh_ViewMode_ExhibitAPPLIESTO_Header, 		"Exhibit APPLIESTO",			RI_Exh_ViewMode_ExhibitAPPLIESTO_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_UNLIMITED_Key+"']", 				RI_Exh_ViewMode_UNLIMITED_Header, 				"UNLIMITED Header",				RI_Exh_ViewMode_UNLIMITED_Header,			"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_EXHIBITIONDATEUPDATE_Key+"']", 	RI_Exh_ViewMode_EXHIBITIONDATEUPDATE_Header,	"EXHIBIT DATE UPDATE Header",	RI_Exh_ViewMode_EXHIBITIONDATEUPDATE_Header,"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_EXHIBITION_DAYS_Key+"']", 		RI_Exh_ViewMode_EXHIBITION_DAYS_Header, 		"EXHIBITION_DAYSHeader",		RI_Exh_ViewMode_EXHIBITION_DAYS_Header,		"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_RESERVED_EXHIBITION_DAYS_Key+"']",RI_Exh_ViewMode_RESERVED_EXHIBITION_DAYS_Header,"RESERVED_EXHIBITION Header",	RI_Exh_ViewMode_RESERVED_EXHIBITION_DAYS_Header,"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_POOLED_Key+"']", 					RI_Exh_ViewMode_POOLED_Header, 					"POOLED Header",				RI_Exh_ViewMode_POOLED_Header,				"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_EXHIBITIONDAYSCOPE_Key+"']", 		RI_Exh_ViewMode_EXHIBITIONDAYSCOPE_Header	, 	"EXHIBITIONDAYSCOPE_Header",	RI_Exh_ViewMode_EXHIBITIONDAYSCOPE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_STARTDATE_Key+"']", 				RI_Exh_ViewMode_STARTDATE_Header, 				"STARTDATE Header",				RI_Exh_ViewMode_STARTDATE_Header,			"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_ENDDATE_Key+"']", 				RI_Exh_ViewMode_ENDDATE_Header, 				"ENDDATEHeader",				RI_Exh_ViewMode_ENDDATE_Header,				"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_ExhibitBUSINESS_TERMS_Key+"']", 	RI_Exh_ViewMode_ExhibitBUSINESS_TERMS_Header, 	"ExhibitBUSINESS_TERMSHeader",	RI_Exh_ViewMode_ExhibitBUSINESS_TERMS_Header,"innerHTML");

	}

	/**
	 * The Headers of View mode are same
	 * This method can be used for headers of view mode and edit mode
	 * @throws Exception
	 */
	public void verifyChildHeaders_ViewMode() throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("Verifying the Headers of Allocated Row in View Mode");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		//verifyFieldValueOfHeader("//th[@key='"+RI_Exh_MEDIA_ROW_Parent_Key+"']", 	RI_Exh_ViewMode_MEDIA_ROW_Parent_Header, 				"Media Row Number",		RI_Exh_ViewMode_MEDIA_ROW_Parent_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_WINDOWNAME_Key+"']", 			RI_Exh_ViewMode_Child_WINDOWNAME_Header, 		    "WINDOWNAME",			        RI_Exh_ViewMode_Child_WINDOWNAME_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_WINDOW_TYPE_Key+"']", 			RI_Exh_ViewMode_Child_WINDOW_TYPE_Header, 		    "WINDOW_TYPE Header",		    RI_Exh_ViewMode_Child_WINDOW_TYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_RIGHTSTYPE_Key_ViewMode+"']", 			RI_Exh_ViewMode_Child_RIGHTSTYPE_Header, 		    "RIGHTSTYPE UPDATE Header",		RI_Exh_ViewMode_Child_RIGHTSTYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key+"']", RI_Exh_ViewMode_Child_EXHIBITION_DAYS_CHILD_Header, "EXHIBITION_DAYSHeader",		RI_Exh_ViewMode_Child_EXHIBITION_DAYS_CHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_MAX_EXHIBITION_DAYS_Key+"']", 	RI_Exh_ViewMode_Child_MAX_EXHIBITION_DAYS_Header, 	"MAX_EXHIBITION_DAYS Header",	RI_Exh_ViewMode_Child_MAX_EXHIBITION_DAYS_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_POOLED_CHILD_Key+"']", 			RI_Exh_ViewMode_Child_POOLED_CHILD_Header, 			"POOLED Header",	 	        RI_Exh_ViewMode_Child_POOLED_CHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_STARTDATECHILD_Key+"']", 		RI_Exh_ViewMode_Child_STARTDATECHILD_Header	, 		"STARTDATECHILD_Header",		RI_Exh_ViewMode_Child_STARTDATECHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_ENDDATECHILD_Key+"']", 			RI_Exh_ViewMode_Child_ENDDATECHILD_Header, 			"ENDDATECHILD Header",		    RI_Exh_ViewMode_Child_ENDDATECHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_NETWORK_SUMMARY_Key+"']", 		RI_Exh_ViewMode_Child_NETWORK_SUMMARY_Header, 		"NETWORK_SUMMARY Header",		RI_Exh_ViewMode_Child_NETWORK_SUMMARY_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_TERRITORY_Key+"']", 			RI_Exh_ViewMode_Child_TERRITORY_Header, 			"TERRITORY_TERMSHeader",		RI_Exh_ViewMode_Child_TERRITORY_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_EXHIBITIONDAYTYPE_Key+"']", 	RI_Exh_ViewMode_Child_EXHIBITIONDAYTYPE_Header	, 	"EXHIBITIONDAYTYPE_Header",		RI_Exh_ViewMode_Child_EXHIBITIONDAYTYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_EXHIBITIONDAYPERIOD_Key+"']", 	RI_Exh_ViewMode_Child_EXHIBITIONDAYPERIOD_Header, 	"EXHIBITIONDAYPERIOD Header",	RI_Exh_ViewMode_Child_EXHIBITIONDAYPERIOD_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_PLAYSPEREXHIBITION_Key+"']", 	RI_Exh_ViewMode_Child_PLAYSPEREXHIBITION_Header, 	"PLAYSPEREXHIBITION Header",	RI_Exh_ViewMode_Child_PLAYSPEREXHIBITION_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_ADDLNETWORKUSAGE_Key+"']", 		RI_Exh_ViewMode_Child_ADDLNETWORKUSAGE_Header, 		"ADDLNETWORKUSAGE_Header",		RI_Exh_ViewMode_Child_ADDLNETWORKUSAGE_Header,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_Exh_Child_RID_RATING_Key+"']", 			RI_Exh_ViewMode_Child_RID_RATING_Header, 			"RID_RATING_TERMSHeader",		RI_Exh_ViewMode_Child_RID_RATING_Header,	"innerHTML");

	}

	/**
	 * The Headers of Edit mode are same
	 * This method can be used for headers of view mode and edit mode
	 * @throws Exception
	 */
	public void verifyChildHeaders_EditMode() throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("Verifying the Headers of Allocated Row in Edit Mode");
		switchIntoFrame(frameParent3Xpath);
		//verifyFieldValueOfHeader(loc_RI_ExhRights_DataRowXpath_EditMode+"//th[@key='"+RI_Exh_MEDIA_ROW_Parent_Key+"']", 	RI_Exh_EditMode_MEDIA_ROW_Parent_Header, 				"Media Row Number",		RI_Exh_EditMode_MEDIA_ROW_Parent_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_WINDOWNAME_Key+"']", 			RI_Exh_EditMode_Child_WINDOWNAME_Header, 		    "WINDOWNAME",			        RI_Exh_EditMode_Child_WINDOWNAME_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_WINDOW_TYPE_Key+"']", 			RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		    "WINDOW_TYPE Header",		    RI_Exh_EditMode_Child_WINDOW_TYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_RIGHTSTYPE_Key_EditMode+"']", 			RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 		    "RIGHTSTYPE UPDATE Header",		RI_Exh_EditMode_Child_RIGHTSTYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key+"']", RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header, "EXHIBITION_DAYSHeader",		RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_MAX_EXHIBITION_DAYS_Key+"']", 	RI_Exh_EditMode_Child_MAX_EXHIBITION_DAYS_Header, 	"MAX_EXHIBITION_DAYS Header",	RI_Exh_EditMode_Child_MAX_EXHIBITION_DAYS_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_POOLED_CHILD_Key+"']", 			RI_Exh_EditMode_Child_POOLED_CHILD_Header, 			"POOLED Header",	 	        RI_Exh_EditMode_Child_POOLED_CHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_STARTDATECHILD_Key_EditMode+"']", 		RI_Exh_EditMode_Child_STARTDATECHILD_Header	, 		"STARTDATECHILD_Header",		RI_Exh_EditMode_Child_STARTDATECHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_ENDDATECHILD_Key+"']", 			RI_Exh_EditMode_Child_ENDDATECHILD_Header, 			"ENDDATECHILD Header",		    RI_Exh_EditMode_Child_ENDDATECHILD_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_NETWORK_SUMMARY_Key+"']", 		RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 		"NETWORK_SUMMARY Header",		RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_TERRITORY_Key+"']", 			RI_Exh_EditMode_Child_TERRITORY_Header, 			"TERRITORY_TERMSHeader",		RI_Exh_EditMode_Child_TERRITORY_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_EXHIBITIONDAYTYPE_Key+"']", 	RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header	, 	"EXHIBITIONDAYTYPE_Header",		RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_EXHIBITIONDAYPERIOD_Key+"']", 	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header, 	"EXHIBITIONDAYPERIOD Header",	RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_PLAYSPEREXHIBITION_Key+"']", 	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	"PLAYSPEREXHIBITION Header",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_ADDLNETWORKUSAGE_Key+"']", 		RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header, 		"ADDLNETWORKUSAGE_Header",		RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header,	"innerHTML");
		verifyFieldValueOfHeader(loc_RI_ExhRights_ChildRow+"//th[@key='"+RI_Exh_Child_RID_RATING_Key+"']", 			RI_Exh_EditMode_Child_RID_RATING_Header, 			"RID_RATING_TERMSHeader",		RI_Exh_EditMode_Child_RID_RATING_Header,	"innerHTML");

	}
	
	public void verifyAllButtons_ViewMode() throws Exception{
		ExecutionLog.Log("");
		ExecutionLog.Log("*****Verify all the buttons, drop down available in View Mode at the Exhibition Rights TAB*****"); 
		verifyFieldValueOfHeader(loc_RI_MediaRights_AppliesToLabel, 		RI_Exh_AppliesToLabel, 		"RI_Exh_AppliesToLabel", 		RI_Exh_AppliesToLabel, 		"innerHTML");
		verifyFieldValueOfHeader(loc_RI_MediaRights_ClearFiltersButton, 	RI_Exh_ClearFiltersButton, 	"RI_Exh_ClearFiltersButton", 	RI_Exh_ClearFiltersButton, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_ShowAllRowsLabel, 		RI_Exh_ShowAllRowsLabel, 	"RI_Exh_ShowAllRowsLabel", 		RI_Exh_ShowAllRowsLabel, 	"innerHTML");
		//verifyFieldValueOfHeader(loc_RI_Exh_ViewMode_ExpandButton, 			RI_Exh_ViewMode_ExpandButton, 			"RI_Exh_ExpandAll", 			RI_Exh_ViewMode_ExpandButton, 	"value");
		//verifyFieldValueOfHeader(loc_RI_Exh_ViewMode_CollapseButton, 		RI_Exh_ViewMode_CollapseButton, 		"RI_Exh_CollapseAll", 			RI_Exh_ViewMode_CollapseButton, 	"value");

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
		String classValue = getClassValueParent(loc_RI_ExhRights_ParentRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
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
		String classValue = getClassValueChild(loc_RI_ExhRights_ChildRow+ "[" + rowNumber +"]//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexClass[1] +"')]";
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
		String classValue = getClassValueChild(loc_RI_ExhRights_ChildRow+ "//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_ExhRights_ChildRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexClass[1] +"')]";
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

	public void unusedCode() throws Exception{
		/*
		//Not Required

		// Adding the rows for Theaters, Series
		switchIntoFrame(frameParent3Xpath);
		ExecutionLog.Log("Adding the rows for Theaters, Series with the help of copy functionalities");		
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), "Selected First Row", RI_MediaRights_EditMode_ROW_NO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);	
		WaitForModalPanel();
		sendKeys(PromptAlertInputBox, "4", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		mediaRights.enterDataInFieldEditMode("2", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				CreatedSeriesAssetTitleTC1,	 	RI_MediaRights_APPLIESTO_Key);
		mediaRights.enterDataInFieldEditMode("3", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				CreatedSeriesAssetTitleTC6,	 	RI_MediaRights_APPLIESTO_Key);
		mediaRights.enterDataInFieldEditMode("4", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				TheatreAssetTitleTC6_1,	 	RI_MediaRights_APPLIESTO_Key);
		mediaRights.enterDataInFieldEditMode("5", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				TheatreAssetTitleTC6_2,	 	RI_MediaRights_APPLIESTO_Key);
		 */


		// Verify the data of child row under the same parent
		//TC_103	
		ExecutionLog.Log("");
		ExecutionLog.Log("Edit Mode: Verify the Data in PARENT Row ");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ExhibitAPPLIESTO_Key, RI_Exh_EditMode_ExhibitAPPLIESTO_Header), 	RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, 	"Applies to",		RI_Exh_EditMode_ExhibitAPPLIESTO_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDATEUPDATE_Key, RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header), 	RI_Exh_Update_DefaultValue, 	"Applies to",		RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header, 	"innerHTML");
		verifyElementPresent(getLocator_Parent_DataRow("2", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", "POOLED Check box");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_EXHIBITIONDAYSCOPE_Key, RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header), RI_Exh_ExhiScope_Season, "ExhiScope",	RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_STARTDATE_Key, RI_Exh_EditMode_STARTDATE_Header), 	RI_MediaRights_TermFromTestData, 	"STARTDATE",			RI_Exh_EditMode_STARTDATE_Header, 	"innerHTML");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_Exh_ENDDATE_Key, RI_Exh_EditMode_ENDDATE_Header), 		RI_MediaRights_TermToTestData, 		"ENDDATE",				RI_Exh_EditMode_ENDDATE_Header, 	"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("Edit Mode: Verify the Data in CHILD Row1 ");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_WINDOW_TYPE_Key, RI_Exh_EditMode_Child_WINDOW_TYPE_Header), 			RI_Exh_WinType_DefaultValue, 		"Window Type",		RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_RIGHTSTYPE_Key_EditMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");
		verifyElementPresent(getLocator_Child_DataRow("3", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header)+"/img", 	"POOLED Check box",		RI_Exh_EditMode_POOLED_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, RI_Exh_EditMode_Child_STARTDATECHILD_Header), 	RI_MediaRights_TermFromTestData, 		"Start Date",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");
		//Exh Networks
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_NETWORK_SUMMARY_Key, RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header), RI_Exh_ExhNetworkChannel1, "Exhibition Network " + RI_Exh_ExhNetworkChannel1,	RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");



		ExecutionLog.Log("");
		ExecutionLog.Log("Edit Mode: Verify the Data in CHILD Row2 ");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"1"), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOW_TYPE_Key, RI_Exh_EditMode_Child_WINDOW_TYPE_Header,"1"), 			RI_Exh_WinType_DefaultValue, 		"Window Type",		RI_Exh_EditMode_Child_WINDOW_TYPE_Header, 		 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_RIGHTSTYPE_Key_EditMode, RI_Exh_EditMode_Child_RIGHTSTYPE_Header,"1"), 		RI_ExhibitionRights_EditMode_Linear, RI_ExhibitionRights_EditMode_Linear,	RI_Exh_EditMode_Child_RIGHTSTYPE_Header, 	 "innerHTML");
		verifyElementPresent(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_POOLED_Key, RI_Exh_EditMode_POOLED_Header,"1")+"/img", 	"POOLED Check box",		RI_Exh_EditMode_POOLED_Header);
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_STARTDATECHILD_Key_EditMode, RI_Exh_EditMode_Child_STARTDATECHILD_Header,"1"), 	RI_MediaRights_TermFromTestData, 		"Start Date",	RI_Exh_EditMode_Child_STARTDATECHILD_Header, 	 "innerHTML");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_PLAYSPEREXHIBITION_Key, RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header,"1"), RI_Exh_Plays_Value1, "Plays",	RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header, 	 "innerHTML");




		// The locator to select complete rows are same hence using List API to locate all the rows
		/*List<WebElement> rowSelector = driver.findElements(ByLocator(FirstAllocationRow_EditMode));
			WebElement Parent1_RowSelector = rowSelector.get(0);
			WebElement Parent1_Child1_RowSelector = rowSelector.get(1);

		 */

		/*
		 * Not Required
	clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"1"), "Window Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
	sendKeys(loc_RI_ExhRights_InputField, "RSG Series A", "Win Name for Sexond Allocation Row", RI_Exh_EditMode_Child_WINDOWNAME_Header);
	clickOn(supportClickLoctor,"Support Click");
	verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"1"), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");

	clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"2"), "Window Name", RI_Exh_EditMode_Child_WINDOWNAME_Header);
	sendKeys(loc_RI_ExhRights_InputField, "RSG Series A", "Win Name for Sexond Allocation Row", RI_Exh_EditMode_Child_WINDOWNAME_Header);
	clickOn(supportClickLoctor,"Support Click");
	verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Exh_Child_WINDOWNAME_Key, RI_Exh_EditMode_Child_WINDOWNAME_Header,"2"), RI_Exh_WinName, "Window Name",	RI_Exh_EditMode_Child_WINDOWNAME_Header, 	 "innerHTML");
		 */


		/*clickOn(loc_RI_MediaRights_EditMode_AssetFilterPickList, "MultiSelect Asset Filter Icon");
		clickOn(loc_RI_MediaRights_EditMode_AssetFilterPickList, "MultiSelect Asset Filter Icon");
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_EditMode_AppliesToDropDown_ValueAll,  RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		 */	




		// Pop up

		/*clickOn(loc_RI_MediaRights_EditMode_AssetFilterPickList, "MultiSelect Asset Filter Icon");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "RI_EditMode_AppliesToDropDown_" + RI_MediaRights_EditMode_AppliesToDropDown_ValueAll,  RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		 */
	}



}





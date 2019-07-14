package rightsIN;

/**
 * @author Rajuddin
 * Started automating for VMN Client
 * TC12 - TC14 are "Not applicable" for VMN they are automated for AMCn
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;
import excelDataBinding.Excel_Reader;

@Listeners(utility.ListenerClass.class)
public class RI_TrackingEvents extends DriverHelper {

	public RI_TrackingEvents() {
		className = this.getClass().getName();
		classObject = this.getClass();
	}
	
	// Object of Test Classes
	AssetMaintenance assetMaintenance 	= new AssetMaintenance();
	RightsIN rightsIN 					= new RightsIN();
	RI_BusinessTerms businessTerm 		= new RI_BusinessTerms();
	RI_MediaRights mediaRights 			= new RI_MediaRights();
	RI_PromoRights promoRights 			= new RI_PromoRights();
	RI_Options options 					= new RI_Options();
	RI_TermEvent termEvent 				= new RI_TermEvent();
	
	// Initialized in Create data. class values used to locate the elements
	String classValue_AppliesTo_ViewMode = "";
	String classValue_EventDate_ViewMode = "";
	String classValue_AppliesTo_EditMode = "";
	String classValue_EventDate_EditMode = "";
	
	
	Date date = new Date();
	SimpleDateFormat sdf 		= new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate 		= sdf.format(date);

	
	String TC1_SeriesAsset 		= "AUT_AssetSeries_TC1_" +formattedDate+"";
	String TC1_Deal 			= "AUT_Deal_TC1_" +formattedDate+"";
	
	
	String TC2_ElementAsset1 	= "AUT_ElementAsset1_TC2_" +formattedDate+"";
	String TC2_ElementAsset2 	= "AUT_ElementAsset2_TC2_" +formattedDate+"";
	String TC2_SeriesAsset 		= "AUT_AssetSeries_TC2_" +formattedDate+"";
	String TC2_ElementalDeal 	= "AUT_ElementalDeal_TC2_" +formattedDate+"";
	String TC2_AcquisitionDeal 	= "AUT_AcquisitionDeal_TC2_" +formattedDate+"";
	
	
	String TC3_SeriesAsset 		= "AUT_AssetSeries_TC3_" +formattedDate+"";
	String TC3_Deal 			= "AUT_Deal_TC3_" +formattedDate+"";
		
	
	String TC6_SeriesAsset 		= "AUT_AssetSeries_TC4_" +formattedDate+"";
	String TC6_ElementAsset		= "AUT_ElementAsset_TC4_" +formattedDate+"";
	String TC6_1_Deal 			= "AUT_Deal_TC4_1_" +formattedDate+"";
	String TC6_2_Deal 			= "AUT_Deal_TC4_2_" +formattedDate+"";
	String TC6_ElementalDeal 	= "AUT_ElementalDeal_TC4_" +formattedDate+"";
	
	
	String TC7_SeriesAsset 		= "AUT_AssetSeries_TC7_" +formattedDate+"";
	String TC7_Deal 			= "AUT_Deal_TC7_" +formattedDate+"";
	// TC 22
	String TC22_ElementAsset 	= "AUT_ElementAsset1_TC22_" +formattedDate+"";
	String TC22_ElementalDeal 	= "AUT_ElementalDeal_TC22_" +formattedDate+"";
	// TC23
	String TC23_SeriesAsset 		= "AUT_AssetSeries_TC23_" +formattedDate+"";
	String TC23_Deal1 			= "AUT_Deal_TC23_1_" +formattedDate+"";
	String TC23_Deal2 			= "AUT_Deal_TC23_2_" +formattedDate+"";
	
	

	
	/**
	 * @author Rajuddin
	 * This Test Method create all the test data like creating Deals, Asset and Adding All Events in Tracking Event TAB
	 * @throws Exception
	 */
	@Test
	public void createData() throws Exception{		
		
		
		// TC1 
		assetMaintenance.createProgramAsset(TC1_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC1_SeriesAsset);		
		rightsIN.createDeal(TC1_Deal);
		rightsIN.associateAssetWithDeal(TC1_Deal,TC1_SeriesAsset);

		// Test Case2 : In Progress		
		assetMaintenance.createProgramAsset(TC2_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC2_SeriesAsset);
		rightsIN.createDeal(TC2_AcquisitionDeal);
		rightsIN.associateAssetWithDeal(TC2_AcquisitionDeal,TC2_SeriesAsset);

		assetMaintenance.createElementAsset(TC2_ElementAsset1, AssetType_Element_Music, AssetType_Element);
		assetMaintenance.createElementAsset(TC2_ElementAsset2, AssetType_Element_Music, AssetType_Element);	

		rightsIN.createDeal(TC2_ElementalDeal , "Standalone Agreement", "MML Synchronization License");

		rightsIN.searchCreatedDeal(TC2_ElementalDeal);
		rightsIN.associateAssetWithDeal(TC2_ElementalDeal,TC2_ElementAsset1);
		rightsIN.associateAssetWithDeal(TC2_ElementalDeal,TC2_ElementAsset2);
		

	// TC3_InitialExhibition_Calc 
	// TC5_InitialExhibition_Of_LastEpisodes_Calc
	// TC7 - TC15
		// One Program Asset >> Add 2 Seasons each having 2 Episodes
		// Episode Tab >> Enter the Initial Air date for each Episodes(01022014,01012014,01042014,01052014)
		// Create Deal and Assets
		assetMaintenance.createProgramAsset(TC3_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC3_SeriesAsset);
		// Enter the Premier date
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		assetMaintenance.enterInitialAirDate_EpisodeTAB("1", RI_TrackingEvents_EventDate122014);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("2", RI_TrackingEvents_EventDate112014);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("3", RI_TrackingEvents_EventDate142014);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("4", RI_TrackingEvents_EventDate152014);


		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		rightsIN.createDeal(TC3_Deal);
		rightsIN.associateAssetWithDeal(TC3_Deal,TC3_SeriesAsset);


		rightsIN.selectDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		// initialize the Class values for Applies to in view mode and edit mode
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify EventDate in View Mode >> Edit >>  EventDate in Edit Mode");
		classValue_AppliesTo_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		classValue_EventDate_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		Thread.sleep(3000);
		classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		classValue_EventDate_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		
		
		if(!ClientData.contains("VMN")) {

			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_TrackingEvents_EditMode_New) ;
			String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);

			verifyElementPresent(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),	"New Row is Added" , RI_TrackEvents_EventName);
			clickOn(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Event Group Field");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_Universal_EventGroup), RI_TrackingEvents_Universal_EventGroup +" in Event Group Field");

			// Enter data in Allocated row
			clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), "Property Field of Allocated row of Parent Row");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Asset Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
			clickOn(supportClickLoctor,"Support Click");

			/***
			 * Note: 
			 * There are several Events(Promotional rights, ProjectedDate, NegotiatedDate, Revenue Participation etc. are not Used for VMN now) which are added by default for VMN
			 * BUT in AMCn There is no default Event added
			 * So For AMCn : We need to add all the event required using Method addEvents(String EventName);
			 */
			// For TC 12 and TC13
			// Add Promotional rights Row in the default added allocated row
			clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), "Tracking Event Field of Allocated row of Parent Row");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_PromoStartDate), RI_TrackingEvents_PromoStartDate +" in Event Name Field");

			addEvents(RI_TrackingEvents_PromoEndDate);
			// For TC 14 and TC15
			addEvents(RI_TrackingEvents_ProjectedDate);
			addEvents(RI_TrackingEvents_NegotiatedDeadlineDate);
			addEvents(RI_TrackingEvents_Initial_ExhibitionDate);

		}

		addEvents(RI_TrackingEvents_ContractEndDate);
		addEvents(RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window");
		WaitForModalPanel();

		
		
		

	// TC6_InitialExhibition_Of_LastEpisodes_Calc
		// Crate Program Series Asset >> add 3 Seasons each having 2 Episodes
		// Add Last Episode Premiere:(01/01/2012,02/01/2012,02/01/2012)
		// Create Deal >> Associate Created Asset
		// Create 2nd Deal >> Associate Season1 and Season2
		// Create Element Asset
		// Create Elemental Deal and Associate Element Asset
		// Associate Series Asset with Element asset
	//// TODO : Enable when need to run TC6_InitialExhibition_Of_LastEpisodes_Calc
		assetMaintenance.createProgramAsset(TC6_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC6_SeriesAsset,3,2);

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "2").replace("@col", "10"), "Initial Air Date of Epi102", Episode_AirDateValue);
		sendKeys(loc_Episodes_InitialAirDate_InputField, RI_TrackingEvents_EventDate112012, "Episodes_InitialAirDate_InputField", Episode_AirDateValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select Initial Air Date");
		Thread.sleep(3000);

		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "4").replace("@col", "10"), "Initial Air Date of Epi202", Episode_AirDateValue);
		sendKeys(loc_Episodes_InitialAirDate_InputField, RI_TrackingEvents_EventDate212012, "Episodes_InitialAirDate_InputField", Episode_AirDateValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select Initial Air Date");
		Thread.sleep(3000);


		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "6").replace("@col", "10"), "Initial Air Date of Epi302", Episode_AirDateValue);
		sendKeys(loc_Episodes_InitialAirDate_InputField, RI_TrackingEvents_EventDate312012, "Episodes_InitialAirDate_InputField", Episode_AirDateValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select Initial Air Date");
		Thread.sleep(3000);

		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		
		rightsIN.createDeal(TC6_1_Deal);
		rightsIN.associateAssetWithDeal(TC6_1_Deal,TC6_SeriesAsset);


		rightsIN.createDeal(TC6_2_Deal);
		// Need to test the below code
		rightsIN.associationOfAssetsWithDeal(TC6_2_Deal,TC6_SeriesAsset);//Associate Season1 and Season2

		assetMaintenance.createElementAsset(TC6_ElementAsset, AssetType_Element_Music, AssetType_Element);
		rightsIN.createDeal(TC6_ElementalDeal, "Standalone Agreement", "Non-Primary Service Agreement");
		rightsIN.associateAssetWithDeal(TC6_ElementalDeal,TC6_ElementAsset);
		// Need to test the below code
		rightsIN.associateAssetWithElementAsset(TC6_ElementalDeal, TC6_SeriesAsset, TC6_ElementAsset);
		
		
		assetMaintenance.createProgramAsset(TC7_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC7_SeriesAsset,2,3); // Two Season having three Episodes in each seasons

		// Enter the Premier date
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		assetMaintenance.copySeasonWithDifferentVersion(TC7_SeriesAsset, S2_Episode201, "All Media Version");
		assetMaintenance.copySeasonWithDifferentVersion(TC7_SeriesAsset, S2_Episode201, "Online Version");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("1", RI_TrackingEvents_EventDate_1_15_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("2", RI_TrackingEvents_EventDate_1_22_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("3", RI_TrackingEvents_EventDate_1_29_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("4", RI_TrackingEvents_EventDate_9_25_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("5", RI_TrackingEvents_EventDate_10_2_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("6", RI_TrackingEvents_EventDate_10_9_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("7", RI_TrackingEvents_EventDate_11_1_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("8", RI_TrackingEvents_EventDate_11_8_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("9", RI_TrackingEvents_EventDate_11_15_2012);
		// Used in TC9_Initial_Exhibition_of_First_Episode_of_Last_Season_OnlineVersion
		assetMaintenance.enterInitialAirDate_EpisodeTAB("10", RI_TrackingEvents_EventDate_9_25_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("11", RI_TrackingEvents_EventDate_10_2_2012);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("12", RI_TrackingEvents_EventDate_10_9_2012);

		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);


		
	// TC7_InitialExhibition_Of_FirstEpisodes_Calc
	// TC8 to TC15
		rightsIN.createDeal(TC7_Deal, "Standalone Agreement");
		rightsIN.associateAssetWithDeal(TC7_Deal,TC7_SeriesAsset);
		


		// TC22
		assetMaintenance.createElementAsset(TC22_ElementAsset, AssetType_Element_Music, AssetType_Element);	
		rightsIN.createDeal(TC22_ElementalDeal , "Standalone Agreement", "MML Synchronization License");
		rightsIN.associateAssetWithDeal(TC22_ElementalDeal,TC22_ElementAsset);
		rightsIN.associateAssetWithElementAsset(TC22_ElementalDeal,TC3_SeriesAsset,TC22_ElementAsset);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");
		switchIntoFrame(frameParent3Xpath);
		
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		// Enter the data for Row 1
		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "", "", "Element");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		
		/*
		// For Test Cases of SKY
		// Create One Series Asset and Two Deals
		// Associate the same Asset with both Deals
		assetMaintenance.createProgramAsset(TC23_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC23_SeriesAsset,1,2);		
		rightsIN.createDeal(TC23_Deal1);
		rightsIN.associateAssetWithDeal(TC23_Deal1,TC23_SeriesAsset);

		rightsIN.createDeal(TC23_Deal2);
		rightsIN.associateAssetWithDeal(TC23_Deal2,TC23_SeriesAsset);
		*/
	}
	
	/**
	 * Total Test Steps : 46
	 * Obsolete : 1
	 * @throws Exception
	 */
	@Test(priority =1,enabled= true,description = "Tracking Event tab: UI Verification")
	public void TC1_UI_Verification() throws Exception {

		Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\RI_TestData.xlsx");
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_RI_TE1_1");
		rightsIN.searchCreatedDeal(TC1_Deal);
	
	
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_EventGroup_Key+"']", 		RI_TrackEvents_EventGroup_ViewMode, 	"RI_TrackEvents_EventGroup",	RI_TrackEvents_EventGroup,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_Notes_Key+"']", 			RI_TrackEvents_Notes, 		"RI_TrackEvents_Note",			RI_TrackEvents_Notes,		"innerHTML");
		ExecutionLog.Log("Verify Default Value of Event Name Field in View Mode");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), RI_TrackingEvents_Universal_EventGroup, "Default Event Group Name", RI_TrackEvents_EventGroup, "innerHTML");
		
		// Verify the default Event Names
		int siblingRow = 1;
		for(int excelRowNumber = 154; excelRowNumber <=163; excelRowNumber++) {
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			String ExpectedValue = xlsInputData.getCellData("RI_TrackingEvent", ClientData, excelRowNumber);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName, siblingRow+""), ExpectedValue, "Default value in Event Name", RI_TrackEvents_EventName, "innerHTML");
			siblingRow++;
		}
		
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_EventGroup_Key+"']", 		RI_TrackEvents_EventGroup, 	"RI_TrackEvents_EventGroup",	RI_TrackEvents_EventGroup,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_Notes_Key+"']", 			RI_TrackEvents_Notes, 		"RI_TrackEvents_Note",			RI_TrackEvents_Notes,		"innerHTML");

		// Verify Default value of Event Group :Universal
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), RI_TrackingEvents_Universal_EventGroup, "Default Event Group Name", RI_TrackEvents_EventGroup, "innerHTML");
		
		ExecutionLog.Log("Verify Default Value of Event Name Field in Edit Mode");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), xlsInputData.getCellData("RI_TrackingEvent", ClientData, 153), "Default Property Name", RI_TrackEvents_EventName, "innerHTML");
		siblingRow = 1;
		for(int excelRowNumber = 154; excelRowNumber <=163; excelRowNumber++) {

			String ExpectedValue = xlsInputData.getCellData("RI_TrackingEvent", ClientData, excelRowNumber);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName, siblingRow+""), ExpectedValue, "Default value in Event Name", RI_TrackEvents_EventName, "innerHTML");
			siblingRow++;
		}
		
		
		//TC_7
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_7");
		ExecutionLog.Log("Verify the Headers of Allocated row in Edit Window");
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_RowNo_Key, 		RI_TrackEvents_RowNo), 			RI_TrackEvents_RowNo, 			RI_TrackEvents_RowNo, 	RI_TrackEvents_RowNo, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), 		RI_TrackEvents_AppliesTO, 	"Default Property Name", 	RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), 		RI_TrackEvents_EventName, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), 		RI_TrackEvents_EventDate, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EstimatedDate_Key,RI_TrackEvents_EstimatedDate), 	RI_TrackEvents_EstimatedDate, 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Buttons available at Edit Window");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_CopyRows_Buttons, RI_TrackingEvents_EditMode_Copy, 	"RI_TrackingEvents_EditMode_Copy", 	RI_TrackingEvents_EditMode_Copy, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_AddButton,		RI_TrackingEvents_EditMode_New, 		"RI_TrackingEvents_EditMode_New", 	RI_TrackingEvents_EditMode_New, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_DeleteButton,	RI_TrackingEvents_EditMode_Delete, 		"RI_TrackingEvents_EditMode_Delete",RI_TrackingEvents_EditMode_Delete,"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_SaveButton,	RI_TrackingEvents_EditMode_Save, 		"RI_TrackingEvents_EditMode_Save", 	RI_TrackingEvents_EditMode_Save, "value");
		verifyFieldValueOfHeader(loc_RI_closeButton,						RI_TrackingEvents_EditMode_Cancel, 		"RI_TrackingEvents_EditMode_Cancel",RI_TrackingEvents_EditMode_Cancel,"value");
		verifyFieldValueOfHeader(loc_RI_Exh_AllocateButton,					RI_TrackingEvents_EditMode_Allocate, 	"RI_TrackingEvents_EditMode_Allocate",RI_TrackingEvents_EditMode_Allocate,"value");

		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Click On Add btn >> Verify New Row Added >> Save >> verify Vali. msg >> Select 'Universal' >> -----------------");
		ExecutionLog.Log("---------------verify Headers of allocated row of Second Parent Row-----------------------");
		
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_TrackingEvents_EditMode_New) ;
		verifyElementPresent(getLocator_Child_DataRow("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),	"New Row is Added" , RI_TrackEvents_EventName);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		
		clickOn(getLocator_Parent_DataRow("4", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Event Group Field of Second Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_Universal_EventGroup), RI_TrackingEvents_Universal_EventGroup +" in Event Group Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		

		//TC_12
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_12");
		switchIntoFrame(frameParent3Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Headers of Allocated row of Second Parent Row in Edit Window");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_RowNo_Key, 		RI_TrackEvents_RowNo), 			RI_TrackEvents_RowNo, 			RI_TrackEvents_RowNo, 	RI_TrackEvents_RowNo, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), 		RI_TrackEvents_AppliesTO, 	RI_TrackEvents_AppliesTO, RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), 		RI_TrackEvents_EventName, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), 		RI_TrackEvents_EventDate, 		RI_TrackEvents_EventDate, 	RI_TrackEvents_EventDate, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EstimatedDate_Key,RI_TrackEvents_EstimatedDate), 	RI_TrackEvents_EstimatedDate, 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "innerHTML");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Select All >> Enter DeliveryofFirstEpisode in Prop Field -----------------");
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), "Property Field of Allocated row of Second Parent Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Asset Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
		
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), "Tracking Event Field of Allocated row of Second Parent Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_DelivaryOfFirstEpisode), RI_TrackingEvents_DelivaryOfFirstEpisode +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), RI_TrackEvents_EventDate + " Event Date");
		sendKeys(loc_RI_ExhRights_InputField, RI_TrackingEvents_EventDate112014, RI_TrackEvents_EventDate, RI_TrackEvents_EventDate);
		clickOn(supportClickLoctor,"Support Click");
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EstimatedDate_Key, 	RI_TrackEvents_EstimatedDate) + "/img", RI_TrackEvents_EstimatedDate + " Check Box");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5", RI_TrackEvents_EstimatedDate_Key, 	RI_TrackEvents_EstimatedDate) + "/img", 	"Checked", 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "title");

		//TC_24
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_24");
		clickOn(getLocator_Parent_DataRow("4", RI_TrackEvents_Notes_Key, 	RI_TrackEvents_Notes) + "/img", "Note Icon of Second Row");
		switchIntoFrame(frameParent4Xpath);
		rightsIN.noteFunctionlity(RI_TrackingEvents_NoteTestData);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		
		
		//TC_36
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_36");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_TrackEvent_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(loc_AlertMessage, RI_TrackingEvents_ValMsg_Dlt_WithoutSelectRow, "Alert Message on clicking 'Delete Button'", RI_TrackingEvents_EditMode_Delete);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert Pop-Up");
//		// Select Row >> Delete >> Vali. Msg
		switchIntoFrame(frameParent3Xpath);	
		String EventNameForFirstRow_EditMode = getAttribute(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"innerHTML");
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"Child Row");
		clickOn(loc_RI_TrackEvent_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_TrackingEvents_ValMsg_Dlt_SelectRow, "Alert Message on clicking 'Delete Button'", RI_TrackingEvents_EditMode_Delete);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		String EventNameForFirstRow_ViewMode = getAttribute(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"innerHTML");
		verifyFalseCondition(EventNameForFirstRow_EditMode.equals(EventNameForFirstRow_ViewMode), "First Row of TrackingEvent");
			
		scriptStatus();
	}		
	
	// In Progress
	@Test(priority =1,enabled= false,description = "Tracking Event tab: UI Verification")
	public void TestCase2() throws Exception {
		Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\RI_TestData.xlsx");
		rightsIN.selectDeal(TC2_ElementalDeal+"_1");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_EventGroup_Key+"']", 		RI_TrackEvents_EventGroup_ViewMode, 	"RI_TrackEvents_EventGroup",	RI_TrackEvents_EventGroup,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_Notes_Key+"']", 			RI_TrackEvents_Notes, 		"RI_TrackEvents_Note",			RI_TrackEvents_Notes,		"innerHTML");
		ExecutionLog.Log("Verify Default Value of Event Name Field in View Mode");
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), RI_TrackingEvents_Universal_EventGroup, "Default Event Group Name", RI_TrackEvents_EventGroup, "innerHTML");
		
		// Verify the default Event Names
		int siblingRow = 1;
		for(int excelRowNumber = 154; excelRowNumber <=163; excelRowNumber++) {
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			String ExpectedValue = xlsInputData.getCellData("RI_TrackingEvent", ClientData, excelRowNumber);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName, siblingRow+""), ExpectedValue, "Default value in Event Name", RI_TrackEvents_EventName, "innerHTML");
			siblingRow++;
		}
		
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_EventGroup_Key+"']", 		RI_TrackEvents_EventGroup, 	"RI_TrackEvents_EventGroup",	RI_TrackEvents_EventGroup,	"innerHTML");
		verifyFieldValueOfHeader("//th[@key='"+RI_TrackEvents_Notes_Key+"']", 			RI_TrackEvents_Notes, 		"RI_TrackEvents_Note",			RI_TrackEvents_Notes,		"innerHTML");

		// Verify Default value of Event Group :Universal
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), RI_TrackingEvents_Universal_EventGroup, "Default Event Group Name", RI_TrackEvents_EventGroup, "innerHTML");
		
		ExecutionLog.Log("Verify Default Value of Event Name Field in Edit Mode");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), xlsInputData.getCellData("RI_TrackingEvent", ClientData, 153), "Default Property Name", RI_TrackEvents_EventName, "innerHTML");
		siblingRow = 1;
		for(int excelRowNumber = 154; excelRowNumber <=163; excelRowNumber++) {

			String ExpectedValue = xlsInputData.getCellData("RI_TrackingEvent", ClientData, excelRowNumber);
			verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName, siblingRow+""), ExpectedValue, "Default value in Event Name", RI_TrackEvents_EventName, "innerHTML");
			siblingRow++;
		}
		
		
		//TC_7
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_7");
		ExecutionLog.Log("Verify the Headers of Allocated row in Edit Window");
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_RowNo_Key, 		RI_TrackEvents_RowNo), 			RI_TrackEvents_RowNo, 			RI_TrackEvents_RowNo, 	RI_TrackEvents_RowNo, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), 		RI_TrackEvents_AppliesTO, 	"Default Property Name", 	RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), 		RI_TrackEvents_EventName, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), 		RI_TrackEvents_EventDate, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("3", RI_TrackEvents_EstimatedDate_Key,RI_TrackEvents_EstimatedDate), 	RI_TrackEvents_EstimatedDate, 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Buttons available at Edit Window");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_CopyRows_Buttons, RI_TrackingEvents_EditMode_Copy, 	"RI_TrackingEvents_EditMode_Copy", 	RI_TrackingEvents_EditMode_Copy, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_AddButton,		RI_TrackingEvents_EditMode_New, 		"RI_TrackingEvents_EditMode_New", 	RI_TrackingEvents_EditMode_New, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_DeleteButton,	RI_TrackingEvents_EditMode_Delete, 		"RI_TrackingEvents_EditMode_Delete",RI_TrackingEvents_EditMode_Delete,"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_SaveButton,	RI_TrackingEvents_EditMode_Save, 		"RI_TrackingEvents_EditMode_Save", 	RI_TrackingEvents_EditMode_Save, "value");
		verifyFieldValueOfHeader(loc_RI_closeButton,						RI_TrackingEvents_EditMode_Cancel, 		"RI_TrackingEvents_EditMode_Cancel",RI_TrackingEvents_EditMode_Cancel,"value");
		verifyFieldValueOfHeader(loc_RI_Exh_AllocateButton,					RI_TrackingEvents_EditMode_Allocate, 	"RI_TrackingEvents_EditMode_Allocate",RI_TrackingEvents_EditMode_Allocate,"value");

		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Click On Add btn >> Verify New Row Added >> Save >> verify Vali. msg >> Select 'Universal' >> -----------------");
		ExecutionLog.Log("---------------verify Headers of allocated row of Second Parent Row-----------------------");
		
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_TrackingEvents_EditMode_New) ;
		verifyElementPresent(getLocator_Child_DataRow("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),	"New Row is Added" , RI_TrackEvents_EventName);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
	//TC_12
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_12");
		clickOn(getLocator_Parent_DataRow("4", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Event Group Field of Second Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_Universal_EventGroup), RI_TrackingEvents_Universal_EventGroup +" in Event Group Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		

		switchIntoFrame(frameParent3Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify the Headers of Allocated row of Second Parent Row in Edit Window");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_RowNo_Key, 		RI_TrackEvents_RowNo), 			RI_TrackEvents_RowNo, 			RI_TrackEvents_RowNo, 	RI_TrackEvents_RowNo, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), 		RI_TrackEvents_AppliesTO, 	RI_TrackEvents_AppliesTO, RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), 		RI_TrackEvents_EventName, 		RI_TrackEvents_EventName, 	RI_TrackEvents_EventName, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), 		RI_TrackEvents_EventDate, 		RI_TrackEvents_EventDate, 	RI_TrackEvents_EventDate, "innerHTML");
		verifyFieldValueOfHeader(getLocatorForChildHeader("5", RI_TrackEvents_EstimatedDate_Key,RI_TrackEvents_EstimatedDate), 	RI_TrackEvents_EstimatedDate, 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "innerHTML");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Select All >> Enter DeliveryofFirstEpisode in Prop Field -----------------");
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_AppliesTO_Key, 	RI_TrackEvents_AppliesTO), "Property Field of Allocated row of Second Parent Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
		
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName), "Tracking Event Field of Allocated row of Second Parent Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_DelivaryOfFirstEpisode), RI_TrackingEvents_DelivaryOfFirstEpisode +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EventDate_Key, 	RI_TrackEvents_EventDate), RI_TrackEvents_EventDate + " Event Date");
		sendKeys(loc_RI_ExhRights_InputField, RI_TrackingEvents_EventDate112014, RI_TrackEvents_EventDate, RI_TrackEvents_EventDate);
		clickOn(supportClickLoctor,"Support Click");
		clickOn(getLocator_Child_DataRow("5", RI_TrackEvents_EstimatedDate_Key, 	RI_TrackEvents_EstimatedDate) + "/img", RI_TrackEvents_EstimatedDate + " Check Box");
		verifyFieldValueOfHeader(getLocator_Child_DataRow("5", RI_TrackEvents_EstimatedDate_Key, 	RI_TrackEvents_EstimatedDate) + "/img", 	"Checked", 	RI_TrackEvents_EstimatedDate, RI_TrackEvents_EstimatedDate, "title");

		//TC_24
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_24");
		clickOn(getLocator_Parent_DataRow("4", RI_TrackEvents_Notes_Key, 	RI_TrackEvents_Notes) + "/img", "Note Icon of Second Row");
		switchIntoFrame(frameParent4Xpath);
		rightsIN.noteFunctionlity(RI_TrackingEvents_NoteTestData);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		WaitForModalPanel();
		
		
		//TC_36
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_36");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_TrackEvent_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(loc_AlertMessage, RI_TrackingEvents_ValMsg_Dlt_WithoutSelectRow, "Alert Message on clicking 'Delete Button'", RI_TrackingEvents_EditMode_Delete);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert Pop-Up");
//		// Select Row >> Delete >> Vali. Msg
		switchIntoFrame(frameParent3Xpath);	
		String EventNameForFirstRow_EditMode = getAttribute(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"innerHTML");
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"Child Row");
		clickOn(loc_RI_TrackEvent_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_TrackingEvents_ValMsg_Dlt_SelectRow, "Alert Message on clicking 'Delete Button'", RI_TrackingEvents_EditMode_Delete);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Exhibition Rights Edit window");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		String EventNameForFirstRow_ViewMode = getAttribute(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),"innerHTML");
		verifyFalseCondition(EventNameForFirstRow_EditMode.equals(EventNameForFirstRow_ViewMode), "First Row of TrackingEvent");
		scriptStatus();
	}
	
	/**
	 * Total Test Steps : 13
	 * @throws Exception
	 */
	@Test(priority =3,enabled= true,description = "Initial Exhibition (Calc)")
	public void TC3_InitialExhibition_Calc() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			
		changePeroperty_VerifyEventDate(RI_MediaRights_Season1, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate112014);
		changePeroperty_VerifyEventDate(RI_MediaRights_Season2, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate142014);
		scriptStatus();

	}
	
	/**
	 * Total Test Steps : 13
	 * @throws Exception
	 */
	@Test(priority =3,enabled= true,description = "Initail Exhibition of the Last Episode(Calc)")
	public void TC5_InitialExhibition_Of_LastEpisodes_Calc() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			
		changePeroperty_VerifyEventDate(RI_MediaRights_Season1, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate152014, RI_TrackingEvents_EventDate112014);
		changePeroperty_VerifyEventDate(RI_MediaRights_Season2, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate152014);
		scriptStatus();
	}
	
	/**
	 * Total Test Steps : 50
	 * In Progress(#21944, #21949) : 12
	 * @throws Exception
	 */
	@Test(priority =3,enabled= true,description = "Initail Exhibition of the Last Episode(Calc)")
	public void TC6_InitialExhibition_Of_LastEpisodes_Calc() throws Exception {
		rightsIN.selectDeal(TC6_1_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			
		changePeroperty_VerifyEventDate(Season1, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate312012, RI_TrackingEvents_EventDate112012);
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate112012, RI_TrackingEvents_EventDate212012);
		changePeroperty_VerifyEventDate(Season3, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate212012, RI_TrackingEvents_EventDate312012);

		//TC_18
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_18");
		rightsIN.searchCreatedDeal(TC6_2_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFieldValueOfHeader(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), RI_TrackingEvents_Universal_EventGroup, "Default Event Group Name", RI_TrackEvents_EventGroup, "innerHTML");

		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate212012, RI_TrackingEvents_EventDate212012);
	


		//TC_23
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_23");
		ExecutionLog.Log(color("red", "Elemental Deal:BUG 21949, 21944"));
		// Enable Below code Once #21949 and #21944 are fixed
		/*rightsIN.searchCreatedDeal(TC4_ElementalDeal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		changePeroperty_VerifyEventDate(Season1, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate312012, RI_TrackingEvents_EventDate112012);
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate112012, RI_TrackingEvents_EventDate212012);
		changePeroperty_VerifyEventDate(Season3, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate, RI_TrackingEvents_EventDate212012, RI_TrackingEvents_EventDate312012);
*/
		scriptStatus();
	}
	
	@Test(priority =7,enabled= true,description = "Initail Exhibition of the Last Episode(Calc)")
	public void TC7_InitialExhibition_Of_FirstEpisodes_Calc() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");

		changePeroperty_VerifyEventDate(TC3_SeriesAsset, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate112014);
		changePeroperty_VerifyEventDate(Season1, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate112014);
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate, RI_TrackingEvents_EventDate112014, RI_TrackingEvents_EventDate142014);
		changePeroperty_VerifyEventDate(S1_Episode102, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate, RI_TrackingEvents_EventDate142014, RI_TrackingEvents_EventDate112014);
		scriptStatus();
	}
	
	@Test(priority =8,enabled= true,description = "Initial Exhibition of First Episode of Last Season")
	public void TC8_Initial_Exhibition_of_First_Episode_of_Last_Season() throws Exception {
		rightsIN.selectDeal(TC7_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Parent Row", RI_TrackEvents_EventGroup);
		clickOn(loc_RI_Exh_AllocateButton, "Allocate Button");
		Thread.sleep(5000);
		
		switchIntoFrame(frameParent3Xpath);
		// New Row is added in the last of the all allocated row on clicking Allocate button
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, RI_TrackEvents_EventName).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_EventName);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Event Name Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason), RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason +" in Event Name Field");
		clickOn(supportClickLoctor,"Support Click");
		
		ExecutionLog.Log(color("red", "BUG : 21951"));
		// Delete Below line after fix of #21951
		String classValue_EstDate_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		clickOn(loc_FollowingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_EstDate_EditMode + "')]","Event Date of " + RI_TrackEvents_EventDate);
		//sendKeys(loc_FollowingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_EstDate_EditMode + "')]", "", RI_TrackEvents_EventDate, RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate);
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.DELETE);
        keyboard.releaseKey(Keys.DELETE);
        Thread.sleep(2000);
        clickOn(supportClickLoctor,"Support Click");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at TrackingEvents Edit window");
		WaitForModalPanel();
		
		changePeroperty_VerifyEventDate(TC7_SeriesAsset, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_9_25_2012);
		
		changePeroperty_VerifyEventDate(Season1.replace("Original Version", "Online Version"), RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_1_15_2012);
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_1_15_2012, RI_TrackingEvents_EventDate_9_25_2012);
		changePeroperty_VerifyEventDate(S1_Episode101, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_1_15_2012);
		// TearDown
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_1_15_2012, RI_TrackingEvents_EventDate_9_25_2012);

		scriptStatus();
	}
	
	@Test(priority =9,enabled= true,description = "Initial Exhibition of First Episode of Last Season")
	public void TC9_Initial_Exhibition_of_First_Episode_of_Last_Season_OnlineVersion() throws Exception {
		rightsIN.selectDeal(TC7_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		changePeroperty_VerifyEventDate(TC7_SeriesAsset, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_9_25_2012);
		changePeroperty_VerifyEventDate(Season2.replace("Original Version", "Online Version"), RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_9_25_2012);
		changePeroperty_VerifyEventDate(Season2.replace("Original Version", "All Media Version"), RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_9_25_2012, RI_TrackingEvents_EventDate_11_1_2012);
		changePeroperty_VerifyEventDate(Season1, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_11_1_2012, RI_TrackingEvents_EventDate_1_15_2012);
		// TearDown
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason, RI_TrackingEvents_EventDate_1_15_2012, RI_TrackingEvents_EventDate_9_25_2012);

		scriptStatus();
		
	}

	/**
	 * This Test Case Require for Events 
	 * 	RI_TrackingEvents_Initial_ExhibitionDate					: Default Present
		RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate		: Default Present
		RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate  	: Create in this test cases
		RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason  : Created ion Last Test Case
	 * @throws Exception
	 */
	@Test(priority =10,enabled= true,description = "Row should be create automatically in view and edit mode if you create versions for Tracking Events Initial Exhibition, Initial Exhibition of Last Episode, Initial Exhibition of First Episode and Initial Exhibition of First Episode of Last Season ")
	public void TC10_Initial_Exhibition_of_First_Episode_of_Last_Season_OnlineVersion() throws Exception {
		rightsIN.selectDeal(TC7_Deal);
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");

		ExecutionLog.Log("");
		ExecutionLog.Log("Add New row for " + RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Parent Row", RI_TrackEvents_EventGroup);
		clickOn(loc_RI_Exh_AllocateButton, "Allocate Button");
		Thread.sleep(5000);
		
		switchIntoFrame(frameParent3Xpath);
	// New Row is added in the last of the all allocated row on clicking Allocate button
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		
		clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, RI_TrackEvents_EventName).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_EventName);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Event Name Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate), RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate +" in Event Name Field");
		clickOn(supportClickLoctor,"Support Click");
		
		ExecutionLog.Log(color("red", "BUG : 21951"));
		// Delete Below line after fix of #21951
		String classValue_EstDate_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		clickOn(loc_FollowingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_EstDate_EditMode + "')]","Event Date of " + RI_TrackEvents_EventDate);
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.DELETE);
        keyboard.releaseKey(Keys.DELETE);
        Thread.sleep(2000);
        clickOn(supportClickLoctor,"Support Click");
        
        clickOn(loc_FollowingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason)+"[contains(@class,'"+ classValue_EstDate_EditMode + "')]","Event Date of " + RI_TrackEvents_EventDate);
		 keyboard.pressKey(Keys.DELETE);
        keyboard.releaseKey(Keys.DELETE);
        Thread.sleep(2000);
        clickOn(supportClickLoctor,"Support Click");
		
        
        ExecutionLog.Log("");
		ExecutionLog.Log("Selecting Season 1 for the event : Initial Exhi,Initial Exhi Of First Episode, "
				+ "Initial Exhi Of First Episode of Last Season,Initial Exhi Of Last Episode");
		
		String classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
	// RI_TrackingEvents_Initial_ExhibitionDate
		clickOn(loc_PrecedingRow.replace("@var", RI_TrackingEvents_Initial_ExhibitionDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", Season1), Season1 +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
	// RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate
		clickOn(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", Season1), Season1 +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");

	// RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate
		clickOn(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", Season1), Season1 +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");

	// RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason
		clickOn(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", Season1), Season1 +" in Property Field");
		clickOn(supportClickLoctor,"Support Click");
		
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at TrackingEvents Edit window");
		WaitForModalPanel();
		
		
		assetMaintenance.copySeasonWithDifferentVersion(TC7_SeriesAsset, S1_Episode101, "VOD Version");
		
		
		rightsIN.searchCreatedDeal(TC7_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		String classValue_AppliesTo_ViewMode ="";
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify Seasons in View Mode >> Edit ");
		classValue_AppliesTo_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		String PropertyName = Season1 + ", " +Season1.replace("Original Version", "VOD Version");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_Initial_ExhibitionDate)+"[contains(@class,'"+ classValue_AppliesTo_ViewMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_Initial_ExhibitionDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_ViewMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_ViewMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason)+"[contains(@class,'"+ classValue_AppliesTo_ViewMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason +"\"", RI_TrackEvents_AppliesTO, "innerHTML");

		
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		classValue_EstDate_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_Initial_ExhibitionDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_Initial_ExhibitionDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", 	PropertyName, 	"Applies to Field of \"" + RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason +"\"", RI_TrackEvents_AppliesTO, "innerHTML");
		scriptStatus();
	}

	@Test(priority =11,enabled= true,description = " License Start Date and License End Date (Single row )")
	public void TC11_License_Start_EndDate() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		mediaRights.enterDatainAllFields("1", All);
		
		switchIntoFrame(frameParent3Xpath);
		if(!ClientData.contains("VMN")){
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
					RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		}

		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_TrackingEvents_EventDate112013, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_TrackingEvents_EventDate112013, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_TrackingEvents_EventDate112015, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_TrackingEvents_EventDate112015, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		// TODO It was not run AND we need to run and check the status
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_LicenseFrom, RI_TrackingEvents_EventDate112013, RI_TrackingEvents_EventDate112013);
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_LicenseTo, RI_TrackingEvents_EventDate112015, RI_TrackingEvents_EventDate112015);
		scriptStatus();
		
	}
	
	@Test(priority =12,enabled= true,description = "License Start Date and License End Date (Multiple rows for same Applies To)")
	public void TC12_License_Start_EndDate() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");
		switchIntoFrame(frameParent3Xpath);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		
		mediaRights.enterDatainAllFields("2", All);		
		switchIntoFrame(frameParent3Xpath);
		if(!ClientData.contains("VMN")){
			scrollElementIntoView(getLocator_EditTAB_DataRow("2", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
					RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		}
		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), 		"Term From Field",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_TrackingEvents_EventDate112012, "Term From", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_TrackingEvents_EventDate112012, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		"Term To Field",	RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		sendKeys_WithoutClear(loc_RI_MediaRights_EditMode_InputField, RI_TrackingEvents_EventDate112017, "Term To input Field", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_ROW_NO_Key, RI_MediaRights_EditMode_ROW_NO_HeaderName), " Support Click on ROW_NO_HeaderName",RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("2", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), RI_TrackingEvents_EventDate112017, "Term From Data", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);

		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_LicenseFrom, RI_TrackingEvents_EventDate112012, RI_TrackingEvents_EventDate112012);
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_LicenseTo, RI_TrackingEvents_EventDate112017, RI_TrackingEvents_EventDate112017);
		
		scriptStatus();
		
		
	}
	
	@Test(priority =12,enabled= true,description = "License Start Date and License End Date (Single row )")
	public void TC12_PromoRights_Start_EndDate() throws Exception {
		if(!RI_TrackingEvents_PromoStartDate.contains("N/A")) {
			rightsIN.selectDeal(TC3_Deal);

			// Add row in Promo rights TAB
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);
			clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
			switchIntoFrame(frameParent3Xpath);
			promoRights.enterDatainAllFields("1", "All",RI_TrackingEvents_EventDate112013, RI_TrackingEvents_EventDate112015);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_Save, "Save button", "");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			Thread.sleep(2000);


			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_1");
			switchIntoFrame(frameParent2Xpath);scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
			clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoStartDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112013, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoEndDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112015, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

			clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");			
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoStartDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112013, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoEndDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112015, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			scriptStatus();
		} else {
			throw new SkipException("RI_TrackingEvents_PromoStartDate Event is not applicable for " + ClientData);
		}


	}
	
	@Test(priority =13,enabled= true,description = "Promo Rights Start Date and Promo Rights End Date (Multiple rows for same Applies To)")
	public void TC13_PromoRights_Start_EndDate() throws Exception {

		if(!RI_TrackingEvents_PromoStartDate.contains("N/A")) {
			rightsIN.selectDeal(TC3_Deal);

			// Add row in Promo rights TAB
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);
			clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
			switchIntoFrame(frameParent3Xpath);
			promoRights.enterDatainAllFields("2", "All",RI_TrackingEvents_EventDate112012, RI_TrackingEvents_EventDate112017);

			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_Save, "Save button", "");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			Thread.sleep(2000);


			ExecutionLog.Log("");
			switchIntoFrame(frameParent2Xpath);
			scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
			clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoStartDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112012, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoEndDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112017, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

			clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");			
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoStartDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112012, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_PromoEndDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112017, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			scriptStatus();

		} else {
			throw new SkipException(RI_TrackingEvents_PromoStartDate + " Event is not applicable for " + ClientData);
		}

	}
	
	@Test(priority =14,enabled= true,description = "Option Exercised Date and Negotiation Date (Single row )")
	public void TC14_Options_Exercised_NegotiatedDate() throws Exception {

		if(!RI_TrackingEvents_ProjectedDate.contains("N/A")) {
			rightsIN.selectDeal(TC3_Deal);
			//Option Tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);
			clickOn(Loc_NewButton, "Add Button");
			options.enterDatainAllFields("1", All,RI_TrackingEvents_EventDate112013,RI_TrackingEvents_EventDate112015);
			
			//Save 
			clickUsingJSExecutor(loc_Save, "Save");
			WaitForModalPanel();
			ExecutionLog.Log("");
			switchIntoFrame(frameParent2Xpath);
			scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
			clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ProjectedDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112013, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_NegotiatedDeadlineDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112015, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

			clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");			
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ProjectedDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112013, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_NegotiatedDeadlineDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112015, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			scriptStatus();
			
		} else {
			throw new SkipException(RI_TrackingEvents_ProjectedDate + " Event is not applicable for " + ClientData);
		}
	
	}
	
	@Test(priority =15,enabled= true,description = "Option Exercised Date and Negotiation Date (Multiple rows for same Applies To)")
	public void TC15_Options_Exercised_NegotiatedDate() throws Exception {

		if(!RI_TrackingEvents_ProjectedDate.contains("N/A")) {
			rightsIN.selectDeal(TC3_Deal);
			//Option Tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
			clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);
			clickOn(Loc_NewButton, "Add Button");
			options.enterDatainAllFields("2", All,RI_TrackingEvents_EventDate112012,RI_TrackingEvents_EventDate112017);

			//Save 
			clickUsingJSExecutor(loc_Save, "Save");
			WaitForModalPanel();
			ExecutionLog.Log("");
			switchIntoFrame(frameParent2Xpath);
			scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
			clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ProjectedDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112012, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_NegotiatedDeadlineDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_TrackingEvents_EventDate112017, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

			clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");			
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ProjectedDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112012, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_NegotiatedDeadlineDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_TrackingEvents_EventDate112017, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
			scriptStatus();
			
		} else {
			throw new SkipException(RI_TrackingEvents_ProjectedDate + " is not applicable for " + ClientData);
		}

	}
		
	// In Progress : Need to set up the Payment TAB
	@Test(priority =16,enabled= false,description = "Payment Start Date and End Dare (Single row )")
	public void TC16_PaymentStart_End_Date() throws Exception {
		throw new SkipException("Need to set up the code for Payment TAB");
	}

	// In Progress : Need to set up the Payment TAB
	@Test(priority =17,enabled= false,description = "Payment Start Date and End Date (Multiple rows for same Applies To)")
	public void TC17_PaymentStart_End_Date() throws Exception {
		throw new SkipException("Need to set up the code for Payment TAB");
	}

		
	@Test(priority =18,enabled= false,description = "Revenue Participation Start Date and End Dare (Single row )")
	public void TC18_RevenueParticipation_Start_EndDate() throws Exception {
		
		throw new SkipException("Not Applicable");
	}
	
	@Test(priority =19,enabled= false,description = "Payment Start Date and End Date (Multiple rows for same Applies To)")
	public void TC19_RevenueParticipation_Start_EndDate() throws Exception {
		throw new SkipException("Not Applicable");
	}
		
	
	@Test(priority =20,enabled= true,description = "Contract End Date ")
	public void TC20_ContractEndDate() throws Exception {
		rightsIN.selectDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ContractEndDate)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	RI_DateExecuted, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");			
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", RI_TrackingEvents_ContractEndDate)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	RI_DateExecuted, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
		scriptStatus();

	}

	
	@Test(priority =21,enabled= true,description = "Bug 34520: S14: Primary Deal: Error on calculation of Initial Exhibition event when changing from a Property where dates are null to dates which are known")
	public void TC21_InitialExhiCalculate_WithNullDates() throws Exception {
		ExecutionLog.Log("---------------Deleting the Initial Exhibition dates for Episodes 102,201 and 202---------------");
		assetMaintenance.searchCreatedAsset(TC3_SeriesAsset);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		assetMaintenance.enterInitialAirDate_EpisodeTAB("1", RI_TrackingEvents_EventDate112010);
		assetMaintenance.enterInitialAirDate_EpisodeTAB("2", "");
		assetMaintenance.enterInitialAirDate_EpisodeTAB("3", "");
		assetMaintenance.enterInitialAirDate_EpisodeTAB("4", "");


		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_Episodes_Save));
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		
		
		rightsIN.searchCreatedDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		changePeroperty_VerifyEventDate(Season1, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112010, RI_TrackingEvents_EventDate112010);
		
		
		ExecutionLog.Log("---------------Enter Date in Term Event Dialog of Media Row---------------");
		rightsIN.searchCreatedDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();


		
		ExecutionLog.Log("--------------Media Rights Row >> Enter date in duration and Execution field >> Initial Exhibition Date in Event field >> OK >> Save--------------");
		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		sendKeys(loc_RI_TermEvent_DurationInputField, "5", "duration Field", RI_TERMEvent_DurationLabel);
		sendKeys(loc_RI_TermEvent_StartEst_InputField, RI_TrackingEvents_EventDate112012, "Estimate Input Field", RI_TERMEvent_EventHeader);

		clickOn(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), "Event Name");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, RI_TERMEvent_EventHeader + "Drop Down Image",	RI_TERMEvent_DurationLabel);
		
		

		String EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season1 + " - " + RI_TrackingEvents_EventDate112010;
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", EventName), RI_TERMEvent_EventHeader ,	RI_TERMEvent_EventHeader);
		clickOn(loc_RI_TermEvent_DurationInputField, "Support click", RI_TERMEvent_DurationLabel);
		clickOn(OKButton, "OKButton");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		

		// Manual Test Step 5
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112010, "");

		rightsIN.searchCreatedDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		//scrollElementIntoView(loc_Tab.replace("@var", "Media Rights"));
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);

		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season2;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickUsingJSExecutor(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();


		// Manual Test Step 8
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_Initial_ExhibitionDate, "", RI_TrackingEvents_EventDate112010);

		rightsIN.searchCreatedDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + All + " - " + RI_TrackingEvents_EventDate112010;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();


		// Manual Test Step 11
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112010, "");

		rightsIN.searchCreatedDeal(TC3_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season2 ;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		scriptStatus();
		
		// Media Row is added in the above test cases hence disabled this step
//		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
//		WaitForModalPanel();
		// Enter the data for Row 1
//		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

		
	}
	
	@Test(priority =22,enabled= true,description = "Bug 34520: S14: Primary Deal: Error on calculation of Initial Exhibition event when changing from a Property where dates are null to dates which are known")
	public void TC22_ElementalDealInitialExhiCalculate_WithNullDates() throws Exception {
		ExecutionLog.Log("---------------Enter Date in Term Event Dialog of Media Row---------------");
		rightsIN.searchCreatedDeal(TC22_ElementalDeal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();


		// Need to select Season 1 for Initial Exhibition at Tracking Event
		ExecutionLog.Log("--------------Media Rights Row >> Enter date in duration and Execution field >> Initial Exhibition Date in Event field >> OK >> Save--------------");
		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		sendKeys(loc_RI_TermEvent_DurationInputField, "5", "duration Field", RI_TERMEvent_DurationLabel);
		sendKeys(loc_RI_TermEvent_StartEst_InputField, RI_TrackingEvents_EventDate112012, "Estimate Input Field", RI_TERMEvent_EventHeader);

		clickOn(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), "Event Name");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, RI_TERMEvent_EventHeader + "Drop Down Image",	RI_TERMEvent_DurationLabel);
		
		

		String EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season1 + " - " + RI_TrackingEvents_EventDate112010;
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", EventName), RI_TERMEvent_EventHeader ,	RI_TERMEvent_EventHeader);
		clickOn(loc_RI_TermEvent_DurationInputField, "Support click", RI_TERMEvent_DurationLabel);
		clickOn(OKButton, "OKButton");
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		

		// Manual Test Step 5
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112010, "", "Element");

		rightsIN.searchCreatedDeal(TC22_ElementalDeal);
		switchIntoFrame(frameParent2Xpath);
		//scrollElementIntoView(loc_Tab.replace("@var", "Media Rights"));
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season2;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickUsingJSExecutor(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();


		// Manual Test Step 8
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(All, RI_TrackingEvents_Initial_ExhibitionDate, "", RI_TrackingEvents_EventDate112010, "Element");

		rightsIN.searchCreatedDeal(TC22_ElementalDeal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + All + " - " + RI_TrackingEvents_EventDate112010;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();


		// Manual Test Step 11
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Tracking Events"));
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		// There is no Event Date of Initial Exhi. for Season 2
		changePeroperty_VerifyEventDate(Season2, RI_TrackingEvents_Initial_ExhibitionDate, RI_TrackingEvents_EventDate112010, "", "Element");

		rightsIN.searchCreatedDeal(TC22_ElementalDeal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		doubleClick(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		EventName = RI_TrackingEvents_Initial_ExhibitionDate + " - " + Season2 ;
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights View Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "RI_MediaRights_EditMode_"+RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName.replace("*", ""),	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(termEvent.getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), EventName, "Event Name at Media Rights Edit Mode", RI_TERMEvent_EventHeader, "title");
		clickOn(LocCancel,"Cancel button at Term Event Window");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		scriptStatus();
}
		
	
	//*****************SKY*********************
	@Test(priority =22,enabled= false,description = "UI")
	public void TC23_UI() throws Exception {
		rightsIN.searchCreatedDeal(TC1_Deal);
		
//		
		//TC_1
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_1");
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Tracking Events"), "Tracking Events TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_TrackingEvents_EditMode_New) ;
		verifyElementPresent(getLocator_Child_DataRow("5", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName),	"New Row is Added" , RI_TrackEvents_EventName);
		
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		

		//TC_7
		// Enter Evert Group
		clickOn(getLocator_Parent_DataRow("4", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup), "Event Group Field of Second Row");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TrackingEvents_Universal_EventGroup), RI_TrackingEvents_Universal_EventGroup +" in Event Group Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		
		
		
	}
	
	public void a() throws Exception{


		
		
		
	}

	
	/**
	 * 
	 * @param PropertyName
	 * @param EventName
	 * Sometimes event date at view mode is different then Edit Mode
	 * In Most cases EventDate1 may be equal to EventDate2
	 * @param EventDate1 : (View Mode)
	 * @param EventDate2 : Edit Mode
	 * @param DealType  : The "Key" of Property is changed to "RELATEDPROGRAM" for Elemental Deal. hence provide the deal name to edit the Property Field else this method will change the value of "Element" Field
	 * @throws Exception
	 */
	public void changePeroperty_VerifyEventDate(String PropertyName, String EventName, String EventDate1, String EventDate2, Object... dealType) throws Exception {
		
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify EventDate in View Mode >> Edit >>  EventDate in Edit Mode");
		
		try {

			if(dealType[0].toString().length() >0) {
				System.out.println(dealType[0].toString().length() + "\n" + dealType[0].toString());
				if(dealType[0].toString().contains("Element")) {
					classValue_AppliesTo_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_Property_ElementAsset_Key, RI_Property_ElementAsset_HeaderName));
				} else {
					classValue_AppliesTo_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
				}
			}

		} catch (Exception e) {
			classValue_AppliesTo_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		}
		
		classValue_EventDate_ViewMode = loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	EventDate1, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		try {

			if(dealType[0].toString().length() >0) {
				System.out.println(dealType[0].toString().length() + "\n" + dealType[0].toString());
				if(dealType[0].toString().contains("Element")) {
					classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_Property_ElementAsset_Key, RI_Property_ElementAsset_HeaderName));
				} else {
					classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
				}
			}

		} catch (Exception e) {
			classValue_AppliesTo_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO));
		}
		classValue_EventDate_EditMode 	= loc_FilterClassValue(getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[3]//th", RI_TrackEvents_EventDate_Key, RI_TrackEvents_EventDate));
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	EventDate1, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("Change the Property of Event Date " + EventName + "to " + PropertyName );
		ExecutionLog.Log(">> Save >> Verify EventDate and PropertyName in View mode >> Edit  >> Verify the same in Edit Mode");
		
		
		clickOn(loc_PrecedingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", RI_TrackEvents_AppliesTO);
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", PropertyName), PropertyName +" in Property Field");
		String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
		clickOn(supportClickLoctor,"Support Click");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at TrackingEvents Edit window");
		WaitForModalPanel();
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Verify EventDate in View Mode >> Edit >>  EventDate in Edit Mode >> After changing the Asset");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_AppliesTo_ViewMode + "')]", 	PropertyName, 	RI_TrackEvents_AppliesTO, RI_TrackEvents_AppliesTO, "innerHTML");
	//Event date gets changed on changing the Property
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_EventDate_ViewMode + "')]", 	EventDate2, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
		// verify the data in edit mode
		clickUsingJSExecutor("name="+loc_RI_TrackEventEdit_Btn, "'Edit' Button at TrackingEvents TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_PrecedingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_AppliesTo_EditMode + "')]", 	PropertyName, 	RI_TrackEvents_AppliesTO, RI_TrackEvents_AppliesTO, "innerHTML");
		verifyFieldValueOfHeader(loc_FollowingRow.replace("@var", EventName)+"[contains(@class,'"+ classValue_EventDate_EditMode + "')]", 	EventDate2, 	RI_TrackEvents_EventDate, RI_TrackEvents_EventDate, "innerHTML");
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at TrackingEvents Edit window");

	}
	

	/**
	 * returns the header locator for allocated row 
	 * This method is being only used for verifying the headers of Allocated row
	 * rowNumber >> 3,5,7....
	 */
	public String getLocatorForChildHeader(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel) {
		
		return loc_RI_TrackEvent_Child_HeaderRow + "[" + rowNumber +"]//th"+"[@key='"+KeyValueFromExcel+"']";
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
		String classValue = getClassValueParent(loc_RI_TrackEvent_ParentRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		locator = loc_RI_TrackEvent_Child_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";

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
		String classValue = getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[" + rowNumber +"]//th", KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_RI_TrackEvent_Child_DataRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		
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
		String classValue = getClassValueChild(loc_RI_TrackEvent_Child_HeaderRow+ "[" + rowNumber +"]//th", KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_RI_TrackEvent_Child_DataRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";

		
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

	public void addEvents(String EventName) throws Exception {
		if(!EventName.contains("N/A")) {
			switchIntoFrame(frameParent3Xpath);
			// Add Promotional rights Row
			String supportClickLoctor = getLocator_Parent_DataRow("2", RI_TrackEvents_EventGroup_Key, 	RI_TrackEvents_EventGroup);
			clickOn(supportClickLoctor, "Select Parent Row");

			clickOn(loc_RI_Exh_AllocateButton, "Allocate Button");
			Thread.sleep(5000);

			switchIntoFrame(frameParent3Xpath);
			// New Row is added in the last of the all allocated row on clicking Allocate button
			clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_AppliesTO);
			//clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_AppliesTO_Key, RI_TrackEvents_AppliesTO, "1"), RI_TrackEvents_AppliesTO);
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Property Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", All), All +" in Property Field");
			clickOn(supportClickLoctor,"Support Click");

			clickOn(getLocator_Child_DataRow("3", RI_TrackEvents_EventName_Key, RI_TrackEvents_EventName).replace("tr[@role='row']", "tr[@role='row'][last()]"), RI_TrackEvents_EventName);

			//clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_TrackEvents_EventName_Key, 	RI_TrackEvents_EventName, "1"), "Tracking Event Field of Allocated row of Parent Row");
			clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "EventGroup Drop Down");
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", EventName), EventName +" in Event Name Field");
			clickOn(supportClickLoctor,"Support Click");
		}

	}

}

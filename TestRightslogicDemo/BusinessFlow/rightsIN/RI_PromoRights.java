package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_PromoRights extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();
	public RI_PromoRights() {
		super(loc_RI_PromoRights_ColumnXpath_EditMode, loc_RI_PromoRights_DataRowXpath_EditMode, 
				loc_RI_PromoRights_ColumnXpath_ViewMode, loc_RI_PromoRights_DataRowXpath_ViewMode);
		className = this.getClass().getName();
		classObject = this.getClass();
	}
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle01 = "AUT_AssetSeries01_" +formattedDate+"";
	String CreatedDeal01 = "AUT_Deal01_" +formattedDate+"";
	

	String CreatedSeriesAssetTitle02 = "AUT_AssetSeries02_" +formattedDate+"";
	String CreatedDeal02 = "AUT_Deal02_" +formattedDate+"";
	
	@Test(priority =1,enabled= true,description = "This test case covers the Promo Rights tab >UI")
	public void TC1_PromoRightsUI() throws Exception {
		System.out.println("*********************Start Testcase - TC1_PromoRightsUI *********************");
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle01,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle01);
		rightIN.createDeal(CreatedDeal01);
		rightIN.associateAssetWithDeal(CreatedDeal01, CreatedSeriesAssetTitle01);
		
		//Promo Rights
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//TC_RI_PR_02
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_PR_02");
		verifyTextMatches(Loc_EditButton2, "Edit Button View Mode", RI_PromoRightsEditButtons,"value");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsAppliesToKey +"']", RI_PromoRightsAppliesTo.replace("*", ""), "Applies To  Field", RI_PromoRightsAppliesTo, "innerHTML");
		verifyElementPresent(Loc_RI_PromoRightsShowAllRows, "Show All Rows Check Box");
		verifyTextMatches(Loc_RI_PromoRightsSendReminder, "Send Reminder", RI_PromoRightsSendReminder,"alt");
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		//TC_RI_PR_03
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_PR_03");
		
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsAppliesToKey +"']", RI_PromoRightsAppliesTo, "Applies To  Field", RI_PromoRightsAppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsMediaKey +"']", RI_PromoRightsMedia, "Media Field", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsTerritoryKey +"']", RI_PromoRightsTerritory, "Business Terms  Field", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsPromoRightsKey +"']", RI_PromoRightsPromoRights, " Promo Rights Field", RI_PromoRightsPromoRights);
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsUnlimitedUseKey +"']", RI_PromoRightsUnlimitedUse, "UnlimitedUse  Field", RI_PromoRightsUnlimitedUse, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsUseOutsideProgramKey +"']", RI_PromoRightsUseOutsideProgram, "Use Outside Program  Field", RI_PromoRightsUseOutsideProgram, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsPerpetuityKey +"']", RI_PromoRightsPerpetuity, "Perpetuity Field", RI_PromoRightsPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsStartDateKey +"']", RI_PromoRightsStartDate, "Start Date Field", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsEndDateKey +"']", RI_PromoRightsEndDate, "EndDate  Field", RI_PromoRightsEndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsToPromoteKey +"']", RI_PromoRightsToPromote, "To Promote Field", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsOutletsKey +"']", RI_PromoRightsOutlets, "Outlets Field", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsVenueKey +"']", RI_PromoRightsVenue, "Venue Field", RI_PromoRightsVenue, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsAggregateKey +"']", RI_PromoRightsAggregate, "Aggregate Field", RI_PromoRightsAggregate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsStartTimeCodeKey +"']", RI_PromoRightsStartTimeCode, "Start Time Code Field", RI_PromoRightsStartTimeCode, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsEndTimeCodeKey +"']", RI_PromoRightsEndTimeCode, "End Time Code Field", RI_PromoRightsEndTimeCode, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_PromoRightsNotesKey +"']", RI_PromoRightsNotes, "Notes Field", RI_PromoRightsNotes, "innerHTML");
		
		verifyTextMatches(loc_Copy, "Copy Button View Mode", RI_PromoRightsCopyRow,"value");
		verifyTextMatches(Loc_NewButton, "Add Button View Mode", RI_PromoRightsAdd,"value");
		verifyTextMatches(loc_Delete, "Delete Button View Mode", RI_PromoRightsDelete,"value");
		verifyTextMatches(loc_Save, "Save Button View Mode", RI_PromoRightsSave,"value");
		verifyTextMatches(loc_Cancel, "Cancel Button View Mode", RI_PromoRightsCancel,"value");

		//Add
		//TC_RI_PR_05
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_PR_05");
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRights1Row, "Promo Rights Rights 1 Row", "");
		//Save
		//TC_RI_PR_06
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_PR_06");
		clickUsingJSExecutor(loc_Save, "Save button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsErrorMgs);
		//Applies To
		//TC_RI_PR_07
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "Applies To 1 Row ",RI_PromoRightsAppliesTo);
		sendKeys(Loc_RI_PromoRightsAppliesToInput, RI_PromoRightsAppliesToData, "Applies To input", RI_PromoRightsAppliesTo);
		Thread.sleep(2000);
		//Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToImgKey, RI_PromoRightsAppliesTo)+"/img", "Applies To Img 1 Row ",RI_PromoRightsAppliesTo);
		rightIN.appliesTOPopUpWindow("TC_RI_PR_07 To TC_RI_PR_21 ", CreatedSeriesAssetTitle01);
		switchIntoFrame(frameParent3Xpath);
		//Save
		//TC_RI_PR_21
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_PR_21");
		clickUsingJSExecutor(loc_Save, "Save button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsErrorMgs);
		
		//Promo Rights
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), "Promo Rights 1 Row ",RI_PromoRightsPromoRights);
		sendKeys(Loc_RI_PromoRightsInput, RI_PromoRightsData, "promo Rights Input", RI_PromoRightsPromoRights);
		
		//pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsPromoRightsImgKey, RI_PromoRightsPromoRights)+"/img", "Promo Rights Img 1 Row ",RI_PromoRightsPromoRights);
		rightIN.functionalityOfPopUpWindow("TC_RI_PR_28 To TC_RI_PR_37", RI_PromoRightsPromoRights, "N/A");
		switchIntoFrame(frameParent3Xpath);
		
		//To Promote
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), "To Promote 1 Row ",RI_PromoRightsToPromote);
		sendKeys(Loc_RI_PromoRightsToPromoteInput, RI_PromoRightsToPromoteData, "To Promote Input", RI_PromoRightsToPromote);
		 
		//Pick List 
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsToPromoteImgKey, RI_PromoRightsToPromote), "To Promote Img 1 Row ",RI_PromoRightsToPromote);
		switchIntoFrame(frameParent4Xpath,RI_PromoRightsToPromote);

        //Media Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsMediaKey, RI_PromoRightsMedia), "Media 1 Row ",RI_PromoRightsMedia);
		sendKeys(Loc_RI_PromoRightsMediaInput, RI_PromoRightsMediaData, "Media Input", RI_PromoRightsMedia);
		 
		Thread.sleep(3000);
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsMediaImgKey, RI_PromoRightsMedia)+"/img", "Media 1 Row ",RI_PromoRightsMedia);
		rightIN.functionalityOfPopUpWindow("TC_RI_PR_34 To TC_RI_PR_45", RI_PromoRightsMedia, "N/A");
		switchIntoFrame(frameParent3Xpath);
		
		//Territory
		//TC_RI_PR_46
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), "Territory 1 Row ",RI_PromoRightsTerritory);
		sendKeys(Loc_RI_PromoRightsTerritoryinput, RI_PromoRightsTerritoryData, "Territory Input", RI_PromoRightsTerritory);
		 
		Thread.sleep(3000);
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsTerritoryImgKey, RI_PromoRightsTerritory)+"/img", "Territory 1 Row ",RI_PromoRightsTerritory);
		rightIN.functionalityOfPopUpWindow("TC_RI_PR_46 To TC_RI_PR_57", RI_PromoRightsTerritory, "N/A");
		switchIntoFrame(frameParent3Xpath,RI_PromoRightsTerritory);
		//Venue
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsVenueKey, RI_PromoRightsVenue), "Venue 1 Row ",RI_PromoRightsVenue);
		sendKeys(RI_PromoRightsVenueInput, RI_PromoRightsVenueData, "Venue Input", RI_PromoRightsVenue);
		 
		//Outlets
		if(!RI_PromoRightsOutlets.contains("N/A")){
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), "Outlets 1 Row ",RI_PromoRightsOutlets);
		sendKeys(RI_PromoRightsOutletsInput, RI_PromoRightsOutletsData, "Outlets Input", RI_PromoRightsOutlets);
		 
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsToOutletsImgKey, RI_PromoRightsOutlets)+"/img", "Outlets 1 Row ",RI_PromoRightsOutlets);
		rightIN.functionalityOfPopUpWindow("", RI_PromoRightsOutlets, "N/A");
		switchIntoFrame(frameParent3Xpath,RI_PromoRightsOutlets);
		}
		//Unlimited Use
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_PromoRightsUnlimitedUseKey, RI_PromoRightsUnlimitedUse), RI_PromoRightsUnlimitedUse);
		//Use Outside Program
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_PromoRightsUseOutsideProgramKey, RI_PromoRightsUseOutsideProgram), RI_PromoRightsUseOutsideProgram);
		//Perpetuity
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsPerpetuityKey, RI_PromoRightsPerpetuity)+"/img", "Outlets 1 Row ",RI_PromoRightsPerpetuity);
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "After clicking Perpetuity Check Box ", RI_PromoRightsEndDateData1,"title");
		
		//Start Date
		if(ClientName.contains("VMN")){
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
		sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
		sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
		}else
		{
			clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
			sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
		}
		//End Date
		if(ClientName.contains("VMN")){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
			sendKeys(RI_PromoRightsEndDateInput, RI_PromoRightsEndDateData2, "End Date Input", RI_PromoRightsEndDate);
		}else{
			clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
			sendKeys(RI_PromoRightsEndDateInput, RI_PromoRightsEndDateData2, "End Date Input", RI_PromoRightsEndDate);
		}
		//support
		clickUsingJSExecutor(Loc_RI_PromoRights1Row, "Support");
		 
		//Save
		//TC_RI_PR_67
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_PR_67]");
		clickUsingJSExecutor(loc_Save, "Save button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsEndDateSatarDateErrorMgs);
		//Start Date
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
		sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
		
		
		//End Date
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
		sendKeys(RI_PromoRightsEndDateInput, RI_PromoRightsEndDateData3, "End Date Input", RI_PromoRightsEndDate);
		
		
		if(ClientName.contains("VMN")){
			scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_PromoRightsNotesKey, RI_PromoRightsNotes));
			//Step - 1
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 1");
			clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			Thread.sleep(1000);
			sendKeys_WithoutClear(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			Thread.sleep(1000);
			if(Browser.contains("ie")){
				//Extra steps only for IE Browser 
				clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
				Thread.sleep(1000);
				sendKeys_WithoutClear(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			}
			//Support
			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsEnterBothStartAndEndTimes);

			//Step - 2
			//Maximum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 2");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsEndTimeCode);
			sendKeys_WithoutClear(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData, "Maximum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support
			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightslaterThanStartTimeCode);

			//Step - 3
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 3");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			sendKeys_WithoutClear(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData1, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			//Maximum (hh:mm:ss)
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsEndTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData1, "Minimum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);

			//Step - 4
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 4");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData2, "Minimum Data input", RI_PromoRightsStartTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);

			//Step - 5
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 5");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData3, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);


			//Step - 6
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 6");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			//Maximum (hh:mm:ss)
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Maximum (hh:mm:ss) Row 1",RI_PromoRightsEndTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData2, "Maximum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);

			//Step - 7
			//Maximum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 7");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsEndTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData3, "Minimum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);

			//Step - 8
			//Maximum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 8");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsEndTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData4, "Minimum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support

			clickOn(Loc_RI_PromoRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_PromoRightsTimeCodeExceedsTheMaximum);

			//Step - 9
			//Minimum (hh:mm:ss)
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 9");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), "Minimum (hh:mm:ss) Row 1",RI_PromoRightsStartTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightStartTimeCodeData, "Minimum (hh:mm:ss) Date input", RI_PromoRightsStartTimeCode);
			//Maximum (hh:mm:ss)
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), "Start Time Code Row 1",RI_PromoRightsEndTimeCode);
			sendKeys(RI_PromoRightsMinimumAndMaximum, RI_PromoRightEndTimeCodeData1, "Minimum (hh:mm:ss) Date input", RI_PromoRightsEndTimeCode);
			//Support
			clickOn(Loc_RI_PromoRights1Row, "Support", "");
		}
		//Notes
		//TC_RI_PR_70
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_PR_70]");
		switchIntoFrame(frameParent3Xpath,	RI_PromoRightsNotes);
		//clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsNotesKey, RI_PromoRightsNotes) + "/img", "Promo Rights Notes",RI_PromoRightsNotes);


		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		System.out.println("*********************End Testcase - TC1_PromoRightsUI *********************");
	}
	
	@Test(priority =2,enabled= true,description = "To verify behavior of fields in Rights Out- Promo Rights Tab - In view")
	public void TC2_PromoRightsViewMode() throws Exception {
		System.out.println("*********************Start Testcase - TC2_PromoRightsViewMode *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal01);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
 
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData1, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData1, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsStartTimeCodeKey, RI_PromoRightsStartTimeCode), RI_PromoRightStartTimeCodeData, "View Mode Start Time Code", RI_PromoRightsStartTimeCode, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsEndTimeCodeKey, RI_PromoRightsEndTimeCode), RI_PromoRightEndTimeCodeData1, "View Mode End Time Code", RI_PromoRightsEndTimeCode, "innerHTML");
		
		System.out.println("*********************End Testcase - TC2_PromoRightsViewMode *********************");

	}
	
	@Test(priority =3,enabled= true,description = "All Promotion Rights checkbox")
	public void TC3_PromoRightsAllcheckbox() throws Exception {
		if(!ClientData.equals("SKY")) {
		System.out.println("*********************Start Testcase - TC3_PromoRightsAllcheckbox *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal01);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_001.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_001");

		clickOn(RI_PromoRightsAllPromotionRightsCheckBox, "AllPromotionRights Check Box Checked");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", RI_PromoRightsAllPromotionRightsConf);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		WaitForElementPresent(loc_Save);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data Verify", RI_PromoRightsAppliesToData);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), "Promo Rights Data Verify", RI_PromoRightsData1);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsMediaKey, RI_PromoRightsMedia), "Media Data Verify", RI_PromoRightsMediaData1);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), "Territory Data Verify", RI_PromoRightsTerritoryData1);
		//To Promote
		clickUsingJSExecutor(Loc_RI_PromoRights1Row, "");
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), "To Promote 1 Row ",RI_PromoRightsToPromote);
		sendKeys(Loc_RI_PromoRightsToPromoteInput, RI_PromoRightsToPromoteData, "To Promote Input", RI_PromoRightsToPromote);
		clickUsingJSExecutor(Loc_RI_PromoRights1Row, "");
		//Save
		//TC_RI_PR_004.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_004");
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		verifyElementPresent(RI_PromoRightsAllPromotionRightsCheckBoxViewMode, "All Promotion Rights CheckBox ViewM ode");

		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_008.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_008");

		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsUnlimitedUseKey, RI_PromoRightsUnlimitedUse)+"/img","Unlimited Use 1 Row Checked",RI_PromoRightsUnlimitedUse);
		//Perpetuity
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsPerpetuityKey, RI_PromoRightsPerpetuity)+"/img", "Outlets 1 Row ",RI_PromoRightsPerpetuity);
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "After clicking Perpetuity Check Box ", RI_PromoRightsEndDateData1,"title");
		//Save
		//TC_RI_PR_009.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_009");
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		verifyElementNotPresent(RI_PromoRightsAllPromotionRightsCheckBoxViewMode, "All Promotion Rights CheckBox ViewM ode");
		System.out.println("*********************End Testcase - TC3_PromoRightsAllcheckbox *********************");
	}
	else{
		throw new SkipException("Script of \"Promo Rights Allcheckbox\" is Not Applicable for "+ ClientData);
	}
	}
	@Test(priority =4,enabled= true,description = "No Promo Rights checkbox")
	public void TC4_NoPromoRightscheckbox() throws Exception {
		if(!ClientData.equals("SKY")) {
		System.out.println("*********************Start Testcase - TC4_NoPromoRightscheckbox *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal01);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_001
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_001");
		
		clickOn(RI_PromoRightsNoPromotionRightsCheckBox, "No PromotionRights Check Box Checked");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", RI_PromoRightsNoPromotionRightsConf);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		WaitForElementPresent(loc_Save);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data Verify", RI_PromoRightsAppliesToData);
		verifyTextMatches(loc_Copy, "Copy Button View Mode", "true","disabled");
		verifyTextMatches(Loc_NewButton, "Add Button View Mode", "true","disabled");
		verifyTextMatches(loc_Delete, "Delete Button View Mode", "true","disabled");
		
		//Save
		//TC_RI_PR_004.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_004");
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		verifyElementPresent(RI_PromoRightsNoPromotionRightsCheckBoxViewMode, "All Promotion Rights CheckBox ViewM ode");
		
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_008.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_008");
		
		clickOn(getLocator_EditTAB_DataRow("1", RI_PromoRightsUnlimitedUseKey, RI_PromoRightsUnlimitedUse)+"/img","Unlimited Use 1 Row Checked",RI_PromoRightsUnlimitedUse);
		verifyTextMatches(RI_PromoRightsNoPromotionRightsCheckBox, "checked No Promotion Rights CheckBox ", "true", "checked");
		//Save
		//TC_RI_PR_009
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_009");
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		verifyElementPresent(RI_PromoRightsNoPromotionRightsCheckBoxViewMode, "No Promotion Rights CheckBox ViewM ode");
		System.out.println("*********************End Testcase - TC4_NoPromoRightscheckbox *********************");
	}
		else{
			throw new SkipException("Script of \"Promo Rights Allcheckbox\" is Not Applicable for "+ ClientData);
		}
	}
	
	@Test(priority =5,enabled= true,description = "Create multiple rows with different Applies To")
	public void TC5_PromoRightsMultipleRows() throws Exception {
		System.out.println("*********************Start Testcase - TC5_PromoRightsMultipleRows *********************");
		//New Asset and deal for Create multiple rows with different Applies To 
		
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle02,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle02);
		rightIN.createDeal(CreatedDeal02);
		rightIN.associateAssetWithDeal(CreatedDeal02, CreatedSeriesAssetTitle02);
		
		//Promo Rights
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_001.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_001");
		//1st
		//Add
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRightsRow.replace("@var", "1"), "Promo Rights 1 Row", "");
		enterDatainAllFields("1", "All");
		//Add
		//2nd
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRightsRow.replace("@var", "2"), "Promo Rights 2 Row", "");
		enterDatainAllFields("2", CreatedSeriesAssetTitle02);
		//Add
		//3rd
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRightsRow.replace("@var", "3"), "Promo Rights 3 Row", "");
		enterDatainAllFields("3", RI_PromoRightsSeason1);
		//Add
		//4th
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRightsRow.replace("@var", "4"), "Promo Rights 4 Row", "");
		enterDatainAllFields("4", RI_PromoRightsEpisode101);
		//Add
		//5th
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_RI_PromoRightsRow.replace("@var", "5"), "Promo Rights 5 Row", "");
		clickOn(getLocator_EditTAB_DataRow("5", RI_PromoRightsAppliesToImgKey, RI_PromoRightsAppliesTo)+"/img", "Applies To Pick List 5 Row ",RI_PromoRightsAppliesTo);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(Loc_ApplyButton1);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "Episode101", RI_PromoRightsAppliesTo);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode201), "Episode201", RI_PromoRightsAppliesTo);
		Thread.sleep(2000);
		
		clickUsingJSExecutor(Loc_ApplyButton1, "Apply Button", RI_PromoRightsAppliesTo);
		enterDatainAllFields("5", "N/A");
		Enter();
		Thread.sleep(2000);
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
	
		//View Mode
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
		
		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
	
		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
		
		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsPromoRightsKey, RI_PromoRightsPromoRights), RI_PromoRightsData, "View Mode Promo Rights", RI_PromoRightsPromoRights, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsToPromoteKey, RI_PromoRightsToPromote), RI_PromoRightsToPromoteData, "View Mode ToPromote", RI_PromoRightsToPromote, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsMediaKey, RI_PromoRightsMedia), RI_PromoRightsMediaData, "View Mode Media Rights", RI_PromoRightsMedia, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsOutletsKey, RI_PromoRightsOutlets), RI_PromoRightsOutletsData, "View Mode Outlets", RI_PromoRightsOutlets, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsTerritoryKey, RI_PromoRightsTerritory), RI_PromoRightsTerritoryData, "View Mode Territory", RI_PromoRightsTerritory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), RI_PromoRightsStartDateData1, "View Mode Start Date ", RI_PromoRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), RI_PromoRightsEndDateData3, "View Mode End Date ", RI_PromoRightsEndDate, "innerHTML");
		
		System.out.println("*********************End Testcase - TC5_PromoRightsMultipleRows *********************");
	}
		
	@Test(priority =6,enabled= true,description = "Copy Row(s) Functionality")
	public void TC6_PromoRightsCopyRow() throws Exception {
		System.out.println("*********************Start Testcase - TC6_PromoRightsCopyRow *********************");
		 //Search Deal
		rightIN.searchCreatedDeal(CreatedDeal02);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//TC_RI_PR_002.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_002");
		clickUsingJSExecutor(loc_Copy, "Copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_PromoRightsCopyWithoutselectingRow);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		WaitForElementPresent(loc_Save);
		clickOn(Loc_RI_PromoRightsRow.replace("@var", "1"), "Select 1 Row");
		clickUsingJSExecutor(loc_Copy, "Copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(PromptAlertValidationMessgeText, "Copy No Row Msg", RI_PromoRightsCopRowMsg);
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_PromoRightsCopRowMsg1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		sendKeys(loc_PromptBoxInput, RI_PromoRightsCopyData1, "Copy Number Row","");
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_PromoRightsCopRowMsg1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		sendKeys(loc_PromptBoxInput, RI_PromoRightsCopyData2, "Copy Number Row","");
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "1"), "Row 1");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "2"), "Row 2");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "3"), "Row 3");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "4"), "Row 4");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "5"), "Row 5");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "6"), "Row 6");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "7"), "Row 7");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "8"), "Row 8");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "9"), "Row 9");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "10"), "Row 10");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "11"), "Row 11");
		
		//Edit Mode verify AppliesTo field
		
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("3", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("4", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("5", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("6", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("7", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("8", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("9", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("10", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("11", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "1"), "Row 1");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "2"), "Row 2");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "3"), "Row 3");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "4"), "Row 4");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "5"), "Row 5");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "6"), "Row 6");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "7"), "Row 7");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "8"), "Row 8");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "9"), "Row 9");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "10"), "Row 10");
		verifyElementPresent(Loc_RI_PromoRightsRow.replace("@var", "11"), "Row 11");
		
		//Edit Mode verify AppliesTo field after Save 

		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("3", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("4", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("5", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("6", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("7", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("8", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("9", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("10", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		verifyTextMatches(getLocator_EditTAB_DataRow("11", RI_PromoRightsAppliesToKey, RI_PromoRightsAppliesTo), "AppliesTo Data For 1st Row",RI_PromoRightsAppliesToData );
		
		System.out.println("*********************End Testcase - TC6_PromoRightsCopyRow *********************");
	}
	
	@Test(priority =7,enabled= true,description = "Delete Functionality")
	public void TC7_PromoRightsDelete() throws Exception {
		System.out.println("*********************Start Testcase - TC7_PromoRightsDelete *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal02);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Promo Rights"), "Promo Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
	
		
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_PromoRightsDeleteAlertMsg, "Alert Message do not select the row and click Delete",RI_PromoRightsDeleteAlertMsg);
		
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath");
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
	    clickOn(Loc_RI_PromoRightsRow.replace("@var", "1"), "First row"); 
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_PromoRightsDeleteConfMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_PromoRightsDeleteConfMsg);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_PromoRightsDeleteConfMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_PromoRightsDeleteConfMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath );
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button  Edit window", RI_MediaRights_EditMode_closeButton);
		
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(Loc_EditButtonCommon));
		if(Browser.contains("firefox")){
			clickUsingJSExecutor(Loc_EditButtonCommon, "'Edit' Button");
		}else{
			clickOn(Loc_EditButtonCommon, "'Edit' Button");
		}
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_RI_PromoRightsRow.replace("@var", "1"), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_PromoRightsDeleteConfMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_PromoRightsDeleteConfMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		
		System.out.println("*********************End Testcase - TC7_PromoRightsDelete *********************");
	}
	

	public void enterDatainAllFields(String rowNumber, String AssetName, Object... StartDate_EndDate_DealType) throws Exception { 
		switchIntoFrame(frameParent3Xpath);
		if(!rowNumber.contains("5")){
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsAppliesTo,AssetName,RI_PromoRightsAppliesToKey); 
		}
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsMedia,RI_PromoRightsMediaData,RI_PromoRightsMediaKey); 
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsPromoRights,RI_PromoRightsData,RI_PromoRightsPromoRightsKey);
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsToPromote,RI_PromoRightsToPromoteData,RI_PromoRightsToPromoteKey);
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsTerritory,RI_PromoRightsTerritoryData,RI_PromoRightsTerritoryKey); 
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsOutlets,RI_PromoRightsOutletsData,RI_PromoRightsOutletsKey); 
		enterDataInFieldEditMode(rowNumber, RI_PromoRightsVenue,RI_PromoRightsVenueData,RI_PromoRightsVenueKey);
		try {
			if(StartDate_EndDate_DealType[0].toString().length() > 0) {
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
				sendKeys(RI_PromoRightsStartDateInput, StartDate_EndDate_DealType[0].toString(), "Promo Rights Start Date Input", RI_PromoRightsStartDate);
			} else {
				// If the provided data's length is zero
				ExecutionLog.Log(color("red", "forgot to give the \"START Date\" in Test Data Repository"));
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
				sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
				 
			}
			if(StartDate_EndDate_DealType[1].toString().length() > 0) {
				scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate));
				//End Date
				ExecutionLog.Log(color("red", "forgot to give the \"END Date\" in Test Data Repository"));
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
				sendKeys(RI_PromoRightsEndDateInput, StartDate_EndDate_DealType[1].toString(), "Promo Rights End Date Input", RI_PromoRightsEndDate);
			} else {
				scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate));
				//End Date
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
				sendKeys(RI_PromoRightsEndDateInput, RI_PromoRightsEndDateData3, "End Date Input", RI_PromoRightsEndDate);
				
			}
			
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
            keyboard.pressKey(Keys.TAB);
            keyboard.releaseKey(Keys.TAB);
            Thread.sleep(2000);
		} catch (Exception e) {
			//Start Date
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
			sendKeys(RI_PromoRightsStartDateInput, RI_PromoRightsStartDateData1, "Start Date Input", RI_PromoRightsStartDate);
			 
			scrollElementIntoView(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate));
			//End Date
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsEndDateKey, RI_PromoRightsEndDate), "End Date 1 Row ",RI_PromoRightsEndDate);
			sendKeys(RI_PromoRightsEndDateInput, RI_PromoRightsEndDateData3, "End Date Input", RI_PromoRightsEndDate);
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_PromoRightsStartDateKey, RI_PromoRightsStartDate), "Start Date 1 Row ",RI_PromoRightsStartDate);
			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
            keyboard.pressKey(Keys.TAB);
            keyboard.releaseKey(Keys.TAB);
            Thread.sleep(2000);
		}
		
		
		 
	}
		
	public void enterDataInFieldEditMode(String rowNumber, String HeaderName, String DropDownValue, String HeaderKey) throws Exception {
		if(!HeaderName.contains("N/A")) {
			switchIntoFrame(frameParent3Xpath,HeaderName);
			
			Thread.sleep(1000);
			doubleClick(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), "RI_PromoRights_EditMode_"+HeaderName.replace("*", ""),	HeaderName);
			clickOn(loc_RI_EditMode_DropDownImage, HeaderName + "Drop Down Image",	HeaderName);
			clickOn(loc_RI_EditMode_DropDownValues.replace("@var", DropDownValue), DropDownValue ,	HeaderName); 
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath, HeaderName);
		
			clickOn(Loc_RI_PromoRights1Row, " Support Click on ROW_NO_HeaderName",HeaderName);

			// 
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow(rowNumber, HeaderKey, HeaderName), 	DropDownValue, "RI_PromoRights_EditMode_" + HeaderName,		HeaderName, 	"innerHTML");

		}
	
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
		String classValue = getClassValue(loc_RI_PromoRights_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_PromoRights_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_PromoRights_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}

	/**
	 * Applies TO's Assets row: Starts from 0th Row
	 * rowNumber_Asset > =1,2,3
	 * 
	 * The Data of the respective Asset starts from 2nd Row	
	 * rowNumber_Data > =2,3,4
	 *  
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_ViewTAB_DataRow(String rowNumber_Asset, String rowNumber_Data, String KeyValueFromExcel, String HeadeNameFromExcel){
		String classValue = getClassValue(loc_RI_PromoRights_ColumnXpath_ViewMode.replace("@var", rowNumber_Asset), KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_PromoRights_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_PromoRights_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
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
	
	
	
}
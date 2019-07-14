package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_EditingRights extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
    String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
    String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
	

	// Edit Mode Data row starts from 1
	// View Mode Data row starts as 1, 3 5 etc.
	public RI_EditingRights() {
		super(RI_EditingRightsColumnXpath_EditMode, RI_EditingRightsDataRowXpath_EditMode, RI_EditingRightsColumnXpath_ViewMode, RI_EditingRightsDataRowXpath_ViewMode);
		className = this.getClass().getName();
		classObject = this.getClass();
	}
		
	@Test(priority =1,enabled= true,description = "This test case covers the Editing Rights tab >UI")
	public void TC1_EditingRightsUI() throws Exception {
		
		
		ExecutionLog.Log("*********************Start Testcase - TC1_EditingRightsUI *********************");
    	assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightsIN.createDeal(CreatedDeal1, "Standalone Agreement", "Non-Primary Service Agreement");
		rightsIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		
		
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		//View Mode
		//TC_RI_ER_02
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_02");
		ExecutionLog.Log("**********The below are columns and buttons in the window************");
		ExecutionLog.Log("Columns");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsApplesTo_Key +"']", RI_EditingRightsApplesTo.replace("*", ""), "ApplesTo Field", RI_EditingRightsApplesTo, "innerHTML");
		ExecutionLog.Log("Button");
		verifyTextMatches(Loc_EditButton, "Edit Button", RI_EditingRightsEditButton,"Value");
		verifyTextMatches(Loc_EditingRightsSendReminder, "Send Reminder", RI_EditingRightsSendReminder,"title");
		//Edit Mode
		//TC_RI_ER_03
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_03");
		ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Editing Rights TAB*****"); 
		clickUsingJSExecutor(Loc_EditButton, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsApplesTo_Key +"']", RI_EditingRightsApplesTo, "ApplesTo Field", RI_EditingRightsApplesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRights1_key +"']", RI_EditingRights1, "EditingRights Field", RI_EditingRights1, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsInProgramUse_Key +"']", RI_EditingRightsInProgramUse, "In Program Use Field", RI_EditingRightsInProgramUse, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsContext_key +"']", RI_EditingRightsContext, "Context Field", RI_EditingRightsContext, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsPerpetuity_Key +"']", RI_EditingRightsPerpetuity, "Perpetuity Field", RI_EditingRightsPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsStartDate_Key +"']", RI_EditingRightsStartDate, "Start Date Field", RI_EditingRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsEndDate_Key +"']", RI_EditingRightsEndDate, "End Date Field", RI_EditingRightsEndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsTimeLimitation_key +"']", RI_EditingRightsTimeLimitation, "Time Limitation Field", RI_EditingRightsTimeLimitation, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsStartTimeCode_Key +"']", RI_EditingRightsStartTimeCode, "Start Date Field", RI_EditingRightsStartTimeCode, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsEndTimeCode_Key +"']", RI_EditingRightsEndTimeCode, "End Date Field", RI_EditingRightsEndTimeCode, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsNotes_Key +"']", RI_EditingRightsNotes, "Note Field", RI_EditingRightsNotes, "innerHTML");
		//Button
		verifyTextMatches(loc_Copy, "Copy",RI_EditingRightCopy,"Value");
		verifyTextMatches(Loc_NewButton, "Add",RI_EditingRightsAdd,"Value");
		verifyTextMatches(loc_Delete, "Delete",RI_EditingRightDelete,"Value");
		verifyTextMatches(loc_Save, "Ok",RI_EditingRightSave,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",RI_EditingRightCancel,"Value");
		
		verifyTextMatches(Loc_AllEditingRights, "All Editing Rights", RI_AllEditingRights);
		verifyTextMatches(Loc_NoEditingRights, "No Editing Rights", RI_NoEditingRights);
		//Add
		//TC_RI_ER_05
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_05");
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		switchIntoFrame(frameParent3Xpath);
		verifyElementDisplayed(Loc_EditingRights1Row, "Editing Rights 1 Row", "");
        //Save
		//TC_RI_ER_06
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_06");
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsErrorMgs);
		//Applies To
		//TC_RI_ER_07
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_07");
		clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), "AppliesTo Row 1",RI_EditingRightsApplesTo);
		if(ClientName.contains("VMN")){ //for VMN Locater different
			sendKeys(loc_EditingRightsAppliesToInput1, RI_EditingRightsAppliesToData, "Input ApplesTo ", RI_EditingRightsApplesTo);
		}else{
		sendKeys(loc_EditingRightsAppliesToInput, RI_EditingRightsAppliesToData, "Input ApplesTo ", RI_EditingRightsApplesTo);
		}
		Enter();
		//Applies To PickList
		if(!ClientName.contains("VMN")){ //For VMN Not Applicable  
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesToPickList_Key, RI_EditingRightsApplesTo), "AppliesTo Pick List Row 1",RI_EditingRightsApplesTo); 
		rightsIN.appliesTOPopUpWindow("TC_RI_ER_07 To TC_RI_ER_22 ", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		}
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsErrorMgs);
		//Editing Rights
		//TC_RI_ER_22
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_22");
		clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 1",RI_EditingRights1);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
        Enter();
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRights1pickList_key, RI_EditingRights1)+"/img", "Editing Rights Img",RI_EditingRights1);
		rightsIN.functionalityOfPopUpWindow("TC_RI_ER_22 To TC_RI_ER_33", RI_EditingRights1, "N/A");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		
		if(!RI_EditingRightsContext.contains("N/A")){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsContext_key, RI_EditingRightsContext), "Context Row 1",RI_EditingRightsContext);
			sendKeys(Loc_EditingRightsContextInput, RI_EditingRightsContextData, "Context Input", RI_EditingRightsContext);
			Enter();
			Thread.sleep(2000);
			clickOn(EditngRightsContextImg, " Context Img", RI_EditingRightsContext);
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(LocCancel);
            verifyTextMatches(loc_SelectAll, "Select All Button", RI_EditingRightsSelectAll, "title");
			verifyTextMatches(loc_Episodes_Filter_DeselectAllCheckBox, "DeSelect All Button", RI_EditingRightsDeselectAll, "title");
			verifyTextMatches(Applybutton_AtSBUWindow, "Apply Button", RI_EditingRightsApplies, "value");
			verifyTextMatches(LocCancel, "Cancel Button", RI_EditingRightCancel, "value");
			verifyTextMatches(EditngRightsProgramCheckBox, "Program CheckBox Checked ", "Checked", "title");
			clickUsingJSExecutor(LocCancel, "Cancel Button", RI_EditingRightsContext);
			switchIntoFrame(frameParent3Xpath);
		}
		
		//In Program Use
		if(!RI_EditingRightsInProgramUse.contains("N/A")){
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_34");
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Unchecked", "In Program Use UnChecked", RI_EditingRightsInProgramUse, "title");
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		}
		
		
		//Perpetuity
		if(!RI_EditingRightsPerpetuity.contains("N/A")){
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_37");
		clickUsingJSExecutor(Loc_EditingRightsPerpetuityCheckBox, "Checked Perpetuity ", RI_EditingRightsPerpetuity);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsPerpetuity_Key, RI_EditingRightsPerpetuity)+"/img", "Checked", "Perpetuity Checked", RI_EditingRightsPerpetuity, "title");
		}
		
		
		//Start Date
		if(!RI_EditingRightsStartDate.contains("N/A")){
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 1",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDateData, "Start Date input", RI_EditingRightsStartDate);
		Enter();
		}
		
		
		//End Date
		if(!RI_EditingRightsEndDate.contains("N/A")){
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 1",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDateData, "End Date input", RI_EditingRightsEndDate);
		Enter();
		}
		
		
		//Time Limitation
		if(!RI_EditingRightsTimeLimitation.contains("N/A")){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsTimeLimitation_key, RI_EditingRightsTimeLimitation), "Time Limitation Row 1",RI_EditingRightsTimeLimitation);
			sendKeys(Loc_EditingRightsTimeLimitationInput, RI_EditingRightsTimeLimitationData, "Time Limitation input", "");
			Enter();
		}
		//Check Perpetuity Uncheck
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsPerpetuity_Key, RI_EditingRightsPerpetuity)+"/img", "Unchecked", "Perpetuity Unchecked", RI_EditingRightsPerpetuity, "title");
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsStartDateErrorMgs);
		
		//Start Date
		if(!RI_EditingRightsStartDate.contains("N/A")){
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 1",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDateData, "Start Date input", "");
		Enter();
		}
		
		//End Date
		if(!RI_EditingRightsEndDate.contains("N/A")){
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 1",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDateData2nd, "End Date input", "");
		Enter();
		}
		if(!RI_EditingRightsStartTimeCode.contains("N/A")){ 
		//Step - 1
		//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 1");
			clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			Thread.sleep(1000);
			sendKeys_WithoutClear(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			Thread.sleep(1000);
			if(Browser.contains("ie")){
				//Extra steps only for IE Browser 
			clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			Thread.sleep(1000);
			sendKeys_WithoutClear(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		     }
			//Support
			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsBothStartAndEndTimeCodes);

			//Step - 2
			//End Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 2");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys_WithoutClear(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support
			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightslaterThanStartTimeCode);

			//Step - 3
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 3");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys_WithoutClear(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData1, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//End Time Code
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 4
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 4");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData2, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 5
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 5");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData3, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 6
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 6");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData4, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 7
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 7");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//End Time Code
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "End Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData2, "End Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 8
			//End Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 8");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData3, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 9
			//End Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 9");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData4, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 10
			//End Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 10");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData5, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support

			clickOn(Loc_EditingRights1Row, "Support", "");
			//Save
			clickUsingJSExecutor(loc_Save, "Save Button", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_EditingRightsTimeCodeExceedsTheMaximum);

			//Step - 11
			//Start Time Code
			ExecutionLog.Log("");
			ExecutionLog.Log("//Step - 11");
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
			//End Time Code
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
			sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
			//Support
			clickOn(Loc_EditingRights1Row, "Support", "");
		}
		
		//Notes
		/*if(!RI_EditingRightsNotes.contains("N/A")){
		clickUsingJSExecutor(Loc_EditingRightsNotes, "Notes Img",RI_EditingRightsNotes);
		rightsIN.noteFunctionlity("TC_RI_ER_43");
	    }*/
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(5000);
		clickUsingJSExecutor(loc_Save, "Save Button ", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		Thread.sleep(2000);
		//View Mode 
		//Header
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsApplesTo_Key +"']", RI_EditingRightsApplesTo.replace("*", ""), "ApplesTo Field", RI_EditingRightsApplesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRights1_key +"']", EditingRightsViewMode, "EditingRights Field", RI_EditingRights1, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsInProgramUse_Key +"']", RI_EditingRightsInProgramUse, "In Program Use Field", RI_EditingRightsInProgramUse, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsPerpetuity_Key +"']", RI_EditingRightsPerpetuity, "Perpetuity Field", RI_EditingRightsPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsStartDate_Key +"']", RI_EditingRightsStartDate, "Start Date Field", RI_EditingRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsEndDate_Key +"']", RI_EditingRightsEndDate, "End Date Field", RI_EditingRightsEndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsNotes_Key +"']", RI_EditingRightsNotes, "Note Field", RI_EditingRightsNotes, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsStartTimeCode_Key +"']", RI_EditingRightsStartTimeCode, "Start Time Code Field", RI_EditingRightsStartTimeCode, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsEndTimeCode_Key +"']", RI_EditingRightsEndTimeCode, "End Time Code Field", RI_EditingRightsEndTimeCode, "innerHTML");
		
		//Data
		WaitForElementPresent(EditngRightsApplesToViewMode);
		verifyFieldValueOfHeader(EditngRightsApplesToViewMode, RI_EditingRightsAppliesToData, "ApplesTo Data", RI_EditingRightsApplesTo);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", RI_EditingRights1_key, RI_EditingRights1), RI_EditingRightsdata1, "EditingRights Data", RI_EditingRights1, "innerHTML");
        verifyElementPresent(EditingRightsInProgramUseViewMode, "In Program Use Checked In view Mode",RI_EditingRightsInProgramUse);
		verifyElementNotPresent(getLocator_ViewTAB_DataRow("1", RI_EditingRightsPerpetuity_Key, RI_EditingRightsPerpetuity)+"/img", "Perpetuity is checked in View Mode");
		
		ExecutionLog.Log("*********************End Testcase - TC1_EditingRightsUI *********************");
	}
	
	@Test(priority =2,enabled= true,description = "To verify behavior of fields in Rights Out- Editing Rights Tab - In view")
	public void TC2_EditingRightsViewMode() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC2_EditingRightsViewMode *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		//Appliesto
		doubleClick(Loc_EditingRightsAppliesToViewMode, "ApplesTo ViewMode", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		Thread.sleep(3000);
		clickUsingJSExecutor(LocCancel, "Cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		//Editing rights
		doubleClick(Loc_EditingRightsViewMode, "Editing Rights ViewMode", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent((Loc_Cancel));
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_Cancel, "Cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
        if(!ClientName.contains("TURNER")){
		//In Program Use
		verifyElementPresent(getLocator_ViewTAB_DataRow("2", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "In Program Use is checked in View Mode");
        }
		//Perpetuity
		verifyElementNotPresent(EditngRightsPerpetuityCheckBox, "Perpetuity Check Box Checked");
		//Notes
		/*if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		doubleClick(Loc_EditingRightsNotesViewMode, "Notes ", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodesWindowClose);
		Thread.sleep(3000);
		verifyTextMatches(loc_BusinesstermsViewMode, "Business terms", RI_BusinessTermsData, "title");
		verifyTextMatches(Loc_BusinesstermsTermDescriptionviewMode, "Term Description", RI_TermDescriptionData);
		verifyElementPresent(Loc_BusinessTermsRestriction, "Restriction Checked");
		verifyElementNotPresent(Loc_BusinessTermsIncludeinReports, "Include in Reports Checked");
		clickUsingJSExecutor(loc_EpisodesWindowClose, "Close Button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		}*/
		ExecutionLog.Log("*********************End Testcase - TC2_EditingRightsViewMode *********************");
	}
	
	@Test(priority =3,enabled= true,description = "All Editingtion Rights checkbox")
	public void TC3_EditingRightsAllcheckbox() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC3_EditingRightsAllcheckbox *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
		
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		clickUsingJSExecutor(loc_Edit, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save_UseWithNameAttribute);
		//All Editing Rights - Checkbox
		//TC_RI_ER_01
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_01");
		clickOn(Loc_AllEditingRightsCheckBox, "All Editing Rights CheckBox", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "All Editing Rights Conf Mgs", RI_AllEditingRightsConfMgs);
		clickUsingJSExecutor(ConfirmAlertButtonXpath,"Confirm Alert Button Xpath");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsApplesTo_Key +"']", RI_EditingRightsApplesTo, "ApplesTo Field", RI_EditingRightsApplesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRights1_key +"']", RI_EditingRights1, "EditingRights Field", RI_EditingRights1, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsInProgramUse_Key +"']", RI_EditingRightsInProgramUse, "In Program Use Field", RI_EditingRightsInProgramUse, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsPerpetuity_Key +"']", RI_EditingRightsPerpetuity, "Perpetuity Field", RI_EditingRightsPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsStartDate_Key +"']", RI_EditingRightsStartDate, "Start Date Field", RI_EditingRightsStartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsEndDate_Key +"']", RI_EditingRightsEndDate, "End Date Field", RI_EditingRightsEndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_EditingRightsNotes_Key +"']", RI_EditingRightsNotes, "Note Field", RI_EditingRightsNotes, "innerHTML");
		//Button
		verifyTextMatches(loc_Copy, "Copy",RI_EditingRightCopy,"Value");
		verifyTextMatches(Loc_NewButton, "Add",RI_EditingRightsAdd,"Value");
		verifyTextMatches(loc_Delete, "Delete",RI_EditingRightDelete,"Value");
		verifyTextMatches(loc_Save, "Ok",RI_EditingRightSave,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",RI_EditingRightCancel,"Value");

		verifyTextMatches(Loc_AllEditingRights, "All Editing Rights", RI_AllEditingRights);
		verifyTextMatches(Loc_NoEditingRights, "No Editing Rights", RI_NoEditingRights);

		clickUsingJSExecutor(loc_Save_UseWithNameAttribute, "Save Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_AllEditingRightsViewMode);
		verifyTextMatches(Loc_EditingRightsAppliesToViewMode, "Editing Rights Applies To ViewMode", RI_EditingRightsAppliesToData);
		verifyElementPresent(Loc_AllEditingRightsCheckBoxViewMode,"All Editing Rights Check Box");
		//Edit values	
		//TC_RI_ER_07
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_07");
		clickUsingJSExecutor(loc_Edit, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), RI_EditingRightsAppliesToData, "Editing Rights ApplesTo", RI_EditingRightsApplesTo, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRights1_key, RI_EditingRights1), RI_EditingRightsData, "Editing Rights", RI_EditingRights1, "innerHTML");
		//In Program Use
		if(!ClientName.contains("Turner")){
		verifyElementNotPresent(getLocator_ViewTAB_DataRow("2", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "In Program Use is checked in View Mode");
		}
		//Perpetuity
		verifyElementNotPresent(EditngRightsPerpetuityCheckBox, "Perpetuity Check Box Checked");
		//TC_RI_ER_08
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_08");
		//In Program Use = Checked
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//save
		//TC_RI_ER_09
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_09");
		clickUsingJSExecutor(Loc_NewButton, "Save Button", "");
		//View
		verifyElementNotPresent(Loc_AllEditingRightsCheckBoxViewMode,"All Editing Rights Check Box"); 
		ExecutionLog.Log("*********************End Testcase - TC3_EditingRightsAllcheckbox *********************");
	}
	
	@Test(priority =4,enabled= true,description = "No Editing Rights checkbox")
	public void TC4_NoEditingRightscheckbox() throws Exception {
		
		ExecutionLog.Log("*********************Start Testcase - TC4_NoEditingRightscheckbox *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
				
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		clickUsingJSExecutor(loc_Edit, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save_UseWithNameAttribute);
		//Verify
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), RI_EditingRightsAppliesToData, "Editing Rights ApplesTo", RI_EditingRightsApplesTo, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRights1_key, RI_EditingRights1), RI_EditingRightsData, "Editing Rights", RI_EditingRights1, "innerHTML");
		//In Program Use
		if(!ClientName.contains("Turner")){
		verifyElementNotPresent(getLocator_ViewTAB_DataRow("2", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "In Program Use is checked in View Mode");
		}
		//Perpetuity
		verifyElementNotPresent(EditngRightsPerpetuityCheckBox, "Perpetuity Check Box Checked");
		
		//No Editing Rights - Checkbox
		clickOn(Loc_NoEditingRightsChekcBox," No Editing Rights", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "No Editing Rights Conf Mgs", RI_NoEditingRightsConfMgs);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button Ok", "");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		//TC_RI_ER_07
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_03");
		verifyTextMatches(loc_Copy, "Copy Button disabled", "true", "disabled");
		verifyTextMatches(Loc_NewButton, "Add Button disabled", "true", "disabled");
		verifyTextMatches(loc_Delete, "Delete Button disabled", "true", "disabled");
		//Save
		clickUsingJSExecutor(Loc_NewButton, "Save Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditingRightsAppliesToViewMode);
		verifyTextMatches(Loc_EditingRightsAppliesToViewMode, "Editing Rights Applies To ViewMode", RI_EditingRightsAppliesToData);
		verifyElementPresent(Loc_NoEditingRightsChekcBoxViewMode,"No Editing Rights Check Box");
		
		ExecutionLog.Log("*********************End Testcase - TC4_NoEditingRightscheckbox *********************");
	}
	
	@Test(priority =5,enabled= true,description = "Create multiple rows with different Applies To")
	public void TC5_EditingRightsMultipleRows() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC5_EditingRightsMultipleRows *********************");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
	
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
		
		ExecutionLog.Log(CreatedSeriesAssetTitle1);
		ExecutionLog.Log(CreatedDeal1);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightsIN.createDeal (CreatedDeal1);
		rightsIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		clickUsingJSExecutor(Loc_EditButton, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);	
		
		//Add - Row 1
		ExecutionLog.Log("");
		ExecutionLog.Log("Row 1");
		ExecutionLog.Log("");
		clickUsingJSExecutor(Loc_NewButton, "New Button", "");
		WaitForElementPresent(Loc_EditingRights1Row);
		clickOn(Loc_EditingRights1Row, "Editing Rights 1Row", "");
		Thread.sleep(2000);
		//Applies To
		//TC_RI_ER_001
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_001");
		if(ClientName.contains("AMCN")||(ClientName.contains("TURNER"))){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), "AppliesTo Row 1",RI_EditingRightsApplesTo); 
		}else{
			clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), "AppliesTo Row 1",RI_EditingRightsApplesTo);
		}
		 
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsAppliesToInput, RI_EditingRightsAppliesToData, "Input ApplesTo ", RI_EditingRightsApplesTo);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		//Editing Rights
		clickOn(getLocator_EditTAB_DataRow("1", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 1",RI_EditingRights1);
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
		act.sendKeys(Keys.ENTER).perform();
		//In Program Use
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//Start Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 1",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDate1Row, "Start Date input", "");	
		act.sendKeys(Keys.ENTER).perform();
		//End Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 1",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDate1Row, "End Date input", "");
		act.sendKeys(Keys.ENTER).perform();
		
		//Start Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		//End Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
		//Support
		clickOn(Loc_EditingRights1Row, "Support", "");
		
		//Note
	/*	if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		clickUsingJSExecutor(Loc_EditingRightsNotes, "Notes Img",RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Row", RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		//Business Terms
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		sendKeys(loc_BusinesstermsInput, RI_BusinessTermsData, "Business terms Input", RI_BusinessTerms);
		act.sendKeys(Keys.ENTER).perform();
		//Term Description
		clickOn(Loc_BusinesstermsTermDescription, "Term Description", RI_BusinessTermTermDescription);
		sendKeys(Loc_BusinesstermsTermDescriptionInput , RI_TermDescriptionData1Row, "Term Description Input", RI_BusinessTermTermDescription);
		//Support
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		}*/
		//Add- Row2
		ExecutionLog.Log("");
		ExecutionLog.Log("Row 2");
		ExecutionLog.Log("");
		clickUsingJSExecutor(Loc_NewButton, "New Button", "");
		WaitForElementPresent(Loc_EditingRights2Row);
		clickOn(Loc_EditingRights2Row, "Editing Rights 2Row", "");
		Thread.sleep(2000);
		//Applies To
		//TC_RI_ER_005
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_005");
		if(ClientName.contains("AMCN")||(ClientName.contains("TURNER"))){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), "AppliesTo Row 1",RI_EditingRightsApplesTo); 
		}else{
		clickOn(getLocator_EditTAB_DataRow("2", RI_EditingRightsApplesTo_Key, RI_EditingRightsApplesTo), "AppliesTo Row 1",RI_EditingRightsApplesTo); 
		}
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsAppliesToInput, CreatedSeriesAssetTitle1, "Input ApplesTo ", RI_EditingRightsApplesTo);
		act.sendKeys(Keys.ENTER).perform();
		//Editing Rights
		clickOn(getLocator_EditTAB_DataRow("2", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 2",RI_EditingRights1);
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
		act.sendKeys(Keys.ENTER).perform();
		//In Program Use
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox2Row, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("2", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//Start Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 2",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDate1Row, "Start Date input", "");	
		act.sendKeys(Keys.ENTER).perform();
		//End Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 2",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDate2Row, "End Date input", "");
		act.sendKeys(Keys.ENTER).perform();
		
		//Start Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		//End Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
		//Support
		clickOn(Loc_EditingRights1Row, "Support", "");
				
		//Note
		/*if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		clickUsingJSExecutor(Loc_EditingRightsNotes2Row, "Notes Img",RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Row", RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		//Business Terms
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		sendKeys(loc_BusinesstermsInput, RI_BusinessTermsData, "Business terms Input", RI_BusinessTerms);
		act.sendKeys(Keys.ENTER).perform();
		//Term Description
		clickOn(Loc_BusinesstermsTermDescription, "Term Description", RI_BusinessTermTermDescription);
		sendKeys(Loc_BusinesstermsTermDescriptionInput , RI_TermDescriptionData2Row, "Term Description Input", RI_BusinessTermTermDescription);
		//Support
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		}*/
		//Add- Row3
		ExecutionLog.Log("");
		ExecutionLog.Log("Row 3");
		ExecutionLog.Log("");
		clickUsingJSExecutor(Loc_NewButton, "New Button", "");
		WaitForElementPresent(Loc_EditingRights1Row);
		//Applies To
		//TC_RI_ER_007
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_007");
		clickUsingJSExecutor(Loc_EditingRightsApplesTo3, "EditingRightsApplesTo 3rd Row", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(Loc_EditngRightsSeason1);
		Thread.sleep(1000);
		clickOn(Loc_EditngRightsSeason1, " Season1", "");
		clickUsingJSExecutor(loc_Episodes_MultiSelectSeason_ApplyButton, "Apply button", "");
		switchIntoFrame(frameParent3Xpath);
		//Editing Rights
		clickOn(getLocator_EditTAB_DataRow("3", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 3",RI_EditingRights1);
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
		act.sendKeys(Keys.ENTER).perform();
		//In Program Use
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox3Row, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("3", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//Start Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("3", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 3",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDate1Row, "Start Date input", "");	
		act.sendKeys(Keys.ENTER).perform();
		//End Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("3", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 3",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDate3Row, "End Date input", "");
		act.sendKeys(Keys.ENTER).perform();

		//Start Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("3", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		//End Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("3", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
		//Support
		clickOn(Loc_EditingRights1Row, "Support", "");
				
		//Note
	/*	if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		clickUsingJSExecutor(Loc_EditingRightsNotes3Row, "Notes Img",RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Row", RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		//Business Terms
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		sendKeys(loc_BusinesstermsInput, RI_BusinessTermsData, "Business terms Input", RI_BusinessTerms);
		act.sendKeys(Keys.ENTER).perform();
		
		//Term Description
		clickOn(Loc_BusinesstermsTermDescription, "Term Description", RI_BusinessTermTermDescription);
		sendKeys(Loc_BusinesstermsTermDescriptionInput , RI_TermDescriptionData3Row, "Term Description Input", RI_BusinessTermTermDescription);
		//Support
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent3Xpath);
		}*/
		//Add- Row4
		ExecutionLog.Log("");
		ExecutionLog.Log("Row 4");
		ExecutionLog.Log("");
		clickUsingJSExecutor(Loc_NewButton, "New Button", "");
		WaitForElementPresent(Loc_EditingRights1Row);
		//Applies To
		//TC_RI_ER_009
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_009");
		//ApplesTo
		clickUsingJSExecutor(Loc_EditingRightsApplesTo4, "EditingRightsApplesTo 4th Row", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(Loc_EditngRightsEpisode101);
		Thread.sleep(1000);
		clickOn(Loc_EditngRightsEpisode101, " Episode101", "");
		clickUsingJSExecutor(loc_Episodes_MultiSelectSeason_ApplyButton, "Apply button", "");
		switchIntoFrame(frameParent3Xpath);
		//Editing Rights
		clickOn(getLocator_EditTAB_DataRow("4", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 4",RI_EditingRights1);
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
		act.sendKeys(Keys.ENTER).perform();
		//In Program Use
		clickUsingJSExecutor(Loc_EditingRightsInProgramUseBeckBox4Row, "Checked In Program Use", RI_EditingRightsInProgramUse);
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("4", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Checked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//Start Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("4", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 4",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDate1Row, "Start Date input", "");	
		act.sendKeys(Keys.ENTER).perform();
		//End Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("4", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 4",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDate3Row, "End Date input", "");
		act.sendKeys(Keys.ENTER).perform();

		//Start Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("4", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		//End Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("4", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
		//Support
		clickOn(Loc_EditingRights1Row, "Support", "");
				
				
		//Note
		/*if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		clickUsingJSExecutor(Loc_EditingRightsNotes4Row, "Notes Img",RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Row", RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		//Business Terms
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		sendKeys(loc_BusinesstermsInput, RI_BusinessTermsData, "Business terms Input", RI_BusinessTerms);
		act.sendKeys(Keys.ENTER).perform();
		
		//Term Description
		clickOn(Loc_BusinesstermsTermDescription, "Term Description", RI_BusinessTermTermDescription);
		sendKeys(Loc_BusinesstermsTermDescriptionInput , RI_TermDescriptionData3Row, "Term Description Input", RI_BusinessTermTermDescription);
		//Support
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		switchIntoFrame(frameParent3Xpath);
		}*/
		//Add- Row5
		ExecutionLog.Log("");
		ExecutionLog.Log("Row 5");
		ExecutionLog.Log("");
		clickUsingJSExecutor(Loc_NewButton, "New Button", "");
		WaitForElementPresent(Loc_EditingRights1Row);
		//Applies To
		//TC_RI_ER_011
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_011");
		//Applies To
		clickUsingJSExecutor(Loc_EditingRightsApplesTo5, "EditingRightsApplesTo 5th Row", ""); 
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Episodes_MultiSelectSeason_ApplyButton);
		Thread.sleep(1000);
		clickOn(loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_EditingRightsEpisode101), "click tsEpisode 101 check box",RI_EditingRightsApplesTo);
		Thread.sleep(1000);
		clickOn(loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_EditingRightsEpisode201), "click Episode 201 check box",RI_EditingRightsApplesTo);
		Thread.sleep(1000);
		clickUsingJSExecutor(loc_Episodes_MultiSelectSeason_ApplyButton, "Apply button", "");
		switchIntoFrame(frameParent3Xpath);
		//Editing Rights
		clickOn(getLocator_EditTAB_DataRow("5", RI_EditingRights1_key, RI_EditingRights1), "Editing Rights Row 5",RI_EditingRights1);
		Thread.sleep(1000);
		sendKeys(loc_EditingRightsInput, RI_EditingRightsData, "Input Editing Rights ", RI_EditingRights1);
		act.sendKeys(Keys.ENTER).perform();
		//In Program Use
		Thread.sleep(2000);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("5", RI_EditingRightsInProgramUse_Key, RI_EditingRightsInProgramUse)+"/img", "Unchecked", "In Program Use Checked", RI_EditingRightsInProgramUse, "title");
		//Start Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("5", RI_EditingRightsStartDate_Key, RI_EditingRightsStartDate), "Start Date Row 4",RI_EditingRightsStartDate);
		sendKeys(Loc_EditingRightsStartDate, RI_EditingRightStartDate1Row, "Start Date input", "");	
		act.sendKeys(Keys.ENTER).perform();
		//End Date
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("5", RI_EditingRightsEndDate_Key, RI_EditingRightsEndDate), "End Date Row 4",RI_EditingRightsEndDate);
		sendKeys(Loc_EditingRightsEndDate, RI_EditingRightEndDate5Row, "End Date input", "");
		act.sendKeys(Keys.ENTER).perform();
		
		//Start Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("5", RI_EditingRightsStartTimeCode_Key, RI_EditingRightsStartTimeCode), "Start Time Code Row 1",RI_EditingRightsStartTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightStartTimeCodeData, "Start Time Code Date input", RI_EditingRightsStartTimeCode);
		//End Time Code
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("5", RI_EditingRightsEndTimeCode_Key, RI_EditingRightsEndTimeCode), "Start Time Code Row 1",RI_EditingRightsEndTimeCode);
		sendKeys(LocEditingRightsStartAndEndTimeCodeInput, RI_EditingRightEndTimeCodeData1, "Start Time Code Date input", RI_EditingRightsEndTimeCode);
		//Support
		clickOn(Loc_EditingRights1Row, "Support", "");
				
		//Note
		/*if(!(ClientName.contains("TURNER") || ClientName.contains("SALESDEMO"))){
		clickUsingJSExecutor(Loc_EditingRightsNotes5Row, "Notes Img",RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Save);
		//Add
		clickUsingJSExecutor(LocAdd, "Add Row", RI_EditingRightsNotes);
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		//Business Terms
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		sendKeys(loc_BusinesstermsInput, RI_BusinessTermsData, "Business terms Input", RI_BusinessTerms);
		act.sendKeys(Keys.ENTER).perform();
		
		//Term Description
		clickOn(Loc_BusinesstermsTermDescription, "Term Description", RI_BusinessTermTermDescription);
		sendKeys(Loc_BusinesstermsTermDescriptionInput , RI_TermDescriptionData5Row, "Term Description Input", RI_BusinessTermTermDescription);
		//Support
		clickOn(loc_Businessterms, "Business Terms", RI_BusinessTerms);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		WaitForModalPanel();
		}*/
		//Save Editing Rights
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		clickUsingJSExecutor(loc_Save, "Save Button", "");
		WaitForModalPanel();
		//View Mode
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		
		//Row 1 
		verifyFieldValueOfHeader(EditngRightsApplesToViewMode, RI_EditingRightsAppliesToData, "Applies To In View Mode Row 1 ", RI_EditingRightsAppliesToData);
		verifyFieldValueOfHeader(EditngRightsViewMode1Row,RI_EditingRightsData, "Editing Rights 1 Row", RI_EditingRights1);
		verifyFieldValueOfHeader(EditngRightsStartDate1Row,RI_EditingRightStartDate1Row, "Start Date 1 Row", RI_EditingRightsStartDate);
		verifyFieldValueOfHeader(EditngRightsEndDate1Row, RI_EditingRightEndDate1Row, "End Date 1 Row", RI_EditingRightsEndDate);
		verifyFieldValueOfHeader(EditngRightsStartTimeCode1Row,RI_EditingRightStartTimeCodeData, "Start Time Code 1 Row", RI_EditingRightsStartTimeCode);
		verifyFieldValueOfHeader(EditngRightsEndTimeCode1Row, RI_EditingRightEndTimeCodeData1, "End Time Code 1 Row", RI_EditingRightsEndTimeCode);

		//Row 2
		verifyFieldValueOfHeader(EditingRightsAppliesToViewMode2,CreatedSeriesAssetTitle1 ,"Applies To In View Mode Row 2 ", RI_EditingRightsAppliesToData);
		verifyFieldValueOfHeader(EditngRightsViewMode2Row,RI_EditingRightsData, "Editing Rights 2 Row", RI_EditingRights1);
		verifyFieldValueOfHeader(EditngRightsStartDate2Row, RI_EditingRightStartDate1Row, "Start Date 2 Row", RI_EditingRightsStartDate);
		verifyFieldValueOfHeader(EditngRightsEndDate2Row, RI_EditingRightEndDate2Row, "End Date 2 Row", RI_EditingRightsEndDate);
		verifyFieldValueOfHeader(EditngRightsStartTimeCode2Row,RI_EditingRightStartTimeCodeData, "Start Time Code 2 Row", RI_EditingRightsStartTimeCode);
		verifyFieldValueOfHeader(EditngRightsEndTimeCode2Row, RI_EditingRightEndTimeCodeData1, "End Time Code 2 Row", RI_EditingRightsEndTimeCode);

		//Row 3
		verifyFieldValueOfHeader(EditingRightsAppliesToViewMode3,RI_EditingRightsSeason1, "Applies To In View Mode Row 3 ", RI_EditingRightsAppliesToData);
		verifyFieldValueOfHeader(EditngRightsViewMode3Row, RI_EditingRightsData, "Editing Rights 3 Row", RI_EditingRights1);
		verifyFieldValueOfHeader(EditngRightsStartDate3Row,RI_EditingRightStartDate1Row, "Start Date 3 Row", RI_EditingRightsStartDate);
		verifyFieldValueOfHeader(EditngRightsEndDate3Row, RI_EditingRightEndDate1Row, "End Date 3 Row", RI_EditingRightsEndDate);
		verifyFieldValueOfHeader(EditngRightsStartTimeCode3Row,RI_EditingRightStartTimeCodeData, "Start Time Code 3 Row", RI_EditingRightsStartTimeCode);
		verifyFieldValueOfHeader(EditngRightsEndTimeCode3Row, RI_EditingRightEndTimeCodeData1, "End Time Code 3 Row", RI_EditingRightsEndTimeCode);

		//Row 4
		verifyFieldValueOfHeader(EditingRightsAppliesToViewMode4,RI_EditingRightsEpisode101 ,"Applies To In View Mode Row 4 ", RI_EditingRightsAppliesToData);
		verifyFieldValueOfHeader(EditngRightsViewMode4Row,RI_EditingRightsData, "Editing Rights 4 Row", RI_EditingRights1);
		verifyFieldValueOfHeader(EditngRightsStartDate4Row, RI_EditingRightStartDate1Row, "Start Date 4 Row", RI_EditingRightsStartDate);
		verifyFieldValueOfHeader(EditngRightsEndDate4Row, RI_EditingRightEndDate1Row, "End Date 4 Row", RI_EditingRightsEndDate);
		verifyFieldValueOfHeader(EditngRightsStartTimeCode4Row,RI_EditingRightStartTimeCodeData, "Start Time Code 4 Row", RI_EditingRightsStartTimeCode);
		verifyFieldValueOfHeader(EditngRightsEndTimeCode4Row, RI_EditingRightEndTimeCodeData1, "End Time Code 4 Row", RI_EditingRightsEndTimeCode);

		//Row 5
		verifyFieldValueOfHeader(EditingRightsAppliesToViewMode5,RI_EditingRightsAppliesTo5RowData,"Applies To In View Mode Row 5  ", RI_EditingRightsAppliesToData);
		verifyFieldValueOfHeader(EditngRightsViewMode5Row, RI_EditingRightsData, "Editing Rights 5 Row", RI_EditingRights1);
		verifyFieldValueOfHeader(EditngRightsStartDate5Row, RI_EditingRightStartDate1Row, "Star Date 5 Row", RI_EditingRightsStartDate);
		verifyFieldValueOfHeader(EditngRightsEndDate5Row, RI_EditingRightEndDate5Row, "End Date 5 Row", RI_EditingRightsEndDate);
		verifyFieldValueOfHeader(EditngRightsStartTimeCode5Row,RI_EditingRightStartTimeCodeData, "Start Time Code 5 Row", RI_EditingRightsStartTimeCode);
		verifyFieldValueOfHeader(EditngRightsEndTimeCode5Row, RI_EditingRightEndTimeCodeData1, "End Time Code 5 Row", RI_EditingRightsEndTimeCode);
		
		ExecutionLog.Log("*********************End Testcase - TC5_EditingRightsMultipleRows *********************");
	}
	
	@Test(priority =6,enabled= true,description = "Copy Row(s) Functionality")
	public void TC6_EditingRightsCopyRow() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC6_EditingRightsCopyRow *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		clickUsingJSExecutor(Loc_EditButton, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		
		//TC_RI_ER_01
		//Copy Row
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_001");
		clickUsingJSExecutor(loc_Copy,"Copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Without Seleting Row", RI_EditingRightsCopyWithoutSeletingRowMgs);
		clickUsingJSExecutor(OKAlertButtonXpath,"ok Alert Button");
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_EditingRights1Row, "Editing Rights 1 Row", "");
		Thread.sleep(1000);
		clickUsingJSExecutor(loc_Copy,"Copy Button");
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(CancelAlertXpath,"Promptt Cancel Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Copy,"Copy Button");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow, RI_EditingRightsNumOfCopyRow, "Input Num Of Copy Row", "");
		clickUsingJSExecutor(loc_EpisodeAddOKbutton,"Ok Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy 20 Row", RI_EditingRightsCopy20RowMgs);
		clickUsingJSExecutor(OKAlertButtonXpath,"Ok Alert Button");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow, RI_EditingRights2CopyRow, "Input 2  Num Of Copy Row", "");
		clickUsingJSExecutor(loc_EpisodeAddOKbutton,"Ok Button");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		verifyElementPresent(Loc_EditingRights2Row, "2nd Row");
		verifyElementPresent(Loc_EditingRights3Row, "3rd Row");
		clickUsingJSExecutor(loc_Save,"Save Button");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		ExecutionLog.Log("*********************End Testcase - TC6_EditingRightsCopyRow *********************");
	}
	
	@Test(priority =7,enabled= true,description = "Delete Functionality")
	public void TC7_EditingRightsDelete() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC7_EditingRightsDelete *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
		//Editing Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Editing Rights"), "Editing Rights TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		clickUsingJSExecutor(Loc_EditButton, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(By.id(loc_Save_UseWithNameAttribute));
		//TC_RI_ER_001
		//Delete a row	
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_001");
		clickUsingJSExecutor(loc_Delete,"Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Without Seleting Row Click Delete Button",RI_EditingRightsDeleteWithOutSeletingRow);
		clickUsingJSExecutor(OKAlertButtonXpath,"Ok Alert");
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_EditingRights3Row, "Select 3rd Row");
		clickUsingJSExecutor(loc_Delete,"Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Conf msg", RI_EditingRightsDeleteCofMgs);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Confirm Cancel");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Delete,"Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Conf msg", RI_EditingRightsDeleteCofMgs);
		clickUsingJSExecutor(ConfirmAlertButtonXpath,"Confirm Alert Button Xpath");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Cancel,"Cancel Button");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		verifyElementPresent(Loc_EditingRights3RowViewMode, "3rd Row Present");
		clickUsingJSExecutor(Loc_EditButton, "Edit Button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		clickOn(Loc_EditingRights3Row, "Select 3rd Row");
		clickUsingJSExecutor(loc_Delete,"Delete");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Conf msg", RI_EditingRightsDeleteCofMgs);
		clickUsingJSExecutor(ConfirmAlertButtonXpath,"Confirm Alert Button Xpath");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Save,"Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton);
		verifyElementNotPresent(Loc_EditingRights3Row, "3rd Row Present");
		ExecutionLog.Log("*********************End Testcase - TC7_EditingRightsDelete *********************");
	}
	
	@Test(priority =8,enabled= true,description = "Delete an Asset from the Deal Navigator that has been used in Applies To")
	public void TC8_EditingRightsDeleteAnAssetFromTheDealNavigator() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC8_EditingRightsDelete *********************");
		//Search Created Deal 
		rightsIN.searchCreatedDeal(CreatedDeal1);
		//TC_RI_ER_001
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_001");
		//Deal  Deal Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(DealNavigatorMenuBar, "Deal Navigator", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1));
		Thread.sleep(2000);
		clickOn(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1), "Select Asset from Asset navigator");
		Thread.sleep(1000);
		clickUsingJSExecutor(AssetNavigatorDeleteButton, "Delete Asset ", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Conf msg",RI_AseetNavigatorDeleteAssetConfMsg );
		clickUsingJSExecutor(ConfirmAlertButtonXpath,"Confirm Alert Button Xpath");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyElementNotPresent(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1), "Asset Deleted");
		clickUsingJSExecutor("name="+loc_OkButton, "Ok Button", "");
		
		
		
	}
	

	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(locator_EditTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]//td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}
	/**
	 * row is starting from 2 for "All" section
	 */
	public String getLocator_ViewTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(locator_ViewModeTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = locator_ViewMode_ColumnDataRow + "[" + rowNumber +"]//td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

}
	

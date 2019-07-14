package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_DeliverySchedule extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	Date date ;
	SimpleDateFormat sdf;
	String formattedDate;

	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";




	public RI_DeliverySchedule() {
		super(RI_DeliveryScheduleColumnXpath_EditMode, RI_DeliveryScheduleDataRowXpath_EditMode, RI_DeliveryScheduleColumnXpath_ViewMode, RI_DeliveryScheduleDataRowXpath_ViewMode);
		className = this.getClass().getName();
	}

	@Test(priority =2,enabled= true,description = "Delivery Schedule Tab")
	public void TC2_DeliveryScheduleUI() throws Exception {
		System.out.println("*********************Start Testcase - TC2_DeliveryScheduleUI *********************");

		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);


		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Delivery Schedule"), "Delivery Schedule TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		// View Mode
		//TC_RI_ER_02
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_02");
		verifyTextMatches(DeliveryScheduleGenerateProduction, "Generate Production Deliverables Exhibit", RI_DeliveryScheduleGenerateProductionDeliverablesExhibit, "value");
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_DeliveryScheduleEdit, "value");
		verifyTextMatches(DeliveryScheduleSendReminder, "Send Reminder Button", RI_DeliveryScheduleSendReminder, "title");

		//Edit Mode
		//TC_RI_ER_03
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_03");
		ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Delivery Schedule TAB*****"); 
		WaitForElementPresent(Loc_EditButton2);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		WaitForElementPresent(loc_Save);
		//Field
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleAppliesToKey +"']", RI_DeliveryScheduleAppliesTo, "ApplesTo Field", RI_DeliveryScheduleAppliesTo, "innerHTML");
		//Button
		verifyTextMatches(Loc_NewButton, "Add Button", RI_DeliveryScheduleAddButton, "value");
		verifyTextMatches(LocAdd, "Allocate Button", RI_DeliveryScheduleAllocateButton, "value");
		verifyTextMatches(loc_Delete, "Delete Button", RI_DeliveryScheduleDeleteButton, "value");
		verifyTextMatches(loc_Save, "Save Button", RI_DeliveryScheduleSaveButton, "value");
		verifyTextMatches(DeliveryScheduleCancelButton, "Cancel Button", RI_DeliveryScheduleCancelButton, "value");
		verifyTextMatches(loc_Copy, "Copy Row Button", RI_DeliveryScheduleCopyRowButton, "value");

		//Add
		clickUsingJSExecutor(Loc_NewButton, "Add Button", RI_DeliveryScheduleAddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		verifyElementPresent(DeliverySchedule1Row, "New Row is created");
		WaitForElementPresent(loc_Save);
		//Save
		//TC_RI_ER_05
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_05");
		clickUsingJSExecutor(loc_Save, "Save Button");
		verifyTextMatches(Loc_ErrorMsg, "Error Msg", RI_DeliveryScheduleSaveWithoutAllocate);
		//TC_RI_ER_07
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_07");
		//Applies To
		clickUsingJSExecutor(RI_DeliveryScheduleAppliesTo1Row, "AppliesTo Row 1",RI_DeliveryScheduleAppliesTo); 
		sendKeys(DeliveryScheduleAppiesToInput, RI_DeliveryScheduleAppliesToData, "AppliesTo Input", RI_DeliveryScheduleAppliesTo);
		Enter();
		//Save
		//TC_RI_ER_20
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_20");
		clickUsingJSExecutor(loc_Save, "Save Button");
		verifyTextMatches(Loc_ErrorMsg, "Error Msg", RI_DeliveryScheduleSaveWithoutAllocate);
		//Select 1Row
		//TC_RI_ER_21
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_21");
		clickOn(DeliverySchedule1Row, "Select 1 Row");
		clickUsingJSExecutor(LocAdd, "Allocate Button");
		switchIntoFrame(frameParent4Xpath);  
		WaitForElementPresent(DeliveryScheduleCancel);
		Thread.sleep(2000);
		verifyTextMatches(DeliveryScheduleSelectAll, "Select All Button", RI_DeliveryScheduleSeelctAll, "value");
		verifyTextMatches(DeliveryScheduleDeSelectAll, "Deselect All Button", RI_DeliveryScheduleDeselectAll, "value");
		verifyTextMatches(DeliveryScheduleSave, "Save Button", RI_DeliveryScheduleSave, "value");
		verifyTextMatches(DeliveryScheduleCancel, "Cancel Button", RI_DeliveryScheduleCancel, "value");

		//Save
		//TC_RI_ER_22
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_22");
		clickUsingJSExecutor(DeliveryScheduleSave, "Save Button", RI_DeliveryScheduleAllocateButton);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Allocate Without Selecting", RI_DeliveryScheduleSavewithoutselcet);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
		switchIntoFrame(frameParent4Xpath);  

		//TC_RI_ER_24
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_24");
		clickUsingJSExecutor(DeliveryScheduleSelectAll, "Select All Button");
		switchIntoFrame(frameParent4Xpath);  

		//verify
		verifyElementNotPresent(RI_DeliverySchedule_AllCheckBoxes.replace("@var", "off"), "Select all check box");



		//TC_RI_ER_25
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_25");
		clickUsingJSExecutor(DeliveryScheduleDeSelectAll, "DeSelect All Button");
		switchIntoFrame(frameParent4Xpath);

		//verify
		verifyElementNotPresent(RI_DeliverySchedule_AllCheckBoxes.replace("@var", "on"), "DeSelect all check box");


		//TC_RI_ER_26
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_26");
		clickOn(DeliveryScheduleHDCam.replace("@var",RI_DeliveryScheduleHDCam ), "Select HD cam");

		//verify
		verifyElementPresent(RI_DeliverySchedule_verifyCheckbox.replace("@var", RI_DeliveryScheduleHDCam), "Checked HDCam");

		//Save
		//TC_RI_ER_27
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_27");
		clickUsingJSExecutor(DeliveryScheduleSave, "Save Button", RI_DeliveryScheduleAllocateButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		//TC_RI_ER_28
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_28");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleNameKey +"']", RI_DeliveryScheduleName, "Name  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDueOnKey +"']", RI_DeliveryScheduleDueOn, "Due On Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDeliveredOnKey +"']", RI_DeliveryScheduleDeliveredOn, "Delivered On  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleFromKey +"']", RI_DeliveryScheduleFrom, "From  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleQtyKey +"']", RI_DeliveryScheduleQty, "Qty  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleFinalQCKey +"']", RI_DeliveryScheduleFinalQC, "Final QC  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleQCStatusKey +"']", RI_DeliveryScheduleQCStatus, "QC Status  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleRequiredKey +"']", RI_DeliveryScheduleRequired, "Required  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleEssentialKey +"']", RI_DeliveryScheduleEssential, "Essential  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDeliveryStatusKey +"']", RI_DeliveryScheduleDeliveryStatus, "Delivery Status  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDisposeKey +"']", RI_DeliveryScheduleDispose, "Dispose  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDateDisposedKey +"']", RI_DeliveryScheduleDateDisposed, "Date Disposed  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleNotificationKey +"']", RI_DeliveryScheduleNotification, "Notification  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleRightToMoveKey +"']", RI_DeliveryScheduleRightToMove, "RightToMove  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleStorageLocationKey +"']", RI_DeliveryScheduleStorageLocation, "Storage Location  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleDateofReturnKey +"']", RI_DeliveryScheduleDateofReturn, "Date of Return  Field", RI_DeliveryScheduleName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_DeliveryScheduleNotesKey +"']", RI_DeliveryScheduleNotes, "Notes  Field", RI_DeliveryScheduleName, "innerHTML");

		//TC_RI_ER_29
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_29");
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleNameKey, RI_DeliveryScheduleName), " verify Name data field", RI_DeliveryScheduleNameData);
		//DueOn
		//TC_RI_ER_30
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_30");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDueOnKey, RI_DeliveryScheduleDueOn), "DueOn Row 1",RI_DeliveryScheduleDueOn); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryDueOnData, "Due On Input", RI_DeliveryScheduleDueOn);
		Enter();
		//Delivered on 
		//TC_RI_ER_31
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_31");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDeliveredOnKey, RI_DeliveryScheduleDeliveredOn), "Delivered On Row 1",RI_DeliveryScheduleDeliveredOn); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryScheduleDeliveredOnData, "Delivered On Input", RI_DeliveryScheduleDeliveredOn);
		Enter();
		//From
		//TC_RI_ER_32
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_32");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFromImgKey, "")+"/img", "From pick List",RI_DeliveryScheduleFrom); 
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_Cancel);
		sendKeys(RI_DeliveryScheduleFromSearchField, RI_DeliveryScheduleFromData, "From Search Field", RI_DeliveryScheduleFrom);
		clickUsingJSExecutor(RI_DeliveryScheduleFindButton, "Find Button", RI_DeliveryScheduleFrom);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		clickOn(RI_DeliveryScheduleIFC, "Selcet IFC");
		clickUsingJSExecutor(RI_DeliveryScheduleSelctButton, "Select Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFromKey, RI_DeliveryScheduleFrom), " verify Name data field", RI_DeliveryScheduleFromData);
		//Qty
		//TC_RI_ER_35
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_35");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "DueOn Row 1",RI_DeliveryScheduleQty); 
		sendKeys(RI_DeliveryScheduleQtyInput, RI_DeliveryScheduleQty1Data, "Qty Input 4555", RI_DeliveryScheduleQty);
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "It should only accept first three digit", RI_DeliveryScheduleQty2Data);

		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "DueOn Row 1",RI_DeliveryScheduleQty); 
		sendKeys(RI_DeliveryScheduleQtyInput, RI_DeliveryScheduleQty3Data, "Qty Input 4555", RI_DeliveryScheduleQty);
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "It should only accept first three digit", RI_DeliveryScheduleQty3Data);
		//Final QC
		//TC_RI_ER_38
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_38");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "DueOn Row 1",RI_DeliveryScheduleFinalQC); 
		clickOn(RI_DeliveryScheduleFinalQCImg, "FinalQC Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleFinalQCData), "Final QC Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "Final QC", RI_DeliveryScheduleFinalQCData);
		//QC Status
		//TC_RI_ER_39
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_39");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQCStatusKey, RI_DeliveryScheduleQCStatus), "QCStatus Row 1",RI_DeliveryScheduleQCStatus); 
		clickOn(RI_DeliveryScheduleQCStatusImg, "QC Status Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleQCStatusData), "QC Status Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQCStatusKey, RI_DeliveryScheduleQCStatus), "QC Status", RI_DeliveryScheduleQCStatusData);
		//Required
		//TC_RI_ER_40
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_40");
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleRequiredKey, RI_DeliveryScheduleRequired), "Required CheckBox");

		//Essential
		//TC_RI_ER_43
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_43");
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleEssentialKey, RI_DeliveryScheduleEssential), "Essential CheckBox");

		//Delivery Status
		//TC_RI_ER_46
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_46");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDeliveryStatusKey, RI_DeliveryScheduleDeliveryStatus), "DeliveryStatus Row 1",RI_DeliveryScheduleDeliveryStatus); 
		sendKeys(RI_DeliveryScheduleDeliveryStatusInput, RI_DeliveryScheduleDeliveryStatusData, "=Delivery Status Input", RI_DeliveryScheduleDeliveryStatus);
		Enter();

		//Dispose
		//TC_RI_ER_47
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_47");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDisposeKey, RI_DeliveryScheduleDispose), "Dispose Row 1",RI_DeliveryScheduleDispose); 
		clickOn(RI_DeliveryScheduleDisposeImg, "Dispose Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleDisposeData), "Dispose Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDisposeKey, RI_DeliveryScheduleQCStatus), "QC Status", RI_DeliveryScheduleDisposeData);

		//Date Disposed
		//TC_RI_ER_48
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_48");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDateDisposedKey, RI_DeliveryScheduleDateDisposed), "Dispose Row 1",RI_DeliveryScheduleDateDisposed); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryScheduleDateDisposedData, "Date Disposed input", RI_DeliveryScheduleDateDisposed);
		Enter();

		//Notification
		//TC_RI_ER_49
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_49");
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleNotificationKey, RI_DeliveryScheduleNotification), "Notification CheckBox");

		//Rights To Move
		//TC_RI_ER_52
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_52");
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleRightToMoveKey, RI_DeliveryScheduleRightToMove), "Rights To Move CheckBox");
		//Scroll 
		scrollElementIntoView(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDateofReturnKey, RI_DeliveryScheduleDateofReturn));
		Thread.sleep(3000);
		//Storage Location
		//TC_RI_ER_55
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_55");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleStorageLocationKey, RI_DeliveryScheduleStorageLocation), "Storage Location Row 1",RI_DeliveryScheduleStorageLocation); 
		sendKeys(RI_DeliveryScheduleStrageLocationInput, RI_DeliveryScheduleStorageLocationData, "Storage Location Input", RI_DeliveryScheduleStorageLocation);

		//Date of Return
		//TC_RI_ER_56
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_56");
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDateofReturnKey, RI_DeliveryScheduleDateofReturn), "Date of Return Row 1",RI_DeliveryScheduleDateofReturn); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryScheduleDateofReturnData, "Date of Return Input", RI_DeliveryScheduleStorageLocation); 

		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", RI_DeliveryScheduleAllocateButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath); 
		verifyTextMatches(RI_DeliveryScheduleDeliverablesWarningWindowMsg, "Deliverables WarningWindowMsg", RI_DeliveryScheduleWarningMsg);
		verifyTextMatches(RI_DeliveryScheduleGroup1, "Group1 Msg", RI_DeliveryScheduleGroup1Msg);
		verifyTextMatches(RI_DeliveryScheduleGroup2, "Group1 Msg", RI_DeliveryScheduleGroup2Msg);

		clickUsingJSExecutor(RI_DeliveryScheduleGroup1CheckBox2, "Group1 CheckBox Cheked");
		Thread.sleep(2000);
		clickUsingJSExecutor(RI_DeliveryScheduleWarningWindowOkButton, "Ok Button");
		//View
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//1St Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn1stdRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn1stRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty1stRow, "View Mode Qty", RI_DeliveryScheduleQty3Data);
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC1stRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus1stRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);


		//2nd Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn2ndRow, "View Mode Due On", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn2ndRow, "View Mode Delivery on", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeQty2ndRow, "View Mode Qty", "0");
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC2ndRow, "View Mode Final QC", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus2ndRow, "View Mode QC Status", "");


		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		WaitForElementPresent(loc_Save);


		//Qty
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "DueOn Row 1",RI_DeliveryScheduleQty); 
		sendKeys(RI_DeliveryScheduleQtyInput, RI_DeliveryScheduleQty4Data, "Qty Input 32", RI_DeliveryScheduleQty);
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "It should only accept first three digit", RI_DeliveryScheduleQty4Data);

		//Final QC
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "DueOn Row 1",RI_DeliveryScheduleFinalQC); 
		clickOn(RI_DeliveryScheduleFinalQCImg, "FinalQC Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleFinalQCData1), "Final QC Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "Final QC", RI_DeliveryScheduleFinalQCData1);

		//Save
		//copy
		clickUsingJSExecutor(loc_Save, "Save Button", RI_DeliveryScheduleAllocateButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath); 


		clickUsingJSExecutor(RI_DeliveryScheduleGroup1CheckBox1, "Group1 CheckBox Cheked");
		Thread.sleep(2000);
		clickUsingJSExecutor(RI_DeliveryScheduleWarningWindowOkButton, "Ok Button");
		//View
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		//1St Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn1stdRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn1stRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty1stRow, "View Mode Qty", RI_DeliveryScheduleQty4Data);
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC1stRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData1);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus1stRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);


		//2nd Row	  
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn2ndRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn2ndRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty2ndRow, "View Mode Qty", "0");
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC2ndRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData1);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus2ndRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);



	}

	@Test(priority =3,enabled= true,description = "Verify Delete Functionality")
	public void TC3_DeliveryScheduleDeleteFunctionality() throws Exception {
		System.out.println("*********************Start Testcase TC3_Verify Delete Functionality *********************");
		//search created deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Delivery Schedule"), "Delivery Schedule TAB");
		rightIN.functionalityOfDeleteTheRow("TC_RI_DST_001 To TC_RI_DST_012", RI_DeliverySchedule1RowChild, "Child Row Delete", "N/A", RI_DeliveryScheduleDeleteRowConf);

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButtonCommon);
		clickOn(Loc_EditButtonCommon, "'Edit' Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		if(Browser.contains("ie")){
			clickUsingJSExecutor(RI_DeliverySchedule1RowParents, "Parents row"); 
		}else{
			clickOn(RI_DeliverySchedule1RowParents, "Parents row");
		}


		clickUsingJSExecutor(loc_Delete, "Delete Button");

		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", RI_DeliveryScheduleDeleteRowConf);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "'Save' Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(Loc_ErrorMsg, "Save Without Allocate", RI_DeliveryScheduleSaveWithoutAllocate);
		if(Browser.contains("ie")){
			clickUsingJSExecutor(RI_DeliverySchedule1RowAppliesTo, "AppliesTo row");
		}else
		{
			clickOn(RI_DeliverySchedule1RowAppliesTo, "AppliesTo row");
		}

		clickOn(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", RI_DeliveryScheduleDeleteRowConf);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Save, "'Save' Button");



	}
	@Test(priority =4,enabled= false,description = "Generate Production Deliverables Exhibit")
	public void TC3_DeliveryScheduleDeliverablesExhibit() throws Exception {
		System.out.println("*********************Start Testcase TC4_Generate Production Deliverables Exhibit *********************");
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";

		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);

		//search created deal
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Delivery Schedule"), "Delivery Schedule TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		WaitForElementPresent(loc_Save);

		//Add
		clickUsingJSExecutor(Loc_NewButton, "Add Button", RI_DeliveryScheduleAddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		verifyElementPresent(DeliverySchedule1Row, "New Row is created");
		WaitForElementPresent(loc_Save);

		//Applies To
		clickUsingJSExecutor(RI_DeliveryScheduleAppliesTo1Row, "AppliesTo Row 1",RI_DeliveryScheduleAppliesTo); 
		sendKeys(DeliveryScheduleAppiesToInput, RI_DeliveryScheduleAppliesToData, "AppliesTo Input", RI_DeliveryScheduleAppliesTo);
		Enter();

		//Allocate
		clickOn(DeliverySchedule1Row, "Select 1 Row");
		clickUsingJSExecutor(LocAdd, "Allocate Button");
		switchIntoFrame(frameParent4Xpath);  
		WaitForElementPresent(DeliveryScheduleCancel);
		Thread.sleep(2000);

		clickOn(DeliveryScheduleHDCam.replace("@var",RI_DeliveryScheduleHDCam ), "Select HD cam");
		Thread.sleep(2000);
		//verify
		verifyElementPresent(RI_DeliverySchedule_verifyCheckbox.replace("@var", RI_DeliveryScheduleHDCam), "Checked HD Cam");
		clickUsingJSExecutor(DeliveryScheduleSave, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath); 


		//DueOn
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDueOnKey, RI_DeliveryScheduleDueOn), "DueOn Row 1",RI_DeliveryScheduleDueOn); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryDueOnData, "Due On Input", RI_DeliveryScheduleDueOn);

		//Delivered on
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleDeliveredOnKey, RI_DeliveryScheduleDeliveredOn), "Delivered On Row 1",RI_DeliveryScheduleDeliveredOn); 
		sendKeys(RI_DeliveryScheduleDueOnInput, RI_DeliveryScheduleDeliveredOnData, "Delivered On Input", RI_DeliveryScheduleDeliveredOn);

		//Qty
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "DueOn Row 1",RI_DeliveryScheduleQty); 
		sendKeys(RI_DeliveryScheduleQtyInput, RI_DeliveryScheduleQty3Data, "Qty Input 12", RI_DeliveryScheduleQty);
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "It should only accept first three digit", RI_DeliveryScheduleQty3Data);

		//Final QC
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "DueOn Row 1",RI_DeliveryScheduleFinalQC); 
		clickOn(RI_DeliveryScheduleFinalQCImg, "FinalQC Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleFinalQCData), "Final QC Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "Final QC", RI_DeliveryScheduleFinalQCData);

		//QC Status
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQCStatusKey, RI_DeliveryScheduleQCStatus), "QCStatus Row 1",RI_DeliveryScheduleQCStatus); 
		clickOn(RI_DeliveryScheduleQCStatusImg, "QC Status Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleQCStatusData), "QC Status Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQCStatusKey, RI_DeliveryScheduleQCStatus), "QC Status", RI_DeliveryScheduleQCStatusData);

		//Save
		clickUsingJSExecutor(loc_Save, "Save Button", RI_DeliveryScheduleAllocateButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath); 
		verifyTextMatches(RI_DeliveryScheduleDeliverablesWarningWindowMsg, "Deliverables WarningWindowMsg", RI_DeliveryScheduleWarningMsg);
		verifyTextMatches(RI_DeliveryScheduleGroup1, "Group1 Msg", RI_DeliveryScheduleGroup1Msg);
		verifyTextMatches(RI_DeliveryScheduleGroup2, "Group1 Msg", RI_DeliveryScheduleGroup2Msg);

		clickUsingJSExecutor(RI_DeliveryScheduleGroup1CheckBox2, "Group1 CheckBox Cheked");
		Thread.sleep(2000);
		clickUsingJSExecutor(RI_DeliveryScheduleWarningWindowOkButton, "Ok Button");
		//View
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//1St Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn1stdRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn1stRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty1stRow, "View Mode Qty", RI_DeliveryScheduleQty3Data);
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC1stRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus1stRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);
		//2nd Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn2ndRow, "View Mode Due On", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn2ndRow, "View Mode Delivery on", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeQty2ndRow, "View Mode Qty", "0");
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC2ndRow, "View Mode Final QC", "");
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus2ndRow, "View Mode QC Status", "");


		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);  
		WaitForElementPresent(loc_Save);


		//Qty
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "DueOn Row 1",RI_DeliveryScheduleQty); 
		sendKeys(RI_DeliveryScheduleQtyInput, RI_DeliveryScheduleQty4Data, "Qty Input 32", RI_DeliveryScheduleQty);
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleQtyKey, RI_DeliveryScheduleQty), "It should only accept first three digit", RI_DeliveryScheduleQty4Data);

		//Final QC
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "DueOn Row 1",RI_DeliveryScheduleFinalQC); 
		clickOn(RI_DeliveryScheduleFinalQCImg, "FinalQC Dropdown");
		Thread.sleep(1000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_DeliveryScheduleFinalQCData1), "Final QC Data");
		Enter();
		verifyTextMatches(getLocator_EditTAB_DataRow("2", RI_DeliveryScheduleFinalQCKey, RI_DeliveryScheduleFinalQC), "Final QC", RI_DeliveryScheduleFinalQCData1);

		//Save
		//copy
		clickUsingJSExecutor(loc_Save, "Save Button", RI_DeliveryScheduleAllocateButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath); 


		clickUsingJSExecutor(RI_DeliveryScheduleGroup1CheckBox1, "Group1 CheckBox Cheked");
		Thread.sleep(2000);
		clickUsingJSExecutor(RI_DeliveryScheduleWarningWindowOkButton, "Ok Button");
		//View
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		//1St Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn1stdRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn1stRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty1stRow, "View Mode Qty", RI_DeliveryScheduleQty4Data);
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC1stRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData1);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus1stRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);


		//2nd Row
		verifyTextMatches(RI_DeliveryScheduleViewModeDueOn2ndRow, "View Mode Due On", RI_DeliveryDueOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeDeliveryOn2ndRow, "View Mode Delivery on", RI_DeliveryScheduleDeliveredOnData);
		verifyTextMatches(RI_DeliveryScheduleViewModeQty2ndRow, "View Mode Qty", "0");
		verifyTextMatches(RI_DeliveryScheduleViewModeFinalQC2ndRow, "View Mode Final QC", RI_DeliveryScheduleFinalQCData1);
		verifyTextMatches(RI_DeliveryScheduleViewModeQCStatus2ndRow, "View Mode QC Status", RI_DeliveryScheduleQCStatusData);


	}
	/*
	 *//**
	 * Row Number Starts from 2
	 *//*
public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
	String idx_HeadeNameFromExcel = getIDxValue(locator_EditTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
	String locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]//td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
	return locator;
}
	  *//**
	  * row is starting from 2 for "All" section
	  *//*
public String getLocator_ViewTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
	String idx_HeadeNameFromExcel = getIDxValue(locator_ViewModeTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
	String locator = locator_ViewMode_ColumnDataRow + "[" + rowNumber +"]//td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
	return locator;
}*/



	/**
	 * Starts from 1st Row
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(locator_EditTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
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

package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_Services extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();
	
	public RI_Services() {
		super(loc_RI_Services_ColumnXpath_EditMode, loc_RI_Services_DataRowXpath_EditMode, 
				loc_RI_Services_ColumnXpath_ViewMode, loc_RI_Services_DataRowXpath_ViewMode);
		className = this.getClass().getName();
	}
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);

	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";

	
	@Test(priority =1,enabled= true,description = "This test case covers the Services tab>UI")
	public void TC1_ServicesUI() throws InterruptedException, Exception {
		System.out.println("*********************Start Testcase - TC1_ServicesUI *********************");
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1 , "Standalone Agreement", "MML Synchronization License");
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		
		//Services	
		switchIntoFrame(frameParent2Xpath);
		
		
		/*if (Browser.equalsIgnoreCase("ie")) {
			
			scrollElementIntoView(loc_Tab.replace("@var", "Project Team"), "");
			Thread.sleep(3000);
		} else {
			
			scrollElementIntoView(loc_Tab.replace("@var", "Attributes"), "");
			Thread.sleep(3000);
		}*/
		
		
		clickOn(loc_Tab.replace("@var", "Services/Credits"), "Services/Credits TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//View Mode
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_02");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesAppliesToKey +"']", RI_ServicesAppliesToViewMode, "ApplesTo Field", RI_ServicesAppliesTo, "innerHTML");
		ExecutionLog.Log("Button");
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_Options_Edit,"Value");
		verifyTextMatches(Loc_RI_Options_SendReminder, "Send Reminder", RI_Options_SendReminder,"alt");
		//Edit Mode
		//TC_RI_ER_03
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_03");
		ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Options TAB*****"); 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesAppliesToKey +"']", RI_ServicesAppliesTo, "ApplesTo Field", RI_ServicesAppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesPartyKey +"']", RI_ServicesParty, "Party Field", RI_ServicesParty, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesRepresentedIndividualKey +"']", RI_ServicesRepresentedIndividual, "Represented Individual(s) Field", RI_ServicesRepresentedIndividual, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesServiceKey +"']", RI_ServicesService, "Service Field", RI_ServicesService, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesPerpetuityKey +"']", RI_ServicesPerpetuity, "Perpetuity Field", RI_ServicesPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesBeginKey +"']", RI_ServicesBegin, "Services Begin Field", RI_ServicesBegin, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesServicesEndKey +"']", RI_ServicesServicesEnd, "Services End Field", RI_ServicesServicesEnd, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesUnionSocietyKey +"']", RI_ServicesUnionSociety, "Service(s) Field", RI_ServicesUnionSociety, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesExclusivityKey +"']", RI_ServicesExclusivity, "Union / Society Field", RI_ServicesExclusivity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesServiceDetailsKey +"']", RI_ServicesServiceDetails, "ServiceDetails Field", RI_ServicesServiceDetails, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesPaidAdsKey +"']", RI_ServicesPaidAds, "PaidAds Field", RI_ServicesPaidAds, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesCreditTreatmentKey +"']", RI_ServicesCreditTreatment, "Credit Treatment Field", RI_ServicesCreditTreatment, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ServicesCharacterKey +"']", RI_ServicesCharacter, "Character Field", RI_ServicesCharacter, "innerHTML");
		
		//Button
		verifyTextMatches(loc_Copy1, "Copy",RI_ServicesCopyRow,"Value");
		verifyTextMatches(Loc_NewButton, "Add",RI_ServicesAdd,"Value");
		verifyTextMatches(loc_Delete, "Delete",RI_ServicesDelete,"Value");
		verifyTextMatches(loc_Save, "Ok",RI_ServicesSave,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",RI_ServicesCancel,"Value");
		
		//Add
		//TC_RI_OpT_005
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_OpT_005");
		clickUsingJSExecutor(Loc_NewButton, "Add");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyElementPresent(Loc_RI_ServicesRow1, "Row 1");
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_ServicesErrorMsg);
		//Applies To
		//TC_RI_ST_007
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_007");
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesAppliesToKey, RI_ServicesAppliesTo), "AppliesTo Row 1",RI_ServicesAppliesTo); 
		sendKeys(Loc_RI_ServicesAppliesToInput, RI_ServicesAppliesToData, "Applies To Input", RI_ServicesAppliesTo);
		
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		/*//Pick List  //
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesAppliesToImgKey, RI_ServicesAppliesTo)+"/img", "AppliesTo Pick List",RI_ServicesAppliesTo);
		rightIN.appliesTOPopUpWindow("TC_RI_ST_007 To TC_RI_ST_021 ", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);*/
	
		//TC_RI_ST_022
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_22");
	   
		//Party
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesPartyKey, RI_ServicesParty), "Party Row 1",RI_ServicesParty); 
		sendKeys(Loc_RI_ServicesPartyInput, RI_ServicesPartyData, "Party To Input", RI_ServicesParty);
		
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
        //Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesPartyImgKey, RI_ServicesParty)+"/img", "Party  pick List",RI_ServicesParty); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		Thread.sleep(3000);
		if(ClientName.contains("AMCN")){
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, "Cancel button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		//Represented Individual(s)
		
		
		//No Data for VMN Represented Individual(s)
		
		
		//TC_RI_ST_032
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_032");
		//Service
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServiceKey, RI_ServicesService), "Service Row 1",RI_ServicesService); 
		sendKeys(Loc_RI_ServicesInput, RI_ServicesData, "Services Input", RI_ServicesService);
	
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		//Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesImgKey, RI_ServicesService)+"/img", "Service  pick List",RI_ServicesService); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(6000);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(2000);
		switchIntoFrame(frameParent4Xpath);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		Thread.sleep(2000);
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(2000);
		switchIntoFrame(frameParent4Xpath);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		Thread.sleep(3000);
		if(ClientName.contains("AMCN")){
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, "Cancel button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		
		
		//Perpetuity
		//TC_RI_ST_041
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_041");
		
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1",RI_ServicesPerpetuityKey, RI_ServicesPerpetuity), RI_ServicesPerpetuity);
		
		//Service Begin
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesBeginKey, RI_ServicesBegin), "Service Begin Field",RI_ServicesBegin); 
		sendKeys(Loc_RI_ServicesBeginInput, RI_ServiceBeginData, "Service Begin Input", RI_ServicesBegin);
		
		//Service End
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServicesEndKey, RI_ServicesServicesEnd), "Service End Field",RI_ServicesServicesEnd); 
		sendKeys(Loc_RI_ServicesEndInput, RI_ServiceEndData, "Service End Input", RI_ServicesBegin);
		
		
		//Union / Society
		//TC_RI_ST_046
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_046");
		
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		//Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesUnionImgKey, RI_ServicesUnionSociety)+"/img", "Union  pick List",RI_ServicesUnionSociety); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");

		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(2000);
		switchIntoFrame(frameParent4Xpath);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(2000);
		switchIntoFrame(frameParent4Xpath);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		Thread.sleep(3000);
		if(ClientName.contains("AMCN")){
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, "Cancel button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesUnionSocietyKey, RI_ServicesUnionSociety), "Union Row 1",RI_ServicesUnionSociety); 
		sendKeys(Loc_RI_ServicesUnionInput, RI_ServicesUnionData, "Union Input", RI_ServicesUnionSociety);
		
		
		// Exclusivity
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesExclusivityKey, RI_ServicesExclusivity)+"/img", "Exclusivity  pick List",RI_ServicesExclusivity); 
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header1+"']", 	RI_BUSINESS_TERMS_Header1, 	"RI_BUSINESS_TERMS_Header1",	RI_BUSINESS_TERMS_Header1,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header2+"']", 	RI_BUSINESS_TERMS_Header2, 	"RI_BUSINESS_TERMS_Header2",	RI_BUSINESS_TERMS_Header2,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header3+"']", 	RI_BUSINESS_TERMS_Header3, 	"RI_BUSINESS_TERMS_Header3",	RI_BUSINESS_TERMS_Header3,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header4+"']", 	RI_BUSINESS_TERMS_Header4, 	"RI_BUSINESS_TERMS_Header4",	RI_BUSINESS_TERMS_Header4,				"innerHTML");
		verifyFieldValueOfHeader(LocAdd, 			RI_NoteWindow_AddButton, 		"RI_NoteWindow_AddButton", 		RI_NoteWindow_AddButton, 		"value");
		verifyFieldValueOfHeader(loc_Delete, 		RI_NoteWindow_DeleteButton, 	"RI_NoteWindow_DeleteButton", 	RI_NoteWindow_DeleteButton, 	"value");
		verifyFieldValueOfHeader(loc_Save, 			RI_NoteWindow_SaveButton, 		"RI_NoteWindow_SaveButton", 	RI_NoteWindow_SaveButton, 		"value");
		verifyFieldValueOfHeader(loc_Cancel, 		RI_NoteWindow_CancelButton, 	"RI_NoteWindow_CancelButton", 	RI_NoteWindow_CancelButton, 	"value");
		clickOn(LocAdd, "Add Button at Notes Window",RI_BUSINESS_TERMS_HeaderName);

		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), "Business Term Field",	RI_MediaRights_NoteWind_Category_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Business Term Drop Down image",	RI_MediaRights_NoteWind_Category_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", ExclusivityData1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "Use Template Field",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Use Template Drop Down image",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", ExclusivityData2), RI_MediaRights_Note_UseTemplate1 ,RI_MediaRights_NoteWind_Template_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Notes_Key, RI_MediaRights_NoteWind_Notes_HeaderName), "Term Description Field",	RI_MediaRights_NoteWind_Notes_HeaderName);
		sendKeys(loc_RI_MediaRights_NoteWind_Descrip_InputField, "RSG@$!%&*()_", "Term Description Data", RI_MediaRights_NoteWind_Notes_HeaderName);
		
		// Verify Restriction check box
		ExecutionLog.Log("");
		ExecutionLog.Log("*********Verify Restriction check box*******");
		clickUsingJSExecutor(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Unchecked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");

		// Verify includeInReport check box.
		ExecutionLog.Log("");
		ExecutionLog.Log("*********Verify includeInReport check box*******");
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
		verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Unchecked']", "NoteWind_includeInReport Check Box is Checked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
		verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Checked']", "NoteWind_includeInReport Check Box is Unchecked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
		Thread.sleep(3000);
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

		
		//Service Details
		//ServiceDetailsData1
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details field",RI_ServicesServiceDetails); 
		sendKeys(Loc_RI_ServicesDetailsInput, ServiceDetailsData1, "Service Details Input", RI_ServicesServiceDetails);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details verify ", ServiceDetailsData1);
		
		//ServiceDetailsData2
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details field",RI_ServicesServiceDetails); 
		sendKeys(Loc_RI_ServicesDetailsInput, ServiceDetailsData2, "Service Details Input", RI_ServicesServiceDetails);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details verify ", ServiceDetailsData2);
		
		//ServiceDetailsData3
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details field",RI_ServicesServiceDetails); 
		sendKeys(Loc_RI_ServicesDetailsInput, ServiceDetailsData3, "Service Details Input", RI_ServicesServiceDetails);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details verify ", ServiceDetailsData3);
		
		//ServiceDetailsData3
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details field",RI_ServicesServiceDetails); 
		sendKeys(Loc_RI_ServicesDetailsInput, ServiceDetailsData4, "Service Details Input", RI_ServicesServiceDetails);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesServiceDetailsKey, RI_ServicesServiceDetails), "Service Details verify ", ServiceDetailsData4);
		
		//Paid Ads
	
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1",RI_ServicesPaidAdsKey, RI_ServicesPaidAds), RI_ServicesPaidAds);
		
		//Credit Treatment
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTreatmentKey, RI_ServicesCreditTreatment)+"/img", "CreditTreatment  pick List",RI_ServicesCreditTreatment);
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header1+"']", 	RI_BUSINESS_TERMS_Header1, 	"RI_BUSINESS_TERMS_Header1",	RI_BUSINESS_TERMS_Header1,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header2+"']", 	RI_BUSINESS_TERMS_Header2, 	"RI_BUSINESS_TERMS_Header2",	RI_BUSINESS_TERMS_Header2,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header3+"']", 	RI_BUSINESS_TERMS_Header3, 	"RI_BUSINESS_TERMS_Header3",	RI_BUSINESS_TERMS_Header3,				"innerHTML");
		verifyFieldValueOfHeader("//th[text()='"+RI_BUSINESS_TERMS_Header4+"']", 	RI_BUSINESS_TERMS_Header4, 	"RI_BUSINESS_TERMS_Header4",	RI_BUSINESS_TERMS_Header4,				"innerHTML");
		verifyFieldValueOfHeader(LocAdd, 			RI_NoteWindow_AddButton, 		"RI_NoteWindow_AddButton", 		RI_NoteWindow_AddButton, 		"value");
		verifyFieldValueOfHeader(loc_Delete, 		RI_NoteWindow_DeleteButton, 	"RI_NoteWindow_DeleteButton", 	RI_NoteWindow_DeleteButton, 	"value");
		verifyFieldValueOfHeader(loc_Save, 			RI_NoteWindow_SaveButton, 		"RI_NoteWindow_SaveButton", 	RI_NoteWindow_SaveButton, 		"value");
		verifyFieldValueOfHeader(loc_Cancel, 		RI_NoteWindow_CancelButton, 	"RI_NoteWindow_CancelButton", 	RI_NoteWindow_CancelButton, 	"value");
		clickOn(LocAdd, "Add Button at Notes Window",RI_BUSINESS_TERMS_HeaderName);

		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), "Business Term Field",	RI_MediaRights_NoteWind_Category_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Business Term Drop Down image",	RI_MediaRights_NoteWind_Category_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", CreditTreatmentData1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "Use Template Field",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Use Template Drop Down image",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", CreditTreatmentData2), RI_MediaRights_Note_UseTemplate1 ,RI_MediaRights_NoteWind_Template_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Notes_Key, RI_MediaRights_NoteWind_Notes_HeaderName), "Term Description Field",	RI_MediaRights_NoteWind_Notes_HeaderName);
		sendKeys(loc_RI_MediaRights_NoteWind_Descrip_InputField, "RSG@$!%&*()_", "Term Description Data", RI_MediaRights_NoteWind_Notes_HeaderName);
		
		// Verify Restriction check box
		ExecutionLog.Log("");
		ExecutionLog.Log("*********Verify Restriction check box*******");
		clickUsingJSExecutor(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Unchecked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "NoteWind_Restriction Check Box",	RI_MediaRights_NoteWind_Restriction_HeaderName);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Restriction_Key, RI_MediaRights_NoteWind_Restriction_Key)+"/img", "Checked",  "Restriction Check Box status", RI_MediaRights_NoteWind_Restriction_HeaderName, "title");

		// Verify includeInReport check box.
		ExecutionLog.Log("");
		ExecutionLog.Log("*********Verify includeInReport check box*******");
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
		verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Unchecked']", "NoteWind_includeInReport Check Box is Checked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
		verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Checked']", "NoteWind_includeInReport Check Box is Unchecked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
		Thread.sleep(3000);
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img", "NoteWind_includeInReport Check Box",	RI_MediaRights_NoteWind_includeInReport_HeaderName);
		verifyElementPresent(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_includeInReport_Key, RI_MediaRights_NoteWind_includeInReport_Key)+"/img[@title='Unchecked']", "NoteWind_includeInReport Check Box is Checked", RI_MediaRights_NoteWind_includeInReport_HeaderName);
		
		// Verify the entered data is shown at the Note Window
		switchIntoFrame(frameParent4Xpath);
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), CreditTreatmentData1, "RI_MediaRights_NoteWind_Category_HeaderName",RI_MediaRights_NoteWind_Category_HeaderName, "innerHTML");
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "", "RI_MediaRights_NoteWind_Template_HeaderName",RI_MediaRights_NoteWind_Template_HeaderName, "innerHTML");
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		verifyElementNotPresent(frameParent4Xpath, "Note Window");
		switchIntoFrame(frameParent3Xpath);
		
		
		
		//Character
		//TC_RI_ST_096
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ST_096");
		scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_ServicesDocumentLinkKey, RI_ServicesDocumentLink));
		Thread.sleep(3000);
		//RI_ServicesCharacterData1
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Character Row 1",RI_ServicesCharacter); 
		sendKeys(Loc_RI_ServicesCharacterInput, RI_ServicesCharacterData1, "Character Input", RI_ServicesCharacter);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Enter Data Verify", RI_ServicesCharacterData1);
		
		//RI_ServicesCharacterData2
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Character Row 1",RI_ServicesCharacter); 
		sendKeys(Loc_RI_ServicesCharacterInput, RI_ServicesCharacterData2, "Character Input", RI_ServicesCharacter);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Enter Data Verify", RI_ServicesCharacterData2);
		
		//RI_ServicesCharacterData3
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Character Row 1",RI_ServicesCharacter); 
		sendKeys(Loc_RI_ServicesCharacterInput, RI_ServicesCharacterData3, "Character Input", RI_ServicesCharacter);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Enter Data Verify", RI_ServicesCharacterData3);
		
		//RI_ServicesCharacterData4
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Character Row 1",RI_ServicesCharacter); 
		sendKeys(Loc_RI_ServicesCharacterInput, RI_ServicesCharacterData4, "Character Input", RI_ServicesCharacter);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCharacterKey, RI_ServicesCharacter), "Enter Data Verify", RI_ServicesCharacterData4);
		
		//Credit Text
		//CreditTextData1
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Credit Text Row 1",RI_ServicesCreditText); 
		sendKeys(Loc_RI_ServicesDetailsInput, CreditTextData1, "Credit Text Input", RI_ServicesCreditText);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Enter Data Verify", CreditTextData1);
		
		//CreditTextData2
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Credit Text Row 1",RI_ServicesCreditText); 
		sendKeys(Loc_RI_ServicesDetailsInput, CreditTextData2, "Credit Text Input", RI_ServicesCreditText);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Enter Data Verify", CreditTextData2);
		
		
		//CreditTextData3
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Credit Text Row 1",RI_ServicesCreditText); 
		sendKeys(Loc_RI_ServicesDetailsInput, CreditTextData3, "Credit Text Input", RI_ServicesCreditText);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Enter Data Verify", CreditTextData3);
		
		//CreditTextData4
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Credit Text Row 1",RI_ServicesCreditText); 
		sendKeys(Loc_RI_ServicesDetailsInput, CreditTextData4, "Credit Text Input", RI_ServicesCreditText);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Enter Data Verify", CreditTextData4);
		
		//CreditTextData1
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Credit Text Row 1",RI_ServicesCreditText); 
		sendKeys(Loc_RI_ServicesDetailsInput, CreditTextData1, "Credit Text Input", RI_ServicesCreditText);
		Enter();
		Thread.sleep(2000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ServicesCreditTextKey, RI_ServicesCreditText), "Enter Data Verify", CreditTextData1);

		/*//Notes
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesNotesKey, RI_ServicesNotes)+"/img", "Notes  pick List",RI_ServicesNotes); 
	
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);*/
		
		//Document Link
		clickOn(getLocator_EditTAB_DataRow("1", RI_ServicesDocumentLinkKey, RI_ServicesDocumentLink), "Document Link Row 1",RI_ServicesDocumentLink); 
		sendKeys(Loc_RI_ServicesDetailsInput, DocumentlinkData, "Document Link Input", RI_ServicesCreditText);
		Enter();
		
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		//view Mode 
		verifyTextMatches(Loc_RI_ServicesAppliesToViewMode, "Applies To View Mode verify", RI_ServicesAppliesToData);
		verifyTextMatches(getLocator_ViewTAB_DataRow("1","2", RI_ServicesPartyKey, RI_ServicesParty), "Party Enter Data Verify", RI_ServicesParty);
		verifyTextMatches(getLocator_ViewTAB_DataRow("1","2", RI_ServicesServiceKey, RI_ServicesService), "Service Enter Data Verify", RI_ServicesService);
		verifyTextMatches(getLocator_ViewTAB_DataRow("1","2", RI_ServicesUnionSocietyKey, RI_ServicesUnionSociety), "Union Enter Data Verify", RI_ServicesUnionSociety);
		verifyTextMatches(getLocator_ViewTAB_DataRow("1","2", RI_ServicesCharacterKey, RI_ServicesCharacter), "Character Enter Data Verify", RI_ServicesCharacter);
		
		
		
		
		System.out.println("*********************End Testcase - TC1_ServicesUI *********************");
	}
	
	@Test(priority =2,enabled= true,description = "Verify Copy Functionality")
	public void TC2_ServicesCopy() throws Exception {
		System.out.println("*********************Start Testcase - TC2_ServicesCopy *********************");	
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Services/Credits"), "Services/Credits TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);

		clickUsingJSExecutor(loc_CopyButton, "copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_ObligationsCopyWithoutSelectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(Loc_RI_ServicesRow1.replace("@var", "1"), "Selate 1 Row");
		Thread.sleep(1000);
		clickUsingJSExecutor(loc_CopyButton, "copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(PromptAlertValidationMessgeText, "Promo  Msg", RI_ObligationsCopyWinEnterNoMsg);
		clickOn(loc_PromptBoxInput, "Prompt Input", "");
		sendKeys(loc_PromptBoxInput, RI_ObligationsInvalidCopyData, "Prompt Copy Input", "");
		clickUsingJSExecutor(loc_PromptOkButton, "Ok Button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_ObligationsCopyWinInvaldMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		sendKeys(loc_PromptBoxInput, RI_ObligationsvalidCopyData, "Prompt Copy Input", "");
		clickUsingJSExecutor(loc_PromptOkButton, "Ok Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyElementPresent(Loc_RI_ServicesRow1.replace("@var", "1"), "Row 1");
		verifyElementPresent(Loc_RI_ServicesRow1.replace("@var", "2"), "Row 2");
		verifyElementPresent(Loc_RI_ServicesRow1.replace("@var", "3"), "Row 3");
		verifyElementPresent(Loc_RI_ServicesRow1.replace("@var", "4"), "Row 4");
		verifyElementPresent(Loc_RI_ServicesRow1.replace("@var", "5"), "Row 5");

		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		System.out.println("*********************End Testcase - TC2_ServicesCopy *********************");
	}
	
	@Test(priority =3,enabled= true,description = "Delete Functionality")
	public void TC3_ServicesDelete() throws Exception {
		System.out.println("*********************Start Testcase - TC3_ServicesDelete *********************");	
		//Search Deal
		
		rightIN.searchCreatedDeal(CreatedDeal1);
 		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Services/Credits"), "Services/Credits TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_ObligationsSelectRowDeleteMsg, "Alert Message do not select the row and click Delete", RI_ObligationsSelectRowDeleteMsg);
		
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath");
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
	    clickOn(Loc_RI_ServicesRow1.replace("@var", "1"), "First row"); 
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_ObligationsConfDeleteMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_ObligationsConfDeleteMsg);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_ObligationsConfDeleteMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_ObligationsConfDeleteMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath );
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button  Edit window", RI_MediaRights_EditMode_closeButton);
		
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(Loc_EditButton2));
		if(Browser.contains("firefox")){
			clickUsingJSExecutor(Loc_EditButton2, "'Edit' Button");
		}else{
			clickOn(Loc_EditButton2, "'Edit' Button");
		}
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_RI_ServicesRow1.replace("@var", "1"), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_ObligationsConfDeleteMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();

		System.out.println("*********************End Testcase - TC3_ServicesDelete *********************");
	}
	
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_Services_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Services_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Services_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	
	public String getLocator_ViewTAB_DataRow(String rowNumber_Asset, String rowNumber_Data, String KeyValueFromExcel, String HeadeNameFromExcel){
		String classValue = getClassValue(loc_RI_Services_ColumnXpath_ViewMode.replace("@var", rowNumber_Asset), KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_Services_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_Services_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
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

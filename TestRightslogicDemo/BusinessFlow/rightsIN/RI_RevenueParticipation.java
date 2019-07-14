package rightsIN;

import java.awt.AWTException;
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
public class RI_RevenueParticipation extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
	
	public RI_RevenueParticipation() {
		super(loc_RI_RevenueParticipation_ColumnXpath_EditMode, loc_RI_RevenueParticipation_DataRowXpath_EditMode, 
				loc_RI_RevenueParticipation_ColumnXpath_ViewMode, loc_RI_RevenueParticipation_DataRowXpath_ViewMode);
		className = this.getClass().getName();
	}
	 

	@Test(priority =1,enabled= true,description = "This test case covers the Services tab>UI")
	public void TC1_RevenueParticipationUI() throws InterruptedException, Exception {
	
		System.out.println("*********************Start Testcase - TC1_RevenueParticipationUI *********************");
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		//RevenueParticipation	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Revenue Participation"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
	    
		//View Mode
		//TC_RI_ER_02
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_002");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationAppliesToKey +"']", RI_RevenueParticipationAppliesToViewMode, "ApplesTo Field", RI_RevenueParticipationAppliesToViewMode, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_RevenueParticipationStatementSchedule, RI_RevenueParticipationStatementSchedule, " StatementSchedule Verify ", RI_RevenueParticipationStatementSchedule);
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_Options_Edit,"Value");
		verifyTextMatches(loc_RI_RevenueParticipationSendReminder, "Send Reminder", RI_RevenueParticipation_SendReminder,"alt");
		
		//Edit Mode
		//TC_RI_RP_003
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_003");
		ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Options TAB*****"); 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationAppliesToKey +"']", RI_RevenueParticipationAppliesTo, "ApplesTo Field", RI_RevenueParticipationAppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationPartyKey +"']", RI_RevenueParticipationParty, "Party Field", RI_RevenueParticipationParty, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationServicesKey +"']", RI_RevenueParticipationServices, "Services Field", RI_RevenueParticipationServices, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationRightsMediaKey +"']", RI_RevenueParticipationRightsMedia, "RightsMedia Field", RI_RevenueParticipationRightsMedia, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationTerritoryKey +"']", RI_RevenueParticipationTerritory, "Territory Field", RI_RevenueParticipationTerritory, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationCurrencyKey +"']", RI_RevenueParticipationCurrency, "Currency Field", RI_RevenueParticipationCurrency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationFixedAmountKey +"']", RI_RevenueParticipationFixedAmount, "Fixed Amount Field", RI_RevenueParticipationFixedAmount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationRepresentedIndividualKey +"']", RI_RevenueParticipationRepresentedIndividual, "Represented Individual Field", RI_RevenueParticipationRepresentedIndividual, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationPercentageKey +"']", RI_RevenueParticipationPercentage, " Percentage Field", RI_RevenueParticipationPercentage, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationBackendFormulaKey +"']", RI_RevenueParticipationBackendFormula, " Backend Formula Field", RI_RevenueParticipationBackendFormula, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_RevenueParticipationPaymentTermsKey +"']", RI_RevenueParticipationPaymentTerms, " Payment Terms Field", RI_RevenueParticipationPaymentTerms, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_NoRevenueParticipation, RI_NoRevenueParticipation, "No Revenue Participation", RI_NoRevenueParticipation);
		//Button
		verifyTextMatches(loc_RI_NoRevenueParticipationCopyButton, "Copy",RI_Options_CopyRow,"Value");
		verifyTextMatches(Loc_NewButton, "Add",RI_Options_Add,"Value");
		verifyTextMatches(loc_Delete, "Delete",RI_Options_Delete,"Value");
		verifyTextMatches(loc_Save, "Ok",RI_Options_Save,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",RI_Options_Cancel,"Value");
		//Add
		//TC_RI_RP_005
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_005");
		clickUsingJSExecutor(Loc_NewButton, "Add");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "1"), "Row 1");
		//Save
		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_RevenueParticipationErrorMsg);
		//Applies To
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationAppliesToKey, RI_RevenueParticipationAppliesTo), "AppliesTo Row 1",RI_RevenueParticipationAppliesTo); 
		sendKeys(loc_RI_RevenueParticipationAppliesToInput, RI_RevenueParticipationAppliesToData, "Applies To Input", RI_RevenueParticipationAppliesTo);
		Enter();
		Thread.sleep(3000);

		//Applies To Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationAppliesToImgKey, RI_RevenueParticipationAppliesTo)+"/img", "AppliesTo  Img Row 1",RI_RevenueParticipationAppliesTo); 
		rightIN.appliesTOPopUpWindow("TC_RI_RP_007 To TC_RI_RP_021 ", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		//Party
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPartyKey, RI_RevenueParticipationParty), "Party Row 1",RI_RevenueParticipationParty); 
		sendKeys(loc_RI_RevenueParticipationPartyInput, RI_RevenueParticipationPartyData, "Party Input", RI_RevenueParticipationParty);
		Thread.sleep(2000);
		Enter();

		//Pick List
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_023 To TC_RI_RP_031 ");
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPartyImgKey, RI_RevenueParticipationParty)+"/img", "Party  Img Row 1",RI_RevenueParticipationParty); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		WaitForElementPresent(Loc_SelectAll);
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

		//Service
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationServicesKey, RI_RevenueParticipationServices), "Service Row 1",RI_RevenueParticipationServices); 
		sendKeys(loc_RI_RevenueParticipationServiceInput, RI_RevenueParticipationServiceData, "Party Input", RI_RevenueParticipationServices);
		Thread.sleep(2000);
		Enter();
		//Pick List
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_034 To TC_RI_RP_039 ");
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationServicesImgKey, RI_RevenueParticipationServices)+"/img", "Service Img Row 1",RI_RevenueParticipationServices); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(3000);
		WaitForElementPresent(Loc_SelectAll);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(3000);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(3000);
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
		//Media Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationRightsMediaKey, RI_RevenueParticipationRightsMedia), "Service Row 1",RI_RevenueParticipationRightsMedia); 
		sendKeys(loc_RI_RevenueParticipationMediaInput, RI_RevenueParticipationMediaData, "Media Input", RI_RevenueParticipationRightsMedia);
		Thread.sleep(2000);
		Enter();
		//Pick List
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_042");
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationRightsMediaImgKey, RI_RevenueParticipationRightsMedia)+"/img", "Media Img Row 1",RI_RevenueParticipationRightsMedia); 
		rightIN.functionalityOfPopUpWindow("TC_RI_RP_043 To TC_RI_RP_053", RI_RevenueParticipationRightsMedia, "N/A");
		switchIntoFrame(frameParent3Xpath);
		//Territory
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationTerritoryKey, RI_RevenueParticipationTerritory), "Service Row 1",RI_RevenueParticipationTerritory); 
		sendKeys(loc_RI_RevenueParticipationTerritoryInput, RI_RevenueParticipationTerritoryData, "Territory Input", RI_RevenueParticipationTerritory);
		Thread.sleep(2000);
		Enter();
		//pick List
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_RP_042");
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationTerritoryImgKey, RI_RevenueParticipationTerritory)+"/img", "Territory Img Row 1",RI_RevenueParticipationTerritory); 
		rightIN.functionalityOfPopUpWindow("TC_RI_RP_077 To TC_RI_RP_088", RI_RevenueParticipationTerritory, "N/A");
		switchIntoFrame(frameParent3Xpath);

		//Percentage
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPercentageKey, RI_RevenueParticipationPercentage), "Percentage Row 1",RI_RevenueParticipationPercentage); 
		sendKeys(loc_RI_RevenueParticipationParticipationInput, RI_RevenueParticipationParticipationData, "Percentage Input", RI_RevenueParticipationPercentage);
		Thread.sleep(2000);
		Enter();

		//Backend Formula
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationBackendFormulaKey, RI_RevenueParticipationBackendFormula), "Backend Formula Row 1",RI_RevenueParticipationBackendFormula); 
		sendKeys(loc_RI_RevenueParticipationBackendFormulaInput, RI_RevenueParticipationBackendFormulaData, "Backend Formula Input", RI_RevenueParticipationBackendFormula);
		Thread.sleep(2000);
		Enter();

		//Payment Terms
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPaymentTermsKey, RI_RevenueParticipationPaymentTerms)+"/img", "Payment Terms Img Row 1",RI_RevenueParticipationPaymentTerms); 
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(LocAdd);
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
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_RevenueParticipationPaymentTermsData1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "Use Template Field",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Use Template Drop Down image",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_RevenueParticipationPaymentTermsData2), RI_MediaRights_Note_UseTemplate1 ,RI_MediaRights_NoteWind_Template_HeaderName);

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
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Category_Key, RI_MediaRights_NoteWind_Category_HeaderName), RI_RevenueParticipationPaymentTermsData1, "RI_MediaRights_NoteWind_Category_HeaderName",RI_MediaRights_NoteWind_Category_HeaderName, "innerHTML");
		verifyFieldValueOfHeader(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "", "RI_MediaRights_NoteWind_Template_HeaderName",RI_MediaRights_NoteWind_Template_HeaderName, "innerHTML");
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		verifyElementNotPresent(frameParent4Xpath, "Note Window");
		switchIntoFrame(frameParent3Xpath);

		//Currency
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationCurrencyKey, RI_RevenueParticipationCurrency), " Currency Row 1",RI_RevenueParticipationCurrency); 
		sendKeys(loc_RI_RevenueParticipationCurrencyInput, RI_RevenueParticipationCurrencyData, "Currency Input", RI_RevenueParticipationCurrency);
		Enter();
		Thread.sleep(2000);
		

		//Amount
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationFixedAmountKey, RI_RevenueParticipationFixedAmount), "Fixed Amount Row 1",RI_RevenueParticipationFixedAmount); 
		sendKeys(loc_RI_RevenueParticipationAmountInput, RI_RevenueParticipationAmountData, "Fixed Amount Input", RI_RevenueParticipationFixedAmount);
		Thread.sleep(2000);
		Enter();


		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		Thread.sleep(5000);
		WaitForElementPresent(Loc_EditButton2);
		System.out.println("*********************End Testcase - TC1_RevenueParticipationUI *********************");
	}
	@Test(priority =2,enabled= true,description = "To verify behavior of fields in Rights Out RevenueParticipation Tab")
	public void TC2_RevenueParticipationView() throws Exception {
		System.out.println("*********************Start Testcase - TC2_RevenueParticipationView *********************");
		
		 //Search Deal
	    rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Revenue Participation"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
	       
		//View Mode 
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationPartyKey, RI_RevenueParticipationParty), RI_RevenueParticipationPartyData, "Party ", RI_RevenueParticipationParty,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationServicesKey, RI_RevenueParticipationServices), RI_RevenueParticipationServiceData, "Services ", RI_RevenueParticipationServices,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationRightsMediaKey, RI_RevenueParticipationRightsMedia), RI_RevenueParticipationMediaData1, "Media ", RI_RevenueParticipationRightsMedia,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationTerritoryKey, RI_RevenueParticipationTerritory), RI_RevenueParticipationTerritoryData, "Territory ", RI_RevenueParticipationTerritory,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationPercentageKey, RI_RevenueParticipationPercentage), RI_RevenueParticipationParticipationData, "Percentage ", RI_RevenueParticipationPercentage,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationBackendFormulaKey, RI_RevenueParticipationBackendFormula), RI_RevenueParticipationBackendFormulaData, "Backend Formula ", RI_RevenueParticipationBackendFormula,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationCurrencyKey, RI_RevenueParticipationCurrency), RI_RevenueParticipationCurrencyData, "Currency  ", RI_RevenueParticipationCurrency,"innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_RevenueParticipationFixedAmountKey, RI_RevenueParticipationFixedAmount), RI_RevenueParticipationAmountData, "Fixed Amount  ", RI_RevenueParticipationFixedAmount,"innerHTML");
		
		
		System.out.println("*********************End Testcase - TC2_RevenueParticipationView *********************");
	}
	@Test(priority =3,enabled= true,description = "This test case covers the Revenue Participation checkbox")
	public void TC3_NoRevenueParticipationcheckbox() throws Exception{
		System.out.println("*********************Start Testcase - TC3_NoRevenueParticipationcheckbox *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Revenue Participation"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//Edit
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		clickOn(loc_RI_NoRevenueParticipationCheckBox, "No Revenue Participation", RI_NoRevenueParticipation);
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "No Revenue Participation Conf Msg", RI_NoRevenueParticipationConf);
		clickOn(ConfirmAlertButtonXpath, "Ok Button", RI_NoRevenueParticipation);
		switchIntoFrame(frameParent3Xpath);
		verifyElementNotPresent(loc_RI_RevenueParticipationRow.replace("@var", "1"), "Delete all row");
		WaitForElementPresent(Loc_NewButton);
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
       //No Revenue Participation  In View mode
		verifyElementDisplayed(loc_RI_NoRevenueParticipationCheckBoxInViewMode, "No Revenue Participation View mode", RI_NoRevenueParticipation);
		
		//Extra Code for uncheck No Revenue Participation
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		clickOn(loc_RI_NoRevenueParticipationCheckBox, "No Revenue Participation", RI_NoRevenueParticipation);
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		System.out.println("*********************End Testcase - TC3_NoRevenueParticipationcheckbox *********************");
	}
	@Test(priority =4,enabled= true,description = "Copy Row(s) functionality")
	public void TC4_RevenueParticipationCopyRows() throws Exception, AWTException {
		System.out.println("*********************Start Testcase - TC4_RevenuePartcipationCopyRow *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Revenue Participation"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//Edit
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
	
		//Add Row
		clickUsingJSExecutor(Loc_NewButton, "Add");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "1"), "Row 1");
	
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		Thread.sleep(2000);
		
		//Applies To
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationAppliesToKey, RI_RevenueParticipationAppliesTo), "AppliesTo Row 1",RI_RevenueParticipationAppliesTo); 
		sendKeys(loc_RI_RevenueParticipationAppliesToInput, RI_RevenueParticipationAppliesToData, "Applies To Input", RI_RevenueParticipationAppliesTo);
		Enter();
		Thread.sleep(3000);

		//Party
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPartyKey, RI_RevenueParticipationParty), "Party Row 1",RI_RevenueParticipationParty); 
		sendKeys(loc_RI_RevenueParticipationPartyInput, RI_RevenueParticipationPartyData, "Party Input", RI_RevenueParticipationParty);
		Thread.sleep(2000);
		Enter();
		//Service
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationServicesKey, RI_RevenueParticipationServices), "Service Row 1",RI_RevenueParticipationServices); 
		sendKeys(loc_RI_RevenueParticipationServiceInput, RI_RevenueParticipationServiceData, "Party Input", RI_RevenueParticipationServices);
		Thread.sleep(2000);
		Enter();
		//Media Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationRightsMediaKey, RI_RevenueParticipationRightsMedia), "Service Row 1",RI_RevenueParticipationRightsMedia); 
		sendKeys(loc_RI_RevenueParticipationMediaInput, RI_RevenueParticipationMediaData, "Media Input", RI_RevenueParticipationRightsMedia);
		Thread.sleep(2000);
		Enter();
		//Territory
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationTerritoryKey, RI_RevenueParticipationTerritory), "Service Row 1",RI_RevenueParticipationTerritory); 
		sendKeys(loc_RI_RevenueParticipationTerritoryInput, RI_RevenueParticipationTerritoryData, "Territory Input", RI_RevenueParticipationTerritory);
		Thread.sleep(2000);
		Enter();
		//Percentage
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationPercentageKey, RI_RevenueParticipationPercentage), "Percentage Row 1",RI_RevenueParticipationPercentage); 
		sendKeys(loc_RI_RevenueParticipationParticipationInput, RI_RevenueParticipationParticipationData, "Percentage Input", RI_RevenueParticipationPercentage);
		Thread.sleep(2000);
		Enter();

		//Backend Formula
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationBackendFormulaKey, RI_RevenueParticipationBackendFormula), "Backend Formula Row 1",RI_RevenueParticipationBackendFormula); 
		sendKeys(loc_RI_RevenueParticipationBackendFormulaInput, RI_RevenueParticipationBackendFormulaData, "Backend Formula Input", RI_RevenueParticipationBackendFormula);
		Thread.sleep(2000);
		Enter();
		//Currency
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationCurrencyKey, RI_RevenueParticipationCurrency), " Currency Row 1",RI_RevenueParticipationCurrency); 
		sendKeys(loc_RI_RevenueParticipationCurrencyInput, RI_RevenueParticipationCurrencyData, "Currency Input", RI_RevenueParticipationCurrency);
		Enter();
		Thread.sleep(2000);
		

		//Amount
		clickOn(getLocator_EditTAB_DataRow("1", RI_RevenueParticipationFixedAmountKey, RI_RevenueParticipationFixedAmount), "Fixed Amount Row 1",RI_RevenueParticipationFixedAmount); 
		sendKeys(loc_RI_RevenueParticipationAmountInput, RI_RevenueParticipationAmountData, "Fixed Amount Input", RI_RevenueParticipationFixedAmount);
		Enter();
		Thread.sleep(2000);
	

		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		//Edit
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "1"));
		
		//Copy
		clickUsingJSExecutor(loc_RI_NoRevenueParticipationCopyButton, "copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_ObligationsCopyWithoutSelectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_RevenueParticipationRow.replace("@var", "1"), "Selate 1 Row");
		Thread.sleep(1000);
		clickUsingJSExecutor(loc_RI_NoRevenueParticipationCopyButton, "copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(PromptAlertValidationMessgeText, "Promo  Msg", RI_ObligationsCopyWinEnterNoMsg);
		clickOn(loc_PromptBoxInput, "Prompt Input", "");
		sendKeys(loc_PromptBoxInput, RI_ObligationsInvalidCopyData, "Prompt Copy Input", "");
		clickUsingJSExecutor(loc_PromptOkButton, "Ok Button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_ObligationsCopyWinInvaldMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle()); 
		sendKeys(loc_PromptBoxInput, RI_ObligationsvalidCopyData, "Prompt Copy Input", "");
		clickUsingJSExecutor(loc_PromptOkButton, "Ok Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "1"), "Row 1");
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "2"), "Row 2");
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "3"), "Row 3");
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "4"), "Row 4");
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "5"), "Row 5");
		verifyElementPresent(loc_RI_RevenueParticipationRow.replace("@var", "5"), "Row 6");

		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		System.out.println("*********************End Testcase - TC4RevenuePartcipationCopyRow *********************");
	}
	@Test(priority =5,enabled= true,description = "Delete row functionality")
	public void TC5_RevenueParticipationDeleteRows() throws Exception, AWTException {
		System.out.println("*********************Start Testcase - TC5_RevenueParticipationDeleteRows *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
 		switchIntoFrame(frameParent2Xpath);
 		clickOn(loc_Tab.replace("@var", "Revenue Participation"), "Options TAB");
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
	    clickOn(loc_RI_RevenueParticipationRow.replace("@var", "1"), "First row"); 
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
		clickOn(loc_RI_RevenueParticipationRow.replace("@var", "1"), "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_ObligationsConfDeleteMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		System.out.println("*********************End Testcase - TC5_RevenueParticipationDeleteRows *********************");
	}
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_RevenueParticipation_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_RevenueParticipation_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_RevenueParticipation_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	
	public String getLocator_ViewTAB_DataRow(String rowNumber_Asset, String rowNumber_Data, String KeyValueFromExcel, String HeadeNameFromExcel){
		String classValue = getClassValue(loc_RI_RevenueParticipation_ColumnXpath_ViewMode.replace("@var", rowNumber_Asset), KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_RevenueParticipation_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_RevenueParticipation_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
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


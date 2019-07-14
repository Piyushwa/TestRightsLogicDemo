package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_General extends DriverHelper implements I_RI_General{
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);


	String CreatedSeriesAssetTitleTC1 	= "AUT_AssetSeries_TC1_" +formattedDate+"";

	String CreatedDealTC1 		= "AUT_Deal_TC1_" +formattedDate+"";
	String CreatedDealTC2 		= "AUT_Deal_TC2_" +formattedDate+"";
	

	public RI_General() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}

	public void a() throws Exception {}
	
	
	@Test
	public void TC1_CreateStandaloneDeal() throws Exception{

		if(!RI_StandAloneAgree.contains("N/A")) {

			switchIntoFrame(frameParent1Xpath);
			clickOn(ModulesXpath, "Module ");
			Thread.sleep(6000);
			clickOn(RightsInXpath, "Rights IN TAB ");
			Thread.sleep(6000);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(loc_NewButton, "New Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			ExecutionLog.Log("Manual Test Step : TC_RI_GT_002");
			ExecutionLog.Log("****** Verify the \"Sub Menu Icon\" under the \"New Menu\" *******");

			verifyElementPresent(loc_SubMenu.replace("@var", RI_MasterAgree), "Master Deal", RI_MasterAgree);
			verifyElementPresent(loc_SubMenu.replace("@var", RI_AttachLink), "MasterAttach Deal", RI_AttachLink);
			verifyElementPresent(loc_SubMenu.replace("@var", RI_StandAloneAgree), "Standalone Deal", RI_StandAloneAgree);
			verifyElementPresent(loc_SubMenu.replace("@var", RI_AttachMentfromMaster_Label), "RI_AttachMentfromMaster", RI_AttachMentfromMaster_Label);
			verifyElementPresent(loc_SubMenu.replace("@var", RI_CopyAgreeMent), "CopyAgreement Deal", RI_CopyAgreeMent);

			ExecutionLog.Log("Manual Test Step : TC_RI_GT_003");
			ExecutionLog.Log("****** Verify the Labels/fields available on Deal Creation Form page **********");
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", RI_StandAloneAgree), "Standalone Agreement");
			verifyFieldValueOfHeader(loc_DealID_LabelName, RI_DealID_Label, "Deal ID", RI_DealID_Label);
			verifyFieldValueOfHeader(loc_DealDescription_LabelName, RI_DealDescription_Label, "DealDescription", RI_DealDescription_Label);
			verifyFieldValueOfHeader(loc_DealName_LabelName, RI_DealName_Label, "DealName", RI_DealName_Label);
			verifyFieldValueOfHeader(loc_DealType_LabelName, RI_DealType_Label, "DealType", RI_DealType_Label);
			verifyFieldValueOfHeader(loc_DealSubType_LabelName, RI_DealSubType_Label, "DealSubType", RI_DealSubType_Label);
			verifyFieldValueOfHeader(loc_ContractStatus_LabelName, RI_ContractStatus_Label, "ContractStatus", RI_ContractStatus_Label);
			verifyFieldValueOfHeader(loc_ContractDataEntryStatus_LabelName, RI_DataEntryContractStatus_Label, "DataEntryContractStatus", RI_DataEntryContractStatus_Label);
			verifyFieldValueOfHeader(loc_DateExecuted_LabelName, RI_DateExecutedStatus_Label, "DateExecutedStatus", RI_DateExecutedStatus_Label);
			verifyFieldValueOfHeader(loc_DateEffective_LabelName, RI_DateEffectiveStatus_Label, "DateEffectiveStatus", RI_DateEffectiveStatus_Label);
			verifyFieldValueOfHeader(loc_Currency_LabelName, RI_CurrentCurrency_Label, "CurrentCurrency", RI_CurrentCurrency_Label);
			verifyFieldValueOfHeader(loc_ProfitCenter_LabelName, RI_ProfitCenter_Label, "ProfitCenter", RI_ProfitCenter_Label);
			verifyFieldValueOfHeader(loc_BudgetLine_LabelName, RI_BudgetLine_Label, "BudgetLine", RI_BudgetLine_Label);
			verifyFieldValueOfHeader(loc_SkipWorkflowCheckBox_LabelNAme, RI_SkipWorkflow_Label, "SkipWorkflow", RI_SkipWorkflow_Label);

			// get the deal Id and verify
			ExecutionLog.Log("*******Verify that Deal ID field is auto populated****");
			int ElementPresent = driver.findElements(By.xpath(loc_DealIDValue)).size();
			if (ElementPresent>0)
			{
				ExecutionLog.Log("Generated Deal Id is:  " + getText(loc_DealIDValue));
			}else {
				ExecutionLog.Log("====Failed===== Field Deal Id is not shown.");
			}

			verifyDropDownValues(loc_DealType_DropDownField, "'Deal Type' Drop Down", "RI_CommonData", 242, 262);
			verifyDropDownValues(loc_DealSubType_DropDownField, "'Deal sub Type' Drop Down", "RI_CommonData", 304, 328);

			selectDropdownValue(loc_DealType_DropDownField, "DealType_DropDownField", RI_DealType_AquisitionProgram, RI_DealType_Label);
			selectDropdownValue(loc_DealSubType_DropDownField, "Deal/Agreement Sub Type", RIDealSubtype, RI_DealSubType_Label);
			sendKeys(loc_DealDescription_InputField, "AUT", "Deal Code", RI_DealDescription_Label);
			sendKeys(loc_DealTitleField, CreatedDealTC1, "Deal Name Field", RI_DealName_Label);

			// IDM In Progress is selected by default for AMCN
			if(ClientData.contains("AMCN")) {
				verifyFirstSelectedDropdownValue(loc_ContractStatus, "Contract Status", RI_ContractStatus_fullyExecuted, RI_ContractStatus_Label);
			}


			//Date executed   
			sendKeys(loc_DateExecuted_InputField, RI_DateExecuted, "DateExecuted_InputField", RI_DateExecutedStatus_Label);

			//Date effective  
			sendKeys(loc_DateEffective_InputField, RI_DateEffective, "DateEffective_InputField", RI_DateEffectiveStatus_Label);

			selectDropdownValue(loc_ProfitCenter_InputField, "ProfitCenter_InputField", RI_DealCreationProfitCenter, RI_ProfitCenter_Label);
			Thread.sleep(6000);
			//Budget line 
			selectDropdownValue(loc_BudgetLine_InputField, "BudgetLine_InputField", DealCreationBudgetLine, RI_BudgetLine_Label);
			sendKeys(loc_Currency_InputField, DealCreationCurrency, "DealCreationCurrency", RI_CurrentCurrency_Label);
			selectDropdownValue(loc_ContractDataEntryStatus, "DealCreationCDEStatus", DealCreationCDEStatus, RI_DataEntryContractStatus_Label);
			//sendKeys(loc_ContractDataEntryStatus, DealCreationCDEStatus, "DealCreationCDEStatus", RI_DataEntryContractStatus_Label);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");


			//TODO verify Message of Please enter * values
			switchIntoFrame(frameParent2Xpath);
			verifyFieldValueOfHeader(loc_PartyLegend, RI_Parties_PartyLegend, "Party Legend", RI_Parties_PartyLegend);
			verifyFieldValueOfHeader("//th[@key='"+ RI_Parties_PartyHeader_Key +"']", RI_Parties_PartyHeader, "RI_Parties_PartyHeader", RI_Parties_PartyHeader);
			verifyFieldValueOfHeader("//th[@key='"+ RI_Parties_PartyType_Key +"']", RI_Parties_PartyType, "RI_Parties_PartyType", RI_Parties_PartyType);
			verifyFieldValueOfHeader(loc_Party_AddButton, RI_Parties_AddButton, "Add Button", RI_Parties_AddButton, "value");
			clickUsingJSExecutor(loc_DeleteParty, "Delete Button", RI_Parties_DeleteButton);
			driver.switchTo().window(driver.getWindowHandle());
			verifyFieldValueOfHeader(loc_AlertMessage, RI_SelectRowBeforeDelete, "Alert Message on click Delete Party without selecting Party","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert");

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_RI_GT_023");
			ExecutionLog.Log("Do not Select the party and click on Select Button");
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Party_AddButton, "Party_AddButton", RI_Parties_AddButton);
			if (!(ClientData.contains("AMCN")  || ClientData.contains("SALESDEMO")  || ClientData.contains("CORUS"))){
				clickUsingJSExecutor(Partiesxpath+"[1]//img", "PartyPopUp Icon");
			} 

			switchIntoFrame(frameParent3Xpath);
			clickOn(SaveButton, "Select Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyFieldValueOfHeader(loc_AlertMessage, RI_SelectItemBeforeClickSelectBtn, "Alert Message on click Select Party","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert");



			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_RI_GT_027");
			ExecutionLog.Log("Create the Party");
			switchIntoFrame(frameParent3Xpath);
			clickOn(LocAdd, "Add Party Button") ;

			String RI_PartyName1_Changed = "AUT_RI_General_TC1" + RI_PartyName1+ formattedDate;
			switchIntoFrame(frameParent4Xpath);
			selectDropdownValue(loc_Contributor_PartyListType_DropDown, "Party Type Drop Down", RI_Partytype_CreatePartyWindow_Outlet, RI_Partytype_CreatePartyWindow_Outlet);
			selectDropdownValue(loc_Outlets_PartiesAddParty, "Outlets_PartiesAddParty", RI_DealCreationProfitCenter, RI_ProfitCenter_Label);
			sendKeys(loc_VendorAddWindow_PartyName, RI_PartyName1_Changed, "Party Name",  "");

			verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", "Primary", "Contributor_ContributorSearch_Add_AddressTypeDropDown");
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "Contributor_ContributorSearch_Add_AddressLine1InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);
			sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "AddressLine1", "Edit_ConrtibutorsSearch_AddWindow_AddressLine1 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine2Label, "Contributor_ContributorSearch_Add_AddressLine2InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);
			sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine2InputField, "AddressLine2", "Edit_ConrtibutorsSearch_AddWindow_AddressLine2 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_CityInputField, "Edit_ConrtibutorsSearch_AddWindow_City",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);
			sendKeys(loc_Contributor_ContributorSearch_Add_CityInputField, "City", "Edit_ConrtibutorsSearch_AddWindow_City Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);

			selectDropdownValue(loc_Contributor_ContributorSearch_Add_CountryInputField, "Country Input Field", "Canada", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country);
			selectDropdownValue(loc_Contributor_ContributorSearch_Add_StateInputField, "Contributor_ContributorSearch_Add_StateInputField", "Alberta", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State);
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_ZipCodeField, "Contributor_ContributorSearch_Add_ZipCodeField");
			sendKeys(loc_Contributor_ContributorSearch_Add_ZipCodeField, "12345", "Edit_ConrtibutorsSearch_AddWindow_ZipCode Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);
			driver.switchTo().window(driver.getWindowHandle());
			clickOn(loc_AddParty_CloseWindow,"close Add Party Window");


			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_RI_GT_027");
			ExecutionLog.Log("********Enter the party name that doesn’t exist and Click find********");
			switchIntoFrame(frameParent3Xpath);
			sendKeys(loc_Contributor_ContributorSearch_SearchField, "Outlet Party 101", "Search Party InputField", RI_EnterNameToSearch_Label);
			doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
			WaitForModalPanel();
			WaitForElementPresent(OKAlertXpath);
			verifyFieldValueOfHeader(loc_AlertMessage, RI_ValMsg_NoQueryFound, "Alert Message","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 
			switchIntoFrame(frameParent3Xpath);

			ExecutionLog.Log("");
			ExecutionLog.Log("********Enter the party name and Click find >> Select the Party********");
			sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName1_Changed, "Search Party InputField", RI_EnterNameToSearch_Label);
			doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
			verifyElementPresent("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn(loc_PartySearch_DeactivateBtn, RI_Deactivate_Button);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickOn("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn(SaveButton, "Select Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyFieldValueOfHeader(loc_AlertMessage, RI_ValMsg_SelectDeactivateParty, "Alert Message on click Select Party","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert");
			switchIntoFrame(frameParent3Xpath);
			verifyFieldValueOfHeader(loc_PartySearch_DeactivateBtn, RI_Activate_Button, "Deactivate btn is changed to Activate Button", RI_Activate_Button, "value");
			clickOn("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn(loc_PartySearch_DeactivateBtn, "Activate Button", RI_Activate_Button);
			clickOn("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn(SaveButton, "Select Button");

			// Select Party Type
			ExecutionLog.Log("");
			ExecutionLog.Log("********Select Primary in Party Type >> Save >> Validate Msg 'SelectMinTwoParties'********");
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Partiesxpath+"[1]/td[4]", "Party Type Field");
			sendKeys(loc_PartyType_InputField, RI_Partytype_Primary, "Party Party InputField", RI_Parties_PartyType);
			clickOn(Partiesxpath+"[1]/td[2]", "Support Click ");

			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			switchIntoFrame(frameParent2Xpath);
			verifyFieldValueOfHeader(loc_DealValidationMsg, RI_ValMsg_SelectMinTwoParties, "Validation Messgae On Selecting Only One Party","");



			ExecutionLog.Log("");
			ExecutionLog.Log("********Select Same Party again and verify Valid. message********");
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Party_AddButton, "Party_AddButton", RI_Parties_AddButton);
			if (!(ClientData.contains("AMCN")  || ClientData.contains("SALESDEMO")  || ClientData.contains("CORUS"))){
				clickUsingJSExecutor(Partiesxpath+"[2]//img", "PartyPopUp Icon");
			} 

			switchIntoFrame(frameParent3Xpath);
			sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName1_Changed, "Search Party InputField", RI_EnterNameToSearch_Label);
			doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
			clickOn("//td[4][contains(text(),'"+RI_PartyName1_Changed+"')]", RI_PartyName1_Changed);
			clickOn(SaveButton, "Select Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyFieldValueOfHeader(loc_DealErrorValidationMsg, RI_ValMsg_PartyAlreadySelected, "Validation Messgae The Party is already selected","", "innerHTML");


			clickOn(Partiesxpath, "Party");
			clickUsingJSExecutor(loc_DeleteParty, "Delete Button", RI_Parties_DeleteButton);
			WaitForModalPanel();
			verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_ValMsg_ConfrmDeleteParty, "Alert Message on click Delete Party","");
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert");

			moveMouse(Partiesxpath, "Party row");
			verifyFieldValueOfHeader(loc_PartyUndoButton, "undo", "Undo Button after deleting Party","");
			clickOn(loc_PartyUndoButton, "undo");

		}

	}

	@Test
	public void TC2_ValidateCopyCurrentAgreement() throws Exception{

		rightsIN.createDeal(CreatedDealTC2);
		
		//TC_RI_GT_002
		String NewDeal = CreatedDealTC2 + "_001";
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "Module ");
		Thread.sleep(6000);
		clickOn(RightsInXpath, "Rights IN TAB ");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		rightsIN.selectDeal(CreatedDealTC2);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_NewButton, "New Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_SubMenu.replace("@var", RI_CopyAgreeMent), "CopyAgreement Deal", RI_CopyAgreeMent);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Deal description OR contact ID
		if(ClientName.contains("SKY")){
			// substring(0, 5) is used as Deal code allows Max. 6 Characters
			sendKeys(loc_DealDescription_InputField, getDateStamp().replace("/", "").substring(0, 5), "Deal Code", RI_DealDescription_Label);
//			sendKeys(loc_DealDescription_InputField, "AUT", "Deal Code", RI_DealDescription_Label);
		}else{
		sendKeys(loc_DealDescription_InputField, CreatedDealTC2 +"_desc", "Deal Description/ContractID", RI_DealDescription_Label);
		}
		
		
		sendKeys(loc_DealTitleField, CreatedDealTC2, "Deal Name", "");
		selectDropdownValue(loc_DealType_DropDownField, "DealType_DropDownField", RI_DealType, RI_DealType_Label);
		sendKeys(loc_ContractStatus, RI_ContractStatus_InNegotiation, "Deal Creation Contract Status", RI_ContractStatus_Label);
		sendKeys(loc_ContractDataEntryStatus, DealCreationCDEStatus, "DealCreationCDEStatus", RI_DataEntryContractStatus_Label);
		sendKeys(loc_DateExecuted_InputField, RI_DateExecuted, "DateExecuted_InputField", RI_DateExecutedStatus_Label);
		sendKeys(loc_Currency_InputField, DealCreationCurrency, "DealCreationCurrency", RI_CurrentCurrency_Label);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//switchIntoChildFrame(frameParent21Xpath);
		sleepTime(2);
		verifyFieldValueOfHeader(loc_ValidationMsg, RI_ValMsg_DealAlreadyExists, "ValMsg_DealAlreadyExists", "CreatedDeal");
		switchIntoFrame(frameParent2Xpath);
		sendKeys(loc_DealTitleField, NewDeal, "Deal Name", "");
		
		//TC_RI_GT_006
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();		
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_ValMsg_SameDealCode, "Alert Message for duplicate Deal Code/Description","");
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_ValMsg_WishToContinue, "Alert Message for duplicate Deal Code/Description","");
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button", "");
		WaitForModalPanel();
		verifyElementNotDisplayed(ConfirmAlertValidationMessgeText, "Validation Message","");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_ValMsg_SameDealCode, "Alert Message for duplicate Deal Code/Description","");
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, RI_ValMsg_WishToContinue, "Alert Message for duplicate Deal Code/Description","");
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyFieldValueOfHeader(loc_CreatedAssetAtHome, NewDeal, "CreatedDeal", "CreatedDeal");

	
		
	}
}

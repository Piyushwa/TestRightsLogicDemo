package assetMaintenance;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;

// clients "ASTRO,CORUS,VMN" does not has the Network drop down
// Hence The scripts is creating Parties and Contributor only (till line 480)

@Listeners(utility.ListenerClass.class)
public class AM_Contributor extends DriverHelper implements IAM_Contributor{
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String ExternalPartyFirst = "ExternalRSG_"+formattedDate+"";
	String ExternalPartyLast = "ExternalMedia_"+formattedDate+"";
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(100);
	// The Locators for Edit window and View Mode are same
	public AM_Contributor() {
		super(loc_Conrtibutors_Header,Conrtibutors_DataRow ,
				loc_Conrtibutors_Header, Conrtibutors_DataRow);
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}

	@Test(priority =1,enabled= true,description = "Contributors tab")
	public void TC1_ContibutorUI() throws Exception {
		String createdSeriesAssetTitle = "AUT_AssetSeries_Contri_" +formattedDate+"";
		String InternDetailFirstname = "InternalRSG_"+formattedDate+"";
		String InternDetailLastname = "InternalMedia_"+formattedDate+"";
		String InternReferencevalue = "REFER_InternalRSG_"+formattedDate+"";
		//createContributorInListMaintenance();
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);

		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(createdSeriesAssetTitle);

		//List maintenance - External party
		//Navigate Contributor tab
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Contributors') or contains(text(),'Contacts') or contains(text(),'Cast"), "Contributors OR Contacts TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		//TC_AM_CT_008
		//Verifying the Headers of Contributor TAB in View Mode
		ExecutionLog.Log("**********Verifying the Headers of Contributor TAB in View Mode***********");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_AppliesTo_ViewMode_Key+"']", "AppliesTo_ViewMode", Conrtibutors_AppliesTo_ViewMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_RankOrder_ViewEditMode_Key+"']", "Rank Order", Conrtibutors_RankOrder_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_PromotableStar_ViewMode_Key+"']", "PromotableStar_ViewMode", Conrtibutors_PromotableStar_ViewMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Name_ViewMode_Key+"']", "Name_ViewMode", Conrtibutors_Name_ViewMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Role_ViewMode_Key+"']", "Role_ViewMode", Conrtibutors_Role_ViewMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Character_ViewEditMode_Key+"']", "Character_ViewMode", Conrtibutors_Character_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_ContactInformation_ViewEditMode_Key+"']", "ContactInformation_ViewMode", Conrtibutors_ContactInformation_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Guild_ViewEditMode_Key+"']", "Guild_ViewMode", Conrtibutors_Guild_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Notes_ViewMode_Key+"']", "Notes_ViewMode", Conrtibutors_Notes_ViewMode_Value,"innerHTML");


		//TC_AM_CT_009
		//Verifying the Headers of Contributor TAB in Edit Mode
		ExecutionLog.Log("**********Verifying the Headers of Contributor TAB in EDit Mode***********");
		clickUsingJSExecutor("name="+loc_Edit, "'Edit' Button at Contributor TAB");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_EpisodeAdd));
		ExecutionLog.Log("**********Verifying the Headers of Contributor TAB in Edit Mode************");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_AppliesTo_EditMode_Key+"']", "AppliesTo_EditMode", Conrtibutors_AppliesTo_EditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_RankOrder_ViewEditMode_Key+"']", "Rank Order", Conrtibutors_RankOrder_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_PromotableStar_EditMode_Key+"']", "PromotableStar_EditMode", Conrtibutors_PromotableStar_EditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Name_EditMode__Key+"']", "Name_EditMode", Conrtibutors_Name_EditMode__Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Role_EditMode_Key+"']", "Role_EditMode", Conrtibutors_Role_EditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Character_ViewEditMode_Key+"']", "Character_EditMode", Conrtibutors_Character_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_ContactInformation_ViewEditMode_Key+"']", "ContactInformation_EditMode", Conrtibutors_ContactInformation_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Guild_ViewEditMode_Key+"']", "Guild_EditMode", Conrtibutors_Guild_ViewEditMode_Value,"innerHTML");
		verifyTextMatches(loc_Conrtibutors_Header+"[@key='"+Conrtibutors_Notes_EditMode_Key+"']", "Notes_EditMode", Conrtibutors_Notes_EditMode_Value,"innerHTML");
		ExecutionLog.Log("*****Verifying the available Buttons at 'Edit Contributor window'*****");
		verifyTextMatches(LocAdd, "Add", Conrtibutors_AddButton_EditMode_Value, "value");
		verifyTextMatches(loc_Delete, "Delete", Conrtibutors_DeleteButton_EditMode_Value, "value");
		verifyTextMatches(loc_Save, "Save", Conrtibutors_Save_EditMode__Value, "value");
		verifyTextMatches(loc_Cancel, "Cancel", Conrtibutors_Cancel_EditMode_Value, "value");

		//click on delete button without selecting any row and verify Alert Messge
		ExecutionLog.Log("*********************click on delete button without selecting any row and verify Alert Messge**********************************");
		clickUsingJSExecutor(loc_Delete, "Delete Button at Edit Contributor Window");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While deleting the Contributor", Conrtibutors_DeleteAlertMessage);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While deleting the Episode"); 


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Contributor window");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(By.id("btnSelect"));

		ExecutionLog.Log("**********Verify dropdown values of 'Enter Name to search' drop down************");
		verifyDropDownValues(loc_Contributor_PartyList_DropDown, "Enter Name To Search Drop Down", "AM_Conrtibutors", 41, 44);

		///////////////////////////////The Below Steps were not mentioned in the Manual Test Cases////////////////
		//////External Contributors////////
		ExecutionLog.Log("************Verify Default selected value in \"Enter Name To Search Drop Down\"***************");
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_ExternalParties, Contributor_ExternalParties);

		/*if(ClientData.contains("AMCN") || ClientData.contains("CORUS") || ClientData.contains("SALESDEMO")) {

		} else {
			ExecutionLog.Log("====Failed===Sent Email to Sandeep that the default value for VMN is changed");
			//verifyFirstSelectedDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_InternalParties, Contributor_InternalParties);
			
		}*/
		ExecutionLog.Log("************Verifying the default value selected in 'Party list type' for 'External Contributors' PartyList' dropdown ************");
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyListType_DropDown, "Contributor_PartyListType_DropDown", "Last Name", "Contributor_PartyListType_DropDown");
		ExecutionLog.Log("***********Verifying The Header for 'External Contributors/Cast'***********");
		verifyTextMatches(loc_Contributor_ContributorSearch_FirstNAmeHeader, "ConrtibutorsSearch_FirstName_Value", Conrtibutors_ConrtibutorsSearch_FirstName_Value, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_LastNAmeHeader, "ConrtibutorsSearch_LastName_Value", Conrtibutors_ConrtibutorsSearch_LastName_Value, "innerHTML");

		//////Internal Parties////////
		selectDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_InternalParties, Contributor_InternalParties);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_InternalParties, Contributor_InternalParties);
		ExecutionLog.Log("**********The default values & columns in the window based on search names -Internal Parties ************");
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyListType_DropDown, "Contributor_PartyListType_DropDown", "Last Name", "Contributor_PartyListType_DropDown");
		ExecutionLog.Log("**********Verifying The Header for 'Internal Parties'**********");
		verifyTextMatches(loc_Contributor_ContributorSearch_FirstNAmeHeader, "ConrtibutorsSearch_FirstName_Value", Conrtibutors_ConrtibutorsSearch_FirstName_Value, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_LastNAmeHeader, "ConrtibutorsSearch_LastName_Value", Conrtibutors_ConrtibutorsSearch_LastName_Value, "innerHTML");



		//////Companies/Individual Parties////////
		ExecutionLog.Log("**********The default values & columns in the window based on search names -Companies/Individual Parties ************");
		sleepTime(3);
		switchIntoFrame(frameParent4Xpath);
		selectDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_CompaniesParties, Contributor_CompaniesParties);
		sleepTime(1);
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_CompaniesParties, Contributor_CompaniesParties);
		sleepTime(1);
		WaitForElementPresent(ByLocator(SaveButton));
		ExecutionLog.Log("Deafult value ");
		verifyFirstSelectedDropdownValue(loc_Contributor_PartyListType_DropDown, "Contributor_PartyListType_DropDown", "Company Name", "Contributor_PartyListType_DropDown");
		ExecutionLog.Log("***********Verifying The Header for 'Companies/Individual Parties'***********");
		verifyTextMatches(loc_Contributor_ContributorSearch_FirstNAmeHeader, "Conrtibutors_ConrtibutorsSearch_CompanyName_Value", Conrtibutors_ConrtibutorsSearch_CompanyName_Value, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_LastNAmeHeader, "Conrtibutors_ConrtibutorsSearch_CompanyType_Value", Conrtibutors_ConrtibutorsSearch_CompanyType_Value, "innerHTML");
		/////////////////////////////////The Above Steps were not mentioned in the Manual Test Cases////////////////

		////Verifying All buttons in the search Contributor window
		ExecutionLog.Log("**********Verifying All buttons in the search Contributor window ************");
		verifyTextMatches(LocAdd, "Add button at Contributor Search", ConrtibutorsEdit_ConrtibutorsSearch_AddButton_Value, "value");
		verifyTextMatches(Loc_EditButton, "Edit button at Contributor Search",ConrtibutorsEdit_ConrtibutorsSearch_EditButton_Value, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_DeActivateButton, "DeActivation button at Contributor Search", ConrtibutorsEdit_ConrtibutorsSearch_DeActivateButton_Value, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_ExportButton, "Export button at Contributor Search", ConrtibutorsEdit_ConrtibutorsSearch_ExportButton_Value, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_SelectButton, "Select button at Contributor Search", ConrtibutorsEdit_ConrtibutorsSearch_SelectButton_Value, "value");
		verifyTextMatches(loc_Cancel, "Cancel button at Contributor Search", ConrtibutorsEdit_ConrtibutorsSearch_CancelButton_Value, "value");

		/////Internal Parties/////
		// Select Internal Parties at the Contributor Search window and then go to "Add window" by clicking on the Add button
		selectDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_InternalParties, Contributor_InternalParties);
		sleepTime(1);
		WaitForElementPresent(SaveButton);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Contributor Edit window");
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(loc_Contributor_ContributorSearch_Add_FirstNameField);
		ExecutionLog.Log("**********Fields & Buttons in the Add  dialog - Detail frame (Internal Parties)************");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_PrefixLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_Prefix", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Prefix, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_FirstNameLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_first Name", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_MiddleNameLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_MiddleName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_MiddleName, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_LastNameLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_LastName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_SuffixLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_Suffix", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Suffix, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKALabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_AKA", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKA, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_AddButton, "Conrtibutors_ConrtibutorsSearch_AddWindow_AKA_Addbutton", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKAAdd, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_DeleteButton, "Conrtibutors_ConrtibutorsSearch_AddWindow_AKA_Delete Button", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKADelete, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddressLine1Label, "Conrtibutors_ConrtibutorsSearch_AddWindow_AddressLine1", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddressLine2Label, "Conrtibutors_ConrtibutorsSearch_AddWindow_AddressLine2", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_CityLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_CityName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_CountryLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_Country", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_StateLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_State", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_ZipCodeLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_ZipCode", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_UserLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_User", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_User, "innerHTML");

		ExecutionLog.Log("		**********Fields & Buttons in the Add  dialog - Communication frame (Internal Parties or MTVN Employees)************");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_BusinessPhoneLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_BusinessPhoneLabel", ContributorSearch_Add_BusinessPhoneLabel, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_PrimaryEmailLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_PrimaryEmailLabel", ContributorSearch_Add_PrimaryEmailLabel, "innerHTML");
		verifyDropDownValues(loc_Contributor_ContributorSearch_Add_ContactListDropDown, "Contributor_ContributorSearch_Add_ContactListDropDown", "AM_Conrtibutors", 88, 93);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_WebAddressLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_WebAddressLabel", ContributorSearch_Add_WebAddressLabel, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_ClearAddressLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_ClearAddressLabel", ContributorSearch_Add_ClearAddressLabel, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddCustomAddressTypeLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_AddCustomAddressTypeLabel", ContributorSearch_Add_AddCustomAddressTypeLabel, "value");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_CancelAllPopupLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_CancelAllPopupLabel", ContributorSearch_Add_CancelAllPopupLabel, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_ClosePopupLabel, "Conrtibutors_ConrtibutorsSearch_AddWindow_ClosePopupLabel", ContributorSearch_Add_ClosePopupLabel, "value");

		////Fill the form to add the contributor for Internal Parties
		ExecutionLog.Log("**********Adding Contributor at 'Add window' for Internal Parties************");

		//Name Field
		clickOn(loc_Contributor_ContributorSearch_Add_FirstNameField, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName);
		sendKeys(loc_Contributor_ContributorSearch_Add_FirstNameField, InternDetailFirstname, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName);
		clickOn(loc_Contributor_ContributorSearch_Add_LastNameField, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName);
		sendKeys(loc_Contributor_ContributorSearch_Add_LastNameField, InternDetailLastname, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName);

		// Entering "Primary Email" as it is mandatory field in VMN
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
		sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "primary" + randomInt + "1@gmail.com", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);

		
		//AKA Field
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameHeader, "Contributor_ContributorSearch_Add_AKA_AlternateNameHeader", ContributorSearch_Add_AKA_AlternateNameHeader, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_TypeHeader, "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader", Contributor_ContributorSearch_Add_AKA_TypeHeader, "innerHTML");

		clickOn(loc_Contributor_ContributorSearch_Add_AKA_TypeField, "Contributor_ContributorSearch_Add_AKA_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownIcon, "Contributor_ContributorSearch_Add_AKA_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("***********The below mentioned are drop down values of AKA Type****************");
		verifyAllAvailableValues(loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownValues, "Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownValues", "AM_Conrtibutors", 101, Contributor_ContributorSearch_Add_AKA_TypeHeader);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameField, "Contributor_ContributorSearch_Add_AKA_AlternateNameField",ContributorSearch_Add_AKA_AlternateNameHeader);
		sleepTime(2);
		sendKeys_WithoutClear(Loc_Details_AssetTitleRowInput, "RSGTest_1", "Contributor_ContributorSearch_Add_AKA_AlternateNameField", ContributorSearch_Add_AKA_AlternateNameHeader);

		sleepTime(2);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AKA_TypeField, "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		sendKeys(loc_Contributor_ContributorSearch_Add_AKA_TypeInputField, "AKA", "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader", Contributor_ContributorSearch_Add_AKA_TypeHeader);
		sleepTime(2);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameField, "Contributor_ContributorSearch_Add_AKA_AlternateNameField",ContributorSearch_Add_AKA_AlternateNameHeader);

		// SKY only uses AKA Type
		if(!ClientData.contains("SKY")) {
		//// Add Second Row in AKA
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AKA_AddButton, "Contributor_ContributorSearch_Add_AKA_AddButton");
			clickOn(loc_Contributor_ContributorSearch_Add_AKA_Row2_TypeField, "Contributor_ContributorSearch_Add_AKA_Row2_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
			sendKeys(loc_Contributor_ContributorSearch_Add_AKA_TypeInputField, "FKA", "Contributor_ContributorSearch_Add_AKA_Row2_TypeInputField", Contributor_ContributorSearch_Add_AKA_TypeHeader);
			clickOn(loc_Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameField, "Support click Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");

			WaitForModalPanel();
			switchIntoFrame(frameParent5Xpath);
			sleepTime(5);

			verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_SaveGeneralInfo_EnterAleternateMsg);
			clickOn(loc_Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameField, "Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameField",ContributorSearch_Add_AKA_AlternateNameHeader);
			sendKeys(Loc_Details_AssetTitleRowInput, "RSGTest_2", "Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameInput Field", ContributorSearch_Add_AKA_AlternateNameHeader);
			clickOn(loc_Contributor_ContributorSearch_Add_AKA_Row2_TypeField, "Contributor_ContributorSearch_Add_AKA_Row2_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);

		}
		
		clickOn(loc_Contributor_ContributorSearch_Add_LastNameField, "Contributor_ContributorSearch_Add_LastNameField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AKA_DeleteButton, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKADelete", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKADelete);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Alert Message While deleting the AKA Information", ContributorSearch_Add_DeleteAlias_ValidationMessage);
		sleepTime(3);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert While While deleting the AKA Information"); 
		switchIntoFrame(frameParent5Xpath);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");

		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		
		//Custom Address 
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddCustomAddressTypeLabel, "Contributor_ContributorSearch_Add_AddCustomAddressTypeLabel"); 
		switchIntoFrame(frameParent6Xpath);

		WaitForElementPresent("name="+loc_Save_UseWithNameAttribute);
		ExecutionLog.Log("		**********Fields & Buttons in the Custom address dialog - Detail & Attribute frame ************");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeIDLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeIDLabel", ContributorSearch_Add_AddReferenceValue_ReferenceTypeIDLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeLabel", ContributorSearch_Add_AddReferenceValue_ReferenceTypeLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_ValueLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_ValueLabel", ContributorSearch_Add_AddReferenceValue_ValueLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplayValueLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_DisplayValueLabel", ContributorSearch_Add_AddReferenceValue_DisplayValueLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplayOrderLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_DisplayOrderLabel", ContributorSearch_Add_AddReferenceValue_DisplayOrderLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_SelectModuleLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_SelectModuleLabel", ContributorSearch_Add_AddReferenceValue_SelectModuleLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplaycheckBoxLabel, "Contributor_ContributorSearch_Add_AddReferenceValue_DisplaycheckBoxLabel", ContributorSearch_Add_AddReferenceValue_DisplaycheckBoxLabel);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute1Label, "Contributor_ContributorSearch_Add_AddReferenceValue_Attribute1Label", ContributorSearch_Add_AddReferenceValue_Attribute1Label);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute2Label, "Contributor_ContributorSearch_Add_AddReferenceValue_Attribute2Label", ContributorSearch_Add_AddReferenceValue_Attribute2Label);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute3Label, "Contributor_ContributorSearch_Add_AddReferenceValue_Attribute3Label", ContributorSearch_Add_AddReferenceValue_Attribute3Label);
// TODO Delete
		/*String Custombutton1 = driver.findElement(By.name("btnSave")).getAttribute("value");
		ExecutionLog.Log (Custombutton1);
		String Custombutton2 = driver.findElement(By.name("btnCancel")).getAttribute("value");
		ExecutionLog.Log (Custombutton2);*/
		verifyTextMatches(loc_Save, "Save button", "Save","value");
		verifyTextMatches("name="+LocCancel_UseWithNameAttribute, "Cancel button", "Cancel","value");
		
		clickOn(loc_Contributor_ContributorSearch_Add_AddReferenceValue_ValueField, "Contributor_ContributorSearch_Add_AddReferenceValue_ValueLabel",ContributorSearch_Add_AddReferenceValue_ValueLabel);
		sendKeys(loc_Contributor_ContributorSearch_Add_AddReferenceValue_ValueField, InternReferencevalue, "Contributor_ContributorSearch_Add_AddReferenceValue_ValueLabel Field", ContributorSearch_Add_AddReferenceValue_ValueLabel);


		clickUsingJSExecutor("name="+loc_Save_UseWithNameAttribute, "'Save' Button at Contributor_ContributorSearch_Add_AddReferenceValue window");
		clickUsingJSExecutor("name="+LocCancel_UseWithNameAttribute, "'Cancel' Button at Contributor_ContributorSearch_Add_AddReferenceValue window");

		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(ByLocator(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton));

		// Manual Test Step: TC_AM_CT_016
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_AM_CT_016");
		verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", ContributorSearch_Add_AddressTypeDropDownValue, "Contributor_ContributorSearch_Add_AddressTypeDropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "Contributor_ContributorSearch_Add_AddressLine1InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);
		sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "AddressLine1", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine2Label, "Contributor_ContributorSearch_Add_AddressLine2InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);
		sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine2InputField, "AddressLine2", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_CityInputField, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);
		sendKeys(loc_Contributor_ContributorSearch_Add_CityInputField, "City", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_CountryInputField, "Country Input Field", "Canada", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country);
		selectDropdownValue(loc_Contributor_ContributorSearch_Add_StateInputField, "Contributor_ContributorSearch_Add_StateInputField", "Alberta", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_ZipCodeField, "Contributor_ContributorSearch_Add_ZipCodeField");
		sendKeys(loc_Contributor_ContributorSearch_Add_ZipCodeField, "12345", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "Contributor_ContributorSearch_Add_BusinessPhone Input Field");
		sendKeys(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "6176828224", "Contributor_ContributorSearch_Add_BusinessPhone Field", ContributorSearch_Add_BusinessPhoneLabel);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
		sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "primary"+randomInt + randomInt + "@gmail.com", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactListDropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Home, "Contributor_ContributorSearch_Add_ContactList2DropDown");
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact1_InputField, "Contributor_ContributorSearch_Add_Contact1_InputField");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact1_InputField, Contributor_ContributorSearch_Add_Comm_Home, "Contributor_ContributorSearch_Add_Contact1_InputField", "Contributor_ContributorSearch_Add_ContactListDropDown");

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList2DropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Mobile, "Contributor_ContributorSearch_Add_ContactList2DropDown");
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "Contributor_ContributorSearch_Add_Contact2_InputField");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "6176828224", "Contributor_ContributorSearch_Add_Contact2_InputField Field", "Contributor_ContributorSearch_Add_ContactListDropDown");

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList3DropDown, "Contributor_ContributorSearch_Add_ContactList3DropDown", Contributor_ContributorSearch_Add_Comm_Personal, "Contributor_ContributorSearch_Add_ContactList3DropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "Contributor_ContributorSearch_Add_ContactList3DropDown");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "personal1" + randomInt + "@gmail.com", "Contributor_ContributorSearch_Add_ContactList3DropDown Field", "Contributor_ContributorSearch_Add_ContactList3DropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_WebAddressInputField, ContributorSearch_Add_WebAddressLabel);
		sendKeys(loc_Contributor_ContributorSearch_Add_WebAddressInputField, "www.web.com", "Contributor_ContributorSearch_Add_WebAddressField", ContributorSearch_Add_WebAddressLabel);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		sleepTime(3);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);

		driver.switchTo().window(driver.getWindowHandle());
		clickOn(loc_Contributor_ContributorSearch_Add_CloseWindow,"close Add Reference Window");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(ByLocator(SaveButton));
		sleepTime(3);

		////////////////////////////Below Steps were Not Found in Manual Test Step//////////////////////
		//TC_AM_CT_018
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_AM_CT_018");
		//Contribution search
		clickOn(loc_Contributor_ContributorSearch_SearchField,"Contributor_ContributorSearch_SearchField");
		sendKeys(loc_Contributor_ContributorSearch_SearchField, InternDetailLastname, "Contributor_ContributorSearch_SearchField", "Contributor_ContributorSearch_SearchField");

		clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "Find Button at Contributor Search Window");
		WaitForElementPresent(loc_Contributor_ContributorSearch_FirstContributor);
		clickUsingJSExecutor(loc_Edit, "Edit Button at Contributor Search Window");

		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(loc_AlertMessage, "Alert Message While Clicking Edit button at Contributor's Search window", ContributorSearch_Editbutton_DoNotSelectContirutorMsg);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 

		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_Contributor_ContributorSearch_FirstContributor,"Contributor_ContributorSearch_FirstContributor");
		clickUsingJSExecutor(loc_Edit, "Edit Button at Contributor Search Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		WaitForElementPresent(ByLocator(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton));
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_ClearAddressLabel, "Contributor_ContributorSearch_Add_ClearAddressLabel");

		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertXpath, "Alert Message While Clearing the Address on 'Communication box' under Contributor Search window", ContributorSearch_Add_ClearAddress_ValidationMessage);
		sleepTime(3);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert While While deleting the AKA Information"); 
		switchIntoFrame(frameParent5Xpath);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
		sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "rsg.rsg", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		sleepTime(3);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Editbutton_WrongCharactersGiven_ValidationMessage", ContributorSearch_Editbutton_WrongCharactersGivenMsg);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
		sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "validemail" + randomInt + "@gmail.com", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");

		WaitForModalPanel();
		switchIntoFrame(frameParent5Xpath);
		sleepTime(3);
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage,"innerHTML");

		driver.switchTo().window(driver.getWindowHandle());
		clickOn(loc_Contributor_ContributorSearch_Add_CloseWindow,"close Add Reference Window");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(SaveButton);
		sleepTime(3);
		clickOn(loc_Contributor_ContributorSearch_FirstContributor, "Select the Contributor at Contributor_ContributorSearch window");
		clickUsingJSExecutor(SaveButton, "'Select' button Contributor at Contributor_ContributorSearch window");
		switchIntoFrame(frameParent3Xpath);

		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Save, "Save button at Contributor_ContributorSearch window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		sleepTime(3);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Contributor_ContributorSearch_ManadatryFieldValidationMessage_ValidationMessage", ContributorSearch_ManadatryFieldValidationMessageMsg);
		//////////////////////////////Above Steps were Not Found in Manual Test Step//////////////////////

		

		// Manual Test Step : TC_AM_CT_035
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_AM_CT_035");
		selectDropdownValue(loc_EditContributor_Network_DropDown, "Network Drop Down", Contributor_Network1, Contributor_Network1);
		sleepTime(3);
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value),Conrtibutors_AppliesTo_ViewMode_Value, Conrtibutors_AppliesTo_ViewMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_AppliesToInputField, createdSeriesAssetTitle, "Applies To first Row", Conrtibutors_AppliesTo_ViewMode_Value);
		clickOn(getLocator_EditTAB_DataRow("1",Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value),"Support click", Conrtibutors_AppliesTo_ViewMode_Value);


		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), Conrtibutors_AppliesTo_ViewMode_Value, Conrtibutors_AppliesTo_ViewMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_AppliesToInputField, "      Ep.101: Episode101", "Applies To first Row", Conrtibutors_AppliesTo_ViewMode_Value);
		// BELOW TWO LINES ARE support click to save applies to data and make rank order enable to type
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value),"Support click", Conrtibutors_AppliesTo_ViewMode_Value);
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value),Conrtibutors_AppliesTo_ViewMode_Value, Conrtibutors_AppliesTo_ViewMode_Value);

		switchIntoFrame(frameParent3Xpath);
		String supportclick_AppliesToField = getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value);

		//Enter Values in RankOrder Field
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), Conrtibutors_RankOrder_ViewEditMode_Value,Conrtibutors_RankOrder_ViewEditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_RankOrderInputField, "0", "Rank Order Field of first Row", Conrtibutors_RankOrder_ViewEditMode_Value);
		keyboard();
		//clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value),"Spport click on Applies to field", Conrtibutors_RankOrder_ViewEditMode_Value);
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(loc_AlertMessage, ContributorSearch_enterZeroRankOrder, "Alert Message on Entering Zero in Rank Order",Conrtibutors_RankOrder_ViewEditMode_Value);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button on Entering Zero in Rank Order", Conrtibutors_RankOrder_ViewEditMode_Value); 

		switchIntoFrame(frameParent3Xpath, Conrtibutors_RankOrder_ViewEditMode_Value);
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), Conrtibutors_RankOrder_ViewEditMode_Value, Conrtibutors_RankOrder_ViewEditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_RankOrderInputField, "1", "Rank Order Field of first Row", Conrtibutors_RankOrder_ViewEditMode_Value);

		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "Applies To", Conrtibutors_AppliesTo_ViewMode_Value);
		sleepTime(2);

		//TC_AM_CT_051
		//Enter Values in Role Field
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), "Role field", Conrtibutors_Role_EditMode_Value,Conrtibutors_Role_EditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_RoleInputField, Contributor_Role, "Role Field of first Row", Conrtibutors_Role_EditMode_Value);
		keyboard();
		//Enter Values in Character Field			
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), Conrtibutors_Character_ViewEditMode_Value,Conrtibutors_Character_ViewEditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_CharacterAndContactInformationInputField, "qwe123!!@@", "Character Field of first Row", Conrtibutors_Character_ViewEditMode_Value);
		clickOn(supportclick_AppliesToField,"Support click on Applies To Field", Conrtibutors_Character_ViewEditMode_Value);
		//Check the Check Box of PromotableStar Field			
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value, Conrtibutors_PromotableStar_ViewMode_Value);
		//Enter Values in Character Field			
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "ContactInformation field",Conrtibutors_ContactInformation_ViewEditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_CharacterAndContactInformationInputField, "qwe123!!@@", "ContactInformation Field of first Row", Conrtibutors_ContactInformation_ViewEditMode_Value);
		clickOn(supportclick_AppliesToField,"Support click on Applies To Field", Conrtibutors_ContactInformation_ViewEditMode_Value);


		//TC_AM_CT_055
		// Enter Note
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", Conrtibutors_Notes_EditMode_Key, Conrtibutors_Notes_EditMode_Value)+"/img", "Note Image Icon", Conrtibutors_Notes_EditMode_Value);
		switchIntoFrame(frameParent4Xpath, Conrtibutors_Notes_EditMode_Value);
		//TC_AM_CT_056
		clickOn(loc_Note_Restriction, "Note_Restriction Check Box");
		WaitForElementPresent(ByLocator(Applybutton_AtSBUWindow));
		sendKeys(loc_NoteBody, "RSG Test", "Note Body", Episode_NotesValue);
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "OK button at Note Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save_UseWithNameAttribute);
		ExecutionLog.Log("*******Verifying the Entered details in the Edit Contributor window*******");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "      Ep.101: Episode101", "'Applies To' of First Data Row", Conrtibutors_AppliesTo_ViewMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "1", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), Contributor_Role, "Role of First Data Row", Conrtibutors_Role_EditMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), "qwe123!!@@", "'Character' of First Data Row", Conrtibutors_Character_ViewEditMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", "Checked", "'Portable Star Status' of First Data Row", Conrtibutors_PromotableStar_EditMode_Value, "title");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "qwe123!!@@", "'ContactInformation' of First Data Row", Conrtibutors_ContactInformation_ViewEditMode_Value, "innerHTML");
		clickUsingJSExecutor(loc_Save, "Save Button at 'Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		// Manual Test Step : TC_AM_CT_061
		ExecutionLog.Log("*******Verifying the Entered details in the Contributor TAB in View Mode*******");
		WaitForElementPresent(ByLocator(loc_Edit));
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_ViewMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "Ep.101: Episode101", "'Applies To' of First Data Row", Conrtibutors_AppliesTo_ViewMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "1", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_ViewMode_Key, Conrtibutors_Role_EditMode_Value), Contributor_Role, "Role of First Data Row", Conrtibutors_Role_EditMode_Value, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), "qwe123!!@@", "'Character' of First Data Row", Conrtibutors_Character_ViewEditMode_Value, "innerHTML");
		verifyElementPresent(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_ViewMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value,Conrtibutors_PromotableStar_ViewMode_Value);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "qwe123!!@@", "'ContactInformation' of First Data Row", Conrtibutors_ContactInformation_ViewEditMode_Value, "innerHTML");

		// These clients "ASTRO,CORUS,VMN, SKY" does not has the Network drop down
		// hence below functionality is not applicable for these clients
		if(!(Contributor_Network1.contains("N/A"))) {			

			//From Test Step: "TC_AM_CT_063".
			//AMCN ADD NEW		
			selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network2, Contributor_Network2);
			sleepTime(1);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network2, Contributor_Network2);
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			// Verifying all data expect Rank Order and Promotable Star Check box
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_ViewMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "Ep.101: Episode101", "'Applies To' of First Data Row", Conrtibutors_AppliesTo_ViewMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_ViewMode_Key, Conrtibutors_Role_EditMode_Value), Contributor_Role, "Role of First Data Row", Conrtibutors_Role_EditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), "qwe123!!@@", "'Character' of First Data Row", Conrtibutors_Character_ViewEditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "qwe123!!@@", "'ContactInformation' of First Data Row", Conrtibutors_ContactInformation_ViewEditMode_Value, "innerHTML");

			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(By.id("btnSave"));
			sleepTime(3);

			// Changing Data for -Role, Character, PromotableStar,ContactInformation fields etc.
			supportclick_AppliesToField = getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value);
			//Enter Values in RankOrder Field for "IFC Linear Network"
			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), Conrtibutors_RankOrder_ViewEditMode_Value,Conrtibutors_RankOrder_ViewEditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_RankOrderInputField, "2", "Rank Order Field of first Row", Conrtibutors_RankOrder_ViewEditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field");

			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), "Role field",Conrtibutors_Role_EditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_RoleInputField, "Cameo", "Role Field of first Row", Conrtibutors_Role_EditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field",Conrtibutors_Role_EditMode_Value);
			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), Conrtibutors_Character_ViewEditMode_Value,Conrtibutors_Character_ViewEditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_CharacterAndContactInformationInputField, "abcd", "Character Field of first Row", Conrtibutors_Character_ViewEditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field");
			// Check Promotable Sar for Network "IFC Linear"
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value,Conrtibutors_PromotableStar_ViewMode_Value);
			// Enter Contact Information
			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "ContactInformation field",Conrtibutors_ContactInformation_ViewEditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_CharacterAndContactInformationInputField, "pqrs", "ContactInformation Field of first Row", Conrtibutors_ContactInformation_ViewEditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field");
			// Enter Guild
			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Guild_ViewEditMode_Key, Conrtibutors_Guild_ViewEditMode_Value), "ContactInformation field",Conrtibutors_Guild_ViewEditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_GuildInputField, "BMI", "Guild Field of first Row", Conrtibutors_Guild_ViewEditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field",Conrtibutors_Guild_ViewEditMode_Value);

			// Enter Note
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", Conrtibutors_Notes_EditMode_Key, Conrtibutors_Notes_EditMode_Value)+"/img", "Note Image Icon", Conrtibutors_Notes_EditMode_Value);
			switchIntoFrame(frameParent4Xpath, Conrtibutors_Notes_EditMode_Value);
			clickOn(loc_Note_Restriction, "Note_Restriction Check Box");
			WaitForElementPresent(ByLocator(Applybutton_AtSBUWindow));
			sendKeys(loc_NoteBody, "Test Notes with Special Characters !@#$%^&*()_12345 Updated", "Note Body", Episode_NotesValue);
			clickUsingJSExecutor(Applybutton_AtSBUWindow, "OK button at Note Window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(By.id("btnSave"));
			//Verifying the Entered details in the Edit Contributor window
			ExecutionLog.Log("*******Verifying the Entered details in the Edit Contributor window*******");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "Ep.101: Episode101", "'Applies To' of First Data Row", Conrtibutors_AppliesTo_ViewMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "2", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), "Cameo", "Role of First Data Row", Conrtibutors_Role_EditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Character_ViewEditMode_Key, Conrtibutors_Character_ViewEditMode_Value), "abcd", "'Character' of First Data Row", Conrtibutors_Character_ViewEditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", "Checked", "'Portable Star Status' of First Data Row", Conrtibutors_PromotableStar_EditMode_Value, "title");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_ContactInformation_ViewEditMode_Key, Conrtibutors_ContactInformation_ViewEditMode_Value), "pqrs", "'ContactInformation' of First Data Row", Conrtibutors_ContactInformation_ViewEditMode_Value, "innerHTML");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_Guild_ViewEditMode_Key, Conrtibutors_Guild_ViewEditMode_Value), "BMI", "'Guild' of First Data Row", Conrtibutors_Guild_ViewEditMode_Value, "innerHTML");

			//From Test Step: "TC_AM_CT_068"
			//////Network Change from "IFC Linear" to "AMC"
			switchIntoFrame(frameParent3Xpath);
			selectDropdownValue(loc_EditContributor_Network_DropDown, "Network Drop Down", Contributor_Network3, Contributor_Network3);
			sleepTime(3);
			switchIntoFrame(frameParent4Xpath);
			verifyFieldValueOfHeader(loc_VendorAppendReplace_RadioButton1, ContributorSearch_Warning_RadioButton1_ValidationMessage, "'Saved Data' Radio button at contributor warning", ContributorSearch_Warning_RadioButton1_ValidationMessage);
			verifyFieldValueOfHeader(loc_VendorAppendReplace_RadioButton2, ContributorSearch_Warning_RadioButton2_ValidationMessage, "'My Network Entry was error' Radio button at contributor warning", ContributorSearch_Warning_RadioButton2_ValidationMessage);
			verifyFieldValueOfHeader(loc_VendorAppendReplace_RadioButton3, ContributorSearch_Warning_RadioButton3_ValidationMessage, "'Do not save any unsaved data' Radio button at contributor warning", ContributorSearch_Warning_RadioButton3_ValidationMessage);
			clickOn(loc_VendorAppendReplace_RadioButton1,"'Saved Data' Radio button at contributor warning",ContributorSearch_Warning_RadioButton1_ValidationMessage);
			clickUsingJSExecutor(OKButton, "OK button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			// Verify the Rank order is blank and Promotable Star is Uncheck for AMC Network
			ExecutionLog.Log("*******Verify the Rank order is blank and Promotable Star is uncheck for AMC Network*******");
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value);
			sleepTime(2);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", "Unchecked", "'Portable Star Status' of First Data Row", Conrtibutors_PromotableStar_EditMode_Value, "title");

			clickUsingJSExecutor(loc_Save, "Save Button at 'Edit Window'");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("btnEdit");
			//// TODO BUG ID : 20302
			ExecutionLog.Log("====BUG ID===== : 20302");
			verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network3, Contributor_Network3);
			//// Once Bug ID: 20302 is fixed then delete the below line
			selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network3, Contributor_Network3);
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value);
			verifyElementNotPresent(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_ViewMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value);

			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("btnEdit");
			//// Once Bug ID: 20302 is fixed then delete the below line
			verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network3, Contributor_Network3);
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(By.id("btnSave"));
			sleepTime(3);

			supportclick_AppliesToField = getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value);

			//Enter Values in RankOrder Field
			clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), Conrtibutors_RankOrder_ViewEditMode_Value,Conrtibutors_RankOrder_ViewEditMode_Value);
			sendKeys(loc_Contributor_ContributorSearch_RankOrderInputField, "3", "Rank Order Field of first Row", Conrtibutors_RankOrder_ViewEditMode_Value);
			clickOn(supportclick_AppliesToField,"Support click on Applies To Field");
			// Uncheck Promotable star for IFC Linear: TC_AM_CT_071
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_EditMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value,Conrtibutors_PromotableStar_ViewMode_Value);

			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Contributor Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("btnEdit");

			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "3", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
			verifyElementPresent(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_ViewMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value);

			//////Network Change to "IFC Linear"
			// Test Step: "TC_AM_CT_074"
			selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network2, Contributor_Network2);
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("btnEdit");
			verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network2, Contributor_Network2);

			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "2", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
			verifyElementPresent(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_ViewMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value);

			sleepTime(3);
			selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("btnEdit");
			verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
			verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", Conrtibutors_RankOrder_ViewEditMode_Key, Conrtibutors_RankOrder_ViewEditMode_Value), "1", "Rank Order of First Data Row", Conrtibutors_RankOrder_ViewEditMode_Value, "innerHTML");
			verifyElementPresent(getLocator_EditTAB_DataRow("1", Conrtibutors_PromotableStar_ViewMode_Key, Conrtibutors_PromotableStar_EditMode_Value)+"/img", Conrtibutors_PromotableStar_ViewMode_Value);


			//HomeIcon
			switchIntoFrame(frameParent2Xpath);
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath(HomeIconXpath)));
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			ExecutionLog.Log("*********************End Testcase - TC1_ContibutorUI *********************");
		}
	}

	
	public void createContributorInListMaintenance() throws Exception{

		switchIntoFrame(frameParent1Xpath);
		WaitForElementToClickable(By.xpath(ModulesXpath));
		driver.findElement(By.xpath(AdministrationXpath)).click();
		sleepTime(6);
		WaitForElementToClickable(By.xpath(ListMaintenanceXpath));
		driver.findElement(By.xpath(ListMaintenanceXpath)).click();
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Maintain"), "Link at Menu");
		clickUsingJSExecutor(loc_PageLink.replace("@var", "External Parties"), "'External Parties' Link under Maintain Menu Link");
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Cast"), "Contributors Link under 'External Parties'");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.cssSelector("input[id*='NewBtn']"));
		clickUsingJSExecutor(loc_ListMaintenance_ExternalContributor_NewButton, "ListMaintenance_ExternalContributor_NewButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		WaitForElementPresent(ByLocator(loc_ListMaintenance_ExternalContributor_FirstName));
		clickOn(loc_ListMaintenance_ExternalContributor_FirstName,"First Name Field");
		sendKeys(loc_ListMaintenance_ExternalContributor_FirstName, ExternalPartyFirst, "ExternalPartyFirst Name", "ExternalPartyFirst Name");
		clickOn(loc_ListMaintenance_ExternalContributor_LastName,"Last Name Field");
		sendKeys(loc_ListMaintenance_ExternalContributor_LastName, ExternalPartyFirst, "ExternalPartyLast Name", "ExternalParty Last Name");
		// Verify the text of AKA Header
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameHeader, "Contributor_ContributorSearch_Add_AKA_AlternateNameHeader", ContributorSearch_Add_AKA_AlternateNameHeader, "innerHTML");
		verifyTextMatches(loc_Contributor_ContributorSearch_Add_AKA_TypeHeader, "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader", Contributor_ContributorSearch_Add_AKA_TypeHeader, "innerHTML");

		// Enter values in AKA Field
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_TypeField, "Contributor_ContributorSearch_Add_AKA_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownIcon, "Contributor_ContributorSearch_Add_AKA_TypeField",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("***********The below mentioned are drop down values of AKA Type****************");
		verifyAllAvailableValues(loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownValues, "Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownValues", "AM_Conrtibutors", 101, Contributor_ContributorSearch_Add_AKA_TypeHeader);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameField, "Contributor_ContributorSearch_Add_AKA_AlternateNameField",ContributorSearch_Add_AKA_AlternateNameHeader);
		sendKeys(Loc_Details_AssetTitleRowInput, "AlternateName_AKA", "Contributor_ContributorSearch_Add_AKA_AlternateNameField", ContributorSearch_Add_AKA_AlternateNameHeader);
		sleepTime(2);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AKA_TypeField, "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader",Contributor_ContributorSearch_Add_AKA_TypeHeader);
		sendKeys(loc_Contributor_ContributorSearch_Add_AKA_TypeInputField, "AKA", "Contributor_ContributorSearch_Add_AKA_AlternateTypeHeader", Contributor_ContributorSearch_Add_AKA_TypeHeader);
		sleepTime(2);
		clickOn(loc_Contributor_ContributorSearch_Add_AKA_AlternateNameField, "Contributor_ContributorSearch_Add_AKA_AlternateNameField",ContributorSearch_Add_AKA_AlternateNameHeader);

		verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", ContributorSearch_Add_AddressTypeDropDownValue, "Contributor_ContributorSearch_Add_AddressTypeDropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "Contributor_ContributorSearch_Add_AddressLine1InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);
		sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "AddressLine1", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);
		sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine2InputField, "AddressLine2", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_CityInputField, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);
		sendKeys(loc_Contributor_ContributorSearch_Add_CityInputField, "City", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_CountryInputField, "Country Input Field", "Canada", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country);
		selectDropdownValue(loc_Contributor_ContributorSearch_Add_StateInputField, "Contributor_ContributorSearch_Add_StateInputField", "Alberta", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State);
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_ZipCodeField, "Contributor_ContributorSearch_Add_ZipCodeField");
		sendKeys(loc_Contributor_ContributorSearch_Add_ZipCodeField, "12345", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "Contributor_ContributorSearch_Add_BusinessPhone Input Field");
		sendKeys(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "6176828224", "Contributor_ContributorSearch_Add_BusinessPhone Field", ContributorSearch_Add_BusinessPhoneLabel);

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
		
		
		sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "primary1" + randomInt + "@gmail.com", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactListDropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Home, "Contributor_ContributorSearch_Add_ContactList2DropDown");
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact1_InputField, "Contributor_ContributorSearch_Add_Contact1_InputField");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact1_InputField, Contributor_ContributorSearch_Add_Comm_Home, "Contributor_ContributorSearch_Add_Contact1_InputField", "Contributor_ContributorSearch_Add_ContactListDropDown");

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList2DropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Mobile, "Contributor_ContributorSearch_Add_ContactList2DropDown");
		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "Contributor_ContributorSearch_Add_Contact2_InputField");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "6176828224", "Contributor_ContributorSearch_Add_Contact2_InputField Field", "Contributor_ContributorSearch_Add_ContactListDropDown");

		selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList3DropDown, "Contributor_ContributorSearch_Add_ContactList3DropDown", Contributor_ContributorSearch_Add_Comm_Personal, "Contributor_ContributorSearch_Add_ContactList3DropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "Contributor_ContributorSearch_Add_ContactList3DropDown");
		sendKeys(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "personal1"  + randomInt + "@gmail.com", "Contributor_ContributorSearch_Add_ContactList3DropDown Field", "Contributor_ContributorSearch_Add_ContactList3DropDown");

		clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_WebAddressInputField, ContributorSearch_Add_WebAddressLabel);
		sendKeys(loc_Contributor_ContributorSearch_Add_WebAddressInputField, "www.web.com", "Contributor_ContributorSearch_Add_WebAddressField", ContributorSearch_Add_WebAddressLabel);

		clickUsingJSExecutor(loc_Episodes_Save, "Save Genral Info. Button at External Contributor Add Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);

	}

}


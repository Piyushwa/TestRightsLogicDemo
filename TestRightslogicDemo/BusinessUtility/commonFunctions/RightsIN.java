package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import rightsIN.RI_BusinessTerms;
import utility.DriverHelper;
import utility.ExecutionLog;



public class RightsIN extends DriverHelper{
	
	public RightsIN() {
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}
	
	public void navigateToRightsIN() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		WaitForElementPresent(ModulesXpath);
		sleepTime(2);
		clickOn(ModulesXpath, "Modules");
		clickOn(ModulesXpath, "Modules");
		sleepTime(6);
		clickOn(RightsInXpath, "RightsIN");
	}
	
	public void selectDeal(String dealName) throws Exception {
		switchIntoFrame(frameParent2Xpath);
		doubleClick("//*[@title='"+ dealName + "']", dealName + "Deal" , dealName);
		WaitForModalPanel();

	}
	
	public void createDeal(String CreatedDeal, Object... AgreementName_DealType ) throws Exception{
		switch(ClientName) {
		   case "SKY" :
			   defaultDealCreation(CreatedDeal + "_Master", "Master Agreement","Acquisition-Program");
			   defaultDealCreation(CreatedDeal, "Attachment & Link to Master", "Acquisition-Program");
		      break; 
		   default : 
			   defaultDealCreation(CreatedDeal, AgreementName_DealType);  
		}
		
	}

	/**
	 * 
	 * @param CreatedDeal
	 * @param Methodname
	 * @param AgreementName_DealType : Pass the name of the agreement if you want to create a master Agreement
	 * @throws Exception
	 */
	public void defaultDealCreation(String CreatedDeal, Object... AgreementName_DealType ) throws Exception{
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "Module ");
		sleepTime(6);
		clickOn(RightsInXpath, "Rights IN TAB ");
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_NewButton, "New Button");

		try {
			if(AgreementName_DealType[0].toString().contains("Master Agreement")) {
				clickUsingJSExecutor(loc_AssetType_New.replace("@var", "Master Agreement"), AgreementName_DealType[0].toString());
			} else if(AgreementName_DealType[0].toString().contains("Attachment & Link to Master")) {
				
				clickUsingJSExecutor(loc_AssetType_New.replace("@var", "Attachment & Link to Master"), AgreementName_DealType[0].toString());
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);
				//Enter value in Asset Title Field in Search
				sendKeys(loc_DealTitleField, CreatedDeal+ "_Master", "Deal Name", "");
				sleepTime(2);
				clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

				WaitForElementToClickable(loc_SearchedAsset);
				moveMouse(loc_SearchedAsset, "First Deal in the Searched Deal");
				clickOn(loc_SearchedAsset, "First Deal in the Searched Deal");
				sleepTime(3);
				clickUsingJSExecutor(loc_ViewAsset, "View Deal");
				WaitForModalPanel();
				sleepTime(3);
				switchIntoFrame(frameParent2Xpath);

				
			} else {
					
			}
		} catch (Exception e) {
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", "Standalone Agreement"), "Standalone Agreement");
		}

		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		//Deal Id
		int ElementPresent = driver.findElements(By.xpath(loc_DealIDValue)).size();
		if (ElementPresent>0)
		{
			ExecutionLog.Log("Generated Deal Id is:  " + getText(loc_DealIDValue));
		}else {
			ExecutionLog.Log("====Failed===== Field Deal Id is not shown.");
		}

		//Deal name
		clickUsingJSExecutor(loc_DealTitleField, "DealTitleField");
		sendKeys(loc_DealTitleField, CreatedDeal, "Deal Name Field", RI_DealName_Label);


		//Deal description OR contact ID
		if(ClientName.contains("SKY")){
			// substring(0, 5) is used as Deal code allows Max. 6 Characrters
			sendKeys(loc_DealDescription_InputField, getDateStamp().replace("/", "").substring(0, 5), "Deal Code", RI_DealDescription_Label);
//			sendKeys(loc_DealDescription_InputField, "AUT", "Deal Code", RI_DealDescription_Label);
		}else{
		sendKeys(loc_DealDescription_InputField, CreatedDeal +"_desc", "Deal Description/ContractID", RI_DealDescription_Label);
		}

		//Deal type
		try {
			if(AgreementName_DealType[1].toString().length() > 0 ) {
				selectDropdownValue(loc_DealType_DropDownField, "DealType_DropDownField", AgreementName_DealType[1].toString(), RI_DealType_Label);

			} else {
				// select Default deal type :Program Acquisition/Licensed Original
				selectDropdownValue(loc_DealType_DropDownField, "DealType_DropDownField", RI_DealType, RI_DealType_Label);

			}
		} catch (Exception e) {
			selectDropdownValue(loc_DealType_DropDownField, "DealType_DropDownField", RI_DealType, RI_DealType_Label);
		}

		//DealSubtype N/A for TURNER
		selectDropdownValue(loc_DealSubType_DropDownField, "Deal/Agreement Sub Type", RIDealSubtype, RI_DealSubType_Label);

		//Contract status
		// This field is disabled for Corus clients
		sendKeys(loc_ContractStatus, RI_ContractStatus_fullyExecuted, "Deal Creation Contract Status", RI_ContractStatus_Label);

		sendKeys(loc_ContractDataEntryStatus, DealCreationCDEStatus, "DealCreationCDEStatus", RI_DataEntryContractStatus_Label);

		//Date executed   
		sendKeys(loc_DateExecuted_InputField, RI_DateExecuted, "DateExecuted_InputField", RI_DateExecutedStatus_Label);

		//Date effective  
		sendKeys(loc_DateEffective_InputField, RI_DateEffective, "DateEffective_InputField", RI_DateEffectiveStatus_Label);

		//Currency
		sendKeys(loc_Currency_InputField, DealCreationCurrency, "DealCreationCurrency", RI_CurrentCurrency_Label);

		//Project Status
		sendKeys(loc_ProjectStatus_InputField, DealCreationProjectStatus, "ProjectStatus", RI_ProjectStatus_Label);

		//Project Id
		sendKeys(loc_ProjectID_InputField, DealCreationProjectID, "ProjectID_InputField", RI_ProjectID_Label);

		//Profit Center N/A for TURNER
		selectDropdownValue(loc_ProfitCenter_InputField, "ProfitCenter_InputField", RI_DealCreationProfitCenter, RI_ProfitCenter_Label);

		sleepTime(6);
		//Budget line 
		selectDropdownValue(loc_BudgetLine_InputField, "BudgetLine_InputField", DealCreationBudgetLine, RI_BudgetLine_Label);

		// Field - Source Business Unit - channel/entity
		if (isElementPresent(loc_SBUImage))
		{
			clickUsingJSExecutor(loc_SBUImage, "SBU look up Icon", RI_SBU_Label);
			sleepTime(6);
			switchIntoFrame(frameParent3Xpath, RI_SBU_Label);
			clickOn(loc_SelectAllCheckBoxSBU, "Select All Button at SBU", RI_SBU_Label);
			clickOn(loc_FirstCheckBoxAtSBU, "FirstCheckBoxAtSBU", RI_SBU_Label);
			clickOn(loc_NinthCheckBoxAtSBU, "NinthCheckBoxAtSBU", RI_SBU_Label);
			clickOn(Applybutton_AtSBUWindow, "Apply Button", RI_SBU_Label);
			switchIntoFrame(frameParent2Xpath, RI_SBU_Label);
		}else {
			sendKeys(loc_SBUField, AssetCreationSourceBusinessUnit, "SBU", RI_SBU_Label);
			sleepTime(3);
		}


		// DM5 Doc type
		clickUsingJSExecutor(loc_DocType_LookUpIconField, "Doc Type look up Icon", RI_DocType_Label);
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath, RI_DocType_Label);
		clickOn(loc_SelectAllCheckBoxSBU, "Select All Button at SBU", RI_DocType_Label);
		clickOn(loc_FirstCheckBoxAtSBU, "FirstCheckBoxAtSBU", RI_DocType_Label);
		clickOn(loc_NinthCheckBoxAtSBU, "NinthCheckBoxAtSBU", RI_DocType_Label);
		clickOn(Applybutton_AtSBUWindow, "Apply Button", RI_DocType_Label);
		switchIntoFrame(frameParent2Xpath, RI_DocType_Label);
		
		try {
			if(!AgreementName_DealType[0].toString().contains("Attachment & Link to Master")) {
				AddPartyForDeal();
			}
		} catch (Exception e) {
			AddPartyForDeal();
		}
		
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		
		// Select Workflow check box
		clickOn(loc_SkipWorkflowCheckBox, "Skip Workflow CheckBox", RI_SkipWorkflow_Label);

		///*Saving A Deal*/
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button", "");
		switchIntoFrame(frameParent2Xpath);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyFieldValueOfHeader(loc_CreatedAssetAtHome, CreatedDeal, "CreatedDeal", "CreatedDeal");

	}
	
	
	public void AddPartyForDeal() throws Exception {
		//Adding Party  
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath, RI_DocType_Label);
		moveMouse(loc_Party_AddButton, "Party_AddButton");
		clickOn(loc_Party_AddButton, "Party_AddButton", RI_Parties_AddButton);
		if (!(ClientData.contains("AMCN")  || ClientData.contains("SALESDEMO")  || ClientData.contains("CORUS") || ClientData.contains("SKY"))){
			clickUsingJSExecutor(Partiesxpath+"[1]//img", "PartyPopUp Icon");
		} 
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName1, "Search Party InputField", RI_EnterNameToSearch_Label);
		doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		sleepTime(1);
		if(isElementPresent("//td[4][contains(text(),'"+RI_PartyName1+"')]")) {
			clickOn("//td[4][contains(text(),'"+RI_PartyName1+"')]", RI_PartyName1);
			clickOn(SaveButton, "Select Button");
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
		} else {
			// Create the Party
			driver.switchTo().window(driver.getWindowHandle());
			WaitForElementPresent(OKAlertXpath);
			String ExpectedText = "No search results were found for this query. Please try again using different criteria.";
			verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 
			switchIntoFrame(frameParent3Xpath);
			clickOn(LocAdd, "Add Party Button") ;
			
			switchIntoFrame(frameParent4Xpath);
			selectDropdownValue(loc_Contributor_PartyListType_DropDown, "Party Type Drop Down", RI_Partytype_CreatePartyWindow_Outlet, RI_Partytype_CreatePartyWindow_Outlet);
			selectDropdownValue(loc_Outlets_PartiesAddParty, "Outlets_PartiesAddParty", RI_DealCreationProfitCenter, RI_ProfitCenter_Label);
			sendKeys(loc_VendorAddWindow_PartyName, RI_PartyName1, "Party Name",  "");

			verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", "Primary", "Contributor_ContributorSearch_Add_AddressTypeDropDown");
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
			
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			sleepTime(3);
			verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);
			driver.switchTo().window(driver.getWindowHandle());
			clickOn(loc_AddParty_CloseWindow,"close Add Party Window");
			
			switchIntoFrame(frameParent3Xpath);
			sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName1, "Search Party InputField", RI_EnterNameToSearch_Label);
			doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			
			clickOn("//td[4][contains(text(),'"+RI_PartyName1+"')]", RI_PartyName1);
			clickOn(SaveButton, "Select Button");
			
			
		}
		
		// Select Party Type
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Partiesxpath+"[1]/td[4]", "Party Type Field");
		sendKeys(loc_PartyType_InputField, RI_Partytype_Primary, "Party Party InputField", RI_Parties_PartyType);
		clickOn(Partiesxpath+"[1]/td[2]", "Support Click ");

		//Add Second Party
		clickUsingJSExecutor(loc_Party_AddButton, "Party_AddButton");
		if (!(ClientData.contains("AMCN") || ClientData.contains("SALESDEMO") || ClientData.contains("CORUS")|| ClientData.contains("SKY"))){
			clickUsingJSExecutor(Partiesxpath+"[2]//img", "PartyPopUp Icon");
		}
		
		sleepTime(5);
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName2, "Search Party InputField", RI_EnterNameToSearch_Label);
		doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
		WaitForModalPanel();
		sleepTime(5);
		switchIntoFrame(frameParent3Xpath);
		
		if(isElementPresent("//td[4][contains(text(),'"+RI_PartyName2+"')]")) {
			switchIntoFrame(frameParent3Xpath);
			clickOn("//td[4][contains(text(),'"+RI_PartyName2+"')]", "Select Party");
			clickOn(SaveButton, "Select Button");
			sleepTime(3);

		} else {
			// Create the Party
			driver.switchTo().window(driver.getWindowHandle());
			WaitForElementPresent(OKAlertXpath);
			String ExpectedText = "No search results were found for this query. Please try again using different criteria.";
			verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 
			switchIntoFrame(frameParent3Xpath);
			clickOn(LocAdd, "Add Party Button") ;
			
			switchIntoFrame(frameParent4Xpath);
			selectDropdownValue(loc_Contributor_PartyListType_DropDown, "Party Type Drop Down", RI_Partytype2_CreatePartyWindow, RI_Partytype2_CreatePartyWindow);
			sendKeys(loc_VendorAddWindow_PartyName, RI_PartyName2, "Party Name",  "");

			verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", "Primary", "Contributor_ContributorSearch_Add_AddressTypeDropDown");
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
			
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			sleepTime(3);
			verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);
			driver.switchTo().window(driver.getWindowHandle());
			clickOn(loc_AddParty_CloseWindow,"close Add Party Window");
			sleepTime(5);
			switchIntoFrame(frameParent3Xpath);
			sendKeys(loc_Contributor_ContributorSearch_SearchField, RI_PartyName2, "Search Party InputField", RI_EnterNameToSearch_Label);
			doubleClick(loc_FindButton, "RI Search Party Window Find Button", RI_Find_Button);
			WaitForModalPanel();
			sleepTime(5);
			switchIntoFrame(frameParent3Xpath);
			clickOn("//td[4][contains(text(),'"+RI_PartyName2+"')]", "Select Party");
			clickOn(SaveButton, "Select Button");
		}
		
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		// Select the Party Types under the Parties section
		clickUsingJSExecutor(Partiesxpath+"[2]/td[4]", "Party Type Field");
		sendKeys(loc_PartyType_InputField, RI_Partytype2, "Party Party InputField", RI_Parties_PartyType);
		clickOn(Partiesxpath+"[1]/td[4]", "Support Click ");
		
	}
	/**
	 * @author Rajuddin
	 * @param Methodname
	 * @param AssetType
	 * @param AssetTitle
	 * @throws Exception
	 * 
	 * @Description : Click on "Asset Maintenance" TAB >> click Search Link 
	 * Select Property/Asset Search
	 * Enter the name of Asset and click on find Now button
	 * Select the Asset from the opened list \n
	 * click On View button
	 */
	public void searchCreatedAsset_IN_RISearch(String CreatedSeriesAssetTitle) throws Exception {
		switchIntoFrame(frameParent1Xpath);
		navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		clickUsingJSExecutor(loc_Agreement,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Enter value in Asset Title Field in Search
		sendKeys(loc_AssetTitleField, CreatedSeriesAssetTitle, "AssetTitle", "");
		sleepTime(2);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		moveMouse(loc_SearchedAsset, "First Asset in the Searched Asset");
		clickOn(loc_SearchedAsset, "First Asset in the Searched Asset");
		sleepTime(3);
		clickUsingJSExecutor(loc_ViewAsset, "View Asset");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		if(!ClientData.contains("VMN")) {
			verifyTextMatches(loc_DealName, "Deal Name", "I: "+CreatedSeriesAssetTitle+" Deal", "value");
		} else {
			verifyTextMatches(loc_DealName, "Deal Name", "I: Deal Container "+CreatedSeriesAssetTitle+" Deal", "value");

		}
		
	}
	
	
	/**
	 * @author Rajuddin
	 * @param Methodname
	 * @param AssetType
	 * @param AssetTitle
	 * @throws Exception
	 * 
	 * @Description : Click on "Asset Maintenance" TAB >> click Search Link 
	 * Select Property/Asset Search
	 * Enter the name of Asset and click on find Now button
	 * Select the Asset from the opened list \n
	 * click On View button
	 */
	public void searchCreatedDeal(String CreatedDealTitle) throws Exception {
		switchIntoFrame(frameParent1Xpath);
		navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		clickUsingJSExecutor(loc_Agreement,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Enter value in Asset Title Field in Search
		sendKeys(loc_DealTitleField, CreatedDealTitle, "Deal Name", "");
		sleepTime(2);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		WaitForElementToClickable(loc_SearchedAsset);
		moveMouse(loc_SearchedAsset, "First Deal in the Searched Deal");
		clickOn(loc_SearchedAsset, "First Deal in the Searched Deal");
		sleepTime(3);
		clickUsingJSExecutor(loc_ViewAsset, "View Deal");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_DealName, "Deal Name", CreatedDealTitle, "value");
	}

	public void associateAssetWithDeal(String CreatedDeal, String CreatedAssetTitle, Object... AssetType_And_AKA) throws Exception{
		System.out.println();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator", "");
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		sleepTime(10);
		//clickOn(ListDealNavigatorDeal, "Deal", "");
		clickUsingJSExecutor(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		//doubleClick(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_AssetTitle);
		clickOn(loc_AssetStatus, "Asset Status", "");
		clickUsingJSExecutor(loc_AssetTitle, "Asset tile", "");
		sendKeys(loc_AssetTitle, CreatedAssetTitle, "Asset title", "");
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_ProgrameType, "");
		
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset type", AssetType_ProgrameType, "");
		try {
			if((AssetType_And_AKA[0].toString().length()!=0)){
				selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_And_AKA[0].toString(), "");
			}
		} catch (Exception e) {
			if (ClientName.contains("AMCN")){
				clickUsingJSExecutor(loc_AssetType_AllCheckBox, "All Check Box");
			} 
		}

		ExecutionLog.Log(color("red","=====BUG ID======: 20309"));
		clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "Display Season checkBox");
		clickUsingJSExecutor(Loc_SearchButton, "Search Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		sleepTime(3);
		WaitForElementPresent(loc_SearchedAsset);
		doubleClick(loc_SearchedAsset, "Searched Asset", "");
		
		WaitForModalPanel();
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		WaitForElementPresent(ListDealNavigatorDeal);
		WaitForElementPresent(ExpendAsset);
	    clickOn("name="+loc_OkButton, "Ok Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
	}
	

	public void associateAssetWithElementAsset(String CreatedDeal, String CreatedAssetTitle, String CreatedElementAsset, Object... AssetType_And_AKA) throws Exception{
		System.out.println();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator", "");
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		clickOn(loc_AssetAtDealNavigator.replace("@var", CreatedElementAsset), "Element Asset" + CreatedElementAsset, "");
		
		Actions oAction = new Actions(driver);
		oAction.contextClick(driver.findElement(ByLocator(loc_AssetAtDealNavigator.replace("@var", CreatedElementAsset)))).build().perform();
		clickOn(loc_MenuAtDealNavigator.replace("@var", "Associate Related Property"), "Associate Related Property");
		
		
		
		//clickOn(ListDealNavigatorDeal, "Deal", "");
		//clickUsingJSExecutor(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		//doubleClick(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_AssetTitle);
		clickOn(loc_AssetStatus, "Asset Status", "");
		clickUsingJSExecutor(loc_AssetTitle, "Asset tile", "");
		sendKeys(loc_AssetTitle, CreatedAssetTitle, "Asset title", "");
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_ProgrameType, "");
		
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset type", AssetType_ProgrameType, "");
		try {
			if((AssetType_And_AKA[0].toString().length()!=0)){
				selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_And_AKA[0].toString(), "");
			}
		} catch (Exception e) {
			if (ClientName.contains("AMCN")){
				clickUsingJSExecutor(loc_AssetType_AllCheckBox, "All Check Box");
			} 
		}

		ExecutionLog.Log("=====BUG ID======: 20309");
		clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "Display Season checkBox");
		clickUsingJSExecutor(Loc_SearchButton, "Search Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		sleepTime(3);
		WaitForElementPresent(loc_SearchedAsset);
		doubleClick(loc_SearchedAsset, "Searched Asset", "");
		
		WaitForModalPanel();
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		WaitForElementPresent(ExpendAsset);
	    clickOn("name="+loc_OkButton, "Ok Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
	}
	

	// We nee to modify this method to associate season/episodes or asset as well
	public void associationOfAssetsWithDeal(String CreatedDeal, String CreatedAssetTitle, Object... AssetType_And_AKA) throws Exception{
		System.out.println();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator", "");
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		//clickOn(ListDealNavigatorDeal, "Deal", "");
		clickUsingJSExecutor(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		doubleClick(AssociateWithExitingAsset, "Associate With Exiting Asset", "");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_AssetTitle);
		clickOn(loc_AssetStatus, "Asset Status", "");
		clickUsingJSExecutor(loc_AssetTitle, "Asset tile", "");
		sendKeys(loc_AssetTitle, CreatedAssetTitle, "Asset title", "");
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_ProgrameType, "");
		
//		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset type", AssetType_ProgrameType, "");
		try {
			if((AssetType_And_AKA[0].toString().length()!=0)){
				selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_And_AKA[0].toString(), "");
			}
		} catch (Exception e) {
			if (ClientName.contains("AMCN")){
				clickUsingJSExecutor(loc_AssetType_AllCheckBox, "All Check Box");
			} 
		}

		ExecutionLog.Log("=====BUG ID======: 20309");
		clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "Display Season checkBox");
		clickUsingJSExecutor(Loc_SearchButton, "Search Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(loc_SearchedAsset);
		clickOn(Loc_Toggle, "Toggle", "");
		sleepTime(3);
		WaitForElementPresent(loc_SearchedAsset);
		// Select Both Seasons
		clickUsingJSExecutor(loc_ExpandAssetDetail_At_AssetSearchGrid,"ExpandSeasonIcon");
		sleepTime(5);
		clickOn(loc_Season_AssetSearchGrid.replace("@var", Season1), Season1);
		Keyboard keyboard = ((HasInputDevices)driver).getKeyboard();
        keyboard.pressKey(Keys.SHIFT);
        clickOn(loc_Season_AssetSearchGrid.replace("@var", Season2), Season2);
        keyboard.releaseKey(Keys.SHIFT);
        sleepTime(5);

		
		WaitForModalPanel();
		sleepTime(6);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ListDealNavigatorDeal);
		WaitForElementPresent(ExpendAsset);
	    clickOn("name="+loc_OkButton, "Ok Button", "");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
	}
	
	
	

	/**
	 * This Method checks the functionality of Applies To Windows
	 * @param TestStep
	 * @param AssetName
	 * @throws Exception
	 * 
	 * Pre-requsites:
	 * click on Applies TO pop up
	 * 
	 */

public void appliesTOPopUpWindow( String TestStep, String AssetName) throws Exception{
		
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : " + TestStep);
		ExecutionLog.Log("*****  Applies To  *****"); 
		ExecutionLog.Log("*****  Select All >> Verification >> DeSelectAll >> Verification >> Select Season 1,2 >> Verification >> DeSelectAll >> Verification*****"); 
		
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_APPLIESTO_Pick List ",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");

		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets ");
		sleepTime(2);
		// Check the Epi 101, 102 and verify that season 2 is also gets checked
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode101), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Episode102), "RI_EditMode_AppliesToDropDown_Episode101",RI_MediaRights_EditMode_APPLIESTO_HeaderName);

		// Verify Epi 101, 102 and season 1 are checked
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), "Checked Episode101 ");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode102), "Checked Episode101 ");
		if(!(ClientName.contains("VMN") || ClientName.contains("SKY"))){
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), "Checked Season1 ");
		} else {
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), "Checked Season1 ");
		}
		

		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets ");

		//TC_RI_MR_15
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_MR_15");
		ExecutionLog.Log("Check All the seasons and verify all the episodes are also gets checked");
		//Select all the Seasons under Series Asset
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season1), "RI_EditMode_AppliesToDropDown_Episode101 Check Box",	RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var", RI_MediaRights_Season2), "RI_EditMode_AppliesToDropDown_Episode101",			RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season1), 		"Checked Season1");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode101), 	"Checked Episode101");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode102), 	"Checked Episode102");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Season2), 		"Checked Season2");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode201), 	"Checked Episode201");
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_Episode202), 	"Checked Episode201");
		sleepTime(2);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "on"), "UnChecked Nodes of Assets ");
		clickOn(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset.replace("@var",AssetName), "RI_EditMode_AppliesToDropDown",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
		if(!(ClientName.contains("VMN") || ClientName.contains("SKY"))){
			verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "Checked "+RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "UnChecked Nodes of Assets ");

		} else {
			verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), "Checked "+RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

		}
		
		
		sleepTime(3);
		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll, "'DeSelect All' RI_EditMode_APPLIESTO_Pick List",RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		sleepTime(2);
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
	    sleepTime(2);
		verifyElementPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset.replace("@var", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll+ " check box");
		verifyElementNotPresent(loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes.replace("@var", "off"), "Checked Nodes of Assets ");

		clickOn(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply, "Appply button");
		WaitForModalPanel();
		/*switchIntoFrame(frameParent3Xpath,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", RI_MediaRights_APPLIESTO_Key, RI_MediaRights_EditMode_APPLIESTO_HeaderName), RI_MediaRights_EditMode_AppliesToDropDown_ValueAll, "RI_MediaRights_EditMode_AppliesToDropDown_ValueAll",RI_MediaRights_EditMode_APPLIESTO_HeaderName, "innerHTML");

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_EnterRequiredFields);*/
		
	}
	
	public void functionalityOfPopUpWindow( String TestStep, String HeaderName, String searchText) throws Exception {
		ExecutionLog.Log("");
		ExecutionLog.Log("***************" + HeaderName + " Template*****");
		ExecutionLog.Log("From Manual Test Step : " + TestStep);
		
		switchIntoFrame(frameParent4Xpath, HeaderName);
		switchIntoFrame(frameParent4Xpath, HeaderName);
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 		RI_MediaRights_EditMode_ExpandAll_Button, 	"RI_MediaRights_EditMode_ExpandAll_Button",		RI_MediaRights_EditMode_ExpandAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 	RI_MediaRights_EditMode_CollapseAll_Button, "RI_MediaRights_EditMode_CollapseAll_Button",	RI_MediaRights_EditMode_CollapseAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 		RI_MediaRights_EditMode_SelectAll_Button, 	"RI_MediaRights_EditMode_SelectAll_Button",		RI_MediaRights_EditMode_SelectAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, 	RI_MediaRights_EditMode_DeSelectAll_Button, "RI_MediaRights_EditMode_DeSelectAll_Button",	RI_MediaRights_EditMode_DeSelectAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 			RI_MediaRights_EditMode_Apply_Button, 		"RI_MediaRights_EditMode_Apply_Button",			RI_MediaRights_EditMode_Apply_Button, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Cancel, 		RI_MediaRights_EditMode_Cancel_Button, 		"RI_MediaRights_EditMode_Cancel_Button",		RI_MediaRights_EditMode_Cancel_Button, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search, RI_MediaRights_EditMode_Search_Button, 		"RI_MediaRights_EditMode_Search_Button", 		searchText);
		
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, "Collapsed Icons", RI_MediaRights_EditMode_Search_Button);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, "Expand Icon");

		sendKeys(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search_InputField, searchText, "RI_MediaRights_"+ HeaderName + "_Search", searchText);
		verifyElementPresent(loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Searched_Result.replace("@var", searchText), "Searched Data '" + searchText + "'", searchText);

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
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",HeaderName);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets at "+ HeaderName + " ");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), 	"Checked Nodes of Assets at "+ HeaderName + "");


		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",HeaderName);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets at "+ HeaderName + "");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), 	"Unchecked Nodes of Assets at "+ HeaderName + "");

		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, "Appply button");
		ExecutionLog.Log("**********Validation message on clikcing apply button without select any check box**********");
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_EditMode_MediaType_SelectAtLeastOneElement, "Alert Message RI_MediaRights_EditMode_"+ HeaderName + "", HeaderName);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", HeaderName);
		switchIntoFrame(frameParent4Xpath, 	HeaderName);

		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 	"'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",HeaderName);
		clickOn(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");

	}

	/**
	 * After this method verify that row is not shown in view mode
	 * @param TestStep
	 * @param firstRowLocator
	 * @param HeaderName
	 * @param PlzSelectRow
	 * @param Confirm_WishToDelete
	 * @throws Exception
	 */
	public void functionalityOfDeleteTheRow(String TestStep, String firstRowLocator, String HeaderName, String PlzSelectRow, String Confirm_WishToDelete) throws Exception {
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButtonCommon);
		sleepTime(5);
		if(Browser.contains("firefox")){
			clickUsingJSExecutor(Loc_EditButtonCommon, "'Edit' Button");
		}else{
			clickOn(Loc_EditButtonCommon, "'Edit' Button");
		}
		
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", PlzSelectRow);
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	PlzSelectRow, "Alert Message do not select the row and click Delete", PlzSelectRow);
		
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath", PlzSelectRow);
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath, Confirm_WishToDelete);
	    clickOn(firstRowLocator, "First row", Confirm_WishToDelete); 
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", Confirm_WishToDelete);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	Confirm_WishToDelete, "Alert Message ConfirmationToDeleteRow_ValidationMessage", Confirm_WishToDelete);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up",Confirm_WishToDelete);
		
		
		switchIntoFrame(frameParent3Xpath, Confirm_WishToDelete);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button", Confirm_WishToDelete);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	Confirm_WishToDelete, "Alert Message ConfirmationToDeleteRow_ValidationMessage", Confirm_WishToDelete);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up", Confirm_WishToDelete);
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
		clickOn(firstRowLocator, "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	Confirm_WishToDelete, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();

	}
	public void moveToElementClick(String Locator){
		WebElement wb = driver.findElement(By.xpath(Locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(wb).click().build().perform();
	}
	
	public void checkBoxFunctionlity(String Locator, String CheckBoxHeader) throws Exception {
		if(!CheckBoxHeader.contains("N/A")){
		switchIntoFrame(frameParent3Xpath, CheckBoxHeader);
		clickOn(Locator, "", "");
		sleepTime(1);
		clickOn(Locator+"/img", CheckBoxHeader + " Check Box", CheckBoxHeader);
		sleepTime(2);
		verifyElementPresent(Locator+"/img[@title='Checked']", CheckBoxHeader + "check box gets Checked", CheckBoxHeader);
		sleepTime(3);
		
		clickOn(Locator+"/img", CheckBoxHeader + " Check Box", CheckBoxHeader);
		sleepTime(2);
		verifyElementPresent(Locator+"/img[@title='Unchecked']", CheckBoxHeader + " check box gets Unchecked", CheckBoxHeader);
		sleepTime(3);
		
		clickOn(Locator+"/img", CheckBoxHeader + " Check Box", CheckBoxHeader);
		sleepTime(2);
		verifyElementPresent(Locator+"/img[@title='Checked']", CheckBoxHeader + " check box gets Checked", CheckBoxHeader);
		}
	}
	
	
	public void noteFunctionlity(String TestData) throws Exception {
		RI_BusinessTerms businessTerm = new RI_BusinessTerms();
		
		ExecutionLog.Log("");
		ExecutionLog.Log("*****  Notes *****"); 
		ExecutionLog.Log("Verify Headers/Buttons of Note Pop up >> save >> Verify message >> Add New Row >> Check , Uncheck , Check the Restriction/IncludeInReport check box >> Verify Entered data >> Save Note >> Verify Note Window is not Shown");
		
		switchIntoFrame(frameParent4Xpath,	RI_BUSINESS_TERMS_HeaderName);
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
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Note_BusinessTerm1), RI_MediaRights_Note_BusinessTerm1 ,RI_MediaRights_EditMode_APPLIESTO_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Template_Key, RI_MediaRights_NoteWind_Template_HeaderName), "Use Template Field",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_BusinessTerms_EditMode_DropDownImage, "Use Template Drop Down image",	RI_MediaRights_NoteWind_Template_HeaderName);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_MediaRights_Note_UseTemplate1), RI_MediaRights_Note_UseTemplate1 ,RI_MediaRights_NoteWind_Template_HeaderName);
		
		clickOn(businessTerm.getLocator_EditTAB_DataRow("1", RI_MediaRights_NoteWind_Notes_Key, RI_MediaRights_NoteWind_Notes_HeaderName), "Term Description Field",	RI_MediaRights_NoteWind_Notes_HeaderName);
		sendKeys(loc_RI_MediaRights_NoteWind_Descrip_InputField, TestData, "Term Description Data", RI_MediaRights_NoteWind_Notes_HeaderName);
		
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
		/*switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		
		if(!ClientData.contains("VMN")) {
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);
		}*/
		
		
	}






public void agreementSearchPickList(String Locater) throws Exception {
	switchIntoFrame(frameParent3Xpath);
	sleepTime(3);
	verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
	verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
	verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
	verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
	clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
	verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
	sleepTime(3);
	clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
	verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
	sleepTime(3);
	clickUsingJSExecutor(LocCancel, "Cancel button", "");
	switchIntoFrame(frameParent2Xpath);	
}
}

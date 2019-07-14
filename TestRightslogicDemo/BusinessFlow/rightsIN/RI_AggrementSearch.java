
package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_AggrementSearch extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	
	
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);

	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
	
	String CreatedSeriesAssetTitle2 = "AUT_AssetSeries2_" +formattedDate+"";
	String CreatedDeal2 = "AUT_Deal2_" +formattedDate+"";
	
	public RI_AggrementSearch() {
		className = this.getClass().getName();

	}
	@Test(priority =1,enabled= true,description = "Verify Agreement Search (UI)")
	public void TC1_RI_AggrementSearchUI() throws InterruptedException, Exception {
		switchIntoFrame(frameParent1Xpath);
		rightIN.navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(SearchXpath, "Search Icon", "Search");
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		Thread.sleep(3000);
//		verifyTextMatches(loc_RI_AggrementSearch, "Agreement Link", "Agreements");
		clickUsingJSExecutor(loc_RI_AggrementSearch,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//TC_RI_AS_002
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPropertyTitle, RI_AggrementSearchPropertyTitle, "Property Title", RI_AggrementSearchPropertyTitle);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchEpisode, RI_AggrementSearchEpisode, "Episode #(s)", RI_AggrementSearchEpisode);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchChannelEntity, RI_AggrementSearchChannelEntity, "Channel / Entity", RI_AggrementSearchChannelEntity);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractName, RI_AggrementSearchContractName, "Contract Name", RI_AggrementSearchContractName);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRMSContractType, RI_AggrementSearchRMSContractType, "RMS Contract Type", RI_AggrementSearchRMSContractType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchDM5DocType, RI_AggrementSearchDM5DocType, "DM5 Doc Type", RI_AggrementSearchDM5DocType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPartyRepresenting, RI_AggrementSearchPartyRepresenting, "Party/Representing", RI_AggrementSearchPartyRepresenting);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchVMNParty, RI_AggrementSearchVMNParty, "VMN Party", RI_AggrementSearchVMNParty);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchServices, RI_AggrementSearchServices, "Services", RI_AggrementSearchServices);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractStatus, RI_AggrementSearchContractStatus, "Contract Status", RI_AggrementSearchContractStatus);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractEntryStatus, RI_AggrementSearchContractEntryStatus, "Contract Entry Status", RI_AggrementSearchContractEntryStatus);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractDtFm, RI_AggrementSearchContractDtFm, "Contract Dt Fm", RI_AggrementSearchContractDtFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRevisionDtFm, RI_AggrementSearchRevisionDtFm, "Revision Dt Fm", RI_AggrementSearchRevisionDtFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdatedBy, RI_AggrementSearchLastUpdatedBy, "Last Updated By", RI_AggrementSearchLastUpdatedBy);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreatedBy, RI_AggrementSearchCreatedBy, "Created By", RI_AggrementSearchCreatedBy);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAgreementType, RI_AggrementSearchAgreementType, "Agreement Type", RI_AggrementSearchAgreementType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchTeamMember, RI_AggrementSearchTeamMember, "Team Member", RI_AggrementSearchTeamMember);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIDType, RI_AggrementSearchIDType, "IDType", RI_AggrementSearchIDType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAKAsFKAs, RI_AggrementSearchAKAsFKAs, "AKAs/FKAs", RI_AggrementSearchAKAsFKAs);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchReturnAttachments, RI_AggrementSearchReturnAttachments, "Return Attachments", RI_AggrementSearchReturnAttachments);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeDeleted, RI_AggrementSearchIncludeDeleted, "Include Deleted", RI_AggrementSearchIncludeDeleted);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExactMatch, RI_AggrementSearchExactMatch, "Exact Match", RI_AggrementSearchExactMatch);

		//Button
		verifyFieldValueOfHeader(Loc_SearchButton, RI_AggrementSearchSearch, "Search Button", RI_AggrementSearchSearch, "value");
		verifyFieldValueOfHeader(Loc_ClearSearch, RI_AggrementSearchClearSearch, "Clear Search Button", RI_AggrementSearchClearSearch, "value");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchSaveSearchButton, RI_AggrementSearchSaveSearch, "Save Search Button", RI_AggrementSearchSaveSearch, "value");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRestoreSearch, RI_AggrementSearchRestoreSearch, "Restore Search Button", RI_AggrementSearchRestoreSearch, "value");

		//Advance Search 
		//TC_RI_AS_007
		clickUsingJSExecutor(loc_RI_AggrementSearchExpandAdvanceSearch,"Expand Advance Search");
		Thread.sleep(3000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRightsMedia, RI_AggrementSearchRightsMedia, "Rights (incl. Media)", RI_AggrementSearchRightsMedia);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchTerritory, RI_AggrementSearchTerritory, "Territory", RI_AggrementSearchTerritory);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLicenseDatesFm, RI_AggrementSearchLicenseDatesFm, "License Dates Fm", RI_AggrementSearchLicenseDatesFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchObligationType, RI_AggrementSearchObligationType, "Obligation Type", RI_AggrementSearchObligationType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchFutureProperty, RI_AggrementSearchFutureProperty, "Future Property", RI_AggrementSearchFutureProperty);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExpirationDateFm, RI_AggrementSearchExpirationDateFm, "Expiration Date Fm", RI_AggrementSearchExpirationDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdateDateFm, RI_AggrementSearchLastUpdateDateFm, "Last Update Date Fm", RI_AggrementSearchLastUpdateDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreationDateFm, RI_AggrementSearchCreationDateFm, "Creation Date Fm", RI_AggrementSearchCreationDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptionDeadlineFm, RI_AggrementSearchOptionDeadlineFm, "Option Deadline Fm", RI_AggrementSearchOptionDeadlineFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereAirDateFm, RI_AggrementSearchPremiereAirDateFm, "Premiere Air Date Fm", RI_AggrementSearchPremiereAirDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereNetwork, RI_AggrementSearchPremiereNetwork, "Premiere Network", RI_AggrementSearchPremiereNetwork);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAttributes, RI_AggrementSearchAttributes, "Attributes", RI_AggrementSearchAttributes);
        
		//TC_RI_AS_008
		sendKeys(loc_RI_AggrementSearchPropertyTitleInput, CreatedSeriesAssetTitle1, "Property Title Input", RI_AggrementSearchPropertyTitle);
		Thread.sleep(2000);
		clickOn(loc_RI_AggrementSearchAKAsFKAsCheckbox, "AKAs/FKAs Check box", RI_AggrementSearchAKAsFKAs);
		Thread.sleep(1000);
		verifyElementNotPresent("//*[@id='chkAKA' and @checked= 'true']", "Unchecked");
		clickOn(loc_RI_AggrementSearchAKAsFKAsCheckbox, "AKAs/FKAs Check box", RI_AggrementSearchAKAsFKAs);
		Thread.sleep(1000);
		verifyElementPresent("//*[@id='chkAKA' and @checked= 'checked']", "checked");


		verifyDropDownValues(loc_RI_AggrementSearchChannelEntityDroupdown, "Channel Entity Droupdown value verify", "RI_AggrementSearch", 75, 135);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchChannelEntityPicklist);
		//Deal Name
		//TC_RI_AS_025
		sendKeys(loc_RI_AggrementSearchDealNameInput, CreatedDeal1, "Deal Name Input", RI_AggrementSearchContractName);
		
		//Return Attachment
		//TC_RI_AS_026
		clickOn(loc_RI_AggrementSearchReturnAttachmentCheckbox, "Return Attachment Check box", RI_AggrementSearchReturnAttachments);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchReturnAttachmentCheckbox, "true", "Verify check box checked", RI_AggrementSearchReturnAttachments, "checked");

		clickOn(loc_RI_AggrementSearchReturnAttachmentCheckbox, "Return Attachment Check box", RI_AggrementSearchContractName);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchReturnAttachmentCheckbox, "null", "Verify check box unchecked", RI_AggrementSearchReturnAttachments, "unchecked");

		//Deal Type
		//TC_RI_AS_029
		verifyDropDownValues(loc_RI_AggrementSearchDealTypeDropdown, "Deal Type Droupdown value verify", "RI_AggrementSearch", 137, 157);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchDealTypePicklist);
		//Document Type
		//
		verifyDropDownValues(loc_RI_AggrementSearchDocumentTypeDropdown, "Document Type Droupdown value verify", "RI_AggrementSearch", 159, 202);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchDealTypePicklist);

		//Party/Representing
		clickOn(loc_RI_AggrementSearchPartyLookupIcone, "party lookup icone", RI_AggrementSearchPartyRepresenting);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		WaitForElementPresent(SaveButton);
		sendKeys(LocTextName, SearchvalueStudio, "Enter party name", RI_AggrementSearchPartyRepresenting);
		clickOn(loc_FindButton, "Find button", RI_AggrementSearchPartyRepresenting);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_AggrementSearchSelectRow.replace("@var", SearchvalueStudio), "Select party", RI_AggrementSearchPartyRepresenting);
		Thread.sleep(3000);
		clickOn(SaveButton, "Select button", RI_AggrementSearchPartyRepresenting);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_RI_AggrementSearchPartyLookupIcone);
		Thread.sleep(1000);

		//VMN Party
		clickOn(loc_RI_AggrementSearchVMNPartyLookupicone, "VMN party lookup icone", RI_AggrementSearchVMNParty);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		WaitForElementPresent(SaveButton);
		sendKeys(LocTextName, SearchvalueVendor, "Enter VMN party name", RI_AggrementSearchVMNParty);
		clickOn(loc_FindButton, "Find button", RI_AggrementSearchVMNParty);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_AggrementSearchSelectRow.replace("@var", SearchvalueVendor), "Select party", RI_AggrementSearchVMNParty);
		Thread.sleep(3000);
		clickOn(SaveButton, "Select button", RI_AggrementSearchVMNParty);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_RI_AggrementSearchVMNPartyLookupicone);
		Thread.sleep(1000);

		//Services
		verifyDropDownValues(loc_RI_AggrementSearchServicesDropdown, "Services Droupdown value verify", "RI_AggrementSearch", 204, 304);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchServicesPicklist);

		//Contract Status
		verifyDropDownValues(loc_RI_AggrementSearchContractStatusDropdown, "Contract Status Droupdown value verify", "RI_AggrementSearch", 306, 322);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchContractStatusPicklist);

		//Contract Entry Status
		//TC_RI_AS_062
		verifyDropDownValues(loc_RI_AggrementSearchContractEntryStatusDropdown, "Contract Entry Status Droupdown value verify", "RI_AggrementSearch", 324, 334);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchContractEntryStatusPicklist);

		//Include Deleted
		clickOn(loc_RI_AggrementSearchIncludeDeletedCheckbox, "Include Deleted Check box", RI_AggrementSearchIncludeDeleted);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeDeletedCheckbox, "true", "Verify check box checked", RI_AggrementSearchIncludeDeleted, "checked");
		clickOn(loc_RI_AggrementSearchIncludeDeletedCheckbox, "Include Deleted Check box", RI_AggrementSearchIncludeDeleted);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeDeletedCheckbox, "null", "Verify check box unchecked", RI_AggrementSearchIncludeDeleted, "unchecked");

		//Contract Dt Fm //Execution  Date Fm/To
		//TC_RI_AS_078
		sendKeys(loc_RI_AggrementSearchdateFrom1, RI_AggrementSearchDataFrom1, "Date From", RI_AggrementSearchContractDtFm);
		sendKeys(loc_RI_AggrementSearchdateTo1, RI_AggrementSearchDateTo, "Date To", RI_AggrementSearchContractDtFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateFrom1, RI_AggrementSearchDataFrom1, "Date From", RI_AggrementSearchContractDtFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateTo1, RI_AggrementSearchDateTo, "Date To", RI_AggrementSearchContractDtFm,"title");

		//Revision Dt Fm
		sendKeys(loc_RI_AggrementSearchdateFrom2, RI_AggrementSearchDataFrom1, "Date From", RI_AggrementSearchRevisionDtFm);
		sendKeys(loc_RI_AggrementSearchdateTo2, RI_AggrementSearchDateTo, "Date To", RI_AggrementSearchRevisionDtFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateFrom2, RI_AggrementSearchDataFrom1, "Date From", RI_AggrementSearchRevisionDtFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateTo2, RI_AggrementSearchDateTo, "Date To", RI_AggrementSearchRevisionDtFm,"title");

		//Last Updated By
		//TC_RI_AS_080
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchLastUpdatedBypicklist);

		//Created By
		//TC_RI_AS_095
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchCreatedBypicklist);


		//Agreement Type
		//TC_RI_AS_114
		verifyDropDownValues(loc_RI_AggrementSearchAgreementTypeDropdown, "Agreement Type Droupdown value verify", "RI_AggrementSearch", 336, 339);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchAgreementTypePicklist);


		//IDType
		//TC_RI_AS_130
		verifyDropDownValues(Loc_RI_AgrementSearchIDType, "ID Type Droupdown value verify", "RI_AggrementSearch", 341, 345);
        selectDropdownValue(Loc_RI_AgrementSearchIDType, "Select "+RI_AgrementSearchIDTypeData+" from Dropdown", RI_AgrementSearchIDTypeData, RI_AggrementSearchIDType);

		//Rights (incl. Media)
        //TC_RI_AS_133
		verifyDropDownValues(loc_RI_AggrementSearchMediaDropdown, "Media  Droupdown value verify", "RI_AggrementSearch", 347, 442);
		functionalityOfPopUpWindow(loc_RI_AggrementSearchMediaPicklist,RI_AggrementSearchRightsMedia);

		//Must Have All 1
		//TC_RI_AS_147
		clickOn(loc_RI_AggrementSearchMustHaveAllMediaCheckbox1, "Must Have All 1 Check box", RI_AggrementSearchRightsMedia);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllMediaCheckbox1, "true", "Verify check box checked", RI_AggrementSearchRightsMedia, "checked");
		clickOn(loc_RI_AggrementSearchMustHaveAllMediaCheckbox1, "Must Have All 1 Check box", RI_AggrementSearchRightsMedia);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllMediaCheckbox1, "null", "Verify check box unchecked", RI_AggrementSearchRightsMedia, "unchecked");

		//Territory
		//TC_RI_AS_149
		verifyDropDownValues(loc_RI_AggrementSearchTerritoryDropdown, "Territory  Droupdown value verify", "RI_AggrementSearch", 444, 476);
		functionalityOfPopUpWindow(loc_RI_AggrementSearchTerritoryPicklist,RI_AggrementSearchTerritory); 

		//Must Have All 2
		//TC_RI_AS_163
		clickOn(loc_RI_AggrementSearchMustHaveAllTerritoryCheckbox2, "Must Have All 2 Check box", RI_AggrementSearchTerritory);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllTerritoryCheckbox2, "true", "Verify check box checked", RI_AggrementSearchTerritory, "checked");
		clickOn(loc_RI_AggrementSearchMustHaveAllTerritoryCheckbox2, "Must Have All 2 Check box", RI_AggrementSearchTerritory);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllTerritoryCheckbox2, "null", "Verify check box unchecked", RI_AggrementSearchTerritory, "unchecked");

		//License Dates Fm 	
		//TC_RI_AS_165
		sendKeys(loc_RI_AggrementSearchLicenseDatesFmInput, RI_AggrementSearchDataFrom1, "LicenseDates From", RI_AggrementSearchLicenseDatesFm);
		sendKeys(loc_RI_AggrementSearchLicenseDatesToInput, RI_AggrementSearchDateTo, "LicenseDates To", RI_AggrementSearchLicenseDatesFm);
		keyboard();
		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateFrom2, RI_AggrementSearchDataFrom1, "Date From", RI_AggrementSearchLicenseDatesFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchdateTo2, RI_AggrementSearchDateTo, "Date To", RI_AggrementSearchLicenseDatesFm,"title");

		//Must Have All 3
		//TC_RI_AS_167
		clickOn(loc_RI_AggrementSearchMustHaveAllDatesCheckbox3, "Must Have All 3 Check box", RI_AggrementSearchLicenseDatesFm);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllDatesCheckbox3, "true", "Verify check box checked", RI_AggrementSearchLicenseDatesFm, "checked");
		clickOn(loc_RI_AggrementSearchMustHaveAllDatesCheckbox3, "Must Have All 3 Check box", RI_AggrementSearchLicenseDatesFm);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMustHaveAllDatesCheckbox3, "null", "Verify check box unchecked", RI_AggrementSearchLicenseDatesFm, "unchecked");


		//Include Records w/o Dates
		//TC_RI_AS_169
		clickOn(loc_RI_AggrementSearchIncludeRecordsDatesCheckbox, "Include Records w/o Dates Check box", RI_AggrementSearchLicenseDatesFm);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeRecordsDatesCheckbox, "true", "Verify check box checked", RI_AggrementSearchLicenseDatesFm, "checked");
		clickOn(loc_RI_AggrementSearchIncludeRecordsDatesCheckbox, "Include Records w/o Dates Check box", RI_AggrementSearchLicenseDatesFm);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeRecordsDatesCheckbox, "null", "Verify check box unchecked", RI_AggrementSearchLicenseDatesFm, "unchecked");

		//Perpetuity
		//TC_RI_AS_172
		clickOn(loc_RI_AggrementSearchPerpetuityCheckbox, "Perpetuity Check box", RI_AggrementSearchFutureProperty);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPerpetuityCheckbox, "true", "Verify check box checked", RI_AggrementSearchFutureProperty, "checked");
		clickOn(loc_RI_AggrementSearchPerpetuityCheckbox, "Perpetuity Check box", RI_AggrementSearchFutureProperty);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPerpetuityCheckbox, "null", "Verify check box unchecked", RI_AggrementSearchFutureProperty, "unchecked");

		//Obligation Type
		//Not cover in manual Test Case
		verifyDropDownValues(loc_RI_AggrementSearchObligationTypeDropdown, "Obligation Type  Droupdown value verify", "RI_AggrementSearch", 478, 563);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchObligationTypePicklist);
		//Future Property
		////Not cover in manual Test Case
		verifyDropDownValues(loc_RI_AggrementSearchFuturePropertyDropdown, "Future Property  Droupdown value verify", "RI_AggrementSearch", 565, 583);


		//Expiration Date Fm
		//TC_RI_AS_174
		sendKeys(loc_RI_AggrementSearchExpirationDateFmInput, RI_AggrementSearchDataFrom1, "Expiration Date Fm", RI_AggrementSearchExpirationDateFm);
		sendKeys(loc_RI_AggrementSearchExpirationDateToInput, RI_AggrementSearchDateTo, "Expiration Date To", RI_AggrementSearchExpirationDateFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchExpirationDateFmInput, RI_AggrementSearchDataFrom1, "Expiration Date Fm", RI_AggrementSearchExpirationDateFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExpirationDateToInput, RI_AggrementSearchDateTo, "Expiration Date To", RI_AggrementSearchExpirationDateFm,"title");


		//Last Update Date Fm
		//TC_RI_AS_176
		sendKeys(loc_RI_AggrementSearchLastUpdateDatFmInput, RI_AggrementSearchDataFrom1, "Last Update Date Fm ", RI_AggrementSearchLastUpdateDateFm);
		sendKeys(loc_RI_AggrementSearchLastUpdateDatToInput, RI_AggrementSearchDateTo, "Last Update Date To ", RI_AggrementSearchLastUpdateDateFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdateDatFmInput, RI_AggrementSearchDataFrom1, "Last Update Date Fm", RI_AggrementSearchLastUpdateDateFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdateDatToInput, RI_AggrementSearchDateTo, "Last Update Date To", RI_AggrementSearchLastUpdateDateFm,"title");


		//Creation Date Fm
		//TC_RI_AS_178
		sendKeys(loc_RI_AggrementSearchCreationDateFmInput, RI_AggrementSearchDataFrom1, "Creation Date Fm ", RI_AggrementSearchCreationDateFm);
		sendKeys(loc_RI_AggrementSearchCreationDateToInput, RI_AggrementSearchDateTo, "Creation Date To ", RI_AggrementSearchCreationDateFm);
		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreationDateFmInput, RI_AggrementSearchDataFrom1, "Creation Date Fm", RI_AggrementSearchCreationDateFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreationDateToInput, RI_AggrementSearchDateTo, "Creation Date To", RI_AggrementSearchCreationDateFm,"title");

		//Option Deadline Fm
		//TC_RI_AS_180
		sendKeys(loc_RI_AggrementSearchOptionDeadlineFmInput, RI_AggrementSearchDataFrom1, "Option Deadline Fm", RI_AggrementSearchOptionDeadlineFm);
		sendKeys(loc_RI_AggrementSearchOptionDeadlineToInput, RI_AggrementSearchDateTo, "Option Deadline To", RI_AggrementSearchOptionDeadlineFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptionDeadlineFmInput, RI_AggrementSearchDataFrom1, "Option Deadline Fm", RI_AggrementSearchOptionDeadlineFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptionDeadlineToInput, RI_AggrementSearchDateTo, "Option Deadline To", RI_AggrementSearchOptionDeadlineFm,"title");


		//Premiere Air Date Fm+
		//TC_RI_AS_182
		sendKeys(loc_RI_AggrementSearchPremiereAirDateFmInput, RI_AggrementSearchDataFrom1, "Premiere Air Date Fm", RI_AggrementSearchPremiereAirDateFm);
		sendKeys(loc_RI_AggrementSearchPremiereAirDateToInput, RI_AggrementSearchDateTo, "Premiere Air Date To", RI_AggrementSearchPremiereAirDateFm);

		keyboard();

		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereAirDateFmInput, RI_AggrementSearchDataFrom1, "Premiere Air Date Fm", RI_AggrementSearchPremiereAirDateFm,"title");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereAirDateToInput, RI_AggrementSearchDateTo, "Premiere Air Date To", RI_AggrementSearchPremiereAirDateFm,"title");

		//Premiere Network
		//TC_RI_AS_184
		verifyDropDownValues(loc_RI_AggrementSearchPremiereNetworkDropdown, "Premiere Network Droupdown value verify", "RI_AggrementSearch", 585, 725);
		rightIN.agreementSearchPickList(loc_RI_AggrementSearchPremiereNetworkPicklist); 
	}
	
	@Test(priority =2,enabled= true,description = "Verify Agreement Search criteria")
	public void TC2_RI_Verify_Agreement_Search_Criteria() throws InterruptedException, Exception {
	
		
		switchIntoFrame(frameParent1Xpath);
		rightIN.navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(SearchXpath, "Search Icon", "Search");
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		Thread.sleep(2000);
//		verifyTextMatches(loc_RI_AggrementSearch, "Agreement Link", "Agreements");
		clickUsingJSExecutor(loc_RI_AggrementSearch,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);	
		
		//Search by Deal Type 
		selectDropdownValue(loc_RI_AggrementSearchDealTypeDropdown, "Select Deal type "+RI_AggrementSearchDealTypeData+"", RI_AggrementSearchDealTypeData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchDealTypeFromSearchResult, 3, RI_AggrementSearchDealTypeData, "title");
		
		//Clear Search
		clearSearchField();
		
		//Search by Contract Status
		selectDropdownValue(loc_RI_AggrementSearchContractStatusDropdown, "Select Contract Status"+RI_AgrementSearchContractStatusData+"", RI_AggrementSearchDealTypeData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchDealTypeFromSearchResult, 3, RI_AgrementSearchContractStatusData, "title");

		//Clear Search
		clearSearchField();
		
		//Search by Contract Entry Status
		selectDropdownValue(loc_RI_AggrementSearchContractEntryStatusDropdown, "Contract Entry Status Dropdown", RI_AggrementSearchContractEntryStatusData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchContractEntryStatusFromSearchresult, 1, RI_AggrementSearchContractEntryStatusData, "title");
		
		
		//Clear Search
		clearSearchField();
		
		//Search by Agreement Type
		selectDropdownValue(loc_RI_AggrementSearchAgreementTypeDropdown, " Agreement Type Dropdown", RI_AggrementSearchAgreementTypeData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchAgreementTypeFromSearchresult, 1, RI_AggrementSearchAgreementTypeData, "title");
		
		//Clear Search
		clearSearchField();
		
		//Search by Channel / Entity
		selectDropdownValue(loc_RI_AggrementSearchChannelEntityDroupdown, " Agreement Type Dropdown", RI_AggrementSearchChanneData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchChannelFromSearchresult, 1, RI_AggrementSearchChanneData, "title");
		
		//Clear Search
		clearSearchField();
				
		//RMS Contract Type
		selectDropdownValue(loc_RI_AggrementSearchChannelEntityDroupdown, " Agreement Type Dropdown", RI_AggrementSearchChanneData, "");
		verifyDataFromSearchresults(loc_RI_AggrementSearchChannelFromSearchresult, 1, RI_AggrementSearchChanneData, "title");
	}
	@Test(priority =3,enabled= true,description = "Verify search with modify deal details")
	public void TC3_RI_VerifySearchWithModifyDealDetails() throws InterruptedException, Exception {
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		
		//Update Deal Name and Deal Type 
		WaitForElementPresent(loc_RI_AggrementSearchDealNameInput);
		sendKeys(loc_RI_AggrementSearchDealNameInput, CreatedDeal1+"_Update", "update deal name ", "");
		selectDropdownValue(loc_ContractDataEntryStatus, "Update Contract Entry Status", RI_AggrementSearchUpdateContractEntryStatusData, "");
		///*Saving A Deal*/
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(3000);
		verifyFieldValueOfHeader(loc_CreatedAssetAtHome, CreatedDeal1, "CreatedDeal", ""); 
		
		//Search Update Deal
		rightIN.searchCreatedDeal(CreatedDeal1+"_Update");
		verifyFieldValueOfHeader(getAllSeletedOptions(loc_ContractDataEntryStatus, "Update Contract Entry Status"), RI_AggrementSearchUpdateContractEntryStatusData, "Verify Contract Entry Status ", ""); 
		
	}	
	@Test(priority =4,enabled= true,description = "Verify Search Results in Agreement search")
	public void TC4_RI_VerifySearchResultsInAgreementSearch() throws InterruptedException, Exception {
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
	
		//Search Deal
		switchIntoFrame(frameParent1Xpath);
		rightIN.navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(SearchXpath, "Search Icon", "Search");
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		Thread.sleep(2000);
		verifyTextMatches(loc_RI_AggrementSearch, "Agreement Link", "Agreements");
		clickUsingJSExecutor(loc_RI_AggrementSearch,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);	
		sendKeys(loc_RI_AggrementSearchDealNameInput, CreatedDeal1, "Deal Name Input", "");
		clickOn(Loc_SearchButton, "Search button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyDropDownValues(loc_RI_AggrementSearchReportTypeDropdown, "Report Type Droupdown value verify", "RI_AggrementSearch", 727	, 728);
		selectDropdownValue(loc_RI_AggrementSearchReportTypeDropdown, "Select Asset - Agrement", RI_AggrementSearchReportTypeData1, "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Header verify
		dealSearchHeaderVerify(loc_RI_AggrementSearchresultsheader, "title", 730);
		
		selectDropdownValue(loc_RI_AggrementSearchReportTypeDropdown, "Select Asset - Agrement", RI_AggrementSearchReportTypeData2, "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		dealSearchHeaderVerify(loc_RI_AggrementSearchresultsheader, "title", 749);
		clickUsingJSExecutor(loc_RI_AggrementSearchFieldChooser, "FieldChooser", "");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		verifyTextMatches(loc_RI_AggrementSearchMoveUpButton, "Move Up", "Move Up", "value");
		verifyTextMatches(loc_RI_AggrementSearchMoveDownButton, "Move Down", "Move Down", "value");
		verifyTextMatches(DeliveryScheduleSelectAll, "Select All", "Select All", "value");
		verifyTextMatches(DeliveryScheduleDeSelectAll, "Deselect All", "Deselect All", "value");
		verifyTextMatches(loc_RI_AggrementSearchAppliesButton, "Apply", "Apply", "value");
		verifyTextMatches(LocCancel, "Cancel", "Cancel", "value");
		clickUsingJSExecutor(DeliveryScheduleSelectAll, "Select All button", "");
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		Thread.sleep(3000);
		clickUsingJSExecutor(DeliveryScheduleDeSelectAll, "Deselect All button", "");
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		Thread.sleep(3000);
		clickUsingJSExecutor(LocCancel, "Cancel button", "");
		switchIntoFrame(frameParent2Xpath);	
		
		//Exact Match
		clickOn(loc_RI_AggrementSearchExactMatchCheckBox, "Exact Match Check box", RI_AggrementSearchExactMatch);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExactMatchCheckBox, "true", "Verify check box checked", RI_AggrementSearchExactMatch, "checked");
		clickOn(loc_RI_AggrementSearchExactMatchCheckBox, "Exact Match Check box", RI_AggrementSearchExactMatch);
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExactMatchCheckBox, "null", "Verify check box unchecked", RI_AggrementSearchExactMatch, "unchecked");

		//Save Search
		clickUsingJSExecutor(loc_RI_AggrementSearchSaveSearchButton, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_Save);
		
		verifyFieldValueOfHeader(loc_RI_AggrementSearchScope, RI_AggrementSearchScope, "Scope", RI_AggrementSearchScope);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchScope1, RI_AggrementSearchScope1, "Scope1", RI_AggrementSearchScope1);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchScope2, RI_AggrementSearchScope2, "Scope2", RI_AggrementSearchScope2);
		
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptions, RI_AggrementSearchOptions, "Options", RI_AggrementSearchOptions);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptions1, RI_AggrementSearchOptions1, "Options1", RI_AggrementSearchOptions1);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptions2, RI_AggrementSearchOptions2, "Options2", RI_AggrementSearchOptions2);
		
		verifyFieldValueOfHeader(loc_Save, "Save", "Save Button", "");
		verifyFieldValueOfHeader(LocCancel, "Cancel", "Cancel Button", "");
		
		//Defult
		verifyFieldValueOfHeader(loc_RI_AggrementSearchScopeCheckBox1, "true", "Verify check box checked", RI_AggrementSearchScope1, "checked");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptionsCheckBox2, "true", "Verify check box checked", RI_AggrementSearchOptions2, "checked");
		
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_RI_AggrementSearchSaveAsANewsearchInput, RI_AggrementSearchSavesData+formattedDate, "Enter data in Save as a new search Field", "");
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		verifyTextMatches(AlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent2Xpath);
		
		//Again Save same name 
		clickUsingJSExecutor(loc_RI_AggrementSearchSaveSearchButton, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_Save);
		sendKeys(loc_RI_AggrementSearchSaveAsANewsearchInput, RI_AggrementSearchSavesData+formattedDate, "Enter data in Save as a new search Field", "");
		clickUsingJSExecutor(loc_Save, "Save button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg2);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		
		//Save With different name 
		clickUsingJSExecutor(loc_RI_AggrementSearchSaveSearchButton, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_Save);
		sendKeys(loc_RI_AggrementSearchSaveAsANewsearchInput, RI_AggrementSearchSavesData1+formattedDate, "Enter data in Save as a new search Field", "");
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		verifyTextMatches(AlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent2Xpath);
		
		//clear
		//TC_RI_AS_085
		clickUsingJSExecutor(Loc_ClearSearch, "clear button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Restore Local search
		clickUsingJSExecutor(loc_RI_AggrementSearchRestoreSearch, "Restore Search button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchMySearchesLocal, RI_AggrementSearchMySearchesLocal, "Restore Search window field verify", "");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchGlobalSearches, RI_AggrementSearchGlobalSearches, "Restore Search window field verify", "");
		
		verifyTextMatches(loc_RI_AggrementSearchrestoreButton, "Restore Button", "Restore", "value");
		verifyTextMatches(loc_Delete, "Delete Button", "Delete", "value");
		verifyTextMatches(LocCancel, "Cancel Button", "Cancel", "value");
		
		sendKeys(loc_RI_AggrementSearchinputField, RI_AggrementSearchSavesData+formattedDate, "inout datain search field", "");
		clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(Loc_Generaltext.replace("var", RI_AggrementSearchSavesData+formattedDate), "select from seach result", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_RI_AggrementSearchrestoreButton, "restore Button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyFieldValueOfHeader(Loc_DealName, CreatedDeal1, "verify data after restore", "");
		
		//Clear
		clickUsingJSExecutor(Loc_ClearSearch, "clear button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Again Search with Invalid data 
		clickUsingJSExecutor(loc_RI_AggrementSearchRestoreSearch, "Restore Search button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		sendKeys(loc_RI_AggrementSearchinputField, RI_AggrementSearchSavesData2+formattedDate, "inout datain search field", "");
		clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
		WaitForModalPanel();
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg",RI_AggrementSearchRestoreSearchInvalidData );
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		
		//Clear
		clickUsingJSExecutor(Loc_ClearSearch, "clear button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Search with different Valid Data
		clickUsingJSExecutor(loc_RI_AggrementSearchRestoreSearch, "Restore Search button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		sendKeys(loc_RI_AggrementSearchinputField, RI_AggrementSearchSavesData1+formattedDate, "inout datain search field", "");
		clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		doubleClick(Loc_Generaltext.replace("var", RI_AggrementSearchSavesData1+formattedDate), "select from seach result", "");
		Thread.sleep(2000);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyFieldValueOfHeader(Loc_DealName, CreatedDeal1, "verify data after restore", "");
        	
		//Clear
		clickUsingJSExecutor(Loc_ClearSearch, "clear button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		
		//Search without seleting row from search result 
		clickUsingJSExecutor(loc_RI_AggrementSearchRestoreSearch, "Restore Search button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_RI_AggrementSearchrestoreButton, "restore Button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg",RI_AggrementSearchRestoreSearchInvalidData );
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_RI_AggrementSearchinputField, RI_AggrementSearchSavesData1+formattedDate, "Input data in search field", "");
		clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_AggrementSearchrestoreButton, "restore Button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg",RI_AggrementSearchRestoreSearchInvalidData );
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(LocCancel, "cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_RI_AggrementSearchRestoreSearch, "Restore Search button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocCancel);
		Thread.sleep(2000);
		
		//Delete without seleting row 
		clickUsingJSExecutor(loc_Delete, "Delete button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg",RI_AggrementSearchDeleteWithoutSeletingRow );
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_RI_AggrementSearchinputField, RI_AggrementSearchSavesData+formattedDate, "Input data in search field", "");
		clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_Generaltext.replace("var", RI_AggrementSearchSavesData+formattedDate), "select from seach result", "");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Delete, "Delete button", "");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, " Conf Alert Msg", RI_AggrementSearchDeleteConfMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg",RI_AggrementSearchDeleteConfAlert );
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Alert");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(LocCancel, "cancel Button", "");
		switchIntoFrame(frameParent2Xpath);
	}
	
    @Test(priority =5,enabled= true,description = "Verify Return to last search")
	public void TC5_RI_VerifyReturnTolastSearch() throws InterruptedException, Exception {
	
	
	assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle2,Series_AssetType);
	assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle2);
	rightIN.createDeal(CreatedDeal2);
	rightIN.associateAssetWithDeal(CreatedDeal2, CreatedSeriesAssetTitle2);
	
	//Return to Last Search
	
	switchIntoFrame(frameParent1Xpath);
	rightIN.navigateToRightsIN();
	switchIntoFrame(frameParent2Xpath);
	verifyTextMatches(SearchXpath, "Search Icon", "Search");
	clickUsingJSExecutor(SearchXpath,"Search Icon");
	Thread.sleep(2000);
	clickUsingJSExecutor(loc_RI_ReturnTolastSearch,"Return To last Search");
	WaitForModalPanel();
	switchIntoFrame(frameParent2Xpath);
	
	verifyFieldValueOfHeader(Loc_DealName, CreatedDeal1, "Return to last Search verify last Deal", "","value");
	
}
    @Test(priority =6,enabled= true,description = "Last search should not be cleared when a user again logs into Rights Logic.")
   	public void TC6_RI_VerifyReturnTolastSearchUserAgainLogs() throws InterruptedException, Exception {
    	
    	switchIntoFrame(frameParent1Xpath);
    	rightIN.navigateToRightsIN();
    	switchIntoFrame(frameParent2Xpath);
    	verifyTextMatches(SearchXpath, "Search Icon", "Search");
    	clickUsingJSExecutor(SearchXpath,"Search Icon");
    	Thread.sleep(2000);
    	clickUsingJSExecutor(loc_RI_ReturnTolastSearch,"Return To last Search");
    	WaitForModalPanel();
    	switchIntoFrame(frameParent2Xpath);
    	
    	verifyFieldValueOfHeader(Loc_DealName, CreatedDeal1, "Return to last Search verify last Deal", "","value");
    }
    public void functionalityOfPopUpWindow(String Locater ,String HeaderName) throws Exception {
    	clickOn(Locater, "Pick list", "");
		switchIntoFrame(frameParent3Xpath, HeaderName);
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll, 		RI_MediaRights_EditMode_ExpandAll_Button, 	"RI_MediaRights_EditMode_ExpandAll_Button",		RI_MediaRights_EditMode_ExpandAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll, 	RI_MediaRights_EditMode_CollapseAll_Button, "RI_MediaRights_EditMode_CollapseAll_Button",	RI_MediaRights_EditMode_CollapseAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 		RI_MediaRights_EditMode_SelectAll_Button, 	"RI_MediaRights_EditMode_SelectAll_Button",		RI_MediaRights_EditMode_SelectAll_Button, 	"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, 	RI_MediaRights_EditMode_DeSelectAll_Button, "RI_MediaRights_EditMode_DeSelectAll_Button",	RI_MediaRights_EditMode_DeSelectAll_Button, "value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 			RI_MediaRights_EditMode_Apply_Button, 		"RI_MediaRights_EditMode_Apply_Button",			RI_MediaRights_EditMode_Apply_Button, 		"value");
		verifyFieldValueOfHeader(loc_RI_MediaRights_EditMode_TemplateWindow_Cancel, 		RI_MediaRights_EditMode_Cancel_Button, 		"RI_MediaRights_EditMode_Cancel_Button",		RI_MediaRights_EditMode_Cancel_Button, 		"value");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon, "Collapsed Icons", RI_MediaRights_EditMode_Search_Button);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon, "Expand Icon");

		

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
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, "'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",HeaderName);
		Thread.sleep(3000);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), "Unchecked Nodes of Assets at "+ HeaderName + " ");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), 	"Checked Nodes of Assets at "+ HeaderName + "");


		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll, "'DeSelect All' RI_MediaRights_EditMode_"+ HeaderName + "",HeaderName);
		Thread.sleep(3000);
		verifyElementNotPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "on"), "Checked Nodes of Assets at "+ HeaderName + "");
		verifyElementPresent(loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes.replace("@var", "off"), 	"Unchecked Nodes of Assets at "+ HeaderName + "");

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, "Appply button");
		ExecutionLog.Log("**********Validation message on clikcing apply button without select any check box**********");
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_MediaRights_EditMode_MediaType_SelectAtLeastOneElement, "Alert Message RI_MediaRights_EditMode_"+ HeaderName + "", HeaderName);
		clickUsingJSExecutor(OKAlertButtonXpath, 				"OK Button at Alert", HeaderName);
		switchIntoFrame(frameParent3Xpath, 	HeaderName);
        Thread.sleep(2000);
        clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll, 	"'Select All' RI_MediaRights_EditMode_"+ HeaderName + " ",HeaderName);
		Thread.sleep(1000);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_TemplateWindow_Apply, 		"Appply button");
		switchIntoFrame(frameParent2Xpath, 	HeaderName);

	}
    public void clearSearchField() throws Exception{
    	clickUsingJSExecutor(Loc_ClearSearch,"Clear Search Button");
    	WaitForModalPanel();
    	switchIntoFrame(frameParent2Xpath);
    }
    public void verifyDataFromSearchresults(String locater,int Num,String ExpetedTestData,String Attributes) throws Exception{
    	Thread.sleep(2000);
    	clickUsingJSExecutor(Loc_SearchButton,"Search Button");
    	WaitForModalPanel();
    	switchIntoFrame(frameParent2Xpath);
    	clickOn(Loc_RI_agreementSearchPageSizeImg,"Page Size");
    	Thread.sleep(1000);
    	clickOn(Loc_RI_agreementSearchPageSizeSelectAll,"Page Size Select All");
    	Enter();
    	switchIntoFrame(frameParent2Xpath);
    	WaitForModalPanel(Loc_RI_agreementSearchprocessingImg);
    	switchIntoFrame(frameParent2Xpath);
    	List<WebElement> elemList2 = driver.findElements(ByLocator(locater));
    
    	/*System.out.println("---------------------START-----------------------------"); //Test
    	System.out.println(elemList2.size());
    	for(WebElement elem : elemList2) {
    		System.out.println(elem.getAttribute("title"));
    		
    	}
    	System.out.println("----------------------END----------------------------");*/
    	System.out.println("---------------------START-----------------------------");
    	for(int i = Num; i<=elemList2.size()-1; i++) {
    		verifyFieldValueOfHeader(elemList2.get(i), ExpetedTestData, "verify "+ExpetedTestData+" form search result", "", Attributes);
    	}
    	System.out.println("---------------------End-----------------------------");
    }	
    public void dealSearchHeaderVerify(String locater,String Attributes,int StartRowNum) throws Exception{

    	String ExpetedTestData = "";
    	List<WebElement> elemList = driver.findElements(ByLocator(locater));
    	//for(int i = 0; i<=elemList.size(); i++) {  
    	for(int i = 0; i<=elemList.size()-1; i++) {  
    		ExpetedTestData = Current_xls.getCellData("RI_AggrementSearch", ClientData, i+StartRowNum);
    		verifyFieldValueOfHeader(elemList.get(i), ExpetedTestData ,"verify Header form search result", "", Attributes);

    	}

    }



}
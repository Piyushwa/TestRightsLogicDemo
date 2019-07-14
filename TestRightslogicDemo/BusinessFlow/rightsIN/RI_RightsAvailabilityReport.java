package rightsIN;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_RightsAvailabilityReport extends DriverHelper implements I_RI_RightsAvailabilityReport{
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	RI_MediaRights mediaRights = new RI_MediaRights();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);


	String CreatedSeriesAssetTitleTC1 	= "AUT_AssetSeries_TC1_" +formattedDate+"";

	String CreatedDealTC1 		= "AUT_Deal_TC1_" +formattedDate+"";
	String CreatedDealTC2 		= "AUT_Deal_TC2_" +formattedDate+"";
	

	public RI_RightsAvailabilityReport() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}

	public void a() throws Exception {}
	
	
	/*@Test
public void FieldVerification() throws Exception{


			switchIntoFrame(frameParent1Xpath);
			clickOn(ModulesXpath, "Module ");
			Thread.sleep(6000);
			clickOn(RightsInXpath, "Rights IN TAB ");
			Thread.sleep(6000);
			switchIntoFrame(frameParent2Xpath);
			// click on Report
			clickOn(ReportsMenuBar, "Reports Menu");
			Thread.sleep(6000);
			// click on RAR
			clickOn(loc_RI_RAR_Reports, "Rights Availability");
			
			switchIntoFrame(frameParent2Xpath);
			
			verifyFieldValueOfHeader(loc_RI_AggrementSearchPropertyTitle,  RI_RAR_PropertyTitle, "Property Title",  RI_RAR_PropertyTitle);
			verifyFieldValueOfHeader(loc_RI_RAR_AssetType, RI_RAR_PropertyType, "Property Type",  RI_RAR_PropertyType);
			verifyFieldValueOfHeader(loc_RI_AggrementSearchEpisode  , RI_RAR_NoofEpisode, "Episode #s",  RI_RAR_NoofEpisode);
			verifyFieldValueOfHeader(loc_RI_RAR_PropertyID,  RI_RAR_PropertyIDs, "Property IDs",  RI_RAR_PropertyIDs);
			verifyFieldValueOfHeader(loc_RI_RAR_RightsVersionType,  RI_RAR_RightsVersiontype, "Rights Version type",  RI_RAR_RightsVersiontype);
			verifyFieldValueOfHeader(loc_RI_RAR_SBU ,  RI_RAR_SourceBusinessUnit, "Source Business Unit",  RI_RAR_SourceBusinessUnit);
			verifyFieldValueOfHeader(loc_RI_RAR_PropertySource, RI_RAR_PropertySource, "Property Source",  RI_RAR_PropertySource);
			verifyFieldValueOfHeader(loc_RI_RAR_IntendedPlatform, RI_RAR_IntendedPlatform, "Intended Platform",  RI_RAR_IntendedPlatform);
			verifyFieldValueOfHeader(loc_RI_RAR_UniversalID, RI_RAR_UniversalID, "_Universal ID",  RI_RAR_UniversalID);
			verifyFieldValueOfHeader(loc_RI_RAR_MediaType, RI_RAR_MediaType, "Media Type",  RI_RAR_MediaType);
			verifyFieldValueOfHeader(loc_RI_RAR_Venue , RI_RAR_Venue, "Venue",  RI_RAR_Venue);
			verifyFieldValueOfHeader(loc_RI_RAR_UsageRights, RI_RAR_EnduserRights, "Usage Rights",  RI_RAR_EnduserRights);
			verifyFieldValueOfHeader(loc_RI_RAR_Outlets, RI_RAR_Outlets, "Outlet",  RI_RAR_Outlets);
			verifyFieldValueOfHeader(loc_RI_RAR_Territory, RI_RAR_Territory, "Territory",  RI_RAR_Territory);
			verifyFieldValueOfHeader(loc_RI_RAR_LicenseTerms, RI_RAR_TermFrom, "Term From",  RI_RAR_TermFrom);
			verifyFieldValueOfHeader(loc_RI_RAR_Language, RI_RAR_Language, "Language",  RI_RAR_Language);
			
			//Buttons
			verifyFieldValueOfHeader(loc_RI_RAR_Searchbutton , RI_RAR_Searchbutton , "Search Button",   RI_RAR_Searchbutton, "value");
			verifyFieldValueOfHeader(Loc_ClearSearch, RI_RAR_Clearsearchbutton , "Clear Search Button",  RI_RAR_Clearsearchbutton, "value");
			verifyFieldValueOfHeader(loc_RI_AggrementSearchSaveSearchButton, RI_RAR_SaveSearch  , "Save Search Button",   RI_RAR_SaveSearch, "value" );
			verifyFieldValueOfHeader(loc_RI_AggrementSearchRestoreSearch   , RI_RAR_Restoresearch , " Restore Search Button",   RI_RAR_Restoresearch, "value");
			verifyFieldValueOfHeader(loc_RI_AggrementSearchExactMatch , RI_RAR_Exactmatchchecbox , " Exact Match Checkbox ",   RI_RAR_Exactmatchchecbox);
			
			//Advance Search
			clickUsingJSExecutor(loc_RI_AggrementSearchExpandAdvanceSearch,"Expand Advance Search");
			Thread.sleep(3000);
			verifyFieldValueOfHeader(loc_RI_RAR_PremiereAirDate  , RI_RAR_PremiereAirDateFrom , "Premiere Air Date From",  RI_RAR_PremiereAirDateFrom);
			verifyFieldValueOfHeader(loc_RI_RAR_PremierePlatform, RI_RAR_PremierePlatform, "Premiere Platform",  RI_RAR_PremierePlatform);
			verifyFieldValueOfHeader(loc_RI_RAR_NoOfEpisodes, RI_RAR_ofEpisodesFrom, "# of Episodes From",  RI_RAR_ofEpisodesFrom);
			verifyFieldValueOfHeader(loc_RI_RAR_Vendor,  RI_RAR_Vendor, "Vendor",   RI_RAR_Vendor);
			verifyFieldValueOfHeader(loc_RI_RAR_PropertyFormat, RI_RAR_PropertyFormat, "Property Format",  RI_RAR_PropertyFormat);
			verifyFieldValueOfHeader(loc_RI_RAR_CountryOrigin, RI_RAR_Countryoforigin, "Country of origin",  RI_RAR_Countryoforigin);
			verifyFieldValueOfHeader(loc_RI_RAR_Exclusivity, RI_RAR_Exclusivity, "Exclusivity", RI_RAR_Exclusivity);
			verifyFieldValueOfHeader(loc_RI_RAR_ContractParty, RI_RAR_ContractParty, "Contract Party",  RI_RAR_ContractParty);
			verifyFieldValueOfHeader(loc_RI_AggrementSearchContractName, RI_RAR_ContractName, "Contract Name",  RI_RAR_ContractName);
			verifyFieldValueOfHeader(loc_RI_RAR_lblContractDate, RI_RAR_ContractDateFrom, "Contract Date From",  RI_RAR_ContractDateFrom);
			verifyFieldValueOfHeader(loc_RI_RAR_LastUpdatedDate, RI_RAR_DateLastupdatedFrom, "Date Last updated ",  RI_RAR_DateLastupdatedFrom);
			verifyFieldValueOfHeader(loc_RI_RAR_IntlOptinDecision,  RI_RAR_IntlOptInDecision, "Int'l Opt In Decision ",   RI_RAR_IntlOptInDecision);
			verifyFieldValueOfHeader(loc_RI_RAR_ContarctID, RI_RAR_ContarctID, "Contarct ID",  RI_RAR_ContarctID);
			verifyFieldValueOfHeader(loc_RI_RAR_Genre , RI_RAR_Genre, "Genre",  RI_RAR_Genre);
		
			
			//Verify Dropdown values
			
			verifyDropDownValues(loc_RI_RAR_RollupTypeDropdown, "Roll up Droupdown value verify", "RI_RightsAvailabilityReport", 212, 214);
			verifyDropDownValues(loc_RI_RAR_ReportTypeTypeDropdown, " Reports Type Droupdown value verify", "RI_RightsAvailabilityReport", 218, 219);
			
			
			//Must Have All 1
			
			clickOn(loc_RI_RAR_MustHaveAllMediaCheckbox1, "Must Have All 1 Check box", RI_RAR_MediaType);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllMediaCheckbox1, "true", "Verify check box checked", RI_RAR_MediaType, "checked");
			clickOn(loc_RI_RAR_MustHaveAllMediaCheckbox1, "Must Have All 1 Check box", RI_RAR_MediaType);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllMediaCheckbox1, "null", "Verify check box unchecked", RI_RAR_MediaType, "unchecked");
			
			//Must Have All 2
			
			clickOn(loc_RI_RAR_MustHaveAllTerritoryCheckbox2, "Must Have All 2 Check box", loc_RI_RAR_Territory);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllTerritoryCheckbox2, "true", "Verify check box checked", loc_RI_RAR_Territory, "checked");
			clickOn(loc_RI_RAR_MustHaveAllTerritoryCheckbox2, "Must Have All 2 Check box", loc_RI_RAR_Territory);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllTerritoryCheckbox2, "null", "Verify check box unchecked", loc_RI_RAR_Territory, "unchecked");
			
                       //Must Have All 3
			
			clickOn(loc_RI_RAR_MustHaveAllUsageRightCheckbox3, "Must Have All 3 Check box", loc_RI_RAR_UsageRights);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllUsageRightCheckbox3, "true", "Verify check box checked", loc_RI_RAR_UsageRights, "checked");
			clickOn(loc_RI_RAR_MustHaveAllUsageRightCheckbox3, "Must Have All 3 Check box", loc_RI_RAR_UsageRights);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllUsageRightCheckbox3, "null", "Verify check box unchecked", loc_RI_RAR_UsageRights, "unchecked");
			
			//Must Have All 4
			
			clickOn(loc_RI_RAR_MustHaveAllTermsCheckbox4, "Must Have All 4 Check box", loc_RI_RAR_LicenseTerms);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllTermsCheckbox4, "true", "Verify check box checked", loc_RI_RAR_LicenseTerms, "checked");
			clickOn(loc_RI_RAR_MustHaveAllTermsCheckbox4, "Must Have All 4 Check box", loc_RI_RAR_LicenseTerms);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllTermsCheckbox4, "null", "Verify check box unchecked", loc_RI_RAR_LicenseTerms, "unchecked");

			//Must Have All 5
			
			clickOn(loc_RI_RAR_MustHaveAllLanguageChecekbox5, "Must Have All 5 Check box", loc_RI_RAR_Language);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllLanguageChecekbox5, "true", "Verify check box checked", loc_RI_RAR_Language, "checked");
			clickOn(loc_RI_RAR_MustHaveAllLanguageChecekbox5, "Must Have All 5 Check box", loc_RI_RAR_Language);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllLanguageChecekbox5, "null", "Verify check box unchecked", loc_RI_RAR_Language, "unchecked");

			//Must Have All 6
			
			clickOn(loc_RI_RAR_MustHaveAllOutletsChecekbox6, "Must Have All 6 Check box", loc_RI_RAR_Outlets);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllOutletsChecekbox6, "true", "Verify check box checked", loc_RI_RAR_Outlets, "checked");
			clickOn(loc_RI_RAR_MustHaveAllOutletsChecekbox6, "Must Have All 6 Check box", loc_RI_RAR_Outlets);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_RAR_MustHaveAllOutletsChecekbox6, "null", "Verify check box unchecked", loc_RI_RAR_Outlets, "unchecked");
			
			//Perpetuity
		
			clickOn(loc_RI_AggrementSearchPerpetuityCheckbox, "Perpetuity Check box", RI_AggrementSearchFutureProperty);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_AggrementSearchPerpetuityCheckbox, "true", "Verify check box checked", RI_AggrementSearchFutureProperty, "checked");
			clickOn(loc_RI_AggrementSearchPerpetuityCheckbox, "Perpetuity Check box", RI_AggrementSearchFutureProperty);
			Thread.sleep(1000);
			verifyFieldValueOfHeader(loc_RI_AggrementSearchPerpetuityCheckbox, "null", "Verify check box unchecked", RI_AggrementSearchFutureProperty, "unchecked");
	}
	*/
			/*@Test(priority =2,enabled= true,description = "Verify Search Results in RAR search")
			public void TC2_RI_VerifySearchResultsInRightsAvailability() throws InterruptedException, Exception {
				
				/*assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC1 ,Series_AssetType);
				assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC1 );
				rightsIN.createDeal(CreatedDealTC1);
				rightsIN.associateAssetWithDeal(CreatedDealTC1, CreatedSeriesAssetTitleTC1); 
		
				
				switchIntoFrame(frameParent1Xpath);
				clickOn(ModulesXpath, "Module ");
				Thread.sleep(6000);
				clickOn(RightsInXpath, "Rights IN TAB ");
				Thread.sleep(6000);
				switchIntoFrame(frameParent2Xpath);
				// click on Report
				clickOn(ReportsMenuBar, "Reports Menu");
				Thread.sleep(6000);
				// click on RAR
				clickOn(loc_RI_RAR_Reports, "Rights Availability");
				sendKeys( loc_RI_RARPropertyNameInput, "T.u.f.f Puppy", "Deal Name Input", "");
				selectDropdownValue(loc_RI_RAR_SBUDroupdown , "Select Asset - Agrement", "Nickelodeon", "");
				Thread.sleep(6000);
				clickOn(loc_RI_RAR_Searchbutton, "Search button", "");
				Thread.sleep(6000);
				//Verify Search Results Column header
				
				dealSearchHeaderVerify(loc_RI_AggrementSearchresultsheader, "title",243);
				
				//Check Field Chooser
				/*clickUsingJSExecutor(loc_RI_AggrementSearchFieldChooser, "FieldChooser", "");
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
				Thread.sleep(6000);
				clickUsingJSExecutor(LocCancel, "Cancel button", "");
				switchIntoFrame(frameParent2Xpath);	
				
				//Save Search 
				clickUsingJSExecutor(loc_RI_AggrementSearchSaveSearchButton, "Save button", "");
				switchIntoFrame(frameParent2Xpath);
				WaitForElementPresent(loc_Save);
				clickUsingJSExecutor(loc_Save, "Save button", "");
				driver.switchTo().window(driver.getWindowHandle()); 
				verifyTextMatches(AlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Confirm");
				switchIntoFrame(frameParent3Xpath);
				sendKeys(loc_RI_AggrementSearchSaveAsANewsearchInput, "RAR New Search", "Enter data in Save as a new search Field", "");
				clickUsingJSExecutor(loc_Save, "Save button", "");
				WaitForModalPanel();
				verifyTextMatches(AlertValidationMessgeText, "Confirm Alert Msg", RI_AggrementSearchSaveAlertMsg1);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button At Confirm");
				switchIntoFrame(frameParent2Xpath);
				
				//clear Search
				
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
				
				sendKeys(loc_RI_AggrementSearchinputField, "RAR New Search", "inout datain search field", "");
				clickUsingJSExecutor(loc_RI_AggrementSearchButton, "Search button", "");
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				doubleClick(loc_RI_RAR_RestoreSearchinput, "select from seach result", "");
				Thread.sleep(2000);
		
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath); 
				
			} */



			@Test(priority =3,enabled= true,description = "Verify Search Results in All Rollups search")
			public void TC3_RI_SearchwithdifferentcriteriaInRightsAvailability() throws InterruptedException, Exception {
				//TC1
				
				/*assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC1,Series_AssetType);
				assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC1,1,4);
			rightsIN.createDeal(CreatedDealTC1);
				rightsIN.searchCreatedDeal(CreatedDealTC1);
				rightsIN.associateAssetWithDeal(CreatedDealTC1,CreatedSeriesAssetTitleTC1);
				rightsIN.selectDeal(CreatedDealTC1);
				switchIntoFrame(frameParent2Xpath);
				clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
				clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
				sleepTime(3);
				switchIntoFrame(frameParent3Xpath);
				clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				// Enter the data for Row1
				mediaRights.enterDatainAllFields("1", CreatedSeriesAssetTitleTC1 );

				switchIntoFrame(frameParent3Xpath);
				clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				switchIntoFrame(frameParent1Xpath); 
				
				switchIntoFrame(frameParent2Xpath);
				// click on Report
				clickOn(ReportsMenuBar, "Reports Menu");
				Thread.sleep(6000);
				// click on RAR
				clickOn(loc_RI_RAR_Reports, "Rights Availability");
				sendKeys( loc_RI_RARPropertyNameInput, CreatedSeriesAssetTitleTC1, "Deal Name Input", "");
					
				selectDropdownValue(loc_RI_RAR_SBUDroupdown , "Select Asset - Agrement", "All VMN Outlets", "");
				Thread.sleep(6000);
				/*clickOn(loc_RI_RAR_MediaLookUpIcon, "Media LookUp Icon");
				switchIntoFrame(frameParent3Xpath);
				clickUsingJSExecutor(Loc_DeselectAll, "Deslect All");
		
				clickUsingJSExecutor(Loc_ApplyButton, "Apply");*/
				sendKeys(loc_RI_RAR_LicenseDatesFmInput , "01/01/2014", "Date From", "");
				sendKeys(loc_RI_RAR_LicenseDatesToInput, "01/01/2016", "Date To", "");
				switchIntoFrame(frameParent2Xpath);
				Thread.sleep(6000);
				clickOn(loc_RI_RAR_Searchbutton  , "Search button", "");
				Thread.sleep(6000);
				selectDropdownValue(loc_RI_RAR_RollupTypeDropdown , "Select Roll Up", "Series", "");	
			
				Thread.sleep(3000);
				clickOn(Loc_SearchButton , "Search button", "");
				selectDropdownValue(loc_RI_RAR_RollupTypeDropdown , "Select Roll Up", "Episode", "");	
				Thread.sleep(3000);
				clickOn(Loc_SearchButton , "Search button", "");
			}
			public void dealSearchHeaderVerify(String locater,String Attributes,int StartRowNum) throws Exception{

		    	String ExpetedTestData = "";
		    	List<WebElement> elemList = driver.findElements(ByLocator(locater));
		    	//for(int i = 0; i<=elemList.size(); i++) {  
		    	for(int i = 0; i<=elemList.size()-1; i++) {  
		    		ExpetedTestData = Current_xls.getCellData("RI_RightsAvailabilityReport", ClientData, i+StartRowNum);
		    		verifyFieldValueOfHeader(elemList.get(i), ExpetedTestData ,"verify Header form search result", "", Attributes);
		    	}
}
}

package assetMaintenance;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class AM_General extends DriverHelper implements IAM_General {

	public AM_General() {
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}

	Date date ;
	SimpleDateFormat sdf;
	String formattedDate;
	String CreatedSeriesAssetTitle = "AUT_AssetSeries_";
	String CreatedMovieAssetTitle =  "AUT_AssetMovie_";
	String CreatedEleAssetTitle = "AUT_AssetEle_";
	String CreatedDeal = "AUT_Deal_";

	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();


	@Test(priority =1,enabled =true,description = "Asset creation,") 
	public void TC1_AssetCreationTest() throws Exception {
		/*Navigate to Asset Maintenance title on left frame*/
		date = new Date();
		sdf = new SimpleDateFormat("MMddyyyyhmmss");   
		formattedDate  = sdf.format(date); 
		CreatedSeriesAssetTitle = CreatedSeriesAssetTitle+formattedDate+"";

		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		// VMN: search for the Asset
		// Other Clients: Go to General tab for all "Asset Maintenance >> New >> Program"
		assetMaintenance.navigateToGeneralTab(AssetType_Element,	CreatedSeriesAssetTitle);

		//Validation drop down values of  Asset type "Element"
		verifyDropDownValues(loc_AssetTypeDropDown, "'Element' Asset Type Drop Down", "Assets", 87, 105);

		// Creation of New Asset
		assetMaintenance.navigateToGeneralTab(AssetType_Program, CreatedSeriesAssetTitle);

		// Verify All Labels Present for General Tab
		assetMaintenance.verifyLabel();

		//Validation drop down values of  Asset type "Program"
		verifyDropDownValues(loc_AssetTypeDropDown, "'Program' Asset Type Drop Down", "Assets", 3, 25);
		//Print the Generated "Asset Id" in the Report 
		ExecutionLog.Log("Generated Asset Id is " + getText(loc_AssetIDVal));

		// click On Save Button
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		sleepTime(3);

		//Validation on mandatory message 
		verifyTextMatches(loc_AssertCreationValidationMessage, "AssertCreationValidationMessage", "Please enter values for required(*) fields.");

		//Field - Entry AssetType 
		selectDropdownValue(loc_AssetTypeDropDown, "Asset Type Drop Down", Series_AssetType, AssetType_Status);
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent2Xpath);
		//Enter value in Asset Title Field
		sendKeys(loc_AssetTitleField, CreatedSeriesAssetTitle, "AssetTitle", AssetTitle_Status);

		switchIntoFrame(frameParent2Xpath);

		assetMaintenance.searchAndSelectIP();
		//Field - IP Name
		selectAndReEnterIP();

		// Verify that Vendor field is not-editable
		//TC_AM_GT_038
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_AM_GT_038");
		verifyFieldValueOfHeader(loc_Vendorfield, "true", "Vendor field is noteditable",Vendor1_Status ,"readonly");

		// Field - Vendor
		assetMaintenance.searchAndSelectVendor();
		if (!Vendor1_Status.contains("N/A")) {
			clickOn(loc_ClearVendor, "Clear Vendor");
			driver.switchTo().window(driver.getWindowHandle());
			String AlertMessage = "Are you sure you want to clear the field value?";
			verifyTextMatches(ConfirmAlertValidationMessgeText, "Alert Message while clearing the Vendor", AlertMessage);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up");
		}

		// select the vendor again
		assetMaintenance.searchAndSelectVendor();
		// TODO Is there any client who does not has studio
		//Field - Studio
		// Search and Select Studio/Vendor2 name
		switchIntoFrame(frameParent2Xpath);
		searchAndSelectStudio_Vendor2();

		//Field - Source Business Unit
		switchIntoFrame(frameParent2Xpath);

		// Search and Select SBU
		//TC_AM_GT_046
		SelectSBUValue_Select_DeSelectSBU();

		// Field - Duration
		//TC_AM_GT_058
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_AM_GT_058");
		switchIntoFrame(frameParent2Xpath);
		sendKeys(loc_DurationField, "003000", "Duration", DurationField_Status);

		//Field - Asset Status
		selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus,AssetStatus_Status);

		// Field - Asset Source
		selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource,AssetFormat_Status);

		// Field - Title Type / Asset source-UCI
		selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
		switchIntoFrame(frameParent2Xpath);


		clickUsingJSExecutor(loc_CheckInternalCheckBox, "Check InternalCheckBox", InternalCheckBox_Status);

		// Field - Delivery date
		sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

		//Asset Group
		selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

		//Season - Commented not required for this 4 clients
		selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, Season_Status);

		//Look up code
		sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

		//Project Id
		sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

		//Asset Hierarchy
		selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

		//MML Client Group
		selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

		//PROD Contract Entry Status
		selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

		//TC_AM_GT_067
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_AM_GT_067");
		//Adding Genre
		// Add Genre and Genre Type
		assetMaintenance.AddGenreAndGenreType();
		//Delete Genre
		clickUsingJSExecutor(loc_SelectGenreCompleteRow, "Genre Complete Row", Genre_DeleteButton);
		clickUsingJSExecutor(loc_DeleteGenre, "Delete Genre Icon", Genre_DeleteButton);
		driver.switchTo().window(driver.getWindowHandle());

		//Alert Message 
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, Genre_DeleteValidationMessage, "Alert Message on clicking 'Delete Button' Genre", Genre_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up");
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath); 

		// Re-Add Genre and Genre Type
		clickUsingJSExecutor(loc_GenreAddbutton, "Genre Add Button", Genre_AddButton);
		WaitForElementToClickable(loc_GenreTypeRow2, Genre_AddButton);
		clickUsingJSExecutor(loc_GenreTypeRow2, "Genre Type Row2 Field", Genre_AddButton);
		clickOn(loc_GenreTypeRowImageDropdown, "Genere Type Dropdown Image", Genre_AddButton);
		clickOn(loc_FirstGenreTypeDropDownValue, "First Genere Type DropDown Value in the list", Genre_AddButton);

		clickUsingJSExecutor(loc_GenreRow2, "Genre Row Field",Genre_AddButton);
		clickOn(loc_Genre, "Genere Dropdown Image", Genre_AddButton);
		clickOn(loc_FirstGenreDropDownValue, "Genere Dropdown value", Genre_AddButton);

		keyboard();
		sleepTime(2);

		//TC_AM_GT_072
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_AM_GT_072");
		// Add Note
		assetMaintenance.AddNote();

		switchIntoFrame(frameParent2Xpath);
		sleepTime(3);

		//Delete Notes
		WaitForElementPresent(loc_NoteCompleteRow, Note_Status);
		clickUsingJSExecutor(loc_NoteCompleteRow, "Note Complete Row", Note_AddButton);
		scrollElementIntoView(loc_RemoveNoteIcon, Note_Status);
		clickUsingJSExecutor(loc_RemoveNoteIcon, "Remove Note", Note_DeleteButton);
		driver.switchTo().window(driver.getWindowHandle());



		//Alert Message 
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, Note_DeleteValidationMessage, "Alert Message", Note_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up", Note_DeleteButton);

		sleepTime(6);
		//Re-Adding Notes
		assetMaintenance.AddNote();

		switchIntoFrame(frameParent2Xpath);
		//Save
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset", CreatedSeriesAssetTitle, "title");
	}	

	@Test(priority =2,enabled =true,description = "Program Summary" )
	public void TC2_ProgramSummary() throws Exception {
		assetMaintenance.selectAsset(CreatedSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		/* Properties in Program Summary */
		ExecutionLog.Log("*******************Program Summary*******************");
		sleepTime(3);

		verifyTextMatches(loc_ProgramSummaryHeader, "Program Summary Header", "Program Summary");
		if (!(ClientName.contains("VMN"))){
			ExecutionLog.Log("=====Source Id is===== " + getAttribute(loc_SourceIDField, "value"));
		} else {
			ExecutionLog.Log("=====Source Id is===== " + getAttribute(loc_SourceIDField_VMN, "value"));
		}

		if (ClientName.contains("AMCN") || ClientName.contains("TURNER")){
			verifyTextMatches(loc_AssetTypeAtProgramSummary, "Asset Type at Program Summary", TitleType, "value");
		}

		//Cast and Premier date is not shown for SKY at Program Summary 
		if (!ClientName.contains("SKY")){
			ExecutionLog.Log("=====CastORContacts is===== " + getAttribute(loc_CastORContacts, "value"));
			ExecutionLog.Log("=====Premier Date At ProgramSummary is===== " + getAttribute(loc_PremierDateAtProgramSummary, "value"));
		}
	}

	@Test(priority =3,enabled =true,description = "Re-Verify Program Summary")
	public void TC3_VerifyProgSum() throws Exception {
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent1Xpath);
		/* Checking Totals Hrs is updated with Episodes time */
		ExecutionLog.Log("*************Checking Totals Hrs is updated with Episodes time*******************");	
		assetMaintenance.selectAsset(CreatedSeriesAssetTitle);
		if (!(ClientName.contains("VMN") && ClientName.contains("CORUS"))){
			ExecutionLog.Log("======Total Hrs shown in Program Summary is===== " + getAttribute(loc_TotalHoursProgramSummary, "value"));
		} else {
			throw new SkipException("TC3_VerifyProgSum does not has the the field 'total Hours' in Program Summary for VMN && CORUS client");
		}
	}

	//ELEMENT sub type change is not applicable for ASTRO as there is only one Subtype i.e. Element Music
	@Test(priority =4,enabled =true,description = "To convert Asset Subtype for Program and Element Assets")
	public void TC4_ChangeAssetSubType() throws Exception {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);


		CreatedMovieAssetTitle =  "AUT_Assetmovie_" +formattedDate+"";
		CreatedEleAssetTitle = "AUT_AssetEle_" +formattedDate+"";

		//Create Movie Asset
		ExecutionLog.Log("**************Started Creating Movie Asset**************");
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		assetMaintenance.navigateToGeneralTab( "Program", CreatedMovieAssetTitle);
		WaitForElementPresent(By.id("txtAssetTitle"));

		//Field - Entry AssetType 
		selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType_ProgrameMovie, AssetType_Status);

		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		assetMaintenance.searchAndSelectIP();
		//Enter value in Asset Title Field
		//driver.findElement(By.id("txtAssetTitle")).click();
		sendKeys(loc_AssetTitleField, CreatedMovieAssetTitle, "AssetTitle", AssetTitle_Status);

		// Field - Vendor
		assetMaintenance.searchAndSelectVendor();

		switchIntoFrame(frameParent2Xpath);

		// Select Vendor 2
		assetMaintenance.searchAndSelectStudio();

		//Field - Source Business Unit
		switchIntoFrame(frameParent2Xpath);

		// Search and Select SBU
		assetMaintenance.searchAndSelectSBU();
		// Field - Duration
		switchIntoFrame(frameParent2Xpath);
		sendKeys(loc_DurationField, Duration, "Duration", AssetTitle_Status);

		//Field - Asset Status
		selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus,AssetStatus_Status);

		// TODO check for which client it exists
		// Field - Asset Source
		//clickUsingJSExecutor(loc_AssetFormatDropDown, "Asset Format");
		selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource,AssetFormat_Status);

		// Field - Title Type / Asset source-UCI
		selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
		switchIntoFrame(frameParent2Xpath);
		//clickUsingJSExecutor(loc_CheckInternalCheckBox, "CheckInternalCheckBox");

		// Field - Delivery date
		sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

		//Asset Group
		selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

		//Season - Commented not required for this 4 clients
		selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, Season_Status);

		//Look up code
		sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

		//Project Id
		sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

		//Asset Hierarchy
		selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

		//MML Client Group
		selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

		//PROD Contract Entry Status
		selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

		//// TODO Failing for CORUS
		//Adding Genre
		// Add Genre and Genre Type
		assetMaintenance.AddGenreAndGenreType();

		assetMaintenance.AddNote();

		switchIntoFrame(frameParent2Xpath);
		//Save
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + CreatedMovieAssetTitle , CreatedMovieAssetTitle);

		ExecutionLog.Log("**************Changing the Asset Type from 'Program - One-Off' to 'Program - Special'**************");
		//TC_AM_GT_004
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_AM_GT_004");
		//Change Sub -type from Program One-Off to Program Special
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);

		assetMaintenance.selectAsset(CreatedMovieAssetTitle);

		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		sleepTime(3);

		if (!(AssetType_Status.contains("N/A"))){
			WaitForElementPresent(loc_AssetTypeDropDown);
			selectDropdownValue(loc_AssetTypeDropDown, "Asset Type", AssetMovieSubType, "");

			driver.switchTo().window(driver.getWindowHandle());
			WaitForElementPresent(ConfirmAlertXpath);
			verifyTextMatches(ConfirmAlertValidationMessgeText, "Validation Messge changing the Asset Type", ValMessage_ChagneAssetSubType);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Ok");
			sleepTime(3);
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath); 
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath); 

			// verify that Asset type is changed
			verifyFirstSelectedDropdownValue(loc_AssetTypeDropDown, "Selected Option", AssetMovieSubType, "");
			ExecutionLog.Log("Verified that the subtupe of Movie Asset: " + CreatedMovieAssetTitle + " is changed from '" + AssetType_ProgrameMovie + "' to '" +AssetMovieSubType + "' successfully");			
		}

		if(!AssetType_Element.contains("N/A")){
			ExecutionLog.Log("**************Started Creating Element Asset**************");
			///////////////////////////Create Element Asset	
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.navigateToGeneralTab( "Element", CreatedEleAssetTitle);
			WaitForElementPresent(By.id("txtAssetTitle"));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType_Element_Music, AssetType_Status);
			WaitForModalPanel();
			sleepTime(2);
			switchIntoFrame(frameParent2Xpath);
			//Enter value in Asset Title Field
			clickOn(loc_AssetTitleField, "Asset Title Field");
			sendKeys(loc_AssetTitleField, CreatedEleAssetTitle, "AssetTitle", AssetTitle_Status);
			// Field - Vendor
			assetMaintenance.searchAndSelectVendor();
			switchIntoFrame(frameParent2Xpath);

			// Select Vendor 2
			// VENDOR 2 is not present for Element Type Asset in VMN 
			if(!(ClientName.contains("SALESDEMO")|| ClientName.contains("VMN"))  ) {
				assetMaintenance.searchAndSelectStudio();
			}

			//Field - Source Business Unit
			// Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// SBU is not Present For Element Type Asset for uCI client
			if(!ClientName.contains("UCI")) {
				assetMaintenance.searchAndSelectSBU();
			}

			switchIntoFrame(frameParent2Xpath);
			//Field - Asset Status >> This field is not applicable for Element Type Status
			// Asset Status is available for ASTRO client only for Element Type Asset
			if(ClientName.contains("ASTRO") || ClientName.contains("CORUS")) {
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", MovieAssetStatus, AssetStatus_Status);
			}


			// Field - Asset Source
			switchIntoFrame(frameParent2Xpath);
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource,AssetFormat_Status);


			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);


			// Field - Duration
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_DurationField, Duration, "Duration", AssetTitle_Status);


			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, Season_Status);

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			// These Fields are not present for Element Type Asset in VMN 
			if(!ClientName.contains("VMN")) {
				//Project Id
				sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);

				//MML Client Group
				selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

				//PROD Contract Entry Status
				selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

			}

			//Adding Genre
			// Add Genre and Genre Type
			assetMaintenance.AddGenreAndGenreType();

			// Add Note for Element Asset Type
			assetMaintenance.AddNote();
			switchIntoFrame(frameParent2Xpath);

			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Asset" + CreatedEleAssetTitle, CreatedEleAssetTitle, "title");

			ExecutionLog.Log("**************Changeing the Asset Type from "+AssetType_Element_Music+"' to 'Element - Text'**************");

			//TC_AM_GT_013
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_AM_GT_013");
			//Change Sub -type for Element 
			switchIntoFrame(frameParent1Xpath); 
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.selectAsset(CreatedEleAssetTitle);

			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			sleepTime(6);

			if (!(AssetType_Status.contains("N/A"))){
				if (!Browser.equalsIgnoreCase("chrome")){
					WaitForElementPresent(loc_AssetTypeDropDown);
				}
				selectDropdownValue(loc_AssetTypeDropDown, "Asset Type Drop down for Element Type Asset", AssetElementSubType, "");
				driver.switchTo().window(driver.getWindowHandle());
				WaitForElementPresent(ConfirmAlertXpath);
				verifyTextMatches(ConfirmAlertValidationMessgeText, "Validation Messge while clear the IP Field", ValMessage_ChagneAssetSubType);
				clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Ok");
				sleepTime(3);
				clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up");
				sleepTime(6);
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath); 
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath); 

				// verify that Asset type is changed
				verifyFirstSelectedDropdownValue(loc_AssetTypeDropDown, "Selected Options", AssetElementSubType, "");
				ExecutionLog.Log("Verified that the subtupe of Movie Asset: " + CreatedEleAssetTitle + " is changed from '" + AssetElementSubType + "' to  successfully");

			}
		}

	}

	@Test(priority =5,enabled =true,description = "Validate functionality to generation Internal Deal for Series assets")
	public void TC5_InternalDealforSeriesassets() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		CreatedSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";

		if(!InternalCheckBox_Status.contains("N/A")){
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.navigateToGeneralTab("Program", CreatedSeriesAssetTitle);
			WaitForElementPresent(By.id("txtAssetTitle"));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", Series_AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, CreatedSeriesAssetTitle, "AssetTitle", AssetTitle_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

			// Field - Vendor
			assetMaintenance.searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//Field - Source Business Unit
			// Search and Select SBU
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.searchAndSelectSBU();
			// Field - Duration
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.searchAndSelectIP(); // newly adding for VMN
			sendKeys(loc_DurationField, Duration, "Duration", AssetTitle_Status);

			//Field - Asset Status
			selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);

			/////////////////////////////

			// TODO check for which client it exists
			// Field - Asset Source
			//clickUsingJSExecutor(loc_AssetFormatDropDown, "Asset Format");
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetCreationAssetSource, AssetFormat_Status);

			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", AssetCreationTitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.searchAndSelectSBU();
			// Manual Test Step : TC_AM_GT_005
			clickUsingJSExecutor(loc_CheckInternalCheckBox, "CheckInternalCheckBox");

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			// Field - Actual run time
			sendKeys(loc_ActualrunTime_InputField, Duration, "ActualRunTime", ActualRunTime_Status);

			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);



			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset", CreatedSeriesAssetTitle, "title");

			if(driver.findElement(ByLocator(loc_CheckInternalCheckBox)).isDisplayed()){
				ExecutionLog.Log("check box not freeze. ");
			}else{
				ExecutionLog.Log("Check box freeze");
			}

			//Rights In
			rightsIN.navigateToRightsIN();

			//TC_AM_GT_012
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_AM_GT_012");
			//Search deal
			rightsIN.searchCreatedAsset_IN_RISearch(CreatedSeriesAssetTitle);

			// TC_AM_GT_001
			assetMaintenance.selectAsset(CreatedSeriesAssetTitle);
			// Verify that On click Home Link user is taken to Asset Home Page
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_CreatedAssetAtHomeLink, "Home Link");
			Assert.assertTrue(isElementPresent(loc_Gadget));
			ExecutionLog.Log("Asset Home page is shown on clicking on the Home Link");

		}else {
			logger.log(LogStatus.SKIP, "Internal Check box is not Applicable for:" + ClientData);
			throw new SkipException("Internal Check box is not Applicable for:" + ClientData);
		}
	}

	@Test(priority =6,enabled =true,description = "Series handling after updating fields in General Tab")
	public void TC6_Series_handling() throws Exception {
		if(!(ClientName.contains("SALESDEMO"))){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			CreatedSeriesAssetTitle ="AUT_AssetSeries_" +formattedDate+"";
			assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle,Series_AssetType);
			//Searching  the Series Asset
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);

			//Search the created Asset 
			assetMaintenance.selectAsset(CreatedSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);

			//TC_AM_GT_002
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_AM_GT_002");
			//Add Episode
			sleepTime(5);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_EpisodeAdd, "Add Episode Button");
			driver.switchTo().window(driver.getWindowHandle());
			sendKeys(loc_EpisodeAddWindow, "101", "Add Episode Window", "");
			sleepTime(3);
			clickUsingJSExecutor(loc_EpisodeAddOKbutton, "OK Button");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);

			// Here @var of the locator is replaced with the row number: 1
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of First Row");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");

			clickOn(loc_SelectSeason.replace("@var", Season1), "Season 1");

			clickUsingJSExecutor(loc_TBD_EpisodeWindow,"TBD EpisodeWindow", Episode_AirDateValue);
			clickOn(loc_InitialAirDate_EpisodeWindow.replace("@var", "1"),"InitialAirDateEpisodeWindow", Episode_AirDateValue);
			sendKeys(loc_InitialAirDatefield_EpisodeWindow.replace("@var", "1"), "01/01/2013", "InitialAirDatefield_EpisodeWindow", Episode_AirDateValue);

			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of First Row");
			clickUsingJSExecutor(loc_EpisodeAdd, "Add Episode Button");
			driver.switchTo().window(driver.getWindowHandle());
			sendKeys(loc_EpisodeAddWindow, "102", "Add Episode Window", "");
			clickUsingJSExecutor(loc_EpisodeAddOKbutton, "OK Button");

			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "Season Field of Second Row");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", "Season 1"), "Season 1");

			clickUsingJSExecutor(loc_TBD_EpisodeWindow,"TBD EpisodeWindow", Episode_AirDateValue);
			clickOn(loc_InitialAirDate_EpisodeWindow.replace("@var", "2"),"InitialAirDateEpisodeWindow", Episode_AirDateValue);
			sendKeys(loc_InitialAirDatefield_EpisodeWindow.replace("@var", "2"), "01/02/2014", "InitialAirDatefield_EpisodeWindow for Second Episode", Episode_AirDateValue);
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "Season Field of Second Row", Episode_AirDateValue);

			clickUsingJSExecutor(loc_EpisodesWindowSave, "Save Button");
			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);

			WaitForElementToClickable(loc_EpisodesWindowSave);
			clickUsingJSExecutor(loc_EpisodesWindowClose, "Close Button at Episode Window");


			//TC_AM_GT_004
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_AM_GT_004");
			sleepTime(6);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "General"), "General TAB");
			//Field - Source Business Unit
			if (!(SBU_Status.contains("N/A"))) {
				ExecutionLog.Log("*******changing the values in the SBU field and verify >> Save >> verify values in \" Series-episodes update window\" >> Select First Radio Button \"All Associated Episodes\" >> ");
				if(!(StudioPickListIconAvailabilty_Status.contains("N/A"))) {
					// If the SBU pick list is present the chagne the value from the Pick list pop up
					clickUsingJSExecutor(loc_SBUImage, "SBUImage");
					driver.switchTo().window(driver.getWindowHandle());
					WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
					verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "SBU Window/Owner Channel Header", SBUWindow_Status);
					switchIntoFrame(frameParent4Xpath);
					WaitForElementToClickable(loc_SelectAllCheckBoxSBU);
					clickOn(loc_SelectAllCheckBoxSBU, "SelectAll CheckBox SBU");
					sleepTime(2);
					clickOn(loc_SecondCheckBoxAtSBU, "Uncheck Second CheckBox At SBU window");
					sleepTime(2);
					clickUsingJSExecutor(Applybutton_AtSBUWindow, "Apply Button");


				} else {
					// Select value in SBU drop down
					selectDropdownValueByIndex(loc_SBUField, "SBU", 2, SBU_Status);
				}
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementToClickable(By.id("btnOK"));
				verifyTextMatches(loc_AllAssociatedEpisodes, "'AllAssociatedEpisodes' Radio button", "Apply changes to all associated Episodes");
				verifyTextMatches(loc_DoNotChangeEpisodeData, "'Do not change Episode data' Radio Button", "Do not change Episode data");
				verifyTextMatches(loc_ApplyChangesToSelectedEpisodes, "'Apply changes to selected Episodes' Radio button", "Apply changes to selected Episodes:");

				//TC_AM_GT_006
				ExecutionLog.Log("************Verify Buttons at 'Series Episode Window'************");
				verifyFieldValueOfHeader(loc_SelectAll, "Select All", "Select All", "","value");
				verifyFieldValueOfHeader(OKButton, "OK", "Ok Button", "" ,"value");
				verifyFieldValueOfHeader(loc_CancelButton, "Cancel", "Cancel Button", "" ,"value");

				//TC_AM_GT_017
				clickUsingJSExecutor(loc_CancelButton, "Cancel Button at 'Series Episode Window'");
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				clickUsingJSExecutor(loc_AllAssociatedEpisodes, "'All Associated Episodes' Radio button at 'Series Episode Window'");
				sleepTime(2);
				clickUsingJSExecutor(OKButton, "OK button at 'Series Episode Window'");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

			}
			//////////////////////////////////////////////////////////////////////////////////////////////
			//Field - Source Business Unit
			if (!(SBU_Status.contains("N/A"))) {
				ExecutionLog.Log("*******Changing the values in the SBU field and verify >> Save >> verify values in \" Series-episodes update window\" >> Select Second Radio Button \"Do not change Episode data\" >> ");
				if(!(StudioPickListIconAvailabilty_Status.contains("N/A"))) {
					clickUsingJSExecutor(loc_SBUImage, "SBUImage");
					driver.switchTo().window(driver.getWindowHandle());
					WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
					verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "SBU Window/Owner Channel Header", SBUWindow_Status);
					switchIntoFrame(frameParent4Xpath);
					WaitForElementToClickable(loc_SelectAllCheckBoxSBU);
					clickOn(loc_SelectAllCheckBoxSBU, "SelectAll CheckBox SBU");
					sleepTime(2);
					clickOn(loc_ThirdCheckBoxAtSBU, "Uncheck Third CheckBox At SBU window");
					sleepTime(2);
					clickUsingJSExecutor(Applybutton_AtSBUWindow, "OK Button");



				} else {
					// Select value in SBU drop down
					selectDropdownValueByIndex(loc_SBUField, "SBU", 3, SBU_Status);
				}
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementToClickable(By.id("btnOK"));
				verifyTextMatches(loc_AllAssociatedEpisodes, "'AllAssociatedEpisodes' Radio button", "Apply changes to all associated Episodes");
				verifyTextMatches(loc_DoNotChangeEpisodeData, "'Do not change Episode data' Radio Button", "Do not change Episode data");
				verifyTextMatches(loc_ApplyChangesToSelectedEpisodes, "'Apply changes to selected Episodes' Radio button", "Apply changes to selected Episodes:");
				ExecutionLog.Log("************Verify Buttons at 'Series Episode Window'************");
				verifyFieldValueOfHeader(loc_SelectAll, "Select All", "Select All", "","value");
				verifyFieldValueOfHeader(OKButton, "OK", "Ok Button", "" ,"value");
				verifyFieldValueOfHeader(loc_CancelButton, "Cancel", "Cancel Button", "" ,"value");

				//TC_AM_GT_017
				ExecutionLog.Log("****************Verify Radio buttons and OK,Select and Cancel Buttons after 'Do not change Episode data'is checked**************");
				clickOn(loc_DoNotChangeEpisodeData,"'Do not change Episode data' Radio Button");
				sleepTime(1);
				clickUsingJSExecutor(OKButton, "OK Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

			}

			//////////////////////////////////////////////////////////////////////////////////////////////
			//change 
			if (!(SBU_Status.contains("N/A"))) { 
				ExecutionLog.Log("*******Changing the values in the SBU field and verify >> Save >> verify values in \" Series-episodes update window\" >> Click Apply >> verify validation Message ");
				if(!(StudioPickListIconAvailabilty_Status.contains("N/A"))) {
					clickUsingJSExecutor(loc_SBUImage, "SBUImage");
					driver.switchTo().window(driver.getWindowHandle());
					WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
					verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "SBU Window/Owner Channel Header", SBUWindow_Status);
					switchIntoFrame(frameParent4Xpath);
					WaitForElementToClickable(loc_SelectAllCheckBoxSBU);
					clickOn(loc_SelectAllCheckBoxSBU, "SelectAll CheckBox SBU");
					sleepTime(2);
					clickOn(loc_FourthCheckBoxAtSBU,"Uncheck Fourth CheckBox At SBU window");
					clickUsingJSExecutor(Applybutton_AtSBUWindow, "Apply Button");
					sleepTime(3);
				}	else {
					// Select value in SBU drop down
					selectDropdownValueByIndex(loc_SBUField, "SBU", 4, SBU_Status);
				}
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementToClickable("btnOK");
				verifyTextMatches(loc_AllAssociatedEpisodes, "'AllAssociatedEpisodes' Radio button", "Apply changes to all associated Episodes");
				verifyTextMatches(loc_DoNotChangeEpisodeData, "'Do not change Episode data' Radio Button", "Do not change Episode data");
				verifyTextMatches(loc_ApplyChangesToSelectedEpisodes, "'Apply changes to selected Episodes' Radio button", "Apply changes to selected Episodes:");
				ExecutionLog.Log("************Verify Buttons at 'Series Episode Window'************");
				verifyFieldValueOfHeader(loc_SelectAll, "Select All", "Select All", "","value");
				verifyFieldValueOfHeader(OKButton, "OK", "Ok Button", "" ,"value");
				verifyFieldValueOfHeader(loc_CancelButton, "Cancel", "Cancel Button", "" ,"value");
				sleepTime(1);
				//TC_AM_GT_026
				clickUsingJSExecutor(OKButton, "OK Button");

				driver.switchTo().window(driver.getWindowHandle());
				verifyTextMatches(AlertValidationMessgeText, "Alert Msg at SBU window", ValMessage_SelectAtLeastOneItme_SBU_window);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert");

				switchIntoFrame(frameParent4Xpath);
				clickOn(loc_Episode002_AtSBUwindow, "Episodes 002");
				clickUsingJSExecutor(OKButton, "OK Button"); 
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

			}

			//////////////////////////////////////////////////////////////////////////////////////////////
			//change 
			if (!(SBU_Status.contains("N/A"))) {
				ExecutionLog.Log("*******Changing the values in the SBU field and verify >> Save >> verify values in \" Series-episodes update window\" >> Select All Button");

				if(!(StudioPickListIconAvailabilty_Status.contains("N/A"))) {
					clickUsingJSExecutor(loc_SBUImage, "SBUImage");
					driver.switchTo().window(driver.getWindowHandle());
					WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
					verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "SBU Window/Owner Channel Header", SBUWindow_Status);
					switchIntoFrame(frameParent4Xpath);
					WaitForElementToClickable(loc_SelectAllCheckBoxSBU);
					clickOn(loc_SelectAllCheckBoxSBU, "SelectAll CheckBox SBU");
					sleepTime(6);
					clickOn(loc_FirstCheckBoxAtSBU, "Uncheck Fifth CheckBox At SBU window");
					clickUsingJSExecutor(Applybutton_AtSBUWindow, "Apply Button");
				} else {
					// Select value in SBU drop down
					selectDropdownValueByIndex(loc_SBUField, "SBU", 5, SBU_Status);
				}
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				WaitForElementToClickable("btnOK");
				verifyTextMatches(loc_AllAssociatedEpisodes, "'AllAssociatedEpisodes' Radio button", "Apply changes to all associated Episodes");
				verifyTextMatches(loc_DoNotChangeEpisodeData, "'Do not change Episode data' Radio Button", "Do not change Episode data");
				verifyTextMatches(loc_ApplyChangesToSelectedEpisodes, "'Apply changes to selected Episodes' Radio button", "Apply changes to selected Episodes:");

				ExecutionLog.Log("************Verify Buttons at 'Series Episode Window'************");
				verifyFieldValueOfHeader(loc_SelectAll, "Select All", "Select All", "","value");
				verifyFieldValueOfHeader(OKButton, "OK", "Ok Button", "" ,"value");
				verifyFieldValueOfHeader(loc_CancelButton, "Cancel", "Cancel Button", "" ,"value");
				clickOn(loc_SelectAll,"SelectAll");
				sleepTime(1);
				clickUsingJSExecutor(OKButton, "OK Button"); 
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

			}

		} else {
			throw new SkipException("SalesDemo: Bug ID: 19762");
		}


	}

	@Test(priority =7,enabled =true,description = "Validate duplicate Asset Title")
	public void TC7_Validate_duplicate_Asset() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);

		if (!(ClientName.contains("VMN"))){
			String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";	
			ExecutionLog.Log("Asset01 with prefix 'AUT_AssetSeries_':" +createdSeriesAssetTitle);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle,Series_AssetType);

			String createdSeriesAssetTitle01 = "RSGA_" +formattedDate+"";
			String createdSeriesAssetTitle02 = "The RSGB_" +formattedDate+"";
			String createdSeriesAssetTitle03 = "An_RSGC_" +formattedDate+"";
			String createdSeriesAssetTitle04 = "@ RSGD_" +formattedDate+"";
			ExecutionLog.Log("Asset01 with prefix 'RSGA_': "+createdSeriesAssetTitle01);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle01,Series_AssetType);
			ExecutionLog.Log("Asset02 with prefix 'The RSGB_': "+createdSeriesAssetTitle02);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle02,Series_AssetType);
			ExecutionLog.Log("Asset03 with prefix 'An_RSGC_': "+createdSeriesAssetTitle03);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle03,Series_AssetType);
			ExecutionLog.Log("Asset04 with prefix '@ RSGD_': "+createdSeriesAssetTitle04);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle04,Series_AssetType);

			//Search the created Asset 
			assetMaintenance.selectAsset(createdSeriesAssetTitle);

			///////////////////////////////For createdSeriesAssetTitle01//////////////////////////////////
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_AssetTitleField, createdSeriesAssetTitle01, "Asset Title Field", "");
			clickOn(loc_AssetTitleImageIcon, "AssetTitleImageIcon");
			EPGAlertAccept();

			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_TitleHeader_AssetTitleWindow, "TitleHeader at Asset Title Window", AKAWindow_Title);

			verifyTextMatches(loc_AKATitles_AssetTitleWindow, "AKA Titles at Asset Title Window", AKAWindow_AKATitles);
			verifyTextMatches(loc_AssetTypeHeader_AssetTitleWindow, "Asset Type at Asset Title Window", AKAWindow_AssetType);
			verifyTextMatches(loc_ReleaseYr_AssetTitleWindow, "Release Yr at Asset Title Window", AKAWindow_ReleaseYr);
			verifyTextMatches(loc_Director_Artist_AssetTitleWindow, "Director/Artist at Asset Title Window", AKAWindow_Director);

			verifyTextMatches(loc_SaveButton_AssetTitleWindow, "Save Button at Asset Title Window", "Save", "value");
			verifyTextMatches(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset Title Window", "Cancel", "value");
			verifyTextMatches(loc_AssetTitleWindowBox, "Asset Title in Asset title Window Box", createdSeriesAssetTitle01+ " " + Series_AssetType);
			clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset Title Window");

			///////////////////////////////For createdSeriesAssetTitle02//////////////////////////////////
			ExecutionLog.Log("Enter the Asset Name " + createdSeriesAssetTitle02 + " >> click on \"Validate Asset Title\" Icon >> Verify Asset Name in the opened window");
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_AssetTitleField, createdSeriesAssetTitle02, "Asset Title Field", "");
			clickOn(loc_AssetTitleImageIcon, "AssetTitleImageIcon");
			EPGAlertAccept();
			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_AssetTitleWindowBox, "Asset Title in Asset title Window Box", createdSeriesAssetTitle02+ " " + Series_AssetType);
			clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset Title Window");

			///////////////////////////////For createdSeriesAssetTitle03//////////////////////////////////
			ExecutionLog.Log("Enter the Asset Name " + createdSeriesAssetTitle03 + " >> click on \"Validate Asset Title\" Icon >> Verify Asset Name in the opened window");
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_AssetTitleField, createdSeriesAssetTitle03, "Asset Title Field", "");
			clickOn(loc_AssetTitleImageIcon, "AssetTitleImageIcon");
			EPGAlertAccept();
			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_AssetTitleWindowBox, "Asset Title in Asset title Window Box", createdSeriesAssetTitle03+ " " + Series_AssetType);
			clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset Title Window");

			///////////////////////////////For createdSeriesAssetTitle04//////////////////////////////////
			ExecutionLog.Log("Enter the Asset Name " + createdSeriesAssetTitle04 + " >> click on \"Validate Asset Title\" Icon >> Verify Asset Name in the opened window");
			switchIntoFrame(frameParent2Xpath);
			sendKeys(loc_AssetTitleField, createdSeriesAssetTitle04, "Asset Title Field", "");
			clickOn(loc_AssetTitleImageIcon, "AssetTitleImageIcon");
			EPGAlertAccept();
			switchIntoFrame(frameParent4Xpath);
			verifyTextMatches(loc_AssetTitleWindowBox, "Asset Title in Asset title Window Box", createdSeriesAssetTitle04+ " " + Series_AssetType);
			clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset Title Window");

			// duplicate Assets are not applicable for TURNER and SalesDemo
			if(!(ClientData.equals("SKY") || ClientData.equals("TURNER") || ClientData.equals("SALESDEMO"))) {
				///////////////////////////////For createdSeriesAssetTitle01 Save and Cancel//////////////////////////////////
				ExecutionLog.Log("Enter the Asset Name " + createdSeriesAssetTitle01 + " >> click on \"Save Button\" >> Verify Aset Title Validation Window Opens");
				switchIntoFrame(frameParent2Xpath);
				sendKeys(loc_AssetTitleField, createdSeriesAssetTitle01, "Asset Title Field", AssetTitle_Status);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				EPGAlertAccept();
				sleepTime(5);
				switchIntoFrame(frameParent4Xpath);
				clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button at Asset title Window");

				///////////////////////////////For createdSeriesAssetTitle02 Save and Cancel//////////////////////////////////
				ExecutionLog.Log("*****Enter the Asset Name " + createdSeriesAssetTitle02 + " >> click on \"Save Button\" >> Verify Aset Title Validation Window Opens");
				switchIntoFrame(frameParent2Xpath);
				sendKeys(loc_AssetTitleField, createdSeriesAssetTitle02, "Asset Title Field", AssetTitle_Status);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				EPGAlertAccept();
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath);
				clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button");

				///////////////////////////////For createdSeriesAssetTitle03 Save and Cancel//////////////////////////////////
				ExecutionLog.Log("*****Enter the Asset Name " + createdSeriesAssetTitle03 + " >> click on \"Save Button\" >> Verify Aset Title Validation Window Opens");
				switchIntoFrame(frameParent2Xpath);
				sendKeys(loc_AssetTitleField, createdSeriesAssetTitle03, "Asset Title Field", AssetTitle_Status);
				clickUsingJSExecutor(SaveMenuBar, "Save Button");
				EPGAlertAccept();
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath);
				clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button");

				///////////////////////////////For createdSeriesAssetTitle04 Save and Cancel//////////////////////////////////
				ExecutionLog.Log("*****Enter the Asset Name " + createdSeriesAssetTitle04 + " >> click on \"Save Button\" >> Verify Aset Title Validation Window Opens");
				switchIntoFrame(frameParent2Xpath);
				sendKeys(loc_AssetTitleField, createdSeriesAssetTitle04, "Asset Title Field", AssetTitle_Status);
				clickUsingJSExecutor(SaveMenuBar, "Save Button Menu Bar");
				EPGAlertAccept();
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath);
				clickUsingJSExecutor(loc_CancelButton_AssetTitleWindow, "Cancel Button");
			}
		} else {
			// VMN does not has the Asset Title validation Icon
			throw new SkipException("***TC7_Validate_duplicate_Asset*** : This Test Case is not applicable for \"" +  ClientData + "\"");
		}

	}


	public void EPGAlertAccept() throws Exception {
		if(ClientData.contains("SKY")){
			acceptAlert();
		}
	}
	
	public void selectAndReEnterIP() throws Exception{
		switchIntoFrame(frameParent2Xpath);
		if (!(IP_Status.contains("N/A"))) {
			WaitForElementToClickable(loc_IPImageIcon);
			clickUsingJSExecutor(loc_IPImageIcon, "IPImageIcon");
			driver.switchTo().window(driver.getWindowHandle());
			sleepTime(3);
			// Window title Validation
			WaitForElementPresent(Window2Header);
			verifyTextMatches(Window2Header, "IP Window Header", IPWindow_Status);
			//Search
			if(ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent3Xpath);
			} else {
				switchIntoFrame(frameParent4Xpath);
			}
			WaitForElementPresent(loc_IPAndVendorWindowfield);
			sendKeys(loc_IPAndVendorWindowfield, SearchvalueIP, "IPfield",IP_Status);
			clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "IPWindowButtonfind");
			WaitForElementPresent("//table[@data-ig='x:uwgSearch.10:mkr:dataTbl.hdn']/tbody/tr/td[2]");
			//Selecting and validating the IP name
			int i = 0;
			String Xpath_val2 = "//*[@data-ig='x:uwgSearch.23:adr:"+ i +":tag:']/td[2]";
			clickOn(Xpath_val2, "Searched IP Name");

			clickUsingJSExecutor(loc_IPSelectButton, "IPSelectButton");
			driver.switchTo().window(driver.getWindowHandle()); 
			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);
			//// Validate that IP name is selected
			verifyFieldValueOfHeader(loc_IPfield, SearchvalueIP, "IP Field", IP_Status, "value");

			///// Clear the IP Name
			WaitForElementToClickable(loc_IPClear);
			clickUsingJSExecutor(loc_IPClear, "IP Clear",IP_Status);
			driver.switchTo().window(driver.getWindowHandle());

			//Alert Message 
			WaitForElementPresent(ConfirmAlertXpath, IP_Status);
			verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, ValMessage_clearFieldVAlue,"Validation Messge while clear the IP Field", IP_Status);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Ok", IP_Status);
			sleepTime(6);
			switchIntoFrame(frameParent2Xpath, IP_Status);

			// Re-enter the IP Name
			clickUsingJSExecutor(loc_IPImageIcon, "IPImageIcon", IP_Status);
			if(ClientData.contains("AMCN")) {
			switchIntoFrame(frameParent3Xpath, IP_Status);
			} else {
				switchIntoFrame(frameParent4Xpath, IP_Status);
			}
			WaitForElementPresent(loc_IPAndVendorWindowfield, IP_Status);
			sendKeys(loc_IPAndVendorWindowfield, SearchvalueIP, "IP field",IP_Status);
			clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "IPWindowButtonfind", IP_Status);
			WaitForElementPresent("//table[@data-ig='x:uwgSearch.10:mkr:dataTbl.hdn']/tbody/tr/td[2]", IP_Status);
			sleepTime(5);
			clickOn(loc_IPNameAtIPWindow, "IPNameAtIPWindow", IP_Status);
			clickUsingJSExecutor(loc_IPSelectButton, "IPSelectButton", IP_Status);
			switchIntoFrame(frameParent2Xpath, IP_Status);

		} else {
			ExecutionLog.Log("IP field is not available for \"" + ClientData  + "\"");
		}
	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 * // Search and Select SBU
	 */
	public void SelectSBUValue_Select_DeSelectSBU() throws Exception {
		if (!(SBU_Status.contains("N/A"))) {
			if(!(StudioPickListIconAvailabilty_Status.contains("N/A"))) {
				clickUsingJSExecutor(loc_SBUImage, "SBUImage", SBUPickListIconAvailabilty_Status);
				driver.switchTo().window(driver.getWindowHandle());
				WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader, SBUPickListIconAvailabilty_Status);
				verifyFieldValueOfHeader(loc_IPAndVendorAndStudioWindowHeader, SBUWindow_Status, "SBU Window", SBUWindow_Status);
				switchIntoFrame(frameParent4Xpath, SBUPickListIconAvailabilty_Status);
				WaitForElementToClickable(loc_SelectAllCheckBoxSBU, SBUPickListIconAvailabilty_Status);
				clickUsingJSExecutor(loc_SelectAllCheckBoxSBU, "'Select All' CheckBox at SBU", SBUPickListIconAvailabilty_Status);
				sleepTime(6);
				verifyElementPresent("css=img:nth-child(2)[src*='ig_checkbox_on.gif']", "All CheckBoxesChecked", SBUPickListIconAvailabilty_Status);
				clickOn(loc_UnSelectAllCheckBoxSBU, "'DeSelect All' CheckBox at SBU", SBUPickListIconAvailabilty_Status);
				sleepTime(6);
				WaitForElementToClickable(loc_SelectAllCheckBoxSBU, SBUPickListIconAvailabilty_Status);
				verifyElementPresent("css=img:nth-child(2)[src*='ig_checkbox_off.gif']", "All CheckBoxes Not Checked", SBUPickListIconAvailabilty_Status);

				clickOn(loc_FirstCheckBoxAtSBU, "First CheckBox At SBU window", SBUPickListIconAvailabilty_Status);
				clickOn(loc_SecondCheckBoxAtSBU, "Second CheckBox At SBU winodw", SBUPickListIconAvailabilty_Status);
				sleepTime(2);
				clickUsingJSExecutor(Applybutton_AtSBUWindow, "Apply Button", SBUPickListIconAvailabilty_Status);

			} else {
				selectDropdownValue(loc_SBUField, "SBU", AssetCreationSourceBusinessUnit, SBU_Status);
			}
		}
	}

	/**
	 * @author Rajuddin
	 * // Search and Select Studio/Vendor2 name
	 * @throws Exception 
	 */
	public void searchAndSelectStudio_Vendor2() throws Exception {
		if (!(Vendor2_Status.contains("N/A"))) {
			assetMaintenance.searchAndSelectStudio();

			// Deleting the Studio with alert message validation 
			clickUsingJSExecutor(loc_ClearStudioImage, "Clear Studio Image", StudioClearIconAvailabilty_Status);
			driver.switchTo().window(driver.getWindowHandle());
			//Alert Message
			WaitForElementPresent(ConfirmAlertXpath, StudioClearIconAvailabilty_Status);
			verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, ValMessage_clearFieldVAlue, "Validation Messge while clear the Studio Field", StudioClearIconAvailabilty_Status);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Alert Pop up", StudioClearIconAvailabilty_Status);
			sleepTime(6);

			//Re-enter the Studio Name
			assetMaintenance.searchAndSelectStudio();
		}
	}




}

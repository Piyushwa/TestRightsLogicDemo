package assetMaintenance;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;

//This TAB is not Applicable for VMN
@Listeners(utility.ListenerClass.class)
public class AM_Document  extends DriverHelper implements IAM_Document{
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	
	
	String createdSeriesAssetTitle_TC1 	= "AUT_AssetSeries_Doc_TC1_" +formattedDate+"";
	String createdSeriesAssetTitle_TC2 	= "AUT_AssetSeries_Doc_TC2_" +formattedDate+"";
	
	public AM_Document() {
		super("", "", GridHeaderViewPath_AMDocuments_Child, GridDataViewPath_AMDocuments_Child);
		className = this.getClass().getName(); 
		classObject = this.getClass();	
	}
	
	@Test(priority =1, enabled= true, description = "Validate the functionality of Documents Tab")
	public void TC1_DocumentUI() throws Exception{
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle_TC1, Series_AssetType);
			assetMaintenance.AddingEpisodeToAssetWithoutPremdt(createdSeriesAssetTitle_TC1);
			
			assetMaintenance.selectAsset(createdSeriesAssetTitle_TC1);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Documents"), "Documents TAB");
			WaitForModalPanel();

			//Manual Test Step: TC_AM_DT_008
			// Verify All Button
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Document_AddDocumentButton));
			ExecutionLog.Log("***********Verifying AllButtons Present on the Document TAB in view Mode***********");
			verifyTextMatches(loc_Document_ViewButton, "Document_ViewButton", document_ViewButtonValue, "value");
			verifyTextMatches(loc_Document_AddDocumentButton, "Document_AddDocumentButton", document_AddDocumentButtonValue, "value");
			verifyTextMatches(loc_Document_EditProfileButton, "Document_EditProfileButton", document_EditProfileValue, "value");
			verifyTextMatches(loc_Document_DeleteDocumentButton, "Document_DeleteDocumentButton", document_DeleteDocumentValue, "value");
			verifyTextMatches(loc_Edit, "	", document_EditDocumentValue, "value");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Fixed+"[@key='"+document_AppliesTOKey+"']", "Applies TO", document_AppliesTOValue,"innerHTML");

			// Manual Test Step: TC_AM_DT_015
			// Verifying the Fields and Buttons on the Add Document Window
			ExecutionLog.Log("******Verifying the Fields and Buttons on the Add Document Window******");
			clickUsingJSExecutor(loc_Document_AddDocumentButton, "Document_AddDocumentButton",document_AddDocumentButtonValue);
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));
			verifyTextMatches(loc_Document_AddDoc_AppliesToLabel, "Document_AddDoc_AppliesToLabel", document_AddDoc_AppliesToLabel);
			verifyTextMatches(loc_Document_AddDoc_DocNameLabel, "Document_AddDoc_DocNameLabel", document_AddDoc_DocNameLabel);
			verifyTextMatches(loc_Document_AddDoc_DocTypeLabel, "Document_AddDoc_DocTypeLabel", document_AddDoc_DocTypeLabel);
			verifyTextMatches(loc_Document_AddDoc_DocDateLabel, "Document_AddDoc_DocDateLabel", document_AddDoc_DocDateLabel);
			verifyTextMatches(loc_Document_AddDoc_DescriptionLabel, "Document_AddDoc_DescritionLabel", document_AddDoc_DescriptionLabel);
			verifyTextMatches(loc_Document_AddDoc_LibraryLabel, "Document_AddDoc_LibrarhyLabel", document_AddDoc_LibraryLabel);
			verifyTextMatches(loc_Document_AddDoc_DocumentIDLabel, "Document_AddDoc_DocuentIDLabel", document_AddDoc_DocumentIDLabel);
			verifyTextMatches(loc_Document_AddDoc_DocumentUploadLabel, "Document_AddDoc_DocuentUploadLabel", document_AddDoc_DocumentUploadLabel);
			verifyTextMatches(loc_Save, "Save button", "Save","value");
			verifyTextMatches(loc_Cancel, "Cancel button", "Cancel","value");
		
			//Manual Test Step : TC_AM_DT_021
			//Verifying all Associated Assets
			ExecutionLog.Log("*****Verifying all Associated Assets and Episodes are prefixed with 'Ep.'*****");
			verifyFirstSelectedDropdownValue(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values", createdSeriesAssetTitle_TC1, document_AddDoc_AppliesToLabel);
	// TODO Technical Challenge: Not able to verify drop down values of Applies to drop down
			/*verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values", Season1);
			verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values S1_Episode1", S1_Episode101);
			verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values S1_Episode2", S1_Episode102);
			verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values Season 2", Season2);
			verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values S2_Episode1", S2_Episode201);
			verifyDropDownValues(loc_Document_AddDoc_AppliesToDropDown, "Applies TO DropDown Values S2_Episode2", S2_Episode202);*/

			//Manual Test Step : TC_AM_DT_024
			//Test Step from Phase 2 : TC_20
			selectDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown", document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);
			verifyFirstSelectedDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown",  document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);

			//Manual Test Step :TC_AM_DT_027
			String InvalidDocumentName = "Declaration from the Legal HeirDeclaration 1234567890 @#$% @&*";
			sendKeys(loc_Document_AddDoc_DocNameField, InvalidDocumentName, "Document_AddDoc_DocNameField", document_AddDoc_DocNameLabel);
			clickOn(loc_Document_AddDoc_DocNameLabel, "Outside the Document Name Field");		
			// Test Step from Phase 2 : TC_7
			driver.switchTo().window(driver.getWindowHandle()); 
			String ExpectedText = "Please enter a valid file name!";
			verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message on Entering the invalid Names", document_AddDoc_DocNameLabel);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on Entering the invalid Names", document_AddDoc_DocNameLabel); 

			switchIntoFrame(frameParent3Xpath);
			// Manual Test Step :TC_AM_DT_027
			// Verify the message "Please select document to upload"
			sendKeys(loc_Document_AddDoc_DocNameField, AMDocumentNameData, "Document_AddDoc_DocNameField", document_AddDoc_DocNameLabel);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");	
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "'Add Document'Validation Message", document_AddDoc_UploadDocumentVAlidationMessage);
			Thread.sleep(3000);
			sendKeys_WithoutClear(loc_Document_AddDoc_UploadField, AMUploadLoc+"AUTTestFile100KB.bmp"+"", "Upload File 'AUTTestFile100KB.bmp'", document_AddDoc_DocumentUploadLabel);
			Thread.sleep(3000);
			sendKeys(loc_Document_AddDoc_DocumentDateField, AMDocumentDateData, "Document Date", document_AddDoc_DocDateLabel);
			Thread.sleep(3000);
			sendKeys(loc_Document_AddDoc_DescriptionField, document_AddDoc_DocTypeDropDownValue, "Document Discription", loc_Document_AddDoc_DescriptionLabel);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");

			// ManualTest Step :TC_AM_DT_035
			//Verifying all the Headers Name shown in View Mode After adding the Document
			Thread.sleep(3000);
			ExecutionLog.Log("****Verifying all the Headers Name shown in View Mode After adding the Document****");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentTypeKey+"']", "AMDocumentTypeKey", AMDocumentTypeValue,"innerHTML");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentNameKey+"']", "AMDocumentName", AMDocumentName,"innerHTML");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentDateKey+"']", "AMDocumentDate", AMDocumentDate,"innerHTML");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentDescKey+"']", "AMDocumentDesc", AMDocumentDesc,"innerHTML");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentDescKey+"']", "AMDocumentDesc", AMDocumentDesc,"innerHTML");
			verifyTextMatches(GridHeaderViewPath_AMDocuments_Child+"[@key='"+AMDocumentDescKey+"']", "AMDocumentDesc", AMDocumentDesc,"innerHTML");

			// ManualTest Step :TC_AM_DT_036
			//Verifying all the Header's Values are shown correctly in View Mode After adding the Document
			ExecutionLog.Log("****Verifying all the Header's Values are shown orrectly in View Mode After adding the Document****");
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentTypeKey, AMDocumentTypeValue), document_AddDoc_DocTypeDropDownValue, "AMDocumentTypeValue", AMDocumentTypeValue, "innerHTML");
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentNameKey, AMDocumentName), AMDocumentNameData, "AMDocumentNameData", AMDocumentNameData, "innerHTML");		
			verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentDateKey, AMDocumentDate), AMDocumentDateData, "AMDocumentDate", AMDocumentDate, "innerHTML");		
			//verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentDescKey, AMDocumentDesc), document_AddDoc_DocTypeDropDownValue, "document_AddDoc_DocTypeDropDownValue", document_AddDoc_DocTypeDropDownValue, "innerHTML");		

			//ManualTest Step: TC_AM_DT_037
			// Click on View Button without selecting the row
			ExecutionLog.Log("******Click on View Button without selecting the row******");
			clickUsingJSExecutor(loc_Document_ViewButton, "View Button");
			WaitForModalPanel();
			driver.switchTo().window(driver.getWindowHandle()); 
			verifyFieldValueOfHeader(loc_AlertMessage, document_SelectRowToViewValidationMessage, "Alert Message on clicking 'View Button'", document_ViewButtonValue);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'View Button'", document_ViewButtonValue);

			//ManualTest Step: TC_AM_DT_038 : Cannot be automated due to Technical Limitations
			if(!ClientData.contains("TURNER")) {
				////ManualTest Step: TC_AM_DT_039
				// Click on Edit Button without selecting the row
				ExecutionLog.Log("******Click on Edit Button without selecting the row******");
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);		
				clickUsingJSExecutor(loc_Document_EditProfileButton, "Edit Button");
				driver.switchTo().window(driver.getWindowHandle()); 
				ExpectedText = "Please select a row which contains document before clicking Edit Profile";
				verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message on clicking 'View Button'", document_EditProfileValue);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'View Button'", document_EditProfileValue);

				////ManualTest Step: TC_AM_DT_040
				// Select the Document row >> Click on Edit Document Button and change the data and verify in view mode
				ExecutionLog.Log("******Click on Edit Document Button and change the data and verify in view mode******");
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				Thread.sleep(3000);
				clickUsingJSExecutor(GridDataViewPath_AMDocuments_Child+"[2]/th[1]", "Select the Row in View Mode");
				Thread.sleep(3000);
				clickUsingJSExecutor(loc_Document_EditProfileButton, "Edit Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				selectDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown", document_AddDoc_DocTypeData, document_AddDoc_DocTypeLabel);
				verifyFirstSelectedDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown",  document_AddDoc_DocTypeData, document_AddDoc_DocTypeLabel);
				sendKeys(loc_Document_AddDoc_DocNameField, AMDocumentNameData+"_Changed", "Document_AddDoc_DocNameField", document_AddDoc_DocNameLabel);
				Thread.sleep(3000);
				sendKeys(loc_Document_AddDoc_DescriptionField, document_AddDoc_DocTypeDropDownValue, "Document Discription", loc_Document_AddDoc_DescriptionLabel);
				clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				Thread.sleep(3000);
				verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentTypeKey, AMDocumentTypeValue), document_AddDoc_DocTypeData, "AMDocumentTypeValue", AMDocumentTypeValue, "innerHTML");
				verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentNameKey, AMDocumentName), AMDocumentNameData+"_Changed", "AMDocumentNameData", AMDocumentNameData, "innerHTML");		
			}  else {
				ExecutionLog.Log("=====Failed===== BUG ID: 20400 for TURNER");
				ExecutionLog.Log("");
			}
			////ManualTest Step: TC_AM_DT_44
			// Click on Remove Button without selecting the row
			ExecutionLog.Log("******Click on Remove Button without selecting the row******");
			switchIntoFrame(frameParent2Xpath,document_DeleteDocumentValue);
			switchIntoChildFrame(frameParent21Xpath,document_DeleteDocumentValue);		
			clickUsingJSExecutor(loc_Document_DeleteDocumentButton, "Delete Document Button");
			driver.switchTo().window(driver.getWindowHandle()); 
			verifyFieldValueOfHeader(loc_AlertMessage, document_AddDoc_SelectRowBeforeDeleteDocument_ValidationMessage, "Alert Message on clicking 'Delete Button'", document_DeleteDocumentValue);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'View Button'", document_DeleteDocumentValue);

			//TC_AM_DT_047
			//Remove/Delete the Document row
			ExecutionLog.Log("******Remove/Delete the Document row******");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickOn(GridDataViewPath_AMDocuments_Child+"[2]/th[1]", "Select the Row in View Mode");
			clickUsingJSExecutor(loc_Document_DeleteDocumentButton, "Delete Document Button");
			WaitForModalPanel();
			ExpectedText = "Are you sure you want to delete the document?";	
			if(!ClientData.contains("TURNER")) {
				verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, ExpectedText, "Alert Message on clicking 'Remove Button'", document_DeleteDocumentValue);
				clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert on clicking 'View Button'", document_DeleteDocumentValue);
				
			} else {
				ExecutionLog.Log("=====Failed===== BUG ID: 20409");
				Alert alert = driver.switchTo().alert();
				ValidationMessageInPage(alert.getText(), ExpectedText, "");
			}
				
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			verifyElementNotPresent(GridDataViewPath_AMDocuments_Child+"[2]/th[1]", "Document Row");

			//Manual Test Step : TC_AM_DT_049
			// Select the file with more than 20480 KB and open
			ExecutionLog.Log("******Verify the validation message on uploading 20480 KB file****");
			clickUsingJSExecutor(loc_Document_AddDocumentButton, "Document_AddDocumentButton",document_AddDocumentButtonValue);
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			selectDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown", document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);
			verifyFirstSelectedDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown",  document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);
			sendKeys(loc_Document_AddDoc_DocNameField, AMDocumentNameData, "Document_AddDoc_DocNameField", document_AddDoc_DocNameLabel);
			Thread.sleep(3000);
			sendKeys(loc_Document_AddDoc_DocumentDateField, AMDocumentDateData, "Document Date", document_AddDoc_DocDateLabel);
			Thread.sleep(3000);
			sendKeys(loc_Document_AddDoc_DescriptionField, document_AddDoc_DocTypeDropDownValue, "Document Discription", loc_Document_AddDoc_DescriptionLabel);
			sendKeys(loc_Document_AddDoc_UploadField, AMUploadLoc+"AUTTestFile21MB.bmp"+"", "Upload File 'AUTTestFile21MB.bmp'", document_AddDoc_DocumentUploadLabel);
			Thread.sleep(3000);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "'Add Document' Validation Message", document_AddDoc_2048KB_UploadDocumentValidationMessage);

			//Manual Test Step : TC_AM_DT_056
			// Verify the message while uploading WinRAR file
			ExecutionLog.Log("*****Verify the message while uploadiing WinRAR file*****");
			sendKeys(loc_Document_AddDoc_UploadField, AMUploadLoc+"AUTTestFile900KB.rar"+"", "Upload File 'AUTTestFile21MB.bmp'", document_AddDoc_DocumentUploadLabel);
			Thread.sleep(3000);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			verifyTextMatches(loc_AssertCreationValidationMessage, "'Add Document' Validation Message", document_AddDoc_WINRAR_UploadDocumentValidationMessage);

		}
	
	@Test(priority =2,enabled= true,description = "Validate document tab across the asset - Program Series and Episode asset")
	public void TC2_DocumentTAB_AcrossEpisodesAsset() throws Exception{
		
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle_TC2, Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(createdSeriesAssetTitle_TC2); 
		assetMaintenance.selectAsset(createdSeriesAssetTitle_TC2);
		
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Documents"), "Documents TAB");
		switchIntoChildFrame(frameParent21Xpath);
		ExecutionLog.Log("******Add the Document Row****");
		clickUsingJSExecutor(loc_Document_AddDocumentButton, "Document_AddDocumentButton",document_AddDocumentButtonValue);
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		selectDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown", document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);
		verifyFirstSelectedDropdownValue(loc_Document_AddDoc_DocTypeDropDown, "Document_AddDoc_DocTypeDropDown",  document_AddDoc_DocTypeDropDownValue, document_AddDoc_DocTypeLabel);
		sendKeys(loc_Document_AddDoc_DocNameField, AMDocumentNameData, "Document_AddDoc_DocNameField", document_AddDoc_DocNameLabel);
		Thread.sleep(3000);
		sendKeys(loc_Document_AddDoc_DocumentDateField, AMDocumentDateData, "Document Date", document_AddDoc_DocDateLabel);
		Thread.sleep(3000);
		selectDropdownValue(loc_Document_AddDoc_LibraryDropDown, "Document_AddDoc_LibraryDropDown", document_AddDoc_LibraryData, document_AddDoc_LibraryLabel);
		Thread.sleep(3000);
		sendKeys(loc_Document_AddDoc_DocumentIDInputField, AMDocumentNameData + "_ID", "document_AddDoc_DocumentIDLabel", document_AddDoc_DocumentIDLabel);
		Thread.sleep(3000);
		sendKeys(loc_Document_AddDoc_DescriptionField, document_AddDoc_DocTypeDropDownValue, "Document Discription", loc_Document_AddDoc_DescriptionLabel);
		sendKeys(loc_Document_AddDoc_UploadField, AMUploadLoc+"AUTTestFile100KB.bmp", "Upload File 'AUTTestFile100KB.bmp'", document_AddDoc_DocumentUploadLabel);
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Add Document Window'");

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		Thread.sleep(3000);
		//Verifying all the Header's Values are shown correctly in View Mode After adding the Document
		ExecutionLog.Log("****Verifying all the Header's Values are shown orrectly in View Mode After adding the Document****");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentTypeKey, AMDocumentTypeValue), document_AddDoc_DocTypeDropDownValue, "AMDocumentTypeValue", AMDocumentTypeValue, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentNameKey, AMDocumentName), AMDocumentNameData, "AMDocumentNameData", AMDocumentNameData, "innerHTML");		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentDateKey, AMDocumentDate), AMDocumentDateData, "AMDocumentDate", AMDocumentDate, "innerHTML");		
		// Manual Test Step : TC_AM_DT_014
		goToAssetNavigatorAndVerifyDocumentDetails(S1_Episode101);
		// Manual Test Step : TC_AM_DT_016
		goToAssetNavigatorAndVerifyDocumentDetails(S1_Episode102);
		// Manual Test Step : TC_AM_DT_019
		goToAssetNavigatorAndVerifyDocumentDetails(S2_Episode201);
		// Manual Test Step : TC_AM_DT_22
		goToAssetNavigatorAndVerifyDocumentDetails(S2_Episode202);
		

	}
	
	/**
	 * 
	 * @param EpisodeName : Ep.201: Episode201
	 * @throws Exception
	 * @description : This method is specific to this class only
	 */
	public void goToAssetNavigatorAndVerifyDocumentDetails(String EpisodeName) throws Exception{
		// Manual Test Step : TC_AM_DT_019
		// Verify the Document details for Episode 201
		ExecutionLog.Log("");
		ExecutionLog.Log("*******Verify the Document details for "+ EpisodeName + "*******");
		//// Navigate to Asset Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_AssetNavigator, "Asset Navigator");
		switchTOAssetNavigatorWindow();
		clickOn(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var",EpisodeName),"Select "+ EpisodeName+" at Asset Navigator");
		doubleClick(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var",EpisodeName),"Select "+ EpisodeName+" at Asset Navigator");
		Thread.sleep(6000);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(6000);
		String[] a = EpisodeName.split(" ");
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", a[1]);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Documents"), "Documents TAB");
		switchIntoChildFrame(frameParent21Xpath);
		//Verifying all the Header's Values are shown correctly in View Mode For Episode 201
		ExecutionLog.Log("****Verifying all the Header's Values are shown correctly in View Mode For " + a[1] +"****");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentTypeKey, AMDocumentTypeValue), document_AddDoc_DocTypeDropDownValue, "AMDocumentTypeValue", AMDocumentTypeValue, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentNameKey, AMDocumentName), AMDocumentNameData, "AMDocumentNameData", AMDocumentNameData, "innerHTML");		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2", AMDocumentDateKey, AMDocumentDate), AMDocumentDateData, "AMDocumentDate", AMDocumentDate, "innerHTML");		
	
	}
	
	public void switchTOAssetNavigatorWindow() throws Exception {
		if(ClientName.contains("TURNER")||(ClientName.contains("VMN"))){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		} 
		WaitForElementPresent(ByLocator("name="+loc_OkButton));
	}

	@BeforeMethod
	public void runStatus() {
		 if(ClientData.equals("VMN")) {
			throw new SkipException("Script of \"Document TAB\" is Not Applicable for VMN");
		}
	}
}

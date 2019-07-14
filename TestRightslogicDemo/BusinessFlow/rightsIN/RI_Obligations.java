package rightsIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;


@Listeners(utility.ListenerClass.class)
public class RI_Obligations extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();

	/*Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";*/

	
	
	String CreatedDeal1 = "AUT_Deal1_0302201720855";
	
	public RI_Obligations() {
		super(loc_RI_Obligations_ColumnXpath_EditMode, loc_RI_Obligations_DataRowXpath_EditMode, 
				loc_RI_Obligations_ColumnXpath_ViewMode, loc_RI_Obligations_DataRowXpath_ViewMode);
		className = this.getClass().getName();
		classObject = this.getClass();
	}


	@Test(priority =1,enabled= true,description = "This test case covers the of Obligation tab>UI")
	public void TC1_ObligationtabUI() throws Exception {

		System.out.println("*********************Start Testcase - TC1_ObligationtabUI*********************");
		/*assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);*/
		
		
		
		//Obligation Tab
		switchIntoFrame(frameParent2Xpath);
		if(ClientName.contains("AMCN")){
			if (Browser.equalsIgnoreCase("ie")) {
				WebElement ScrollTab1 = driver.findElement(By.xpath("//span/span[contains(text(),'Services')]"));
				scrollElementIntoView(ScrollTab1);
				Thread.sleep(3000);
			} else {
				WebElement ScrollTab1 = driver.findElement(By.xpath("//span/span[contains(text(),'Attributes')]"));
				scrollElementIntoView(ScrollTab1);
				Thread.sleep(3000);
			}
			
		}
		if (ClientName.contains("SKY")) {
			scrollElementIntoView(loc_Tab.replace("@var", "Options"));
			Thread.sleep(3000);		
		}
		
		clickOn(loc_Tab.replace("@var", "Obligations"), "Obligations TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//View Mode
		//TC_RI_ObT_002
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ObT_002");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsAppliesToKey +"']", RI_ObligationsAppliesTo.replace("*", ""), "Applies To   Field", RI_ObligationsAppliesTo, "innerHTML");
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_ObligationsEditButton, "value");
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//Edit Mode
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsAppliesToKey +"']", RI_ObligationsAppliesTo, "Applies To   Field", RI_ObligationsAppliesToKey, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsFromKey +"']", RI_ObligationsFrom, "Obligations From   Field", RI_ObligationsFrom, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsRepresentedIndividualFromKey +"']", RI_ObligationsRepresentedIndividualFrom, "Represented Individual(s) From Field", RI_ObligationsRepresentedIndividualFrom, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsRepresentedIndividualToKey +"']", RI_ObligationsRepresentedIndividualTo, "Represented Individual(s) To  Field", RI_ObligationsRepresentedIndividualTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsServiceKey +"']", RI_ObligationsService, "Service Field", RI_ObligationsService, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsToKey +"']", RI_ObligationsTo, "Obligations To   Field", RI_ObligationsTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsCategoryKey +"']", RI_ObligationsCategory, "Obligations Category Field", RI_ObligationsCategory, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsTypeKey +"']", RI_ObligationsType, "Obligations Type Field", RI_ObligationsType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsRelatedUsageKey +"']", RI_ObligationsRelatedUsage, "Related Usage Field", RI_ObligationsRelatedUsage, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsMediaKey +"']", RI_ObligationsMedia, "Obligations Media Field", RI_ObligationsMedia, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsUsageRightsKey +"']", RI_ObligationsUsageRights, "Usage Rights Field", RI_ObligationsUsageRights, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsTerritoryKey +"']", RI_ObligationsTerritory, "Territory Field", RI_ObligationsTerritory, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsPerpetuityKey +"']", RI_ObligationsPerpetuity, "Obligations Perpetuity Field", RI_ObligationsPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsStartDateKey +"']", RI_ObligationsStartDate, "Obligations Perpetuity Field", RI_ObligationsStartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsEndDateKey +"']", RI_ObligationsEndDate, "Obligations Perpetuity Field", RI_ObligationsEndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsStatusKey +"']", RI_ObligationsStatus, "Obligations Statusy Field", RI_ObligationsStatus, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsValueKey +"']", RI_ObligationsValue, "Obligations Value Field", RI_ObligationsValue, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsValueFulfilledKey +"']", RI_ObligationsValueFulfilled, "Obligation Value Fulfilled Field", RI_ObligationsValueFulfilled, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsCurrencyKey +"']", RI_ObligationsCurrency, "Currency Field", RI_ObligationsCurrency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_ObligationsNotesKey +"']", RI_ObligationsNotes, "Currency Field", RI_ObligationsNotes, "innerHTML");


		verifyTextMatches(Loc_NewButton, "Add Button", RI_ObligationsAddButton, "value");
		verifyTextMatches(loc_Delete, "Delete Button", RI_ObligationsDeleteButton, "value");
		verifyTextMatches(loc_Save, "Save Button", RI_ObligationsSaveButton, "value");
		verifyTextMatches(loc_Cancel, "Cancel Button", RI_ObligationsCancelButton, "value");

		//TC_RI_ObT_005
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ObT_005");
		clickUsingJSExecutor(Loc_NewButton, "Add Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//New Row
		verifyElementPresent(ObligationsRow1, "New Row 1");
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		verifyTextMatches(LocErrorMgs, "Alert Msg", RI_ObligationsWithoutSaveMsg);
		//Applies To
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		sendKeys(RI_ObligationsAppliesToInput,RI_ObligationsAppliesToData , "Applies To Input", RI_ObligationsAppliesTo);
		Enter();
		//Applies To Pick List
		keyboard();
	/*	clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsAppliesToImgKey, RI_ObligationsAppliesTo)+"/img", "Applies To pick List",RI_ObligationsAppliesTo); 
		rightIN.appliesTOPopUpWindow("TC_RI_ObT_008 To TC_RI_ObT_021", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);*/
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_ObligationsWithoutSaveMsg);
		//Obligation From
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsFromKey, RI_ObligationsFrom), "Obligations From",RI_ObligationsFrom); 	
		sendKeys(RI_ObligationsFromInput, RI_ObligationsFromData, "Obligations From Input", RI_ObligationsFrom);
		keyboard();
		//Obligation From Pick List
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsFromImgKey, "")+"/img", "Obligations From pick List",RI_ObligationsFrom); 
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(2000);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");

		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(2000);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(2000);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		if(ClientName.contains("AMCN")){
			clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
			Thread.sleep(2000);
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
			clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
			switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, " Cancel button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);

		//Obligation To
		if(Browser.contains("chrome")){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsToKey, RI_ObligationsTo), "Obligations To",RI_ObligationsTo); 
		}else{
			clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsToKey, RI_ObligationsTo), "Obligations To",RI_ObligationsTo); 
		}
		
		sendKeys(RI_ObligationsToInput, RI_ObligationsToData, "Obligations To Input", RI_ObligationsTo);
		//Obligation To Pick List
		keyboard();
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsToImgKey, RI_ObligationsTo)+"/img", "Obligations To pick List",RI_ObligationsTo); 
		switchIntoFrame(frameParent4Xpath);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(2000);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked, "All check box Checked");
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(2000);
		verifyElementNotPresent(loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked, "All check box Unchecked");
		if(ClientName.contains("AMCN")){
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, " Cancel button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		
		//Obligation Category
		if(Browser.contains("chrome")){
			clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsCategoryKey, RI_ObligationsCategory), "Obligations Category",RI_ObligationsCategory); 
		}else{
			clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsCategoryKey, RI_ObligationsCategory), "Obligations Category",RI_ObligationsCategory);
		}
		 
		sendKeys(RI_ObligationsCategoryInput, RI_ObligationsCategoryData, "Obligations Category Input", RI_ObligationsCategory);

		//Obligation Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsTypeKey, RI_ObligationsType), "Obligations Type",RI_ObligationsType); 
		sendKeys(RI_ObligationsTypeInput, RI_ObligationsTypeData, "Obligations Type Input", RI_ObligationsType);

		//Obligation Type Pick List
		keyboard();	
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsTypeImgKey, RI_ObligationsType)+"/img", "Obligations To pick List",RI_ObligationsType); 
		switchIntoFrame(frameParent4Xpath);
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
		if(ClientName.contains("AMCN")){
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "Applies Button", "");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Deselect All And Apply", RI_ObligationsapplywithoutselectMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");
		switchIntoFrame(frameParent4Xpath);
		}
		clickUsingJSExecutor(LocCancel, " Cancel button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		keyboard();
		//Related Usage
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), "Related Usage",RI_ObligationsRelatedUsage); 
		sendKeys(RI_ObligationsRelatedUsageInput, RI_ObligationsRelatedUsageData, "RelatedUsage Input", RI_ObligationsRelatedUsage);
	
		
		//Service(s)
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsServiceKey, RI_ObligationsService), "Service",RI_ObligationsService); 
		sendKeys(RI_ObligationsServiceInput, RI_ObligationsServiceData, "Service Input", RI_ObligationsService);
		
	
		
		//Media
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsMediaKey, RI_ObligationsMedia), "Media",RI_ObligationsMedia); 
		sendKeys(RI_ObligationsMediaInput, RI_ObligationsMediaData, "Media Input1", RI_ObligationsMedia);
		Enter();
		//Pick List
		keyboard();
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsMediaImgKey, RI_ObligationsMedia)+"/img", "Media To pick List",RI_ObligationsMedia); 
		rightIN.functionalityOfPopUpWindow("TC_RI_ObT_045 To TC_RI_ObT_053", RI_ObligationsMedia, "N/A");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		
		//Scroll
	    scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_ObligationsNotesKey, RI_ObligationsNotes), RI_ObligationsNotes);
	    Thread.sleep(5000);
		//Usage Rights
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), "UsageRights",RI_ObligationsUsageRights); 
		sendKeys(RI_ObligationsUsageRightsInput, RI_ObligationsUsageRightsData, "UsageRights Input", RI_ObligationsUsageRights);
		
		//Territory
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), "UsageRights",RI_ObligationsTerritory); 
		sendKeys(RI_ObligationsTerritoryInput, RI_ObligationsTerritoryData, "Territory Input", RI_ObligationsTerritory);
		keyboard();
		
		/*//Perpetuity
		if(!RI_ObligationsPerpetuity.contains("N/A")){
		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img", RI_ObligationsPerpetuity);
		}*/
	  
		/*
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img"," Check Box", RI_ObligationsPerpetuity);
		Thread.sleep(1000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img", "Check Box Checked", "Checked", "title");
		
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img"," Check Box", RI_ObligationsPerpetuity);
		Thread.sleep(1000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img", "Check Box Checked", "Unchecked", "title");
		
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img"," Check Box", RI_ObligationsPerpetuity);
		Thread.sleep(1000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsPerpetuityKey, RI_ObligationsPerpetuity)+"/img", "Check Box Checked", "Checked", "title");*/
		
		if(!RI_ObligationsStartDate.contains("N/A")){  //Not Applicable for VMN
		//Start Date
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsStartDateKey, RI_ObligationsStartDate), "Start Date",RI_ObligationsStartDate); 
		sendKeys(RI_ObligationsStartDateInput, RI_ObligationsStartDateData, "Start Date Input", RI_ObligationsStartDate);
		//End Date
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsEndDateKey, RI_ObligationsEndDate), "End Date",RI_ObligationsEndDate); 
		sendKeys(RI_ObligationsEndDateInput, RI_ObligationsEndDateData, "End Date Input", RI_ObligationsEndDate);
		keyboard();
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_ObligationsEndDateMsg);
		//End Date
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsEndDateKey, RI_ObligationsEndDate), "Obligation Status",RI_ObligationsEndDate); 
		sendKeys(RI_ObligationsEndDateInput, RI_ObligationsEndDateData1, "Media Input", RI_ObligationsEndDate);
		keyboard();
		}
	
		
	    //Obligation Status
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsStatusKey, RI_ObligationsStatus), "Obligation Status",RI_ObligationsStatus); 
		sendKeys(RI_ObligationsStatusInput, RI_ObligationsStatusData, "Obligations Status Input", RI_ObligationsStatus);
		keyboard();
		//Currency
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), "Currency",RI_ObligationsCurrency); 
		sendKeys(RI_ObligationsCountryInput, RI_ObligationsCurrencyData, "Currency Input", RI_ObligationsCurrency);
		
		
		
		//Obligation Value
		if(!RI_ObligationsValue.contains("N/A")){
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value",RI_ObligationsValue); 
		sendKeys(RI_ObligationsValueInput, RI_ObligationsValueData1, "Obligations Value Input", RI_ObligationsValue);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value", RI_ObligationsValueData1);
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value",RI_ObligationsValue); 
		sendKeys(RI_ObligationsValueInput, RI_ObligationsValueData2, "Obligations Value Input", RI_ObligationsValue);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value", RI_ObligationsValueData2);
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value",RI_ObligationsValue); 
		sendKeys(RI_ObligationsValueInput, RI_ObligationsValueData3, "Obligations Value Input", RI_ObligationsValue);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value", "");
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value",RI_ObligationsValue); 
		sendKeys(RI_ObligationsValueInput, RI_ObligationsValueData4, "Obligations Value Input", RI_ObligationsValue);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueKey, RI_ObligationsValue), "Obligations Value", RI_ObligationsValueData5);
		}
		
		//Obligation Fulfilled Value
		if(!RI_ObligationsValueFulfilled.contains("N/A")){
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligations Value Fulfilled Value",RI_ObligationsValueFulfilled); 
		sendKeys(RI_ObligationsObligationValueFulfilledInput, RI_ObligationsObligationValueFulfilledData1, "Obligation Value Fulfilled Value Input", RI_ObligationsValueFulfilled);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligation Value Fulfilled Value", RI_ObligationsObligationValueFulfilledData1);
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligations Value Fulfilled Value",RI_ObligationsValueFulfilled); 
		sendKeys(RI_ObligationsObligationValueFulfilledInput, RI_ObligationsObligationValueFulfilledData2, "Obligation Value Fulfilled Value Input", RI_ObligationsValueFulfilled);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligation Value Fulfilled Value", RI_ObligationsObligationValueFulfilledData2);
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligations Value Fulfilled Value",RI_ObligationsValueFulfilled); 
		sendKeys(RI_ObligationsObligationValueFulfilledInput, RI_ObligationsObligationValueFulfilledData3, "Obligation Value Fulfilled Value Input", RI_ObligationsValueFulfilled);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligation Value Fulfilled Value", "");
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligations Value Fulfilled Value",RI_ObligationsValueFulfilled); 
		sendKeys(RI_ObligationsObligationValueFulfilledInput, RI_ObligationsObligationValueFulfilledData4, "Obligation Value Fulfilled Value Input", RI_ObligationsValueFulfilled);
		keyboard();
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), "Obligation Value Fulfilled Value", RI_ObligationsObligationValueFulfilledData5);
		}

        /*//Notes  //No data for VMN
		//TC_RI_ObT_071
		ExecutionLog.Log("");
		ExecutionLog.Log("*****  Notes *****"); 
		ExecutionLog.Log("From Manual Test Step :TC_RI_ObT_071");
		keyboard();
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_ObligationsNotesKey, RI_ObligationsNotes)+"/img", "Notes",RI_ObligationsNotes);
		rightIN.noteFunctionlity("TC_RI_ObT_071");
		switchIntoFrame(frameParent3Xpath);*/
		
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		System.out.println("*********************End Testcase - TC1_ObligationtabUI*********************");
	
	}

	@Test(priority =2,enabled= true,description = "To verify behavior of fields in Rights In Obligation Tab - In view")
	public void TC2_ObligationtabView() throws Exception {
		System.out.println("*********************Start Testcase - TC2_ObligationtabView*********************");
		 //Search Deal
		 rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Obligations"), "Obligations TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
	       
		//View Mode 
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		System.out.println("*********************End Testcase - TC2_ObligationtabView*********************");
	}
	
	@Test(priority =3,enabled= true,description = "Verify Copy Functionality")
	public void TC3_ObligationtabCopy() throws Exception {
		System.out.println("*********************Start Testcase - TC3_ObligationtabCopy*********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		clickOn(loc_Tab.replace("@var", "Obligations"), "Obligations TAB");
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
		clickUsingJSExecutor(ObligationsRow1, "Selate 1 Row");
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
		verifyElementPresent(ObligationsRow1, "Row 1");
		verifyElementPresent(ObligationsRow2, "Row 2");
		verifyElementPresent(ObligationsRow3, "Row 3");
		verifyElementPresent(ObligationsRow4, "Row 4");
		verifyElementPresent(ObligationsRow5, "Row 5");
		
		clickOn(getLocator_EditTAB_DataRow("1", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		clickOn(ObligationsImg, "Row 1 Img");
		Thread.sleep(2000);
//		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", CreatedSeriesAssetTitle1), "Select "+CreatedSeriesAssetTitle1+"",RI_ObligationsAppliesTo); //Need to uncommnent
		Enter();
		
		clickOn(getLocator_EditTAB_DataRow("2", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		clickOn(ObligationsImg, "Row 2 Img");
		Thread.sleep(2000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_ObligationsEp101Data), "Select"+RI_ObligationsEp101Data+"",RI_ObligationsAppliesTo);
		Enter();
		
		clickOn(getLocator_EditTAB_DataRow("3", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		clickOn(ObligationsImg, "Row 3 Img");
		Thread.sleep(2000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_ObligationsEp102Data), "Select"+RI_ObligationsEp102Data+"",RI_ObligationsAppliesTo);
		Enter();
		
		clickOn(getLocator_EditTAB_DataRow("4", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		clickOn(ObligationsImg, "Row 4 Img");
		Thread.sleep(2000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_ObligationsEp201Data), "Select"+RI_ObligationsEp201Data+"",RI_ObligationsAppliesTo);
		Enter();
		
		clickOn(getLocator_EditTAB_DataRow("5", RI_ObligationsAppliesToKey, RI_ObligationsAppliesTo), "Applies To Row 1",RI_ObligationsAppliesTo); 
		clickOn(ObligationsImg, "Row 5 Img");
		Thread.sleep(2000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_ObligationsEp202Data), "Select"+RI_ObligationsEp202Data+"",RI_ObligationsAppliesTo);
		Enter();
		
		//Save
		clickUsingJSExecutor(loc_Save, "Save button", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//View Mode 

		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		//2nd RoW
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("2","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		//3rd Row
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("3","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		//4th
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("4","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		//5th
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("5","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		//6th
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsFromKey, RI_ObligationsFrom), RI_ObligationsFromData, "Obligation From", RI_ObligationsFrom,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsToKey, RI_ObligationsTo), RI_ObligationsToData, "Obligation To", RI_ObligationsTo,"val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsCategoryKey, RI_ObligationsCategory), RI_ObligationsCategoryData, "Obligation Category", RI_ObligationsCategory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsTypeKey, RI_ObligationsType), RI_ObligationsTypeData, "Obligation Type", RI_ObligationsType);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsRelatedUsageKey, RI_ObligationsRelatedUsage), RI_ObligationsRelatedUsageData, "Related Usage", RI_ObligationsRelatedUsage);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsServiceKey, RI_ObligationsService), RI_ObligationsServiceData, "Service", RI_ObligationsService);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsMediaKey, RI_ObligationsMedia), RI_ObligationsMediaData, "Obligation Media", RI_ObligationsMedia);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsStartDateKey, RI_ObligationsStartDate), RI_ObligationsStartDateData, "Obligation Star Date", RI_ObligationsStartDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsEndDateKey, RI_ObligationsEndDate), RI_ObligationsEndDateData1, "Obligation End Date", RI_ObligationsEndDate);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsStatusKey, RI_ObligationsStatus), RI_ObligationsStatusData, "Obligation Status", RI_ObligationsStatus);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsUsageRightsKey, RI_ObligationsUsageRights), RI_ObligationsUsageRightsData, "UsageRights ", RI_ObligationsUsageRights);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsTerritoryKey, RI_ObligationsTerritory), RI_ObligationsTerritoryData, "Territory", RI_ObligationsTerritory);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsValueKey, RI_ObligationsValue), RI_ObligationsValueData5, "Obligation Value", RI_ObligationsValue);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsValueFulfilledKey, RI_ObligationsValueFulfilled), RI_ObligationsObligationValueFulfilledData5, "Obligation ValueFulfilled", RI_ObligationsValueFulfilled);
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("6","2", RI_ObligationsCurrencyKey, RI_ObligationsCurrency), RI_ObligationsCurrencyData, "Obligation Country", RI_ObligationsCurrency);
		
		System.out.println("*********************End Testcase - TC3_ObligationtabCopy*********************");
	}
	
	@Test(priority =4,enabled= true,description = "Delete row functionality")
	public void TC4_ObligationsDeleteRows() throws Exception {
		System.out.println("*********************Start Testcase - TC4_ObligationsDeleteRows *********************");
		//search created deal
		//TC_RI_RP_001 To TC_RI_RP_012
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Obligations"), "Obligations TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(5000);
		if(Browser.contains("firefox")){
			clickUsingJSExecutor(Loc_EditButton2, "'Edit' Button");
		}else{
			clickOn(Loc_EditButton2, "'Edit' Button");
		}
		
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(AlertValidationMessgeText, 	RI_ObligationsSelectRowDeleteMsg, "Alert Message do not select the row and click Delete", RI_ObligationsSelectRowDeleteMsg);
		
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath");
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
	    clickOn(ObligationsRow1, "First row"); 
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
		clickOn(ObligationsRow1, "First row",RI_MediaRights_EditMode_ROW_NO_HeaderName);
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_ObligationsConfDeleteMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		System.out.println("*********************End Testcase - TC4_ObligationsDeleteRows *********************");
	}

	/**
	 * Starts from 1st Row
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_Obligations_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Obligations_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Obligations_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}

	/**
	 * Applies TO's Assets row: Starts from 0th Row
	 * rowNumber_Asset > =1,2,3
	 * 
	 * The Data of the respective Asset starts from 2nd Row	
	 * rowNumber_Data > =2,3,4
	 *  
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_ViewTAB_DataRow(String rowNumber_Asset, String rowNumber_Data, String KeyValueFromExcel, String HeadeNameFromExcel){
		String classValue = getClassValue(loc_RI_Obligations_ColumnXpath_ViewMode.replace("@var", rowNumber_Asset), KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_Obligations_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_Obligations_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
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

package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_BusinessTerms extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	
	
	
	public RI_BusinessTerms() {
		super(loc_RI_BusinessTerms_ColumnXpath_EditMode, loc_RI_BusinessTerms_DataRowXpath_EditMode, 
				loc_RI_BusinessTerms_ColumnXpath_ViewMode, loc_RI_BusinessTerms_DataRowXpath_ViewMode);
		className = this.getClass().getName();
	}
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";

	
	@Test(priority =1,enabled= true,description = "To verify all UI Elements of Rights In Business Terms Tab in View and Edit mode")
	public void TC1_BusinessTermUI() throws Exception {
		System.out.println("*********************Start Testcase - TC1_BusinessTermUI *********************");
		
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		
		//Business Term	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Business Terms"), "Business Terms TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		
		//View Mode
		//TC_RI_ER_002
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_002");
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_BusinessTermsEditButton, "value");
		verifyFieldValueOfHeader("//th[@key='" + RI_BusinessTerms_Key +"']", RI_BusinessTerms, "Business Terms  Field", RI_BusinessTerms, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_BusinessTermTermDescription_Key +"']", RI_BusinessTermTermDescriptionViewMode, "Term Description  Field", RI_BusinessTermTermDescriptionViewMode, "innerHTML");
		verifyTextMatches(RI_BusinessTermsSendReminder, "Send Reminder Button", RI_BusinessTermsSendReminderTitle, "alt");
		
		
		// Edit Mode
		//TC_RI_ER_003
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_003");
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyFieldValueOfHeader("//th[@key='" + RI_BusinessTerms_Key +"']", RI_BusinessTerms, "Business Terms  Field", RI_BusinessTerms, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_BusinessTermUseTemplate_Key +"']", RI_BusinessTermUseTemplate, "Business Terms  Field", RI_BusinessTermUseTemplate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_BusinessTermTermDescription_Key +"']", RI_BusinessTermTermDescription, "Term Description  Field", RI_BusinessTermTermDescription, "innerHTML");
		verifyTextMatches(LocAdd, "Add Button", RI_BusinessTermsAddButton, "value");
		verifyTextMatches(loc_Delete, "Delete Button", RI_BusinessTermsDeleteButton, "value");
		verifyTextMatches(loc_Save, "Save Button", RI_BusinessTermsSaveButton, "value");
		verifyTextMatches(loc_Cancel, "Cancel Button", RI_BusinessTermsCancelButton, "value");
		
		//TC_RI_ER_004
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_004");
		clickUsingJSExecutor(LocAdd, "Add Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		//New Row
		verifyElementPresent(loc_Businessterms1Row, "New Row 1");
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocErrorMgs);
		verifyTextMatches(LocErrorMgs, "Alert Msg", RI_BusinessTermsAlertMsg);
        Thread.sleep(3000);
		//Business Terms
        clickOn(getLocator_EditTAB_DataRow("1", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms Row 1",RI_BusinessTerms); 
		sendKeys(RI_BusinessTermsInput, RI_BusinessTermsData1, "Business Terms Input", RI_BusinessTerms);
		Enter();
		//Use Template
		clickOn(getLocator_EditTAB_DataRow("1", RI_BusinessTermUseTemplate_Key, RI_BusinessTermUseTemplate), "Use Template Row 1",RI_BusinessTermUseTemplate);
		clickOn(loc_RI_BusinessTermsUsetempletImg, "Business Terms UsetempletImg");
		Thread.sleep(2000);
		clickOn(RI_DeliveryScheduleDropdownValeSelect.replace("@var", RI_UseTemplateData), "Use Template");
		Enter();
		
		Thread.sleep(5000);
		
		//Term Description
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "Term Description Data", TermDescriptionData);
		
		//New Row 2
		clickUsingJSExecutor(LocAdd, "Add Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementPresent(loc_Businessterms2Row, "New Row 1");
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(LocErrorMgs, "Alert Msg", RI_BusinessTermsAlertMsg);
		//Business Terms
		clickOn(getLocator_EditTAB_DataRow("2", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms Row 2",RI_BusinessTerms); 
		sendKeys(RI_BusinessTermsInput, RI_BusinessTermsData2, "Business Terms Input", RI_BusinessTerms);
		Enter();
		//Term Description
		clickOn(getLocator_EditTAB_DataRow("2", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "Term Description Row 2",RI_BusinessTermTermDescription); 
		sendKeys(RI_TermDescriptionInput, TermDescriptionData1, "Term Description", RI_BusinessTermTermDescription);
	
		clickOn(getLocator_EditTAB_DataRow("2", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms Row 2",RI_BusinessTerms); 
		//Save
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(5000);
		//view Mode
		//1st Row
		
		verifyTextMatches(getLocator_ViewTAB_DataRow("1", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms data field", RI_BusinessTermsData2);
		verifyTextMatches(getLocator_ViewTAB_DataRow("1", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "Term Description data field", TermDescriptionData1);
		//2nd Row
		verifyTextMatches(getLocator_ViewTAB_DataRow("2", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms data field", RI_BusinessTermsData1);
		verifyTextMatches(getLocator_ViewTAB_DataRow("2", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "Term Description data field", TermDescriptionData);
		// Edit Mode
		//TC_RI_ER_015
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_015");
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		Thread.sleep(5000);
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Delete Alert Msg", RI_BusinessTermsDeleteAlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		//TC_RI_ER_018
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_018");
		clickUsingJSExecutor(LocAdd, "Add Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		Thread.sleep(5000);
		//New Row 3
		verifyElementPresent(loc_Businessterms3Row, "New Row 3");

		//Business Terms
		Thread.sleep(2000);
		clickOn(loc_Businessterms3Row, "New Row 3");
		Thread.sleep(1000);
		clickOn(getLocator_EditTAB_DataRow("3", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms Row 3",RI_BusinessTerms); 
		sendKeys(RI_BusinessTermsInput, RI_BusinessTermsData2, "Business Terms Input", RI_BusinessTerms);
		Enter();
		//Term Description
		clickOn(getLocator_EditTAB_DataRow("3", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "Term Description Row 3",RI_BusinessTermTermDescription); 
		sendKeys(RI_TermDescriptionInput, TermDescriptionData2, "Term Description", RI_BusinessTermTermDescription);
		
		clickOn(getLocator_EditTAB_DataRow("3", RI_BusinessTerms_Key, RI_BusinessTerms), "Business Terms Row 3",RI_BusinessTerms); 
		//TC_RI_ER_018
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_018");
		clickUsingJSExecutor(loc_Businessterms3Row, " Row 3");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Alert Msg", RI_BusinessTermsDeleteConfAlertMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		//Delete New Row 3
	
		moveMouse(getLocator_EditTAB_DataRow("3", RI_BusinessTermTermDescription_Key, RI_BusinessTermTermDescription), "3rd Row ");
		clickUsingJSExecutor(RI_BusinessTermsUndoButton, "Undo Button");
		
		verifyElementPresent(loc_Businessterms3Row, "New Row 3");
		//Save 
		//TC_RI_ER_022
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_022");
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Delete);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Businessterms1Row, " Row 1");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Alert Msg", RI_BusinessTermsDeleteConfAlertMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//View
		//Check Deleteed Row not prestent 
		
		System.out.println("*********************End Testcase - TC1_BusinessTermUI *********************");
	}
	
	@Test(priority =2,enabled= true,description = "Delete Functionality")
	public void TC2_BusinessTermDelete() throws Exception {
		System.out.println("*********************Start Testcase - TC2_BusinessTermDelete *********************");
	     //Search Deal
		 rightIN.searchCreatedDeal(CreatedDeal1);
		//Business Term Rights	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Business Terms"), "Business Terms TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		Thread.sleep(5000);
		clickUsingJSExecutor(loc_Businessterms1Row, "1St Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Alert Msg", RI_BusinessTermsDeleteConfAlertMsg);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		//Again
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		
		
		clickUsingJSExecutor(loc_Businessterms1Row, "1St Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Delete Alert Msg", RI_BusinessTermsDeleteConfAlertMsg);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Cancel Button At Confirm");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);

		System.out.println("*********************End Testcase - TC2_BusinessTermDelete *********************");
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
		String classValue = getClassValue(loc_RI_BusinessTerms_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_BusinessTerms_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_BusinessTerms_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		
		return locator;
	}

	/**
	 * Starts from 0th Row
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_ViewTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_BusinessTerms_ColumnXpath_ViewMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		if(hexClass.length > 2) {
			locator = loc_RI_BusinessTerms_DataRowXpath_ViewMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[hexClass.length-2] +"')]";	
		}
		locator = loc_RI_BusinessTerms_DataRowXpath_ViewMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
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

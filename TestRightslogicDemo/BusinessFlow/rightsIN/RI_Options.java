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
public class RI_Options extends MultiClient_SupportingFunctions {
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";

	
	public RI_Options() {
		super(loc_RI_Options_ColumnXpath_EditMode, loc_RI_Options_DataRowXpath_EditMode, 
				loc_RI_Options_ColumnXpath_ViewMode, loc_RI_Options_DataRowXpath_ViewMode);
		className = this.getClass().getName();
	}
	
	@Test(priority =1,enabled= true,description = "This test case covers the of Option tab>UI")
	public void TC1_OptiontabUI() throws Exception {	
		System.out.println("*********************Start Testcase - TC1_OptiontabUI*********************");
		ExecutionLog.Log(CreatedSeriesAssetTitle1);
		ExecutionLog.Log(CreatedDeal1);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
		//Option Tab
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		//View Mode
		//TC_RI_ER_02
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_02");
		ExecutionLog.Log("**********The below are columns and buttons in the window************");
		ExecutionLog.Log("Columns");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_AppliesToKey +"']", RI_Options_AppliesToViewMode, "ApplesTo Field", RI_Options_AppliesTo, "innerHTML");
		ExecutionLog.Log("Button");
		verifyTextMatches(Loc_EditButton2, "Edit Button", RI_Options_Edit,"Value");
		verifyTextMatches(Loc_RI_Options_SendReminder, "Send Reminder", RI_Options_SendReminder,"alt");
		//Edit Mode
		//TC_RI_ER_03
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_ER_03");
		ExecutionLog.Log("*****Verify the Headers in Edit Mode at the Options TAB*****"); 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_AppliesToKey +"']", RI_Options_AppliesTo, "ApplesTo Field", RI_Options_AppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_OptionTypeKey +"']", RI_Options_OptionType, "Option Type Field", RI_Options_OptionType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_ServiceTypeKey +"']", RI_Options_ServiceType, "Service Type Field", RI_Options_ServiceType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_NetworkKey +"']", RI_Options_Network, "Network Field", RI_Options_Network, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_MediaKey +"']", RI_Options_Media, "Media Field", RI_Options_Media, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_TerritoryKey +"']", RI_Options_Territory, "Territory Field", RI_Options_Territory, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_AddlPrgsTermsKey +"']", RI_Options_AddlPrgsTerms, "Add l PrgsTerms Field", RI_Options_AddlPrgsTerms, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_AddlPeriodKey +"']", RI_Options_AddlPeriod, "AddlPeriod Field", RI_Options_AddlPeriod, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_ProjectedExerciseDtKey +"']", RI_Options_ProjectedExerciseDt, "Projected Exercise Dt Field", RI_Options_ProjectedExerciseDt, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_NegotiationDeadlineKey +"']", RI_Options_NegotiationDeadline, "Negotiation Deadline Field", RI_Options_NegotiationDeadline, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_1stNegotiationKey +"']", RI_Options_1stNegotiation, "1st Negotiation Field", RI_Options_1stNegotiation, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_FirstRefusalKey +"']", RI_Options_FirstRefusal, "First Refusal Field", RI_Options_FirstRefusal, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_LastRefusalKey +"']", RI_Options_LastRefusal, "Last Refusal Field", RI_Options_LastRefusal, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_MaxBudgetIncKey +"']", RI_Options_MaxBudgetInc, "Max BudgetInc Field", RI_Options_MaxBudgetInc, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_OptPeriodLicenseFeeKey +"']", RI_Options_OptPeriodLicenseFee, "Opt Period License Fee Field", RI_Options_OptPeriodLicenseFee, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_OptionTermKey +"']", RI_Options_OptionTerm, "Option Term Field", RI_Options_OptionTerm, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_StatusKey +"']", RI_Options_Status, "Exercised Field", RI_Options_Status, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_FinalExercisedDtKey +"']", RI_Options_FinalExercisedDt, "Final Exercised Dt Field", RI_Options_FinalExercisedDt, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_GrantorKey +"']", RI_Options_Grantor, "Grantor Field", RI_Options_Grantor, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_RepresentedIndividualKey +"']", RI_Options_RepresentedIndividual, "Represented Individual Field", RI_Options_RepresentedIndividual, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_OutletsKey +"']", RI_Options_Outlets, "Outlets Field", RI_Options_Outlets, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_AddlPerpetuityKey +"']", RI_Options_AddlPerpetuity, "Addl Perpetuity Field", RI_Options_AddlPerpetuity, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + RI_Options_PerpetuityKey +"']", RI_Options_Perpetuity, "Perpetuity Field", RI_Options_Perpetuity, "innerHTML");
		//Button
		verifyTextMatches(loc_Copy, "Copy",RI_Options_CopyRow,"Value");
		verifyTextMatches(Loc_NewButton, "Add",RI_Options_Add,"Value");
		verifyTextMatches(loc_Delete, "Delete",RI_Options_Delete,"Value");
		verifyTextMatches(loc_Save, "Ok",RI_Options_Save,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",RI_Options_Cancel,"Value");
		//Add
		//TC_RI_OpT_005
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : //TC_RI_OpT_005");
		clickUsingJSExecutor(Loc_NewButton, "Add");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		verifyElementPresent(loc_RI_Options_Row1, "Row 1");
		//Applies To
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_AppliesToKey, RI_Options_AppliesTo), "AppliesTo Row 1",RI_Options_AppliesTo); 
		sendKeys(loc_RI_Options_AppliesToInput, RI_OptionsAppliesToData, "Applies To Input", RI_Options_AppliesTo);
		Thread.sleep(3000);
//		clickUsingJSExecutor(loc_RI_Options_Row1, "Row 1", RI_Options_AppliesTo);
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_OptionTypeKey, RI_Options_OptionType), "Support",RI_Options_OptionType); //Support
		//Save 
		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		WaitForElementPresent(LocErrorMgs);
		Thread.sleep(2000);
		verifyTextMatches(LocErrorMgs, "Error Msg", RI_OptionsErrorMsg);
		
		//Applies To Pick List
		clickOn(loc_RI_Options_AppliesImg, "AppliesTo  Pick List Row 1",RI_Options_AppliesTo); 
		rightIN.appliesTOPopUpWindow("TC_RI_OpT_002 To TC_RI_OpT_016 ", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		
		//Service Type
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_ServiceTypeKey, RI_Options_ServiceType), "Service Type Row 1",RI_Options_ServiceType); 
		sendKeys(loc_RI_Options_ServiceTypeInput, RI_OptionsServiceTypeData, "Service Type Input", RI_Options_ServiceType);
		clickOn(loc_RI_Options_Row1, "Row 1", RI_Options_ServiceType);//Support
		Thread.sleep(3000);
	
		//Options Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_OptionTypeKey, RI_Options_OptionType), "Options Type Row 1",RI_Options_OptionType); 
		sendKeys(loc_RI_Options_OptionsTypeInput, RI_OptionsOptionsTypeData, "Options Type Input", RI_Options_OptionType);
		Thread.sleep(3000);
	
		
		//Grantor
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_GrantorKey, RI_Options_Grantor), "Grantor Row 1",RI_Options_Grantor); 
		sendKeys(loc_RI_Options_GrantorInput, RI_OptionsGrantorData, "Grantor Input", RI_Options_Grantor);
		Thread.sleep(3000);
		
		//No Data For VMN
		//Represented Individual(s)
//		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_RepresentedIndividualKey, RI_Options_RepresentedIndividual), "Represented Individual(s) Row 1",RI_Options_RepresentedIndividual); 
//		sendKeys(loc_RI_Options_RepresentedIndividualInput, "", "Represented Individual(s) Input", RI_Options_RepresentedIndividual);
		

		//Network
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_NetworkKey, RI_Options_Network), "Options Type Row 1",RI_Options_Network); 
		sendKeys(loc_RI_Options_NetworkInput, RI_OptionsNetworkData, "Options Type Input", RI_Options_Network);
		Thread.sleep(3000);
		
		//Media Type
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_MediaKey, RI_Options_Media), "Media Row 1",RI_Options_Media); 
		sendKeys(loc_RI_Options_MediaInput, RI_OptionsMediaData, "Media Input", RI_Options_Media);
		
		
		//Media Pick List
		clickOn(loc_RI_Options_MediaImg, "Media Row 1",RI_Options_Media);
		rightIN.functionalityOfPopUpWindow("TC_RI_OpT_019 TC_RI_OpT_030", RI_Options_Media, RI_OptionsMediaData1);
		switchIntoFrame(frameParent3Xpath);
		
		//Outlets
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_OutletsKey, RI_Options_Outlets), "Outlets Row 1",RI_Options_Outlets); 
		sendKeys(loc_RI_Options_Outletsnput, RI_Options_OutletsData, "Outlets Input", RI_Options_Outlets);
		Thread.sleep(3000);
		
		//Territory
		clickOn(getLocator_EditTAB_DataRow("1", RI_Options_TerritoryKey, RI_Options_Territory), "Media Row 1",RI_Options_Territory); 
		sendKeys(loc_RI_Options_Territorynput, RI_OptionsTerritoryData, "Territory Input", RI_Options_Territory);
		
		
		//Territory Pick List
		clickOn(loc_RI_Options_TerritoryImg, "Territory Row 1",RI_Options_Territory);
		rightIN.functionalityOfPopUpWindow("TC_RI_OpT_031 TC_RI_OpT_042", RI_Options_Territory, "N/A");
		switchIntoFrame(frameParent3Xpath,RI_Options_Territory);
		
		
		//Addl Perpetuity
//		rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_Options_AddlPerpetuityKey, RI_Options_AddlPerpetuity), RI_Options_AddlPerpetuity);

		//TC_RI_OpT_043
		// Add'l Prgs/Terms
		if(!RI_Options_AddlPrgsTerms.contains("N/A")){
			doubleClick(getLocator_EditTAB_DataRow("1", RI_Options_AddlPrgsTermsKey, RI_Options_AddlPrgsTerms), "Add'l Prgs/Terms Row 1",RI_Options_AddlPrgsTerms);
			driver.switchTo().window(driver.getWindowHandle()); 
			verifyTextMatches(AlertValidationMessgeText, "Alert Msg Disabled fields for Add'l Prgs/Terms", RI_OptionsAddlPrgsTermsAlertMsg);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(2000);
			WaitForElementPresent(loc_Save);
		}
		//TC_RI_OpT_044
		//Add'l Period
		if(!RI_Options_AddlPeriod.contains("N/A")){
			if(ClientName.contains("AMCN")){
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_AddlPeriodKey, RI_Options_AddlPeriod)+"/img", "Add'l Period Row 1",RI_Options_AddlPeriod);
				driver.switchTo().window(driver.getWindowHandle()); 
				verifyTextMatches(AlertValidationMessgeText, "Alert Msg Disabled fields for Add'l Period", RI_OptionsAddlPrgsTermsAlertMsg);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
				switchIntoFrame(frameParent3Xpath);
				Thread.sleep(2000);
				WaitForElementPresent(loc_Save);
			}
			if(!RI_Options_AddlPeriod.contains("N/A")){
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_AddlPeriodKey, RI_Options_AddlPeriod)+"/img", "Add'l Period Row 1",RI_Options_AddlPeriod);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(OKButton);
				verifyTextMatches(Loc_RI_Options_LicPeriodDateFrom, "Lic Period Date From", RI_Options_LicPeriodDateFrom);
				verifyTextMatches(Loc_RI_Options_LicPeriodDateTo, "Lic Period DateT o", RI_Options_LicPeriodDateTo);
				verifyTextMatches(Loc_RI_Options_EventPeriod, "", "Event Period");
				verifyTextMatches(OKButton, "Ok button", RI_Options_OKButton,"value");
				verifyTextMatches(LocCancel, "Cancel Button", RI_Options_CancelButton,"value");
				//Lic. Period Date From
				clickOn(Loc_RI_Options_LicPeriodDateFromInput, "Lic. Period Date From", RI_Options_AddlPeriod);
				sendKeys_WithoutClear(Loc_RI_Options_LicPeriodDateFromInput, RI_Options_LicPeriodDateFromData, "Lic. Period Date From", RI_Options_AddlPeriod);
				//Lic. Period Date To  
				clickOn(Loc_RI_Options_LicPeriodDateToInput, "Lic. Period Date To", RI_Options_AddlPeriod);
				sendKeys_WithoutClear(Loc_RI_Options_LicPeriodDateToInput, RI_Options_LicPeriodDateToData1, "Lic. Period Date To", RI_Options_AddlPeriod);
				clickOn(OKButton, "Ok button");
				driver.switchTo().window(driver.getWindowHandle()); 
				verifyTextMatches(AlertValidationMessgeText, "Lic. Period Date  Alert Msg",AdditionalLicensePeriodErrorMsg );
				clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button Alert");
				switchIntoFrame(frameParent4Xpath);	
				//Lic. Period Date To  
				clickOn(Loc_RI_Options_LicPeriodDateToInput, "Lic. Period Date To", RI_Options_AddlPeriod);
				sendKeys_WithoutClear(Loc_RI_Options_LicPeriodDateToInput, RI_Options_LicPeriodDateFromData, "Lic. Period Date To", RI_Options_AddlPeriod);
				clickOn(OKButton, "Ok button", RI_Options_AddlPeriod);
				driver.switchTo().window(driver.getWindowHandle()); 
				verifyTextMatches(AlertValidationMessgeText, "Lic. Period Date  Alert Msg",AdditionalLicensePeriodErrorMsg );
				clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button Alert");

				switchIntoFrame(frameParent4Xpath);		
				//Lic. Period Date To  
				clickOn(Loc_RI_Options_LicPeriodDateToInput, "Lic. Period Date To", RI_Options_AddlPeriod);
				sendKeys_WithoutClear(Loc_RI_Options_LicPeriodDateToInput, RI_Options_LicPeriodDateToData2, "Lic. Period Date To", RI_Options_AddlPeriod);
				clickOn(OKButton, "Ok button", RI_Options_AddlPeriod);
				switchIntoFrame(frameParent3Xpath);	
				//Event Period

				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_AddlPeriodKey, RI_Options_AddlPeriod)+"/img", "Add'l Period Row 1",RI_Options_AddlPeriod);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(OKButton);

				clickOn(Loc_RI_Options_EventPeriodInput, "Event Period Input", RI_Options_AddlPeriod);
				sendKeys_WithoutClear(Loc_RI_Options_EventPeriodInput, RI_Options_EventPeriodData1, "Event Period Input", RI_Options_AddlPeriod);
				//Cancel
				clickUsingJSExecutor(LocCancel, "Cancel Button", RI_Options_AddlPeriod);
				switchIntoFrame(frameParent3Xpath);	
				Thread.sleep(2000);
				WaitForElementPresent(loc_Save);
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_AddlPeriodKey, RI_Options_AddlPeriod)+"/img", "Add'l Period Row 1",RI_Options_AddlPeriod);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(OKButton);
				clickOn(Loc_RI_Options_EventPeriod, "Event Period", RI_Options_AddlPeriod);
				sendKeys(Loc_RI_Options_EventPeriodInput, RI_Options_EventPeriodData2, "Event Period Input", RI_Options_AddlPeriod);
				selectDropdownValue(Loc_RI_Options_EventPeriodYearInput, "Event Period year", RI_Options_EventPeriodyear, RI_Options_AddlPeriod);
				clickUsingJSExecutor(OKButton, "Ok Button", RI_Options_AddlPeriod);
				switchIntoFrame(frameParent3Xpath);	

			}
			//*Status
			if(!RI_Options_Status.contains("N/A")){
				switchIntoFrame(frameParent3Xpath);
				scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_Options_FinalExercisedDtKey, RI_Options_FinalExercisedDt), RI_Options_Status);
				Thread.sleep(2000);
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_StatusKey, RI_Options_Status), "Status Field", RI_Options_Status);
				sendKeys(loc_RI_Options_StatusInput, RI_Options_ExercisedData, "Status Input", RI_Options_Status);
				Thread.sleep(2000);
				clickOn(loc_RI_Options_Row1, "Options1 Row");
			}
			//Projected Exercise Dt  
			if(Browser.contains("ie")){
				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_ProjectedExerciseDtImg, RI_Options_ProjectedExerciseDt)+"/img", "Projected Exercise Dt Img ", RI_Options_ProjectedExerciseDt);
			}else{
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_ProjectedExerciseDtImg, RI_Options_ProjectedExerciseDt)+"/img", "Projected Exercise Dt Img ", RI_Options_ProjectedExerciseDt);
			}

			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(Loc_CancelButton);
			clickUsingJSExecutor(Loc_CancelButton, "Term Event Dialog Windows Close", RI_Options_ProjectedExerciseDt);
			switchIntoFrame(frameParent3Xpath);

			//TC_RI_OpT_047
			//Save 
			if(!ClientName.contains("VMN")){
				clickUsingJSExecutor(loc_Save, "Save");
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				WaitForElementPresent(LocErrorMgs);
				Thread.sleep(2000);
				verifyTextMatches(LocErrorMgs, "Error Msg", RI_OptionsErrorMsg);
				switchIntoFrame(frameParent3Xpath);
			}
			//Projected Exercise Dt  
			clickOn(Loc_RI_Options_ProjectedExerciseDt, "ProjectedExerciseDt 1 Row ",RI_Options_ProjectedExerciseDt);
			sendKeys(loc_RI_Options_ProjectedExerciseDtInput, RI_Options_ProjectedExerciseDtData, "Projected Exercise Dt Input", RI_Options_ProjectedExerciseDt);
			clickOn(loc_RI_Options_Row1, "Options1 Row");


			//Negotiation Deadline
			clickOn(getLocator_EditTAB_DataRow("1", RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), "Negotiation Deadline Row 1",RI_Options_NegotiationDeadline);
			sendKeys(RI_Options_NegotiationDeadlineInput, RI_Options_NegotiationDeadlineData, "Negotiation Deadline Input", RI_Options_NegotiationDeadline);
			clickOn(loc_RI_Options_Row1, "Options 1 Row");


			//Save 
			clickUsingJSExecutor(loc_Save, "Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocErrorMgs);
			Thread.sleep(2000);
			verifyTextMatches(LocErrorMgs, "Error Msg", RI_OptionsNegotiationDateMsg);
			//Projected Exercise Dt  
			clickOn(getLocator_EditTAB_DataRow("1", RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), "Projected Exercise Dt Row 1",RI_Options_ProjectedExerciseDt);
			sendKeys(loc_RI_Options_ProjectedExerciseDtInput, RI_Options_ProjectedExerciseDtData, "Projected Exercise Dt Input", RI_Options_ProjectedExerciseDt);
			clickOn(loc_RI_Options_Row1, "Options 1 Row");
			//Negotiation Deadline
			clickOn(getLocator_EditTAB_DataRow("1", RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), "Negotiation Deadline Row 1",RI_Options_NegotiationDeadline);
			sendKeys(RI_Options_NegotiationDeadlineInput, RI_Options_NegotiationDeadlineData1, "Negotiation Deadline Input", RI_Options_NegotiationDeadline);
			clickOn(loc_RI_Options_Row1, "Options 1 Row");

			//Save 
			clickUsingJSExecutor(loc_Save, "Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);

			//View Mode 
			verifyTextMatches(getLocator_ViewTAB_DataRow("1","2", RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), "View Mode Projected Exercise Dt   ", RI_Options_ProjectedExerciseDtData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1","2",RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), "View Mode NegotiationDeadline   ", RI_Options_NegotiationDeadlineData1);

			//Edit
			clickUsingJSExecutor(Loc_EditButton2, "Edit Button", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_NewButton);
			Thread.sleep(5000);

			//Negotiation Deadline
			clickOn(getLocator_EditTAB_DataRow("1", RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), "Projected Exercise Dt Row 1",RI_Options_NegotiationDeadline);
			sendKeys(RI_Options_NegotiationDeadlineInput, RI_Options_NegotiationDeadlineData2, "Negotiation Deadline Input", RI_Options_NegotiationDeadline);
			Thread.sleep(2000);
		    clickOn(loc_RI_Options_Row1, "Options 1 Row");
		
			
			//1st Negotiation /Not Applicable for VMN
			if(!RI_Options_1stNegotiation.contains("N/A")){
			rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_Options_1stNegotiationKey, RI_Options_1stNegotiation), RI_Options_1stNegotiation);
			}
			//First Refusal
			if(!RI_Options_FirstRefusal.contains("N/A")){
			rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_Options_FirstRefusalKey, RI_Options_FirstRefusal), RI_Options_FirstRefusal);
			}
			//Last Refusal
			if(!RI_Options_LastRefusal.contains("N/A")){
			rightIN.checkBoxFunctionlity(getLocator_EditTAB_DataRow("1", RI_Options_LastRefusalKey, RI_Options_LastRefusal), RI_Options_LastRefusal);
			}
			//Max% Budget Inc
			if(!RI_Options_MaxBudgetInc.contains("N/A")){

				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Row 1",RI_Options_MaxBudgetInc);
				sendKeys(RI_Options_MaxBudgetIncInput, RI_Options_MaxBudgetIncData4, "MaxBudgetInc Input", RI_Options_MaxBudgetInc);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Value", RI_Options_MaxBudgetInc);

				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Row 1",RI_Options_MaxBudgetInc);
				sendKeys(RI_Options_MaxBudgetIncInput, RI_Options_MaxBudgetIncData1, "MaxBudgetInc Input", RI_Options_MaxBudgetInc);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Value", RI_Options_MaxBudgetInc);

				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Row 1",RI_Options_MaxBudgetInc);
				sendKeys(RI_Options_MaxBudgetIncInput, RI_Options_MaxBudgetIncData2, "MaxBudgetInc Input", RI_Options_MaxBudgetInc);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Value", RI_Options_MaxBudgetInc);

				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Row 1",RI_Options_MaxBudgetInc);
				sendKeys(RI_Options_MaxBudgetIncInput, RI_Options_MaxBudgetIncData5, "MaxBudgetInc Input", RI_Options_MaxBudgetInc);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_MaxBudgetIncKey, RI_Options_MaxBudgetInc), "Max% Budget Inc Value", RI_Options_MaxBudgetIncData6);
			}
			//TC_RI_OpT_066
			//Opt Period License Fee
			if(!RI_Options_OptPeriodLicenseFee.contains("N/A")){
				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Row 1",RI_Options_OptPeriodLicenseFee);
				sendKeys(RI_Options_OptPeriodLicenseFeeInput, OptPeriodLicenseFeeData1, "OptPeriodLicenseFee Input", RI_Options_OptPeriodLicenseFee);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Value", OptPeriodLicenseFeeData);
				Thread.sleep(2000);
				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Row 1",RI_Options_OptPeriodLicenseFee);
				sendKeys(RI_Options_OptPeriodLicenseFeeInput, OptPeriodLicenseFeeData2, "OptPeriodLicenseFee Input", RI_Options_OptPeriodLicenseFee);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Value", OptPeriodLicenseFeeData);
				Thread.sleep(2000);
				clickUsingJSExecutor(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Row 1",RI_Options_OptPeriodLicenseFee);
				sendKeys(RI_Options_OptPeriodLicenseFeeInput, OptPeriodLicenseFeeData3, "OptPeriodLicenseFee Input", RI_Options_OptPeriodLicenseFee);
				Enter();
				verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_Options_OptPeriodLicenseFeeKey, RI_Options_OptPeriodLicenseFee), "OptPeriodLicenseFee Value", OptPeriodLicenseFeeData4);
			}
			//Option Terms/Note For VMN (No data for VMN)
			
			/*clickOn(getLocator_EditTAB_DataRow("1", RI_Options_OptionTermKey, RI_Options_OptionTerm)+"/img", "OptionTerm Row 1",RI_Options_OptionTerm);
			rightIN.noteFunctionlity(RI_Options_NotesData);
			switchIntoFrame(frameParent3Xpath);*/
			
			if(!RI_Options_Status.contains("N/A")){
				switchIntoFrame(frameParent3Xpath);
				scrollElementIntoView(getLocator_EditTAB_DataRow("1", RI_Options_FinalExercisedDtKey, RI_Options_FinalExercisedDt), RI_Options_Status);
				Thread.sleep(2000);
				clickOn(getLocator_EditTAB_DataRow("1", RI_Options_StatusKey, RI_Options_Status), "Status Field", RI_Options_Status);
				sendKeys(loc_RI_Options_StatusInput, RI_Options_ExercisedData, "Status Input", RI_Options_Status);
				Thread.sleep(2000);
				clickOn(loc_RI_Options_Row1, "Options1 Row");
			}
			
			//Final Exercised Dt
			clickOn(getLocator_EditTAB_DataRow("1", RI_Options_FinalExercisedDtKey, RI_Options_FinalExercisedDt), "Final Exercised Dt Row 1",RI_Options_FinalExercisedDt);	
			sendKeys(Loc_RI_Options_FinalExercisedDtInput, RI_Options_FinalExercisedDtData, "Final Exercised Dt Input", RI_Options_FinalExercisedDt);
			clickOn(loc_RI_Options_Row1, "Options 1 Row");
			
			
			//Save 
			clickUsingJSExecutor(loc_Save, "Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_EditButton2);
		}
			System.out.println("*********************End Testcase - TC2_OptiontabUI *********************");
	}
	
	@Test(priority =2,enabled= true,description = "To verify behavior of fields in Rights In Option Tab - In View Mode")
	public void TC2_OptionsView() throws Exception {
		System.out.println("*********************Start Testcase - TC2_OptionsView *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_OptionTypeKey, RI_Options_OptionType), RI_OptionsOptionsTypeData, "View Mode Option Type", RI_Options_OptionType, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_GrantorKey, RI_Options_Grantor), RI_OptionsGrantorData, "View Mode Grantor", RI_Options_Grantor, "val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_MediaKey, RI_Options_Media), RI_OptionsMediaData, "View Mode Media Rights", RI_Options_Media, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_OutletsKey, RI_Options_Outlets), RI_Options_OutletsData, "View Mode Outlets", RI_Options_Outlets, "val");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_TerritoryKey, RI_Options_Territory), RI_OptionsTerritoryData, "View Mode Territory", RI_Options_Territory, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_AddlPeriodKey, RI_Options_AddlPeriod), RI_OptionsTermViewModeData, "View Mode Term For VMN and other AddlPeriod ", RI_Options_AddlPeriod, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), RI_Options_ProjectedExerciseDtData, "View Mode Projected ExerciseDt ", RI_Options_ProjectedExerciseDt, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), RI_Options_NegotiationDeadlineData2, "View Mode Negotiation Deadline ", RI_Options_NegotiationDeadline, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_StatusKey, RI_Options_Status), RI_Options_ExercisedData, "View Mode Status For VMN and Other Exercised ", RI_Options_Status, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1","2", RI_Options_FinalExercisedDtKey, RI_Options_FinalExercisedDt), RI_Options_FinalExercisedDtData, "View Mode Exercised Date ", RI_Options_FinalExercisedDt, "innerHTML");
	
		System.out.println("*********************End Testcase - TC2_OptionsView *********************");
	}

	@Test(priority =3,enabled= true,description = "Copy Row(s) Functionality")
	public void TC3_OptionsCopyRow() throws Exception {
		System.out.println("*********************Start Testcase - TC3_OptionsCopyRow *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		Thread.sleep(2000);
		//TC_RI_PR_002.
		ExecutionLog.Log("");
		ExecutionLog.Log("TC_RI_PR_002");
		clickUsingJSExecutor(loc_Copy, "Copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_OptionsCopyWithoutselectingRow);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		Thread.sleep(2000);
		clickOn(loc_RI_Options_Row.replace("@var", "1"), "Select 1 Row");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_Copy, "Copy Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(PromptAlertValidationMessgeText, "Copy No Row Msg", RI_OptionsCopRowMsg);
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_OptionsCopyAlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		sendKeys(loc_PromptBoxInput, RI_PromoRightsCopyData1, "Copy Number Row","");
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Copy Alert Msg", RI_OptionsCopyAlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		sendKeys(loc_PromptBoxInput, RI_PromoRightsCopyData2, "Copy Number Row","");
		clickUsingJSExecutor(loc_PromptOkButton, "OK Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "1"), "Row 1");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "2"), "Row 2");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "3"), "Row 3");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "4"), "Row 4");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "5"), "Row 5");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "6"), "Row 6");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "7"), "Row 7");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "8"), "Row 8");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "9"), "Row 9");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "10"), "Row 10");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "11"), "Row 11");
		//Save 
		clickUsingJSExecutor(loc_Save, "Save button", "");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_EditButton2);
		Thread.sleep(2000);
		//Edit 
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "1"), "Row 1");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "2"), "Row 2");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "3"), "Row 3");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "4"), "Row 4");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "5"), "Row 5");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "6"), "Row 6");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "7"), "Row 7");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "8"), "Row 8");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "9"), "Row 9");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "10"), "Row 10");
		verifyElementPresent(loc_RI_Options_Row.replace("@var", "11"), "Row 11");
		System.out.println("*********************End Testcase - TC3_OptionsCopyRow *********************");
	}

	@Test(priority =4,enabled= true,description = "Delete row functionality")
	public void TC4_OptionsDeleteRows() throws Exception {
		System.out.println("*********************Start Testcase - TC4_OptionsDeleteRows *********************");
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Options"), "Options TAB");
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
		verifyFieldValueOfHeader(AlertValidationMessgeText, RI_OptionsWithoutSelectingRowAlertMsg, "Alert Message do not select the row and click Delete","");
		clickUsingJSExecutor(OKAlertButtonXpath, "OKAlertButtonXpath");
		WaitForModalPanel();
		
		
		switchIntoFrame(frameParent3Xpath);
	    clickOn(loc_RI_Options_Row.replace("@var", "11"), "First row"); 
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_OptionsSelectingRowAlertMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", "");
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button At Confirm Pop-Up");
		
		
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_OptionsSelectingRowAlertMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", "");
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
		clickOn(loc_RI_Options_Row.replace("@var", "11"), "First row");
		doubleClick(loc_RI_MediaRights_EditMode_DeleteButton, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, 	RI_OptionsSelectingRowAlertMsg, "Alert Message ConfirmationToDeleteRow_ValidationMessage", RI_MediaRights_EditMode_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button At Confirm Pop-Up");
	
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Edit window");
		WaitForModalPanel();
		System.out.println("*********************End Testcase - TC4_OptionsDeleteRows *********************");
	}
	
	@Test(priority =5,enabled= true,description = "Delete an Asset from the Deal Navigator that has been used in Applies To")
	public void TC5_OptionsDeleteAnAssetFromTheDealNavigator() throws Exception {
		ExecutionLog.Log("*********************Start Testcase - TC5_Options *********************");
		//Search Created Deal 
		rightIN.searchCreatedDeal(CreatedDeal1);
		//TC_RI_ER_001
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_RI_ER_001");
		//Deal  Deal Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(DealNavigatorMenuBar, "Deal Navigator", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1));
		Thread.sleep(2000);
		clickOn(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1), "Select Asset from Asset navigator");
		Thread.sleep(1000);
		clickUsingJSExecutor(AssetNavigatorDeleteButton, "Delete Asset ", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Conf msg",RI_AseetNavigatorDeleteAssetConfMsg );
		clickUsingJSExecutor(ConfirmAlertButtonXpath,"Confirm Alert Button Xpath");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyElementNotPresent(EditngRightsAssetInAssetNavigator1.replace("@var", CreatedSeriesAssetTitle1), "Asset Deleted");
		clickUsingJSExecutor("name="+loc_OkButton, "Ok Button", "");	
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
		String classValue = getClassValue(loc_RI_Options_ColumnXpath_EditMode, KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Options_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Options_DataRowXpath_EditMode + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
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
		String classValue = getClassValue(loc_RI_Options_ColumnXpath_ViewMode.replace("@var", rowNumber_Asset), KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		String locator  = "";
		// using the class name to locate the added row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10 && hexValue.startsWith("i")) {
					locator = loc_RI_Options_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset) + "[" + rowNumber_Data + "]" + "//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value(RI_MediaRights.getLocator_ViewTAB_DataRow())";
			}
		} else {
			locator = loc_RI_Options_DataRowXpath_ViewMode.replace("@var", rowNumber_Asset)  + "[" + rowNumber_Data + "]" +  "//td[contains(@class,'"+ hexClass[1] +"')]";
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
	
	public void enterDatainAllFields(String rowNumber, String AssetName, Object... StartDate_EndDate) throws Exception { 
		
		/*switchIntoFrame(frameParent3Xpath);
		//Applies To
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(rowNumber, RI_Options_AppliesToKey, RI_Options_AppliesTo), "AppliesTo Row 1",RI_Options_AppliesTo); 
		sendKeys(loc_RI_Options_AppliesToInput, AssetName, "Applies To Input", RI_Options_AppliesTo);
		Thread.sleep(3000);
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(rowNumber, RI_Options_OptionTypeKey, RI_Options_OptionType), "Support",RI_Options_OptionType); //Support

		//Service Type
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(getLocator_EditTAB_DataRow(rowNumber, RI_Options_ServiceTypeKey, RI_Options_ServiceType), "Service Type Row 1",RI_Options_ServiceType); 
		sendKeys(loc_RI_Options_ServiceTypeInput, RI_OptionsServiceTypeData, "Service Type Input", RI_Options_ServiceType);
		clickOn(loc_RI_Options_Row1, "Row 1", RI_Options_ServiceType);//Support
		Thread.sleep(3000);

		//Options Type
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_OptionTypeKey, RI_Options_OptionType), "Options Type Row 1",RI_Options_OptionType); 
		sendKeys(loc_RI_Options_OptionsTypeInput, RI_OptionsOptionsTypeData, "Options Type Input", RI_Options_OptionType);
		Thread.sleep(3000);

		//Grantor
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_GrantorKey, RI_Options_Grantor), "Grantor Row 1",RI_Options_Grantor); 
		sendKeys(loc_RI_Options_GrantorInput, RI_OptionsGrantorData, "Grantor Input", RI_Options_Grantor);
		Thread.sleep(3000);

		//Network
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_NetworkKey, RI_Options_Network), "Options Type Row 1",RI_Options_Network); 
		sendKeys(loc_RI_Options_NetworkInput, RI_OptionsNetworkData, "Options Type Input", RI_Options_Network);
		Thread.sleep(3000);

		//Media Type
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_MediaKey, RI_Options_Media), "Media Row 1",RI_Options_Media); 
		sendKeys(loc_RI_Options_MediaInput, RI_OptionsMediaData, "Media Input", RI_Options_Media);

		//Outlets
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_OutletsKey, RI_Options_Outlets), "Outlets Row 1",RI_Options_Outlets); 
		sendKeys(loc_RI_Options_Outletsnput, RI_Options_OutletsData, "Outlets Input", RI_Options_Outlets);
		Thread.sleep(3000);

		//Territory
		clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_TerritoryKey, RI_Options_Territory), "Media Row 1",RI_Options_Territory); 
		sendKeys(loc_RI_Options_Territorynput, RI_OptionsTerritoryData, "Territory Input", RI_Options_Territory);
*/
		try {
			if(StartDate_EndDate[0].toString().length()>0) {
				//Projected Exercise Dt  
				System.out.println(); 
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), "Media Row",RI_Options_Territory); 
			//	clickOn(Loc_RI_Options_ProjectedExerciseDt, "ProjectedExerciseDt 1 Row ",RI_Options_ProjectedExerciseDt);
				sendKeys(loc_RI_Options_ProjectedExerciseDtInput, StartDate_EndDate[0].toString(), "Projected Exercise Dt Input", RI_Options_ProjectedExerciseDt);
				clickOn(loc_RI_Options_Row1, "Options1 Row");


				//Negotiation Deadline
				clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_NegotiationDeadlineKey, RI_Options_NegotiationDeadline), "Media Row",RI_Options_Territory); 
				sendKeys(RI_Options_NegotiationDeadlineInput, StartDate_EndDate[1].toString(), "Negotiation Deadline Input", RI_Options_NegotiationDeadline);
				clickOn(loc_RI_Options_Row1, "Options 1 Row");
			}
		} catch (Exception e) {
			//Projected Exercise Dt  
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), "Media Row",RI_Options_Territory); 
			sendKeys(loc_RI_Options_ProjectedExerciseDtInput, RI_Options_ProjectedExerciseDtData, "Projected Exercise Dt Input", RI_Options_ProjectedExerciseDt);
			clickOn(loc_RI_Options_Row1, "Options1 Row");


			//Negotiation Deadline
			clickOn(getLocator_EditTAB_DataRow(rowNumber, RI_Options_ProjectedExerciseDtKey, RI_Options_ProjectedExerciseDt), "Media Row",RI_Options_Territory); 
			sendKeys(RI_Options_NegotiationDeadlineInput, RI_Options_NegotiationDeadlineData, "Negotiation Deadline Input", RI_Options_NegotiationDeadline);
			clickOn(loc_RI_Options_Row1, "Options 1 Row");
		}
		






	}
	
}

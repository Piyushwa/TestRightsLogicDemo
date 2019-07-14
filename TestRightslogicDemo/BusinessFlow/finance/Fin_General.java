package finance;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import rightsIN.RI_ExhibitionRights;
import rightsIN.RI_MediaRights;
import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.Finance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class Fin_General extends DriverHelper {


	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_MediaRights mediaRights = new RI_MediaRights();
	RI_ExhibitionRights exhibitionRights = new RI_ExhibitionRights();
	Finance AquisitionFinance = new Finance();


	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	//String CreatedSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedSeriesAssetTitle = "AUT_AssetSeries_0227201711535";
	//String CreatedDeal = "AUT_Deal_" +formattedDate+"";
	String CreatedDeal = "AUT_Deal_0227201714813";
	
	/*public void create_PreRequisites_AllDeal_Assets() throws Exception
	{
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle);
		rightIN.createDeal(CreatedDeal);
		rightIN.searchCreatedDeal(CreatedDeal);
		rightIN.associateAssetWithDeal(CreatedDeal,CreatedSeriesAssetTitle);
		AquisitionFinance.MediaRightstabdata();
		AquisitionFinance.ExhibitionRightstabdata();
		AquisitionFinance.Paymenttab_Paymentframe();
		AquisitionFinance.Paymenttab_Assetvalueframe();
		AquisitionFinance.navigateToRightsINFinance();
		AquisitionFinance.AcceptRIDeal_ChangeDealGadget(CreatedDeal);
		
	}*/
	
	public Fin_General() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@Test(priority =1,enabled= true,description = "General Tab UI Verification")
	public void TC1_GeneralTab() throws Exception {
		
		AquisitionFinance.navigateToRightsINFinance();
		AquisitionFinance.Searchdeal_FinanceAgreementSearch(CreatedDeal);				
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(Loc_Fin_General_DealDetails_Legend);
		Thread.sleep(2000);
		
		//TC_3
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Different Frame label name of General tab************************");
		verifyFieldValueOfHeader(Loc_Fin_General_DealDetails_Legend, Fin_General_DealDetails_Legend , Fin_General_DealDetails_Legend, Fin_General_DealDetails_Legend);
		verifyFieldValueOfHeader(Loc_Fin_General_Party_Legend, Fin_General_Party_Legend , Fin_General_Party_Legend, Fin_General_Party_Legend);
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_Legend, Fin_General_Notes_Legend , Fin_General_Notes_Legend, Fin_General_Notes_Legend);
		verifyFieldValueOfHeader(Loc_Fin_General_AssetSummary_Legend, Fin_General_AssetSummary_Legend , Fin_General_AssetSummary_Legend, Fin_General_AssetSummary_Legend);
		verifyFieldValueOfHeader(Loc_Fin_General_Liabilities_Legend, Fin_General_Liabilities_Legend , Fin_General_Liabilities_Legend, Fin_General_Liabilities_Legend);
		
		//TC_4
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Field Label name in Deal Details Legend************************");
		verifyFieldValueOfHeader(Loc_Fin_General_DealID, Fin_General_DealID , Fin_General_DealID, Fin_General_DealID);
		verifyFieldValueOfHeader(Loc_Fin_General_DealDescription, Fin_General_DealDescription , Fin_General_DealDescription, Fin_General_DealDescription);
		verifyFieldValueOfHeader(Loc_Fin_General_DealName, Fin_General_DealName , Fin_General_DealName, Fin_General_DealName);
		verifyFieldValueOfHeader(Loc_Fin_General_DealType, Fin_General_DealType , Fin_General_DealType, Fin_General_DealType);
		verifyFieldValueOfHeader(Loc_Fin_General_ContractStatus, Fin_General_ContractStatus , Fin_General_ContractStatus, Fin_General_ContractStatus);
		verifyFieldValueOfHeader(Loc_Fin_General_CDES, Fin_General_CDES , Fin_General_CDES, Fin_General_CDES);
		verifyFieldValueOfHeader(Loc_Fin_General_ProjectStatus, Fin_General_ProjectStatus , Fin_General_ProjectStatus, Fin_General_ProjectStatus);
		verifyFieldValueOfHeader(Loc_Fin_General_DateExecuted, Fin_General_DateExecuted , Fin_General_DateExecuted, Fin_General_DateExecuted);
		verifyFieldValueOfHeader(Loc_Fin_General_DateEffective, Fin_General_DateEffective , Fin_General_DateEffective, Fin_General_DateEffective);
		verifyFieldValueOfHeader(Loc_Fin_General_ContractCurrency, Fin_General_ContractCurrency , Fin_General_ContractCurrency, Fin_General_ContractCurrency);
		verifyFieldValueOfHeader(Loc_Fin_General_BudgetLine, Fin_General_BudgetLine , Fin_General_BudgetLine, Fin_General_BudgetLine);
		verifyFieldValueOfHeader(Loc_Fin_General_Retired, Fin_General_FinancialStatus , Fin_General_FinancialStatus, Fin_General_FinancialStatus);
		
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Field Label name in Party Legend************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_PartyType_Key +"']", Fin_General_PartyType, "Party Type Field", Fin_General_PartyType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Party_Key +"']", Fin_General_Party, "Party Field", Fin_General_Party, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_ProfitCenter_Key +"']", Fin_General_ProfitCenter, "Profit Center Field", Fin_General_ProfitCenter, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Field Label name in Notes Legend************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Priority_Key +"']", Fin_General_Priority, "Priority Field", Fin_General_Priority, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Subject_Key +"']", Fin_General_Subject, "Subject Field", Fin_General_Subject, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_CreatedDate_Key +"']", Fin_General_CreatedDate, "Created Date Field", Fin_General_CreatedDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_DueDate_Key +"']", Fin_General_DueDate, "Due Date Field", Fin_General_DueDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_CreatedBy_Key +"']", Fin_General_CreatedBy, "Created By Field", Fin_General_CreatedBy, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Notes_Key +"']", Fin_General_Notes, "Notes Field", Fin_General_Notes, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Field Label name in Assets Summary - General Ledger Legend************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_AppliesTo_Key +"']", Fin_General_AV_AppliesTo, "Applies To Field", Fin_General_AV_AppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_Currency_Key +"']", Fin_General_AV_Currency, "Currency Field", Fin_General_AV_Currency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_AssetAmount_Key +"']", Fin_General_AV_AssetAmount, "Asset Amount Field", Fin_General_AV_AssetAmount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_AmortAmount_Key +"']", Fin_General_AV_AmortAmount, "Amort Amount Field", Fin_General_AV_AmortAmount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_NBV_Key +"']", Fin_General_AV_NBV, "Net Book Value Field", Fin_General_AV_NBV, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_AV_AsOf_Key +"']", Fin_General_AV_AsOf, "As Of Field", Fin_General_AV_AsOf, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Field Label name in Liabilities Legend************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_PaymentDescription_Key +"']", Fin_General_Liabilities_PaymentDescription, "Payment Description Field", Fin_General_Liabilities_PaymentDescription, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_DueDate_Key +"']", Fin_General_Liabilities_DueDate, "Due Date Field", Fin_General_Liabilities_DueDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_Currency_Key +"']", Fin_General_Liabilities_Currency, "Currency Field", Fin_General_Liabilities_Currency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_Amount_Key +"']", Fin_General_Liabilities_Amount, "Amount Field", Fin_General_Liabilities_Amount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_Paid_Key +"']", Fin_General_Liabilities_Paid, "Paid Field", Fin_General_Liabilities_Paid, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_PaidDate_Key +"']", Fin_General_Liabilities_PaidDate, "Paid Date Field", Fin_General_Liabilities_PaidDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_General_Liabilities_CheckNumber_Key +"']", Fin_General_Liabilities_CheckNumber, "Check Number Field", Fin_General_Liabilities_CheckNumber, "innerHTML");
		
		//Verify the Notes Functionality
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Notes Functionality************************");
		clickUsingJSExecutor(loc_AddNote, "Add Button of Note");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Notes Popup Window UI************************");
		//Field Labels
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_Priority, Fin_General_Notes_Priority , Fin_General_Notes_Priority, Fin_General_Notes_Priority);
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_DueDate, Fin_General_Notes_DueDate , Fin_General_Notes_DueDate, Fin_General_Notes_DueDate);
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_Subject, Fin_General_Notes_Subject , Fin_General_Notes_Subject, Fin_General_Notes_Subject);
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_Notes, Fin_General_Notes_Notes , Fin_General_Notes_Notes, Fin_General_Notes_Notes);		
		
		//Button
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_OK, Fin_General_Notes_OK, "Ok Button", Fin_General_Notes_OK, "value");
		verifyFieldValueOfHeader(Loc_Fin_General_Notes_Cancel, Fin_General_Notes_Cancel, "Cancel Button", Fin_General_Notes_Cancel, "value");
		
		clickUsingJSExecutor(Loc_Fin_General_Notes_Cancel, "Cancel Note button");
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(1000);
		AddNote();
		switchIntoFrame(frameParent2Xpath);
		sleepTime(3);
		
		//RI Notes are not editable
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the RI Notes in General tab************************");
		doubleClick(Loc_Fin_General_RINotesLocator, "RghtsIn Notes","");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(2000);
		
		//Check with sipan for non editable check
		
		clickUsingJSExecutor(Loc_Fin_General_Notes_Cancel, "Cancel Note button");
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(1000);
		
		//Rights Notes are not Editable
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify that RI Notes cannot be deleted in Finance General tab************************");
		clickOn(Loc_Fin_General_RINotesLocator, "RightsIn Notes","");
		clickUsingJSExecutor(loc_RemoveNoteIcon, "Remove Note", Note_Status);
		driver.switchTo().window(driver.getWindowHandle());
		WaitForElementPresent(By.xpath(OKAlertXpath));
		String ExpectedText = "You are Not Authorized to remove this Note.";
		verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 
		switchIntoFrame(frameParent2Xpath);
		
		//User is able to delete the Finance Notes
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify that RI Notes cannot be deleted in Finance General tab************************");
		clickOn(Loc_Fin_General_FinNotesLocator, "Finance Notes","");
		clickUsingJSExecutor(loc_RemoveNoteIcon, "Remove Note", Note_Status);
		driver.switchTo().window(driver.getWindowHandle());
		ExpectedText = "Are you sure you want to delete selected row(s)?";	
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, ExpectedText, "Alert Message", Note_Status);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up", Note_Status);
		switchIntoFrame(frameParent2Xpath);
		
		//Reminder functionality
		//User is able to delete the Finance Notes
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verify the Reminder Functionality on General Tab************************");
		clickOn(Loc_Fin_General_Reminder,"Reminder Icon","");
		WaitForModalPanel();
		Thread.sleep(1000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(1000);
		scrollElementIntoView(loc_Fin_ChangedealGadget_Reminder_User);
		Thread.sleep(1000);	
	
	}
	
	@Test(priority =2,enabled= true,description = "Payment Tab UI Verification")
	public void TC2_PaymentTab() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		verifyFieldValueOfHeader(Loc_Fin_Payment_Payables, Fin_Payment_Payables , Fin_Payment_Payables, Fin_Payment_Payables);
		verifyFieldValueOfHeader(Loc_Fin_Payment_AssetValues, Fin_Payment_AssetValues , Fin_Payment_AssetValues, Fin_Payment_AssetValues);
		verifyFieldValueOfHeader(Loc_Fin_Payment_CollapseAll, Fin_Payment_CollapseAll , Fin_Payment_CollapseAll, Fin_Payment_CollapseAll);
		verifyFieldValueOfHeader(Loc_Fin_Payment_Paymentsexpand, Fin_Payment_Paymentsexpand , Fin_Payment_Paymentsexpand, Fin_Payment_Paymentsexpand);
		verifyFieldValueOfHeader(Loc_Fin_Payment_Assetvalueexpand, Fin_Payment_Assetvalueexpand , Fin_Payment_Assetvalueexpand, Fin_Payment_Assetvalueexpand);
		switchIntoFrame(frameParent2Xpath);
		
	}
	
	@Test(priority =3,enabled= true,description = "Exhibition Tab UI Verification")
	public void TC2_ExhibitionTab() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_Exhibition_showallrows);
		verifyFieldValueOfHeader(Loc_Fin_Exhibition_showallrows, Fin_Exhibition_showallrows , Fin_Exhibition_showallrows, Fin_Exhibition_showallrows);
		verifyFieldValueOfHeader(Loc_Fin_Exhibition_Expandall, Fin_Exhibition_Expandall , Fin_Exhibition_Expandall, Fin_Exhibition_Expandall);
		verifyFieldValueOfHeader(Loc_Fin_Exhibition_Collapseall, Fin_Exhibition_Collapseall , Fin_Exhibition_Collapseall, Fin_Exhibition_Collapseall);
		
		
		
	}
	
	//Utility Methods for General tab
	public void AddNote() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		if (!Note_Status.contains("N/A")) {
			clickUsingJSExecutor(loc_AddNote, "Add Button of Note");
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(2000);
			sendKeys(loc_NotePriority, Fin_General_Notes_Priority_data, "Priority", "");
			sendKeys(Loc_Fin_General_Notes_DueDateinput, Fin_General_Notes_DueDate_data, "Due datw", "");
			sendKeys(loc_NoteSubject, Fin_General_Notes_Subject_data, "Subject", "");
			sendKeys(loc_NoteBody, Fin_General_Notes_Notes_data, "Notes TextField", "");
			clickOn(OKButton, "OK button");
			Thread.sleep(2000);
		}
	}
	
}

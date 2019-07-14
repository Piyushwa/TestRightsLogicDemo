package finance;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class Fin_TitleValuation extends DriverHelper {


	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	RI_MediaRights mediaRights = new RI_MediaRights();
	RI_ExhibitionRights exhibitionRights = new RI_ExhibitionRights();
	Finance AquisitionFinance = new Finance();


	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal = "AUT_Deal_" +formattedDate+"";
	
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
	
	public Fin_TitleValuation() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@Test(priority =1,enabled= true,description = "Title Valuation Tab UI Verification")
	public void TC1_TitleValuationUI() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Title Valuation"), "Title Valuation Tab");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_TV_TitlevalueLegend);
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field Label name in Title Valuation Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_TV_TitlevalueLegend, Fin_TV_TitlevalueLegend , Fin_TV_TitlevalueLegend, Fin_TV_TitlevalueLegend);
		verifyFieldValueOfHeader(Loc_Fin_TV_DealNamelabel, Fin_TV_DealNamelabel , Fin_TV_DealNamelabel, Fin_TV_DealNamelabel);
		verifyFieldValueOfHeader(Loc_Fin_TV_NBVINGL, Fin_TV_NBVINGL , Fin_TV_NBVINGL, Fin_TV_NBVINGL);
		verifyFieldValueOfHeader(Loc_Fin_TV_NBVAsOf, Fin_TV_NBVAsOf , Fin_TV_NBVAsOf, Fin_TV_NBVAsOf);
		verifyFieldValueOfHeader(Loc_Fin_TV_GDV, Fin_TV_GDV , Fin_TV_GDV, Fin_TV_GDV);
		verifyFieldValueOfHeader(Loc_Fin_TV_AmortizationTrigger, Fin_TV_AmortizationTrigger , Fin_TV_AmortizationTrigger, Fin_TV_AmortizationTrigger);
		verifyFieldValueOfHeader(Loc_Fin_TV_Escalator, Fin_TV_Escalator , Fin_TV_Escalator, Fin_TV_Escalator);
		verifyFieldValueOfHeader(Loc_Fin_TV_Apply, Fin_TV_Apply, "Apply button", Fin_TV_Apply, "value");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of Icons in Title Valuation Tab************************");
		verifyElementPresent(Loc_Fin_TV_Exporticon, "Export icon", Fin_TV_Exporticon);
		verifyElementPresent(Loc_Fin_TV_Remindericon, "Reminder icon", Fin_TV_Remindericon);
		verifyElementPresent(Loc_Fin_TV_AutoAppovalIcon, "Auto Approval icon", Fin_TV_AutoAppovalIcon);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of Field Header Name at Deal Level in Title Valuation Tab************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_AppliesTo_Key +"']", Fin_TV_AppliesTo, "Applies To Field", Fin_TV_AppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_WindowName_Key +"']", Fin_TV_WindowName, "Window Name Field", Fin_TV_WindowName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_WindowType_Key +"']", Fin_TV_WindowType, "Window Type Field", Fin_TV_WindowType, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_Currency_Key +"']", Fin_TV_Currency, "Currency Field", Fin_TV_Currency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_Contractual_Key +"']", Fin_TV_Contractual, "Contractual Field", Fin_TV_Contractual, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_Liability_Key +"']", Fin_TV_Liability, "Liability Field", Fin_TV_Liability, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_ExhibitionFrom_Key +"']", Fin_TV_ExhibitionFrom, "Exhibition From Field", Fin_TV_ExhibitionFrom, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_ExhibitionTo_Key +"']", Fin_TV_ExhibitionTo, "Exhibition To Field", Fin_TV_ExhibitionTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_FinancialFrom_Key +"']", Fin_TV_FinancialFrom, "Financial From Field", Fin_TV_FinancialFrom, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_FinancialTo_Key +"']", Fin_TV_FinancialTo, "Financial To Field", Fin_TV_FinancialTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_ProfitCenter_Key +"']", Fin_TV_ProfitCenter, "Profit Center Field", Fin_TV_ProfitCenter, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_AmortizationTrigger_Key +"']", Fin_TV_AmortizationTrigger, "Amortization Trigger Field", Fin_TV_AmortizationTrigger, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_Escalator_Key +"']", Fin_TV_Escalator, "Escalator Field", Fin_TV_Escalator, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_Notes_Key +"']", Fin_TV_Notes, "Notes Field", Fin_TV_Notes, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_GLReleaseDate_Key +"']", Fin_TV_GLReleaseDate, "GL Release Date Field", Fin_TV_GLReleaseDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_TV_AmortType_Key +"']", Fin_TV_AmortType, "Amort Type Field", Fin_TV_AmortType, "innerHTML");
		
		clickOn(Loc_Fin_TV_Title, "Title", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_TV_TitlevalueLegend);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field Label name in Title Valuation Tab at Title level************************");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_HideExcludeRows, Fin_TVAtTitleLevel_HideExcludeRows , Fin_TVAtTitleLevel_HideExcludeRows, Fin_TVAtTitleLevel_HideExcludeRows);
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_WriteDown, Fin_TVAtTitleLevel_WriteDown, "WriteDown button", Fin_TVAtTitleLevel_WriteDown, "value");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_Save, Fin_TVAtTitleLevel_Save, "Save button", Fin_TVAtTitleLevel_Save, "value");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field of Parent Header Name in Title Valuation Tab at Title level************************");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_AppliesTo_Key +"']", Fin_TVAtTitleLevel_AppliesTo, "Applies To Field", Fin_TVAtTitleLevel_AppliesTo, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_Currency_Key +"']", Fin_TVAtTitleLevel_Currency, "Currency Field", Fin_TVAtTitleLevel_Currency, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_Contractual_Key +"']", Fin_TVAtTitleLevel_Contractual, "Contractual Field", Fin_TVAtTitleLevel_Contractual, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_Liability_Key +"']", Fin_TVAtTitleLevel_Liability, "Liability Field", Fin_TVAtTitleLevel_Liability, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_ProfitCenter_Key +"']", Fin_TVAtTitleLevel_ProfitCenter, "ProfitCenter Field", Fin_TVAtTitleLevel_ProfitCenter, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_AmortizationTrigger_Key +"']", Fin_TVAtTitleLevel_AmortizationTrigger, "Amortization Trigger Field", Fin_TVAtTitleLevel_AmortizationTrigger, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_Escalator_Key +"']", Fin_TVAtTitleLevel_Escalator, "Escalator Field", Fin_TVAtTitleLevel_Escalator, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_AmortType_Key +"']", Fin_TVAtTitleLevel_AmortType, "Amort Type Field", Fin_TVAtTitleLevel_AmortType, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_TVAtTitleLevel_ParentHeader+"//th[@key='" + Fin_TVAtTitleLevel_Notes_Key +"']", Fin_TVAtTitleLevel_Notes, "Notes Field", Fin_TVAtTitleLevel_Notes, "innerHTML");
		
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field of Child Header Name in Title Valuation Tab at Title level************************");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_WindowName_Key,Fin_TVAtChildTitleLevel_WindowName ), Fin_TVAtChildTitleLevel_WindowName, "Window Name Field", Fin_TVAtChildTitleLevel_WindowName, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_WindowType_Key,Fin_TVAtChildTitleLevel_WindowType ), Fin_TVAtChildTitleLevel_WindowType, "Window Type Field", Fin_TVAtChildTitleLevel_WindowType, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_ExhibitionFrom_Key,Fin_TVAtChildTitleLevel_ExhibitionFrom ), Fin_TVAtChildTitleLevel_ExhibitionFrom, "Exhibition From Field", Fin_TVAtChildTitleLevel_ExhibitionFrom, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_ExhibitionTo_Key,Fin_TVAtChildTitleLevel_ExhibitionTo ), Fin_TVAtChildTitleLevel_ExhibitionTo, "Exhibition To Field", Fin_TVAtChildTitleLevel_ExhibitionTo, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_FinancialFrom_Key,Fin_TVAtChildTitleLevel_FinancialFrom ), Fin_TVAtChildTitleLevel_FinancialFrom, "Financial From Field", Fin_TVAtChildTitleLevel_FinancialFrom, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_FinancialTo_Key,Fin_TVAtChildTitleLevel_FinancialTo ), Fin_TVAtChildTitleLevel_FinancialTo, "Financial To Field", Fin_TVAtChildTitleLevel_FinancialTo, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_Currency_Key,Fin_TVAtChildTitleLevel_Currency ), Fin_TVAtChildTitleLevel_Currency, "Currency Field", Fin_TVAtChildTitleLevel_Currency, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_Contractual_Key,Fin_TVAtChildTitleLevel_Contractual ), Fin_TVAtChildTitleLevel_Contractual, "Contractual Field", Fin_TVAtChildTitleLevel_Contractual, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_CurrentNBV_Key,Fin_TVAtChildTitleLevel_CurrentNBV ), Fin_TVAtChildTitleLevel_CurrentNBV, "Current NBV Field", Fin_TVAtChildTitleLevel_CurrentNBV, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_AmortizationTrigger_Key,Fin_TVAtChildTitleLevel_AmortizationTrigger ), Fin_TVAtChildTitleLevel_AmortizationTrigger, "Amortization Trigger Field", Fin_TVAtChildTitleLevel_AmortizationTrigger, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_Notes_Key,Fin_TVAtChildTitleLevel_Notes ), Fin_TVAtChildTitleLevel_Notes, "Notes Field", Fin_TVAtChildTitleLevel_Notes, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_TVAtChildTitleLevel_GLReleaseDate_Key,Fin_TVAtChildTitleLevel_GLReleaseDate ), Fin_TVAtChildTitleLevel_GLReleaseDate, "GL Release Date Field", Fin_TVAtChildTitleLevel_GLReleaseDate, "innerHTML");

}
	
	//Utility Methods for Title valuation Tab
	/**
	 * 
	 * @param rowNumber Row start from 3,5,7, etc..
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_ChildHeaderRow(String rowNumber,String KeyValueFromExcel,String HeadeNameFromExcel )
	{		
	String locator =   Loc_Fin_TVAtTitleLevel_ChildHeader + "[" + rowNumber +"]//th[@key= '"+ KeyValueFromExcel +"']";
		return locator;
	}
	
}

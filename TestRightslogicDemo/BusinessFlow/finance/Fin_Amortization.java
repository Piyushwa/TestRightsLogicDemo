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
public class Fin_Amortization extends DriverHelper {


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
	
	public Fin_Amortization() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@Test(priority =1,enabled= true,description = "Amortization Tab UI Verification")
	public void TC1_AmortizationUI() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Amortization"), "Amortization Tab");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_Amort_Legend);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field Label name in Amortization Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_Amort_CollapseAll, Fin_Amort_CollapseAll , Fin_Amort_CollapseAll, Fin_Amort_CollapseAll);
		verifyFieldValueOfHeader(Loc_Fin_Amort_ExpandAmort, Fin_Amort_ExpandAmort , Fin_Amort_ExpandAmort, Fin_Amort_ExpandAmort);
		verifyFieldValueOfHeader(Loc_Fin_Amort_ExpandAmortSchedule, Fin_Amort_ExpandAmortSchedule , Fin_Amort_ExpandAmortSchedule, Fin_Amort_ExpandAmortSchedule);		
		verifyFieldValueOfHeader(Loc_Fin_Amort_DealNameLabel, Fin_Amort_DealNameLabel , Fin_Amort_DealNameLabel, Fin_Amort_DealNameLabel);
		verifyFieldValueOfHeader(Loc_Fin_Amort_TotalDealValue, Fin_Amort_TotalDealValue , Fin_Amort_TotalDealValue, Fin_Amort_TotalDealValue);
		verifyFieldValueOfHeader(Loc_Fin_Amort_TotalAmortReleasetoGL, Fin_Amort_TotalAmortReleasetoGL , Fin_Amort_TotalAmortReleasetoGL, Fin_Amort_TotalAmortReleasetoGL);
		verifyFieldValueOfHeader(Loc_Fin_Amort_AsOfDate, Fin_Amort_AsOfDate , Fin_Amort_AsOfDate, Fin_Amort_AsOfDate);
		verifyFieldValueOfHeader(Loc_Fin_Amort_Legend, Fin_Amort_Legend , Fin_Amort_Legend, Fin_Amort_Legend);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Icons in Amortization Tab************************");
		verifyElementPresent(Loc_Fin_Amort_ExportIcon, "Export icon", Fin_Amort_ExportIcon);
		verifyElementPresent(Loc_Fin_Amort_ReminderIcon, "Reminder icon", Fin_Amort_ReminderIcon);
		verifyElementPresent(Loc_Fin_Amort_StraightLineAmortIcon, "Apply StraightLine Amortization Icon", Fin_Amort_StraightLineAmortIcon);
		verifyElementPresent(Loc_Fin_Amort_AutoAppovalIcon, "Auto Approval Icon", Fin_Amort_AutoAppovalIcon);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Parent Header Field Name in Amortization Tab************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Amort_Appliesto_Key +"']", Fin_Amort_Appliesto, "Applies To Field", Fin_Amort_Appliesto, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Amort_Currency_Key +"']", Fin_Amort_Currency, "Currency Field", Fin_Amort_Currency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Amort_Contractual_Key +"']", Fin_Amort_Contractual, "Contractual Field", Fin_Amort_Contractual, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Amort_NBVInGL_Key +"']", Fin_Amort_NBVInGL, "NBV in GL Field", Fin_Amort_NBVInGL, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Amort_ProfitCenter_Key +"']", Fin_Amort_ProfitCenter, "Profit Center Field", Fin_Amort_ProfitCenter, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Child Header Field Name in Amortization Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_Amort_ChildHeaderRow+"//th[@key='" + Fin_Amort_Year_Key +"']", Fin_Amort_Year, "Year Field", Fin_Amort_Year, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_Amort_ChildHeaderRow+"//th[@key='" + Fin_Amort_Amount_Key +"']", Fin_Amort_Amount, "Amount Field", Fin_Amort_Amount, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_Amort_ChildHeaderRow+"//th[@key='" + Fin_Amort_ReleasedtoGL_Key +"']", Fin_Amort_ReleasedtoGL, "Released to GL Field", Fin_Amort_ReleasedtoGL, "innerHTML");
		
		clickOn(Loc_Fin_AmortTitle, "Title","" );
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_AmortatTitleLevel_Legend);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Button Label Name in Amortization Tab at Title Level************************");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_Savebutton, Fin_AmortatTitleLevel_Savebutton, "Save button", Fin_AmortatTitleLevel_Savebutton, "value");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Parent Header Field Name in Amortization Tab at Title Level************************");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_Appliesto_Key +"']", Fin_AmortatTitleLevel_Appliesto, "Applies To Field", Fin_AmortatTitleLevel_Appliesto, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_FinancialLifeFrom_Key +"']", Fin_AmortatTitleLevel_FinancialLifeFrom, "Financial Life From Field", Fin_AmortatTitleLevel_FinancialLifeFrom, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_FinancialLifeTo_Key +"']", Fin_AmortatTitleLevel_FinancialLifeTo, "Financial Life To Field", Fin_AmortatTitleLevel_FinancialLifeTo, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_Amortization_Key +"']", Fin_AmortatTitleLevel_Amortization, "Amortization Field", Fin_AmortatTitleLevel_Amortization, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_Currency_Key +"']", Fin_AmortatTitleLevel_Currency, "Currency Field", Fin_AmortatTitleLevel_Currency, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_NewTitleValue_Key +"']", Fin_AmortatTitleLevel_NewTitleValue, "New Title Value Field", Fin_AmortatTitleLevel_NewTitleValue, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_AmortReleasedtoGL_Key +"']", Fin_AmortatTitleLevel_AmortReleasedtoGL, "Amort Released to GL Field", Fin_AmortatTitleLevel_AmortReleasedtoGL, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_NBVinGL_Key +"']", Fin_AmortatTitleLevel_NBVinGL, "NBV in GL Field", Fin_AmortatTitleLevel_NBVinGL, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_AmortAsOfDate_Key +"']", Fin_AmortatTitleLevel_AmortAsOfDate, "Amort As Of Date Field", Fin_AmortatTitleLevel_AmortAsOfDate, "innerHTML");
		
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Child Header Field Name in Amortization Tab at Title Level************************");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_Window_Key +"']", Fin_AmortatTitleLevel_Window, "Window Field", Fin_AmortatTitleLevel_Window, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_WindowType_Key +"']", Fin_AmortatTitleLevel_WindowType, "Window Type Field", Fin_AmortatTitleLevel_WindowType, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_Period_Key +"']", Fin_AmortatTitleLevel_Period, "Period Field", Fin_AmortatTitleLevel_Period, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_AmortizationTemplate_Key +"']",  Fin_AmortatTitleLevel_AmortizationTemplate, "Amortization Template Field",  Fin_AmortatTitleLevel_AmortizationTemplate, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_AmortizationValue_Key +"']", Fin_AmortatTitleLevel_AmortizationValue, "Amortization Value Field", Fin_AmortatTitleLevel_AmortizationValue, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_NewNBV_Key +"']", Fin_AmortatTitleLevel_NewNBV, "New NBV Field", Fin_AmortatTitleLevel_NewNBV, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortatTitleLevel_AdjustmentMethod_Key +"']", Fin_AmortatTitleLevel_AdjustmentMethod, "Adjustment Method Field", Fin_AmortatTitleLevel_AdjustmentMethod, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Parent Header Field Name in Amortization Schedule frame at Title Level************************");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Window_Key +"']", Fin_AmortScheduleTitleLevel_Window, "Window Field", Fin_AmortScheduleTitleLevel_Window, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_WindowType_Key +"']", Fin_AmortScheduleTitleLevel_WindowType, "Window Type Field", Fin_AmortScheduleTitleLevel_WindowType, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_FinancialLife_Key +"']", Fin_AmortScheduleTitleLevel_FinancialLife, "Financial Life Field", Fin_AmortScheduleTitleLevel_FinancialLife, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_TitleValue_Key +"']", Fin_AmortScheduleTitleLevel_TitleValue, "Title Value Field", Fin_AmortScheduleTitleLevel_TitleValue, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_AdjustedAmortizationAmount_Key +"']", Fin_AmortScheduleTitleLevel_AdjustedAmortizationAmount, "Adjusted Amortization Amount Field", Fin_AmortScheduleTitleLevel_AdjustedAmortizationAmount, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_AmortAsOfDate_Key +"']", Fin_AmortScheduleTitleLevel_AmortAsOfDate, "Amort As Of Date Field", Fin_AmortScheduleTitleLevel_AmortAsOfDate, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Child Header Field Name in Amortization Schedule frame at Title Level************************");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Date_Key +"']", Fin_AmortScheduleTitleLevel_Date, "Date Field", Fin_AmortScheduleTitleLevel_Date, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_ScheduledMonth_Key +"']", Fin_AmortScheduleTitleLevel_ScheduledMonth, "Scheduled Month Field", Fin_AmortScheduleTitleLevel_ScheduledMonth, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_GLReleaseDate_Key +"']", Fin_AmortScheduleTitleLevel_GLReleaseDate, "GL Release Date Field", Fin_AmortScheduleTitleLevel_GLReleaseDate, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Currency_Key +"']", Fin_AmortScheduleTitleLevel_Currency, "Currency Field", Fin_AmortScheduleTitleLevel_Currency, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Amount_Key +"']", Fin_AmortScheduleTitleLevel_Amount, "Amount Field", Fin_AmortScheduleTitleLevel_Amount, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_ProfitCenter_Key +"']", Fin_AmortScheduleTitleLevel_ProfitCenter, "Profit Center Field", Fin_AmortScheduleTitleLevel_ProfitCenter, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Submitted_Key +"']", Fin_AmortScheduleTitleLevel_Submitted, "Submitted Field", Fin_AmortScheduleTitleLevel_Submitted, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_WriteDown_Key +"']", Fin_AmortScheduleTitleLevel_WriteDown, "Write Down Field", Fin_AmortScheduleTitleLevel_WriteDown, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Manual_Key +"']", Fin_AmortScheduleTitleLevel_Manual, "Manual Field", Fin_AmortScheduleTitleLevel_Manual, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_Notes_Key +"']", Fin_AmortScheduleTitleLevel_Notes, "Notes Field", Fin_AmortScheduleTitleLevel_Notes, "innerHTML");
		verifyFieldValueOfHeader(Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow+"//th[@key='" + Fin_AmortScheduleTitleLevel_ApprovalNumber_Key +"']", Fin_AmortScheduleTitleLevel_ApprovalNumber, "Approval Number Field", Fin_AmortScheduleTitleLevel_ApprovalNumber, "innerHTML");
		
		//System.out.println(getAttribute(getLocator_AmortatTitleLevel_ParentDataRow("2",Loc_Fin_AmortatTitleLevel_ParentHeaderRow, Loc_Fin_AmortatTitleLevel_ChildHeaderRow,Fin_AmortatTitleLevel_NewTitleValue_Key, Fin_AmortatTitleLevel_NewTitleValue), "innerHTML"));
		//Note this is not working
		// I will discuss later with Rajuddin regarding data row locators
		//System.out.println(getAttribute(getLocator_AmortatTitleLevel_ParentDataRow("2",Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow, Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow,Fin_AmortScheduleTitleLevel_FinancialLife_Key, Fin_AmortScheduleTitleLevel_FinancialLife), "innerHTML"));
	}

	//Utility Methods for Amortization Tab
	/**
	 * 
	 * @param rowNumber Row start from 3,5,7, etc..
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_ChildHeaderRow(String rowNumber,String KeyValueFromExcel,String HeadeNameFromExcel )
	{		
		String locator =   Loc_Fin_Amort_ChildHeaderRow + "[" + rowNumber +"]//th[@key= '"+ KeyValueFromExcel +"']";
		return locator;
	}

	/**
	 * @author Rajuddin
	 * @param rowNumber: row number from the table of Application 
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_EditTAB_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(locator_EditTAB_ColumnHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = locator_EditTAB_ColumnDataRow + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;

		//td[not(@aria-describedby = 'ctl00')
		//input[not(@type='hidden')] 
	}

	public String getLocator_AmortatTitleLevel_ParentDataRow(String rowNumber,String ParentHeaderLoc,String ChildHeaderLoc, String KeyValueFromExcel, String HeadeNameFromExcel){
		String ParentLocator = ParentHeaderLoc;
		String ChildLocator  =  ChildHeaderLoc;
		String locator = "";
		String classValue = getClassValueParent(ParentLocator+"//th[@key= '"+ KeyValueFromExcel +"']", HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = ChildLocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = ChildLocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";

		}

		return locator;

	}
	public String getClassValueParent(String headerLocator, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			classValue =  getAttribute(headerLocator, "class");
		} 
		return classValue;
	}
}

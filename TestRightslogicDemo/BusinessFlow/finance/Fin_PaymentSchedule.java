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
public class Fin_PaymentSchedule extends DriverHelper {


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
	
	public Fin_PaymentSchedule() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	@Test(priority =1,enabled= true,description = "Payment Schedule Tab UI Verification")
	public void TC1_PaymentScheduleUI() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payment Schedule"), "Payment Schedule TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(Loc_Fin_PS_ExpandAll);
		/*ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of Fields label name in Payment Schedule Tab************************");
	    verifyFieldValueOfHeader(Loc_Fin_PS_SelectLabelname, Fin_PS_SelectLabelname , Fin_PS_SelectLabelname, Fin_PS_SelectLabelname);
		verifyFieldValueOfHeader(Loc_Fin_PS_Multiselect, Fin_PS_Multiselect , Fin_PS_Multiselect, Fin_PS_Multiselect);
		verifyFieldValueOfHeader(Loc_Fin_PS_Assetnamelabel, Fin_PS_Assetnamelabel , Fin_PS_Assetnamelabel, Fin_PS_Assetnamelabel);
		verifyFieldValueOfHeader(Loc_Fin_PS_Datelegend, Fin_PS_Datelegend , Fin_PS_Datelegend, Fin_PS_Datelegend);
		verifyFieldValueOfHeader(Loc_Fin_PS_Duedate, Fin_PS_Duedate , Fin_PS_Duedate, Fin_PS_Duedate);
*/
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of button name in Payment Schedule Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_PS_Filter, Fin_PS_Filter, "Filter button", Fin_PS_Filter, "value");
		verifyFieldValueOfHeader(Loc_Fin_PS_Clearfilter, Fin_PS_Clearfilter,"Clear Filter button" , Fin_PS_Clearfilter, "value");
		verifyFieldValueOfHeader(Loc_Fin_PS_ExpandAll, Fin_PS_ExpandAll ,"Expand All button", Fin_PS_ExpandAll, "value");
		verifyFieldValueOfHeader(Loc_Fin_PS_CollapseAll, Fin_PS_CollapseAll ,"Collapse All", Fin_PS_CollapseAll, "value");
		verifyFieldValueOfHeader(Loc_Fin_PS_UnlockPaidRows, Fin_PS_UnlockPaidRows ,"Unlock Paid rows button", Fin_PS_UnlockPaidRows, "value");
		verifyFieldValueOfHeader(Loc_Fin_PS_Save, Fin_PS_Save ,"Save button", Fin_PS_Save, "value");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of icons in Payment Schedule Tab************************");
		verifyElementPresent(Loc_Fin_PS_Exporticon, "Export icon", Fin_PS_Exporticon);
		verifyElementPresent(Loc_Fin_PS_Remindericon, "Reminder icon", Fin_PS_Remindericon);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of Field in Parent Header Name in Payment Schedule Tab************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_AppliesTo_Key +"']", Fin_PS_AppliesTo, "Applies To Field", Fin_PS_AppliesTo, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_Party_Key +"']", Fin_PS_Party, "Party Field", Fin_PS_Party, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_Currency_Key +"']", Fin_PS_Currency, "Currency Field", Fin_PS_Currency, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_Total_Key +"']", Fin_PS_Total, "Total Field", Fin_PS_Total, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_TotalPaid_Key +"']", Fin_PS_TotalPaid, "Total Paid Field", Fin_PS_TotalPaid, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_PS_TotalUnpaid_Key +"']", Fin_PS_TotalUnpaid, "Total Unpaid Field", Fin_PS_TotalUnpaid, "innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("*******************************Verification of Field in Parent Header Name in Payment Schedule Tab************************");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_Paymentnumber_Key,Fin_PS_Paymentnumber), Fin_PS_Paymentnumber, "Payment Number", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_DueDate_Key,Fin_PS_DueDate), Fin_PS_DueDate, "Due Date", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_PaymentType_Key,Fin_PS_PaymentType), Fin_PS_PaymentType, "Payment Type", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_AmountDue_Key,Fin_PS_AmountDue), Fin_PS_AmountDue, "Amount Due", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_ProfitCenter_Key,Fin_PS_ProfitCenter), Fin_PS_ProfitCenter, "Profit Center", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_DatePaid_Key,Fin_PS_DatePaid), Fin_PS_DatePaid, "Date Paid", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_PaidAmount_Key,Fin_PS_PaidAmount), Fin_PS_PaidAmount, "Paid Amount", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_InvoiceNumber_Key,Fin_PS_InvoiceNumber), Fin_PS_InvoiceNumber, "Invoice Number", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_Webpac_Key,Fin_PS_Webpac), Fin_PS_Webpac, "Account Reference", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_InvoiceDate_Key,Fin_PS_InvoiceDate), Fin_PS_InvoiceDate, "Invoice Date", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_Unlock_Key,Fin_PS_Unlock), Fin_PS_Unlock, "Unlockr", "innerHTML");
		verifyFieldValueOfHeader(getLocator_ChildHeaderRow("3",Fin_PS_Notes_Key,Fin_PS_Notes), Fin_PS_Notes, "Notes", "innerHTML");
		
		System.out.println(getLocator_PS_ParentDataRow("2", Fin_PS_AppliesTo_Key, Fin_PS_AppliesTo));
		System.out.println(getLocator_PS_ChildDataRow("3","2", Fin_PS_Paymentnumber_Key, Fin_PS_Paymentnumber));
		
	}

	//Utility Methods for Payment Schedule Tab
	/**
	 * 
	 * @param rowNumber Row start from 3,5,7, etc..
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_ChildHeaderRow(String rowNumber,String KeyValueFromExcel,String HeadeNameFromExcel )
	{		
	String locator =   Loc_Fin_PS_DataRow + "[" + rowNumber +"]//th[@key= '"+ KeyValueFromExcel +"']";
		return locator;
	}
	
	/**
	 * 
	 * @param rowNumber -- Parent Row number starts from 2,4,6, etc..
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_PS_ParentDataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueParent(loc_Fin_ChangedealGadget_GeneralParent_HeaderRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = Loc_Fin_PS_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = Loc_Fin_PS_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}

		return locator;
	}
	
	/**
	 * 
	 * @param HeaderrowNumber HeaderrowNumber starts from 3,5,7, etc..
	 * @param ChildrowNumber  ChildrowNumber starts from 2,4,6, etc..
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @return
	 */
	public String getLocator_PS_ChildDataRow(String HeaderrowNumber,String ChildrowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String Headerlocator =   Loc_Fin_PS_DataRow + "[" + HeaderrowNumber +"]//th[@key= '"+ KeyValueFromExcel +"']";
		String locator = "";
		String classValue = getClassValueParent(Headerlocator, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = Loc_Fin_PS_DataRow + "[" + ChildrowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = Loc_Fin_PS_DataRow + "[" + ChildrowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
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
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
public class Fin_Adjustments_Reverse_Assets_and_Liabilities extends DriverHelper {


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
	
	public Fin_Adjustments_Reverse_Assets_and_Liabilities() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@Test(priority =1,enabled= true,description = "Reverse_Assets_and_Liabilities UI Verification")
	public void TC1_Reverse_Assets_and_LiabilitiesUI() throws Exception {
		Thread.sleep(1000);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Fin_SubmitMenu,"Submit Menu");
		Thread.sleep(1000);
		clickUsingJSExecutor(Loc_Fin_Adjustments,"Adjustments under Submit Menu");
		clickUsingJSExecutor(Loc_Fin_ReverseAssetsandLiabilities,"Reverse Assetsand Liabilities");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(Loc_Fin_Adjustments_Reverse_Reversebutton);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Field Label name in Reverse Assets and Liabilities Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_ProfitCenterandBudgetLine, Fin_Adjustments_Reverse_ProfitCenterandBudgetLine , Fin_Adjustments_Reverse_ProfitCenterandBudgetLine, Fin_Adjustments_Reverse_ProfitCenterandBudgetLine);
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_DealName, Fin_Adjustments_Reverse_DealName , Fin_Adjustments_Reverse_DealName, Fin_Adjustments_Reverse_DealName);						
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_TotalAmount, Fin_Adjustments_Reverse_TotalAmount , Fin_Adjustments_Reverse_TotalAmount, Fin_Adjustments_Reverse_TotalAmount);
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_ReverseApprovallabel, Fin_Adjustments_Reverse_ReverseApprovallabel , Fin_Adjustments_Reverse_ReverseApprovallabel, Fin_Adjustments_Reverse_ReverseApprovallabel);
				
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Button Label Name in Reverse Assets and Liabilities Tab************************");
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_Searchbutton, Fin_Adjustments_Reverse_Searchbutton, "Search button", Fin_Adjustments_Reverse_Searchbutton, "value");	
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_SelectAllbutton, Fin_Adjustments_Reverse_SelectAllbutton, "Select All button", Fin_Adjustments_Reverse_SelectAllbutton, "value");	
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_DeselectAllbutton, Fin_Adjustments_Reverse_DeselectAllbutton, "Deselect button", Fin_Adjustments_Reverse_DeselectAllbutton, "value");	
		verifyFieldValueOfHeader(Loc_Fin_Adjustments_Reverse_Reversebutton, Fin_Adjustments_Reverse_Reversebutton, "Reverse button", Fin_Adjustments_Reverse_Reversebutton, "value");	
		
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Icons in Reverse Assets and Liabilities Tab************************");
		verifyElementPresent(Loc_Fin_Adjustments_Reverse_ExportIcon, "Export icon", Fin_Adjustments_Reverse_ExportIcon);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------------------------------------------------------------------------------------------------------------");
		ExecutionLog.Log("******************************Verification of Header Field Name in Reverse Assets and Liabilities Tab************************");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_Appliesto_Key +"']", Fin_Adjustments_Reverse_Appliesto, "Applies To Field", Fin_Adjustments_Reverse_Appliesto, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_WindowName_Key +"']", Fin_Adjustments_Reverse_WindowName, "Window Name Field", Fin_Adjustments_Reverse_WindowName, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_StartDate_Key +"']", Fin_Adjustments_Reverse_StartDate, "Start Date Field", Fin_Adjustments_Reverse_StartDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_EndDate_Key +"']", Fin_Adjustments_Reverse_EndDate, "End Date Field", Fin_Adjustments_Reverse_EndDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_Amount_Key +"']", Fin_Adjustments_Reverse_Amount, "Amount Field", Fin_Adjustments_Reverse_Amount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_Transaction_Key +"']", Fin_Adjustments_Reverse_Transaction, "Transaction Field", Fin_Adjustments_Reverse_Transaction, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_GLAccount_Key +"']", Fin_Adjustments_Reverse_GLAccount, "GL Account Field", Fin_Adjustments_Reverse_GLAccount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_BalancingTransaction_Key +"']", Fin_Adjustments_Reverse_BalancingTransaction, "Balancing Transaction Field", Fin_Adjustments_Reverse_BalancingTransaction, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_BalancingGLAccount_Key +"']", Fin_Adjustments_Reverse_BalancingGLAccount, "GL Account Field", Fin_Adjustments_Reverse_BalancingGLAccount, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_ApprovalDate_Key +"']", Fin_Adjustments_Reverse_ApprovalDate, "Approval Date Field", Fin_Adjustments_Reverse_ApprovalDate, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Adjustments_Reverse_FinancialLife_Key +"']", Fin_Adjustments_Reverse_FinancialLife, "Financial Life Field", Fin_Adjustments_Reverse_FinancialLife, "innerHTML");
		

	}
	
	}
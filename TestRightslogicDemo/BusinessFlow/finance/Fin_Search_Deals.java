package finance;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import rightsIN.RI_ExhibitionRights;
import rightsIN.RI_MediaRights;
import utility.DriverHelper;
import commonFunctions.Finance;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class Fin_Search_Deals extends DriverHelper {


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
	String CreatedDeal =   "AUT_Deal_0227201714813";
	
	public Fin_Search_Deals() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@Test(priority =1,enabled= true,description = "Search > Deals")
	public void TC1_FinanceSearch() throws Exception {
		
		AquisitionFinance.navigateToRightsINFinance();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		clickUsingJSExecutor(loc_Fin_Search_Deals,"Deals");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyElementPresent(loc_RI_AggrementSearchRestoreSearch, "Restore Button");
		
		
		//TC_1
		/*// Verify Labels of Search Fields
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchDealName, Fin_AggrementSearchDealName, "Deal Name", Fin_AggrementSearchDealName);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractDescription, Fin_AggrementSearchContractDescription, "Contract Description", Fin_AggrementSearchContractDescription);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchDealType, Fin_AggrementSearchDealType, "Deal Type", Fin_AggrementSearchDealType);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchAgreementType, Fin_AggrementSearchAgreementType, "Agreement Type", Fin_AggrementSearchAgreementType);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchContractingEntity, Fin_AggrementSearchContractingEntity, "Contracting Entity", Fin_AggrementSearchContractingEntity);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchVendorParty, Fin_AggrementSearchVendorParty, "Vendor/Party", Fin_AggrementSearchVendorParty);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchDealStatus, Fin_AggrementSearchDealStatus, "Deal Status", Fin_AggrementSearchDealStatus);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchProfitCenter, Fin_AggrementSearchProfitCenter, "Profit Center", Fin_AggrementSearchProfitCenter);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchContractStatus, Fin_AggrementSearchContractStatus, "Contract Status", Fin_AggrementSearchContractStatus);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchCDES, Fin_AggrementSearchCDES, "Contract Data Entry Status", Fin_AggrementSearchCDES);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchLicenseTerm, Fin_AggrementSearchLicenseTerm, "License Term", Fin_AggrementSearchLicenseTerm);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchExecutionDate, Fin_AggrementSearchExecutionDate, "Execution Date", Fin_AggrementSearchExecutionDate);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchTitleName, Fin_AggrementSearchAssetName, "Asset Name", Fin_AggrementSearchAssetName);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchTitleID, Fin_AggrementSearchAssetID, "Asset ID", Fin_AggrementSearchAssetID);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchFinancialStatus, Fin_AggrementSearchFinanceStatus, "Finance Status", Fin_AggrementSearchFinanceStatus);
		verifyFieldValueOfHeader(loc_Fin_AggrementSearchExactMatch, Fin_AggrementSearchExactMatch, "Exact Match", Fin_AggrementSearchExactMatch);
	
		//Button Verification
		verifyFieldValueOfHeader(loc_Fin_AggrementSearch_Searchbutton, Fin_AggrementSearch_Searchbutton, "Search Button", Fin_AggrementSearch_Searchbutton, "value");
		verifyFieldValueOfHeader(loc_Fin_AggrementSearch_ClearSearchbutton, Fin_AggrementSearch_ClearSearchbutton, "Clear Search Button", Fin_AggrementSearch_ClearSearchbutton, "value");
		verifyFieldValueOfHeader(loc_Fin_AggrementSearch_SaveSearchbutton, Fin_AggrementSearch_SaveSearchbutton, "Save Search Button", Fin_AggrementSearch_SaveSearchbutton, "value");
		verifyFieldValueOfHeader(loc_Fin_AggrementSearch_RestoreSearchbutton, Fin_AggrementSearch_RestoreSearchbutton, "Restore Search Button", Fin_AggrementSearch_RestoreSearchbutton, "value");
*/

		//TC_2
		//Search by Deal Name
		sendKeys(loc_RI_AggrementSearchDealNameInput, CreatedDeal, "Deal Name", Fin_AggrementSearchDealName);
		Thread.sleep(2000);
		verifyDataFromSearchresults(loc_RI_AggrementSearchDealTypeFromSearchResult, 3, RI_AggrementSearchDealTypeData, "title");
	}
		
	
	//Utility methods for Fin_Agreement Search
	public void clearSearchField() throws Exception{
		clickUsingJSExecutor(loc_Fin_AggrementSearch_ClearSearchbutton,"Clear Search Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
	}
	
	public void agreementSearchPickList(String Locater) throws Exception {
        clickOn(Locater, "Pick list", "");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_SelectAll);
		Thread.sleep(3000);
		verifyTextMatches(Loc_SelectAll, "Select All", RI_ObligationsSelectAll, "value");
		verifyTextMatches(Loc_DeselectAllButton, "Deselect All", RI_ObligationsDeselectAll, "value");
		verifyTextMatches(Applybutton_AtSBUWindow, "Apply", RI_ObligationsApply, "value");
		verifyTextMatches(LocCancel, "Cancel", RI_ObligationsCancel, "value");
		clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		verifyElementNotPresent(Loc_RI_agreementSearchPickListUnchecked, "All check box Checked");  
		Thread.sleep(3000);
		clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		verifyElementNotPresent(Loc_RI_agreementSearchPickListChecked, "All check box Unchecked");
		Thread.sleep(3000);
		clickUsingJSExecutor(LocCancel, "Cancel button", "");
		switchIntoFrame(frameParent2Xpath);	
	}
	public void verifyDataFromSearchresults(String locater,int Num,String ExpetedTestData,String Attributes) throws Exception{
    	Thread.sleep(2000);
    	clickUsingJSExecutor(Loc_SearchButton,"Search Button");
    	WaitForModalPanel();
    	switchIntoFrame(frameParent2Xpath);
    	clickOn(Loc_RI_agreementSearchPageSizeImg,"Page Size");
    	Thread.sleep(1000);
    	clickOn(Loc_RI_agreementSearchPageSizeSelectAll,"Page Size Select All");
    	Enter();
    	switchIntoFrame(frameParent2Xpath);
    	WaitForModalPanel(Loc_RI_agreementSearchprocessingImg);
    	switchIntoFrame(frameParent2Xpath);
    	List<WebElement> elemList2 = driver.findElements(ByLocator(locater));
    
    	/*System.out.println("---------------------START-----------------------------"); //Test
    	System.out.println(elemList2.size());
    	for(WebElement elem : elemList2) {
    		System.out.println(elem.getAttribute("title"));
    		
    	}
    	System.out.println("----------------------END----------------------------");*/
    	System.out.println("---------------------START-----------------------------");
    	for(int i = Num; i<=elemList2.size()-1; i++) {
    		
    		verifyFieldValueOfHeader(elemList2.get(i), ExpetedTestData, "verify "+ExpetedTestData+" form search result", "", Attributes);
    	}
    	System.out.println("---------------------End-----------------------------");
    }	
}
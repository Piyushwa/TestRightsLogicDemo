package finance;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import rightsIN.RI_ExhibitionRights;
import rightsIN.RI_MediaRights;
import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.Finance;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class Fin_Changedealgadget extends DriverHelper {


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
	String followingFieldChanged_From_DealNavigator = "/following-sibling::td[1]";
	String followingFromValue_From_DealNavigator = "/following-sibling::td[5]";
	String followingToValue_From_DealNavigator = "/following-sibling::td[6]";
	String followingToValue_From_DealNavigator_forAssetdata = "/following-sibling::td[text()='@var']";
	
	String Expected202        = CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode202;
	String Expected201        = CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode201;
	String Expected101        = CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode101;
	String Expected102        = CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode102;
	String TotalExpected      = Expected202+Expected201+Expected101+Expected102;
	
	String GeneralTabID 	= "uwgGeneralTab";
	String MediaTabID 		= "uwgMediaRightsTab";
	String ExhibitionTabID 	= "uwgExhibitions";
	String PaymentTabID 	= "uwgPaymentTab";
	
	public Fin_Changedealgadget() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	
	@Test(priority =1,enabled= true,description = "Deals Changed Gadget UI and Fields to be tracked")
	public void TC1_Change_Deal_Gadget() throws Exception {


		//Series_and_Deal_Creation();
		AquisitionFinance.navigateToRightsINFinance();	
		selectDeal(CreatedDeal);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_1_Deal Change Gadget");
		ExecutionLog.Log("*****Verify all tabs and Buttons in Change deal Gadget Popup Window*****");
		
		verifyFieldValueOfHeader(Loc_Fin_ChangedealGadget_Generaltab,         Fin_Changedealgadget_Generaltab,            " General tab in Change deal gadget",          Fin_Changedealgadget_Generaltab,        "innerHTML");
		verifyFieldValueOfHeader(loc_Fin_ChangedealGadget_MediaRightstab,     Fin_Changedealgadget_MediaRightstab,        " Media Rights tab in Change deal gadget",     Fin_Changedealgadget_MediaRightstab,    "innerHTML");
		verifyFieldValueOfHeader(loc_Fin_ChangedealGadget_Paymenttab,         Fin_Changedealgadget_Paymenttab,            " Payment tab in Change deal gadget",          Fin_Changedealgadget_Paymenttab,        "innerHTML");
		verifyFieldValueOfHeader(loc_Fin_ChangedealGadget_Exhibitionstab,     Fin_Changedealgadget_Exhibitionstab,        " Exhibitions tab in Change deal gadget",      Fin_Changedealgadget_Exhibitionstab,    "innerHTML");		
		verifyFieldValueOfHeader("//th[@key='" + Fin_Changedealgadget_Appliesto_label_Key +"']", Fin_Changedealgadget_Appliesto_label, "Applies to field", Fin_Changedealgadget_Appliesto_label, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Changedealgadget_TabName_label_Key +"']", Fin_Changedealgadget_TabName_label, "Tab Name field", Fin_Changedealgadget_TabName_label, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Changedealgadget_FieldChanged_label_Key +"']", Fin_Changedealgadget_FieldChanged_label, "Field change field", Fin_Changedealgadget_FieldChanged_label, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Changedealgadget_FromValue_label_Key +"']", Fin_Changedealgadget_FromValue_label, "From value field", Fin_Changedealgadget_FromValue_label, "innerHTML");
		verifyFieldValueOfHeader("//th[@key='" + Fin_Changedealgadget_ToValue_label_Key +"']", Fin_Changedealgadget_ToValue_label, "To value field", Fin_Changedealgadget_ToValue_label, "innerHTML");		
		verifyTextMatches(loc_Fin_ChangedealGadget_Acceptbutton, "Accept", Fin_Changedealgadget_Acceptbutton, "value");
		verifyTextMatches(loc_Fin_ChangedealGadget_Rejectbutton, "Reject", Fin_Changedealgadget_Rejectbutton, "value");
		verifyTextMatches(loc_Fin_ChangedealGadget_Cancelbutton, "Cancel", Fin_Changedealgadget_Cancelbutton, "value");
		
		//Verify the Deal Name in Applies to Field  
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Deal Name verification in General Tab of Applies to Field************************");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow("2", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,GeneralTabID),CreatedDeal,CreatedDeal + " in Applies to field ",Fin_Changedealgadget_Appliesto_label,"innerHTML");
		
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab of To value field for Series, Season and Episode************************");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season2),CreatedSeriesAssetTitle+" - " +Season2,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season1),CreatedSeriesAssetTitle+" - " +Season1,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode202),CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode202,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode201),CreatedSeriesAssetTitle+" - " +Season2+" - "+S2_Episode201,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle),CreatedSeriesAssetTitle,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode101),CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode101,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_AssetDataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingToValue_From_DealNavigator_forAssetdata.replace("@var", CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode102),CreatedSeriesAssetTitle+" - " +Season1+" - "+S1_Episode102,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		                                                                                                      
		
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 1************************");
		//Data verification in General Tab Row number - 2
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,GeneralTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		
 
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 2************************");
		//Data verification in General Tab Row number - 3
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "1",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
   
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 3************************");
		//Data verification in General Tab Row number - 4
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "2",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "2",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "2",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 4************************");
		//Data verification in General Tab Row number - 5
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "3",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "3",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "3",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 5************************");
		//Data verification in General Tab Row number - 6
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "4",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "4",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "4",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 6************************");
		//Data verification in General Tab Row number - 7
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "5",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "5",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "5",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 7************************");
		//Data verification in General Tab Row number - 8
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "6",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row2to8data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "6",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "6",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 8************************");
		//Data verification in General Tab Row number - 9
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "7",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "7",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row9data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "7",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "7",GeneralTabID)+ followingToValue_From_DealNavigator ,Fin_Changedealgadget_BudgetLinedata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 9************************");
		//Data verification in General Tab Row number - 10
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "8",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "8",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row10data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "8",GeneralTabID)+ followingFromValue_From_DealNavigator ,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "8",GeneralTabID)+ followingToValue_From_DealNavigator ,Fin_Changedealgadget_CDESdata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 10************************");
		//Data verification in General Tab Row number - 11
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "9",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "9",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row11data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "9",GeneralTabID)+ followingFromValue_From_DealNavigator ,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "9",GeneralTabID)+ followingToValue_From_DealNavigator ,Fin_Changedealgadget_ContractStatusdata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 11************************");
		//Data verification in General Tab Row number - 12
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "10",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "10",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row12data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "10",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "10",GeneralTabID)+ followingToValue_From_DealNavigator,Fin_Changedealgadget_Currencydata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 12************************");
		//Data verification in General Tab Row number - 13
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "11",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "11",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row13data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "11",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "11",GeneralTabID)+ followingToValue_From_DealNavigator,Fin_Changedealgadget_DateExecuteddata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 13************************");
		//Data verification in General Tab Row number - 14
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "12",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "12",GeneralTabID)+ followingFieldChanged_From_DealNavigator ,Fin_Changedealgadget_FieldChangedfor_Row14data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "12",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "12",GeneralTabID)+ followingToValue_From_DealNavigator,Fin_Changedealgadget_DealPartiesdata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");

		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in General Tab ----- Row 14************************");
		//Data verification in General Tab Row number - 15
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "13",GeneralTabID), Fin_Changedealgadget_TabNamedatafor_Row9to15data,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "13",GeneralTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row15data,"Field Change field ",Fin_Changedealgadget_FieldChanged_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "13",GeneralTabID)+ followingFromValue_From_DealNavigator,"","Tab Name field ",Fin_Changedealgadget_FromValue_label,"innerHTML");
		verifyFieldValueOfHeader(getLocator_CHG_General_DataRow_UnderSameParentRow("2", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label, "13",GeneralTabID)+ followingToValue_From_DealNavigator ,Fin_Changedealgadget_ProfitCenterdata,"To Value field ",Fin_Changedealgadget_ToValue_label,"innerHTML");


		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in Media Rights Tab***************************************");
		clickOn(loc_Fin_ChangedealGadget_MediaRightstab, "Media Rights");
		Thread.sleep(1000);
		
		 for(int rownumber = 2; rownumber<=8;)
			 
		 {
			
			 
			 if(TotalExpected.contains(getText(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,MediaTabID)))){

				 //Row 1
				 String AppliestoValue = (getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,MediaTabID), "innerHTML"));
				 ExecutionLog.Log("");
				 ExecutionLog.Log("********************************Data verification in Media Rights Tab for "+ getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,MediaTabID), "innerHTML") + " ********************************");
				 verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,MediaTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,MediaTabID)+ followingToValue_From_DealNavigator,AppliestoValue,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 //Row 2
 
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow2,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",MediaTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",MediaTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_MediaType_DropDownValues," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				 //Row 3
				 
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow3,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",MediaTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",MediaTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_BusinessOutLet_DropDownValues," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				 //Row 4
				 
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow4,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",MediaTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",MediaTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermFromTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				//Row 5
				 
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow5,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",MediaTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",MediaTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermToTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				 //Row 6
				 
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",MediaTabID), Fin_Changedealgadget_TabNameDatafor_MRRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",MediaTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow6,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",MediaTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				 verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",MediaTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_Territory_DropDownValues," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
 
				 
			 }
			 else 
			 {
				 System.out.println("data is not present");
			 }
			 
			 rownumber = rownumber+2;
			 
		 }
		
	
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in Exhibitions Tab***************************************");
		clickOn(loc_Fin_ChangedealGadget_Exhibitionstab, "Exhibitions");
		Thread.sleep(1000);
		for(int rownumber = 2; rownumber<=8;)

		{
			
			if(TotalExpected.contains(getText(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,ExhibitionTabID)))){
				//Row 1
				String AppliestoValue = (getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,ExhibitionTabID), "innerHTML"));
				ExecutionLog.Log("");
				ExecutionLog.Log("********************************Data verification in Exhibitions Tab for "+ getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,ExhibitionTabID), "innerHTML") + " ********************************");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,ExhibitionTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,ExhibitionTabID)+ followingToValue_From_DealNavigator,AppliestoValue,"To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 2
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_ExRow2,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_Exh_ExhNetworkChannel1," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				//Row 3
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow4,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermFromTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 4
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow4,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermFromTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 5
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow5,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermToTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 6
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow5,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermToTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 7
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_ExRow7,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_Exh_WinName," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 8
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"7",ExhibitionTabID), Fin_Changedealgadget_TabNameDatafor_ExhRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"7",ExhibitionTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_ExRow8,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"7",ExhibitionTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"7",ExhibitionTabID)+ followingToValue_From_DealNavigator,RI_Exh_WinType_DefaultValue," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

			}
			else
			{
				System.out.println("data is not present");
			}
			rownumber = rownumber+2;
		}
		
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in Payment Tab***************************************");
		clickOn(loc_Fin_ChangedealGadget_Paymenttab, "Payment");
		Thread.sleep(1000);
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Data verification in Payment frame of Payment Tab***************************************");
		for(int rownumber = 2; rownumber<=8;)

		{			
			if(TotalExpected.contains(getText(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID)))){
				
				//Row 1
				String AppliestoValue = (getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID), "innerHTML"));
				ExecutionLog.Log("-----------------------------------------------------------------------");				
				ExecutionLog.Log("********************************Data verification in Payment frame of Payment Tab for "+ getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID), "innerHTML") + " ********************************");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_AmountRow,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Amountdata," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				//Row 2
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingToValue_From_DealNavigator,AppliestoValue," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 3
				
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_DuedateRow,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				if(AppliestoValue.equals(Expected101))
				{

					verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Duedatedata1," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				}
				else if(AppliestoValue.equals(Expected102))
				{
					verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Duedatedata2," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				}
				else if(AppliestoValue.equals(Expected201))
				{
					verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Duedatedata3," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				}
				else
				{
					verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Duedatedata4," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");

				}
				
				//Row 4
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_PaymenttypeRow,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"3",PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Paymenttypedata," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 5
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row15data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"4",PaymentTabID)+ followingToValue_From_DealNavigator,Fin_Changedealgadget_ProfitCenterdata," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 6
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow4,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"5",PaymentTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermFromTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 7
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_MRRow5,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"6",PaymentTabID)+ followingToValue_From_DealNavigator,RI_MediaRights_TermToTestData," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
			}
			else
			{
				System.out.println("data is not present");
			}
			rownumber = rownumber+2;
		}
		
		for(int rownumber = 10; rownumber<=16;)

		{			
			if(TotalExpected.contains(getText(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID)))){
				
				//Row 1
				String AppliestoValue = (getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID), "innerHTML"));
				ExecutionLog.Log("");
				ExecutionLog.Log("********************************Data verification in Payment Tab for "+ getAttribute(getLocator_CHG_ParentDataRow(rownumber+"", Fin_Changedealgadget_Appliesto_label_Key, Fin_Changedealgadget_Appliesto_label,PaymentTabID), "innerHTML") + " ********************************");

				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID), Fin_Changedealgadget_TabNameDatafor_AssetvalueFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_AmountRow,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_FirstChildDataRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,PaymentTabID)+ followingToValue_From_DealNavigator,RI_Payment_Assetvalue_Amountdata," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 2
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_AssetvalueFrameRow," Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedfor_Row2to8data,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingFromValue_From_DealNavigator,""," From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"1",PaymentTabID)+ followingToValue_From_DealNavigator,AppliestoValue," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
				//Row 3
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID), Fin_Changedealgadget_TabNameDatafor_AssetvalueFrameRow,"Tab Name field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingFieldChanged_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_PaymenttypeRow,"Field Change field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingFromValue_From_DealNavigator,"","From Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				verifyFieldValueOfHeader(getLocator_CHG_ChildData_UnderSameParentRow(rownumber+"", Fin_Changedealgadget_TabName_label_Key, Fin_Changedealgadget_TabName_label,"2",PaymentTabID)+ followingToValue_From_DealNavigator,Fin_Changedealgadget_FieldChangedDatafor_Paymenttype_AssetvalueRow," To Value field ",Fin_Changedealgadget_TabName_label,"innerHTML");
				
			}
			else{
				System.out.println("data is not present");
			}
			rownumber = rownumber+2;
		}
		 
		
		
		 
		//Verification of Reject Button Functionality
		Thread.sleep(2000); 
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify the Reject button functionality******************************************");
		clickOn(loc_Fin_ChangedealGadget_Rejectbutton, "Reject Button");
		Thread.sleep(1000);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		Thread.sleep(1000);
		scrollElementIntoView(loc_Fin_ChangedealGadget_Reminder_User);
		Thread.sleep(1000);
		clickOn(loc_Fin_ChangedealGadget_Reminder_User, "Select Automation user");		 
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Enter the Subject and Notes in Reminder Popup for Reject button******************************************");
		sendKeys(loc_Fin_ChangedealGadget_Reminder_Suject, Fin_Changedealgadget_Reminder_SubjectData, "Subject", "");
		sendKeys(loc_Fin_ChangedealGadget_Reminder_Notes, Fin_Changedealgadget_Reminder_NotesData, "Notes", "");
		clickOn(loc_Save,"Ok Button");
		WaitForModalPanel();
		Thread.sleep(1000);
		verifyTextMatches(AlertValidationMessgeText, "Confirmation Alert", Fin_Changedealgadget_Reminder_AlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		switchIntoFrame(frameParent2Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verfiy that Deal should not present in Change Deal Gadget after rejecting the deal in Change Deal Gadget Popup window******************************************");
		verifyElementNotPresent(loc_Fin_ChangedealGadget_DealSelect.replace("@var", CreatedDeal),  "Deal");		 

		//Navigating to RI Module
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Again Saving the Deal in RI Module to Push the deal in Finance Module******************************************");
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "Modules", "");
		Thread.sleep(2000);	
		rightIN.searchCreatedDeal(CreatedDeal);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(3000);
		verifyFieldValueOfHeader(loc_CreatedAssetAtHome, CreatedDeal, "CreatedDeal", "CreatedDeal");

		//Navigating to RI Finance Module
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Navigate to Finance Module******************************************");
		ExecutionLog.Log("*****************************Searching the deal in Change Deal gadget******************************************");
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "Modules", "");
		Thread.sleep(2000);
		clickOn(RightsInFinanceXpath, "Finance Module ", "");
		Thread.sleep(2000);		
		selectDeal(CreatedDeal);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);

		//Verify the Cancel button Functionality
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify the Cancel button functionality******************************************");
		clickOn(loc_Fin_ChangedealGadget_Cancelbutton, "Cancel Button");
		switchIntoFrame(frameParent2Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify that after click on Cancel button Deal should be present in Change Deal Gadget ******************************************");
		verifyElementPresent(loc_Fin_ChangedealGadget_DealSelect.replace("@var", CreatedDeal),  "Deal");

		//Verify the Accept button Functionality
		selectDeal(CreatedDeal);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify the Accept button functionality******************************************");
		Thread.sleep(3000);
		clickOn(loc_Fin_ChangedealGadget_Acceptbutton, "Accept Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(2000);
		//verifyElementPresent(loc_Fin_Generaltab_DealDetails, "General Tab of Finance Module");
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify that Deal should be removed from the 'Deals Changed Gadget'******************************************");
		clickOn(RightsInFinanceXpath, "Finance Module ", "");
		Thread.sleep(2000);
		verifyElementNotPresent(loc_Fin_ChangedealGadget_DealSelect.replace("@var", CreatedDeal),  "Deal");	
			
		Thread.sleep(2000);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************************Verify the Amount Mismatch in Payables and Asset value******************************************");
		rightIN.searchCreatedDeal(CreatedDeal);
		AquisitionFinance.UpdatedAmountinPaymentframe();
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "Modules", "");
		Thread.sleep(2000);
		clickOn(RightsInFinanceXpath, "Finance Module ", "");
		Thread.sleep(2000);	
		selectDeal(CreatedDeal);
		WaitForModalPanel();
		//switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		verifyTextMatches(AlertValidationMessgeText, "Confirmation Alert", Fin_Changedealgadget_Amount_AlertMsg);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button Alert");
		Thread.sleep(2000);
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_Fin_ChangedealGadget_Cancelbutton, "Cancel Button");
		switchIntoFrame(frameParent2Xpath);
	}
	


	//////////////////////////////////////////////Utility Methods which are specific to Change Deal Gadget///////////////////////////////////////////////////////////////////////////////

	

	public void Series_and_Deal_Creation() throws Exception{

		// TC1
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle);
		rightIN.createDeal(CreatedDeal);
		selectDropdownValue(loc_ContractStatus, "Deal Creation Contract Status", Fin_RI_ContractStatus, RI_ContractStatus_Label);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(ConfirmAlertXpath);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up", ConfirmAlertButtonXpath);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(3000);
		verifyFieldValueOfHeader(loc_CreatedAssetAtHome, CreatedDeal, "CreatedDeal", "CreatedDeal");
		rightIN.searchCreatedDeal(CreatedDeal);
		rightIN.associateAssetWithDeal(CreatedDeal,CreatedSeriesAssetTitle);
	}	
	public void selectDeal(String dealName) throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOnDisplayedElement(loc_Fin_ChangedealGadget_DealSelect.replace("@var", dealName), "Select deal in Change Deal Gadget ", "");
		WaitForModalPanel();
		Thread.sleep(3000);
	}
	public String getLocator_CHG_General_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel,String TabID){
		String DataRowlocator   = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);
		String locator = "";
		String classValue = getClassValueParent(loc_Fin_ChangedealGadget_GeneralParent_HeaderRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = DataRowlocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = DataRowlocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}

		return locator;
	}
	public String getLocator_CHG_General_DataRow_UnderSameParentRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String SiblingRow,String TabID){
		String DataRowlocator   = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);
		String locator = "";
		String classValue = getClassValueChild("//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = DataRowlocator + "[" + rowNumber +"]/following-sibling::tr[" + SiblingRow + "]/td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = DataRowlocator + "[" + rowNumber +"]/following-sibling::tr[" + SiblingRow + "]/td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	public String getLocator_CHG_General_AssetDataRow_UnderSameParentRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String SiblingRow,String TabID){
		String DataRowlocator   = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);
		String locator = "";
		String classValue = getClassValueChild("//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = DataRowlocator + "[" + rowNumber +"]/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = DataRowlocator + "[" + rowNumber +"]/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	public String getLocator_CHG_ParentDataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel,String TabID){
		String Appliestolocator = loc_Fin_ChangedealGadget_AppliestoField_HeaderRow.replace("@var1", TabID);
		String DataRowlocator   = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);
		String locator = "";
		String classValue = getClassValueParent(Appliestolocator.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = DataRowlocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = DataRowlocator + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
			
		}

		return locator;
		
	}
	/**
	 * 
	 * @param rowNumber : Parent Row number starts from 2,4,6, etc..
	 * <br>(rowNumber + 1) denotes to the child row as child row starts from 3,5,7, etc...</br>
	 * @param KeyValueFromExcel
	 * @param HeadeNameFromExcel
	 * @param SiblingRow
	 * @return
	 */
    public String getLocator_CHG_FirstChildDataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String TabID){

    	String locator = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);

    	int IrowNumber = Integer.parseInt(rowNumber);
    	String classValue = getClassValueChild(locator + "[" + (IrowNumber + 1)+ "]//th", KeyValueFromExcel, HeadeNameFromExcel);
    	return locator + "[" + (IrowNumber+1) +"]//tr[@role='row']/td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
	}
	public String getLocator_CHG_ChildData_UnderSameParentRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String SiblingRow, String TabID){
		
		String locator = loc_Fin_ChangedealGadget_Tab_DataRow.replace("@var", TabID);
		
		int IrowNumber = Integer.parseInt(rowNumber);
		String classValue = getClassValueChild(locator + "[" + (IrowNumber + 1)+ "]//th", KeyValueFromExcel, HeadeNameFromExcel);
		return locator + "[" + (IrowNumber+1) +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]/td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
	}
	
	public String getClassValueParent(String headerLocator, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			classValue =  getAttribute(headerLocator, "class");
		} 
		return classValue;
	}
	public String getClassValueChild(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";

		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_Header = headerPath+"[@key='"+keyValue+"']";
			classValue =  getAttribute(loc_Header, "class");
		} 
		return classValue;
	}	
	
	
	
	
	
		
	
}

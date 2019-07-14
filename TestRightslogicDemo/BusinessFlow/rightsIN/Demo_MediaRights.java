package rightsIN;


import java.text.SimpleDateFormat; 
import java.util.Date;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class Demo_MediaRights extends DriverHelper {
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	RI_MediaRights mediaRights = new RI_MediaRights();
	RI_BusinessTerms businessTerm = new RI_BusinessTerms();

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date); 
	//String formattedDate = "0315201711334";
	
	String CreatedSeriesAssetTitleTC1 	= "RAR_Collision Series_TC30_" +formattedDate+"";
	String CreatedDealTC1 			= 	"RAR_Collision Deal_TC30_" +formattedDate+"";

	String supportClickLoctor = loc_RI_ExhRights_ChildRow + "[2]/th";


	public Demo_MediaRights() {
		className = this.getClass().getName(); 
		classObject = this.getClass();	
	}


	@Test(priority =1, enabled = true , description = "Exhibition Rights flow")
	public void TC1_MediaRightsRow() throws Exception {

		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitleTC1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitleTC1);
		rightsIN.createDeal(CreatedDealTC1);
		rightsIN.searchCreatedDeal(CreatedDealTC1);
		rightsIN.associateAssetWithDeal(CreatedDealTC1,CreatedSeriesAssetTitleTC1);
		rightsIN.selectDeal(CreatedDealTC1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		// Enter the data for Row1
		/*mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);

		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		// Verifying the entered data
		mediaRights.verifyAllAvailableFields_EditMode("1",RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);*/
		
	}

	
}





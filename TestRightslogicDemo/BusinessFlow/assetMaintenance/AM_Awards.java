package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;

@Listeners(utility.ListenerClass.class)
public class AM_Awards extends MultiClient_SupportingFunctions {



	public AM_Awards() {
		super(AM_AwardsColumnXpath, AM_AwardsDataRowXpath, AM_AwardsColumnXpath, AM_AwardsDataRowXpath);
		className = this.getClass().getName();
		classObject = this.getClass();
	}

	@BeforeTest
	public void runStatus() {
		//logger = ExtentReports.get(AM_Awards.class);
		/*if(ClientData.equals("CORUS") || ClientData.equals("VMN")) {
			throw new SkipException("Script of \"Award TAB\" is Not Applicable for "+ ClientData);
		}*/
	}

	@Test(priority =2,enabled= true,description = "Awards TAB")
	public void TC2_AwardsUI() throws Exception {

		
		
		Date date = new Date();
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		ExecutionLog.Log(CreatedSeriesAssetTitle1);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		
		

		//search Created Asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent2Xpath);

		//Award TAB
		clickOn(loc_Tab.replace("@var", "Award"), "Award TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		//// Manual Test Step: TC_AM_AWRD_002
		//Verify Columns Header Name of Award TAB in view Mode
		ExecutionLog.Log("**********Verify Columns Header Name of Award TAB in view Mode********");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsOrganization_Key+"']", "Organization", AM_AwardsTabOrganizationViewMode,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsAward_Key+"']", "Award", AM_AwardsTabAwardViewMode,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsAwardTitle_Key+"']", "Award Title", AM_AwardsTabAwardTitleViewMode+"sdsds","innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsYear_Key+"']", "Year", AM_AwardsTabYear,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsWinner_Key+"']", "Winner", AM_AwardsTabWinner,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsStatus_Key+"']", "Status", AM_AwardsTabStatus,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsParticipant_Key+"']", "Participant Award", AM_AwardsTabParticipantAward,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsGameAward_Key+"']", "Game Award", AM_AwardsTabGameAward,"innerHTML");

		//Edit Button
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		// Manual Test Step: TC_AM_AWRD_003
		// Verify Columns Header Name of Award TAB in Edit Mode
		ExecutionLog.Log("**********Verify Columns Header Name of Award TAB in Edit Mode********");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsOrganization_Key+"']", "Organization", AM_AwardsTabOrganization,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsAward_Key+"']", "Award", AM_AwardsTabAward,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsAwardTitle_Key+"']", "Award Title", AM_AwardsTabAwardTitle,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsYear_Key+"']", "Year", AM_AwardsTabYear,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsWinner_Key+"']", "Winner", AM_AwardsTabWinner,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsStatus_Key+"']", "Status", AM_AwardsTabStatus,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsParticipant_Key+"']", "Participant Award", AM_AwardsTabParticipantAward,"innerHTML");
		verifyTextMatches(AM_AwardsColumnXpath+"[@key='"+AM_AwardsGameAward_Key+"']", "Game Award", AM_AwardsTabGameAward,"innerHTML");
		// Manual Test Step: TC_AM_AWRD_004
		//Button
		ExecutionLog.Log("**********Verify buttons present on 'Edit Award TAB' Window********");
		verifyTextMatches(Loc_NewButton, "Add",AM_AwardsAddButton,"Value");
		verifyTextMatches(loc_Delete, "Delete",AM_AwardsDeleteButton,"Value");
		verifyTextMatches(loc_Save, "Ok",AM_AwardsSaveButton,"Value");
		verifyTextMatches(loc_Cancel, "Cancel",AM_AwardsCancelButton,"Value");

		//Add Button
		clickUsingJSExecutor(Loc_NewButton, "Add Button", "");
		verifyElementDisplayed(Loc_Award1Row, "New row is Created", "");
		// Manual Test Step: TC_AM_AWRD_006
		// Save without entering the data
		clickUsingJSExecutor(loc_Save, "Save Button");
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		String ExpectedText = " Please enter values for required (*) fields.";
		verifyTextMatches(LocErrorMgs, "Validation Msg", ExpectedText);

		//Organization
		clickUsingJSExecutor(Loc_AwardsOrganization1Row, "Awards Organization 1Row",AM_AwardsTabOrganization);
		sendKeys(Loc_AwardsOrganizationInput, AM_AwardsOrganization, "Organization Input", AM_AwardsTabOrganization);
		Enter();

		//Award
		clickUsingJSExecutor(Loc_AwardAward1Row, "Award Award 1Row", AM_AwardsTabAward);
		sendKeys(Loc_AwardsInput, AM_AwardsAward, "Awards Input", AM_AwardsTabAward);
		Enter();

		//Award Title
		clickUsingJSExecutor(Loc_AwardAwardTitle1Row, "Award Award Title 1Row",AM_AwardsTabAwardTitle);
		sendKeys(Loc_AwardAwardTitleInput, AM_AwardsAwardTitle, "Award Title Input", AM_AwardsTabAwardTitle);
		Enter();

		//Year
		clickUsingJSExecutor(Loc_AwardYear1Row, "Award Year 1Row",AM_AwardsTabYear);
		sendKeys(Loc_AwardYearInput, AM_AwardsYear, "AwardsYear Input", AM_AwardsTabYear);
		Enter();
		//Winner
		clickUsingJSExecutor(Loc_AwardWinner1Row, "Winner 1Row",AM_AwardsTabWinner);
		sendKeys(Loc_AwardWinnerinput, AM_AwardsWinner, "Winner input", AM_AwardsTabWinner); 
		Enter();

		//Status
		clickUsingJSExecutor(Loc_AwardStatus1Row, "Status 1Row", AM_AwardsTabStatus);
		sendKeys(Loc_AwardStatusInput, AM_AwardsStatus, "Status Input", AM_AwardsTabStatus); 
		Enter();
		//Participant Award
		///Participant Award Check
		clickUsingJSExecutor(Loc_AwardParticipantAward1Row, "Participant Award 1Row", AM_AwardsTabParticipantAward);
		Thread.sleep(1000);
		///Participant Award Uncheck
		clickUsingJSExecutor(Loc_AwardParticipantAward1Row, "Participant Award 1Row", AM_AwardsTabParticipantAward);
		Thread.sleep(1000);

		//Game Award
		//Check Game Award
		clickUsingJSExecutor(Loc_AwardGameAward1Row, "GameAward1Row", AM_AwardsTabGameAward);
		Thread.sleep(1000);
		//UnCheck	
		clickUsingJSExecutor(Loc_AwardGameAward1Row, "GameAward1Row", AM_AwardsTabGameAward);
		Thread.sleep(1000);

		//Edit Mode
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsOrganization_Key, AM_AwardsTabOrganization), AM_AwardsOrganization, "AM_AwardsOrganization Field", AM_AwardsTabOrganization, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsAward_Key, AM_AwardsTabAward), AM_AwardsAward, "AM_Awards Award Field", AM_AwardsTabAward, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsAwardTitle_Key, AM_AwardsTabAwardTitle), AM_AwardsAwardTitle, "AM_Awards Award Title", AM_AwardsTabAwardTitle, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsYear_Key, AM_AwardsTabYear), AM_AwardsYear, "AM_Awards Year", AM_AwardsTabYear, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsWinner_Key, AM_AwardsTabWinner), AM_AwardsWinner, "AM_Awards Winner", AM_AwardsTabWinner, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsStatus_Key, AM_AwardsTabStatus), AM_AwardsStatus, "AM_Awards Status", AM_AwardsTabStatus, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsParticipant_Key, AM_AwardsTabParticipantAward)+"/img", "Unchecked", "'AwardsTabParticipantAward' Check box status of First Data Row", AM_AwardsTabParticipantAward, "title");
		verifyFieldValueOfHeader(getLocator_EditTAB_DataRow("1", AM_AwardsGameAward_Key, AM_AwardsTabGameAward)+"/img", "Unchecked", "'AM_AwardsTabGameAward' Check box status of First Data Row", AM_AwardsTabGameAward, "title");

		//Save
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);	  

		//verify View Mode
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsOrganization_Key, AM_AwardsTabOrganization), AM_AwardsOrganization, "AM_AwardsOrganization Field", AM_AwardsTabOrganization, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsAward_Key, AM_AwardsTabAward), AM_AwardsAward, "AM_Awards Award Field", AM_AwardsTabAward, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsAwardTitle_Key, AM_AwardsTabAwardTitle), AM_AwardsAwardTitle, "AM_Awards Award Title", AM_AwardsTabAwardTitle, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsYear_Key, AM_AwardsTabYear), AM_AwardsYear, "AM_Awards Year", AM_AwardsTabYear, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsWinner_Key, AM_AwardsTabWinner), AM_AwardsWinner, "AM_Awards Winner", AM_AwardsTabWinner, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", AM_AwardsStatus_Key, AM_AwardsTabStatus), AM_AwardsStatus, "AM_Awards Status", AM_AwardsTabStatus, "innerHTML");
		verifyElementNotPresent(getLocator_ViewTAB_DataRow("1", AM_AwardsParticipant_Key, AM_AwardsTabParticipantAward)+"/img", "AwardsTabParticipantAward is Unchecked in View Mode");
		verifyElementNotPresent(getLocator_ViewTAB_DataRow("1", AM_AwardsGameAward_Key, AM_AwardsTabGameAward)+"/img", "AM_AwardsTabGameAward is Unchecked in View Mode");




		//TC_AM_AWRD_020
		//click on Delete button without selecting row and verify Alert Message 
		ExecutionLog.Log("click on Delete button without selecting row and verify Alert Message");
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		Thread.sleep(3000);

		//Delete Without selecting  Row  Alert 
		if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent3Xpath);

			String Expected = "Please select a row before clicking Delete.";
			verifyTextMatches(Loc_ErrorMsg, "Validation Msg", Expected);

		}else{ 
			driver.switchTo().window(driver.getWindowHandle());
			String AlertMessage = "Please select a row before clicking Delete.";
			verifyTextMatches(AlertTest, "Alert Msg", AlertMessage);
			clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button");

		}
		switchIntoFrame(frameParent3Xpath);
		//TC_AM_AWRD_022
		clickOn(Loc_Award1Row, "1 row ", "");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		String ConfirmAlertMsg = "Are you sure you want to delete the Award information?";
		verifyTextMatches(ConfMsgText, "Confirm Alert Msg", ConfirmAlertMsg);
		Thread.sleep(1000);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Confirm Cancel");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(LocCancel, "Cancel Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);

		//Select the Row and click on Delete button and verify Alert Message and Click on "Cancel" button at Award Edit Window
		ExecutionLog.Log("Select the Row and click on Delete button and verify Alert Message and Click on \"Cancel\" button at Award Edit Window");
		verifyElementDisplayed(Loc_Award1Row, "Award 1 Row", "");
		clickOn(Loc_Award1Row, "1 row ", "");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		String ConfirmAlertMsg1 = "Are you sure you want to delete the Award information?";
		verifyTextMatches(ConfMsgText, "Confirm Alert Msg", ConfirmAlertMsg1);
		Thread.sleep(1000);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(LocCancel, "Cancel Button");
		WaitForModalPanel();

		//Verify that Row was not deleted on canceling the changes
		ExecutionLog.Log("Verify that Row was not deleted on canceling the changes of Edit Award TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor(Loc_EditButton2, "Edit Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save);
		verifyElementDisplayed(Loc_Award1Row, "Award 1 Row", "");
		//TC_AM_AWRD_032
		//Select the Row and click on Delete button and verify Alert Message and Click on "OK" button to delete the row at Award Edit Window
		ExecutionLog.Log("Select the Row and click on Delete button and verify Alert Message and Click on \"OK\" button to delete the row at Award Edit Window");
		clickOn(Loc_Award1Row, "Award 1Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button");
		driver.switchTo().window(driver.getWindowHandle());
		String ConfirmAlertMsg2 = "Are you sure you want to delete the Award information?";
		verifyTextMatches(ConfMsgText, "Confirm Alert Msg", ConfirmAlertMsg2);
		Thread.sleep(1000);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Save, "Save Button");
		WaitForModalPanel();

	}


}



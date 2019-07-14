package assetMaintenance;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.RightsIN;

/**
 * @author Rajuddin
 * TC3_EpisodeRightVersion has an issue with whose bug id is 20337 for SalesDemo and ASTRO
 *
 */
@Listeners(utility.ListenerClass.class)
public class AM_Episode extends DriverHelper implements IAM_Episode{

	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();

	public AM_Episode() {
		super(AM_EpisodeColumnXpath, loc_Episode_EditEpisode_DataRow,
				loc_Episodes_ViewModeHeader, loc_Episodes_ViewModeDataRow);
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}

	@Test(priority =1,enabled= true,description = "Episode tab")
	public void TC1_EpisodeUI() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
		
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_002");
		ExecutionLog.Log("*****************The below are buttons in the Episode Wiondow at View Mode*****************");
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		verifyTextMatches(loc_Episodes_Edit, "Edit button", Episode_Edit, "value");
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("*****Verifying the Filters of 'Edit Episodes window'*****");
		verifyTextMatches(loc_Episodes_Filter1, "filter Criteria 1", Episode_FilterLabel1);
		verifyTextMatches(loc_Episodes_Filter2, "filter Criteria 2", Episode_FilterLabel2);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_003");
		ExecutionLog.Log("*****Verifying the Headers of 'Edit Episodes window'*****");
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_TitleKey+"']", "Title Header", Episode_TitleValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_Seasion+"']", "Season Header", Episode_SeasonValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_Episode_Number+"']", "Episode Number Header", Episode_Episode_NumberValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_TBAKey+"']", "TBA Header", Episode_TBAValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_AirDateKey+"']", "Air Date Header", Episode_AirDateValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SeasonOpenerKey+"']", "Season Opener Header", Episode_SeasonOpenerValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SeasonCloserKey+"']", "Season Closer Header", Episode_SeasonCloserValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SeriesOpener+"']", "Series Opener Header", Episode_SeriesOpenerValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SeriesCloser+"']", "Series Closer Header", Episode_SeriesCloserValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_AirOrder+"']", "AirOrder Header", Episode_AirOrderValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_ProgramDuration+"']", "Program Duration Header", Episode_ProgramDurationValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_Highlights+"']", "Highlights Header", Episode_HighlightsValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_Notes+"']", "Notes Header", Episode_NotesValue);
		// For VMN
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_IPS_AVAILABILITY_DATEKey+"']", "International Amortization Date Header", Episode_IPS_AVAILABILITY_DATEValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_Cue_Sheet_IDKey+"']", "Cue_Sheet_ID Header", Episode_Cue_Sheet_IDValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_VMIDKey+"']", "VMID Header", Episode_VMIDValue);

		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SYNDICATIONNOKey+"']", "VMID Header", Episode_SYNDICATIONNOValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SHORTNAMEKey+"']", "VMID Header", Episode_SHORTNAMEValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_FLAG_LIBRARYKey+"']", "VMID Header", Episode_FLAG_LIBRARYValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_RID_MATCH_CATEGORYKey+"']", "VMID Header", Episode_RID_MATCH_CATEGORYValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_RID_VENUEKey+"']", "VMID Header", Episode_RID_VENUEValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_RID_ROUND_OF_SERIESKey+"']", "VMID Header", Episode_RID_ROUND_OF_SERIESValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_RID_ASSET_CATEGORYKey+"']", "VMID Header", Episode_RID_ASSET_CATEGORYValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_LIST_OF_TEAMS_TEXTKey+"']", "VMID Header", Episode_LIST_OF_TEAMS_TEXTValue);
		verifyTextMatches(AM_EpisodeColumnXpath+"[@key='"+Episode_SEASON_NUMBERKey+"']", "VMID Header", Episode_SEASON_NUMBERValue);

		ExecutionLog.Log("");
		ExecutionLog.Log("*****Verifying the available Buttons at 'Edit Episodes window'*****");
		verifyTextMatches(loc_Episodes_CopyEpisodes, "Copy Episodes", Episode_CopyEpisodesValue, "value");
		verifyTextMatches(loc_Episodes_CopySeason, "CopySeason", Episodes_CopySeason, "value");
		verifyTextMatches(loc_Episodes_UpdateTool, "UpdateTool", Episodes_UpdateTool, "value");
		verifyTextMatches(loc_Episodes_Add, "Add Episodes", Episodes_Add, "value");
		verifyTextMatches(loc_Episodes_Delete, "Delete Episodes", Episodes_Delete, "value");
		verifyTextMatches(loc_Episodes_Save, "Save Episodes", Episodes_Save, "value");
		verifyTextMatches(loc_Episodes_Close, "Close Episodes", Episodes_Close, "value");
		verifyTextMatches(loc_Episodes_AddEpisodes, "Add Episodes", Episodes_AddEpisodes, "value");

		ExecutionLog.Log("");
		ExecutionLog.Log("*****Click on Delete Episodes, verify the Alert message and Click on OK button*****");
		clickUsingJSExecutor(loc_Episodes_Delete, "'Delete' Button at Episode window");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(OKAlertXpath, "Alert Message While deleting the Episode", Episodes_DoNotSelectEpisode_Delete_AlertMessage);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While deleting the Episode"); 
		switchIntoFrame(frameParent3Xpath);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_006");
		ExecutionLog.Log("******Click on 'Copy Episode', verify the Alert message and Click on OK button******");	
		clickUsingJSExecutor(loc_Episodes_CopyEpisodes, "'CopyEpisodes' Button at Episode window");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While Copying the Episode", Episodes_CopyEpisodes_AlertMessage);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While Copying the Episode"); 
		switchIntoFrame(frameParent3Xpath);

		ExecutionLog.Log("");
		ExecutionLog.Log("******Click on 'Copy Season', verify the Alert message and Click on OK button******");	
		clickUsingJSExecutor(loc_Episodes_CopySeason, "'Copy Season' Button at Episode window");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While Copying the Season", Episodes_Copyseason_AlertMessage);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While Copying the Season"); 
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
		driver.switchTo().window(driver.getWindowHandle());
		ExecutionLog.Log("*****Verifying the available Buttons at 'Add Episodes window'*****");
		verifyTextMatches(loc_Episodes_AddEpisodesWindowMessage, "AddEpisodes Window Header", Episodes_AddEpisodesWindowMessage);
		verifyTextMatches(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' button AddEpisodes Window", Episodes_OKButton_AddEpisodesWindow,"value");
		verifyTextMatches(loc_Episodes_Cancel_AddEpisodesWindow, "'Cancel' button AddEpisodes Window", Episodes_Cancel_AddEpisodesWindow,"value");

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_011");
		sendKeys(loc_EpisodeAddWindow,"1-5","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Episodes_FirstRow_EpisodesEditWindow);

		//// Select Season 1 for Episode 1 and Verify the default season for Episode 2
		ExecutionLog.Log("******Select Season 1 for Episode 1 and Verify the default season for Episode 2*****");
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of First Row");
		sleepTime(1);
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		verifyTextMatches(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "'deafult' value for 2nd Episodes of Edit Episode window after selecting 'Season 1' for 'Episode 1'", Season1);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("******Select Season 2 for Episode 2 and Verify the default season for Episode 3*****");
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "Season Field of Episode002");
		sleepTime(2);
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season2), Season2);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		verifyTextMatches(loc_SeasonField_OF_RowNumber.replace("@var", "3"), "'deafult' value for 3rd Episodes of 'Edit Episode Window' after selecting 'Season 2' for 'Episode 2'", Season2);
		sleepTime(3);

		ExecutionLog.Log("");
		ExecutionLog.Log("******Select Season 3 for Episode 3 and Verify the default season for Episode 4*****");
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "3"), "Season Field of Episode002");
		sleepTime(5);
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season3), Season3);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		// Delete after applying this: expected for other customers : Season 2.Original Version
		verifyTextMatches(loc_SeasonField_OF_RowNumber.replace("@var", "4"), "'deafult' value for 4th Episodes of 'Edit Episode Window' after selecting 'Season 3' for 'Episode 3'", Season3);
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);


		// Duplicacy is only allowed for AMCN. Controlling based on the client without using excel file
		if(!(ClientData.equals("AMCN") || ClientData.equals("SALESDEMO")|| ClientData.equals("SKY"))) {
			
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_018");
			ExecutionLog.Log("*******verify that 'Same Episode Numbers with the Same Rights Version Type are not allowed.'  *****");
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_Add, "'Add Episodes' at Episode window"); 
			driver.switchTo().window(driver.getWindowHandle());
			sendKeys(loc_EpisodeAddWindow,"1","Add Episode input field",Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK Button' at AddEpisode window");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_SeasonField_OF_RowNumber.replace("@var", "6")));
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "6"), "Season Field of Episode006");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			sleepTime(3);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", Episodes_SameEpiWithWSameVersion_AlertMessage);
			clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "8"), "Episode Number", Episode_Episode_NumberValue);
			sendKeys(loc_Episodes_EpisodesNumber_InputField, "6", "Episodes Number", Episode_Episode_NumberValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(loc_Episodes_Save);
			// Manual Test Step : TC_2.5_Episode Tab_025
			clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
			sleepTime(6);
		}

	}

	@Test(priority =2,enabled= true,description = "Auto generated Episode Numbers")
	public void TC2_EpisodeAutoNo() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************The below are buttons in the window*****************");
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		verifyTextMatches(loc_Episodes_Edit, "Edit button", Episode_Edit, "value");

		//Edit Episode   
		ExecutionLog.Log("");
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow, "1","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK Button' at AddEpisode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		ExecutionLog.Log("");
		ExecutionLog.Log("******Select Season 1 for Episode 1 and Verify the default season for Episode 2*****");
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of First Row");
		sleepTime(1);
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "10"), "Initial Air Date", Episode_AirDateValue);
		sendKeys(loc_Episodes_InitialAirDate_InputField, "01/01/2014", "Episodes_InitialAirDate_InputField", Episode_AirDateValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select Initial Air Date");
		sleepTime(3);
		
		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_08");
		clickUsingJSExecutor(loc_Episodes_NoteImageIcon, "Note Image Icon", Episode_NotesValue);
		switchIntoFrame(frameParent4Xpath);
		clickOn(loc_Note_Restriction, "Note_Restriction Check Box");
		WaitForElementPresent(Applybutton_AtSBUWindow);
		sendKeys(loc_NoteBody, "RSG Test", "Note Body", Episode_NotesValue);
		clickUsingJSExecutor(Applybutton_AtSBUWindow, "OK button at Note Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Save_UseWithNameAttribute);
		clickUsingJSExecutor(loc_Save, "Save Button at 'Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_14");
		ExecutionLog.Log("Verify that \"Asset/Property/Episode Id\" is system generated");
		//Verify the Asset Id
		if(ClientData.equalsIgnoreCase("TURNER") || ClientData.equalsIgnoreCase("VMN")){
			String AssetID = getText(loc_Episodes_AssetID_OR_SourceSystem__ViewMode);
			ExecutionLog.Log("System Generated Asset/Property/Episode Id is: -" + AssetID);
			try {
				if( Integer.parseInt(AssetID)>0){

				}
			} catch (Exception e) {
				ExecutionLog.Log("=====Failed===== Please check auto generated System ID is not a Number" + AssetID);
				e.printStackTrace();
			}

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_15");
			ExecutionLog.Log("View Mode : Verify Source System Name in View mode");
			verifyTextMatches(loc_Episodes_SourceSystem_ViewMode, "Source System Name", "RL" , "title");

		} else if(ClientData.equalsIgnoreCase("SKY") || ClientData.equalsIgnoreCase("AMCN") || ClientData.equalsIgnoreCase("CORUS") ||ClientData.equalsIgnoreCase("ASTRO")) {

			String AssetID = getText(loc_Episodes_AssetID_OR_SourceSystem__ViewMode);
			ExecutionLog.Log("System Generated Asset/Property/Episode Id is: -" + AssetID);
			try {
				if( Integer.parseInt(AssetID)>0){

				}
			} catch (Exception e) {
				ExecutionLog.Log("=====Failed===== Please check auto generated System ID is not a Number" + AssetID);
				e.printStackTrace();
			}
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_15");
			ExecutionLog.Log("View Mode : Verify Source System Name in View mode");
			verifyTextMatches(loc_Episodes_SourceSystem_ViewMode, "Source System Name", "RL" , "title");

		} else {
			ExecutionLog.Log("=====Info===== System Generated Asset/Property/Episode Id and Source System Name are not applicable for : -" + ClientData);
		}

	}
	
	// 20337 Issue for ASTRO and SalesDemo
	@Test(priority =3,enabled= true,description = "Rights Version Type with User-Defined Season Name")
	public void TC3_EpisodeRightVersion() throws Exception {
		if(!(ClientData.contains("ASTRO") || ClientData.contains("SALESDEMO"))) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
			assetMaintenance.selectAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);
			clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
			driver.switchTo().window(driver.getWindowHandle());
			sendKeys(loc_EpisodeAddWindow,"1-2","Add Episode input field",Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_FirstRow_EpisodesEditWindow));
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			sleepTime(3);
			
			ExecutionLog.Log("");
			ExecutionLog.Log("*****************Change season of Episode002 to Season 2 from Season 1*****************");
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "Season Field of Episode002");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", Season2), Season2);		
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");		
			sleepTime(3); 
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(loc_Episodes_Save);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			
			ExecutionLog.Log("");
			ExecutionLog.Log("*****************Verify that Airing order does not change after changing the Season of Episode002*******");
			verifyFieldValueOfHeader(getLocatorFor_AiringOrder_Field("2"), "2", "Airing Order", Episode_AirOrderValue, "innerHTML");
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);
			ExecutionLog.Log("*******Change Episode's season name and airing order*******");
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "2"), "Season Field of Episode002");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");

			ExecutionLog.Log("");
			ExecutionLog.Log("*******Uncheck Season Closed for Episode 1*******");
			String loc_ClosedCheckBox = loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "22")+"/img";
			if(!(Episode_SeasonCloserValue.contains("N/A"))){
				if(getAttribute(loc_ClosedCheckBox, "title").equals("Checked")){
					clickOn(loc_ClosedCheckBox, "UnCheck Season closed Check Box", Episode_SeasonCloserValue);
				}
			}
			sleepTime(3);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(loc_Episodes_Save);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);
			verifyFieldValueOfHeader(getLocatorFor_AiringOrder_Field("1"), "1", "Airing Order", Episode_AirOrderValue, "innerHTML");
			//Verify that Airing order does not change after changing the Season of Episode002 
			verifyFieldValueOfHeader(getLocatorFor_AiringOrder_Field("2"), "2", "Airing Order does not change after changing the Season of Episode002", Episode_AirOrderValue, "innerHTML");

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_07");
			ExecutionLog.Log("*****Verify that Airing order can not be duplicate*****");
			clickOn(getLocatorFor_AiringOrder_Field("2"),"Airing Order",Episode_AirOrderValue);
			sendKeys(loc_Episodes_AiringDate_InputField, "1", "Airing Order for Row 2", Episode_AirOrderValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season", Episode_AirOrderValue);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'", Episode_AirOrderValue);
			WaitForModalPanel();
			verifyFieldValueOfHeader(OKAlertXpath, Episodes_SameAiringOrder_Delete_AlertMessage, "Alert Message for duplicate Airing Order", Episode_AirOrderValue);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert duplicate Airing Order", Episode_AirOrderValue); 
			switchIntoFrame(frameParent3Xpath);


			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_11");
			ExecutionLog.Log("*****Check the Season User Defined check box and Click on the Season title field.*****");
			clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
			driver.switchTo().window(driver.getWindowHandle());
			sendKeys(loc_EpisodeAddWindow,"7","Add Episode input field", Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "3").replace("@col", "3")+"/img", "user defined check box", Episode_SeasonValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to check user-defined check box");
			clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "3").replace("@col", "4"), "Episode 003's season field", Episode_SeasonValue);
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(OKButton);

			ExecutionLog.Log("");
			ExecutionLog.Log("**********Verifying 'Edit Season pop up' fields AND Buttons************");
			verifyTextMatches(loc_Episodes_EditSeason_SeriesTitle, "Episodes_EditSeason_Series title Label", "Title");
			verifyTextMatches(loc_Episodes_EditSeason_userDefinedLabel, "Episodes_EditSeason_userDefinedLabel", "User-defined Season Name");
			verifyTextMatches(OKButton, "OK button", "OK", "value");
			verifyTextMatches(LocCancel, "Cancel button", "Cancel", "value");
			sendKeys(loc_Episodes_EditSeason_userDefined_InputField, "Test Season", "Episodes_EditSeason_userDefined Field", Episode_SeasonValue);
			clickUsingJSExecutor(loc_OkButton, "OKButton at EditSeason pop-up",Episodes_EditEpisodes_Userdefined_EditSeasonLabel);

			
			if(!Episodes_EditEpisodes_Userdefined_EditSeasonLabel.contains("N/A")) {
				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_13");
				ExecutionLog.Log("*****Verify Validation Message \"Please Enter Rights Version Type for this Season\"*****");
				driver.switchTo().window(driver.getWindowHandle());
				verifyFieldValueOfHeader(OKAlertXpath, Episodes_DoNotEnerVersionType_AlertMessage, "Alert Message While for User-defined Season", Episodes_EditEpisodes_Userdefined_EditSeasonLabel);
				sleepTime(3);
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While for User-defined Season");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				selectDropdownValue(loc_Episodes_EditEpisodes_Userdefined_EditSeasonDropDown, "Episodes_EditEpisodes_Userdefined_EditSeason", "Original Version", Episodes_EditEpisodes_Userdefined_EditSeasonLabel);
				clickUsingJSExecutor(OKButton, "OKButton", Episode_SeasonValue);
				switchIntoFrame(frameParent3Xpath);
				WaitForElementPresent(loc_EpisodeAdd);
				clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				WaitForElementToClickable(loc_Episodes_Save);
				clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				WaitForElementPresent("name="+loc_EditButtonEpisodes);
			}
			
		} else {
			throw new SkipException("BUG ID: 20337 For Astro and SalesDemo");
		}
	}
	
	@Test(priority =4,enabled= true,description = "Deleting Episode from the Episode Tab")
	public void TC4_EpisodeDelete() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);

		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"1-5","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		switchIntoFrame(frameParent3Xpath);

		WaitForElementPresent(By.xpath(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2")));
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_07");
		ExecutionLog.Log("*****Verify the Validation message\"Please select at least one Episode before clicking Remove\"******");
		clickUsingJSExecutor(loc_Episodes_Delete, "'Delete Button' at Episode window");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While deleting the Episode", Episodes_DoNotSelectEpisode_Delete_AlertMessage);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While deleting the Episode"); 
		switchIntoFrame(frameParent3Xpath);


		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step :TC_2.5_Episode Tab_11");
		ExecutionLog.Log("*****Delete the First Episode******");
		clickOn(loc_Episode_SelectRow.replace("@row", "1"), "Select First Row of Episodes");
		clickUsingJSExecutor(loc_Episodes_Delete, "'Delete Button' at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Alert Message While DeleteEpisodes", DeleteEpisodes_AlertMessage);

		WaitForElementPresent("name=" + OKButton);
		switchIntoFrame(frameParent4Xpath);
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton", Episode_SeasonValue);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		verifyTextMatches(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2"), "First Episodes name in first row of Episode after deleting Episodes001", "Episode002");
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		sleepTime(6);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);

		//View mode	
		verifyTextMatches(loc_Episodes_Episodesfields_ViewMode.replace("@row", "1").replace("@col", "1"), "First Episodes name in first row of Episode after deleting Episodes001 in VIEW MODE", "Episode002");

	}
	
	// BUG ID: 20379 for ASTRO : #Code Line 761
	@Test(priority =5,enabled= true,description = "Copy Episode")
	public void TC5_EpisodeCopy() throws Exception {
		if(!(ClientData.contains("ASTRO"))) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
			String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";

			assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
			assetMaintenance.AddingEpisodeToAssetWithoutPremdt(createdSeriesAssetTitle);
			rightsIN.createDeal(CreatedDeal1);
			rightsIN.associateAssetWithDeal(CreatedDeal1, createdSeriesAssetTitle);
			assetMaintenance.selectAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocAdd);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);
			switchIntoFrame(frameParent3Xpath);

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_6");
			ExecutionLog.Log("*****Select the Episode and check functionality of Copy Episode******");
			clickOn(loc_Episode_SelectRow.replace("@row", "1"), "Select First Row of Episodes");
			doubleClick(loc_Episode_SelectRow.replace("@row", "1"), "Select First Row of Episodes");

			// 'Copy Episodes Window' is applicable for "VMN, SalesDemo, CORUS"
			if(!(CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton.contains("N/A"))){
				// Deal Creation is require if Copy Asset Window is applicable on clicking copy episode
				clickUsingJSExecutor(loc_Episodes_CopyEpisodes, "'CopyEpisodes' Button at Episode window");
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(ByLocator(loc_OkButton));

				ExecutionLog.Log("**********The below are Copy Episode pop up fields ************");
				verifyTextMatches(loc_Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton, "CreateNewAsset_RadioButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
				verifyTextMatches(loc_Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton, "LinkAssettoDeal_RadioButton", CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton);

				verifyFirstSelectedDropdownValue(loc_Episodes_CopyEpisodes_CopyAssetWindow_Versionselector, "CopyEpisodeWindow", CopyEpisodes_CopyAssetWindow_Versionselector_FirstOption, CopyEpisodes_CopyAssetWindow_Versionselector_FirstOption);
				ExecutionLog.Log("**********The below are Copy Episodes window Buttons************");
				verifyTextMatches(OKButton, "OK button", "OK", "value");
				verifyTextMatches(LocCancel, "Cancel button", "Cancel", "value");

				clickOn(loc_Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton, "Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
				clickUsingJSExecutor(OKButton, "OKButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);

			}else {
				clickUsingJSExecutor(loc_Episodes_CopyEpisodes, "'CopyEpisodes' Button at Episode window");
			}

			WaitForModalPanel();
			
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_9 to TC_2.5_Episode Tab_11");
			ExecutionLog.Log("*****Verify the Episode Name, Season Name and Episode Number of the copied Episode*****");
			switchIntoFrame(frameParent3Xpath);
			String EpisodeName = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "5").replace("@col", "2"));
			ValidationMessageInPage(EpisodeName, "Copy of Episode101", "Copied Episode");

			String SeasonName = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "5").replace("@col", "4"));
			ValidationMessageInPage(SeasonName, Season1, "Season Name of Copied Episode 'Copy of Episodes101'");

			String EpisodeNo = getAttribute(getLocatorFor_EpisodeNumber_Field("5"),"innerHTML");
			ValidationMessageInPage(EpisodeNo, "101", "Episode Number of Copied Episode 'Copy of Episodes101'");

			ExecutionLog.Log("******************************(Select All) in the Filter Drop down**************************************************");
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			sendKeys(loc_Episodes_Filter1DropDown, "(Select All)", "Episodes_Filter1DropDown", Episode_FilterLabel1);
			sleepTime(2);
			switchIntoFrame(frameParent3Xpath);

			ExecutionLog.Log("*****Change the Airing Order so that Copied Episodes can be saved*****");
			doubleClick(getLocatorFor_AiringOrder_Field("2"),"Airing Order", Episode_AirOrderValue);
			sleepTime(3);
			//ExecutionLog.Log("=====BUG ID: 20379 for ASTRO");
			sendKeys(loc_Episodes_AiringDate_InputField, "7", "Airing Order for Row 5", Episode_AirOrderValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season", Episode_AirOrderValue);
			clickOn(getLocatorFor_TBA_Field("1"), "TBA Check Box", Episode_TBAValue);

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_13");
			ExecutionLog.Log("*****Change Episode Number of Copied Episode and verify that changes are applied successfully******");
			clickOn(getLocatorFor_EpisodeNumber_Field("2"), "Episode Number in row 5", Episode_Episode_NumberValue);
			sendKeys(loc_Episodes_EpisodesNumber_InputField, "301", "Episodes Number", Episode_Episode_NumberValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click");
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(loc_Episodes_Save);
			sleepTime(2);
			sendKeys(loc_Episodes_Filter1DropDown, "(Select All)", "Episodes_Filter1DropDown", Episode_FilterLabel1);
			sleepTime(2);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);


			// The position of copied Episodes is changed from 5th row to 3rd row after clearing filter
			ExecutionLog.Log("*****Verify #Episode Number has been changed******");
			verifyFieldValueOfHeader(getLocatorFor_EpisodeNumber_Field("3"), "301", "Episode Number of Newly copied Episode", Episode_Episode_NumberValue);
			clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
			sleepTime(6);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			//HomeIcon
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(HomeIconXpath, "Home Icon");
			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_16");
			ExecutionLog.Log("******Verify that Copied Episode is not shown in Deal Navigator*****");
			//Check copied episode in deal
			rightsIN.navigateToRightsIN();
			rightsIN.searchCreatedDeal(CreatedDeal1);

			//Deal Navigator
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(loc_DealNavigator, "Deal Navigator");
			sleepTime(6);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_DealNavigatorWindow_DealName));
			clickOn(loc_DealNavigatorWindow_AssetSeriesExpandIcon, "DealNavigatorWindow_AssetSeriesExpandIcon");
			clickOn(loc_DealNavigatorWindow_1stSeason_ExpandIcon, "DealNavigatorWindow_1stSeason_ExpandIcon");
			clickOn(loc_DealNavigatorWindow_2ndSeason_ExpandIcon, "DealNavigatorWindow_2ndSeason_ExpandIcon");
			ExecutionLog.Log("Verifying that Copied Episode is not shown at the Deal Navigator");
			Assert.assertFalse(isElementPresent(loc_DealNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.301: Copy of Episode101")));
			ExecutionLog.Log("\"Ep.301: Copy of Episode101\" is not shown at the Deal Navigator");

			if (Browser.equalsIgnoreCase("firefox")){
				clickOn("name="+loc_OkButton, "OKButton");
			} else {
				clickUsingJSExecutor("name="+loc_OkButton, "OKButton");
			}
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			//HomeIcon
			clickUsingJSExecutor(HomeIconXpath, "Home Icon");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);	

			//Searching  the Series  Asset 
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			assetMaintenance.selectAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);

			//Edit Episode   
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);

			if(!(CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton.contains("N/A"))){
				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_26");
				
				clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				moveMouse(loc_Episode_SelectRow.replace("@row", "1"), "Select First Row of Episodes");
				doubleClick(loc_Episode_SelectRow.replace("@row", "1"), "Select First Row of Episodes");

				clickUsingJSExecutor(loc_Episodes_CopyEpisodes, "'CopyEpisodes' Button at Episode window");
				sleepTime(3);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(ByLocator(loc_OkButton));

				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_28");
				ExecutionLog.Log("*****Select the Rights Version type \"VOD Version\" and press ok. ******");
				clickOn(loc_Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton, "Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton", CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton);
				selectDropdownValue(loc_Episodes_CopyEpisodes_CopyAssetWindow_Versionselector, "Episodes_CopyEpisodes_CopyAssetWindow_Versionselector", "VOD Version", Episodes_CopyEpisodes_CopyAssetWindow_Versionselector);
				clickUsingJSExecutor(OKButton, "OKButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);

				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step :TC_2.5_Episode Tab_30");
				ExecutionLog.Log("*****Check the Episode Name, Season Name and Episode Number of the Version Episode. ******");
				String EpisodeName_Row6 = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "6").replace("@col", "2"));
				ValidationMessageInPage(EpisodeName_Row6, "Episode101", "Copied Episode by checking the Radio button at 'Copy Episode window'");
				String SeasonName_Row6 = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "6").replace("@col", "4"));
				ValidationMessageInPage(SeasonName_Row6, "Season 1.VOD Version", "Copied Episode");
				String EpisodeNumber_Row6 = getText(getLocatorFor_EpisodeNumber_Field("6"));
				ValidationMessageInPage(EpisodeNumber_Row6, "101", "Episode Number of Copied Episode");
				clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		    
				WaitForModalPanel();
				switchIntoFrame(frameParent3Xpath);
				WaitForElementToClickable(loc_Episodes_Save);
				clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				WaitForElementPresent("name="+loc_EditButtonEpisodes);
				switchIntoFrame(frameParent2Xpath);


				//// Navigate to Asset Navigator
				clickUsingJSExecutor(loc_AssetNavigator, "Asset Navigator");

				if(ClientName.contains("TURNER")){
					switchIntoFrame(frameParent4Xpath);
				}else{
					switchIntoFrame(frameParent3Xpath);
				} 
				WaitForElementPresent("name="+loc_OkButton);

				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_35");
				ExecutionLog.Log("*****Verify Copied Episode are shown at Asset Navigator******");
				verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var","Season 1.VOD Version"), "Season 1 at Asset Navigator", "Season 1.VOD Version");
				verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var","Ep.101: Episode101"), "Episode101 at Asset Navigator", "Ep.101: Episode101");
				if (Browser.equalsIgnoreCase("firefox")){
					driver.findElement(By.name("btnOK")).click();
				} else{ 
					clickUsingJSExecutor("name="+loc_OkButton, "OK Button");
				}

				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				//HomeIcon
				clickUsingJSExecutor(HomeIconXpath, "Home Icon");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);		    

				//Check copied version in deal
				rightsIN.navigateToRightsIN();
				rightsIN.searchCreatedDeal(CreatedDeal1);

				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				//Deal Navigator	
				clickUsingJSExecutor(DealNavigatorMenuBar, "DealNavigator at MenuBar");
				sleepTime(6);	
				switchIntoFrame(frameParent3Xpath);
				WaitForElementPresent(ByLocator(loc_DealNavigatorWindow_DealName));
				clickOn(loc_DealNavigatorWindow_AssetSeriesExpandIcon, "DealNavigatorWindow_AssetSeriesExpandIcon");
				clickOn(loc_DealNavigatorWindow_1stSeason_ExpandIcon, "DealNavigatorWindow_1stSeason_ExpandIcon");
				clickOn(loc_DealNavigatorWindow_2ndSeason_ExpandIcon, "DealNavigatorWindow_2ndSeason_ExpandIcon");
				clickOn(loc_DealNavigatorWindow_3rdSeason_ExpandIcon, "DealNavigatorWindow_3rdSeason_ExpandIcon");

				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_46");
				ExecutionLog.Log("*****Verify Copied Episode are shown at Deal Navigator******");
				verifyTextMatches(loc_DealNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Season 1.VOD Version"), "Season 1 at Deal Navigator", "Season 1.VOD Version");
				ExecutionLog.Log("Verified that the Copied version is available at Deal Navigator");

				verifyTextMatches(loc_DealNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.101: Episode101"), "Season 1 at Deal Navigator", "Ep.101: Episode101");
				ExecutionLog.Log("Verified that the Copied episode is available at Deal Navigator");

				if (Browser.equalsIgnoreCase("firefox")){
					clickOn("name="+loc_OkButton, "OKButton");
				} else {
					clickUsingJSExecutor("name="+loc_OkButton, "OKButton");
				} 
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);
				//HomeIcon
				clickUsingJSExecutor(HomeIconXpath, "Home Icon");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);

				//Searching  the Movie  Asset 
				assetMaintenance.navigateToAssetMaintenance();
				switchIntoFrame(frameParent2Xpath);
				assetMaintenance.selectAsset(createdSeriesAssetTitle);
				switchIntoFrame(frameParent2Xpath);
				clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				WaitForElementPresent("name="+loc_EditButtonEpisodes);

				selectDropdownValue(loc_Episodes_Filter1DropDown, "Season Selector at Episode TAB", "(Select All)", "Season Selector at Episode TAB");
				WaitForModalPanel();
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);

				ExecutionLog.Log("");
				ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_36");
				ExecutionLog.Log("***** View mode - check the different versions******");
				clickOn(loc_Episodes_ViewModeDataRow + "//td[contains(text(),'VOD')]", "Episode having VOD Versions in view Mode","Click On VOD");
				clickUsingJSExecutor(loc_Episodes_EditEpisodes, "Episodes_EditEpisodes");
				driver.switchTo().window(driver.getWindowHandle());
				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
				sleepTime(6);
				switchIntoFrame(frameParent2Xpath);
				switchIntoChildFrame(frameParent21Xpath);
				WaitForElementPresent(ByLocator(loc_Edit));
				verifyElementPresent(loc_GroupVersionHeaderDifferentHeader.replace("@var", "Different Rights"), "Versions (Different Rights)");
				String loc_ViewVersion_VersionTypeField = getLocator_ViewVersion_RightVersion_DataRow("1", AMVerVersionTypeKey, VersionTypeHeader);
				verifyFieldValueOfHeader(loc_ViewVersion_VersionTypeField, "Original Version","Version Name Field at Edit Version window", VersionTypeHeader);

				String loc_ViewVersion_3rdRow_VersionTypeField = getLocator_ViewVersion_RightVersion_DataRow("2", AMVerVersionTypeKey, VersionTypeHeader);
				verifyFieldValueOfHeader(loc_ViewVersion_3rdRow_VersionTypeField, "VOD Version","Version Name Field at Edit Version window", VersionTypeHeader);
			}
		} else {
			throw new SkipException("BUG ID: 20379 for ASTRO");
		}
	}

	@Test(priority =6,enabled= true,description = "Copy Season")
	public void TC6_EpisodeCopySeason() throws Exception {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";	
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(createdSeriesAssetTitle);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		ExecutionLog.Log("");
		ExecutionLog.Log("*****************The below are buttons in the window*****************");
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		verifyTextMatches(loc_Episodes_Edit, "Edit button", Episode_Edit, "value");

		//Edit Episode   
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_1");
		ExecutionLog.Log("*****Copy Episode : Multiple select using Ctrl Key	- Episodes****");
		Robot robot = new Robot();
		sleepTime(2);
		clickOn(loc_Episode_SelectRow.replace("@row", "1"), "first Row");
		doubleClick(loc_Episode_SelectRow.replace("@row", "1"), "first Row");
		robot.keyPress(KeyEvent.VK_CONTROL);
		sleepTime(3);
		clickOn(loc_Episode_SelectRow.replace("@row", "2"), "Second Row");
		clickUsingJSExecutor(loc_Episodes_CopySeason, "Episodes_CopySeason", Episodes_CopySeason);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While Copying season after selecting multiple Episodes", Episodes_SelectSingleEpisodeToCopySeason);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert While deleting the Episode"); 
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		
		WaitForModalPanel();

		
		// Copy Episodes Window is applicable for "VMN, SalesDemo, CORUS"
		if(!(CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton.contains("N/A"))){
			// Deal Creation is require if Copy Asset Window is applicable on clicking copy episode
			String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
			rightsIN.createDeal(CreatedDeal1);
			rightsIN.associateAssetWithDeal(CreatedDeal1, createdSeriesAssetTitle);
			assetMaintenance.selectAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			
			
			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_6");
			ExecutionLog.Log("*******Select the Episode and Copy Season**********");			
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_Episode_SelectRow.replace("@row", "1"), "first Row");
			doubleClick(loc_Episode_SelectRow.replace("@row", "1"), "first Row");
			clickUsingJSExecutor(loc_Episodes_CopySeason, "Episodes_CopySeason", Episodes_CopySeason);
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(loc_OkButton);

			//Verify the Radio Buttons of \"Copy Season pop up fields\"
			ExecutionLog.Log("**********Verify the Radio Buttons of \"Copy Season pop up fields\" ************");
			verifyTextMatches(loc_Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton, "CreateNewAsset_RadioButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
			verifyTextMatches(loc_Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton, "LinkAssettoDeal_RadioButton", CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton);


			String RightsVersiontype = new Select(driver.findElement(ByLocator(loc_Episodes_CopyEpisodes_CopyAssetWindow_Versionselector))).getFirstSelectedOption().getText();
			ValidationMessageInPage(RightsVersiontype, CopyEpisodes_CopyAssetWindow_Versionselector_FirstOption, "CopyEpisodeWindow");
			ExecutionLog.Log("**********The below are Copy Episodes window Buttons************");
			verifyTextMatches(OKButton, "OK button", "OK", "value");
			verifyTextMatches(LocCancel, "Cancel button", "Cancel", "value");

			ExecutionLog.Log("******************************************************");
			clickUsingJSExecutor(loc_Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton, "Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
			clickUsingJSExecutor(OKButton, "OKButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_EpisodeAdd);

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_8");
			ExecutionLog.Log("**********Verify the Episode Name and Season name of copied Season************");	
			verifyTextMatches(loc_Episode_Pass_RowAndHeaderNumber_To_SelectRow.replace("@row", "6").replace("@col", "2"),  "Copy of Episode102", "Copy of Episode102");
			verifyTextMatches(loc_Episode_Pass_RowAndHeaderNumber_To_SelectRow.replace("@row", "5").replace("@col", "4"), "Copy of "+ Season1, "Copy of 'Season 1.Original Version' OR 'Copy of Season 1'");
			verifyTextMatches(getLocatorFor_EpisodeNumber_Field("5"), "Episode Number for Row1", "101");
			verifyTextMatches(getLocatorFor_EpisodeNumber_Field("6"), "Episode Number for Row2", "102");
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
			sleepTime(3);
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			sleepTime(2);

			ExecutionLog.Log("Change the Airing Order so that Episodes can be saved");
			switchIntoFrame(frameParent3Xpath);
			clickOn(getLocatorFor_AiringOrder_Field("1"),"Airing Order", Episode_AirOrderValue);
			sendKeys(loc_Episodes_AiringDate_InputField, "5", "Airing Order for 1st Row", Episode_AirOrderValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			clickOn(getLocatorFor_TBA_Field("5"), "TBA Check Box 5th Row", Episode_TBAValue);
			clickOn(getLocatorFor_AiringOrder_Field("2"),"Airing Order", Episode_AirOrderValue);
			sendKeys(loc_Episodes_AiringDate_InputField, "6", "Airing Order for 1st Row", Episode_AirOrderValue);
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			clickOn(getLocatorFor_TBA_Field("6"), "TBA Check Box 6th Row", Episode_TBAValue);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(loc_Episodes_Save);
			clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
			sleepTime(6);
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);	
			//HomeIcon
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(HomeIconXpath, "Home Icon");
			driver.switchTo().window(driver.getWindowHandle()); 
			WaitForModalPanel();
			sleepTime(3);
			switchIntoFrame(frameParent2Xpath);

			ExecutionLog.Log("");
			ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_13");
			ExecutionLog.Log("Check copied episode and season in Deal Navigator");			
			rightsIN.navigateToRightsIN();
			rightsIN.searchCreatedDeal(CreatedDeal1);
			sleepTime(6);
			switchIntoFrame(frameParent2Xpath);
			//Deal Navigator
			clickUsingJSExecutor(loc_DealNavigator, "Deal Navigator");	
			sleepTime(6);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_DealNavigatorWindow_DealName));
			clickOn(loc_DealNavigatorWindow_AssetSeriesExpandIcon, "DealNavigatorWindow_AssetSeriesExpandIcon");
			clickOn(loc_DealNavigatorWindow_1stSeason_ExpandIcon, "DealNavigatorWindow_1stSeason_ExpandIcon");
			clickOn(loc_DealNavigatorWindow_2ndSeason_ExpandIcon, "DealNavigatorWindow_2ndSeason_ExpandIcon");
			clickOn(loc_DealNavigatorWindow_3rdSeason_ExpandIcon, "DealNavigatorWindow_3rdSeason_ExpandIcon");
			ExecutionLog.Log("*****Verify the Episodes which were created while Copying the Season are not shown at the Deal Navigator*****");
			verifyElementNotPresent(loc_DealNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Copy of Season 1.Original Version"), "Season of Copied Season");
			ExecutionLog.Log("\"Copy of Season 1.Original Version\" is not shown at the Deal Navigator");
			verifyElementNotPresent(loc_DealNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.101: Copy of Episode101"), "Episode of Copied Season");
			ExecutionLog.Log("\"Ep.101: Copy of Episode101\" is not shown at the Deal Navigator");
			if (Browser.equalsIgnoreCase("firefox")){
				clickOn("name="+loc_OkButton, "OKButton");

			} else {
				clickUsingJSExecutor("name="+loc_OkButton, "OKButton");
			} 
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			//HomeIcon
			clickUsingJSExecutor(HomeIconXpath, "Home Icon"); 
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);	
		}

	}

	//TODO This Method takes more than 20 minutes and halt the script hence disabling
	@Test(priority =7,enabled= false,description = "Season Filter")
	public void TC7_SeasonFilters() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		ExecutionLog.Log("*****************The below are buttons in the EditEpisodes Window*****************");
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		verifyTextMatches(loc_Episodes_Edit, "Edit button", Episode_Edit, "value");
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		WaitForModalPanel();
		sleepTime(3);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_6");
		ExecutionLog.Log("create 1-300 Episodes and select Season 1 for All Episodes");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"1-300","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		switchIntoFrame(frameParent3Xpath);

		//WaitForElementToClickable(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2"));
		WaitForElementToClickable(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_6");
		ExecutionLog.Log("Create 301-600 Episodes and select Season 2 for All Episodes");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"301-600","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season2), Season2);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);


		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"601-900","Add Episode input field",Episodes_Add);
		/////////// Below Steps were not found in Manual Test Cases///////////////////
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season3), Season3);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");		
		WaitForModalPanel();

		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(ByLocator(loc_EpisodesWindowSave));
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		sleepTime(6); 
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);

		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);


		//Default values in the window
		ExecutionLog.Log("**********The default values for the filter functionality ************");
		String Dropdownseason = new Select(driver.findElement(ByLocator(loc_Episodes_Filter1DropDown))).getFirstSelectedOption().getText();
		ValidationMessageInPage(Dropdownseason, Season3, "TC7_EpisodeFilters_Season3");
		switchIntoFrame(frameParent3Xpath);
		ExecutionLog.Log("**********The dropdown values of season filter ************");
		verifyDropDownValues(loc_Episodes_Filter1DropDown, "Episodes_Filter1 DropDown Values", "AM_Episode", 115, 118);
		selectDropdownValue(loc_Episodes_Filter1DropDown, "filter 1", Season1, Season1);

		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		String DefaultEpisodes1 = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "4"));
		ValidationMessageInPage(DefaultEpisodes1, Season1, "Season of First Row");

		selectDropdownValue(loc_Episodes_Filter1DropDown, "filter 1", Season2, Season2);
		sleepTime(5);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		DefaultEpisodes1 = getText(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "4"));
		ValidationMessageInPage(DefaultEpisodes1, Season2, "Season of First Row");
		clickUsingJSExecutor(loc_SBUImage, "MultiSelect season Icon", Episode_FilterLabel1);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(By.id("btnApply"));
		clickUsingJSExecutor(loc_Episodes_Filter_DeselectAllCheckBox, "Episodes_Filter_DeselectAllCheckBox");
		sleepTime(3);
		WaitForElementPresent(By.id("btnApply"));
		moveMouse(loc_Episodes_MultiSelectSeason_CheckBox1, "Episodes_MultiSelectSeason_CheckBox1");
		clickOn(loc_Episodes_MultiSelectSeason_CheckBox1, "Episodes_MultiSelectSeason_CheckBox1");
		moveMouse(loc_Episodes_MultiSelectSeason_CheckBox2, "Episodes_MultiSelectSeason_CheckBox2");
		clickOn(loc_Episodes_MultiSelectSeason_CheckBox2, "Episodes_MultiSelectSeason_CheckBox2");
		clickUsingJSExecutor(loc_Episodes_MultiSelectSeason_ApplyButton, "Apply button at MultiSelectSeason window");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		String DefaultEpisodes_Season = getAttribute(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "4"), "innerHTML");
		ValidationMessageInPage(DefaultEpisodes_Season, Season1, "Season of First Row");

		String DefaultEpisodes300_Season = getAttribute(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "301").replace("@col", "4"),"innerHTML");
		scrollElementIntoView(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "301").replace("@col", "4"));
		ValidationMessageInPage(DefaultEpisodes300_Season, Season2, "Season of row number 301");

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_8");
		//ExecutionLog.Log("=====BUG ID======: 20202");
		verifyTextMatches(loc_Episodes_EditEpisodes_RecordDetails, "Paginated View of Record", "Records in Page: 500 of 500");
		verifyDropDownValues(loc_Episodes_EditEpisodes_PageSelector, "Page Drop down", "1");
		verifyDropDownValues(loc_Episodes_EditEpisodes_PageSelector, "Page Drop down", "2");

		clickUsingJSExecutor(loc_Episodes_ClearFilter, "'ClearFilter' at Episode window"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);

		DefaultEpisodes_Season = getAttribute(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "4"),"innerHTML");
		ValidationMessageInPage(DefaultEpisodes_Season, Season1, "Season of First Row");
		scrollElementIntoView(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "4"));
		DefaultEpisodes300_Season = getAttribute(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "301").replace("@col", "4"),"innerHTML");
		ValidationMessageInPage(DefaultEpisodes300_Season, Season2, "Season of row number 301");
		// BUG ID 20202
		//ExecutionLog.Log("=====BUG ID======: 20202");
		verifyTextMatches(loc_Episodes_EditEpisodes_RecordDetails, "Paginated View of Record", "Records in Page: 500 of 900");
		verifyDropDownValues(loc_Episodes_EditEpisodes_PageSelector, "Page Drop down", "1");
		verifyDropDownValues(loc_Episodes_EditEpisodes_PageSelector, "Page Drop down", "2");

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_9");
		ExecutionLog.Log("Select All in the Filter Drop down");
		verifyFirstSelectedDropdownValue(loc_Episodes_Filter1DropDown, "Episodes_Filter1DropDown", "(Select All)", "TC7_EpisodeFilters_Season1");
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);

	}

	@Test(priority =8,enabled= true,description = "Update Tool")
	public void TC8_EpisodeUpdateTool() throws Exception {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String createdSeriesAssetTitle = "AUT_AssetSeries_" +formattedDate+"";
		
		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.selectAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		ExecutionLog.Log("*****************The below are buttons in the window*****************");
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		verifyTextMatches(loc_Episodes_Edit, "Edit button", Episode_Edit, "value");
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		sleepTime(3);
		
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);
		
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_5");
		ExecutionLog.Log("*****Create 1-5 Episodes and Select Season1****");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"1-5","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		switchIntoFrame(frameParent3Xpath);		
		WaitForElementToClickable(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2"));
		//WaitForElementPresent(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2"));
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		
		sleepTime(3);
		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_5");
		ExecutionLog.Log("**********Create 6-10 Episodes and Select Season2*********");			
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow,"6-10","Add Episode input field",Episodes_Add);
		clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Episode_Pass_RowAndColumnNumber.replace("@row", "1").replace("@col", "2"));
		sleepTime(3);
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "6"), "Season Field of Episode006");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", Season2), Season2);		
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
		sleepTime(3);
		doubleClick(loc_Episode_EditEpisode_DataRow + "/th[1]", "Select 1st Row");

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_12");
		ExecutionLog.Log("**********Copy TBA value for all episodes of the selected Season*********");		
	//TODO failing here as locator for TBA is changed for VMN
		clickOn(getLocatorFor_TBA_Field("1")+"/img", "TBA Check Box", Episode_TBAValue);
		clickUsingJSExecutor(loc_Episodes_UpdateTool, "Update Tool", Episodes_UpdateTool);
		switchIntoFrame(frameParent4Xpath);
		WaitForElementToClickable(loc_OkButton);
		verifyTextMatches(loc_Episodes_UpdateTool_TBAValueCheckBox, "Episodes_UpdateTool_TBAValueCheckBox", Episodes_UpdateTool_TBAValueCheckBox);
		verifyTextMatches(loc_Episodes_UpdateTool_SeasonCheckBox, "Episodes_UpdateTool_SeasonCheckBox", Episodes_UpdateTool_SeasonCheckBox);
		verifyTextMatches(loc_Episodes_UpdateTool_DurationValueCheckBox, "Episodes_UpdateTool_DurationValueCheckBox", Episodes_UpdateTool_DurationValueCheckBox);
		verifyTextMatches(loc_Episodes_UpdateTool_EpisodeHeader, "Episodes_UpdateTool_EpisodeHeader", Episodes_UpdateTool_EpisodeHeader);
		verifyTextMatches(loc_Episodes_UpdateTool_UpdateEpisodeTitle, "Episodes_UpdateTool_UpdateEpisodeTitle", Episodes_UpdateTool_UpdateEpisodeTitle);
		verifyTextMatches(loc_Episodes_UpdateTool_TitleLabel, "Episodes_UpdateTool_TitleLabel", Episodes_UpdateTool_TitleLabel);

		ExecutionLog.Log("");
		ExecutionLog.Log("**********Verifying the button on Update tool Pop - Up************");
		WaitForElementPresent(ByLocator(OKButton));
		verifyTextMatches(OKButton, "OK button", "OK", "value");
		verifyTextMatches(LocCancel, "Cancel button", "Cancel", "value");
		clickUsingJSExecutor(loc_Episodes_UpdateTool_TBAValueCheckBox, "Episodes_UpdateTool_TBAValueCheckBox",Episodes_UpdateTool_TBAValueCheckBox);
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton", Episode_SeasonValue,Episodes_UpdateTool_TBAValueCheckBox);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath,Episodes_UpdateTool_TBAValueCheckBox);

		ExecutionLog.Log("**********Verify that TBA check box is check for all episodes Season 1 but not for Season 2*********");	
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("1")+"/img", "Checked", "TBA Check Box for Episode1 of Seseaon1", Episodes_UpdateTool_TBAValueCheckBox,"title");
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("2")+"/img", "Checked", "TBA Check Box for Episode2 of Seseaon1", Episodes_UpdateTool_TBAValueCheckBox,"title");

		if(ClientData.equals("VMN")){
			ExecutionLog.Log("=====BUG ID: 20543");
		}
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("6")+"/img", "Checked", "TBA Check Box for Episode6 of Seseaon2", Episodes_UpdateTool_TBAValueCheckBox,"title");


		clickOn(loc_Episode_EditEpisode_DataRow + "/th[1]", "Select 1st Row of Episode 1",Episodes_UpdateTool_TBAValueCheckBox);
		clickOn(getLocatorFor_TBA_Field("1")+"/img", "Uncheck TBA of Episode 1",Episodes_UpdateTool_TBAValueCheckBox);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step: TC_2.5_Episode Tab_14");
		ExecutionLog.Log("Uncheck 'Copy TBA' check box for All Episodes of Season 1 at Update Tool and Verify that TBA is unchecked at Edit Episdoe Window");
		clickUsingJSExecutor(loc_Episodes_UpdateTool, "Update Tool", Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoFrame(frameParent4Xpath,Episodes_UpdateTool_TBAValueCheckBox);
		WaitForElementPresent(loc_OkButton, Episodes_UpdateTool_TBAValueCheckBox);
		clickUsingJSExecutor(loc_Episodes_UpdateTool_TBAValueCheckBox, "Episodes_UpdateTool_TBAValueCheckBox", Episodes_UpdateTool_TBAValueCheckBox);
		clickUsingJSExecutor(loc_OkButton, "OKButton at Update tool Window", Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoFrame(frameParent3Xpath, Episodes_UpdateTool_TBAValueCheckBox);
		WaitForElementPresent(loc_EpisodeAdd, Episodes_UpdateTool_TBAValueCheckBox);
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("1")+"/img", "Unchecked", "TBA Check Box for Episode1 of Seseaon1", Episodes_UpdateTool_TBAValueCheckBox,"title");
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("2")+"/img", "Unchecked", "TBA Check Box for Episode2 of Seseaon1", Episodes_UpdateTool_TBAValueCheckBox,"title");
		// Verify that TBA is not checked for Episode6
		verifyFieldValueOfHeader(getLocatorFor_TBA_Field("6")+"/img", "Unchecked", "TBA Check Box for Episode6 of Seseaon2 is unchecked", Episodes_UpdateTool_TBAValueCheckBox,"title");

		ExecutionLog.Log("");
		ExecutionLog.Log("// Manual Test Step : TC_2.5_Episode Tab_18");
		clickOn(loc_Episode_EditEpisode_DataRow + "/th[1]", "Select 1st Row", Episodes_UpdateTool_TBAValueCheckBox);
		clickUsingJSExecutor(loc_Episodes_UpdateTool, "Update Tool", Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoFrame(frameParent4Xpath, Episodes_UpdateTool_TBAValueCheckBox);
		WaitForElementPresent(loc_OkButton, Episodes_UpdateTool_TBAValueCheckBox);
		clickOn(loc_Episodes_UpdateTool_UpdateEpisodeTitle, "Episodes_UpdateTool_UpdateEpisodeTitle", Episodes_UpdateTool_TBAValueCheckBox);
		sleepTime(3);
		sendKeys(loc_Episodes_UpdateTool_TitleField, "RSG", "Episodes_UpdateTool_TitleField", Episodes_UpdateTool_TBAValueCheckBox);
		clickUsingJSExecutor(loc_OkButton, "OKButton at Update tool Window", Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoFrame(frameParent3Xpath, Episodes_UpdateTool_TBAValueCheckBox);
		WaitForElementPresent(loc_EpisodeAdd, Episodes_UpdateTool_TBAValueCheckBox);

		ExecutionLog.Log("");
		ExecutionLog.Log("Manual Test Step : TC_2.5_Episode Tab_19");
		ExecutionLog.Log("******Change the Episode name of Season 1 from \"Episode\" to \"RSG\"******");
		String loc_EditEpisode_TitleValue_1stRow =getLocator_EditEpisode_DataRow("1",Episode_TitleKey , Episode_TitleValue);
		verifyFieldValueOfHeader(loc_EditEpisode_TitleValue_1stRow, "RSG 001", "TBA Check Box for 1st Row", Episodes_UpdateTool_TBAValueCheckBox,"innerHTML");
		if(ClientData.equals("VMN")){
			ExecutionLog.Log("=====BUG ID=====: 20543");
		}
		String loc_EditEpisode_TitleValue_6thRow =getLocator_EditEpisode_DataRow("6",Episode_TitleKey , Episode_TitleValue);
		verifyFieldValueOfHeader(loc_EditEpisode_TitleValue_6thRow, "RSG 006", "TBA Check Box for 6th Row", Episodes_UpdateTool_TBAValueCheckBox,"innerHTML");
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'",Episodes_UpdateTool_TBAValueCheckBox);	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath,Episodes_UpdateTool_TBAValueCheckBox);
		sleepTime(6);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'", Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoFrame(frameParent2Xpath, Episodes_UpdateTool_TBAValueCheckBox);
		switchIntoChildFrame(frameParent21Xpath, Episodes_UpdateTool_TBAValueCheckBox);
		WaitForElementPresent("name="+loc_EditButtonEpisodes, Episodes_UpdateTool_TBAValueCheckBox);

	}


	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @throws IOException
	 * 
	 * <h1> Test Cases : TU3.2_AMCn_TC_AssetMaintenance_v1.1.xlsx </h1>
	 */
	@Test(priority =9,enabled= true,description = "Validate Episode Tab in Program Mini Series")
	public void TC9_Program_Mini_Series() throws Exception {
		if(!MiniSeries_AssetType.contains("N/A")) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			String createdSeriesAssetTitle = "AUT_AssetMiniSeries_" +formattedDate+"";
			ExecutionLog.Log(createdSeriesAssetTitle);
			assetMaintenance.createProgramAsset(createdSeriesAssetTitle, MiniSeries_AssetType);
			assetMaintenance.selectAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name="+loc_EditButtonEpisodes);
			clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
			sleepTime(3);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocAdd);
			clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
			WaitForModalPanel();
			driver.switchTo().window(driver.getWindowHandle()); 
			sendKeys(loc_EpisodeAddWindow,"1-10","Add Episode input field",Episodes_Add);
			clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "Episodes_OKButton_AddEpisodesWindow");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_FirstRow_EpisodesEditWindow));
			clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "1"), "Season Field of First Row");
			sleepTime(1);
			clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
			clickOn(loc_SelectSeason.replace("@var", Season1), Season1);		
			clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
			sleepTime(3);
			clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			sleepTime(3);
			verifyTextMatches(loc_AssertCreationValidationMessage, "Alert Message While DeleteEpisodes", "Changes have been saved successfully");
			clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
			sleepTime(6);
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Edit));
			String loc_Totalrowvalue1 =getLocator_ViewEpisode_DataRow("10", Episode_Episode_Number, Episode_Episode_NumberValue);
			verifyTextMatches(loc_Totalrowvalue1, "Episode Number", "10");
		}
	}

	
	
	
	
	
	public String getLocator_EditEpisode_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(AM_EpisodeColumnXpath, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = loc_Episode_EditEpisode_DataRow + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

	public String getLocator_ViewEpisode_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(loc_Episodes_ViewModeHeader, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = loc_Episodes_ViewModeDataRow + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

	/**
	 * We will replace the below way for the locator
	 * We need to Apply idx and adr value to find the locator of the respective header
	 * @param rowNumber
	 * @return
	 */
	public String  getLocatorFor_TBA_Field(String rowNumber){
		String locator = "";
		locator = loc_Episode_Pass_RowAndColumnNumber.replace("@row", rowNumber).replace("@col", "9");
		return locator;
	}

	public String  getLocatorFor_AiringOrder_Field(String rowNumber){
		String locator = "";
		if(!(ClientData.contains("TURNER"))){
			locator = loc_Episode_Pass_RowAndColumnNumber.replace("@row", rowNumber).replace("@col", "25");

		} else if (ClientData.contains("TURNER")){
			locator = loc_Episode_Pass_RowAndColumnNumber.replace("@row", rowNumber).replace("@col", "23");
		}
		return locator;

	}

	public String  getLocatorFor_EpisodeNumber_Field(String rowNumber){
		String locator = "";

		if(!(ClientData.contains("TURNER"))){
			locator = loc_Episode_Pass_RowAndColumnNumber.replace("@row", rowNumber).replace("@col", "8");

		} else if (ClientData.contains("TURNER")){
			locator = loc_Episode_Pass_RowAndColumnNumber.replace("@row", rowNumber).replace("@col", "7");
		}
		return locator;

	}

	// This method belongs to TC5
	public String getLocator_ViewVersion_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(ColumnRow1XpathAMVersionView, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = DataRow1XpathAMVersionView + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}


	public String getLocator_ViewVersion_RightVersion_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(ColumnRow1XpathAMVersionView_DifferentVersion, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = DataRow1XpathAMVersionView_DifferentVersion + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}
}

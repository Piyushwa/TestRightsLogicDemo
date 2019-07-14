package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import commonFunctions.AssetMaintenance;
@Listeners(utility.ListenerClass.class)
public class AM_AssetNavigator extends DriverHelper implements IAM_AssetNavigator{
	
	public AM_AssetNavigator() {
		className = this.getClass().getName();
		classObject = this.getClass();	
	}
	
	@BeforeTest
	public void runStatus() {
		if(ClientData.equals("ASTRO")) {
			throw new SkipException("Script of \"Attribute TAB\" is Not Applicable for "+ ClientData);
			
		}
		
	}

	@Test(priority =1,enabled= true,description = "Validate the functionality of Asset Navigator.")
	public void TC1_AssetNavigator() throws Exception {
		System.out.println("*********************Start Testcase - TC2_AssetNavigator *********************");
		Date date = new Date();
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		//Create Asset
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		//Add Episode
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		//Search Asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		//Asset Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator,"Navigator");
		if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		//TC_AM_AN_002
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", CreatedSeriesAssetTitle1), CreatedSeriesAssetTitle1,CreatedSeriesAssetTitle1); 
		
        verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", Season1), Season1,Season1);
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", Season2), Season2,Season2); 
		
		
		
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.101: Episode101"), "Ep.101: Episode101","Ep.101: Episode101"); 
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.102: Episode102"), "Ep.102: Episode102","Ep.102: Episode102"); 
		
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.201: Episode201"), "Ep.201: Episode201","Ep.201: Episode201"); 
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.202: Episode202"), "Ep.202: Episode202","Ep.202: Episode202"); 

		
		System.out.println("**********The below are Icon menus************");
		clickOn(loc_AssetNavigater, "Asset Title Navigater");
		if(!ClientName.contains("VMN")){
		clickUsingJSExecutor(Loc_AddSeason, "Add Season");
		}else{
			clickUsingJSExecutor(Loc_AddSeason1, "Add Season");
		}
		//Add Season	
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		verifyTextMatches(Loc_AssetNavigatorAppliesto, "Applies to",AssetNavigatorAppliesto);
		verifyTextMatches(Loc_AssetNavigatorSeasonName1, "Season Name",AssetNavigatorSeasonName1);
		verifyTextMatches(Loc_AssetNavigatorSeasonName2, "Season Name",AssetNavigatorSeasonName2);
		verifyTextMatches(Loc_AssetNavigatorVMID, "VMID",AssetNavigatorVMID);
		verifyTextMatches(Loc_AssetNavigatorRightsVersionType, "Rights Version Type",AssetNavigatorRightsVersionType);
		verifyTextMatches(Loc_AssetNavigatorSave, "Save",AssetNavigatorSave,"Value");
		verifyTextMatches(Loc_AssetNavigatorCancel, "Cancel",AssetNavigatorCancel,"Value");
		//ApplesTo
		verifyTextMatches(loc_Appliesto, "Appliesto", CreatedSeriesAssetTitle1);
		//Season Name 1
		verifyFirstSelectedDropdownValue(Loc_SeasonNameDropDown, "AssetNavigator Season Name", DefaultSeasonname, AssetNavigatorSeasonName1);
		//Season Name 2
		verifyTextMatches(Loc_SeasonName, "Season Name Blank", ""); //Verify Blank 
		//VMID
		if(ClientName.contains("VMN")||(ClientName.contains("SALESDEMO"))){
		verifyFieldValueOfHeader(Loc_VMIDInput, "", "VMID Blank", AssetNavigatorVMID);//Verify Blank 
		}
		//Rights Version Type
		verifyFirstSelectedDropdownValue(Loc_RightsVersionTypeDropDown, "Rights Version Type", "", AssetNavigatorRightsVersionType);
		//Season Name 1 Select Season 3
		selectDropdownValue(Loc_SeasonNameDropDown, "Season Name DropDown", AssetNavigatorSeasonNameValue, AssetNavigatorSeasonName1);
		sleepTime(2);
		clickUsingJSExecutor(loc_Save, "Save");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
			}else{
				switchIntoFrame(frameParent3Xpath);
			}
		WaitForElementPresent(By.name(loc_OkButton));
		sleepTime(3);
		
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", CreatedSeriesAssetTitle1), CreatedSeriesAssetTitle1,CreatedSeriesAssetTitle1); 
		
        verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", Season1), Season1,Season1);
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.101: Episode101"), "Ep.101: Episode101","Ep.101: Episode101"); 
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.102: Episode102"), "Ep.102: Episode102","Ep.102: Episode102"); 
		
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", Season2), Season2,Season2); 
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.201: Episode201"), "Ep.201: Episode201","Ep.201: Episode201"); 
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", "Ep.202: Episode202"), "Ep.202: Episode202","Ep.202: Episode202"); 
		//verify Season 3
		sleepTime(2);
		verifyTextMatches(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", Season3), Season3,Season3);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(loc_AssetNavigater)));
		oAction.contextClick(driver.findElement(By.xpath(loc_AssetNavigater))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
			clickOn(Loc_AssetNavigatorAddSeason, "Add Season");
		}
		else{
			clickUsingJSExecutor(Loc_AssetNavigatorAddSeason, "Add Season");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
		}else{
			switchIntoFrame(frameParent4Xpath);
		}
		WaitForElementPresent(By.xpath(loc_Save));
		//TC_AM_AN_011
		//Season Name 1
		selectDropdownValue(Loc_SeasonNameDropDown, "Season Name DropDown", DefaultSeasonname, AssetNavigatorSeasonName1);
		//Season Name 2
		sendKeys(Loc_SeasonName, AssetNavigatorSeasonName, "Season Name", AssetNavigatorSeasonName2);
		//Rights Version Type
		selectDropdownValue(Loc_RightsVersionTypeDropDown, "Rights Version Type DropDown", AssetNavigatorRightsVersionTypeData, AssetNavigatorRightsVersionType);
		clickUsingJSExecutor(loc_Save, "Save");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}

		WaitForElementPresent(By.name(loc_OkButton));
		sleepTime(2);
		verifyElementPresent(loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName.replace("@var", AssetNavigatorRightsVersionTypeData1), AssetNavigatorRightsVersionTypeData1); 
		clickUsingJSExecutor("name="+loc_OkButton, "Ok Button", "");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator,"Navigator");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);

		}else{
			switchIntoFrame(frameParent3Xpath);
		}

		WaitForElementPresent(By.name(loc_OkButton));
		sleepTime(2);
		oAction.moveToElement(driver.findElement(By.xpath(loc_AssetNavigater)));
		oAction.contextClick(driver.findElement(By.xpath(loc_AssetNavigater))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
		clickOn(Loc_AssetNavigatorAddSeason, "Add Season");
		}else{
			clickUsingJSExecutor(Loc_AssetNavigatorAddSeason, "Add Season");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		//Season Name
		selectDropdownValue(Loc_SeasonNameDropDown, "Season Name DropDown", DefaultSeasonname, AssetNavigatorSeasonName1);
		//Season Name
		sendKeys(Loc_SeasonName, AssetNavigatorSeasonName, "Season Name", AssetNavigatorSeasonName2);	
		//Rights Version Type
		if (!AssetNavigatorRightsVersionType.contains("N/A")) {
		clickUsingJSExecutor(loc_Save, "Save");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg", "Please enter Rights Version Type for this Season");
		sleepTime(1);
		clickUsingJSExecutor(OKAlertButtonXpath, "Alert Ok Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		}
//		selectDropdownValue(Loc_RightsVersionTypeDropDown, "Rights Version Type DropDown", AssetNavigatorRightsVersionTypeData, AssetNavigatorRightsVersionType);
		clickUsingJSExecutor(loc_Cancel, "cancel Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
			}else{
				switchIntoFrame(frameParent3Xpath);
			}
		WaitForElementPresent(By.name(loc_OkButton));
		//Add Episode	
		clickOn(Loc_Season1, " Season1");
		clickOn(Loc_AddEpisode, "Add Episode");
		
		/*if(!ClientName.contains("VMN")){
		clickOn(Loc_AddEpisode, "Add Episode");
		}else{
			clickOn(Loc_AddEpisode2, "Add Episode");
		}*/
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));

		verifyTextMatches(Loc_AssetNavigatorAppliesto, "Applies to",AssetNavigatorAppliesto1);
		verifyTextMatches(Loc_AssetNavigatorSeasonName2, "Episode Name",AssetNavigatorEpisodeName);
		verifyTextMatches(loc_AssetNavigatorEpisodeNumber, "Episode Number",AssetNavigatorEpisodeNumber);
		verifyTextMatches(loc_AssetNavigatorInitialAirDate, "Initial Air Date",AssetNavigatorInitialAirDate);
		verifyTextMatches(loc_Save, "Save",AssetNavigatorSave1,"Value");
		verifyTextMatches(LocCancel, "Cancel",AssetNavigatorcancel1,"Value");

		clickUsingJSExecutor(loc_Cancel, "Cencel Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
			}else{
				switchIntoFrame(frameParent3Xpath);
			}
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Season1)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Season1))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
			clickOn(Loc_AddEpisode1, "Add Episode", "");
		}else{
			clickUsingJSExecutor(Loc_AddEpisode1, "Add Episode", "");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
		}else{
			switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		clickUsingJSExecutor(loc_Save, "Save");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg", EpisodeNameAlertMsg);
		sleepTime(1);
		clickUsingJSExecutor(OKAlertButtonXpath, "Alert Ok Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		sendKeys(Loc_SeasonName, EpisodeName103, "Episode", AssetNavigatorSeasonName1);
		clickUsingJSExecutor(loc_Save, "Save");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg", EpisodeNumberAlertMsg);
		sleepTime(1);
		clickUsingJSExecutor(OKAlertButtonXpath, "Alert Ok Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}


		sendKeys(Loc_EpisodeNumberInput, EpisodeNumber103, "Episode Number Input", AssetNavigatorSeasonName2);
		//Initial Air Date
		sendKeys(Loc_InitialAirDateInput, AssetNavigatorInitialAirDateInputDtata, "Initial Air Date Input", AssetNavigatorInitialAirDate);

		clickUsingJSExecutor(loc_Save, "Save");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.xpath(loc_Episode103));
		verifyTextMatches(loc_Episode103, "Added Episode", AddedEpisode103);

		//Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Season1)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Season1))).build().perform();
		driver.findElement(By.xpath(Loc_AddEpisode1)).click();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		//Episode Name
		sendKeys(Loc_SeasonName, EpisodeName103, "Episode NameInput", AssetNavigatorEpisodeName);
		//Episode Number
		sendKeys(Loc_EpisodeNumberInput, EpisodeNumber103, "Episode Number Input", AssetNavigatorEpisodeNumber);
		clickUsingJSExecutor(loc_Save, "Save");

		if (Browser.equalsIgnoreCase("ie")) {
			Runtime.getRuntime().exec("C:/SeleniumProject/Workspace/RightsLogic/ModalDialog.exe");

		} else{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		sleepTime(5);
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Cancel));
		sleepTime(2);
		clickUsingJSExecutor(loc_Cancel, "Cancel Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		clickOn(loc_Episode103, "Episode103", "");
		clickOn(Loc_EditSeason, "Edit Season Img", "");
		// Modified the locator for all clients
		/*if (!ClientName.contains("VMN")){
		clickOn(Loc_EditSeason, "Edit Season", "");
		}else{
			clickOn(Loc_EditSeason1, "Edit Season", "");
		}*/
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		clickUsingJSExecutor(loc_Cancel, "Cancel Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		//Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(loc_Episode103)));
		oAction.contextClick(driver.findElement(By.xpath(loc_Episode103))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
		clickOn(Loc_EditEpisode, "Edit Episode", "");
		}else{
			clickUsingJSExecutor(Loc_EditEpisode, "Edit Episode", "");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		//Episode Name
		sendKeys(Loc_SeasonName, EpisodeName104, "Episode NameInput", "");
		//Episode Number
		sendKeys(Loc_EpisodeNumberInput, EpisodeNumber104, "Episode Number Input", "");
		//Initial Air Date
		sendKeys(Loc_InitialAirDateInput, AssetNavigatorInitialAirDateInputDtata1, "Initial Air Date Input", AssetNavigatorInitialAirDate);
		clickUsingJSExecutor(loc_Save, "Save");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		sleepTime(2);
		WaitForElementPresent(By.xpath(loc_Episode104));

		//Delete Episode
		//Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(loc_Episode104)));
		oAction.contextClick(driver.findElement(By.xpath(loc_Episode104))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
		clickOn(Loc_DeleteEpisode, "Delete Episode ", "");
		}
		else{
			clickUsingJSExecutor(Loc_DeleteEpisode, "Delete Episode ", "");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.name(loc_OkButton));
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton"); 
		WaitForModalPanel();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));

		//Check Epe-104 Delete or not 
		verifyElementNotPresent(loc_Episode104, "Episode104");
		//Add/Edit Episode
		//Actions oAction = new Actions(driver);

		oAction.moveToElement(driver.findElement(By.xpath(Loc_Season1)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Season1))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
		clickOn(Loc_AddEditEEpisode, "Edit", "");
		}else{
			clickUsingJSExecutor(Loc_AddEditEEpisode, "Edit", "");
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		//Edit Episode
		WaitForElementPresent(By.xpath(loc_Save));
		clickUsingJSExecutor(loc_Episodes_Add, "Add Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow, "1-5", "Enetr Episode", "");
		clickUsingJSExecutor(loc_EpisodeAddOKbutton, "Ok Button", "");
		WaitForModalPanel();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", "3"), "Season Field of Episode001");
		clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
		clickOn(loc_SelectSeason.replace("@var", "Season 1"), "Season 1");			
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");

		clickUsingJSExecutor(loc_Save, "Save");
		WaitForModalPanel();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementToClickable(By.xpath(loc_Save));
		verifyTextMatches(Episode001, "Episode001", VerifyEpisode001);
		verifyTextMatches(Episode002, "Episode002", VerifyEpisode002);
		verifyTextMatches(Episode003, "Episode003", VerifyEpisode003);
		verifyTextMatches(Episode004, "Episode004", VerifyEpisode004);
		verifyTextMatches(Episode005, "Episode005", VerifyEpisode005);
		verifyTextMatches(LocErrorMgs, "Validation Msg", EposodeSaveValidationMsg);
		clickUsingJSExecutor(loc_EpisodesWindowClose, "Window Close", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.xpath(Loc_Episode001));
		//Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Season1)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Season1))).build().perform();
		if (!ClientName.contains("SALESDEMO")){
		clickOn(Loc_AddEditEEpisode, "Add Edit Episode", "");	
		}else{
			clickUsingJSExecutor(Loc_AddEditEEpisode, "Add Edit Episode", "");	
		}
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
		}else{
			switchIntoFrame(frameParent4Xpath);
		}
		WaitForElementPresent(By.xpath(loc_Save));
		clickUsingJSExecutor(Loc_DeleteButton, "Delete Button", "");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Alert Msg", EposodeRowWithoutSeletingDeleteBtmAlertMsg);

		sleepTime(1);
		clickUsingJSExecutor(OKAlertButtonXpath, "Alert Ok Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
		}else{
			switchIntoFrame(frameParent4Xpath);
		}
		WaitForElementPresent(By.xpath(Loc_SelectEpisode005));
		clickUsingJSExecutor(Loc_SelectEpisode005, "Select Episode005", "");
		clickUsingJSExecutor(Loc_DeleteButton, "Delete Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent6Xpath);
				}else{
					switchIntoFrame(frameParent5Xpath);
				}
			WaitForElementPresent(By.name(loc_OkButton));
			clickUsingJSExecutor("name="+loc_OkButton, "OKButton"); 
			WaitForModalPanel();
			sleepTime(3);
		if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent5Xpath);
				}else{
					switchIntoFrame(frameParent4Xpath);
				}
			WaitForElementPresent(By.xpath(loc_Save));

			clickUsingJSExecutor(loc_Save, "Save");
			
			WaitForModalPanel();
			sleepTime(3);
		if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent5Xpath);
				}else{
					switchIntoFrame(frameParent4Xpath);
				}
			WaitForElementToClickable(By.name("btnSave"));
			verifyTextMatches(Episode001, "Episode001", VerifyEpisode001);
			verifyTextMatches(Episode002, "Episode002", VerifyEpisode002);
			verifyTextMatches(Episode003, "Episode003", VerifyEpisode003);
			verifyTextMatches(Episode004, "Episode004", VerifyEpisode004);
			verifyTextMatches(LocErrorMgs, "Validation Msg", EposodeSaveValidationMsg);
			clickUsingJSExecutor(loc_EpisodesWindowClose, "Window Close", "");
		
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		sleepTime(5);
		verifyElementNotPresent(Loc_Episode005, "Episode005");
		//Edit Episoid
		//TC_AM_AN_058
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Episode004)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Episode004))).build().perform();
		driver.findElement(By.xpath(Loc_EditEpisode)).click();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.xpath(loc_Save));
		//Episode Name
		sendKeys(Loc_SeasonName, Loc_EpisodeAAA, "Season NameInput", AssetNavigatorEpisodeName);
		//Episode Number
		sendKeys(Loc_EpisodeNumberInput, Loc_Episode111, "Episode Number Input", AssetNavigatorEpisodeNumber);
		clickUsingJSExecutor(loc_Save, "Save");
		sleepTime(2);
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.xpath(Loc_EpisodeAAA1));
		verifyTextMatches(Loc_EpisodeAAA1, "Ep.111: AAA", Loc_Ep111AAA);
		//Edit Season
        //TC_AM_AN_067
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		clickOn(Loc_Season1, " Season1");
		clickOn(Loc_EditSeason, "Edit Season Img", "");
		// Modified the locator for all clients
		/*if(!ClientName.contains("VMN")){
			clickOn(Loc_EditSeason, "Edit Season Img", "");
		}else{
			clickOn(Loc_EditSeason1, "Edit Season Img", "");
		}*/
		
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}		
		WaitForElementPresent(By.xpath(loc_Save));
		selectDropdownValue(Loc_SeasonNameDropDown, "Season 1 Change to Season 4", AssetNavigatorChangeSeason, AssetNavigatorSeasonName1);
		//Refresh page
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		sleepTime(3);
		WaitForElementPresent(By.xpath(loc_Save));
		clickUsingJSExecutor(loc_Save, "Save Button", "");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.xpath(Loc_Season4));
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton"); 
		sleepTime(2);
		//Asset Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		//Delete Season
		//TC_AM_AN_071
		//Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Season4)));
		sleepTime(2);
		oAction.contextClick(driver.findElement(By.xpath(Loc_Season4))).build().perform();
		sleepTime(2);
		clickUsingJSExecutor(Loc_DeleteSeason, "Delete Season", "");
		sleepTime(2);
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Msg", DeleteSeasonConfirmAlertMsg);
		sleepTime(1);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Ok Button", "");
		sleepTime(5);
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		sleepTime(5);
		verifyElementNotPresent(Loc_Season4, "Season4");
		sleepTime(2);
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton"); 
		scriptStatus();
	}

	@Test(priority =2,enabled= true,description = "Validate the functionality to Standalone")
	public void TC2_AssetNavigator_Standalone() throws Exception {

		System.out.println("*********************Start Testcase - TC3_AssetNavigator *********************");
		Date date = new Date();
		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
		String CreatedMoviesAssetTitle1 = "AUT_AssetMovies_" +formattedDate+"";
		System.out.println(CreatedMoviesAssetTitle1);
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		assetMaintenance.createProgramAsset(CreatedMoviesAssetTitle1, AssetType_ProgrameMovie);

		//Searching  the Series Asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);

		//Asset Navigator
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator");
	    if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		
		//TC_AM_AN_001
		//Add Standalone
		Actions oAction = new Actions(driver);
		oAction.moveToElement(driver.findElement(By.xpath(Loc_Details_Assect)));
		oAction.contextClick(driver.findElement(By.xpath(Loc_Details_Assect))).build().perform();	
		sleepTime(2);
		doubleClick(Loc_AddStandalone, " Add Standalone", "");
		
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		WaitForElementPresent(By.id(loc_AssetTitle));
		clickUsingJSExecutor(loc_AssetTitle, "Asset Title", "");
		sendKeys(loc_AssetTitle, CreatedMoviesAssetTitle1, "Asset Title Input", "");

		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox", "");
		if(ClientName.contains("PROSIBIEN")){
			clickUsingJSExecutor(loc_AssetType_AllCheckBox, "All", "");
		}
		sleepTime(2);
		clickUsingJSExecutor(Loc_SearchButton, "Find Button", "");
		WaitForModalPanel();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent5Xpath);
			}else{
				switchIntoFrame(frameParent4Xpath);
			}
		clickOn(Loc_Toggle, "Toggle", "");
		sleepTime(1);
		WaitForElementPresent(loc_SearchedAsset);
		doubleClick(loc_SearchedAsset, "Search Asset", "");
		WaitForModalPanel();
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.xpath("//*[@data-ig='x:uwtAssets.6:mkr:dtnContent']"));
		 Assert.assertTrue(isElementPresent(Oneoff)); 
	
		sleepTime(3);
		if (Browser.equalsIgnoreCase("chrome")) {
			oAction.moveToElement(driver.findElement(By.xpath(Loc_OneOff))).doubleClick().build().perform();
			clickOn(Loc_OneOff, "Oneoff", "");
		} else{
			oAction.moveToElement(driver.findElement(By.xpath(Loc_OneOff))).doubleClick().build().perform();
		}
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Verify Series Title
		verifyTextMatches(SeriesTitleInput, "Series Title ", CreatedSeriesAssetTitle1,"value");
		//TC_AM_AN_009
		//Update Movie
		sendKeys(loc_AssetTitleField, CreatedMoviesAssetTitle1+"_Update", "Update One Off", "");
		//Save
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		sleepTime(2);
		assetMaintenance.searchCreatedAsset(CreatedMoviesAssetTitle1+"_Update");
		//Searching  the Series Asset
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_Navigator, "Navigator");
	if (ClientName.contains("TURNER")){
			switchIntoFrame(frameParent4Xpath);
		}else{
			switchIntoFrame(frameParent3Xpath);
		}
		WaitForElementPresent(By.name(loc_OkButton));
		verifyTextMatches("//a[contains(text(),'"+CreatedMoviesAssetTitle1+"_Update')]", "", CreatedMoviesAssetTitle1+"_Update");
		clickUsingJSExecutor("name="+loc_OkButton, "OKButton"); 
		//HomeIcon
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(HomeIconXpath, "Home Page", "");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);


		System.out.println("*********************End Testcase - TC3_AssetNavigator *********************");
		scriptStatus();
	}


}

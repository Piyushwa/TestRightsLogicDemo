package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;

@Listeners(utility.ListenerClass.class)
public class AM_Version extends DriverHelper implements IAM_Version{
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate  = sdf.format(date);
	String CreatedMoviesAssetTitle = "AUT_AssetMovies_" + formattedDate + "";
	AssetMaintenance assetMaintenance = new AssetMaintenance();

	public AM_Version() {
		super(ColumnRow1XpathAMVersionEdit, DataRow1XpathAMVersionEdit,
				ColumnRow1XpathAMVersionView, DataRow1XpathAMVersionView);
		className = this.getClass().getName();
		classObject = this.getClass();
	}

	@Test(priority =1,enabled= true,description = "Validate the functionality of Version Tab")
	public void TC1_VersionUI() throws Exception {
		//assetMaintenance.createProgramAsset(CreatedMoviesAssetTitle, AssetType_Element_Music); // This line needs to check if it is necessary for AMCn, VMN
		assetMaintenance.createProgramAsset(CreatedMoviesAssetTitle, AssetType_ProgrameMovie);
		
		assetMaintenance.selectAsset(CreatedMoviesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		
		clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_Edit);
		
		//Frames and default rows
		ExecutionLog.Log("***************Frames and default values**********************");
		verifyTextMatches(loc_GroupVersionHeaderDifferentHeader.replace("@var", "Same Rights"), "Versions Legend Name in the left of the version table", "Versions (Same Rights)");

		String loc_ViewVersion_NameField = getLocator_ViewVersion_DataRow("2", AMVerNameKey, NameHeader);
		verifyFieldValueOfHeader(loc_ViewVersion_NameField, "Version 1.0","Version Name Field at Edit Version window", NameHeader);
		clickUsingJSExecutor("name="+loc_Edit, "Edit Button"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocAdd);
		ExecutionLog.Log("**********Verifying the columns in the \"Versions Edit window\"************");    


		switchIntoFrame(frameParent3Xpath);
		String loc_EditVersion_NameField = getLocator_EditVersion_DataRow("2", AMVerNameKey, NameHeader);
		scrollElementIntoView(loc_EditVersion_NameField, NameHeader);

		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNameKey+"']", "Name Header", NameHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerVersionTypeKey+"']", "Version Type Header", VersionTypeHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerSerialNumKey+"']", "Serial Number Header", SerialNumberHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerLanguageKey+"']", "Language Header", LanguageHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerFormatKey+"']", "FormatHeader", FormatHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerBlockLengthKey+"']", "PlanningLengthHeader", PlanningLengthHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerFormatTargetDurationKey+"']", "MAX_RUNTIMEHeader", MAX_RUNTIMEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerTotalActualRuntimeKey+"']", "RUNTIMEHeader", RUNTIMEHeader,"innerHTML");

		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerRunsLongShortKey+"']", "LONG_SHORT_RUNTIMEHeader", LONG_SHORT_RUNTIMEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerExtraAvailsKey+"']", "EXTRA_AVAILSHeader", EXTRA_AVAILSHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNetworkKey+"']", "NETWORKHeader", NETWORKHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNetworkDefaultKey+"']", "FLAG_NETWORK_DEFAULTHeader", FLAG_NETWORK_DEFAULTHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerActiveKey+"']", "ActiveHeader", ActiveHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerDaytimePlayableKey+"']", "FLAG_DAYTIME_PLAYABLEHeader", FLAG_DAYTIME_PLAYABLEHeader,"innerHTML");

		// Scroll horizontally to make other headers in the view range
		if (Browser.equalsIgnoreCase("ie")) {
			String loc_21Column = "//*[@id='ctl00_columnheader_21']"; 
			scrollElementIntoView(loc_21Column, FLAG_DAYTIME_PLAYABLEHeader);
			sleepTime(3);
		} else{
			String loc_37Column = "//*[@id='ctl00_columnheader_.37']";
			scrollElementIntoView(loc_37Column, FLAG_DAYTIME_PLAYABLEHeader);
		}

		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerEarliestTimeKey+"']", "EARLIEST_TIMEHeader", EARLIEST_TIMEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerTVParentalRatingKey+"']", "RID_TVPARENTALRATINGHeader", RID_TVPARENTALRATINGHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerRatingNotesKey+"']", "RATING_WARNINGHeader", RATING_WARNINGHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerAudioKey+"']", "AUDIOHeader", AUDIOHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerHueKey+"']", "COLORHeader", COLORHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerDubbedKey+"']", "DUBBED_LANGUAGEHeader", DUBBED_LANGUAGEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerSubtitledKey+"']", "SUBTITLED_LANGUAGEHeader", SUBTITLED_LANGUAGEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerAspectRatioKey+"']", "ASPECTRATIOHeader", ASPECTRATIOHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerDirsCutKey+"']", "DIRCUTHeader", DIRCUTHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerIntermissionKey+"']", "INTERMISSIONHeader", INTERMISSIONHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerCCAPKey+"']", "CCAPHeader", CCAPHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerBlockStatusKey+"']", "BLOCK_STATUSHeader", BLOCK_STATUSHeader,"innerHTML");
		scrollElementIntoView(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNotesKey +"']");
		WebElement Scroll2 = driver.findElement(By.xpath("//*[@id='ctl00_columnheader_50']"));
		scrollElementIntoView(Scroll2, BLOCK_STATUSHeader);
		sleepTime(3);


		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerStandardKey+"']", "STANDARDHeader", STANDARDHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerTapeStatusKey+"']", "TAPE_STATUSHeader", TAPE_STATUSHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVersionDefaultKey+"']", "DEFAULTHeader", DEFAULTHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerCommercialLoadKey+"']", "COMMERCIAL_LOADHeader", COMMERCIAL_LOADHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerScheduleBlockKey+"']", "SCHEDULE_BLOCKHeader", SCHEDULE_BLOCKHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerAlteredFilmKey+"']", "ALTERED_FILM_SPECIAL_EVENTHeader", ALTERED_FILM_SPECIAL_EVENTHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerGabrDescKey+"']", "FORMAT_DESCRIPTIONHeader", FORMAT_DESCRIPTIONHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerDisclaimerIDKey+"']", "DISCLAIMERHeader", DISCLAIMERHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNotesKey+"']", "NOTEHeader", NOTEHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerParentalRatingExtKey+"']", "RATING_ISSUESHeader", RATING_ISSUESHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+DANHeaderKey+"']", "DANHeader", DANHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+RATINGKey+"']", "RATINGHeader", RATINGHeader,"innerHTML");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+VODHeaderKey+"']", "VODHeader", VODHeader,"innerHTML");

		ExecutionLog.Log("**********Verifying the Buttons in the \"Versions Edit window\"************"); 
		verifyTextMatches(LocAdd, "Add button", AddButton, "value");
		verifyTextMatches(loc_Copy, "Copy button", "Copy","value");
		verifyTextMatches(loc_Delete, "Delete button", "Delete","value");
		verifyTextMatches(loc_Save, "Save button", "Save","value");
		verifyTextMatches(loc_Cancel, "Cancel button", "Cancel","value");

		ExecutionLog.Log("**********The default values in the row************");
		scrollElementIntoView(loc_VersionEditWindow_FirstColumn);
		sleepTime(3);

		verifyTextMatches(loc_EditVersion_NameField, "Version Name Field at Edit Version window", "Version 1.0");


		// Total Actual run time verify
		String loc_RUNTIMEHeaderField = getLocator_EditVersion_DataRow("2", AMVerTotalActualRuntimeKey, RUNTIMEHeader);
		verifyFieldValueOfHeader(loc_RUNTIMEHeaderField, ChangeHrstoMin(Duration),"Actual run time duration", RUNTIMEHeader);

		String loc_AMVerActiveField = getLocator_EditVersion_DataRow("2", AMVerActiveKey, ActiveHeader);
		scrollElementIntoView(loc_AMVerActiveField);


		String loc_FLAG_NETWORK_DEFAULTHeader = getLocator_EditVersion_DataRow("2", AMVerNetworkDefaultKey, FLAG_NETWORK_DEFAULTHeader);
		scrollElementIntoView(loc_FLAG_NETWORK_DEFAULTHeader, "NETWORK_DEFAULT");
		verifyTextMatches(ColumnRow1XpathAMVersionEdit+"[@key='"+AMVerNetworkDefaultKey+"']", "NETWORK_DEFAULTHeader", FLAG_NETWORK_DEFAULTHeader,"innerHTML");

		//By default Network field(mandatory field) is empty for first row hence entering the value
		String loc_NETWORKHeader_Field = getLocator_EditVersion_DataRow("2", AMVerNetworkKey, AMVerNetworkKey);
		clickOn(loc_NETWORKHeader_Field, "NETWORKHeader_Field", NETWORKHeader);
		sendKeys(loc_NETWORKHeader_InputField, Network, "NETWORKHeader_Field", NETWORKHeader);
		clickOn(DataRow1XpathAMVersionEdit+"[2]", "support click 'Select Row'");
		verifyTextMatches(loc_NETWORKHeader_Field, "Network value", Network);

		//Add new row
		scrollElementIntoView(loc_EditVersion_NameField, "Name field at Edit Version window");
		clickUsingJSExecutor(LocAdd, "Add Button at Edit Version Window");
		sleepTime(3);


		switchIntoFrame(frameParent3Xpath);
		//Entering the name twice as entring is not working in one-attempt in the Name field
		String loc_VersionNameSecondRow = getLocator_EditVersion_DataRow("3", AMVerNameKey, NameHeader);
		doubleClick(loc_VersionNameSecondRow, "Version Name Field SecondRow at Edit Version Window", NameHeader);
		sendKeys(loc_EditVersionInputField, "Version 2.0", "Name InputField at Edit Version Window", NameHeader);
		clickOn(DataRow1XpathAMVersionEdit+"[2]", "support click 'Select Row'");
		doubleClick(loc_VersionNameSecondRow, "Version Name Field SecondRow at Edit Version Window", NameHeader);
		sendKeys(loc_EditVersionInputField, "Version 2.0", "Name InputField at Edit Version Window", NameHeader);


		//Version Type
		String loc_VersionTypeField_SecondRow = getLocator_EditVersion_DataRow("3", AMVerVersionTypeKey, VersionTypeHeader);
		clickOn(loc_VersionTypeField_SecondRow, "VersionTypeFieldSecondRow at Edit Version Window", VersionTypeHeader);
		clickOn(loc_VersionTypeDropwDown, "Version Type Drop Down at Edit Version Window", VersionTypeHeader);
		verifyAllAvailableValues(loc_VersionTypeValues, "Version Type Drop at 'Edit Version window'", "AMVersion", 120,VersionTypeHeader);
		sendKeys(loc_VersionTypeField, "Sponsored", "Version Type Field at Edit Version Window", VersionTypeHeader);


		//Language	popup
		if(!AMVerLANGUAGE_IMAGEHeader.contains("N/A")){
			doubleClick(loc_EditVersion_LanguageIcon, "Language Image", AMVerLANGUAGE_IMAGEHeader);
			switchIntoFrame(frameParent4Xpath);

			WaitForElementPresent(ByLocator(loc_EditVersion_LanguageWindow_ApplyButton));
			clickOn(loc_EditVersion_LanguageWindow_CollapseButton, "CollapseAll", AMVerLANGUAGE_IMAGEHeader);
			clickOn(loc_EditVersion_LanguageWindow_ExpandButton, "ExpandAll", AMVerLANGUAGE_IMAGEHeader);
			clickOn(loc_EditVersion_LanguageWindow_Selectbutton, "btnSelect", AMVerLANGUAGE_IMAGEHeader);
			clickOn(loc_EditVersion_LanguageWindow_DeSelectbutton, "btnDeSelect", AMVerLANGUAGE_IMAGEHeader);
			clickOn(loc_EditVersion_LanguageWindow_ApplyButton, "Apply button", AMVerLANGUAGE_IMAGEHeader);
			sleepTime(3);
			WaitForElementPresent(ByLocator(loc_EditVersion_LanguageWindow_ExpandButton));

			driver.switchTo().window(driver.getWindowHandle()); 
			WebElement Ele1 = driver.findElement(By.xpath(OKAlertXpath));
			AlertMessage (Ele1,"");
			sleepTime(3);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert");
			switchIntoFrame(frameParent4Xpath);

			clickOn(loc_EditVersion_LanguageWindow_PrimaryLanguageCheckBox, "PrimaryLanguageCheckBox at Language Window", AMVerLANGUAGE_IMAGEHeader);
			scrollElementIntoView(loc_EditVersion_LanguageWindow_subtitleLanguageCheckBox);
			clickOn(loc_EditVersion_LanguageWindow_subtitleLanguageCheckBox, "subtitleLanguageCheckBox at Language Window", AMVerLANGUAGE_IMAGEHeader);
			clickOn(loc_EditVersion_LanguageWindow_ApplyButton, "Apply button", AMVerLANGUAGE_IMAGEHeader);
			WaitForModalPanel();

		}
		switchIntoFrame(frameParent3Xpath);

		// Enter Language
		String loc_LanguageField = getLocator_EditVersion_DataRow("3", AMVerLanguageKey, LanguageHeader);
		clickOn(loc_LanguageField, "Language Field", LanguageHeader);
		sendKeys(loc_LanguageField_EditVersion, Language, "Language Field at Edit Version Window", LanguageHeader);

		//Format 
		String loc_VerFormat = getLocator_EditVersion_DataRow("3", AMVerFormatKey, FormatHeader); 
		clickOn(loc_VerFormat, "Version Format field", FormatHeader);
		sendKeys(loc_VersionformatInputField, Format, "Version Format field", FormatHeader);


		// Block length   
		String loc_AMVerBlockLengthField = getLocator_EditVersion_DataRow("3", AMVerBlockLengthKey, PlanningLengthHeader); 
		clickOn(loc_AMVerBlockLengthField, "AMVerBlockLength", PlanningLengthHeader);
		sendKeys(loc_AMVerBlockLengthInputField, "100", "AMVerBlockLength Field", PlanningLengthHeader);

		//Total Actual Run Time  
		String loc_AMVerTotalActualRuntime_Field = getLocator_EditVersion_DataRow("3", AMVerTotalActualRuntimeKey, RUNTIMEHeader); 
		clickOn(loc_AMVerTotalActualRuntime_Field, "AMVerTotalActualRuntime_Field", RUNTIMEHeader);
		sendKeys(loc_AMVerTotalActualRuntime_InputField, "58:40", "AMVerBlockLength Field", RUNTIMEHeader);

		//Format Target duration 
		String loc_MAX_RUNTIMEHeader_Field = getLocator_EditVersion_DataRow("3", AMVerFormatTargetDurationKey, MAX_RUNTIMEHeader); 
		clickOn(loc_MAX_RUNTIMEHeader_Field, "MAX_RUNTIMEHeader_Field", MAX_RUNTIMEHeader);
		sendKeys(loc_MAX_RUNTIMEHeader_InputField, "60:40", "MAX_RUNTIMEHeader_Field", MAX_RUNTIMEHeader);

		//Network
		String loc_NETWORKHeader_Field_SecondRow = getLocator_EditVersion_DataRow("3", AMVerNetworkKey, NETWORKHeader);
		clickOn(loc_NETWORKHeader_Field_SecondRow, "NETWORKHeader_Field_SecondRow", NETWORKHeader);
		sendKeys(loc_NETWORKHeader_InputField, Network, "NETWORKHeader_Field_SecondRow", NETWORKHeader);
		clickOn(DataRow1XpathAMVersionEdit+"[2]", "support click 'Select Row'");
		verifyTextMatches(loc_NETWORKHeader_Field_SecondRow, "NETWORK", NETWORKHeader);
		 
		//Network default
		String loc_FLAG_NETWORK_DEFAULTHeader_Field = getLocator_EditVersion_DataRow("3", AMVerNetworkDefaultKey, FLAG_NETWORK_DEFAULTHeader);
		clickOn(loc_FLAG_NETWORK_DEFAULTHeader_Field, "FLAG_NETWORK_DEFAULTHeader", FLAG_NETWORK_DEFAULTHeader);

		//Audio	
		String loc_AUDIO_Field_SecondRow = getLocator_EditVersion_DataRow("3", AMVerAudioKey, AUDIOHeader);
		scrollElementIntoView(loc_AUDIO_Field_SecondRow, AUDIOHeader);
		clickOn(loc_AUDIO_Field_SecondRow, "AUDIO_Field_SecondRow at Edit Version Window", AUDIOHeader);
		clickOn(loc_AUDIO_Field_SecondRow, "AUDIO_Field_SecondRow at Edit Version Window", AUDIOHeader);
		// as the drop down values are changable hence disabling this field
		//verifyAllAvailableValues(loc_AudioDropDownValues, "AUDIO_Field_SecondRow at 'Edit Version window'", "AMVersion", 164,AUDIOHeader);

		//Hue 
		String loc_COLORHeader_Field_SecondRow = getLocator_EditVersion_DataRow("3", AMVerHueKey, COLORHeader);
		scrollElementIntoView(loc_COLORHeader_Field_SecondRow, COLORHeader);
		clickOn(loc_COLORHeader_Field_SecondRow, "COLORHeader_Field_SecondRow at Edit Version Window", COLORHeader);
		clickOn(loc_COLORHeader_DropDownImageIcon_SecondRow, "COLORHeader_Drop Down_SecondRow at Edit Version Window", COLORHeader);
		// The dropdown values of color are changeable hence commenting
		//verifyAllAvailableValues(loc_colorDropDownValues, "COLORHeader_Drop Down 'Edit Version window'", "AMVersion", 130, COLORHeader);
		sendKeys(loc_COLOR_InputField, "Colors", "COLOR_InputField", COLORHeader);
		ExecutionLog.Log(getText(loc_COLOR_InputField));

		//Dubbed
		
		String loc_DUBBED_LANGUAGE_Field_SecondRow = getLocator_EditVersion_DataRow("3", AMVerDubbedKey, DUBBED_LANGUAGEHeader);
		scrollElementIntoView(loc_DUBBED_LANGUAGE_Field_SecondRow, DUBBED_LANGUAGEHeader);
		clickOn(loc_DUBBED_LANGUAGE_Field_SecondRow, "DUBBED_LANGUAGE_Field_SecondRow at Edit Version Window", DUBBED_LANGUAGEHeader);
		sendKeys(loc_DUBBED_LANGUAGE_InputField, "English", "DUBBED_LANGUAGE_Field_SecondRow Field", DUBBED_LANGUAGEHeader);
		ExecutionLog.Log(getText(loc_DUBBED_LANGUAGE_InputField));

		//Subtitled
		String loc_SUBTITLED_LANGUAGEHeader_Field_SecondRow = getLocator_EditVersion_DataRow("3", AMVerSubtitledKey, SUBTITLED_LANGUAGEHeader);
		scrollElementIntoView(loc_SUBTITLED_LANGUAGEHeader_Field_SecondRow, SUBTITLED_LANGUAGEHeader);
		clickOn(loc_SUBTITLED_LANGUAGEHeader_Field_SecondRow, "SUBTITLED_LANGUAGEHeader_Field_SecondRow at Edit Version Window", SUBTITLED_LANGUAGEHeader);
		sendKeys(loc_SUBTITLED_LANGUAGEHeader_InputField, "Spanish", "SUBTITLED_LANGUAGEHeader_Field_SecondRow", SUBTITLED_LANGUAGEHeader);
		ExecutionLog.Log(getText(loc_SUBTITLED_LANGUAGEHeader_InputField));

		//Aspect Ratio
		String loc_AspectRatio_TypeField_SecondRow = getLocator_EditVersion_DataRow("3", AMVerAspectRatioKey, ASPECTRATIOHeader);
		scrollElementIntoView(loc_AspectRatio_TypeField_SecondRow, ASPECTRATIOHeader);
		clickOn(loc_AspectRatio_TypeField_SecondRow, "Aspect Ratio SecondRow at Edit Version Window", ASPECTRATIOHeader);
		clickOn(loc_AspectRatioDropdownIamgeIcon, "Aspect Ratio Drop Down at Edit Version Window", ASPECTRATIOHeader);
		verifyAllAvailableValues(loc_AspectRatioValues, "Aspect Ratio at 'Edit Version window'", "AMVersion", 138,ASPECTRATIOHeader);
		sendKeys(loc_AspectRatio_InputField, "2:3", "Aspect Ratio Field at Edit Version Window", ASPECTRATIOHeader);

		//Dir's cut
		String loc_DIRCUTHeader_CheckBox_SecondRow = getLocator_EditVersion_DataRow("3", AMVerDirsCutKey, DIRCUTHeader) + "/img";
		scrollElementIntoView(loc_AspectRatio_TypeField_SecondRow, ASPECTRATIOHeader);
		clickOn(loc_DIRCUTHeader_CheckBox_SecondRow, "DIRCUTHeader_CheckBox_SecondRow at Edit Version Window", DIRCUTHeader);

		//Intermission
		String loc_INTERMISSIONHeader_CheckBox_SecondRow = getLocator_EditVersion_DataRow("3", AMVerIntermissionKey, INTERMISSIONHeader)  + "/img";
		clickOn(loc_INTERMISSIONHeader_CheckBox_SecondRow, "INTERMISSIONHeader Check Box at Edit Version Window", INTERMISSIONHeader);

		//CCAP 
		String loc_CCAPHeader_CheckBox_SecondRow = getLocator_EditVersion_DataRow("3", AMVerCCAPKey, CCAPHeader)  + "/img";
		clickOn(loc_CCAPHeader_CheckBox_SecondRow, "CCAPHeader Check Box at Edit Version Window", CCAPHeader);


		//Notes
		if(!(NOTEHeader.equals("N/A"))){
			String loc_NOTEHeader_field = getLocator_EditVersion_DataRow("3", AMVerNotesKey, NOTEHeader); 
			scrollElementIntoView(loc_NOTEHeader_field, NOTEHeader);
			String loc_NOTEHeader_ImageIcon = loc_NOTEHeader_field+"/img";
			scrollElementIntoView(loc_NOTEHeader_field);
			sleepTime(3);
			clickOn(loc_NOTEHeader_ImageIcon, "NOTE Image Icon at Edit Version Window", NOTEHeader);
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(By.id("btnOk"));

			clickOn(loc_Note_Restriction,"Restriction at Note");
			clickOn(loc_NoteBody,"Note field");
			sendKeys(loc_NoteBody, "ABC123", "Note Field", NOTEHeader);

			clickUsingJSExecutor(Applybutton_AtSBUWindow, "OK button at Note Widnow", NOTEHeader);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_Save);
		}

		if(!(DEFAULTHeader.equals("N/A"))){
			String loc_AMVersionDefault_Field = getLocator_EditVersion_DataRow("3", AMVersionDefaultKey, DEFAULTHeader);
			String loc_AMVersionDefault_Field_Image = loc_AMVersionDefault_Field + "/img";
			scrollElementIntoView(loc_AMVersionDefault_Field);
			sleepTime(3);
			moveMouse(loc_AMVersionDefault_Field_Image, "AMVersionDefault_Field_Image");
			clickUsingJSExecutor(loc_AMVersionDefault_Field_Image, "AMVersionDefault_Field_Image");
			sleepTime(3);
			clickUsingJSExecutor(loc_Save, "Save button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(loc_AlertMessage, "Alert Message While checking two default check box of the Version", defaultCheckBoxAlert);
			sleepTime(3);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 
			switchIntoFrame(frameParent3Xpath);
			clickOn(loc_AMVersionDefault_Field_Image, "AMVersionDefault_Field_Image");
			verifyTextMatches(loc_AMVersionDefault_Field_Image, "Default Check Box", "Unchecked", "title");
			sleepTime(5);
		}

		clickUsingJSExecutor(loc_Save, "Save button");
		WaitForModalPanel();
		sleepTime(5);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name("btnEdit"));

		////view mode

		String loc_VersionName_LastField_ViewMode = getLocator_ViewVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_LastField_ViewMode, "Version 2.0", "Version 2.0");
		
	}

	@Test(priority =2,enabled= true,description = "Validate Program Summary on General Tab by changing the value of field 'Standard'")
	public void TC2_VersionProgSummary() throws Exception {
		if(!(HDAvailProgramSummary.equals("N/A"))) {
			//Search the created Asset 
			assetMaintenance.selectAsset(CreatedMoviesAssetTitle);

			//Navigate to general tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "General"), "General TAB");
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_ProgramSummaryHeader));
			verifyTextMatches(loc_HDAvail, "HDAvail", "No", "value");

			//Navigate to version tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator("name="+loc_Edit));			
			clickUsingJSExecutor("name="+loc_Edit, "Edit Button"); 
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(LocAdd));
			sleepTime(5);

			
			//// Change the Standard to "HD" for first version 1.0
			String loc_STANDARDHeader_1stRow = getLocator_EditVersion_DataRow("2", AMVerStandardKey, STANDARDHeader);
			scrollElementIntoView(loc_STANDARDHeader_1stRow);
			sleepTime(3);
			clickOn(loc_STANDARDHeader_1stRow, "STANDARD Field", STANDARDHeader);
			sendKeys(loc_StandardField_InputField, "HD", "StandardField_InputField", STANDARDHeader);
			clickOn(DataRow1XpathAMVersionEdit+"[2]", "support click 'Select Row'");
			verifyFieldValueOfHeader(loc_STANDARDHeader_1stRow, "HD", "STANDARD Field Second Row", STANDARDHeader, "innerHTML");

			clickUsingJSExecutor(loc_Save,"Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));

			//Navigate to general tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "General"), "General TAB");
			driver.switchTo().window(driver.getWindowHandle());
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_ProgramSummaryHeader));
			verifyTextMatches(loc_HDAvail, "HDAvail", "No", "value");


			//// Change the Standard to "HD" for first version 1.0
			//Navigate to version tab
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(By.name("btnEdit"));
			clickUsingJSExecutor("name="+loc_Edit, "Edit Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(LocAdd);

			//Standard
			String loc_STANDARDHeader_2ndRow = getLocator_EditVersion_DataRow("3", AMVerStandardKey, STANDARDHeader);
			scrollElementIntoView(loc_STANDARDHeader_2ndRow, STANDARDHeader);
			clickOn(loc_STANDARDHeader_2ndRow, "STANDARD Field", STANDARDHeader);
			sendKeys(loc_StandardField_InputField, "HD", "StandardField_InputField", STANDARDHeader);
			clickOn(DataRow1XpathAMVersionEdit+"[2]", STANDARDHeader);
			verifyFieldValueOfHeader(loc_STANDARDHeader_2ndRow, "HD", "STANDARD Field Second Row", STANDARDHeader, "innerHTML");


			// Save the details
			clickUsingJSExecutor(loc_Save,"Save Button at Edit Version Window", STANDARDHeader);
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath, STANDARDHeader);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent("name=" +"btnEdit");
			//Search the created Asset 
			assetMaintenance.searchCreatedAsset(CreatedMoviesAssetTitle);
			WaitForModalPanel();
			sleepTime(3);
			//Navigate to general tab
			//Search the created Asset 
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "General"), "General TAB");
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_ProgramSummaryHeader));
			verifyTextMatches(loc_HDAvail, "HDAvail", "Yes", "value");
			
		} else {
			logger.log(LogStatus.SKIP, "HD Field is not available for: " + ClientData);
			throw new SkipException("HD Field is not available for: " + ClientData);
		}
		
	}

	@Test(priority =3,enabled= true,description = " Validate 'Copy' functionality")
	public void TC3_VersionCopy() throws Exception {
		assetMaintenance.selectAsset(CreatedMoviesAssetTitle);
		//Navigate to version tab
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_Edit));			
		clickUsingJSExecutor("name="+loc_Edit, "Edit Button"); 
		WaitForModalPanel();

		////Do not select the row and click on copy version and verify the Alert message
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent("btnAdd");
		clickUsingJSExecutor(loc_Copy, "Copy Button"); 
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(OKAlertXpath, "Alert Message While copying the Version", CopyAlertMessage);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 
		switchIntoFrame(frameParent3Xpath);

		////Select the row and click on copy version and cancel it
		clickOn(DataRow1XpathAMVersionEdit+"[2]/th[1]", "Select first Row");
		clickUsingJSExecutor(loc_Copy, "Copy Button"); 
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(CancelAlertXpath, "Cancel Button at Alert"); 

		////make 2 copy of the version
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Copy, "Copy Button");
		driver.switchTo().window(driver.getWindowHandle());
		sendKeys(loc_EpisodeAddWindow, "2", "Number of Copy of Version", "Copy Version");
		clickUsingJSExecutor(loc_EpisodeAddOKbutton, "OK Button");
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Save, "Save button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(OKAlertXpath, "Alert Message While copying the Version", ValdMsgOnEneringSameVersionName);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 

		switchIntoFrame(frameParent3Xpath);

		////uncheck default and update version Name
		String loc_VersionName_SecondLastField_EditVersion = getLocator_EditVersion_DataRow("last()-1", AMVerNameKey, NameHeader);
		String loc_VersionName_LastField_EditVersion = getLocator_EditVersion_DataRow("last()", AMVerNameKey, NameHeader);

		sleepTime(3);
		scrollElementIntoView(loc_VersionName_SecondLastField_EditVersion, "VersionName_SecondLast_Field");
		sleepTime(3);

		clickOn(loc_VersionName_LastField_EditVersion, "Version Name", NameHeader);
		sendKeys(loc_EditVersionInputField, "Version 4.0", "Version Name in last row", NameHeader);

		clickOn(loc_VersionName_SecondLastField_EditVersion, "Version Name", NameHeader);
		sendKeys(loc_EditVersionInputField, "Version 3.0", "Version Name in Second last row", NameHeader);
		// Support click on change the control out of the Version name fields
		clickOn(DataRow1XpathAMVersionEdit+"[2]/th[1]", "Select first Row");
		clickOn(DataRow1XpathAMVersionEdit+"[2]/th[1]", "Select first Row");
		//// Uncheck Default check Box		
		String loc_VersionDefault_SecondLastRow_checkBoxIcon = getLocator_EditVersion_DataRow("last()-1", AMVersionDefaultKey, DEFAULTHeader)+"/img";
		String loc_VersionDefault_LastRow_CheckBoxIcon = getLocator_EditVersion_DataRow("last()", AMVersionDefaultKey, DEFAULTHeader)+"/img";
		scrollElementIntoView(loc_VersionDefault_LastRow_CheckBoxIcon);
		sleepTime(3);

		String checkBoxStatus = getAttribute(loc_VersionDefault_SecondLastRow_checkBoxIcon, "title");
		System.out.println(checkBoxStatus);
		if(checkBoxStatus.equalsIgnoreCase("Checked")){
			moveMouse(loc_VersionDefault_SecondLastRow_checkBoxIcon, "DEFAULTHeader Image Icon");
			clickOn(loc_VersionDefault_SecondLastRow_checkBoxIcon, "DEFAULTHeader Image Icon",DEFAULTHeader);
			sleepTime(2);
			checkBoxStatus = getAttribute(loc_VersionDefault_SecondLastRow_checkBoxIcon, "title");
			Assert.assertTrue(checkBoxStatus.equalsIgnoreCase("Unchecked"));
			ExecutionLog.Log("Unchecked default check box for Version 3.0");
		}

		// check if the check box is checked if yes the uncheck the check box
		checkBoxStatus = getAttribute(loc_VersionDefault_LastRow_CheckBoxIcon, "title");
		if(checkBoxStatus.equalsIgnoreCase("Checked")){
			moveMouse(loc_VersionDefault_LastRow_CheckBoxIcon, "DEFAULTHeader Image Icon");
			clickOn(loc_VersionDefault_LastRow_CheckBoxIcon, "DEFAULTHeader Image Icon",DEFAULTHeader);
			sleepTime(2);
			checkBoxStatus = getAttribute(loc_VersionDefault_LastRow_CheckBoxIcon, "title");
			Assert.assertTrue(checkBoxStatus.equalsIgnoreCase("Unchecked"));
			ExecutionLog.Log("Unchecked default check box for Version 4.0");
		}
		String loc_LanguageField = getLocator_EditVersion_DataRow("3", AMVerLanguageKey, LanguageHeader);
		scrollElementIntoView(loc_LanguageField);
		clickOn(loc_LanguageField, "Language Name", LanguageHeader);

		//save
		clickUsingJSExecutor(loc_EpisodesWindowSave, "Save Button");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name("btnEdit"));

		////view mode
		String loc_VersionName_SecondLastField_ViewMode = getLocator_ViewVersion_DataRow("last()-1", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_SecondLastField_ViewMode, "VersionName_SecondLastRow", "Version 3.0");

		String loc_VersionName_LastField_ViewMode = getLocator_ViewVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_LastField_ViewMode, "Version 4.0", "Version 4.0");
		
		
	}

	@Test(priority =4,enabled= true,description = " Validate 'Delete' functionality")
	public void TC4_VersionDelete() throws Exception {
		assetMaintenance.selectAsset(CreatedMoviesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Versions"), "Versions TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//Do not select the Version row and click on Delete version and verify the Alert message 
		ExecutionLog.Log("******Do not select the Version row and click on Delete version and verify the Alert message ******");	
		WaitForElementPresent("name="+loc_Edit);			
		clickUsingJSExecutor("name="+loc_Edit, "Edit Button"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocAdd);
		clickUsingJSExecutor(loc_Delete, "Delete Button"); 

		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(OKAlertXpath, "Alert Message While copying the Version", DeleteAlertMessage);
		sleepTime(3);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert"); 

		// Select the row and click on Delete version and cancel it
		ExecutionLog.Log("******Select the row and click on Delete version and cancel it******");	
		switchIntoFrame(frameParent3Xpath);
		String loc_NameHeader_Last_Field = getLocator_EditVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_NameHeader_Last_Field, "Version Name in Last Row", "Version 4.0");
		clickOn(DataRow1XpathAMVersionEdit+"[last()]/th[1]", "Select Last Row");
		clickUsingJSExecutor(loc_Delete, "Delete Button at Alert"); 
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(loc_CancelButtonAtAlert, "Cancel Button at Alert"); 

		//// Select the row and click on Delete version and OK
		ExecutionLog.Log("******click on Delete version and Click on OK button and Cancel the 'Edit Version window'******");	
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_Delete, "Delete Button at Alert"); 
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert"); 
		//cancel
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(LocCancel, "Cancel Button"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.name("btnEdit"));

		//// verify versions are not deleted and shown in view mode
		ExecutionLog.Log("****** verify versions are not deleted on canceling the delete alert pop up ******");	
		String loc_VesrsionName_LastRow_ViewMode = getLocator_ViewVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VesrsionName_LastRow_ViewMode, "Version 4.0'", "Version 4.0");

		String loc_VersionName_SecondLastRow_ViewMode = getLocator_ViewVersion_DataRow("last()-1", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_SecondLastRow_ViewMode, "Version 3.0'", "Version 3.0");
		ExecutionLog.Log("Verified that the version which was deleted on Edit Version window still exists on the view mode after canceling the Edit Version window");	

		////Edit and delete
		scrollElementIntoView(driver.findElement(By.name("btnEdit")));
		clickUsingJSExecutor("name="+loc_Edit, "Edit Button"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(LocAdd);

		String loc_VersionName_SecondLastRow_EditMode = getLocator_EditVersion_DataRow("last()-1", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_SecondLastRow_EditMode, "Version 3.0'", "Version 3.0");
		String loc_VersionName_LastRow_EditMode = getLocator_EditVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_VersionName_LastRow_EditMode, "Version 4.0'", "Version 4.0");
		clickUsingJSExecutor(DataRow1XpathAMVersionEdit+"[last()]/th[1]", "Select Last Version Row"); 

		clickUsingJSExecutor(loc_Delete, "Delete button"); 
		driver.switchTo().window(driver.getWindowHandle());
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert"); 
		switchIntoFrame(frameParent3Xpath);

		//Save
		clickUsingJSExecutor(loc_Save, "save Button"); 
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//view mode
		String loc_Version_LastRow = getLocator_ViewVersion_DataRow("last()", AMVerNameKey, NameHeader);
		verifyTextMatches(loc_Version_LastRow, "Version Name in Last Row", "Version 3.0");
		
	}

	// Need to replace these with the help of method created in DriverHelper
	public String getLocator_EditVersion_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(ColumnRow1XpathAMVersionEdit, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = DataRow1XpathAMVersionEdit + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}

	// Need to replace these with the help of method created in DriverHelper
	public String getLocator_ViewVersion_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String idx_HeadeNameFromExcel = getIDxValue(ColumnRow1XpathAMVersionView, KeyValueFromExcel, HeadeNameFromExcel);
		String locator = DataRow1XpathAMVersionView + "[" + rowNumber +"]/td[contains(@aria-describedby,'"+idx_HeadeNameFromExcel+"') or @idx='" + idx_HeadeNameFromExcel +"'  or @adr='" + idx_HeadeNameFromExcel +"']";
		return locator;
	}
}

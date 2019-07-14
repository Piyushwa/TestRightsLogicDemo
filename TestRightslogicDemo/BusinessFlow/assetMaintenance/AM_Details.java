package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;

@Listeners(utility.ListenerClass.class)	
public class AM_Details extends MultiClient_SupportingFunctions {
	public AM_Details() {
		className = this.getClass().getName();
		classObject = this.getClass();
	}

	@Test(priority =2,enabled= true,description = "Details Tab")
	public void TC2_DetailsUI() throws Exception {
		System.out.println("*********************Start Testcase - TC2_DetailsUI *********************");

		AssetMaintenance assetMaintenance = new AssetMaintenance(); 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedMoviesAssetTitle1 = "AUT_AssetMovies_" +formattedDate+"";  
		System.out.println(CreatedMoviesAssetTitle1);
		//Asset Creation
		assetMaintenance.createProgramAsset(CreatedMoviesAssetTitle1,AssetType_ProgrameMovie);
		//Search Asset
		assetMaintenance.searchCreatedAsset(CreatedMoviesAssetTitle1);

//		String CreatedMoviesAssetTitle1 = "AUT_AssetMovies_0307201724631";

		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.xpath(DetailsTab));
		clickOn(DetailsTab, "DetailsTab");
		Thread.sleep(3000);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(DetailsTabSaveBtn);
		//TC_AM_DT_001
		//Details Tab - Fields name
		System.out.println("**********The below are Fields************");
		verifyFieldValueOfHeader(Loc_Details_ParentVMID, AM_Details_ParentVMID, " Labels Parent VMID", AM_Details_ParentVMID);
		verifyFieldValueOfHeader(Loc_Details_AKA, AM_Details_AKA, "Labels AKA", AM_Details_AKA);
		verifyFieldValueOfHeader(Loc_Details_ShootingFormat, AM_Details_ShootingFormat, "Labels Shooting Format", AM_Details_ShootingFormat);
		verifyFieldValueOfHeader(Loc_Details_DeliveryFormat, AM_Details_DeliveryFormat, "Labels Delivery Format",AM_Details_DeliveryFormat);
		verifyFieldValueOfHeader(Loc_Details_ReleaseYear, AM_Details_ReleaseYear, "Labels Release Year", AM_Details_ReleaseYear);
		verifyFieldValueOfHeader(Loc_Details_Publisher, AM_Details_Publisher, "Labels Publisher", AM_Details_Publisher);
		verifyFieldValueOfHeader(Loc_Details_AssetDescription, AM_Details_AssetDescription, "Labels Asset Description", AM_Details_AssetDescription);
		verifyFieldValueOfHeader(Loc_Details_CreditTimeIn, AM_Details_CreditsTimeIn, "Labels Credit Time In", AM_Details_CreditsTimeIn);
		verifyFieldValueOfHeader(Loc_Details_TimeOut, AM_Details_TimeOut,  "Labels Time Out", AM_Details_TimeOut);
		verifyFieldValueOfHeader(Loc_Details_Language1, AM_Details_PrimaryLanguage, "Labels Primary Language", AM_Details_PrimaryLanguage);
		verifyFieldValueOfHeader(Loc_Details_CloseCaptioned, AM_Details_CloseCaptioned, "Labels Close Captioned", AM_Details_CloseCaptioned);
		verifyFieldValueOfHeader(Loc_Details_Dubbed, AM_Details_Dubbed, "LabelsDubbed", AM_Details_Dubbed); 
		verifyFieldValueOfHeader(Loc_Details_Subtitled, AM_Details_Subtitled, "Labels Subtitled", AM_Details_Subtitled);
		verifyFieldValueOfHeader(Loc_Details_Venue, AM_Details_Venue,  "Labels Venue", AM_Details_Venue);
		verifyFieldValueOfHeader(Loc_Details_RoundOfSeries, AM_Details_RoundOfSeries, "Labels Round Of Series", AM_Details_RoundOfSeries);
		verifyFieldValueOfHeader(Loc_Details_MatchCategory, AM_Details_MatchCategory, "Labels Match Category", AM_Details_MatchCategory);
		verifyFieldValueOfHeader(Loc_Details_PlayerCategory, AM_Details_PlayerCategory, "Labels Player Category", AM_Details_PlayerCategory);
		verifyFieldValueOfHeader(Loc_Details_AssetCategory, AM_Details_AssetCategory, "Labels Asset Category", AM_Details_AssetCategory);
		verifyFieldValueOfHeader(Loc_Details_SourceID, AM_Details_SourceID, "Labels Source ID", AM_Details_SourceID);
		verifyFieldValueOfHeader(Loc_Details_SourceSystem, AM_Details_System, "Labels Source System", AM_Details_System);
		verifyFieldValueOfHeader(Loc_Details_FromGrade, AM_Details_FromGrade, "Labels From Grade", AM_Details_FromGrade);
		verifyFieldValueOfHeader(Loc_Details_ToGrade, AM_Details_ToGrade, "Labels To Grade", AM_Details_ToGrade);
		verifyFieldValueOfHeader(Loc_Details_TVParentalRating, AM_Details_TVParentalRating, "Labels TV Parental Rating", AM_Details_TVParentalRating);
		verifyFieldValueOfHeader(Loc_Details_RatingWarning, AM_Details_RatingWarning, "Labels Rating Warning", AM_Details_RatingWarning);
		verifyFieldValueOfHeader(Loc_Details_Keywords, AM_Details_Keywords, "Labels Keywords", AM_Details_Keywords);
		verifyFieldValueOfHeader(Loc_Details_VMID, AM_Details_VMID, "Labels VMID", AM_Details_VMID);
		verifyFieldValueOfHeader(Loc_Details_MasterAudio, AM_Details_MasterAudio, "Labels MasterAudio", AM_Details_MasterAudio);
		verifyFieldValueOfHeader(Loc_Details_Productionno, AM_Details_Production, "Labels Productionno", AM_Details_Production);
		verifyFieldValueOfHeader(Loc_Details_HDPercentage, AM_Details_HDPercentage, "Labels HDPercentage", AM_Details_HDPercentage);
		verifyFieldValueOfHeader(Loc_Details_HDType, AM_Details_HDType, "Labels HDType", AM_Details_HDType);
		verifyFieldValueOfHeader(Loc_Details_Boxoffice, AM_Details_Boxoffice, "Labels Boxoffice", AM_Details_Boxoffice);
		verifyFieldValueOfHeader(Loc_Details_Targetdemography, AM_Details_TargetDemographics, "Labels Target demography", AM_Details_TargetDemographics);
		verifyFieldValueOfHeader(Loc_Details_GuildAssociation, AM_Details_GuildAssociation, "Labels Guild Association", AM_Details_GuildAssociation);
		verifyFieldValueOfHeader(Loc_Details_Tier, AM_Details_Tier, "Labels Tier", AM_Details_Tier);
		verifyFieldValueOfHeader(Loc_Details_InternationalAmortizationDate, AM_Details_InternationalAmortizationDate, "Labels International Amortization Date", AM_Details_InternationalAmortizationDate);
		verifyFieldValueOfHeader(Loc_Details_SAPMPMID, AM_Details_SAPMPMID, "Labels SAPMPMID", AM_Details_SAPMPMID);
		verifyFieldValueOfHeader(Loc_Details_MPAARating, AM_Details_MPAARating, "Labels MPAA Rating", AM_Details_MPAARating);
		verifyFieldValueOfHeader(Loc_Details_CC, AM_Details_CC, "Labels CC", AM_Details_CC);
		verifyFieldValueOfHeader(Loc_Details_CopyRightYr, AM_Details_CopyrightYear, "Labels Copy Right Year", AM_Details_CopyrightYear);
		verifyFieldValueOfHeader(Loc_Details_Nudity, AM_Details_Nudity, "Labels Nudity", AM_Details_Nudity);
		verifyFieldValueOfHeader(Loc_Details_Rape, AM_Details_Rape, "Labels Rape", AM_Details_Rape);
		verifyFieldValueOfHeader(Loc_Details_Violence, AM_Details_Violence, "Labels Violence", AM_Details_Violence);
		verifyFieldValueOfHeader(Loc_Details_Sensuality, AM_Details_Sensuality, "Labels Sensuality", AM_Details_Sensuality);
		verifyFieldValueOfHeader(Loc_Details_Commentary, AM_Details_Commentary, "Labels Commentary", AM_Details_Commentary);
		verifyFieldValueOfHeader(Loc_Details_Graphics,  AM_Details_Graphics, "Labels Graphics",  AM_Details_Graphics);
		verifyFieldValueOfHeader(Loc_Details_Disclaimers, AM_Details_Disclaimers, "Labels Disclaimers", AM_Details_Disclaimers);
		verifyFieldValueOfHeader(Loc_Details_Tournament, AM_Details_Tournament, "Labels Tournament", AM_Details_Tournament);
		verifyFieldValueOfHeader(Loc_Details_Teams, AM_Details_Teams, "Labels Teams", AM_Details_Teams);
		verifyFieldValueOfHeader(Loc_Details_Image, AM_Details_ImageUpload, "Labels image Upload", AM_Details_ImageUpload);
		System.out.println("***************************");
		//TC_AM_DT_006
		//Field - AKA
		WaitForElementPresent(By.xpath(Loc_Details_AssetTitle1Row));
		Thread.sleep(2000);
		clickOn(Loc_Details_1Row, " Details 1Row", "");
		Thread.sleep(2000);
		if(ClientData.contains("TURNER")) {

			clickUsingJSExecutor(Loc_Details_AssetTitle1Row, "Asset Title 1Row", Loc_Details_AKA);

			WaitForElementPresent(By.xpath(Loc_Details_AssetTitleRowInput));
			Thread.sleep(2000);
			sendKeys(Loc_Details_AssetTitleRowInput, AM_Details_AKAData, "AKA Input", AM_Details_AKAField);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);

		}else{
			clickOn(Loc_Details_AssetTitle1Row, "Asset Title 1Row", Loc_Details_AKA);
			WaitForElementPresent(By.xpath(Loc_Details_AssetTitle1RowInput));
			Thread.sleep(2000);
			sendKeys(Loc_Details_AssetTitle1RowInput, AM_Details_AKAData, "AKA Input", AM_Details_AKAField);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
		}

		//Field - AKA Type
		clickOn(Loc_Details_AKAType1Row, "AKA Type", AM_Details_AKAField);
		sendKeys(Loc_Details_AKATypeInput, AM_Details_AKATypeData, "AKA Type Input", AM_Details_AKAField);
		Enter();
		//Network
		if (!AM_Details_NetworkField.contains("N/A")) {
			clickUsingJSExecutor(Loc_Details_Networks1Row, "Networks 1Row");
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Networks 1Row Input", "");
			Enter();
			//TC_AM_DT_009
			//Img
			clickUsingJSExecutor(Loc_Details_NetworkImg, "Network img", "");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_SelectAll);
			verifyTextMatches(Loc_SelectAll, "Select All", "Select All", "value");
			verifyTextMatches(Loc_DeselectAllButton, "Deselect All", "Deselect All", "value");
			verifyTextMatches(Applybutton_AtSBUWindow, "Apply", "Apply", "value");
			verifyTextMatches(LocCancel, "Cancel", "Cancel", "value");
			clickUsingJSExecutor(Loc_SelectAll, "Select All button", "");
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			verifyElementNotPresent(Loc_Details_Network_PickListUnchecked, "All check box Checked");  
			Thread.sleep(3000);
			clickUsingJSExecutor(Loc_DeselectAllButton, "Deselect All button", "");
			Thread.sleep(3000);
			switchIntoFrame(frameParent3Xpath);
			verifyElementNotPresent(Loc_Details_Network_PickListChecked, "All check box Unchecked");
			Thread.sleep(3000);
			clickUsingJSExecutor(LocCancel, "Cancel button", "");
			switchIntoFrame(frameParent2Xpath);	
			switchIntoChildFrame(frameParent21Xpath);	
		}
		//clickOn(Loc_Details_AKAType2Row, "AKA Type 2nd Row");	
		clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab SaveBtn");	
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);	
		WaitForElementPresent(DetailsTabSaveBtn);
		//TC_AM_DT_016
		//Field - Shooting Format	
		selectDropdownValue(Loc_Details_ShootingFormatDropDown, "Shooting Format DropDown", AM_Details_Shootingformatval, AM_Details_ShootingFormat);
		//Field - DeliveryFormat
		selectDropdownValue(Loc_Details_DeliveryFormatDropDown, "DeliveryFormat DropDown", AM_Details_Delivereyformatval, AM_Details_DeliveryFormat);	
		//Field - Releasing Year
		selectDropdownValue(Loc_Details_ReleasingYearDropDown, "Releasing Year DropDown", "2009", AM_Details_ReleaseYear);
		selectDropdownValue(Loc_Details_ReleasingYearDropDown, "Releasing Year DropDown", "2010", AM_Details_ReleaseYear);	
		clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab SaveBtn");	
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);	
		WaitForElementPresent(DetailsTabSaveBtn);	
		//Field - Publisher
		String Publisher = xlsInputData.getCellData("AM_Details", ClientData, 71);
		if (!Publisher.contains("N/A")) {
			clickUsingJSExecutor(Loc_Details_PublisherImg, "Publisher Outlet");
			switchIntoFrame(frameParent3Xpath);	
			WaitForElementToClickable(SaveButton);
			sendKeys(LocTextName, Publisher, "Text Name", "");
			clickUsingJSExecutor(LocFindButton, "FindButton");
			WaitForElementPresent(By.xpath("//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]"));
			clickOn("//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]", "Select 1st Row");
			clickOn(LocSelectButton, "Select Button");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);	
		}
		//Field - Input Asset Description  
		String AssetDescription = xlsInputData.getCellData("AM_Details", ClientData, 72);
		if (!AssetDescription.contains("N/A")) {
			clickOn(Loc_Details_DescriptionTextBox, "Description Text Box");
			sendKeys(Loc_Details_DescriptionTextBox, "TestAssetDescription", "Enter Data Description", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);	
			WaitForElementPresent(DetailsTabSaveBtn);
			clickOn(Loc_Details_DescriptionTextBox, "Description Text Box");
			sendKeys(Loc_Details_DescriptionTextBox, "UpdatedTestAssetDescription", "Enter Data In Description ", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field - Entering credits time	
		String CreditsTimeIn = xlsInputData.getCellData("AM_Details", ClientData, 73);
		if (!CreditsTimeIn.contains("N/A")) {
			clickOn(Loc_Details_CreditTimeIn, "Credits Time In");
			driver.findElement(By.xpath(Loc_Details_CreditTimeIn)).sendKeys("24000000");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "Blank Credit Time Out", AM_Details_CreditTimeOut);
			clickOn(Loc_Details_CreditTimeout, "Credits Time Out");
			driver.findElement(By.xpath(Loc_Details_CreditTimeout)).sendKeys("01000000");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "Credits Time Exceeds", AM_Details_CreditsTimeExceeds);
			clickOn(Loc_Details_CreditTimeIn, "Credits Time In");
			driver.findElement(By.xpath(Loc_Details_CreditTimeIn)).sendKeys("02000000");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save "); 
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "Credits Time Out lesser", AM_Details_CreditsTimeOutlesser);
			clickOn(Loc_Details_CreditTimeout, "Credits Time Out");
			driver.findElement(By.xpath(Loc_Details_CreditTimeout)).sendKeys("02100000");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save "); 
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field - language
		String language = xlsInputData.getCellData("AM_Details", ClientData, 75);
		if (!language.contains("N/A")) {
			selectDropdownValue(Loc_Details_LanguageDropDown, "language", AM_Details_Languageval, "");	
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");	
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field - Country of Origin

		selectDropdownValue(Loc_Details_CountryofOriginDropDown, "Country of Origin DropDown",AM_Details_Country1 , AM_Details_CountryofOriginData);

		//Field - Close Captioned
		if (!AM_Details_CloseCaptioned.contains("N/A")) {
			selectDropdownValue(Loc_Details_CloseCaptionedDropDown, "Close Captioned", AM_Details_CloseCaptionedval, "");	
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}

		//Field - Dubbed
		selectDropdownValue(Loc_Details_DubbedDropDown, "Dubbed", AM_Details_Dubbedlangval, AM_Details_Dubbed);
		clickOn(Loc_Details_DubbedDropDown, "Dubbed",AM_Details_Dubbed);	

		//Field - Subtitle

		selectDropdownValue(Loc_Details_SubtitleDropDown, "Subtitle", AM_Details_Subtitlelangval, AM_Details_Subtitled);
		clickOn(Loc_Details_SubtitleDropDown, "Subtitle",AM_Details_Subtitled);

		//Field - Source System  
		verifyFieldValueOfHeader(Loc_Details_SourceSystem1, AM_Details_SystemData, "Source System ", AM_Details_System);

		//Field - Source Id 
		//		verifyFieldValueOfHeader(Loc_Details_SourceID, AM_Details_SourceIDData, "Source Id", AM_Details_SourceID); 

		//Field Grade From & To  
		if (!AM_Details_FromGrade.contains("N/A")) {
			selectDropdownValue(Loc_Details_FromGradeDropDown, "Grade From", "5", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "select both From-Grade and To-Grade.", AM_Details_bothFromGradeandToGrade);
			selectDropdownValue(Loc_Details_ToGradeDropDown, "Grade To", "1", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "greater than the To-Grade. Please enter an equivalent or lower Grade.", AM_Details_bothgreaterthan);
			selectDropdownValue(Loc_Details_FromGradeDropDown, "Grade From", "1", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			WaitForElementPresent(DetailsTabSaveBtn); 
		}
		//Field TV Parental Rating
		if (!AM_Details_TVParentalRating.contains("N/A")) {
			clickOn(Loc_Details_TVParentalRating1stRow1Col, "TV Parental Rating 1stRow 1Col");	
			sendKeys(Loc_Details_TVParentalRating1stRow1ColInput, AM_Details_TVParentalRatingData, "TV Parental Rating 1stRow 1Col Input", "");
			Actions act1 = new Actions(driver);
			act1.sendKeys(Keys.ENTER).perform();
			clickUsingJSExecutor(Loc_Details_ExtensionImg, "ExtensionImg");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(By.xpath(Applybutton_AtSBUWindow));
			clickOn(Loc_Details_ExtensionListSexuality, "Select Sexuality");
			clickUsingJSExecutor(Applybutton_AtSBUWindow, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field -'Rating Warning'  
		if (!AM_Details_RatingWarning.contains("N/A")) {
			selectDropdownValue(Loc_Details_RatingWarningDropDown, "Rating Warning", AM_Details_RatingWarning, "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field -MPAA Rating
		if (!AM_Details_MPAARating.contains("N/A")) {
			selectDropdownValue(Loc_Details_MPAARatingDropDown, "MPAA Warning", AM_Details_MPAARatingval, "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field - Keyword 
		if (!AM_Details_Keywords.contains("N/A")) {
			clickUsingJSExecutor(Loc_Details_KeywordsPickList, "Keywords Pick List");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(SaveButton);
			clickUsingJSExecutor(LocFindButton, "Find Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(2000);
			clickUsingJSExecutor(SaveButton, "Select Button");
			Thread.sleep(2000);
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(AlertValidationMessgeText, "Without entering Keyword", AM_Details_KeywordWithoutselect);
			Thread.sleep(1000);
			clickUsingJSExecutor(OKAlertButtonXpath, "Ok");
			Thread.sleep(2000);
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(2000);
			clickUsingJSExecutor(LocNewButton, "New Button");
			Thread.sleep(2000);
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(By.xpath(Loc_Details_KeywordsSave));
			clickUsingJSExecutor(Loc_Details_KeywordsSave, "Keywords Save Button");
			driver.switchTo().window(driver.getWindowHandle());

			Thread.sleep(1000);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
			driver.switchTo().window(driver.getWindowHandle());
			switchIntoFrame(frameParent4Xpath);
			clickOn(Loc_Details_KeywordsInput, "Keywords Input");
			sendKeys(Loc_Details_KeywordsInput, "Action", "Keywords Input", "");
			clickUsingJSExecutor(Loc_Details_KeywordsSave, "Keywords Save Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(AlertValidationMessgeText, "Already exist data ", AM_Details_KeywordAlreadyExist);
			Thread.sleep(1000);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
			driver.switchTo().window(driver.getWindowHandle());
			switchIntoFrame(frameParent4Xpath);
			clickOn(Loc_Details_KeywordsInput, "Keywords Input");
			sendKeys(Loc_Details_KeywordsInput, "NewAction_"+formattedDate+"", "Keywords Input", "");
			clickUsingJSExecutor(Loc_Details_KeywordsSave, "Keywords Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(Loc_Details_1stValueSelect);
			clickOn(Loc_Details_1stValueSelect, "Select 1st Row");
			clickUsingJSExecutor(LocSelectButton, "Select Button");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor(Loc_Details_KeywordsPickList, "Keywords Pick List");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(SaveButton);
			sendKeys(LocTextName, "NewAction_"+formattedDate+"", "Text Name", "");
			clickUsingJSExecutor(LocFindButton, "Find Button");
			WaitForElementPresent(Loc_Details_1stValueSelect);
			clickOn(Loc_Details_1stValueSelect, "Select row");
			clickUsingJSExecutor(LocSelectButton, "Select Button");
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(3000);
			clickUsingJSExecutor(Loc_Details_Options3, "Seelct 3rd Option");
			clickUsingJSExecutor(OKButton, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(Loc_Details_KeywordsPickList);
			clickUsingJSExecutor(Loc_Details_KeywordsPickList, "Keywords Pick Lis");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(SaveButton);
			clickOn(LocTextName, "text name");
			sendKeys(LocTextName, "NewAction_"+formattedDate+"", "text name", "");
			clickUsingJSExecutor(LocFindButton, "Find");
			WaitForElementPresent(Loc_Details_1stValueSelect);
			clickOn(Loc_Details_1stValueSelect, "Select row");
			clickUsingJSExecutor(LocSelectButton, "Select Button");
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(3000);
			clickUsingJSExecutor(Loc_Details_Options2, "option 2");
			clickUsingJSExecutor(OKButton, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor(Loc_Details_KeywordsPickList, "Keywords Pick List");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(SaveButton);
			sendKeys(LocTextName, "NewAction_"+formattedDate+"", "text Name", "");
			clickUsingJSExecutor(LocFindButton, "Find");
			WaitForElementPresent(Loc_Details_1stValueSelect);
			clickOn(Loc_Details_1stValueSelect, "Select 1st row");
			clickUsingJSExecutor(LocSelectButton, "Select");
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(3000);
			clickUsingJSExecutor(Loc_Details_Options1, "Options 1");
			clickUsingJSExecutor(OKButton, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			//Delete Icon
			WaitForElementPresent(Loc_Details_KeywordsDeleteBtn);
			Thread.sleep(2000);
			clickUsingJSExecutor(Loc_Details_KeywordsDeleteBtn, "Delete Keywords Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(AlertValidationMessgeText, "Alert Validation Messge Text", AM_Details_KeywordDeleteWithoutAlertMsg);
			Thread.sleep(2000);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickOn(Loc_Details_Keywors1Row, "1st Row ");
			clickUsingJSExecutor(Loc_Details_KeywordsDeleteBtn, "Keywords Delete Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Validation Messge Text", AM_Details_KeywordDeleteWithAlertMsg);
			clickUsingJSExecutor(Loc_ConfirmCancel, "Confirm Cancel", "");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			clickUsingJSExecutor(Loc_Details_KeywordsDeleteBtn, "Keywords Delete Button");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Validation Messge Text", AM_Details_KeywordDeleteWithAlertMsg);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button", "");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
		}
		//Field - Production #  
		if (!AM_Details_Production.contains("N/A")) {
			clickOn(Loc_Details_ProductionInput, "Input Production");
			sendKeys(Loc_Details_ProductionInput, "Testingxyz", "Input Production", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			clickOn(Loc_Details_ProductionInput, "Input Production");
			sendKeys(Loc_Details_ProductionInput, "Testingabc123", "Input Production", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
		}
		//Field - Universal ID  
		if (!AM_Details_UniversalID .contains("N/A")) {
			clickOn(Loc_Details_UniversalIDInput, "Universal ID DropDown");
			sendKeys(Loc_Details_UniversalIDInput, "Testingxyz", "Universal ID Input", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			clickOn(Loc_Details_UniversalIDInput, "Universal ID DropDown");
			sendKeys(Loc_Details_UniversalIDInput, "Testingabc123", "Universal ID Input", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save Btn");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);	
		}
		//Field - Master Audio 
		if (!AM_Details_MasterAudio.contains("N/A")) {
			selectDropdownValue(Loc_Details_MasterAudioDropDown, "MasterAudio", AM_Details_MasterAudioval, "");
		}
		//Field - HD Percentage 
		String HDPercentage  = xlsInputData.getCellData("AM_Details", ClientData, 89);
		if (!HDPercentage.contains("N/A")) {
			selectDropdownValue(Loc_Details_HDPercentage, "HD Percentage ", AM_Details_HDPercentageval, "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save Btn");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			Thread.sleep(3000);
			verifyTextMatches(Loc_Details_Error, "select both HD Type and HD Percentage", xlsInputData.getCellData("AM_Details", ClientData, 178));
		}
		//Field - HD Type 	
		String HDType  = xlsInputData.getCellData("AM_Details", ClientData, 90);
		if (!HDType.contains("N/A")) {
			selectDropdownValue(Loc_Details_HDType, "HD Type ", AM_Details_HDTypeval, "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab Save Btn");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}

		//Field - Entering Box Office 
		if (!AM_Details_Boxoffice.contains("N/A")) {
			clickUsingJSExecutor(Loc_Details_BoxOffice, "Box Office");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(OKButton);
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Country_Key +"']", AM_Details_Country, "Country Field", AM_Details_Country, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Currency_Key +"']", AM_Details_Currency, "Currency Field", AM_Details_Currency, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_ReleaseDate_Key +"']", AM_Details_ReleaseDate, "Release Date Field", AM_Details_ReleaseDate, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Actual_Key +"']", AM_Details_Actual, "Actual Field", AM_Details_Actual, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_AsofDate_Key +"']", AM_Details_AsofDate, "As of Date Field", AM_Details_AsofDate, "innerHTML");
			//Button
			verifyTextMatches(LocAdd, "Add","Add","value");
			verifyTextMatches(LocDelete, "Delete","Delete","value");
			verifyTextMatches(OKButton, "Ok","OK","value");
			verifyTextMatches(LocCancel, "Cancel","Cancel","value");
			clickUsingJSExecutor(LocAdd, "Add");
			WaitForElementPresent(Loc_Details_BoxOffice1Row);
			clickUsingJSExecutor(OKButton, "Ok");
			Thread.sleep(3000);
			verifyTextMatches(LocErrorMgs, "Error Msg", AM_Details_AlertMsg);
			if (Browser.equalsIgnoreCase("chrome")) {
				clickOn(Loc_Details_Counry1Row, "Counry1Row");
			} else {
				clickOn(Loc_Details_Counry1Row, "Counry 1 Row");
				clickOn(Loc_Details_Counry1Row, "Counry 1 Row");
			}
			sendKeys(Loc_Details_CountryInput, "United States", "CountryInput", xlsInputData.getCellData("AM_Details", ClientData, 107));
			clickOn(Loc_Details_Currency1Row, "Currency 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 108));
			verifyTextMatches(Loc_Details_Currency1Row, "Currency 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 120));
			clickOn(Loc_Details_Year1Row, "Year 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 109));
			sendKeys_WithoutClear(Loc_Details_Year1RowInput, "2013", "Year Input", xlsInputData.getCellData("AM_Details", ClientData, 109));
			//					driver.findElement(By.xpath(Loc_Details_Year1RowInput)).sendKeys("2013");
			clickOn(Loc_Details_ReleaseDate1Row, "Release Date 1 Row",AM_Details_ReleaseDate);
			sendKeys_WithoutClear(Loc_Details_ReleaseDate1RowInput, "01/01/2013", "Release Date Input 1", AM_Details_ReleaseDate);
			//					driver.findElement(By.xpath(Loc_Details_ReleaseDate1RowInput)).sendKeys("01/01/2013");
			clickOn(Loc_Details_Estimated1Row, "Estimated 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 111));
			sendKeys(Loc_Details_Estimated1RowInput, "10", "Estimated 1 Row Input",xlsInputData.getCellData("AM_Details", ClientData, 111));
			clickOn(Loc_Details_Actual1Row, "Actual 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 112));
			sendKeys(Loc_Details_Actual1RowInput, "10", "Actual1RowInput", xlsInputData.getCellData("AM_Details", ClientData, 112));
			clickOn(Loc_Details_WksRpted1Row, "WksRpted 1 Row", xlsInputData.getCellData("AM_Details", ClientData, 113));
			sendKeys(Loc_Details_WksRpted1RowInput, "10", "Wks Rpted 1 Row Input", xlsInputData.getCellData("AM_Details", ClientData, 113));
			clickOn(Loc_Details_PointsofRel, "Points of Rel", xlsInputData.getCellData("AM_Details", ClientData, 114));
			sendKeys(Loc_Details_PointsofRelInput, "10", "Points of Rel Input", xlsInputData.getCellData("AM_Details", ClientData, 114));
			clickOn(Loc_Details_AsofDate1Row, "As of Date 1 Row",AM_Details_AsofDate);
			sendKeys_WithoutClear(Loc_Details_AsofDate1RowInput, "01/01/2013", "As of Date Input", AM_Details_AsofDate);
			keyboard();
			clickOn(Loc_Details_WksRpted1Row, "Wks Rpted 1 Row",xlsInputData.getCellData("AM_Details", ClientData, 113));
			ExecutionLog.Log("");
			clickUsingJSExecutor(OKButton, "Ok");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			verifyTextMatches(Loc_Details_BoxOfficeInpput, "BoxOfficevalue1", xlsInputData.getCellData("AM_Details", ClientData, 121), "value");
			//Delete
			clickUsingJSExecutor(Loc_Details_BoxOffice, "Box Office");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(OKButton);
			clickUsingJSExecutor(LocDelete, "Delete");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(AlertValidationMessgeText, "Alert Validation Messge", xlsInputData.getCellData("AM_Details", ClientData, 180));
			Thread.sleep(1000);
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
			switchIntoFrame(frameParent3Xpath);
			clickOn(Loc_Details_BoxOffice1stRow,"BoxOffice 1st Row");
			clickUsingJSExecutor(LocDelete, "Delete");
			driver.switchTo().window(driver.getWindowHandle());
			verifyTextMatches(ConfirmAlertValidationMessgeText, "Confirm Alert Validation MessgeText", xlsInputData.getCellData("AM_Details", ClientData, 179));
			Thread.sleep(1000);
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "Confirm Alert Button", "");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(OKButton, "Ok");
			WaitForModalPanel();
			driver.switchTo().window(driver.getWindowHandle());
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			verifyTextMatches(Loc_Details_BoxOfficeInpput, "Details Box Office Input", " ", "value");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}


		//Field - Target demographics
		//Need to code, Failure in the system -  nothing happen while click in the field
		//Field - Union / Guild Affiliation
		String GuildAffiliation  = xlsInputData.getCellData("AM_Details", ClientData, 93);
		if (!GuildAffiliation.contains("N/A")) {
			selectDropdownValue(Loc_Details_GuildAssociationDropDown, "Guild Association DropDown", AM_Details_GuildeAffiliationval, "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			driver.switchTo().window(driver.getWindowHandle());
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		//Field - VMID
		String VMID  = xlsInputData.getCellData("AM_Details", ClientData, 86);
		if (!VMID.contains("N/A")) {
			clickOn(Loc_Details_VMIDInput, "VMID");
			sendKeys(Loc_Details_VMIDInput, "Testingabc123", "VMID", "");
		}
		//Field - Tier		
		String Tier  = xlsInputData.getCellData("AM_Details", ClientData, 94);
		if (!Tier.contains("N/A")) {
			selectDropdownValue(Loc_Details_TierInput, "TierInput", AM_Details_Tierval, "");
		}
		// Field - IPSAvailability date
		String IPSAvailabilityDate  = xlsInputData.getCellData("AM_Details", ClientData, 95);
		if (!IPSAvailabilityDate.contains("N/A")) {
			clickOn(Loc_Details_InternationalAmortizationDateInput, "International Amortization Date Input");
			sendKeys(Loc_Details_InternationalAmortizationDateInput, "01/01/2013", "International Amortization Date Input", "");
		}
		//Field - SAPMPMID
		String SAPMPMID  = xlsInputData.getCellData("AM_Details", ClientData, 96);
		if (!SAPMPMID.contains("N/A")) {
			clickOn(Loc_Details_SAPMPMIDinput, "SAPMPMID input");
			sendKeys(Loc_Details_SAPMPMIDinput, "Testingabc123", "SAPMPMID input", "");
		}
		//Field - CC
		String CC  = xlsInputData.getCellData("AM_Details", ClientData, 98);
		if (!CC.contains("N/A")) {
			clickOn(Loc_Details_CCCheckBox, "CC CheckBox");
		}
		//Field - HD
		String HD  = xlsInputData.getCellData("AM_Details", ClientData, 124);
		if (!HD.contains("N/A")) {
			clickOn(Loc_Details_HDCheckABox, "HD CheckABox");
		}
		//Field - CopyRightDate
		String CopyRightDate  = xlsInputData.getCellData("AM_Details", ClientData, 99);
		if (!CopyRightDate.contains("N/A")) {
			selectDropdownValue(Loc_Details_CopyRightDateDropDown, "Copy Right Date DropDown", AM_Details_CopyRightDateval, "");
		}
		//Field - Nudity
		String Nudity  = xlsInputData.getCellData("AM_Details", ClientData, 100);
		if (!Nudity.contains("N/A")) {
			clickOn(Loc_Details_NudityCheckBox, "Nudity Check Box");
		}
		//Field - Rape
		String Rape  = xlsInputData.getCellData("AM_Details", ClientData, 101);
		if (!Rape.contains("N/A")) {
			clickOn(Loc_Details_RapeCheckBox, "Rape Check Box");
		}
		//Field - Violence
		String Violence  = xlsInputData.getCellData("AM_Details", ClientData, 102);
		if (!Violence.contains("N/A")) {
			clickOn(Loc_Details_ViolenceCheckbox, "Violence Checkbox");
		}
		//Field - Sensuality
		String Sensuality  = xlsInputData.getCellData("AM_Details", ClientData, 103);
		if (!Sensuality.contains("N/A")) {
			clickOn(Loc_Details_SensualityCkeckBox, "Sensuality CkeckBox");
		}
		//Field - Commentary
		String Commentary  = xlsInputData.getCellData("AM_Details", ClientData, 104);
		if (!Commentary.contains("N/A")) {
			clickOn(Loc_Details_CommentaryCheckBox, "Commentary CheckBox");
		}
		//Field - Graphics
		String Graphics = xlsInputData.getCellData("AM_Details", ClientData, 105);
		if (!Graphics.contains("N/A")) {
			clickOn(Loc_Details_GraphicsCheckbox, "Graphics Checkbox");
		}
		//Field - Disclaimers
		String Disclaimers = xlsInputData.getCellData("AM_Details", ClientData, 106);
		if (!Disclaimers.contains("N/A")) {
			clickOn(Loc_Details_DisclaimersInput, "Disclaimers Input");
			sendKeys(Loc_Details_DisclaimersInput, "Testingabc123", "Disclaimers Input", "");
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
		}
		Thread.sleep(3000);

		//TC_AM_DT_155
		//Field - Synopsis
		if (!AM_Details_SynopsisType.contains("N/A")) {
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			System.out.println("***************************");
			//SKY
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_SynopsisType_Key +"']", AM_Details_SynopsisType, "SynopsisType Field", AM_Details_SynopsisType, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Network_Key +"']", AM_Details_Network, "Channel Field", AM_Details_Network, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_SynopsisSource_Key +"']", AM_Details_SynopsisSource, "Synopsis Source Field", AM_Details_SynopsisSource, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Language_Key +"']", AM_Details_Language, "Language Field", AM_Details_Language_Key, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Length_Key +"']", AM_Details_Length, "Length Field", AM_Details_Length, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_CreatedBy_Key +"']", AM_Details_CreatedBy, "Created By Field", AM_Details_CreatedBy, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_CreatedDate_Key +"']", AM_Details_CreatedDate, "Created Date Field", AM_Details_CreatedDate, "innerHTML");
			verifyFieldValueOfHeader("//th[@key='" + AM_Details_Synopsis_Key +"']", AM_Details_Synopsis, "Synopsis Field", AM_Details_Synopsis, "innerHTML");
			System.out.println("***************************");
			//1st Row
			doubleClick(getLocator_ViewTAB_DataRow("1", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Synopsis1Row",AM_Details_SynopsisType);
			Thread.sleep(5000);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementToClickable(OKButton);
			verifyElementDisplayed(Loc_Details_DoNOTUseexternally, "Passed :Do Not Use Externally Flag is marked with X ", "");
			verifyTextMatches(Loc_Details_SynopsisType, "Synopsis Type",xlsInputData.getCellData("AM_Details", ClientData, 129));
			verifyTextMatches(Loc_Details_Network1, "Network",xlsInputData.getCellData("AM_Details", ClientData, 130));
			verifyTextMatches(Loc_Details_Source, "Source Type",xlsInputData.getCellData("AM_Details", ClientData, 131));
			verifyTextMatches(Loc_Details_Title, "Title",xlsInputData.getCellData("AM_Details", ClientData, 132));
			verifyTextMatches(Loc_Details_Length, "Length",xlsInputData.getCellData("AM_Details", ClientData, 133));
			verifyTextMatches(Loc_Details_Synopsis1, "Synopsis",xlsInputData.getCellData("AM_Details", ClientData, 134));
			verifyTextMatches(Loc_Details_SynopsisLanguage, "Language",xlsInputData.getCellData("AM_Details", ClientData, 135));
			verifyTextMatches(Loc_Details_LanguageTitle1, "Language Title",xlsInputData.getCellData("AM_Details", ClientData, 136));
			verifyTextMatches(Loc_Details_LanguageSeriesTitle1, "Language Series Title",xlsInputData.getCellData("AM_Details", ClientData, 137));
			verifyTextMatches(Loc_Details_ViewContributors, "View Contributors Button",xlsInputData.getCellData("AM_Details", ClientData, 138),"Value");		
			clickUsingJSExecutor(OKButton, "Ok");
			Thread.sleep(3000);
			verifyTextMatches(LocErrorMgs, "Error Msg", AM_Details_AlertMsg);
			selectDropdownValue(Loc_Details_Synopsistype, "Synopsistype", AM_Details_SynopsisTypeData1, "");
			Thread.sleep(3000);
			verifyDropDownValues(Loc_Details_LengthDropdown, "*Length", "AM_Details", 43, 48);
			selectDropdownValue(Loc_Details_LengthDropdown, "Length", AM_Details_LengthData1, AM_Details_Length);
			clickOn(Loc_Details_SynopsistypeInput, "Synopsistype Input");
			sendKeys(Loc_Details_SynopsistypeInput, "ABCDEFGHIJKLMNOPQRS", "SynopsistypeInput", "");
			Thread.sleep(3000);
			//Network
			//TC_AM_DT_134
			if (!AM_Details_AssetSynopsisNetwork.contains("N/A")) {	
				//img
				clickUsingJSExecutor(Loc_Details_SynopsisNetworkImg, "Synopsis NetworkImg", AM_Details_SynopsisNetwork1);
				Thread.sleep(3000);
				switchIntoFrame(frameParent4Xpath);
				WaitForElementPresent(Applybutton_AtSBUWindow);
				Thread.sleep(2000);
				clickOn(Loc_Details_AMCHD, "AMC HD", AM_Details_SynopsisNetwork1);
				Thread.sleep(2000);
				clickUsingJSExecutor(Applybutton_AtSBUWindow, "Ok Button", "");
				switchIntoFrame(frameParent3Xpath);
				WaitForElementPresent(OKButton);
				Thread.sleep(2000);
				switchIntoFrame(frameParent3Xpath);
				selectDropdownValue(Loc_Details_NetworkDropDown, "Network DropDown", AM_Details_SynopsisNetworkData, Network);
				Thread.sleep(2000);
				switchIntoFrame(frameParent3Xpath);
				verifyTextMatches(Loc_Details_NetworkDropDown, "Network", AM_Details_SynopsisNetworkData,"title");
			}
			//Source
			selectDropdownValue(Loc_Details_SourceDropdown, "Source", AM_Details_DetailsSourceData, AM_Details_SynopsisSource);
			//TC_AM_DT_153
			//View Contributors
			clickUsingJSExecutor(Loc_Details_ViewContributors, "View Contributors");
			switchIntoFrame(frameParent4Xpath);
			driver.switchTo().window(driver.getWindowHandle());
			clickOn(Loc_Details_ContributorsClose, "Contributors Close");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(OKButton);
			clickUsingJSExecutor(OKButton, "Ok");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);	

			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Synopsis Type view mode", AM_Details_SynopsisTypeData1);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_Network_Key, AM_Details_Network), "Network view mode", AM_Details_SynopsisNetworkData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_SynopsisSource_Key, AM_Details_SynopsisSource), "Source view mode", AM_Details_DetailsSourceData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_Length_Key, AM_Details_Length), "Length view mode", AM_Details_LengthData1);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_CreatedBy_Key, AM_Details_CreatedBy), "Created By view mode", AM_Details_CreatedByData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("1", AM_Details_Synopsis_Key, AM_Details_Synopsis), "Synopsis view mode", AM_Details_SynopsisData);

			//2nd Row
			ExecutionLog.Log("2nd Row");
			doubleClick(getLocator_ViewTAB_DataRow("2", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Details Synopsis Type 2Row",AM_Details_SynopsisType);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(OKButton);
			clickUsingJSExecutor(OKButton, "Ok");
			Thread.sleep(3000);
			verifyTextMatches(LocErrorMgs, "Error Msg", AM_Details_AlertMsg);
			selectDropdownValue(Loc_Details_Synopsistype, "Synopsis type", AM_Details_SynopsisTypeData2, AM_Details_SynopsisType);
			Thread.sleep(3000);
			verifyDropDownValues(Loc_Details_LengthDropdown, "*Length", "AM_Details", 43, 48);
			selectDropdownValue(Loc_Details_LengthDropdown, "Length DropDown", AM_Details_LengthData2, AM_Details_Length);
			clickOn(Loc_Details_SynopsistypeInput, "Synopsistype Input",AM_Details_Synopsis);
			sendKeys(Loc_Details_SynopsistypeInput, AM_Details_SynopsisData , "Synopsistype Input", AM_Details_Synopsis);
			Thread.sleep(3000);
			selectDropdownValue(Loc_Details_NetworkDropDown, "Network DropDown", AM_Details_SynopsisNetworkData, AM_Details_Network);
			switchIntoFrame(frameParent3Xpath);
			//Source
			selectDropdownValue(Loc_Details_SourceDropdown, "Source", AM_Details_DetailsSourceData, AM_Details_SynopsisSource);
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(Loc_Details_ViewContributors, "ViewContributors");
			switchIntoFrame(frameParent4Xpath);
			driver.switchTo().window(driver.getWindowHandle());
			clickOn(Loc_Details_ContributorsClose, "Contributors Close");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(OKButton, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);


			WaitForElementPresent(DetailsTabSaveBtn);

			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);

			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Synopsis Type view mode", AM_Details_SynopsisTypeData2);
			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_Network_Key, AM_Details_Network), "Network view mode", AM_Details_SynopsisNetworkData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_SynopsisSource_Key, AM_Details_SynopsisSource), "Source view mode", AM_Details_DetailsSourceData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_Length_Key, AM_Details_Length), "Length view mode", AM_Details_LengthData2);
			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_CreatedBy_Key, AM_Details_CreatedBy), "Created By view mode", AM_Details_CreatedByData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("2", AM_Details_Synopsis_Key, AM_Details_Synopsis), "Synopsis view mode", AM_Details_SynopsisData);

			//3rd Row
			ExecutionLog.Log("3rd Row");
			doubleClick(getLocator_ViewTAB_DataRow("3", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Details Synopsis Type 3Row", AM_Details_SynopsisType);
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(By.xpath(OKButton));
			clickUsingJSExecutor(OKButton, "Ok");
			Thread.sleep(3000);
			verifyTextMatches(LocErrorMgs, "Error Msg", AM_Details_AlertMsg);
			selectDropdownValue(Loc_Details_Synopsistype, "Synopsis type", AM_Details_SynopsisTypeData3, AM_Details_SynopsisType);
			Thread.sleep(3000);
			verifyDropDownValues(Loc_Details_LengthDropdown, "*Length", "AM_Details", 43, 48);
			selectDropdownValue(Loc_Details_LengthDropdown, "Length Drop Down", AM_Details_LengthData3, AM_Details_Length);
			clickOn(Loc_Details_SynopsistypeInput, "Synopsistype Input",AM_Details_Synopsis);
			sendKeys(Loc_Details_SynopsistypeInput, AM_Details_SynopsisData, "Synopsistype Input", AM_Details_Synopsis);
			//Network
			selectDropdownValue(Loc_Details_NetworkDropDown, "Network DropDown", AM_Details_SynopsisNetworkData, Network);
			switchIntoFrame(frameParent3Xpath);
			//Source
			selectDropdownValue(Loc_Details_SourceDropdown, "Source", AM_Details_DetailsSourceData,AM_Details_SynopsisSource);
			switchIntoFrame(frameParent3Xpath);

			clickUsingJSExecutor(Loc_Details_ViewContributors, "View Contributors");
			switchIntoFrame(frameParent4Xpath);

			driver.switchTo().window(driver.getWindowHandle());
			clickOn(Loc_Details_ContributorsClose, "Contributors Close");
			switchIntoFrame(frameParent3Xpath);
			clickUsingJSExecutor(OKButton, "Ok");
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);

			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);

			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_SynopsisType_Key, AM_Details_SynopsisType), "Synopsis Type view mode", AM_Details_SynopsisTypeData3);
			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_Network_Key, AM_Details_Network), "Network view mode", AM_Details_SynopsisNetworkData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_SynopsisSource_Key, AM_Details_SynopsisSource), "Source view mode", AM_Details_DetailsSourceData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_Length_Key, AM_Details_Length), "Length view mode", AM_Details_LengthData3);
			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_CreatedBy_Key, AM_Details_CreatedBy), "Created By view mode", AM_Details_CreatedByData);
			verifyTextMatches(getLocator_ViewTAB_DataRow("3", AM_Details_Synopsis_Key, AM_Details_Synopsis), "Synopsis view mode", AM_Details_SynopsisData);

		}
		System.out.println("*********************End Testcase - TC2_DetailsUI *********************");

	}
	@Test(priority =3,enabled= true,description = "Validate search with respect to AKA/FKA/EAKA/Legal")
	public void TC3_ValidateSearch () throws Exception { 
		System.out.println("*************Start Testcase - TC3_ValidateSearch**********");
		AssetMaintenance assetMaintenance = new AssetMaintenance();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";

		System.out.println(CreatedSeriesAssetTitle1);
		//Asset Creation
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
		//Search Asset 
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent2Xpath);
		//Details Tab
		clickOn(DetailsTab, "Details Tab");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(DetailsTabSaveBtn);

		if (Browser.equalsIgnoreCase("chrome")){
			clickOn(Loc_Details_AssetTitle1Row, "Asset Title 1Row");

		}else{
			clickOn(Loc_Details_AssetTitle1Row, "Asset Title 1Row");
			clickOn(Loc_Details_AssetTitle1Row, "Asset Title 1Row");
		}
		if (ClientName.contains("TURNER")){
			sendKeys(Loc_Details_AssetTitleRowInput, CreatedSeriesAssetTitle1+"_AKA", "Asset Title 1Row Input", "");
		}
		else{
			sendKeys(Loc_Details_AssetTitle1RowInput, CreatedSeriesAssetTitle1+"_AKA", "Asset Title 1Row Input", "");	
		}

		clickUsingJSExecutor(Loc_Details_AKAType1Row, "AKA Type 1Row");
		sendKeys(Loc_Details_AKATypeInput, "AKA", "AKA Type Input", "");
		Actions act = new  Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

		String Network = xlsInputData.getCellData("AM_Details", ClientData, 156);
		if (!Network.contains("N/A")) {
			if (Browser.equalsIgnoreCase("chrome")){

				clickOn(Loc_Details_Networks1Row, "Network 1 Row");

			}else{
				clickOn(Loc_Details_Networks1Row, "Network 1 Row");
				clickOn(Loc_Details_Networks1Row, "Network 1 Row");
			}
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Network Input", "");
			Enter();
		}

		if (Browser.equalsIgnoreCase("chrome")){
			clickOn(Loc_Details_AssetTitle2Row, "Asset Title 2Row");


		}else{
			clickOn(Loc_Details_AssetTitle2Row, "Asset Title 2Row");
			clickOn(Loc_Details_AssetTitle2Row, "Asset Title 2Row");
		}
		if (ClientName.contains("TURNER")){
			sendKeys(Loc_Details_AssetTitleRowInput, CreatedSeriesAssetTitle1+"_FKA", "Asset Title 1Row Input", "");
		}
		else
		{
			sendKeys(Loc_Details_AssetTitle1RowInput, CreatedSeriesAssetTitle1+"_FKA", "Asset Title 1Row Input", "");
		}
		clickUsingJSExecutor(Loc_Details_AKAType2Row, "AKA Type 2Row");
		sendKeys(Loc_Details_AKATypeInput, "FKA", "AKA Type Input", "");
		Enter();
		String Network5 = xlsInputData.getCellData("AM_Details", ClientData, 156);
		if (!Network5.contains("N/A")) {
			clickOn(Loc_Details_Networks2Row, "Networks 2Row");
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Networks 2Row Input", "");
		}
		if(!ClientName.contains("SKY")){
			//		scrollElementIntoView(Loc_Details_3Row);
			Thread.sleep(6000);
		}
		if (Browser.equalsIgnoreCase("chrome")){
			clickOn(Loc_Details_AssetTitle3Row, "Asset Title 3Row");
		}else{
			clickOn(Loc_Details_AssetTitle3Row, "Asset Title 3Row");
			clickOn(Loc_Details_AssetTitle3Row, "Asset Title 3Row");
		}
		if (ClientName.contains("TURNER")){
			sendKeys(Loc_Details_AssetTitleRowInput, CreatedSeriesAssetTitle1+"_EAKA", "AssetTitle 3Row Input", "");
		}
		else
		{
			sendKeys(Loc_Details_AssetTitle1RowInput, CreatedSeriesAssetTitle1+"_EAKA", "AssetTitle 3Row Input", "");	
		}

		clickUsingJSExecutor(Loc_Details_AKAType3Row, "AKA Type 3Row");
		sendKeys(Loc_Details_AKATypeInput, "EAKA", "AKA Type Input", "");
		Enter();

		String Network6 = xlsInputData.getCellData("AM_Details", ClientData, 156);
		if (!Network6.contains("N/A")) {
			if (Browser.equalsIgnoreCase("chrome")){
				clickOn(Loc_Details_Networks3Row, "Networks 3Row");


			}else{
				clickOn(Loc_Details_Networks3Row, "Networks 3Row");
				clickOn(Loc_Details_Networks3Row, "Networks 3Row");
			}
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Networks 3Row Input", "");
			Enter();

		}

		scrollElementIntoView(Loc_Details_AssetTitle4Row);

		if (Browser.equalsIgnoreCase("chrome")){
			clickOn(Loc_Details_AssetTitle4Row, "Asset Title 4Row");
			clickOn(Loc_Details_AssetTitle4Row, "Asset Title 4Row");

		}else{
			clickOn(Loc_Details_AssetTitle4Row, "Asset Title 4Row");
			clickOn(Loc_Details_AssetTitle4Row, "Asset Title 4Row");
		}
		if (ClientName.contains("TURNER")){
			sendKeys(Loc_Details_AssetTitleRowInput, CreatedSeriesAssetTitle1+"_Legal", "Asset Title 1Row Input", "");
		}
		else
		{
			sendKeys(Loc_Details_AssetTitle1RowInput, CreatedSeriesAssetTitle1+"_Legal", "Asset Title 1Row Input", "");	
		}

		clickUsingJSExecutor(Loc_Details_AKAType4Row, "AKA Type 4Row");
		sendKeys(Loc_Details_AKATypeInput, "Legal", "AKA Type Input", "");
		Enter();
		//Network
		String Network7 = xlsInputData.getCellData("AM_Details", ClientData, 156);
		if (!Network7.contains("N/A")) {
			if (Browser.equalsIgnoreCase("chrome")){
				clickOn(Loc_Details_Networks4Row, "Networks 4Row");

			}else{
				clickOn(Loc_Details_Networks4Row, "Networks 4Row");
				clickOn(Loc_Details_Networks4Row, "Networks 4Row");
			}
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Networks Row Input", "");
			//Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		Thread.sleep(200);


		clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
		WaitForModalPanel();
		//Navigate to search asset screen
		switchIntoFrame(frameParent2Xpath);
		if (ClientName.contains("VMN")){
			clickUsingJSExecutor(SearchXpath,"Search Icon");
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");

			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
			clickUsingJSExecutor(loc_VMNSearchCritariaBox, "VMNSearchCritaria");
		}
		else{
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			sleepTime(5);
			clickUsingJSExecutor(loc_AssetSearchUnderSearch, "AssetSearchUnderAsset");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}
		Thread.sleep(2000);
		//Search asset with title - check AKA
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1, "Asset Tttle", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search asset with title - check AKA ", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(loc_AssetTitle);
		//Search asset with title - uncheck AKA
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1, "Search asset with title - uncheck AKA", "");
		clickUsingJSExecutor(Loc_AKACheckBox, "AKA CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search asset with title - uncheck AKA ", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		//Search with AKA-1
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_AKA", "Search with AKA-1", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with AKA-1 ", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with AKA-2
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_AK", "Search with AKA-2", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with AKA-2 ", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with AKA-3
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_AKA", "Search with AKA-3","");
		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with AKA-3 ", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with AKA-4
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_AKA", "Search with AKA-4", "");
		clickUsingJSExecutor(Loc_AKACheckBox, "AKA CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Search Data Not Match", AM_Details_SearchResultNotMatch);
		Thread.sleep(3000);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		//Search with FKA-1
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_FKA", "Search with FKA-1", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with FKA-1", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-2
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_FK", "Search with FKA-2", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with FKA-2", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-3
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_FKA", "Asset Title", "");

		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with FKA-3", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-4
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_FKA", "Asset Title", "");
		clickUsingJSExecutor(Loc_AKACheckBox, "AKA CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Search Data Not Match", AM_Details_SearchResultNotMatch);
		Thread.sleep(3000);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with EAKA-1
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_EAKA", "Asset Title", "");

		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with EAKA-1", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-2
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_EAK", "Asset Title", "");

		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with EAKA-2", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-3
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_EAKA", "_Asset Title", "");
		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox");

		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with EAKA-3", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with FKA-4
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_EAKA", "Asset Title", "");
		clickUsingJSExecutor(Loc_AKACheckBox, "AKA CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Search Data Not Match", AM_Details_SearchResultNotMatch);
		Thread.sleep(3000);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		//Search with Legal
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_Legal", "Asset Title", "");

		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with Legal", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with Leg
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_Leg", "Asset Title", "");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with Leg", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with Legal
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_Legal", "Asset Title", "");
		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox");
		clickUsingJSExecutor(Loc_ExactMatchCheckBox, "Exact Match CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_SearchedAsset, "Search with Legal", CreatedSeriesAssetTitle1);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//Search with Legal
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle1+"_Legal", "Asset Title", "");
		clickUsingJSExecutor(Loc_AKACheckBox, "AKA CheckBox");
		clickUsingJSExecutor(Loc_SearchButton, "Find Button");
		driver.switchTo().window(driver.getWindowHandle());
		verifyTextMatches(AlertValidationMessgeText, "Search Data Not Match", AM_Details_SearchResultNotMatch);
		Thread.sleep(3000);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(Loc_ClearSearch, "Clear Search");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		System.out.println("*********************End Testcase - TC3_ValidateSearch *********************");
	}

	@Test(priority =4,enabled= true,description = "Series handling after updating fields in Details Tab")
	public void TC4_Series_handling () throws Exception {

			System.out.println("*************Start Testcase - TC4_SeriesHandling**********");
			AssetMaintenance assetMaintenance = new AssetMaintenance(); 
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+""; 
			assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1, Series_AssetType);
			assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
			assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Details"), "Details TAB");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);

			doubleClick(Loc_Details_AssetTitle1Row, "Asset Title 1Row", "");
			if (ClientName.contains("TURNER")){
				sendKeys(Loc_Details_AssetTitleRowInput, "AUT_Test_AKA", "Asset Title 1Row Input", "");
			}
			else
			{
				sendKeys(Loc_Details_AssetTitle1RowInput, "AUT_Test_AKA", "Asset Title 1Row Input", "");
			}
			clickUsingJSExecutor(Loc_Details_AKAType1Row, "AKA Type 1Row");
			sendKeys(Loc_Details_AKATypeInput, "AKA", "AKA Type Input", "");
			Enter();
			Thread.sleep(1000);
			//Network 
			clickUsingJSExecutor(Loc_Details_Networks1Row, "Networks 1Row",AM_Details_NetworkField);
			sendKeys(Loc_Details_Networks1RowInput, AM_Details_AKANetwork, "Networks 1Row Input", AM_Details_NetworkField);
			Enter();

			//Shooting Format 
			selectDropdownValue(Loc_Details_ShootingFormatDropDown, "Shooting Format DropDown", AM_Details_Shootingformat1, AM_Details_ShootingFormat);
			//Delivery Format
			selectDropdownValue(Loc_Details_DeliveryFormatDropDown, "Delivery Format DropDown", AM_Details_Delivereyformat1, AM_Details_DeliveryFormat);
			//Relise Year
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year DropDown", AM_Details_ReliseYear2000, AM_Details_ReleaseYear);
			//Description
			sendKeys(Loc_Details_DescriptionTextBox, "AUT_Test", "Description Text Box", AM_Details_AssetDescription);
			//Language 
			selectDropdownValue(Loc_Details_LanguageDropDown, "Language DropDown", AM_Details_Languageval, AM_Details_PrimaryLanguage);

			//Mastro Audio
			selectDropdownValue(Loc_Details_MasterAudioDropDown, "Master Audio DropDown", AM_Details_MasterAudioval, AM_Details_MasterAudio);
			//Save 
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();


			assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle1);

			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(loc_OkButton);
			System.out.println("Values in Radio options dialog box are:");
			System.out.println("***************************");
			//TC_AM_GT_016
			verifyTextMatches(Loc_Details_Radio1, "Radio1", AM_Details_Radio1);
			verifyTextMatches(Loc_Details_Radio2, "Radio2", AM_Details_Radio2);
			verifyTextMatches(Loc_Details_Radio3, "Radio3", AM_Details_Radio3);
			System.out.println("********************");
			System.out.println("Details of Series and Episodes are displayed as below:");
			System.out.println("********************");
			verifyTextMatches(Loc_Details_Season1, "Season1", AM_Details_Season1);
			verifyTextMatches(Loc_Details_Ep1, "Ep1", AM_Details_Ep1);
			verifyTextMatches(Loc_Details_Ep2, "Ep2", AM_Details_Ep2);
			System.out.println("********************");		
			System.out.println("Buttons displayed are:");
			System.out.println("********************");
			verifyTextMatches(loc_SelectAll, "Select All", AM_Details_SelectAll,("value"));
			verifyTextMatches(OKButton, "Ok", AM_Details_Ok,("value"));
			verifyTextMatches(loc_CancelButton, "Cancel", AM_Details_Cancel,("value"));
			System.out.println("********************");
			clickUsingJSExecutor(LocCancel, "Cancel");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementToClickable("btnOK");
			clickUsingJSExecutor(Loc_Details_ApplyAll, "Apply All", "");
			Thread.sleep(2000);
			clickUsingJSExecutor(OKButton, "Ok Button");	
			driver.switchTo().window(driver.getWindowHandle());		
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			//verify in Episode - Details
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){ 
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			Thread.sleep(3000);
			clickOn(Loc_Episode101, "Episode101", "");
			doubleClick(Loc_Episode101, "Episode101", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(DetailsTab);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Episode102, "Episode102", "");
			doubleClick(Loc_Episode102, "Loc_Episode102", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			//Navigate to Details to change release year
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Details_Assect, "Details Asset", "");
			doubleClick(Loc_Details_Assect, "Details Asset", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			//Relies Year
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year DropDown", AM_Details_ReliseYear2018,  AM_Details_ReleaseYear);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementToClickable("btnOK");
			System.out.println("Values in Radio options dialog box are:");
			System.out.println("***************************");
			verifyTextMatches(Loc_Details_Radio1, "Radio1", AM_Details_Radio1);
			verifyTextMatches(Loc_Details_Radio2, "Radio2", AM_Details_Radio2);
			verifyTextMatches(Loc_Details_Radio3, "Radio3", AM_Details_Radio3);
			System.out.println("********************");
			System.out.println("Details of Series and Episodes are displayed as below:");
			System.out.println("********************");
			verifyTextMatches(Loc_Details_Season1, "Season1", AM_Details_Season1);
			verifyTextMatches(Loc_Details_Ep1, "Ep1", AM_Details_Ep1);
			verifyTextMatches(Loc_Details_Ep2, "Ep2", AM_Details_Ep2);
			System.out.println("********************");		
			System.out.println("Buttons displayed are:");
			System.out.println("********************");
			verifyTextMatches(loc_SelectAll, "Select All", AM_Details_SelectAll,("value"));
			verifyTextMatches(OKButton, "Ok", AM_Details_Ok,("value"));
			verifyTextMatches(loc_CancelButton, "Cancel", AM_Details_Cancel,("value"));
			System.out.println("********************");
			clickUsingJSExecutor("rboNoChange", "rboNoChange", "");
			Thread.sleep(2000);
			clickUsingJSExecutor(OKButton, "Ok Button");	
			Thread.sleep(3000);
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//verify in Episode - Details
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			Thread.sleep(3000);
			clickOn(Loc_Episode101, "Episode 101", "");
			doubleClick(Loc_Episode101, "Episode 101", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Episode102, "Episode 102", "");
			doubleClick(Loc_Episode102, "Episode 102", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			//Navigate to Details to change release year
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Details_Assect, "Loc_Details_Assect", "");
			doubleClick(Loc_Details_Assect, "Loc_Details_Assect", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year DropDown",AM_Details_ReliseYear2009, AM_Details_ReleaseYear);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(By.name("btnOK"));
			System.out.println("Values in Radio options dialog box are:");
			System.out.println("***************************");
			verifyTextMatches(Loc_Details_Radio1, "Radio1", AM_Details_Radio1);
			verifyTextMatches(Loc_Details_Radio2, "Radio2", AM_Details_Radio2);
			verifyTextMatches(Loc_Details_Radio3, "Radio3", AM_Details_Radio3);
			System.out.println("********************");
			System.out.println("Details of Series and Episodes are displayed as below:");
			System.out.println("********************");
			verifyTextMatches(Loc_Details_Season1, "Season1", AM_Details_Season1);
			verifyTextMatches(Loc_Details_Ep1, "Ep1", AM_Details_Ep1);
			verifyTextMatches(Loc_Details_Ep2, "Ep2", AM_Details_Ep2);
			System.out.println("********************");		
			System.out.println("Buttons displayed are:");
			System.out.println("********************");
			verifyTextMatches(loc_SelectAll, "Select All", AM_Details_SelectAll,("value"));
			verifyTextMatches(OKButton, "Ok", AM_Details_Ok,("value"));
			verifyTextMatches(loc_CancelButton, "Cancel", AM_Details_Cancel,("value"));
			System.out.println("********************");
			clickUsingJSExecutor(Loc_Details_AppleySelected, "Appley Selected");
			Thread.sleep(2000);
			clickUsingJSExecutor(OKButton, "Ok Button");	
			driver.switchTo().window(driver.getWindowHandle());
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Alert Button");
			switchIntoFrame(frameParent4Xpath);
			driver.findElement(By.xpath("//*[@id='uwtList']/ul/li/ul/li[2]/img[3]")).click();
			clickUsingJSExecutor(OKButton, "Ok Button");	
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			//verify in Episode - Details
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			Thread.sleep(3000);
			clickOn(Loc_Episode101, "Episode 101", "");
			doubleClick(Loc_Episode101, "Episode 101", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			verifyFirstSelectedDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2017, AM_Details_ReleaseYear);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Episode102, "Episode 102", "");
			Thread.sleep(1000);
			doubleClick(Loc_Episode102, "Episode 102", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			verifyFirstSelectedDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2009, AM_Details_ReleaseYear);
			//Navigate to Details to change release year
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Details_Assect, "Details Asset", "");
			doubleClick(Loc_Details_Assect, "Details Asset", "");
			driver.switchTo().window(driver.getWindowHandle());		
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			//TC_AM_GT_033
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year DropDown", AM_Details_ReliseYear2020, AM_Details_ReleaseYear);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(By.name("btnOK"));
			System.out.println("Values in Radio options dialog box are:");
			System.out.println("***************************");
			verifyTextMatches(Loc_Details_Radio1, "Radio1", AM_Details_Radio1);
			verifyTextMatches(Loc_Details_Radio2, "Radio2", AM_Details_Radio2);
			verifyTextMatches(Loc_Details_Radio3, "Radio3", AM_Details_Radio3);
			System.out.println("********************");
			System.out.println("Details of Series and Episodes are displayed as below:");
			System.out.println("********************");
			verifyTextMatches(Loc_Details_Season1, "Season1", AM_Details_Season1);
			verifyTextMatches(Loc_Details_Ep1, "Ep1", AM_Details_Ep1);
			verifyTextMatches(Loc_Details_Ep2, "Ep2", AM_Details_Ep2);
			System.out.println("********************");		
			System.out.println("Buttons displayed are:");
			System.out.println("********************");
			verifyTextMatches(loc_SelectAll, "Select All", AM_Details_SelectAll,("value"));
			verifyTextMatches(OKButton, "Ok", AM_Details_Ok,("value"));
			verifyTextMatches(loc_CancelButton, "Cancel", AM_Details_Cancel,("value"));
			System.out.println("********************");
			clickUsingJSExecutor(Loc_SelectAll, "Select All");
			Thread.sleep(3000);
			clickUsingJSExecutor(OKButton, "Ok Button");	
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			//verify in Episode - Details
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Episode101, "Episode 101", "");
			doubleClick(Loc_Episode101, "Episode 101", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			verifyFirstSelectedDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year", AM_Details_ReliseYear2020, AM_Details_ReleaseYear);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Episode102, "Episode 102", "");
			doubleClick(Loc_Episode102, "Episode 102", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			verifyFirstSelectedDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year",AM_Details_ReliseYear2020, AM_Details_ReleaseYear);
			//Navigate to Details to change release year
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(Loc_Navigator, "Navigator Button");
			if (ClientName.contains("TURNER")){
				switchIntoFrame(frameParent4Xpath);
			}
			else{
				switchIntoFrame(frameParent3Xpath);	
			}
			WaitForElementPresent(By.name(loc_OkButton));
			clickOn(Loc_Details_Assect, "Details Assect", "");
			doubleClick(Loc_Details_Assect, "Details Assect", "");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			clickOn(DetailsTab, "Details Tab");
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			//TC_AM_GT_042
			selectDropdownValue(Loc_Details_ReliseYearDropDown, "Relise Year DropDown", AM_Details_ReliseYear2021, AM_Details_ReleaseYear);
			clickUsingJSExecutor(DetailsTabSaveBtn, "DetailsTab Save ");
			WaitForModalPanel();
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(By.name("btnOK"));
			System.out.println("Values in Radio options dialog box are:");
			System.out.println("***************************");
			verifyTextMatches(Loc_Details_Radio1, "Radio1", AM_Details_Radio1);
			verifyTextMatches(Loc_Details_Radio2, "Radio2", AM_Details_Radio2);
			verifyTextMatches(Loc_Details_Radio3, "Radio3", AM_Details_Radio3);
			System.out.println("********************");
			System.out.println("Details of Series and Episodes are displayed as below:");
			System.out.println("********************");
			verifyTextMatches(Loc_Details_Season1, "Season1", AM_Details_Season1);
			verifyTextMatches(Loc_Details_Ep1, "Ep1", AM_Details_Ep1);
			verifyTextMatches(Loc_Details_Ep2, "Ep2", AM_Details_Ep2);
			System.out.println("********************");		
			System.out.println("Buttons displayed are:");
			System.out.println("********************");
			verifyTextMatches(loc_SelectAll, "Select All", AM_Details_SelectAll,("value"));
			verifyTextMatches(OKButton, "Ok", AM_Details_Ok,("value"));
			verifyTextMatches(loc_CancelButton, "Cancel", AM_Details_Cancel,("value"));
			System.out.println("********************");
			clickUsingJSExecutor(Loc_SelectAll, "Select All");
			Thread.sleep(2000);
			clickUsingJSExecutor(OKButton, "Ok Button");	
			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(DetailsTabSaveBtn);
			System.out.println("*************End Testcase - TC4_SeriesHandling**********");
	}


	public String getLocator_ViewTAB_DataRow(String rowNumber,String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_AM_Details_ColumnXpath_ViewMode, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_AM_Details_DataRowXpath_ViewMode + "[" + rowNumber +"]//td[contains(@class,'"+(classValue)+"')]";
		locator = loc_AM_Details_DataRowXpath_ViewMode + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}	
}

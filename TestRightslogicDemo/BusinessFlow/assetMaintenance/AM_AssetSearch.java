package assetMaintenance;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;

@Listeners(utility.ListenerClass.class)
public class AM_AssetSearch extends DriverHelper{
	Date date = new Date();
	SimpleDateFormat sdf 	= new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate 	= sdf.format(date);
	String PrefixAssetName 	= "AUT_AstSrisSrch_";
	
	String Asset_Series 	= PrefixAssetName +formattedDate+"";
	String Asset_PromoMarket= "AUT_AssetPromoMarket_" +formattedDate+"";
	String Asset_HomeVideo 	= "AUT_AssetHomeVideo_" +formattedDate+"";
	String Asset_Merch 		= "AUT_Asset_Merch_" +formattedDate+"";
	String Asset_Publish 	= "AUT_Asset_Publish_" +formattedDate+"";
	String Asset_Element 	= "AUT_Asset_Element_" +formattedDate+"";
	String Asset_Theatre 	= "AUT_Asset_Theatre_" +formattedDate+"";
	String Asset_Series1 	= PrefixAssetName + "1_" +formattedDate+"";
	String Asset_Series2 	= PrefixAssetName + "2_" +formattedDate+"";
	
	// Variables for TC15
	String RSGPS 			= formattedDate + "RSGPS";
	String AKA 				=  formattedDate+ "AKA";
	String Action_Series 	=  formattedDate+ "Action_Series";
	String FKA 				=  formattedDate+ "FKA";
	String DelhiAction 		=  formattedDate+ "DelhiAction";
	String For_A_month 		=  formattedDate+ "For A month";
	String EAKA 			=  formattedDate+ "EAKA";
	String Legal 			=  formattedDate+ "Legal";
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	
	// Locators of Contributor TAB for TC2
	public AM_AssetSearch() {
		super(loc_Conrtibutors_Header,Conrtibutors_DataRow ,
				loc_Conrtibutors_Header, Conrtibutors_DataRow);
		
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}
	
	
	
	
	@Test
	public void createPrerequisites() throws Exception {
		ExecutionLog.Log("	Assets are:");
		ExecutionLog.Log(Asset_Series);
		ExecutionLog.Log(Asset_PromoMarket);
		ExecutionLog.Log(Asset_HomeVideo);
		ExecutionLog.Log(Asset_Merch);
		ExecutionLog.Log(Asset_Publish);
		ExecutionLog.Log(Asset_Element);
		ExecutionLog.Log(Asset_Theatre);
		ExecutionLog.Log(Asset_Series1);
		ExecutionLog.Log(Asset_Series2);
		ExecutionLog.Log("");
		assetMaintenance.createProgramAsset(Asset_Series, Series_AssetType);
		// Add 4 episodes 2 for Season 1 and 2 for season2
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(Asset_Series);	
		assetMaintenance.createPromoMarketingAsset(Asset_PromoMarket,AssetType_PromoAndMarketing_Promos, AssetType_PromoAndMarketing);
		assetMaintenance.createHomeVideoAsset(Asset_HomeVideo, AssetType_HomeVideo_DVD, AssetType_HomeVideo);
		assetMaintenance.createMerchandiseAsset(Asset_Merch, AssetType_Merchandise_Apparel, AssetType_Merchandise);
		assetMaintenance.createPublishingAsset(Asset_Publish, AssetType_Publishing_Printed, AssetType_Publishing);
		assetMaintenance.createElementAsset(Asset_Element, AssetType_Element_Music, AssetType_Element);
		assetMaintenance.createTheatricalAsset(Asset_Theatre, AssetType_Theatrical_FeatureLength, AssetType_Theatrical);
		assetMaintenance.createProgramAsset(Asset_Series1, Series_AssetType);
		assetMaintenance.createProgramAsset(Asset_Series2, Series_AssetType);
	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 */
	@Test(priority =1,enabled= true,description = "Field Validation")
	public void TC1_AssetSearchFields() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		//TC_AM_AS_001
		clickUsingJSExecutor(SearchXpath, "Search Menu Icon");

		verifyTextMatches(AM_Asset1_Under_SearchMenu, "Asset1_Under_SearchMenu", AssetSearch_Asset1, "innerHTML");
		verifyTextMatches(AM_Asset2_Under_SearchMenu, "Asset2_Under_SearchMenu", AssetSearch_Asset2, "innerHTML");
		verifyTextMatches(AM_Asset3_Under_SearchMenu, "Asset3_Under_SearchMenu", AssetSearch_Asset3, "innerHTML");
		verifyTextMatches(AM_Asset4_Under_SearchMenu, "Asset4_Under_SearchMenu", AssetSearch_Asset4, "innerHTML");
		//TC_AM_AS_002
		clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_AssetSearchWindowName, "AssetSearchWindowName", AssetSearch_HeaderName);
		verifyElementPresent(loc_ExpandAdvancedSearchIcon, "ShowMoreIcon");

		// Verify Labels of Search Fields
		verifyTextMatches(loc_AssetTitleLabel, "AssetTitleLabel", AssetSearch_AssetTitle);
		verifyTextMatches(loc_AssetIDLabel, "AssetSearch_AssetID", AssetSearch_AssetID);
		verifyTextMatches(loc_AssetTypeLabel, "AssetSearch_AssetType", AssetSearch_AssetType);
		verifyTextMatches(loc_Asset_RightsVersionTypeLabel, "AssetSearch_AssetRightsVersionType", AssetSearch_AssetRightsVersionType);
		verifyTextMatches(loc_Asset_SourceBusUnitLabel, "AssetSearch_SBU", AssetSearch_SBU);
		verifyTextMatches(loc_Asset_GenreLabel, "AssetSearch_Genre", AssetSearch_Genre);
		verifyTextMatches(loc_ShortName, "AssetSearch_ShortName", AssetSearch_ShortName);
		verifyTextMatches(loc_IPName, "AssetSearch_IPName", AssetSearch_IPName);
		verifyTextMatches(loc_AssetCategory, "AssetSearch_AssetCategrory", AssetSearch_AssetCategory);
		verifyTextMatches(loc_Asset_SourceLabel, "AssetSearch_AssetSource", AssetSearch_AssetSource);
		verifyTextMatches(loc_AssetStatusLabel, "AssetSearch_AssetStatus", AssetSearch_AssetStatus);
		verifyTextMatches(loc_Asset_ArtistLabel, "AssetSearch_Artist", AssetSearch_Artist);
		verifyTextMatches(loc_Asset_ComposerLabel, "AssetSearch_Composer", AssetSearch_Composer);
		verifyTextMatches(loc_Asset_DataEntryStatusLabel, "AssetSearch_PRODEntry", AssetSearch_PRODEntry);
		verifyTextMatches(loc_Asset_MMLDataEntryStatusLabel, "AssetSearch_MMLEntry", AssetSearch_MMLEntry);
		verifyTextMatches(loc_ExpandAdvancedSearchIcon, "AssetSearch_ExpandToggleImagebtn", AssetSearch_ExpandToggleImagebtn_ShowMore, "title");
		
		verifyTextMatches(loc_AstGrp, "AssetSearch_AssetCategory2", AssetSearch_AssetCategory2);
		verifyTextMatches(loc_Venue, "AssetSearch_Venue", AssetSearch_Venue);
		verifyTextMatches(loc_Teams, "AssetSearch_Teams", AssetSearch_Teams);
		verifyTextMatches(loc_MatchCategory, "AssetSearch_MatchCategory", AssetSearch_MatchCategory);
		verifyTextMatches(loc_RoundOfSeries, "AssetSearch_RoundOfSeries", AssetSearch_RoundOfSeries);
		//TC_AM_AS_007
		// Verify Labels of Advanced Search Fields
		clickOn(loc_ExpandAdvancedSearchIcon,"Show More Icon");
		sleepTime(3);
		verifyTextMatches(loc_Asset_AttributesLabel, "AssetSearch_Attribute", AssetSearch_Attribute);
		verifyTextMatches(loc_Asset_ContributorLabel, "AssetSearch_Contributor", AssetSearch_AdvanceSearch_Contributor);
		verifyTextMatches(loc_Asset_ContributorRoleLabel, "AssetSearch_ContributorRole", AssetSearch_ContributorRole);
		verifyTextMatches(loc_Asset_CharacterLabel, "AssetSearch_Charachter", AssetSearch_Charachter);
		verifyTextMatches(loc_Asset_AirNetBusUnitLabel, "AssetSearch_PremierNetwork", AssetSearch_PremierNetwork);
		verifyTextMatches(loc_Asset_PremiereDatesLabel, "AssetSearch_PremierAirDate", AssetSearch_PremierAirDate);
		verifyTextMatches(loc_Asset_DurationFromLabel, "AssetSearch_LengthFm", AssetSearch_LengthFm);
		verifyTextMatches(loc_Asset_GuildAssociationLabel, "AssetSearch_GuildAssociation", AssetSearch_GuildAssociation);
		verifyTextMatches(loc_AssetFormat, "AssetSearch_PropertyFormat", AssetSearch_PropertyFormat);
		verifyTextMatches(loc_VendorLabel, "AssetSearch_Vendor", AssetSearch_Vendor);
		verifyTextMatches(loc_StudioLabel, "AssetSearch_Vendor2", AssetSearch_Vendor2);
		verifyTextMatches(loc_Asset_KeywordLabel, "AssetSearch_Keyword", AssetSearch_Keyword);
		verifyTextMatches(loc_ClientGroup, "AssetSearch_ClientGroup", AssetSearch_ClientGroup);
		verifyTextMatches(loc_Asset_MMLClearanceLevelLabel, "AssetSearch_MMLClearance", AssetSearch_MMLClearance);
		verifyTextMatches(loc_Asset_InternationalAmortizationLabel, "AssetSearch_InternationalAvailabitlity", AssetSearch_InternationalAvailabitlity);

		verifyTextMatches(loc_CreationDate, "AssetSearch_CreationDate_Search",  AssetSearch_CreationDate_Search);
		verifyTextMatches(loc_LangOfOrigin, "AssetSearch_LanguageofOrigin", 	AssetSearch_LanguageofOrigin);
		verifyTextMatches(loc_Length, 		"AssetSearch_Length", 				AssetSearch_Length);
		verifyTextMatches(loc_MpaaRat, 		"AssetSearch_MPAARating", 			AssetSearch_MPAARating);
		verifyTextMatches(loc_TVRating, 	"AssetSearch_TVParentalRating", 	AssetSearch_TVParentalRating);
		verifyTextMatches(loc_CountryOrigin,"AssetSearch_CountryofOrigin", 		AssetSearch_CountryofOrigin);
	
		
		
		
		
		// Below Steps were not present in the Manual Test Cases
		// Verify All Available Check Boxes on Asset Search Window
		verifyTextMatches(loc_AssetSearch_AKA, "AssetSearch_AKA", AssetSearch_AKA);
		verifyTextMatches(loc_Asset_DispSeasonsCheckBoxLabel, "AssetSearch_Seasons", AssetSearch_Seasons);
		verifyTextMatches(loc_Asset_DispEpisodesCheckBoxLabel, "AssetSearch_Episodes", AssetSearch_Episodes);
		verifyTextMatches(loc_Asset_SelectAllCheckBoxLabel, "AssetSearch_SelectAll", AssetSearch_SelectAll);
		verifyTextMatches(loc_Asset_SearchEarliestPremiereCheckBoxLabel, "AssetSearch_SearchEarliest", AssetSearch_SearchEarliest);
		verifyTextMatches(loc_Asset_IncludeDeletedCheckBoxLabel, "AssetSearch_IncludeDelete", AssetSearch_IncludeDelete);
		verifyTextMatches(loc_Asset_CheckRelatedAssetLabel, "AssetSearch_RelatedAsset", AssetSearch_RelatedAsset);
		verifyTextMatches(loc_Asset_ExactMatchCheckBoxLabel, "AssetSearch_ExactMatch", AssetSearch_ExactMatch);
		//TC_AM_AS_008
		verifyTextMatches(loc_ExpandAdvancedSearchIcon, "AssetSearch_ExpandToggleImagebtn", AssetSearch_ExpandToggleImagebtn_ShowLess, "title");
		//clickOn(loc_ExpandAdvancedSearchIcon,"Show Less Icon");
		Thread.sleep(3000);
		verifyTextMatches(loc_Asset_InternationalAmortizationLabel, "AssetSearch_InternationalAvailabitlity", AssetSearch_InternationalAvailabitlity);


	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description verify all the headers of Search Grid. Rename the Asset and again verify the Search Grid. Verify the Seasons in Search Grid
	 */
	@Test(priority =2,enabled= true,description = "Search -Programs with Episode Details")
	public void TC2_AssetSearchWithEpisodesDetails() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
		//TC_AM_AS_010
		clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));
		
		//TC_AM_AS_011
		verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		verifyFieldValueOfHeader(loc_Asset_DispEpisodesCheckBox_CheckBox, "true", "Asset_DispEpisodesCheckBox_CheckBox", AssetSearch_Episodes, "checked");

		sendKeys(loc_AssetTitle, Asset_Series, "AssetTitle", AssetTitle_Status);
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			Thread.sleep(3000);
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));

		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			ExecutionLog.Log("=====BUG ID======: 20309");
		} else {
			//TC_AM_AS_017
			Thread.sleep(3000);
			clickUsingJSExecutor(loc_ExpandAssetDetail_At_AssetSearchGrid,"ExpandSeasonIcon");
			Thread.sleep(3000);
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season1), Season1, Season1 + " at Asset Search Grid", Season1, "title");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season2), Season2, Season2 + " at Asset Search Grid", Season2, "title");
			
		}

		//TC_AM_AS_016
		//Verify that the Search Results are in accordance with entered Asset Title
		ExecutionLog.Log("*****Verify that the Search Results are in accordance with entered Asset Title*****");
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetTitle_SearchGrid), AssetSearch_AssetTitle_SearchGrid, "AssetSearch_AssetTitle", AssetSearch_AssetTitle_SearchGrid);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGrid_AssetID), AssetSearch_SearchGrid_AssetID, "AssetSearch_AssetID", AssetSearch_SearchGrid_AssetID);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetType_SearchGrid), AssetSearch_AssetType_SearchGrid, "AssetSearch_AssetType", AssetSearch_AssetType);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGrid_SBU), AssetSearch_SearchGrid_SBU, "AssetSearch_SBU", AssetSearch_SearchGrid_SBU);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ShortName), AssetSearch_ShortName, "AssetSearch_ShortName", AssetSearch_ShortName);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetStatus), AssetSearch_AssetStatus, "AssetSearch_AssetStatus", AssetSearch_AssetStatus);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetSource), AssetSearch_AssetSource);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetSource), AssetSearch_AssetSource, "AssetSearch_AssetSource", AssetSearch_AssetSource);

		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Publisher), AssetSearch_Publisher);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Publisher), AssetSearch_Publisher, "AssetSearch_Publisher", AssetSearch_Publisher);

		if(ClientData.equals("VMN")) {
			scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var",  "All "+AssetSearch_SearchGrid_Contributor));

			// "All Contact" is displayed instead of "Contact"
			verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var",  "All "+AssetSearch_SearchGrid_Contributor), "All "+AssetSearch_SearchGrid_Contributor, "AssetSearch_Contributor", AssetSearch_SearchGrid_Contributor);
		} else {
			scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var",AssetSearch_SearchGrid_Contributor),AssetSearch_SearchGrid_Contributor);
			verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var",AssetSearch_SearchGrid_Contributor), AssetSearch_SearchGrid_Contributor, "AssetSearch_Contributor", AssetSearch_SearchGrid_Contributor);
		}
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var",AssetSearch_Vendor),AssetSearch_SearchGridHeaderVendor);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Vendor), AssetSearch_Vendor, "AssetSearch_Vendor", AssetSearch_SearchGridHeaderVendor);

		// Specific to VMN
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetRightsVersionType),AssetSearch_AssetRightsVersionType);

		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetRightsVersionType), AssetSearch_AssetRightsVersionType, "AssetSearch_AssetRightsVersionType", AssetSearch_AssetRightsVersionType);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ProdEntry), "Prod Entry Status", "AssetSearch_ProdEntry", AssetSearch_ProdEntry);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_MMLEntry), AssetSearch_MMLEntry, "AssetSearch_MMLEntry", AssetSearch_MMLEntry);

		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Composer),AssetSearch_Composer);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Composer), AssetSearch_Composer, "AssetSearch_Composer", AssetSearch_Composer);

		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGridHeader_Artist),AssetSearch_SearchGridHeader_Artist);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGridHeader_Artist), AssetSearch_SearchGridHeader_Artist, "AssetSearch_SearchGridHeader_Artist", AssetSearch_SearchGridHeader_Artist);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Artist),AssetSearch_Artist);

		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Artist), AssetSearch_Artist, "AssetSearch_Artist", AssetSearch_Artist);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_MMLContact), AssetSearch_MMLContact, "AssetSearch_MMLContact", AssetSearch_MMLContact);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_PRODBALAContact), AssetSearch_PRODBALAContact, "AssetSearch_PRODBALAContact", AssetSearch_PRODBALAContact);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_CreationDate), AssetSearch_CreationDate);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_CreationDate), AssetSearch_CreationDate, "AssetSearch_CreationDate", AssetSearch_CreationDate);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_InternationalAvailabitlity), AssetSearch_InternationalAvailabitlity, "AssetSearch_InternationalAvailabitlity", AssetSearch_InternationalAvailabitlity);


		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Vendor2), AssetSearch_Vendor2, "AssetSearch_Vendor2", AssetSearch_Vendor2);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_IPName), AssetSearch_IPName, "AssetSearch_IPName", AssetSearch_IPName);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ProjectID), AssetSearch_ProjectID);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ProjectID), AssetSearch_ProjectID, "AssetSearch_Project ID", AssetSearch_ProjectID);
		//may be a bug for AMCN as Header name is Guild Association instead of  "Union/Guild Association"
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ClientGroup), AssetSearch_ClientGroup, "AssetSearch_ClientGroup", AssetSearch_ClientGroup);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_PropertyFormat), AssetSearch_PropertyFormat, "AssetSearch_PropertyFormat", AssetSearch_PropertyFormat);


		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetType_GuildAssociation), AssetSearch_AssetType_GuildAssociation);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetType_GuildAssociation), AssetSearch_AssetType_GuildAssociation, "AssetSearch_GuildAssociation", AssetSearch_AssetType_GuildAssociation);
		
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGrid_NumberOfEpisodees), AssetSearch_SearchGrid_NumberOfEpisodees, "AssetSearch_Number of Episodes", AssetSearch_SearchGrid_NumberOfEpisodees);
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_DurationORLength), AssetSearch_DurationORLength);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_DurationORLength), AssetSearch_DurationORLength, AssetSearch_DurationORLength, AssetSearch_DurationORLength);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_DurationORLength_Minute), AssetSearch_DurationORLength_Minute, "Length (minutes)", AssetSearch_DurationORLength_Minute);
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ReleaseYear), AssetSearch_ReleaseYear);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ReleaseYear), AssetSearch_ReleaseYear, "Release/Production Year", AssetSearch_ReleaseYear);

		//////////////////////SalesDemo
		// VMN: Asset Category = Initial Platform 
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetCategory2), AssetSearch_AssetCategory2);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetCategory2), AssetSearch_AssetCategory2, "AssetSearch_AssetCategory2", AssetSearch_AssetCategory2);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Teams), AssetSearch_Teams);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Teams), AssetSearch_Teams, "AssetSearch_Teams", AssetSearch_Teams);
	
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ADES), AssetSearch_ADES);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ADES), AssetSearch_ADES, "AssetSearch_ADES", AssetSearch_ADES);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_EDES), AssetSearch_EDES);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_EDES), AssetSearch_EDES, "AssetSearch_EDES", AssetSearch_EDES);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Studio), AssetSearch_Studio);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Studio), AssetSearch_Studio, "AssetSearch_Studio", AssetSearch_Studio);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGridHeeader_ClientGroup), AssetSearch_SearchGridHeeader_ClientGroup);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGridHeeader_ClientGroup), AssetSearch_SearchGridHeeader_ClientGroup, "AssetSearch_SearchGridHeeader_ClientGroup", AssetSearch_SearchGridHeeader_ClientGroup);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetClearance), AssetSearch_AssetClearance);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_AssetClearance), AssetSearch_AssetClearance, "AssetSearch_AssetClearance", AssetSearch_AssetClearance);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ProductContact), AssetSearch_ProductContact);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ProductContact), AssetSearch_ProductContact, "AssetSearch_ProductContact", AssetSearch_ProductContact);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Episodes2), AssetSearch_Episodes2);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Episodes2), AssetSearch_Episodes2, "AssetSearch_Episodes2", AssetSearch_Episodes2);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Length2), AssetSearch_Length2);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_Length2), AssetSearch_Length2, "AssetSearch_Length2", AssetSearch_Length2);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_ReleaseYear), AssetSearch_ReleaseYear);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_SearchGridHeader_Venue), AssetSearch_SearchGridHeader_Venue, "AssetSearch_SearchGridHeeader_Venue", AssetSearch_SearchGridHeader_Venue);
		
		scrollElementIntoView(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_VersionType), AssetSearch_VersionType);
		verifyFieldValueOfHeader(loc_AssetSearch_ColumnName.replace("@var", AssetSearch_VersionType), AssetSearch_VersionType, "AssetSearch_VersionType", AssetSearch_VersionType);
		////////////////////
		
		
		
		moveMouse(loc_SearchedAsset, "First Asset in the Searched Asset");
		clickOn(loc_SearchedAsset, "First Asset in the Searched Asset");
		clickOn(loc_SearchedAsset, "First Asset in the Searched Asset");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_ViewAsset, "View Asset");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(6000);
		//TC_AM_AS_019
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series);
		sendKeys(loc_AssetTitleField, Asset_Series + "_Ed", "AssetTitle", AssetTitle_Status);
		keyboard();
		sleepTime(10);
		if(ClientData.contains("SKY")) {
			acceptAlert();
		}
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series + "_Ed" , Asset_Series + "_Ed");
		// Verify that the name of the asset gets changed
		assetMaintenance.selectAsset(Asset_Series + "_Ed");

		//TC_AM_AS_027
		sendKeys(loc_AssetTitleField, Asset_Series , "AssetTitle", AssetTitle_Status);
		sleepTime(5);
		if(ClientData.contains("SKY")) {
			acceptAlert();
		}
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(3000);
		// Verify that the name of the asset gets changed to original one
		assetMaintenance.selectAsset(Asset_Series);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series , Asset_Series);


	}
	
	/**
	 * @author Rajuddin
	 * @description 
	 * Create a contributor
	 * Provide a Role to the Asset
	 * @throws Exception
	 */
	@Test(priority =3,enabled= true,description = "Advanced Search -Programs with Episode Details")
	public void TC3_AdvancedAssetSearchWithEpisodeDetails() throws Exception {
		createContributor_AssignRole(Asset_Series, AssetSearch_DefaultAssetType, Contributor_Role);
		if (!(ClientName.contains("TURNER") || ClientName.contains("ASTRO"))){
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			//TC_AM_AS_010
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
			switchIntoFrame(frameParent2Xpath);
			//TC_AM_AS_031
			clickOn(loc_ExpandAdvancedSearchIcon,"ExpandAdvanceSearchIcon");

			//TC_AM_AS_032
			verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
			verifyFieldValueOfHeader(loc_Asset_DispEpisodesCheckBox_CheckBox, "true", "Asset_DispEpisodesCheckBox_CheckBox", AssetSearch_Episodes, "checked");

			sendKeys(loc_AssetTitle, Asset_Series, "AssetTitle", AssetTitle_Status);
			selectDropdownValue(loc_AssetSearch_ContactRole_inputField, "AssetSearch_ContactRole_inputField", Contributor_Role, AssetSearch_ContributorRole);

			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(ByLocator(loc_SearchedAsset));
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series), "Searched Asset at Search Grid", Asset_Series);

			clickUsingJSExecutor(loc_ExpandAssetDetail_At_AssetSearchGrid,"Expand Asset Detail At Asset Search Grid");
			Thread.sleep(3000);
			//TC_AM_AS_038
			clickUsingJSExecutor(loc_ExpandSeason_At_AssetSearchGrid.replace("@var", Season1),"Expand Season1 at Asset Search Grid");
			// Below splitting is used to get "Episode101" from "Ep.101: Episode101"
			String Season1_Episode1[] =S1_Episode101.split(" ");
			String Season1_Episode2[] =S1_Episode102.split(" ");		
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season1_Episode1[1]), Season1_Episode1[1], Season1_Episode1[1] + " at Asset Search Grid", S1_Episode101, "title");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season1_Episode2[1]), Season1_Episode2[1], Season1_Episode2[1] + " at Asset Search Grid", S1_Episode102, "title");

			clickUsingJSExecutor(loc_ExpandSeason_At_AssetSearchGrid.replace("@var", Season2),"Expand Season2 at Asset Search Grid");
			String Season2_Episode1[] =S2_Episode201.split(" ");
			String Season2_Episode2[] =S2_Episode202.split(" ");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season2_Episode1[1]), Season2_Episode1[1], Season2_Episode1[1] + " at Asset Search Grid", S2_Episode201, "title");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season2_Episode2[1]), Season2_Episode2[1], Season2_Episode2[1] + " at Asset Search Grid", S2_Episode202, "title");

		} else {
			throw new SkipException("=====BUG ID======: 20309");
		}

	}

	/**
	 * @author Rajuddin
	 * @description 
	 * Uncheck the Episode Check box and Search the Asset 
	 * @throws Exception
	 */
	@Test(priority =4,enabled= true,description = "Search -Programs without episode details")
	public void TC4_AssetSearchWithoutEpisodeDetails() throws Exception {
		// Delete these lines once 20309 is fixed
		if (!(ClientName.contains("TURNER") || ClientName.contains("ASTRO"))){

			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(loc_AssetTitle);
			switchIntoFrame(frameParent2Xpath);
			
			//TC_AM_AS_042
			//verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
			verifyFieldValueOfHeader(loc_Asset_DispEpisodesCheckBox_CheckBox, "true", "Asset_DispEpisodesCheckBox_CheckBox", AssetSearch_Episodes, "checked");
			clickUsingJSExecutor(loc_Asset_DispEpisodesCheckBox_CheckBox,"Click on Episodes Check Box");
			// did not find any attribute to check that Episode Check box is unchecked
			//verifyFieldValueOfHeader(loc_Asset_DispEpisodesCheckBox_CheckBox, "false", "Asset_DispEpisodesCheckBox_CheckBox", AssetSearch_Episodes, "value");

			sendKeys(loc_AssetTitle, Asset_Series, "AssetTitle", AssetTitle_Status);
			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(ByLocator(loc_SearchedAsset));

			ExecutionLog.Log("********Verify that on Seasons are displayed but Episodes are not displayed in Asset Search Grid*********");
			clickOn(loc_ExpandAssetDetail_At_AssetSearchGrid,"Expand Season Icon");
			Thread.sleep(3000);
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season1), Season1, Season1 + " at Asset Search Grid", Season1, "title");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season2), Season2, Season2 + " at Asset Search Grid", Season2, "title");

			//TC_AM_AS_048
			verifyElementNotDisplayed(loc_ExpandSeason_At_AssetSearchGrid.replace("@var", Season1),"Expand Icon of " +Season1, "");
		
		} else {
			throw new SkipException("=====BUG ID======: 20309");
		}

}

	@Test(priority =5,enabled= true,description = "Advanced Search -Programs without Episode Details")
	public void TC5_AdvancedAssetSearchWithoutEpisodesDetails() throws Exception {
		if(!(ClientName.contains("TURNER") || ClientName.contains("ASTRO"))) {
			// The steps to Assign Contributor Role is covered in Test Method  TC3_AdvancedAssetSearchWithEpisodeDetails
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
			switchIntoFrame(frameParent2Xpath);

			//TC_AM_AS_031
			clickOn(loc_ExpandAdvancedSearchIcon,"ExpandAdvanceSearchIcon");

			verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
			verifyFieldValueOfHeader(loc_Asset_DispEpisodesCheckBox_CheckBox, "true", "Asset_DispEpisodesCheckBox_CheckBox", AssetSearch_Episodes, "checked");
			//TC_AM_AS_053
			clickOn(loc_Asset_DispEpisodesCheckBox_CheckBox,"Click on Episodes Check Box");

			sendKeys(loc_AssetTitle, Asset_Series, "AssetTitle", AssetTitle_Status);
			//TC_AM_AS_054
			selectDropdownValue(loc_AssetSearch_ContactRole_inputField, "AssetSearch_ContactRole_inputField", Contributor_Role, AssetSearch_ContributorRole);

			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(loc_SearchedAsset);
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series), "Searched Asset at Search Grid", Asset_Series);
			ExecutionLog.Log("********Verify that on Seasons are displayed but Episodes are not displayed in Asset Search Grid******");
			clickOn(loc_ExpandAssetDetail_At_AssetSearchGrid,"Expand Season Icon");
			Thread.sleep(3000);
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season1), Season1, Season1 + " at Asset Search Grid", Season1, "title");
			verifyFieldValueOfHeader(loc_Season_AssetSearchGrid.replace("@var", Season2), Season2, Season2 + " at Asset Search Grid", Season2, "title");

			//TC_AM_AS_057
			verifyElementNotDisplayed(loc_ExpandSeason_At_AssetSearchGrid.replace("@var", Season1),"Episode" , "");

		} else {
			throw new SkipException("=====BUG ID======: 20309");
		}

	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =6,enabled= true,description = "Search -Promo & Marketing")
	public void TC6_AssetAdvancedSearchPromoMarketing() throws Exception {
		if(!AssetType_PromoAndMarketing.contains("N/A")) {
			ExecutionLog.Log("********Create the Contributor and Assign Actor Role********");
			createContributor_AssignRole(Asset_PromoMarket, AssetType_PromoAndMarketing, Contributor_Role);
			ExecutionLog.Log("****************");
			
			//TC_AM_AS_059
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_059");
			assetSearch_WithoutWpisodes(Asset_PromoMarket, AssetType_PromoAndMarketing);
			//TC_AM_AS_066
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_066");
			assetSearch_EditAssetName(Asset_PromoMarket, AssetType_PromoAndMarketing);
			//TC_AM_AS_077
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_077");
			advancedAssetSearch_ContactRole(Asset_PromoMarket, AssetType_PromoAndMarketing, Contributor_Role);
		} else {
			throw new SkipException("AssetType_PromoAndMarketing is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =7,enabled= true,description = "Search -Home Video")
	public void TC7_AssetAdvancedSearchHomeVideo() throws Exception {
		if(!AssetType_HomeVideo.contains("N/A")) {
			ExecutionLog.Log("********Create the Contributor and Assign Composer Role********");
			createContributor_AssignRole(Asset_HomeVideo, AssetType_HomeVideo,Contributor_Role);
			ExecutionLog.Log("****************");
			
			//TC_AM_AS_059
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_086");
			assetSearch_WithoutWpisodes(Asset_HomeVideo, AssetType_HomeVideo);
			
			//TC_AM_AS_093
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_093");
			assetSearch_EditAssetName(Asset_HomeVideo, AssetType_HomeVideo);
			
			//TC_AM_AS_104
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_104");
			advancedAssetSearch_ContactRole(Asset_HomeVideo, AssetType_HomeVideo, Contributor_Role);
		}  else {
			throw new SkipException("HomeVideo is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =8,enabled= true,description = "Search -Merchandise")
	public void TC8_AssetAdvancedSearchMerchandise() throws Exception {
		if(!AssetType_Merchandise.contains("N/A")) {
			ExecutionLog.Log("********Create the Contributor and Assign \"Actor\" Role********");
			createContributor_AssignRole(Asset_Merch, AssetType_Merchandise,Contributor_Role);
			ExecutionLog.Log("****************");
			
			//TC_AM_AS_113
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_113");
			assetSearch_WithoutWpisodes(Asset_Merch, AssetType_Merchandise);
			
			//TC_AM_AS_120
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_120");
			assetSearch_EditAssetName(Asset_Merch, AssetType_Merchandise);
			
			//TC_AM_AS_131
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_131");
			advancedAssetSearch_ContactRole(Asset_Merch, AssetType_Merchandise, Contributor_Role);
		} else {
			throw new SkipException("AssetType_Merchandise is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =9,enabled= true,description = "Search -Publishing")
	public void TC9_AssetAdvancedSearchPublishing() throws Exception {
		if(!AssetType_Publishing.contains("N/A")) {
			ExecutionLog.Log("********Create the Contributor and Assign \"Actor\" Role********");
			createContributor_AssignRole(Asset_Publish, AssetType_Publishing,Contributor_Role);
			ExecutionLog.Log("****************");
			
			//TC_AM_AS_140
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_140");
			assetSearch_WithoutWpisodes(Asset_Publish, AssetType_Publishing);
			
			//TC_AM_AS_147
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_147");
			assetSearch_EditAssetName(Asset_Publish, AssetType_Publishing);
			
			//TC_AM_AS_158
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_158");
			advancedAssetSearch_ContactRole(Asset_Publish, AssetType_Publishing, Contributor_Role);
		} else {
			throw new SkipException("AssetType_Publishing is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =10,enabled= true,description = "Search -Elements")
	public void TC10_AssetAdvancedSearchElement() throws Exception {
		if(!AssetType_Element.contains("N/A")) {
			//SalesDemo : Element Asset >> Contributor Ntwork dorp down is not present 
			if(!ClientData.contains("SALESDEMO")) {
				ExecutionLog.Log("********Create the Contributor and Assign \"Actor\" Role********");
				createContributor_AssignRole(Asset_Element, AssetType_Element,Contributor_Role);
				ExecutionLog.Log("****************");
			}
			
			
			//TC_AM_AS_167
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_167");
			assetSearch_WithoutWpisodes(Asset_Element, AssetType_Element);
			
			//TC_AM_AS_174
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_174");
			assetSearch_EditAssetName(Asset_Element, AssetType_Element);
			
			//TC_AM_AS_185
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_185");
			advancedAssetSearch_ContactRole(Asset_Element, AssetType_Element, Contributor_Role);
		}
		else {
			throw new SkipException("AssetType_Element is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =11,enabled= true,description = "Search -Theatrical")
	public void TC11_AssetAdvancedSearchTheatre() throws Exception {
		if(!AssetType_Theatrical.contains("N/A")) {
			ExecutionLog.Log("********Create the Contributor and Assign \"Actor\" Role********");
			createContributor_AssignRole(Asset_Theatre, AssetType_Theatrical,Contributor_Role);
			ExecutionLog.Log("****************");
			
			//TC_AM_AS_194
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_194");
			assetSearch_WithoutWpisodes(Asset_Theatre, AssetType_Theatrical);
			
			//TC_AM_AS_201
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_201");
			assetSearch_EditAssetName(Asset_Theatre, AssetType_Theatrical);
			
			//TC_AM_AS_212
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_212");
			advancedAssetSearch_ContactRole(Asset_Theatre, AssetType_Theatrical, Contributor_Role);
		} else {
			throw new SkipException("AssetType_Theatrical is Not Applicable for " + ClientData);
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =12,enabled= true,description = "Update Multiple Assets and Validate the search results AND Validate Pagination")
	public void TC12_MultipleAssetSearch() throws Exception {
		if(!(ClientData.equals("VMN") || ClientData.equals("TURNER") || ClientData.equals("ASTRO"))) {
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			//TC_AM_AS_010
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
			switchIntoFrame(frameParent2Xpath);

			//TC_AM_AS_226
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_226");
			sendKeys(loc_AssetTitle, PrefixAssetName, "AssetTitle " + AssetType, AssetTitle_Status);
			switchIntoFrame(frameParent2Xpath);
			// Delete these lines once 20309 is fixed
			if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
				/// Handling BUG ID: 20309
				ExecutionLog.Log("=====BUG ID======: 20309");
				clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
			}
			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(loc_SearchedAsset);
			verifyElementPresent(loc_SearchedAssetDetails.replace("@var", Asset_Series), Asset_Series, "");
			verifyElementPresent(loc_SearchedAssetDetails.replace("@var", Asset_Series1), Asset_Series1, "");
			verifyElementPresent(loc_SearchedAssetDetails.replace("@var", Asset_Series2), Asset_Series2, "");

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series), Asset_Series);
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series1), Asset_Series1);
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series2), Asset_Series2);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Validation Pagination
			// TC_AM_AS_243
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_243");
			sendKeys(loc_AssetTitle, PrefixAssetName, "AssetTitle " + AssetType, AssetTitle_Status);
			verifyElementPresent(loc_TotalRecords, "Verify Total Records is shown");
			clickOn(loc_PaginationDropDown,"PaginationDropDown");
			verifyElementPresent(loc_TotalRecords, "Verify Total Records is shown");
			verifyElementPresent(loc_PageDropDownValue, "Verify page Drop Down values");

			Thread.sleep(3000);
			clickUsingJSExecutor(loc_ViewAsset, "View Asset");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series);
			sendKeys(loc_AssetTitleField, Asset_Series + "_Up", "AssetTitle", AssetTitle_Status);
			
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			//TC_AM_AS_227
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series + "_Up" , Asset_Series + "_Up");

			clickUsingJSExecutor(loc_Next_GeneralTab, "Next_GeneralTab");
			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series1);
			sendKeys(loc_AssetTitleField, Asset_Series1 + "_Up", "AssetTitle", AssetTitle_Status);
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series1 + "_Up" , Asset_Series1 + "_Up");

			//TC_AM_AS_231
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_231");
			clickUsingJSExecutor(loc_Next_GeneralTab, "Next_GeneralTab");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series2);
			sendKeys(loc_AssetTitleField, Asset_Series2 + "_Up", "AssetTitle", AssetTitle_Status);
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series2 + "_Up" , Asset_Series2 + "_Up");


			//TC_AM_AS_232
			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_232");
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			//TC_AM_AS_010
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
			switchIntoFrame(frameParent2Xpath);
			
			sendKeys(loc_AssetTitle, PrefixAssetName, "AssetTitle " + AssetType, AssetTitle_Status);
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(ByLocator(loc_SearchedAsset));
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series + "_Up"), "Searched Asset at Search Grid", Asset_Series + "_Up");
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series1 + "_Up"), "Searched Asset at Search Grid", Asset_Series1 + "_Up");
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series2 + "_Up"), "Searched Asset at Search Grid", Asset_Series2 + "_Up");

			robot.keyPress(KeyEvent.VK_CONTROL);
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series + "_Up"), "Asset_Series" + "_Up");
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series1 + "_Up"), "Asset_Series1" + "_Up");
			clickOn(loc_SearchedAssetDetails.replace("@var", Asset_Series2 + "_Up"), "Asset_Series2" + "_Up");
			robot.keyRelease(KeyEvent.VK_CONTROL);

			Thread.sleep(3000);
			clickUsingJSExecutor(loc_ViewAsset, "View Asset");
			WaitForModalPanel();

			//TC_AM_AS_234

			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_234");
			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series);
			sendKeys(loc_AssetTitleField, Asset_Series, "AssetTitle", AssetTitle_Status);
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series , Asset_Series);

			clickUsingJSExecutor(loc_Next_GeneralTab, "Next_GeneralTab");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series1);
			sendKeys(loc_AssetTitleField, Asset_Series1, "AssetTitle", AssetTitle_Status);
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series1 , Asset_Series1);

			ExecutionLog.Log("");
			ExecutionLog.Log("From Manual Test Step : TC_AM_AS_231");
			clickUsingJSExecutor(loc_Next_GeneralTab, "Next_GeneralTab");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", Asset_Series2);
			sendKeys(loc_AssetTitleField, Asset_Series2, "AssetTitle", AssetTitle_Status);
			sleepTime(5);
			if(ClientData.contains("SKY")) {
				acceptAlert();
			}
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + Asset_Series2 , Asset_Series2);

		} else {
			throw new SkipException("=====BUG ID====== : 20728 [Client :" + ClientData + "]");
		}
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =13,enabled= true,description = "Search with no results (Validation)")
	public void TC13_SearchNoResult() throws Exception {
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath, "SearchLink");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), AssetSearch_Asset1 + " Search");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));
		sendKeys(loc_AssetTitle, "123456789_NoResult", "Asset Title","");
		Thread.sleep(2000);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		WaitForModalPanel();
		Thread.sleep(3000);

		//Alert Message 
		driver.switchTo().window(driver.getWindowHandle());
		WaitForElementPresent(By.xpath(OKAlertXpath));
		String ExpectedText = "No search results were found for this query. Please try again using different criteria.";
		verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 

	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =14,enabled= true,description = "Save/Restore Search")
	public void TC14_AssetSearch_RestoreSearch() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		if (ClientName.contains("VMN")){
			clickUsingJSExecutor(SearchXpath,"Search Icon");
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));			
		} else {	
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetSearchUnderSearch, "Asset Under 'Asset Search'");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}

		moveMouse(loc_AssetSearch_btnSaveSearchButton, "AssetSearch_btnSaveSearchButton");
		doubleClick(loc_AssetSearch_btnSaveSearchButton, "AssetSearch_btnSaveSearchButton");
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "Please run the search before attempting to save the search query.", "Alert Message on clicking 'Save Search Button'", AssetSearch_SaveSearch);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Save Search Button'");

		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));
		sendKeys(loc_AssetTitle, PrefixAssetName, "Asset Title","");

		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309 [Client :" + ClientData + "]");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		Thread.sleep(2000);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_AssetSearch_btnSaveSearchButton, "AssetSearch_btnSaveSearchButton");

		//TC_AM_AS_259
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_259");
		switchIntoFrame(frameParent3Xpath);

		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_ScopeLegend, AssetSearch_SaveSearch_ScopeLegend, "AssetSearch_SaveSearch_ScopeLegend", AssetSearch_SaveSearch_ScopeLegend);
		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_SaveForLocalRadioButton, AssetSearch_SaveSearch_SaveForLocalRadioButton,"AssetSearch_SaveSearch_SaveForLocalRadioButton",AssetSearch_SaveSearch_SaveForLocalRadioButton);
		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_SaveForGlobalRadioButton, AssetSearch_SaveSearch_SaveForGlobalRadioButton, "AssetSearch_SaveSearch_SaveForGlobalRadioButton", AssetSearch_SaveSearch_SaveForGlobalRadioButton);
		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_OptionsLegend, AssetSearch_SaveSearch_OptionsLegend, "AssetSearch_SaveSearch_OptionsLegend", AssetSearch_SaveSearch_OptionsLegend);
		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton,AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton , "AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton",AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton );
		verifyFieldValueOfHeader(loc_AssetSearch_SaveSearch_SaveAsNewSearchRadioButton, AssetSearch_SaveSearch_SaveAsNewSearchRadioButton, "AssetSearch_SaveSearch_SaveAsNewSearchRadioButton",AssetSearch_SaveSearch_SaveAsNewSearchRadioButton );
		verifyFieldValueOfHeader(loc_Save,AssetSearch_SaveSearch_SaveButton , "AssetSearch_SaveSearch_SaveButton",AssetSearch_SaveSearch_SaveButton, "value" );
		verifyFieldValueOfHeader(LocCancel, AssetSearch_SaveSearch_CancelButton, "AssetSearch_SaveSearch_CancelButton",AssetSearch_SaveSearch_CancelButton, "value" );

		//TC_AM_AS_261
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_261");
		doubleClick(loc_Save, "AssetSearch_SaveSearch_SaveButton", AssetSearch_SaveSearch_SaveButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "Please enter the name with which you want to save this search.", "Alert Message on clicking 'Save Button' at Save Search pop-up", AssetSearch_SaveSearch);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Save Button' at Save Search pop-up");

		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_AssetSearch_SaveSearch_SaveAsNewSearch_InputField, PrefixAssetName, "AssetSearch_SaveSearch_SaveAsNewSearch_InputField", AssetSearch_SaveSearch_SaveAsNewSearchRadioButton);
		clickOn(loc_Save, "AssetSearch_SaveSearch_SaveButton", AssetSearch_SaveSearch_SaveButton);

		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "Search Saved successfully.", "Alert Message on clicking 'Save Button' at Save Search pop-up", AssetSearch_SaveSearch);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Save Button' at Save Search pop-up",AssetSearch_SaveSearch);

		//TC_AM_AS_264
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_264");
		ExecutionLog.Log("******Verify Radio buttons, Headers, Legends and Buttons on the Restore Search Window'******");
		switchIntoFrame(frameParent2Xpath,AssetSearch_RestoreSearch);
		clickOn(loc_AssetSearch_btnRestoreSearchButton, "AssetSearch_btnRestoreSearchButton",AssetSearch_RestoreSearch);
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_SearchLegend, AssetSearch_RestoreSearch_SearchLegend, "AssetSearch_SaveSearch_ScopeLegend", AssetSearch_SaveSearch_ScopeLegend);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_SearchForLocalRadioButton, AssetSearch_RestoreSearch_SearchForLocalRadioButton,"AssetSearch_SaveSearch_SaveForLocalRadioButton",AssetSearch_SaveSearch_SaveForLocalRadioButton);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_SaveForGlobalRadioButton, AssetSearch_RestoreSearch_SaveForGlobalRadioButton, "AssetSearch_SaveSearch_SaveForGlobalRadioButton", AssetSearch_SaveSearch_SaveForGlobalRadioButton);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_ResultsLegend, AssetSearch_RestoreSearch_ResultsLegend, "AssetSearch_SaveSearch_OptionsLegend", AssetSearch_SaveSearch_OptionsLegend);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_ColumnHeader,AssetSearch_RestoreSearch_Results_ColumnHeader , "AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton",AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton );
		ExecutionLog.Log("*****Verify Button of the Restore Pop-up******");
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_SearchButton, AssetSearch_RestoreSearch_SearchButton, "AssetSearch_RestoreSearch_SearchButton", AssetSearch_RestoreSearch_SearchButton, "value");
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_RestoreButton, AssetSearch_RestoreSearch_RestoreButton, "AssetSearch_RestoreSearch_RestoreButton", AssetSearch_RestoreSearch_RestoreButton, "value" );
		verifyFieldValueOfHeader(loc_Delete, AssetSearch_RestoreSearch_DeleteButton, "AssetSearch_RestoreSearch_DeleteButton", AssetSearch_RestoreSearch_DeleteButton, "value");
		verifyFieldValueOfHeader(loc_Cancel, AssetSearch_RestoreSearch_CancelButton, AssetSearch_RestoreSearch_CancelButton, AssetSearch_RestoreSearch_CancelButton, "value" );
		ExecutionLog.Log("******Verify the default searched Asset after 'Save Search'******");
		
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName), PrefixAssetName, "AssetSearch_RestoreSearch_Results_SearchedAsset",AssetSearch_RestoreSearch_RestoreButton );

		//TC_AM_AS_265
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_265");
		ExecutionLog.Log("******Enter Not-Exising Asset Name in the Search Field >> Search >> Verify Validation Message******");
		sendKeys(loc_AssetSearch_RestoreSearch_SearchField, "ABC123456", "AssetSearch_RestoreSearch_SearchField", AssetSearch_RestoreSearch_SearchLegend);
		clickOn(loc_AssetSearch_RestoreSearch_SearchButton, "AssetSearch_RestoreSearch_SearchButton",AssetSearch_RestoreSearch_SearchButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "No report results were found for this query. Please try again using different criteria.", "Alert Message on clicking 'Search Button' at Restore Search pop-up", AssetSearch_RestoreSearch_RestoreButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Search Button' at Restore Search pop-up");

		//TC_AM_AS_266
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_266");
		ExecutionLog.Log("******Enter Exising Asset Name in the Search Field >> Search >> Verify The Search Asset in the Result box******");
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_AssetSearch_RestoreSearch_SearchField, PrefixAssetName, "AssetSearch_RestoreSearch_SearchField", AssetSearch_RestoreSearch_SearchLegend);
		clickOn(loc_AssetSearch_RestoreSearch_SearchButton, "AssetSearch_RestoreSearch_SearchButton",AssetSearch_RestoreSearch_SearchButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName), PrefixAssetName, "AssetSearch_RestoreSearch_Results_SearchedAsset",AssetSearch_RestoreSearch_RestoreButton );
		clickOn(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName),"First Asset in Restore Pop-up");
		clickOn(loc_AssetSearch_RestoreSearch_Results_RestoreButton,"AssetSearch_RestoreSearch_RestoreButton",AssetSearch_RestoreSearch_RestoreButton);
		WaitForModalPanel();

		//TC_AM_AS_268
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_268");
		ExecutionLog.Log("*****Click RestoreSearch >> Enter Asset Name >> Click Delete >> Verify Validation message*****");
		switchIntoFrame(frameParent2Xpath,AssetSearch_RestoreSearch);
		clickOn(loc_AssetSearch_btnRestoreSearchButton, "AssetSearch_btnRestoreSearchButton",AssetSearch_RestoreSearch);
		switchIntoFrame(frameParent3Xpath);
		sendKeys(loc_AssetSearch_RestoreSearch_SearchField, PrefixAssetName, "AssetSearch_RestoreSearch_SearchField", AssetSearch_RestoreSearch_SearchLegend);
		clickOn(loc_AssetSearch_RestoreSearch_SearchButton, "AssetSearch_RestoreSearch_SearchButton",AssetSearch_RestoreSearch_SearchButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName).replace("@var", PrefixAssetName), PrefixAssetName, "AssetSearch_RestoreSearch_Results_SearchedAsset",AssetSearch_RestoreSearch_RestoreButton );
		clickOn(loc_Delete, "AssetSearch_RestoreSearch_DeleteButton",AssetSearch_RestoreSearch_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "Please select an item in the list before clicking the Delete button.", "Alert Message on clicking 'Delete Button' at Restore Search pop-up", AssetSearch_RestoreSearch_DeleteButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Delete Button' at Restore Search pop-up",AssetSearch_RestoreSearch_DeleteButton);

		//TC_AM_AS_269
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_269");
		ExecutionLog.Log("*****Select the Asset in the Restore Search pop-up >> Delete >> Cancel >> Verify Record not deleted*****");
		switchIntoFrame(frameParent3Xpath,AssetSearch_RestoreSearch_DeleteButton);
		clickOn(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName),"First Asset in Restore Pop-up");
		clickOn(loc_Delete, "AssetSearch_RestoreSearch_DeleteButton",AssetSearch_RestoreSearch_DeleteButton);
		WaitForModalPanel();
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, "Are you sure you want to delete this search?", "Alert Message on clicking 'Delete Button'", AssetSearch_RestoreSearch_DeleteButton);
		clickUsingJSExecutor(Loc_ConfirmCancel, "Cancel Button at Alert on clicking 'Delete Button'", AssetSearch_RestoreSearch_DeleteButton);
		switchIntoFrame(frameParent3Xpath);
		verifyFieldValueOfHeader(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName), PrefixAssetName, "AssetSearch_RestoreSearch_Results_SearchedAsset",AssetSearch_RestoreSearch_RestoreButton );

		//TC_AM_AS_270
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_270");
		ExecutionLog.Log("*****Select the Asset in the Restore Search pop-up >> Delete >> OK >> Verify Record is deleted*****");
		switchIntoFrame(frameParent3Xpath,AssetSearch_RestoreSearch_DeleteButton);
		clickOn(loc_AssetSearch_RestoreSearch_Results_SearchedAsset.replace("@var", PrefixAssetName),"First Asset in Restore Pop-up");
		clickOn(loc_Delete, "AssetSearch_RestoreSearch_DeleteButton",AssetSearch_RestoreSearch_DeleteButton);
		WaitForModalPanel();
		ExecutionLog.Log("=====BUG ID====== : 20729 [Client :" + ClientData + "]");
		verifyFieldValueOfHeader(ConfirmAlertValidationMessgeText, "Are you sure you want to delete this search?", "Alert Message on clicking 'Delete Button'", AssetSearch_RestoreSearch_DeleteButton);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Alert on clicking 'Delete Button' at Restore Search pop-up");
		WaitForModalPanel();
		verifyFieldValueOfHeader(AlertValidationMessgeText, "No report results were found for this query. Please try again using different criteria.", "Alert Message on clicking 'Search Button' at Restore Search pop-up", AssetSearch_RestoreSearch_RestoreButton);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on clicking 'Search Button' at Restore Search pop-up");



	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =15,enabled= true,description = "Exact Match")
	public void TC15_AssetSearch_ExactMatch() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		if (ClientName.contains("VMN")){
			clickUsingJSExecutor(SearchXpath,"Search Icon");
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));			
		} else {	
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetSearchUnderSearch, "Asset Under 'Asset Search'");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}
		
		//TC_AM_AS_278
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : TC_AM_AS_278");
		clickOn(loc_Asset_ExactMatchCheckBoxLabel,"Asset_ExactMatchCheckBoxLabel");
		sendKeys(loc_AssetTitle, Asset_Series, "AssetTitle " + AssetType, AssetTitle_Status);
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series), "Searched Asset at Search Grid", Asset_Series);
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * 
	 */
	@Test(priority =16,enabled= true,description = "Search with respect to AKA/FKA/EAKA/Legal")
	public void TC16_AssetSearch_SearchWithRespectToAKA_FKA_EAKA_Legal() throws Exception {
		
		AddAKADetails();
		//TC_AM_AS_003
		navigateTo_AssetsSearchPage();
		switchIntoFrame(frameParent2Xpath);
		//verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		sendKeys(loc_AssetTitle, Asset_Series1, "AssetTitle", AssetTitle_Status);
		// un-checking the AKA Check Box
		clickOn(Loc_AKACheckBox, "AKA Check Box");
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series1), "Searched Asset at Search Grid", Asset_Series1);
		//TC_AM_AS_004
		assetSearchWithAKA(RSGPS);
		//TC_AM_AS_008
		assetSearchWithAKA(Action_Series);
		//TC_AM_AS_011
		assetSearchWithAKA(DelhiAction);
		//TC_AM_AS_014
		assetSearchWithAKA(For_A_month);
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 */
	public void navigateTo_AssetsSearchPage() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		if (ClientName.contains("VMN")){
			clickUsingJSExecutor(SearchXpath,"Search Icon");
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));			
		} else {	
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			//TC_AM_AS_010
			clickUsingJSExecutor(loc_AssetSearchUnderSearch, "Asset Under 'Asset Search'");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}
	}
	
	/**
	 * @author Rajuddin
	 * @param AssetTitle
	 * @throws Exception
	 */
	public void assetSearchWithAKA(String AKA_Name) throws Exception {
		//TC_AM_AS_004
		navigateTo_AssetsSearchPage();
		switchIntoFrame(frameParent2Xpath);
		//verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		sendKeys(loc_AssetTitle, AKA_Name, "AssetTitle", AssetTitle_Status);
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		// AKA Check box is selected by default
		// Exact Match is unchecked by Default
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series1), "Searched Asset at Search Grid", Asset_Series1);

		//TC_AM_AS_005
		String TrimedAKAName = AKA_Name.substring(0,AKA_Name.length()-1);
		System.out.println("Original Name :" +AKA_Name);
		System.out.println("TrimedAKAName Name :" +TrimedAKAName);
		navigateTo_AssetsSearchPage();
		switchIntoFrame(frameParent2Xpath);
		verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		sendKeys(loc_AssetTitle, TrimedAKAName, "AssetTitle", AssetTitle_Status);
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		// AKA Check box is selected by default
		// Exact Match is unchecked by Default
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series1), "Searched Asset at Search Grid", Asset_Series1);

		//TC_AM_AS_006
		navigateTo_AssetsSearchPage();
		switchIntoFrame(frameParent2Xpath);
		verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		sendKeys(loc_AssetTitle, AKA_Name, "AssetTitle", AssetTitle_Status);
		clickOn(Loc_ExactMatchCheckBox, "ExactMatch Box");
		// Delete these lines once 20309 is fixed
		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309");
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", Asset_Series1), "Searched Asset at Search Grid", Asset_Series1);

		//TC_AM_AS_007
		navigateTo_AssetsSearchPage();
		switchIntoFrame(frameParent2Xpath);
		verifyFirstSelectedDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type", AssetSearch_DefaultAssetType, AssetSearch_DefaultAssetType);
		sendKeys(loc_AssetTitle, AKA_Name, "AssetTitle", AssetTitle_Status);
		// uncheck AKA Check 
		clickOn(Loc_AKACheckBox, "AKA Check Box");
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		//Alert Message 
		driver.switchTo().window(driver.getWindowHandle());
		WaitForElementPresent(By.xpath(OKAlertXpath));
		String ExpectedText = "No search results were found for this query. Please try again using different criteria.";
		verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 

	}

	public void AddAKADetails() throws Exception  {
		
		//search Created Asset
		assetMaintenance.searchCreatedAsset(Asset_Series1);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(By.xpath(DetailsTab));
		clickOn(DetailsTab, "DetailsTab");
		Thread.sleep(3000);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(By.id(DetailsTabSaveBtn));


		WaitForElementPresent(By.xpath(Loc_Details_AssetTitle1Row));
		Thread.sleep(2000);
		clickOn(Loc_Details_1Row, " Details 1Row", "");
		Thread.sleep(2000);
		String AKAInputField_Details = Loc_Details_AssetTitle1RowInput;
		if(ClientData.contains("TURNER")) {
			AKAInputField_Details = Loc_Details_AssetTitleRowInput;
		} else {
			AKAInputField_Details = Loc_Details_AssetTitle1RowInput;
		}
		
		//Field - AKA
		doubleClick(Loc_Details_AssetTitle1Row, "Asset Title 1Row", Loc_Details_AKA);
		WaitForElementPresent(AKAInputField_Details);
		Thread.sleep(2000);
		sendKeys(AKAInputField_Details,  RSGPS, "AKA Input", AM_Details_AKAField);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();		
		//Field - AKA Type
		clickOn(Loc_Details_AKAType1Row, "AKA Type", AM_Details_AKAField);
		sendKeys(Loc_Details_AKATypeInput, AKA, "AKA Type Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);

		//FKA
		clickOn(Loc_Details_AssetTitle2Row, "Asset Title 1Row", Loc_Details_AKA);
		WaitForElementPresent(By.xpath(AKAInputField_Details));
		Thread.sleep(2000);
		sendKeys(AKAInputField_Details, Action_Series, "AKA Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();		
		//Field - AKA Type
		clickOn(Loc_Details_AKAType2Row, "AKA Type", AM_Details_AKAField);
		sendKeys(Loc_Details_AKATypeInput, FKA, "AKA Type Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);

		//EAKA
		clickOn(Loc_Details_AssetTitle3Row, "Asset Title 1Row", Loc_Details_AKA);
		WaitForElementPresent(By.xpath(AKAInputField_Details));
		Thread.sleep(2000);
		sendKeys(AKAInputField_Details, DelhiAction, "AKA Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();		
		//Field - AKA Type
		clickOn(Loc_Details_AKAType3Row, "AKA Type", AM_Details_AKAField);
		sendKeys(Loc_Details_AKATypeInput, EAKA, "AKA Type Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);

		//Legal
		scrollElementIntoView(Loc_Details_AssetTitle4Row);
		clickOn(Loc_Details_AssetTitle4Row, "Asset Title 1Row", Loc_Details_AKA);
		WaitForElementPresent(By.xpath(AKAInputField_Details));
		Thread.sleep(2000);
		sendKeys(AKAInputField_Details, For_A_month, "AKA Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();		
		//Field - AKA Type
		clickOn(Loc_Details_AKAType4Row, "AKA Type", AM_Details_AKAField);
		sendKeys(Loc_Details_AKATypeInput, Legal, "AKA Type Input", AM_Details_AKAField);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		clickUsingJSExecutor(DetailsTabSaveBtn, "Details Tab SaveBtn");	


	}
	
	public void createContributor_AssignRole(String AssetName, String AssetType, String Role)  throws Exception {

		/* Add the Role to the Contributor*/
		assetMaintenance.selectAsset(AssetName);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Contributors') or contains(text(),'Contacts') or contains(text(),'Cast"), "Contributors OR Contacts TAB");
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		selectDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFirstSelectedDropdownValue(Loc_Details_ContributorsNetwork, "Network Drop Down", Contributor_Network1, Contributor_Network1);
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor("name="+loc_Edit, "'Edit' Button at Contributor TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_EpisodeAdd));

		clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Contributor window");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(By.id("btnSelect"));
		selectDropdownValue(loc_Contributor_PartyList_DropDown, "Contributor_PartyList_DropDown", Contributor_InternalParties, Contributor_InternalParties);
		Thread.sleep(1000);
		WaitForElementPresent(ByLocator(SaveButton));
		String InternDetailfirstname = "Automation First Name";
		String InternDetailLastname = "Automation Last Name";

		// Select the created Contributor
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(ByLocator(SaveButton));
		Thread.sleep(3000);
		clickOn(loc_Contributor_ContributorSearch_SearchField,"Contributor_ContributorSearch_SearchField");
		sendKeys(loc_Contributor_ContributorSearch_SearchField, InternDetailLastname, "Contributor_ContributorSearch_SearchField", "Contributor_ContributorSearch_SearchField");

		clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "Find Button at Contributor Search Window");
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		// Search for the contributor
		if(getText(loc_Contributor_ContributorSearch_FirstContributor).equals(InternDetailfirstname)) {
			// Select the created Contributor
			switchIntoFrame(frameParent4Xpath);
	//TODO Not selecting the Contributor hence failing Asset Search TC3
			doubleClick(loc_Contributor_ContributorSearch_FirstContributor,"Contributor_ContributorSearch_FirstContributor");
			//clickUsingJSExecutor(SaveButton, "Select Contributor at Contributor_ContributorSearch window");

		} else {
			// if the contributor is not found then Create a New Contributor 
			driver.switchTo().window(driver.getWindowHandle()); 
			clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert on Entering the invalid Names", document_AddDoc_DocNameLabel); 
			switchIntoFrame(frameParent4Xpath);
			clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Contributor Edit window");
			switchIntoFrame(frameParent5Xpath);
			WaitForElementPresent(ByLocator(loc_Contributor_ContributorSearch_Add_FirstNameField));

			////Create the Contributor
			clickOn(loc_Contributor_ContributorSearch_Add_FirstNameField, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName);
			sendKeys(loc_Contributor_ContributorSearch_Add_FirstNameField, InternDetailfirstname, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName);
			clickOn(loc_Contributor_ContributorSearch_Add_LastNameField, ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName);
			sendKeys(loc_Contributor_ContributorSearch_Add_LastNameField, InternDetailLastname, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName);

			verifyFirstSelectedDropdownValue(loc_Contributor_ContributorSearch_Add_AddressTypeDropDown, "Contributor_ContributorSearch_Add_AddressTypeDropDown", "Primary", "Contributor_ContributorSearch_Add_AddressTypeDropDown");
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "Contributor_ContributorSearch_Add_AddressLine1InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);
			sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine1InputField, "AddressLine1", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_AddressLine2Label, "Contributor_ContributorSearch_Add_AddressLine2InputField",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);
			sendKeys(loc_Contributor_ContributorSearch_Add_AddressLine2InputField, "AddressLine2", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2 Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_CityInputField, "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City",ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);
			sendKeys(loc_Contributor_ContributorSearch_Add_CityInputField, "City", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City);

			selectDropdownValue(loc_Contributor_ContributorSearch_Add_CountryInputField, "Country Input Field", "Canada", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country);
			selectDropdownValue(loc_Contributor_ContributorSearch_Add_StateInputField, "Contributor_ContributorSearch_Add_StateInputField", "Alberta", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State);
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_ZipCodeField, "Contributor_ContributorSearch_Add_ZipCodeField");
			sendKeys(loc_Contributor_ContributorSearch_Add_ZipCodeField, "12345", "ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode Field", ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "Contributor_ContributorSearch_Add_BusinessPhone Input Field");
			sendKeys(loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField, "6176828224", "Contributor_ContributorSearch_Add_BusinessPhone Field", ContributorSearch_Add_BusinessPhoneLabel);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "Contributor_ContributorSearch_Add_PrimaryEmail");
			sendKeys(loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField, "primary1@gmail.com", "Contributor_ContributorSearch_Add_PrimaryEmail Input Field", ContributorSearch_Add_PrimaryEmailLabel);

			selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactListDropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Home, "Contributor_ContributorSearch_Add_ContactList2DropDown");
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact1_InputField, "Contributor_ContributorSearch_Add_Contact1_InputField");
			sendKeys(loc_Contributor_ContributorSearch_Add_Contact1_InputField, "Home Phone", "Contributor_ContributorSearch_Add_Contact1_InputField", "Contributor_ContributorSearch_Add_ContactListDropDown");

			selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList2DropDown, "Contributor_ContributorSearch_Add_ContactList2DropDown", Contributor_ContributorSearch_Add_Comm_Mobile, "Contributor_ContributorSearch_Add_ContactList2DropDown");
			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "Contributor_ContributorSearch_Add_Contact2_InputField");
			sendKeys(loc_Contributor_ContributorSearch_Add_Contact2_InputField, "6176828224", "Contributor_ContributorSearch_Add_Contact2_InputField Field", "Contributor_ContributorSearch_Add_ContactListDropDown");

			selectDropdownValue(loc_Contributor_ContributorSearch_Add_ContactList3DropDown, "Contributor_ContributorSearch_Add_ContactList3DropDown", Contributor_ContributorSearch_Add_Comm_Personal, "Contributor_ContributorSearch_Add_ContactList3DropDown");

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "Contributor_ContributorSearch_Add_ContactList3DropDown");
			sendKeys(loc_Contributor_ContributorSearch_Add_Contact3_InputField, "personal1@gmail.com", "Contributor_ContributorSearch_Add_ContactList3DropDown Field", "Contributor_ContributorSearch_Add_ContactList3DropDown");

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_WebAddressInputField, ContributorSearch_Add_WebAddressLabel);
			sendKeys(loc_Contributor_ContributorSearch_Add_WebAddressInputField, "www.web.com", "Contributor_ContributorSearch_Add_WebAddressField", ContributorSearch_Add_WebAddressLabel);

			clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
			WaitForModalPanel();
			switchIntoFrame(frameParent5Xpath);
			Thread.sleep(3000);
			verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);

			driver.switchTo().window(driver.getWindowHandle());
			clickOn(loc_Contributor_ContributorSearch_Add_CloseWindow,"close Add Reference Window");
			///////////// Contributor is created above

			// Select the created Contributor
			ExecutionLog.Log("Select the created Contributor");
			switchIntoFrame(frameParent4Xpath);
			WaitForElementPresent(ByLocator(SaveButton));
			Thread.sleep(3000);
			clickOn(loc_Contributor_ContributorSearch_SearchField,"Contributor_ContributorSearch_SearchField");
			sendKeys(loc_Contributor_ContributorSearch_SearchField, InternDetailLastname, "Contributor_ContributorSearch_SearchField", "Contributor_ContributorSearch_SearchField");

			clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "Find Button at Contributor Search Window");
			WaitForElementPresent(ByLocator(loc_Contributor_ContributorSearch_FirstContributor));
			Thread.sleep(3000);
			switchIntoFrame(frameParent4Xpath);
			Thread.sleep(3000);
			doubleClick(loc_Contributor_ContributorSearch_FirstContributor,"Contributor_ContributorSearch_FirstContributor");
			//clickUsingJSExecutor(SaveButton, "Select Contributor at Contributor_ContributorSearch window");
		}


		// Fill the details for the Asset at Edit Contributor Window
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_EpisodeAdd);

		Thread.sleep(3000);
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "contributor Applies to", Conrtibutors_AppliesTo_ViewMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_AppliesToInputField, Asset_Series, "Applies To first Row", Conrtibutors_AppliesTo_ViewMode_Value);
		keyboard();
		
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_AppliesTo_EditMode_Key, Conrtibutors_AppliesTo_ViewMode_Value), "contributor Applies to", Conrtibutors_AppliesTo_ViewMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_AppliesToInputField, Asset_Series, "Applies To first Row", Conrtibutors_AppliesTo_ViewMode_Value);
		keyboard();
		clickOn(getLocator_EditTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), "Role field", Conrtibutors_Role_EditMode_Value,Conrtibutors_Role_EditMode_Value);
		sendKeys(loc_Contributor_ContributorSearch_RoleInputField, Role, "Role Field of first Row", Conrtibutors_Role_EditMode_Value);
		keyboard();

		clickUsingJSExecutor(loc_Save, "Save Button at 'Edit Window'");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", Conrtibutors_Role_EditMode_Key, Conrtibutors_Role_EditMode_Value), Role, "Role of First Data Row", Conrtibutors_Role_EditMode_Value, "innerHTML");

	}
	

	public void assetSearch_WithoutWpisodes(String AssetName, String AssetType) throws Exception {
		
		ExecutionLog.Log("Go to Asset Search>> Select " +  AssetType +" option >> Select the Asset \"" + AssetName + "\"");
		switchIntoFrame(frameParent1Xpath);
		assetMaintenance.navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
		clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_AssetTitle));

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_ExpandAdvancedSearchIcon,"ExpandAdvancedSearchIcon");
		selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type DropDown At AssetSearch", AssetType, AssetType);
		verifySeletedOptions(loc_AssetTypeDropDownAtAssetSearch, AssetType, "Asset Type");
		sendKeys(loc_AssetTitle, AssetName, "AssetTitle " + AssetType, AssetTitle_Status);
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		WaitForElementToClickable(ByLocator(loc_SearchedAsset));
		verifyTextMatches(loc_SearchedAssetDetails.replace("@var", AssetName), "Searched Asset at Search Grid", AssetName);
		moveMouse(loc_SearchedAssetDetails.replace("@var", AssetName), AssetName + " Asset in the Searched Asset");
		clickOn(loc_SearchedAssetDetails.replace("@var", AssetName), AssetName + " Asset in the Searched Asset");
		clickOn(loc_SearchedAssetDetails.replace("@var", AssetName), AssetName + " Asset in the Searched Asset");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_ViewAsset, "View Asset");
		WaitForModalPanel();
		
		
	}
		
	/**
	 * @author Rajuddin
	 * @param AssetName
	 * @param AssetType
	 * @throws Exception
	 * @description : This method will be used after "assetSearch_WithoutWpisodes()" method
	 */
	public void assetSearch_EditAssetName(String AssetName, String AssetType) throws Exception {
		
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(3000);
		ExecutionLog.Log("Edit the Asset Name("+AssetType+ ") >> Save >> Search And Verify Edited Asset >> Rename the Asset to Original one");
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", AssetName);
		sendKeys(loc_AssetTitleField, AssetName + "_Edit", "AssetTitle", AssetTitle_Status);
		sleepTime(5);
		if(ClientData.contains("SKY")) {
			acceptAlert();
		}
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + AssetName + "_Edit" , AssetName + "_Edit");
		//TC_AM_AS_068
		assetMaintenance.searchCreatedAsset(AssetName + "_Edit", AssetType);
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(6000);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", AssetName + "_Edit");
		//TC_AM_AS_075
		sendKeys(loc_AssetTitleField, AssetName , "AssetTitle", AssetTitle_Status);
		sleepTime(5);
		if(ClientData.contains("SKY")) {
			acceptAlert();
		}
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + AssetName , AssetName);

	}
	
	public void advancedAssetSearch_ContactRole(String AssetName, String AssetType, String Role ) throws Exception {
		// SalesDemo does not has Contact Role
		if(!AssetSearch_ContributorRole.contains("N/A")) {
			ExecutionLog.Log("Advance Search >> Contact Role ("+ Role +") >> Verify Searched Asset >> Verify Season/Episodes are not shown");
			switchIntoFrame(frameParent1Xpath);
			assetMaintenance.navigateToAssetMaintenance();
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));

			switchIntoFrame(frameParent2Xpath);
			selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "Asset Type DropDown At AssetSearch", AssetType, AssetType);
			verifySeletedOptions(loc_AssetTypeDropDownAtAssetSearch, AssetType, "Asset Type");
			sendKeys(loc_AssetTitle, AssetName, "Asset Title", AssetTitle_Status);
			clickOn(loc_ExpandAdvancedSearchIcon,"ExpandAdvancedSearchIcon");
			Thread.sleep(3000);
			// TC_AM_AS_080
			selectDropdownValue(loc_AssetSearch_ContactRole_inputField, "AssetSearch_ContactRole_inputField", Role, AssetSearch_ContributorRole);			
			clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
			Thread.sleep(6000);
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementToClickable(ByLocator(loc_SearchedAsset));
			verifyTextMatches(loc_SearchedAssetDetails.replace("@var", AssetName), "Searched Asset at Search Grid", AssetName);
			verifyElementNotDisplayed(loc_ExpandAssetDetail_At_AssetSearchGrid, "Season","Applicable for All Clients");
		}
	}

}
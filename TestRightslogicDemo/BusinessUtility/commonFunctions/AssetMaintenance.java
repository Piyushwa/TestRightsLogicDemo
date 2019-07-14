package commonFunctions;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExecutionLog;
import utility.PropertyReader;

public class AssetMaintenance extends MultiClient_SupportingFunctions {
	String ClientName = PropertyReader.readApplicationFile("Client");

	
	public void selectAsset(String AssetName) throws Exception {
		navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		doubleClick("//*[@title='"+ AssetName + "']", AssetName + "AssetName" , AssetName);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
	}
	
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description this method will pick the Expected Label Name from Excel file for client and match it with Actual Label present in the applications
	 */
	public void verifyLabel() throws Exception{
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_AssetTypeLabel, "Asset Type", AssetType_Status);
		verifyTextMatches(loc_AssetCategory, "Asset Category/Group",AssetCategory_Status);
		verifyTextMatches(loc_AssetTitleLabel,"Asset Title", AssetTitle_Status);
		verifyTextMatches(loc_IPName, "IP Name", IP_Status);
		verifyTextMatches(loc_ProjectIDLabel,"Project ID", ProjectID_Status);
		verifyTextMatches(loc_SeriesTitleLabel,"Series Title", SeriesTitle_Status);
		verifyTextMatches(loc_VendorLabel,"Vendor", Vendor1_Status);
		verifyTextMatches(loc_StudioLabel, "Studio", Vendor2_Status);
		verifyTextMatches(loc_SourceBusinessUnitLabel,"SourceBusinessUnit", SBU_Status);
		verifyTextMatches(loc_DurationLabel,"Duration", DurationField_Status);
		verifyTextMatches(loc_ShortName,  "ShortName", ShortName_Status);
		verifyTextMatches(loc_AssetStatusLabel,"AssetStatusLabel", AssetStatus_Status);
		verifyTextMatches(loc_AssetSourceLabel,"Asset Source", AssetSource_Status);
		verifyTextMatches(loc_InternalCheckBoxLabel,"Internal CheckBox", InternalCheckBox_Status);
		verifyTextMatches(loc_NonAirableCheckBoxLabel,"NonAirable CheckBox", NonAirableCheckBox_Status);
		verifyTextMatches(loc_TBACheckBoxLabel, "TBA CheckBox", TBACheckBox_Status);
		verifyTextMatches(loc_AssetFormat, "Asset Format", AssetFormat_Status);
		verifyTextMatches(loc_ViewedLabel,"ViewedLabel", ViewedLabel_Status);
		verifyTextMatches(loc_DeliveryDateLabel,"DeliveryDate", DeliveryDate_Status);
		verifyTextMatches(loc_AssetDataStatus, "PROD Contract Entry/AssetData Status", PPRODContract_Status);
		verifyTextMatches(loc_UniqueEpi,"Unique Episode", UniqueEpisode_Status);
		verifyTextMatches(loc_ClientGroup,"_ClientGroup", ClientGroup_Status);
		verifyTextMatches(loc_SeasonLabel, "SeasonLabel", Season_Status);
		verifyTextMatches(loc_AssetHierarchy, "AssetHierarchy", AssetHierarchy_Status);
		verifyTextMatches(loc_GroupAssociation,"GroupAssociation", GroupAssociation_Status);
		verifyTextMatches(loc_ActualRuntime,"Actual Run time", ActualRunTime_Status);
	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description Click on Module TAB >> Asset Maintenance
	 */
	public void navigateToAssetMaintenance() throws Exception {
		sleepTime(10);
		switchIntoFrame(frameParent1Xpath);
		clickOn(ModulesXpath, "MODULE");
		Thread.sleep(3000);
		if(ClientName.contains("VMN")){
			clickOn(loc_PageLink.replace("@var", "Entry & Maintenance"), "Property Entry & Maintenance");
		}else if(ClientName.contains("SKY")){
			
			clickOn(loc_PageLink.replace("@var", "Title Maintenance"), "Title Maintenance");
		}
		else {
			clickOn(loc_PageLink.replace("@var", "Asset Maintenance"), "Asset Maintenance");
		}
		sleepTime(10);
	}

	/**
	 * @author Rajuddin
	 * @param Methodname : name of the method
	 * @param AssetType : Type of the Asset like Program or element etc.
	 * @param AssetTitle : Title of the Asset
	 * @throws Exception
	 * 
	 * @descrioption click On New Button
	 * click on Asset Type for e.g: element Program, Element etc.
	 * click on General type
	 */
	public void navigateToGeneralTab(String AssetType, String AssetTitle) throws Exception {
		if(!AssetType.contains("N/A")) {

			switchIntoFrame(frameParent2Xpath);
			if (ClientName.contains("VMN")){
				clickUsingJSExecutor(SearchXpath, "SearchLink");
				clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
				driver.switchTo().window(driver.getWindowHandle()); 
				WaitForModalPanel();
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				WaitForElementPresent(loc_AssetTitle);
				clickUsingJSExecutor("//*[@id='TR_Asset_Search_Params']/td", "TR_Asset_Search_Params");
				sendKeys(loc_AssetTitle, AssetTitle, "Asset Title","");
				Thread.sleep(2000);
				clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
				WaitForModalPanel();
				Thread.sleep(3000);

				//Alert Message 
				driver.switchTo().window(driver.getWindowHandle());
				WaitForElementPresent(OKAlertXpath);
				String ExpectedText = "No search results were found for this query. Please try again using different criteria.";
				verifyFieldValueOfHeader(loc_AlertMessage, ExpectedText, "Alert Message","");
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 


				clickUsingJSExecutor(loc_AlertButton, "Ok button At Alert");
				Thread.sleep(6000);
				switchIntoFrame(frameParent2Xpath);
				WaitForElementPresent(loc_btnAddAsset);
				clickUsingJSExecutor(loc_btnAddAsset, "Add Asset Button");
				WaitForModalPanel();
				switchIntoFrame(frameParent4Xpath);
				if(getAllOptions(loc_AssetTypeDropDown_VMN, "AssetTypeDropDown Pop upn VMN").contains(AssetType)) {
					selectDropdownValue(loc_AssetTypeDropDown_VMN, "AssetTypeDropDown Pop upn VMN", AssetType, AssetType);
				}
				switchIntoFrame(frameParent4Xpath);
				doubleClick(OKButton,"OK Button");
				WaitForModalPanel();
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				ExecutionLog.Log("Asset id is "+getText("//*[@id='lblAssetIDVal']"));
				//Search and click new for VMN
			} else{
				//Click on Element title on new menu
				clickUsingJSExecutor(loc_NewButton, "New Button", AssetType);
				clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetType), AssetType, AssetType);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				Thread.sleep(8000);
				switchIntoFrame(frameParent2Xpath, AssetType);
				wait.until(ExpectedConditions .elementToBeClickable(ByLocator(loc_Tab.replace("@var", "General")))); 
				clickOn(loc_Tab.replace("@var", "General"), "General TAB", AssetType);
			}

		}

	}


	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createProgramAsset(String assetTitleName,String AssetType, Object... InternalAgreementCheckStatus) throws Exception {
		ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
		switchIntoFrame(frameParent1Xpath);
		navigateToAssetMaintenance();
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		navigateToGeneralTab("Program", assetTitleName);
		WaitForElementPresent(loc_AssetTitleField);

		//Field - Entry AssetType 
		selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType);

		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);

		//Enter value in Asset Title Field
		sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

		// Enter IP Name: Commenting as auto selected IP can also be used
		if(ClientData.contains("VMN")) {
			searchAndSelectIP();
		}

		// Field - Vendor
		searchAndSelectVendor();

		switchIntoFrame(frameParent2Xpath);
		// Select Vendor 2
		searchAndSelectStudio();

		//Field - Source Business Unit
		switchIntoFrame(frameParent2Xpath);

		// Search and Select SBU
		searchAndSelectSBU();

		switchIntoFrame(frameParent2Xpath);

		// Field - Duration
		if(isElementPresent(loc_DurationField)){
			sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
		}
		// Actual Run time field is available only for Corus
		if(isElementPresent(loc_ActualRuntime)){
			sendKeys(loc_ActualrunTime_InputField, Duration, "Duration", DurationField_Status);
		}


		switchIntoFrame(frameParent2Xpath);
		//Field - Asset Status
		selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);

		// Field - Asset Source
		selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);

		// Field - Title Type / Asset source-UCI
		selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
		switchIntoFrame(frameParent2Xpath);

		// Field - Delivery date
		sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

		//Asset Group
		selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

		//Season - Commented not required for this 4 clients
		selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, Season_Status);

		//Look up code
		sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

		//Project Id
		sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

		//Asset Hierarchy
		selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

		//MML Client Group
		selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

		//PROD Contract Entry Status
		selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

		try {
			if(InternalAgreementCheckStatus[0].toString().length()>0){
				if(!(ClientName.equalsIgnoreCase("CORUS"))){
					clickUsingJSExecutor(loc_CheckInternalCheckBox, "Check InternalCheckBox", InternalAgreementCheckStatus[0]);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		switchIntoFrame(frameParent2Xpath);
		//Save
		clickUsingJSExecutor(SaveMenuBar, "Save Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
		ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
	} 

	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createPromoMarketingAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {
			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_PromoAndMarketing, assetTitleName);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

			// Enter IP Name: Commenting as auto selected IP can also be used
			if(ClientData.contains("VMN") || ClientData.contains("SALESDEMO")) {
				searchAndSelectIP();
			}

			// Field - Vendor
			searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			// Select Vendor 2
			if (!(Vendor2_Status.contains("N/A"))) {
				searchAndSelectStudio();
			}

			//Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// Search and Select SBU
			searchAndSelectSBU();

			switchIntoFrame(frameParent2Xpath);

			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			// Actual Run time field is available only for Corus
			if(isElementPresent(loc_ActualRuntime)){
				sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
			}

			switchIntoFrame(frameParent2Xpath);
			
			// Asset Status is mandatory field for CORUS
			// Asset Status is not available for AMCN
			if(ClientData.equals("CORUS")) {
				//Field - Asset Status
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
			}
			
					
			// Field - Asset Format
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);
			}
			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			//Project Id
			sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

			//Asset Hierarchy
			selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//PROD Contract Entry Status
			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

			switchIntoFrame(frameParent2Xpath);
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");	
		}
		
	} 

	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createElementAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {
			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_Element, assetTitleName);
			WaitForElementPresent(loc_AssetTitleField);

			//Field - Entry AssetType 
			//getAllOptions(loc_AssetTypeDropDown, "AssetTypeDropDown");
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);
			
			if(!(ClientData.equals("SALESDEMO") || ClientData.contains("VMN"))) {
				// Enter IP Name: Commenting as auto selected IP can also be used
				if(!(ClientData.equals("ASTRO"))) {
					// Field - Vendor
					searchAndSelectVendor();
				}
				

				switchIntoFrame(frameParent2Xpath);
				// Select Vendor 2
				if (!(Vendor2_Status.contains("N/A"))) {
					searchAndSelectStudio();
				}

				//Field - Source Business Unit
				switchIntoFrame(frameParent2Xpath);

				// Search and Select SBU
				searchAndSelectSBU();

				switchIntoFrame(frameParent2Xpath);

				
				// Actual Run time field is available only for Corus
				if(isElementPresent(loc_ActualRuntime)){
					sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
				}

				switchIntoFrame(frameParent2Xpath);

				// Asset Status is mandatory field for CORUS
				// Asset Status is not available for AMCN
				if(ClientData.equals("CORUS")) {
					//Field - Asset Status
					selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
				}

				// Field - Asset Source
				selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);

				// Field - Title Type / Asset source-UCI
				selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
				switchIntoFrame(frameParent2Xpath);

				// Field - Delivery date
				sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

				if(!ClientData.equals("ASTRO")) {
					//Asset Group
					selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);
				}
				
				//Season - Commented not required for this 4 clients
				selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

				//Look up code
				sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

				//Project Id
				sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

				//Asset Hierarchy
				selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

				//MML Client Group
				selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

				//PROD Contract Entry Status
				selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);
			}

			switchIntoFrame(frameParent2Xpath);
			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
		}
	} 
	

	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createHomeVideoAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {
			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_HomeVideo, assetTitleName);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

			// Enter IP Name: Commenting as auto selected IP can also be used
			if(ClientData.contains("VMN") || ClientData.contains("SALESDEMO")) {
				searchAndSelectIP();
			}

			// Field - Vendor
			searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			// Select Vendor 2
			if (!(Vendor2_Status.contains("N/A"))) {
				searchAndSelectStudio();
			}

			//Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// Search and Select SBU
			searchAndSelectSBU();

			switchIntoFrame(frameParent2Xpath);

			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			// Actual Run time field is available only for Corus
			if(isElementPresent(loc_ActualRuntime)){
				sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
			}

			switchIntoFrame(frameParent2Xpath);

			// Asset Status is mandatory field for CORUS
			// Asset Status is not available for AMCN
			if(ClientData.equals("CORUS")) {
				//Field - Asset Status
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
			}
			
			// Field - Asset Source
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);
			}
			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			//Project Id
			sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

			//Asset Hierarchy
			selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//PROD Contract Entry Status
			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);
			switchIntoFrame(frameParent2Xpath);
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
		}
	} 
	
	
	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createMerchandiseAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {
			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_Merchandise, assetTitleName);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

			// Enter IP Name: Commenting as auto selected IP can also be used
			if(ClientData.contains("VMN") || ClientData.contains("SALESDEMO")) {
				searchAndSelectIP();
			}

			// Field - Vendor
			searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			// Select Vendor 2
			if (!(Vendor2_Status.contains("N/A"))) {
				searchAndSelectStudio();
			}

			//Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// Search and Select SBU
			searchAndSelectSBU();

			switchIntoFrame(frameParent2Xpath);

			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			// Actual Run time field is available only for Corus
			if(isElementPresent(loc_ActualRuntime)){
				sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
			}

			switchIntoFrame(frameParent2Xpath);
			
			// Asset Status is mandatory field for CORUS
			// Asset Status is not available for AMCN
			if(ClientData.equals("CORUS")) {
				//Field - Asset Status
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
			}
			// Field - Asset Source
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);
			}
			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			//Project Id
			sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

			//Asset Hierarchy
			selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//PROD Contract Entry Status
			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

			switchIntoFrame(frameParent2Xpath);
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
		}
	} 

	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createPublishingAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {

			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_Publishing, assetTitleName);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));

			//Field - Entry AssetType 
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

			// Enter IP Name: Commenting as auto selected IP can also be used
			if(ClientData.contains("VMN") || ClientData.equals("SALESDEMO")) {
				searchAndSelectIP();
			}

			// Field - Vendor
			searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			// Select Vendor 2
			if (!(Vendor2_Status.contains("N/A"))) {
				searchAndSelectStudio();
			}

			//Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// Search and Select SBU
			searchAndSelectSBU();

			switchIntoFrame(frameParent2Xpath);

			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			// Actual Run time field is available only for Corus
			if(isElementPresent(loc_ActualRuntime)){
				sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
			}

			switchIntoFrame(frameParent2Xpath);

			// Asset Status is mandatory field for CORUS
			// Asset Status is not available for AMCN
			if(ClientData.equals("CORUS")) {
				//Field - Asset Status
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
			}

			// Field - Asset Source
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);
			}
			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);

			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			//Project Id
			sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

			//Asset Hierarchy
			selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//PROD Contract Entry Status
			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

			switchIntoFrame(frameParent2Xpath);
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
		}
	} 

	/**
	 * @author Rajuddin
	 * @param assetTitleName
	 * @param AssetType
	 * @param InternalAgreementCheckStatus : "Yes" if you want to check Internal Agreement Check Box else "N/A"
	 * @throws Exception
	 */
	public void createTheatricalAsset(String assetTitleName,String AssetType, String runStatus) throws Exception {
		if(!runStatus.contains("N/A")) {
			ExecutionLog.Log("************************Started Creating Asset of Type: " + AssetType + "************************");
			switchIntoFrame(frameParent1Xpath);
			navigateToAssetMaintenance();
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			navigateToGeneralTab(AssetType_Theatrical, assetTitleName);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));

			//Field - Entry AssetType 			
			selectDropdownValue(loc_AssetTypeDropDown, "AssetTypeDropDown", AssetType, AssetType_Status);

			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);

			//Enter value in Asset Title Field
			sendKeys(loc_AssetTitleField, assetTitleName, "AssetTitle", AssetTitle_Status);

			// Enter IP Name: Commenting as auto selected IP can also be used
			if(ClientData.contains("VMN") || ClientData.equals("SALESDEMO")) {
				searchAndSelectIP();
			}

			// Field - Vendor
			searchAndSelectVendor();

			switchIntoFrame(frameParent2Xpath);
			// Select Vendor 2
			if (!(Vendor2_Status.contains("N/A"))) {
				searchAndSelectStudio();
			}

			//Field - Source Business Unit
			switchIntoFrame(frameParent2Xpath);

			// Search and Select SBU
			searchAndSelectSBU();

			switchIntoFrame(frameParent2Xpath);

			// Field - Duration
			if(isElementPresent(loc_DurationField)){
				sendKeys(loc_DurationField, Duration, "Duration", DurationField_Status);
			}
			// Actual Run time field is available only for Corus
			if(isElementPresent(loc_ActualRuntime)){
				sendKeys(loc_ActualRuntime, Duration, "Duration", DurationField_Status);
			}

			switchIntoFrame(frameParent2Xpath);
			// Asset Status is mandatory field for CORUS
			// Asset Status is not available for AMCN
			if(ClientData.equals("CORUS")) {
				//Field - Asset Status
				selectDropdownValue(loc_AssetStatusDropDown, "Asset Status", AssetStatus, AssetStatus_Status);
			}

			// Field - Asset Source
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetFormatDropDown, "Asset Format", AssetSource, AssetFormat_Status);
			}
			// Field - Title Type / Asset source-UCI
			selectDropdownValue(loc_AssetSource, "Asset Source", TitleType, AssetSource_Status);
			switchIntoFrame(frameParent2Xpath);

			// Field - Delivery date
			sendKeys(loc_DelivaryDatefield, DeliveryDate, "Delivery Date", DelivaryDate_Status);

			//Asset Group
			if(!ClientData.equals("SALESDEMO")) {
			selectDropdownValue(loc_AssetCategoryDropDown, "Asset Category/Group", InitialPlatform, AssetCategory_Status);
			}
			//Season - Commented not required for this 4 clients
			selectDropdownValue(loc_SeasonDropDown, "Season DropDown", Season, xlsInputData.getCellData("AMGeneral", ClientData, 115));

			//Look up code
			sendKeys(loc_ShortNameField, LookUpCode, "Short Name", ShortName_Status);

			//Project Id
			sendKeys(loc_ProjectIDField, ProjectID, "ProjectID", ProjectID_Status);			

			//Asset Hierarchy
			selectDropdownValue(loc_AssetHierarchyDropDown, "Asset Hierarchy", AssetHierarchy, AssetHierarchy_Status);

			//MML Client Group
			selectDropdownValue(loc_ClientGroupDropDown, "Client Group", MMLClient, ClientGroup_Status);

			//PROD Contract Entry Status
			selectDropdownValue(loc_AssetDataStatusDropDown, "PROD Contract Entry/AssetData Status", PRODContractEntryStatus, PPRODContract_Status);

			switchIntoFrame(frameParent2Xpath);
			//Save
			clickUsingJSExecutor(SaveMenuBar, "Save Button");
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath);
			verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset" + assetTitleName , assetTitleName);
			ExecutionLog.Log("************************Created Asset of Type" + AssetType + "************************");
		}
	} 
	
	/**
	 * @author Rajuddin
	 * @param Methodname
	 * @param AssetType
	 * @param AssetTitle : first index is for Asset Type
	 * Second index is to uncheck AKA (by default it is checked)
	 * @throws Exception
	 * 
	 * @Description : Click on "Asset Maintenance" TAB >> click Search Link 
	 * Select Property/Asset Search
	 * Enter the name of Asset and click on find Now button
	 * Select the Asset from the opened list \n
	 * click On View button
	 */
	public void searchCreatedAsset(String CreatedSeriesAssetTitle, Object... AssetType_And_AKA) throws Exception {
		switchIntoFrame(frameParent1Xpath);
		navigateToAssetMaintenance();
		switchIntoFrame(frameParent2Xpath);
		if (ClientName.contains("VMN")){
			clickUsingJSExecutor(SearchXpath,"Search Icon");
			clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");

			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitleField));
			//clickUsingJSExecutor(loc_VMN_PropertySearch, "Property Search");
			//clickUsingJSExecutor(loc_VMNSearchCritariaBox, "VMNSearchCritaria");
		}
		if (ClientName.contains("SKY")){
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetSearchUnderSearch, "AssetSearchUnderAsset");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}
		else {	
			clickUsingJSExecutor(SearchXpath, "Search Menu Icon");
			clickUsingJSExecutor(loc_AssetType_New.replace("@var", AssetSearch_Asset1), "Asset Under Asset Search");
			WaitForModalPanel();
			Thread.sleep(3000);
			switchIntoFrame(frameParent2Xpath);
			WaitForElementPresent(ByLocator(loc_AssetTitle));
		}
		Thread.sleep(2000);
		switchIntoFrame(frameParent2Xpath);
		sendKeys(loc_AssetTitle, CreatedSeriesAssetTitle, "AssetTitle", AssetTitle_Status);
		
		/* if (ClientName.contains("ASTRO")){
			 selectDropdownValue(loc_OwnerChannel_ASTRO, "OwnerChannel for ASTRO Client", "Malay", "");
		 }*/
		try {
			if((AssetType_And_AKA[0].toString().length()!=0)){
				selectDropdownValue(loc_AssetTypeDropDownAtAssetSearch, "AssetTypeDropDownAtAssetSearch", AssetType_And_AKA[0].toString(), "");
			}
		} catch (Exception e) {
			if (ClientName.contains("AMCN")){
				clickUsingJSExecutor(loc_AssetType_AllCheckBox, "All Check Box");
			} 
		}

		try {
			if((AssetType_And_AKA[1].toString().length()!=0)){
				clickUsingJSExecutor("//*[@id='chkAKA']", "AKA check Box");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (ClientName.contains("TURNER") || ClientName.contains("ASTRO")){
			/// Handling BUG ID: 20309
			ExecutionLog.Log("=====BUG ID======: 20309 >> AssetMaintenance.searchCreatedAsset()" );
			clickUsingJSExecutor(Loc_DisplaySeasoncheckBox, "DisplaySeasoncheckBox");
		}

		
		clickUsingJSExecutor(loc_FindButtonNow, "Find Button");
		Thread.sleep(6000);
		WaitForModalPanel();
		Thread.sleep(10000);
		switchIntoFrame(frameParent2Xpath);

		WaitForElementToClickable(loc_SearchedAsset);
		Thread.sleep(5000);
		moveMouse(loc_SearchedAsset, "First Asset in the Searched Asset");
		clickOn(loc_SearchedAsset, "First Asset in the Searched Asset");
		clickOn(loc_SearchedAsset, "First Asset in the Searched Asset");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_ViewAsset, "View Asset");
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(6000);
		verifyTextMatches(loc_CreatedAssetAtHome, "Created Asset At Home", CreatedSeriesAssetTitle, "title");
	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 */
	public void searchAndSelectStudio() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		if (!Vendor2_Status.contains("N/A")) {
			switchIntoFrame(frameParent2Xpath);
			clickUsingJSExecutor(loc_StudioImageIcon, "StudioImageIcon");
			driver.switchTo().window(driver.getWindowHandle());
			//WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
			//verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "Studio Window Header", StudioWindowHeaderName);
			if(!ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent4Xpath);
			} else {
				switchIntoFrame(frameParent3Xpath);
			}
			sendKeys(loc_IPAndVendorWindowfield, SearchvalueStudio, "Studio Name", Vendor2_Status);
			clickUsingJSExecutor(loc_FindButton, "Find Button");
			WaitForModalPanel();
			if(!ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent4Xpath);
			} else {
				switchIntoFrame(frameParent3Xpath);
			}
			Thread.sleep(5000);
			if(isElementPresent(loc_VendorNameAtVendorWindow)) {
				WaitForElementToClickable(loc_VendorNameAtVendorWindow);
				clickOn(loc_VendorNameAtVendorWindow, "VendorName At VendorWindow");
				clickUsingJSExecutor(loc_IPSelectButton, "Vendor Select Button");
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				verifyFieldValueOfHeader(loc_Studiofield, SearchvalueStudio, "Studio/Vendor2", SearchvalueStudio, "value");

			} else {
				driver.switchTo().window(driver.getWindowHandle());
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 
				if(!ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent4Xpath);
			} else {
				switchIntoFrame(frameParent3Xpath);
			}
				doubleClick(loc_EpisodeAdd,"Add Button at Vendor Add Window");
				if(!ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent5Xpath);
			} else {
				switchIntoFrame(frameParent3Xpath);
			}
				if(getAllSeletedOptions(loc_Contributor_PartyListType_DropDown, "PartyList").contains("(Select One)")){
					selectDropdownValue(loc_Contributor_PartyListType_DropDown, "Party Type", Vendor_PartyType, Vendor1_Status);
				}
				switchIntoFrame(frameParent4Xpath);
				sendKeys(loc_VendorAddWindow_PartyName, SearchvalueStudio, "Company Name", Vendor2_Status);

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
				clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
				WaitForModalPanel();
				if(!ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent5Xpath);
			} else {
			switchIntoFrame(frameParent4Xpath);
			}
				Thread.sleep(3000);
				verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);

				driver.switchTo().window(driver.getWindowHandle());
				clickOn(loc_Contributor_ContributorSearch_Add_CloseWindow,"close Add Reference Window");
				
				switchIntoFrame(frameParent4Xpath);
				sendKeys(loc_IPAndVendorWindowfield, SearchvalueStudio, "Studio Name", Vendor2_Status);
				clickUsingJSExecutor(loc_FindButton, "Find Button");
				
				WaitForElementToClickable(loc_VendorNameAtVendorWindow);
				clickOn(loc_VendorNameAtVendorWindow, "VendorName At VendorWindow");
				clickUsingJSExecutor(loc_IPSelectButton, "Vendor Select Button");
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				verifyFieldValueOfHeader(loc_Studiofield, SearchvalueStudio, "Studio/Vendor2", SearchvalueStudio, "value");
			
			}

		}

	}

	/**
	 * @author Rajuddin
	 * @param Methodname
	 * @param Vendor
	 * @throws Exception
	 */
	public void searchAndSelectVendor() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		if (!Vendor1_Status.contains("N/A")) {
			Assert.assertTrue(isElementPresent(loc_VendorImgIcon));
			clickUsingJSExecutor(loc_VendorImgIcon, "Vendor Img Icon");
			if(ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent3Xpath);
			} else {
				switchIntoFrame(frameParent4Xpath);
			}
			WaitForElementPresent(loc_IPAndVendorWindowfield);
			sendKeys(loc_IPAndVendorWindowfield, SearchvalueVendor, "SearchvalueVendor","");
			Thread.sleep(2000);
			clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind,"VendorWindowButtonfind");
			WaitForModalPanel();
			switchIntoFrame(frameParent3Xpath);
			Thread.sleep(3000);
			if(isElementPresent(loc_VendorNameAtVendorWindow)) {
				WaitForElementToClickable(loc_VendorNameAtVendorWindow);
				clickOn(loc_VendorNameAtVendorWindow, "VendorName At VendorWindow");
				clickUsingJSExecutor(loc_IPSelectButton, "Vendor Select Button");
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				verifyFieldValueOfHeader(loc_Vendorfield, SearchvalueVendor, "Vendor1", Vendor1_Status, "value");
				//Assert.assertTrue(getAttribute(loc_Vendorfield, "value").contains(SearchvalueVendor), "=====Failed===== Actual ["+ getAttribute(loc_Vendorfield, "value") + "] but Expected [" + SearchvalueVendor+ "]");;
			} else {
				driver.switchTo().window(driver.getWindowHandle());
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 
				switchIntoFrame(frameParent3Xpath);
				clickOn(loc_EpisodeAdd,"Add Button at Vendor Add Window");
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent4Xpath);
				} else {
					switchIntoFrame(frameParent5Xpath);
				}
				if(getAllSeletedOptions(loc_Contributor_PartyListType_DropDown, "PartyList").contains("(Select One)")){
					selectDropdownValue(loc_Contributor_PartyListType_DropDown, "Party Type", Vendor_PartyType, Vendor1_Status);
				}

				sendKeys(loc_VendorAddWindow_PartyName, SearchvalueVendor, "Company Name", Vendor1_Status);

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
				clickUsingJSExecutor(loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton, "'Save Button' Contributor_ContributorSearch_Add_SaveGeneralInfoButton");
				WaitForModalPanel();
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent4Xpath);
				} else {
					switchIntoFrame(frameParent5Xpath);
				}
				Thread.sleep(3000);
				verifyTextMatches(loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage, "Contributor_ContributorSearch_Add_SaveGeneralInfo_EnterAleternate_ValidationMessage", ContributorSearch_Add_Saved_ValidationMessage);

				driver.switchTo().window(driver.getWindowHandle());
				clickOn(loc_Contributor_ContributorSearch_Add_CloseWindow,"close Add Reference Window");
				// Select Vendor
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent3Xpath);
				} else {
					switchIntoFrame(frameParent4Xpath);
				}
				WaitForElementPresent(ByLocator(loc_IPAndVendorWindowfield));
				sendKeys(loc_IPAndVendorWindowfield, SearchvalueVendor, "SearchvalueVendor","");
				Thread.sleep(2000);
				clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind,"VendorWindowButtonfind");
				
				WaitForElementToClickable(loc_VendorNameAtVendorWindow);
				clickOn(loc_VendorNameAtVendorWindow, "VendorName At VendorWindow");
				clickUsingJSExecutor(loc_VendorNameAtVendorWindow, "VendorName At VendorWindow");

				clickUsingJSExecutor(loc_IPSelectButton, "Vendor Select Button");
				
				Thread.sleep(3000);
				switchIntoFrame(frameParent2Xpath);
				verifyFieldValueOfHeader(loc_Vendorfield, SearchvalueVendor, "Vendor1", Vendor1_Status, "value");

			}

		}

	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 *  Search and Select SBU
	 */
	public void searchAndSelectSBU() throws Exception {
		if (!(SBU_Status.contains("N/A"))) {
			if(!(SBUPickListIconAvailabilty_Status.contains("N/A"))) {
				clickUsingJSExecutor(loc_SBUImage, "SBUImage");
				driver.switchTo().window(driver.getWindowHandle());
				//WaitForElementPresent(loc_IPAndVendorAndStudioWindowHeader);
				//verifyTextMatches(loc_IPAndVendorAndStudioWindowHeader, "SBU Window/Owner Channel Header",SBUWindow_Status);
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent3Xpath);
				} else {
					switchIntoFrame(frameParent4Xpath);
				}
				WaitForElementToClickable(loc_SelectAllCheckBoxSBU);
				//clickUsingJSExecutor(loc_SelectAllCheckBoxSBU, "'Select All' CheckBox at SBU");
				Thread.sleep(6000);
				clickOn(loc_FirstCheckBoxAtSBU, "First CheckBox At SBU window");
				//clickOn(loc_NinthCheckBoxAtSBU, "Ninth CheckBox At SBU winodw");
				Thread.sleep(2000);
				clickUsingJSExecutor(Applybutton_AtSBUWindow, "Apply Button");
			} else {
				selectDropdownValue(loc_SBUField, "SBU", AssetCreationSourceBusinessUnit, SBU_Status);
			}
		}
	}
	
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description this method select the Genre Type in the Genre Type Drop down
	 * and Select Genre in Genre Drop down 
	 */
	public void AddGenreAndGenreType() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		if (!Genre_Legend.contains("N/A")) {
			clickUsingJSExecutor(loc_GenreAddbutton, "Genre Add Button", Genre_AddButton);
			WaitForElementToClickable(loc_GenreTypeRow, Genre_AddButton);
			clickUsingJSExecutor(getLocator_Genre("1",GenreNetworkTypeKey, GenreNetworkType), GenreNetworkType);
			clickOn(loc_GenreTypeRowImageDropdown, "Genere Type Dropdown Image", GenreNetworkType);
			clickOn(loc_FirstGenreTypeDropDownValue, "First Genere Type DropDown Value in the list", GenreNetworkType);
			
			clickUsingJSExecutor(getLocator_Genre("1",SubGenreKey, SubGenre), SubGenre);
			clickOn(loc_Genre, "Genere Dropdown Image", SubGenre);
			clickOn(loc_FirstGenreDropDownValue, "Genere Dropdown value", SubGenre);
			sleepTime(5);
		}

	}
	
	public String getLocator_Genre(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel ) {
		String locator = "";
		String classValue = getClassValue(loc_GenreHeader, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_GenreDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		
		return locator;
	}


	public String getClassValue(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_NWHeader = headerPath+"[@key='"+keyValue+"']";
			classValue =  getAttribute(loc_NWHeader, "class");
		} 
		return classValue;
	}
	
	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description this method select the IP in the IP Drop down
	 * and Select Genre in Genre Drop down 
	 */
	public void searchAndSelectIP() throws Exception {
		switchIntoFrame(frameParent2Xpath);
		if (!(IP_Status.contains("N/A"))) {
			WaitForElementToClickable(loc_IPImageIcon);
			clickUsingJSExecutor(loc_IPImageIcon, "IPImageIcon");
			if(ClientData.contains("AMCN")) {
				switchIntoFrame(frameParent3Xpath);
			} else {
				switchIntoFrame(frameParent4Xpath);
			}
			
			WaitForElementPresent(loc_IPAndVendorWindowfield);
			driver.findElement(By.id("txtName")).sendKeys(SearchvalueIP);
			clickUsingJSExecutor(loc_IPAndVendorWindowButtonfind, "Find Button");
			Thread.sleep(3000);
			if(isElementPresent(loc_IPName_AT_IPWindow)) {
				// Select the IP
				WaitForElementPresent(ByLocator(loc_IPName_AT_IPWindow));
				clickOn(loc_IPName_AT_IPWindow,"loc_IPName_AT_IPWindow");
				clickUsingJSExecutor(loc_IPSelectButton, "IP Select Button");
			} else {
				// Create the IP and select it
				driver.switchTo().window(driver.getWindowHandle());
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", ""); 
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent3Xpath);
				} else {
					switchIntoFrame(frameParent4Xpath);
				}
				clickOn(loc_EpisodeAdd,"Add Button at IP Window");
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent4Xpath);
				} else {
					switchIntoFrame(frameParent5Xpath);
				}sendKeys(Loc_Details_KeywordsInput, IPName, "IP at IP Window", IP_Status);
				clickOn(Loc_Details_KeywordsSave,"Save Button at IP Add Window");
				if(ClientData.contains("AMCN")) {
					switchIntoFrame(frameParent3Xpath);
				} else {
					switchIntoFrame(frameParent4Xpath);
				}
				clickOn(loc_IPName_AT_IPWindow,"loc_IPName_AT_IPWindow");
				clickUsingJSExecutor(loc_IPSelectButton, "IP Select Button");
			}

		}
		switchIntoFrame(frameParent2Xpath);
	}

	/**
	 * @author Rajuddin
	 * @throws Exception
	 * @description This method Add the Note with
	 * Priority, subject and Notes 
	 */
	public void AddNote() throws Exception {
		switchIntoFrame(frameParent2Xpath, Note_Status);
		clickUsingJSExecutor(loc_AddNote, "Add Button of Note", Note_AddButton);
		if(ClientData.contains("AMCN") || ClientData.contains("SKY")) {
			switchIntoFrame(frameParent3Xpath, Note_AddButton);
		} else {
			switchIntoFrame(frameParent4Xpath, Note_AddButton);
		}
		Thread.sleep(2000);
		sendKeys(loc_NotePriority, AssetPriority, "Asset Priority",NoteWindow_Priority);
		sendKeys(loc_NoteSubject, AssetSubject, "Asset Subject", NoteWindow_Subject);
		sendKeys(loc_NoteBody, AssetNotesTextField, "AssetNotes TextField", NoteWindow_Note);
		clickOn(OKButton, "OK button", NoteWindow_OKButton);
		Thread.sleep(2000);
	}

	/**
	 * 
	 * @param CreatedSeriesAssetTitle
	 * @param NumberOfSeason_NumberOfEpisode
	 * If Number of Season  = 2 and No. of Episode = 3
	 * This method will create 3 Episodes in each season
	 *  
	 * @throws Exception
	 */
	public void AddingEpisodeToAssetWithoutPremdt(String CreatedSeriesAssetTitle, Object... NumberOfSeason_NumberOfEpisode) throws Exception{
		AssetMaintenance assetMaintenance = new AssetMaintenance();
		int Number_Of_Season = 0;
		int Number_Of_Episodes = 0;
		//Adding Episodes	
		assetMaintenance.selectAsset(CreatedSeriesAssetTitle);
		
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		// Add 2 seasons each having 2 Episodes (if No of Seasons and Episodes are not passed)
		try {
			Number_Of_Season =Integer.parseInt(NumberOfSeason_NumberOfEpisode[0].toString());
			Number_Of_Episodes = Integer.parseInt(NumberOfSeason_NumberOfEpisode[1].toString());
		} catch (IndexOutOfBoundsException e) {
			Number_Of_Season = 2;
			Number_Of_Episodes = 2;
		}
		// Requirement
		// create given no of Season
		// Add given no of Episodes in each season
		int rowNumber =1;
		
		int EpisodeNumber =101;
		for( int  seasons = 1; seasons<= Number_Of_Season; seasons++) {
			String SeasonName = "";
			int temp = EpisodeNumber;
			if(ClientData.contains("VMN") || ClientData.contains("SALESDEMO") || ClientData.contains("CORUS")) {
				SeasonName ="Season " + seasons + ".Original Version";
			} else {
				SeasonName ="Season " + seasons;
			}
			for( int  episodes = 1; episodes<=Number_Of_Episodes; episodes++ ) {

				clickUsingJSExecutor(loc_Episodes_Add, "'Add' Button at Episode window",Episodes_Add);
				WaitForModalPanel();		
				driver.switchTo().window(driver.getWindowHandle());
				sendKeys(loc_EpisodeAddWindow,temp+"","Add Episode input field",Episodes_Add);
				clickUsingJSExecutor(loc_Episodes_OKButton_AddEpisodesWindow, "'OK' Button at Episode window");
				WaitForModalPanel();	
				Thread.sleep(5000);

				switchIntoFrame(frameParent3Xpath);
				clickUsingJSExecutor(loc_SeasonField_OF_RowNumber.replace("@var", rowNumber+""), "Season Field of Episode101");
				clickOn(loc_EpisodeEditWindow_DropDownimage, "Image Drop Down at 'Episode Edit Window'");
				clickOn(loc_SelectSeason.replace("@var", SeasonName), Season1);			
				clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select season");
				// TODO SKY  : Delete these lines
				String loc = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[" + rowNumber + "]/td[26]";
				sendKeys(loc, "00:30:00", "duration Program", "");
				rowNumber++;
				temp++;
			}

			EpisodeNumber = EpisodeNumber + 100;

		}

		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
	}
	
	/**
	 * Search Asset >> Click Episodes >> Edit Button >> Select respective Episode >> Copy Season >>Select respective Media
	 *  >>OK >> Save >> Close Edit Episode Window
	 * @param CreatedSeriesAssetTitle
	 * @param SelectEpisodeOfSeason
	 * @param VersionName
	 * @throws Exception
	 */
	public void copySeasonWithDifferentVersion(String CreatedSeriesAssetTitle, String SelectEpisodeOfSeason, String VersionName) throws Exception{
		AssetMaintenance assetMaintenance = new AssetMaintenance();
		
		assetMaintenance.searchCreatedAsset(CreatedSeriesAssetTitle);
		
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Episode window");
		Thread.sleep(3000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		//Clear Filter
		doubleClick(loc_RI_MediaRights_ClearFiltersButton, "Clear Filter");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		
		
		String Episode[] = SelectEpisodeOfSeason.split(" ");
		String EpisodeNameWithourColon = Episode[1];
		clickOn(loc_Episodes_SelectRow_Of_Episodes.replace("@var", EpisodeNameWithourColon), "Row of " + EpisodeNameWithourColon);
		clickOn(loc_Episodes_CopySeason, "Copy Season");
		switchIntoFrame(frameParent4Xpath);
		WaitForElementPresent(ByLocator(loc_OkButton));
		ExecutionLog.Log("*****Select the Rights Version type \"" + VersionName + "\" and press OK. ******");
		clickOn(loc_Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton, "Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton", CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton);
		selectDropdownValue(loc_Episodes_CopyEpisodes_CopyAssetWindow_Versionselector, "Episodes_CopyEpisodes_CopyAssetWindow_Versionselector", VersionName, Episodes_CopyEpisodes_CopyAssetWindow_Versionselector);
		clickUsingJSExecutor(OKButton, "OKButton", CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton);
		Thread.sleep(5000);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		

		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Save, "Save Button at 'Episode Edit Window'");	
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementToClickable(loc_Episodes_Save);
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Episodes_Close, "Close Button at 'Episode Edit Window'");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
	}
	
	public void enterInitialAirDate_EpisodeTAB(String RowNumber, String Date) throws Exception{
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_Episode_Pass_RowAndColumnNumber.replace("@row", RowNumber).replace("@col", "10"), "Initial Air Date", Episode_AirDateValue);
		sendKeys(loc_Episodes_InitialAirDate_InputField, Date, "Episodes_InitialAirDate_InputField in row" + RowNumber, Episode_AirDateValue);
		clickOn(loc_Episodes_FirstRow_EpisodesEditWindow, "Support click to select Initial Air Date");
		Thread.sleep(3000);
	}

}



















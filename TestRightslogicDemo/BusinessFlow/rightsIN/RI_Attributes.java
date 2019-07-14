package rightsIN;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.ListMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_Attributes extends MultiClient_SupportingFunctions{	
	
	
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
	List<String> allAttributes = new ArrayList<String>();
	ListMaintenance listMaintenance = new ListMaintenance();
	
	
	String Attributes1_FilmLocation = "AUT_Attributes_Film location" +formattedDate+"";
	String Attributes2_Media 	= "AUT_Attributes_Media_" +formattedDate+"";
	String Attributes3_NUMERIC 	= "AUT_Attributes_ NUMERIC 1_" +formattedDate+"";
	String Attributes4_NUMERIC 	= "AUT_Attributes_NUMERIC 2_" +formattedDate+"";
	String Attributes5_CURRENCY = "AUT_Attributes_CURRENCY 1_" +formattedDate+"";
	String Attributes6_CURRENCY = "AUT_Attributes_CURRENCY 2_" +formattedDate+"";
	String Attributes7_RANGE 	= "AUT_Attributes_RANGE 1_" +formattedDate+"";
	String Attributes8_RANGE 	= "AUT_Attributes_RANGE 2_" +formattedDate+"";
	String Attributes9_RANGE 	= "AUT_Attributes_RANGE 3_" +formattedDate+"";	
	String Attributes10_RANGE 	= "AUT_Attributes_RANGE 4_" +formattedDate+"";
	String Attributes11_RANGE 	= "AUT_Attributes_RANGE 5_" +formattedDate+"";
	String Attributes12_RANGE 	= "AUT_Attributes_RANGE 6_" +formattedDate+"";
	String Attributes13_RANGE 	= "AUT_Attributes_RANGE 7_" +formattedDate+""; 
	String Attributes14_List 	= "AUT_Attributes_List_" +formattedDate+"";	
	String Attributes15_Date 	= "AUT_Attributes_Date1_" +formattedDate+"";
	public RI_Attributes() {
		super(loc_RI_Attributes_ColumnXpath_EditMode, loc_RI_Attributes_DataRowXpath_EditMode, 
				loc_RI_Attributes_ColumnXpath_ViewMode, loc_RI_Attributes_DataRowXpath_ViewMode);
		className = this.getClass().getName();
	}
	@Test(priority =1,enabled= true,description = "Create Pre-requisites")
	public void TC1_AttributesPrerequisites() throws Exception {
		System.out.println("*********************Start Testcase - TC1_AttributesPrerequisites *********************");
		
		assetMaintenance.createProgramAsset(CreatedSeriesAssetTitle1,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(CreatedSeriesAssetTitle1);
		rightIN.createDeal(CreatedDeal1);
		rightIN.associateAssetWithDeal(CreatedDeal1, CreatedSeriesAssetTitle1);
	
		allAttributes.add(Attributes1_FilmLocation);
		allAttributes.add(Attributes2_Media);
		allAttributes.add(Attributes3_NUMERIC);
		allAttributes.add(Attributes4_NUMERIC);
		allAttributes.add(Attributes5_CURRENCY);
		allAttributes.add(Attributes6_CURRENCY);
		allAttributes.add(Attributes7_RANGE);
		allAttributes.add(Attributes8_RANGE);
		allAttributes.add(Attributes9_RANGE);
		allAttributes.add(Attributes10_RANGE);
		allAttributes.add(Attributes11_RANGE);
		allAttributes.add(Attributes12_RANGE);
		allAttributes.add(Attributes13_RANGE);
		allAttributes.add(Attributes14_List);
		allAttributes.add(Attributes15_Date);

		String ModuleName = "Rights In";
		
		switchIntoFrame(frameParent1Xpath);
		WaitForElementToClickable(By.xpath(ModulesXpath));
		clickOn(AdministrationXpath,"Administration");
		Thread.sleep(6000);
		WaitForElementToClickable(By.xpath(ListMaintenanceXpath));
		clickOn(ListMaintenanceXpath,"ListMaintenance");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Maintain"), "Link at Menu");
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Custom Attributes"), "'Custom Attributes' Link under Maintain Menu Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		WaitForElementPresent(ByLocator(loc_NewButton_CustomAttribute_ListMaintenance));
		
		
		
		
		listMaintenance.createCustomAttribute(ModuleName, Attributes1_FilmLocation, "Text only", "Text", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes2_Media, "Text only", "AlphaNumeric", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes3_NUMERIC, "Numeric", "Number", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes4_NUMERIC, "Numeric", "Decimal", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes5_CURRENCY, "Currency", "$$$$$", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes6_CURRENCY, "Currency", "$$$$$.cc", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes7_RANGE, "Range", "AlphaNumeric", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes8_RANGE, "Range", "Number", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes9_RANGE, "Range", "Decimal", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes10_RANGE, "Range", "$$$$$", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes11_RANGE, "Range", "$$$$$.cc", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes12_RANGE, "Range", "No Format", "N/A"); 
		listMaintenance.createCustomAttribute(ModuleName, Attributes13_RANGE, "Range", "Text", "N/A");
		listMaintenance.createCustomAttribute(ModuleName, Attributes14_List, "List", "No Format", "Volume 1,Volume 2,Volume 3,Volume 4,Volume 5,Volume 6,Volume 7,Volume 8,Volume 9,Volume 10,Special");
		listMaintenance.createCustomAttribute(ModuleName, Attributes15_Date, "Date", "Custom", "N/A");
		System.out.println("*********************End Testcase - TC1_AttributesPrerequisites *********************");
	}
	@Test(priority =2,enabled= true,description = "Verify UI elements/Attriutes of Attribute TAB")
	public void TC2_AttributeUI() throws Exception {
		
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		scrollElementIntoView(loc_Tab.replace("@var", "Obligations"));
		Thread.sleep(5000);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		switchIntoChildFrame(frameParent21Xpath);
		ExecutionLog.Log("*****Verify Headers of Attribute TAB in View mode*****");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesAppliesToKey+"']", "AM_AppliesTo Header", RI_AttributesAppliesTo,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesAttributeKey+"']", "AM_Attributes Header", RI_AttributesAttribute,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesValue1Key+"']", "AttributesValue1", RI_AttributesValue1,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesValue2Key+"']", "AttributesValue2", RI_AttributesValue2,"innerHTML");
		
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		ExecutionLog.Log("*****Verify Headers of Attribute TAB in Edit mode*****");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesAppliesToKey+"']", "AM_AppliesTo Header", RI_AttributesAppliesToView,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesAttributeKey+"']", "AM_Attributes Header", RI_AttributesAttributeView,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+RI_AttributesValue1Key+"']", "AttributesValue1", RI_AttributesValue1,"innerHTML");
		

		ExecutionLog.Log("*****Verify Button available in Edit mode*****");
		verifyTextMatches(loc_Save, "Save button", "Save","value");
		verifyTextMatches(loc_Cancel, "Cancel button", "Cancel","value");
		verifyTextMatches(Loc_DeleteButton1, "Delete button", "Delete","value");
		verifyTextMatches(Loc_NewButton, "Add button", "Add","value");
		
		clickUsingJSExecutor(Loc_NewButton, "Add button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(Loc_NewButton);
		//Save 
		clickUsingJSExecutor(loc_Save, "Save");
//		WaitForModalPanel();
//		switchIntoFrame(frameParent3Xpath);
//		WaitForElementPresent(Loc_NewButton);
//		WaitForElementPresent(LocErrorMgs);
//		Thread.sleep(2000);
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyTextMatches(AlertValidationMessgeText, "Error Msg",RI_AttributesErrorMsg );
		clickUsingJSExecutor(OKAlertButtonXpath, "Ok Button Alert");
		switchIntoFrame(frameParent3Xpath);	
		WaitForElementPresent(Loc_NewButton);
	
		//Applies/Property To Pick List
		clickOn(getLocator_EditTAB_DataRow("1", RI_AttributesAppliesToKey, RI_AttributesAppliesTo)+"/img", "Applies to Pick List", RI_AttributesAppliesTo);
		rightIN.appliesTOPopUpWindow("TC_RI_OpT_002 To TC_RI_OpT_016 ", CreatedSeriesAssetTitle1);
		switchIntoFrame(frameParent3Xpath);
		Thread.sleep(3000);
		//Attributes
		clickOn(getLocator_EditTAB_DataRow("1", RI_AttributesAttributeKey, RI_AttributesAttribute), "Attribute ", RI_AttributesAttribute);
		sendKeys(loc_RI_AttributesInput, Attributes1_FilmLocation, "Attributes Input", RI_AttributesAttribute);
		Enter();
		//Attributes Replace 
		clickOn(getLocator_EditTAB_DataRow("1", RI_AttributesAttributeKey, RI_AttributesAttribute), "Attribute ", RI_AttributesAttribute);
		sendKeys(loc_RI_AttributesInput, Attributes8_RANGE, "Attributes Input", RI_AttributesAttribute);
		Enter();
		//verifyText
		Thread.sleep(5000);
		verifyTextMatches(getLocator_EditTAB_DataRow("1", RI_AttributesAttributeKey, RI_AttributesAttribute), "Attributes Value Verify", RI_AttributesAttribute);
		//Value1
		clickOn(getLocator_EditTAB_DataRow("1", RI_AttributesValue1Key, RI_AttributesValue1), "Value 1 ", RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, RI_AttributesValueData, "Value Input", RI_AttributesValue1);
		Enter();
		//TC_RI_AT_032
		//save
		clickUsingJSExecutor(loc_Save, "Save");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", RI_AttributesAppliesToKey, RI_AttributesAppliesTo), "All", "AllplesTo View Mode", RI_AttributesAppliesTo, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", RI_AttributesAttributeKey, RI_AttributesAttribute), "All", "Attribute View Mode", RI_AttributesAttribute, "innerHTML");
		verifyFieldValueOfHeader(getLocator_ViewTAB_DataRow("1", RI_AttributesValue1Key, RI_AttributesValue1), "All", "Attribute View Mode", RI_AttributesValue1, "innerHTML");
	
		
	}
	@Test(priority =3,enabled= true,description = "[FilmLocation Attribute >>  DataType: TextOnly, Format :Text]")
	public void TC3_EnterDataInDifferentAttribute() throws Exception {
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));
		
		//Attributes1_FilmLocation
		enterInvalidDataForValue1_VerifyAlertMessage("3423423", Attributes1_FilmLocation,RI_Attribute_ValidationMessage_EnteringInvalidData);
		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423ab", Attributes1_FilmLocation,RI_Attribute_ValidationMessage_EnteringInvalidData);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("RSGab#$%^*%#$",Attributes1_FilmLocation);
		
		
		
		//Attributes2_Media
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("10.1",Attributes2_Media);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("RSG3423423ab",Attributes2_Media);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("RSGab#$%^*%#$",Attributes2_Media);
		
		//Attributes3_NUMERIC
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("RSG3423423", Attributes3_NUMERIC,RI_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("RSGab#$%^*%#$", Attributes3_NUMERIC,RI_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("10.32", Attributes3_NUMERIC,RI_Attribute_ValidationMessage_EnterValidNumericValue);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("342342",Attributes3_NUMERIC);

		
		//Attributes4_NUMERIC
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("RSG3423423", Attributes4_NUMERIC,RI_Attribute_ValidationMessage_EnterDecimalValue);
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("RSGab#$%^*%#$", Attributes4_NUMERIC,RI_Attribute_ValidationMessage_EnterDecimalValue);
		enterInvalidDataForValue1_WithSaveVerifyAlertMessage("10003", Attributes4_NUMERIC,RI_Attribute_ValidationMessage_EnterDecimalValue);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("342342.33",Attributes4_NUMERIC);
		
		//Attributes5_CURRENCY
		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes5_CURRENCY,RI_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes5_CURRENCY,RI_Attribute_ValidationMessage_EnterValidNumericValue);
    	enterInvalidDataForValue1_VerifyAlertMessage("10.32", Attributes5_CURRENCY,RI_Attribute_ValidationMessage_EnterNonValidDecimalValue);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("342342",Attributes5_CURRENCY);

		
		//Attributes6_CURRENCY
		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes6_CURRENCY,RI_Attribute_ValidationMessage_EnterValidDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes6_CURRENCY,RI_Attribute_ValidationMessage_EnterValidDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("10003", Attributes6_CURRENCY,RI_Attribute_ValidationMessage_EnterDecimalValue);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("342342.33",Attributes6_CURRENCY);
		if(ClientName.contains("VMN")){
		//Attributes7_RANGE
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes7_RANGE, RI_Attribute_ValidationMessage_EnterRangeValues);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("12RSGab#$%^*%#$", Attributes7_RANGE);
		enterDataInValue2_And_VerifyIn_Edit_ViewMode("12RSGab#$%^*%#$", Attributes7_RANGE);
		
		//Attributes8_RANGE
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterOnlyNumber);		
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterOnlyNumber);		
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterOnlyNumber);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterRangeValues);		
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterRangeValues);		
		// Manual Test Step : TC_AM_AT_114
		enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes8_RANGE, RI_Attribute_ValidationMessage_EnterOnlyNumber);

		// Enter "1024" in value1
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", Attributes8_RANGE), "Value1 of " + Attributes8_RANGE,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, "1024", "RI_AttributeValue1_InputField", RI_AttributesValue1);
		clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes8_RANGE+"']", "Select Attribute " + Attributes8_RANGE, RI_AttributesValue1);
		ExecutionLog.Log("");
		// Verify data f VAlu1 in Edit Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes8_RANGE), "1024", " Value1 Field of Attribute " + Attributes8_RANGE + " in Edit Mode", RI_AttributesValue1);

		enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024", Attributes8_RANGE);
		// Verify the data in view Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes8_RANGE), "1024", "Value1 Field of Attribute " + Attributes8_RANGE + " in View Mode", RI_AttributesValue1);
		
		//Attributes9_RANGE
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
		enterInvalidDataForValue2_VerifyAlertMessage("1024", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterDecimalValue);	

		// Enter "1024.33" in value1 and verify in Edit Mode
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", Attributes9_RANGE), "Value1 of " + Attributes9_RANGE,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, "1024.33", "loc_RI_AttributesValue1Input", RI_AttributesValue1);
		clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes9_RANGE+"']", "Select Attribute " + Attributes9_RANGE, RI_AttributesValue1);
		ExecutionLog.Log("");
		// Verify data f Value1 in Edit Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes9_RANGE), "1024", " Value1 Field of Attribute " + Attributes9_RANGE + " in Edit Mode", RI_AttributesValue1);

		enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024.33", Attributes9_RANGE);
		// Verify the data in view Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes9_RANGE), "1024", "Value1 Field of Attribute " + Attributes9_RANGE + " in View Mode", RI_AttributesValue1);
		
		//Attributes10_RANGE
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	

		// Enter "1024" in value1
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", Attributes10_RANGE), "Value1 of " + Attributes8_RANGE,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, "1024", "loc_RI_AttributesValue1Input", RI_AttributesValue1);
		clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes10_RANGE+"']", "Select Attribute " + Attributes10_RANGE, RI_AttributesValue1);
		ExecutionLog.Log("");
		// Verify data f VAlu1 in Edit Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes10_RANGE), "1024", " Value1 Field of Attribute " + Attributes10_RANGE + " in Edit Mode", RI_AttributesValue1);

		enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024", Attributes10_RANGE);
		// Verify the data in view Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes10_RANGE), "1024", "Value1 Field of Attribute " + Attributes10_RANGE + " in View Mode", RI_AttributesValue1);
		
		//Attributes11_RANGE
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		enterInvalidDataForValue2_VerifyAlertMessage("1024", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterDecimalValue);

		// Enter "1024.33" in value1
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", Attributes11_RANGE), "Value1 of " + Attributes8_RANGE,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, "1024.33", "loc_RI_AttributesValue1Input", RI_AttributesValue1);
		clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes11_RANGE+"']", "Select Attribute " + Attributes11_RANGE, RI_AttributesValue1);
		ExecutionLog.Log("");
		// Verify data f VAlu1 in Edit Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes11_RANGE), "1024.33", " Value1 Field of Attribute " + Attributes11_RANGE + " in Edit Mode", RI_AttributesValue1);
		// This step was not found in Manual Step but we had to add it to save the details successfully
		enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024.33", Attributes11_RANGE);
		// Verify the data in view Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes11_RANGE), "1024.33", "Value1 Field of Attribute " + Attributes11_RANGE + " in View Mode", RI_AttributesValue1);
		
		
		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	

		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	

		enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);


		enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
		enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);		
		enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
		enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		enterInvalidDataForValue2_VerifyAlertMessage("", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);

		// Enter "RSG" in value1
		switchIntoFrame(frameParent3Xpath,AM_AttributesValue2Value);
		clickOn(loc_RI_AttributesValue1.replace("@var", Attributes13_RANGE), "Value1 of " + Attributes8_RANGE,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, "RSG", "loc_RI_AttributesValue1Input", RI_AttributesValue1);
		clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes13_RANGE+"']", "Select Attribute " + Attributes13_RANGE, RI_AttributesValue1);
		ExecutionLog.Log("");
		// Verify data of Value1 in Edit Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes13_RANGE), "RSG", " Value1 Field of Attribute " + Attributes13_RANGE + " in Edit Mode", RI_AttributesValue1);
		// This step was not found in Manual Step but we had to add it to save the details successfully
		enterDataInValue2_And_VerifyIn_Edit_ViewMode("RSG", Attributes13_RANGE);
		// Verify the data in view Mode
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", Attributes13_RANGE), "RSG", "Value1 Field of Attribute " + Attributes13_RANGE + " in View Mode", RI_AttributesValue1);
		
		}
					
		//Attributes14_List
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("Volume 1", Attributes14_List);
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("Volume 2", Attributes14_List);


		//Attributes15_Date
		enterValidDataInValue1_And_VerifyIn_Edit_ViewMode("12/23/2014", Attributes15_Date);
		enterInvalidDataForValue1_VerifyAlertMessage("23/12/2014", Attributes15_Date, AM_Attribute_ValidationMessage_InCorrectDateFormat);
		enterInvalidDataForValue1_VerifyAlertMessage("23/12/20144", Attributes15_Date, AM_Attribute_ValidationMessage_InCorrectDateFormat);
		
	}
	@Test(priority =4,enabled= true)
	public void TC4_DeleteAttributes() throws Exception {
		//Search Deal
		rightIN.searchCreatedDeal(CreatedDeal1);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));
		
		
		// Clear the Value1 and value2 of all Attributes
		for(String attribute : allAttributes) {

			switchIntoFrame(frameParent2Xpath,RI_AttributesValue1);
			switchIntoChildFrame(frameParent21Xpath,RI_AttributesValue1);
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			if(isElementPresent(AM_AttributesRowXpath+"/td[@title='"+attribute+"']")) {
				// Delete the data of value1 field
				clickOn(AM_Attributes_Value1.replace("@var", attribute), "Value1 of " + attribute,RI_AttributesValue1);
				sendKeys(loc_RI_AttributesValue1Input, Keys.DELETE+"", "loc_RI_AttributesValue1Input", RI_AttributesValue1);
				clickOn(AM_AttributesRowXpath+"/td[@title='"+attribute+"']", "Select Attribute " + attribute, RI_AttributesValue1);
				
				WaitForModalPanel();
				ExecutionLog.Log("");
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_AttributesValue1);
				switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);

				//Only Range Type Attribute is allowed to enter the data in value2 field 
				if(attribute.contains("RANGE")) {
					// Delete the data of value2 field
					clickOn(AM_Attributes_Value2.replace("@var", attribute), "Value2 of " + attribute, RI_AttributesValue2);
					sendKeys(AM_AttributeValue2_InputField, Keys.DELETE+"", "AM_AttributeValue2_InputField", RI_AttributesValue2);
					WaitForModalPanel();
					ExecutionLog.Log("");
					clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_AttributesValue2);
					switchIntoFrame(frameParent3Xpath,RI_AttributesValue2);
					// Save the changes
					clickOn(AM_AttributesRowXpath+"/td[@title='"+attribute+"']", "Select Attribute " + attribute, RI_AttributesValue2);
					ExecutionLog.Log("");
					switchIntoFrame(frameParent3Xpath);
				}

				clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",RI_AttributesValue1);	
				WaitForModalPanel();
				ExecutionLog.Log("");
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_AttributesValue1);

			}

		}

		// Navigate to List Maintenance 
		switchIntoFrame(frameParent1Xpath);
		WaitForElementToClickable(By.xpath(ModulesXpath));
		clickOn(AdministrationXpath,"Administration");
		Thread.sleep(6000);
		WaitForElementToClickable(By.xpath(ListMaintenanceXpath));
		clickOn(ListMaintenanceXpath,"ListMaintenance");
		Thread.sleep(6000);
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Maintain"), "Link at Menu");
		clickUsingJSExecutor(loc_PageLink.replace("@var", "Custom Attributes"), "'Custom Attributes' Link under Maintain Menu Link");
		WaitForModalPanel();

		for(String attribute : allAttributes) {
			switchIntoFrame(frameParent2Xpath);
			// Delete the Attribute
			scrollElementIntoView(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", attribute));
			clickOn(loc_CustomAttribute_ListMaintenance_AttributeRow_AfterSave.replace("@var", attribute),"Select Attribute " + attribute);
			clickOn(loc_DeleteButton,"click on Delete Button");
			WaitForModalPanel();
			clickUsingJSExecutor(ConfirmAlertButtonXpath, "OK Button at Confirm Alert");
			WaitForModalPanel();
		}
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_SaveButton_CustomAttribute_ListMaintenance, "Save Button to Delete Attribute");
		WaitForModalPanel();
	}

	public void enterInvalidDataForValue1_VerifyAlertMessage(String TestData, String AttributeName, String ValidationMessage) throws Exception {

		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", AttributeName), "Value1 of " + AttributeName,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, TestData, "RI_AttributeValue1_InputField", RI_AttributesValue1);
		Thread.sleep(2000);
		Enter();
//		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", AttributeName), TestData, " Value1 Field of Attribute " + AttributeName + " in Edit Mode", RI_AttributesValue1);
//		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",RI_AttributesValue1);		
//		WaitForModalPanel();
//		ExecutionLog.Log("");
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyFieldValueOfHeader(AlertValidationMessgeText, ValidationMessage, "Alert Message on Entering Invalid Data for Attribute Value", RI_AttributesValue1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_AttributesValue1);
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
	}
	public void enterInvalidDataForValue1_WithSaveVerifyAlertMessage(String TestData, String AttributeName, String ValidationMessage) throws Exception {

		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", AttributeName), "Value1 of " + AttributeName,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, TestData, "RI_AttributeValue1_InputField", RI_AttributesValue1);
		Thread.sleep(2000);
		Enter();
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", AttributeName), TestData, " Value1 Field of Attribute " + AttributeName + " in Edit Mode", RI_AttributesValue1);
		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",RI_AttributesValue1);		
		driver.switchTo().window(driver.getWindowHandle()); 
		verifyFieldValueOfHeader(AlertValidationMessgeText, ValidationMessage, "Alert Message on Entering Invalid Data for Attribute Value", RI_AttributesValue1);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", RI_AttributesValue1);
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
	}
	public void enterValidDataInValue1_And_VerifyIn_Edit_ViewMode(String TestData, String AttributeName) throws Exception {
		switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
		clickOn(loc_RI_AttributesValue1.replace("@var", AttributeName), "Value1 of " + AttributeName,RI_AttributesValue1);
		sendKeys(loc_RI_AttributesValue1Input, TestData, "RI_AttributeValue1_InputField", RI_AttributesValue1);
		Enter();
		Thread.sleep(1000);
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", AttributeName), TestData, " Value1 Field of Attribute " + AttributeName + " in Edit Mode", RI_AttributesValue1);
		//Save
		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",RI_AttributesValue1);	
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath,RI_AttributesValue1);
		switchIntoChildFrame(frameParent21Xpath,RI_AttributesValue1);
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", AttributeName), TestData, "Value1 Field of Attribute " + AttributeName + " in View Mode", RI_AttributesValue1);

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));
	}
	public void enterInvalidDataForValue2_VerifyAlertMessage(String TestData, String AttributeName, String ValidationMessage) throws Exception {

		switchIntoFrame(frameParent3Xpath,AM_AttributesValue2Value);
		clickOn(AM_Attributes_Value2.replace("@var", AttributeName), "Value2 of " + AttributeName,AM_AttributesValue2Value);
		sendKeys(AM_AttributeValue2_InputField, TestData, "AM_AttributeValue2_InputField", AM_AttributesValue2Value);
		Thread.sleep(3000);
		clickOn(AM_Attributes_Field.replace("@var", AttributeName), AttributeName,AM_AttributesValue2Value);

		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",AM_AttributesValue2Value);		
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, ValidationMessage, "Alert Message on Entering the Data for Attribute's Value2", AM_AttributesValue2Value);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", AM_AttributesValue2Value);
		switchIntoFrame(frameParent3Xpath,AM_AttributesValue2Value);
	}
	
	public void enterDataInValue2_And_VerifyIn_Edit_ViewMode(String TestData, String AttributeName) throws Exception {

		// Check whether the Value2 field exists or not
		// Most of the clients does not has Value2 fields
		// Hence applying the condition to ignore scenario. 
		if(!AM_AttributesValue2Value.contains("N/A")) {			
			switchIntoFrame(frameParent3Xpath,RI_AttributesValue1);
			clickOn(AM_Attributes_Value2.replace("@var", AttributeName), "Value2 of " + AttributeName, AM_AttributesValue2Value);
			sendKeys(AM_AttributeValue2_InputField, TestData, "AM_AttributeValue2_InputField", AM_AttributesValue2Value);

			clickOn(AM_AttributesRowXpath+"/td[@title='"+AttributeName+"']", "Select Attribute " + AttributeName, AM_AttributesValue2Value);
			ExecutionLog.Log("");
			verifyFieldValueOfHeader(loc_RI_AttributesValue1.replace("@var", AttributeName), TestData.toString(), " Value2 Field of Attribute " + AttributeName + " in Edit Mode", AM_AttributesValue2Value);

			clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",RI_AttributesValue1);	
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath,RI_AttributesValue1);
			switchIntoChildFrame(frameParent21Xpath,RI_AttributesValue1);
			ExecutionLog.Log("");
			verifyFieldValueOfHeader(AM_Attributes_Value2.replace("@var", AttributeName), TestData, "Value2 Field of Attribute " + AttributeName + " in View Mode", AM_AttributesValue2Value);

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));
		}
	}
	

}

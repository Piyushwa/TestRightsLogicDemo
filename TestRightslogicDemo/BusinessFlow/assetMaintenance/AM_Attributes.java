package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.DriverHelper;
import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.ListMaintenance;


// This TAB is not For VMN
@Listeners(utility.ListenerClass.class)
public class AM_Attributes extends DriverHelper implements IAM_Attributes{

	public AM_Attributes() {
		super(AM_AttributesColumnXpath, AM_AttributesRowXpath, AM_AttributesColumnXpath, AM_AttributesRowXpath);
		className = this.getClass().getName();
		classObject = this.getClass();	
	}

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	String createdSeriesAssetTitle = "AUT_AssetSeries_Attri_" +formattedDate+"";

	AssetMaintenance assetMaintenance = new AssetMaintenance();
	ListMaintenance listMaintenance = new ListMaintenance();
	List<String> allAttributes = new ArrayList<String>();

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
	String Attributes13_RANGE 	= "AUT_Attributes_RANGE 7_" +formattedDate+""; // Not in manual Test Case
	String Attributes14_List 	= "AUT_Attributes_List_" +formattedDate+"";	
	String Attributes15_Date 	= "AUT_Attributes_Date1_" +formattedDate+"";
	String ModuleName = "Asset Maintenance";


	@BeforeTest
	public void runStatus() {
		if(ClientData.equals("TURNER") || ClientData.equals("VMN")) {
			throw new SkipException("Script of \"Attribute TAB\" is Not runnable for " + ClientData);
		} 
	}

	/**
	 * @description : Go To List Maintenance and Created Custom Attributes
	 * @throws Exception
	 */
	@Test(priority =1,enabled= true,description = "Create Pre-requisites")
	public void createCustomAttributes_Prerequisites() throws Exception {

		allAttributes.add(Attributes1_FilmLocation);
		allAttributes.add(Attributes2_Media);
		allAttributes.add(Attributes3_NUMERIC);
		allAttributes.add(Attributes4_NUMERIC);
		allAttributes.add(Attributes5_CURRENCY);
		allAttributes.add(Attributes6_CURRENCY);
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			allAttributes.add(Attributes7_RANGE);
			allAttributes.add(Attributes8_RANGE);
			allAttributes.add(Attributes9_RANGE);
			allAttributes.add(Attributes10_RANGE);
			allAttributes.add(Attributes11_RANGE);
			allAttributes.add(Attributes12_RANGE);
			allAttributes.add(Attributes13_RANGE);
		}
		allAttributes.add(Attributes14_List);
		allAttributes.add(Attributes15_Date);
		if(ClientData.contains("SKY")) {
			ModuleName = "Title Maintenance";
		}

		switchIntoFrame(frameParent1Xpath);
		WaitForElementToClickable(ModulesXpath);
		clickOn(AdministrationXpath,"Administration");
		Thread.sleep(6000);
		WaitForElementToClickable(ListMaintenanceXpath);
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

		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			listMaintenance.createCustomAttribute(ModuleName, Attributes7_RANGE, "Range", "AlphaNumeric", "N/A");
			listMaintenance.createCustomAttribute(ModuleName, Attributes8_RANGE, "Range", "Number", "N/A");
			listMaintenance.createCustomAttribute(ModuleName, Attributes9_RANGE, "Range", "Decimal", "N/A");
			listMaintenance.createCustomAttribute(ModuleName, Attributes10_RANGE, "Range", "$$$$$", "N/A");
			listMaintenance.createCustomAttribute(ModuleName, Attributes11_RANGE, "Range", "$$$$$.cc", "N/A");
			listMaintenance.createCustomAttribute(ModuleName, Attributes12_RANGE, "Range", "No Format", "N/A"); // This is not required as per Manual TC but Adding as It was Already autoamted
			listMaintenance.createCustomAttribute(ModuleName, Attributes13_RANGE, "Range", "Text", "N/A");
		}
		listMaintenance.createCustomAttribute(ModuleName, Attributes14_List, "List", "No Format", "Volume 1,Volume 2,Volume 3,Volume 4,Volume 5,Volume 6,Volume 7,Volume 8,Volume 9,Volume 10,Special");
		listMaintenance.createCustomAttribute(ModuleName, Attributes15_Date, "Date", "Custom", "N/A");

		if(ClientData.contains("UCI")) {
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(loc_Edit);
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(loc_Episodes_Save);
			for (String attribute : allAttributes) {
				clickUsingJSExecutor(Loc_NewButton, "New Button");
				clickOn(AM_Attribute_LastRow, "Last row Field");
				clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Attribute to Drop Down Image");
				clickOn(loc_RI_EditMode_DropDownValues_HiddenAndUnique.replace("@var",attribute), "Select " + attribute + "Attribute");
			}
			clickOn(loc_Save, "Save Button");
		}
	}

	@Test(priority =2,enabled= true,description = "Verify UI elements/Attriutes of Attribute TAB")
	public void TC1_AttributeUI() throws Exception {

		assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();
		//UI Element
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		ExecutionLog.Log("*****Verify Headers of Attribute TAB in View mode*****");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesAttributeKey+"']", "AM_Attributes Header", AM_AttributesAttributeValue_ViewMode,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesValue1Key+"']", "AttributesValue1", AM_AttributesValue1Value,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesValue2Key+"']", "AttributesValue2", AM_AttributesValue2Value,"innerHTML");
		ExecutionLog.Log("");
		ExecutionLog.Log("*****Verify Attribute in View mode*****");
		verifyAttributesAtAttributeTAB();
		ExecutionLog.Log("");

		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));
		ExecutionLog.Log("*****Verify Headers of Attribute TAB in Edit mode*****");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesAttributeKey+"']", "AM_Attributes Header", AM_AttributesAttributeValue_EditMode,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesValue1Key+"']", "AttributesValue1", AM_AttributesValue1Value,"innerHTML");
		verifyTextMatches(AM_AttributesColumnXpath+"[@key='"+AM_AttributesValue2Key+"']", "AttributesValue2", AM_AttributesValue2Value,"innerHTML");

		ExecutionLog.Log("*****Verify Button available in Edit mode*****");
		verifyTextMatches(loc_Save, "Save button", "Save","value");
		verifyTextMatches(loc_Cancel, "Cancel button", "Cancel","value");
		ExecutionLog.Log("");

		ExecutionLog.Log("*****Verify Attributes in Edit mode*****");
		//verifyAttributesAtAttributeTAB();
		ExecutionLog.Log("");
		clickUsingJSExecutor(loc_Cancel, "Cancel button", "");


	}

	@Test(priority =3,enabled= true,description = "[FilmLocation Attribute >>  DataType: TextOnly, Format :Text]")
	public void TC2_ValueEnter_FilmLocationAttribute() throws Exception {
		//String Attributes1_FilmLocation = "AUT_Attributes_Film location0927201640644";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(loc_Edit);
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_Episodes_Save);

		enterInvalidDataForValue1_VerifyAlertMessage("3423423", Attributes1_FilmLocation,AM_Attribute_ValidationMessage_EnteringInvalidData);
		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423ab", Attributes1_FilmLocation,AM_Attribute_ValidationMessage_EnteringInvalidData);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("RSGab#$%^*%#$",Attributes1_FilmLocation);


	}

	@Test(priority =4,enabled= true,description = "[Media Attribute >>  DataType: TextOnly, Format :Alphanumeric]")
	public void TC3_ValueEnter_MediaAttribute() throws Exception {
		//String Attributes2_Media = "AUT_Attributes_Media0927201650927";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		// Enter the data in Value1 and verify the entered data on Edit Attribute Window and View Mode
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("10.1",Attributes2_Media);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("RSG3423423ab",Attributes2_Media);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("RSGab#$%^*%#$",Attributes2_Media);
		//// TODO verify that Value2 field is disabled

	}

	@Test(priority =5,enabled= true,description = "[NUMERIC Attribute >>  DataType: Numeric, Format :Number]")
	public void TC4_ValueEnter_Numeric1Attribute() throws Exception {

		//String Attributes3_NUMERIC = "AUT_Attributes_ NUMERIC 10927201650927";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes3_NUMERIC,AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_VerifyAlertMessage("RSGab#$%^*%#$", Attributes3_NUMERIC,AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_VerifyAlertMessage("10.32", Attributes3_NUMERIC,AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("342342",Attributes3_NUMERIC);


	}

	@Test(priority =6,enabled= true,description = "[NUMERIC Attribute >>  DataType: Numeric, Format :Decimal]")
	public void TC5_ValueEnter_Numeric2Attribute() throws Exception {
		//String Attributes4_NUMERIC = "AUT_Attributes_NUMERIC 20927201650927";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes4_NUMERIC,AM_Attribute_ValidationMessage_EnterDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("RSGab#$%^*%#$", Attributes4_NUMERIC,AM_Attribute_ValidationMessage_EnterDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("10003", Attributes4_NUMERIC,AM_Attribute_ValidationMessage_EnterDecimalValue);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("342342.33",Attributes4_NUMERIC);

	}

	@Test(priority =7,enabled= true,description = "[Currency Attribute >>  DataType: Currency, Format :$$$$$]")
	public void TC6_ValueEnter_Currency1Attribute() throws Exception {

		//String Attributes5_CURRENCY = "AUT_Attributes_CURRENCY 10927201650927";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes5_CURRENCY,AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes5_CURRENCY,AM_Attribute_ValidationMessage_EnterValidNumericValue);
		enterInvalidDataForValue1_VerifyAlertMessage("10.32", Attributes5_CURRENCY,AM_Attribute_ValidationMessage_EnterNonValidDecimalValue);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("342342",Attributes5_CURRENCY);
	}

	@Test(priority =8,enabled= true,description = "[Currency Attribute >>  DataType: Currency, Format :$$$$$.cc]")
	public void TC7_ValueEnter_Currency2Attribute() throws Exception {
		//String Attributes6_CURRENCY = "AUT_Attributes_CURRENCY 20927201650927";
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterInvalidDataForValue1_VerifyAlertMessage("RSG3423423", Attributes6_CURRENCY,AM_Attribute_ValidationMessage_EnterValidDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes6_CURRENCY,AM_Attribute_ValidationMessage_EnterValidDecimalValue);
		enterInvalidDataForValue1_VerifyAlertMessage("10003", Attributes6_CURRENCY,AM_Attribute_ValidationMessage_EnterDecimalValue);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("342342.33",Attributes6_CURRENCY);
	}

	@Test(priority =9,enabled= true,description = "[Range1 Attribute >>  DataType: Range, Format :Alphanumeric]")
	public void TC8_ValueEnter_Range1Attribute() throws Exception {
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			//String createdSeriesAssetTitle = "AUT_AssetSeries_1005201650504";
			//String Attributes7_RANGE = "AUT_Attributes_RANGE 1_1005201650504";
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes7_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
			enterDataInValue1_And_VerifyIn_Edit_ViewMode("12RSGab#$%^*%#$", Attributes7_RANGE);
			enterDataInValue2_And_VerifyIn_Edit_ViewMode("12RSGab#$%^*%#$", Attributes7_RANGE);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}

	}

	@Test(priority =10,enabled= true,description = "[Range2 Attribute >>  DataType: Range, Format :Number]")
	public void TC9_ValueEnter_Range2Attribute() throws Exception {
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterOnlyNumber);		
			enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterOnlyNumber);		
			enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterOnlyNumber);		
			enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);		
			enterInvalidDataForValue2_VerifyAlertMessage("", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);		
			// Manual Test Step : TC_AM_AT_114
			enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes8_RANGE, AM_Attribute_ValidationMessage_EnterOnlyNumber);

			// Enter "1024" in value1
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value1.replace("@var", Attributes8_RANGE), "Value1 of " + Attributes8_RANGE,AM_AttributesValue1Value);
			sendKeys(AM_AttributeValue1_InputField, "1024", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
			clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes8_RANGE+"']", "Select Attribute " + Attributes8_RANGE, AM_AttributesValue1Value);
			ExecutionLog.Log("");
			// Verify data f VAlu1 in Edit Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes8_RANGE), "1024", " Value1 Field of Attribute " + Attributes8_RANGE + " in Edit Mode", AM_AttributesValue1Value);

			enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024", Attributes8_RANGE);
			// Verify the data in view Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes8_RANGE), "1024", "Value1 Field of Attribute " + Attributes8_RANGE + " in View Mode", AM_AttributesValue1Value);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}
	}

	@Test(priority =11,enabled= true,description = "[Range3 Attribute >>  DataType: Range, Format :Decimal]")
	public void TC10_ValueEnter_Range3Attribute() throws Exception {
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			//String Attributes9_RANGE = "AUT_Attributes_RANGE 30927201650927";
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
			enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
			enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
			enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);
			enterInvalidDataForValue2_VerifyAlertMessage("", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
			enterInvalidDataForValue2_VerifyAlertMessage("1024", Attributes9_RANGE, AM_Attribute_ValidationMessage_EnterDecimalValue);	

			// Enter "1024.33" in value1 and verify in Edit Mode
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value1.replace("@var", Attributes9_RANGE), "Value1 of " + Attributes9_RANGE,AM_AttributesValue1Value);
			sendKeys(AM_AttributeValue1_InputField, "1024.33", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
			clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes9_RANGE+"']", "Select Attribute " + Attributes9_RANGE, AM_AttributesValue1Value);
			ExecutionLog.Log("");
			// Verify data f Value1 in Edit Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes9_RANGE), "1024", " Value1 Field of Attribute " + Attributes9_RANGE + " in Edit Mode", AM_AttributesValue1Value);

			enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024.33", Attributes9_RANGE);
			// Verify the data in view Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes9_RANGE), "1024", "Value1 Field of Attribute " + Attributes9_RANGE + " in View Mode", AM_AttributesValue1Value);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}

	}

	@Test(priority =12,enabled= true,description = "[Range4 Attribute >>  DataType: Range, Format :$$$$]")
	public void TC11_ValueEnter_Range4Attribute() throws Exception {
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			//String Attributes10_RANGE = "AUT_Attributes_RANGE 40927201650927";
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
			enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
			enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
			enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
			enterInvalidDataForValue2_VerifyAlertMessage("", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
			enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes10_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	

			// Enter "1024" in value1
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value1.replace("@var", Attributes10_RANGE), "Value1 of " + Attributes8_RANGE,AM_AttributesValue1Value);
			sendKeys(AM_AttributeValue1_InputField, "1024", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
			clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes10_RANGE+"']", "Select Attribute " + Attributes10_RANGE, AM_AttributesValue1Value);
			ExecutionLog.Log("");
			// Verify data f VAlu1 in Edit Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes10_RANGE), "1024", " Value1 Field of Attribute " + Attributes10_RANGE + " in Edit Mode", AM_AttributesValue1Value);

			enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024", Attributes10_RANGE);
			// Verify the data in view Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes10_RANGE), "1024", "Value1 Field of Attribute " + Attributes10_RANGE + " in View Mode", AM_AttributesValue1Value);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}

	}

	@Test(priority =13,enabled= true,description = "[Range5 Attribute >>  DataType: Range, Format :$$$$.cc]")
	public void TC12_ValueEnter_Range5Attribute() throws Exception {
		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			//String Attributes11_RANGE = "AUT_Attributes_RANGE 50927201650927";
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	
			enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
			enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);		
			enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterValidNumericValue);	
			enterInvalidDataForValue2_VerifyAlertMessage("", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
			enterInvalidDataForValue2_VerifyAlertMessage("1024", Attributes11_RANGE, AM_Attribute_ValidationMessage_EnterDecimalValue);

			// Enter "1024.33" in value1
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value1.replace("@var", Attributes11_RANGE), "Value1 of " + Attributes8_RANGE,AM_AttributesValue1Value);
			sendKeys(AM_AttributeValue1_InputField, "1024.33", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
			clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes11_RANGE+"']", "Select Attribute " + Attributes11_RANGE, AM_AttributesValue1Value);
			ExecutionLog.Log("");
			// Verify data f VAlu1 in Edit Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes11_RANGE), "1024.33", " Value1 Field of Attribute " + Attributes11_RANGE + " in Edit Mode", AM_AttributesValue1Value);
			// This step was not found in Manual Step but we had to add it to save the details successfully
			enterDataInValue2_And_VerifyIn_Edit_ViewMode("1024.33", Attributes11_RANGE);
			// Verify the data in view Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes11_RANGE), "1024.33", "Value1 Field of Attribute " + Attributes11_RANGE + " in View Mode", AM_AttributesValue1Value);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}

	}

	// BUG ID : 20479
	@Test(priority =14,enabled= true,description = "[Range5 Attribute >>  DataType: Range, Format :Text]")
	public void TC13_ValueEnter_Range6Attribute() throws Exception {
		throw new SkipException("=======BUG ID : 20479");
		/*if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {
			//String Attributes13_RANGE = "AUT_Attributes_Range 0927201650927";
			assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
			switchIntoFrame(frameParent2Xpath);
			clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
			WaitForModalPanel();

			switchIntoFrame(frameParent2Xpath);
			switchIntoChildFrame(frameParent21Xpath);
			WaitForElementPresent(ByLocator(loc_Edit));
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			// Enable belo code when BUG ID : 20479 is fixed
				//enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);	

		//enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	

		//enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);		
		//enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
		//enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);
		//enterInvalidDataForValue2_VerifyAlertMessage("", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
		//enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);



			//////////////////////////////// Delete these Below Code when BUG ID : 20479 is fixed
			enterInvalidDataForValue2_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
			enterInvalidDataForValue1_VerifyAlertMessage("12RSGab#$%^*%#$", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
			enterInvalidDataForValue1_VerifyAlertMessage("1024", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);		
			enterInvalidDataForValue1_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);	
			enterInvalidDataForValue1_VerifyAlertMessage("RSG", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
			enterInvalidDataForValue2_VerifyAlertMessage("", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterRangeValues);
			enterInvalidDataForValue2_VerifyAlertMessage("1024.33", Attributes13_RANGE, AM_Attribute_ValidationMessage_EnterOnlyText);
			/////////////////////////////////////
			// Enter "RSG" in value1
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue2Value);
			clickOn(AM_Attributes_Value1.replace("@var", Attributes13_RANGE), "Value1 of " + Attributes8_RANGE,AM_AttributesValue1Value);
			sendKeys(AM_AttributeValue1_InputField, "RSG", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
			clickOn(AM_AttributesRowXpath+"/td[@title='"+Attributes13_RANGE+"']", "Select Attribute " + Attributes13_RANGE, AM_AttributesValue1Value);
			ExecutionLog.Log("");
			// Verify data of Value1 in Edit Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes13_RANGE), "RSG", " Value1 Field of Attribute " + Attributes13_RANGE + " in Edit Mode", AM_AttributesValue1Value);
			// This step was not found in Manual Step but we had to add it to save the details successfully
			enterDataInValue2_And_VerifyIn_Edit_ViewMode("RSG", Attributes13_RANGE);
			// Verify the data in view Mode
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", Attributes13_RANGE), "RSG", "Value1 Field of Attribute " + Attributes13_RANGE + " in View Mode", AM_AttributesValue1Value);
		} else {
			throw new SkipException("RANGE attribute is not applicable for \""+ ClientData + "\"");
		}*/

	}

	@Test(priority =15,enabled= true,description = "[Attributes14_List >>  DataType: List, Format :No Format]")
	public void TC14_ValueEnter_ESTAttribute() throws Exception {
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterDataInValue1_And_VerifyIn_Edit_ViewMode("Volume 1", Attributes14_List);
		enterDataInValue1_And_VerifyIn_Edit_ViewMode("Volume 2", Attributes14_List);

	}

	@Test(priority =16,enabled= true,description = "[Attributes15_Date >>  DataType: Date, Format :Custom]")
	public void TC15_ValueEnter_DateAttribute() throws Exception {
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Attributes"), "Attributes TAB");
		WaitForModalPanel();

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));

		enterDataInValue1_And_VerifyIn_Edit_ViewMode(AM_Attribute_CorrectFormatedDate, Attributes15_Date);
		enterInvalidDataForValue1_VerifyAlertMessage(AM_Attribute_InCorrectFormatedDate, Attributes15_Date, AM_Attribute_ValidationMessage_InCorrectDateFormat);
		enterInvalidDataForValue1_VerifyAlertMessage(AM_Attribute_InCorrectFormatedDate+"4", Attributes15_Date, AM_Attribute_ValidationMessage_InCorrectDateFormat);
	}

	/**
	 * @author Rajuddin
	 * @description : Teardown, Deletes all the created Attributes
	 * @throws Exception
	 */
	@Test(priority =17,enabled= true)
	public void TC16_DeleteAttributes() throws Exception {
		assetMaintenance.searchCreatedAsset(createdSeriesAssetTitle);
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

			switchIntoFrame(frameParent2Xpath,AM_AttributesValue1Value);
			switchIntoChildFrame(frameParent21Xpath,AM_AttributesValue1Value);
			clickUsingJSExecutor(loc_Edit, "Edit Button");
			switchIntoFrame(frameParent3Xpath);
			WaitForElementPresent(ByLocator(loc_Episodes_Save));

			if(isElementPresent(AM_AttributesRowXpath+"/td[@title='"+attribute+"']")) {
				// Delete the data of value1 field
				clickOn(AM_Attributes_Value1.replace("@var", attribute), "Value1 of " + attribute,AM_AttributesValue1Value);
				sendKeys(AM_AttributeValue1_InputField, Keys.DELETE+"", "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
				clickOn(AM_AttributesRowXpath+"/td[@title='"+attribute+"']", "Select Attribute " + attribute, AM_AttributesValue1Value);

				WaitForModalPanel();
				ExecutionLog.Log("");
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", AM_AttributesValue1Value);
				switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);

				//Only Range Type Attribute is allowed to enter the data in value2 field 
				if(attribute.contains("RANGE")) {
					// Delete the data of value2 field
					clickOn(AM_Attributes_Value2.replace("@var", attribute), "Value2 of " + attribute, AM_AttributesValue2Value);
					sendKeys(AM_AttributeValue2_InputField, Keys.DELETE+"", "AM_AttributeValue2_InputField", AM_AttributesValue2Value);
					WaitForModalPanel();
					ExecutionLog.Log("");
					clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", AM_AttributesValue2Value);
					switchIntoFrame(frameParent3Xpath,AM_AttributesValue2Value);
					// Save the changes
					clickOn(AM_AttributesRowXpath+"/td[@title='"+attribute+"']", "Select Attribute " + attribute, AM_AttributesValue2Value);
					ExecutionLog.Log("");
					switchIntoFrame(frameParent3Xpath);
				}

				clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",AM_AttributesValue1Value);	
				WaitForModalPanel();
				ExecutionLog.Log("");
				clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", AM_AttributesValue1Value);

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

	public void verifyAttributesAtAttributeTAB() throws Exception {
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes1_FilmLocation+"']", "AM_Attributes Name", Attributes1_FilmLocation,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes2_Media+"']", "AM_Attributes Name", Attributes2_Media,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes3_NUMERIC+"']", "AM_Attributes Name", Attributes3_NUMERIC,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes4_NUMERIC+"']", "AM_Attributes Name", Attributes4_NUMERIC,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes5_CURRENCY+"']", "AM_Attributes Name", Attributes5_CURRENCY,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes6_CURRENCY+"']", "AM_Attributes Name", Attributes6_CURRENCY,"innerHTML");

		if(!AM_AttributesRangeAttributeStatus.contains("N/A")) {		
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes7_RANGE+"']", "AM_Attributes Name", Attributes7_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes8_RANGE+"']", "AM_Attributes Name", Attributes8_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes9_RANGE+"']", "AM_Attributes Name", Attributes9_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes10_RANGE+"']", "AM_Attributes Name", Attributes10_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes11_RANGE+"']", "AM_Attributes Name", Attributes11_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes12_RANGE+"']", "AM_Attributes Name", Attributes12_RANGE,"innerHTML");
			verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes13_RANGE+"']", "AM_Attributes Name", Attributes13_RANGE,"innerHTML");
		}
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes14_List+"']", "AM_Attributes Name", Attributes14_List,"innerHTML");
		verifyTextMatches(AM_AttributesRowXpath+"/td[@title='"+Attributes15_Date+"']", "AM_Attributes Name", Attributes15_Date,"innerHTML");

	}

	/**
	 * @author Rajuddin
	 * @param TestData
	 * @param AttributeName
	 * @throws Exception 
	 * @description : This method assumes that the control is on the 
	 * Frame3 and At End Leaves the control on Frame3
	 */
	public void enterDataInValue1_And_VerifyIn_Edit_ViewMode(String TestData, String AttributeName) throws Exception {
		switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
		clickOn(AM_Attributes_Value1.replace("@var", AttributeName), "Value1 of " + AttributeName,AM_AttributesValue1Value);
		sendKeys(AM_AttributeValue1_InputField, TestData, "AM_AttributeValue1_InputField", AM_AttributesValue1Value);

		clickOn(AM_AttributesRowXpath+"/td[@title='"+AttributeName+"']", "Select Attribute " + AttributeName, AM_AttributesValue1Value);
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", AttributeName), TestData, " Value1 Field of Attribute " + AttributeName + " in Edit Mode", AM_AttributesValue1Value);

		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",AM_AttributesValue1Value);	
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath,AM_AttributesValue1Value);
		switchIntoChildFrame(frameParent21Xpath,AM_AttributesValue1Value);
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", AttributeName), TestData, "Value1 Field of Attribute " + AttributeName + " in View Mode", AM_AttributesValue1Value);

		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator(loc_Edit));
		clickUsingJSExecutor(loc_Edit, "Edit Button");
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(ByLocator(loc_Episodes_Save));
	}

	/**
	 * @author Rajuddin
	 * @param TestData
	 * @param AttributeName
	 * @throws Exception 
	 * @description : This method assumes that the control is on the 
	 * Frame3 and At End Leaves the control on Frame3
	 */
	public void enterInvalidDataForValue1_VerifyAlertMessage(String TestData, String AttributeName, String ValidationMessage) throws Exception {

		switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
		clickOn(AM_Attributes_Value1.replace("@var", AttributeName), "Value1 of " + AttributeName,AM_AttributesValue1Value);
		sendKeys(AM_AttributeValue1_InputField, TestData, "AM_AttributeValue1_InputField", AM_AttributesValue1Value);
		Thread.sleep(3000);
		clickOn(AM_Attributes_Field.replace("@var", AttributeName), AttributeName,AM_AttributesValue2Value);
		clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",AM_AttributesValue1Value);		
		WaitForModalPanel();
		ExecutionLog.Log("");
		verifyFieldValueOfHeader(AlertValidationMessgeText, ValidationMessage, "Alert Message on Entering Invalid Data for Attribute Value", AM_AttributesValue1Value);
		clickUsingJSExecutor(OKAlertButtonXpath, "OK Button at Alert", AM_AttributesValue1Value);
		switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
	}

	/**
	 * @author Rajuddin
	 * @param TestData
	 * @param AttributeName
	 * @throws Exception 
	 * @description : This method assumes that the control is on the 
	 * Frame3 and At End Leaves the control on Frame3
	 */
	public void enterDataInValue2_And_VerifyIn_Edit_ViewMode(String TestData, String AttributeName) throws Exception {

		// Check whether the Value2 field exists or not
		// Most of the clients does not has Value2 fields
		// Hence applying the condition to ignore scenario. 
		if(!AM_AttributesValue2Value.contains("N/A")) {			
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value2.replace("@var", AttributeName), "Value2 of " + AttributeName, AM_AttributesValue2Value);
			sendKeys(AM_AttributeValue2_InputField, TestData, "AM_AttributeValue2_InputField", AM_AttributesValue2Value);

			clickOn(AM_AttributesRowXpath+"/td[@title='"+AttributeName+"']", "Select Attribute " + AttributeName, AM_AttributesValue2Value);
			ExecutionLog.Log("");
			verifyFieldValueOfHeader(AM_Attributes_Value1.replace("@var", AttributeName), TestData.toString(), " Value2 Field of Attribute " + AttributeName + " in Edit Mode", AM_AttributesValue2Value);

			clickOn(loc_Episodes_Save, "Save Button at 'Attribute Edit Window'",AM_AttributesValue1Value);	
			WaitForModalPanel();
			switchIntoFrame(frameParent2Xpath,AM_AttributesValue1Value);
			switchIntoChildFrame(frameParent21Xpath,AM_AttributesValue1Value);
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

	/**
	 * @author Rajuddin
	 * @param TestData
	 * @param AttributeName
	 * @throws Exception 
	 * @description : This method assumes that the control is on the 
	 * Frame3 and At End Leaves the control on Frame3
	 */
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

	/**
	 * @author Rajuddin
	 * @param TestData
	 * @param AttributeName
	 * @throws Exception 
	 * @description : This method assumes that the control is on the 
	 * Frame3 and At End Leaves the control on Frame3
	 */
	public void Verify_Value2FieldIsDisabled(String AttributeName) throws Exception {

		// Check whether the Value2 field exists or not
		// Most of the clients does not has Value2 fields
		// Hence applying the condition to ignore scenario. 
		if(!AM_AttributesValue2Value.contains("N/A")) {	
			switchIntoFrame(frameParent3Xpath,AM_AttributesValue1Value);
			clickOn(AM_Attributes_Value2.replace("@var", AttributeName), "Value2 of " + AttributeName, AM_AttributesValue2Value);
			verifyElementNotPresent(AM_AttributeValue2_InputField, "Value 2 Field of '" + AttributeName + "'");

		}
	}

	


}

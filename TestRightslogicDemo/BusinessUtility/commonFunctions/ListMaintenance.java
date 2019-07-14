package commonFunctions;

import utility.DriverHelper;
import utility.ExecutionLog;

public class ListMaintenance extends DriverHelper {
	
	
	
			
			
	/**
	 * @author Rajuddin
	 * @param ModuleName  	: Asset Maintenance, Rights in, Rights Out
	 * @param AttributeName : Name of the Attribute
	 * @param DataType  	: e.g: Text Only,Range,         Numeric,        Currency,List,Date
	 * @param Format     	: e.g: Text, Alphanumeric,Number,Decimal,$$$$$,$$$$$.cc
	 * @param ListElement   : As this field is not Mandatory hence pass "N/A" if do not want enter data in this field other wise pass the data
	 * @throws Exception
	 */
	public void createCustomAttribute(String ModuleName, String AttributeName, String DataType, String Format, String ListElement) throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickUsingJSExecutor(loc_NewButton_CustomAttribute_ListMaintenance, "New Button to Add Attribute");
		Thread.sleep(2000);

		clickOn(getLocator_LastDataRow("last()",LM_CustomAttributesModuleKey, LM_CustomAttributesModule),"Module Field");
		sendKeys(loc_CustomAttribute_ListMaintenance_ModuleName_InputField, ModuleName, "Entered " + ModuleName + " in Module Input Field" , "");

		clickOn(getLocator_LastDataRow("last()",LM_CustomAttributesAttributeKey, LM_CustomAttributesAttribute),"AttributeName Field");
		sendKeys(loc_CustomAttribute_ListMaintenance_AttributeName_InputField, AttributeName, "Entered " + AttributeName + " in Attribute Name Input Field" , "");

		clickOn(getLocator_LastDataRow("last()",LM_CustomAttributesDataTypeKey, LM_CustomAttributesDataType),"DataType Field");
		sendKeysOnDisplayedElement(loc_CustomAttribute_ListMaintenance_DataType_InputField, DataType, "Entered "+ DataType + " in DataType Input Field" , "");

		clickOn(getLocator_LastDataRow("last()",LM_CustomAttributesFormatKey, LM_CustomAttributesFormat),"Format Field");
		sendKeysOnDisplayedElement(loc_CustomAttribute_ListMaintenance_DataType_InputField, Format, "Entered " + Format + " in Format Input Field" , "");
		keyboard();

		if(!ListElement.contains("N/A")) {
			clickOn(getLocator_LastDataRow("last()",LM_CustomAttributesListElements_CommaSeparatedKey, LM_CustomAttributesListElements_CommaSeparated),"ListElement Field");
			sendKeysOnDisplayedElement(loc_CustomAttribute_ListMaintenance_DataType_InputField, ListElement, "Entered "+ ListElement + " in DataType Input Field" , "");
			keyboard();
		}


		clickUsingJSExecutor(loc_SaveButton_CustomAttribute_ListMaintenance, "Save Button to Add Attribute");
		WaitForModalPanel();
		ExecutionLog.Log("Verify the details of Created Custom Attribute");
		switchIntoFrame(frameParent2Xpath);
		String classValue_Module = loc_FilterClassValue(getClassValue(loc_CustomAttribute_ListMaintenance_Header, LM_CustomAttributesModuleKey, LM_CustomAttributesModule));
		String classValue_Format = loc_FilterClassValue(getClassValue(loc_CustomAttribute_ListMaintenance_Header, LM_CustomAttributesFormatKey, LM_CustomAttributesFormat));
		String classValue_DataType = loc_FilterClassValue(getClassValue(loc_CustomAttribute_ListMaintenance_Header, LM_CustomAttributesDataTypeKey, LM_CustomAttributesDataType));
//System.out.println(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName)+"//preceding-sibling::td[contains(@class,'" + classValue_Module + "')]");
		verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName)+"//preceding-sibling::td[contains(@class,'" + classValue_Module + "')]", ModuleName, "ModuleName Field", "", "innerHTML");
		verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName)+"//following-sibling::td[contains(@class,'" + classValue_Format + "')]", Format, "Format Field", "", "innerHTML");
		verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName)+"//following-sibling::td[contains(@class,'" + classValue_DataType + "')]", DataType, "DataType Field", "", "innerHTML");

		
		//verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_ModuleField_AfterSave.replace("@var", AttributeName), ModuleName, "ModuleName Field", "", "innerHTML");
		//verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName), AttributeName, "AttributeName Field", "", "innerHTML");
		//verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_DataTypeField_AfterSave.replace("@var", AttributeName), DataType, "DataType Field", "", "innerHTML");
		//verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_FormatField_AfterSave.replace("@var", AttributeName), Format, "Format Field", "", "innerHTML");
		if(!ListElement.contains("N/A")) {
			//verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave.replace("@var", AttributeName)+"//following-sibling::td[contains(@class,'" + classValue_ListElement + "')]", ListElement, "ListElement Field", "", "innerHTML");
			String classValue_ListElement = loc_FilterClassValue(getClassValue(loc_CustomAttribute_ListMaintenance_Header, LM_CustomAttributesListElements_CommaSeparatedKey, LM_CustomAttributesListElements_CommaSeparated));
			verifyFieldValueOfHeader(loc_CustomAttribute_ListMaintenance_ListElementField_AfterSave.replace("@var", AttributeName)+"//following-sibling::td[contains(@class,'" + classValue_ListElement + "')]", ListElement, "ListElement", "", "innerHTML");
		}
		ExecutionLog.Log("");
	}
	
	
	public String getLocator_LastDataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		
		String classValue = getClassValue(loc_CustomAttribute_ListMaintenance_Header, KeyValueFromExcel, HeadeNameFromExcel);
		locator =  loc_LastAttribute_CustomAttribute_ListMaintenance + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
}



















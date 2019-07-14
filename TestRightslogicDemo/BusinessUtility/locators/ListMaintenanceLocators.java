package locators;

public interface ListMaintenanceLocators {
	

	 // Locators of ListMaintenance_ExternalContributor
	 String loc_ListMaintenance_ExternalContributor_NewButton = "css=input[id*='NewBtn']";
	 String loc_ListMaintenance_ExternalContributor_FirstName = "txtFirstName";
	 String loc_ListMaintenance_ExternalContributor_LastName = "txtLastName";
	
	    // Locators of List Maintenance >> Custom Attributes
	 String loc_CustomAttribute_ListMaintenance_Header 		= "//*[@id='uwgCustomAttributes']//th";
	 String loc_NewButton_CustomAttribute_ListMaintenance 	= "PageContent_NewBtn";
	 String loc_SaveButton_CustomAttribute_ListMaintenance 	= "//*[@id='PageContent_SaveBtn']";
	 String loc_LastAttribute_CustomAttribute_ListMaintenance = "//*[@id='uwgCustomAttributes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	 String loc_CustomAttribute_ListMaintenance_ModuleName_InputField = "//*[@id='uwgCustomAttributes_ctl00']/div/table/tbody/tr/td[1]/input";
	 String loc_CustomAttribute_ListMaintenance_AttributeName_InputField = "//*[@id='uwgCustomAttributes_txtAttribute']/input";
	 String loc_CustomAttribute_ListMaintenance_DataType_InputField = "//*[contains(@id,'uwgCustomAttributes_ctl0')]/div/table/tbody/tr/td[1]/input";
	 //String loc_CustomAttribute_ListMaintenance_Format_InputField = "//*[@id='uwgCustomAttributes_ctl02']/div/table/tbody/tr/td[1]/input";
	 //String loc_CustomAttribute_ListMaintenance_ListElement_InputField = "//*[@id='uwgCustomAttributes_ed0']/input";
	 
	 String loc_CustomAttribute_ListMaintenance_ModuleField = loc_LastAttribute_CustomAttribute_ListMaintenance+"/td[2]";
	 String loc_CustomAttribute_ListMaintenance_AttributeNameField = loc_LastAttribute_CustomAttribute_ListMaintenance+"/td[3]";
	 String loc_CustomAttribute_ListMaintenance_DataTypeField = loc_LastAttribute_CustomAttribute_ListMaintenance+"/td[4]";
	 String loc_CustomAttribute_ListMaintenance_FormatField = loc_LastAttribute_CustomAttribute_ListMaintenance+"/td[5]";
	 String loc_CustomAttribute_ListMaintenance_ListElementField = loc_LastAttribute_CustomAttribute_ListMaintenance+"/td[6]";
	 
	 // While creating the Attributes in List Maintenance, The location of the Attribute is getting changed after click on the save button for CORUS
	 String loc_CustomAttribute_ListMaintenance_ModuleField_AfterSave 			= "//*[@id='uwgCustomAttributes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[text()='@var']"+"/preceding-sibling::td/following-sibling::td";
	 String loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave 	= "//*[@id='uwgCustomAttributes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[text()='@var']";
	 String loc_CustomAttribute_ListMaintenance_AttributeRow_AfterSave = "//*[@id='uwgCustomAttributes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[text()='@var']/../th";
	 String loc_CustomAttribute_ListMaintenance_DataTypeField_AfterSave = loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave+"/following-sibling::td";
	 String loc_CustomAttribute_ListMaintenance_FormatField_AfterSave = loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave+"/following-sibling::td/following-sibling::td";
	 String loc_CustomAttribute_ListMaintenance_ListElementField_AfterSave = loc_CustomAttribute_ListMaintenance_AttributeNameField_AfterSave+"/following-sibling::td/following-sibling::td/following-sibling::td";
	 
	 
	 String loc_DeleteButton = "//*[@id='btnDelete']";
	 
	 


}

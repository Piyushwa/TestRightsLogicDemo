package commonFunctions;

import rightsIN.RI_ExhibitionRights;
import rightsIN.RI_MediaRights;
import utility.ExecutionLog;


public class Finance extends MultiClient_SupportingFunctions{


	public void FinancePrerequisite() throws Exception 
	{
	
		//MediaRightstabdata();
		//ExhibitionRightstabdata();
		Paymenttab_Paymentframe();
		Paymenttab_Assetvalueframe();

	}

	public void MediaRightstabdata() throws Exception
	{
		
		RI_MediaRights mediaRights = new RI_MediaRights();
		// Navigation to Media Rights tab	
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent(ByLocator("name="+loc_EditButtonEpisodes));

		// Click on Edit button in Media Rights Tab
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Media Rights TAB");
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);

		// Define Media Rights row in Media Rights for 4 Episodes(Ep # 101,102,201 and 202)
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		// Enter the data for Row1
		mediaRights.enterDatainAllFields("1", RI_MediaRights_Episode101);
		clickOn(loc_RI_MediaRights_EditMode_CopyRows_Buttons, "Copy Rows Button", RI_MediaRights_EditMode_CopyRows_Buttons);
		WaitForModalPanel();

		// Enter the data for Row 2 - 4
		sendKeys(PromptAlertInputBox, "3", "Number of Copies", RI_MediaRights_EditMode_CopyRows_Buttons);
		clickUsingJSExecutor(PromptAlertOKButton, 				"OK Button at Prompt Alert", RI_MediaRights_EditMode_CopyRows_Buttons);
		switchIntoFrame(frameParent3Xpath);		
		mediaRights.enterDataInFieldEditMode("2", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode102,	 	RI_MediaRights_APPLIESTO_Key);
		mediaRights.enterDataInFieldEditMode("3", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode201,	 	RI_MediaRights_APPLIESTO_Key);
		mediaRights.enterDataInFieldEditMode("4", RI_MediaRights_EditMode_APPLIESTO_HeaderName, 				RI_MediaRights_Episode202,	 	RI_MediaRights_APPLIESTO_Key);

		//Saving the data for Media rights row
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		//Close the edit window and navigate to Media rights view mode page
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();

		//Navigation to Exhibition Rights TAB
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
	}
	
	public void ExhibitionRightstabdata() throws Exception
	{
		RI_MediaRights mediaRights = new RI_MediaRights();
		RI_ExhibitionRights exhibitionRights = new RI_ExhibitionRights();

		//Navigation to Exhibition Rights TAB
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Exhibition Rights"), "Exhibition Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//Click on Edit button in Exhibition Rights TAB
		clickUsingJSExecutor("name="+loc_EditButtonEpisodes, "'Edit' Button at Exhibition Rights TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		// Adding  First Media Row(Ep 101) into the Exhibition Row
		switchIntoFrame(frameParent3Xpath, RI_Exh_EditMode_AddButton);
		clickOn(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("1", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		clickOn(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		exhibitionRights.EnterMandatoryData(2);

		// Adding  Second Media Row(Ep 102) into the Exhibition Row
		switchIntoFrame(frameParent3Xpath);		
		doubleClick(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("2", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		doubleClick(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		exhibitionRights.EnterMandatoryData(4);

		// Adding  Third Media Row(Ep 201) into the Exhibition Row
		switchIntoFrame(frameParent3Xpath);		
		doubleClick(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("3", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		doubleClick(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		exhibitionRights.EnterMandatoryData(6);

		// Adding  Fourth Media Row(Ep 202) into the Exhibition Row
		switchIntoFrame(frameParent3Xpath);		
		doubleClick(loc_RI_MediaRights_EditMode_AddButton, "Add Button", RI_Exh_EditMode_AddButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath, RI_Exh_EditMode_AddButton);
		clickOn(mediaRights.getLocator_EditTAB_DataRow("4", RI_Exh_MediaWindow_SelectKey, RI_Exh_MediaWindow_SelectHeader)+"/img", 	"Select Check Box",	RI_Exh_MediaWindow_SelectHeader);
		doubleClick(loc_RI_closeButton, "Add Button at Media rights Pop up Window", RI_Exh_MediaWindow_AddButton);
		WaitForModalPanel();
		exhibitionRights.EnterMandatoryData(8);

		//Save the Exhibiton rights tab data
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		//Close the edit window and navigate to Media rights view mode page
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
	}
	
	public void Paymenttab_Paymentframe() throws Exception
	{
		//Navigation to Payments TAB
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Payments TAB---------------");

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//Click on Edit Payment Button
		clickUsingJSExecutor("name="+loc_RI_Payment_Editpayment, "'Edit Payments' Button at Payment TAB");
		switchIntoFrame(frameParent3Xpath);		
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_RI_Payments_Editpayment_AddButton);


		//Add a New row in Payment Frame
		clickUsingJSExecutor(loc_RI_Payments_Editpayment_AddButton, "'Add' Button at Edit Payment TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(Loc_RI_Payments_Editpayment_FirstAllocationrowSelector, "Allocating first payment row ", loc_RI_Payments_Editpayment_AllocateButton);		
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_Payments_Editpayment_AllocateButton, "'Allocate' Button at Edit Payment TAB");	
		switchIntoFrame(frameParent4Xpath);
		selectDropdownValue(Loc_RI_Payments_Allocationrowlines, "Allocating 4 payment rows", "4", "");
		clickUsingJSExecutor(Loc_RI_Payments_Allocationrowokbutton, " Payment Row allocation ok button", Loc_RI_Payments_Allocationrowokbutton);
		WaitForModalPanel();
		Thread.sleep(3000);
		switchIntoFrame(frameParent3Xpath);

		//Entering data for first payment row
		
		//Entering data for Applies to field
		ExecutionLog.Log("----------Enter the data in the Applies to field of first Payment row----------");				
		clickOn(getLocator_Payment_Child_DataRow("2", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo), "Applies to Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Appliesto_Episode101), "'Episode 101' in Applies to field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo), RI_Payment_Appliesto_Episode101, RI_Payment_Appliesto_Episode101 + " in Applies to field ",	RI_Payment_AppliesTo, 	 "innerHTML");

		//Entering data for Party field
		ExecutionLog.Log("----------Enter the data in the Party field of first Payment row----------");	
		clickOn(getLocator_Payment_Child_DataRow("3", RI_Payments_Party_Key, RI_Payment_Party), "Party Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Party Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Partyname1data), " 'Party Name' in Party field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_Party_Key, RI_Payment_Party), RI_Payment_Partyname1data, RI_Payment_Partyname1data + " in Party field",	RI_Payment_Party, 	 "innerHTML");

		//Entering data for Payment type field
		ExecutionLog.Log("----------Enter the data in the Payment Type field of first Payment row----------");	
		clickOn(getLocator_Payment_Child_DataRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType), "Payment Type Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Paymenttypedata), "'License Fee' in  Payment type field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType), RI_Payment_Paymenttypedata, RI_Payment_Paymenttypedata + " in Payment Type field",	RI_Payment_PaymentType, 	 "innerHTML");

		//Scrolling 
		scrollElementIntoView(getLocator_Payment_Child_DataRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate), "Scrolling to Due date field", RI_Payment_DueDate);

		//Entering data for Amount field
		ExecutionLog.Log("----------Enter the data in the Amount field of first Payment row----------");
		clickOn(getLocator_Payment_Child_DataRow("3", RI_Payments_Amount_Key, RI_Payment_Amount), "Amount for First payment row", RI_Payment_Amount);
		sendKeys_WithoutClear(Loc_RI_Payment_Amount_input, RI_Payment_Amountdata, "Enter data for Amount Field", RI_Payment_Amount);
		keyboard();
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_Amount_Key, RI_Payment_Amount), RI_Payment_Amountdata, RI_Payment_Amountdata + " in Amount field ",	RI_Payment_Amount, 	 "innerHTML");

		//Entering data for Due date field
		ExecutionLog.Log("----------Enter the data in the Due date of first Payment row----------");
		clickOn(getLocator_Payment_Child_DataRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate), "Amount for First payment row", RI_Payment_DueDate);
		sendKeys_WithoutClear(Loc_RI_Payment_Duedate_input, RI_Payment_Duedatedata1, "Enter data for due date Field", RI_Payment_DueDate);
		keyboard();
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate), RI_Payment_Duedatedata1, RI_Payment_Duedatedata1 + " in Due date field ",	RI_Payment_DueDate, 	 "innerHTML");
		
		//Scrolling
		scrollElementIntoView(getLocator_Payment_Child_DataRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo), "Scrolling to Applies to field", RI_Payment_AppliesTo);
		//WaitForElementPresent(getLocator_Payment_Child_DataRow("5", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo));
		Thread.sleep(2000);
		
		//Second payment row data
		ExecutionLog.Log("----------Enter the data in the Applies to field of Second Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "1"), "Applies to Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Appliesto_Episode102), "'Episode 102' in Applies to field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "1"), RI_Payment_Appliesto_Episode102, RI_Payment_Appliesto_Episode102 + " in Applies to field ",	RI_Payment_AppliesTo, 	 "innerHTML");

		//Entering data for Party field
		ExecutionLog.Log("----------Enter the data in the Party field of Second Payment row----------");
		// Enter Exhibition Scope in Parent Window
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "1"), "Party Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Party Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Partyname1data), " 'Party Name' in Party field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "1"), RI_Payment_Partyname1data, RI_Payment_Partyname1data + " in Party field",	RI_Payment_Party, 	 "innerHTML");

		//Entering data for Payment type field
		ExecutionLog.Log("----------Enter the data in the Payment Type field of Second Payment row----------");
		// Enter Exhibition Scope in Parent Window		
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "1"), "Payment Type Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Paymenttypedata), "'License Fee' in  Payment type field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "1"), RI_Payment_Paymenttypedata, RI_Payment_Paymenttypedata + " in Payment Type field",	RI_Payment_PaymentType, 	 "innerHTML");

		//Scrolling 
		scrollElementIntoView(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "1"), "Scrolling to Due date field", RI_Payment_DueDate);

		//Entering data for Amount field
		ExecutionLog.Log("----------Enter the data in the Amount field of Second Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Amount_Key, RI_Payment_Amount, "1"), "Amount for Second payment row");
		//clickOn(getLocator_Payment_Child_DataRow("5", RI_Payments_Amount_Key, RI_Payment_Amount), "Amount for First payment row", RI_Payment_Amount);
		sendKeys_WithoutClear(Loc_RI_Payment_Amount_input, RI_Payment_Amountdata, "Enter data for Amount Field", RI_Payment_Amount);
		keyboard();


		//Entering data for Due date field
		ExecutionLog.Log("----------Enter the data in the Due date of Second Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "1"), "Due date for Second payment row");
		//clickOn(getLocator_Payment_Child_DataRow("5", RI_Payments_DueDate_Key, RI_Payment_DueDate), "Amount for First payment row", RI_Payment_DueDate);
		sendKeys_WithoutClear(Loc_RI_Payment_Duedate_input, RI_Payment_Duedatedata2, "Enter data for due date Field", RI_Payment_DueDate);
		keyboard();

		//Scrolling
		scrollElementIntoView(getLocator_Payment_Child_DataRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo), "Scrolling to Applies to field", RI_Payment_AppliesTo);

		//Third payment row
		ExecutionLog.Log("----------Enter the data in the Applies to field of Third Payment row----------");		
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "2"), "Applies to Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Appliesto_Episode201), "'Episode 201' in Applies to field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "2"), RI_Payment_Appliesto_Episode201, RI_Payment_Appliesto_Episode201 + " in Applies to field ",	RI_Payment_AppliesTo, 	 "innerHTML");

		//Entering data for Party field
		ExecutionLog.Log("----------Enter the data in the Party field of Third Payment row----------");	
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "2"), "Party Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Party Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Partyname1data), " 'Party Name' in Party field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "2"), RI_Payment_Partyname1data, RI_Payment_Partyname1data + " in Party field",	RI_Payment_Party, 	 "innerHTML");

		//Entering data for Payment type field
		ExecutionLog.Log("----------Enter the data in the Payment Type field of Third Payment row----------");	
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "2"), "Payment Type Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Paymenttypedata), "'License Fee' in  Payment type field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "2"), RI_Payment_Paymenttypedata, RI_Payment_Paymenttypedata + " in Payment Type field",	RI_Payment_PaymentType, 	 "innerHTML");

		//Scrolling 
		scrollElementIntoView(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "2"), "Scrolling to Due date field", RI_Payment_DueDate);

		//Entering data for Amount field
		ExecutionLog.Log("----------Enter the data in the Amount field of Third Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Amount_Key, RI_Payment_Amount, "2"), "Amount for Third payment row");
		sendKeys_WithoutClear(Loc_RI_Payment_Amount_input, RI_Payment_Amountdata, "Enter data for Amount Field", RI_Payment_Amount);
		keyboard();

		//Entering data for Due date field
		ExecutionLog.Log("----------Enter the data in the Due date of Third Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "2"), "Due date for Third payment row");
		sendKeys_WithoutClear(Loc_RI_Payment_Duedate_input, RI_Payment_Duedatedata3, "Enter data for due date Field", RI_Payment_DueDate);
		keyboard();
		
		//Scrolling
		scrollElementIntoView(getLocator_Payment_Child_DataRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo), "Scrolling to Applies to field", RI_Payment_AppliesTo);

		//Fourth payment row
		ExecutionLog.Log("----------Enter the data in the Applies to field of Fourth Payment row----------");		
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "3"), "Applies to Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Appliesto_Episode202), "'Episode 202' in Applies to field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_AppliesTo_Key, RI_Payment_AppliesTo, "3"), RI_Payment_Appliesto_Episode202, RI_Payment_Appliesto_Episode202 + " in Applies to field ",	RI_Payment_AppliesTo, 	 "innerHTML");

		//Entering data for Party field
		ExecutionLog.Log("----------Enter the data in the Party field of Fourth Payment row----------");	
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "3"), "Party Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Party Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Partyname1data), " 'Party Name' in Party field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Party_Key, RI_Payment_Party, "3"), RI_Payment_Partyname1data, RI_Payment_Partyname1data + " in Party field",	RI_Payment_Party, 	 "innerHTML");

		//Entering data for Payment type field
		ExecutionLog.Log("----------Enter the data in the Payment Type field of Fourth Payment row----------");	
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "3"), "Payment Type Field");
		clickOn(loc_RI_Payment_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Paymenttypedata), "'License Fee' in  Payment type field");
		clickOn(loc_RI_Payment_supportclick , "Support Click");
		verifyFieldValueOfHeader(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_PaymentType_Key, RI_Payment_PaymentType, "3"), RI_Payment_Paymenttypedata, RI_Payment_Paymenttypedata + " in Payment Type field",	RI_Payment_PaymentType, 	 "innerHTML");

		//Scrolling 
		scrollElementIntoView(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "3"), "Scrolling to Due date field", RI_Payment_DueDate);

		//Entering data for Amount field
		ExecutionLog.Log("----------Enter the data in the Amount Fourth of first Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_Amount_Key, RI_Payment_Amount, "3"), "Amount for Fourth payment row");
		sendKeys_WithoutClear(Loc_RI_Payment_Amount_input, RI_Payment_Amountdata, "Enter data for Amount Field", RI_Payment_Amount);
		keyboard();

		//Entering data for Due date field
		ExecutionLog.Log("----------Enter the data in the Due date of Fourth Payment row----------");
		clickOn(getLocator_Child_DataRow_UnderSameParentRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate, "3"), "Due date for Fourth payment row");
		sendKeys_WithoutClear(Loc_RI_Payment_Duedate_input, RI_Payment_Duedatedata4, "Enter data for due date Field", RI_Payment_DueDate);
		keyboard();

		//Save and close the payment edit page
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
//		switchIntoFrame(frameParent3Xpath);
//		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Payments Edit window",RI_MediaRights_EditMode_SaveButton);
//		WaitForModalPanel();
		switchIntoFrame(ConfirmAlertXpath);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up", ConfirmAlertButtonXpath);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		//Close the edit window and navigate to Payment tab view mode page
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at  Edit Payment Page window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);


		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
	}
	
	public void Paymenttab_Assetvalueframe() throws Exception
	{
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Payments TAB---------------");

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		//Click on Edit Asset value Button
		clickUsingJSExecutor("name="+loc_RI_Payment_EditAssetvalue, "'Edit Asset value' Button at Payment TAB");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);

		//Add a new row in Asset value frame
		clickUsingJSExecutor(Loc_RI_Payment_Assetvalue_Addbutton, "'Add' Button at Edit Asset value TAB");
		Thread.sleep(3000);	
		
		//Entering data for First Asset value row
		//Enter the Applies to value for first asset value row
		ExecutionLog.Log("----------Enter the data in the Applies to of first Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("1", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), "Applies to Field");
		clickOn(loc_RI_Payment_Assetvalue_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Assetvalue_Episode101), "'Episode 101' in Applies to field");
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("1", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), RI_Payment_Assetvalue_Episode101, RI_Payment_Assetvalue_Episode101 + " in Applies to field ",	RI_Payment_Assetvalue_AppliesTo, 	 "innerHTML");

		//Enter the Amount value for first asset value row
		ExecutionLog.Log("----------Enter the data in the Amount of first Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("1", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), "Amount for First Asset value row", RI_Payment_Assetvalue_AmountTo);
		sendKeys_WithoutClear(Loc_RI_Payment_Assetvalue_Amount_input, RI_Payment_Assetvalue_Amountdata, "Enter data for Amount Field", RI_Payment_Assetvalue_AmountTo);
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("1", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), RI_Payment_Assetvalue_Amountdata, RI_Payment_Assetvalue_Amountdata + " in Applies to field ",	RI_Payment_Assetvalue_AmountTo, 	 "innerHTML");
		
		//Entering data for Second Asset value row
		clickUsingJSExecutor(Loc_RI_Payment_Assetvalue_Addbutton, "'Add' Button at Edit Asset value TAB");
		Thread.sleep(3000);
		//Enter the Applies to value for Second asset value row
		ExecutionLog.Log("----------Enter the data in the Applies to of Second Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("2", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), "Applies to Field");
		clickOn(loc_RI_Payment_Assetvalue_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Assetvalue_Episode102), "'Episode 102' in Applies to field");
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("2", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), RI_Payment_Assetvalue_Episode102, RI_Payment_Assetvalue_Episode102 + " in Applies to field ",	RI_Payment_Assetvalue_AppliesTo, 	 "innerHTML");

		//Enter the Amount value for Second asset value row
		ExecutionLog.Log("----------Enter the data in the Amount of Second Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("2", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), "Amount for Second Asset value row", RI_Payment_Assetvalue_AmountTo);
		sendKeys_WithoutClear(Loc_RI_Payment_Assetvalue_Amount_input, RI_Payment_Assetvalue_Amountdata, "Enter data for Amount Field", RI_Payment_Assetvalue_AmountTo);
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("2", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), RI_Payment_Assetvalue_Amountdata, RI_Payment_Assetvalue_Amountdata + " in Applies to field ",	RI_Payment_Assetvalue_AmountTo, 	 "innerHTML");

		//Entering data for Third Asset value row
		clickUsingJSExecutor(Loc_RI_Payment_Assetvalue_Addbutton, "'Add' Button at Edit Asset value TAB");
		Thread.sleep(3000);
		//Enter the Applies to value for Third asset value row
		ExecutionLog.Log("----------Enter the data in the Applies to of Third Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("3", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), "Applies to Field");
		clickOn(loc_RI_Payment_Assetvalue_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Assetvalue_Episode201), "'Episode 201' in Applies to field");
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("3", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), RI_Payment_Assetvalue_Episode201, RI_Payment_Assetvalue_Episode201 + " in Applies to field ",	RI_Payment_Assetvalue_AppliesTo, 	 "innerHTML");

		//Enter the Amount value for Third asset value row
		ExecutionLog.Log("----------Enter the data in the Amount of Third Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("3", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), "Amount for Third Asset value row", RI_Payment_Assetvalue_AmountTo);
		sendKeys_WithoutClear(Loc_RI_Payment_Assetvalue_Amount_input, RI_Payment_Assetvalue_Amountdata, "Enter data for Amount Field", RI_Payment_Assetvalue_AmountTo);
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("3", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), RI_Payment_Assetvalue_Amountdata, RI_Payment_Assetvalue_Amountdata + " in Applies to field ",	RI_Payment_Assetvalue_AmountTo, 	 "innerHTML");

		//Entering data for Fourth Asset value row
		clickUsingJSExecutor(Loc_RI_Payment_Assetvalue_Addbutton, "'Add' Button at Edit Asset value TAB");
		Thread.sleep(3000);
		//Enter the Applies to value for Fourth asset value row
		ExecutionLog.Log("----------Enter the data in the Applies to of Fourth Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("4", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), "Applies to Field");
		clickOn(loc_RI_Payment_Assetvalue_EditMode_DropDownImage, "Applies to Drop Down");
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_Payment_Assetvalue_Episode202), "'Episode 202' in Applies to field");
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("4", RI_Payments_Assetvalue_AppliesTo_Key, RI_Payment_Assetvalue_AppliesTo), RI_Payment_Assetvalue_Episode202, RI_Payment_Assetvalue_Episode202 + " in Applies to field ",	RI_Payment_Assetvalue_AppliesTo, 	 "innerHTML");

		//Enter the Amount value for Fourth asset value row
		ExecutionLog.Log("----------Enter the data in the Amount of Fourth Asset value row----------");
		clickOn(getLocator_Assetvalue_DataRow("4", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), "Amount for Fourth Asset value row", RI_Payment_Assetvalue_AmountTo);
		sendKeys_WithoutClear(Loc_RI_Payment_Assetvalue_Amount_input, RI_Payment_Assetvalue_Amountdata, "Enter data for Amount Field", RI_Payment_Assetvalue_AmountTo);
		clickOn(loc_RI_Payment_Assetvalue_DataRow , "Support Click");
		verifyFieldValueOfHeader(getLocator_Assetvalue_DataRow("4", RI_Payments_Assetvalue_Amount_Key, RI_Payment_Assetvalue_AmountTo), RI_Payment_Assetvalue_Amountdata, RI_Payment_Assetvalue_Amountdata + " in Applies to field ",	RI_Payment_Assetvalue_AmountTo, 	 "innerHTML");



		// Save the data in Asset value frame
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Payments Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		//Close the edit window and navigate to Media rights view mode page
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		switchIntoChildFrame(frameParent21Xpath);	
	}
	
	public void UpdatedAmountinPaymentframe() throws Exception
	{
		ExecutionLog.Log("");
		ExecutionLog.Log("---------------Payments TAB---------------");

		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);

		//Click on Edit Payment Button
		clickUsingJSExecutor("name="+loc_RI_Payment_Editpayment, "'Edit Payments' Button at Payment TAB");
		switchIntoFrame(frameParent3Xpath);		
		clickOn(loc_RI_MediaRights_ClearFiltersButton,"ClearFiltersButton");
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		WaitForElementPresent(loc_RI_Payments_Editpayment_AddButton);

		//Scrolling to Payment Amount Field
		scrollElementIntoView(getLocator_Payment_Child_DataRow("3", RI_Payments_DueDate_Key, RI_Payment_DueDate), "Scrolling to Due date field", RI_Payment_DueDate);

		//Update the Amount for Episode 101
		ExecutionLog.Log("----------Update the Amount for Episode 101 in Payment frame----------");
		clickOn(getLocator_Payment_Child_DataRow("3", RI_Payments_Amount_Key, RI_Payment_Amount), "Amount for First payment row", RI_Payment_Amount);
		sendKeys_WithoutClear(Loc_RI_Payment_Amount_input, RI_Payment_UpdatedAmountData, "Enter data for Amount Field", RI_Payment_Amount);
		keyboard();
		verifyFieldValueOfHeader(getLocator_Payment_Child_DataRow("3", RI_Payments_Amount_Key, RI_Payment_Amount), RI_Payment_UpdatedAmountData, RI_Payment_Amountdata + " in Amount field ",	RI_Payment_Amount, 	 "innerHTML");
		//Save and close the payment edit page
		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		//switchIntoFrame(frameParent3Xpath);
		//clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Payments Edit window",RI_MediaRights_EditMode_SaveButton);
		//WaitForModalPanel();
		switchIntoFrame(ConfirmAlertXpath);
		clickUsingJSExecutor(ConfirmAlertButtonXpath, "Ok Button At Confirm Pop-Up", ConfirmAlertButtonXpath);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		//Close the edit window and navigate to Payment tab view mode page
		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at  Edit Payment Page window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Payments"), "Payments TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
	}
	
	public void navigateToRightsINFinance() throws Exception {
		switchIntoFrame(frameParent1Xpath);
		WaitForElementPresent(ModulesXpath);
		Thread.sleep(2000);
		clickOn(ModulesXpath, "Modules");
		Thread.sleep(6000);
		clickOn(RightsInFinanceXpath, "RightsIN Finance");
		Thread.sleep(2000);
	}
	
	public void AcceptRIDeal_ChangeDealGadget(String dealName) throws Exception {
		switchIntoFrame(frameParent2Xpath);
		clickOnDisplayedElement(loc_Fin_ChangedealGadget_DealSelect.replace("@var", dealName), "Select deal in Change Deal Gadget ", "");
		WaitForModalPanel();
		Thread.sleep(3000);
		WaitForElementPresent(loc_Fin_ChangedealGadget_Acceptbutton);
		clickOn(loc_Fin_ChangedealGadget_Acceptbutton, "Accept Button");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		Thread.sleep(2000);

	}
	
	public void Searchdeal_FinanceAgreementSearch(String dealName) throws Exception
	{
		switchIntoFrame(frameParent2Xpath);		
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Navigate to Finance Agreement Search************************");
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		clickUsingJSExecutor(loc_Fin_Search_Deals,"Deals");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		ExecutionLog.Log("");
		ExecutionLog.Log("********************************Search the Deal by Deal Name***********************");
		sendKeys(Loc_Fin_AggrementSearchDealNameInput, dealName, Fin_AggrementSearchDealName, Fin_AggrementSearchDealName);			
		Thread.sleep(2000);
		clickUsingJSExecutor(Loc_SearchButton,"Search Button");
    	WaitForModalPanel();
    	switchIntoFrame(frameParent2Xpath);
    	clickOn(loc_Fin_AggrementSearch_DataRow.replace("@var", dealName),"Search result" , "");
    	WaitForElementToClickable(ByLocator(loc_Fin_AggrementSearch_DataRow.replace("@var", dealName)));
		moveMouse(loc_Fin_AggrementSearch_DataRow.replace("@var", dealName), "First Deal in Searched Deal");
		clickOn(loc_Fin_AggrementSearch_DataRow.replace("@var", dealName), "First Deal in Searched Deal");
		Thread.sleep(3000);
		clickUsingJSExecutor(loc_Fin_ViewDeal, "View Deal");
		WaitForModalPanel();		
		
		

	}
	
	/**
	 * Parent Row starts from : 2,4,6,8
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_Payment_Parent_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueParent(loc_RI_Payment_Parent_HeaderRow.replace("@var", KeyValueFromExcel), HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Payment_Parent_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Payment_Parent_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}

		return locator;
	}

	/**
	 * Child Row starts from : 3,5,7,9
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_Payment_Child_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueChild(loc_RI_Payment_Child_Data_HeaderRow+ "[" + rowNumber +"]//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Payment_Child_Data_HeaderRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexValue +"')]";
					
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Payment_Child_Data_HeaderRow + "[" + rowNumber +"]//tr[@role='row']//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}

	public String getLocator_Assetvalue_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValueChild(loc_RI_Payment_Assetvalue_HeaderRow+ "//th", KeyValueFromExcel, HeadeNameFromExcel);
		System.out.println(classValue);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Payment_Assetvalue_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Payment_Assetvalue_DataRow + "[" + rowNumber +"]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}
	
	/**
	 * Parent Row starts from : 3,5,7,9
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @param SiblingRow Starts from 1,2,3,4...
	 * 
	 * Example: If you want to verify the second allocation row of First Parent then pass
	 * rowNumber = 3
	 * SiblingRow = 1
	 * @return
	 */
	public String getLocator_Child_DataRow_UnderSameParentRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel, String SiblingRow){
		String locator = "";
		String classValue = getClassValueChild(loc_RI_Payment_Child_Data_HeaderRow+ "//th", KeyValueFromExcel, HeadeNameFromExcel);
		String[] hexClass = classValue.split(" ");
		// Observation : When more than 2 classes are used in the Header then 2nd last class is common with the data row
		if(hexClass.length > 2) {
			for(String hexValue : hexClass) {
				if(hexValue.length()==10) {
					locator = loc_RI_Payment_Child_Data_HeaderRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexValue +"')]";
					break;
				}
				locator = "No_Attribute_Value";
			}
		} else {
			locator = loc_RI_Payment_Child_Data_HeaderRow + "[" + rowNumber +"]//tr[@role='row']/following-sibling::tr[" + SiblingRow + "]//td[contains(@class,'"+ hexClass[1] +"')]";
		}
		return locator;
	}

	public String getClassValueChild(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";

		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_Header = headerPath+"[@key='"+keyValue+"']";
			classValue =  getAttribute(loc_Header, "class");
		} 
		return classValue;
	}

	public String getClassValueParent(String headerLocator, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			classValue =  getAttribute(headerLocator, "class");
		} 
		return classValue;
	}



}


package excelDataBinding;

import utility.PropertyReader;

public interface RI_ExcelData {

	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\RI_TestData.xlsx");
	String ClientData = PropertyReader.readApplicationFile("Client");

	// RI_Common Data
	String RI_MasterAgree 						= xlsInputData.getCellData("RI_CommonData", ClientData, 3);
	String RI_AttachLink 						= xlsInputData.getCellData("RI_CommonData", ClientData, 4);
	String RI_StandAloneAgree 					= xlsInputData.getCellData("RI_CommonData", ClientData, 5);
	String RI_AttachMentfromMaster_Label 		= xlsInputData.getCellData("RI_CommonData", ClientData, 6);
	String RI_CopyAgreeMent 					= xlsInputData.getCellData("RI_CommonData", ClientData, 7);
	
	
	
	//// All Labels and Input fields present on the General TAB
	String RI_ProjectHeaderName 			= xlsInputData.getCellData("RI_CommonData", ClientData, 25);
	String RI_DealID_Label 					= xlsInputData.getCellData("RI_CommonData", ClientData, 26);
	String RI_DealDescription_Label 		= xlsInputData.getCellData("RI_CommonData", ClientData, 27);
	String RI_DealName_Label 				= xlsInputData.getCellData("RI_CommonData", ClientData, 28);
	String RI_DealType_Label 				= xlsInputData.getCellData("RI_CommonData", ClientData, 29);
	String RI_DealSubType_Label 			= xlsInputData.getCellData("RI_CommonData", ClientData, 30);
	String RI_ContractStatus_Label	 		= xlsInputData.getCellData("RI_CommonData", ClientData, 31);
	String RI_DataEntryContractStatus_Label = xlsInputData.getCellData("RI_CommonData", ClientData, 32);
	String RI_DateExecutedStatus_Label 		= xlsInputData.getCellData("RI_CommonData", ClientData, 33);
	String RI_DateEffectiveStatus_Label		= xlsInputData.getCellData("RI_CommonData", ClientData, 34);
	// One row is left blank in excel file :(
	String RI_ProfitCenter_Label 			= xlsInputData.getCellData("RI_CommonData", ClientData, 36);
	String RI_CurrentCurrency_Label			= xlsInputData.getCellData("RI_CommonData", ClientData, 37);
	String RI_BudgetLine_Label				= xlsInputData.getCellData("RI_CommonData", ClientData, 38);
	String RI_SkipWorkflow_Label 			= xlsInputData.getCellData("RI_CommonData", ClientData, 39);
	String RI_SBU_Label 					= xlsInputData.getCellData("RI_CommonData", ClientData, 40);
	String RI_DocType_Label 				= xlsInputData.getCellData("RI_CommonData", ClientData, 41);
	String RI_ProjectStatus_Label 			= xlsInputData.getCellData("RI_CommonData", ClientData, 42);
	String RI_ProjectID_Label 				= xlsInputData.getCellData("RI_CommonData", ClientData, 43);

	////All Labels and Input fields present on the Search Party window
	String RI_PartyHeaderName 				= xlsInputData.getCellData("RI_CommonData", ClientData, 106);
	String RI_EnterNameToSearch_Label 		= xlsInputData.getCellData("RI_CommonData", ClientData, 107);
	String RI_ExactMatch_Label 				= xlsInputData.getCellData("RI_CommonData", ClientData, 116);
	String RI_PartyHeader					= xlsInputData.getCellData("RI_CommonData", ClientData, 117);
	String RI_TypeHeader 					= xlsInputData.getCellData("RI_CommonData", ClientData, 118);
	 String DealCreationDealType 			= xlsInputData.getCellData("RI_CommonData", ClientData, 192);

	////All Buttons present on the Search Party window
	String RI_Add_Button				= xlsInputData.getCellData("RI_CommonData", ClientData, 124);
	String RI_Edit_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 125);
	String RI_view_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 126);
	String RI_Deactivate_Button	 		= xlsInputData.getCellData("RI_CommonData", ClientData, 127);
	String RI_Export_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 128);
	String RI_Select_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 129);
	String RI_Cancel_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 130);
	String RI_Find_Button	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 131);
	String RI_Activate_Button	 		= xlsInputData.getCellData("RI_CommonData", ClientData, 132);
	
	// Validation Messages
	String RI_SelectRowBeforeDelete	 			= xlsInputData.getCellData("RI_CommonData", ClientData, 151);
	String RI_SelectItemBeforeClickSelectBtn	= xlsInputData.getCellData("RI_CommonData", ClientData, 152);
	String RI_ValMsg_NoQueryFound				= xlsInputData.getCellData("RI_CommonData", ClientData, 153);
	String RI_ValMsg_SelectDeactivateParty		= xlsInputData.getCellData("RI_CommonData", ClientData, 154);
	String RI_ValMsg_PartyAlreadySelected		= xlsInputData.getCellData("RI_CommonData", ClientData, 155);
	String RI_ValMsg_SelectMinTwoParties		= xlsInputData.getCellData("RI_CommonData", ClientData, 156);
	String RI_ValMsg_ConfrmDeleteParty			= xlsInputData.getCellData("RI_CommonData", ClientData, 157);
	String RI_ValMsg_DealAlreadyExists			= xlsInputData.getCellData("RI_CommonData", ClientData, 158);
	String RI_ValMsg_SameDealCode				= xlsInputData.getCellData("RI_CommonData", ClientData, 159);
	String RI_ValMsg_WishToContinue				= xlsInputData.getCellData("RI_CommonData", ClientData, 160);
	
	
	// Test Data
	String RIDealSubtype 				= xlsInputData.getCellData("RI_CommonData", ClientData, 182);
	String RI_PartyName1 				= xlsInputData.getCellData("RI_CommonData", ClientData, 183);
	String RI_PartyName2 				= xlsInputData.getCellData("RI_CommonData", ClientData, 184);
	String RI_Partytype_Primary 				= xlsInputData.getCellData("RI_CommonData", ClientData, 185);
	String RI_Partytype2 				= xlsInputData.getCellData("RI_CommonData", ClientData, 186);
	String RI_Partytype_CreatePartyWindow_Outlet = xlsInputData.getCellData("RI_CommonData", ClientData, 221);
	String RI_Partytype2_CreatePartyWindow = xlsInputData.getCellData("RI_CommonData", ClientData, 188);
	String RI_DealCreationProfitCenter 	= xlsInputData.getCellData("RI_CommonData", ClientData, 189);
	String RI_DateExecuted 				= xlsInputData.getCellData("RI_CommonData", ClientData, 190);
	String RI_DateEffective		 		= xlsInputData.getCellData("RI_CommonData", ClientData, 191);
	
	String DealCreationCDEStatus 		= xlsInputData.getCellData("RI_CommonData", ClientData, 194);
	String DealCreationCurrency 		= xlsInputData.getCellData("RI_CommonData", ClientData, 195);
    String DealCreationProjectStatus 	= xlsInputData.getCellData("RI_CommonData", ClientData, 196);
    String DealCreationProjectID 		= xlsInputData.getCellData("RI_CommonData", ClientData, 197);
    String DealCreationBudgetLine 		= xlsInputData.getCellData("RI_CommonData", ClientData, 198);
    String RI_DealType_AquisitionProgram					= xlsInputData.getCellData("RI_CommonData", ClientData, 199);
    String RI_DealType		 								= xlsInputData.getCellData("RI_CommonData", ClientData, 200);
    String RI_ContractStatus_fullyExecuted 					= xlsInputData.getCellData("RI_CommonData", ClientData, 213);
    String RI_ContractStatus_InNegotiation 					= xlsInputData.getCellData("RI_CommonData", ClientData, 214);
    String RI_Partytype_CreatePartyWindow_Distributor 		= xlsInputData.getCellData("RI_CommonData", ClientData, 220);
    
	//RI_General
	String RI_Parties_PartyHeader_Key 	= xlsInputData.getCellData("RI_CommonData", "Keys", 87);
	String RI_Parties_POPUPIcon_Key 	= xlsInputData.getCellData("RI_CommonData", "Keys", 91);
	String RI_Parties_PartyType_Key   	= xlsInputData.getCellData("RI_CommonData", "Keys", 88);

	String RI_Parties_PartyLegend 		= xlsInputData.getCellData("RI_CommonData", ClientData, 86);
	String RI_Parties_PartyHeader 		= xlsInputData.getCellData("RI_CommonData", ClientData, 87);
	String RI_Parties_PartyType 		= xlsInputData.getCellData("RI_CommonData", ClientData, 88);
	String RI_Parties_AddButton   		= xlsInputData.getCellData("RI_CommonData", ClientData, 89);
	String RI_Parties_DeleteButton   	= xlsInputData.getCellData("RI_CommonData", ClientData, 90);

	//RI_Option - Global values
	String RIOPTIONAPPLIES_TO 			= xlsInputData.getCellData("RI_Options", "KeyValues", 2);
	String RIOPTIONTYPE 				= xlsInputData.getCellData("RI_Options", "KeyValues", 3);
	String RIOPTIONSERVICE_TYPE			= xlsInputData.getCellData("RI_Options", "KeyValues", 4);
	String NETWORK 						= xlsInputData.getCellData("RI_Options", "KeyValues", 5);
	String RIOPTIONMEDIA 				= xlsInputData.getCellData("RI_Options", "KeyValues", 6);
	String RIOPTIONTERRITORY 			= xlsInputData.getCellData("RI_Options", "KeyValues", 7);
	String ADDL_PROGRAMS 				= xlsInputData.getCellData("RI_Options", "KeyValues", 8);
	String FLAG_ADDL_PERPETUITY 		= xlsInputData.getCellData("RI_Options", "KeyValues", 9);
	String PROJECTED_EX_DATE 			= xlsInputData.getCellData("RI_Options", "KeyValues", 10);
	String OPTION_DEADLINE_DATE			= xlsInputData.getCellData("RI_Options", "KeyValues", 11);
	String FLAG_FIRST_NEGOT 			= xlsInputData.getCellData("RI_Options", "KeyValues", 12);
	String FLAG_FIRST_REFUSAL 			= xlsInputData.getCellData("RI_Options", "KeyValues", 13);
	String FLAG_LAST_REFUSAL 			= xlsInputData.getCellData("RI_Options", "KeyValues", 14);
	String BUDGET_INCREASE 				= xlsInputData.getCellData("RI_Options", "KeyValues", 15);
	String RIOPTIONCURRENCY 			= xlsInputData.getCellData("RI_Options", "KeyValues", 16);
	String OFFERED_AMOUNT 				= xlsInputData.getCellData("RI_Options", "KeyValues", 17);
	String OPTION_TERMS 				= xlsInputData.getCellData("RI_Options", "KeyValues", 18);
	String FLAG_EXERCISED 				= xlsInputData.getCellData("RI_Options", "KeyValues", 19);
	String FINAL_EXERCISED_DATE 		= xlsInputData.getCellData("RI_Options", "KeyValues", 20);
	String applies_to_popup 			= xlsInputData.getCellData("RI_Options", "KeyValues", 21);
	String SERVICE_TYPE_Ref_POPUP 		= xlsInputData.getCellData("RI_Options", "KeyValues", 22);
	String RIOPTIONMEDIA_UD_POPUP 		= xlsInputData.getCellData("RI_Options", "KeyValues", 23);
	String RIOPTIONTERRITORY_UD_POPUP 	= xlsInputData.getCellData("RI_Options", "KeyValues", 24);
	String ADDL_PERIOD_IMG 				= xlsInputData.getCellData("RI_Options", "KeyValues", 25);
	String PROJECTED_EX_DATE_IMAGE		= xlsInputData.getCellData("RI_Options", "KeyValues", 26);

	//////////////////////////////////========RI_MediaRights=====/////////////////////////////////////////////// 
	////Getting Client Specific Data: Buttons, DropDown etc. at Media Rights View Mode
	String RI_MediaRights_AppliesToLabel 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 3);
	String RI_MediaRights_AssetFilter 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 4);
	String RI_MediaRights_MultiSelectFilter 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 5);
	String RI_MediaRights_ClearFilterIcon 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 6);
	String RI_MediaRights_ClearFiltersButton 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 7);
	String RI_MediaRights_ShowAllRowsLabel		= xlsInputData.getCellData("RI_MediaRights", ClientData, 8);
	String RI_MediaRights_EditButton			= xlsInputData.getCellData("RI_MediaRights", ClientData, 9);
	String RI_MediaRights_SendReminderIcon		= xlsInputData.getCellData("RI_MediaRights", ClientData, 10);

	//// Getting All Keys
	String RI_MediaRights_ROW_NO_Key 						= xlsInputData.getCellData("RI_MediaRights", "Keys", 69);
	String RI_MediaRights_APPLIESTO_Key 					= xlsInputData.getCellData("RI_MediaRights", "Keys", 70);
	String RI_MediaRights_APPLIESTO_POPUP_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 71);
	//String FLAG_EXTCARVEOUT 								= xlsInputData.getCellData("RI_MediaRights", "Keys", 4);
	String RI_MediaRights_PARTY_Key 						= xlsInputData.getCellData("RI_MediaRights", "Keys", 72);
	String RI_MediaRights_PARTY_POPUP_Key 					= xlsInputData.getCellData("RI_MediaRights", "Keys", 73);
	String RI_MediaRights_MEDIA_TEMPLATE_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 74);
	String RI_MediaRights_MEDIA_UD_POPUP_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 75);

	String RI_MediaRights_ENDUSER_RIGHTS_TEMPLATE_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 76);
	String RI_MediaRights_ENDUSER_RIGHTS_UD_POPUP_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 77);

	String RI_MediaRights_VENUE_TEMPLATE_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 78);
	String RI_MediaRights_VENUE_UD_POPUP_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 79);

	String RI_MediaRights_PKGING_RIGHTS_TEMPLATE_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 80);
	String RI_MediaRights_PKGING_RIGHTS_UD_POPUP_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 81);

	String RI_MediaRights_TOUCHPOINT_TEMPLATE_Key			= xlsInputData.getCellData("RI_MediaRights", "Keys", 82);
	String RI_MediaRights_TOUCHPOINT_UD_POPUP_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 83);

	String RI_MediaRights_BUSINESS_OUTLET_TEMPLATE_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 84);
	String RI_MediaRights_BUSINESS_OUTLET_UD_POPUP_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 85);

	String RI_MediaRights_TERRITORY_TEMPLATE_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 86);
	String RI_MediaRights_TERRITORY_UD_POPUP_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 87);

	String RI_MediaRights_LANGUAGE_TEMLATE_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 88);
	String RI_MediaRights_LANGUAGE_UD_POPUP_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 89);

	String RI_MediaRights_FLAG_PERPETUITY_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 90);
	String RI_MediaRights_TERM_FROM_DATE_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 91);
	String RI_MediaRights_TERMEVENT_POPUP_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 92);

	String RI_MediaRights_TERM_TO_DATE_Key 					= xlsInputData.getCellData("RI_MediaRights", "Keys", 93);
	String RI_MediaRights_FLAG_EXCLUSIVITY_Key	 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 94);
	String RI_MediaRights_FLAG_RESTRICTION_TYPE_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 95);
	String RI_MediaRights_FLAG_THIRD_PARTY_SUBLICENSE_Key 	= xlsInputData.getCellData("RI_MediaRights", "Keys", 96);
	String RI_MediaRights_BUSINESS_TERMS_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 97);
	String RI_Property_ElementAsset_Key 			 	    = xlsInputData.getCellData("RI_MediaRights", "Keys", 104);

	// Getting Client Specific Data: Header Name at View Mode
	String RI_MediaRights_ViewMode_ROW_NO_HeaderName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 20);
	String RI_MediaRights_ViewMode_APPLIESTO_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 21);
	//String RI_MediaRights_ViewMode_FLAG_EXTCARVEOUT 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 4);
	String RI_MediaRights_ViewMode_PARTY_HeaderName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 22);
	String RI_MediaRights_ViewMode_MEDIA_TEMPLATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 23);
	String RI_MediaRights_ViewMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 24);
	String RI_MediaRights_ViewMode_VENUE_TEMPLATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 25);
	String RI_MediaRights_ViewMode_PKGING_RIGHTS_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 26);
	String RI_MediaRights_ViewMode_TOUCHPOINT_TEMPLATE_HeaderName			= xlsInputData.getCellData("RI_MediaRights", ClientData, 27);
	String RI_MediaRights_ViewMode_BUSINESS_OUTLET_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 28);
	String RI_MediaRights_ViewMode_TERRITORY_TEMPLATE_HeaderName 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 29);
	String RI_MediaRights_ViewMode_LANGUAGE_TEMPLATE_HeaderName 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 30);
	String RI_MediaRights_ViewMode_FLAG_PERPETUITY_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 31);
	String RI_MediaRights_ViewMode_TERM_FROM_DATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 32);
	String RI_MediaRights_ViewMode_TERM_TO_DATE_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 33);
	String RI_MediaRights_ViewMode_FLAG_EXCLUSIVITY_HeaderName	 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 34);
	String RI_MediaRights_ViewMode_FLAG_RESTRICTION_TYPE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 35);
	String RI_MediaRights_ViewMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName	= xlsInputData.getCellData("RI_MediaRights", ClientData, 36);
	String RI_MediaRights_ViewMode_BUSINESS_TERMS_HeaderName 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 37);

	// Keys and Values at Business Term/Notes Window
	String RI_MediaRights_NoteWind_Category_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 98);
	String RI_MediaRights_NoteWind_Template_Key	 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 99);
	String RI_MediaRights_NoteWind_Notes_Key 				= xlsInputData.getCellData("RI_MediaRights", "Keys", 100);
	String RI_MediaRights_NoteWind_Restriction_Key 			= xlsInputData.getCellData("RI_MediaRights", "Keys", 101);
	String RI_MediaRights_NoteWind_includeInReport_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 102);
	String RI_MediaRights_NoteWind_TemplatePopup_Key 		= xlsInputData.getCellData("RI_MediaRights", "Keys", 103);
	// Header Names of Business Term/Notes Window
	String RI_MediaRights_NoteWind_Category_HeaderName 			= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 98);
	String RI_MediaRights_NoteWind_Template_HeaderName	 		= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 99);
	String RI_MediaRights_NoteWind_Notes_HeaderName 			= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 100);
	String RI_MediaRights_NoteWind_Restriction_HeaderName 		= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 101);
	String RI_MediaRights_NoteWind_includeInReport_HeaderName 	= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 102);
	String RI_MediaRights_NoteWind_TemplatePopup_HeaderName 	= xlsInputData.getCellData("RI_MediaRights_NoteWind_", ClientData, 103);

	//// Getting Client Specific Data: Header Name at Edit Mode
	String RI_MediaRights_EditMode_ROW_NO_HeaderName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 69);
	String RI_MediaRights_EditMode_APPLIESTO_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 70);
	//String RI_MediaRights_EditMode_FLAG_EXTCARVEOUT 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 4);
	String RI_MediaRights_EditMode_PARTY_HeaderName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 72);
	String RI_MediaRights_EditMode_MEDIA_TEMPLATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 74);
	String RI_MediaRights_EditMode_ENDUSER_RIGHTS_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 76);
	String RI_MediaRights_EditMode_VENUE_TEMPLATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 78);
	String RI_MediaRights_EditMode_PKGING_RIGHTS_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 80);
	String RI_MediaRights_EditMode_TOUCHPOINT_TEMPLATE_HeaderName			= xlsInputData.getCellData("RI_MediaRights", ClientData, 82);
	String RI_MediaRights_EditMode_BUSINESS_OUTLET_TEMPLATE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 84);
	String RI_MediaRights_EditMode_TERRITORY_TEMPLATE_HeaderName 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 86);
	String RI_MediaRights_EditMode_LANGUAGE_TEMPLATE_HeaderName 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 88);
	String RI_MediaRights_EditMode_FLAG_PERPETUITY_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 90);
	String RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 91);
	String RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 93);
	String RI_MediaRights_EditMode_FLAG_EXCLUSIVITY_HeaderName	 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 94);
	String RI_MediaRights_EditMode_FLAG_RESTRICTION_TYPE_HeaderName 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 95);
	String RI_MediaRights_EditMode_FLAG_THIRD_PARTY_SUBLICENSE_HeaderName	= xlsInputData.getCellData("RI_MediaRights", ClientData, 96);
	String RI_BUSINESS_TERMS_HeaderName 			 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 97);
	String RI_Property_ElementAsset_HeaderName 			 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 104);

	// Term Event dialog
	String RI_TERMEvent_DurationLabel 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 3);
	String RI_TERMEvent_PerpetuityCheckBox 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 4);
	String RI_TERMEvent_CommencingOn 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 5);
	String RI_TERMEvent_StartDateLabel 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 6);
	String RI_TERMEvent_RollingCheckBox 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 7);
	// Commencing On
	String RI_TERMEvent_EventHeader 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 8);
	String RI_TERMEvent_Operator1Header 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 9);
	String RI_TERMEvent_NumberHeader 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 10);
	String RI_TERMEvent_PeriodHeader 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 11);
	String RI_TERMEvent_DateHeader 			 		= xlsInputData.getCellData("RI_TermEvent", ClientData, 12);
	String RI_TERMEvent_DealNameHeader 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 13);
	String RI_TERMEvent_MRRowHeader 			 	= xlsInputData.getCellData("RI_TermEvent", ClientData, 15);
	String RI_TERMEvent_Operator2Header 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 17);
	String RI_TERMEvent_WhichEverComesLabel 		= xlsInputData.getCellData("RI_TermEvent", ClientData, 18);
	String RI_TERMEvent_ButNoLaterLabel 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 19);
	String RI_TERMEvent_EstimatedDateLabel 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 20);
	String RI_TERMEvent_StartDateUnKnownLabel 		= xlsInputData.getCellData("RI_TermEvent", ClientData, 21);

	// Keys of Term Event Dialog Box
	String RI_TERMEvent_EventKey 			 		= xlsInputData.getCellData("RI_TermEvent", "Keys", 8);
	String RI_TERMEvent_Operator1Key 				= xlsInputData.getCellData("RI_TermEvent", "Keys", 9);
	String RI_TERMEvent_NumberKey 			 		= xlsInputData.getCellData("RI_TermEvent", "Keys", 10);
	String RI_TERMEvent_PeriodKey 			 		= xlsInputData.getCellData("RI_TermEvent", "Keys", 11);
	String RI_TERMEvent_DateKey 			 		= xlsInputData.getCellData("RI_TermEvent", "Keys", 12);
	String RI_TERMEvent_DealNameKey 				= xlsInputData.getCellData("RI_TermEvent", "Keys", 13);
	String RI_TERMEvent_DealNamePopUpKey 			= xlsInputData.getCellData("RI_TermEvent", "Keys", 14);
	String RI_TERMEvent_MRRowKey 			 		= xlsInputData.getCellData("RI_TermEvent", "Keys", 15);
	String RI_TERMEvent_MRRowPopUpKey 				= xlsInputData.getCellData("RI_TermEvent", "Keys", 16);
	String RI_TERMEvent_Operator2Key 				= xlsInputData.getCellData("RI_TermEvent", "Keys", 17);
	// Ending On

	String RI_TERMEvent_EndingOnLabel		 		= xlsInputData.getCellData("RI_TermEvent", ClientData, 42);
	String RI_TERMEvent_EndDateLabel		 		= xlsInputData.getCellData("RI_TermEvent", ClientData, 43);




	String RI_TERMEvent_OK							= xlsInputData.getCellData("RI_TermEvent", ClientData, 22);
	String RI_TERMEvent_Cancel			 			= xlsInputData.getCellData("RI_TermEvent", ClientData, 23);
	String RI_TERMEvent_TrackingEvents				= xlsInputData.getCellData("RI_TermEvent", ClientData, 24);

	//Test Data
	String RI_TERMEvent_StartDate					= xlsInputData.getCellData("RI_TermEvent", ClientData, 71);
	String RI_TERMEvent_EndDate						= xlsInputData.getCellData("RI_TermEvent", ClientData, 72);
	String RI_TERMEvent_OperatorPlus				= xlsInputData.getCellData("RI_TermEvent", ClientData, 73);
	String RI_TERMEvent_OperatorMinus				= xlsInputData.getCellData("RI_TermEvent", ClientData, 74);
	String RI_TERMEvent_Day							= xlsInputData.getCellData("RI_TermEvent", ClientData, 75);
	String RI_TERMEvent_Week						= xlsInputData.getCellData("RI_TermEvent", ClientData, 76);
	String RI_TERMEvent_Month						= xlsInputData.getCellData("RI_TermEvent", ClientData, 77);
	String RI_TERMEvent_Year						= xlsInputData.getCellData("RI_TermEvent", ClientData, 78);




	////////////////////////////////TERM EVENTS/////////////////////////////////////////////

	////////////////////////////////BUSINESS_TERMS_/////////////////////////////////////////////

	String RI_BUSINESS_TERMS_Header1 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 98);
	String RI_BUSINESS_TERMS_Header2 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 99);
	String RI_BUSINESS_TERMS_Header3 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 100);
	String RI_BUSINESS_TERMS_Header4 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 101);
	String RI_BUSINESS_TERMS_Header5 			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 102);
	//// Header's Pop up Status at Edit Mode
	String RI_MediaRights_APPLIESTO_POPUP 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 71);
	String RI_MediaRights_PARTY_POPUP 							= xlsInputData.getCellData("RI_MediaRights", ClientData, 73);
	String RI_MediaRights_MEDIA_UD_POPUP 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 75);
	String RI_MediaRights_ENDUSER_RIGHTS_UD_POPUP_POPUP 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 77);
	String RI_MediaRights_VENUE_UD_POPUP 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 79);
	String RI_MediaRights_PKGING_RIGHTS_UD_POPUP 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 81);
	String RI_MediaRights_TOUCHPOINT_UD_POPUP 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 83);
	String RI_MediaRights_BUSINESS_OUTLET_UD_POPUP 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 85);
	String RI_MediaRights_TERRITORY_UD_POPUP 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 87);
	String RI_MediaRights_LANGUAGE_UD_POPUP 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 89);
	String RI_MediaRights_TERMEVENT_POPUP 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 92);

	//// Buttons, DropDown etc. at Media Rights Edit Window
	String RI_MediaRights_EditMode_MediaRights_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 117);
	String RI_MediaRights_EditMode_Alphabet_LabelName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 118);
	String RI_MediaRights_EditMode_Alphabet_DropDown 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 119);
	String RI_MediaRights_EditMode_Alphabet_MultiSelect 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 120);
	String RI_MediaRights_EditMode_AppliesTo_LabelName 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 121);
	String RI_MediaRights_EditMode_AppliesTo_DropDown 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 122);
	String RI_MediaRights_EditMode_AppliesToMultiSelect						= xlsInputData.getCellData("RI_MediaRights", ClientData, 123);
	String RI_MediaRights_EditMode_FirstLetter_LabelName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 124);
	String RI_MediaRights_EditMode_AppliesToFilter_LabelName 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 125);
	String RI_MediaRights_EditMode_ClearFilter 								= xlsInputData.getCellData("RI_MediaRights", ClientData, 126);
	//// Buttons
	String RI_MediaRights_EditMode_CopyColumns_Button 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 127);
	String RI_MediaRights_EditMode_CopyRows_Buttons 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 128);
	String RI_MediaRights_EditMode_AddButton								= xlsInputData.getCellData("RI_MediaRights", ClientData, 129);
	String RI_MediaRights_EditMode_DeleteButton 							= xlsInputData.getCellData("RI_MediaRights", ClientData, 130);
	String RI_MediaRights_EditMode_SaveButton 								= xlsInputData.getCellData("RI_MediaRights", ClientData, 131);
	String RI_MediaRights_EditMode_closeButton								= xlsInputData.getCellData("RI_MediaRights", ClientData, 132);

	//// Buttons at Note Window
	String RI_NoteWindow_AddButton							= xlsInputData.getCellData("RI_MediaRights", ClientData, 141);
	String RI_NoteWindow_DeleteButton 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 142);
	String RI_NoteWindow_SaveButton 						= xlsInputData.getCellData("RI_MediaRights", ClientData, 143);			
	String RI_NoteWindow_CancelButton						= xlsInputData.getCellData("RI_MediaRights", ClientData, 144);

	//// RI_MediaRights : Template window Name of Media Rights TAB in Edit Window
	String RI_MediaRights_EditMode_Template_AppliesTo_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 153);
	String RI_MediaRights_EditMode_Template_PartySelection_HeaderName  				= xlsInputData.getCellData("RI_MediaRights", ClientData, 154);
	String RI_MediaRights_EditMode_Template_MediaType_HeaderName  					= xlsInputData.getCellData("RI_MediaRights", ClientData, 155);
	String RI_MediaRights_EditMode_Template_UsageRights_HeaderName  				= xlsInputData.getCellData("RI_MediaRights", ClientData, 156);
	String RI_MediaRights_EditMode_Template_Venue_HeaderName  						= xlsInputData.getCellData("RI_MediaRights", ClientData, 157);
	String RI_MediaRights_EditMode_Template_PlatformRestriction_HeaderName  		= xlsInputData.getCellData("RI_MediaRights", ClientData, 158);
	String RI_MediaRights_EditMode_Template_Restriction_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 159);
	String RI_MediaRights_EditMode_Template_Business_HeaderName 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 160);
	String RI_MediaRights_EditMode_Template_Territory_HeaderName 				    = xlsInputData.getCellData("RI_MediaRights", ClientData, 161);
	String RI_MediaRights_EditMode_Template_Language_HeaderName  					= xlsInputData.getCellData("RI_MediaRights", ClientData, 162);
	String RI_MediaRights_EditMode_Template_TermEvent_HeaderName  					= xlsInputData.getCellData("RI_MediaRights", ClientData, 163);
	String RI_MediaRights_EditMode_Template_NoteWindow_HeaderName  					= xlsInputData.getCellData("RI_MediaRights", ClientData, 164);

	//// RI_MediaRights : Buttons available at Template window of Media Rights TAB in Edit Window
	String RI_MediaRights_EditMode_ExpandAll_Button 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 191);
	String RI_MediaRights_EditMode_CollapseAll_Button   = xlsInputData.getCellData("RI_MediaRights", ClientData, 192);
	String RI_MediaRights_EditMode_SelectAll_Button   	= xlsInputData.getCellData("RI_MediaRights", ClientData, 193);
	String RI_MediaRights_EditMode_DeSelectAll_Button   = xlsInputData.getCellData("RI_MediaRights", ClientData, 194);
	String RI_MediaRights_EditMode_Apply_Button   		= xlsInputData.getCellData("RI_MediaRights", ClientData, 195);
	String RI_MediaRights_EditMode_Cancel_Button   		= xlsInputData.getCellData("RI_MediaRights", ClientData, 196);
	String RI_MediaRights_EditMode_Search_Button  		= xlsInputData.getCellData("RI_MediaRights", ClientData, 197);
	String RI_MediaRights_EditMode_CrossIcon  			= xlsInputData.getCellData("RI_MediaRights", ClientData, 198);

	//// RI_MediaRights : Alert/Validation Messages
	String RI_MediaRights_EditMode_EnterRequiredFields 					= xlsInputData.getCellData("RI_MediaRights", ClientData, 216);
	String RI_MediaRights_EditMode_SelectAtLeastOneElement 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 217);
	String RI_MediaRights_EditMode_MediaType_SelectAtLeastOneElement 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 218);
	String RI_MediaRights_EditMode_DataSaved 							= xlsInputData.getCellData("RI_MediaRights", ClientData, 219);
	String RI_MediaRights_EditMode_DataSavedSuccessfully 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 220);
	String RI_NavigateAwayPopup 										= xlsInputData.getCellData("RI_MediaRights", ClientData, 221);
	String RI_MediaRights_AssetUnlinkFromDeal_ValidationMessage 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 222);
	String RI_MediaRights_SelectRowToCopy_ValidationMessage 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 223);
	String RI_MediaRights_EnterNoOfCopies_ValidationMessage 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 224);
	String RI_MediaRights_EnterNoOfCopies_InvalidNumber_ValidationMessage 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 225);
	String RI_MediaRights_SelectRowBeforeCopyColumn_ValidationMessage 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 226);
	String RI_MediaRights_SaveRowBeforeCopyColumn_ValidationMessage 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 227);
	String RI_MediaRights_SelectRowToDelete_ValidationMessage 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 228);
	String RI_MediaRights_ConfirmationToDeleteRow_ValidationMessage 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 229);
	String RI_MediaRights_EditMode_DataSavedSuccessfullyWithUpdatedFilter 			= xlsInputData.getCellData("RI_MediaRights", ClientData, 230);
	String RI_MediaRights_EditMode_ChangeFilterConfirmation_ValidationMessage 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 231);
	String RI_MediaRights_EditMode_NoMathingFound_ValidationMessage 				= xlsInputData.getCellData("RI_MediaRights", ClientData, 232);
	String RI_MediaRights_EditMode_TermToGreaterThanTermFrom_ValidationMessage 		= xlsInputData.getCellData("RI_MediaRights", ClientData, 233);


	// Edit Mode >> Test Data
	String RI_MediaRights_EditMode_AppliesToDropDown_ValueAll			= xlsInputData.getCellData("RI_MediaRights", ClientData, 251);
	String RI_MediaRights_Season1				= xlsInputData.getCellData("RI_MediaRights", ClientData, 252);
	String RI_MediaRights_Episode101			= xlsInputData.getCellData("RI_MediaRights", ClientData, 253);
	String RI_MediaRights_Episode102			= xlsInputData.getCellData("RI_MediaRights", ClientData, 254);
	String RI_MediaRights_Season2				= xlsInputData.getCellData("RI_MediaRights", ClientData, 255);
	String RI_MediaRights_Episode201			= xlsInputData.getCellData("RI_MediaRights", ClientData, 256);
	String RI_MediaRights_Episode202			= xlsInputData.getCellData("RI_MediaRights", ClientData, 257);
	String RI_MediaRights_MediaType_Search		= xlsInputData.getCellData("RI_MediaRights", ClientData, 258);
	String RI_MediaRights_Venue_Search			= xlsInputData.getCellData("RI_MediaRights", ClientData, 259);
	String RI_MediaRights_Platform_Search		= xlsInputData.getCellData("RI_MediaRights", ClientData, 260);
	String RI_MediaRights_Restriction_Search	= xlsInputData.getCellData("RI_MediaRights", ClientData, 261);
	String RI_MediaRights_BusinessOutLet_Search	= xlsInputData.getCellData("RI_MediaRights", ClientData, 262);
	String RI_MediaRights_Territory_Search		= xlsInputData.getCellData("RI_MediaRights", ClientData, 263);
	String RI_MediaRights_Language_Search		= xlsInputData.getCellData("RI_MediaRights", ClientData, 264);
	String RI_MediaRights_UserDefinedSeason						= xlsInputData.getCellData("RI_MediaRights", ClientData, 265);
	String RI_MediaRights_UserDefinedSeasonEpisode101			= xlsInputData.getCellData("RI_MediaRights", ClientData, 266);
	String RI_MediaRights_UserDefinedSeasonEpisode102			= xlsInputData.getCellData("RI_MediaRights", ClientData, 267);
	String RI_MediaRights_UserDefinedSeasonEpisode103				= xlsInputData.getCellData("RI_MediaRights", ClientData, 268);

	String RI_MediaRights_MediaType_DropDownValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 282);
	String RI_MediaRights_Venue_DropDownValues			= xlsInputData.getCellData("RI_MediaRights", ClientData, 283);
	String RI_MediaRights_Platform_DropDownValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 284);
	String RI_MediaRights_Restriction_DropDownValues	= xlsInputData.getCellData("RI_MediaRights", ClientData, 285);
	String RI_MediaRights_BusinessOutLet_DropDownValues	= xlsInputData.getCellData("RI_MediaRights", ClientData, 286);
	String RI_MediaRights_Territory_DropDownValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 287);
	String RI_MediaRights_Language_DropDownValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 288);
	String RI_MediaRights_TermToDefaultData			 	= xlsInputData.getCellData("RI_MediaRights", ClientData, 289);
	String RI_MediaRights_TermToTestData				= xlsInputData.getCellData("RI_MediaRights", ClientData, 290);
	String RI_MediaRights_TermFromTestData				= xlsInputData.getCellData("RI_MediaRights", ClientData, 291);
	String RI_MediaRights_Restriction_DropDownValues1	= xlsInputData.getCellData("RI_MediaRights", ClientData, 292);
	String RI_MediaRights_Restriction_DropDownValues2		= xlsInputData.getCellData("RI_MediaRights", ClientData, 293);
	String RI_MediaRights_Restriction_DropDownValues3		= xlsInputData.getCellData("RI_MediaRights", ClientData, 294);
	String RI_MediaRights_Restriction_DropDownValues4		= xlsInputData.getCellData("RI_MediaRights", ClientData, 295);
	String RI_MediaRights_SubLicense_DropDownValues1		= xlsInputData.getCellData("RI_MediaRights", ClientData, 299);
	String RI_MediaRights_SubLicense_DropDownValues2		= xlsInputData.getCellData("RI_MediaRights", ClientData, 300);
	String RI_MediaRights_SubLicense_DropDownValues3		= xlsInputData.getCellData("RI_MediaRights", ClientData, 301);
	String RI_MediaRights_SubLicense_DropDownValues4		= xlsInputData.getCellData("RI_MediaRights", ClientData, 302);
	String RI_MediaRights_SubLicense_DropDownValues5		= xlsInputData.getCellData("RI_MediaRights", ClientData, 303);
	String RI_MediaRights_SubLicense_DropDownValues6		= xlsInputData.getCellData("RI_MediaRights", ClientData, 304);
	String RI_MediaRights_SubLicense_DropDownValues7		= xlsInputData.getCellData("RI_MediaRights", ClientData, 305);
	String RI_MediaRights_SubLicense_DropDownValues8		= xlsInputData.getCellData("RI_MediaRights", ClientData, 306);
	String RI_MediaRights_SubLicense_DropDownValues9		= xlsInputData.getCellData("RI_MediaRights", ClientData, 307);

	String RI_MediaRights_Note_BusinessTerm1				= xlsInputData.getCellData("RI_MediaRights", ClientData, 310);
	String RI_MediaRights_Note_UseTemplate1					= xlsInputData.getCellData("RI_MediaRights", ClientData, 311);
	String RI_MediaRights_EndUsersRights_DropDownValue					= xlsInputData.getCellData("RI_MediaRights", ClientData, 312);

	String RI_MediaRights_MediaType_PickListValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 321);
	String RI_MediaRights_Venue_PickListValues			= xlsInputData.getCellData("RI_MediaRights", ClientData, 322);
	String RI_MediaRights_Platform_PickListValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 323);
	String RI_MediaRights_Restriction_PickListValues	= xlsInputData.getCellData("RI_MediaRights", ClientData, 324);
	String RI_MediaRights_BusinessOutLet_PickListValues	= xlsInputData.getCellData("RI_MediaRights", ClientData, 325);
	String RI_MediaRights_Territory_PickListValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 326);
	String RI_MediaRights_Language_PickListValues		= xlsInputData.getCellData("RI_MediaRights", ClientData, 327);




	//RI_ExhibitionsRights - Global values
	//////////////View mode////////////////////////////////
	//Keys of Parent Headers in View Window	
	// These Keys are applicable for Edit mode as well as View Mode
	String RI_Exh_MEDIA_ROW_Parent_Key				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 3);
	String RI_Exh_ExhibitAPPLIESTO_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 4);
	String RI_Exh_UNLIMITED_Key 					= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 5);
	String RI_Exh_EXHIBITIONDATEUPDATE_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 6);
	String RI_Exh_EXHIBITION_DAYS_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 7);
	String RI_Exh_RESERVED_EXHIBITION_DAYS_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 8);
	String RI_Exh_POOLED_Key 						= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 9);
	String RI_Exh_EXHIBITIONDAYSCOPE_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 10);
	String RI_Exh_STARTDATE_Key 					= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 11);
	String RI_Exh_ENDDATE_Key 						= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 12);
	String RI_Exh_ExhibitBUSINESS_TERMS_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 13);

	//Keys of Child Headers in View Window							
	String RI_Exh_Child_MEDIA_ROW_ORDER_ID_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 25);
	String RI_Exh_Child_WINDOWNAME_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 26);
	String RI_Exh_Child_WINDOW_TYPE_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 27);
	String RI_Exh_Child_RIGHTSTYPE_Key_ViewMode 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 28);
	String RI_Exh_Child_EXHIBITION_DAYS_CHILD_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 29);
	String RI_Exh_Child_MAX_EXHIBITION_DAYS_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 30);
	String RI_Exh_Child_POOLED_CHILD_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 31);
	String RI_Exh_Child_STARTDATECHILD_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 32);
	String RI_Exh_Child_ENDDATECHILD_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 33);
	String RI_Exh_Child_NETWORK_SUMMARY_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 34);
	String RI_Exh_Child_TERRITORY_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 35);
	String RI_Exh_Child_EXHIBITIONDAYTYPE_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 36);
	String RI_Exh_Child_EXHIBITIONDAYPERIOD_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 37);
	String RI_Exh_Child_PLAYSPEREXHIBITION_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 38);
	String RI_Exh_Child_ADDLNETWORKUSAGE_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 39);
	String RI_Exh_Child_RID_RATING_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 40);
	/*
	String RI_Exh_ViewMode_Parent_ExhibitAPPLIESTO_POPUP_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 64);
	String RI_Exh_ViewMode_MEDIA_ROW_ORDER_POPUP_Key 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 62);
	String RI_Exh_ViewMode_Child_NETWORK_POPUP_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 96);
	String RI_Exh_ViewMode_Child_ExhibitTERRITORY_UD_POPUP_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 98);
	String RI_Exh_ViewMode_Child_DAYPART_POPUP_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 100);*/

	//Parent Headers in View Window							
	String RI_Exh_ViewMode_MEDIA_ROW_Parent_Header				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 3);
	String RI_Exh_ViewMode_ExhibitAPPLIESTO_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 4);
	String RI_Exh_ViewMode_UNLIMITED_Header 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 5);
	String RI_Exh_ViewMode_EXHIBITIONDATEUPDATE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 6);
	String RI_Exh_ViewMode_EXHIBITION_DAYS_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 7);
	String RI_Exh_ViewMode_RESERVED_EXHIBITION_DAYS_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 8);
	String RI_Exh_ViewMode_POOLED_Header 						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 9);
	String RI_Exh_ViewMode_EXHIBITIONDAYSCOPE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 10);
	String RI_Exh_ViewMode_STARTDATE_Header 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 11);
	String RI_Exh_ViewMode_ENDDATE_Header 						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 12);
	String RI_Exh_ViewMode_ExhibitBUSINESS_TERMS_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 13);

	//Child Headers in View Window							
	String RI_Exh_ViewMode_Child_MEDIA_ROW_ORDER_ID_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 25);
	String RI_Exh_ViewMode_Child_WINDOWNAME_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 26);
	String RI_Exh_ViewMode_Child_WINDOW_TYPE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 27);
	String RI_Exh_ViewMode_Child_RIGHTSTYPE_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 28);
	String RI_Exh_ViewMode_Child_EXHIBITION_DAYS_CHILD_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 29);
	String RI_Exh_ViewMode_Child_MAX_EXHIBITION_DAYS_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 30);
	String RI_Exh_ViewMode_Child_POOLED_CHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 31);
	String RI_Exh_ViewMode_Child_STARTDATECHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 32);
	String RI_Exh_ViewMode_Child_ENDDATECHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 33);
	String RI_Exh_ViewMode_Child_NETWORK_SUMMARY_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 34);
	String RI_Exh_ViewMode_Child_TERRITORY_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 35);
	String RI_Exh_ViewMode_Child_EXHIBITIONDAYTYPE_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 36);
	String RI_Exh_ViewMode_Child_EXHIBITIONDAYPERIOD_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 37);
	String RI_Exh_ViewMode_Child_PLAYSPEREXHIBITION_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 38);
	String RI_Exh_ViewMode_Child_ADDLNETWORKUSAGE_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 39);
	String RI_Exh_ViewMode_Child_RID_RATING_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 40);

	////Getting Client Specific Data: Buttons, DropDown etc. at Media Rights View Mode
	String RI_Exh_AppliesToLabel 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 209);
	String RI_Exh_AssetFilter 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 210);
	String RI_Exh_MultiSelectFilter 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 211);
	String RI_Exh_ClearFilterIcon 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 212);
	String RI_Exh_ClearFiltersButton 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 213);
	String RI_Exh_ShowAllRowsLabel		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 214);
	String RI_Exh_EditButton			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 215);
	String RI_Exh_SendReminderIcon		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 216);
	String RI_Exh_ViewMode_ExpandButton				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 217);
	String RI_Exh_ViewMode_CollapseButton			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 218);



	//////////////Edit mode////////////////////////////////
	String RI_Exh_Child_RIGHTSTYPE_Key_EditMode 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 88);
	String RI_Exh_Child_STARTDATECHILD_Key_EditMode 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 93);
	String RI_Exh_Child_ENDDATECHILD_Key_EditMode 		= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 94);
	//Parent Headers of in Edit Window							
	String RI_Exh_EditMode_MEDIA_ROW_Parent_Header				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 61);
	String RI_Exh_EditMode_MEDIA_ROW_PopUp						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 62);
	String RI_Exh_EditMode_ExhibitAPPLIESTO_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 63);
	String RI_Exh_EditMode_UNLIMITED_Header 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 65);
	String RI_Exh_EditMode_EXHIBITIONDATEUPDATE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 66);
	String RI_Exh_EditMode_EXHIBITION_DAYS_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 67);
	String RI_Exh_EditMode_RESERVED_EXHIBITION_DAYS_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 68);
	String RI_Exh_EditMode_POOLED_Header 						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 69);
	String RI_Exh_EditMode_EXHIBITIONDAYSCOPE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 70);
	String RI_Exh_EditMode_STARTDATE_Header 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 71);
	String RI_Exh_EditMode_ENDDATE_Header 						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 72);
	String RI_Exh_EditMode_ExhibitBUSINESS_TERMS_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 73);

	//Child Headers of in Edit Window							
	String RI_Exh_EditMode_Child_MEDIA_ROW_ORDER_ID_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 84);
	String RI_Exh_EditMode_Child_WINDOWNAME_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 86);
	String RI_Exh_EditMode_Child_WINDOW_TYPE_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 87);
	String RI_Exh_EditMode_Child_RIGHTSTYPE_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 88);
	String RI_Exh_EditMode_Child_EXHIBITION_DAYS_CHILD_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 90);
	String RI_Exh_EditMode_Child_MAX_EXHIBITION_DAYS_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 91);
	String RI_Exh_EditMode_Child_POOLED_CHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 92);
	String RI_Exh_EditMode_Child_STARTDATECHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 93);
	String RI_Exh_EditMode_Child_ENDDATECHILD_Header 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 94);
	String RI_Exh_EditMode_Child_NETWORK_SUMMARY_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 95);
	String RI_Exh_EditMode_Child_TERRITORY_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 97);
	String RI_Exh_EditMode_Child_DayPartSummary_Header			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 99);
	String RI_Exh_EditMode_Child_EXHIBITIONDAYTYPE_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 101);
	String RI_Exh_EditMode_Child_EXHIBITIONDAYPERIOD_Header 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 102);
	String RI_Exh_EditMode_Child_PLAYSPEREXHIBITION_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 103);
	String RI_Exh_EditMode_Child_ADDLNETWORKUSAGE_Header 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 104);
	String RI_Exh_EditMode_Child_RID_RATING_Header 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 105);

	// Pop up keys
	String RI_Exh_EditMode_MEDIA_ROW_ORDER_POPUP_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 85);// Key is same for child and parent row
	String RI_Exh_EditMode_Parent_ExhibitAPPLIESTO_POPUP_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 64);
	String RI_Exh_EditMode_Child_RIGHTSTYPE_POPUP_Key 			= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 89);
	String RI_Exh_EditMode_Child_NETWORK_POPUP_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 96);
	String RI_Exh_EditMode_Child_ExhibitTERRITORY_UD_POPUP_Key 	= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 98);
	String RI_Exh_EditMode_Child_DAYPART_POPUP_Key 				= xlsInputData.getCellData("RI_ExhibitionRights", "Keys", 100);

	////Buttons, DropDown etc. at Exhibition Rights Edit Window
	String RI_Exh_EditMode_Exh_HeaderName 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 121);
	String RI_Exh_EditMode_Alphabet_LabelName 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 122);
	String RI_Exh_EditMode_Alphabet_DropDown 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 123);
	String RI_Exh_EditMode_Alphabet_MultiSelect 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 124);
	String RI_Exh_EditMode_AppliesTo_LabelName 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 125);
	String RI_Exh_EditMode_AppliesTo_DropDown 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 126);
	String RI_Exh_EditMode_AppliesToMultiSelect				=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 127);
	String RI_Exh_EditMode_FirstLetter_LabelName 			=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 128);
	String RI_Exh_EditMode_AppliesToFilter_LabelName 		=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 129);
	String RI_Exh_EditMode_ClearFilter 						=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 130);
	////Buttons
	String RI_Exh_EditMode_CopyColumns_Button 				=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 131);
	String RI_Exh_EditMode_CopyRows_Buttons 				=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 132);
	String RI_Exh_EditMode_AddButton						=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 133);
	String RI_Exh_EditMode_DeleteButton 					=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 134);
	String RI_Exh_EditMode_SaveButton 						=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 135);
	String RI_Exh_EditMode_closeButton						=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 136);
	String RI_Exh_EditMode_ExpandButton 					=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 137);
	String RI_Exh_EditMode_CollapseButton 					=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 138);
	String RI_Exh_EditMode_AllocateButton					=xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 139);

	//Edit Mode: Media Row No Pop up >> Media Rights  Window
	/*String RI_Exh_MediaWindow_Exh_HeaderName 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 156);
	String RI_Exh_MediaWindow_Alphabet_LabelName 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 157);
	String RI_Exh_MediaWindow_Alphabet_DropDown 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 158);
	String RI_Exh_MediaWindow_Alphabet_MultiSelect 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 159);
	String RI_Exh_MediaWindow_AppliesTo_LabelName 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 160);
	String RI_Exh_MediaWindow_AppliesTo_DropDown 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 161);
	String RI_Exh_MediaWindow_AppliesToMultiSelect				=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 162);*/
	String RI_Exh_MediaWindow_AddButton 						= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 156);
	String RI_Exh_MediaWindow_SelectKey							=xlsInputData.getCellData("RI_ExhibitionRights",  "Keys", 157);
	String RI_Exh_MediaWindow_SelectHeader						=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 157);


	// Edit Mode: Rights Type Pop up >> Rights Type Window	
	String RI_ExhibitionRights_EditMode_Linear 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 171);
	String RI_ExhibitionRights_EditMode_NonLinear	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 172);
	String RI_ExhibitionRights_EditMode_ExpandAll_Button 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 173);
	String RI_ExhibitionRights_EditMode_CollapseAll_Button	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 174);
	String RI_ExhibitionRights_EditMode_SelectAll_Button   	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 175);
	String RI_ExhibitionRights_EditMode_DeSelectAll_Button  = xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 176);
	String RI_ExhibitionRights_EditMode_Apply_Button   		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 177);
	String RI_ExhibitionRights_EditMode_Cancel_Button   	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 178);

	// Edit Mode: Exhibition Rights Network Dialog Pop up >> Exhibition Rights Network Dialog Window
	String RI_Exh_NetworkWindow_AppliesTO_Label 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 190);
	String RI_Exh_NetworkWindow_MediaType_Label 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 191);
	String RI_Exh_NetworkWindow_MediaType_DropDown 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 192);
	String RI_Exh_NetworkWindow_NetworkType_Label 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 193);
	String RI_Exh_NetworkWindow_NetworkType_DropDown		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 194);
	String RI_Exh_NetworkWindow_UserDefined_Label 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 195);
	String RI_Exh_NetworkWindow_UserDefined_CheckBox		=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 196);
	String RI_Exh_NetworkWindow_UserDefinedNetwork_Label 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 197);
	String RI_Exh_NetworkWindow_ExhibNetwork_Label 			=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 198);
	String RI_Exh_NetworkWindow_OutLetNumber_Label 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 199);
	String RI_Exh_NetworkWindow_DeselectAllButton 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 200);
	String RI_Exh_NetworkWindow_SelectAllButton				=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 201);
	String RI_Exh_NetworkWindow_OKButton 					= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 202);
	String RI_Exh_NetworkWindow_CancelButton				=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 203);
	String RI_Exh_NetworkWindow_MediaType_DropDownValue1 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 204);
	String RI_Exh_NetworkWindow_MediaType_DropDownValue2	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 205);
	String RI_Exh_NetworkWindow_NetworkType_DropDownValue1 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 206);
	String RI_Exh_NetworkWindow_NetworkType_DropDownValue2	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 207);

	// Edit Mode: Exhibition Rights Network Dialog Pop up >> Exhibition Rights Network Dialog Window
	String RI_Exh_ExhiScope_Series 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 221);
	String RI_Exh_ExhiScope_Season			=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 222);
	String RI_Exh_ExhiScope_Episodes 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 223);
	String RI_Exh_ExhiScope_Asset			=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 224);

	// Day Type 
	String RI_Exh_DayType_Consecutive 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 229);
	String RI_Exh_DayType_Programming		=xlsInputData.getCellData("RI_ExhibitionRights",  ClientData, 230);

	// Day Period 
	String RI_Exh_DayPeriod_Value1 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 234);
	String RI_Exh_DayPeriod_Value2 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 235);
	String RI_Exh_DayPeriod_Value3 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 236);
	String RI_Exh_DayPeriod_Value4 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 237);
	String RI_Exh_DayPeriod_Value5 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 238);

	// Drop down values of Plays 
	String RI_Exh_Plays_Value1 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 243);
	String RI_Exh_Plays_Value2 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 244);
	String RI_Exh_Plays_Value3 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 245);
	String RI_Exh_Plays_Value4 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 246);
	String RI_Exh_Plays_Value5 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 247);
	String RI_Exh_Plays_Value6 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 248);
	String RI_Exh_Plays_Value7 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 249);
	String RI_Exh_Plays_Value8 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 250);
	String RI_Exh_Plays_Value9 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 251);
	String RI_Exh_Plays_Value10		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 252);
	String RI_Exh_Plays_Value11		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 253);

	// Drop down values of Additional Exhibition 
	String RI_Exh_AddExh_Value1 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 257);
	String RI_Exh_AddExh_Value2 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 258);
	String RI_Exh_ExhNetworkChannel1 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 263);
	String RI_Exh_ExhNetworkChannel2 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 264);

	String RI_Exh_Allocate_ValidationMsg 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 312);
	String RI_Exh_Copy_ValidationMsg 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 313);
	String RI_Exh_Delete_ValidationMsg 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 314);
	String RI_ExhNet_EnterOutlet_ValidationMsg				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 315);
	String RI_Exh_Delete_Conrimation_ValidationMsg 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 316);
	String RI_Exh_Delete_ParentConrimation_ValidationMsg 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 317);
	String RI_Exh_EnterRequiredFields_ValidationMsg 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 320);
	String RI_Exh_EnterUserDefined_ValidationMsg 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 321);
	String RI_Exh_ValidationMsg_ExhDayMustBePooled 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 328);
	String RI_Exh_ValidationMsg_ExhDayEqualToReservedDays 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 329);
	String RI_Exh_ValidationMsg_ExhDayPeriodMustBeValid		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 330);
	String RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 331);
	String RI_Exh_ValidationMsg_EnterExhDayDoesNotMatch2	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 332);
	String RI_Exh_ValidationMsg_AddExhiMustBeSameNetwork	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 333);
	String RI_Exh_ValidationMsg_ExhPeriodMustBe_NA			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 334);
	String RI_Exh_ValidationMsg_NotWithInValidDateRange		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 335);
	String RI_Exh_ValidationMsg_EnterValidDateRange			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 336);
	String RI_Exh_ValidationMsg_NotPooledThenSameNetwork	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 337);
	String RI_Exh_ValidationMsg_ExhibitionDayScopeMustbeAsset 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 338);
	String RI_Exh_ValidationMsg_ExhibitionDayScopeValidValueisEpisode 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 339);
	String RI_Exh_ValidationMsg_OnChangingFilter 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 340);
	String RI_Exh_ValidationMsg_OnSelectAssetWithNoRow 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 341);
	String RI_Exh_ValidationMsg_DalNav_EpispdeTAB 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 342);
	String RI_Exh_ValidationMsg_NavigateAwayPopup 										= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 343);
	String RI_Exh_AlertMsg_SameMediaRowSelect 				= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 352);






	// Exhibition Test Data
	String RI_Exh_Update_DefaultValue 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 402);
	String RI_Exh_StartDate_DefaultValue 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 403);
	String RI_Exh_End_DefaultValue 			= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 404);
	String RI_Exh_WinType_DefaultValue 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 405);
	String RI_Exh_DayType_DefaultValue 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 406);
	String RI_Exh_DayPeriod_DefaultValue 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 407);
	String RI_Exh_Plays_DefaultValue 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 408);
	String RI_Exh_AddExhi_DefaultValue 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 409);
	String RI_Exh_WinName			 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 410);
	String RI_Exh_WinName2			 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 421);
	String RI_Exh_Terr1			 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 422);
	String RI_Exh_Terr2			 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 423);
	String RI_Exh_NetWorkWindow_TestData	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 411);
	String RI_Exh_StartDate2016 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 412);
	String RI_Exh_StartDate2017 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 413);
	String RI_Exh_StartDate2018_1 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 414);
	String RI_Exh_StartDate2018_2 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 415);
	String RI_Exh_StartDate2021 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 416);
	String RI_Exh_ENDDate2016 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 417);
	String RI_Exh_ENDDate2018_1 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 418);
	String RI_Exh_ENDDate2018_2 	= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 419);
	String RI_Exh_ENDDate2021 		= xlsInputData.getCellData("RI_ExhibitionRights", ClientData, 420);
	//RI_EditingRights
	String RI_EditingRightsApplesTo_Key                                    = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 2);
	String RI_EditingRights1_key                                           = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 3);
	String RI_EditingRightsInProgramUse_Key                                = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 4);
	String RI_EditingRightsPerpetuity_Key                                  = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 5);
	String RI_EditingRightsStartDate_Key                                   = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 6);
	String RI_EditingRightsEndDate_Key	                                   = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 7);
	String RI_EditingRightsStartTimeCode_Key	                           = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 8);
	String RI_EditingRightsEndTimeCode_Key	                               = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 9);
	String RI_EditingRightsNotes_Key	                                   = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 10);
	String RI_EditingRightsApplesToPickList_Key                            = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 11);
	String RI_EditingRights1pickList_key                                   = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 12);
	String RI_EditingRightsContext_key                                     = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 13);
	String RI_EditingRightsTimeLimitation_key                              = xlsInputData.getCellData("RI_EditingRights", "KeyValues", 14);



	//Field
	String RI_EditingRightsApplesTo                                        = xlsInputData.getCellData("RI_EditingRights", ClientData, 2);
	String RI_EditingRights1                                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 3);
	String RI_EditingRightsInProgramUse                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 4);
	String RI_EditingRightsPerpetuity	                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 5);
	String RI_EditingRightsStartDate                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 6);
	String RI_EditingRightsEndDate	                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 7);
	String RI_EditingRightsStartTimeCode                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 8);
	String RI_EditingRightsEndTimeCode                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 9);
	String RI_EditingRightsNotes	                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 10);
	String RI_AllEditingRights                                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 16);
	String RI_NoEditingRights                                              = xlsInputData.getCellData("RI_EditingRights", ClientData, 17);
	String EditingRightsApplesToViewMode                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 18);
	String EditingRightsViewMode                                           = xlsInputData.getCellData("RI_EditingRights", ClientData, 26);
	String RI_EditingRightsContext                                         = xlsInputData.getCellData("RI_EditingRights", ClientData, 27);
	String RI_EditingRightsTimeLimitation                                  = xlsInputData.getCellData("RI_EditingRights", ClientData, 28);

	//Button
    String RI_EditingRightCopy                                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 117); 
	String RI_EditingRightsAdd                                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 118);
	String RI_EditingRightDelete                                           = xlsInputData.getCellData("RI_EditingRights", ClientData, 119);
	String RI_EditingRightSave                                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 120);
	String RI_EditingRightCancel                                           = xlsInputData.getCellData("RI_EditingRights", ClientData, 121); 
	String RI_EditingRightsEditButton                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 102);
	String RI_EditingRightsSendReminder                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 103);
	String RI_EditingRightsExpandAll                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 148);
	String RI_EditingRightsCollapseAll                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 149);
	String RI_EditingRightsSelectAll                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 150);
	String RI_EditingRightsDeselectAll                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 151);
	String RI_EditingRightsApplies                                         = xlsInputData.getCellData("RI_EditingRights", ClientData, 152);
		//Alert
	String RI_EditingRightsCopyWithoutSeletingRowMgs                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 30);
	String RI_EditingRightsDeleteCofMgs                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 31);
	String RI_EditingRightsErrorMgs                                        = xlsInputData.getCellData("RI_EditingRights", ClientData, 32); 
	String RI_AppliesToWithoutSeletingErrorMgs                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 33); 
	String RI_EditingRightsWithoutSeletingErrorMgs                         = xlsInputData.getCellData("RI_EditingRights", ClientData, 34); 
	String RI_EditingRightsStartDateErrorMgs                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 35);
	String RI_AllEditingRightsConfMgs                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 36);
	String RI_NoEditingRightsConfMgs                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 37);
	String RI_EditingRightsCopy20RowMgs                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 38);
	String RI_EditingRightsDeleteWithOutSeletingRow                        = xlsInputData.getCellData("RI_EditingRights", ClientData, 39);
	String RI_EditingRightsBothStartAndEndTimeCodes                        = xlsInputData.getCellData("RI_EditingRights", ClientData, 40);
	String RI_EditingRightslaterThanStartTimeCode                          = xlsInputData.getCellData("RI_EditingRights", ClientData, 41);
	String RI_EditingRightsTimeCodeExceedsTheMaximum                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 42);
	String RI_AseetNavigatorDeleteAssetConfMsg                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 43);
	//Data
	String RI_EditingRightsAppliesToData                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 45);
	String RI_EditingRightsData                                            = xlsInputData.getCellData("RI_EditingRights", ClientData, 52);
	String RI_EditingRightsSeason1                                         = xlsInputData.getCellData("RI_EditingRights", ClientData, 46);
	String RI_EditingRightsEpisode101                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 47);
	String RI_EditingRightsEpisode102                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 48);
	String RI_EditingRightsSeason2                                         = xlsInputData.getCellData("RI_EditingRights", ClientData, 49);
	String RI_EditingRightsEpisode201                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 50);
	String RI_EditingRightsEpisode202                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 51);
	String RI_EditingRightSearchBoxData                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 53);
	String RI_EditingRightStartDateData                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 54);
	String RI_EditingRightStartTimeCodeData                                = xlsInputData.getCellData("RI_EditingRights", ClientData, 70);
	String RI_EditingRightEndDateData                                      = xlsInputData.getCellData("RI_EditingRights", ClientData, 55);
	String RI_EditingRightEndTimeCodeData                                  = xlsInputData.getCellData("RI_EditingRights", ClientData, 71);
	String RI_EditingRightEndTimeCodeData1                                 = xlsInputData.getCellData("RI_EditingRights", ClientData, 72);
	String RI_EditingRightStartTimeCodeData1                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 73);
	String RI_EditingRightStartTimeCodeData2                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 74);
	String RI_EditingRightStartTimeCodeData3                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 75);
	String RI_EditingRightStartTimeCodeData4                               = xlsInputData.getCellData("RI_EditingRights", ClientData, 76);
	String RI_EditingRightEndTimeCodeData2                                 = xlsInputData.getCellData("RI_EditingRights", ClientData, 77);
	String RI_EditingRightEndTimeCodeData3                                 = xlsInputData.getCellData("RI_EditingRights", ClientData, 78);
	String RI_EditingRightEndTimeCodeData4                                 = xlsInputData.getCellData("RI_EditingRights", ClientData, 79);
	String RI_EditingRightEndTimeCodeData5                                 = xlsInputData.getCellData("RI_EditingRights", ClientData, 80);
	String RI_EditingRightEndDateData2nd                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 56);
	String RI_BusinessTermsData                                            = xlsInputData.getCellData("RI_EditingRights", ClientData, 57);
	String RI_TermDescriptionData                                          = xlsInputData.getCellData("RI_EditingRights", ClientData, 58);
	String RI_EditingRightStartDate1Row                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 59);
	String RI_EditingRightEndDate1Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 60);
	String RI_TermDescriptionData1Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 61);
	String RI_EditingRightEndDate2Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 62);
	String RI_TermDescriptionData2Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 63);
	String RI_TermDescriptionData3Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 64);
	String RI_EditingRightEndDate3Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 65);
	String RI_EditingRightEndDate5Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 66);
	String RI_TermDescriptionData5Row                                     = xlsInputData.getCellData("RI_EditingRights", ClientData, 67);
	String RI_EditingRightsNumOfCopyRow                                   = xlsInputData.getCellData("RI_EditingRights", ClientData, 68);
	String RI_EditingRights2CopyRow                                       = xlsInputData.getCellData("RI_EditingRights", ClientData, 69);
	String RI_EditingRightsTimeLimitationData                             = xlsInputData.getCellData("RI_EditingRights", ClientData, 81);
	String RI_EditingRightsContextData                                    = xlsInputData.getCellData("RI_EditingRights", ClientData, 82);
	String RI_EditingRightsdata1                                          = xlsInputData.getCellData("RI_EditingRights", ClientData, 83);
	String RI_EditingRightsAppliesTo5RowData                              = xlsInputData.getCellData("RI_EditingRights", ClientData, 84);
	//RI_BusinessTerm 
	String RI_BusinessTerms_Key                                           = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 2);
	String RI_BusinessTermUseTemplate_Key                                 = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 3);
	String RI_BusinessTermTermDescription_Key                             = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 4);
	String RI_BusinessTermRestriction_Key                                 = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 5);
	String RI_BusinessTermsIncludeinReports_Key                           = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 6);
	//Field
	String RI_BusinessTerms                                               = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 2);
	String RI_BusinessTermUseTemplate                                     = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 3);
	String RI_BusinessTermTermDescription                                 = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 5);
	String RI_BusinessTermTermDescriptionViewMode                         = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 13);
	String RI_BusinessTermRestriction                                     = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 5);
	String RI_BusinessTermsIncludeinReports                               = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 6);
	String RI_BusinessTermsSendReminderTitle                              = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 8);
	String RI_BusinessTermsEditButton                                     = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 7);
	String RI_BusinessTermsAddButton                                      = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 9);
	String RI_BusinessTermsDeleteButton                                   = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 10);
	String RI_BusinessTermsSaveButton                                     = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 11);
	String RI_BusinessTermsCancelButton                                   = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 12);
	String RI_BusinessTermsData1                                          = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 41);
	String RI_UseTemplateData                                             = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 42);
	String TermDescriptionData                                            = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 43);
	String RI_BusinessTermsData2                                          = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 44);
	String RI_BusinessTermsData3                                          = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 46);
	String TermDescriptionData1                                           = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 45);
	String TermDescriptionData2                                           = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 47);
	//Alert
	String RI_BusinessTermsAlertMsg                                       = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 26);
	String RI_BusinessTermsDeleteAlertMsg                                 = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 27);
	String RI_BusinessTermsDeleteConfAlertMsg                             = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 28);

	//RI_Delivery Schedule    
	String RI_DeliveryScheduleAppliesToKey                                = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 2);
	String RI_DeliveryScheduleNameKey                                     = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 17);
	String RI_DeliveryScheduleDueOnKey                                    = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 18);
	String RI_DeliveryScheduleDeliveredOnKey                              = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 19);
	String RI_DeliveryScheduleFromKey                                     = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 20);
	String RI_DeliveryScheduleQtyKey                                      = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 21);
	String RI_DeliveryScheduleFinalQCKey                                  = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 22);
	String RI_DeliveryScheduleQCStatusKey                                 = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 23);
	String RI_DeliveryScheduleRequiredKey                                 = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 24);
	String RI_DeliveryScheduleEssentialKey                                = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 25);
	String RI_DeliveryScheduleDeliveryStatusKey                           = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 26);
	String RI_DeliveryScheduleDisposeKey                                  = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 27);
	String RI_DeliveryScheduleDateDisposedKey                             = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 28);
	String RI_DeliveryScheduleNotificationKey                             = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 29);
	String RI_DeliveryScheduleRightToMoveKey                              = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 30);
	String RI_DeliveryScheduleStorageLocationKey                          = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 31);
	String RI_DeliveryScheduleDateofReturnKey                             = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 32);
	String RI_DeliveryScheduleNotesKey                                    = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 33);
	String RI_DeliveryScheduleFromImgKey                                  = xlsInputData.getCellData("RI_DeliverySchedule", "Keys", 34);
	//Field
	String RI_DeliveryScheduleAppliesTo                                   =xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 2);
	String RI_DeliveryScheduleEdit                                        = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 9);
	String RI_DeliveryScheduleGenerateProductionDeliverablesExhibit       = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 10);
	String RI_DeliveryScheduleSendReminder                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 12);
	String RI_DeliveryScheduleSeelctAll                                   = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 13);
	String RI_DeliveryScheduleDeselectAll                                 = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 14);
	String RI_DeliveryScheduleSave                                        = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 15);
	String RI_DeliveryScheduleCancel                                      = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 16);
	String RI_DeliveryScheduleName                                        = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 17);
	String RI_DeliveryScheduleDueOn                                       = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 18);
	String RI_DeliveryScheduleDeliveredOn                                 = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 19);
	String RI_DeliveryScheduleFrom                                        = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 20);
	String RI_DeliveryScheduleQty                                         = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 21);
	String RI_DeliveryScheduleFinalQC                                     = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 22);
	String RI_DeliveryScheduleQCStatus                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 23);
	String RI_DeliveryScheduleRequired                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 24);
	String RI_DeliveryScheduleEssential                                   = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 25);
	String RI_DeliveryScheduleDeliveryStatus                              = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 26);
	String RI_DeliveryScheduleDispose                                     = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 27);
	String RI_DeliveryScheduleDateDisposed                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 28);
	String RI_DeliveryScheduleNotification                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 29);
	String RI_DeliveryScheduleRightToMove                                 = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 30);
	String RI_DeliveryScheduleStorageLocation                             = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 31);
	String RI_DeliveryScheduleDateofReturn                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 32);
	String RI_DeliveryScheduleNotes                                       = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 33);
	String RI_DeliveryScheduleEditButton                                  = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 9);
	String RI_DeliveryScheduleAddButton                                   = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 3);
	String RI_DeliveryScheduleAllocateButton                              = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 4);
	String RI_DeliveryScheduleDeleteButton                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 5);
	String RI_DeliveryScheduleSaveButton                                  = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 6);
	String RI_DeliveryScheduleCancelButton                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 7);
	String RI_DeliveryScheduleCopyRowButton                               = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 8);
	//Alert
	String RI_DeliveryScheduleSaveWithoutAllocate                         = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 46);
	String RI_DeliveryScheduleSavewithoutselcet                           = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 47);
	String RI_DeliveryScheduleDeleteRowConf                               = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 48);
	String RI_DeliveryScheduleWarningMsg                                  = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 49);
	String RI_DeliveryScheduleGroup1Msg                                   = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 50);
	String RI_DeliveryScheduleGroup2Msg                                   = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 51);
	//Data
	String RI_DeliveryScheduleAppliesToData                               = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 68);
	String RI_DeliveryScheduleHDCam                                       = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 69);
	String RI_DeliveryScheduleNameData                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 70);
	String RI_DeliveryDueOnData                                           = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 71);
	String RI_DeliveryScheduleDeliveredOnData                             = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 72);
	String RI_DeliveryScheduleFromData                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 73);
	String RI_DeliveryScheduleQty1Data                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 74);
	String RI_DeliveryScheduleQty2Data                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 75);
	String RI_DeliveryScheduleQty3Data                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 76);
	String RI_DeliveryScheduleQty4Data                                    = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 84);
	String RI_DeliveryScheduleFinalQCData                                 = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 77);
	String RI_DeliveryScheduleFinalQCData1                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 85);
	String RI_DeliveryScheduleQCStatusData                                = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 78);
	String RI_DeliveryScheduleDeliveryStatusData                          = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 79);
	String RI_DeliveryScheduleDisposeData                                 = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 80);
	String RI_DeliveryScheduleDateDisposedData                            = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 81);
	String RI_DeliveryScheduleStorageLocationData                         = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 82);
	String RI_DeliveryScheduleDateofReturnData                            = xlsInputData.getCellData("RI_DeliverySchedule", ClientData, 83);



	//RI_Obligations
	String RI_ObligationsAppliesToKey 	                                  = xlsInputData.getCellData("RI_Obligations", "KeyValues", 2);
	String RI_ObligationsFromKey					                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 3);
	String RI_ObligationsToKey					                          = xlsInputData.getCellData("RI_Obligations", "KeyValues", 4);
	String RI_ObligationsCategoryKey                                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 5);
	String RI_ObligationsTypeKey                                          = xlsInputData.getCellData("RI_Obligations", "KeyValues", 6);
	String RI_ObligationsMediaKey                                         = xlsInputData.getCellData("RI_Obligations", "KeyValues", 7);
	String RI_ObligationsPerpetuityKey                                    = xlsInputData.getCellData("RI_Obligations", "KeyValues", 8);
	String RI_ObligationsStartDateKey                                     = xlsInputData.getCellData("RI_Obligations", "KeyValues", 9);
	String RI_ObligationsEndDateKey                                       = xlsInputData.getCellData("RI_Obligations", "KeyValues", 10);
	String RI_ObligationsStatusKey                                        = xlsInputData.getCellData("RI_Obligations", "KeyValues", 11);
	String RI_ObligationsValueKey                                         = xlsInputData.getCellData("RI_Obligations", "KeyValues", 12);
	String RI_ObligationsValueFulfilledKey                                = xlsInputData.getCellData("RI_Obligations", "KeyValues", 23);
	String RI_ObligationsCurrencyKey                                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 24);
	String RI_ObligationsNotesKey                                         = xlsInputData.getCellData("RI_Obligations", "KeyValues", 25);
	String RI_ObligationsRepresentedIndividualFromKey                     = xlsInputData.getCellData("RI_Obligations", "KeyValues", 26);
	String RI_ObligationsRepresentedIndividualToKey                       = xlsInputData.getCellData("RI_Obligations", "KeyValues", 27);
	String RI_ObligationsUsageRightsKey                                   = xlsInputData.getCellData("RI_Obligations", "KeyValues", 28);
	String RI_ObligationsServiceKey                                       = xlsInputData.getCellData("RI_Obligations", "KeyValues", 29);
	String RI_ObligationsRelatedUsageKey                                  = xlsInputData.getCellData("RI_Obligations", "KeyValues", 30);
	String RI_ObligationsTerritoryKey                                     = xlsInputData.getCellData("RI_Obligations", "KeyValues", 31);

	//PopUp
	String RI_ObligationsAppliesToImgKey 	                              = xlsInputData.getCellData("RI_Obligations", "KeyValues", 13);
	String RI_ObligationsFromImgKey					                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 14);
	String RI_ObligationsToImgKey					                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 15);
	String RI_ObligationsTypeImgKey                                       = xlsInputData.getCellData("RI_Obligations", "KeyValues", 16);
	String RI_ObligationsMediaImgKey                                      = xlsInputData.getCellData("RI_Obligations", "KeyValues", 17);
	//Field                  
	String RI_ObligationsAppliesTo 	                                      = xlsInputData.getCellData("RI_Obligations", ClientData, 2);
	String RI_ObligationsFrom					                          = xlsInputData.getCellData("RI_Obligations", ClientData, 3);
	String RI_ObligationsTo				                                  = xlsInputData.getCellData("RI_Obligations", ClientData, 4);
	String RI_ObligationsCategory                                         = xlsInputData.getCellData("RI_Obligations", ClientData, 5);
	String RI_ObligationsType                                             = xlsInputData.getCellData("RI_Obligations", ClientData, 6);
	String RI_ObligationsMedia                                            = xlsInputData.getCellData("RI_Obligations", ClientData, 7);
	String RI_ObligationsPerpetuity                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 8);
	String RI_ObligationsStartDate                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 9);
	String RI_ObligationsEndDate                                          = xlsInputData.getCellData("RI_Obligations", ClientData, 10);
	String RI_ObligationsStatus                                           = xlsInputData.getCellData("RI_Obligations", ClientData, 11);
	String RI_ObligationsValue                                            = xlsInputData.getCellData("RI_Obligations", ClientData, 12);
	String RI_ObligationsAppliesToViewMode 	                              = xlsInputData.getCellData("RI_Obligations", ClientData, 14);
	String RI_ObligationsValueFulfilled                                   = xlsInputData.getCellData("RI_Obligations", ClientData, 23);
	String RI_ObligationsCurrency                                         = xlsInputData.getCellData("RI_Obligations", ClientData, 24);
	String RI_ObligationsNotes                                            = xlsInputData.getCellData("RI_Obligations", ClientData, 25);
	String RI_ObligationsRepresentedIndividualFrom                        = xlsInputData.getCellData("RI_Obligations", ClientData, 26);
	String RI_ObligationsRepresentedIndividualTo                          = xlsInputData.getCellData("RI_Obligations", ClientData, 27);
	String RI_ObligationsUsageRights                                      = xlsInputData.getCellData("RI_Obligations", ClientData, 28);
	String RI_ObligationsService                                          = xlsInputData.getCellData("RI_Obligations", ClientData, 29);
	String RI_ObligationsRelatedUsage                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 30);
	String RI_ObligationsTerritory                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 31);
	//Botton 
	String RI_ObligationsEditButton                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 13);
	String RI_ObligationsSelectAll                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 20); 
	String RI_ObligationsDeselectAll                                      = xlsInputData.getCellData("RI_Obligations", ClientData, 21); 
	String RI_ObligationsApply                                            = xlsInputData.getCellData("RI_Obligations", ClientData, 22); 
	String RI_ObligationsCancel                                           = xlsInputData.getCellData("RI_Obligations", ClientData, 19); 
	//Alert
	String RI_ObligationsWithoutSaveMsg                                   = xlsInputData.getCellData("RI_Obligations", ClientData, 43);
	String RI_ObligationsEndDateMsg                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 44);
	String RI_ObligationsapplywithoutselectMsg                            = xlsInputData.getCellData("RI_Obligations", ClientData, 45);
	String RI_ObligationsCopyWithoutSelectMsg                             = xlsInputData.getCellData("RI_Obligations", ClientData, 46);
	String RI_ObligationsCopyWinEnterNoMsg                                = xlsInputData.getCellData("RI_Obligations", ClientData, 47);
	String RI_ObligationsCopyWinInvaldMsg                                 = xlsInputData.getCellData("RI_Obligations", ClientData, 48);
	String RI_ObligationsSelectRowDeleteMsg                               = xlsInputData.getCellData("RI_Obligations", ClientData, 49);
	String RI_ObligationsConfDeleteMsg                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 50);
	//Data
	String RI_ObligationsAppliesToData                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 54);
	String RI_ObligationsFromData                                         = xlsInputData.getCellData("RI_Obligations", ClientData, 55);
	String RI_ObligationsToData                                           = xlsInputData.getCellData("RI_Obligations", ClientData, 56);
	String RI_ObligationsCategoryData                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 57);
	String RI_ObligationsTypeData                                         = xlsInputData.getCellData("RI_Obligations", ClientData, 58);
	String RI_ObligationsMediaData                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 59);
	String RI_ObligationsStartDateData                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 60);
	String RI_ObligationsEndDateData                                      = xlsInputData.getCellData("RI_Obligations", ClientData, 61);
	String RI_ObligationsEndDateData1                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 62);
	String RI_ObligationsStatusData                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 63);
	String RI_ObligationsCurrencyData                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 64);
	String RI_ObligationsValueData1                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 65);
	String RI_ObligationsValueData2                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 66);
	String RI_ObligationsValueData3                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 67);
	String RI_ObligationsValueData4                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 68);
	String RI_ObligationsValueData5                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 69);
	String RI_ObligationsObligationValueFulfilledData1                    = xlsInputData.getCellData("RI_Obligations", ClientData, 70);
	String RI_ObligationsObligationValueFulfilledData2                    = xlsInputData.getCellData("RI_Obligations", ClientData, 71);
	String RI_ObligationsObligationValueFulfilledData3                    = xlsInputData.getCellData("RI_Obligations", ClientData, 72);
	String RI_ObligationsObligationValueFulfilledData4                    = xlsInputData.getCellData("RI_Obligations", ClientData, 73);
	String RI_ObligationsObligationValueFulfilledData5                    = xlsInputData.getCellData("RI_Obligations", ClientData, 74);
	String RI_ObligationsInvalidCopyData                                  = xlsInputData.getCellData("RI_Obligations", ClientData, 75);
	String RI_ObligationsvalidCopyData                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 76);
	String RI_ObligationsEp101Data                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 77);
	String RI_ObligationsEp102Data                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 78);
	String RI_ObligationsEp201Data                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 79);
	String RI_ObligationsEp202Data                                        = xlsInputData.getCellData("RI_Obligations", ClientData, 80);
	String RI_ObligationsRelatedUsageData                                 = xlsInputData.getCellData("RI_Obligations", ClientData, 81);
	String RI_ObligationsServiceData                                      = xlsInputData.getCellData("RI_Obligations", ClientData, 82);
	String RI_ObligationsUsageRightsData                                  = xlsInputData.getCellData("RI_Obligations", ClientData, 83);
	String RI_ObligationsTerritoryData                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 84);
		String RI_ObligationsAddButton                                    = xlsInputData.getCellData("RI_Obligations", ClientData, 16);
	String RI_ObligationsDeleteButton                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 17);
	String RI_ObligationsSaveButton                                       = xlsInputData.getCellData("RI_Obligations", ClientData, 18);
	String RI_ObligationsCancelButton                                     = xlsInputData.getCellData("RI_Obligations", ClientData, 19);


	//RI_PromoRights
	String RI_PromoRightsAppliesToKey                                     = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 2);
	String RI_PromoRightsMediaKey                                         = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 3);
	String RI_PromoRightsTerritoryKey                                     = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 4);
	String RI_PromoRightsPromoRightsKey                                   = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 5);
	String RI_PromoRightsUnlimitedUseKey                                  = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 6);
	String RI_PromoRightsUseOutsideProgramKey                             = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 7);
	String RI_PromoRightsPerpetuityKey                                    = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 8);
	String RI_PromoRightsStartDateKey                                     = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 9);
	String RI_PromoRightsEndDateKey                                       = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 10);
	String RI_PromoRightsNotesKey                                         = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 11);
	String RI_PromoRightsToPromoteKey                                     = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 12);
	String RI_PromoRightsOutletsKey                                       = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 13);
	String RI_PromoRightsVenueKey                                         = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 14);
	String RI_PromoRightsAggregateKey                                     = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 15);
	String RI_PromoRightsStartTimeCodeKey                                 = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 16);
	String RI_PromoRightsEndTimeCodeKey                                   = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 17); 
	String RI_PromoRightsAppliesToImgKey                                  = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 18);
	String RI_PromoRightsMediaImgKey                                      = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 19);
	String RI_PromoRightsTerritoryImgKey                                  = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 20);
	String RI_PromoRightsPromoRightsImgKey                                = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 21);
	String RI_PromoRightsToPromoteImgKey                                  = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 23);
	String RI_PromoRightsToOutletsImgKey                                  = xlsInputData.getCellData("RI_PromoRights", "KeyValues", 24);

	String RI_PromoRightsAppliesTo                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 2);
	String RI_PromoRightsMedia                                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 3);
	String RI_PromoRightsTerritory                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 4);
	String RI_PromoRightsPromoRights                                      = xlsInputData.getCellData("RI_PromoRights", ClientData, 5);
	String RI_PromoRightsUnlimitedUse                                     = xlsInputData.getCellData("RI_PromoRights", ClientData, 6);
	String RI_PromoRightsUseOutsideProgram                                = xlsInputData.getCellData("RI_PromoRights", ClientData, 7);
	String RI_PromoRightsPerpetuity                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 8);
	String RI_PromoRightsStartDate                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 9);
	String RI_PromoRightsEndDate                                          = xlsInputData.getCellData("RI_PromoRights", ClientData, 10);
	String RI_PromoRightsNotes                                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 11);
	String RI_PromoRightsToPromote                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 12);
	String RI_PromoRightsOutlets                                          = xlsInputData.getCellData("RI_PromoRights", ClientData, 13);
	String RI_PromoRightsVenue                                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 14);
	String RI_PromoRightsAggregate                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 15);
	String RI_PromoRightsStartTimeCode                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 16);
	String RI_PromoRightsEndTimeCode                                      = xlsInputData.getCellData("RI_PromoRights", ClientData, 17); 

	String RI_PromoRightsAppliesToViewMode                                = xlsInputData.getCellData("RI_PromoRights", ClientData, 25);
	String RI_PromoRightsEditButtons                                      = xlsInputData.getCellData("RI_PromoRights", ClientData, 32); 
	String RI_PromoRightsSendReminder                                     = xlsInputData.getCellData("RI_PromoRights", ClientData, 33);
	String RI_PromoRightsCopyRow                                          = xlsInputData.getCellData("RI_PromoRights", ClientData, 34);
	String RI_PromoRightsAdd                                              = xlsInputData.getCellData("RI_PromoRights", ClientData, 35);
	String RI_PromoRightsDelete                                           = xlsInputData.getCellData("RI_PromoRights", ClientData, 36);
	String RI_PromoRightsSave                                             = xlsInputData.getCellData("RI_PromoRights", ClientData, 37);
	String RI_PromoRightsCancel                                           = xlsInputData.getCellData("RI_PromoRights", ClientData, 38);
	String RI_PromoRightsSelectAll                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 39);
	String RI_PromoRightsDeselectAll                                      = xlsInputData.getCellData("RI_PromoRights", ClientData, 40);
	String RI_PromoRightsApply                                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 41);
	String RI_PromoRightsErrorMgs                                         = xlsInputData.getCellData("RI_PromoRights", ClientData, 50);
	String RI_PromoRightsEndDateSatarDateErrorMgs                         = xlsInputData.getCellData("RI_PromoRights", ClientData, 51);
	String RI_PromoRightsAllPromotionRightsConf                           = xlsInputData.getCellData("RI_PromoRights", ClientData, 52);
	String RI_PromoRightsNoPromotionRightsConf                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 58);

	String RI_PromoRightsCopyWithoutselectingRow                          = xlsInputData.getCellData("RI_PromoRights", ClientData, 53);
	String RI_PromoRightsCopRowMsg                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 54);
	String RI_PromoRightsCopRowMsg1                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 55);
	String RI_PromoRightsDeleteAlertMsg                                   = xlsInputData.getCellData("RI_PromoRights", ClientData, 56);
	String RI_PromoRightsDeleteConfMsg                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 57);
	String RI_PromoRightsEnterBothStartAndEndTimes                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 59);
	String RI_PromoRightslaterThanStartTimeCode                           = xlsInputData.getCellData("RI_PromoRights", ClientData, 60);
	String RI_PromoRightsTimeCodeExceedsTheMaximum                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 61);

	String RI_PromoRightsAppliesToData                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 63);
	String RI_PromoRightsData                                             = xlsInputData.getCellData("RI_PromoRights", ClientData, 64);
	String RI_PromoRightsData1                                            = xlsInputData.getCellData("RI_PromoRights", ClientData, 80);
	String RI_PromoRightsSearchData                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 65);
	String RI_PromoRightsToPromoteData                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 66);
	String RI_PromoRightsMediaData                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 67);
	String RI_PromoRightsMediaData1                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 81);
	String RI_PromoRightsTerritoryData                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 68);
	String RI_PromoRightsTerritoryData1                                   = xlsInputData.getCellData("RI_PromoRights", ClientData, 82);
	String RI_PromoRightsOutletsData                                      = xlsInputData.getCellData("RI_PromoRights", ClientData, 69);
	String RI_PromoRightsEndDateData1                                     = xlsInputData.getCellData("RI_PromoRights", ClientData, 70);
	String RI_PromoRightsEndDateData2                                     = xlsInputData.getCellData("RI_PromoRights", ClientData, 72);
	String RI_PromoRightsEndDateData3                                     = xlsInputData.getCellData("RI_PromoRights", ClientData, 73);
	String RI_PromoRightsStartDateData1                                   = xlsInputData.getCellData("RI_PromoRights", ClientData, 71);
	String RI_PromoRightsTerritoryData2                                   = xlsInputData.getCellData("RI_PromoRights", ClientData, 74);
	String RI_PromoRightsVenueData                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 75);
	String RI_PromoRightsVenueData1                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 83);
	String RI_PromoRightsSeason1                                          = xlsInputData.getCellData("RI_PromoRights", ClientData, 76);
	String RI_PromoRightsEpisode101                                       = xlsInputData.getCellData("RI_PromoRights", ClientData, 77);
	String RI_PromoRightsCopyData1                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 78);
	String RI_PromoRightsCopyData2                                        = xlsInputData.getCellData("RI_PromoRights", ClientData, 79);
	String RI_PromoRights_Note_BusinessTerm1                              = xlsInputData.getCellData("RI_PromoRights", ClientData, 94);
	String RI_PromoRightStartTimeCodeData                                 = xlsInputData.getCellData("RI_PromoRights", ClientData, 85);
	String RI_PromoRightEndTimeCodeData                                   = xlsInputData.getCellData("RI_PromoRights", ClientData, 86);
	String RI_PromoRightEndTimeCodeData1                                  = xlsInputData.getCellData("RI_PromoRights", ClientData, 87);
	String RI_PromoRightStartTimeCodeData1                                = xlsInputData.getCellData("RI_PromoRights", ClientData, 88);
	String RI_PromoRightStartTimeCodeData2                                = xlsInputData.getCellData("RI_PromoRights", ClientData, 89);
	String RI_PromoRightStartTimeCodeData3                                = xlsInputData.getCellData("RI_PromoRights", ClientData, 90);
	String RI_PromoRightEndTimeCodeData2                                  = xlsInputData.getCellData("RI_PromoRights", ClientData, 91);
	String RI_PromoRightEndTimeCodeData3                                  = xlsInputData.getCellData("RI_PromoRights", ClientData, 92);
	String RI_PromoRightEndTimeCodeData4                                  = xlsInputData.getCellData("RI_PromoRights", ClientData, 93);
	String RI_PromoRightEndTimeCodeData5                                  = xlsInputData.getCellData("RI_PromoRights", ClientData, 94);
	String RI_PromoRightEndDateData2nd                                    = xlsInputData.getCellData("RI_PromoRights", ClientData, 95);

	//RI_Options
	String RI_Options_AppliesToKey                                        = xlsInputData.getCellData("RI_Options", "KeyValues", 2);
	String RI_Options_OptionTypeKey                                       = xlsInputData.getCellData("RI_Options", "KeyValues", 3); 
	String RI_Options_ServiceTypeKey                                      = xlsInputData.getCellData("RI_Options", "KeyValues", 4);
	String RI_Options_NetworkKey                                          = xlsInputData.getCellData("RI_Options", "KeyValues", 5);
	String RI_Options_MediaKey                                            = xlsInputData.getCellData("RI_Options", "KeyValues", 6);
	String RI_Options_TerritoryKey                                        = xlsInputData.getCellData("RI_Options", "KeyValues", 7);
	String RI_Options_AddlPrgsTermsKey                                    = xlsInputData.getCellData("RI_Options", "KeyValues", 8);
	String RI_Options_AddlPeriodKey                                       = xlsInputData.getCellData("RI_Options", "KeyValues", 9);
	String RI_Options_ProjectedExerciseDtKey                              = xlsInputData.getCellData("RI_Options", "KeyValues", 10);
	String RI_Options_NegotiationDeadlineKey                              = xlsInputData.getCellData("RI_Options", "KeyValues", 11);
	String RI_Options_1stNegotiationKey                                   = xlsInputData.getCellData("RI_Options", "KeyValues", 12);
	String RI_Options_FirstRefusalKey                                     = xlsInputData.getCellData("RI_Options", "KeyValues", 13);
	String RI_Options_LastRefusalKey                                      = xlsInputData.getCellData("RI_Options", "KeyValues", 14);
	String RI_Options_MaxBudgetIncKey                                     = xlsInputData.getCellData("RI_Options", "KeyValues", 15);
	String RI_Options_OptPeriodLicenseFeeKey                              = xlsInputData.getCellData("RI_Options", "KeyValues", 16);
	String RI_Options_OptionTermKey                                       = xlsInputData.getCellData("RI_Options", "KeyValues", 17);
	String RI_Options_StatusKey                                           = xlsInputData.getCellData("RI_Options", "KeyValues", 18);
	String RI_Options_FinalExercisedDtKey                                 = xlsInputData.getCellData("RI_Options", "KeyValues", 19);
	String RI_Options_GrantorKey                                          = xlsInputData.getCellData("RI_Options", "KeyValues", 20);
	String RI_Options_RepresentedIndividualKey                            = xlsInputData.getCellData("RI_Options", "KeyValues", 21);
	String RI_Options_OutletsKey                                          = xlsInputData.getCellData("RI_Options", "KeyValues", 22);
	String RI_Options_AddlPerpetuityKey                                   = xlsInputData.getCellData("RI_Options", "KeyValues", 23);
	String RI_Options_PerpetuityKey                                       = xlsInputData.getCellData("RI_Options", "KeyValues", 24);
	String RI_Options_AppliesToImgKey                                     = xlsInputData.getCellData("RI_Options", "KeyValues", 25);
	String RI_Options_MediaImgKey                                         = xlsInputData.getCellData("RI_Options", "KeyValues", 26);
	String RI_Options_TerritoryImgKey                                     = xlsInputData.getCellData("RI_Options", "KeyValues", 27);
	String RI_Options_ProjectedExerciseDtImg                              = xlsInputData.getCellData("RI_Options", "KeyValues", 28);


	String RI_Options_AppliesTo                                           = xlsInputData.getCellData("RI_Options", ClientData, 2);
	String RI_Options_OptionType                                          = xlsInputData.getCellData("RI_Options", ClientData, 3); 
	String RI_Options_ServiceType                                         = xlsInputData.getCellData("RI_Options", ClientData, 4);
	String RI_Options_Network                                             = xlsInputData.getCellData("RI_Options", ClientData, 5);
	String RI_Options_Media                                               = xlsInputData.getCellData("RI_Options", ClientData, 6);
	String RI_Options_Territory                                           = xlsInputData.getCellData("RI_Options", ClientData, 7);
	String RI_Options_AddlPrgsTerms                                       = xlsInputData.getCellData("RI_Options", ClientData, 8);
	String RI_Options_AddlPeriod                                          = xlsInputData.getCellData("RI_Options", ClientData, 9);
	String RI_Options_ProjectedExerciseDt                                 = xlsInputData.getCellData("RI_Options", ClientData, 10);
	String RI_Options_NegotiationDeadline                                 = xlsInputData.getCellData("RI_Options", ClientData, 11);
	String RI_Options_1stNegotiation                                      = xlsInputData.getCellData("RI_Options", ClientData, 12);
	String RI_Options_FirstRefusal                                        = xlsInputData.getCellData("RI_Options", ClientData, 13);
	String RI_Options_LastRefusal                                         = xlsInputData.getCellData("RI_Options", ClientData, 14);
	String RI_Options_MaxBudgetInc                                        = xlsInputData.getCellData("RI_Options", ClientData, 15);
	String RI_Options_OptPeriodLicenseFee                                 = xlsInputData.getCellData("RI_Options", ClientData, 16);
	String RI_Options_OptionTerm                                          = xlsInputData.getCellData("RI_Options", ClientData, 17);
	String RI_Options_Status                                              = xlsInputData.getCellData("RI_Options", ClientData, 18);
	String RI_Options_FinalExercisedDt                                    = xlsInputData.getCellData("RI_Options", ClientData, 19);
	String RI_Options_Grantor                                             = xlsInputData.getCellData("RI_Options", ClientData, 20);
	String RI_Options_RepresentedIndividual                               = xlsInputData.getCellData("RI_Options", ClientData, 21);
	String RI_Options_Outlets                                             = xlsInputData.getCellData("RI_Options", ClientData, 22);
	String RI_Options_AddlPerpetuity                                      = xlsInputData.getCellData("RI_Options", ClientData, 23);
	String RI_Options_Perpetuity                                          = xlsInputData.getCellData("RI_Options", ClientData, 24);

	String RI_Options_CopyRow                                             = xlsInputData.getCellData("RI_Options", ClientData, 40);
	String RI_Options_Add                                                 = xlsInputData.getCellData("RI_Options", ClientData, 41);
	String RI_Options_Delete                                              = xlsInputData.getCellData("RI_Options", ClientData, 42);
	String RI_Options_Save                                                = xlsInputData.getCellData("RI_Options", ClientData, 43);
	String RI_Options_Cancel                                              = xlsInputData.getCellData("RI_Options", ClientData, 44);
	String RI_Options_AppliesToViewMode                                   = xlsInputData.getCellData("RI_Options", ClientData, 45);
	String RI_Options_Edit                                                = xlsInputData.getCellData("RI_Options", ClientData, 46);
	String RI_Options_SendReminder                                        = xlsInputData.getCellData("RI_Options", ClientData, 47);
	String RI_Options_ExpandAll                                           = xlsInputData.getCellData("RI_Options", ClientData, 48);
	String RI_Options_CollapseAll                                         = xlsInputData.getCellData("RI_Options", ClientData, 49);
	String RI_Options_SelectAll                                           = xlsInputData.getCellData("RI_Options", ClientData, 50);
	String RI_Options_DeselectAll                                         = xlsInputData.getCellData("RI_Options", ClientData, 51);
	String RI_Options_Apply                                               = xlsInputData.getCellData("RI_Options", ClientData, 52);
	//Data
	String RI_OptionsAppliesToData                                        = xlsInputData.getCellData("RI_Options", ClientData, 76);
	String RI_OptionsServiceTypeData                                      = xlsInputData.getCellData("RI_Options", ClientData, 78);
	String RI_OptionsOptionsTypeData                                      = xlsInputData.getCellData("RI_Options", ClientData, 77);
	String RI_OptionsOptionsTypeData1                                     = xlsInputData.getCellData("RI_Options", ClientData, 116);
	String RI_OptionsOptionsTypeData2                                     = xlsInputData.getCellData("RI_Options", ClientData, 117);
	String RI_OptionsOptionsTypeData3                                     = xlsInputData.getCellData("RI_Options", ClientData, 118);
	String RI_OptionsOptionsTypeData4                                     = xlsInputData.getCellData("RI_Options", ClientData, 119);
	String RI_OptionsOptionsTypeData5                                     = xlsInputData.getCellData("RI_Options", ClientData, 120);
	String RI_OptionsOptionsTypeData6                                     = xlsInputData.getCellData("RI_Options", ClientData, 121);
	String RI_OptionsNetworkData                                          = xlsInputData.getCellData("RI_Options", ClientData, 79);
	String RI_OptionsMediaData                                            = xlsInputData.getCellData("RI_Options", ClientData, 80);
	String RI_OptionsMediaData1                                           = xlsInputData.getCellData("RI_Options", ClientData, 82);
	String RI_OptionsTerritoryData                                        = xlsInputData.getCellData("RI_Options", ClientData, 81);
	String RI_OptionsGrantorData                                          = xlsInputData.getCellData("RI_Options", ClientData, 83);
	String RI_Options_ProjectedExerciseDtData                             = xlsInputData.getCellData("RI_Options", ClientData, 84);
	String RI_Options_NegotiationDeadlineData                             = xlsInputData.getCellData("RI_Options", ClientData, 85);
	String RI_Options_NegotiationDeadlineData1                            = xlsInputData.getCellData("RI_Options", ClientData, 86);
	String RI_Options_NegotiationDeadlineData2                            = xlsInputData.getCellData("RI_Options", ClientData, 87);
	String RI_Options_MaxBudgetIncData                                    = xlsInputData.getCellData("RI_Options", ClientData, 88);
	String RI_Options_MaxBudgetIncData1                                   = xlsInputData.getCellData("RI_Options", ClientData, 89);
	String RI_Options_MaxBudgetIncData2                                   = xlsInputData.getCellData("RI_Options", ClientData, 90);
	String RI_Options_MaxBudgetIncData3                                   = xlsInputData.getCellData("RI_Options", ClientData, 91);
	String RI_Options_MaxBudgetIncData4                                   = xlsInputData.getCellData("RI_Options", ClientData, 92);
	String RI_Options_MaxBudgetIncData5                                   = xlsInputData.getCellData("RI_Options", ClientData, 93);
	String RI_Options_MaxBudgetIncData6                                   = xlsInputData.getCellData("RI_Options", ClientData, 94);
	String OptPeriodLicenseFeeData                                        = xlsInputData.getCellData("RI_Options", ClientData, 95);
	String OptPeriodLicenseFeeData1                                       = xlsInputData.getCellData("RI_Options", ClientData, 96);
	String OptPeriodLicenseFeeData2                                       = xlsInputData.getCellData("RI_Options", ClientData, 97);
	String OptPeriodLicenseFeeData3                                       = xlsInputData.getCellData("RI_Options", ClientData, 98);
	String OptPeriodLicenseFeeData4                                       = xlsInputData.getCellData("RI_Options", ClientData, 99);
	String RI_Options_NotesData                                           = xlsInputData.getCellData("RI_Options", ClientData, 100);
	String RI_Options_ExercisedData                                       = xlsInputData.getCellData("RI_Options", ClientData, 101);
	String RI_Options_FinalExercisedDtData                                = xlsInputData.getCellData("RI_Options", ClientData, 102);

	String RI_Options_LicPeriodDateFrom                                   = xlsInputData.getCellData("RI_Options", ClientData, 103);
	String RI_Options_LicPeriodDateTo                                     = xlsInputData.getCellData("RI_Options", ClientData, 104);
	String RI_Options_EventPeriod                                         = xlsInputData.getCellData("RI_Options", ClientData, 105);
	String RI_Options_OKButton                                            = xlsInputData.getCellData("RI_Options", ClientData, 106);
	String RI_Options_CancelButton                                        = xlsInputData.getCellData("RI_Options", ClientData, 107);
	String RI_Options_LicPeriodDateFromData                               = xlsInputData.getCellData("RI_Options", ClientData, 108);
	String RI_Options_LicPeriodDateToData1                                = xlsInputData.getCellData("RI_Options", ClientData, 109);
	String RI_Options_LicPeriodDateToData2                                = xlsInputData.getCellData("RI_Options", ClientData, 110);
	String RI_Options_EventPeriodData1                                    = xlsInputData.getCellData("RI_Options", ClientData, 111);
	String RI_Options_EventPeriodData2                                    = xlsInputData.getCellData("RI_Options", ClientData, 113);
	String RI_Options_EventPeriodyear                                     = xlsInputData.getCellData("RI_Options", ClientData, 112);
	String RI_Options_AddlPrgsTermsData                                   = xlsInputData.getCellData("RI_Options", ClientData, 114);
	String RI_Options_AddlPrgsTermsData1                                  = xlsInputData.getCellData("RI_Options", ClientData, 115);
	String RI_Options_OutletsData                                         = xlsInputData.getCellData("RI_Options", ClientData, 124);

	String RI_OptionsTermViewModeData                                     = xlsInputData.getCellData("RI_Options", ClientData, 126);

	//Alert
	String RI_OptionsErrorMsg                                             = xlsInputData.getCellData("RI_Options", ClientData, 58);
	String RI_OptionsAddlPrgsTermsAlertMsg                                = xlsInputData.getCellData("RI_Options", ClientData, 59);
	String RI_OptionsNegotiationDateMsg                                   = xlsInputData.getCellData("RI_Options", ClientData, 60);
	String RI_OptionsMediaorerritoryorAddlProgsMsg                        = xlsInputData.getCellData("RI_Options", ClientData, 61);
	String AdditionalLicensePeriodErrorMsg                                = xlsInputData.getCellData("RI_Options", ClientData, 62);
	String RI_OptionsAdditionalErrorMsg                                   = xlsInputData.getCellData("RI_Options", ClientData, 63);
	String RI_OptionsWithoutSelectingRowAlertMsg                          = xlsInputData.getCellData("RI_Options", ClientData, 64);	
	String RI_OptionsSelectingRowAlertMsg                                 = xlsInputData.getCellData("RI_Options", ClientData, 65);		
	String RI_OptionsCopyWithoutselectingRow                              = xlsInputData.getCellData("RI_Options", ClientData, 66);		
	String RI_OptionsCopRowMsg                                            = xlsInputData.getCellData("RI_Options", ClientData, 67);	
	String RI_OptionsCopyAlertMsg                                         = xlsInputData.getCellData("RI_Options", ClientData, 68);	

	//View Mode Key Values
	String RI_AttributesAppliesToView                                     = xlsInputData.getCellData("RI_Attributes", "KeyValues", 5);
	String RI_AttributesAttributeView                                     = xlsInputData.getCellData("RI_Attributes", "KeyValues", 6);

	String RI_AttributesAppliesTo                                         = xlsInputData.getCellData("RI_Attributes", ClientData, 2);
	String RI_AttributesAttribute                                         = xlsInputData.getCellData("RI_Attributes", ClientData, 3);
	String RI_AttributesValue1                                            = xlsInputData.getCellData("RI_Attributes", ClientData, 4);
	String RI_AttributesValue2                                            = xlsInputData.getCellData("RI_Attributes", ClientData, 9);
	//Alert
	String RI_Attribute_ValidationMessage_EnteringInvalidData             = xlsInputData.getCellData("RI_Attributes", ClientData, 21);
	String RI_Attribute_ValidationMessage_EnterValidNumericValue          = xlsInputData.getCellData("RI_Attributes", ClientData, 22);
	String RI_Attribute_ValidationMessage_EnterDecimalValue               = xlsInputData.getCellData("RI_Attributes", ClientData, 23);
	String RI_Attribute_ValidationMessage_EnterNonValidDecimalValue       = xlsInputData.getCellData("RI_Attributes", ClientData, 24);
	String RI_Attribute_ValidationMessage_EnterValidDecimalValue          = xlsInputData.getCellData("RI_Attributes", ClientData, 25);
	String RI_Attribute_ValidationMessage_EnterRangeValues                = xlsInputData.getCellData("RI_Attributes", ClientData, 26);
	String RI_Attribute_ValidationMessage_EnterOnlyNumber                 = xlsInputData.getCellData("RI_Attributes", ClientData, 27);
	//Data
	String RI_AttributesErrorMsg                                          = xlsInputData.getCellData("RI_Attributes", ClientData, 20);
	String RI_AttributesValueData                                         = xlsInputData.getCellData("RI_Attributes", ClientData, 33);

	//RI_Services
	String RI_ServicesAppliesToKey                                        = xlsInputData.getCellData("RI_Services", "KeyValues", 2);
	String RI_ServicesPartyKey                                            = xlsInputData.getCellData("RI_Services", "KeyValues", 3);
	String RI_ServicesRepresentedIndividualKey                            = xlsInputData.getCellData("RI_Services", "KeyValues", 4);
	String RI_ServicesServiceKey                                          = xlsInputData.getCellData("RI_Services", "KeyValues", 5);
	String RI_ServicesPerpetuityKey                                       = xlsInputData.getCellData("RI_Services", "KeyValues", 6);
	String RI_ServicesBeginKey                                            = xlsInputData.getCellData("RI_Services", "KeyValues", 7);
	String RI_ServicesServicesEndKey                                      = xlsInputData.getCellData("RI_Services", "KeyValues", 8);
	String RI_ServicesUnionSocietyKey                                     = xlsInputData.getCellData("RI_Services", "KeyValues", 9);
	String RI_ServicesExclusivityKey                                      = xlsInputData.getCellData("RI_Services", "KeyValues", 10);
	String RI_ServicesServiceDetailsKey                                   = xlsInputData.getCellData("RI_Services", "KeyValues", 11);
	String RI_ServicesPaidAdsKey                                          = xlsInputData.getCellData("RI_Services", "KeyValues", 12);
	String RI_ServicesCreditTreatmentKey                                  = xlsInputData.getCellData("RI_Services", "KeyValues", 13);
	String RI_ServicesCharacterKey                                        = xlsInputData.getCellData("RI_Services", "KeyValues", 14);
	String RI_ServicesCreditTextKey                                       = xlsInputData.getCellData("RI_Services", "KeyValues", 16);
	String RI_ServicesNotesKey                                            = xlsInputData.getCellData("RI_Services", "KeyValues", 19);
	String RI_ServicesDocumentLinkKey                                     = xlsInputData.getCellData("RI_Services", "KeyValues", 20);
	String RI_ServicesAppliesToImgKey                                     = xlsInputData.getCellData("RI_Services", "KeyValues", 22);
	String RI_ServicesPartyImgKey                                         = xlsInputData.getCellData("RI_Services", "KeyValues", 23);
	String RI_ServicesImgKey                                              = xlsInputData.getCellData("RI_Services", "KeyValues", 24);
	String RI_ServicesUnionImgKey                                         = xlsInputData.getCellData("RI_Services", "KeyValues", 26);

	String RI_ServicesAppliesTo                                           = xlsInputData.getCellData("RI_Services", ClientData, 2);
	String RI_ServicesParty                                               = xlsInputData.getCellData("RI_Services", ClientData, 3);
	String RI_ServicesRepresentedIndividual                               = xlsInputData.getCellData("RI_Services", ClientData, 4);
	String RI_ServicesService                                             = xlsInputData.getCellData("RI_Services", ClientData, 5);
	String RI_ServicesPerpetuity                                          = xlsInputData.getCellData("RI_Services", ClientData, 6);
	String RI_ServicesBegin                                               = xlsInputData.getCellData("RI_Services", ClientData, 7);
	String RI_ServicesServicesEnd                                         = xlsInputData.getCellData("RI_Services", ClientData, 8);
	String RI_ServicesUnionSociety                                        = xlsInputData.getCellData("RI_Services", ClientData, 9);
	String RI_ServicesExclusivity                                         = xlsInputData.getCellData("RI_Services", ClientData, 10);
	String RI_ServicesServiceDetails                                      = xlsInputData.getCellData("RI_Services", ClientData, 11);
	String RI_ServicesPaidAds                                             = xlsInputData.getCellData("RI_Services", ClientData, 12);
	String RI_ServicesCreditTreatment                                     = xlsInputData.getCellData("RI_Services", ClientData, 13);
	String RI_ServicesCharacter                                           = xlsInputData.getCellData("RI_Services", ClientData, 14);
	String RI_ServicesCreditText                                          = xlsInputData.getCellData("RI_Services", ClientData, 16);
	String RI_ServicesNotes                                               = xlsInputData.getCellData("RI_Services", ClientData, 19);
	String RI_ServicesDocumentLink                                        = xlsInputData.getCellData("RI_Services", ClientData, 20);
	String RI_ServicesAppliesToViewMode                                   = xlsInputData.getCellData("RI_Services", ClientData, 27);

	String RI_ServicesCopyRow                                             = xlsInputData.getCellData("RI_Services", ClientData, 43);
	String RI_ServicesAdd                                                 = xlsInputData.getCellData("RI_Services", ClientData, 44);
	String RI_ServicesDelete                                              = xlsInputData.getCellData("RI_Services", ClientData, 45);
	String RI_ServicesSave                                                = xlsInputData.getCellData("RI_Services", ClientData, 46);
	String RI_ServicesCancel                                              = xlsInputData.getCellData("RI_Services", ClientData, 47);

	String RI_ServicesErrorMsg                                            = xlsInputData.getCellData("RI_Services", ClientData, 57);

	String RI_ServicesAppliesToData                                       = xlsInputData.getCellData("RI_Services", ClientData, 72);
	String RI_ServicesPartyData                                           = xlsInputData.getCellData("RI_Services", ClientData, 73);
	String RI_ServicesData                                                = xlsInputData.getCellData("RI_Services", ClientData, 74);
	String RI_ServicesUnionData                                           = xlsInputData.getCellData("RI_Services", ClientData, 75);
	String RI_ServicesCharacterData1                                      = xlsInputData.getCellData("RI_Services", ClientData, 76);
	String RI_ServicesCharacterData2                                      = xlsInputData.getCellData("RI_Services", ClientData, 77);
	String RI_ServicesCharacterData3                                      = xlsInputData.getCellData("RI_Services", ClientData, 78);
	String RI_ServicesCharacterData4                                      = xlsInputData.getCellData("RI_Services", ClientData, 79);
	String RI_ServiceBeginData                                            = xlsInputData.getCellData("RI_Services", ClientData, 80);
	String RI_ServiceEndData                                              = xlsInputData.getCellData("RI_Services", ClientData, 81);
	String ServiceDetailsData1                                            = xlsInputData.getCellData("RI_Services", ClientData, 82);
	String ServiceDetailsData2                                            = xlsInputData.getCellData("RI_Services", ClientData, 83);
	String ServiceDetailsData3                                            = xlsInputData.getCellData("RI_Services", ClientData, 84);
	String ServiceDetailsData4                                            = xlsInputData.getCellData("RI_Services", ClientData, 85);
	String CreditTextData1                                                = xlsInputData.getCellData("RI_Services", ClientData, 86);
	String CreditTextData2                                                = xlsInputData.getCellData("RI_Services", ClientData, 87);
	String CreditTextData3                                                = xlsInputData.getCellData("RI_Services", ClientData, 88);
	String CreditTextData4                                                = xlsInputData.getCellData("RI_Services", ClientData, 89);
	String DocumentlinkData                                               = xlsInputData.getCellData("RI_Services", ClientData, 90);
	String CreditTreatmentData1                                           = xlsInputData.getCellData("RI_Services", ClientData, 91);
	String CreditTreatmentData2                                           = xlsInputData.getCellData("RI_Services", ClientData, 92);
	String ExclusivityData1                                               = xlsInputData.getCellData("RI_Services", ClientData, 93);
	String ExclusivityData2                                               = xlsInputData.getCellData("RI_Services", ClientData, 94);

	//RI_RevenueParticipation   
	String RI_RevenueParticipationAppliesToKey                            = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 2);
	String RI_RevenueParticipationAppliesToImgKey                         = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 22);
	String RI_RevenueParticipationPartyKey                                = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 3);
	String RI_RevenueParticipationPartyImgKey                             = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 26);
	String RI_RevenueParticipationServicesKey                             = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 4);
	String RI_RevenueParticipationServicesImgKey                          = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 27);
	String RI_RevenueParticipationRightsMediaKey                          = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 6);
	String RI_RevenueParticipationRightsMediaImgKey                       = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 23);
	String RI_RevenueParticipationTerritoryKey                            = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 8);
	String RI_RevenueParticipationTerritoryImgKey                         = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 25);
	String RI_RevenueParticipationCurrencyKey                             = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 13);
	String RI_RevenueParticipationFixedAmountKey                          = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 14);
	String RI_RevenueParticipationRepresentedIndividualKey                = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 32);
	String RI_RevenueParticipationPercentageKey                           = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 33);
	String RI_RevenueParticipationBackendFormulaKey                       = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 34);
	String RI_RevenueParticipationPaymentTermsKey                         = xlsInputData.getCellData("RI_RevenuePart", "KeyValues", 35);
	String RI_RevenueParticipationAppliesTo                               = xlsInputData.getCellData("RI_RevenuePart", ClientData, 2);
	String RI_RevenueParticipationAppliesToViewMode                       = xlsInputData.getCellData("RI_RevenuePart", ClientData, 36);
	String RI_RevenueParticipationParty                                   = xlsInputData.getCellData("RI_RevenuePart", ClientData, 3);
	String RI_RevenueParticipationServices                                = xlsInputData.getCellData("RI_RevenuePart", ClientData, 4);
	String RI_RevenueParticipationRightsMedia                             = xlsInputData.getCellData("RI_RevenuePart", ClientData, 6);
	String RI_RevenueParticipationTerritory                               = xlsInputData.getCellData("RI_RevenuePart", ClientData, 8);
	String RI_RevenueParticipationCurrency                                = xlsInputData.getCellData("RI_RevenuePart", ClientData, 13);
	String RI_RevenueParticipationFixedAmount                             = xlsInputData.getCellData("RI_RevenuePart", ClientData, 14);
	String RI_RevenueParticipationRepresentedIndividual                   = xlsInputData.getCellData("RI_RevenuePart", ClientData, 32);
	String RI_RevenueParticipationPercentage                              = xlsInputData.getCellData("RI_RevenuePart", ClientData, 33);
	String RI_RevenueParticipationBackendFormula                          = xlsInputData.getCellData("RI_RevenuePart", ClientData, 34);
	String RI_RevenueParticipationPaymentTerms                            = xlsInputData.getCellData("RI_RevenuePart", ClientData, 35);
	String RI_RevenueParticipation_SendReminder                           = xlsInputData.getCellData("RI_RevenuePart", ClientData, 53);
	String RI_RevenueParticipationStatementSchedule                       = xlsInputData.getCellData("RI_RevenuePart", ClientData, 51);
	String RI_NoRevenueParticipation                                      = xlsInputData.getCellData("RI_RevenuePart", ClientData, 54);
	String RI_RevenueParticipationErrorMsg                                = xlsInputData.getCellData("RI_RevenuePart", ClientData, 64);
	String RI_NoRevenueParticipationConf                                  = xlsInputData.getCellData("RI_RevenuePart", ClientData, 65);
	String RI_RevenueParticipationAppliesToData                           = xlsInputData.getCellData("RI_RevenuePart", ClientData, 82);
	String RI_RevenueParticipationPartyData                               = xlsInputData.getCellData("RI_RevenuePart", ClientData, 83);
	String RI_RevenueParticipationServiceData                             = xlsInputData.getCellData("RI_RevenuePart", ClientData, 84);
	String RI_RevenueParticipationMediaData                               = xlsInputData.getCellData("RI_RevenuePart", ClientData, 85);
	String RI_RevenueParticipationMediaData1                              = xlsInputData.getCellData("RI_RevenuePart", ClientData, 93);
	String RI_RevenueParticipationTerritoryData                           = xlsInputData.getCellData("RI_RevenuePart", ClientData, 86);
	String RI_RevenueParticipationParticipationData                       = xlsInputData.getCellData("RI_RevenuePart", ClientData, 87);
	String RI_RevenueParticipationBackendFormulaData                      = xlsInputData.getCellData("RI_RevenuePart", ClientData, 88);
	String RI_RevenueParticipationPaymentTermsData1                       = xlsInputData.getCellData("RI_RevenuePart", ClientData, 89);
	String RI_RevenueParticipationPaymentTermsData2                       = xlsInputData.getCellData("RI_RevenuePart", ClientData, 90);
	String RI_RevenueParticipationCurrencyData                            = xlsInputData.getCellData("RI_RevenuePart", ClientData, 91);
	String RI_RevenueParticipationAmountData                              = xlsInputData.getCellData("RI_RevenuePart", ClientData, 92);

	//RI_AggrementSearch

	String RI_AggrementSearchPropertyTitle                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 2);
	String RI_AggrementSearchEpisode                                      = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 3);
	String RI_AggrementSearchChannelEntity                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 4);
	String RI_AggrementSearchContractName                                 = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 5);
	String RI_AggrementSearchRMSContractType                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 6);
	String RI_AggrementSearchDM5DocType                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 7);
	String RI_AggrementSearchPartyRepresenting                            = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 8);
	String RI_AggrementSearchVMNParty                                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 9);
	String RI_AggrementSearchServices                                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 10);
	String RI_AggrementSearchContractStatus                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 11);
	String RI_AggrementSearchContractEntryStatus                          = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 12);
	String RI_AggrementSearchContractDtFm                                 = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 13);
	String RI_AggrementSearchRevisionDtFm                                 = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 14);
	String RI_AggrementSearchLastUpdatedBy                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 15);
	String RI_AggrementSearchCreatedBy                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 16);
	String RI_AggrementSearchAgreementType                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 17);
	String RI_AggrementSearchTeamMember                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 18);
	String RI_AggrementSearchIDType                                       = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 19);
	String RI_AggrementSearchAKAsFKAs                                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 20);
	String RI_AggrementSearchReturnAttachments                            = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 21);
	String RI_AggrementSearchIncludeDeleted                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 22);
	String RI_AggrementSearchExactMatch                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 23);
	String RI_AggrementSearchRightsMedia                                  = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 24);
	String RI_AggrementSearchTerritory                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 25);
	String RI_AggrementSearchLicenseDatesFm                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 26);
	String RI_AggrementSearchObligationType                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 27);
	String RI_AggrementSearchFutureProperty                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 28);
	String RI_AggrementSearchExpirationDateFm                             = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 29);
	String RI_AggrementSearchLastUpdateDateFm                             = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 30);
	String RI_AggrementSearchCreationDateFm                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 31);
	String RI_AggrementSearchOptionDeadlineFm                             = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 32);
	String RI_AggrementSearchPremiereAirDateFm                            = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 33);
	String RI_AggrementSearchPremiereNetwork                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 34);
	String RI_AggrementSearchAttributes                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 35);
	String RI_AggrementSearchSearch                                       = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 54);
	String RI_AggrementSearchClearSearch                                  = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 55);
	String RI_AggrementSearchSaveSearch                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 56);
	String RI_AggrementSearchRestoreSearch                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 57);
	String RI_AggrementSearchDataFrom1                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 58);
	String RI_AggrementSearchDataFrom2                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 59);
	String RI_AggrementSearchDateTo                                       = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 60);
	String RI_AggrementSearchDealTypeData                                 = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 61);
	String RI_AggrementSearchContractEntryStatusData                      = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 62);
	String RI_AggrementSearchAgreementTypeData                            = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 63);
	String RI_AggrementSearchChanneData                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 64);
	String RI_AggrementSearchUpdateContractEntryStatusData                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 65);
	String RI_AggrementSearchReportTypeData1                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 66);
	String RI_AggrementSearchReportTypeData2                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 67);
	String RI_AggrementSearchScope                                        = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 68);
	String RI_AggrementSearchScope1                                       = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 69);
	String RI_AggrementSearchScope2                                       = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 70);
	String RI_AggrementSearchOptions                                      = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 71);
	String RI_AggrementSearchOptions1                                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 72);
	String RI_AggrementSearchOptions2                                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 52);
	String RI_AggrementSearchSaveAlertMsg                                 = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 51);
	String RI_AggrementSearchSavesData                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 50);
	String RI_AggrementSearchSaveAlertMsg1                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 49);
	String RI_AggrementSearchSaveAlertMsg2                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 48);
	String RI_AggrementSearchSavesData1                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 47);
	String RI_AggrementSearchMySearchesLocal                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 46);
	String RI_AggrementSearchGlobalSearches                               = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 45);
	String RI_AggrementSearchRestoreSearchInvalidData                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 44);
	String RI_AggrementSearchSavesData2                                   = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 43);
	String RI_AggrementSearchDeleteWithoutSeletingRow                     = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 42);
	String RI_AggrementSearchDeleteConfMsg                                = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 41);
	String RI_AggrementSearchDeleteConfAlert                              = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 40);
	String RI_AgrementSearchIDTypeData                                    = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 345);
	String RI_AgrementSearchContractStatusData                            = xlsInputData.getCellData("RI_AggrementSearch", ClientData, 39);
	//RI_Documents
	String RI_document_AppliesTOKey = xlsInputData.getCellData("RI_Documents", "Keys", 2);
	String RI_DocumentTypeKey = xlsInputData.getCellData("RI_Documents", "Keys", 3);
	String RI_DocumentNameKey = xlsInputData.getCellData("RI_Documents", "Keys", 4);
	String RI_DocumentDateKey = xlsInputData.getCellData("RI_Documents", "Keys", 5);
	String RI_DocumentDescKey = xlsInputData.getCellData("RI_Documents", "Keys", 6);

	String RI_document_AppliesTOValue = xlsInputData.getCellData("RI_Documents", ClientData, 2);
	String RI_DocumentTypeValue = xlsInputData.getCellData("RI_Documents", ClientData, 3);
	String RI_DocumentTypeData = xlsInputData.getCellData("RI_Documents", "Data", 3);
	String RI_DocumentName = xlsInputData.getCellData("RI_Documents", ClientData, 4);
	String RI_DocumentNameData = xlsInputData.getCellData("RI_Documents", "Data", 4);
	String RI_DocumentDate = xlsInputData.getCellData("RI_Documents", ClientData, 5);  
	String RI_DocumentDateData = xlsInputData.getCellData("RI_Documents", ClientData, 13);
	String RI_DocumentDesc = xlsInputData.getCellData("RI_Documents", ClientData, 6);
	String RI_DocumentDescData = xlsInputData.getCellData("RI_Documents", "Data", 6);
	//String AMUploadLoc = xlsInputData.getCellData("RI_Documents", ClientData, 8);
	String RI_UploadLoc = System.getProperty("user.dir")+"\\TestUploadFiles\\";
	String RI_DocumentID = xlsInputData.getCellData("RI_Documents", ClientData, 9);
	String RI_LibrarySelect = xlsInputData.getCellData("RI_Documents", ClientData, 10);
	//RI_Documents - Buttons inView Mode
	String RI_document_ViewButtonValue = xlsInputData.getCellData("RI_Documents", ClientData, 21);
	String RI_document_AddDocumentButtonValue = xlsInputData.getCellData("RI_Documents", ClientData, 22);
	String RI_document_EditProfileValue = xlsInputData.getCellData("RI_Documents", ClientData, 23);
	String RI_document_DeleteDocumentValue = xlsInputData.getCellData("RI_Documents", ClientData, 24);
	String RI_document_EditDocumentValue = xlsInputData.getCellData("RI_Documents", ClientData, 25);	
	String RI_document_SelectRowToViewValidationMessage = xlsInputData.getCellData("RI_Documents", ClientData, 48);
	String RI_document_AddDoc_SelectRowBeforeDeleteDocument_ValidationMessage = xlsInputData.getCellData("RI_Documents", ClientData, 49);

	//RI_Documents - Add document window
	String RI_document_AddDoc_DocumentUploadLabel = xlsInputData.getCellData("RI_Documents", ClientData, 30);
	String RI_document_AddDoc_AppliesToLabel = xlsInputData.getCellData("RI_Documents", ClientData, 31);
	String RI_document_AddDoc_DocNameLabel = xlsInputData.getCellData("RI_Documents", ClientData, 32);
	String RI_document_AddDoc_DocTypeLabel = xlsInputData.getCellData("RI_Documents", ClientData, 33);
	String RI_document_AddDoc_DocTypeData = xlsInputData.getCellData("RI_Documents", ClientData, 12);
	String RI_document_AddDoc_DocDateLabel = xlsInputData.getCellData("RI_Documents", ClientData, 34);
	String RI_document_AddDoc_DescriptionLabel = xlsInputData.getCellData("RI_Documents", ClientData, 35);
	String RI_document_AddDoc_LibraryLabel = xlsInputData.getCellData("RI_Documents", ClientData, 36);
	String RI_document_AddDoc_LibraryData = xlsInputData.getCellData("RI_Documents", "Data", 36);
	String RI_document_AddDoc_DocumentIDLabel = xlsInputData.getCellData("RI_Documents", ClientData, 37);
	String RI_document_AddDoc_Season1 = xlsInputData.getCellData("RI_Documents", ClientData, 39);
	String RI_document_AddDoc_S1_Episode1 = xlsInputData.getCellData("RI_Documents", ClientData, 40);
	String RI_document_AddDoc_S1_Episode2 = xlsInputData.getCellData("RI_Documents", ClientData, 41);
	String RI_document_AddDoc_Season2 = xlsInputData.getCellData("RI_Documents", ClientData, 42);
	String RI_document_AddDoc_S2_Episode1 = xlsInputData.getCellData("RI_Documents", ClientData, 43);
	String RI_document_AddDoc_S2_Episode2 = xlsInputData.getCellData("RI_Documents", ClientData, 44);

	String RI_document_AddDoc_UploadDocumentVAlidationMessage 		  = xlsInputData.getCellData("RI_Documents", ClientData, 45);
	String RI_document_AddDoc_2048KB_UploadDocumentValidationMessage = xlsInputData.getCellData("RI_Documents", ClientData, 46);
	String RI_document_AddDoc_WINRAR_UploadDocumentValidationMessage = xlsInputData.getCellData("RI_Documents", ClientData, 47);






	//RI_Documents - Global values    
	String RIDOCAPPLIESTO_VALUE= xlsInputData.getCellData("RI_Documents", "KeyValues", 2);
	String RIDOCUMENTTYPE= xlsInputData.getCellData("RI_Documents", "KeyValues", 3);
	String RIdocname= xlsInputData.getCellData("RI_Documents", "KeyValues", 4);
	String RIDOCUMENTDATE= xlsInputData.getCellData("RI_Documents", "KeyValues", 5);
	String RIDOCfiledesc= xlsInputData.getCellData("RI_Documents", "KeyValues", 6);
	String RIDOCfiledate= xlsInputData.getCellData("RI_Documents", "KeyValues", 7);

	//RI_Services - Global values
	String RIServicesAPPLIES_TO = xlsInputData.getCellData("RI_Services", "KeyValues", 2);
	String RIServicesPARTY = xlsInputData.getCellData("RI_Services", "KeyValues", 3);
	String RIServices = xlsInputData.getCellData("RI_Services", "KeyValues", 4);
	String RIServicesFLAG_PERPETUITY = xlsInputData.getCellData("RI_Services", "KeyValues", 5);
	String RIServicesBegin = xlsInputData.getCellData("RI_Services", "KeyValues", 6);
	String RIServicesEnd = xlsInputData.getCellData("RI_Services", "KeyValues", 7);
	String RIServicesUnion = xlsInputData.getCellData("RI_Services", "KeyValues", 8);
	String RIServicesBUSINESS_EXCLUSIVE_TERMS = xlsInputData.getCellData("RI_Services", "KeyValues", 9);
	String RIServices_DETAILS = xlsInputData.getCellData("RI_Services", "KeyValues", 10);
	String RIServicesPAID_ADS = xlsInputData.getCellData("RI_Services", "KeyValues", 11);
	String RIServicesBUSINESS_CREDIT_TERMS = xlsInputData.getCellData("RI_Services", "KeyValues", 12);
	String RIServicesCHARACTER = xlsInputData.getCellData("RI_Services", "KeyValues", 13);
	String RIServicesS_ORDER = xlsInputData.getCellData("RI_Services", "KeyValues", 14);
	String RIServicesCREDIT_TEXT = xlsInputData.getCellData("RI_Services", "KeyValues", 15);
	String RIServicesTITLE_PERCENTAGE = xlsInputData.getCellData("RI_Services", "KeyValues", 16);
	String RIServicesPosition = xlsInputData.getCellData("RI_Services", "KeyValues", 17);
	String RIServicesNOTE_IMG = xlsInputData.getCellData("RI_Services", "KeyValues", 18);
	String RIServicesFILENAME = xlsInputData.getCellData("RI_Services", "KeyValues", 19);
	String RIServicesPAGE_NUMBER = xlsInputData.getCellData("RI_Services", "KeyValues", 20);
	String RIServicesAPPLIESTO_POPUP= xlsInputData.getCellData("RI_Services", "KeyValues", 22);
	String RIServicesLIST_OF_DEAL_PARTIES_POPUP= xlsInputData.getCellData("RI_Services", "KeyValues", 23);
	String RIServices_POPUP= xlsInputData.getCellData("RI_Services", "KeyValues", 24);
	String RIServicesTERMEVENT_POPUP= xlsInputData.getCellData("RI_Services", "KeyValues", 25);
	String RIServicesUNION_POPUP= xlsInputData.getCellData("RI_Services", "KeyValues", 26);

	//RI_Restriction
	String RestrictionActiveKey = xlsInputData.getCellData("RI_Restriction", "Keys", 2);
	String RestrictionValidationTypeKey = xlsInputData.getCellData("RI_Restriction", "Keys", 3);
	String RestrictionRestrictionTypeKey = xlsInputData.getCellData("RI_Restriction", "Keys", 4);
	String RestrictionAppliesToKey = xlsInputData.getCellData("RI_Restriction", "Keys", 5);
	String RestrictionNetworkKey = xlsInputData.getCellData("RI_Restriction", "Keys", 6);
	String RestrictionDateFromKey = xlsInputData.getCellData("RI_Restriction", "Keys", 7);
	String RestrictionDateToKey = xlsInputData.getCellData("RI_Restriction", "Keys", 8);
	String RestrictionTimeFromKey = xlsInputData.getCellData("RI_Restriction", "Keys", 9);
	String RestrictionTimeToKey = xlsInputData.getCellData("RI_Restriction", "Keys", 10);
	String RestrictionDaysKey = xlsInputData.getCellData("RI_Restriction", "Keys", 11);
	String RestrictionExclusionLimitKey = xlsInputData.getCellData("RI_Restriction", "Keys", 12);

	String RestrictionActive2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 13);
	String RestrictionValidationType2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 14);
	String RestrictionRestrictionType2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 15);
	String RestrictionAppliesTo2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 16);
	String RestrictionRightsTypeKey = xlsInputData.getCellData("RI_Restriction", "Keys", 17);
	String RestrictionNetwork2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 18);
	String RestrictionRuleKey = xlsInputData.getCellData("RI_Restriction", "Keys", 19);
	String RestrictionHashKey = xlsInputData.getCellData("RI_Restriction", "Keys", 20);
	String RestrictionPeriodKey = xlsInputData.getCellData("RI_Restriction", "Keys", 21);
	String RestrictionRightsType2ndKey = xlsInputData.getCellData("RI_Restriction", "Keys", 22);
	String RestrictionNetwork2ndKey = xlsInputData.getCellData("RI_Restriction", "Keys", 23);

	String RestrictionActive3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 24);
	String RestrictionValidationType3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 25);
	String RestrictionRestrictionType3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 26);
	String RestrictionAppliesTo3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 27);
	String RestrictionMaxPlatsKey = xlsInputData.getCellData("RI_Restriction", "Keys", 28);
	String RestrictionNetwork3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 29);
	String RestrictionRightsType1Key = xlsInputData.getCellData("RI_Restriction", "Keys", 30);
	String RestrictionPeriod1Key = xlsInputData.getCellData("RI_Restriction", "Keys", 31);

	String RestrictionActive4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 32);
	String RestrictionValidationType4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 33);
	String RestrictionRestrictionType4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 34);
	String RestrictionAppliesTo4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 35);
	String RestrictionRightsType2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 36);
	String RestrictionNetwork4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 37);
	String RestrictionMaxPlats1Key = xlsInputData.getCellData("RI_Restriction", "Keys", 38);
	String RestrictionPeriod2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 39);

	String RestrictionActive5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 40);
	String RestrictionValidationType5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 41);
	String RestrictionRestrictionType5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 42);
	String RestrictionAppliesTo5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 43);
	String RestrictionNetwork5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 44);
	String RestrictionRightsType3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 45);
	String RestrictionMaxPlats2Key = xlsInputData.getCellData("RI_Restriction", "Keys", 46);
	String RestrictionDayTypeKey = xlsInputData.getCellData("RI_Restriction", "Keys", 47);

	String RestrictionActive6Key = xlsInputData.getCellData("RI_Restriction", "Keys", 48);
	String RestrictionValidationType6Key = xlsInputData.getCellData("RI_Restriction", "Keys", 49);
	String RestrictionRestrictionType6Key = xlsInputData.getCellData("RI_Restriction", "Keys", 50);
	String RestrictionAppliesTo6Key = xlsInputData.getCellData("RI_Restriction", "Keys", 51);
	String RestrictionRightsType4Key = xlsInputData.getCellData("RI_Restriction", "Keys", 52);
	String RestrictionNetwork6Key = xlsInputData.getCellData("RI_Restriction", "Keys", 53);
	String RestrictionRightsType5Key = xlsInputData.getCellData("RI_Restriction", "Keys", 54);
	String RestrictionHash1Key = xlsInputData.getCellData("RI_Restriction", "Keys", 55);
	String RestrictionRule1Key = xlsInputData.getCellData("RI_Restriction", "Keys", 56);
	String RestrictionPeriod3Key = xlsInputData.getCellData("RI_Restriction", "Keys", 57);
	String RestrictionNetwork7Key = xlsInputData.getCellData("RI_Restriction", "Keys", 58);

	//RI_TrackingEvents
	String AppliesToRITrEvKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 2);
	String TrackingEventRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 3);
	String ROW_DEAL_NAMERIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 4);
	String DeliverableGroupRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 5);
	String EventDateRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 6);
	String EstimatedDateRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 7);
	String AirNetworkRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 8);
	String PremiereDateRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 9);
	String TermFromRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 10);
	String TermToRIKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 11);
	String MediaTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 12);
	String VenueTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 13);
	String PackagingRightsPlatformTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 14);
	String TouchpointRestrictionsTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 15);
	String BusOutletTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 16);
	String TerritoryTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 17);
	String LanguageTemplateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 18);
	String OptionTypeKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 19);
	String ProjDateImgKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 20);
	String NegotiationDeadlineKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 21);
	String ProjDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 22);
	String PromoRightsKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 23);
	String PromoRightsStartDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 24);
	String PromoRightsEndDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 25);
	String PromoRightsAggregateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 26);
	String EditingRightsKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 27);
	String EditingRightsStartDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 28);
	String EditingRightsEndDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 29);
	String EditingRightsTimeLimitationKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 30);
	String PaymentsAppliesToKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 31);
	String PaymentsPartyKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 32);
	String PaymentsTypeKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 33);
	String PaymentsAmountKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 34);
	String PaymentsDueDateFieldKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 35);
	String PaymentsDueDateImageKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 36);
	String PaymentsAssetValueAppliesToKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 37);
	String PaymentsAssetValuePaymentTypeKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 38);
	String PaymentsAssetValueStartDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 39);
	String PaymentsAssetValueEndDateKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 40);
	String PaymentsAssetValueProfitCenterKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 41);
	String PaymentsAssetValueAmountKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 42);
	String PaymentsAssetValueCurrencyKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 43);
	String PaymentsAssetValueNotesKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 44);
	String PaymentsTermFromKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 45);
	String PaymentsTermToKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 46);
	String PaymentsPayTemplate = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 47);
	String TrEvDelGroupPickListKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 48);    
	String MedRightsTermEventPickListKey = xlsInputData.getCellData("RI_TrackingEvent", "Keys", 49);

	//RI_Payments
	String PaymentsRowNumKey = xlsInputData.getCellData("RI_Payment", "Keys", 2);
	String PaymentsMediaKey = xlsInputData.getCellData("RI_Payment", "Keys", 3);
	String PaymentsTerritoryKey = xlsInputData.getCellData("RI_Payment", "Keys", 4);
	String PaymentsBarterKey = xlsInputData.getCellData("RI_Payment", "Keys", 5);
	String PaymentsPercentAmtKey = xlsInputData.getCellData("RI_Payment", "Keys", 6);
	String PaymentsNotesKey = xlsInputData.getCellData("RI_Payment", "Keys", 7);
	String PaymentsGeneralTermsKey = xlsInputData.getCellData("RI_Payment", "Keys", 8);
	String PaymentsCurrencyKey = xlsInputData.getCellData("RI_Payment", "Keys", 9);
	String PaymentsProfitCenterKey = xlsInputData.getCellData("RI_Payment", "Keys", 10);
	String PaymentsMediaPickListKey = xlsInputData.getCellData("RI_Payment", "Keys", 11);
	String PaymentsTerritoryPickListKey = xlsInputData.getCellData("RI_Payment", "Keys", 12);
	String PaymentsMainPayDefinitionKey = xlsInputData.getCellData("RI_Payment", "Keys", 13);
	String PaymentsMainCheckNumberKey = xlsInputData.getCellData("RI_Payment", "Keys", 14);
	String PaymentsMainPaidDateKey = xlsInputData.getCellData("RI_Payment", "Keys", 15);
	String PaymentsAppliesPopUpKey = xlsInputData.getCellData("RI_Payment", "Keys", 16);

	//RI_Versions
	String RIVerNameKey = xlsInputData.getCellData("RI_Version", "Keys", 2);
	String RIVerVersionTypeKey = xlsInputData.getCellData("RI_Version", "Keys", 3);
	String RIVerContractStatusKey = xlsInputData.getCellData("RI_Version", "Keys", 4);
	String RIVerCDEKey = xlsInputData.getCellData("RI_Version", "Keys", 5);
	String RIVerCreatedByKey = xlsInputData.getCellData("RI_Version", "Keys", 6);
	String RIVerDateKey = xlsInputData.getCellData("RI_Version", "Keys", 7);
	String RIVerNotesKey = xlsInputData.getCellData("RI_Version", "Keys", 8);

	//RI_ProjectTeam
	String RIProjTeamGroupsKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 2);
	String RIProjTeamNameKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 3);
	String RIProjTeamRoleKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 4);
	String RIProjTeamNotifyDropdownKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 5);
	String RIProjTeamNotifyPickListKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 6);
	String RIProjTeamNoteKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 7);
	String RIProjTeamMedRightsTermEventKey = xlsInputData.getCellData("RI_ProjectTeam", "Keys", 8);



	//RI_Attributes
	String RI_AttributesAppliesToKey = xlsInputData.getCellData("RI_Attributes", "Keys", 2);
	String RI_AttributesAttributeKey = xlsInputData.getCellData("RI_Attributes", "Keys", 3);
	String RI_AttributesValue1Key = xlsInputData.getCellData("RI_Attributes", "Keys", 4);
	String RI_AttributesValue2Key = xlsInputData.getCellData("RI_Attributes", "Keys", 5);
	//RI_Options
	String RIOptionsAppliesTo  = xlsInputData.getCellData("RI_Options", ClientData, 2);
	String OptionType  = xlsInputData.getCellData("RI_Options", ClientData, 3);
	String RIOptionsServiceType  = xlsInputData.getCellData("RI_Options", ClientData, 4);
	String RIOptionsNetwork  = xlsInputData.getCellData("RI_Options", ClientData, 5);
	String RIOptionsMedia  = xlsInputData.getCellData("RI_Options", ClientData, 6);
	String RIOptionsTerritory  = xlsInputData.getCellData("RI_Options", ClientData, 7);
	String AddtlPrograms  = xlsInputData.getCellData("RI_Options", ClientData, 8);
	String AddtlPerpetuity  = xlsInputData.getCellData("RI_Options", ClientData, 9);
	String ProjectedDate  = xlsInputData.getCellData("RI_Options", ClientData, 10);
	String Negotiationdeadline  = xlsInputData.getCellData("RI_Options", ClientData, 11);
	String FirstNegotiation  = xlsInputData.getCellData("RI_Options", ClientData, 12);
	String FirstRefusal  = xlsInputData.getCellData("RI_Options", ClientData, 13);
	String LastRefusal  = xlsInputData.getCellData("RI_Options", ClientData, 14);
	String Maxbudget  = xlsInputData.getCellData("RI_Options", ClientData, 15);
	String RIOptionsCurrency  = xlsInputData.getCellData("RI_Options", ClientData, 16);
	String OfferedAmount  = xlsInputData.getCellData("RI_Options", ClientData, 17);
	String RIOptionsNotes  = xlsInputData.getCellData("RI_Options", ClientData, 18);
	String Exercised  = xlsInputData.getCellData("RI_Options", ClientData, 19);
	String FinalExercised  = xlsInputData.getCellData("RI_Options", ClientData, 20);

	//RI_Version
	String PromoRights = xlsInputData.getCellData("RI_Version", ClientData, 2);
	String ToPromote = xlsInputData.getCellData("RI_Version", ClientData, 3); 
	String RightsInclMedia = xlsInputData.getCellData("RI_Version", ClientData, 4); 
	String Outlets = xlsInputData.getCellData("RI_Version", ClientData, 5); 
	String RITerritory = xlsInputData.getCellData("RI_Version", ClientData, 6);
	String EditingRights = xlsInputData.getCellData("RI_Version", ClientData, 7);
	String DealCreationCDEStatusReview = xlsInputData.getCellData("RI_Version", ClientData, 8);
	String DealCreationCDEStatusInProgress = xlsInputData.getCellData("RI_Version", ClientData, 9);

	//RI_RevenueParticipation
	String RIRevenuePartAppliesTo = xlsInputData.getCellData("RI_RevenuePart", ClientData, 2);
	String RIRevenuePartParty = xlsInputData.getCellData("RI_RevenuePart", ClientData, 3);
	String RIRevenuePartServices = xlsInputData.getCellData("RI_RevenuePart", ClientData, 4);
	String RIRevenuePartRole = xlsInputData.getCellData("RI_RevenuePart", ClientData, 5);
	String RIRevenuePartMedia = xlsInputData.getCellData("RI_RevenuePart", ClientData, 6);
	String RIRevenuePartPlatform = xlsInputData.getCellData("RI_RevenuePart", ClientData, 7);
	String RIRevenuePartTerritory = xlsInputData.getCellData("RI_RevenuePart", ClientData, 8);
	String RIRevenuePartTier = xlsInputData.getCellData("RI_RevenuePart", ClientData, 9);
	String RIRevenuePartDefinition = xlsInputData.getCellData("RI_RevenuePart", ClientData, 10);
	String RIRevenuePartParticipation = xlsInputData.getCellData("RI_RevenuePart", ClientData, 11);
	String RIRevenuePartPaymentTerm = xlsInputData.getCellData("RI_RevenuePart", ClientData, 12);
	String RIRevenuePartCurrency = xlsInputData.getCellData("RI_RevenuePart", ClientData, 13);
	String RIRevenuePartAmount = xlsInputData.getCellData("RI_RevenuePart", ClientData, 14);
	String RIRevenuePartDefaultDates = xlsInputData.getCellData("RI_RevenuePart", ClientData, 15);
	String RIRevenuePartStartdate = xlsInputData.getCellData("RI_RevenuePart", ClientData, 16);
	String RIRevenuePartEnddate = xlsInputData.getCellData("RI_RevenuePart", ClientData, 17);
	String RIRevenuePartCaps = xlsInputData.getCellData("RI_RevenuePart", ClientData, 18);
	String RIRevenuePartNote = xlsInputData.getCellData("RI_RevenuePart", ClientData, 19);
	String RIRevenuePartBusinessterm =xlsInputData.getCellData("RI_RevenuePart", ClientData, 20);
	String RIRevenuePartVenue =xlsInputData.getCellData("RI_RevenuePart", ClientData, 21);

	//RI_Documents
	String RIDocumentTypeValue = xlsInputData.getCellData("RI_Documents", ClientData, 3);
	String RIDocumentName = xlsInputData.getCellData("RI_Documents", ClientData, 4);
	String RIDocumentDate = xlsInputData.getCellData("RI_Documents", ClientData, 5);
	String RIDocumentDesc = xlsInputData.getCellData("RI_Documents", ClientData, 6);
	String RIUploadLoc = xlsInputData.getCellData("RI_Documents", ClientData, 8);
	String RIDocumentID = xlsInputData.getCellData("RI_Documents", ClientData, 9);
	String RILibrarySelect = xlsInputData.getCellData("RI_Documents", ClientData, 10);



	//RI_TrackingEvents
	String MediaRightsMedType 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 2);
	String TrEvMediaRightsVenue 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 3);
	String MediaRightsPlatforms 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 4);
	String MediaRightsRestrictions 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 5);
	String MediaRightsBusOut 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 6);
	String TrEvMediaRightsTerritory = xlsInputData.getCellData("RI_TrackingEvent", ClientData, 7);
	String MediaRightsLanguage 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 8);
	String NegotiationDeadline 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 9);
	String PaymentProfitCenter 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 10);

	//RI_Projectteam
	String ProjTeamMediaRightsParty 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 2);
	String ProjTeamMediaRightsMediaType 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 3);
	String ProjTeamMediaRightsVenue 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 4);
	String ProjTeamMediaRightsPlatform 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 5);
	String ProjTeamMediaRightsRestriction 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 6);
	String ProjTeamMediaRightsBusinessOutlet = xlsInputData.getCellData("RI_ProjectTeam", ClientData, 7);
	String ProjTeamMediaRightsTerritory 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 8);
	String ProjTeamMediaRightsLanguages 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 9);
	String ProjTeamMediaRightsTermfrom 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 10);
	String ProjTeamMediaRightsTermTo 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 11);
	String ProjTeamMediaRightsEstimateDate 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 12);
	String ProjTeamMediaRightsEstimateEndDate = xlsInputData.getCellData("RI_ProjectTeam", ClientData, 13);
	String ProjTeamMediaRightsTermfrom2 	= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 14);
	String ProjTeamMediaRightsTermTo2 		= xlsInputData.getCellData("RI_ProjectTeam", ClientData, 15);
	String ProjTeamMediaRightsEstimateDate2 = xlsInputData.getCellData("RI_ProjectTeam", ClientData, 16);
	String ProjTeamMediaRightsEstimateEndDate2 = xlsInputData.getCellData("RI_ProjectTeam", ClientData, 17);

	//RI Payments
	String PaymentsParty = xlsInputData.getCellData("RI_Payment", ClientData, 2);
	String PaymentsPartyUpdate = xlsInputData.getCellData("RI_Payment", ClientData, 3);
	String PaymentsTerritory = xlsInputData.getCellData("RI_Payment", ClientData, 4);
	String PaymentsBudgetLine = xlsInputData.getCellData("RI_Payment", ClientData, 5);    


	//RI_BusinessTerm
	String RIBusinessTermCatvalues  = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 2);
	String RIBusinessTermTempvalues = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 3);
	String RIBusinessTermDescvalues = xlsInputData.getCellData("RI_BusinessTerms", ClientData, 4);


	//RI_MediaRights
	String Rowno = xlsInputData.getCellData("RI_MediaRights", ClientData, 2);
	String MediaRightsAppliesTo = xlsInputData.getCellData("RI_MediaRights", ClientData, 3);
	String Ext_CarveOut = xlsInputData.getCellData("RI_MediaRights", ClientData, 4);
	String MediaRightsParty = xlsInputData.getCellData("RI_MediaRights", ClientData, 5);
	String MediaRightsMedia = xlsInputData.getCellData("RI_MediaRights", ClientData, 6);
	String MediaRightsVenue = xlsInputData.getCellData("RI_MediaRights", ClientData, 7);
	String MediaRightsPlatform = xlsInputData.getCellData("RI_MediaRights", ClientData, 8);
	String MediaRightsRestriction = xlsInputData.getCellData("RI_MediaRights", ClientData, 9);
	String MediaRightsBusinessOutlet = xlsInputData.getCellData("RI_MediaRights", ClientData, 10);
	String MediaRightsTerritory = xlsInputData.getCellData("RI_MediaRights", ClientData, 11);
	String MediaRightsLanguages = xlsInputData.getCellData("RI_MediaRights", ClientData, 12);
	String MediaRightsPerpetuity = xlsInputData.getCellData("RI_MediaRights", ClientData, 13);
	String MediaRightsTermfrom = xlsInputData.getCellData("RI_MediaRights", ClientData, 14);
	String MediaRightsTermTo = xlsInputData.getCellData("RI_MediaRights", ClientData, 15);
	String MediaRightsExclusivity = xlsInputData.getCellData("RI_MediaRights", ClientData, 16);
	String Holdback = xlsInputData.getCellData("RI_MediaRights", ClientData, 17);
	String Sublicense = xlsInputData.getCellData("RI_MediaRights", ClientData, 18);
	String MediaRightsNotes = xlsInputData.getCellData("RI_MediaRights", ClientData, 19);
	String MediaRightsBusinessTerm =xlsInputData.getCellData("RI_MediaRights", ClientData, 20);

	//RI_Audit Trial Report 
	String RI_AgreementNameKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 2);
	String RI_DealDescriptionKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 3);
	String RI_AgreementTypeKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 4);
	String RI_CreatedDateKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 5);
	String RI_CreatedTimeKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 6);
	String RI_CreatedByKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 7);
	String RI_LastUpdatedDateKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 8);
	String RI_LastUpdatedTimeKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 9);
	String RI_LastUpdatedByKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 10);
	String RI_RowNoKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 11);
	String RI_AppliesToKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 12);
	String RI_ModuleNameKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 13);
	String RI_TabNameKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 14);
	String RI_UserNameKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 15);
	String RI_RecordTypeKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 16);
	String RI_UpdatedDateKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 17);
	String RI_UpdatedTimeKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 18);
	String RI_FieldNameKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 19);
	String RI_OldValueKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 20);
	String RI_NewValueKey = xlsInputData.getCellData("RI_Audit_Trial_Report", "Keys", 21);

	//RI_Tracking Events
	//-------------------------------------------Keys of View/Edit Mode-------------------------------------------------//
	//Keys of Parent Headers
	//The value of @key of EventGroup in Parent row= The value of @key of TrackingEvent in allocated row
	String RI_TrackEvents_EventGroup_Key		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 51);
	String RI_TrackEvents_Notes_Key 			= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 52);

	//Keys of Child Headers
	String RI_TrackEvents_RowNo_Key				= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 62);
	String RI_TrackEvents_AppliesTO_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 63);
	String RI_TrackEvents_AppliesTOPopUp_Key 	= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 64);
	String RI_TrackEvents_EventName_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 65);
	String RI_TrackEvents_DealName_Key 			= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 66);
	String RI_TrackEvents_DealPopUp_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 67);
	String RI_TrackEvents_DealClear_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 68);
	String RI_TrackEvents_Deliverable_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 69);
	String RI_TrackEvents_DeliverablePopUp_Key 	= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 70);
	String RI_TrackEvents_EventDate_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 71);
	String RI_TrackEvents_EstimatedDate_Key 		= xlsInputData.getCellData("RI_TrackingEvent", "Keys", 72);
	//-------------------------------------------Headers of view Mode-------------------------------------------------//
	//Name of Parent Headers in Edit Mode
	String RI_TrackEvents_EventGroup_ViewMode		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 3);
	String RI_TrackEvents_Notes_ViewMode 				= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 4);

	//Name of Child Headers in Edit Mode
	String RI_TrackEvents_RowNo_ViewMode			= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 15);
	String RI_TrackEvents_AppliesTO_ViewMode 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 16);
	String RI_TrackEvents_EventName_ViewMode 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 17);
	String RI_TrackEvents_DealName_ViewMode 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 18);	
	String RI_TrackEvents_Deliverable_ViewMode 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 19);
	String RI_TrackEvents_EventDate_ViewMode 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 20);

	//-------------------------------------------Headers of Edit Mode-------------------------------------------------//
	//Name of Parent Headers in Edit Mode
	String RI_TrackEvents_EventGroup			= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 51);
	String RI_TrackEvents_Notes 				= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 52);

	//Name of Child Headers in Edit Mode
	String RI_TrackEvents_RowNo				= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 62);
	String RI_TrackEvents_AppliesTO 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 63);
	String RI_TrackEvents_AppliesTOPopUp 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 64);
	String RI_TrackEvents_EventName 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 65);
	String RI_TrackEvents_DealName 			= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 66);
	String RI_TrackEvents_DealPopUp 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 67);
	String RI_TrackEvents_DealClear 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 68);
	String RI_TrackEvents_Deliverable 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 69);
	String RI_TrackEvents_DeliverablePopUp 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 70);
	String RI_TrackEvents_EventDate 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 71);
	String RI_TrackEvents_EstimatedDate 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 72);

	//-------------------------------------------Buttons of Tracking Event's in Edit Mode-------------------------------------------------//
	String RI_TrackingEvents_EditMode_Copy 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 94);
	String RI_TrackingEvents_EditMode_New   	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 95);
	String RI_TrackingEvents_EditMode_Delete   	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 96);
	String RI_TrackingEvents_EditMode_Save   	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 97);
	String RI_TrackingEvents_EditMode_Cancel   	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 98);
	String RI_TrackingEvents_EditMode_Allocate  = xlsInputData.getCellData("RI_TrackingEvent", ClientData, 99);


	//-------------------------------------------TestData of Tracking Event's in Edit Mode-------------------------------------------------//
	String RI_TrackingEvents_Universal_EventGroup 					= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 152);
	String RI_TrackingEvents_Initial_ExhibitionDate 				= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 160);
	String RI_TrackingEvents_InitialExhibition_Of_LastEpisodesDate 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 161);
	String RI_TrackingEvents_LicenseFrom 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 162);
	String RI_TrackingEvents_LicenseTo	 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 163);
	String RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate = xlsInputData.getCellData("RI_TrackingEvent", ClientData, 164);
	String RI_TrackingEvents_InitialExhibition_Of_FirstEpisodesDate_OfLastSeason = xlsInputData.getCellData("RI_TrackingEvent", ClientData, 165);
	String RI_TrackingEvents_PromoStartDate 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 166);
	String RI_TrackingEvents_PromoEndDate 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 167);
	String RI_TrackingEvents_ProjectedDate 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 168);
	String RI_TrackingEvents_NegotiatedDeadlineDate 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 169);
	String RI_TrackingEvents_ContractEndDate 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 170);

	String RI_TrackingEvents_NoteTestData	 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 192);
	String RI_TrackingEvents_DelivaryOfFirstEpisode = xlsInputData.getCellData("RI_TrackingEvent", ClientData, 191);



	//-------------------------------------------Validation Messages-------------------------------------------------//
	String RI_TrackingEvents_ValMsg_Dlt_WithoutSelectRow 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 231);
	String RI_TrackingEvents_ValMsg_Dlt_SelectRow 			= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 232);

	//-------------------------------------------Validation Messages-------------------------------------------------//
	String RI_TrackingEvents_EventDate112014		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 300);
	String RI_TrackingEvents_EventDate122014		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 301);
	String RI_TrackingEvents_EventDate142014		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 302);
	String RI_TrackingEvents_EventDate152014		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 303);
	String RI_TrackingEvents_EventDate112012		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 304);
	String RI_TrackingEvents_EventDate212012		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 305);
	String RI_TrackingEvents_EventDate312012		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 306);
	String RI_TrackingEvents_EventDate_1_15_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 307);
	String RI_TrackingEvents_EventDate_1_22_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 308);
	String RI_TrackingEvents_EventDate_1_29_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 309);
	String RI_TrackingEvents_EventDate_9_25_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 310);
	String RI_TrackingEvents_EventDate_10_2_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 311);
	String RI_TrackingEvents_EventDate_10_9_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 312);
	String RI_TrackingEvents_EventDate_11_1_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 313);
	String RI_TrackingEvents_EventDate_11_8_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 314);
	String RI_TrackingEvents_EventDate_11_15_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 315);
	String RI_TrackingEvents_EventDate112013		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 316);
	String RI_TrackingEvents_EventDate112015		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 317);
	String RI_TrackingEvents_EventDate112017		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 318);
	String RI_TrackingEvents_EventDate112010		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 319);
	String RI_TrackingEvents_EventDate_3_1_2013		 		= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 320);
	String RI_TrackingEvents_EventDate_12_31_2012		 	= xlsInputData.getCellData("RI_TrackingEvent", ClientData, 321);




	//Fin_RI_Payment tab
	//Keys of Parent Header
	String RI_Payments_RowNo_Key 							= xlsInputData.getCellData("RI_Payment", "KeyValues", 2);
	String RI_Payments_AppliesTo_Key					    = xlsInputData.getCellData("RI_Payment", "KeyValues", 3);
	String RI_Payments_Party_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 4);
	String RI_Payments_PaymentType_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 5);
	String RI_Payments_Media_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 6);
	String RI_Payments_Territory_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 7);
	String RI_Payments_TermFrom_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 8);
	String RI_Payments_TermTo_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 9);
	String RI_Payments_Amount_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 10);
	String RI_Payments_DueDate_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 11);
	String RI_Payments_GeneralTerms_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 12);

	//Keys of Asset value header
	String RI_Payments_Assetvalue_AppliesTo_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 15);
	String RI_Payments_Assetvalue_Amount_Key = xlsInputData.getCellData("RI_Payment", "KeyValues", 16);

	//Field values of Asset values frame
	String RI_Payment_Assetvalue_AppliesTo = xlsInputData.getCellData("RI_Payment", ClientData, 15);
	String RI_Payment_Assetvalue_AmountTo = xlsInputData.getCellData("RI_Payment", ClientData, 16);

	//Field Value
	String RI_Payment_Rowno = xlsInputData.getCellData("RI_Payment", ClientData, 2);
	String RI_Payment_AppliesTo = xlsInputData.getCellData("RI_Payment", ClientData, 3);
	String RI_Payment_Party = xlsInputData.getCellData("RI_Payment", ClientData, 4);
	String RI_Payment_PaymentType = xlsInputData.getCellData("RI_Payment", ClientData, 5);
	String RI_Payment_Media = xlsInputData.getCellData("RI_Payment", ClientData, 6);
	String RI_Payment_Territory = xlsInputData.getCellData("RI_Payment", ClientData, 7);
	String RI_Payment_TermFrom = xlsInputData.getCellData("RI_Payment", ClientData, 8);
	String RI_Payment_TermTo = xlsInputData.getCellData("RI_Payment", ClientData, 9);
	String RI_Payment_Amount = xlsInputData.getCellData("RI_Payment", ClientData, 10);
	String RI_Payment_DueDate = xlsInputData.getCellData("RI_Payment", ClientData, 11);
	String RI_Payments_GeneralTerms = xlsInputData.getCellData("RI_Payment", "KeyValues", 12);
	

	//RI_Payment Frame Test Data
	String RI_Payment_Appliesto_All = xlsInputData.getCellData("RI_Payment", ClientData, 51);
	String RI_Payment_Appliesto_Season1 = xlsInputData.getCellData("RI_Payment", ClientData, 52);
	String RI_Payment_Appliesto_Episode101 = xlsInputData.getCellData("RI_Payment", ClientData, 53);
	String RI_Payment_Appliesto_Episode102 = xlsInputData.getCellData("RI_Payment", ClientData, 54);
	String RI_Payment_Appliesto_Season2 = xlsInputData.getCellData("RI_Payment", ClientData, 55);
	String RI_Payment_Appliesto_Episode201 = xlsInputData.getCellData("RI_Payment", ClientData, 56);
	String RI_Payment_Appliesto_Episode202 = xlsInputData.getCellData("RI_Payment", ClientData, 57);
	String RI_Payment_Paymenttypedata = xlsInputData.getCellData("RI_Payment", ClientData, 58);
	String RI_Payment_Amountdata = xlsInputData.getCellData("RI_Payment", ClientData, 63);
	String RI_Payment_Duedatedata1 = xlsInputData.getCellData("RI_Payment", ClientData, 64);
	String RI_Payment_Partyname1data = xlsInputData.getCellData("RI_Payment", ClientData, 65);
	String RI_Payment_Partyname2data = xlsInputData.getCellData("RI_Payment", ClientData, 66);
	String RI_Payment_Duedatedata2 = xlsInputData.getCellData("RI_Payment", ClientData, 67);
	String RI_Payment_Duedatedata3 = xlsInputData.getCellData("RI_Payment", ClientData, 68);
	String RI_Payment_Duedatedata4 = xlsInputData.getCellData("RI_Payment", ClientData, 69);
	String RI_Payment_UpdatedAmountData = xlsInputData.getCellData("RI_Payment", ClientData, 70);

	//RI_Payment Asset value frame data
	String RI_Payment_Assetvalue_Appliesto_All = xlsInputData.getCellData("RI_Payment", ClientData, 73);
	String RI_Payment_Assetvalue_Season1 = xlsInputData.getCellData("RI_Payment", ClientData, 74);
	String RI_Payment_Assetvalue_Episode101 = xlsInputData.getCellData("RI_Payment", ClientData, 75);
	String RI_Payment_Assetvalue_Episode102 = xlsInputData.getCellData("RI_Payment", ClientData, 76);
	String RI_Payment_Assetvalue_Season2 = xlsInputData.getCellData("RI_Payment", ClientData, 77);
	String RI_Payment_Assetvalue_Episode201 = xlsInputData.getCellData("RI_Payment", ClientData, 78);
	String RI_Payment_Assetvalue_Episode202 = xlsInputData.getCellData("RI_Payment", ClientData, 79);
	String RI_Payment_Assetvalue_Amountdata = xlsInputData.getCellData("RI_Payment", ClientData, 80);


	//RI_AuditTrail
	//String RI_AuditTrail of Search Criteria Fields
	String RI_AuditTrailDealName                              = xlsInputData.getCellData("RI_AuditTrail", ClientData, 3);
	String RI_AuditTrailDealCode                              = xlsInputData.getCellData("RI_AuditTrail", ClientData, 4);
	String RI_AuditTrailDealTabs                              = xlsInputData.getCellData("RI_AuditTrail", ClientData, 5);
	String RI_AuditTrailDealModule                            = xlsInputData.getCellData("RI_AuditTrail", ClientData, 6);
	String RI_AuditTrailUpdatedDatesFrom                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 7);
	String RI_AuditTrailUpdatedDatesTo                        = xlsInputData.getCellData("RI_AuditTrail", ClientData, 8);
	String RI_AuditTrailUserID                                = xlsInputData.getCellData("RI_AuditTrail", ClientData, 9);
	String RI_AuditTrailUserIDMutliSelectIcon                 = xlsInputData.getCellData("RI_AuditTrail", ClientData, 10);
	String RI_AuditTrailTitleName                             = xlsInputData.getCellData("RI_AuditTrail", ClientData, 11);
	String RI_AuditTrailTitleID                               = xlsInputData.getCellData("RI_AuditTrail", ClientData, 12);
	String RI_AuditTrailDistributor                           = xlsInputData.getCellData("RI_AuditTrail", ClientData, 13);
	String RI_AuditTrailDistributorMutliSelectIcon            = xlsInputData.getCellData("RI_AuditTrail", ClientData, 14);
	String RI_AuditTrailDistributorClearIcon                  = xlsInputData.getCellData("RI_AuditTrail", ClientData, 15);
	String RI_AuditTrailContractStatus                        = xlsInputData.getCellData("RI_AuditTrail", ClientData, 16);
	String RI_AuditTrailContractDataEntryStatus               = xlsInputData.getCellData("RI_AuditTrail", ClientData, 17);
	String RI_AuditTrailGroup                                 = xlsInputData.getCellData("RI_AuditTrail", ClientData, 18);
	String RI_AuditTrailGroupMutliSelectIcon                  = xlsInputData.getCellData("RI_AuditTrail", ClientData, 19);

	//Check Boxes
	String RI_AuditTrailExactMatch                            = xlsInputData.getCellData("RI_AuditTrail", ClientData, 30);

	//Buttons Available
	String RI_AuditTrailSearchbutton                          = xlsInputData.getCellData("RI_AuditTrail", ClientData, 37);
	String RI_AuditTrailClearSearchbutton                     = xlsInputData.getCellData("RI_AuditTrail", ClientData, 38);
	String RI_AuditTrailSaveSearchbutton                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 39);
	String RI_AuditTrailRestoreSearchbutton                   = xlsInputData.getCellData("RI_AuditTrail", ClientData, 40);

	//Buttons Available in Picklist
	String RI_AuditTrailSelectAllbutton                       = xlsInputData.getCellData("RI_Inventory", ClientData, 49);
	String RI_AuditTrailDeselectAllbutton                     = xlsInputData.getCellData("RI_Inventory", ClientData, 50);
	String RI_AuditTrailApplybutton                           = xlsInputData.getCellData("RI_Inventory", ClientData, 51);
	String RI_AuditTrailCancelbutton                          = xlsInputData.getCellData("RI_Inventory", ClientData, 52);

	//Save Search Window
	String RI_AuditTrailSaveSearchHeader                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 236);    
	String RI_AuditTrailScope                                 = xlsInputData.getCellData("RI_AuditTrail", ClientData, 237);
	String RI_AuditTrailSaveformyuseonly_Local                = xlsInputData.getCellData("RI_AuditTrail", ClientData, 238);
	String RI_AuditTrailSavesoeveryonecanuse_Global           = xlsInputData.getCellData("RI_AuditTrail", ClientData, 239);
	String RI_AuditTrailOptions                               = xlsInputData.getCellData("RI_AuditTrail", ClientData, 240);
	String RI_AuditTrailOverwritethecurrentsavedsearch        = xlsInputData.getCellData("RI_AuditTrail", ClientData, 241);
	String RI_AuditTrailSaveasanewsearch                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 242);
	String RI_AuditTrailSave                                  = xlsInputData.getCellData("RI_AuditTrail", ClientData, 243);
	String RI_AuditTrailCancelSaveSearch                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 244);
	
	//Restore Search Window
	String RI_AuditTrailSearch                                = xlsInputData.getCellData("RI_AuditTrail", ClientData, 254);
	String RI_AuditTrailSearchfor                             = xlsInputData.getCellData("RI_AuditTrail", ClientData, 255);
	String RI_AuditTrailMysearches_Local                      = xlsInputData.getCellData("RI_AuditTrail", ClientData, 256);
	String RI_AuditTrailGlobalsearches                        = xlsInputData.getCellData("RI_AuditTrail", ClientData, 257);
	String RI_AuditTrailResults                               = xlsInputData.getCellData("RI_AuditTrail", ClientData, 258);
	String RI_AuditTrailSearchName                            = xlsInputData.getCellData("RI_AuditTrail", ClientData, 259);
	String RI_AuditTrailSearchRestorebutton                   = xlsInputData.getCellData("RI_AuditTrail", ClientData, 260);
	String RI_AuditTrailRestorebutton                         = xlsInputData.getCellData("RI_AuditTrail", ClientData, 261);
	String RI_AuditTrailDeleteRestorebutton                   = xlsInputData.getCellData("RI_AuditTrail", ClientData, 262);
	String RI_AuditTrailCancelRestorebutton                   = xlsInputData.getCellData("RI_AuditTrail", ClientData, 263);

	//Keys RI_AuditTrail of Search Results Fields
	String RI_AuditTrailAgreementNameKey                       = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 269);
	String RI_AuditTrailDealCodeKey                      	   = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 270);
	String RI_AuditTrailAgreementTypeKey                       = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 271);
	String RI_AuditTrailCreatedDateKey                         = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 272);
	String RI_AuditTrailCreatedTimeKey                         = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 273);
	String RI_AuditTrailCreatedByKey                           = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 274);
	String RI_AuditTrailLastUpdatedDateKey                     = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 275);
	String RI_AuditTrailLastUpdatedTimeKey                     = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 276);
	String RI_AuditTrailLastUpdatedByKey                       = xlsInputData.getCellData("RI_AuditTrail", "KeyValues", 277);

	//Buttons at Search Results fields
	String RI_AuditTrailViewDeal                               = xlsInputData.getCellData("RI_AuditTrail", ClientData, 295);

	
	
	

}
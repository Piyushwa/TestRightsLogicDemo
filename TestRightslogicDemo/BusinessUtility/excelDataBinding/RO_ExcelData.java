package excelDataBinding;

import utility.PropertyReader;

public interface RO_ExcelData {
    
	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\InputData_MultipleClient.xlsx");
	String ClientData = PropertyReader.readApplicationFile("Client");
	 
	//RO_ProjectTeam
	String AddNewInternalPartyCountry = xlsInputData.getCellData("ROProjectTeam", ClientData, 2);
	String AddNewInternalPartyState = xlsInputData.getCellData("ROProjectTeam", ClientData, 3);
	String AddNewInternalPartyUser = xlsInputData.getCellData("ROProjectTeam", ClientData, 4);
	String AddNewInternalPartyContact1 = xlsInputData.getCellData("ROProjectTeam", ClientData, 5);
	String AddNewInternalPartyContact2 = xlsInputData.getCellData("ROProjectTeam", ClientData, 6);
	String AddNewInternalPartyContact3 = xlsInputData.getCellData("ROProjectTeam", ClientData, 7);

	//RO_TrackingEvents
	String EventGroupUniEvent = xlsInputData.getCellData("ROTrackingEvent", ClientData, 2);
	String AppliesToTrEv = xlsInputData.getCellData("ROTrackingEvent", ClientData, 3);
	String TrackingEventTrEv = xlsInputData.getCellData("ROTrackingEvent", ClientData, 4);
	String EventDateTrEv = xlsInputData.getCellData("ROTrackingEvent", ClientData, 5);
	String DeliverableGroupTrEv = xlsInputData.getCellData("ROTrackingEvent", ClientData, 6);
	String TrackingEventTrEv2 = xlsInputData.getCellData("ROTrackingEvent", ClientData, 7);
	String TrackingEventTrEv3 = xlsInputData.getCellData("ROTrackingEvent", ClientData, 8);

	//RO_Guarantees
	String GuaranteesAppliesTo = xlsInputData.getCellData("RO_Guarantees", ClientData, 2);
	String GuaranteesParty = xlsInputData.getCellData("RO_Guarantees", ClientData, 3);
	String GuaranteesOperator = xlsInputData.getCellData("RO_Guarantees", ClientData, 4);
	String GuaranteesMin = xlsInputData.getCellData("RO_Guarantees", ClientData, 5);
	String GuaranteesUsageLimit = xlsInputData.getCellData("RO_Guarantees", ClientData, 6);
	String GuaranteesUnits1 = xlsInputData.getCellData("RO_Guarantees", ClientData, 7);
	String GuaranteesMinutes = xlsInputData.getCellData("RO_Guarantees", ClientData, 8);
	String GuaranteesTimePeriod = xlsInputData.getCellData("RO_Guarantees", ClientData, 9);
	String GuaranteesChangeTimePeriod = xlsInputData.getCellData("RO_Guarantees", ClientData, 10);
	String GuaranteesLanguage = xlsInputData.getCellData("RO_Guarantees", ClientData, 11);
	String GuaranteesCurrency = xlsInputData.getCellData("RO_Guarantees", ClientData, 12);
	String GuaranteesFee  = xlsInputData.getCellData("RO_Guarantees", ClientData, 13);
	String GuaranteesTermFrom  = xlsInputData.getCellData("RO_Guarantees", ClientData, 14);
	String GuaranteesTermTo  = xlsInputData.getCellData("RO_Guarantees", ClientData, 15);
	String GuaranteesType  = xlsInputData.getCellData("RO_Guarantees", ClientData, 16);
	String GuaranteesTrueUp  = xlsInputData.getCellData("RO_Guarantees", ClientData, 17);
	String GuaranteesFrequency = xlsInputData.getCellData("RO_Guarantees", ClientData, 18);
	String GuaranteesUnits = xlsInputData.getCellData("RO_Guarantees", ClientData, 19);
	String GuaranteesNotes = xlsInputData.getCellData("RO_Guarantees", ClientData, 20);
	String GuaranteesChangeTermTo = xlsInputData.getCellData("RO_Guarantees", ClientData, 21);
	String GuaranteesLanguage1 = xlsInputData.getCellData("RO_Guarantees", ClientData, 22);
	String GuaranteesPlatform = xlsInputData.getCellData("RO_Guarantees", ClientData, 23);
	String GuaranteesFee2 = xlsInputData.getCellData("RO_Guarantees", ClientData, 24);
	String GuaranteesTermFrom1 = xlsInputData.getCellData("RO_Guarantees", ClientData, 25);
	String GuaranteesTermTo1 = xlsInputData.getCellData("RO_Guarantees", ClientData, 26);

	//RO_Payments
	String ROPaymentsParty = xlsInputData.getCellData("ROPayment", ClientData, 2);
	String ROPaymentsPartyUpdate = xlsInputData.getCellData("ROPayment", ClientData, 3);
	String ROPaymentsTerritory = xlsInputData.getCellData("ROPayment", ClientData, 4);
	String ROPaymentsBudgetLine = xlsInputData.getCellData("ROPayment", ClientData, 5);
	

	//RO_BusinessTerm
	String ROBusinessTermCatvalues  = xlsInputData.getCellData("RO_BusinessTerms", ClientData, 2);
	String ROBusinessTermTempvalues = xlsInputData.getCellData("RO_BusinessTerms", ClientData, 3);
	String ROBusinessTermDescvalues = xlsInputData.getCellData("RO_BusinessTerms", ClientData, 4);
	
	//RO_Documents
	String RODocumentTypeValue = xlsInputData.getCellData("RO_Documents", ClientData, 3);
	String RODocumentName = xlsInputData.getCellData("RO_Documents", ClientData, 4);
	String RODocumentDate = xlsInputData.getCellData("RO_Documents", ClientData, 5);
	String RODocumentDesc = xlsInputData.getCellData("RO_Documents", ClientData, 6);
	String ROUploadLoc = xlsInputData.getCellData("RO_Documents", ClientData, 8);
	String RODocumentID = xlsInputData.getCellData("RO_Documents", ClientData, 9);
	String ROLibrarySelect = xlsInputData.getCellData("RO_Documents", ClientData, 10);
	
	//RO_RevenueParticipation
	String RORevenuePartAppliesTo = xlsInputData.getCellData("RO_RevenuePart", ClientData, 2);
	String RORevenuePartParty = xlsInputData.getCellData("RO_RevenuePart", ClientData, 3);
	String RORevenuePartServices = xlsInputData.getCellData("RO_RevenuePart", ClientData, 4);
	String RORevenuePartRole = xlsInputData.getCellData("RO_RevenuePart", ClientData, 5);
	String RORevenuePartMedia = xlsInputData.getCellData("RO_RevenuePart", ClientData, 6);
	String RORevenuePartPlatform = xlsInputData.getCellData("RO_RevenuePart", ClientData, 7);
	String RORevenuePartTerritory = xlsInputData.getCellData("RO_RevenuePart", ClientData, 8);
	String RORevenuePartTier = xlsInputData.getCellData("RO_RevenuePart", ClientData, 9);
	String RORevenuePartDefinition = xlsInputData.getCellData("RO_RevenuePart", ClientData, 10);
	String RORevenuePartParticipation = xlsInputData.getCellData("RO_RevenuePart", ClientData, 11);
	String RORevenuePartPaymentTerm = xlsInputData.getCellData("RO_RevenuePart", ClientData, 12);
	String RORevenuePartCurrency = xlsInputData.getCellData("RO_RevenuePart", ClientData, 13);
	String RORevenuePartAmount = xlsInputData.getCellData("RO_RevenuePart", ClientData, 14);
	String RORevenuePartDefaultDates = xlsInputData.getCellData("RO_RevenuePart", ClientData, 15);
	String RORevenuePartStartdate = xlsInputData.getCellData("RO_RevenuePart", ClientData, 16);
	String RORevenuePartEnddate = xlsInputData.getCellData("RO_RevenuePart", ClientData, 17);
	String RORevenuePartCaps = xlsInputData.getCellData("RO_RevenuePart", ClientData, 18);
	String RORevenuePartNote = xlsInputData.getCellData("RO_RevenuePart", ClientData, 19);
	String RORevenuePartBusinessterm =xlsInputData.getCellData("RO_RevenuePart", ClientData, 20);
	
	//RO_Options
	String ROOptionsAppliesTo  = xlsInputData.getCellData("RO_Options", ClientData, 2);
	String ROOptionsOptionType  = xlsInputData.getCellData("RO_Options", ClientData, 3);
	String ROOptionsRIOptionsParty  = xlsInputData.getCellData("RO_Options", ClientData, 4);
	String ROOptionsRIOptionsNetwork  = xlsInputData.getCellData("RO_Options", ClientData, 5);
	String ROOptionsMedia  = xlsInputData.getCellData("RO_Options", ClientData, 6);
	String ROOptionsTerritory  = xlsInputData.getCellData("RO_Options", ClientData, 7);
	String ROOptionsAddtlPrograms  = xlsInputData.getCellData("RO_Options", ClientData, 8);
	String ROOptionsAddtlPerpetuity  = xlsInputData.getCellData("RO_Options", ClientData, 9);
	String ROOptionsProjectedDate  = xlsInputData.getCellData("RO_Options", ClientData, 10);
	String ROOptionsNegotiationdeadline  = xlsInputData.getCellData("RO_Options", ClientData, 11);
	String ROOptionsFirstNegotiation  = xlsInputData.getCellData("RO_Options", ClientData, 12);
	String ROOptionsFirstRefusal  = xlsInputData.getCellData("RO_Options", ClientData, 13);
	String ROOptionsLastRefusal  = xlsInputData.getCellData("RO_Options", ClientData, 14);
	String ROOptionsMaxbudget  = xlsInputData.getCellData("RO_Options", ClientData, 15);
	String ROOptionsCurrency  = xlsInputData.getCellData("RO_Options", ClientData, 16);
	String ROOptionsOfferedAmount  = xlsInputData.getCellData("RO_Options", ClientData, 17);
	String ROOptionsNotes  = xlsInputData.getCellData("RO_Options", ClientData, 18);
	String ROOptionsExercised  = xlsInputData.getCellData("RO_Options", ClientData, 19);
	String ROOptionsFinalExercised  = xlsInputData.getCellData("RO_Options", ClientData, 20);
	
	//RO_Obligations
	String ROOBLIGAppliesTo  = xlsInputData.getCellData("RO_Obligations", ClientData, 2);
	String ROOBLIGFrom = xlsInputData.getCellData("RO_Obligations", ClientData, 3);
	String ROOBLIGTo = xlsInputData.getCellData("RO_Obligations", ClientData, 4);
	String ROOBLIGCat = xlsInputData.getCellData("RO_Obligations", ClientData, 5);
	String ROOBLIGType = xlsInputData.getCellData("RO_Obligations", ClientData, 6);
	String ROOBLIGMedia = xlsInputData.getCellData("RO_Obligations", ClientData, 7);
	String ROOBLIGStartdate = xlsInputData.getCellData("RO_Obligations", ClientData, 9);
	String ROOBLIGEnddate = xlsInputData.getCellData("RO_Obligations", ClientData, 10);
	String ROOBLIGStatus = xlsInputData.getCellData("RO_Obligations", ClientData, 11);
	String ROOBLIGValue = xlsInputData.getCellData("RO_Obligations", ClientData, 12);
	String ROOBLIGValuefill = xlsInputData.getCellData("RO_Obligations", ClientData, 13);
	String ROOBLIGBusinessterm = xlsInputData.getCellData("RO_Obligations", ClientData, 15);
	
	//RO_General
    String ROPARTY = xlsInputData.getCellData("RO_General", "ObjectID", 40);
    String ROPARTY_POPUP = xlsInputData.getCellData("RO_General", "ObjectID", 41);
    String ROPARTYTYPE = xlsInputData.getCellData("RO_General", "ObjectID", 42);
    
    //RO_Version
    String VersionNameKey = xlsInputData.getCellData("RO_Version", "Keys", 2);
    String VersionNumberKey = xlsInputData.getCellData("RO_Version", "Keys", 3);
    String VersionTypeKey = xlsInputData.getCellData("RO_Version", "Keys", 4);
    String DealStatusKey= xlsInputData.getCellData("RO_Version", "Keys", 5);
    String VersionDateKey = xlsInputData.getCellData("RO_Version", "Keys", 6);
    String CreatedByKey = xlsInputData.getCellData("RO_Version", "Keys", 7);
    String NotesKey = xlsInputData.getCellData("RO_Version", "Keys", 8);

    //RO_PromoRights - Global values	
    String APPLIESTO_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 2);
    String MEDIA_TEMPLATE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 3);
    String TERRITORY_TEMPLATE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 4);
    String PROMO_RIGHTS_TEMPLATE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 5);
    String FLAG_UNLIMITED_USE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 6);
    String FLAG_USE_OUTSIDE_PROGRAM_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 7);
    String START_DATE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 8);
    String END_DATE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 9);
    String START_TIME_CODE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 10);
    String END_TIME_CODE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 11);
    String NOTE_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 12);
    String APPLIESTO_POPUP_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 13);
    String MEDIA_POPUP_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 14);
    String TERRITORY_POPUP_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 15);
    String PROMO_POPUP_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 16);
    String PROMOEVENT_POPUP_Key = xlsInputData.getCellData("RO_PromoRights", "KeyValues", 17);
    
    //RO_EditingRights - Global values
    String EDITAPPLIESTO_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 2);
    String EDITING_RIGHTS_TEMPLATE = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 3);
    String EDITFLAG_PERPETUITY = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 4);
    String FLAG_PROGRAM_USE = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 5);
    String EDITSTART_DATE_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 6);
    String EDITEND_DATE_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 7);
    String EDITSTART_TIME_CODE_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 8);
    String EDITEND_TIME_CODE_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 9);
    String EDITAPPLIESTO_POPUP_Key = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 10);
    String EDITING_RIGHTS_POPUP = xlsInputData.getCellData("RO_EditingRights", "KeyValues", 11);
    
    //RO_Obligations - Global values
    String ROOBLIGAPPLIESTO = xlsInputData.getCellData("RO_Obligations", "KeyValues", 2);
    String ROOBLIGFROM = xlsInputData.getCellData("RO_Obligations", "KeyValues", 3);
    String ROOBLIGTO = xlsInputData.getCellData("RO_Obligations", "KeyValues", 4);
    String ROOBLIGCAT = xlsInputData.getCellData("RO_Obligations", "KeyValues", 5);
    String ROOBLIGTYPE = xlsInputData.getCellData("RO_Obligations", "KeyValues", 6);
    String ROOBLIGMEDIA = xlsInputData.getCellData("RO_Obligations", "KeyValues", 7);
    String ROOBLIGFLAG_PERPETUITY = xlsInputData.getCellData("RO_Obligations", "KeyValues", 8);
    String ROOBLIGSTART_DATE = xlsInputData.getCellData("RO_Obligations", "KeyValues", 9);
    String ROOBLIGEND_DATE = xlsInputData.getCellData("RO_Obligations", "KeyValues", 10);
    String ROOBLIGSTATUS = xlsInputData.getCellData("RO_Obligations", "KeyValues", 11);
    String ROOBLIGVALUE = xlsInputData.getCellData("RO_Obligations", "KeyValues", 12);
    String ROOBLIGVALUEFILLED = xlsInputData.getCellData("RO_Obligations", "KeyValues", 13);
    String ROOBLIGCURRENCY = xlsInputData.getCellData("RO_Obligations", "KeyValues", 14);
    String ROOBLIGNOTE = xlsInputData.getCellData("RO_Obligations", "KeyValues", 15);
    String ROOBLIGAPPLIESTO_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 16);
    String ROOBLIGFROM_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 17);
    String ROOBLIGTO_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 18);
    String ROOBLIGREPINDV_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 19);
    String ROOBLIGTYPE_REF_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 20);
    String ROOBLIGMEDIA_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 21);
    String ROOBLIGTERMEVENT_POPUP = xlsInputData.getCellData("RO_Obligations", "KeyValues", 22);
    
    //RO_BusinessTerm - Global values
    String ROBusinessTermsCategory = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 2);
    String ROBusinessTermsTemplate = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 3);
    String ROBusinessTermsNotes = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 4);
    String ROBusinessTermsTemplatePopup = xlsInputData.getCellData("RI_BusinessTerms", "KeyValues", 5);
    
    //RO_Services - Global values
    String ROServicesAPPLIESTO = xlsInputData.getCellData("RO_Services", "KeyValues", 2);
    String ROServicesID_PARTY = xlsInputData.getCellData("RO_Services", "KeyValues", 3);
    String ROServices = xlsInputData.getCellData("RO_Services", "KeyValues", 4);
    String ROServicesBegin = xlsInputData.getCellData("RO_Services", "KeyValues", 5);
    String ROServicesEnd = xlsInputData.getCellData("RO_Services", "KeyValues", 6);
    String ROServicesUnion = xlsInputData.getCellData("RO_Services", "KeyValues", 7);
    String ROServicesBUSINESS_EXCLUSIVE_TERMS = xlsInputData.getCellData("RO_Services", "KeyValues", 8);
    String ROServicesNOTE = xlsInputData.getCellData("RO_Services", "KeyValues", 9);
    String ROServicesPAID_ADS = xlsInputData.getCellData("RO_Services", "KeyValues", 10);
    String ROServicesBUSINESS_CREDIT_TERMS = xlsInputData.getCellData("RO_Services", "KeyValues", 11);
    String ROServicesCHARACTER = xlsInputData.getCellData("RO_Services", "KeyValues", 12);
    String ROServicesS_ORDER = xlsInputData.getCellData("RO_Services", "KeyValues", 13);
    String ROServicesCREDIT_TEXT = xlsInputData.getCellData("RO_Services", "KeyValues", 14);
    String ROServicesTITLE_PERCENTAGE = xlsInputData.getCellData("RO_Services", "KeyValues", 15);
    String ROServicesPosition = xlsInputData.getCellData("RO_Services", "KeyValues", 16);
    String ROServicesNOTE_IMG = xlsInputData.getCellData("RO_Services", "KeyValues", 17);
    String ROServicesDOCUMENT_LINK = xlsInputData.getCellData("RO_Services", "KeyValues", 18);
    String ROServicesPAGE_NUMBER = xlsInputData.getCellData("RO_Services", "KeyValues", 19);
    String ROServicesAPPLIESTO_POPUP = xlsInputData.getCellData("RO_Services", "KeyValues", 21);
    String ROServices_POPUP = xlsInputData.getCellData("RO_Services", "KeyValues", 22);
    String ROServicesTERMEVENT_POPUP = xlsInputData.getCellData("RO_Services", "KeyValues", 23);
    String ROServicesUNION_POPUP = xlsInputData.getCellData("RO_Services", "KeyValues", 24);
    
    //RO_ProjectTeam - Global values
    String ROProjectTeamName = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 2);
    String ROProjectTeamRole = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 3);
    String ROProjectTeamApproval = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 4);
    String ROProjectTeamApprove = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 5);
    String ROProjectTeamNotify = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 6);
    String ROProjectTeamNotes = xlsInputData.getCellData("RO_ProjectTeam", "KeyValues", 7);
    
    //RO_RevenueParticipation - Global values	
    String RORevenuPartAPPLIESTO = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 2);
    String RORevenuPartPARTY = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 3);
    String RORevenuPartTYPE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 4);
    String RORevenuPartRole = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 5);
    String RORevenuPartMEDIA_TEMPLATE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 6);
    String RORevenuPartPKGING_RIGHTS_TEMPLATE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 7);
    String RORevenuPartTERRITORY_TEMPLATE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 8);
    String RORevenuPartTIER = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 9);
    String RORevenuPart_DEFN_TM = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 10);
    String RORevenuPart_PART_TM = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 11);
    String RORevenuPartPAYMENT_TERMS = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 12);
    String RORevenuPartCURRENCY = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 13);
    String RORevenuPartAMOUNT_DOLLAR = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 14);
    String RORevenuPartDEFAULT_DATES = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 15);
    String RORevenuPartTERM_FROM_DATE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 16);
    String RORevenuPartTERM_TO_DATE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 17);
    String RORevenuPartCAP_DOLLAR = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 18);
    String RORevenuPartNOTE = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 19);
    String RORevenuPartAPPLIESTO_POPUP = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 21);
    String RORevenuPartMEDIA_POPUP = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 22);
    String RORevenuPartPKGING_RIGHTS_POPUP = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 23);
    String RORevenuPartTERRITORY_POPUP = xlsInputData.getCellData("RO_RevenuePart", "KeyValues", 24);
    
    //RO_Option - Global values	
    String ROOPTIONAPPLIES_TO = xlsInputData.getCellData("RO_Options", "KeyValues", 2);
    String ROOPTIONTYPE = xlsInputData.getCellData("RO_Options", "KeyValues", 3);
    String ROOPTIONPARTY = xlsInputData.getCellData("RO_Options", "KeyValues", 4);
    String ROOPTIONNETWORK = xlsInputData.getCellData("RO_Options", "KeyValues", 5);
    String ROOPTIONMEDIA = xlsInputData.getCellData("RO_Options", "KeyValues", 6);
    String ROOPTIONTERRITORY = xlsInputData.getCellData("RO_Options", "KeyValues", 7);
    String ROOPTIONADDL_PROGRAMS = xlsInputData.getCellData("RO_Options", "KeyValues", 8);
    String ROOPTIONFLAG_ADDL_PERPETUITY = xlsInputData.getCellData("RO_Options", "KeyValues", 9);
    String ROOPTIONPROJECTED_EX_DATE = xlsInputData.getCellData("RO_Options", "KeyValues", 10);
    String ROOPTIONOPTION_DEADLINE_DATE = xlsInputData.getCellData("RO_Options", "KeyValues", 11);
    String ROOPTIONFLAG_FIRST_NEGOT = xlsInputData.getCellData("RO_Options", "KeyValues", 12);
    String ROOPTIONFLAG_FIRST_REFUSAL = xlsInputData.getCellData("RO_Options", "KeyValues", 13);
    String ROOPTIONFLAG_LAST_REFUSAL = xlsInputData.getCellData("RO_Options", "KeyValues", 14);
    String ROOPTIONBUDGET_INCREASE = xlsInputData.getCellData("RO_Options", "KeyValues", 15);
    String ROOPTIONCURRENCY = xlsInputData.getCellData("RO_Options", "KeyValues", 16);
    String ROOPTIONOFFERED_AMOUNT = xlsInputData.getCellData("RO_Options", "KeyValues", 17);
    String ROOPTIONOPTION_TERMS = xlsInputData.getCellData("RO_Options", "KeyValues", 18);
    String ROOPTIONFLAG_EXERCISED = xlsInputData.getCellData("RO_Options", "KeyValues", 19);
    String ROOPTIONFINAL_EXERCISED_DATE = xlsInputData.getCellData("RO_Options", "KeyValues", 20);
    String ROOPTIONapplies_to_popup = xlsInputData.getCellData("RO_Options", "KeyValues", 21);
    String ROOPTIONSPARTY_POPUP = xlsInputData.getCellData("RO_Options", "KeyValues", 22);
    String ROOPTIONMEDIA_UD_POPUP = xlsInputData.getCellData("RO_Options", "KeyValues", 23);
    String ROOPTIONTERRITORY_UD_POPUP = xlsInputData.getCellData("RO_Options", "KeyValues", 24);
    String ROOPTIONADDL_PERIOD_IMG = xlsInputData.getCellData("RO_Options", "KeyValues", 25);
    String ROOPTIONPROJECTED_EX_DATE_IMAGE = xlsInputData.getCellData("RO_Options", "KeyValues", 26);

    //RO_Documents - Global values
    String RODOCAPPLIESTO_VALUE= xlsInputData.getCellData("RO_Documents", "KeyValues", 2);
    String RODOCUMENTTYPE= xlsInputData.getCellData("RO_Documents", "KeyValues", 3);
    String ROdocname= xlsInputData.getCellData("RO_Documents", "KeyValues", 4);
    String RODOCUMENTDATE= xlsInputData.getCellData("RO_Documents", "KeyValues", 5);
    String RODOCfiledesc= xlsInputData.getCellData("RO_Documents", "KeyValues", 6);
    String RODOCfiledate= xlsInputData.getCellData("RO_Documents", "KeyValues", 7);

    //RO_Guarantees
    String GuaranteesAppliesToKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 2);
    String GuaranteesPartyKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 3);
    String GuaranteesUsageTemplateKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 4);
    String GuaranteesRightsKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 5);
    String GuaranteesTerritoryKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 6);
    String GuaranteesLanguageKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 7);
    String GuaranteesPlatformKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 8);
    String GuaranteesPackagingTemplateKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 9);
    String GuaranteesCurrencyKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 10);
    String GuaranteesGuaranteeFeeKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 11);
    String GuaranteesFromKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 12);
    String GuaranteesToKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 13);
    String GuaranteesGuaranteeTypeKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 14);
    String GuaranteesTrueUpKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 15);
    String GuaranteesFrequencyKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 16);
    String GuaranteesUnitsKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 17);
    String GuaranteesNotesKey = xlsInputData.getCellData("RO_Guarantees", "Keys", 18);

    //RO_TrackingEvents
    String AppliesToTrEvKey = xlsInputData.getCellData("ROTrackingEvent", "Keys", 2);
    String TrackingEventKey = xlsInputData.getCellData("ROTrackingEvent", "Keys", 3);
    String DeliverableGroupKey = xlsInputData.getCellData("ROTrackingEvent", "Keys", 4);
    String EventDateKey = xlsInputData.getCellData("ROTrackingEvent", "Keys", 5);
    String EstimatedDateKey = xlsInputData.getCellData("ROTrackingEvent", "Keys", 6);
    //RO_TrackingEvents

    //RO_Payment Schedule
    String PayScheCurrencyKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 2);
    String PayScheMaterialKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 3);
    String PayScheTotalFeeKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 4);	
    String PayScheAppliesToKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 5);
    String PayScheAppliesToPopUpKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 6);
    String PaySchePaymentKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 7);
    String PayScheDueDateKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 8);
    String PayScheAmountDueKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 9);
    String PayScheNotesKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 10);
    String PayScheInvoiceNumberKey = xlsInputData.getCellData("ROPaymentSchedule", "Keys", 11);
    
    //RO_Workflow
    String WorkflowNameKey = xlsInputData.getCellData("ROWorkflow", "Keys", 2);
    String WorkflowNamePopUpKey = xlsInputData.getCellData("ROWorkflow", "Keys", 3);
    String WorkflowNameRoleKey = xlsInputData.getCellData("ROWorkflow", "Keys", 4);
    String WorkflowDescriptionKey = xlsInputData.getCellData("ROWorkflow", "Keys", 5);
    String WorkflowWFStatusKey = xlsInputData.getCellData("ROWorkflow", "Keys", 6);
    String WorkflowApprovalStatusKey = xlsInputData.getCellData("ROWorkflow", "Keys", 7);
    String WorkflowPriorityKey = xlsInputData.getCellData("ROWorkflow", "Keys", 8);
    String WorkflowFlagApproveKey = xlsInputData.getCellData("ROWorkflow", "Keys", 9);
    String WorkflowFlagDenyKey = xlsInputData.getCellData("ROWorkflow", "Keys", 10);
    String WorkflowLastUpdatedKey = xlsInputData.getCellData("ROWorkflow", "Keys", 11);
    String WorkflowNotesKey = xlsInputData.getCellData("ROWorkflow", "Keys", 12);
    String WorkflowFlagNAKey = xlsInputData.getCellData("ROWorkflow", "Keys", 13);	
    String WorkflowWFStatusTemplate = xlsInputData.getCellData("ROWorkflow", "Keys", 14);
    String WorkflowNamePopUpTemplate = xlsInputData.getCellData("ROWorkflow", "Keys", 15);
    String WorkflowDelAppliesToTemplate = xlsInputData.getCellData("ROWorkflow", "Keys", 16);
    
    

    //RO_Attributes
    String RO_AttributesAppliesToKey = xlsInputData.getCellData("RO_Attributes", "Keys", 2);
    String RO_AttributesAttributeKey = xlsInputData.getCellData("RO_Attributes", "Keys", 3);
    String RO_AttributesValue1Key = xlsInputData.getCellData("RO_Attributes", "Keys", 4);
    String RO_AttributesValue2Key = xlsInputData.getCellData("RO_Attributes", "Keys", 5);
    

    
    //RO_CollisionReport
    String RO_CollisionReportRowNoKey = xlsInputData.getCellData("RI_Restriction", "Keys", 2);
    String RO_CollisionReportApplieseToKey = xlsInputData.getCellData("RI_Restriction", "Keys", 3);
    String RO_CollisionReportMediaKey = xlsInputData.getCellData("RI_Restriction", "Keys", 4);
    String RO_CollisionReportTerritoryKey = xlsInputData.getCellData("RI_Restriction", "Keys", 5);
    String RO_CollisionReportLanguageKey = xlsInputData.getCellData("RI_Restriction", "Keys", 6);
    String RO_CollisionReportOutletKey = xlsInputData.getCellData("RI_Restriction", "Keys", 7);
    String RO_CollisionReportFromKey = xlsInputData.getCellData("RI_Restriction", "Keys", 8);
    String RO_CollisionReportToKey = xlsInputData.getCellData("RI_Restriction", "Keys", 9);
    String RO_CollisionReportExcelKey = xlsInputData.getCellData("RI_Restriction", "Keys", 10);
    String RO_CollisionReportHoldBackKey = xlsInputData.getCellData("RI_Restriction", "Keys", 11);
    String RO_CollisionReportNotesKey = xlsInputData.getCellData("RI_Restriction", "Keys", 12);
    String RO_CollisionReportIdKey = xlsInputData.getCellData("RI_Restriction", "Keys", 13);
    String RO_CollisionReportNameKey = xlsInputData.getCellData("RI_Restriction", "Keys", 14);
    String RO_CollisionReportTypeKey = xlsInputData.getCellData("RI_Restriction", "Keys", 15);

    //RO General
    String RODealCreationDealType = xlsInputData.getCellData("RO_General", ClientData, 2);
    String RODealCreationDealSubType = xlsInputData.getCellData("RO_General", ClientData, 3);
    String RODealCreationContractStatus = xlsInputData.getCellData("RO_General", ClientData, 4);
    String RODealCreationCDEStatus = xlsInputData.getCellData("RO_General", ClientData, 5);
    String RODealCreationCurrency = xlsInputData.getCellData("RO_General", ClientData, 6);
    String RODealCreationProjectStatus = xlsInputData.getCellData("RO_General", ClientData, 8);
    String RODealCreationProfitCenter = xlsInputData.getCellData("RO_General", ClientData, 14);
    String ROSourceBusinessUnit = xlsInputData.getCellData("RO_General", ClientData, 18);
    String RODealProjectID = xlsInputData.getCellData("RO_General", ClientData, 9);
    String RODealStage = xlsInputData.getCellData("RO_General", ClientData, 7);
    String ROOrigNetwork = xlsInputData.getCellData("RO_General", ClientData, 10);
    String ROPackage = xlsInputData.getCellData("RO_General", ClientData, 11);
    String ROMasterAgreement = xlsInputData.getCellData("RO_General", ClientData, 12);
    String ROBudgetLine = xlsInputData.getCellData("RO_General", ClientData, 13);
    String ROIntegrationAction = xlsInputData.getCellData("RO_General", ClientData, 15);
    String ROBillingFrequency = xlsInputData.getCellData("RO_General", ClientData, 16);
    String ROContractOrigin = xlsInputData.getCellData("RO_General", ClientData, 17);
    String ROPartyDialogType1 = xlsInputData.getCellData("RO_General", ClientData, 26);
    String ROPartyOutlet1 = xlsInputData.getCellData("RO_General", ClientData, 27);
    String ROPartytype1 = xlsInputData.getCellData("RO_General", ClientData, 22);
    String ROPartyDialogType2 = xlsInputData.getCellData("RO_General", ClientData, 28);
    String ROPartytype2 = xlsInputData.getCellData("RO_General", ClientData, 23);
    String ROPartytype3 = xlsInputData.getCellData("RO_General", ClientData, 24);
    String ROPartytype4 = xlsInputData.getCellData("RO_General", ClientData, 25);
    String RODealPriority = xlsInputData.getCellData("RO_General", ClientData, 29);
    String RODealSubject = xlsInputData.getCellData("RO_General", ClientData, 30);
    String RODealNotesTextField = xlsInputData.getCellData("RO_General", ClientData, 31);
    String RODueDate = xlsInputData.getCellData("RO_General", ClientData, 32);
    String ROPartyName1 = xlsInputData.getCellData("RO_General", ClientData, 20);
    String ROPartyName2= xlsInputData.getCellData("RO_General", ClientData, 21);
    String ROExecutedDate = xlsInputData.getCellData("RO_General", ClientData, 33);
    String ROEffectiveDate = xlsInputData.getCellData("RO_General", ClientData, 34);
    String ROLicenseGroup = xlsInputData.getCellData("RO_General", ClientData, 35);
    String ROExpectedMsg1 = xlsInputData.getCellData("RO_General", ClientData, 36);
    String ROExpectedMsg2 = xlsInputData.getCellData("RO_General", ClientData, 37);
    String ROExpectedMsg3 = xlsInputData.getCellData("RO_General", ClientData, 38);
    String ROExpectedMsg4 = xlsInputData.getCellData("RO_General", ClientData, 39);
    //RO_PromoRights
    String AppliesTo = xlsInputData.getCellData("RO_PromoRights", ClientData, 2);
    String MediaPromo = xlsInputData.getCellData("RO_PromoRights", ClientData, 3);
    String Territory = xlsInputData.getCellData("RO_PromoRights", ClientData, 4);
    String PromoRightsPromo = xlsInputData.getCellData("RO_PromoRights", ClientData, 5);
    String Unlimited_Use = xlsInputData.getCellData("RO_PromoRights", ClientData, 6);
    String Outside_Program = xlsInputData.getCellData("RO_PromoRights", ClientData, 7);
    String Start_date = xlsInputData.getCellData("RO_PromoRights", ClientData, 8);
    String End_date = xlsInputData.getCellData("RO_PromoRights", ClientData, 9);
    String Startime_code = xlsInputData.getCellData("RO_PromoRights", ClientData, 10);
    String Endtime_code = xlsInputData.getCellData("RO_PromoRights", ClientData, 11);
    String Notes = xlsInputData.getCellData("RO_PromoRights", ClientData, 12);
    //RO_EditingRights
    String EditAppliesTo = xlsInputData.getCellData("RO_EditingRights", ClientData, 2);
    String EditingRightsEdit = xlsInputData.getCellData("RO_EditingRights", ClientData, 3);
    String Program_Use = xlsInputData.getCellData("RO_EditingRights", ClientData, 5);
    String EditStart_date = xlsInputData.getCellData("RO_EditingRights", ClientData, 6);
    String EditEnd_date = xlsInputData.getCellData("RO_EditingRights", ClientData, 7);
    String EditStartime_code = xlsInputData.getCellData("RO_EditingRights", ClientData, 8);
    String EditEndtime_code = xlsInputData.getCellData("RO_EditingRights", ClientData, 9);
    
    //RO_Version
    String VersionCreationType = xlsInputData.getCellData("RO_Version", ClientData, 2);
    String EditedContractStatus = xlsInputData.getCellData("RO_Version", ClientData, 3);

    //RO_Services
    String ROServicesAppliesTo = xlsInputData.getCellData("RO_Services", ClientData, 2);
    String ROServicesParty = xlsInputData.getCellData("RO_Services", ClientData, 3);
    String ROServiceIn = xlsInputData.getCellData("RO_Services", ClientData, 4);
    String ROServicesBeginValue = xlsInputData.getCellData("RO_Services", ClientData, 5);
    String ROServiceEndValue = xlsInputData.getCellData("RO_Services", ClientData, 6);
    String ROServicesUnionValue = xlsInputData.getCellData("RO_Services", ClientData, 7);
    String ROServiceDetails = xlsInputData.getCellData("RO_Services", ClientData, 9);
    String ROServiceCharacter = xlsInputData.getCellData("RO_Services", ClientData, 12);
    String ROServiceOrder = xlsInputData.getCellData("RO_Services", ClientData, 13);
    String ROServiceCreditText = xlsInputData.getCellData("RO_Services", ClientData, 14);
    String ROServiceTitleper = xlsInputData.getCellData("RO_Services", ClientData, 15);
    String ROServicesPositionValue = xlsInputData.getCellData("RO_Services", ClientData, 16);
    String ROServicesDocumentLink = xlsInputData.getCellData("RO_Services", ClientData, 18);
    String ROServicesPageNo = xlsInputData.getCellData("RO_Services", ClientData, 19);
    String ROServicesBusinessterm = xlsInputData.getCellData("RO_Services", ClientData, 20);
  }

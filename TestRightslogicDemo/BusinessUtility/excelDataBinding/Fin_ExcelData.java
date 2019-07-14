package excelDataBinding;

import utility.PropertyReader;

public interface Fin_ExcelData {

	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\Fin_TestData.xlsx");
	String ClientData = PropertyReader.readApplicationFile("Client");


	// RI_Fin_Common Data
	String Fin_RI_ContractStatus                                                   = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 20);
	
    //key values for all fields present in Change deal Gadget Popup window
	String Fin_Changedealgadget_Generaltab_Key                                     = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 3);
	String Fin_Changedealgadget_MediaRightstab_Key                                 = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 4);
	String Fin_Changedealgadget_Paymenttab_Key                                     = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 5);
	String Fin_Changedealgadget_Exhibitionstab_Key                                 = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 6);
	String Fin_Changedealgadget_Appliesto_label_Key		                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 7);
	String Fin_Changedealgadget_TabName_label_Key		                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 8);
	String Fin_Changedealgadget_FieldChanged_label_Key	                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 9);
	String Fin_Changedealgadget_FromValue_label_Key			                       = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 10);
	String Fin_Changedealgadget_ToValue_label_Key		                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 11);
	String Fin_Changedealgadget_Acceptbutton_Key 		                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 12);
	String Fin_Changedealgadget_Rejectbutton_Key		                           = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 13);
	String Fin_Changedealgadget_Cancelbutton_Key			                       = xlsInputData.getCellData("RI_Fin_CHG", "KeyValues", 14);
	
	
	// All Labels and Input fields present on the Change Deal Gadget Popup Window
	String Fin_Changedealgadget_Generaltab                                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 3);
	String Fin_Changedealgadget_MediaRightstab                                     = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 4);
	String Fin_Changedealgadget_Paymenttab                                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 5);
	String Fin_Changedealgadget_Exhibitionstab                                     = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 6);
	String Fin_Changedealgadget_Appliesto_label		                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 7);
	String Fin_Changedealgadget_TabName_label		                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 8);
	String Fin_Changedealgadget_FieldChanged_label	                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 9);
	String Fin_Changedealgadget_FromValue_label			                           = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 10);
	String Fin_Changedealgadget_ToValue_label		                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 11);
	String Fin_Changedealgadget_Acceptbutton 		                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 12);
	String Fin_Changedealgadget_Rejectbutton		                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 13);
	String Fin_Changedealgadget_Cancelbutton			                           = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 14);


	//Change Deal Gadget Data for General tab
	String Fin_Changedealgadget_TabNamedatafor_Row2to8data                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 33);
	String Fin_Changedealgadget_TabNamedatafor_Row9to15data                        = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 34);
	String Fin_Changedealgadget_FieldChangedfor_Row2to8data                        = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 35);
	String Fin_Changedealgadget_FieldChangedfor_Row9data                           = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 36);
	String Fin_Changedealgadget_FieldChangedfor_Row10data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 37);
	String Fin_Changedealgadget_FieldChangedfor_Row11data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 38);
	String Fin_Changedealgadget_FieldChangedfor_Row12data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 39);
	String Fin_Changedealgadget_FieldChangedfor_Row13data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 40);
	String Fin_Changedealgadget_FieldChangedfor_Row14data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 41);
	String Fin_Changedealgadget_FieldChangedfor_Row15data                          = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 42);
	
	String Fin_Changedealgadget_BudgetLinedata                                     = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 43);
	String Fin_Changedealgadget_CDESdata                                           = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 44);
	String Fin_Changedealgadget_ContractStatusdata                                 = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 45);
	String Fin_Changedealgadget_Currencydata                                       = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 46);
	String Fin_Changedealgadget_DateExecuteddata                                   = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 47);
	String Fin_Changedealgadget_DealPartiesdata                                    = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 48);
	String Fin_Changedealgadget_ProfitCenterdata                                   = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 49);
	
	//Change Deal Gadget Data for Media Rights tab
	String Fin_Changedealgadget_TabNameDatafor_MRRow                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 54);
	String Fin_Changedealgadget_FieldChangedDatafor_MRRow2                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 55);
	String Fin_Changedealgadget_FieldChangedDatafor_MRRow3                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 56);
	String Fin_Changedealgadget_FieldChangedDatafor_MRRow4                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 57);
	String Fin_Changedealgadget_FieldChangedDatafor_MRRow5                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 58);
	String Fin_Changedealgadget_FieldChangedDatafor_MRRow6                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 59);
	
	//Change Deal Gadget Data for Exhibitions tab
	String Fin_Changedealgadget_TabNameDatafor_ExhRow                              = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 69);
	String Fin_Changedealgadget_FieldChangedDatafor_ExRow2                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 70);
	String Fin_Changedealgadget_FieldChangedDatafor_ExRow7                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 71);
	String Fin_Changedealgadget_FieldChangedDatafor_ExRow8                         = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 72);
	
	//Change Deal Gadget Data for Payment tab
	String Fin_Changedealgadget_TabNameDatafor_PaymentFrameRow                     = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 76);
	String Fin_Changedealgadget_TabNameDatafor_AssetvalueFrameRow                  = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 77);
	String Fin_Changedealgadget_FieldChangedDatafor_AmountRow                      = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 78);
	String Fin_Changedealgadget_FieldChangedDatafor_DuedateRow                     = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 79);
	String Fin_Changedealgadget_FieldChangedDatafor_PaymenttypeRow                 = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 80);
	String Fin_Changedealgadget_FieldChangedDatafor_Paymenttype_AssetvalueRow      = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 81);
	

	
	//Change Deal Gadget Data for Reminder functionality
	String Fin_Changedealgadget_Reminder_SubjectData                               = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 84);
	String Fin_Changedealgadget_Reminder_NotesData                                 = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 85);
	String Fin_Changedealgadget_Reminder_AlertMsg                                  = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 88);
	String Fin_Changedealgadget_Amount_AlertMsg                                    = xlsInputData.getCellData("RI_Fin_CHG", ClientData, 89);
	
	//Fin_Agreement_Search
	String Fin_AggrementSearchDealName                                             = xlsInputData.getCellData("RI_Fin_Search", ClientData, 3);
	String Fin_AggrementSearchContractDescription                                  = xlsInputData.getCellData("RI_Fin_Search", ClientData, 4);
	String Fin_AggrementSearchDealType                                             = xlsInputData.getCellData("RI_Fin_Search", ClientData, 5);
	String Fin_AggrementSearchAgreementType                                        = xlsInputData.getCellData("RI_Fin_Search", ClientData, 6);
	String Fin_AggrementSearchContractingEntity                                    = xlsInputData.getCellData("RI_Fin_Search", ClientData, 7);
	String Fin_AggrementSearchVendorParty                                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 8);
	String Fin_AggrementSearchDealStatus                                           = xlsInputData.getCellData("RI_Fin_Search", ClientData, 9);
	String Fin_AggrementSearchProfitCenter                                         = xlsInputData.getCellData("RI_Fin_Search", ClientData, 10);
	String Fin_AggrementSearchContractStatus                                       = xlsInputData.getCellData("RI_Fin_Search", ClientData, 11);
	String Fin_AggrementSearchCDES                                                 = xlsInputData.getCellData("RI_Fin_Search", ClientData, 12);
	String Fin_AggrementSearchLicenseTerm                                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 13);
	String Fin_AggrementSearchExecutionDate                                        = xlsInputData.getCellData("RI_Fin_Search", ClientData, 14);
	String Fin_AggrementSearchAssetName                                            = xlsInputData.getCellData("RI_Fin_Search", ClientData, 15);
	String Fin_AggrementSearchAssetID                                              = xlsInputData.getCellData("RI_Fin_Search", ClientData, 16);
	String Fin_AggrementSearchFinanceStatus                                        = xlsInputData.getCellData("RI_Fin_Search", ClientData, 17);
	String Fin_AggrementSearchExactMatch                                           = xlsInputData.getCellData("RI_Fin_Search", ClientData, 18);
	String Fin_AggrementSearch_HeaderName 		                                   = xlsInputData.getCellData("RI_Fin_Search", ClientData, 19);
	
	
	//Fin_AgreementSearch_Buttons
	String Fin_AggrementSearch_Searchbutton                                        = xlsInputData.getCellData("RI_Fin_Search", ClientData, 41);
	String Fin_AggrementSearch_ClearSearchbutton                                   = xlsInputData.getCellData("RI_Fin_Search", ClientData, 42);
	String Fin_AggrementSearch_SaveSearchbutton                                    = xlsInputData.getCellData("RI_Fin_Search", ClientData, 43);
	String Fin_AggrementSearch_RestoreSearchbutton                                 = xlsInputData.getCellData("RI_Fin_Search", ClientData, 44);
	
	//Fin_SearchResult Headers
	String Fin_AggrementSearch_DealName_Key                                        = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 22);
	String Fin_AggrementSearch_DealType_Key                                        = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 23);
	String Fin_AggrementSearch_Vendor_Key                                          = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 24);
	String Fin_AggrementSearch_ContractStatus_Key                                  = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 25);
	String Fin_AggrementSearch_CDES_Key                                            = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 26);
	String Fin_AggrementSearch_BudgetLine_Key                                      = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 27);
	String Fin_AggrementSearch_FinancialStatus_Key                                 = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 28);
	String Fin_AggrementSearch_ProfitCenter_Key                                    = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 29);
	String Fin_AggrementSearch_DealStatus_Key                                      = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 30);
	String Fin_AggrementSearch_AppliesTo_Key                                       = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 31);
	String Fin_AggrementSearch_FinancialLife_Key                                   = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 32);
	String Fin_AggrementSearch_AssetValue_Key                                      = xlsInputData.getCellData("RI_Fin_Search", "KeyValues", 33);
	
	String Fin_AggrementSearch_DealName                                            = xlsInputData.getCellData("RI_Fin_Search", ClientData, 22);
	String Fin_AggrementSearch_DealType                                            = xlsInputData.getCellData("RI_Fin_Search", ClientData, 23);
	String Fin_AggrementSearch_Vendor                                              = xlsInputData.getCellData("RI_Fin_Search", ClientData, 24);
	String Fin_AggrementSearch_ContractStatus                                      = xlsInputData.getCellData("RI_Fin_Search", ClientData, 25);
	String Fin_AggrementSearch_CDES                                                = xlsInputData.getCellData("RI_Fin_Search", ClientData, 26);
	String Fin_AggrementSearch_BudgetLine                                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 27);
	String Fin_AggrementSearch_FinancialStatus                                     = xlsInputData.getCellData("RI_Fin_Search", ClientData, 28);
	String Fin_AggrementSearch_ProfitCenter                                        = xlsInputData.getCellData("RI_Fin_Search", ClientData, 29);
	String Fin_AggrementSearch_DealStatus                                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 30);
	String Fin_AggrementSearch_AppliesTo                                           = xlsInputData.getCellData("RI_Fin_Search", ClientData, 31);
	String Fin_AggrementSearch_FinancialLife                                       = xlsInputData.getCellData("RI_Fin_Search", ClientData, 32);
	String Fin_AggrementSearch_AssetValue                                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 33);
	
	//Fin_Agreement_Searchresult data
	String Fin_AggrementSearch_DealType_Acq_data                                   = xlsInputData.getCellData("RI_Fin_Search", ClientData, 54);
	String Fin_AggrementSearch_DealStatus_Approved_data                            = xlsInputData.getCellData("RI_Fin_Search", ClientData, 55);
	String Fin_AggrementSearch_ContractStatus_FullExecuted_data                    = xlsInputData.getCellData("RI_Fin_Search", ClientData, 56);
	String Fin_AggrementSearch_CDES_Finalized_data                                 = xlsInputData.getCellData("RI_Fin_Search", ClientData, 57);
	String Fin_AggrementSearch_ExecutionDateTermFrom_data                          = xlsInputData.getCellData("RI_Fin_Search", ClientData, 58);
	String Fin_AggrementSearch_ExecutionDateTermTo_data                            = xlsInputData.getCellData("RI_Fin_Search", ClientData, 59);
	String Fin_AggrementSearch_LicenseTermFrom_data                                = xlsInputData.getCellData("RI_Fin_Search", ClientData, 60);
	String Fin_AggrementSearch_LicenseTermTo_data                                  = xlsInputData.getCellData("RI_Fin_Search", ClientData, 61);
	
	//Fin_General_Tab data
	String Fin_General_DealDetails_Legend                                          = xlsInputData.getCellData("RL_Fin_General", ClientData, 3);
	String Fin_General_Party_Legend                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 4);
	String Fin_General_Notes_Legend                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 5);
	String Fin_General_AssetSummary_Legend                                         = xlsInputData.getCellData("RL_Fin_General", ClientData, 6);
	String Fin_General_Liabilities_Legend                                          = xlsInputData.getCellData("RL_Fin_General", ClientData, 7);
	
	//String Deal Details Locators
	String Fin_General_DealID                                                      = xlsInputData.getCellData("RL_Fin_General", ClientData, 12);
	String Fin_General_DealDescription                                             = xlsInputData.getCellData("RL_Fin_General", ClientData, 13);
	String Fin_General_DealName                                                    = xlsInputData.getCellData("RL_Fin_General", ClientData, 14);
	String Fin_General_DealType                                                    = xlsInputData.getCellData("RL_Fin_General", ClientData, 15);
	String Fin_General_ContractStatus                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 16);
	String Fin_General_CDES                                                        = xlsInputData.getCellData("RL_Fin_General", ClientData, 17);
	String Fin_General_ProjectStatus                                               = xlsInputData.getCellData("RL_Fin_General", ClientData, 18);
	String Fin_General_DateExecuted                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 19);
	String Fin_General_DateEffective                                               = xlsInputData.getCellData("RL_Fin_General", ClientData, 20);
	String Fin_General_ContractCurrency                                            = xlsInputData.getCellData("RL_Fin_General", ClientData, 21);
	String Fin_General_BudgetLine                                                  = xlsInputData.getCellData("RL_Fin_General", ClientData, 22);
	String Fin_General_FinancialStatus                                             = xlsInputData.getCellData("RL_Fin_General", ClientData, 23);
	
	
	//Party,Notes,Asset values and Liabilities Key Values
	String Fin_General_PartyType_Key                                               = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 27);
	String Fin_General_Party_Key                                                   = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 28);
	String Fin_General_ProfitCenter_Key                                            = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 29);
	String Fin_General_Priority_Key                                                = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 30);
	String Fin_General_Subject_Key                                                 = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 31);
	String Fin_General_CreatedDate_Key                                             = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 32);
	String Fin_General_DueDate_Key                                                 = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 33);
	String Fin_General_CreatedBy_Key                                               = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 34);
	String Fin_General_Notes_Key                                                   = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 35);
	String Fin_General_AV_AppliesTo_Key                                            = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 36);
	String Fin_General_AV_Currency_Key                                             = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 37);
	String Fin_General_AV_AssetAmount_Key                                          = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 38);
	String Fin_General_AV_AmortAmount_Key                                          = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 39);
	String Fin_General_AV_NBV_Key                                                  = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 40);
	String Fin_General_AV_AsOf_Key                                                 = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 41);
	String Fin_General_Liabilities_PaymentDescription_Key                          = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 42);
	String Fin_General_Liabilities_DueDate_Key                                     = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 43);
	String Fin_General_Liabilities_Currency_Key                                    = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 44);
	String Fin_General_Liabilities_Amount_Key                                      = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 45);
	String Fin_General_Liabilities_Paid_Key                                        = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 46);
	String Fin_General_Liabilities_PaidDate_Key                                    = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 47);	
	String Fin_General_Liabilities_CheckNumber_Key                                 = xlsInputData.getCellData("RL_Fin_General", "KeyValues", 48);
	
	
	//Party,Notes,Asset values and Liabilities Field Label Name
	String Fin_General_PartyType                                                   = xlsInputData.getCellData("RL_Fin_General", ClientData, 27);
	String Fin_General_Party                                                       = xlsInputData.getCellData("RL_Fin_General", ClientData, 28);
	String Fin_General_ProfitCenter                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 29);
	String Fin_General_Priority                                                    = xlsInputData.getCellData("RL_Fin_General", ClientData, 30);
	String Fin_General_Subject                                                     = xlsInputData.getCellData("RL_Fin_General", ClientData, 31);
	String Fin_General_CreatedDate                                                 = xlsInputData.getCellData("RL_Fin_General", ClientData, 32);
	String Fin_General_DueDate                                                     = xlsInputData.getCellData("RL_Fin_General", ClientData, 33);
	String Fin_General_CreatedBy                                                   = xlsInputData.getCellData("RL_Fin_General", ClientData, 34);
	String Fin_General_Notes                                                       = xlsInputData.getCellData("RL_Fin_General", ClientData, 35);
	String Fin_General_AV_AppliesTo                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 36);
	String Fin_General_AV_Currency                                                 = xlsInputData.getCellData("RL_Fin_General", ClientData, 37);
	String Fin_General_AV_AssetAmount                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 38);
	String Fin_General_AV_AmortAmount                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 39);
	String Fin_General_AV_NBV                                                      = xlsInputData.getCellData("RL_Fin_General", ClientData, 40);
	String Fin_General_AV_AsOf                                                     = xlsInputData.getCellData("RL_Fin_General", ClientData, 41);
	String Fin_General_Liabilities_PaymentDescription                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 42);
	String Fin_General_Liabilities_DueDate                                         = xlsInputData.getCellData("RL_Fin_General", ClientData, 43);
	String Fin_General_Liabilities_Currency                                        = xlsInputData.getCellData("RL_Fin_General", ClientData, 44);
	String Fin_General_Liabilities_Amount                                          = xlsInputData.getCellData("RL_Fin_General", ClientData, 45);
	String Fin_General_Liabilities_Paid                                            = xlsInputData.getCellData("RL_Fin_General", ClientData, 46);
	String Fin_General_Liabilities_PaidDate                                        = xlsInputData.getCellData("RL_Fin_General", ClientData, 47);	
	String Fin_General_Liabilities_CheckNumber                                     = xlsInputData.getCellData("RL_Fin_General", ClientData, 48);

	
	//Notes Pop Up Field label Name
	String Fin_General_Notes_Priority                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 52);
	String Fin_General_Notes_DueDate                                               = xlsInputData.getCellData("RL_Fin_General", ClientData, 53);
	String Fin_General_Notes_Subject                                               = xlsInputData.getCellData("RL_Fin_General", ClientData, 54);
	String Fin_General_Notes_Notes                                                 = xlsInputData.getCellData("RL_Fin_General", ClientData, 55);
	String Fin_General_Notes_OK                                                    = xlsInputData.getCellData("RL_Fin_General", ClientData, 56);
	String Fin_General_Notes_Cancel                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 57);
	
	String Fin_General_Notes_Priority_data                                         = xlsInputData.getCellData("RL_Fin_General", ClientData, 61);
	String Fin_General_Notes_DueDate_data                                          = xlsInputData.getCellData("RL_Fin_General", ClientData, 62);
	String Fin_General_Notes_Subject_data                                          = xlsInputData.getCellData("RL_Fin_General", ClientData, 63);
	String Fin_General_Notes_Notes_data                                            = xlsInputData.getCellData("RL_Fin_General", ClientData, 64);
	
	
	//Payment Tab Data
	String Fin_Payment_Payables                                                    = xlsInputData.getCellData("RL_Fin_General", ClientData, 102);
	String Fin_Payment_AssetValues                                                 = xlsInputData.getCellData("RL_Fin_General", ClientData, 103);
	String Fin_Payment_CollapseAll                                                 = xlsInputData.getCellData("RL_Fin_General", ClientData, 104);
	String Fin_Payment_Paymentsexpand                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 105);
	String Fin_Payment_Assetvalueexpand                                            = xlsInputData.getCellData("RL_Fin_General", ClientData, 106);
	
	//Exhibition Tab Data
	String Fin_Exhibition_showallrows                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 110);
	String Fin_Exhibition_Expandall                                                = xlsInputData.getCellData("RL_Fin_General", ClientData, 111);
	String Fin_Exhibition_Collapseall                                              = xlsInputData.getCellData("RL_Fin_General", ClientData, 112);
	
	//Payment Schedule Tab Data
	String Fin_PS_AppliesTo_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 3);
	String Fin_PS_Party_Key                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 4);
	String Fin_PS_Currency_Key                                                     = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 5);
	String Fin_PS_Total_Key                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 6);
	String Fin_PS_TotalPaid_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 7);
	String Fin_PS_TotalUnpaid_Key                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 8);
	String Fin_PS_Paymentnumber_Key                                                = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 9);
	String Fin_PS_DueDate_Key                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 10);
	String Fin_PS_PaymentType_Key                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 11);
	String Fin_PS_AmountDue_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 12);
	String Fin_PS_ProfitCenter_Key                                                 = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 13);
	String Fin_PS_DatePaid_Key                                                     = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 14);
	String Fin_PS_PaidAmount_Key                                                   = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 15);
	String Fin_PS_CheckNumber_Key                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 16);
	String Fin_PS_InvoiceNumber_Key                                                = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 17);
	String Fin_PS_Webpac_Key                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 18);
	String Fin_PS_InvoiceDate_Key                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 19);
	String Fin_PS_Submitted_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 20);
	String Fin_PS_Unlock_Key                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 21);
	String Fin_PS_Notes_Key                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 22);
	
	String Fin_PS_AppliesTo                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 3);
	String Fin_PS_Party                                                            = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 4);
	String Fin_PS_Currency                                                         = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 5);
	String Fin_PS_Total                                                            = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 6);
	String Fin_PS_TotalPaid                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 7);
	String Fin_PS_TotalUnpaid                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 8);
	String Fin_PS_Paymentnumber                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 9);
	String Fin_PS_DueDate                                                          = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 10);
	String Fin_PS_PaymentType                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 11);
	String Fin_PS_AmountDue                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 12);
	String Fin_PS_ProfitCenter                                                     = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 13);
	String Fin_PS_DatePaid                                                         = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 14);
	String Fin_PS_PaidAmount                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 15);
	String Fin_PS_CheckNumber                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 16);
	String Fin_PS_InvoiceNumber                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 17);
	String Fin_PS_Webpac                                                           = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 18);
	String Fin_PS_InvoiceDate                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 19);
	String Fin_PS_Submitted                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 20);
	String Fin_PS_Unlock                                                           = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 21);
	String Fin_PS_Notes                                                            = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 22);
	
	String Fin_PS_SelectLabelname                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 28);
	String Fin_PS_Multiselect                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 29);
	String Fin_PS_Assetnamelabel                                                   = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 30);
	String Fin_PS_Datelegend                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 31);
	String Fin_PS_Duedate                                                          = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 32);
	String Fin_PS_Filter                                                           = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 33);
	String Fin_PS_Clearfilter                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 34);
	String Fin_PS_ExpandAll                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 35);
	String Fin_PS_CollapseAll                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 36);
	String Fin_PS_UnlockPaidRows                                                   = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 37);
	String Fin_PS_Save                                                             = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 38);
	String Fin_PS_Exporticon                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 39);
	String Fin_PS_Remindericon                                                     = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 40);
	
	// Title Payment Schedule Tab Data
	String Fin_TPS_Title_Key                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 53);
	String Fin_TPS_TitleType_Key                                                   = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 54);
	String Fin_TPS_AvailabilityStartDate_Key                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 55);
	String Fin_TPS_AvailabilityEndDate_Key                                         = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 56);
	String Fin_TPS_Currency_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 57);
	String Fin_TPS_Amount_Key                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 58);
	String Fin_TPS_DueDate_Key                                                     = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 59);
	String Fin_TPS_AmountPaid_Key                                                  = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 60);
	String Fin_TPS_PaidDate_Key                                                    = xlsInputData.getCellData("RL_Fin_Payment_Schedule", "KeyValues", 61);
	
	String Fin_TPS_Title                                                           = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 53);
	String Fin_TPS_TitleType                                                       = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 54);
	String Fin_TPS_AvailabilityStartDate                                           = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 55);
	String Fin_TPS_AvailabilityEndDate                                             = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 56);
	String Fin_TPS_Currency                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 57);
	String Fin_TPS_Amount                                                          = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 58);
	String Fin_TPS_DueDate                                                         = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 59);
	String Fin_TPS_AmountPaid                                                      = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 60);
	String Fin_TPS_PaidDate                                                        = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 61);
	
	String Fin_TPS_ClearPaidAmounts                                                = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 63);
	String Fin_TPS_Save                                                            = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 64);
	String Fin_TPS_Cancel                                                          = xlsInputData.getCellData("RL_Fin_Payment_Schedule", ClientData, 65);
	
	//Title Valuation Tab Data
	String Fin_TV_TitlevalueLegend                                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 35);
	String Fin_TV_DealNamelabel                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 36);
	String Fin_TV_NBVINGL                                                          = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 37);
	String Fin_TV_NBVAsOf                                                          = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 38);
	String Fin_TV_GDV                                                              = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 39);
	String Fin_TV_AmortizationTriggeratDeallevel                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 40);
	String Fin_TV_EscalatorTemplates                                               = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 41);
	String Fin_TV_Apply                                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 42);
	String Fin_TV_Exporticon                                                       = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 43);
	String Fin_TV_Remindericon                                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 44);
	String Fin_TV_AutoAppovalIcon                                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 45);
	
	String Fin_TV_AppliesTo_Key                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 3);
	String Fin_TV_WindowName_Key                                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 4);
	String Fin_TV_WindowType_Key                                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 5);
	String Fin_TV_Currency_Key                                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 6);
	String Fin_TV_Contractual_Key                                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 7);
	String Fin_TV_Liability_Key                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 8);
	String Fin_TV_ExhibitionFrom_Key                                               = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 9);
	String Fin_TV_ExhibitionTo_Key                                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 10);
	String Fin_TV_FinancialFrom_Key                                                = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 11);
	String Fin_TV_FinancialTo_Key                                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 12);
	String Fin_TV_ProfitCenter_Key                                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 13);
	String Fin_TV_AmortizationTrigger_Key                                          = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 14);
	String Fin_TV_Escalator_Key                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 15);
	String Fin_TV_Notes_Key                                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 16);
	String Fin_TV_GLReleaseDate_Key                                                = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 17);
	String Fin_TV_AmortType_Key                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 18);
	
	String Fin_TV_AppliesTo                                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 3);
	String Fin_TV_WindowName                                                       = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 4);
	String Fin_TV_WindowType                                                       = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 5);
	String Fin_TV_Currency                                                         = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 6);
	String Fin_TV_Contractual                                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 7);
	String Fin_TV_Liability                                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 8);
	String Fin_TV_ExhibitionFrom                                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 9);
	String Fin_TV_ExhibitionTo                                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 10);
	String Fin_TV_FinancialFrom                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 11);
	String Fin_TV_FinancialTo                                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 12);
	String Fin_TV_ProfitCenter                                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 13);
	String Fin_TV_AmortizationTrigger                                              = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 14);
	String Fin_TV_Escalator                                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 15);
	String Fin_TV_Notes                                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 16);
	String Fin_TV_GLReleaseDate                                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 17);
	String Fin_TV_AmortType                                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 18);
	
	String Fin_TVAtTitleLevel_AppliesTo_Key                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 50);
	String Fin_TVAtTitleLevel_Currency_Key                                         = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 51);
	String Fin_TVAtTitleLevel_Contractual_Key                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 52);
	String Fin_TVAtTitleLevel_Liability_Key                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 53);
	String Fin_TVAtTitleLevel_ProfitCenter_Key                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 54);
	String Fin_TVAtTitleLevel_AmortizationTrigger_Key                              = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 55);
	String Fin_TVAtTitleLevel_Escalator_Key                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 56);
	String Fin_TVAtTitleLevel_AmortType_Key                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 57);
	String Fin_TVAtTitleLevel_Notes_Key                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 58);
	
	String Fin_TVAtChildTitleLevel_WindowName_Key                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 59);
	String Fin_TVAtChildTitleLevel_WindowType_Key                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 60);
	String Fin_TVAtChildTitleLevel_ExhibitionFrom_Key                              = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 61);
	String Fin_TVAtChildTitleLevel_ExhibitionTo_Key                                = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 62);
	String Fin_TVAtChildTitleLevel_FinancialFrom_Key                               = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 63);
	String Fin_TVAtChildTitleLevel_FinancialTo_Key                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 64);
	String Fin_TVAtChildTitleLevel_Currency_Key                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 65);
	String Fin_TVAtChildTitleLevel_Contractual_Key                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 66);
	String Fin_TVAtChildTitleLevel_CurrentNBV_Key                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 67);
	String Fin_TVAtChildTitleLevel_AmortizationTrigger_Key                         = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 68);
	String Fin_TVAtChildTitleLevel_Notes_Key                                       = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 69);
	String Fin_TVAtChildTitleLevel_GLReleaseDate_Key                               = xlsInputData.getCellData("RL_Fin_Title_Valuation", "KeyValues", 70);
	
	String Fin_TVAtTitleLevel_AppliesTo                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 50);
	String Fin_TVAtTitleLevel_Currency                                             = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 51);
	String Fin_TVAtTitleLevel_Contractual                                          = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 52);
	String Fin_TVAtTitleLevel_Liability                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 53);
	String Fin_TVAtTitleLevel_ProfitCenter                                         = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 54);
	String Fin_TVAtTitleLevel_AmortizationTrigger                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 55);
	String Fin_TVAtTitleLevel_Escalator                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 56);
	String Fin_TVAtTitleLevel_AmortType                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 57);
	String Fin_TVAtTitleLevel_Notes                                                = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 58);
	
	String Fin_TVAtChildTitleLevel_WindowName                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 59);
	String Fin_TVAtChildTitleLevel_WindowType                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 60);
	String Fin_TVAtChildTitleLevel_ExhibitionFrom                                  = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 61);
	String Fin_TVAtChildTitleLevel_ExhibitionTo                                    = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 62);
	String Fin_TVAtChildTitleLevel_FinancialFrom                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 63);
	String Fin_TVAtChildTitleLevel_FinancialTo                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 64);
	String Fin_TVAtChildTitleLevel_Currency                                        = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 65);
	String Fin_TVAtChildTitleLevel_Contractual                                     = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 66);
	String Fin_TVAtChildTitleLevel_CurrentNBV                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 67);
	String Fin_TVAtChildTitleLevel_AmortizationTrigger                             = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 68);
	String Fin_TVAtChildTitleLevel_Notes                                           = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 69);
	String Fin_TVAtChildTitleLevel_GLReleaseDate                                   = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 70);
	
	String Fin_TVAtTitleLevel_HideExcludeRows                                      = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 84);
	String Fin_TVAtTitleLevel_WriteDown                                            = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 85);
	String Fin_TVAtTitleLevel_Save                                                 = xlsInputData.getCellData("RL_Fin_Title_Valuation", ClientData, 86);
	
	//Amortization Tab Data
	String Fin_Amort_CollapseAll                                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 3);
	String Fin_Amort_ExpandAmort                                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 4);
	String Fin_Amort_ExpandAmortSchedule                                           = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 5);
	String Fin_Amort_ExportIcon                                                    = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 6);
	String Fin_Amort_ReminderIcon                                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 7);
	String Fin_Amort_DealNameLabel                                                 = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 8);
	String Fin_Amort_TotalDealValue                                                = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 9);
	String Fin_Amort_TotalAmortReleasetoGL                                         = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 10);
	String Fin_Amort_AsOfDate                                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 11);
	String Fin_Amort_Legend                                                        = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 12);
	String Fin_Amort_StraightLineAmortIcon                                         = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 13);
	String Fin_Amort_AutoAppovalIcon                                               = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 14);

	String Fin_Amort_Appliesto_Key                                                 = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 31);
	String Fin_Amort_Currency_Key                                                  = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 32);
	String Fin_Amort_Contractual_Key                                               = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 33);
	String Fin_Amort_NBVInGL_Key                                                   = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 34);
	String Fin_Amort_ProfitCenter_Key                                              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 35);
	String Fin_Amort_Year_Key                                                      = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 36);
	String Fin_Amort_Amount_Key                                                    = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 37);
	String Fin_Amort_ReleasedtoGL_Key                                              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 38);
	
	String Fin_Amort_Appliesto                                                     = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 31);
	String Fin_Amort_Currency                                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 32);
	String Fin_Amort_Contractual                                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 33);
	String Fin_Amort_NBVInGL                                                       = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 34);
	String Fin_Amort_ProfitCenter                                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 35);
	String Fin_Amort_Year                                                          = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 36);
	String Fin_Amort_Amount                                                        = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 37);
	String Fin_Amort_ReleasedtoGL                                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 38);
	
	String Fin_AmortatTitleLevel_Appliesto_Key                                     = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 51);
	String Fin_AmortatTitleLevel_FinancialLifeFrom_Key                             = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 52);
	String Fin_AmortatTitleLevel_FinancialLifeTo_Key                               = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 53);
	String Fin_AmortatTitleLevel_Amortization_Key                                  = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 54);
	String Fin_AmortatTitleLevel_Currency_Key                                      = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 55);
	String Fin_AmortatTitleLevel_NewTitleValue_Key                                 = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 56);
	String Fin_AmortatTitleLevel_AmortReleasedtoGL_Key                             = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 57);
	String Fin_AmortatTitleLevel_NBVinGL_Key                                       = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 58);
	String Fin_AmortatTitleLevel_AmortAsOfDate_Key                                 = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 59);
	String Fin_AmortatTitleLevel_Window_Key                                        = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 60);
	String Fin_AmortatTitleLevel_WindowType_Key                                    = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 61);
	String Fin_AmortatTitleLevel_Period_Key                                        = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 62);
	String Fin_AmortatTitleLevel_AmortizationTemplate_Key                          = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 63);
	String Fin_AmortatTitleLevel_AmortizationValue_Key                             = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 64);
	String Fin_AmortatTitleLevel_NewNBV_Key                                        = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 65);
	String Fin_AmortatTitleLevel_AdjustmentMethod_Key                              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 66);
	String Fin_AmortatTitleLevel_Savebutton                                        = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 67);
	
	String Fin_AmortScheduleTitleLevel_Window_Key                                  = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 72);
	String Fin_AmortScheduleTitleLevel_WindowType_Key                              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 73);
	String Fin_AmortScheduleTitleLevel_FinancialLife_Key                           = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 74);
	String Fin_AmortScheduleTitleLevel_TitleValue_Key                              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 75);
	String Fin_AmortScheduleTitleLevel_AdjustedAmortizationAmount_Key              = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 76);
	String Fin_AmortScheduleTitleLevel_AmortAsOfDate_Key                           = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 77);
	String Fin_AmortScheduleTitleLevel_Date_Key                                    = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 78);
	String Fin_AmortScheduleTitleLevel_ScheduledMonth_Key                          = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 79);
	String Fin_AmortScheduleTitleLevel_GLReleaseDate_Key                           = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 80);
	String Fin_AmortScheduleTitleLevel_Currency_Key                                = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 81);
	String Fin_AmortScheduleTitleLevel_Amount_Key                                  = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 82);
	String Fin_AmortScheduleTitleLevel_ProfitCenter_Key                            = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 83);
	String Fin_AmortScheduleTitleLevel_Submitted_Key                               = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 84);
	String Fin_AmortScheduleTitleLevel_WriteDown_Key                               = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 85);
	String Fin_AmortScheduleTitleLevel_Manual_Key                                  = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 86);
	String Fin_AmortScheduleTitleLevel_Notes_Key                                   = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 87);
	String Fin_AmortScheduleTitleLevel_ApprovalNumber_Key                          = xlsInputData.getCellData("RL_Fin_Amortization", "KeyValues", 88);
	
	String Fin_AmortatTitleLevel_Appliesto                                         = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 51);
	String Fin_AmortatTitleLevel_FinancialLifeFrom                                 = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 52);
	String Fin_AmortatTitleLevel_FinancialLifeTo                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 53);
	String Fin_AmortatTitleLevel_Amortization                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 54);
	String Fin_AmortatTitleLevel_Currency                                          = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 55);
	String Fin_AmortatTitleLevel_NewTitleValue                                     = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 56);
	String Fin_AmortatTitleLevel_AmortReleasedtoGL                                 = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 57);
	String Fin_AmortatTitleLevel_NBVinGL                                           = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 58);
	String Fin_AmortatTitleLevel_AmortAsOfDate                                     = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 59);
	String Fin_AmortatTitleLevel_Window                                            = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 60);
	String Fin_AmortatTitleLevel_WindowType                                        = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 61);
	String Fin_AmortatTitleLevel_Period                                            = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 62);
	String Fin_AmortatTitleLevel_AmortizationTemplate                              = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 63);
	String Fin_AmortatTitleLevel_AmortizationValue                                 = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 64);
	String Fin_AmortatTitleLevel_NewNBV                                            = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 65);
	String Fin_AmortatTitleLevel_AdjustmentMethod                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 66);
	
	String Fin_AmortScheduleTitleLevel_Window                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 72);
	String Fin_AmortScheduleTitleLevel_WindowType                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 73);
	String Fin_AmortScheduleTitleLevel_FinancialLife                               = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 74);
	String Fin_AmortScheduleTitleLevel_TitleValue                                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 75);
	String Fin_AmortScheduleTitleLevel_AdjustedAmortizationAmount                  = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 76);
	String Fin_AmortScheduleTitleLevel_AmortAsOfDate                               = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 77);
	String Fin_AmortScheduleTitleLevel_Date                                        = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 78);
	String Fin_AmortScheduleTitleLevel_ScheduledMonth                              = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 79);
	String Fin_AmortScheduleTitleLevel_GLReleaseDate                               = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 80);
	String Fin_AmortScheduleTitleLevel_Currency                                    = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 81);
	String Fin_AmortScheduleTitleLevel_Amount                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 82);
	String Fin_AmortScheduleTitleLevel_ProfitCenter                                = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 83);
	String Fin_AmortScheduleTitleLevel_Submitted                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 84);
	String Fin_AmortScheduleTitleLevel_WriteDown                                   = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 85);
	String Fin_AmortScheduleTitleLevel_Manual                                      = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 86);
	String Fin_AmortScheduleTitleLevel_Notes                                       = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 87);
	String Fin_AmortScheduleTitleLevel_ApprovalNumber                              = xlsInputData.getCellData("RL_Fin_Amortization", ClientData, 88);
	
	//Reverse Assets and Liabilities Data
	String Fin_Adjustments_Reverse_ProfitCenterandBudgetLine                       = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 3);
	String Fin_Adjustments_Reverse_DealName                                        = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 4);
	String Fin_Adjustments_Reverse_Searchbutton                                    = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 5);
	String Fin_Adjustments_Reverse_ExportIcon                                      = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 6);
	String Fin_Adjustments_Reverse_TotalAmount                                     = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 7);
	String Fin_Adjustments_Reverse_ReverseApprovallabel                            = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 8);
	String Fin_Adjustments_Reverse_SelectAllbutton                                 = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 9);
	String Fin_Adjustments_Reverse_DeselectAllbutton                               = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 10);
	String Fin_Adjustments_Reverse_Reversebutton                                   = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 11);
	
	String Fin_Adjustments_Reverse_Appliesto_Key                                   = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 21);
	String Fin_Adjustments_Reverse_WindowName_Key                                  = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 22);
	String Fin_Adjustments_Reverse_StartDate_Key                                   = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 23);
	String Fin_Adjustments_Reverse_EndDate_Key                                     = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 24);
	String Fin_Adjustments_Reverse_Amount_Key                                      = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 25);
	String Fin_Adjustments_Reverse_Transaction_Key                                 = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 26);
	String Fin_Adjustments_Reverse_GLAccount_Key                                   = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 27);
	String Fin_Adjustments_Reverse_BalancingTransaction_Key                        = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 28);
	String Fin_Adjustments_Reverse_BalancingGLAccount_Key                          = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 29);
	String Fin_Adjustments_Reverse_ApprovalDate_Key                                = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 30);
	String Fin_Adjustments_Reverse_FinancialLife_Key                               = xlsInputData.getCellData("RL_Fin_Reverse_Assets", "KeyValues", 31);
	
	String Fin_Adjustments_Reverse_Appliesto                                       = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 21);
	String Fin_Adjustments_Reverse_WindowName                                      = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 22);
	String Fin_Adjustments_Reverse_StartDate                                       = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 23);
	String Fin_Adjustments_Reverse_EndDate                                         = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 24);
	String Fin_Adjustments_Reverse_Amount                                          = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 25);
	String Fin_Adjustments_Reverse_Transaction                                     = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 26);
	String Fin_Adjustments_Reverse_GLAccount                                       = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 27);
	String Fin_Adjustments_Reverse_BalancingTransaction                            = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 28);
	String Fin_Adjustments_Reverse_BalancingGLAccount                              = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 29);
	String Fin_Adjustments_Reverse_ApprovalDate                                    = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 30);
	String Fin_Adjustments_Reverse_FinancialLife                                   = xlsInputData.getCellData("RL_Fin_Reverse_Assets", ClientData, 31);
	
}


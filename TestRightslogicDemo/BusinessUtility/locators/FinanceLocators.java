package locators;


public interface FinanceLocators {
	//Finance Home Page locators
	String loc_Fin_homepage                                              = "//*[@id='leftRight']/table/tbody/tr/td[1]/b";
	
	String Loc_Fin_SubmitMenu                                            ="//a/span[contains(text(),'Submit')]";
	String Loc_Fin_Adjustments                                           ="//a/span[contains(text(),'Adjustments')]";
	String Loc_Fin_ReverseAssetsandLiabilities                           ="//a/span[contains(text(),'Reverse Assets and Liabilities')]";
	
	
	//Locators for Fields and Buttons specific to Change Deal gadget
	String loc_Fin_ChangedealGadget_DealRow                 			 = "//*[@id='uwgDealsChanged']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Loc_Fin_ChangedealGadget_Generaltab              			 = "//span/span[contains(text(),'General')]";
	String loc_Fin_ChangedealGadget_MediaRightstab          			 = "//span/span[contains(text(),'Media Rights')]";
	String loc_Fin_ChangedealGadget_Paymenttab              			 = "//span/span[contains(text(),'Payment')]";
	String loc_Fin_ChangedealGadget_Exhibitionstab          			 = "//span/span[contains(text(),'Exhibitions')]";
	String loc_Fin_ChangedealGadget_Acceptbutton            			 = "//*[@id='btnRIAccept']";
	String loc_Fin_ChangedealGadget_Rejectbutton            			 = "//*[@id='btnRIReject']";
	String loc_Fin_ChangedealGadget_Cancelbutton            			 = "//*[@id='btnRICancel']";
	String loc_Fin_ChangedealGadget_DealSelect              			 = "//a[contains(text(),'@var')]";
	
	String loc_Fin_ChangedealGadget_AppliestoField                       = "//*[contains(@id,'uwtViewDealChanges')]/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr[1]";
	String loc_Fin_ChangedealGadget_GeneralParent_HeaderRow              = "//th[@key='@var']";	
	String loc_Fin_ChangedealGadget_Tab_DataRow	                         = "//*[contains(@id,'uwtViewDealChanges') and contains(@id,'@var')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	
	String loc_Fin_ChangedealGadget_AppliestoField_HeaderRow             = "//*[contains(@id,'uwtViewDealChanges') and contains(@id,'@var1')]/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th[@key='@var']";	
	
	//Reminder Popup
	String loc_Fin_ChangedealGadget_Reminder_User                        = "//td[text()='auto']/..//img";
	String loc_Fin_ChangedealGadget_Reminder_Suject                      = "//*[@id='txtSubject']";	
	String loc_Fin_ChangedealGadget_Reminder_Notes                       = "//*[@id='txtNotes']";
	
	//General Tab Locators
	String loc_Fin_Generaltab                                            ="//span/span/span[contains(text(),'General')]";

	
	
	//Search Deals Locators
	String loc_Fin_Search_Deals                                          ="//*[@id='PlainTopMenu1_MainMenu_0']/div/ul/li[1]/a/span";

	//Fin_AggrementSearch
	String loc_Fin_AggrementSearchDealName                               = "lblDealName";
	String loc_Fin_AggrementSearchContractDescription                    = "lblContractId";
	String loc_Fin_AggrementSearchDealType                               = "lblDealType";
	String loc_Fin_AggrementSearchAgreementType                          = "lblAgreementType";	
	String loc_Fin_AggrementSearchContractingEntity                      = "lblDCIContractingEntity";	
	String loc_Fin_AggrementSearchVendorParty                            = "lblVendorParty";
	String loc_Fin_AggrementSearchDealStatus                             = "lblDealStatus";
	String loc_Fin_AggrementSearchProfitCenter                           = "lblProfitCenter";
	String loc_Fin_AggrementSearchContractStatus                         = "lblContractStatus";
	String loc_Fin_AggrementSearchCDES                                   = "lblContractEntryStatus";
	String loc_Fin_AggrementSearchLicenseTerm                            = "lblLicenseTerm";
	String loc_Fin_AggrementSearchExecutionDate                          = "lblExecutionDate";
	String loc_Fin_AggrementSearchTitleName                              = "lblAssetName";
	String loc_Fin_AggrementSearchTitleID                                = "lblAssetID";
	String loc_Fin_AggrementSearchFinancialStatus                        = "lblFinanceStatus";
	String loc_Fin_AggrementSearchExactMatch                             = "//*[@id='grpButtons']/div/table/tbody/tr[7]/td/span/label";
	String loc_Fin_AggrementSearchExactMatchCheckBox                     = "ExactCheckBox";
	
	String Loc_Fin_AggrementSearchDealNameInput                          = "txtDealName";
	String Loc_Fin_AggrementSearchContractDescriptionInput               = "txtContractId";
	String Loc_Fin_AggrementSearchDealTypePicklist                       = "imgDealType";
	String Loc_Fin_AggrementSearchAgreementTypePicklist                  = "img1";
	String Loc_Fin_AggrementSearchContractingEntityLookupicon            = "img2";
	String Loc_Fin_AggrementSearchVendorPartyLookupicon                  = "imgVendor";
	String Loc_Fin_AggrementSearchDealStatusPicklist                     = "imgDealStatus";
	String Loc_Fin_AggrementSearchProfitCenterDropdown                   = "ddlProfitCenter";
	String Loc_Fin_AggrementSearchContractStatusDropdown                 = "ddlContractStatus";
	String Loc_Fin_AggrementSearchCDESDropdown                           = "ddlContractEntryStatus";
	String Loc_Fin_AggrementSearchLicenseTermfrominput                   = "//*[@id='dtLicenseTermFrom']/tbody/tr/td[1]/input";
	String Loc_Fin_AggrementSearchLicenseTermtoinput                     = "//*[@id='dtLicenseTermTo']/tbody/tr/td[1]/input";
	String Loc_Fin_AggrementSearchExecutionDateFromInput                 = "//*[@id='dtExecutionDateFrom']/tbody/tr/td[1]/input";
	String Loc_Fin_AggrementSearchExecutionDateToInput                   = "//*[@id='dtExecutionDateTo']/tbody/tr/td[1]/input";
	String Loc_Fin_AggrementSearchTitleNameinput                         = "txtAssetName";
	String Loc_Fin_AggrementSearchTitleIDinput                           = "txtAssetID";
	String Loc_Fin_AggrementSearchFinancialStatusDropdown                = "ddlFinanceStatus";
	
	//Pick list value
	String Loc_Fin_AggrementSearchDealTypepicklistvalue_Acq              = "//*[@id='PageContent_pkList_uwTree']/ul/li[1]/img[2]";
	String Loc_Fin_AggrementSearchAgreementTypepicklistvalue_Std         = "//*[@id='PageContent_pkList_uwTree']/ul/li[3]/img[2]";
	String Loc_Fin_AggrementSearchDealStatuspicklistvalue_Approved       = "//*[@id='uwTree']/ul/li[1]/img[2]";
	
	
	

	//Fin_AgreementSearch Buttons
	String loc_Fin_AggrementSearch_Searchbutton                          = "btnFindNow";
	String loc_Fin_AggrementSearch_ClearSearchbutton                     = "btnClearSearch";
	String loc_Fin_AggrementSearch_SaveSearchbutton                      = "btnSaveSearch";
	String loc_Fin_AggrementSearch_RestoreSearchbutton                   = "btnRestoreSearch";
	String loc_Fin_ViewDeal                                              = "btnViewMaster";
	
	//Search results
	String loc_Fin_AggrementSearch_DataRow                               ="//*[contains(@id,'uwgSearchResults')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[text()='@var']";
	String loc_Fin_AggrementSearchresult_Expand                          ="//*[contains(@id,'uwgSearchResults')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[1]/img";

	
   //General Tab Locators
	String Loc_Fin_General_DealDetails_Legend                            ="//*[@id='grpDealDetails']/legend";
	String Loc_Fin_General_Party_Legend                                  ="//*[@id='grpParties']/legend";
	String Loc_Fin_General_Notes_Legend                                  ="//*[@id='grpNotes']/legend";
	String Loc_Fin_General_AssetSummary_Legend                           ="//*[@id='grpAssets']/legend";
	String Loc_Fin_General_Liabilities_Legend                            ="//*[@id='grpPayments']/legend";
	String Loc_Fin_General_Reminder                                      ="//*[@id='pnlReminder']/img";
	
	//Deal Details Locators
	String Loc_Fin_General_DealID                                        ="lblDealID";
	String Loc_Fin_General_DealDescription                               ="lblDealDescription";
	String Loc_Fin_General_DealName                                      ="lblDealName";
	String Loc_Fin_General_DealType                                      ="lblDealType";
	String Loc_Fin_General_ContractStatus                                ="lblContractStatus";
	String Loc_Fin_General_CDES                                          ="lblCDEStatus";
	String Loc_Fin_General_ProjectStatus                                 ="lblProjectStatus";
	String Loc_Fin_General_DateExecuted                                  ="lblDateExecuted";
	String Loc_Fin_General_DateEffective                                 ="lblDateEffective";
	String Loc_Fin_General_ContractCurrency                              ="lblContractCurrency";
	String Loc_Fin_General_BudgetLine                                    ="lblBudgetLine";
	String Loc_Fin_General_Retired                                       ="lblRetired";
	
	//Notes Popup Locators
	//Field Labels
	String Loc_Fin_General_Notes_Priority                                ="lblPriority";
	String Loc_Fin_General_Notes_DueDate                                 ="lblDueDate";
	String Loc_Fin_General_Notes_Subject                                 ="lblSubject";
	String Loc_Fin_General_Notes_Notes                                   ="lblNotes";
	//Buttons
	String Loc_Fin_General_Notes_OK                                      ="btnOK";
	String Loc_Fin_General_Notes_Cancel                                  ="btnCancel";
	
	//Notes Field data locator
	String Loc_Fin_General_Notes_DueDateinput                            ="//*[@id='wdcDueDate']/tbody/tr/td[1]/input";
	String Loc_Fin_General_RINotesLocator                                ="//*[@id='uwgNotes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[6]";
	String Loc_Fin_General_FinNotesLocator                               ="//*[@id='uwgNotes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]";
	
	//Reminder Popup Locator
	String Loc_Fin_Reminder_LabelName                                    ="lblAssetTitle";
	
	//Payment Tab Locators
	String Loc_Fin_Payment_Payables                                      ="//*[@id='grpReceivables_uwtPayment']/span/span/span[2]/span/span/span";
	String Loc_Fin_Payment_AssetValues                                   ="//*[@id='grpPayables']/legend";
	String Loc_Fin_Payment_CollapseAll                                   ="lblCollapseAll";
	String Loc_Fin_Payment_Paymentsexpand                                ="lblExpandGrpReceivables";
	String Loc_Fin_Payment_Assetvalueexpand                              ="lblExpandGrpPayables";
	
	//Exhibition Tab Locators
	String Loc_Fin_Exhibition_showallrows                                ="//*[@id='RL_Deal_Tab_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/span/label";
	String Loc_Fin_Exhibition_Expandall                                  ="btnExpandall";
	String Loc_Fin_Exhibition_Collapseall                                ="btnCollapseall";
	
	//Payment Schedule Tab Locators
	String Loc_Fin_PS_SelectLabelname                                    ="lblAssetName";
	String Loc_Fin_PS_Multiselect                                        ="lblFilterDet2";
	String Loc_Fin_PS_Multiselectpicklist                                ="img1";
	String Loc_Fin_PS_Assetnamelabel                                     ="Label2";
	String Loc_Fin_PS_Datelegend                                         ="//*[@id='grpDateFilters']/legend";
	String Loc_Fin_PS_Duedate                                            ="lblDueDateFrom";
	String Loc_Fin_PS_Filter                                             ="btnFilter";
	String Loc_Fin_PS_Clearfilter                                        ="btnClear";
	String Loc_Fin_PS_ExpandAll                                          ="expendAll_onclick";
	String Loc_Fin_PS_CollapseAll                                        ="collapseAll_Click";
	String Loc_Fin_PS_UnlockPaidRows                                     ="btnUnlock";
	String Loc_Fin_PS_Save                                               ="btnSave";
	String Loc_Fin_PS_Exporticon                                         ="imgBtnExport";
	String Loc_Fin_PS_Remindericon                                       ="//*[@id='grpButtons']/div/table/tbody/tr[2]/td[2]/img";
	
	//Title Payment Schedule locators
	String Loc_Fin_TPS_ClearPaidAmount                                   ="btnClearPaidAmount";
	String Loc_Fin_TPS_Savebutton                                        ="btnSave";
	String Loc_Fin_TPS_Cancelbutton                                      ="btnCancel";
	String Loc_Fin_TPS_Exporticon                                        ="btnExport";
	
	//Payment Schedule input data locators
	String Loc_Fin_PS_Selectdropdown                                     ="cmbAssetName";
	String Loc_Fin_PS_Duedatefrominput                                   ="//*[@id='dueDateFrom']/tbody/tr/td[1]/input";
	String Loc_Fin_PS_Duedatetoinput                                     ="//*[@id='dueDateTo']/tbody/tr/td[1]/input";
	
	//Payment Schedule tab data row locators
	String Loc_Fin_PS_DataRow                                            ="//*[contains(@id,'uwgPaymentScheduled_ctl00')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	
	//Title Valuation Locators
	String Loc_Fin_TV_TitlevalueLegend                                   ="//*[@id='grpAssetEditGrid']/legend";
	String Loc_Fin_TV_DealNamelabel                                      ="grpDealSummary_lblContractID";
	String Loc_Fin_TV_NBVINGL                                            ="grpDealSummary_lblNDV";
	String Loc_Fin_TV_NBVAsOf                                            ="grpDealSummary_lblLastPayDate";
	String Loc_Fin_TV_GDV                                                ="grpDealSummary_lblTotalDAV";
	String Loc_Fin_TV_AmortizationTrigger                                ="grpDealSummary_lblAmort";
	String Loc_Fin_TV_Escalator                                          ="grpDealSummary_lblEscalatorTemplates";
	String Loc_Fin_TV_Apply                                              ="grpDealSummary_btnApplyESTemplate";
	 
	String Loc_Fin_TV_Exporticon                                         ="imgBtnExport";
	String Loc_Fin_TV_Remindericon                                       ="//*[@id='RL_FIN_ASSETVALUATION']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/img";
	String Loc_Fin_TV_Applybutton                                        ="grpDealSummary_btnApplyESTemplate";	
	String Loc_Fin_TV_DealName                                           ="//*[@id='uwtAssets']/ul/li/a";
	String Loc_Fin_TV_Title                                              ="//*[@id='uwtAssets']/ul/li/ul/li[1]/a";
    String Loc_Fin_TV_AutoAppovalIcon                                    ="//*[@id='uwToolBar']/div/ul/li[4]/a/img";
	
	//Title Valuation at Asset Level Locators
	String Loc_Fin_TVAtTitleLevel_HideExcludeRows                        ="//*[@id='grpAssetEditGrid']/div/table/tbody/tr[1]/td[1]/span/label";
	String Loc_Fin_TVAtTitleLevel_WriteDown                              ="grpAssetEditGrid_btnWriteDown";
	String Loc_Fin_TVAtTitleLevel_Save                                   ="btnSave";
	
	// Title Valuation Parent and Child Header locators
	String Loc_Fin_TVAtTitleLevel_ParentHeader                           ="//*[@id='grpAssetEditGrid_uwgAssetValueEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr";
	String Loc_Fin_TVAtTitleLevel_ChildHeader                            ="//*[contains(@id,'grpAssetEditGrid_uwgAssetValueEdit')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	
	
	//Amortization Tab Locators
	String Loc_Fin_Amort_CollapseAll                                     ="lblCollapseAll";
	String Loc_Fin_Amort_ExpandAmort                                     ="lblExpandGrpReceivables";
	String Loc_Fin_Amort_ExpandAmortSchedule                             ="lblExpandGrpPayables";
	String Loc_Fin_Amort_ExportIcon                                      ="imgBtnExport";
	String Loc_Fin_Amort_ReminderIcon                                    ="//*[@id='pnlReminder']/img";
	String Loc_Fin_Amort_DealNameLabel                                   ="grpAmortDealHeader_DealHeader_lblContractID";
	String Loc_Fin_Amort_TotalDealValue                                  ="grpAmortDealHeader_DealHeader_lblTotalDealValue";
	String Loc_Fin_Amort_TotalAmortReleasetoGL                           ="grpAmortDealHeader_DealHeader_lblTotalDealPostAmort";
	String Loc_Fin_Amort_AsOfDate                                        ="grpAmortDealHeader_DealHeader_lblAsOfDate";
	String Loc_Fin_Amort_Legend                                          ="//*[@id='wgbAmortization']/legend";
	String Loc_Fin_Amort_StraightLineAmortIcon                           ="//*[@id='uwToolBar']/div/ul/li[2]/a/img";
	String Loc_Fin_Amort_AutoAppovalIcon                                 ="//*[@id='uwToolBar']/div/ul/li[4]/a/img";	
	String Loc_Fin_AmortatTitleLevel_Legend                              = "//*[@id='grpAmortizationGrid']/legend";	
	String Loc_Fin_AmortTitle                                            ="//*[@id='uwtAssets']/ul/li/ul/li[1]/a";
	String Loc_Fin_AmortatTitleLevel_Savebutton                          ="btnSubmit";
	
	
	//Amortization header and Data row locators
	String Loc_Fin_Amort_ChildHeaderRow                                  ="//*[contains(@id,'AmortizationView_wgbAmortization_uwgAmortSummary_ctl00')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	
	
	//Amortization at Title Level Locators
	String Loc_Fin_AmortatTitleLevel_ParentHeaderRow                     ="//*[@id='AmortizationEdit_grpAmortizationGrid_uwgAmortization_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr";
	String Loc_Fin_AmortatTitleLevel_ChildHeaderRow                      ="//*[@id='AmortizationEdit_grpAmortizationGrid_uwgAmortization_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";		
	
	//Amortization Schedule Locators
	String Loc_Fin_AmortScheduleatTitleLevel_ParentHeaderRow             ="//*[@id='AmortizationEdit_grpAmortSchedule_uwgAmortSchedule_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr";
	String Loc_Fin_AmortScheduleatTitleLevel_ChildHeaderRow              ="//*[@id='AmortizationEdit_grpAmortSchedule_uwgAmortSchedule_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	
	//Reverse Assets and Liabilities Locators
	String Loc_Fin_Adjustments_Reverse_ProfitCenterandBudgetLine         ="lblProfitCenter";
	String Loc_Fin_Adjustments_Reverse_DealName                          ="lblDealName";
	String Loc_Fin_Adjustments_Reverse_Searchbutton                      ="PageContent_grpButtons_btnSearch";
	String Loc_Fin_Adjustments_Reverse_ExportIcon                        ="imgBtnExport";
	String Loc_Fin_Adjustments_Reverse_TotalAmount                       ="lblAmount";
	String Loc_Fin_Adjustments_Reverse_ReverseApprovallabel              ="//*[@id='pnlSearch']/table/tbody/tr/td[3]/span/label";
	String Loc_Fin_Adjustments_Reverse_SelectAllbutton                   ="btnselect";
	String Loc_Fin_Adjustments_Reverse_DeselectAllbutton                 ="btnunselect";
	String Loc_Fin_Adjustments_Reverse_Reversebutton                     ="btnReverse_Conf";
	

	
	
	
	
	
	
	
	
}

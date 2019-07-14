package locators;

public interface RightsInLocators {

	// ****************Locators specific to Rights In Module***********************//
	String RightsInHeader = "//*[@id='leftRight']//b[contains(text(),'Rights In')]";
	
	//RI Common Data e.g: create the deal
	String loc_DealID_LabelName			 		= "//*[@id='lblDealID']";
	String loc_DealDescription_LabelName 		= "//*[@id='lblContractID']";
	String loc_DealName_LabelName 				= "//*[@id='lblDealName']";
	String loc_DealType_LabelName 				= "//*[@id='lblDealType']";
	String loc_DealSubType_LabelName 			= "//*[@id='lblDealSubType']";
	String loc_ContractStatus_LabelName  		= "//*[@id='lblContractStatus']";
	String loc_ContractDataEntryStatus_LabelName = "//*[@id='lblCDEStatus']";	
	String loc_DateExecuted_LabelName 			= "//*[@id='lblDateExecuted']";
	String loc_DateEffective_LabelName 			= "//*[@id='lblDateEffective']";
	String loc_Currency_LabelName 				= "//*[@id='lblCurrency']";
	String loc_ProfitCenter_LabelName 			= "//*[@id='lblProfitCenter']";
	String loc_BudgetLine_LabelName 			= "//*[@id='lblBudgetLine']";
	String loc_SkipWorkflowCheckBox_LabelNAme	= "//*[@id='lblSkipWf']";
	
	// Buttons available on PArty Search Window
	String loc_PartySearch_ViewBtn			 	= "//*[@id='btnView']";
	String loc_PartySearch_DeactivateBtn		= "//*[@id='DeactivateBtn']";
	String loc_PartySearch_ExportBtn			= "//*[@id='btnExport']";
	
	String loc_DealValidationMsg 				= "//*[@id='divMsg']/../span[2]";
	String loc_DealErrorValidationMsg 			= "//*[@id='divMsg']";
	
	
	
	
	
	String loc_DealIDValue = "//*[@id='lblDealIDVal']";
	String loc_ContractStatus  = "//*[@id='lstContractStatus']";
	String loc_DealDescription_InputField = "//*[@id='txtContractID']";
	String loc_DealType_DropDownField = "//*[@id='lstDealType']";
	String loc_DealSubType_DropDownField = "lstDealSubType";
	String loc_ContractDataEntryStatus = "//*[@id='lstCDEStatus']";
	String loc_DateExecuted_InputField = "//*[@id='wdcDateExecuted']/tbody/tr/td[1]/input";
	String loc_DateEffective_InputField = "//*[@id='wdcDateEffective']/tbody/tr/td[1]/input";
	String loc_Currency_InputField = "//*[@id='lstCurrency']";
	String loc_ProfitCenter_InputField = "//*[@id='lstProfitCenter']";
	String loc_BudgetLine_InputField = "//*[@id='lstBudgetLine']";
	String loc_Party_AddButton = "//*[@id='btnPartyAdd']";
	String loc_ProjectStatus_InputField = "txtPTProjectStatus";
	String loc_ProjectID_InputField = "txtPTProjectID";
	String loc_DocType_LookUpIconField = "//*[@id='imgDocType']";
	String loc_SkipWorkflowCheckBox = "chkSkipWorkflow";
	
	String loc_PartyLegend 					= "//*[@id='Group2']/legend";
	String loc_PartyHeader 					= "//*[@id='uwgParties_columnheader_1']";
	String loc_PartyTypeHeader 				= "//*[@id='uwgParties_columnheader_2']";
	
	String loc_PartyType_InputField 		= "//*[@id='uwgParties_ctl00']/div/table/tbody/tr/td[1]/input";
	String loc_Outlets_PartiesAddParty      = "lstOutlets";
	String loc_AddParty_CloseWindow 		= "//*[@id='WebDialogWindow2']//*[contains(@data-ig,'Close')]";
	String loc_DeleteParty		 			= "//*[@id='btnPartyRemove']";
	String loc_PartyUndoButton				="uwgParties_undoBtnDiv";
	String loc_ValidationMsg				="//*[contains(@id,'lblMsg')]";
	
	// RI_ Menu Links 
	String loc_DealNavigator = "//a/span[contains(text(),'Deal Navigator')]";
	String loc_AssetNavigator = "//a/span[contains(text(),'Navigator')]";
	String loc_DealNavigatorWindow_DealName = "//*[@data-ig='x:uwtDN.3:mkr:dtnContent']";
	String loc_DealNavigatorWindow_AssetSeriesExpandIcon = "//div[@id='uwtDN']/ul/li/ul/li/img[contains(@title,'Expand')]";
	String loc_DealNavigatorWindow_1stSeason_ExpandIcon = "//div[@id='uwtDN']/ul/li/ul/li/ul/li[1]/img[3]";
	String loc_DealNavigatorWindow_2ndSeason_ExpandIcon = "//div[@id='uwtDN']/ul/li/ul/li/ul/li[2]/img[3]";
	String loc_DealNavigatorWindow_3rdSeason_ExpandIcon = "//div[@id='uwtDN']/ul/li/ul/li/ul/li[3]/img[3]";
	
	// Episode Name is like : Ep.202: Episode202
	// Series Name is like : Season 2.Original Version
	String loc_DealNavigatorWindow_SeriesName_OR_EpisodeName = "//*[@id='uwtDN']//a[text()='@var']";
	
	
	
	// RI_ Search 
	String loc_DealTitleField = "//*[@id='txtDealName']";

	// RI_General
	String Partiesheaderxpath = "//*[@id='uwgParties']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String Partiesxpath = "//*[@id='uwgParties']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Partiesxpath_Window = "//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Notesxpath = "//*[@id='uwgNotes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String loc_DealName = "//*[@id='txtDealName']";


	// RI_MediaRights 
	String loc_RI_MediaRights_ColumnXpath_EditMode 				= "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th"; // Done
	String loc_RI_MediaRights_DataRowXpath_EditMode 			= "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";//Done
	String loc_RI_MediaRights_ColumnXpath_ViewMode 				= "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";// used to get the idx and adr values
	String loc_RI_MediaRights_DataRowXpath_ViewMode 			= "//*[@id='uwgMediaRights_ctl00_@var_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String loc_RI_MediaRights_HorizontalScroll_EditMode 		="//*[@id='uwgMediaRights']/table/tbody/tr[2]/td[1]/div";
	

		
	////Buttons, DropDown etc. at Media Rights View Mode
	String loc_RI_MediaRights_AppliesToLabel 		= "appliesToFilter_lblAssetName";
	String loc_RI_MediaRights_AssetFilter 			= "//select[@id='cmbAssetName']";
	String loc_RI_MediaRights_ClearFiltersButton 	= "//*[@value='Clear Filters']";
	String loc_RI_MediaRights_ShowAllRowsLabel		= "//label[@for='chkShowAllRows']";
	String loc_RI_MediaRights_SendReminderIcon		= "//td/img[@alt='Send Reminder']";//td/img[@title='Send Reminder']";
	

		////Buttons, DropDown etc. at Media Rights Edit Mode
	String loc_RI_MediaRights_EditMode_CopyColumns_Button 			= "//*[@id='btnCopydown']";
	String loc_RI_Exh_EditMode_CopyColumns_Button 					= "//*[@id='btnCopyDown']";
	String loc_RI_MediaRights_EditMode_CopyRows_Buttons 			= "//*[@id='btnCopy']";
	String loc_RI_MediaRights_EditMode_AddButton					= "//*[@id='btnNew']";
	String loc_RI_MediaRights_EditMode_DeleteButton 				= "//*[contains(@id,'btnDel')]";
	String loc_RI_MediaRights_EditMode_SaveButton 					= "//*[@id='btnSave']";
	String loc_RI_closeButton										= "//*[@id='btnClose'] | //*[@id='btnCancel']";
	String loc_RI_MediaRights_EditMode_AlphabateFilterPickList 		= "//*[@id='imgFilter']";
	String loc_RI_MediaRights_EditMode_AlphabateFilterDropDown 		= "//*[@id='cmbFilter']";
	String loc_RI_MediaRights_LabelsCopyColumnWindow 				= "//label[contains(@for,'cblMediaRightCopy') and text()='@var']";
	String loc_RI_MediaRights_EditMode_AssetFilterPickList 			= "//*[@id='img1']";
	
	// Applies TO
	//String loc_RI_MediaRights_EditMode_DropDownImage		="//div[contains(@id,'uwgMediaRights_ddl') and contains(@style,'visibility: visible')]//div[contains(@id,'uwgMediaRights_') and contains(@id,'Editor') ]//td/img";
	String loc_RI_MediaRights_EditMode_DropDownImage		="//div[contains(@id,'uwg') and contains(@style,'visibility: visible')]//div[contains(@id,'uwg') and contains(@id,'Editor') ]//td/img | //div[contains(@id,'uwg') and contains(@style,'visibility: visible')]//td/img";
	String loc_RI_MediaRights_ViewMode_Assets				= "//*[@id='uwgMediaRights_ctl00']//tr/td[contains(text(),'@var')]"; 
	// Modified to select value under Note >> Use Template. Need to check for other Headers as well
	String loc_RI_EditMode_DropDownValues					= "//div[contains(@class,'DropDownList') and contains(@style,'visibility: visible')]//div[contains(@data-ig,':mkr:DropDownContents')]/ul//*[contains(text(),'@var')]";
	String loc_RI_EditMode_DropDownValues_HiddenAndUnique	= "//div[contains(@class,'DropDownList')]//div[contains(@data-ig,':mkr:DropDownContents')]/ul//*[contains(text(),'@var')]";

	String loc_RI_MediaRights_EditMode_InputField			= "//div[contains(@id,'uwgMediaRights_dpp') and contains(@style,'visibility: visible')]//div//input"; 
	String loc_RI_MediaRights_ViewMode_CurrentPage			= "//*[@id='uwgMediaRights_ctl00']/table/tbody/tr[4]/td/div/span[contains(@class,'BluePageCurrent') and text()='@var']"; 
	String loc_RI_MediaRights_ViewMode_PageLink				= "//*[@id='uwgMediaRights_ctl00']/table/tbody/tr[4]/td/div/span[contains(@class,'BluePageLink') and text()='@var']"; 

	//String loc_RI_MediaRights_EditMode_PARTY_DropDownValues				= "//div[contains(@data-ig,':mkr:DropDownContents')]/ul/li/a[text()='@var']";


	////Buttons available at Template window of Applies TO Rights TAB in Edit Window
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_SelectAll 		= "btnSelectAll";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_DeSelectAll 		= "btnDeselectAll";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Apply 			= "btnApply";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Cancel 			= "btnCancel";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search 			= "lblSearchTree";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Search_InputField = "txtSearchTree";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_CrossIconAtSearch = "imgRemoveSearch";
	String loc_RI_MediaRights_EditMode_Applies_TemplateWindow_Searched_Result 	= "//ul/li/a/span[contains(text(),'@var')]";
	String loc_RI_MediaRights_EditMode_Party_TemplateWindow_Apply 				= "btnOk";

	////Buttons available at Template window of Media Rights TAB in Edit Window
	String loc_RI_MediaRights_EditMode_TemplateWindow_ExpandAll 			= "//*[contains(@value,'Expand All')]";
	String loc_RI_MediaRights_EditMode_TemplateWindow_CollapseAll 			= "//*[contains(@value,'Collapse All')]";
	String loc_RI_MediaRights_EditMode_TemplateWindow_SelectAll 			= "//*[contains(@value,'Select All')]";
	String loc_RI_MediaRights_EditMode_TemplateWindow_DeSelectAll 			= "//*[contains(@value,'Deselect All')]";
	String loc_RI_MediaRights_EditMode_TemplateWindow_Apply 				= "//*[contains(@value,'Apply')]";
	String loc_RI_MediaRights_EditMode_TemplateWindow_Cancel 				= "//*[contains(@value,'Cancel')]";



	//// RI_MediaRights Applied to Template Window
	/**
	 * replacce @var with "on" for Checked else "off"
	 *  Unchecked : off
	 */
	String loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes 					= "//*[@id='uwtList']//ul/li//img[contains(@src,'checkbox_@var')]";
	String loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Asset 				= "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_')]";
	String loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset 		= "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_on')]";
	String loc_RI_EditMode_Applies_TemplateWindow_CheckBoxes_Unchecked_Asset 	= "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_off')]";
	String loc_RI_EditMode_Applies_TemplateWindow_Asset 						= "//*[@id='uwtList']//ul/li/a[text()='@var']";

	////RI_MediaRights  Party Template Window

	String loc_RI_EditMode_PARTY_TemplateWindow_CheckBox_Party 					= "//*[@id='uwgReferences']//td[contains(text(),'@var')]/..//img";
	String loc_RI_EditMode_TemplateWindow_CheckBoxes_Checked 			= "//*[@id='uwgReferences']//img[@title='Checked']";
	String loc_RI_EditMode_TemplateWindow_CheckBoxes_UnChecked 			= "//*[@id='uwgReferences']//img[@title='Unchecked']";

	//// RI_MediaRights Media Type Media_Template Window
	/**
	 * replacce @var with "on" for Checked else "off"
	 *  Unchecked : off
	 */
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes 						= "//*[contains(@id,'List')]//ul/li//img[contains(@src,'checkbox_@var')]";
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset 				= "//*[contains(@id,'List')]//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_')]";
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset 		= "//*[contains(@id,'List')]//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_on')]";
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_CheckBoxes_Unchecked_Asset 		= "//*[contains(@id,'List')]//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_off')]";
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_ExpandIcon 						= "//*[contains(@id,'List')]/ul/li/img[contains(@title,'Expand')]";
	String loc_RI_MediaRights_EditMode_Media_TemplateWindow_CollapseIcon 					= "//*[contains(@id,'List')]/ul/li/img[contains(@title,'Collapse')]";

	
	////RI_MediaRights  Note Template Window
	String loc_RI_MediaRights_NoteWind_Descrip_InputField						= "//*[@id='uwgBusTerms_txtNotesProvider']//textarea";
	String loc_RI_MediaRights_HeaderAtViewMode 									= 	"//*[contains(@class,'BlueHeaderContent')]";
	String loc_RI_MediaRights_CheckedDataViewMode				=	"//*[@id='PageContent_tList1_uwTree']//ul/li/a[text()='@var']/../img[contains(@src,'itemcheck.gif')]";
		
	
	
	////////////////////Exhibition TAB/////////////////////////////////////
	String loc_RI_Exh_AppliesTOPickList 		= "//*[@id='imgAppliesTo']";
	String loc_RI_Exh_ViewMode_ExpandButton		= "//*[@value='Expand All']";
	String loc_RI_Exh_ViewMode_CollapseButton 	= "//*[@value='Collapse All']";
	String loc_RI_Exh_AllocateButton 			= "//*[@id='btnAllocate']";
	String loc_RI_Exh_ViewMode_CollapseIcon 	= "//*[@title='Collapse Row']";
	String loc_RI_Exh_ViewMode_ExpandIcon 		= "//*[@title='Expand Row']";

	
	
	String loc_RI_ExhRights_ParentRow     		= "//th[contains(@id,'columnheader_') and @key='@var']";
	String loc_RI_ExhRights_ChildRow     		= "//*[contains(@id,'uwgExhibitions_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	                                                                            
	String loc_RI_ExhRights_Child_ColumnXpath_EditMode   	= "//*[contains(@id,'uwgExhibitions_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]//tr[@role='row']/th";
	String loc_RI_ExhibitionRights_HorizontalScroll 		= "//*[@id='uwgExhibitions_ctl00']/table/tbody/tr[3]/td[1]/div";

	//Exhibition Rights: Network Dialog Pop up >> Exhibition Rights Network Dialog Window
	String loc_RI_Exh_NetworkWindow_AppliesTO 					= 	"//*[contains(text(),'AppliesTo')]";
	String loc_RI_Exh_NetworkWindow_MediaType_Label	 			=	"Group1_lblMediaType";
	String loc_RI_Exh_NetworkWindow_MediaType_DropDown 			= 	"Group1_lstMediaType";
	String loc_RI_Exh_NetworkWindow_NetworkType_Label			= 	"Group1_lblNetworkType";
	String loc_RI_Exh_NetworkWindow_NetworkType_DropDown 		= 	"Group1_lstNetworkType";
	String loc_RI_Exh_NetworkWindow_UserDefined_Label			= 	"Group1_lblUserDefNW";
	String loc_RI_Exh_NetworkWindow_UserDefined_CheckBox 		= 	"Group1_chkUserDefNW";
	String loc_RI_Exh_NetworkWindow_UserDefinedNetwork_Label 	= 	"Group1_lblUserDefNetwork";
	String loc_RI_Exh_NetworkWindow_UserDefinedNetwork_input 	= 	"Group1_txtUserDefNetwork";
	String loc_RI_Exh_NetworkWindow_ExhibNetwork_Label 			=	"Group1_lblNetwork";
	String loc_RI_Exh_NetworkWindow_OutLetNumber_Label 			=	"Group1_lblNumOutlets";
	String loc_RI_Exh_NetworkWindow_OutLetNumber_input 			=	"Group1_wmeNumOutlets";
	String loc_RI_Exh_NetworkWindow_DeSelectAll_Button 			= "Group1_btnDeSelect";
	String loc_RI_Exh_NetworkWindow_SelectAll_Button 			= "Group1_Button1";
	/*String loc_RI_ExhRightsColumnXpath_EditMode      = "";
	String loc_RI_ExhRightsDataRowXpath_EditMode     = "//*[contains(@id,'uwgExhibitions_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	                                                                            
	String loc_RI_ExhRightsColumnXpath_ViewMode      = "";
	String loc_RI_ExhRightsDataRowXpath_ViewMode     = "";
*/
	String loc_RI_ExhRights_InputField     = "//div[contains(@id,'uwg') and contains(@style,'visibility: visible')]//input[not(@type='hidden')]";

	// RI_EditingRights 
	String RI_EditingRightsColumnXpath_EditMode                              = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody//tr/th";
	String RI_EditingRightsDataRowXpath_EditMode                             = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	                                                                            
	String RI_EditingRightsColumnXpath_ViewMode                              = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_EditingRightsDataRowXpath_ViewMode                             = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Loc_EditingRightsApplesToViewMode                                 = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[4]";
	String Loc_EditngRightsImg                                               = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[5]/img";
	String Loc_EditingRightsSendReminder                                     = "//*[@id='pnlButtons']/table/tbody/tr/td[3]/img";
	String Loc_AllEditingRights                                              = "//*[@id='RI_EditRights_Edit_Div']/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/span[1]/label";
	String Loc_NoEditingRights                                               = "//*[@id='RI_EditRights_Edit_Div']/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/span[2]/label";
	String Loc_EditingRights1Row                                             = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String Loc_EditingRights2Row                                             = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String Loc_EditingRights3Row                                             = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/th";
	String Loc_EditingRights3RowViewMode                                     = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[2]";      
	String Loc_EditingRightsApplesTo3                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[2]/img";
	String Loc_EditingRightsApplesTo4                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[2]/img";
	String Loc_EditingRightsApplesTo5                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td[2]/img";



	String Loc_EditngRightsSeason1                                           = "//*[@id='uwtList']/ul/li/ul/li/ul/li[1]/img[4]";
	String Loc_EditngRightsEpisode101                                        = "//*[@id='uwtList']/ul/li/ul/li/ul/li[1]/ul/li[1]/img[5]";
	String loc_EditingRightsAppliesToInput                                   = "//*[@id='AppliesToEditor']/div/table/tbody/tr/td[1]/input";
	String loc_EditingRightsAppliesToInput1                                   = "//*[@id='RelatedAppliesToEditor']/div/table/tbody/tr/td[1]/input";
	
	String loc_EditingRightsInput                                            = "//*[@id='PromoEditor']/div/table/tbody/tr/td[1]/input";  
	String Loc_EditingRightsSearchBox                                        = "//*[@id='txtSearchTree']";
	String Loc_EditingRightsAutosuggestbox                                   = "//*[@id='ui-id-1']";
	String Loc_EditingRightsStartDate                                        = "//*[@id='uwgEditRights_StartDateEditor']/tbody/tr/td[1]/input";
	String Loc_EditingRightsEndDate                                          = "//*[@id='uwgEditRights_EndDateEditor']/tbody/tr/td[1]/input";                                                                           
	String LocEditingRightsStartAndEndTimeCodeInput                          = "//input[@id='uwgEditRights_TimeCodeFrameEditor']";  
	String Loc_EditingRightsTimeLimitationInput                              = "//*[@id='uwgEditRights_TimeCodeFrameEditor']";
	String Loc_EditingRightsContextInput                                     = "//*[@id='ContextEditor']/div/table/tbody/tr/td[1]/input";
	String Loc_EditingRightsNotes                                            = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[18]/img";
	String Loc_EditingRightsNotes2Row                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr/td[18]/img";
	String Loc_EditingRightsNotes3Row                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[6]/div/table/tbody/tr/td[18]/img";
	String Loc_EditingRightsNotes4Row                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[6]/div/table/tbody/tr/td[18]/img";
	String Loc_EditingRightsNotes5Row                                        = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td[6]/div/table/tbody/tr/td[18]/img";
	String loc_Businessterms1Row                                             = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String loc_Businessterms2Row                                             = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String loc_Businessterms3Row                                             = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/th";
    String loc_Businessterms                                                 = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	String loc_BusinesstermsViewMode                                         = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[1]";
	String loc_BusinesstermsInput                                            = "//*[@id='uwgBusTerms_ctl00']/div/table/tbody/tr/td[1]/input";
	String Loc_BusinesstermsTermDescription                                  = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]";
	String Loc_BusinesstermsTermDescriptionviewMode                          = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	String Loc_BusinesstermsTermDescriptionInput                             = "//*[@id='uwgBusTerms_ctl02']";
	String loc_BusinesstermsUsetempletPickList                               = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/img";
	String Loc_BusinessTermsGeneralcheckBox                                  = "//*[@id='PageContent_pkList_uwTree']/ul/li/img[2]";
	String Loc_EditingRightsInProgramUseBeckBox                              = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[6]/img";
	String Loc_EditingRightsInProgramUseBeckBox2Row                          = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr/td[6]/img";
	String Loc_EditingRightsInProgramUseBeckBox3Row                          = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[6]/div/table/tbody/tr/td[6]/img";
	String Loc_EditingRightsInProgramUseBeckBox4Row                          = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[6]/div/table/tbody/tr/td[6]/img";
	String Loc_EditingRightsPerpetuityCheckBox                               = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[9]/img";
	String Loc_EditingRightsRectionCheckBox                                  = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]/img";
	String Loc_EditingRightsIncludeinReportsCheckBox                         = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[9]/img";
	String Loc_EditingRightsAppliesToViewMode                                = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String Loc_EditingRightsViewMode                                         = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String Loc_EditingRightsNotesViewMode                                    = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[14]/img";
	String Loc_BusinessTermsRestriction                                      = "//*[@id='uwgBusTerms_it5_0_imgFlag_Restriction']";
	String Loc_BusinessTermsIncludeinReports                                 = "//*[@id='uwgBusTerms_it7_0_imgFlag_Include_In_Reports']";
	String Loc_AllEditingRightsCheckBox                                      = "//*[@id='chkAllEditRights']";
	String Loc_AllEditingRightsViewMode                                      = "//*[@id='lblNoAllPart']";
	String Loc_AllEditingRightsCheckBoxViewMode                              = "//*[@id='RI_EditRights_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/img";
	String Loc_NoEditingRightsChekcBox                                       = "//*[@id='chkNoEditRights']";
	String Loc_NoEditingRightsChekcBoxViewMode                               = "//*[@id='RI_EditRights_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/img";
	String loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes   = "//*[@id='uwtList']//ul/li//img[contains(@src,'checkbox_@var')]";
	String loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes_Asset = "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_')]";
	String loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes_Checked_Asset = "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_on')]";
	String loc_RI_EditingRights_EditMode_Applies_TemplateWindow_CheckBoxes_Unchecked_Asset = "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_off')]"; 
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_CheckBoxes 	 = "//*[@id='PageContent_tList1_uwTree']//ul/li//img[contains(@src,'checkbox_@var')]";
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_CheckBoxes_Asset = "//*[@id='PageContent_tList1_uwTree']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_')]";
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_CheckBoxes_Checked_Asset = "//*[@id='PageContent_tList1_uwTree']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_on')]";
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_CheckBoxes_Unchecked_Asset = "//*[@id='PageContent_tList1_uwTree']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_off')]";
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_ExpandIcon     = "//*[@id='PageContent_tList1_uwTree']/ul/li/img[contains(@title,'Expand')]";
	String loc_RI_EditingRights_EditMode_Media_TemplateWindow_CollapseIcon   = "//*[@id='PageContent_tList1_uwTree']/ul/li/img[contains(@title,'Collapse')]"; 
	String GridHeaderPath_RIEditingRights                                    = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String GridHeaderPath_RIEditingRights_1                                  = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_RIEditingRights_1                                    = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridDataPath_RIEditingRights                                      = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_RIEditingRights_Parent                             = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataView_RIEditingRights_Parent                               = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_RIEditingRights_child                              = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_RIEditingRights_child                                = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";
	String EditngRightsApplesToViewMode                                      = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String EditingRightsInProgramUseViewMode                                 = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]/img";
	String EditngRightsPerpetuityCheckBox                                    = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[5]/img";
	String EditngRightsContextImg                                            = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[8]/img";
	String EditngRightsProgramCheckBox                                       = "//*[@id='uwgReferences']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[6]/td[1]/img";


	String EditngRightsViewMode1Row                                          = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String EditngRightsStartDate1Row                                         = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String EditngRightsEndDate1Row                                           = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String EditngRightsStartTimeCode1Row                                     = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String EditngRightsEndTimeCode1Row                                       = "//*[@id='uwgEditRights_ctl00_1_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";

	String EditingRightsAppliesToViewMode2                                   = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[4]";
	String EditngRightsViewMode2Row                                          = "//*[@id='uwgEditRights_ctl00_3_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String EditngRightsStartDate2Row                                         = "//*[@id='uwgEditRights_ctl00_3_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String EditngRightsEndDate2Row                                           = "//*[@id='uwgEditRights_ctl00_3_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String EditngRightsStartTimeCode2Row                                     = "//*[@id='uwgEditRights_ctl00_3_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String EditngRightsEndTimeCode2Row                                       = "//*[@id='uwgEditRights_ctl00_3_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";

	String EditingRightsAppliesToViewMode3                                   = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[6]/td[4]";
	String EditngRightsViewMode3Row                                          = "//*[@id='uwgEditRights_ctl00_5_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String EditngRightsStartDate3Row                                         = "//*[@id='uwgEditRights_ctl00_5_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String EditngRightsEndDate3Row                                           = "//*[@id='uwgEditRights_ctl00_5_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String EditngRightsStartTimeCode3Row                                     = "//*[@id='uwgEditRights_ctl00_5_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String EditngRightsEndTimeCode3Row                                       = "//*[@id='uwgEditRights_ctl00_5_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";

	String EditingRightsAppliesToViewMode4                                   = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[8]/td[4]";
	String EditngRightsViewMode4Row                                          = "//*[@id='uwgEditRights_ctl00_7_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String EditngRightsStartDate4Row                                         = "//*[@id='uwgEditRights_ctl00_7_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String EditngRightsEndDate4Row                                           = "//*[@id='uwgEditRights_ctl00_7_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String EditngRightsStartTimeCode4Row                                     = "//*[@id='uwgEditRights_ctl00_7_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String EditngRightsEndTimeCode4Row                                       = "//*[@id='uwgEditRights_ctl00_7_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";

	String EditingRightsAppliesToViewMode5                                   = "//*[@id='uwgEditRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[10]/td[4]";
	String EditngRightsViewMode5Row                                          = "//*[@id='uwgEditRights_ctl00_9_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String EditngRightsStartDate5Row                                         = "//*[@id='uwgEditRights_ctl00_9_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String EditngRightsEndDate5Row                                           = "//*[@id='uwgEditRights_ctl00_9_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String EditngRightsStartTimeCode5Row                                     = "//*[@id='uwgEditRights_ctl00_9_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String EditngRightsEndTimeCode5Row                                       = "//*[@id='uwgEditRights_ctl00_9_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";
	String EditngRightsAssetInAssetNavigator                                 = "//a[contains(text(),'@var')]";
	String EditngRightsAssetInAssetNavigator1                                = "//a[contains(text(),'@var')]";
	

	//RI_Delivery Schedule
	String RI_DeliveryScheduleColumnXpath_EditMode                           = "//*[contains(@id,'uwgDeliveryMaterials_ctl00')]/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";     
	String RI_DeliveryScheduleDataRowXpath_EditMode                          = "//*[contains(@id,'uwgDeliveryMaterials_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String RI_DeliveryScheduleColumnXpath_ViewMode                           = "";
	String RI_DeliveryScheduleDataRowXpath_ViewMode                          = "";
	String DeliveryScheduleGenerateProduction                                = "//*[@id='btnRep']";
	String DeliveryScheduleSendReminder                                      = "//*[@id='pnlReminder']/img";
	String DeliveryScheduleCancelButton                                      = "//*[@id='btnClose']";
	String DeliverySchedule1Row                                              = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";  
	String DeliveryScheduleAppiesToInput                                     = "//*[@id='uwgDeliveryMaterials_ctl00_ctl00']/div/table/tbody/tr/td[1]/input";
	String DeliveryScheduleSelectAll                                         = "//*[@id='PageContent_tList1_btnSelectAll']";                                     
	String DeliveryScheduleDeSelectAll                                       = "//*[@id='PageContent_tList1_btnUnSelectAll']";
	String DeliveryScheduleSave                                              = "//*[@id='PageContent_tList1_btnOk']";
	String DeliveryScheduleCancel                                            = "//*[@id='Cancel']";
	String DeliveryScheduleHDCam                                             = "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_')]";
	String RI_DeliverySchedule_AllCheckBoxes                                 = "//*[@id='uwtList']//ul/li//img[contains(@src,'checkbox_@var')]";
	String RI_DeliverySchedule_verifyCheckbox                                = "//*[@id='uwtList']//ul/li/a[text()='@var']/../img[contains(@src,'checkbox_on')]";
	String RI_DeliveryScheduleDueOnInput                                     = "//*[@id='uwgDeliveryMaterials_ctl00_EditorControl2']/tbody/tr/td[1]/input";
	String RI_DeliveryScheduleFromImg                                        = "//*[@id='imgFromParty']";
	String RI_DeliveryScheduleFromSearchField                                = "//*[@id='txtName']";
	String RI_DeliveryScheduleFindButton                                     = "//*[@id='btnFind']";
	String RI_DeliveryScheduleIFC                                            = "//*[(text()='IFC')]";
	String RI_DeliveryScheduleSelctButton                                    = "//*[@id='btnSelect']"; 
	String RI_DeliveryScheduleQtyInput                                       = "//*[@id='uwgDeliveryMaterials_ctl00_EditorControl1']";
	String RI_DeliveryScheduleFinalQCInput                                   = "//*[@id='uwgDeliveryMaterials_ctl00_ctl01']/div/table/tbody/tr/td[1]/input";   
	String RI_DeliveryScheduleFinalQCImg                                     = "//*[@id='uwgDeliveryMaterials_ctl00_ctl01']/div/table/tbody/tr/td[2]/img";
	String RI_DeliveryScheduleText                                           = "//*[contains(text(),'@var')]";
	String RI_DeliveryScheduleQCStatusImg                                    = "//*[@id='uwgDeliveryMaterials_ctl00_ctl02']/div/table/tbody/tr/td[2]/img";
	String RI_DeliveryScheduleDeliveryStatusInput                            = "//*[contains(@id='uwgDeliveryMaterials_ctl00')]/input";
	String RI_DeliveryScheduleDisposeImg                                     = "//*[@id='uwgDeliveryMaterials_ctl00_ctl03']/div/table/tbody/tr/td[2]/img"; 
	String RI_DeliverySchedule1RowChild                                      = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String RI_DeliverySchedule1RowParents                                    = "//table/tbody/tr[1]/td/div/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String RI_DeliverySchedule1RowAppliesTo                                  = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String RI_DeliveryScheduleStrageLocationInput                            = "//input[@class='igg_Office2007BlueEditCell']";
	String RI_DeliveryScheduleAppliesTo1Row                                  = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String RI_DeliveryScheduleDeliverablesWarningWindowMsg                   = "//*[@id='lblMessage']";
	String RI_DeliveryScheduleGroup1                                         = "//*[@id='Group1']";
	String RI_DeliveryScheduleGroup2                                         = "//*[@id='Webgroupbox1']";    
	String RI_DeliveryScheduleGroup1CheckBox2                                = "//*[@id='ChkChildNo']"; 
	String RI_DeliveryScheduleGroup1CheckBox1                                = "//*[@id='chkChildYes']";
	String RI_DeliveryScheduleWarningWindowOkButton                          = "//*[@id='btnOk']";
	String RI_DeliveryScheduleViewModeDueOn2ndRow                            = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]";
	String RI_DeliveryScheduleViewModeDeliveryOn2ndRow                       = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String RI_DeliveryScheduleViewModeQty2ndRow                              = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String RI_DeliveryScheduleViewModeFinalQC2ndRow                          = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String RI_DeliveryScheduleViewModeQCStatus2ndRow                         = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";
	String RI_DeliveryScheduleViewModeDueOn1stdRow                            = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]";
	String RI_DeliveryScheduleViewModeDeliveryOn1stRow                       = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String RI_DeliveryScheduleViewModeQty1stRow                              = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[9]";
	String RI_DeliveryScheduleViewModeFinalQC1stRow                          = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String RI_DeliveryScheduleViewModeQCStatus1stRow                         = "//table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";
	String RI_DeliveryScheduleDropdownValeSelect                             = "//div[contains(@class,'DropDownList') and contains(@style,'visibility: visible')]//div[contains(@data-ig,':mkr:DropDownContents')]/ul//*[contains(text(),'@var')]";
	
	//RI_Obligations
     String ObligationsRow1                                                  = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
     String ObligationsRow2                                                  = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
     String ObligationsRow3                                                  = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/th";
     String ObligationsRow4                                                  = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/th";
     String ObligationsRow5                                                  = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/th";
     String ObligationsImg                                                   = "//*[@id='ddpAppliesTo_Editor']/div/table/tbody/tr/td[2]/img";
     String ObligationsTypeImg                                               = "//*[@id='ddpObgType_Editor']/div/table/tbody/tr/td[2]/img";
     String ObligationsCategoryImg                                           = "//*[@id='ddpObgCategory_Editor']/div/table/tbody/tr/td[2]/img";
     String loc_RI_Obligations_ColumnXpath_EditMode                          = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th";
     String loc_RI_Obligations_DataRowXpath_EditMode                         = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
     String loc_RI_Obligations_ColumnXpath_ViewMode                          = "//*[@id='uwgObligations_ctl00_@var_0']/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr//th";
     String loc_RI_Obligations_DataRowXpath_ViewMode                         = "//*[@id='uwgObligations_ctl00_@var_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
     String RI_ObligationsAppliesToInput                                     = "//*[@id='ddpAppliesTo_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsFromInput                                          = "//*[@id='ddpObgFrom_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsToInput                                            = "//*[@id='ddpObgTo_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_Obligations_CheckBoxes_Checked                                = "//*[@id='uwgReferences']//img[@title='Checked']";
     String RI_Obligations_CheckBoxes_UnChecked 			                 = "//*[@id='uwgReferences']//img[@title='Unchecked']";
     String RI_ObligationsCategoryInput                                      = "//*[@id='ddpObgCategory_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsTypeInput                                          = "//*[@id='ddpObgType_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsMediaInput                                         = "//*[@id='ddpMT_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsStartDateInput                                     = "//*[@id='uwgObligations_EventDateEditor']/tbody/tr/td[1]/input";
     String RI_ObligationsEndDateInput                                       = "//*[@id='uwgObligations_dppEndDateEditor']/tbody/tr/td[1]/input";
     String RI_ObligationsStatusInput                                        = "//*[@id='ddpObgStatus_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsCountryInput                                       = "//*[@id='ddpCurrency_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsValueInput                                         = "//*[@id='uwgObligations_ctl00']";
     String RI_ObligationsObligationValueFulfilledInput                      = "//*[@id='uwgObligations_ctl01']";
     String RI_NotesField                                                    = "//*[contains(text(),'Notes')][1]";
     String RI_ObligationsRelatedUsageInput                                  = "//*[@id='ddlRelatedUsageEditor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsServiceInput                                       = "//*[@id='ddpService_Editor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsUsageRightsInput                                   = "//*[@id='ddpUsageRightsEditor']/div/table/tbody/tr/td[1]/input";
     String RI_ObligationsTerritoryInput                                     = "//*[@id='ddpTerritory_Editor']/div/table/tbody/tr/td[1]/input";
     
    // RI_BusinessTerm
 	String loc_RI_BusinessTerms_ColumnXpath_EditMode 		                 = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th"; // Done
 	String loc_RI_BusinessTerms_DataRowXpath_EditMode  		                 = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";//Done
 	String loc_RI_BusinessTerms_ColumnXpath_ViewMode 	 		             = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
 	String loc_RI_BusinessTerms_DataRowXpath_ViewMode 	 		             = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
 	String loc_RI_BusinessTerms_EditMode_DropDownImage	 		             = "//div[contains(@id,'uwgBusTerms') and contains(@style,'visibility: visible')]//img";
 	String loc_RI_BusinessTermsUsetempletImg  		                         = "//*[@id='uwgBusTerms_ctl01']/div/table/tbody/tr/td[2]/img";
 	String RI_BusinessTermsSendReminder         		                     = "//*[@id='pnlReminder']/img";
 	String RI_BusinessTermsInput 		                                     = "//*[@id='uwgBusTerms_ctl00']/div/table/tbody/tr/td[1]/input";
 	String RI_BusinessTermsUseTemplateInput  		                         = "//*[@id='uwgBusTerms_ctl01']/div/table/tbody/tr/td[1]/input";
 	String RI_TermDescriptionInput  		                                 = "//*[@id='uwgBusTerms_ctl02']";
 	String RI_BusinessTermsUndoButton 		                                 = "//*[@id='uwgBusTerms_undoBtnDiv']/input";
    
 	// RI_PromoRights 	
  	String loc_RI_PromoRights_ColumnXpath_EditMode                           = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th";
  	String loc_RI_PromoRights_DataRowXpath_EditMode                          = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
  	String loc_RI_PromoRights_ColumnXpath_ViewMode                           = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
  	String loc_RI_PromoRights_DataRowXpath_ViewMode                          = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
  
  	String Loc_RI_PromoRightsAppliesToViewMode                               = "//*[@id='uwgPromoRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[4]";
  	String Loc_RI_PromoRightsShowAllRows                                     = "//input[@id='chkShowAllRows']";
  	String Loc_RI_PromoRightsSendReminder                                    = "//*[@id='pnlButtons']/table/tbody/tr/td[4]/img";
  	String Loc_RI_PromoRights1Row                                            = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
  	String Loc_RI_PromoRightsRow                                             = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/th";
  	String Loc_RI_PromoRightsAppliesToInput                                  = "//*[@id='AppliesToEditor']/div/table/tbody/tr/td[1]/input";
  	String Loc_RI_PromoRightsInput                                           = "//*[@id='PromoEditor']/div/table/tbody/tr/td[1]/input";
  	String Loc_RI_PromoRightsToPromoteInput                                  = "//*[@id='ToPromoteEditor']/div/table/tbody/tr/td[1]/input";
  	String Loc_RI_PromoRightsMediaInput                                      = "//*[@id='MediaTMEditor']/div/table/tbody/tr/td[1]/input";
  	String Loc_RI_PromoRightsTerritoryinput                                  = "//*[@id='TerritoryTMEditor']/div/table/tbody/tr/td[1]/input";
  	String RI_PromoRightsOutletsInput                                        = "//*[@id='BusinessOutletEditor']/div/table/tbody/tr/td[1]/input";
  	String RI_PromoRightsVenueInput                                          = "//*[@id='VenueEditor']/div/table/tbody/tr/td[1]/input";
  	String RI_PromoRightsStartDateInput                                      = "//*[@id='uwgPromoRights_StartDateEditor']/tbody/tr/td[1]/input";
  	String RI_PromoRightsEndDateInput                                        = "//*[@id='uwgPromoRights_EndDateEditor']/tbody/tr/td[1]/input";
  	String RI_PromoRightsAllPromotionRightsCheckBox                          = "//*[@id='chkAllPromoRights']";
  	String RI_PromoRightsAllPromotionRightsCheckBoxViewMode                  = "//*[@id='RI_PromoRights_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/img";
  	String RI_PromoRightsNoPromotionRightsCheckBox                           = "//*[@id='chkNoPromoRights']";
 	String RI_PromoRightsNoPromotionRightsCheckBoxViewMode                   = "//*[@id='RI_PromoRights_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/img";
 	String RI_PromoRightsMinimumAndMaximum                                   = "//*[@id='uwgPromoRights_TimeCodeNoFrameEditor']";
    // RI_Option
  	String Loc_RI_Options_SendReminder                                       = "//*[@id='pnlReminder']/img";
  	String loc_RI_Options_ColumnXpath_EditMode                               = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th";
  	String loc_RI_Options_DataRowXpath_EditMode                              = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
  	String loc_RI_Options_ColumnXpath_ViewMode                               = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
  	String loc_RI_Options_DataRowXpath_ViewMode                              = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
  	String loc_RI_Options_Row1                                               = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
  	String loc_RI_Options_AppliesToInput                                     = "//*[@id='uwgOptions_AppliesToEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_ServiceTypeInput                                   = "//*[@id='uwgOptions_ServiceTypeEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_OptionsTypeInput                                   = "//*[@id='uwgOptions_OptionTypeEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_NetworkInput                                       = "//*[@id='uwgOptions_NetworkEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_GrantorInput                                       = "//*[@id='ddlParty_Editor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_MediaInput                                         = "//*[@id='uwgOptions_MediaEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_Territorynput                                      = "//*[@id='uwgOptions_TerritoryEditor']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_Options_AppliesImg                                         = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[2]/img";
  	String loc_RI_Options_MediaImg                                           = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[6]/div/table/tbody/tr/td[15]/img";
  	String loc_RI_Options_TerritoryImg                                       = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[6]/div/table/tbody/tr/td[23]/img";
  	String loc_RI_Options_ProjectedExerciseDtImg                             = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[30]/img";
  	String loc_RI_Options_ProjectedExerciseDtInput                           = "//*[@id='uwgOptions_ProjectedExDateEditor']/tbody/tr/td[1]/input";
  	String RI_Options_NegotiationDeadlineInput                               = "//*[@id='uwgOptions_OptionDeadlineDateEditor']/tbody/tr/td[1]/input";
  	String RI_Options_MaxBudgetIncInput                                      = "//input[@id='uwgOptions_PercentageEditorControl']"; 
  	String RI_Options_OptPeriodLicenseFeeInput                               = "//input[@id='uwgOptions_CurrencyEditor']";
  	String Loc_RI_Options_ProjectedExerciseDt                                = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td[29]";
  	String Loc_RI_Options_ExercisedInput                                     = "//*[@id='uwgOptions_ddlStatusEditor']/div/table/tbody/tr/td[1]/input";
  	String Loc_RI_Options_FinalExercisedDtInput                              = "//*[@id='uwgOptions_FinalExercisedDateEditor']/tbody/tr/td[1]/input";
  	String Loc_RI_Options_LicPeriodDateFrom                                  = "//*[@id='lblLicDateFrom']";
 	String Loc_RI_Options_LicPeriodDateTo                                    = "//*[@id='form1']/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr/td[3]";
 	String Loc_RI_Options_EventPeriod                                        = "//*[@id='lblEventPeriod']";
 	String Loc_RI_Options_LicPeriodDateFromInput                             = "//*[@id='wdcFromDate']/tbody/tr/td[1]/input";
 	String Loc_RI_Options_LicPeriodDateToInput                               = "//*[@id='wdcToDate']/tbody/tr/td[1]/input"; 
 	String Loc_RI_Options_EventPeriodInput                                   = "//input[@id='WebMaskEditPeriod']";
 	String Loc_RI_Options_EventPeriodYearInput                               = "//*[@id='lstPeriod']";
 	String Loc_RI_Options_Add1PrgsTermsInput                                 = "//input[@id='uwgOptions_AddlProgramsEditor']";
 	String loc_RI_Options_Outletsnput                                        = "//*[@id='uwgOptions_Business_OutletEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_Options_RepresentedIndividualInput                         = "//*[@id='ddlRepPartyFromEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_Options_StatusInput                                        = "//*[@id='uwgOptions_ddlStatusEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_Options_Row                                                = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/th";
 // RI_Attributes
  	String loc_RI_Attributes_ColumnXpath_EditMode                            = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
   	String loc_RI_Attributes_DataRowXpath_EditMode                           = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
   	String loc_RI_Attributes_ColumnXpath_ViewMode                            = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
   	String loc_RI_Attributes_DataRowXpath_ViewMode                           = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
   	String loc_RI_AttributesAppliesToInput    = "";
   	String loc_RI_AttributesInput                                            = "//*[@id='uwgAssetAttributesDefault_ctl01']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_AttributesValue1Input                                      = "//*[@id='uwgAssetAttributesDefault_ctl02']/div/table/tbody/tr/td[1]/input";
  	String loc_RI_AttributesValue1                                           = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[@title='@var']/following-sibling::td";
  	String Loc_RI_Attributes_Field                                           = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[@title='@var']";
  	
  	//RI_Services
  	String Loc_RI_ServicesRow1                                               = "//*[@id='uwgServices']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/th";
  	String Loc_RI_ServicesAppliesToInput                                     = "//*[@id='ddpRelatedUsageEditor']/div/table/tbody/tr/td[1]/input";
 	String Loc_RI_ServicesPartyInput                                         = "//*[@id='ddpParty_Editor']/div/table/tbody/tr/td[1]/input";
 	String Loc_RI_ServicesInput                                              = "//*[@id='ddpService_Editor']/div/table/tbody/tr/td[1]/input";
 	String Loc_RI_ServicesUnionInput                                         = "//*[@id='ddpUnion_Editor']/div/table/tbody/tr/td[1]/input";
 	String Loc_RI_ServicesCharacterInput                                     = "//*[@id='uwgServices_ed0']/input";
 	String Loc_RI_ServicesAppliesToViewMode                                  = "//*[@id='uwgServices_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]"; 
 	String loc_RI_Services_ColumnXpath_EditMode                              = "//*[@id='uwgServices']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th";
 	String loc_RI_Services_DataRowXpath_EditMode                             = "//*[@id='uwgServices']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
 	String loc_RI_Services_ColumnXpath_ViewMode                              = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr//th";
 	String loc_RI_Services_DataRowXpath_ViewMode                             = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
 	String Loc_RI_ServicesBeginInput                                         = "//*[@id='uwgServices_EventDateEditor']/tbody/tr/td[1]/input"; 
 	String Loc_RI_ServicesEndInput                                           = "//*[@id='uwgServices_EditorControl1']/tbody/tr/td[1]/input"; 
 	String Loc_RI_ServicesDetailsInput                                       = "//*[@id='uwgServices_ed0']/input";      
 	
 	
	// RI_RevenueParticipation
 	String loc_RI_RevenueParticipationStatementSchedule                      = "//*[@id='lblStatementSchedule']";
 	String loc_RI_RevenueParticipationSendReminder                           = "//*[@id='pnlButtons']/table/tbody/tr/td[3]/img";
 	String loc_RI_RevenueParticipationRow                                    = "//*[@id='uwgRevParticipation']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/th";
 	String loc_RI_RevenueParticipationAppliesToInput                         = "//*[@id='AppliesToEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationPartyInput                             = "//*[@id='PartyEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationServiceInput                           = "//*[@id='ddlServicesNewEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationMediaInput                             = "//*[@id='MediaTMEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationTerritoryInput                         = "//*[@id='TerritoryTMEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationParticipationInput                     = "//*[@id='uwgRevParticipation_ctl01']";
 	String loc_RI_RevenueParticipationBackendFormulaInput                    = "//*[@id='BackEndEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationCurrencyInput                          = "//*[@id='CurrencyEditor']/div/table/tbody/tr/td[1]/input";
 	String loc_RI_RevenueParticipationAmountInput                            = "//*[@id='uwgRevParticipation_ctl03']";
 	String loc_RI_NoRevenueParticipation                                     = "//*[@id='pnlNoRevenueParticipation']/table/tbody/tr/td/span/label";
 	String loc_RI_NoRevenueParticipationCheckBox                             = "//*[@id='chkNoRevenueParticipation']";
 	String loc_RI_NoRevenueParticipationCheckBoxInViewMode                   = "//*[@id='RI_Revenue_ParticipationTab_Div']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr/td/img";
 	String loc_RI_NoRevenueParticipationCopyButton                           = "//*[@id='btnCopyRow']";
 	String loc_RI_RevenueParticipation_ColumnXpath_EditMode                  = "//*[@id='uwgRevParticipation']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th";
 	String loc_RI_RevenueParticipation_DataRowXpath_EditMode                 = "//*[@id='uwgRevParticipation']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
 	String loc_RI_RevenueParticipation_ColumnXpath_ViewMode                  = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
 	String loc_RI_RevenueParticipation_DataRowXpath_ViewMode                 = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
 	
 	//RI_AggrementSearch
 	String loc_RI_AggrementSearchPropertyTitle                               = "lblAssetTitle";
 	String loc_RI_AggrementSearchEpisode                                     = "lblEpisodes";
 	String loc_RI_AggrementSearchChannelEntity                               = "lblSourceEntity";
 	String loc_RI_AggrementSearchContractName                                = "lblDealName";
 	String loc_RI_AggrementSearchRMSContractType                             = "lblDealType";
 	String loc_RI_AggrementSearchDM5DocType                                  = "lblDocType";
 	String loc_RI_AggrementSearchPartyRepresenting                           = "lblParty";
 	String loc_RI_AggrementSearchVMNParty                                    = "lblInternalParty";
 	String loc_RI_AggrementSearchServices                                    = "lblServices";
 	String loc_RI_AggrementSearchContractStatus                              = "lblContractStatus";
 	String loc_RI_AggrementSearchContractEntryStatus                         = "lblDataEntryStatus";
 	String loc_RI_AggrementSearchContractDtFm                                = "lblExecutionDtFrom";
 	String loc_RI_AggrementSearchRevisionDtFm                                = "lblContractRevisionDate";
 	String loc_RI_AggrementSearchLastUpdatedBy                               = "lblLastUpdatedBy";
 	String loc_RI_AggrementSearchCreatedBy                                   = "lblCreatedBy";
 	String loc_RI_AggrementSearchAgreementType                               = "lblAgreementType";
 	String loc_RI_AggrementSearchTeamMember                                  = "lblTeamMember";
 	String loc_RI_AggrementSearchIDType                                      = "lblIDType";
 	String loc_RI_AggrementSearchAKAsFKAs                                    = "//*[@id='grpSearchCriteria']/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/span/label";
 	String loc_RI_AggrementSearchReturnAttachments                           = "//*[@id='grpSearchCriteria']/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]/span/label";
 	String loc_RI_AggrementSearchIncludeDeleted                              = "//*[@id='grpSearchCriteria']/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[3]/span/label";
 	String loc_RI_AggrementSearchExactMatch                                  = "//*[@id='TPanel']/table/tbody/tr/td[2]/table/tbody/tr[7]/td/span/label";
 	String loc_RI_AggrementSearchRightsMedia                                 = "lblMedia";
 	String loc_RI_AggrementSearchTerritory                                   = "lblTerritory";
 	String loc_RI_AggrementSearchLicenseDatesFm                              = "lblLicenseDates";
 	String loc_RI_AggrementSearchObligationType                              = "lblObligationType";
 	String loc_RI_AggrementSearchFutureProperty                              = "lblFutureAssets";
 	String loc_RI_AggrementSearchExpirationDateFm                            = "lblExpirationDate";
 	String loc_RI_AggrementSearchLastUpdateDateFm                            = "lblLastUpdateDateFrom";
 	String loc_RI_AggrementSearchCreationDateFm                              = "lblCreationDateFrom";
 	String loc_RI_AggrementSearchOptionDeadlineFm                            = "lblOptionDeadlineFrom";
 	String loc_RI_AggrementSearchPremiereAirDateFm                           = "lblPremiereAirDateFrom";
 	String loc_RI_AggrementSearchPremiereNetwork                             = "lblPremiereNetwork";
 	String loc_RI_AggrementSearchAttributes                                  = "lblAttributes";
    String loc_RI_AggrementSearch                                            = "//*[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[1]/a/span";
 	String loc_RI_AggrementSearchSaveSearchButton                            = "btnSaveSearch";
 	String loc_RI_AggrementSearchRestoreSearch                               = "btnRestoreSearch";
 	String loc_RI_AggrementSearchExpandAdvanceSearch                         = "//*[@id='ExpandToggleImagebtn']";
	String loc_RI_AggrementSearchPropertyTitleInput                          = "txtAssetTitle";
	String loc_RI_AggrementSearchAKAsFKAsCheckbox                            = "//*[@id='chkAKA']";
	String loc_RI_AggrementSearchChannelEntityDroupdown                      = "//*[@id='ddlSourceEntity']";
	String loc_RI_AggrementSearchChannelEntityPicklist                       = "imgSourceEntity";
	String loc_RI_AggrementSearchDealNameInput                               = "txtDealName";
	String loc_RI_AggrementSearchReturnAttachmentCheckbox                    = "chkReturnAttachments";
	String loc_RI_AggrementSearchReturnAttachmentCheckboxVerify              = "//*[@id='chkReturnAttachments' and @checked= 'true']";
	String loc_RI_AggrementSearchReturnAttachmentCheckboxVerifyChecked       = "//*[@id='chkReturnAttachments' and @checked= 'checked']";
	String loc_RI_AggrementSearchDealTypeDropdown                            = "ddlDealType";
	String loc_RI_AggrementSearchDealTypePicklist                            = "img_dealtyp";
	String loc_RI_AggrementSearchDocumentTypeDropdown                        = "ddlDocType";
	String loc_RI_AggrementSearchPartyLookupIcone                            = "imgParty";
	String loc_RI_AggrementSearchSelectRow                                   = "//*[contains(text(),'@var')]";
	String loc_RI_AggrementSearchVMNPartyLookupicone                         = "img1";
	String loc_RI_AggrementSearchServicesDropdown                            = "ddlServices";
	String loc_RI_AggrementSearchServicesPicklist                            = "img2";
	String loc_RI_AggrementSearchContractStatusDropdown                      = "ddlContractStatus";
	String loc_RI_AggrementSearchContractStatusPicklist                      = "img2";
	String loc_RI_AggrementSearchContractEntryStatusDropdown                 = "ddlDataEntryStatus";
	String loc_RI_AggrementSearchContractEntryStatusPicklist                 = "imgAssetStatus";
	String loc_RI_AggrementSearchIncludeDeletedCheckbox                      = "chkIncludeDeleted";
	String loc_RI_AggrementSearchIncludeDeletedCheckboxVerify                = "//*[@id='chkIncludeDeleted' and @checked= 'true']";
	String loc_RI_AggrementSearchIncludeDeletedCheckboxVerifyChecked         = "//*[@id='chkIncludeDeleted' and @checked= 'checked']";
	String loc_RI_AggrementSearchdateFrom1                                   = "//*[@id='dtExecutionFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchdateTo1                                     = "//*[@id='dtExecutionTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchdateFrom2                                   = "//*[@id='dtContractRevisionFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchdateTo2                                     = "//*[@id='dtContractRevisionTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchLastUpdatedBypicklist                       = "img4";
	String loc_RI_AggrementSearchCreatedBypicklist                           = "img5";
	String loc_RI_AggrementSearchAgreementTypeDropdown                       = "ddlAgreementType";
	String loc_RI_AggrementSearchAgreementTypePicklist                       = "imgAgreementType";
	String loc_RI_AggrementSearchTeamMemberLookupIcone                       = "img7";
	String loc_RI_AggrementSearchMediaDropdown                               = "ddlMedia";
	String loc_RI_AggrementSearchMediaPicklist                               = "imgMedia";
	String loc_RI_AggrementSearchMustHaveAllMediaCheckbox1                   = "chkMustHaveAllMedia";
	String loc_RI_AggrementSearchTerritoryDropdown                           = "ddlTerritory";
	String loc_RI_AggrementSearchTerritoryPicklist                           = "imgTerritory";
	String loc_RI_AggrementSearchMustHaveAllTerritoryCheckbox2               = "chkMustHaveAllTerritory";
	String loc_RI_AggrementSearchLicenseDatesFmInput 	                     = "//*[@id='dtContractRevisionFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchLicenseDatesToInput 	                     = "//*[@id='dtLicenseDatesTo']/tbody/tr/td[1]/input";
                                                                                    
	String loc_RI_AggrementSearchMustHaveAllDatesCheckbox3                   = "chkMustHaveAllDates";
	String loc_RI_AggrementSearchIncludeRecordsDatesCheckbox                 = "chkIncludeNoDateRecords";
	String loc_RI_AggrementSearchPerpetuityCheckbox                          = "chkPerpetuity";
	String loc_RI_AggrementSearchObligationTypeDropdown                      = "ddlObligationType";
	String loc_RI_AggrementSearchObligationTypePicklist                      = "imgObligationType";
	String loc_RI_AggrementSearchFuturePropertyDropdown                      = "ddlFutureAssets";
	String loc_RI_AggrementSearchExpirationDateFmInput 	                     = "//*[@id='dtExpirationFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchExpirationDateToInput 	                     = "//*[@id='dtExpirationTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchLastUpdateDatFmInput 	                     = "//*[@id='dtLastUpdateDateFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchLastUpdateDatToInput 	                     = "//*[@id='dtLastUpdateDateTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchCreationDateFmInput 	                     = "//*[@id='dtCreationDateFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchCreationDateToInput 	                     = "//*[@id='dtCreationDateTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchOptionDeadlineFmInput 	                     = "//*[@id='dtOptionDeadlineFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchOptionDeadlineToInput 	                     = "//*[@id='dtOptionDeadlineTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchPremiereAirDateFmInput 	                 = "//*[@id='dtOptionDeadlineFrom']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchPremiereAirDateToInput 	                 = "//*[@id='dtOptionDeadlineTo']/tbody/tr/td[1]/input";
	String loc_RI_AggrementSearchPremiereNetworkDropdown                     = "ddlPremiereNetwork";
	String loc_RI_AggrementSearchPremiereNetworkPicklist                     = "imgPremiere";
	String loc_RI_AggrementSearchDealTypeFromSearchResult                    = "//*[contains(@id,'uwgSearchResults_')]//tr/td[4]";
	String loc_RI_AggrementSearchContractEntryStatusFromSearchresult         = "//*[contains(@class,'dxgvCSD')]//tr/td[2]";
	String loc_RI_AggrementSearchAgreementTypeFromSearchresult               = "//*[contains(@class,'dxgvCSD')]//tr/td[14]";
	String loc_RI_AggrementSearchChannelFromSearchresult                     = "//*[contains(@class,'dxgvCSD')]//tr/td[6]";
	String loc_RI_AggrementSearchReportTypeDropdown                          = "ddlReportVesion";
	String loc_RI_AggrementSearchresultsheader                               = "//*[contains(@id,'uwgSearchResults_col')]";
	String loc_RI_AggrementSearchFieldChooser                                = "Butt_FieldChooser";
	String loc_RI_AggrementSearchAppliesButton                               = "//*[@id='PageContent_tList1_btnSave']";
	String loc_RI_AggrementSearchMoveUpButton                                = "//*[@id='PageContent_tList1_btnMoveUp']";
	String loc_RI_AggrementSearchMoveDownButton                              = "//*[@id='PageContent_tList1_btnMoveDown']";
	String loc_RI_AggrementSearchScope                                       = "//*[@id='grpRadio']/legend";
	String loc_RI_AggrementSearchScope1                                      = "//*[@id='grpRadio']/div/table/tbody/tr[1]/td[1]/span/label";
	String loc_RI_AggrementSearchScope2                                      = "//*[@id='grpRadio']/div/table/tbody/tr[1]/td[2]/span/label";
	String loc_RI_AggrementSearchOptions                                     = "//*[@id='WebGroupBox1']/legend";
	String loc_RI_AggrementSearchOptions1                                    = "//*[@id='WebGroupBox1']/div/table/tbody/tr[1]/td/span/label";
	String loc_RI_AggrementSearchOptions2                                    = "//*[@id='WebGroupBox1']/div/table/tbody/tr[2]/td/span/label";
	String loc_RI_AggrementSearchExactMatchCheckBox                          = "chkExactMatch";
	String loc_RI_AggrementSearchScopeCheckBox1                              = "//*[@id='grpRadio_local']";
	String loc_RI_AggrementSearchOptionsCheckBox2                            = "//*[@id='WebGroupBox1_rbSaveAs']";
	String loc_RI_AggrementSearchSaveAsANewsearchInput                       = "//*[@id='WebGroupBox1_txtFileName']"; 
	String loc_RI_AggrementSearchMySearchesLocal                             = "//*[@id='wgbSearch']/div/table/tbody/tr/td/span[2]/label";
	String loc_RI_AggrementSearchGlobalSearches                              = "//*[@id='wgbSearch']/div/table/tbody/tr/td/span[3]/label";
	String loc_RI_AggrementSearchrestoreButton                               = "btnRestore";
	String loc_RI_AggrementSearchinputField                                  = "wgbSearch_txtSearchFor";
	String loc_RI_AggrementSearchButton                                      = "wgbSearch_btnSearch";
	String loc_RI_ReturnTolastSearch                                         = "//*[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[2]/a/span";
	String Loc_RI_AgrementSearchIDType                                       = "ddlIDType";
	String Loc_RI_agreementSearchPickListChecked                             = "//*[@id='PageContent_pkList_uwTree']//../img[contains(@src,'checkbox_on')]";
	String Loc_RI_agreementSearchPickListUnchecked                           = "//*[@id='PageContent_pkList_uwTree']//../img[contains(@src,'checkbox_off')]";
	String Loc_RI_agreementSearchPageSizeImg                                 = "//*[@id='uwgSearchResults_DXPagerBottom_DDBImg']";
	String Loc_RI_agreementSearchPageSizeSelectAll                           = "//*[@id='uwgSearchResults_DXPagerBottom_PSP_DXI4_T']";
	String Loc_RI_agreementSearchprocessingImg                               = "//*[@id='uwgSearchResults_LPV']/table/tbody/tr/td[1]/img";
	
	
	
	
	
	
	
	
	
	
 	
	// RI_Restriction
	String RI_RestrictionColumnXpath = "//*[@id='uwgDaypart']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_RestrictionColumn2Xpath = "//*[@id='uwgLastPlay']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";// 2nd
	String RI_RestrictionColumn3Xpath = "//*[@id='uwgMaxPlays']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";// 3rd
	String RI_RestrictionColumn4Xpath = "//*[@id='uwgMaxEpiPerPeriod']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";// 4th
	String RI_RestrictionColumn5Xpath = "//*[@id='uwgMaxExhib']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";// 5th
	String RI_RestrictionColumn6Xpath = "//*[@id='uwgMustPlay']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";// 6th
	String RI_RestrictionRowXpath = "//*[@id='uwgDaypart']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 1st
	String RI_RestrictionRow2Xpath = "//*[@id='uwgLastPlay']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 2nd
	String RI_RestrictionRow3Xpath = "//*[@id='uwgMaxPlays']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 3rd
	String RI_RestrictionRow4Xpath = "//*[@id='uwgMaxEpiPerPeriod']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 4th
	String RI_RestrictionRow5Xpath = "//*[@id='uwgMaxExhib']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 5th
	String RI_RestrictionRow6Xpath = "//*[@id='uwgMustPlay']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";// 6th

	// RI_TrackingEvents
	String ParentDataRowXpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathRIPremiere = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIPremiere = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[9]/div/table/tbody/tr/th";
	String DataRow1XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]/div/table/tbody/tr";
	String ColumnRow1XpathRIOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String DataRow1XpathRIOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr";
	String ColumnRow1XpathRIPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String DataRow1XpathRIPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr";
	String DataRow2XpathRIPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr";
	String ColumnRow1XpathRIEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String DataRow1XpathRIEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[6]/div/table/tbody/tr";
	String DataRow2XpathRIEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr";
	String DataRow2XpathRIOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr";
	String ColumnRow1XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathRIPaymentsAssetValue = "//*[@id='uwgAssetvalue']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIPaymentsAssetValue = "//*[@id='uwgAssetvalue']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow2XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow2XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	// RI_MediaRights - Global values
	String GridHeaderPath_RIMediaRights_Fixed = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridHeaderPath_RIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[9]/div/table/tbody/tr/th";
	String GridHeaderPath_ROMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String GridDataPath_RIMediaRights_Fixed = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridDataPath_RIMediaRights 		= "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridViewPath_RIMediaRights_Parent = "//*[@id='uwgMediaRights_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridViewPath_RIMediaRights_Child = "//*[@id='uwgMediaRights_ctl00_0_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridPath_RIMediaRights_Episode = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RI_ExhibitionsRights - Global values
	String GridHeaderPath_RIExhibitionRights_Parent = "//*[@id='uwgExhibitions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_RIExhibitionRights_Parent = "//*[@id='uwgExhibitions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderPath_RIExhibitionRights_Child = "//*[@id='uwgExhibitions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_RIExhibitionRights_Child = "//*[@id='uwgExhibitions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	// RI_Payments
	String DataRow2XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[8]/div/table/tbody/tr";
	String DataRow3XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[8]/div/table/tbody/tr";
	String ColumnRow1XpathRIPaymentsMain = "//*[@id='grpReceivables_uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIPaymentsMain = "//*[@id='grpReceivables_uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow2XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow21XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String DataRow2XpathRIPaymentsMain = "//*[@id='grpReceivables_uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow3XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow31XpathRIPayments = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RI_DeliverySchedule
	String RI_DeliveryScheduleColumnXpath = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_DeliveryScheduleColumnXpath1 = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_DeliveryScheduleColumnXpath2 = "//*[contains(@id,'uwgDeliveryMaterials_ctl00')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_DeliveryScheduleRowXpath = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RI_DeliveryScheduleRowXpath1 = "//*[@id='uwgDeliveryMaterials_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RI_DeliveryScheduleRowXpath2 = "//*[contains(@id,'uwgDeliveryMaterials_ctl00')]/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";

	
	

	// RI_Audit Trial Report
	String loc_ExpandDeal_Icon = "//*[contains(@id,'grpResults_uwgSearchResults')]//td[contains(@class,'ExpansionColumn')]//img";
	String loc_AuditTrail_RowDeleted = "//*[contains(@id,'grpResults_uwgSearchResults')]//td[text()='3']/../td[text()='Delete']";
	String RI_MediaRights_ColumnXpath = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[9]/div/table/tbody/tr/th";
	String RI_MediaRights_RowXpath = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]/div/table/tbody/tr/td";
	String RI_MediaRights_RowXpath1 = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[8]/div/table/tbody/tr/td";
	String ROExhibitionRights_Columnparent = "//table[1]/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String ROExhibitionRights_ColumnChild = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String ROExhibitionRights_Rowparent = "//table[1]/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String ROExhibitionRights_RowChild = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RI_Audit_Trial_ReportColumnXpath = "//*[@id='ctl00_PageContent_grpResults_uwgSearchResults_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_ExhibitionsRowXpath = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RI_Audit_Trial_ReportColumnXpath1 = "//table/tbody/tr/td/fieldset/div/table/tbody/tr[2]/td/div/div/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_Audit_Trial_ReportColumnXpath2 = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_Audit_Trial_ReportRowXpath3 = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String RI_Audit_Trial_ReportColumnXpath3 = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RI_Audit_Trial_ReportRowXpath4 = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RI_Versions
	String ColumnRow1XpathRIVersionView = "//*[@id='uwgVersions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIVersionView = "//*[@id='uwgVersions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow3XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow3XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow4XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[9]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow4XpathRITrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[9]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RI_ProjectTeam
	String ColumnRow1XpathRIProjTeamEdit = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIProjTeamEdit = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	
	//RI_Pre-requisites
	String loc_SubMenu_PopUp_OptionAtPopUpWindow 	= "//*[@id='PageContent_tList1_uwTree']//a[text()='@var']";
	String loc_SubMenu_PopUp_TemplateDropDown 	= "PageContent_tList1_ddlTemplatesLst";
	String loc_SubMenu_PopUp_AddButton 				= "PageContent_tList1_btnNew";
	String loc_SubMenu_PopUp_SelectAllButton 		= "PageContent_tList1_btnSelectAll";
	String loc_SubMenu_PopUp_TemplateNameInputField = "PageContent_tList1_txtNewTemplate";
	String loc_SubMenu_PopUp_SaveButtonAtTemplateWindow = "PageContent_tList1_btnNewSave";
	String loc_SubMenu_PopUp_CancelButton 				= "PageContent_tList1_btnCancel";
	
	/**
	 * @author Rajuddin
	 */
	// RI_Tracking Events
	String loc_RI_TrackEventEdit_Btn 			= "btnTrackEventEdit";
	String loc_RI_TrackEvent_ParentRow    		= "//th[contains(@id,'columnheader_') and @key='@var']";
//	String loc_RI_TrackEvent_Child_HeaderRow    = "//*[contains(@id,'uwgTrackEventsEdit_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String loc_RI_TrackEvent_Child_HeaderRow    = "//*[contains(@id,'uwgTrackEvents')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	//String loc_RI_TrackEvent_Child_DataRow     	= "//*[contains(@id,'uwgTrackEventsEdit_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	
	String loc_RI_TrackEvent_Child_DataRow     	= "//*[contains(@id,'uwgTrackEvents')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	
	String loc_RI_TrackEvent_DeleteButton 		= "//*[contains(@id,'btnDelete') and not(@type='submit')]";
	
	
	
	
	
	
	
	
	// Term Event
	///////////////Commencing On//////////////////////////////////////
	// Labels
	String loc_RI_TermEvent_CommencingOn_GeneralElement 		= "//*[contains(@id,'wgbStartDate')]//*[contains(text(),'@var')]";
	String loc_RI_TermEvent_CommencingOnLabel 		= "lblCommencingOn";
	String loc_RI_TermEvent_EndingOnLabel 			= "lblEndingOn";	
	
	String loc_RI_TermEvent_DurationInputField 			= "txtDuration";
	String loc_RI_TermEvent_DurationDropDownField 		= "lstDurationPeriod";
	String loc_RI_TermEvent_DurationOperatorField 		= "lstDurationOperator";
	String loc_RI_TermEvent_AddlDurationField 			= "txtAddlDuration";
	String loc_RI_TermEvent_AddlDurationPeriodDropDown 	= "lstAddlDurationPeriod";
	String loc_RI_TermEvent_PerpetuityCheckBox 			= "chkPerpetuity";	
	
	String loc_RI_TermEvent_StartDateInputField 				= "";
	String loc_RI_TermEvent_StartDateDurationOperatorDropDown	= "lstStartDateDurationOperator";
	String loc_RI_TermEvent_StartDateAddlDurationField 			= "lstStartDateAddlDuration";
	String loc_RI_TermEvent_AddlDurationPeriod 					= "lstAddlDurationPeriod";	
	
	String loc_RI_TermEvent_StartEst_InputField 	= "//*[@id='wdcStartEstimatedDate']//input";
	String loc_RI_TermEvent_StartEventHeaderRow		= "//th[contains(@id,'uwgStartEvent_columnheader') and @key='@var']";
	String loc_RI_TermEvent_StartEventDataRow 		= "//*[@id='uwgStartEvent']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String loc_RI_TermEvent_StartDealHeaderRow		= "//th[contains(@id,'uwgStartDealSelect_columnheader') and @key='@var']";
	String loc_RI_TermEvent_StartDealDataRow 		= "//*[contains(@id,'uwgStartDeal')]/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	
	///////////////////////////////////////////////////Ending On//////////////////////////////////////
	String loc_RI_TermEvent_EndingOn_GeneralElement 			= "//*[contains(@id,'wgbEndDate')]//*[contains(text(),'@var')]";
	String loc_RI_TermEvent_EndDateInputField 					= "";
	String loc_RI_TermEvent_EndDateDurationOperatorDropDown		= "lstEndDateDurationOperator";
	String loc_RI_TermEvent_EndDateAddlDurationField 			= "lstEndDateAddlDuration";
	String loc_RI_TermEvent_EndDateDurationPeriod 				= "lstEndDateDurationPeriod";	
	String loc_RI_TermEvent_EndEst_InputField 	= "//*[@id='wdcEndEstimatedDate']//input";
	
	
	
	String loc_RI_TermEvent_EndEventHeaderRow		= "//th[contains(@id,'uwgEndEvent_columnheader') and @key='@var']";
	String loc_RI_TermEvent_EndEventDataRow 		= "//*[@id='uwgEndEvent']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	

	String loc_RI_TermEvent_EndDealHeaderRow		= "//th[contains(@id,'uwgEndDealSelect_columnheader') and @key='@var']";
	String loc_RI_TermEvent_EndDealDataRow 		= "//*[contains(@id,'uwgEndDeal')]/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	

	
	/**
	 * @author Jaikumar
	 */
	//Buttons on Payments Tab
	String loc_RI_Payment_Editpayment = "btnEditReceivablesPayables";
	String loc_RI_Payment_EditAssetvalue = "btnEditAssetvalue";
	String loc_RI_Payments_Editpayment_AddButton = "//*[@id='btnPayAdd']";
	String loc_RI_Payments_Editpayment_AllocateButton = "//*[@id='uwtPayment_tmpl1_btnPayAlloc']";
	String loc_RI_Payments_Editpayment_CopyButton = "uwtPayment_tmpl1_btnPayCopy";
	String Loc_RI_Payments_Editpayment_FirstAllocationrowSelector = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
	String Loc_RI_Payments_Allocationrowokbutton = "//*[@id='btnOk']";
	String Loc_RI_Payments_Allocationrowlines = "//*[@id='ddlRows']";
	String temp = "//*[@id='-2_0_columnheader_83']";
	
	//Buttons on Asset value Tab
	String Loc_RI_Payment_Assetvalue_Addbutton = "btnNew";
			
	
	//RI Payment frame input locators
	String loc_RI_Payment_EditMode_DropDownImage		="//div[contains(@id,'uwg') and contains(@style,'visibility: visible')]//div[contains(@id,'uwg') ]//td/img";	
	String Loc_RI_Payment_Appliesto_input = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00_ctl03']/div/table/tbody/tr/td[1]/input";
	String Loc_RI_Payment_Party_input = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00_ctl05']/div/table/tbody/tr/td[1]/input";
	String Loc_RI_Payment_Paymenttype_input = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00_ctl06']/div/table/tbody/tr/td[1]/input";
	String Loc_RI_Payment_Amount_input = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00_EditorControl2']";
	String Loc_RI_Payment_Duedate_input = "//*[@data-ig ='x:828233568.0:mkr:3']";
	
	//RI Payment_Asset value input locators
	String loc_RI_Payment_Assetvalue_EditMode_DropDownImage	= "//div[contains(@id,'AppliesTo') and contains(@id,'uwg')]//td/img";
	String Loc_RI_Payment_Assetvalue_Appliesto_input = "//*[@id='uwgAssetvalue_ctl00']/div/table/tbody/tr/td[1]/input";
	String Loc_RI_Payment_Assetvalue_Amount_input = "//*[@id='uwgAssetvalue_EditorControl4']";
	
	

	String loc_RI_Payment_Parent_HeaderRow  = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[@key='@var']";
	String loc_RI_Payment_Parent_DataRow	= "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";		 		                                                                            
	String loc_RI_Payment_Child_Data_HeaderRow	= "//*[contains(@id,'uwtPayment_tmpl1_uwgPayables_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody//tr";
	String loc_RI_Payment_supportclick = "//*[@id='uwtPayment_tmpl1_uwgPayables_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr//tr[@role='row']";
	String loc_RI_Payment_Assetvalue_HeaderRow = "//*[@id='uwgAssetvalue']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr";
	String loc_RI_Payment_Assetvalue_DataRow	= "//*[@id='uwgAssetvalue']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody//tr";

//RAR Search Criteria 
String loc_RI_RAR_ProprtyTitle = "//*[@id='txtAssetTitle']"
	
}
	
	
	
	
	
	
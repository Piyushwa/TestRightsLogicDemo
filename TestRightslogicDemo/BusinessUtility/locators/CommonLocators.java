package locators;

public interface CommonLocators {

	// Links
	String loc_NewButton  = "//a/span[contains(text(),'New')]";
	
	//Tabs
	String loc_Tab 						= "//span/span/span[contains(text(),'@var')]";
	/**
	 * @var : title
	 */
  	String loc_FollowingRow     	= "//*[text()='@var']/following-sibling::td";
  	/**
	 * @var : title
	 */
  	String loc_PrecedingRow     	= "//*[text()='@var']/preceding-sibling::td";

	String loc_Generallocator    	= "//*[contains(text(),'@var')]";
	
	
	// ****************Common Xpaths for Menu Bar***********************//
	String NewMenuBar = "//*[@id='PlainTopMenu1_MainMenu']//a/span[text()='New']";
	String TemplatesMenuBar = "//*[@id='PlainTopMenu1_MainMenu']//a/span[text()='Templates']";
	//String SearchMenuBar = "//*[@id='PlainTopMenu1_MainMenu']//a/span[text()='Search']";
	String HelpMenuBar = "//*[@id='PlainTopMenu1_MainMenu']//a/span[text()='Help']";
	String ReportsMenuBar = "//*[@id='PlainTopMenu1_MainMenu']//a/span[text()='Reports']";
	String DealNavigatorMenuBar = "//a/span[text()='Deal Navigator']";
	String DealMemoMenuBar = "//a/span[text()='Deal Memo']";
	String SaveMenuBar = "//a/span[contains(text(),'Save')]";
	String RightsInOutGadgets = "//*[contains(@id,'PageContent_Home1_HomePage')]//img[@id='GadgetImage']";
	String Window2Header  ="//div[@id='WebDialogWindow2' or @id='WebDialogWindow1']/div/table/tbody/tr/td[2]/span";
	String OKButton = "//*[@id='btnOK']";
	String ExpendAsset = "//*[@data-ig='x:uwtDN.4:adr:0.0']/img[2]";
	
	String Applybutton_AtSBUWindow = "//*[@id='btnOk']"; 
	String SelectButton ="SELECTBUT";
	String GeneralTab = "//span/span[contains(text(),'General')]";
	String DetailsTab = "//span/span[contains(text(),'Details')]";
	String Save = "//a/span[contains(text(),'Save')]";
	String DetailsTabSaveBtn ="DetailsTab1_btnsaveDetails";
	String SaveButton ="btnSelect";
	String LocTextName = "txtName";
	String LocFindButton ="btnFind";
	String LocSelectButton ="btnSelect";
	String LocNewButton = "NewBtn";
	String LocAdd = "//*[@id='btnAdd']";
	String LocDelete = "//*[@id='btnRemove']";
	String LocCancel = "//*[@id='btnCancel']";
	String Loc_CancelButton = "//input[@value= 'Cancel']";
	String LocCancel_UseWithNameAttribute = "btnCancel";
	String LocErrorMgs = "//*[@id='lblMsg']";
	String loc_Agreement ="//*[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[1]";
	String loc_AuditTrail = "//*[@id='PlainTopMenu1_MainMenu_4']/div/ul//li/a/span[text()='Audit Trail']";
	String loc_SubMenu = "//*[contains(@id,'PlainTopMenu1_MainMenu')]/div/ul//li/a/span[text()='@var']";
	String loc_FindButton = "btnFind";
	String Loc_SearchButton = "btnFindNow";
	String loc_AssetStatus = "//*[@id='ddlAssetStatus']";
	String Loc_ClearSearch = "//*[@id='btnClearSearch']";
	String Loc_SelectAll = "//*[@id='btnSelectAll'] | //*[@id='PageContent_pkList_btnSelectAll']";
	String Loc_Navigator = "//a/span[contains(text(),'Navigator')]";
	String loc_OkButton = "btnOK";
	String Loc_Episode101 = "//a[contains(text(),'Ep.101: Episode101')]";
	String Loc_Episode102 = "//a[contains(text(),'Ep.102: Episode102')]";
	String Loc_AKACheckBox = "chkAKA";
	String Loc_ExactMatchCheckBox = "chkExactMatch";
	String loc_Edit 			= "btnEdit";
	String loc_Copy = "//*[@id='btnCopy']|//*[@id='Button1']";
	String loc_Copy1 = "//*[@id='btnClientCopy']";
	//*[@id='PageContent_pkList_btnSelectAll']
	
	String loc_Delete = "//*[@id='btnDelete']";
	String loc_Save = "//*[@id='btnSave']";
	String loc_Save_UseWithNameAttribute = "btnSave";
	String loc_Cancel = "//*[@id='btnCancel']|//*[@id='btnClose']";
	String loc_CancelButtonAtAlert = "btn_RL_Confirm_Cancel";
	String LocPremiereTab = "//span/span[contains(text(),'Premiere')]";
	String Loc_EditButton = "//*[@id='btnEdit']";
	String Loc_NewButton = "//*[@id='btnNew']|//*[@id='btn_New']";
	String Loc_ErrorMsg = "//*[@id='divMsg']";
	String Loc_DealName = "//*[@id='txtDealName']";
	String Loc_Toggle = "//*[@id='ToggleImagebtn']";
	String Loc_LinkAsset = "btnLinkAsset";
	String Loc_ApplyButton = "//*[@id='PageContent_tList1_btnOk']";
	String Loc_ExpandAll = "//*[@id='PageContent_tList1_btnExpandAll']";
	String Loc_CollapseAll = "//*[@id='PageContent_tList1_btnCollapseAll']";
	String loc_SelectAll1 = "//*[@id='PageContent_tList1_btnSelect']";
	String Loc_DeselectAll = "//*[@id='PageContent_tList1_btnDeSelect']";
	String Loc_DisplaySeasoncheckBox = "//*[@id='cbDispSeasons']";
	String Loc_Cancel = "//*[@id='Cancel']";
	String Loc_ConfirmCancel = "//*[@id='btn_RL_Confirm_Cancel']";
	String Loc_EditButton1 = "btnTitlesEdit";
	String Loc_EditButton2 = "//*[@id='pnlEdit']/input";
	String loc_AssetNavigater = "//*[@data-ig='x:uwtAssets.3:mkr:dtnContent']";
	String Loc_AddSeason = "//*[@title='Add Season']";
	String Loc_AddSeason1 = "//*[@id='uwToolBar']/div/ul/li[5]/a/img";
	String Loc_AddEpisode = "//*[@title='Add Episode']";
//	String Loc_AddEpisode2 = "//*[@title='uwToolBar']/div/ul/li[5]/a/img";
	String Loc_DeleteButton = "btnDel";
	String Loc_DeleteButton1 = "//*[@id='pnlDelete']/input";
	
	// ****************Common Xpaths from InfragisticsGridIterator***********************//
	 String ModulesXpath = "//a/span[contains(text(),'MODULES')]";
	 String RightsOutXpath = "//a/span[contains(text(),'Rights Out')]";
	 String RightsInXpath = "//a/span[contains(text(),'Rights In')]";
	 String AdministrationXpath = "//a/span[contains(text(),'ADMINISTRATION')]";
	 String ListMaintenanceXpath = "//a/span[contains(text(),'List Maintenance')]";
	 String loc_PageLink = "//a/span[contains(text(),'@var')]";
	 String frameParent1Xpath = "//div[@clientid='RL_SplitterPane_Navigation']";
	 String frameParent2Xpath = "//div[@clientid='RL_SplitterPane_Content']";
	 String frameParent21Xpath = "div[class*='igtab_Office2007BlueTHContent'][style*=visible]";
	 String frameParent3Xpath = "div[id*='WebDialogWindow1'][style*=visible]";
	 String frameParent4Xpath = "div[id*='WebDialogWindow2'][style*=visible]";
	 String frameParent5Xpath = "div[id*='WebDialogWindow3'][style*=visible]";
	 String frameParent6Xpath = "div[id*='WebDialogWindow4'][style*=visible]";
	 String SearchXpath = "//a/span[contains(text(),'Search')]";
	 String AgreementsXpath = "//a/span[contains(text(),'Agreements')]";
	 String AssetSearchResultRowXpath = "//*[@id='uwgSearchResults']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	 String GridDealSearchResultRow = "//*[@id='uwgSearchResults']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	 String HomeIconXpath = "//*[@id='leftRight']/table/tbody/tr/td[1]/b/a/img";
	 String OKAlertXpath = "//*[@id ='WebDialogWindow_RL_Alert']";
	 String loc_AlertMessage = "//*[@id ='WebDialogWindow_RL_Alert_tmpl_lbl_RL_Alert_Msg']";
	 String OKAlertButtonXpath = "//*[@id='btn_RL_Alert_OK']";
	 String ConfirmAlertXpath = "//*[@id ='WebDialogWindow_RL_Confirm']";
	 String CancelAlertXpath = "btn_RL_Promptt_Cancel";
	 String ConfirmAlertValidationMessgeText= "//*[@id ='WebDialogWindow_RL_Confirm_tmpl_lbl_RL_Confirm_Msg']";
	 String ConfirmAlertButtonXpath 	= "//*[@id='btn_RL_Confirm_OK']";
	 String AlertValidationMessgeText	= "//*[@id='WebDialogWindow_RL_Alert_tmpl_lbl_RL_Alert_Msg']";
	 String PromptAlertValidationMessgeText = "//*[@id='WebDialogWindow_RL_Prompt_tmpl_lbl_RL_Prompt_Msg']";
	 String PromptAlertInputBox			= "//*[@id ='WebDialogWindow_RL_Prompt_tmpl_txt_RL_Prompt_Msg']";
	 String PromptAlertOKButton			= "//*[@id ='btn_RL_Promptt_OK']";
	 String PromptAlertCancelButton		= "//*[@id='btn_RL_Promptt_Cancel']";
	 
	 String ListDealNavigatorDeal 		= "//*[@data-ig='x:uwtDN.3:mkr:dtnContent']";
	 String AssociateWithExitingAsset 	= "//*[@data-ig='x:uwToolBar.1:adr:1']";
	 String AssociateAssetType 			= "//*[@id='lstAssetTypes']";
	 String AssetInAssetNavigator 		= "//*[@data-ig='x:uwtDN.6:mkr:dtnContent']";
	 String AssetNavigatorDeleteButton 	= "//*[@id='uwToolBar']/ul/li[22]/a/img";
	 String loc_AssetAtDealNavigator	= "//*[@id='uwtDN']/ul/li/ul/li/a[contains(@title,'@var')]";
	 String loc_MenuAtDealNavigator 	= "//*[@id='ContextMenu']/ul/li//a/*[@title='@var']";
	 String Loc_Generaltext             = "//*[contains(text(),'@var')]";
	 String Loc_EditButtonCommon        = "//Input[@id='btnEdit' or @id='pnlEdit']";
	 String Loc_ApplyButton1             = "//*[@id='btnApply']";
	 String Loc_DeselectAllButton           = "//*[@id='btnDeselectAll'] | //*[@id='PageContent_pkList_btnUnSelectAll']";
	 String loc_CopyButton               = "//*[@id='btnClientCopy']";
	 String loc_PromptBoxInput = "//input[@id='WebDialogWindow_RL_Prompt_tmpl_txt_RL_Prompt_Msg']";
	 String loc_PromptOkButton = "//*[@id='btn_RL_Promptt_OK']"; 
	 String loc_RI_EditMode_DropDownImage					= "//div[contains(@id,'uwg') and contains(@style,'visibility: visible')]//td/img"; 
	 String RightsInFinanceXpath = "//a/span[contains(text(),'Rights In Finance')]";
	 
	
}

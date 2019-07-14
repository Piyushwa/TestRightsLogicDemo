package locators;

public interface AssetMaintenanceLocators {

	// ****************Locators specific to AM Module_ General Tab***********************//

	// AM Links
	String loc_VMN_PropertySearch = "//a/span[contains(text(),'Property Search')]";
	String loc_AssetTitle = "txtAssetTitle";
	String loc_FindButtonNow = "btnFindNow";
	String loc_AlertButton = "btn_RL_Alert_OK";
	String loc_btnAddAsset = "btnAddAsset";
	String loc_AssetType_New = "//a/span[contains(text(),'@var')]";
	String loc_OwnerChannel_ASTRO = "//select[@id='ddlSourceBusUnit']";
	// AM  IP
	String loc_IPImageIcon = "//*[@id='imgIPName']";
	String loc_IPAndVendorWindowButtonfind = "btnFind"; 
	String loc_IPClear = "//*[@id='imgClearIPName']";
	String loc_IPNameAtIPWindow = "//*[@data-ig='x:uwgSearch.23:adr:0:tag:']/td[2]";
	String loc_IPSelectButton = "btnSelect";
	// Vendor
	String loc_VendorImgIcon = "//*[@id='imgVendor']";
	String loc_VendorNameAtVendorWindow = "//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String loc_VendorAppendReplace_RadioButtons= "//*[@id='form1']/div[3]/table/tbody/tr[4]/td[2]/table";
	String loc_VendorAppendReplace_RadioButton1= "lblOption1";
	String loc_VendorAppendReplace_RadioButton2= "lblOption2";
	String loc_VendorAppendReplace_RadioButton3= "lblOption3";
	String loc_VendorAddWindow_PartyName = "txtCompanyName";

	// SBU window
	String loc_SelectAllCheckBoxSBU 		= "//*[@id='PageContent_pkList_btnSelectAll']";
	String loc_UnSelectAllCheckBoxSBU 		= "//*[@id='PageContent_pkList_btnUnSelectAll']";
	String loc_FirstCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[1]/img[2]";
	String loc_SecondCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[2]/img[2]";
	String loc_ThirdCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[3]/img[2]";
	String loc_FourthCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[4]/img[2]";
	String loc_FifthCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[5]/img[2]";
	String loc_SixthCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[6]/img[2]";
	String loc_EleventhCheckBoxAtSBU 		= "//*[@id='PageContent_pkList_uwTree']/ul/li[11]/img[2]";
	String loc_EigthCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[8]/img[2]";
	String loc_NinthCheckBoxAtSBU 			= "//*[@id='PageContent_pkList_uwTree']/ul/li[9]/img[2]";
	
	String loc_Episode002_AtSBUwindow = "//*[@id='uwtList']/ul/li[1]/ul/li[2]/img[3]";
	

	// AM General tab Labels
	String loc_AssetTypeLabel 			= "lblAssetType";
	String loc_AssetCategory 			= "//*[@id='lblAssetGroup']";
	String loc_AssetTitleLabel 			= "lblAssetTitle";
	String loc_IPName 					= "//*[@id='lblIPName']";
	String loc_ProjectIDLabel 			= "lblProjectID";
	String loc_SeriesTitleLabel 		= "//*[@id='lblSeriesTitle']";
	String loc_VendorLabel 				= "//*[@id='lblVendor']";
	String loc_StudioLabel 				= "//*[@id='lblStudio']";
	String loc_SourceBusinessUnitLabel 	= "//*[@id='lblSBU']";
	String loc_DurationLabel 			="//*[@id='lblDuration']";
	String loc_ShortName 				= "//*[@id='lblShortName']";
	String loc_AssetSourceLabel 		= "//*[@id='lblAsset_Source']";
	String loc_InternalCheckBoxLabel 	= "//*[@id='lblInternal']";
	String loc_NonAirableCheckBoxLabel 	= "//*[@id='lblNonAirable']";
	String loc_TBACheckBoxLabel 		= "//*[@id='lblChkInPSUsageRpt']";
	String loc_DelivaryDateLabel 		="//*[@id='wdcDateDelivery']";
	String loc_DelivaryDatefield 		="//*[@id='wdcDateDelivery']/tbody/tr/td[1]/input";
	String loc_SeasonDropDown 			= "//*[@id='lstSeason']";
	String loc_AssetHierarchyDropDown 	= "//*[@id='lstAssetHierarchy']";
	String loc_ClientGroupDropDown 		= "//*[@id='lstClientGroup']";
	String loc_AssetDataStatusDropDown 	= "//*[@id='lstAssetDataStatus']";
	String loc_AssetIDVal 				= "//*[@id='lblAssetIDVal']";
	String loc_StudioImageIcon 			= "//*[@id='imgStudio']";
	String loc_GenreAddbutton 			="//*[@id='btnGenreAdd']";
	String loc_ActualRuntime 			= "lblAcRuntime";
	String loc_SBUImage 				= "//*[@id='imgSBU']";
	String loc_Gadget 					= "//*[@id='GadgetImage']";
	String loc_ClearVendor				= "//*[@id='pnlImgClearVendor']";
	String loc_IPName_AT_IPWindow 		= "//*[@data-ig='x:uwgSearch.23:adr:0:tag:']/td[2]";
	//  AM_General  Tool Bar Buttons
	String loc_Next_GeneralTab = "//*[@id='uwtToolbar']//span[@title='Next Asset']";

	String loc_AstGrp 			= 	"lblAssetGroup";
	String loc_Venue 			= 	"lblVenue";
	String loc_Teams 			= 	"lblTeams";
	String loc_MatchCategory 	= 	"lblMatchCategory";
	String loc_RoundOfSeries 	= 	"lblRoundOfSeries";
	String loc_AssetCategory2 	= 	"lblAssetCategory";

	String loc_CreationDate 	= "lblCreationDate";
	String loc_LangOfOrigin	= "lblLangOfOrigin";
	String loc_Length			= "lblLength";
	String loc_MpaaRat			= "lblMpaaRat";
	String loc_TVRating 		= "lblTVRating";
	String loc_CountryOrigin	= "lblCountryOrigin";


	// Asset Navigator
	// Episode Name is like : Ep.202: Episode202
	// Series Name is like : Season 2.Original Version
	String loc_AssetNavigatorWindow_SeriesName_OR_EpisodeName = "//*[@id='uwtAssets']//a[text()='@var']";

	// AM_Episode
	//// All Labels and Buttons
	String loc_EditButtonEpisodes = "btnTitlesEdit";
	String loc_EpisodeAdd = "btnAdd";
	String loc_EpisodeAddWindow = "WebDialogWindow_RL_Prompt_tmpl_txt_RL_Prompt_Msg";
	String loc_EpisodeAddOKbutton = "btn_RL_Promptt_OK";
	String loc_Episode_EditEpisode_DataRow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String loc_Episode_Pass_RowAndColumnNumber = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@row]/td[@col]";
	String loc_Episode_Pass_RowAndHeaderNumber_To_SelectRow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@row]/td[@col]";
	String loc_Episode_SelectRow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@row]/th";
	String loc_SeasonField_OF_RowNumber = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/td[4]";
	String loc_EpisodeEditWindow_DropDownimage = "//*[@id='uwgEpisodes_EditorControl1' or @id='uwgEpisodes_ctl00']/div/table/tbody/tr/td[2]/img";


	String loc_SelectSeason = "//a[contains(text(),'@var')]";
	String loc_EpisodesWindowSave = "//*[@id='btnSave']";
	String loc_EpisodesWindowClose = "//*[@id='btnClose']";
	String loc_AssetStatusLabel = "//*[@id='lblAssetStatus']";
	String loc_AssetFormat = "lblAssetFormat";
	String loc_ViewedLabel = "//*[@id='lblViewed']";
	String loc_DeliveryDateLabel = "//*[@id='lblDelivDate']";
	String loc_SeasonLabel = "//*[@id='lblSeason']";
	String loc_AssetHierarchy = "//*[@id='lblAssetHierarchy']";
	String loc_AssetDataStatus = "//*[@id='lblAssetDataStatus']";
	String loc_UniqueEpi = "//*[@id='lblUniqueEpi']";
	String loc_ClientGroup =  "//*[@id='lblClientGroup']";
	String loc_GroupAssociation = "//*[@id='lblGroupAssociation']";
	String AM_EpisodeColumnXpath = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr[2]/th";
	String loc_Episodes_EditEpisodes = "//*[@id='pnlEditEp']/input";
	String loc_Episodes_Edit = "//*[@id='pnlEdit']/input";
	String loc_Episodes_Filter1 = "//*[@id='lblFilter1']";
	String loc_Episodes_Filter2 = "//*[@id='lblFilter2']";
	String loc_Episodes_ClearFilter = "btnClearFilter";
	String loc_Episodes_CopyEpisodes = "//*[@id='btnCopyEpisode']";
	String loc_Episodes_CopySeason = "//*[@id='btnCopySeason']";
	String loc_Episodes_UpdateTool = "//*[@id='btnUpdateTool']";
	String loc_Episodes_Add = "//*[@id='btnAdd']";
	String loc_Episodes_Delete = "//*[@id='btnDel']";
	String loc_Episodes_Save = "//*[@id='btnSave']";
	String loc_Episodes_Close = "//*[@id='btnClose']";
	String loc_Episodes_AddEpisodes = "//*[@id='btnAddEpisodes']";
	String loc_Episodes_Filter1DropDown = "//*[@id='drpSeason']";
	String loc_Episodes_Filter_DeselectAllCheckBox = "//*[@id='btnDeselectAll']";
	String loc_Episodes_MultiSelectSeason_CheckBox1= "//*[@data-ig='x:uwtList.2:mkr:check']";
	String loc_Episodes_MultiSelectSeason_CheckBox2= "//*[@data-ig='x:uwtList.5:mkr:check']";
	String loc_Episodes_MultiSelectSeason_ApplyButton= "btnApply";
	String loc_Episodes_EditEpisodes_RecordDetails= "//*[@id='lblRecordCount']";
	String loc_Episodes_EditEpisodes_PageSelector= "//*[@id='drpPages']";
	//Asset Navigator
	String Loc_AssetNavigatorAppliesto = "//*[@id='lblName']";
	String Loc_AssetNavigatorSeasonName1 = "//*[@id='lblGivenName']";
	String Loc_AssetNavigatorSeasonName2 = "//*[@id='Label1']";
	String Loc_AssetNavigatorVMID = "//*[@id='lblVMID']";
	String Loc_AssetNavigatorRightsVersionType = "//*[@id='lblRightsVersion']";
	String Loc_AssetNavigatorSave = "//*[@id='btnSave']";
	String Loc_AssetNavigatorCancel = "//*[@id='btnCancel']";
	String Loc_AssetNavigatorAddSeason = "//a/span[contains(text(),'Add Season')]";
	String Loc_SeasonNameDropDown = "//*[@id='cmbVolumeSeason']";
	String Loc_SeasonName = "//*[@id='txtUserDefinedName']";
	String Loc_VMIDInput = "//*[@id='txtVMID']";
	String Loc_RightsVersionTypeDropDown = "//*[@id='lstRightsVersion']";
	String Loc_RightsVersionTypeOriginalVersion = "//div/ul/li/ul/li/a[contains(text(),'RSG.Original Version')]";
	String Loc_Season1 = "//a[contains(text(),'Season 1.')] | //a[text()='Season 1']";
	String Loc_Season2 = "//a[contains(text(),'Season 2.')] | //a[text()='Season 2']";
	String loc_AssetNavigatorEpisodeNumber = "//*[@id='lblEpisodeOrder']";
	String loc_AssetNavigatorInitialAirDate = "//*[@id='lblInitialAirDate']";
	String Loc_AddEpisode1  = "//a/span[contains(text(),'Add Episode')]";
	String Loc_EpisodeNumberInput = "//*[@id='txtEpisodeOrder']";
	String Loc_InitialAirDateInput = "//*[@id='dtInitialAirDate']/tbody/tr/td[1]/input";
	String loc_Episode103 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.103: Episode103')]";
	String Loc_EditSeason = "//*[@alt='Edit Season']";
	//String Loc_EditSeason1 = "//*[@id='uwToolBar']/div/ul/li[3]/a/img";
	
	String Loc_EditEpisode = "//a/span[contains(text(),'Edit Episode')]";
	String Loc_AddEditEEpisode  = "//a/span[contains(text(),'Add/Edit Episodes')]";                       
	String loc_Episode104 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.104: Episode104')]";
	String Loc_DeleteEpisode = "//a/span[contains(text(),'Delete Episode')]";
	String Loc_Episode001 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.1: Episode001')]";
	String Loc_Episode002 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.2: Episode002')]";
	String Loc_Episode003 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.3: Episode003')]";
	String Loc_Episode004 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.4: Episode004')]";
	String Loc_Episode005 = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.5: Episode005')]";
	String Loc_SelectEpisode005 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/th";
	String Loc_Season3 = "//a[contains(text(),'Season 3.')] | //a[text()='Season 3']";
	String Loc_Season4 = "//a[contains(text(),'Season 4.')] | //a[text()='Season 4']";
	String loc_EditSeason = "//a/span[contains(text(),'Edit Season')]";
	String Loc_DeleteSeason = "//a/span[contains(text(),'Delete Season')]";
	String Loc_AddStandalone = "//a/span[contains(text(),'Add Standalone')]";
	String Loc_OneOff ="//*[@data-ig='x:uwtAssets.6:mkr:dtnContent']"; 
	String HomeIcone = "//*[@id='leftRight']/table/tbody/tr/td[1]/b/a/img";
	String SeriesTitleInput = "//*[@id='txtSeriesTitle'] | //*[@id='txtAssetTitle']"; 	
	String Epi3Row = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[4]";
	String Epi4Row = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[4]";
	String Oneoff = "//div/ul/li[2][contains(@class, 'BlueMenuItemHorizontalRootDisabled')]";
	String loc_Appliesto = "//*[@id='lblVolSeaSeriesName']";
	String Loc_EpisodeAAA1 = "//a[contains(text(),'Ep.111: AAA')]";
	String Episode001 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[2]";
	String Episode002 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";
	String Episode003 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[2]";
	String Episode004 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[2]";
	String Episode005 = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td[2]";
	//// Update Tool
	String loc_Episodes_UpdateTool_TBAValueCheckBox  		= "//input[@id='chkCopyTBA']/following-sibling::label";
	String loc_Episodes_UpdateTool_SeasonCheckBox  			= "//input[@id='chkCopySeason']/following-sibling::label";
	String loc_Episodes_UpdateTool_DurationValueCheckBox  	= "//input[@id='chkCopyDuration']/following-sibling::label";
	String loc_Episodes_UpdateTool_EpisodeHeader  = "//*[@id='pnlOption2']/fieldset/legend";
	String loc_Episodes_UpdateTool_UpdateEpisodeTitle  = "//*[@id='pnlOption2']//span/label[@for='chkUpdateTitle']";

	String loc_Episodes_UpdateTool_TitleLabel  = "//*[@id='lblTitle']";
	String loc_Episodes_UpdateTool_TitleField  = "//*[@id='txtEpisodeTitle']";


	//// Copy Episodes
	String loc_Episodes_CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton  = "//*[@id='lblOption1']";
	String loc_Episodes_CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton  = "//*[@id='lblOption2']";
	String loc_Episodes_CopyEpisodes_CopyAssetWindow_Versionselector  = "//*[@id='lstRVType']";


	///// All Fields and input Fields
	String loc_Episodes_ViewModeHeader = "//*[@id='uwgTitles']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String loc_Episodes_ViewModeDataRow = "//*[@id='uwgTitles']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div/table/tbody/tr";
	String loc_Episodes_EpisodesNumber_InputField = "//*[@id='uwgEpisodes_ed0']/input";
	String loc_Episodes_InitialAirDate_InputField = "//*[@data-ig ='x:1107341110.0:mkr:3']";
	String loc_Episodes_InitialAirDate_InputField_VMN = "//*[@id='EditorControl1']/tbody/tr/td[1]/input";
	String loc_Episodes_AiringDate_InputField = "//*[@id='uwgEpisodes_EditorControl2' or @id='uwgEpisodes_ctl01']";
	String loc_Episodes_NoteImageIcon = "//table/tbody/tr[1]//img[@alt='Notes']";
	String loc_Episodes_Episodesfields_ViewMode = "//table[@data-ig='x:uwgTitles.5:mkr:dataTbl.hdn']/tbody/tr[@row]/td[@col]";
	String loc_Episodes_AssetID_ViewMode = "//table[@data-ig='x:uwgTitles.5:mkr:dataTbl.hdn']/tbody/tr[1]/td[11]";
	String loc_Episodes_AssetID_OR_SourceSystem__ViewMode = "//table[@data-ig='x:uwgTitles.5:mkr:dataTbl.hdn']/tbody/tr[1]/td[12]";
	String loc_Episodes_SourceSystem_ViewMode = "//table[@data-ig='x:uwgTitles.5:mkr:dataTbl.hdn']/tbody/tr[1]/td[13]";
	////Episodes TAB : Add Window
	String loc_Episodes_AddEpisodesWindowMessage = "WebDialogWindow_RL_Prompt_tmpl_lbl_RL_Prompt_Msg";
	String loc_Episodes_OKButton_AddEpisodesWindow = "//*[@id='btn_RL_Promptt_OK']";
	String loc_Episodes_Cancel_AddEpisodesWindow = "//*[@id='btn_RL_Promptt_Cancel']";
	String loc_Episodes_FirstRow_EpisodesEditWindow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[2]";
	String loc_Episodes_SelectRow_Of_Episodes ="//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[text()='@var']/../th";
	String loc_Episodes_SeasonField_EpisodesEditWindow = "//table[@data-ig='x:1323401759.5:mkr:dataTbl.hdn']/tbody/tr[1]/td[4]";
	String loc_Episodes_SeasonFieldDropDown_EpisodesEditWindow =  "//*[@id='uwgEpisodes_EditorControl1']/div/table/tbody/tr/td[2]/img";
	//// Edit Season fields
	String loc_Episodes_EditSeason_SeriesTitle = "//*[@id='form1']/div[3]/table/tbody/tr[2]/td[1]";
	String loc_Episodes_EditSeason_userDefinedLabel = "//*[@id='form1']/div[3]/table/tbody/tr[3]/td[1]";
	String loc_Episodes_EditSeason_userDefined_InputField = "//*[@id='txtSeason']";
	////RightVersion FOR VMN
	String loc_Episodes_EditEpisodes_Userdefined_EditSeasonLabel = "//*[@id='lblRightVersionType']";
	String loc_Episodes_EditEpisodes_Userdefined_EditSeasonDropDown = "//*[@id='lstRightsVersion']";




	String loc_EpisodeEditWindow_InputField = "[@id='uwgEpisodes_EditorControl1' or 'uwgEpisodes_ctl00']/div/table/tbody/tr/td[1]/input";

	// AM General tab Fields and Dropdowns
	String loc_AssetTypeDropDown = "//*[@id='lstAssetType']";
	String loc_AssetTypeDropDown_VMN = "//*[@id='cmbAssetType']"; // For VMN 
	String loc_IPAndVendorWindowfield  ="txtName";//txtVendor
	String loc_VendorfieldAt_VendorWindow  ="txtName";
	String loc_AssetTitleField = "//*[@id='txtAssetTitle' or @id='txtDealName']";
	String loc_DurationField = "//*[@id='WMEDuration']";
	String loc_ActualrunTime_InputField = "//*[@id='WMEAcRuntime']";
	String loc_AssetStatusDropDown = "//*[@id='lstAssetStatus']";
	String loc_AssetFormatDropDown = "//*[@id='lstAssetFormat']";
	String loc_AssetSource = "//*[@id='lstAsset_Source']";
	String loc_AssetCategoryDropDown = "//*[@id='lstAssetGroup']";
	String loc_ShortNameField = "//*[@id='txtShortName']";
	String loc_ProjectIDField = "//*[@id='txtProjectID']";
	String loc_AssertCreationValidationMessage ="//*[@id='lblMsg']";
	String loc_CheckInternalCheckBox ="//*[@id='chkInternal']";
	String loc_SBUField = "//*[@id='lstSBU']"; 
	String loc_IPfield = "txtIPName";
	String loc_Vendorfield = "txtVendor";
	String loc_Studiofield = "txtStudio";
	String loc_AssetTypeDropDownAtAssetSearch = "//select[@id='lstAssetTypes']";
	String loc_AssetTypeID ="//*[@id='lblAssetIDVal']";

	// Genre Window
	String loc_GenreHeader 	= "//*[@id='uwgGenre']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String loc_GenreDataRow 		= "//*[@id='uwgGenre']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String loc_GenreTypeRow = "//*[@data-ig='x:a0']/td[2]";
	String loc_GenreTypeRow2 = "//*[@data-ig='x:a1']/td[2]";
	String loc_GenreTypeRowImageDropdown = "//*[@id='uwgGenre_ctl00']/div/table/tbody/tr/td[2]/img";
	String loc_FirstGenreTypeDropDownValue = "//*[@id='form2']/div[4]/div/ul/li[1]";
	String loc_GenreRow = "//*[@data-ig='x:a0']/td[3]";
	String loc_GenreRow2 = "//*[@data-ig='x:a1']/td[3]";
	String loc_Genre = "//*[@id='uwgGenre_ctl01']/div/table/tbody/tr/td[2]/img";
	String loc_FirstGenreDropDownValue = "//*[@id='form2']/div[5]/div/ul/li[1]";
	String loc_SelectGenreCompleteRow = "//*[@id='uwgGenre']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String loc_DeleteGenre = "btnGenreRemove";

	// Asset Note
	String loc_AddNote = "btnNew";
	String loc_NotePriority = "//*[@id='ddlPriority']";
	String loc_NoteSubject = "//*[@id='txtSubject']";
	String loc_NoteBody = "//*[@id='txtNotes']";
	String loc_NoteCompleteRow = "//*[@id='uwgNotes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String loc_RemoveNoteIcon = "//*[@id='btnRemove']";
	String loc_VMNSearchCritariaBox ="//*[@id='TR_Asset_Search_Params']/td";
	String loc_AssetSearchUnderSearch = "//li[not(contains(@class,'Disabled'))]/a/span[contains(text(),'Assets')]  | //li[not(contains(@class,'Disabled'))]/a/span[contains(text(),'Titles')]";
	
	// Program Summary
	String loc_ProgramSummaryHeader = "//*[@id='lblProgramSummary']";
	String loc_SourceIDField  =  "//*[@id='txtPDSVal']";
	String loc_SourceIDField_VMN  =  "//*[@id='txtSSIVal']";
	String loc_AssetTypeAtProgramSummary = "//*[@id='txtAssetSourceVal']";
	String loc_CastORContacts = "//*[@id='txtCastVal']";
	String loc_PremierDateAtProgramSummary = "//*[@id='txtPremierDate']";
	String loc_TotalHoursProgramSummary = "//*[@id='txtTotHoursVal']";
	String loc_HDAvail = "//*[@id='txtHDAvail']";

	// Asset Search 
	String loc_SearchedAsset = "//*[@id='uwgSearchResults_DXDataRow0']/td[2]";
	//String loc_SearchedAsset1 = "//*[@id='uwgSearchResults_DXDataRow0']/td[3]";
	String loc_SearchedAssetByText = "//*[@id='uwgSearchResults_DXDataRow0']/td[text()='@var']";
	String loc_SearchedAssetDetails = "//*[contains(@id,'uwgSearchResults_DXDataRow')]/td[text()='@var']";
	String loc_TotalRecords = "lblCount";
	String loc_PaginationDropDown = "//*[@id='uwgSearchResults_DXPagerBottom_DDBImg']";
	String loc_PageDropDownValue = "//*[@id='uwgSearchResults_DXPagerBottom_PSP_DXI1_T']/span[text()='100']";
	String loc_ViewAsset = "SELECTBUT";
	String loc_CreatedAssetAtHome = "//*[@id='leftRight']/table/tbody/tr/td[1]/b/span | //*[@id='LeftHeaderContent_LitLeftHeader']/span/b";
	String loc_CreatedAssetAtHomeLink = "//*[@id='leftRight']/table/tbody/tr/td[1]/b/a";
	String loc_AssetSearchWindowName = "//*[@id='leftRight']/table/tbody/tr/td[1]/b";
	String loc_AssetType_AllCheckBox ="//*[@id='cbSelectAll']";
	String loc_InitialAirDate_EpisodeWindow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[@var]/td[10]";
	String loc_InitialAirDatefield_EpisodeWindow = "//*[@data-ig='x:1107341110.0:mkr:3']";
	String loc_TBD_EpisodeWindow = "//*[@id='uwgEpisodes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[9]";

	// Labels Search Fields
	String loc_ExpandAdvancedSearchIcon = "//*[@id='ExpandToggleImagebtn']";
	String loc_AssetIDLabel = "lblAssetID"; 	
	String loc_Asset_RightsVersionTypeLabel = "lblRightsVersionType";
	String loc_Asset_SourceBusUnitLabel = "lblSourceBusUnit";
	String loc_Asset_GenreLabel = "lblGenre";
	String loc_Asset_SourceLabel = "//*[@id='lblAssetSource']";
	String loc_Asset_ArtistLabel = "lblArtist";
	String loc_Asset_ComposerLabel = "lblComposer";
	String loc_Asset_DataEntryStatusLabel = "lblAssetDataEntryStatus";
	String loc_Asset_MMLDataEntryStatusLabel = "lblMMLDataEntryStatus";
	// Asset Search Labels of Advanced Search Fields
	String loc_Asset_AttributesLabel = "lblAttributes";
	String loc_Asset_ContributorLabel = "lblContributor";
	String loc_Asset_ContributorRoleLabel = "lblContributorRole";
	String loc_Asset_CharacterLabel = "lblCharacter";
	String loc_Asset_AirNetBusUnitLabel = "lblAirNetBusUnit";
	String loc_Asset_PremiereDatesLabel = "lblPremiereDates";
	String loc_Asset_DurationFromLabel = "lblDurationFrom";
	String loc_Asset_GuildAssociationLabel = "lblGuildAssociation";
	String loc_Asset_KeywordLabel = "lblKeyword";
	String loc_Asset_MMLClearanceLevelLabel = "lblMMLClearanceLevel";
	String loc_Asset_InternationalAmortizationLabel = "lblInternationalAvailabilityDate";
	// Asset Search Labels of Check Boxes
	String loc_AssetSearch_AKA = "//input[@id='chkAKA']/following-sibling::label";
	String loc_Asset_DispSeasonsCheckBoxLabel = "//input[@id='cbDispSeasons']/following-sibling::label";
	String loc_Asset_DispEpisodesCheckBoxLabel="//input[@id='cbDispEpisodes']/following-sibling::label";
	String loc_Asset_SelectAllCheckBoxLabel = "//input[@id='cbSelectAll']/following-sibling::label";
	String loc_Asset_SearchEarliestPremiereCheckBoxLabel = "//input[@id='chkSearchEarliestPremiere']/following-sibling::label";
	String loc_Asset_IncludeDeletedCheckBoxLabel = "//input[@id='chkIncludeDeleted']/following-sibling::label";
	String loc_Asset_CheckRelatedAssetLabel = "//input[@id='chkCheckRelatedAsset']/following-sibling::label";
	String loc_Asset_ExactMatchCheckBoxLabel = "//input[@id='chkExactMatch']/following-sibling::label";
	// Asset Search Input Check Boxes
	String loc_AssetSearch_AKA_CheckBox = "//input[@id='chkAKA']";
	String loc_Asset_DispSeasonsCheckBox_CheckBox = "//input[@id='cbDispSeasons']";
	String loc_Asset_DispEpisodesCheckBox_CheckBox ="//input[@id='cbDispEpisodes']";
	String loc_Asset_SelectAllCheckBox_CheckBox = "//input[@id='cbSelectAll']";
	String loc_Asset_SearchEarliestPremiereCheckBox_CheckBox = "//input[@id='chkSearchEarliestPremiere']";
	String loc_Asset_IncludeDeletedCheckBox_CheckBox = "//input[@id='chkIncludeDeleted']";
	String loc_Asset_CheckRelatedAsset_CheckBox = "//input[@id='chkCheckRelatedAsset']";
	String loc_Asset_ExactMatchCheckBox_CheckBox = "//input[@id='chkExactMatch']";

	// Asset Search Labels of Advanced Search Fields
	String loc_AssetSearch_ContactRole_inputField = "//select[@id='ddlContributorRole']";
	// Asset Search Buttons
	String loc_AssetSearch_btnClearSearchButton = "btnClearSearch";
	String loc_AssetSearch_btnSaveSearchButton = "btnSaveSearch";
	String loc_AssetSearch_btnRestoreSearchButton = "btnRestoreSearch";

	// Asset Search SaveSearch POP-UP
	String loc_AssetSearch_SaveSearch_ScopeLegend = "//*[@id='grpRadio']/legend";
	String loc_AssetSearch_SaveSearch_SaveForLocalRadioButton = "//*[@id='grpRadio']/div/table/tbody/tr[1]/td[1]/span/label";
	String loc_AssetSearch_SaveSearch_SaveForGlobalRadioButton = "//*[@id='grpRadio']/div/table/tbody/tr[1]/td[2]/span/label";
	String loc_AssetSearch_SaveSearch_OptionsLegend = "//*[@id='WebGroupBox1']/legend";
	String loc_AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton = "//*[@id='WebGroupBox1']/div/table/tbody/tr[1]/td/span/label";
	String loc_AssetSearch_SaveSearch_SaveAsNewSearchRadioButton = "//*[@id='WebGroupBox1']/div/table/tbody/tr[2]/td/span/label";
	String loc_AssetSearch_SaveSearch_SaveAsNewSearch_InputField = "//*[@id='WebGroupBox1_txtFileName']";

	// Asset Search RestoreSearch POP-UP
	String loc_AssetSearch_RestoreSearch_SearchLegend = "//*[@id='wgbSearch']/legend";
	String loc_AssetSearch_RestoreSearch_SearchForLocalRadioButton = "//*[@id='wgbSearch']/div/table/tbody/tr/td/span[2]/label";
	String loc_AssetSearch_RestoreSearch_SaveForGlobalRadioButton = "//*[@id='wgbSearch']/div/table/tbody/tr/td/span[3]/label";
	String loc_AssetSearch_RestoreSearch_ResultsLegend = "//*[@id='wgbResults']/legend";
	String loc_AssetSearch_RestoreSearch_Results_ColumnHeader = "//*[@id='uwgSearchResults_columnheader_1']";
	String loc_AssetSearch_RestoreSearch_Results_SearchedAsset = "//*[@id='wgbResults_uwgSearchResults']//tr/td[contains(text(),'@var')]";
	String loc_AssetSearch_RestoreSearch_SearchField = "//*[@id='wgbSearch_txtSearchFor']";
	String loc_AssetSearch_RestoreSearch_Results_RestoreButton = "btnRestore";
	String loc_AssetSearch_RestoreSearch_LocalRadioButton = "//*[@id='wgbSearch_rbLocal']";
	String loc_AssetSearch_RestoreSearch_GlobalRadioButton = "//*[@id='wgbSearch_rbGlobal']";
	String loc_AssetSearch_RestoreSearch_SearchButton = "//*[@id='wgbSearch_btnSearch']";





	// Column's Header of the Search Assets
	String loc_AssetSearch_ColumnName = "//*[contains(@id,'uwgSearchResults_col')]/table/tbody/tr/td[text()='@var']";
	String loc_ExpandAssetDetail_At_AssetSearchGrid = "//*[@id='uwgSearchResults_DXDataRow0']/td[1]/img";
	// Replace @var with Season name
	String loc_ExpandSeason_At_AssetSearchGrid = "//tr[contains(@id,'uwgSearchResults_dxdt0_Season')]/td[@title='@var']/../td/img";
	String loc_Season_AssetSearchGrid = "//tr[contains(@id,'uwgSearchResults_dxdt0_Season')]/td[@title='@var']";
	// Series Episode Window Update
	String loc_AllAssociatedEpisodes = "//*[@id='form1']/table/tbody/tr[3]/td[2]/label";
	String loc_DoNotChangeEpisodeData = "//*[@id='form1']/table/tbody/tr[4]/td[2]/label";
	String loc_ApplyChangesToSelectedEpisodes = "//*[@id='form1']/table/tbody/tr[5]/td[2]/label";
	String loc_SelectAll ="//*[@id='btnSelectAll']";
	String loc_CancelButton = "//*[@id='btnCancel']";

	// AssetTitleWindow
	String loc_AssetTitleImageIcon = "//*[@id='img_Validate']";
	String loc_TitleHeader_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_1']";
	String loc_AKATitles_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_2']";
	//String loc_TitleHeader_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_3']";
	String loc_AssetTypeHeader_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_4']";
	String loc_ReleaseYr_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_5']";
	String loc_Director_Artist_AssetTitleWindow = "//*[@id='uwgAssets_columnheader_6']";
	String loc_SaveButton_AssetTitleWindow ="//*[@id='igtbl_reOkBtn']";
	String loc_CancelButton_AssetTitleWindow = "//*[@id='btnCancel']";
	String loc_AssetTitleWindowBox = "//*[@id='uwgAssets']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]";
	String loc_SearchedStudio = "//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String loc_ClearStudioImage = "//*[@id='imgClearStudio']";
	String loc_IPAndVendorAndStudioWindowHeader ="//div[@id='WebDialogWindow2' or @id='WebDialogWindow1']/div/table/tbody/tr/td[2]/span";


	// ****************Locators specific to AM Module_details Tab***********************//

	//AM_Details
	
	
	
	String loc_AM_Details_ColumnXpath_ViewMode 				                 = "//table/tbody/tr[1]/td/div[1]/table/tbody/tr[1]/td/table/tbody[1]/tr/td/div/table/tbody/tr//th";	
	String loc_AM_Details_DataRowXpath_ViewMode 			                 = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody//tr";
	
	String Loc_Details_ParentVMID                                            = "DetailsTab1_Group1_lblVMID";
	String Loc_Details_AKA                                                   = "DetailsTab1_Group1_lblAkaTitle";
	String Loc_Details_ShootingFormat                                        = "DetailsTab1_Group1_lblShootingFormat";
	String Loc_Details_DeliveryFormat                                        = "DetailsTab1_Group1_lblDeliveryFormat";
	String Loc_Details_ReleaseYear                                           = "DetailsTab1_Group1_lblReleaseYear";
	String Loc_Details_Publisher                                             = "DetailsTab1_Group1_lblPublisher";
	String Loc_Details_AssetDescription                                      = "DetailsTab1_Group1_lblDescription";
	String Loc_Details_CreditTimeIn                                          = "DetailsTab1_Group1_lblCreditsIn";
	String Loc_Details_TimeOut                                               = "DetailsTab1_Group1_lblCreditsOut";
	String Loc_Details_SynopsisLanguage                                      = "lblLanguage";
	String Loc_Details_CloseCaptioned                                        = "DetailsTab1_Group1_lblCloseCaption";
	String Loc_Details_Dubbed                                                = "DetailsTab1_Group1_lblDubbed";
	String Loc_Details_Subtitled                                             = "DetailsTab1_Group1_lblSubtitled";
	String Loc_Details_Venue                                                 = "DetailsTab1_Group1_lblVenue";
	String Loc_Details_RoundOfSeries                                         = "DetailsTab1_Group1_lblRoundOfSeries";
	String Loc_Details_MatchCategory                                         = "DetailsTab1_Group1_lblMatchCategory";
	String Loc_Details_PlayerCategory                                        = "DetailsTab1_Group1_lblPlayerCategory";
	String Loc_Details_SourceID                                              = "DetailsTab1_Group1_lblAssetId";
	String Loc_Details_SourceSystem                                          = "DetailsTab1_Group1_lblSystem";
	String Loc_Details_FromGrade                                             = "DetailsTab1_Group1_lblFromGrade";
	String Loc_Details_ToGrade                                               = "DetailsTab1_Group1_lblToGrade";
	String Loc_Details_TVParentalRating                                      = "DetailsTab1_Group1_lblNwParentalRating";
	String Loc_Details_RatingWarning                                         = "//*[@id='lblRatingWarning' or @id='DetailsTab1_Group1_lblRatingWarning']";
	String Loc_Details_Keywords                                              = "DetailsTab1_Group1_lblKeywords";
	String Loc_Details_VMID                                                  = "DetailsTab1_Group1_lblSyndication";
	String Loc_Details_MasterAudio                                           = "DetailsTab1_Group1_lblMasterAudio";
	String Loc_Details_Productionno                                          = "DetailsTab1_Group1_lblProduction";
	String Loc_Details_Boxoffice                                             = "DetailsTab1_Group1_lblBoxOffice";
	String Loc_Details_AssetCategory                                         = "DetailsTab1_Group1_lblAssetCategory";
	String Loc_Details_Targetdemography                                      = "DetailsTab1_Group1_lblNwDemographic";
	String Loc_Details_CountryofOriginDropDown                               = "//*[@id='DetailsTab1_Group1_lstCountryOrigin']";
	String Loc_Details_GuildAssociation                                      = "lblGuildAssoc";
	String Loc_Details_Tier                                                  = "DetailsTab1_Group1_lblTier";
	String Loc_Details_InternationalAmortizationDate                         = "DetailsTab1_Group1_lblIPSAvailDate";
	String Loc_Details_SAPMPMID                                              = "DetailsTab1_Group1_lblSAPMPMID";
	String Loc_Details_MPAARating                                            = "DetailsTab1_Group1_lblMPAARating";
	String Loc_Details_CC                                                    = "DetailsTab1_Group1_lblCC";
	String Loc_Details_CopyRightYr                                           = "DetailsTab1_Group1_lblCopyRightDate";
	String Loc_Details_Nudity                                                = "DetailsTab1_Group1_lblNudity";
	String Loc_Details_Violence                                              = "DetailsTab1_Group1_lblViolence";
	String Loc_Details_Sensuality                                            = "DetailsTab1_Group1_lblSensuality";
	String Loc_Details_Commentary                                            = "DetailsTab1_Group1_lblCommentary";
	String Loc_Details_Graphics                                              = "DetailsTab1_Group1_lblGraphics";
	String Loc_Details_Disclaimers                                           = "DetailsTab1_Group1_lblDisclaimers";
	String Loc_Details_AssetTitle1Row                                        = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[2]";
	String Loc_Details_AssetTitle4Row                                        = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[2]";
	String Loc_Details_AKAType1Row                                           = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[3]";
	String Loc_Details_AKAType4Row                                           = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[3]";
	String Loc_Details_AssetTitle1RowInput 	                                 = "//*[@id='uwgAkaTitle_ShortDescription'] | //*[@id='uwgAkaTitle_ed0']/input";
	String Loc_Details_AssetTitleRowInput 	                                 = "//*[@id='uwgAkaTitle_ShortDescription'] | //*[@id='uwgAkaTitle_ed0']/input";
	String Loc_Details_AssetTitle2Row                                        = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[2]";	                                    
	String Loc_Details_AKAType2Row                                           = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]";
	String Loc_Details_AKAType3Row                                           = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[3]";
	String Loc_Details_Networks1Row                                          = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[4]";                                   
	String Loc_Details_Networks2Row                                          = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String Loc_Details_Networks3Row                                          = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[4]";
	String Loc_Details_Networks4Row                                          = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td[4]";
	String Loc_Details_Networks1RowInput                                     = "//*[@id='uwgAkaTitle_EditorControl2']/div/table/tbody/tr/td[1]/input";
	String Loc_Details_AssetTitle3Row                                        = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[2]";
	String Loc_Details_AKATypeInput                                          = "//*[@id='uwgAkaTitle_EditorControl1']/div/table/tbody/tr/td[1]/input";
	String Loc_Details_3Row                                                  = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/th";
	String Loc_Details_ShootingFormatDropDown                                = "//*[@id='DetailsTab1_Group1_lstShootingFormat']";
	String Loc_Details_DeliveryFormatDropDown                                = "DetailsTab1_Group1_lstDeliveryFormat";
	String Loc_Details_ReleasingYearDropDown                                 = "DetailsTab1_Group1_lstReleaseYear";
	String Loc_Details_PublisherImg                                          = "//*[@id='imgPublisher']";
	String Loc_Details_DescriptionTextBox                                    = "DetailsTab1_Group1_txtDescription";
	String Loc_Details_CreditTimeout                                         = "//*[@id='DetailsTab1_Group1_WMECreditsOut']";
	String Loc_Details_LanguageDropDown                                      = "//*[@id='DetailsTab1_Group1_lstLanguage']";
	String Loc_Details_CloseCaptionedDropDown                                = "//*[@id='DetailsTab1_Group1_lstCloseCaptioned'] | //*[@id='DetailsTab1_Group1_lstCloseCaptioned']";
	String Loc_Details_DubbedDropDown                                        = "//*[@id='DetailsTab1_Group1_ddlDubbed']";
	String Loc_Details_SubtitleDropDown                                      = "//*[@id='DetailsTab1_Group1_ddlSubtitled']";
	String Loc_Details_FromGradeDropDown                                     = "//*[@id='DetailsTab1_Group1_lstFromGrade']";
	String Loc_Details_ToGradeDropDown                                       = "//*[@id='DetailsTab1_Group1_lstToGrade']";
	String Loc_Details_TVParentalRating1stRow1Col                            = "//*[@id='uwgTVRating']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[3]";
	String Loc_Details_TVParentalRating1stRow1ColInput                       = "//*[@id='uwgTVRating_EditorControl6']/div/table/tbody/tr/td[1]/input";
	String Loc_Details_ExtensionImg                                          = "//*[@id='DetailsTab1_Group1_uwgTVRating_it4_0_imgNotes']";
	String Loc_Details_ExtensionListSexuality                                = "//*[@id='PageContent_pkList_uwTree']/ul/li[1]/img[2]";
	String Loc_Details_RatingWarningDropDown                                 = "//*[@id='DetailsTab1_Group1_ddlRatingWarning']";
	String Loc_Details_KeywordsPickList                                      = "//*[@id='imgKeyword']";
	String Loc_Details_1stValueSelect                                        = "//table[@data-ig='x:uwgSearch.7:mkr:dataTbl.hdn']/tbody/tr[1]/td[2]";
	String Loc_Details_KeywordsSave                                          = "//*[@id='PageContent_btnSave']";
	String Loc_Details_KeywordsInput                                         = "//*[@id='PageContent_txtName']";
	String Loc_Details_Options3                                              = "//*[@id='RadOption3']";
	String Loc_Details_Options2                                              = "//*[@id='RadOption2']";
	String Loc_Details_Options1                                              = "//*[@id='RadOption1']";
	String Loc_Details_KeywordsDeleteBtn                                     = "//*[@id='img2']";
	String Loc_Details_Keywors1Row                                           = "//*[@id='txtKeywords']/option[1]";
	String Loc_Details_ProductionInput                                       = "//*[@id='DetailsTab1_Group1_txtProduction']";
	String Loc_Details_UniversalIDInput                                      = "//*[@id='DetailsTab1_Group1_txtSyndication']";
	String Loc_Details_MasterAudioDropDown                                   = "//*[@id='DetailsTab1_Group1_lstMasterAudio']";
	String Loc_Details_HDPercentage                                          = "//*[@id='DetailsTab1_Group1_lstHDPercentage']";
	String Loc_Details_HDType                                                = "//*[@id='DetailsTab1_Group1_lstHDType']";
	String Loc_Details_BoxOffice                                             = "//*[@id='imgBoxoffice']";
	String Loc_Details_CountryInput                                          = "//*[@id='uwgBODetail_ctl06']/div/table/tbody/tr/td[1]/input";
	String Loc_Details_Currency1Row                                          = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[3]";
	String Loc_Details_Counry1Row                                            = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[2]";
	String Loc_Details_Year1Row                                              = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	String Loc_Details_Year1RowInput                                         = "//*[@id='uwgBODetail_ctl00']/div/table/tbody/tr/td[1]/input";
	String Loc_Details_ReleaseDate1Row                                       = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[5]";
	String Loc_Details_ReleaseDate1RowInput                                  = "//*[@id='uwgBODetail_EditorControl1']/tbody/tr/td[1]/input";
	String Loc_Details_Estimated1Row                                         = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]";
	String Loc_Details_Estimated1RowInput                                    = "//input[@id='uwgBODetail_ctl02']";
	String Loc_Details_Actual1Row                                            = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]";
	String Loc_Details_Actual1RowInput                                       = "//*[@id='uwgBODetail_ctl03']"; 
	String Loc_Details_WksRpted1Row                                          = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]";
	String Loc_Details_WksRpted1RowInput                                     = "//*[@id='uwgBODetail_ctl04']";
	String Loc_Details_PointsofRel                                           = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[9]";
	String Loc_Details_PointsofRelInput                                      = "//*[@id='uwgBODetail_ctl05']";
	String Loc_Details_AsofDate1Row                                          = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[10]";
	String Loc_Details_AsofDate1RowInput                                     = "//*[@id='uwgBODetail_EditorControl2']/tbody/tr/td[1]/input";
	String Loc_Details_Currencydropdown                                      = "//*[@id='grpTotal_ddlCurrencyTotal']";
	String Loc_Details_BoxOfficeInpput                                       = "//*[@id='DetailsTab1_Group1_txtBoxOffice']";
	String Loc_Details_BoxOffice1stRow                                       = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String Loc_Details_VMIDInput                                             = "//*[@id='DetailsTab1_Group1_txtVMID']";
	String Loc_Details_TierInput                                             = "//*[@id='DetailsTab1_Group1_ddlTier']";
	String Loc_Details_InternationalAmortizationDateInput                    = "//*[@id='DetailsTab1_Group1_dtIPSAvailDate']/tbody/tr/td[1]/input";
	String Loc_Details_SAPMPMIDinput                                         = "//*[@id='DetailsTab1_Group1_txtSAPMPMID']"; 
	String Loc_Details_MPAARatingDropDown                                    = "//*[@id='DetailsTab1_Group1_lstMPAARating']";
	String Loc_Details_CCCheckBox                                            = "//*[@id='DetailsTab1_Group1_chkCC']";
	String Loc_Details_HD                                                    = "//*[@id='DetailsTab1_Group1_lblHD']";
	String Loc_Details_HDCheckABox                                           = "//*[@id='DetailsTab1_Group1_chkHD']";
	String Loc_Details_CopyRightDate                                         = "//*[@id='DetailsTab1_Group1_lblCopyRightDate']";
	String Loc_Details_CopyRightDateDropDown                                 = "//*[@id='DetailsTab1_Group1_lstCopyRightDate']";
	String Loc_Details_NudityCheckBox                                        = "//*[@id='DetailsTab1_Group1_chkNudity']";
	String Loc_Details_Rape                                                  = "DetailsTab1_Group1_lblRape"; 
	String Loc_Details_RapeCheckBox                                          = "DetailsTab1_Group1_chkRape"; 
	String Loc_Details_ViolenceCheckbox                                      = "DetailsTab1_Group1_chkViolence"; 
	String Loc_Details_SensualityCkeckBox                                    = "DetailsTab1_Group1_chkSensuality";
	String Loc_Details_CommentaryCheckBox                                    = "DetailsTab1_Group1_chkCommentary";  
	String Loc_Details_GraphicsCheckbox                                      = "DetailsTab1_Group1_chkGraphics";
	String Loc_Details_DisclaimersInput                                      = "DetailsTab1_Group1_txtDisclaimers";
	String Loc_Details_SynopsisTypeHeder                                     = "//*[@id='DetailsTab1_Group3']/legend";
	String Loc_Details_SynopsisType1Row                                      = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[3]";
		String Loc_Details_SynopsisType2Row                                      = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]";
		String Loc_Details_SynopsisType3Row                                      = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[3]";
	String Loc_Details_DoNOTUseexternally                                    = "lblDNUExtern";
	String Loc_Details_DoNOTUseexternallyCheckBox                            = "//*[@id='chkDNUExtern'][@checked                                                  ='checked']";
	String Loc_Details_Synopsistype                                          = "//*[@id='ddlSynopsisType']";
	String Loc_Details_SynopsistypeInput                                     = "//*[@id='txtSynopsis']";
	String Loc_Details_NetworkDropDown                                       = "//*[@id='ddlNetwork']";
	String Loc_Details_ContributorsClose                                     = "//*[@id='WebDialogWindow2' or @id='WebDialogWindow1']/div[1]/table/tbody/tr/td[3]/img";
	String Loc_Details_Network1Row                                           = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[4]";
	String Loc_Details_Length1Row                                            = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[7]";
	String Loc_Details_CreatedBy1Row                                         = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[10]";       
	String Loc_Details_CretedDate1Row                                        = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[11]"; 
	String Loc_Details_Synopsis1Row                                          = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[12]";
	String Loc_Details_Synopsis2Row                                          = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[12]"; 
	String Loc_Details_ContributorsNetwork                                   = "lstNetwork";
	String Loc_Details_Network2Row                                           = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
	String Loc_Details_Length2Row                                            = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[7]";
	String Loc_Details_CreatedBy2Row                                         = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
	String Loc_Details_CretedDate2Row                                        = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";
	String Loc_Details_Network3Row                                           = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[4]";
	String Loc_Details_Length3Row                                            = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[7]";
	String Loc_Details_CreatedBy3Row                                         = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[10]";
	String Loc_Details_CretedDate3Row                                        = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[11]";
	String Loc_Details_Synopsis3Row                                          = "//*[@id='DetailsTab1_Group3_uwgSynopsis']/table/tbody/tr[1]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[12]";
	String Loc_Details_ReliseYear                                            = "//*[@id='DetailsTab1_Group1_lstReleaseYear']";
	String Loc_Details_ReliseYearDropDown                                    = "//*[@id='DetailsTab1_Group1_lstReleaseYear']";
	String Loc_Details_GuildAssociationDropDown                              = "//*[@id='DetailsTab1_Group1_ddlGuildAssoc']";
	String Loc_Details_Tournament                                            = "//*[@id='DetailsTab1_Group1_lblTournament']";
	String Loc_Details_Teams                                                 = "//*[@id='DetailsTab1_Group1_lblTeams']";
	String Loc_Details_Image                                                 = "//*[@id='DetailsTab1_Group1_lblImage']"; 
	String Loc_Details_AssetSynopsis                                         = "//*[@id='DetailsTab1_Group3']/legend";
	String Loc_Details_Network1                                              = "//*[@id='lblNetwork']";
	String Loc_Details_Source                                                = "//*[@id='lblSource']";
	String Loc_Details_Title                                                 = "//*[@id='lblTitleLessThanN']";
	String Loc_Details_Length                                                = "//*[@id='lblLength']";
	String Loc_Details_SynopsisType                                         = "//*[@id='lblSynopsisType']";
	String Loc_Details_Synopsis1                                             = "//*[@id='lblSynopsis']";
	String Loc_Details_Language1                                             = "//*[@id='lblLanguage' or @id='DetailsTab1_Group1_lblLanguage']";
	String Loc_Details_LanguageTitle1                                        = "//*[@id='lblLangTitle']";
	String Loc_Details_LanguageSeriesTitle1                                  = "//*[@id='lblLangSeriesTitle']";
	String Loc_Details_ViewContributors                                      = "//*[@id='btnViewContrib']";
	String Loc_Details_Radio1                                                = "//*[@id='form1']/table/tbody/tr[3]/td[2]/label";
	String Loc_Details_Radio2                                                = "//*[@id='form1']/table/tbody/tr[4]/td[2]/label";
	String Loc_Details_Radio3                                                = "//*[@id='form1']/table/tbody/tr[5]/td[2]/label";
	String Loc_Details_Season1                                               = "//*[@id='uwtList']/ul/li/a";
	String Loc_Details_Ep1                                                   = "//*[@id='uwtList']/ul/li/ul/li[1]/a";
	String Loc_Details_Ep2                                                   = "//*[@id='uwtList']/ul/li/ul/li[2]/a";
	String Loc_Details_Assect                                                = "//*[@data-ig='x:uwtAssets.3:mkr:dtnContent']";
	String Loc_Details_BoxOffice1Row                                         = "//*[@id='uwgBODetail']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String Loc_Details_Error                                                 = "DetailsTab1_lblMsg";
	String Loc_Details_NetworkImg                                            = "//*[@id='DetailsTab1_Group1_uwgAkaTitle_it4_0_imgNotes']";
	String Loc_Details_NetworkCheckBoxAMCN                                   = "//*[@id='PageContent_pkList_uwTree']/ul/li[7]/img[2]";
	String Loc_Details_NetworkCheckBoxAMCNCanada                             = "//*[@id='PageContent_pkList_uwTree']/ul/li[8]/img[2]";
	String Loc_Details_NetworkCheckBoxAMCNCanadaHD                           = "//*[@id='PageContent_pkList_uwTree']/ul/li[9]/img[2]";
	String Loc_Details_SynopsisNetworkImg                                    = "//*[@id='imgNetwork']";
	String Loc_Details_AMCHD                                                 = "//*[@id='PageContent_pkList_uwTree']/ul/li[11]/img[2]";
	String Loc_Details_1Row                                                  = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/th";
	String Loc_Details_Network_PickListUnchecked                             = "//*[@id='PageContent_pkList_uwTree']//../img[contains(@src,'checkbox_off')]";
	String Loc_Details_Network_PickListChecked                               = "//*[@id='PageContent_pkList_uwTree']//../img[contains(@src,'checkbox_on')]";
	String Loc_Details_SearchIcone                                           = "//*[@id='PlainTopMenu1_MainMenu']/div[1]/ul/li[3]/a/span";
	String Loc_Details_ApplyAll                                              = "rboApplyAll";
	String Loc_Details_AppleySelected                                        = "rboApplySelected";
	String Loc_Details_SourceSystem1                                         = "DetailsTab1_Group1_lblSystemValue";
	String Loc_Details_LengthDropdown                                        = "//*[@id='ddlLength']";
	String Loc_Details_SourceDropdown                                        = "//*[@id='ddlSource']";
 



	// AM General tab Fields and Dropdowns
	String loc_DubbedDropdown  ="//select[contains(@id,'DetailsTab1_Group1') and contains(@id,'Dubbed') ]";


	// AM_Premiere
	String loc_AM_Premiere_ColumnXpath_EditMode 				              = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String loc_AM_Premiere_DataRowXpath_EditMode 			                  = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String loc_AM_Premiere_ColumnXpath_ViewMode 				              = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr//th";	
	String loc_AM_Premiere_DataRowXpath_ViewMode 			                  = "//table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]";
	String Loc_AM_Premiere_1Row                                               = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	String Loc_AM_Premiere_AirNetWorkInput                                    = "//*[@id='uwgPremiere_ctl06']/div/table/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_AirNetWorkInput1                                   = "//*[@id='uwgPremiere_ctl04']/div/table/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_PremiereDateInput                                  = "//*[@id='uwgPremiere_ctl07']/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_RightsTypeInput                                    = "//*[@id='uwgPremiere_ctl04']/div/table/tbody/tr/td[1]/input"; 
	String Loc_AM_Premiere_RightsType1Input                                   = "//*[@id='uwgPremiere_ctl05']/tbody/tr/td[1]/input"; 
	String Loc_AM_Premiere_CountryInput                                       = "//*[@id='uwgPremiere_ctl05']/div/table/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_PremiereTimeInput                                  = "//*[@id='uwgPremiere_EditorControl1']";
	String Loc_AM_Premiere_DurationInput                                      = "//*[@id='uwgPremiere_ctl08']";
	String Loc_AM_Premiere_OrigNetworkInput                                   = "//*[@id='uwgPremiere_ctl00']/div/table/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_AirNetworkDropdownImg                              = "//*[@id='uwgPremiere_ctl06']/div/table/tbody/tr/td[2]/img";
	String Loc_AM_Premiere_AMCLinear                                          = "//*[text()='AMC Linear']";
	String Loc_AM_Premiere_VMNAirNetwork                                      = "//*[text()='All VMN and Non-VMN Outlets']";
	String Loc_AM_Premiere_Epi101                                             = "//div/ul/li/ul/li/ul/li/a[contains(text(),'Ep.101: Episode101')]";
	String Loc_AM_Premiere_RightsType                                         = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[17]";
	String Loc_AM_Premiere_RightsType1                                        = "//*[@id='uwgPremiere']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[17]";
	String Loc_AM_Premiere_AssetNavigator                                     = "//*[@data-ig='x:uwtAssets.3:mkr:dtnContent']";  
	String Loc_AM_Premiere_DealNameSearchHeder                                = "//*[@data-ig='x:1505864701.0:obj:header']";
	String Loc_AM_Premiere_DealNameSearchHederClose                           = "//*[@id='WebDialogWindow2']/div[1]/table/tbody/tr/td[3]/img";
	String loc_AM_Premiere_ProductOfferingInput                               = "//*[@id='uwgPremiere_ctl02']/div/table/tbody/tr/td[1]/input";
	String Loc_AM_Premiere_DealNameVerif                                      = "//table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[3]/table/tbody/tr/td/div[@title='@var']";
	String loc_AM_Premiere_AssetInViewMode                                    = "//*[@id='uwgPremiere_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]";
	// AM_Conrtibutors
	String loc_Conrtibutors_Header = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String Conrtibutors_ColumnXpath1 = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th"; // 2nd
	String Conrtibutors_DataRow = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Conrtibutors_RowXpath1 = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td";
	String Conrtibutors_RowXpath2 = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td"; // 2nd row
	String Conrtibutors_RowXpath3 = "//*[@id='uwgConrtibutors']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td"; // 3rd row
	String loc_EditContributor_Network_DropDown = "lstNetworkEdit";
	String loc_Contributor_PartyList_DropDown = "lstPartyList";
	String loc_Contributor_PartyListType_DropDown = "lstType";
	String loc_Contributor_ContributorSearch_FirstNAmeHeader = "//table[@data-ig='x:uwgSearch.21:mkr:headerContent.hdn']/tbody/tr[1]/th[3]";
	String loc_Contributor_ContributorSearch_LastNAmeHeader = "//table[@data-ig='x:uwgSearch.21:mkr:headerContent.hdn']/tbody/tr[1]/th[4]";
	String loc_Contributor_ContributorSearch_DeActivateButton = "//*[@id='DeactivateBtn']";
	String loc_Contributor_ContributorSearch_ExportButton = "//*[@id='btnExport']";
	String loc_Contributor_ContributorSearch_SelectButton = "//*[@id='btnSelect']";

	//  Contributor Search Window
	String loc_Contributor_ContributorSearch_SearchField = "//*[@id='txtName']";
	String loc_Contributor_ContributorSearch_FirstContributor = "//table[@data-ig='x:uwgSearch.10:mkr:dataTbl.hdn']/tbody/tr[1]/td[2]";
	String loc_Contributor_ContributorSearch_AppliesToInputField = "//*[@id='uwgConrtibutors_ctl00']/div/table/tbody/tr/td[1]/input";
	String loc_Contributor_ContributorSearch_RankOrderInputField = "//*[@id='uwgConrtibutors_EditorControl1']";
	String loc_Contributor_ContributorSearch_RoleInputField = "//*[@id='uwgConrtibutors_ctl02']//input";
	String loc_Contributor_ContributorSearch_CharacterAndContactInformationInputField = "//*[@id='uwgConrtibutors_nCharactername']/input";
	String loc_Contributor_ContributorSearch_GuildInputField = "//*[@id='uwgConrtibutors_ctl01']//input";
	// Contributor Search >> Add Window
	String loc_Contributor_ContributorSearch_Add_PrefixLabel = "//*[@id='EntityEdit1_Group1_lblPrefix']";
	String loc_Contributor_ContributorSearch_Add_FirstNameLabel = "//*[@id='EntityEdit1_Group1_lblFirstName']";
	String loc_Contributor_ContributorSearch_Add_FirstNameField = "//*[@id='EntityEdit1_Group1_txtFirstName']";
	String loc_Contributor_ContributorSearch_Add_MiddleNameLabel = "//*[@id='EntityEdit1_Group1_lblMiddleName']";
	String loc_Contributor_ContributorSearch_Add_LastNameLabel = "//*[@id='EntityEdit1_Group1_lblLastName']";
	String loc_Contributor_ContributorSearch_Add_LastNameField = "//*[@id='EntityEdit1_Group1_txtLastName']";
	String loc_Contributor_ContributorSearch_Add_SuffixLabel = "//*[@id='EntityEdit1_Group1_lblSuffix']";
	String loc_Contributor_ContributorSearch_Add_AKALabel = "//*[@id='EntityEdit1_Group1_lblAKA']";
	String loc_Contributor_ContributorSearch_Add_AKA_AlternateNameHeader = "//*[@id='uwgAkaTitle']//tbody/tr[1]/th[3]";
	String loc_Contributor_ContributorSearch_Add_AKA_AlternateNameField = "//*[@id='uwgAkaTitle']//tbody[2]/tr[1]//div[2]//tr[1]/td[2]";
	String loc_Contributor_ContributorSearch_Add_AKA_Row2_AlternateNameField = "//*[@id='uwgAkaTitle']//tbody[2]/tr[1]//div[2]//tr[2]/td[2]";
	String loc_Contributor_ContributorSearch_Add_AKA_TypeHeader = "//*[@id='uwgAkaTitle']//tbody/tr[1]/th[4]";
	String loc_Contributor_ContributorSearch_Add_AKA_TypeInputField= "//*[@id='uwgAkaTitle_EditorControl1']//input";
	String loc_Contributor_ContributorSearch_Add_AKA_TypeField= "//*[@id='uwgAkaTitle']//tbody[2]/tr[1]//div[2]//tr[1]/td[3]";
	String loc_Contributor_ContributorSearch_Add_AKA_Row2_TypeField= "//*[@id='uwgAkaTitle']//tbody[2]/tr[1]//div[2]//tr[2]/td[3]";
	String loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownIcon = "//*[@id='uwgAkaTitle_EditorControl1']//img";
	String loc_Contributor_ContributorSearch_Add_AKA_TypeFieldDropdownValues = "//*[@id='form1']/div[7]/div/ul/li/a";
	String loc_Contributor_ContributorSearch_Add_AKA_AddButton = "//*[@id='EntityEdit1_Group1_btnAliasesAdd']";
	String loc_Contributor_ContributorSearch_Add_AKA_DeleteButton = "//*[@id='EntityEdit1_Group1_btnAliasesDelete']";
	String loc_Contributor_ContributorSearch_Add_AddressTypeDropDown = "ddlAddressType";
	String loc_Contributor_ContributorSearch_Add_AddressLine1Label = "//*[@id='EntityEdit1_Group1_lblAddress1']";
	String loc_Contributor_ContributorSearch_Add_AddressLine1InputField = "txtAddress1";
	String loc_Contributor_ContributorSearch_Add_AddressLine2Label = "//*[@id='EntityEdit1_Group1_lblAddress2']";
	String loc_Contributor_ContributorSearch_Add_AddressLine2InputField = "txtAddress2";
	String loc_Contributor_ContributorSearch_Add_CityLabel ="//*[@id='EntityEdit1_Group1_lblCity']";
	String loc_Contributor_ContributorSearch_Add_CityInputField ="txtCity";
	String loc_Contributor_ContributorSearch_Add_CountryLabel = "//*[@id='EntityEdit1_Group1_lblCountry']";
	String loc_Contributor_ContributorSearch_Add_CountryInputField = "lstCountry";
	String loc_Contributor_ContributorSearch_Add_StateLabel = "//*[@id='EntityEdit1_Group1_lblState']";
	String loc_Contributor_ContributorSearch_Add_StateInputField = "lstState";
	String loc_Contributor_ContributorSearch_Add_ZipCodeLabel = "//*[@id='EntityEdit1_Group1_lblZipcode']";
	String loc_Contributor_ContributorSearch_Add_ZipCodeField = "txtZipcode";
	String loc_Contributor_ContributorSearch_Add_UserLabel = "//*[@id='EntityEdit1_Group1_lblUser']";

	String loc_Contributor_ContributorSearch_Add_BusinessPhoneLabel 		= "//*[@id='EntityEdit1_Group2_lblBusinessPhone']";
	String loc_Contributor_ContributorSearch_Add_BusinessPhoneInputField 	= "txtBusinessPhone";
	String loc_Contributor_ContributorSearch_Add_PrimaryEmailLabel 			= "//*[@id='EntityEdit1_Group2_lblPrimaryEmail']";
	String loc_Contributor_ContributorSearch_Add_PrimaryEmailInputField 	=  "txtPrimaryEmail";
	String loc_Contributor_ContributorSearch_Add_ContactListDropDown 		= "//*[@id='lstContact1']";
	String loc_Contributor_ContributorSearch_Add_Contact1_InputField 		= "txtContact1";
	String loc_Contributor_ContributorSearch_Add_ContactList2DropDown 		= "//*[@id='lstContact2']";
	String loc_Contributor_ContributorSearch_Add_Contact2_InputField 		= "txtContact2";
	String loc_Contributor_ContributorSearch_Add_ContactList3DropDown 		= "//*[@id='lstContact3']";
	String loc_Contributor_ContributorSearch_Add_Contact3_InputField 		= "txtContact3";
	String loc_Contributor_ContributorSearch_Add_WebAddressLabel 			= "//*[@id='EntityEdit1_Group2_lblWebAddress']";
	String loc_Contributor_ContributorSearch_Add_WebAddressInputField 		= "txtWebAddress";
	String loc_Contributor_ContributorSearch_Add_ClearAddressLabel 			= "//*[@id='btnClearAddress']";
	String loc_Contributor_ContributorSearch_Add_AddCustomAddressTypeLabel 	= "//*[@id='btnAddCustomAddressType']";
	String loc_Contributor_ContributorSearch_Add_CancelAllPopupLabel 		= "//*[@id='btnCancelAllPopup']";
	String loc_Contributor_ContributorSearch_Add_ClosePopupLabel 			= "//*[@id='btnCancelPopup']";
	String loc_Contributor_ContributorSearch_Add_SaveGeneralInfoButton 		= "//*[@id='EntityEdit1_Group6_btnSave']";
	String loc_Contributor_ContributorSearch_Add_SaveGeneralInfo_ValidationMessage =  "EntityEdit1_Group6_lblMsg";
	String loc_Contributor_ContributorSearch_Add_CloseWindow 				= "//*[@id='WebDialogWindow3']//*[contains(@data-ig,'Close')]";

	// Contributor_ContributorSearch_Add_Add Reference Type 
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeIDLabel =  "//*[@id='RidLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_ReferenceTypeLabel =  "//*[@id='RefTypeLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_ValueLabel =  "//*[@id='ValueLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_ValueField =  "//*[@id='ValueTxt']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplayValueLabel =  "//*[@id='DisplayValueLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplayOrderLabel =  "//*[@id='IdSequenceLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_SelectModuleLabel =  "//*[@id='lblModules']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_DisplaycheckBoxLabel =  "//*[@id='DisplayLbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute1Label =  "//*[@id='Attribute1Lbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute2Label =  "//*[@id='Attribute2Lbl']";
	String loc_Contributor_ContributorSearch_Add_AddReferenceValue_Attribute3Label =  "//*[@id='Attribute3Lbl']";


	// AM_Documents - Global values
	String GridHeaderViewPath_AMDocuments_Fixed = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_AMDocuments_Fixed = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderViewPath_AMDocuments_Child = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr[1]/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_AMDocuments_Child = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";
	// AM_Documents - View Mode
	String loc_Document_ViewButton = "//*[@id='btnView']";
	String loc_Document_AddDocumentButton = "//*[@id='btnDocsAdd']";
	String loc_Document_EditProfileButton = "//*[@id='btnEditAppliesTo']";
	String loc_Document_DeleteDocumentButton = "//*[@id='btnDocsRemove']";
	//AM_Documents - Add Document Window
	String loc_Document_AddDoc_AppliesToLabel = "//*[@id='lblFirstAppliesTo']";    
	String loc_Document_AddDoc_AppliesToDropDown = "//*[@id='ddlFirstAppliesTo']"; 
	String loc_Document_AddDoc_DocNameLabel = "//*[@id='lblDocumentName']";
	String loc_Document_AddDoc_DocNameField = "//*[@id='txtFileName']";
	String loc_Document_AddDoc_DocTypeLabel = "//*[@id='lblDocumentType']";
	String loc_Document_AddDoc_DocTypeDropDown = "//*[@id='lstDocType']";
	String loc_Document_AddDoc_DocDateLabel = "//*[@id='lblDocumentDate']";
	String loc_Document_AddDoc_DocumentDateField = "//*[@id='wdcDocDate']//input";
	String loc_Document_AddDoc_DescriptionLabel = "//*[@id='lblDescription']";
	String loc_Document_AddDoc_DescriptionField = "//*[@id='txtDescription']";
	String loc_Document_AddDoc_LibraryLabel = "//*[@id='lblLibrary']";
	String loc_Document_AddDoc_DocumentIDLabel = "//*[@id='lblDocumentID']";
	String loc_Document_AddDoc_DocumentIDInputField = "//*[@id='txtDocumentID']";

	String loc_Document_AddDoc_DocumentUploadLabel = "//*[@id='lblUploadFile']";
	String loc_Document_AddDoc_UploadField = "//*[@id='txtUpload']";
	String loc_Document_AddDoc_LibraryDropDown = "//*[@id='lstLibrary']";

	// AM_RelatedPrograms
	String GridDataViewPath_AMRelatedProg_Fixed = "//*[@id='uwgRelatedprog']/div//table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridDataViewPath_AMRelatedProg = "//*[@id='uwgRelatedprog']/div//table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderPath_AMRelatedProg = "//*[@id='uwgRelatedprog']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataPath_AMRelatedProg = "//*[@id='uwgRelatedprog']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// AssetValues
	String ColumnXpathRIPaymentsAssetValuesMain = "//*[@id='grpPayables_uwgAssetvalue']/table/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathRIPaymentsAssetValuesMain = "//*[@id='grpPayables_uwgAssetvalue']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// AM_RelatedAsset
	String loc_AM_RelatedAsset_ColumnXpath_EditMode 				      = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr//th"; 
	String loc_AM_RelatedAsset_DataRowXpath_EditMode 			          = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody//tr";
//	String loc_AM_RelatedAsset_ColumnXpath_ViewMode 			          = "//*[contains(@id,'uwgRelatedAssets_ctl00')]/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
//	String loc_AM_RelatedAsset_DataRowXpath_ViewMode 			          = "//*[contains(@id,'uwgRelatedAssets_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]";
	
	
	String loc_AM_RelatedAsset_ParentRow     		               = "//th[contains(@id,'columnheader_') and @key='@var']";
	String loc_AM_RelatedAsset_ChildRow     		               = "//*[contains(@id,'uwgRelatedAssets_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";	                                                                            
	String loc_AM_RelatedAsset_Child_ColumnXpath_EditMode   	   = "//*[contains(@id,'uwgRelatedAssets_ctl00')]/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]//tr[@role='row']/th";
	
	
	
    String RelAssetApplesTo1Row = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
    String RelAssetApplesTo2Row = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[4]";
    String RelAssetApplesToInput = "//*[@id='uwgRelAssetsEdit_ctl00']/div/table/tbody/tr/td[1]/input";
    String RelAssetAssetTitle1RowImg = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[6]/img";
    String RelAssetAssetTitle2RowImg = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/img";
    String RelAssetAssetTitle3RowImg = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[6]/img";
 
    String RelAssetAssteTileViewMode = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[5]";
    String RelAssetAssetType = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]";
    String RelAssetAssetType1 = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[6]";
    String RelatedAssetStartTimeCodeViewMode = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[10]";
    String RelatedAssetEndTimeCodeViewMode = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[11]";
    String ApplesToViewMode  = "//*[@id='uwgRelatedAssets_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr[1]/th[3]";
    String AssetTitleviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[5]";
    String AssetTitle1viewmode = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[5]";
    String AssetTitle2viewmode = "//table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[5]";
    String Assettypeviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[6]";
    String IPNameviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]"; 
    String Vendorviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[8]";
    String AssetIDviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[9]";
    String EpisodeNumberviewmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[12]";
    String SourceSystemviwmode = "//table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[13]";
    String AseetExpand1 = 	"//*[@id='uwgSearchResults_DXDataRow0']/td[1]/img";
    String SeasonExpand1 = "//*[@id='uwgSearchResults_dxdt0_Season_0_DXDataRow0']/td[1]/img";
    String Epi101Select = "//*[@id='uwgSearchResults_dxdt0_Season_0_dxdt0_0_Episode_0_DXDataRow0']/td[1]";
    String Epi1Row = "//*[@id='uwgTitles']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[1]";
    String EpiEditButton = "//*[@id='pnlEditEp']";
    String AllRow = "//table[@data-ig='x:275319342.5:mkr:dataTbl.hdn']/tbody/tr";
 
    
    String RelatedAssetStartTimeCode1Row = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]";
    String RelatedAssetEndTimeCode1Row =   "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]";
    String RelatedAssetStartTimeCodeinput = "//*[@id='uwgRelAssetsEdit_ctl01']";
    String RelatedAssetEndTimeCodeinput =  "//*[@id='uwgRelAssetsEdit_ctl02']";
    String RelatedAssetRoleViewMode = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[15]";
    String RelatedAssetGuildViewMode = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[17]";
    String RelatedAssetRoleRow1 = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[12]";
	String RelatedAssetGuildRow1 = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[14]"; 
	String RelatedAssetRoleRow1Input = "//*[@id='uwgRelAssetsEdit_ctl03']/div/table/tbody/tr/td[1]/input";
	String RelatedAssetGuildRow1Input = "//*[@id='uwgRelAssetsEdit_ctl04']/div/table/tbody/tr/td[1]/input"; 
    String RelAsset2Row = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/th";
    String RelAsset3Row = "//*[@id='uwgRelAssetsEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/th";
    String UnckeckDisplaySeasons = "//*[@id='cbDispSeasons']";
	//Return to Last Search 
	String Loc_RetunrToLastSearch = "//a/span[contains(text(),'Return to Last Search')]";
	String Loc_RetunrToLastSearchButton = "//*[@id='uwtToolbar']/div/ul/li[2]/a/span";	




	// AM_Versions
	String ColumnRow1XpathAMVersionView = "//*[@id='Group1_uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathAMVersionView = "//*[@id='Group1_uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String ColumnRow1XpathAMVersionEdit = "//*[@id='uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathAMVersionEdit = "//*[@id='uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String ColumnRow1XpathAMVersionView_DifferentVersion = "//*[@id='Group2_uwgVersionedAssets']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathAMVersionView_DifferentVersion = "//*[@id='Group2_uwgVersionedAssets']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// AM_Awards
	String AM_AwardsColumnXpath = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String AM_AwardsRowXpath = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";
	String AM_AwardsDataRowXpath = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String Loc_AwardsOrganization = "//*[@id='uwgAwards_columnheader_0']";
	String Loc_AwardsOrganization1 = "//*[@id='uwgAwards_columnheader_1']";
	String Loc_AwardAward = "//*[@id='uwgAwards_columnheader_1']";
	String Loc_AwardAward1 = "//*[@id='uwgAwards_columnheader_2']";
	String Loc_AwardAwardTitle = "//*[@id='uwgAwards_columnheader_2']";
	String Loc_AwardAwardTitle1 = "//*[@id='uwgAwards_columnheader_3']";
	String Loc_AwardYear = "//*[@id='uwgAwards_columnheader_3']";
	String Loc_AwardYear1 = "//*[@id='uwgAwards_columnheader_4']";
	String Loc_AwardWinner = "//*[@id='uwgAwards_columnheader_4']";
	String Loc_AwardWinner1 = "//*[@id='uwgAwards_columnheader_5']";
	String Loc_AwardStatus = "//*[@id='uwgAwards_columnheader_5']";
	String Loc_AwardStatus1 = "//*[@id='uwgAwards_columnheader_6']";
	String Loc_AwardParticipantAward = "//*[@id='uwgAwards_columnheader_6']";
	String Loc_AwardParticipantAward1 = "//*[@id='uwgAwards_columnheader_7']";
	String Loc_AwardGameAward = "//*[@id='uwgAwards_columnheader_8']";
	String Loc_AwardTab = "//span/span[contains(text(),'Award')]";
	String Loc_Award1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th";
	//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/th
	String Loc_AwardsOrganizationDropDownImg = "//*[@id='uwgAwards_ctl00']/div/table/tbody/tr/td[2]/img";
	String Loc_AwardsOrganizationDropDownPage = "//*[@id='form1']/div[4]/div";
	String Loc_AwardsOrganizationInput = "//*[@id='uwgAwards_ctl00']/div/table/tbody/tr/td[1]/input";
	String Loc_AwardsDropDownImg = "//*[@id='uwgAwards_ctl01']/div/table/tbody/tr/td[2]/img";
	String Loc_AwardsDropDownImgPage = "//*[@id='form1']/div[5]/div";
	String Loc_AwardsInput = "//*[@id='uwgAwards_ctl01']/div/table/tbody/tr/td[1]/input";
	String Loc_AwardsOrganization1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[2]";
	String Loc_AwardAward1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[3]";
	String Loc_AwardAwardTitle1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	String Loc_AwardAwardTitleInput = "//*[@id='uwgAwards_ctl02']/div/table/tbody/tr/td[1]/input";
	String Loc_AwardYear1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[5]";
	String Loc_AwardYearInput = "//*[@id='uwgAwards_ctl04']/div/table/tbody/tr/td[1]/input";
	String Loc_AwardWinner1Row  = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]";
	String Loc_AwardWinnerinput = "//*[@id='uwgAwards_nWinner']/input";
	String Loc_AwardStatus1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]";
	String Loc_AwardStatusInput = "//*[@id='uwgAwards_ctl03']/div/table/tbody/tr/td[1]/input";
	String Loc_AwardParticipantAward1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[8]/img";
	String Loc_AwardGameAward1Row = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[9]/img";
	String AlertTest = "//*[@id='WebDialogWindow_RL_Alert_tmpl_lbl_RL_Alert_Msg']";
	String ConfMsgText = "//*[@id='WebDialogWindow_RL_Confirm_tmpl_lbl_RL_Confirm_Msg']";



	//View Mode
	String Loc_AwardsOrganizationViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[1]";
	String Loc_AwardAwardViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[2]";
	String Loc_AwardAwardTitleViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[3]";
	String Loc_AwardYearViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[4]";
	String Loc_AwardWinnerViewMode  = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[5]";
	String Loc_AwardStatusViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]";
	String Loc_AwardParticipantAwardViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[7]";
	String Loc_AwardGameAwardViewMode = "//*[@id='uwgAwards']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[9]";










	//Versions
	String loc_GroupVersionHeaderDifferentHeader = "//*[contains(@id,'Group')]/legend[contains(text(),'@var')]";
	String loc_VersionEditWindow_FirstColumn = "//*[@id='ctl00_columnheader_2']";
	String loc_VersionEditWindow_25thColumn = "//*[@id='uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[25]";
	String loc_VersionEditWindow_32ndColumn = "//*[@id='uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[32]";
	String loc_VersionEditWindow_43rdColumn = "//*[@id='uwgVersions_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[43]";

	String loc_EditVersionInputField ="//*[@id='uwgVersions_ctl00_ed0']/input";
	String loc_LanguageField_EditVersion = "//*[@id='uwgVersions_ctl00_ctl02']/div/table/tbody/tr/td[1]/input";
	String loc_VersionTypeDropwDown = "//*[@id='uwgVersions_ctl00_ctl00']/div/table/tbody/tr/td[2]/img";
	String loc_VersionTypeField = "//*[@id='uwgVersions_ctl00_ctl00']/div/table/tbody/tr/td[1]/input";
	String loc_VersionTypeValues ="//*[@id='form1']/div[4]/div/ul/li/a";
	String loc_AspectRatioValues ="//*[@id='form1']/div[15]/div/ul/li/a";
	String loc_AudioDropDownValues = "//*[@id='form1']/div[10]/div/ul/li/a";
	String loc_colorDropDownValues = "//*[@id='form1']/div[11]/div/ul/li/a";
	String loc_AspectRatioDropdownIamgeIcon = "//*[@id='uwgVersions_ctl00_ctl14']/div/table/tbody/tr/td[2]/img";
	String loc_VersionformatInputField = "//*[@data-ig ='x:911154279.2:mkr:Input']";
	String loc_AspectRatio_InputField = "//*[@id='uwgVersions_ctl00_ctl14']/div/table/tbody/tr/td[1]/input";
	String loc_AMVerBlockLengthInputField = "uwgVersions_ctl00_ctl04";
	String loc_AMVerTotalActualRuntime_InputField = "uwgVersions_ctl00_ctl06";
	String loc_MAX_RUNTIMEHeader_InputField = "uwgVersions_ctl00_ctl05";
	String loc_NETWORKHeader_InputField = "//*[@id='uwgVersions_ctl00_ctl07']/div/table/tbody/tr/td[1]/input";
	String loc_AUDIO_DropDownImageIcon_SecondRow = "//*[@id='uwgVersions_ctl00_ctl09']/div/table/tbody/tr/td[2]/img";
	String loc_COLORHeader_DropDownImageIcon_SecondRow = "//*[@id='uwgVersions_ctl00_ctl10']/div/table/tbody/tr/td[2]/img";
	String loc_COLOR_InputField="//*[@id='uwgVersions_ctl00_ctl10']/div/table/tbody/tr/td[1]/input";
	String loc_DUBBED_LANGUAGE_InputField = "//*[@id='uwgVersions_ctl00_ctl12']/div/table/tbody/tr/td[1]/input";
	String loc_SUBTITLED_LANGUAGEHeader_InputField = "//*[@id='uwgVersions_ctl00_ctl13']/div/table/tbody/tr/td[1]/input";
	String loc_Note_Restriction = "//*[@id='chkRestriction']";
	String loc_StandardField_InputField = "//*[@id='uwgVersions_ctl00_ctl15']/div/table/tbody/tr/td[1]/input";
	String loc_TotalNumberOfVersions_EditVersionWindow = "//table/tbody[contains(@class,'NewItemClass')]/tr";
	String loc_EditVersion_LanguageIcon = "//*[@id='imgLanguage']";
	String loc_EditVersion_LanguageWindow_ApplyButton = "//*[@id='PageContent_tList1_btnOk']";
	String loc_EditVersion_LanguageWindow_CollapseButton = "//*[@id='PageContent_tList1_btnCollapseAll']";
	String loc_EditVersion_LanguageWindow_ExpandButton = "//*[@id='PageContent_tList1_btnExpandAll']";
	String loc_EditVersion_LanguageWindow_Selectbutton = "//*[@id='PageContent_tList1_btnSelect']";
	String loc_EditVersion_LanguageWindow_DeSelectbutton = "//*[@id='PageContent_tList1_btnDeSelect']";
	String loc_EditVersion_LanguageWindow_PrimaryLanguageCheckBox = "//*[@id='PageContent_tList1_uwTree']/ul/li/ul/li[1]/img[3]";
	String loc_EditVersion_LanguageWindow_subtitleLanguageCheckBox = "//*[@id='PageContent_tList1_uwTree']/ul/li/ul/li[2]/img[3]";

	// AM_Attributes
	String AM_AttributesColumnXpath 		= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String AM_AttributesRowXpath 			= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String AM_Attributes_Field 				= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[@title='@var']";
	String AM_Attributes_Value1 			= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[@title='@var']/following-sibling::td";
	String AM_Attributes_Value2 			= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[@title='@var']/following-sibling::td/following-sibling::td";
	String AM_AttributeName_InputField 		= "//*[@id='uwgAssetAttributesDefault_ctl00']/div/table/tbody/tr/td[1]/input";
	String AM_AttributeValue1_InputField 	= "//*[@id='uwgAssetAttributesDefault_ctl01']/div/table/tbody/tr/td[1]/input"; 
	String AM_AttributeValue2_InputField 	= "//*[@id='uwgAssetAttributesDefault_ed0']/input"; 
	String AM_Attribute_LastRow 			= "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[last()]/td[2]";



	// Asset Search
	String AM_Asset1_Under_SearchMenu = "//div[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[1]/a/span";
	String AM_Asset2_Under_SearchMenu = "//div[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[2]/a/span";
	String AM_Asset3_Under_SearchMenu = "//div[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[3]/a/span";
	String AM_Asset4_Under_SearchMenu = "//div[@id='PlainTopMenu1_MainMenu_2']/div/ul/li[4]/a/span";
}

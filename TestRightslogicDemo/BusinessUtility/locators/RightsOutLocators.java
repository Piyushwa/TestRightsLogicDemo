package locators;

public interface RightsOutLocators {

	// ****************Locators specific to Rights Out Module***********************//
	// Deal Memo
	String GenerateDealSummary = "//*[contains(@id,'RadioButtonList')]//label[text()='Generate Deal Summary']";
	String GenerateLicenseAgreement = "//*[contains(@id,'RadioButtonList')]//label[text()='Generate License Agreement']";
	String GeneratePrivateNetsLicenseAgreement = "//*[contains(@id,'RadioButtonList')]//label[text()='Generate Private Nets License Agreement']";
	String NextDealMemo = "//*[contains(@id,'Next')]";
	String CancelDealMemo = "//*[contains(@id,'Cancel')]";
	String PartyLabel = "//*[@id='ProjectTeamNotify_Div']//*[contains(text(),'Party')]";
	String TabsLabel = "//*[@id='ProjectTeamNotify_Div']//*[contains(text(),'Tabs')]";
	String AttributesLabel = "//*[@id='ProjectTeamNotify_Div']//*[contains(text(),'Attributes')]";
	String TermEventsLabel = "//*[@id='ProjectTeamNotify_Div']//*[contains(text(),'Term Events')]";
	String DisplayTermEventDetailsLabel = "//*[@id='rdTermEvents']//*[contains(text(),'Display Term Event Details')]";
	String HideTermEventDetailsLabel = "//*[@id='rdTermEvents']//*[contains(text(),'Hide Term Event Details')]";
	String NotesOnTabsLabel = "//*[@id='trNotesOnTabs']//*[contains(text(),'Notes on Tabs')]";
	String AllNotesLabel = "//*[@id='trNotesOnTabs']//*[contains(text(),'All Notes')]";
	String IncludeInReportsLabel = "//*[@id='trNotesOnTabs']//*[contains(text(),'Include in Reports')]";
	String SelectAllButton = "//*[contains(@id,'SelectAll')]";
	String FinishButton = "//*[contains(@id,'Send')]";
	String CancelButton = "//*[contains(@value,'Cancel')]";
	String TabsList = "//*[@id='lstTabs']";
	String PartyList = "//*[@id='lstParty']";
	String AttributesList = "//*[@id='lstAttributes']";	
	

	// RO_General
	static String ROPartiesheaderxpath = "//*[@id='uwgParties']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	static String ROPartiesxpath = "//*[@id='uwgParties']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	static String ROPartiesxpath_Window = "//*[@id='uwgSearch_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	static String RONotesxpath = "//*[@id='uwgNotes']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Version
	String ColumnXpath = "//*[@id='uwgVersions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRowXpath = "//*[@id='uwgVersions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td";

	// RO_PromoRights - Global values
	String GridHeaderPath_ROPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataPath_ROPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROPromoRights_Parent = "//*[@id='uwgPromoRights']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataView_ROPromoRights_Parent = "//*[@id='uwgPromoRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROPromoRights_child = "//*[@id='uwgPromoRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_ROPromoRights_child = "//*[@id='uwgPromoRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_EditingRights - Global values
	String GridHeaderPath_ROEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataPath_ROEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROEditingRights_Parent = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataView_ROEditingRights_Parent = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROEditingRights_child = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_ROEditingRights_child = "//*[@id='uwgEditRights']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_Obligations - Global values
	String GridHeaderPath_ROObligations = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String GridHeaderPath_ROObligations_1 = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_ROObligations_1 = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridDataPath_ROObligations = "//*[@id='uwgObligations']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROObligations_Parent = "//*[@id='uwgObligations']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataView_ROObligations_Parent = "//*[@id='uwgObligations']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROObligations_child = "//*[@id='uwgObligations']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_ROObligations_child = "//*[@id='uwgObligations']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_BusinessTerm - Global values
	String GridHeaderPath_ROBusinessTerms = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataPath_ROBusinessTerms = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderViewPath_ROBusinessTerms = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_ROBusinessTerms = "//*[@id='uwgBusTerms']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Services - Global values
	String GridHeaderPath_ROServices = "//*[@id='uwgServices']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_ROServices = "//*[@id='uwgServices']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_ProjectTeam - Global values
	String GridHeaderPath_ROProjectTeam = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataPath_ROProjectTeam = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridAKAHeader_ROProjectTeam = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridAKAData_ROProjectTeam = "//*[@id='uwgAkaTitle']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String GridSearchInternal_ROProjectTeam = "//*[@id='uwgSearch']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderViewPath_ROProjectTeam = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_ROProjectTeam = "//*[@id='uwgProjectTeam']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_RevenueParticipation - Global values
	String GridHeaderPath_RORevenueParticipation = "//*[@id='uwgRevParticipation']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_RORevenueParticipation = "//*[@id='uwgRevParticipation']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_RORevenueParticipation_Parent = "//*[@id='uwgRevParticipation']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataView_RORevenueParticipation_Parent = "//*[@id='uwgRevParticipation']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_RORevenueParticipation_child = "//*[@id='uwgRevParticipation']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_RORevenueParticipation_child = "//*[@id='uwgRevParticipation']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_Option - Global values
	String GridHeaderPath_ROOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[4]/div/table/tbody/tr/th";
	String GridHeaderPath_ROOptions_1 = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String GridDataPath_ROOptions_1 = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridDataPath_ROOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROOptions_Parent = "//*[@id='uwgOptions']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataView_ROOptions_Parent = "//*[@id='uwgOptions']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderView_ROOptions_child = "//*[@id='uwgOptions']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/table/tbody/tr/th";
	String GridDataView_ROOptions_child = "//*[@id='uwgOptions']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_Documents - Global values
	String GridHeaderViewPath_RODocuments_Fixed = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_RODocuments_Fixed = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String GridHeaderViewPath_RODocuments_Child = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr[1]/td/div[1]/table/tbody/tr/th";
	String GridDataViewPath_RODocuments_Child = "//*[@id='uwgDocuments']/div/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td/div[2]/table/tbody/tr";

	// RO_Guarantees
	String RO_GuaranteesColumnXpath = "//*[@id='uwgGuaranteesEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RO_GuaranteesRowXpath = "//*[@id='uwgGuaranteesEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RO_GuaranteesRow2Xpath = "//*[@id='uwgGuaranteesEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[4]/td";
	String RO_GuaranteesRow3Xpath = "//*[@id='uwgGuaranteesEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td";
	String RO_GuaranteesRow4Xpath = "//*[@id='uwgGuaranteesEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[6]/td";

	// RO_TrackingEvents
	String ColumnXpathTrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00_0_0']/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRowXpathTrckngEvnts = "//*[@id='uwgTrackEventsEdit_ctl00_0_0']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathROOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[4]/div/table/tbody/tr/th";
	String DataRow1XpathROOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[1]/td[3]/div/table/tbody/tr";
	String ColumnRow1XpathROPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String DataRow1XpathROPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String DataRow2XpathROPromoRights = "//*[@id='uwgPromoRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]";
	String ColumnRow1XpathROEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div[1]/table/tbody/tr/th";
	String DataRow1XpathROEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String DataRow2XpathROEditingRights = "//*[@id='uwgEditRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]";
	String DataRow2XpathROOptions = "//*[@id='uwgOptions']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[3]/div/table/tbody/tr";

	// RO_Payments
	String ROColumnRow1XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String RODataRow1XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr";
	String RODataRow2XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr";
	String RODataRow3XpathRIMediaRights = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td[6]/div/table/tbody/tr";
	String ROColumnRow1XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RODataRow1XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ROColumnRow1XpathRIPaymentsMain = "//*[@id='grpReceivables_uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RODataRow1XpathRIPaymentsMain = "//*[@id='grpReceivables_uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ROColumnRow2XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String ROColumnRow3XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RODataRow21XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[5]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String RODataRow31XpathRIPayments = "//*[@id='uwtPayment_tmpl0_uwgReceivables_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Payment Schedule
	String ColumnXpathROPaymentScheduleMain = "//*[@id='uwgPaySchedule_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String ColumnXpathROPaymentSchedule = "//*[@id='uwgPayScheduleEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String ColumnXpathROPaymentScheduleChild = "//*[@id='uwgPayScheduleEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th[2]";
	String DataXpathROPaymentSchedule = "//*[@id='uwgPayScheduleEdit_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String DataRowXpathROPaymentScheduleChild = "//*[@id='uwgPayScheduleEdit_ctl00']/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Workflow
	String ColumnRow1XpathROWorkflowView = "//*[@id='uwgWorkflow']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowView = "//*[@id='uwgWorkflow']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathROWorkflowEdit = "//*[@id='uwgWorkflowEdit']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowEdit = "//*[@id='uwgWorkflowEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String ColumnRow1XpathROWorkflowTemplate = "//*[@id='uwgWorkflow']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowTemplate = "//*[@id='uwgWorkflow']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathROWorkflowDeliveryEdit = "//*[@id='uwgDeliveryEdit']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowDeliveryEdit = "//*[@id='uwgDeliveryEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	String ColumnRow1XpathROWorkflowDeliveryView = "//*[@id='uwgDelivery']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowDeliveryView = "//*[@id='uwgDelivery']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathROWorkflowAmendmentEdit = "//*[@id='uwgAmendmentWorkflowEdit']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowAmendmentEdit = "//*[@id='uwgAmendmentWorkflowEdit']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";
	String ColumnRow1XpathROWorkflowAmendmentView = "//*[@id='uwgWorkflow_Amnmt']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String DataRow1XpathROWorkflowAmendmentView = "//*[@id='uwgWorkflow_Amnmt']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Attributes
	String RO_AttributesColumnXpath = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RO_AttributesRowXpath = "//*[@id='uwgAssetAttributesDefault']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr";

	// RO_Delivery
	String RO_DeliveryColumnXpath1 = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th[7]/div/table/tbody/tr/th";
	String RO_DeliveryRowXpath1 = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr/td[6]/div/table/tbody/tr/td";
	String RO_DeliveryRowXpath2 = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr/td";
	String RO_DeliveryRowXpath3 = "//*[@id='uwgMediaRights']/table/tbody/tr[1]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td[6]/div/table/tbody/tr[1]/td";

	// RO_CollisionReport
	String RO_CollisionReportColumn1Xpath = "//*[@id='uwgCollisionRightsOut_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RO_CollisionReportColumn2Xpath = "//table/tbody[2]/tr/td/div[2]/table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[1]/tr/td/div/table/tbody/tr/th";
	String RO_CollisionReportRow1Xpath = "//*[@id='uwgCollisionRightsOut_ctl00']/table/tbody/tr[2]/td[1]/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RO_CollisionReportRow2Xpath = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";
	String RO_CollisionReportRow3Xpath = "//table/tbody/tr[3]/td/div/div/table/tbody/tr[2]/td/table/tbody[2]/tr/td/div[2]/table/tbody/tr[2]/td";

	
	
}

package excelDataBinding;

import utility.PropertyReader;

public interface AM_ExcelData {

	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\AM_TestData.xlsx");
	String ClientData = PropertyReader.readApplicationFile("Client");


	// Asset Maintenance 
	// AM General
	String ValMessage_ChagneAssetSubType                               = xlsInputData.getCellData("AM_General", ClientData, 64);
	String ValMessage_clearFieldVAlue                                  = xlsInputData.getCellData("AM_General", ClientData, 65);
	String ValMessage_SelectAtLeastOneItme_SBU_window                  = xlsInputData.getCellData("AM_General", ClientData, 66);
	String IPName                                                      = xlsInputData.getCellData("AM_General", ClientData, 74);
	String AssetType_Status                                            = xlsInputData.getCellData("AM_General", ClientData, 3);
	String AssetCategory_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 4);
	String AssetTitle_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 5);
	String IP_Status 				                                   = xlsInputData.getCellData("AM_General", ClientData, 6);
	String ProjectID_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 7);
	String SeriesTitle_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 8);
	String Vendor1_Status 						                       = xlsInputData.getCellData("AM_General", ClientData, 9);
	String Vendor2_Status 						                       = xlsInputData.getCellData("AM_General", ClientData, 10);
	String SBU_Status 							                       = xlsInputData.getCellData("AM_General", ClientData, 11);
	String DurationField_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 12);
	String ShortName_Status 					                       = xlsInputData.getCellData("AM_General", ClientData, 13);
	String AssetStatus_Status 					                       = xlsInputData.getCellData("AM_General", ClientData, 14);
	String AssetSource_Status 					                       = xlsInputData.getCellData("AM_General", ClientData, 16);
	String InternalCheckBox_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 17);
	String NonAirableCheckBox_Status 				                   = xlsInputData.getCellData("AM_General", ClientData, 18);
	String TBACheckBox_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 19);
	String AssetFormat_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 20);
	String ViewedLabel_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 21);
	String DeliveryDate_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 22);
	String PPRODContract_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 23);
	String UniqueEpisode_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 24);
	String ClientGroup_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 25);
	String Season_Status		 					                   = xlsInputData.getCellData("AM_General", ClientData, 26);
	String AssetHierarchy_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 27);
	String GroupAssociation_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 28);
	String DelivaryDate_Status 				                           = xlsInputData.getCellData("AM_General", ClientData, 29);	
	
	String IPWindow_Status 				                               = xlsInputData.getCellData("AM_General", ClientData, 33);
	String ActualRunTime_Status 				                       = xlsInputData.getCellData("AM_General", ClientData, 35);
	String StudioWindowHeaderName 				                       = xlsInputData.getCellData("AM_General", ClientData, 36);
	String StudioClearIconAvailabilty_Status 				           = xlsInputData.getCellData("AM_General", ClientData, 37);
	String StudioPickListIconAvailabilty_Status 				       = xlsInputData.getCellData("AM_General", ClientData, 38);
	String SBUPickListIconAvailabilty_Status 				       	   = xlsInputData.getCellData("AM_General", ClientData, 39);
	

	//Genre Data
	String Genre_Legend 				                           = xlsInputData.getCellData("AM_General", ClientData, 116);
	String GenreNetworkTypeKey 				                       = xlsInputData.getCellData("AM_General", "Keys", 117);
	String SubGenreKey 				                               = xlsInputData.getCellData("AM_General", "Keys", 118);
	String GenreNetworkType 				                       = xlsInputData.getCellData("AM_General", ClientData, 117);
	String SubGenre 				                               = xlsInputData.getCellData("AM_General", ClientData, 118);
	String Genre_AddButton 				                           = xlsInputData.getCellData("AM_General", ClientData, 119);
	String Genre_DeleteButton 				                       = xlsInputData.getCellData("AM_General", ClientData, 120);
	String Genre_DeleteValidationMessage 				           = xlsInputData.getCellData("AM_General", ClientData, 121);
	String Note_DeleteValidationMessage 				           = xlsInputData.getCellData("AM_General", ClientData, 67);
	
	//Tempaltes
	String SBUWindow_Status		 				           			= xlsInputData.getCellData("AM_General", ClientData, 138);
	
	
	//Note Data
	String Note_Status 				                                   = xlsInputData.getCellData("AM_General", ClientData, 171);
	String Note_AddButton 				                               = xlsInputData.getCellData("AM_General", ClientData, 172);
	String Note_DeleteButton 				                           = xlsInputData.getCellData("AM_General", ClientData, 173);
	String NoteWindow_Priority 				                           = xlsInputData.getCellData("AM_General", ClientData, 174);
	String NoteWindow_Subject 				                           = xlsInputData.getCellData("AM_General", ClientData, 175);
	String NoteWindow_Note 				                           	   = xlsInputData.getCellData("AM_General", ClientData, 176);
	String NoteWindow_OKButton 				                           = xlsInputData.getCellData("AM_General", ClientData, 177);
	String NoteWindow_CancelButton 				                           	   = xlsInputData.getCellData("AM_General", ClientData, 178);
	
	
	// AM General Test Data
	// AKA Title Window
	String AKAWindow_Title 				                               = xlsInputData.getCellData("AM_General", ClientData, 77);
	String AKAWindow_AKATitles 				                           = xlsInputData.getCellData("AM_General", ClientData, 78);
	String AKAWindow_AssetType 				                           = xlsInputData.getCellData("AM_General", ClientData, 79);
	String AKAWindow_ReleaseYr				                           = xlsInputData.getCellData("AM_General", ClientData, 80);
	String AKAWindow_Director 				                           = xlsInputData.getCellData("AM_General", ClientData, 81);
    String SearchvalueVendor  				                      		= xlsInputData.getCellData("AM_General", ClientData, 72);
    String SearchvalueStudio  				                       		= xlsInputData.getCellData("AM_General", ClientData, 73);
	String SearchvalueIP  				                       			= xlsInputData.getCellData("AM_General", ClientData, 74);
    String AssetStatus 		                                            = xlsInputData.getCellData("AM_General", ClientData, 92);
	String AssetSource 		                                            = xlsInputData.getCellData("AM_General", ClientData, 93);
	String TitleType 		                                            = xlsInputData.getCellData("AM_General", ClientData, 94);
	String DeliveryDate	 	                                            = xlsInputData.getCellData("AM_General", ClientData, 95);
	String InitialPlatform 	                                            = xlsInputData.getCellData("AM_General", ClientData, 96);
	String Season 			                                            = xlsInputData.getCellData("AM_General", ClientData, 97);
	String AssetEditable_Status 			                            = xlsInputData.getCellData("AM_General", ClientData, 98);
	String Duration                                                     = xlsInputData.getCellData("AM_General", ClientData, 99);
	String LookUpCode                                                   = xlsInputData.getCellData("AM_General", ClientData, 100);
	String MovieAssetStatus                                             = xlsInputData.getCellData("AM_General", ClientData, 101);
	String AssetSubject                                                 = xlsInputData.getCellData("AM_General", ClientData, 102);
	String AssetNotesTextField                                          = xlsInputData.getCellData("AM_General", ClientData, 103);
	String AssetPriority                                                = xlsInputData.getCellData("AM_General", ClientData, 104);
	String ProjectID                                                    = xlsInputData.getCellData("AM_General", ClientData, 105);
	String AssetHierarchy                                               = xlsInputData.getCellData("AM_General", ClientData, 106);
	String PRODContractEntryStatus                                      = xlsInputData.getCellData("AM_General", ClientData, 107);
	String MMLClient 		                                            = xlsInputData.getCellData("AM_General", ClientData, 108);
	String Vendor_PartyType  				                       		= xlsInputData.getCellData("AM_General", ClientData, 109);
    String AssetCreationSourceBusinessUnit 	                       		= xlsInputData.getCellData("AM_General", ClientData, 110);
    String AssetCreationAssetSource 		                       		= xlsInputData.getCellData("AM_General", ClientData, 111);
    String AssetCreationTitleType 			                       		= xlsInputData.getCellData("AM_General", ClientData, 112);

	//AMDetails
	//keys Boxoffice Header
	String AM_Details_Country_Key                                       = xlsInputData.getCellData("AM_Details", "Keys", 107); 
	String AM_Details_Currency_Key                                      = xlsInputData.getCellData("AM_Details", "Keys", 108); 

	String AM_Details_ReleaseDate_Key                                   = xlsInputData.getCellData("AM_Details", "Keys", 110); 
	String AM_Details_Actual_Key                                        = xlsInputData.getCellData("AM_Details", "Keys", 112); 
	String AM_Details_AsofDate_Key                                      = xlsInputData.getCellData("AM_Details", "Keys", 115); 
	String AM_Details_SynopsisType_Key                                  = xlsInputData.getCellData("AM_Details", "Keys", 140); 
	String AM_Details_Network_Key                                       = xlsInputData.getCellData("AM_Details", "Keys", 141); 
	String AM_Details_SynopsisSource_Key                                = xlsInputData.getCellData("AM_Details", "Keys", 142); 
	String AM_Details_Language_Key                                      = xlsInputData.getCellData("AM_Details", "Keys", 143); 
	String AM_Details_Length_Key                                        = xlsInputData.getCellData("AM_Details", "Keys", 144); 
	String AM_Details_CreatedBy_Key                                     = xlsInputData.getCellData("AM_Details", "Keys", 146); 
	String AM_Details_CreatedDate_Key                                   = xlsInputData.getCellData("AM_Details", "Keys", 147); 
	String AM_Details_Synopsis_Key                                      = xlsInputData.getCellData("AM_Details", "Keys", 148); 

	//Boxoffice Header
	String AM_Details_Country                                           = xlsInputData.getCellData("AM_Details", ClientData, 107); 
	String AM_Details_Currency                                          = xlsInputData.getCellData("AM_Details", ClientData, 108); 
	String AM_Details_ReleaseDate                                       = xlsInputData.getCellData("AM_Details", ClientData, 110); 
	String AM_Details_Actual                                            = xlsInputData.getCellData("AM_Details", ClientData, 112); 
	String AM_Details_AsofDate                                          = xlsInputData.getCellData("AM_Details", ClientData, 115); 
	String AM_Details_SynopsisType                                      = xlsInputData.getCellData("AM_Details", ClientData, 140); 
	String AM_Details_Network                                           = xlsInputData.getCellData("AM_Details", ClientData, 141); 
	String AM_Details_SynopsisSource                                    = xlsInputData.getCellData("AM_Details", ClientData, 142); 
	String AM_Details_Language                                          = xlsInputData.getCellData("AM_Details", ClientData, 143); 
	String AM_Details_Length                                            = xlsInputData.getCellData("AM_Details", ClientData, 144); 
	String AM_Details_CreatedBy                                         = xlsInputData.getCellData("AM_Details", ClientData, 146); 
	String AM_Details_CreatedDate                                       = xlsInputData.getCellData("AM_Details", ClientData, 147); 
	String AM_Details_Synopsis                                          = xlsInputData.getCellData("AM_Details", ClientData, 148); 
	String AM_Details_Venue                                             = xlsInputData.getCellData("AM_Details", ClientData, 160); 
	String AM_Details_RoundOfSeries                                     = xlsInputData.getCellData("AM_Details", ClientData, 161); 
	String AM_Details_MatchCategory                                     = xlsInputData.getCellData("AM_Details", ClientData, 162); 
	String AM_Details_PlayerCategory                                    = xlsInputData.getCellData("AM_Details", ClientData, 163); 
	String AM_Details_AssetCategory                                     = xlsInputData.getCellData("AM_Details", ClientData, 164); 
	String AM_Details_ParentVMID                                        = xlsInputData.getCellData("AM_Details", ClientData, 65);
	String AM_Details_AKA                                               = xlsInputData.getCellData("AM_Details", ClientData, 67); 
	String AM_Details_ShootingFormat                                    = xlsInputData.getCellData("AM_Details", ClientData, 68); 
	String AM_Details_DeliveryFormat                                    = xlsInputData.getCellData("AM_Details", ClientData, 69); 
	String AM_Details_ReleaseYear                                       = xlsInputData.getCellData("AM_Details", ClientData, 70);
	String AM_Details_Publisher                                         = xlsInputData.getCellData("AM_Details", ClientData, 71); 
	String AM_Details_AssetDescription                                  = xlsInputData.getCellData("AM_Details", ClientData, 72); 
	String AM_Details_CreditsTimeIn                                     = xlsInputData.getCellData("AM_Details", ClientData, 73); 
	String AM_Details_TimeOut                                           = xlsInputData.getCellData("AM_Details", ClientData, 74); 
	String AM_Details_PrimaryLanguage                                   = xlsInputData.getCellData("AM_Details", ClientData, 75); 
	String AM_Details_CloseCaptioned                                    = xlsInputData.getCellData("AM_Details", ClientData, 76); 
	String AM_Details_Dubbed                                            = xlsInputData.getCellData("AM_Details", ClientData, 77); 
	String AM_Details_Subtitled                                         = xlsInputData.getCellData("AM_Details", ClientData, 78); 
	String AM_Details_SourceID                                          = xlsInputData.getCellData("AM_Details", ClientData, 79); 
	String AM_Details_System                                            = xlsInputData.getCellData("AM_Details", ClientData, 80); 
	String AM_Details_FromGrade                                         = xlsInputData.getCellData("AM_Details", ClientData, 81); 
	String AM_Details_ToGrade                                           = xlsInputData.getCellData("AM_Details", ClientData, 82); 
	String AM_Details_TVParentalRating                                  = xlsInputData.getCellData("AM_Details", ClientData, 83); 
	String AM_Details_RatingWarning                                     = xlsInputData.getCellData("AM_Details", ClientData, 84); 
	String AM_Details_Keywords                                          = xlsInputData.getCellData("AM_Details", ClientData, 85); 
	String AM_Details_VMID                                              = xlsInputData.getCellData("AM_Details", ClientData, 86);
	String AM_Details_MasterAudio                                       = xlsInputData.getCellData("AM_Details", ClientData, 87); 
	String AM_Details_Production                                        = xlsInputData.getCellData("AM_Details", ClientData, 88); 
	String AM_Details_HDPercentage                                      = xlsInputData.getCellData("AM_Details", ClientData, 89); 
	String AM_Details_HDType                                            = xlsInputData.getCellData("AM_Details", ClientData, 90); 
	String AM_Details_Boxoffice                                         = xlsInputData.getCellData("AM_Details", ClientData, 91); 
	String AM_Details_TargetDemographics                                = xlsInputData.getCellData("AM_Details", ClientData, 92); 
	String AM_Details_GuildAssociation                                  = xlsInputData.getCellData("AM_Details", ClientData, 93);
	String AM_Details_Tier                                              = xlsInputData.getCellData("AM_Details", ClientData, 94);
	String AM_Details_InternationalAmortizationDate                     = xlsInputData.getCellData("AM_Details", ClientData, 95);
	String AM_Details_SAPMPMID                                          = xlsInputData.getCellData("AM_Details", ClientData, 96);
	String AM_Details_MPAARating                                        = xlsInputData.getCellData("AM_Details", ClientData, 97); 
	String AM_Details_CC                                                = xlsInputData.getCellData("AM_Details", ClientData, 98); 
	String AM_Details_CopyrightYear                                     = xlsInputData.getCellData("AM_Details", ClientData, 99); 
	String AM_Details_Nudity                                            = xlsInputData.getCellData("AM_Details", ClientData, 100); 
	String AM_Details_Rape                                              = xlsInputData.getCellData("AM_Details", ClientData, 101); 
	String AM_Details_Violence                                          = xlsInputData.getCellData("AM_Details", ClientData, 102); 
	String AM_Details_Sensuality                                        = xlsInputData.getCellData("AM_Details", ClientData, 103); 
	String AM_Details_Commentary                                        = xlsInputData.getCellData("AM_Details", ClientData, 104); 
	String AM_Details_Graphics                                          = xlsInputData.getCellData("AM_Details", ClientData, 105); 
	String AM_Details_Disclaimers                                       = xlsInputData.getCellData("AM_Details", ClientData, 106); 
	String AM_Details_Tournament                                        = xlsInputData.getCellData("AM_Details", ClientData, 126); 
	String AM_Details_Teams                                             = xlsInputData.getCellData("AM_Details", ClientData, 127);  
	String AM_Details_ImageUpload                                       = xlsInputData.getCellData("AM_Details", ClientData, 128);
	String AM_Details_AKANetwork                                        = xlsInputData.getCellData("AM_Details", ClientData, 2);
	String AM_Details_PublisherData                                     = xlsInputData.getCellData("AM_Details", ClientData, 3);
	String AM_Details_Languageval                                       = xlsInputData.getCellData("AM_Details", ClientData, 4);
	String AM_Details_CloseCaptionedval                                 = xlsInputData.getCellData("AM_Details", ClientData, 5);
	String AM_Details_Dubbedlangval                                     = xlsInputData.getCellData("AM_Details", ClientData, 6);
	String AM_Details_Subtitlelangval                                   = xlsInputData.getCellData("AM_Details", ClientData, 7);
	String AM_Details_TVParentalNetwork                                 = xlsInputData.getCellData("AM_Details", ClientData, 8);
	String AM_Details_TVParentalRatingData                              = xlsInputData.getCellData("AM_Details", ClientData, 9);
	String AM_Details_RatingWarningData                                 = xlsInputData.getCellData("AM_Details", ClientData, 10);
	String AM_Details_MasterAudioval                                    = xlsInputData.getCellData("AM_Details", ClientData, 11);
	String AM_Details_HDPercentageval                                   = xlsInputData.getCellData("AM_Details", ClientData, 12);
	String AM_Details_HDTypeval                                         = xlsInputData.getCellData("AM_Details", ClientData, 13);
	String AM_Details_Tierval                                           = xlsInputData.getCellData("AM_Details", ClientData, 14);
	String AM_Details_CopyRightDateval                                  = xlsInputData.getCellData("AM_Details", ClientData, 15);
	String AM_Details_SynopsisNetworkData                               = xlsInputData.getCellData("AM_Details", ClientData, 16);
	String AM_Details_SynopsisTypeData1                                 = xlsInputData.getCellData("AM_Details", ClientData, 17);
	String AM_Details_SynopsisTypeData2                                 = xlsInputData.getCellData("AM_Details", ClientData, 18);
	String AM_Details_SynopsisTypeData3                                 = xlsInputData.getCellData("AM_Details", ClientData, 19);
	String AM_Details_GuildeAffiliationval                              = xlsInputData.getCellData("AM_Details", ClientData, 20);
	String AM_Details_MPAARatingval                                     = xlsInputData.getCellData("AM_Details", ClientData, 21);
	String AM_Details_LengthData1                                       = xlsInputData.getCellData("AM_Details", ClientData, 22);
	String AM_Details_LengthData2                                       = xlsInputData.getCellData("AM_Details", ClientData, 23);
	String AM_Details_LengthData3                                       = xlsInputData.getCellData("AM_Details", ClientData, 24);
	String AM_Details_Shootingformatval                                 = xlsInputData.getCellData("AM_Details", ClientData, 25);
	String AM_Details_Delivereyformatval                                = xlsInputData.getCellData("AM_Details", ClientData, 26);
	String AM_Details_SourceIDData                                      = xlsInputData.getCellData("AM_Details", ClientData, 29);
	String AM_Details_Delivereyformat1                                  = xlsInputData.getCellData("AM_Details", ClientData, 36);
	String AM_Details_Shootingformat1                                   = xlsInputData.getCellData("AM_Details", ClientData, 37);
	String AM_Details_Country1                                          = xlsInputData.getCellData("AM_Details", ClientData, 38);
	String AM_Details_DetailsTabValidationMsg                           = xlsInputData.getCellData("AM_Details", ClientData, 166);
	String AM_Details_DetailsSourceData                                 = xlsInputData.getCellData("AM_Details", ClientData, 50);
	String AM_Details_AKAField                                          = xlsInputData.getCellData("AM_Details", ClientData, 67);
	String AM_Details_NetworkField                                      = xlsInputData.getCellData("AM_Details", ClientData, 156);
	String AM_Details_AlertMsg                                          = xlsInputData.getCellData("AM_Details", ClientData, 167);
	String AM_Details_SynopsisNetwork1                                  = xlsInputData.getCellData("AM_Details", ClientData, 141);
	String AM_Details_KeywordDeleteWithoutAlertMsg                      = xlsInputData.getCellData("AM_Details", ClientData, 168);
	String AM_Details_KeywordDeleteWithAlertMsg                         = xlsInputData.getCellData("AM_Details", ClientData, 169);
	String AM_Details_CreditTimeOut                                     = xlsInputData.getCellData("AM_Details", ClientData, 170);
	String AM_Details_CreditsTimeExceeds                                = xlsInputData.getCellData("AM_Details", ClientData, 171);
	String AM_Details_CreditsTimeOutlesser                              = xlsInputData.getCellData("AM_Details", ClientData, 172);
	String AM_Details_bothFromGradeandToGrade                           = xlsInputData.getCellData("AM_Details", ClientData, 173);
	String AM_Details_bothgreaterthan                                   = xlsInputData.getCellData("AM_Details", ClientData, 174);
	String AM_Details_KeywordWithout                                    = xlsInputData.getCellData("AM_Details", ClientData, 175);
	String AM_Details_KeywordAlreadyExist                               = xlsInputData.getCellData("AM_Details", ClientData, 176);
	String AM_Details_KeywordWithoutselect                              = xlsInputData.getCellData("AM_Details", ClientData, 177);
	String AM_Details_SearchResultNotMatch                              = xlsInputData.getCellData("AM_Details", ClientData, 181);
	String AM_Details_AKAData                                           = xlsInputData.getCellData("AM_Details", ClientData, 41);
	String AM_Details_AKATypeData                                       = xlsInputData.getCellData("AM_Details", ClientData, 42);
	String AM_Details_SynopsistypeInputData                             = xlsInputData.getCellData("AM_Details", ClientData, 28);
	String AM_Details_NetworkVeridata                                   = xlsInputData.getCellData("AM_Details", ClientData, 49);
	String AM_Details_AssetSynopsisNetwork                              = xlsInputData.getCellData("AM_Details", ClientData, 141);
	String AM_Details_ReliseYear2017                                    = xlsInputData.getCellData("AM_Details", ClientData, 54);
	String AM_Details_ReliseYear2018                                    = xlsInputData.getCellData("AM_Details", ClientData, 55);
	String AM_Details_ReliseYear2009                                    = xlsInputData.getCellData("AM_Details", ClientData, 56);
	String AM_Details_ReliseYear2020                                    = xlsInputData.getCellData("AM_Details", ClientData, 57);
	String AM_Details_ReliseYear2021                                    = xlsInputData.getCellData("AM_Details", ClientData, 58);
	String AM_Details_ReliseYear2000                                    = xlsInputData.getCellData("AM_Details", ClientData, 59);
	String AM_Details_Radio1                                            = xlsInputData.getCellData("AM_Details", ClientData, 30);
	String AM_Details_Radio2                                            = xlsInputData.getCellData("AM_Details", ClientData, 31);
	String AM_Details_Radio3                                            = xlsInputData.getCellData("AM_Details", ClientData, 32);
	String AM_Details_Season1                                           = xlsInputData.getCellData("AM_Details", ClientData, 33);
	String AM_Details_Ep1                                               = xlsInputData.getCellData("AM_Details", ClientData, 34);
	String AM_Details_Ep2                                               = xlsInputData.getCellData("AM_Details", ClientData, 35);
	String AM_Details_SelectAll                                         = xlsInputData.getCellData("AM_Details", ClientData, 151);
	String AM_Details_Ok                                                = xlsInputData.getCellData("AM_Details", ClientData, 152);
	String AM_Details_Cancel                                            = xlsInputData.getCellData("AM_Details", ClientData, 153);
	String AM_Details_CountryofOriginData                               = xlsInputData.getCellData("AM_Details", ClientData, 126);
	String AM_Details_UniversalID                                       = xlsInputData.getCellData("AM_Details", ClientData, 157);
	String AM_Details_SystemData                                        = xlsInputData.getCellData("AM_Details", ClientData, 159);
	String AM_Details_CreatedByData                                     = xlsInputData.getCellData("AM_Details", ClientData, 27); 
	String AM_Details_SynopsisData                                      = xlsInputData.getCellData("AM_Details", ClientData, 28); 
	
	

   //AM_Premiere   
	String AM_Premiere_AssetType 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 11);
	String AM_Premiere_DealName 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 52);
	String AM_Premiere_DealDescription 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 53);
	String AM_Premiere_OrigNetwork 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 54);
	String AM_Premiere_AirNetwork 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 55);
	String AM_Premiere_MediaPlatform 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 56);
	String AM_Premiere_MediaPlatform1 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 71);
	String AM_Premiere_RightsType 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 57);
	String AM_Premiere_Country 				                           = xlsInputData.getCellData("AM_Premiere", ClientData, 58);
	String AM_Premiere_PlatformFlag 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 59);
	String AM_Premiere_PremiereDate 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 60);
	String AM_Premiere_FromSystem 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 61);
	String AM_Premiere_PremiereTime 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 62);
	String AM_Premiere_Duration 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 63);
	String AM_Premiere_ProductOffering                                 = xlsInputData.getCellData("AM_Premiere", ClientData, 64);
	String AM_Premiere_AssetName                                       = xlsInputData.getCellData("AM_Premiere", ClientData, 66);
	String AM_Premiere_AirTerritory 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 67);

	//Keys
	String AM_Premiere_DealName_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 52);
	String AM_Premiere_DealDescription_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 53);
	String AM_Premiere_OrigNetwork_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 54);
	String AM_Premiere_AirNetwork_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 55);
	String AM_Premiere_MediaPlatform_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 56);
	String AM_Premiere_RightsType_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 57);
	String AM_Premiere_Country_Key 				                       = xlsInputData.getCellData("AM_Premiere", "Keys", 58);
	String AM_Premiere_PlatformFlag_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 59);
	String AM_Premiere_PremiereDate_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 60);
	String AM_Premiere_FromSystem_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 61);
	String AM_Premiere_PremiereTime_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 62);
	String AM_Premiere_Duration_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 63);
	String AM_Premiere_ProductOffering_Key                             = xlsInputData.getCellData("AM_Premiere", "Keys", 64);
	String AM_Premiere_AssetName_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 66);
	String AM_Premiere_AirTerritory_Key 				               = xlsInputData.getCellData("AM_Premiere", "Keys", 68);
	String AM_Premiere_DealNameImg_Key 				                   = xlsInputData.getCellData("AM_Premiere", "Keys", 72);
	//Alert 
	String AM_Premiere_WithoutEnteringAnyData 				           = xlsInputData.getCellData("AM_Premiere", ClientData, 18);
	String AM_Premiere_DeleteBtnWithoutSelectingRow 				   = xlsInputData.getCellData("AM_Premiere", ClientData, 19);
	String AM_Premiere_ConfirmAlertForDeleteRow 				       = xlsInputData.getCellData("AM_Premiere", ClientData, 20);
	String AM_Premiere_AssetNotlinked 				                   = xlsInputData.getCellData("AM_Premiere", ClientData, 21);
	String AM_Premiere_MasterDeallinkedAlert 				           = xlsInputData.getCellData("AM_Premiere", ClientData, 22);
	String AM_Premiere_MediaPlatformAlert 				               = xlsInputData.getCellData("AM_Premiere", ClientData, 23);
	String AM_Premiere_OutletData 				                       = xlsInputData.getCellData("AM_Premiere", ClientData, 3);
	//Data
	String AM_Premiere_OrigNetworkData                                 = xlsInputData.getCellData("AM_Premiere", ClientData, 2);
	String AM_Premiere_AirNetworkData                                  = xlsInputData.getCellData("AM_Premiere", ClientData, 3);
	String AM_Premiere_MediaData                                       = xlsInputData.getCellData("AM_Premiere", ClientData, 4);
	String AM_Premiere_PremiereData                                    = xlsInputData.getCellData("AM_Premiere", ClientData, 5);
	String AM_Premiere_RightsTypeData                                  = xlsInputData.getCellData("AM_Premiere", ClientData, 6);
	String AM_Premiere_CountryData                                     = xlsInputData.getCellData("AM_Premiere", ClientData, 7);
	String AM_Premiere_PremiereTimeData                                = xlsInputData.getCellData("AM_Premiere", ClientData, 8);
	String AM_Premiere_DurationData                                    = xlsInputData.getCellData("AM_Premiere", ClientData, 9);
	String AM_Premiere_AirDateData                                     = xlsInputData.getCellData("AM_Premiere", ClientData, 10);
	String AM_Premiere_AirTerritoryData                                = xlsInputData.getCellData("AM_Premiere", ClientData, 12);
	String AM_Premiere_ProductOfferingData                             = xlsInputData.getCellData("AM_Premiere", ClientData, 13);
	//Button
	String AM_Premiere_Add                                             = xlsInputData.getCellData("AM_Premiere", ClientData, 26);
	String AM_Premiere_Delete                                          = xlsInputData.getCellData("AM_Premiere", ClientData, 27);
	String AM_Premiere_Save                                            = xlsInputData.getCellData("AM_Premiere", ClientData, 28);
	String AM_Premiere_Cancel                                          = xlsInputData.getCellData("AM_Premiere", ClientData, 29);


	//AM_Conrtibutors
	//// AllKeys
	String Conrtibutors_AppliesTo_ViewMode_Key 				           = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 2);
	String Conrtibutors_RankOrder_ViewEditMode_Key 				       = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 3);
	String Conrtibutors_PromotableStar_ViewMode_Key 				   = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 4);
	String Conrtibutors_Name_ViewMode_Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 5);
	String Conrtibutors_Role_ViewMode_Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 6);
	String Conrtibutors_Character_ViewEditMode_Key 				       = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 7);
	String Conrtibutors_ContactInformation_ViewEditMode_Key 		   = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 8);
	String Conrtibutors_Guild_ViewEditMode_Key 				           = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 9);
	String Conrtibutors_Notes_ViewMode_Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 10);

	//Headers Key on Edit Contributor window
	String Conrtibutors_AppliesTo_EditMode_Key 				           = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 23);
	String Conrtibutors_PromotableStar_EditMode_Key 				   = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 24);
	String Conrtibutors_Name_EditMode__Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 25);
	String Conrtibutors_Role_EditMode_Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 26);
	String Conrtibutors_Notes_EditMode_Key 				               = xlsInputData.getCellData("AM_Conrtibutors", "Keys", 27);

	////All Values of Contributor TAB
	String Conrtibutors_AppliesTo_ViewMode_Value                       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 2);
	String Conrtibutors_RankOrder_ViewEditMode_Value 				   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 3);
	String Conrtibutors_PromotableStar_ViewMode_Value 				   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 4);
	String Conrtibutors_Name_ViewMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 5);
	String Conrtibutors_Role_ViewMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 6);
	String Conrtibutors_Character_ViewEditMode_Value 				   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 7);
	String Conrtibutors_ContactInformation_ViewEditMode_Value 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 8);
	String Conrtibutors_Guild_ViewEditMode_Value 				       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 9);
	String Conrtibutors_Notes_ViewMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 10);

	//Headers on Edit Contributor window
	String Conrtibutors_AppliesTo_EditMode_Value 				       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 23);
	String Conrtibutors_PromotableStar_EditMode_Value 				   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 24);
	String Conrtibutors_Name_EditMode__Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 25);
	String Conrtibutors_Role_EditMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 26);
	String Conrtibutors_Notes_EditMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 27);

	String Conrtibutors_AddButton_EditMode_Value 				       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 51);
	String Conrtibutors_DeleteButton_EditMode_Value 				   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 52);
	String Conrtibutors_Save_EditMode__Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 53);
	String Conrtibutors_Cancel_EditMode_Value 				           = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 54);
	////ConrtibutorsEdit_ConrtibutorsSearch
	String Conrtibutors_ConrtibutorsSearch_FirstName_Value 			   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 31);
	String Conrtibutors_ConrtibutorsSearch_LastName_Value 			   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 32);
	String Conrtibutors_ConrtibutorsSearch_CompanyName_Value 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 33);
	String Conrtibutors_ConrtibutorsSearch_CompanyType_Value 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 34);
	String Conrtibutors_DeleteAlertMessage                             = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 55);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddButton_Value 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 56);
	String ConrtibutorsEdit_ConrtibutorsSearch_EditButton_Value 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 57);
	String ConrtibutorsEdit_ConrtibutorsSearch_DeActivateButton_Value  = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 58);
	String ConrtibutorsEdit_ConrtibutorsSearch_ExportButton_Value      = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 59);
	String ConrtibutorsEdit_ConrtibutorsSearch_SelectButton_Value 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 60);
	String ConrtibutorsEdit_ConrtibutorsSearch_CancelButton_Value 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 61);
	//// ConrtibutorsEdit_ConrtibutorsSearch_Add Window
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Prefix        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 71);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_FirstName 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 72);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_MiddleName    = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 73);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_LastName 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 74);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Suffix 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 75);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKA 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 76);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKAAdd        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 77);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AKADelete 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 78);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine1  = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 79);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_AddressLine2  = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 80);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_City 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 81);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_Country       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 82);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_State 		   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 83);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_ZipCode 	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 84);
	String ConrtibutorsEdit_ConrtibutorsSearch_AddWindow_User          = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 85);
	String ContributorSearch_Add_BusinessPhoneLabel 	               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 86);
	String ContributorSearch_Add_PrimaryEmailLabel 		               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 87);
	String ContributorSearch_Add_WebAddressLabel 		               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 94);
	String ContributorSearch_Add_ClearAddressLabel 		               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 95);
	String ContributorSearch_Add_AddCustomAddressTypeLabel             = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 96);
	String ContributorSearch_Add_CancelAllPopupLabel                   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 97);
	String ContributorSearch_Add_ClosePopupLabel 		               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 98);
	String ContributorSearch_Add_AKA_AlternateNameHeader               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 99);
	String Contributor_ContributorSearch_Add_AKA_TypeHeader			   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 100);
	String ContributorSearch_Add_SaveGeneralInfo_EnterAleternateMsg    = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 111);
	String ContributorSearch_Add_AddressTypeDropDownValue			   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 113);
	String ContributorSearch_Add_ClearAddress_ValidationMessage        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 116);
	String ContributorSearch_Add_DeleteAlias_ValidationMessage         = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 117);
	String ContributorSearch_Add_Saved_ValidationMessage               = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 118);
	String ContributorSearch_Editbutton_WrongCharactersGivenMsg        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 119);
	String ContributorSearch_Editbutton_DoNotSelectContirutorMsg       = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 120);
	String ContributorSearch_ManadatryFieldValidationMessageMsg        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 121);
	String ContributorSearch_Warning_RadioButton1_ValidationMessage    = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 122);
	String ContributorSearch_Warning_RadioButton2_ValidationMessage	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 123);
	String ContributorSearch_Warning_RadioButton3_ValidationMessage	   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 124);
	String ContributorSearch_enterZeroRankOrder			   			   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 125);

	// Contributor_ContributorSearch_Add_Add Reference Type 
	String ContributorSearch_Add_AddReferenceValue_ReferenceTypeIDLabel = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 131);
	String ContributorSearch_Add_AddReferenceValue_ReferenceTypeLabel   = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 132);
	String ContributorSearch_Add_AddReferenceValue_ValueLabel		    = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 133);
	String ContributorSearch_Add_AddReferenceValue_DisplayValueLabel	= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 134);
	String ContributorSearch_Add_AddReferenceValue_DisplayOrderLabel	= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 135);
	String ContributorSearch_Add_AddReferenceValue_SelectModuleLabel	= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 136);
	String ContributorSearch_Add_AddReferenceValue_DisplaycheckBoxLabel	= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 137);
	String ContributorSearch_Add_AddReferenceValue_Attribute1Label		= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 138);
	String ContributorSearch_Add_AddReferenceValue_Attribute2Label		= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 139);
	String ContributorSearch_Add_AddReferenceValue_Attribute3Label		= xlsInputData.getCellData("AM_Conrtibutors", ClientData, 140);
	String Contributor_Network1	                                        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 143);
	String Contributor_Network2	                                        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 144);
	String Contributor_Network3	                                        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 145);
	String Contributor_Role		                                        = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 146);
	// Parties at Add Contributor Window
	String Contributor_ExternalParties		                            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 41);
	String Contributor_CompaniesParties		                            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 42);
	String Contributor_InternalParties		                            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 43);
	// 
	String Contributor_ContributorSearch_Add_Comm_Home 		            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 89);
	String Contributor_ContributorSearch_Add_Comm_Mobile	            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 90);
	String Contributor_ContributorSearch_Add_Comm_Personal 	            = xlsInputData.getCellData("AM_Conrtibutors", ClientData, 91);

//AM_Episode
	String All 														   = xlsInputData.getCellData("AM_Episode", ClientData, 161);
	String Season1 				 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 162);
	String S1_Episode101 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 163);
	String S1_Episode102 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 164);
	String S1_Episode103 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 165);
	String Season2 				 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 166);
	String S2_Episode201 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 167);
	String S2_Episode202 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 168);
	String S2_Episode203 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 169);
	String Season3 				 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 170);
	String S3_Episode301 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 171);
	String S3_Episode302 		 		                               = xlsInputData.getCellData("AM_Episode", ClientData, 172);

	//// All keys
	String Episode_TitleKey	 		                                    = xlsInputData.getCellData("AM_Episode", "Keys", 2);
	String Episode_Seasion 			                                    = xlsInputData.getCellData("AM_Episode", "Keys", 3);
	String Episode_Episode_Number 	                                    = xlsInputData.getCellData("AM_Episode", "Keys", 4);
	String Episode_TBAKey 			                                    = xlsInputData.getCellData("AM_Episode", "Keys", 5);
	String Episode_AirDateKey 		                                    = xlsInputData.getCellData("AM_Episode", "Keys", 6);
	String Episode_SeasonOpenerKey                                      = xlsInputData.getCellData("AM_Episode", "Keys", 7);
	String Episode_SeasonCloserKey                                      = xlsInputData.getCellData("AM_Episode", "Keys", 8);
	String Episode_SeriesOpener 	                                    = xlsInputData.getCellData("AM_Episode", "Keys", 9);
	String Episode_SeriesCloser 	                                    = xlsInputData.getCellData("AM_Episode", "Keys", 10);
	String Episode_AirOrder 		                                    = xlsInputData.getCellData("AM_Episode", "Keys", 11);
	String Episode_ProgramDuration                                      = xlsInputData.getCellData("AM_Episode", "Keys", 12);
	String Episode_Highlights 		                                    = xlsInputData.getCellData("AM_Episode", "Keys", 13);
	String Episode_Notes 			                                    = xlsInputData.getCellData("AM_Episode", "Keys", 14);
	String Episode_IPS_AVAILABILITY_DATEKey                             = xlsInputData.getCellData("AM_Episode", "Keys", 15);
	String Episode_Cue_Sheet_IDKey                                      = xlsInputData.getCellData("AM_Episode", "Keys", 16);
	String Episode_VMIDKey 			                                    = xlsInputData.getCellData("AM_Episode", "Keys", 17);
	//// TURNER HEADERS
	String Episode_SYNDICATIONNOKey                                     = xlsInputData.getCellData("AM_Episode", "Keys", 18);
	String Episode_SHORTNAMEKey 	                                    = xlsInputData.getCellData("AM_Episode", "Keys", 19);
	//// SALESDEMO HEADER
	String Episode_FLAG_LIBRARYKey 			                            = xlsInputData.getCellData("AM_Episode", "Keys", 20);
	String Episode_RID_MATCH_CATEGORYKey 		                        = xlsInputData.getCellData("AM_Episode", "Keys", 21);
	String Episode_RID_VENUEKey 				                        = xlsInputData.getCellData("AM_Episode", "Keys", 22);
	String Episode_RID_ROUND_OF_SERIESKey 		                        = xlsInputData.getCellData("AM_Episode", "Keys", 23);
	String Episode_RID_ASSET_CATEGORYKey 		                        = xlsInputData.getCellData("AM_Episode", "Keys", 24);
	String Episode_LIST_OF_TEAMS_TEXTKey 		                        = xlsInputData.getCellData("AM_Episode", "Keys", 25);
	//// CORUS HEADER
	String Episode_SEASON_NUMBERKey 	                                = xlsInputData.getCellData("AM_Episode", "Keys", 26);
	String Episode_Season_ViewModeKey 	                                = xlsInputData.getCellData("AM_Episode", "Keys", 29);

	//// All Values
	String Episode_TitleValue 				                            = xlsInputData.getCellData("AM_Episode", ClientData, 2);
	String Episode_SeasonValue 				                            = xlsInputData.getCellData("AM_Episode", ClientData, 3);
	String Episode_Episode_NumberValue	                                = xlsInputData.getCellData("AM_Episode", ClientData, 4);
	String Episode_TBAValue 				                            = xlsInputData.getCellData("AM_Episode", ClientData, 5);
	String Episode_AirDateValue 		                                = xlsInputData.getCellData("AM_Episode", ClientData, 6);
	String Episode_SeasonOpenerValue		                            = xlsInputData.getCellData("AM_Episode", ClientData, 7);
	String Episode_SeasonCloserValue 		                            = xlsInputData.getCellData("AM_Episode", ClientData, 8);
	String Episode_SeriesOpenerValue 	                                = xlsInputData.getCellData("AM_Episode", ClientData, 9);
	String Episode_SeriesCloserValue 		                            = xlsInputData.getCellData("AM_Episode", ClientData, 10);
	String Episode_AirOrderValue 			                            = xlsInputData.getCellData("AM_Episode", ClientData, 11);
	String Episode_ProgramDurationValue 	                            = xlsInputData.getCellData("AM_Episode", ClientData, 12);
	String Episode_HighlightsValue 			                            = xlsInputData.getCellData("AM_Episode", ClientData, 13);
	String Episode_NotesValue 				                            = xlsInputData.getCellData("AM_Episode", ClientData, 14);
	String Episode_IPS_AVAILABILITY_DATEValue	                        = xlsInputData.getCellData("AM_Episode", ClientData, 15);
	String Episode_Cue_Sheet_IDValue 		                            = xlsInputData.getCellData("AM_Episode", ClientData, 16);
	String Episode_VMIDValue 				                            = xlsInputData.getCellData("AM_Episode", ClientData, 17);
	//// TURNER HEADERS
	String Episode_SYNDICATIONNOValue	                                = xlsInputData.getCellData("AM_Episode", ClientData, 18);
	String Episode_SHORTNAMEValue	                                    = xlsInputData.getCellData("AM_Episode", ClientData, 19);
	//// SALESDEMO HEADER
	String Episode_FLAG_LIBRARYValue 	                                = xlsInputData.getCellData("AM_Episode", ClientData, 20);
	String Episode_RID_MATCH_CATEGORYValue	                            = xlsInputData.getCellData("AM_Episode", ClientData, 21);
	String Episode_RID_VENUEValue	                                    = xlsInputData.getCellData("AM_Episode", ClientData, 22);
	String Episode_RID_ROUND_OF_SERIESValue 	                        = xlsInputData.getCellData("AM_Episode", ClientData, 23);
	String Episode_RID_ASSET_CATEGORYValue	                            = xlsInputData.getCellData("AM_Episode", ClientData, 24);
	String Episode_LIST_OF_TEAMS_TEXTValue 	                            = xlsInputData.getCellData("AM_Episode", ClientData, 25);
	//// CORUS HEADER
	String Episode_SEASON_NUMBERValue 	                                = xlsInputData.getCellData("AM_Episode", ClientData, 26);
	String Episode_Season_ViewModeHeader 	                            = xlsInputData.getCellData("AM_Episode", ClientData, 28);


	String Episode_EditEpisodes 	                                    = xlsInputData.getCellData("AM_Episode", ClientData, 100);
	String Episode_Edit	                                                = xlsInputData.getCellData("AM_Episode", ClientData, 101);
	String Episode_FilterLabel1 	                                    = xlsInputData.getCellData("AM_Episode", ClientData, 102);
	String Episode_FilterLabel2 	                                    = xlsInputData.getCellData("AM_Episode", ClientData, 103);

	String Episode_CopyEpisodesValue 	                                = xlsInputData.getCellData("AM_Episode", ClientData, 104);
	String Episodes_CopySeason 		                                    = xlsInputData.getCellData("AM_Episode", ClientData, 105);
	String Episodes_UpdateTool 	                                   	    = xlsInputData.getCellData("AM_Episode", ClientData, 106);
	String Episodes_Add 			                                    = xlsInputData.getCellData("AM_Episode", ClientData, 107);
	String Episodes_Delete 			                                    = xlsInputData.getCellData("AM_Episode", ClientData, 108);
	String Episodes_Save 		                                      	= xlsInputData.getCellData("AM_Episode", ClientData, 109);
	String Episodes_Close 			                                    = xlsInputData.getCellData("AM_Episode", ClientData, 110);
	String Episodes_AddEpisodes	                                        = xlsInputData.getCellData("AM_Episode", ClientData, 111);
	
	////
	String Episodes_AddEpisodesWindowMessage                            = xlsInputData.getCellData("AM_Episode", ClientData, 112);
	String Episodes_OKButton_AddEpisodesWindow                          = xlsInputData.getCellData("AM_Episode", ClientData, 113);
	String Episodes_Cancel_AddEpisodesWindow                            = xlsInputData.getCellData("AM_Episode", ClientData, 114);
	// Update Tool
	String Episodes_UpdateTool_TBAValueCheckBox  	                    = xlsInputData.getCellData("AM_Episode", ClientData, 119);
	String Episodes_UpdateTool_SeasonCheckBox  			                = xlsInputData.getCellData("AM_Episode", ClientData, 120);
	String Episodes_UpdateTool_DurationValueCheckBox                    = xlsInputData.getCellData("AM_Episode", ClientData, 121);
	String Episodes_UpdateTool_EpisodeHeader  			                = xlsInputData.getCellData("AM_Episode", ClientData, 122);
	String Episodes_UpdateTool_UpdateEpisodeTitle  		                = xlsInputData.getCellData("AM_Episode", ClientData, 123);
	String Episodes_UpdateTool_TitleLabel  				                = xlsInputData.getCellData("AM_Episode", ClientData, 124);
	String Episodes_UpdateTool_Highlights                               = xlsInputData.getCellData("AM_Episode", ClientData, 142);
	String Episodes_UpdateTool_No_of_Highlights                         = xlsInputData.getCellData("AM_Episode", ClientData, 143);
	String Episodes_UpdateTool_Duration                                 = xlsInputData.getCellData("AM_Episode", ClientData, 144);
	String Episodes_UpdateTool_SelectALL_Button                         = xlsInputData.getCellData("AM_Episode", ClientData, 145);
	String Episodes_UpdateTool_DeselectAll                              = xlsInputData.getCellData("AM_Episode", ClientData, 146);
	String Episodes_UpdateTool_OK                                       = xlsInputData.getCellData("AM_Episode", ClientData, 147);
	String Episodes_UpdateTool_Cancel                                   = xlsInputData.getCellData("AM_Episode", ClientData, 148);
	String Episodes_UpdateTool_Combine                                  = xlsInputData.getCellData("AM_Episode", ClientData, 150);
	String Episodes_UpdateTool_EpisodeName                              = xlsInputData.getCellData("AM_Episode", ClientData, 151);
	String Episodes_UpdateTool_Episode_No                               = xlsInputData.getCellData("AM_Episode", ClientData, 152);
	// Copy Episodes
	String CopyEpisodes_CopyAssetWindow_CreateNewAsset_RadioButton      = xlsInputData.getCellData("AM_Episode", ClientData, 125);
	String CopyEpisodes_CopyAssetWindow_LinkAssettoDeal_RadioButton     = xlsInputData.getCellData("AM_Episode", ClientData, 126);
	String Episodes_CopyEpisodes_CopyAssetWindow_Versionselector        = xlsInputData.getCellData("AM_Episode", ClientData, 127);
	String CopyEpisodes_CopyAssetWindow_Versionselector_FirstOption     = xlsInputData.getCellData("AM_Episode", ClientData, 128);
	String Episodes_EditEpisodes_Userdefined_EditSeasonLabel            = xlsInputData.getCellData("AM_Episode", ClientData, 133);

	String DeleteEpisodes_AlertMessage		                            = xlsInputData.getCellData("AM_Episode", ClientData, 134);
	String Episodes_SelectSingleEpisodeToCopySeason                     = xlsInputData.getCellData("AM_Episode", ClientData, 201);
	String Episodes_CopyEpisodes_AlertMessage                     		= xlsInputData.getCellData("AM_Episode", ClientData, 202);
	String Episodes_Copyseason_AlertMessage                     		= xlsInputData.getCellData("AM_Episode", ClientData, 203);
	String Episodes_SameEpiWithWSameVersion_AlertMessage                = xlsInputData.getCellData("AM_Episode", ClientData, 204);
	String Episodes_DoNotSelectEpisode_Delete_AlertMessage              = xlsInputData.getCellData("AM_Episode", ClientData, 205);
	String Episodes_SameAiringOrder_Delete_AlertMessage              	= xlsInputData.getCellData("AM_Episode", ClientData, 206);
	String Episodes_DoNotEnerVersionType_AlertMessage              	= xlsInputData.getCellData("AM_Episode", ClientData, 207);

		//AM_RelatedPrograms
	String AMRelatedProgAppliesTO                                       = xlsInputData.getCellData("AM_RelatedProg", "KeyValues", 2);
	String AMRelatedProgStartCode                                       = xlsInputData.getCellData("AM_RelatedProg", "KeyValues", 3);
	String AMRelatedProgEndCode                                         = xlsInputData.getCellData("AM_RelatedProg", "KeyValues", 4);

//Data for AM Asset Navigator
	String AssetNavigatorSeasonNameTest                                 = xlsInputData.getCellData("AMAssetNavigator", ClientData, 17);
	String AssetNavigatorSeasonNameValue                                = xlsInputData.getCellData("AMAssetNavigator", ClientData, 18);
	String DefaultSeasonname                                            = xlsInputData.getCellData("AMAssetNavigator", ClientData, 2); 
	String AssetNavigatorAppliesto                                      = xlsInputData.getCellData("AMAssetNavigator", ClientData, 26);
	String AssetNavigatorSeasonName1                                    = xlsInputData.getCellData("AMAssetNavigator", ClientData, 27);
	String AssetNavigatorSeasonName2                                    = xlsInputData.getCellData("AMAssetNavigator", ClientData, 28);
	String AssetNavigatorVMID                                           = xlsInputData.getCellData("AMAssetNavigator", ClientData, 29);
	String AssetNavigatorRightsVersionType                              = xlsInputData.getCellData("AMAssetNavigator", ClientData, 30);
	String AssetNavigatorSave                                           = xlsInputData.getCellData("AMAssetNavigator", ClientData, 31);
	String AssetNavigatorCancel                                         = xlsInputData.getCellData("AMAssetNavigator", ClientData, 32);
	String AssetNavigatorSeasonName                                     = xlsInputData.getCellData("AMAssetNavigator", ClientData, 4);
	String AssetNavigatorRightsVersionTypeData                          = xlsInputData.getCellData("AMAssetNavigator", ClientData, 5);
	String AssetNavigatorRightsVersionTypeData1                         = xlsInputData.getCellData("AMAssetNavigator", ClientData, 6); 
	String AssetNavigatorAppliesto1                                     = xlsInputData.getCellData("AMAssetNavigator", ClientData, 33); 
	String AssetNavigatorEpisodeName                                    = xlsInputData.getCellData("AMAssetNavigator", ClientData, 34); 
	String AssetNavigatorEpisodeNumber                                  = xlsInputData.getCellData("AMAssetNavigator", ClientData, 35); 
	String AssetNavigatorInitialAirDate                                 = xlsInputData.getCellData("AMAssetNavigator", ClientData, 36); 
	String AssetNavigatorSave1                                          = xlsInputData.getCellData("AMAssetNavigator", ClientData, 37); 
	String AssetNavigatorcancel1                                        = xlsInputData.getCellData("AMAssetNavigator", ClientData, 38); 
	String EpisodeName103                                               = xlsInputData.getCellData("AMAssetNavigator", ClientData, 7); 
	String EpisodeNumber103                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 8); 
	String AssetNavigatorInitialAirDateInputDtata                       = xlsInputData.getCellData("AMAssetNavigator", ClientData, 9); 
	String AddedEpisode103                                              = xlsInputData.getCellData("AMAssetNavigator", ClientData, 10);  
	String EpisodeName104                                               = xlsInputData.getCellData("AMAssetNavigator", ClientData, 12); 
	String EpisodeNumber104                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 13); 
	String AssetNavigatorInitialAirDateInputDtata1                      = xlsInputData.getCellData("AMAssetNavigator", ClientData, 14); 
	String AssetNavigatorAssetTypeSeries                                = xlsInputData.getCellData("AMAssetNavigator", ClientData, 15);
	String AssetNavigatorAssetTypeMovie                                 = xlsInputData.getCellData("AMAssetNavigator", ClientData, 16);
	String AssetNavigatorChangeSeason                                   = xlsInputData.getCellData("AMAssetNavigator", ClientData, 19);
	String Loc_EpisodeAAA                                               = xlsInputData.getCellData("AMAssetNavigator", ClientData, 11);
	String Loc_Episode111                                               = xlsInputData.getCellData("AMAssetNavigator", ClientData, 20);
	String Loc_Ep111AAA                                                 = xlsInputData.getCellData("AMAssetNavigator", ClientData, 21);
	String VerifyEpisode001                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 42);
	String VerifyEpisode002                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 43);
	String VerifyEpisode003                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 44);
	String VerifyEpisode004                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 45);
	String VerifyEpisode005                                             = xlsInputData.getCellData("AMAssetNavigator", ClientData, 46);
	String DeleteSeasonConfirmAlertMsg                                  = xlsInputData.getCellData("AMAssetNavigator", ClientData, 47);
	String EpisodeNameAlertMsg                                          = xlsInputData.getCellData("AMAssetNavigator", ClientData, 48); 
	String EpisodeNumberAlertMsg                                        = xlsInputData.getCellData("AMAssetNavigator", ClientData, 49); 
	String EposodeSaveValidationMsg                                     = xlsInputData.getCellData("AMAssetNavigator", ClientData, 50); 
	String EposodeRowWithoutSeletingDeleteBtmAlertMsg                   = xlsInputData.getCellData("AMAssetNavigator", ClientData, 51); 

	
	//Data for AM_Version
	String NameHeader                                                   = xlsInputData.getCellData("AMVersion", ClientData, 52);
	String VersionTypeHeader                                            = xlsInputData.getCellData("AMVersion", ClientData, 53);
	String SerialNumberHeader                                           = xlsInputData.getCellData("AMVersion", ClientData, 54);
	String LanguageHeader                                               = xlsInputData.getCellData("AMVersion", ClientData, 55);
	String FormatHeader                                                 = xlsInputData.getCellData("AMVersion", ClientData, 56);
	String PlanningLengthHeader                                         = xlsInputData.getCellData("AMVersion", ClientData, 57);
	String MAX_RUNTIMEHeader                                            = xlsInputData.getCellData("AMVersion", ClientData, 58);
	String RUNTIMEHeader                                                = xlsInputData.getCellData("AMVersion", ClientData, 59);
	String LONG_SHORT_RUNTIMEHeader                                     = xlsInputData.getCellData("AMVersion", ClientData, 60);
	String EXTRA_AVAILSHeader                                           = xlsInputData.getCellData("AMVersion", ClientData, 61);
	String NETWORKHeader                                                = xlsInputData.getCellData("AMVersion", ClientData, 62);
	String FLAG_NETWORK_DEFAULTHeader                                   = xlsInputData.getCellData("AMVersion", ClientData, 63);
	String ActiveHeader                                                 = xlsInputData.getCellData("AMVersion", ClientData, 64);
	String FLAG_DAYTIME_PLAYABLEHeader                                  = xlsInputData.getCellData("AMVersion", ClientData, 65);
	String EARLIEST_TIMEHeader                                          = xlsInputData.getCellData("AMVersion", ClientData, 66);
	String RID_TVPARENTALRATINGHeader                                   = xlsInputData.getCellData("AMVersion", ClientData, 67);
	String RATING_WARNINGHeader                                         = xlsInputData.getCellData("AMVersion", ClientData, 68);
	String AUDIOHeader 					                                = xlsInputData.getCellData("AMVersion", ClientData, 69);
	String COLORHeader 					                                = xlsInputData.getCellData("AMVersion", ClientData, 70);
	String DUBBED_LANGUAGEHeader 		                                = xlsInputData.getCellData("AMVersion", ClientData, 71);
	String SUBTITLED_LANGUAGEHeader 	                                = xlsInputData.getCellData("AMVersion", ClientData, 72);
	String ASPECTRATIOHeader			                                = xlsInputData.getCellData("AMVersion", ClientData, 73);
	String DIRCUTHeader 				                                = xlsInputData.getCellData("AMVersion", ClientData, 74);
	String INTERMISSIONHeader 			                                = xlsInputData.getCellData("AMVersion", ClientData, 75);
	String CCAPHeader                                                   = xlsInputData.getCellData("AMVersion", ClientData, 76);
	String BLOCK_STATUSHeader                                           = xlsInputData.getCellData("AMVersion", ClientData, 77);
	String STANDARDHeader                                               = xlsInputData.getCellData("AMVersion", ClientData, 78);
	String TAPE_STATUSHeader                                            = xlsInputData.getCellData("AMVersion", ClientData, 79);
	String DEFAULTHeader                                                = xlsInputData.getCellData("AMVersion", ClientData, 80);
	String COMMERCIAL_LOADHeader                                        = xlsInputData.getCellData("AMVersion", ClientData, 81);
	String SCHEDULE_BLOCKHeader                                         = xlsInputData.getCellData("AMVersion", ClientData, 82);
	String ALTERED_FILM_SPECIAL_EVENTHeader                             = xlsInputData.getCellData("AMVersion", ClientData, 83);
	String FORMAT_DESCRIPTIONHeader                                     = xlsInputData.getCellData("AMVersion", ClientData, 84);
	String DISCLAIMERHeader                                             = xlsInputData.getCellData("AMVersion", ClientData, 85);
	String NOTEHeader                                                   = xlsInputData.getCellData("AMVersion", ClientData, 86);
	String RATING_ISSUESHeader                                          = xlsInputData.getCellData("AMVersion", ClientData, 87);
	String AMVerLANGUAGE_IMAGEHeader                                    = xlsInputData.getCellData("AMVersion", ClientData, 88);
	String DANHeader                                                    = xlsInputData.getCellData("AMVersion", ClientData, 89);
	String RATINGHeader                                                 = xlsInputData.getCellData("AMVersion", ClientData, 90);
	String VODHeader                                                    = xlsInputData.getCellData("AMVersion", ClientData, 91);
	String HDAvailProgramSummary                                        = xlsInputData.getCellData("AMVersion", ClientData, 99);








	//Edit Version Buttons
	String AddButton 									= xlsInputData.getCellData("AMVersion", ClientData, 101);
	String VersionType 									= xlsInputData.getCellData("AMVersion", ClientData, 2);
	String Language 									= xlsInputData.getCellData("AMVersion", ClientData, 3);
	String Format 										= xlsInputData.getCellData("AMVersion", ClientData, 4);
	String Network 										= xlsInputData.getCellData("AMVersion", ClientData, 5);
	String AMVerDuration 								= xlsInputData.getCellData("AMVersion", ClientData, 6);
	String CopyAlertMessage 							= xlsInputData.getCellData("AMVersion", ClientData, 107);
	String DeleteAlertMessage 							= xlsInputData.getCellData("AMVersion", ClientData, 108);
	String defaultCheckBoxAlert							= xlsInputData.getCellData("AMVersion", ClientData, 109);
	String ValdMsgOnEneringSameVersionName				= xlsInputData.getCellData("AMVersion", ClientData, 110);

	//AM_Versions keys
	String AMVerNameKey                                     = xlsInputData.getCellData("AMVersion", "Keys", 52);
	String AMVerVersionTypeKey 								= xlsInputData.getCellData("AMVersion", "Keys", 53);
	String AMVerSerialNumKey  								= xlsInputData.getCellData("AMVersion", "Keys", 54);
	String AMVerLanguageKey  								= xlsInputData.getCellData("AMVersion", "Keys", 55);
	String AMVerFormatKey  								    = xlsInputData.getCellData("AMVersion", "Keys", 56);
	String AMVerBlockLengthKey 								= xlsInputData.getCellData("AMVersion", "Keys", 57);
	String AMVerFormatTargetDurationKey  					= xlsInputData.getCellData("AMVersion", "Keys", 58);
	String AMVerTotalActualRuntimeKey  						= xlsInputData.getCellData("AMVersion", "Keys", 59);
	String AMVerRunsLongShortKey  							= xlsInputData.getCellData("AMVersion", "Keys", 60);
	String AMVerExtraAvailsKey  							= xlsInputData.getCellData("AMVersion", "Keys", 61);
	String AMVerNetworkKey  								= xlsInputData.getCellData("AMVersion", "Keys", 62);
	String AMVerNetworkDefaultKey  							= xlsInputData.getCellData("AMVersion", "Keys", 63);
	String AMVerActiveKey  									= xlsInputData.getCellData("AMVersion", "Keys", 64);
	String AMVerDaytimePlayableKey  						= xlsInputData.getCellData("AMVersion", "Keys", 65);
	String AMVerEarliestTimeKey  							= xlsInputData.getCellData("AMVersion", "Keys", 66);
	String AMVerTVParentalRatingKey  						= xlsInputData.getCellData("AMVersion", "Keys", 67);
	String AMVerRatingNotesKey  							= xlsInputData.getCellData("AMVersion", "Keys", 68);
	String AMVerAudioKey  									= xlsInputData.getCellData("AMVersion", "Keys", 69);
	String AMVerHueKey  									= xlsInputData.getCellData("AMVersion", "Keys", 70);
	String AMVerDubbedKey  									= xlsInputData.getCellData("AMVersion", "Keys", 71);
	String AMVerSubtitledKey  								= xlsInputData.getCellData("AMVersion", "Keys", 72);
	String AMVerAspectRatioKey  							= xlsInputData.getCellData("AMVersion", "Keys", 73);
	String AMVerDirsCutKey  								= xlsInputData.getCellData("AMVersion", "Keys", 74);
	String AMVerIntermissionKey  							= xlsInputData.getCellData("AMVersion", "Keys", 75);
	String AMVerCCAPKey  									= xlsInputData.getCellData("AMVersion", "Keys", 76);
	String AMVerBlockStatusKey  							= xlsInputData.getCellData("AMVersion", "Keys", 77);
	String AMVerStandardKey  								= xlsInputData.getCellData("AMVersion", "Keys", 78);
	String AMVerTapeStatusKey  								= xlsInputData.getCellData("AMVersion", "Keys", 79);
	String AMVersionDefaultKey  							= xlsInputData.getCellData("AMVersion", "Keys", 80);
	String AMVerCommercialLoadKey  							= xlsInputData.getCellData("AMVersion", "Keys", 81);
	String AMVerScheduleBlockKey  							= xlsInputData.getCellData("AMVersion", "Keys", 82);
	String AMVerAlteredFilmKey  							= xlsInputData.getCellData("AMVersion", "Keys", 83);
	String AMVerGabrDescKey  								= xlsInputData.getCellData("AMVersion", "Keys", 84);
	String AMVerDisclaimerIDKey  							= xlsInputData.getCellData("AMVersion", "Keys", 85);
	String AMVerNotesKey  									= xlsInputData.getCellData("AMVersion", "Keys", 86);
	String AMVerParentalRatingExtKey  						= xlsInputData.getCellData("AMVersion", "Keys", 87);
	String AMVerLANGUAGE_IMAGEKey  							= xlsInputData.getCellData("AMVersion", "Keys", 88);
	String DANHeaderKey  									= xlsInputData.getCellData("AMVersion", "Keys", 89);
	String RATINGKey  										= xlsInputData.getCellData("AMVersion", "Keys", 90);
	String VODHeaderKey  									= xlsInputData.getCellData("AMVersion", "Keys", 91);


	//AM_RelatedAsset
	String AM_RelatedAsset_AppliesTo_Key  						= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 2);
	String AM_RelatedAsset_AssetTitle_Key 						= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 3);
	String AM_RelatedAsset_AssetType_Key 						= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 4);
	String AM_RelatedAsset_AssetID_Key  						= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 7);
	String AM_RelatedAsset_EpisodeNumber_Key 					= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 8);
	String AM_RelatedAsset_SourceSystem_Key  					= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 9);
	String AM_RelatedAsset_TitleVersion_Key  					= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 10);
	String AM_RelatedAsset_ROLE_Key  							= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 11);
	String AM_RelatedAsset_GUILD_Key 							= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 12);
	String AM_RelatedAsset_StartTimeCode_Key 					= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 13);
	String AM_RelatedAsset_EndTimeCode_Key  					= xlsInputData.getCellData("AM_RelatedAsset", "Keys", 14);
	String AM_RelatedAsset_AppliesTo  						   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 2);
	String AM_RelatedAsset_AssetTitle 						   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 3);
	String AM_RelatedAsset_AssetType 						   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 4);
	String AM_RelatedAsset_IPName  							   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 5);
	String AM_RelatedAsset_Vendor  							   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 6);
	String AM_RelatedAsset_AssetID  						   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 7);
	String AM_RelatedAsset_EpisodeNumber 					   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 8);
	String AM_RelatedAsset_SourceSystem  					   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 9);
	String AM_RelatedAsset_TitleVersion  					   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 10);
	String AM_RelatedAsset_ROLE  							   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 11);
	String AM_RelatedAsset_GUILD 							   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 12);
	String AM_RelatedAsset_StartTimeCode 					   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 13);
	String AM_RelatedAsset_EndTimeCode  					   = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 14);
	//Button
	String AM_RelatedAsset_Add                                 = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 49);
	String AM_RelatedAsset_Copy                                = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 50);
	String AM_RelatedAsset_Delete                              = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 51);
	String AM_RelatedAsset_Save                                = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 52);
	String AM_RelatedAsset_Cancel                              = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 53);
	//Alert
	String AM_RelatedAsset_ValidationMsg                        = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 26);
	String AM_RelatedAsset_AlertDuplicateMsg                    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 27);
	String AM_RelatedAsset_AlertCopyMsg                         = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 28);
	String AM_RelatedAsset_ConfDeleteMsg                        = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 29);
	String AM_RelatedAsset_AlertBeforeDeleteMsg                 = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 30);
	String AM_RelatedAsset_AlertSameAssetMsg                    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 31);
	

	
	 
	String AM_RelatedAsset_SeriesAssetTypeData     = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 59);
	String AM_RelatedAsset_MovieAssetTypeData      = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 60);
	String AM_RelatedAsset_EpisodeAssetTypeData    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 61);
	String AM_RelatedAsset_ApplesTo1         = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 31);
	String AssetTitle1                       = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 32);
	String AssetType                         = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 33);
	String IPName1                           = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 34);
	String Vendor1                           = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 35);
	String AssetID1                          = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 36);
	String EpisodeNumber1                    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 37);
	String SourceSystem1                     = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 38);
	String RelAssetMovie1                    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 5);
	String RelAssetEpi101                    = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 6);
	String ApplesToEidtMode                  = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 24);
	String AssetTitleEditMode                = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 25);
	
	
	
	String AM_RelatedAsset_RoleData                                 = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 68);
	String AM_RelatedAsset_GuildData                                = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 69);
	String AM_RelatedAsset_StartTimeCodeData1                            = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 71);
	String AM_RelatedAsset_EndTimeCodeData1                              = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 70);
	String AM_RelatedAsset_StartTimeCodeData2                        = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 70);
	String AM_RelatedAsset_EndTimeCodeData2                          = xlsInputData.getCellData("AM_RelatedAsset", ClientData, 71);
	
	
    //AM_Attributes
	String AM_AttributesAttributeKey 								= xlsInputData.getCellData("AM_Attributes", "Keys", 2);
	String AM_AttributesValue1Key 									= xlsInputData.getCellData("AM_Attributes", "Keys", 3);
	String AM_AttributesValue2Key 									= xlsInputData.getCellData("AM_Attributes", "Keys", 4);
	String AM_AttributesAppliesToKey 								= xlsInputData.getCellData("AM_Attributes", "Keys", 5);

	// Value of the Header
	String AM_AttributesAttributeValue_ViewMode 					= xlsInputData.getCellData("AM_Attributes", ClientData, 2);
	String AM_AttributesAttributeValue_EditMode 					= xlsInputData.getCellData("AM_Attributes", ClientData, 10);
	String AM_AttributesValue1Value 								= xlsInputData.getCellData("AM_Attributes", ClientData, 3);
	String AM_AttributesValue2Value 								= xlsInputData.getCellData("AM_Attributes", ClientData, 4);
	String AM_AttributesRangeAttributeStatus 						= xlsInputData.getCellData("AM_Attributes", ClientData, 5);
	// the Attribute Name is not editable for AMCN and it may be editable or not editable hence We made specific row for this
	String AM_AttributeNameEditableStatus 							= xlsInputData.getCellData("AM_Attributes", ClientData, 11);
	String AM_Attribute_ValidationMessage_EnteringInvalidData 		= xlsInputData.getCellData("AM_Attributes", ClientData, 12);
	String AM_Attribute_ValidationMessage_EnterValidNumericValue 	= xlsInputData.getCellData("AM_Attributes", ClientData, 13);
	String AM_Attribute_ValidationMessage_EnterDecimalValue 		= xlsInputData.getCellData("AM_Attributes", ClientData, 14);
	String AM_Attribute_ValidationMessage_EnterNonValidDecimalValue = xlsInputData.getCellData("AM_Attributes", ClientData, 15);
	String AM_Attribute_ValidationMessage_EnterValidDecimalValue 	= xlsInputData.getCellData("AM_Attributes", ClientData, 16);
	String AM_Attribute_ValidationMessage_EnterRangeValues 			= xlsInputData.getCellData("AM_Attributes", ClientData, 17);
	String AM_Attribute_ValidationMessage_EnterOnlyNumber 			= xlsInputData.getCellData("AM_Attributes", ClientData, 18);
	String AM_Attribute_ValidationMessage_EnterOnlyText 			= xlsInputData.getCellData("AM_Attributes", ClientData, 19);
	String AM_Attribute_ValidationMessage_InCorrectDateFormat 		= xlsInputData.getCellData("AM_Attributes", ClientData, 20);
	String AM_Attribute_CorrectFormatedDate 						= xlsInputData.getCellData("AM_Attributes", ClientData, 28);
	String AM_Attribute_InCorrectFormatedDate 						= xlsInputData.getCellData("AM_Attributes", ClientData, 29);

//AM_AssetSearch
	 // Search Drop Down Values
	String AssetSearch_Asset1 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 3);
	String AssetSearch_Asset2 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 4);
	String AssetSearch_Asset3 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 5);
	String AssetSearch_Asset4 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 6);
	String AssetSearch_HeaderName 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 7);
	   // Search Field
	String AssetSearch_AssetTitle 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 11);
	String AssetSearch_AssetID		 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 12);
	String AssetSearch_AssetType 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 13);
	String AssetSearch_AssetRightsVersionType = xlsInputData.getCellData("AM_AssetSearch", ClientData, 14);
	String AssetSearch_SBU 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 15);
	String AssetSearch_Genre 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 16);
	String AssetSearch_ShortName 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 17);
	String AssetSearch_IPName 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 18);
	String AssetSearch_AssetCategory 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 19);
	String AssetSearch_AssetSource 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 20);
	String AssetSearch_AssetStatus 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 21);
	String AssetSearch_Artist 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 22);
	String AssetSearch_Composer 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 23);
	String AssetSearch_PRODEntry 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 24);
	String AssetSearch_MMLEntry			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 25);
	String AssetSearch_ExpandToggleImagebtn_ShowMore= xlsInputData.getCellData("AM_AssetSearch", ClientData, 26);
	String AssetSearch_ExpandToggleImagebtn_ShowLess= xlsInputData.getCellData("AM_AssetSearch", ClientData, 27);
		//Additional Search Field
	String AssetSearch_Attribute 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 32);
	String AssetSearch_AdvanceSearch_Contributor 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 33);
	String AssetSearch_ContributorRole 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 34);
	String AssetSearch_Charachter 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 35);
	String AssetSearch_PremierNetwork 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 36);
	String AssetSearch_PremierAirDate 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 37);
	String AssetSearch_LengthFm 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 38);
	String AssetSearch_GuildAssociation 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 39);
	String AssetSearch_PropertyFormat 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 40);
	String AssetSearch_Vendor 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 41);
	String AssetSearch_Vendor2 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 42);
	String AssetSearch_Keyword 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 43);
	String AssetSearch_ClientGroup 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 44);
	String AssetSearch_MMLClearance 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 45);
	String AssetSearch_InternationalAvailabitlity	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 46);
		//Check Boxes
	String AssetSearch_AKA 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 52);
	String AssetSearch_Seasons			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 53);
	String AssetSearch_Episodes			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 54);
	String AssetSearch_SelectAll 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 55);
	String AssetSearch_SearchEarliest 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 56);
	String AssetSearch_IncludeDelete	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 57);
	String AssetSearch_RelatedAsset 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 58);
	String AssetSearch_ExactMatch 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 59);
		//Buttons Available
	String AssetSearch_Search 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 66);
	String AssetSearch_ClearSearch		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 67);
	String AssetSearch_SaveSearch		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 68);
	String AssetSearch_RestoreSearch 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 69);
		// Asset Search Grid Data
	String AssetSearch_ProjectID 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 80);
	String AssetSearch_Publisher 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 81);
	String AssetSearch_DurationORLength_Minute 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 82);
	String AssetSearch_MMLContact 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 83);
	String AssetSearch_PRODBALAContact 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 84);
	String AssetSearch_CreationDate 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 85);
	String AssetSearch_AssetType_SearchGrid 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 86);
	String AssetSearch_AssetType_GuildAssociation 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 87);
	String AssetSearch_AssetTitle_SearchGrid 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 88);
	String AssetSearch_ReleaseYear 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 89);
	String AssetSearch_DurationORLength 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 90);
	String AssetSearch_SearchGrid_Contributor 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 91);
	String AssetSearch_ProdEntry 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 92);
	String AssetSearch_SearchGrid_AssetID 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 93);
	String AssetSearch_SearchGrid_SBU 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 94);
	String AssetSearch_SearchGrid_NumberOfEpisodees		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 95);
	String AssetSearch_AssetCategory2 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 251);
	String AssetSearch_Venue 							= xlsInputData.getCellData("AM_AssetSearch", ClientData, 252); // This is not present in the Header of Search Grid
	String AssetSearch_Teams 							= xlsInputData.getCellData("AM_AssetSearch", ClientData, 253);
	String AssetSearch_MatchCategory 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 254);
	String AssetSearch_RoundOfSeries 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 255);
	String AssetSearch_AssetCategory3 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 256);
	String AssetSearch_ADES								= xlsInputData.getCellData("AM_AssetSearch", ClientData, 257);
	String AssetSearch_EDES								= xlsInputData.getCellData("AM_AssetSearch", ClientData, 258);
	String AssetSearch_Studio							= xlsInputData.getCellData("AM_AssetSearch", ClientData, 259);
	String AssetSearch_SearchGridHeeader_ClientGroup 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 260);
	String AssetSearch_AssetClearance					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 261);
	String AssetSearch_ProductContact					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 262);
	String AssetSearch_Episodes2 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 263);
	String AssetSearch_Length2							= xlsInputData.getCellData("AM_AssetSearch", ClientData, 264);
	String AssetSearch_SearchGridHeader_Venue 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 265);
	String AssetSearch_VersionType 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 266);
	String AssetSearch_SearchGridHeader_Artist 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 267);
	String AssetSearch_SearchGridHeaderVendor 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 268);
	
	String AssetSearch_CreationDate_Search 		            = xlsInputData.getCellData("AM_AssetSearch", ClientData, 271);
	String AssetSearch_LanguageofOrigin				        = xlsInputData.getCellData("AM_AssetSearch", ClientData, 272);
	String AssetSearch_Length 				                = xlsInputData.getCellData("AM_AssetSearch", ClientData, 273);
	String AssetSearch_MPAARating 					        = xlsInputData.getCellData("AM_AssetSearch", ClientData, 274);
	String AssetSearch_TVParentalRating 				    = xlsInputData.getCellData("AM_AssetSearch", ClientData, 275);
	String AssetSearch_CountryofOrigin 						= xlsInputData.getCellData("AM_AssetSearch", ClientData, 276);
	
	// Asset Search Test Data
	String AssetSearch_DefaultAssetType 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 102);
	// Asset Search SaveSearch POP-UP
	String AssetSearch_SaveSearch_ScopeLegend	 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 161);
	String AssetSearch_SaveSearch_SaveForLocalRadioButton 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 162);
	String AssetSearch_SaveSearch_SaveForGlobalRadioButton 	= xlsInputData.getCellData("AM_AssetSearch", ClientData, 163);
	String AssetSearch_SaveSearch_OptionsLegend 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 164);
	String AssetSearch_SaveSearch_OverWriteCurrentSearchRadioButton = xlsInputData.getCellData("AM_AssetSearch", ClientData, 165);
	String AssetSearch_SaveSearch_SaveAsNewSearchRadioButton = xlsInputData.getCellData("AM_AssetSearch", ClientData, 166);
	String AssetSearch_SaveSearch_SaveButton 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 167);
	String AssetSearch_SaveSearch_CancelButton 				= xlsInputData.getCellData("AM_AssetSearch", ClientData, 168);
	// Asset Search RestoreSearch POP-UP
	String AssetSearch_RestoreSearch_SearchLegend 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 177);
	String AssetSearch_RestoreSearch_SearchForLocalRadioButton 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 178);
	String AssetSearch_RestoreSearch_SaveForGlobalRadioButton 		= xlsInputData.getCellData("AM_AssetSearch", ClientData, 179);
	String AssetSearch_RestoreSearch_ResultsLegend 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 180);
	String AssetSearch_RestoreSearch_Results_ColumnHeader 			= xlsInputData.getCellData("AM_AssetSearch", ClientData, 181);
	String AssetSearch_RestoreSearch_SearchButton 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 182);
	String AssetSearch_RestoreSearch_RestoreButton 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 183);
	String AssetSearch_RestoreSearch_DeleteButton 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 184);
	String AssetSearch_RestoreSearch_CancelButton 					= xlsInputData.getCellData("AM_AssetSearch", ClientData, 185);
	//AM_ReturnLast Search
	String AssetTypeProgramRLS 										= xlsInputData.getCellData("AMRetLastSearch", ClientData, 2);
	String AssetTypeMovieRLS 										= xlsInputData.getCellData("AMRetLastSearch", ClientData, 3);
	String AssetTypeProgramSeriesRLS 								= xlsInputData.getCellData("AMRetLastSearch", ClientData, 4);
	String AssetTypeSpecialRLS 										= xlsInputData.getCellData("AMRetLastSearch", ClientData, 5);
	
	String ReturntoLastSearch 										= xlsInputData.getCellData("AM_RetLastSearch", ClientData, 2);
	

	//AM_Documents
	String document_AppliesTOKey				 		= xlsInputData.getCellData("AM_Documents", "Keys", 2);
	String AMDocumentTypeKey				 			= xlsInputData.getCellData("AM_Documents", "Keys", 3);
	String AMDocumentNameKey 				 		 	= xlsInputData.getCellData("AM_Documents", "Keys", 4);
	String AMDocumentDateKey 				 			= xlsInputData.getCellData("AM_Documents", "Keys", 5);
	String AMDocumentDescKey 				 			= xlsInputData.getCellData("AM_Documents", "Keys", 6);

	String document_AppliesTOValue 				 		= xlsInputData.getCellData("AM_Documents", ClientData, 2);
	String AMDocumentTypeValue 				 			= xlsInputData.getCellData("AM_Documents", ClientData, 3);
	String AMDocumentName 				 				= xlsInputData.getCellData("AM_Documents", ClientData, 4);
	String AMDocumentNameData 				 			= xlsInputData.getCellData("AM_Documents", ClientData, 92);
	String AMDocumentDate 				 				= xlsInputData.getCellData("AM_Documents", ClientData, 5);  
	String AMDocumentDateData 				 			= xlsInputData.getCellData("AM_Documents", ClientData, 13);
	String AMDocumentDesc 				 				= xlsInputData.getCellData("AM_Documents", ClientData, 6);
	String AMDocumentDescData 				 			= xlsInputData.getCellData("AM_Documents", ClientData, 93);
	//String AMUploadLoc = xlsInputData.getCellData("AM_Documents", ClientData, 8);
	String AMUploadLoc 				 					= System.getProperty("user.dir")+"\\TestUploadFiles\\";
	String AMDocumentID 				 				= xlsInputData.getCellData("AM_Documents", ClientData, 9);
	String AMLibrarySelect 				 				= xlsInputData.getCellData("AM_Documents", ClientData, 10);
	//AM_Documents - Buttons inView Mode
	String document_ViewButtonValue 				 	= xlsInputData.getCellData("AM_Documents", ClientData, 21);
	String document_AddDocumentButtonValue 				= xlsInputData.getCellData("AM_Documents", ClientData, 22);
	String document_EditProfileValue 					= xlsInputData.getCellData("AM_Documents", ClientData, 23);
	String document_DeleteDocumentValue 				= xlsInputData.getCellData("AM_Documents", ClientData, 24);
	String document_EditDocumentValue 					= xlsInputData.getCellData("AM_Documents", ClientData, 25);	
	String document_SelectRowToViewValidationMessage 	= xlsInputData.getCellData("AM_Documents", ClientData, 48);
	String document_AddDoc_SelectRowBeforeDeleteDocument_ValidationMessage = xlsInputData.getCellData("AM_Documents", ClientData, 49);

	//AM_Documents - Add document window
	String document_AddDoc_DocumentUploadLabel 			= xlsInputData.getCellData("AM_Documents", ClientData, 30);
	String document_AddDoc_AppliesToLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 31);
	String document_AddDoc_DocNameLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 32);
	String document_AddDoc_DocTypeLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 33);
	String document_AddDoc_DocTypeData 					= xlsInputData.getCellData("AM_Documents", ClientData, 12);
	String document_AddDoc_DocDateLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 34);
	String document_AddDoc_DescriptionLabel 			= xlsInputData.getCellData("AM_Documents", ClientData, 35);
	String document_AddDoc_LibraryLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 36);
	
	String document_AddDoc_DocumentIDLabel 				= xlsInputData.getCellData("AM_Documents", ClientData, 37);
	
	String document_AddDoc_UploadDocumentVAlidationMessage 		  = xlsInputData.getCellData("AM_Documents", ClientData, 45);
	String document_AddDoc_2048KB_UploadDocumentValidationMessage = xlsInputData.getCellData("AM_Documents", ClientData, 46);
	String document_AddDoc_WINRAR_UploadDocumentValidationMessage = xlsInputData.getCellData("AM_Documents", ClientData, 47);
	
	// Test Data of Document TAB
	String document_AddDoc_DocTypeDropDownValue 		= xlsInputData.getCellData("AM_Documents", ClientData, 91);
	String document_AddDoc_LibraryData 					= xlsInputData.getCellData("AM_Documents", ClientData, 94);
	
	//AM_RelatedProgram
	String AMRelatedProgAppliesTOValue 	= xlsInputData.getCellData("AM_RelatedProg", ClientData, 2);
	String AMRelatedProgStartCodeValue 	= xlsInputData.getCellData("AM_RelatedProg", ClientData, 3);
	String AMRelatedProgEndCodeValue 	= xlsInputData.getCellData("AM_RelatedProg", ClientData, 4);

	//AM_Awards
	String AM_AwardsOrganization 		= xlsInputData.getCellData("AM_Awards", ClientData, 2);
	String AM_AwardsAward 				= xlsInputData.getCellData("AM_Awards", ClientData, 3);
	String AM_AwardsAwardTitle 			= xlsInputData.getCellData("AM_Awards", ClientData, 4);
	String AM_AwardsYear 				= xlsInputData.getCellData("AM_Awards", ClientData, 5);
	String AM_AwardsWinner 				= xlsInputData.getCellData("AM_Awards", ClientData, 6);
	String AM_AwardsStatus 				= xlsInputData.getCellData("AM_Awards", ClientData, 7);
	//Field
	String AM_AwardsTabOrganization 	= xlsInputData.getCellData("AM_Awards", ClientData, 31);
	String AM_AwardsTabAward 			= xlsInputData.getCellData("AM_Awards", ClientData, 32);
	String AM_AwardsTabAwardTitle 		= xlsInputData.getCellData("AM_Awards", ClientData, 33);
	String AM_AwardsTabYear 			= xlsInputData.getCellData("AM_Awards", ClientData, 34);
	String AM_AwardsTabWinner 			= xlsInputData.getCellData("AM_Awards", ClientData, 35);
	String AM_AwardsTabStatus 			= xlsInputData.getCellData("AM_Awards", ClientData, 36);
	String AM_AwardsTabParticipantAward = xlsInputData.getCellData("AM_Awards", ClientData, 37);
	String AM_AwardsTabGameAward 		= xlsInputData.getCellData("AM_Awards", ClientData, 38);
	//View Mode
	String AM_AwardsTabOrganizationViewMode = xlsInputData.getCellData("AM_Awards", ClientData, 43);
	String AM_AwardsTabAwardViewMode 		= xlsInputData.getCellData("AM_Awards", ClientData, 44);
	String AM_AwardsTabAwardTitleViewMode 	= xlsInputData.getCellData("AM_Awards", ClientData, 45);
	String AM_AwardsAddButton 				= xlsInputData.getCellData("AM_Awards", ClientData, 39);
	String AM_AwardsDeleteButton 			= xlsInputData.getCellData("AM_Awards", ClientData, 40);
	String AM_AwardsSaveButton 				= xlsInputData.getCellData("AM_Awards", ClientData, 41);
	String AM_AwardsCancelButton 			= xlsInputData.getCellData("AM_Awards", ClientData, 42);
	String AM_AwardsAssetType 				= xlsInputData.getCellData("AM_Awards", ClientData, 10);
	//keys
	String AM_AwardsOrganization_Key 		= xlsInputData.getCellData("AM_Awards","Keys", 2);
	String AM_AwardsAward_Key 				= xlsInputData.getCellData("AM_Awards","Keys", 3);
	String AM_AwardsAwardTitle_Key 			= xlsInputData.getCellData("AM_Awards","Keys", 4);
	String AM_AwardsYear_Key 				= xlsInputData.getCellData("AM_Awards","Keys", 5);
	String AM_AwardsWinner_Key 				= xlsInputData.getCellData("AM_Awards","Keys", 6);
	String AM_AwardsStatus_Key 				= xlsInputData.getCellData("AM_Awards","Keys", 7);
	String AM_AwardsParticipant_Key 		= xlsInputData.getCellData("AM_Awards","Keys", 8);
	String AM_AwardsGameAward_Key 			= xlsInputData.getCellData("AM_Awards","Keys", 9);

	
	// Assets Types
	String AssetType_Program 				= xlsInputData.getCellData("Assets",ClientData, 2);
	String AssetType_PromoAndMarketing 		= xlsInputData.getCellData("Assets",ClientData, 26);
	String AssetType_HomeVideo 				= xlsInputData.getCellData("Assets",ClientData, 41);
	String AssetType_Merchandise 			= xlsInputData.getCellData("Assets",ClientData, 56);
	String AssetType_Publishing 			= xlsInputData.getCellData("Assets",ClientData, 71);
	String AssetType_Element 				= xlsInputData.getCellData("Assets",ClientData, 86);
	String AssetType_Theatrical 			= xlsInputData.getCellData("Assets",ClientData, 106);
	
	// Asset SubTypes
	String AssetType_PromoAndMarketing_Promos = xlsInputData.getCellData("Assets",ClientData, 27);
	String AssetType_HomeVideo_DVD 			  = xlsInputData.getCellData("Assets",ClientData, 42);
	String AssetType_Merchandise_Apparel 	  = xlsInputData.getCellData("Assets",ClientData, 57);
	String AssetType_Publishing_Printed 	  = xlsInputData.getCellData("Assets",ClientData, 72);
	String AssetType_Theatrical_FeatureLength = xlsInputData.getCellData("Assets",ClientData, 107);
	  // Assset Sub Type Programmes
	String Series_AssetType 		  		  = xlsInputData.getCellData("Assets",ClientData, 202);
	String AssetType_ProgrameMovie 			  = xlsInputData.getCellData("Assets",ClientData, 203);
	String AssetMovieSubType 			  	  = xlsInputData.getCellData("Assets",ClientData, 204);
	String MiniSeries_AssetType 			  = xlsInputData.getCellData("Assets",ClientData, 205);
	
	
	//Element SubTypes
	String AssetType_Element_Music 		 	 = xlsInputData.getCellData("Assets",ClientData, 231);
	String AssetType_Element_Talent 		 = xlsInputData.getCellData("Assets",ClientData, 87);
	String AssetElementSubType               = xlsInputData.getCellData("Assets", ClientData, 233);
	

}

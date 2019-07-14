package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;

@Listeners(utility.ListenerClass.class)
public class RI_TermEvent  extends MultiClient_SupportingFunctions {
	
	public RI_TermEvent() {
		className = this.getClass().getName();
		
	}
	AssetMaintenance assetMaintenance 	= new AssetMaintenance();
	RightsIN rightsIN 					= new RightsIN();
	RI_MediaRights mediaRights 			= new RI_MediaRights();
	
	Date date 					= new Date();
	SimpleDateFormat sdf 		= new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate 		= "0202201715754";//sdf.format(date);
	
	String TC1_SeriesAsset 		= "AUT_AssetSeries_TC1_" +formattedDate+"";
	String TC1_Deal 			= "AUT_Deal_TC1_" +formattedDate+"";
	
	@Test(enabled= true,description = "Create Assets/Deals and add pre-requites data which is given in Manual Test Case")
	public void preRequisites() throws Exception {
		// TC1 
/*		assetMaintenance.createProgramAsset(TC1_SeriesAsset,Series_AssetType);
		assetMaintenance.AddingEpisodeToAssetWithoutPremdt(TC1_SeriesAsset,2,3);		
		rightsIN.createDeal(TC1_Deal);
		rightsIN.associateAssetWithDeal(TC1_Deal,TC1_SeriesAsset);
		*/

		
	}
	
	@Test(priority =1, enabled= true, description = "S1:Media Rights tab>Term Events >UI")
	public void MediaRightsTermEventUI() throws Exception{
		rightsIN.selectDeal(TC1_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");
		switchIntoFrame(frameParent3Xpath);

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_AddButton, "'Add' Button at Media Rights Edit window",RI_MediaRights_EditMode_AddButton);
		WaitForModalPanel();
		// Enter the data for Row 1
		mediaRights.enterDatainAllFields("1", RI_MediaRights_EditMode_AppliesToDropDown_ValueAll);
		switchIntoFrame(frameParent3Xpath);

		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "Term Event Icon",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);

		//DTC_RI_Term Events_4.5_S1_1
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_1");		
		verifyFieldValueOfHeader(loc_Generallocator.replace("@var", RI_TERMEvent_DurationLabel), RI_TERMEvent_DurationLabel, "Duration Label", RI_TERMEvent_DurationLabel);
		verifyFieldValueOfHeader(loc_Generallocator.replace("@var", RI_TERMEvent_PerpetuityCheckBox), RI_TERMEvent_PerpetuityCheckBox, "Perpetuity Label", RI_TERMEvent_PerpetuityCheckBox);
		verifyFieldValueOfHeader(loc_RI_TermEvent_CommencingOnLabel, RI_TERMEvent_CommencingOn, "CommencingOn Label", RI_TERMEvent_CommencingOn);
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndingOnLabel, RI_TERMEvent_EndingOnLabel, "EndingOn Label", RI_TERMEvent_EndingOnLabel);
		verifyFieldValueOfHeader(OKButton, RI_TERMEvent_OK, "RI_TERMEvent_OK", RI_TERMEvent_OK, "value");
		verifyFieldValueOfHeader(LocCancel, RI_TERMEvent_Cancel, "RI_TERMEvent_Cancel", RI_TERMEvent_Cancel, "value");

		//DTC_RI_Term Events_4.5_S1_3
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_3");
		ExecutionLog.Log("************Check the available fields in Duration frame******");
		verifyElementPresent(loc_RI_TermEvent_DurationInputField, "DurationInputField");
		verifyElementPresent(loc_RI_TermEvent_DurationDropDownField, "DurationDropDownField");
		verifyElementPresent(loc_RI_TermEvent_DurationOperatorField, "DurationOperatorField");
		verifyElementPresent(loc_RI_TermEvent_AddlDurationField, "AddlDurationField");
		verifyElementPresent(loc_RI_TermEvent_AddlDurationPeriodDropDown, "AddlDurationPeriodDropDown");
		verifyElementPresent(loc_RI_TermEvent_PerpetuityCheckBox, "PerpetuityCheckBox");

		//DTC_RI_Term Events_4.5_S1_4
				ExecutionLog.Log("");
				ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_4");
		ExecutionLog.Log("************Check the available fields in Commencing on frame******");
		verifyElementPresent(loc_RI_TermEvent_CommencingOn_GeneralElement.replace("@var", RI_TERMEvent_StartDateLabel), "StartDateLabel", RI_TERMEvent_StartDateLabel);
		verifyElementPresent(loc_RI_TermEvent_StartDateDurationOperatorDropDown, "StartDateDurationOperatorDropDown", RI_TERMEvent_StartDateLabel);
		verifyElementPresent(loc_RI_TermEvent_StartDateAddlDurationField, "StartDateAddlDurationField", RI_TERMEvent_StartDateLabel);
		verifyElementPresent(loc_RI_TermEvent_AddlDurationPeriod, "AddlDurationPeriod", RI_TERMEvent_StartDateLabel);

		
		ExecutionLog.Log("************Check the available Headers in Start Event frame******");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEventHeaderRow.replace("@var", RI_TERMEvent_EventKey), RI_TERMEvent_EventHeader, "Event", RI_TERMEvent_EventHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEventHeaderRow.replace("@var", RI_TERMEvent_Operator1Key), RI_TERMEvent_Operator1Header, "Operator", RI_TERMEvent_Operator1Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEventHeaderRow.replace("@var", RI_TERMEvent_NumberKey), RI_TERMEvent_NumberHeader, "Number", RI_TERMEvent_NumberHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEventHeaderRow.replace("@var", RI_TERMEvent_PeriodKey), RI_TERMEvent_PeriodHeader, "Period", RI_TERMEvent_PeriodHeader, "innerHTML");


		ExecutionLog.Log("************Check the available Headers in Start Deal frame******");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartDealHeaderRow.replace("@var", RI_TERMEvent_DateKey), 	RI_TERMEvent_DateHeader, 	  "DateHeader", RI_TERMEvent_DateHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartDealHeaderRow.replace("@var", RI_TERMEvent_DealNameKey), RI_TERMEvent_DealNameHeader,  "DealNameHeader", RI_TERMEvent_DealNameHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartDealHeaderRow.replace("@var", RI_TERMEvent_MRRowKey), 	RI_TERMEvent_MRRowHeader, 	  "MRRowHeader", RI_TERMEvent_MRRowHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartDealHeaderRow.replace("@var", RI_TERMEvent_Operator2Key),RI_TERMEvent_Operator2Header, "Operator Header", RI_TERMEvent_Operator2Header, "innerHTML");


		verifyElementPresent(loc_RI_TermEvent_CommencingOn_GeneralElement.replace("@var", RI_TERMEvent_WhichEverComesLabel), "WhichEverComesLabel", RI_TERMEvent_WhichEverComesLabel);
		verifyElementPresent(loc_RI_TermEvent_CommencingOn_GeneralElement.replace("@var", RI_TERMEvent_ButNoLaterLabel), "ButNoLaterLabel", RI_TERMEvent_ButNoLaterLabel);
		verifyElementPresent(loc_RI_TermEvent_CommencingOn_GeneralElement.replace("@var", RI_TERMEvent_EstimatedDateLabel), "EstimatedDateLabel", RI_TERMEvent_EstimatedDateLabel);
		verifyElementPresent(loc_RI_TermEvent_CommencingOn_GeneralElement.replace("@var", RI_TERMEvent_StartDateUnKnownLabel), "StartDateUnKnownLabel", RI_TERMEvent_StartDateUnKnownLabel);

		//DTC_RI_Term Events_4.5_S1_5
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_5");
		ExecutionLog.Log("************Verify the Default values of Start Deal Fields******");
		verifyFieldValueOfHeader(getLocator_StartDeal_DataRow("1", RI_TERMEvent_DealNameKey, RI_TERMEvent_DealNameHeader), TC1_Deal, "Deal Name at 'Start Deal'", RI_TERMEvent_DealNameHeader, "innerHTML");
		verifyFieldValueOfHeader(getLocator_StartDeal_DataRow("1", RI_TERMEvent_DateKey, RI_TERMEvent_DateHeader), RI_TERMEvent_StartDate, "Deal Date at 'Start Deal'", RI_TERMEvent_DateHeader, "innerHTML");

		//DTC_RI_Term Events_4.5_S1_7
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_7");
		ExecutionLog.Log("************Verify the Default values of Start Deal Fields******");
		ExecutionLog.Log("************Check the available fields in Ending on frame******");
		verifyElementPresent(loc_RI_TermEvent_EndingOn_GeneralElement.replace("@var", RI_TERMEvent_EndDateLabel), "EnddateLabel", RI_TERMEvent_EndDateLabel);
		verifyElementPresent(loc_RI_TermEvent_EndDateDurationOperatorDropDown, "EndDateDurationOperatorDropDown", RI_TERMEvent_EndDateLabel);
		verifyElementPresent(loc_RI_TermEvent_EndDateAddlDurationField, "EndDateAddlDurationField", RI_TERMEvent_EndDateLabel);
		verifyElementPresent(loc_RI_TermEvent_AddlDurationPeriod, "AddlDurationPeriod", RI_TERMEvent_EndDateLabel);

		
		ExecutionLog.Log("************Check the available Headers in End Event frame******");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndEventHeaderRow.replace("@var", RI_TERMEvent_EventKey), RI_TERMEvent_EventHeader, "Event", RI_TERMEvent_EventHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndEventHeaderRow.replace("@var", RI_TERMEvent_Operator1Key), RI_TERMEvent_Operator1Header, "Operator", RI_TERMEvent_Operator1Header, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndEventHeaderRow.replace("@var", RI_TERMEvent_NumberKey), RI_TERMEvent_NumberHeader, "Number", RI_TERMEvent_NumberHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndEventHeaderRow.replace("@var", RI_TERMEvent_PeriodKey), RI_TERMEvent_PeriodHeader, "Period", RI_TERMEvent_PeriodHeader, "innerHTML");



		ExecutionLog.Log("************Check the available Headers in End Deal frame******");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndDealHeaderRow.replace("@var", RI_TERMEvent_DateKey), 	RI_TERMEvent_DateHeader, 	  "DateHeader", RI_TERMEvent_DateHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndDealHeaderRow.replace("@var", RI_TERMEvent_DealNameKey), RI_TERMEvent_DealNameHeader,  "DealNameHeader", RI_TERMEvent_DealNameHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndDealHeaderRow.replace("@var", RI_TERMEvent_MRRowKey), 	RI_TERMEvent_MRRowHeader, 	  "MRRowHeader", RI_TERMEvent_MRRowHeader, "innerHTML");
		verifyFieldValueOfHeader(loc_RI_TermEvent_EndDealHeaderRow.replace("@var", RI_TERMEvent_Operator2Key),RI_TERMEvent_Operator2Header, "Operator Header", RI_TERMEvent_Operator2Header, "innerHTML");


		verifyElementPresent(loc_RI_TermEvent_EndingOn_GeneralElement.replace("@var", RI_TERMEvent_WhichEverComesLabel), "WhichEverComesLabel", RI_TERMEvent_WhichEverComesLabel);
		verifyElementPresent(loc_RI_TermEvent_EndingOn_GeneralElement.replace("@var", RI_TERMEvent_ButNoLaterLabel), "ButNoLaterLabel", RI_TERMEvent_ButNoLaterLabel);
		verifyElementPresent(loc_RI_TermEvent_EndingOn_GeneralElement.replace("@var", RI_TERMEvent_EstimatedDateLabel), "EstimatedDateLabel", RI_TERMEvent_EstimatedDateLabel);
		verifyElementPresent(loc_RI_TermEvent_EndingOn_GeneralElement.replace("@var", RI_TERMEvent_StartDateUnKnownLabel), "StartDateUnKnownLabel", RI_TERMEvent_StartDateUnKnownLabel);



		//DTC_RI_Term Events_4.5_S1_8
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_8");
		ExecutionLog.Log("************Verify the Default values of End Deal Fields******");
		verifyFieldValueOfHeader(getLocator_EndDeal_DataRow("1", RI_TERMEvent_DealNameKey, RI_TERMEvent_DealNameHeader), TC1_Deal, "Deal Name at 'End Deal'", RI_TERMEvent_DealNameHeader, "innerHTML");
		verifyFieldValueOfHeader(getLocator_EndDeal_DataRow("1", RI_TERMEvent_DateKey, RI_TERMEvent_DateHeader), RI_TERMEvent_StartDate, "Deal Date at 'End Deal'", RI_TERMEvent_DateHeader, "innerHTML");

		//DTC_RI_Term Events_4.5_S1_8
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_10");
		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_Operator1Key, RI_TERMEvent_Operator1Header), "Operator Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Operator Field of Start Event",RI_TERMEvent_Operator1Header);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_OperatorPlus),RI_TERMEvent_OperatorPlus, "Operator Plus", RI_TERMEvent_OperatorPlus);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_OperatorMinus),RI_TERMEvent_OperatorMinus, "Operator Minus", RI_TERMEvent_OperatorMinus);

		//DTC_RI_Term Events_4.5_S1_11
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_11");
		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_PeriodKey, RI_TERMEvent_PeriodHeader), "Period Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Period Field of Start Event",RI_TERMEvent_PeriodHeader);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_Day),RI_TERMEvent_Day, "Day", RI_TERMEvent_Day);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_Week),RI_TERMEvent_Week, "Day", RI_TERMEvent_Week);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_Month),RI_TERMEvent_Month, "Day", RI_TERMEvent_Month);
		verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_Year),RI_TERMEvent_Year, "Day", RI_TERMEvent_Year);

		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_NumberKey, RI_TERMEvent_NumberHeader), "Number Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Number Field of Start Event",RI_TERMEvent_NumberHeader);

		//DTC_RI_Term Events_4.5_S1_12
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S1_12");
		for(int i = 1; i<=180; i++) {
			verifyFieldValueOfHeader(loc_RI_EditMode_DropDownValues.replace("@var", i+""),i+"", "Day", RI_TERMEvent_NumberHeader);
		}

		clickOn(OKButton, "OK Button");

		switchIntoFrame(frameParent3Xpath);

		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();


		/*
		sendKeys(loc_RI_TermEvent_DurationInputField, "5", "duration Field", RI_TERMEvent_DurationLabel);
		sendKeys(loc_RI_TermEvent_StartEst_InputField, RI_TrackingEvents_EventDate112012, "Estimate Input Field", RI_TERMEvent_EventHeader);

		sendKeys(loc_RI_TermEvent_CommencingOnLabel, RI_TrackingEvents_EventDate112012, "Estimate Input Field", RI_TERMEvent_EventHeader);

		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_EventKey, RI_TERMEvent_EventHeader), "Event Name");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, RI_TERMEvent_EventHeader + "Drop Down Image",	RI_TERMEvent_DurationLabel);



		 */

	}
	
	@Test(priority =2, enabled= true, description = "S2: Media Rights tab:Term Events >Commencing on Frame: If the user does not select any Media Rights Row No. and does not specify any value in one or more of the fields Operator/Number/Period, it is assumed that the selection is ")
	public void MediaRightsTermEvent_CommencingOnFrame() throws Exception{
		rightsIN.selectDeal(TC1_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");

		//DTC_RI_Term Events_4.5_S2_2
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S2_2");
		switchIntoFrame(frameParent3Xpath);
		mediaRights.enterDataInFieldEditMode("1", RI_MediaRights_EditMode_APPLIESTO_HeaderName, S1_Episode101,	RI_MediaRights_APPLIESTO_Key);

		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "Term Event Icon",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		sendKeys(loc_RI_TermEvent_DurationInputField, "5", "duration Field", RI_TERMEvent_DurationLabel);
		sendKeys(loc_RI_TermEvent_StartEst_InputField, RI_TrackingEvents_EventDate_3_1_2013, "Estimate Input Field", RI_TERMEvent_EventHeader);

		verifyFieldValueOfHeader(loc_RI_TermEvent_DurationInputField,"5", "DurationInputField", RI_TERMEvent_DurationLabel, "value");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEst_InputField,RI_TrackingEvents_EventDate_3_1_2013, "Estimation Field", RI_TERMEvent_EventHeader, "value");
		clickOn(OKButton, "OK Button");

		ExecutionLog.Log("Verify the data of \"Term From\" and \" Term To\" Fields in Edit Mode");
		switchIntoFrame(frameParent3Xpath);		
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), RI_TrackingEvents_EventDate_3_1_2013, "Term From Data", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		scrollElementIntoView(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), 		
				RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, loc_RI_MediaRights_HorizontalScroll_EditMode);
		
		String EndDate_Add5Years = addDays(RI_TrackingEvents_EventDate_3_1_2013, 0, -1, 5);//02/28/2018
		verifyFieldValueOfHeader(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), EndDate_Add5Years, "Term To Date", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName);

		clickUsingJSExecutor(loc_Save, "'Save' Button at Note window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		clickUsingJSExecutor(loc_RI_MediaRights_EditMode_SaveButton, "'Save' Button at Media Rights Edit window",RI_MediaRights_EditMode_SaveButton);
		WaitForModalPanel();
		switchIntoFrame(frameParent3Xpath);
		verifyTextMatches(loc_AssertCreationValidationMessage, "Validation message", RI_MediaRights_EditMode_DataSavedSuccessfully);

		clickUsingJSExecutor(loc_RI_closeButton, "'Close' Button at Media Rights Edit window", RI_MediaRights_EditMode_closeButton);
		WaitForModalPanel();
		

		ExecutionLog.Log("Verify the data of \"Term From\" and \" Term To\" Fields in View Mode");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		verifyFieldValueOfHeader(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_FROM_DATE_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName), "est " +RI_TrackingEvents_EventDate_3_1_2013, "Term From Date Field", RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName, "title");
		verifyFieldValueOfHeader(mediaRights.getLocator_ViewTAB_DataRow("0", "2", RI_MediaRights_TERM_TO_DATE_Key, RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName), "est " +EndDate_Add5Years, "Term To Date", RI_MediaRights_EditMode_TERM_TO_DATE_HeaderName, "title");
		
	}

	@Test(priority =1, enabled= true, description = " S3: Media Rights tab:Term Events >Commencing on Frame: If the user does not select any Media Rights Row No. and if user has selected a value in one or more of the fields Operator/Number/Period, system should give a validation for Media Rights Row being mandatory")
	public void MediaRightsTermEvent_CommencingOnFrame2() throws Exception{
		rightsIN.selectDeal(TC1_Deal);
		switchIntoFrame(frameParent2Xpath);
		clickOn(loc_Tab.replace("@var", "Media Rights"), "Media Rights TAB");
		switchIntoFrame(frameParent2Xpath);
		switchIntoChildFrame(frameParent21Xpath);
		WaitForElementPresent("name="+loc_EditButtonEpisodes);
		clickOn("name="+loc_EditButtonEpisodes,"Edit Button");

		switchIntoFrame(frameParent3Xpath);
		mediaRights.enterDataInFieldEditMode("1", RI_MediaRights_EditMode_APPLIESTO_HeaderName, S1_Episode103,	RI_MediaRights_APPLIESTO_Key);

		a();
		
	}
	
	public void a()  throws Exception{
		

		//DTC_RI_Term Events_4.5_S3_2
		ExecutionLog.Log("");
		ExecutionLog.Log("From Manual Test Step : DTC_RI_Term Events_4.5_S3_2");
		switchIntoFrame(frameParent3Xpath);
		doubleClick(mediaRights.getLocator_EditTAB_DataRow("1", RI_MediaRights_TERMEVENT_POPUP_Key, RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName)+"/img", "Term Event Icon",	RI_MediaRights_EditMode_TERM_FROM_DATE_HeaderName);
		WaitForModalPanel();
		switchIntoFrame(frameParent4Xpath);
		sendKeys(loc_RI_TermEvent_DurationInputField, "5", "duration Field", RI_TERMEvent_DurationLabel);
		sendKeys(loc_RI_TermEvent_StartEst_InputField, RI_TrackingEvents_EventDate_12_31_2012, "Estimate Input Field", RI_TERMEvent_EventHeader);
		verifyFieldValueOfHeader(loc_RI_TermEvent_DurationInputField,"5", "DurationInputField", RI_TERMEvent_DurationLabel, "value");
		verifyFieldValueOfHeader(loc_RI_TermEvent_StartEst_InputField,RI_TrackingEvents_EventDate_12_31_2012, "Estimation Field", RI_TERMEvent_EventHeader, "value");
		
		
		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_Operator1Key, RI_TERMEvent_Operator1Header), "Operator Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Operator Field of Start Event",RI_TERMEvent_Operator1Header);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_OperatorPlus), "Plus Operator",RI_TERMEvent_Operator1Header);
		supportActionToSelectData();
		verifyFieldValueOfHeader(getLocator_StartEvent_DataRow("1", RI_TERMEvent_Operator1Key, RI_TERMEvent_Operator1Header),RI_TERMEvent_OperatorPlus, "Operator Plus", RI_TERMEvent_OperatorPlus);

		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_NumberKey, RI_TERMEvent_NumberHeader), "Number Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Number Field of Start Event",RI_TERMEvent_NumberHeader);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", "1"), "Number in Start Event",RI_TERMEvent_NumberHeader);
		supportActionToSelectData();
		verifyFieldValueOfHeader(getLocator_StartEvent_DataRow("1", RI_TERMEvent_NumberKey, RI_TERMEvent_NumberHeader),"1", "Number", RI_TERMEvent_NumberHeader);

		clickOn(getLocator_StartEvent_DataRow("1", RI_TERMEvent_PeriodKey, RI_TERMEvent_PeriodHeader), "Period Field of Start Event");
		clickOn(loc_RI_MediaRights_EditMode_DropDownImage, "Period Field of Start Event",RI_TERMEvent_PeriodHeader);
		clickOn(loc_RI_EditMode_DropDownValues.replace("@var", RI_TERMEvent_Year), "Period in Start Event",RI_TERMEvent_PeriodHeader);
		supportActionToSelectData();
		verifyFieldValueOfHeader(getLocator_StartEvent_DataRow("1", RI_TERMEvent_PeriodKey, RI_TERMEvent_PeriodHeader),RI_TERMEvent_Year, "Period", RI_TERMEvent_PeriodHeader);

		
		clickOn(OKButton, "OK Button");
		
		
		
		
	}
	/**
	 * Start EventRow starts from : 1,2,3,4,5
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_StartEvent_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_TermEvent_StartEventHeaderRow, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_RI_TermEvent_StartEventDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
	
	/**
	 * Start EventRow starts from : 1,2,3,4,5
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_StartDeal_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_TermEvent_StartDealHeaderRow, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_RI_TermEvent_StartDealDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
	
	/**
	 * Start EventRow starts from : 1,2,3,4,5
	 * @param headerPath
	 * @param keyValue
	 * @param ExcelFromHeader
	 * @return
	 */
	public String getLocator_EndDeal_DataRow(String rowNumber, String KeyValueFromExcel, String HeadeNameFromExcel){
		String locator = "";
		String classValue = getClassValue(loc_RI_TermEvent_EndDealHeaderRow, KeyValueFromExcel, HeadeNameFromExcel);
		locator = loc_RI_TermEvent_EndDealDataRow + "[" + rowNumber +"]//td[contains(@class,'"+ loc_FilterClassValue(classValue) +"')]";
		return locator;
	}
	
	
	public String getClassValue(String headerPath, String keyValue, String ExcelFromHeader){
		String classValue = "No class attribute was found";
		if(!(ExcelFromHeader.contains("N/A"))){
			// using the class name to locate the added row
			String loc_NWHeader = headerPath.replace("@var", keyValue);
			classValue =  getAttribute(loc_NWHeader, "class");
		} 
		return classValue;
	}
	
	public void supportActionToSelectData() throws Exception{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.TAB);
        keyboard.releaseKey(Keys.TAB);
        sleepTime(2);
	}

}

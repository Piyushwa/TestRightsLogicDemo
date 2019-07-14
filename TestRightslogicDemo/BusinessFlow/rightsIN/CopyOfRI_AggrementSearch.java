
package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class CopyOfRI_AggrementSearch extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	
	
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);

	String CreatedSeriesAssetTitle1 = "AUT_AssetSeries_" +formattedDate+"";
	String CreatedDeal1 = "AUT_Deal_" +formattedDate+"";
	
	String CreatedSeriesAssetTitle2 = "AUT_AssetSeries2_" +formattedDate+"";
	String CreatedDeal2 = "AUT_Deal2_" +formattedDate+"";
	
	public CopyOfRI_AggrementSearch() {
		className = this.getClass().getName();

	}
	@Test(priority =1,enabled= true,description = "Verify Agreement Search (UI)")
	public void TC1_RI_AggrementSearchUI() throws InterruptedException, Exception {
		switchIntoFrame(frameParent1Xpath);
		rightIN.navigateToRightsIN();
		switchIntoFrame(frameParent2Xpath);
		verifyTextMatches(SearchXpath, "Search Icon", "Search");
		clickUsingJSExecutor(SearchXpath,"Search Icon");
		Thread.sleep(3000);
//		verifyTextMatches(loc_RI_AggrementSearch, "Agreement Link", "Agreements");
		clickUsingJSExecutor(loc_RI_AggrementSearch,"Agreement Link");
		WaitForModalPanel();
		switchIntoFrame(frameParent2Xpath);
		//TC_RI_AS_002
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPropertyTitle, RI_AggrementSearchPropertyTitle, "Property Title", RI_AggrementSearchPropertyTitle);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchEpisode, RI_AggrementSearchEpisode, "Episode #(s)", RI_AggrementSearchEpisode);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchChannelEntity, RI_AggrementSearchChannelEntity, "Channel / Entity", RI_AggrementSearchChannelEntity);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractName, RI_AggrementSearchContractName, "Contract Name", RI_AggrementSearchContractName);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRMSContractType, RI_AggrementSearchRMSContractType, "RMS Contract Type", RI_AggrementSearchRMSContractType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchDM5DocType, RI_AggrementSearchDM5DocType, "DM5 Doc Type", RI_AggrementSearchDM5DocType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPartyRepresenting, RI_AggrementSearchPartyRepresenting, "Party/Representing", RI_AggrementSearchPartyRepresenting);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchVMNParty, RI_AggrementSearchVMNParty, "VMN Party", RI_AggrementSearchVMNParty);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchServices, RI_AggrementSearchServices, "Services", RI_AggrementSearchServices);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractStatus, RI_AggrementSearchContractStatus, "Contract Status", RI_AggrementSearchContractStatus);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractEntryStatus, RI_AggrementSearchContractEntryStatus, "Contract Entry Status", RI_AggrementSearchContractEntryStatus);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchContractDtFm, RI_AggrementSearchContractDtFm, "Contract Dt Fm", RI_AggrementSearchContractDtFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRevisionDtFm, RI_AggrementSearchRevisionDtFm, "Revision Dt Fm", RI_AggrementSearchRevisionDtFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdatedBy, RI_AggrementSearchLastUpdatedBy, "Last Updated By", RI_AggrementSearchLastUpdatedBy);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreatedBy, RI_AggrementSearchCreatedBy, "Created By", RI_AggrementSearchCreatedBy);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAgreementType, RI_AggrementSearchAgreementType, "Agreement Type", RI_AggrementSearchAgreementType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchTeamMember, RI_AggrementSearchTeamMember, "Team Member", RI_AggrementSearchTeamMember);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIDType, RI_AggrementSearchIDType, "IDType", RI_AggrementSearchIDType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAKAsFKAs, RI_AggrementSearchAKAsFKAs, "AKAs/FKAs", RI_AggrementSearchAKAsFKAs);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchReturnAttachments, RI_AggrementSearchReturnAttachments, "Return Attachments", RI_AggrementSearchReturnAttachments);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchIncludeDeleted, RI_AggrementSearchIncludeDeleted, "Include Deleted", RI_AggrementSearchIncludeDeleted);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExactMatch, RI_AggrementSearchExactMatch, "Exact Match", RI_AggrementSearchExactMatch);

		//Button
		verifyFieldValueOfHeader(Loc_SearchButton, RI_AggrementSearchSearch, "Search Button", RI_AggrementSearchSearch, "value");
		verifyFieldValueOfHeader(Loc_ClearSearch, RI_AggrementSearchClearSearch, "Clear Search Button", RI_AggrementSearchClearSearch, "value");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchSaveSearchButton, RI_AggrementSearchSaveSearch, "Save Search Button", RI_AggrementSearchSaveSearch, "value");
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRestoreSearch, RI_AggrementSearchRestoreSearch, "Restore Search Button", RI_AggrementSearchRestoreSearch, "value");

		//Advance Search 
		//TC_RI_AS_007
		clickUsingJSExecutor(loc_RI_AggrementSearchExpandAdvanceSearch,"Expand Advance Search");
		Thread.sleep(3000);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchRightsMedia, RI_AggrementSearchRightsMedia, "Rights (incl. Media)", RI_AggrementSearchRightsMedia);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchTerritory, RI_AggrementSearchTerritory, "Territory", RI_AggrementSearchTerritory);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLicenseDatesFm, RI_AggrementSearchLicenseDatesFm, "License Dates Fm", RI_AggrementSearchLicenseDatesFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchObligationType, RI_AggrementSearchObligationType, "Obligation Type", RI_AggrementSearchObligationType);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchFutureProperty, RI_AggrementSearchFutureProperty, "Future Property", RI_AggrementSearchFutureProperty);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchExpirationDateFm, RI_AggrementSearchExpirationDateFm, "Expiration Date Fm", RI_AggrementSearchExpirationDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchLastUpdateDateFm, RI_AggrementSearchLastUpdateDateFm, "Last Update Date Fm", RI_AggrementSearchLastUpdateDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchCreationDateFm, RI_AggrementSearchCreationDateFm, "Creation Date Fm", RI_AggrementSearchCreationDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchOptionDeadlineFm, RI_AggrementSearchOptionDeadlineFm, "Option Deadline Fm", RI_AggrementSearchOptionDeadlineFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereAirDateFm, RI_AggrementSearchPremiereAirDateFm, "Premiere Air Date Fm", RI_AggrementSearchPremiereAirDateFm);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchPremiereNetwork, RI_AggrementSearchPremiereNetwork, "Premiere Network", RI_AggrementSearchPremiereNetwork);
		verifyFieldValueOfHeader(loc_RI_AggrementSearchAttributes, RI_AggrementSearchAttributes, "Attributes", RI_AggrementSearchAttributes);
        
		
	}
	


}
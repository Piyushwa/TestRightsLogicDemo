package assetMaintenance;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.MultiClient_SupportingFunctions;

public class AM_Demo extends MultiClient_SupportingFunctions {
	
		
	public AM_Demo() {
		super(RI_EditingRightsColumnXpath_EditMode,
				RI_EditingRightsDataRowXpath_EditMode,
				RI_EditingRightsColumnXpath_ViewMode,
				RI_EditingRightsDataRowXpath_ViewMode);
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}

	@Test(priority = 1, enabled = true, description = "Test script")
	public void TC1_AssetCreationTest( ) throws Exception {
		logger.startTest("Test1.TC1_AssetCreationTest");
		logger.log(LogStatus.INFO, "Browser Opened");
		logger.log(LogStatus.INFO, "entered UserName");
		logger.log(LogStatus.INFO, "entered Password");
		logger.log(LogStatus.FAIL, "Verified HomePage");
		
		
		
	}
	
	
	

	

}

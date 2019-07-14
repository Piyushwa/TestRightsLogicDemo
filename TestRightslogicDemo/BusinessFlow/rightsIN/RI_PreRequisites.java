package rightsIN;
/*Required points
 * Create IP, vendor in the application and had parameterized in the input values sheet for the same
 * Templates have created for all drops downs in the Media Rights grid & Parameterized the same
 *  
 */


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
import excelDataBinding.Excel_Reader;

@Listeners(utility.ListenerClass.class)
public class RI_PreRequisites extends MultiClient_SupportingFunctions {
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightsIN = new RightsIN();
	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\excelDataBinding\\RI_TestData.xlsx");
	
	
	public RI_PreRequisites() {
		super(loc_RI_MediaRights_ColumnXpath_EditMode, loc_RI_MediaRights_DataRowXpath_EditMode, 
				loc_RI_MediaRights_ColumnXpath_ViewMode, loc_RI_MediaRights_DataRowXpath_ViewMode);
		className = this.getClass().getName(); 
	}
	
	@Test(priority =1,enabled= true,description = "Create PreRequisites")
	public void TC1_PreRequisites() throws Exception {
		


		for(int i = 2; i <=xlsInputData.getRowCount("RI_PreRequisites")-2 ; i++) {
			String TemplateName 	= xlsInputData.getCellData("RI_PreRequisites", "TemplateName", i);
			String TemplateTestData = xlsInputData.getCellData("RI_PreRequisites", ClientData, i);
			
			if(!TemplateTestData.contains("N/A")) {
				Thread.sleep(5000);
				switchIntoFrame(frameParent2Xpath);
				clickUsingJSExecutor(loc_PageLink.replace("@var", "Templates"), "Templates ");
				ExecutionLog.Log("");
				ExecutionLog.Log("------------" + TemplateName + "------------" );
				clickUsingJSExecutor(loc_SubMenu.replace("@var", TemplateName), "TemplateName " + TemplateName);
				switchIntoFrame(frameParent3Xpath);
				// Check if the data is already present in the list
				if(!getAllOptions(loc_SubMenu_PopUp_TemplateDropDown, "Template Drop Down").contains(TemplateTestData)) {
					clickOn(loc_SubMenu_PopUp_AddButton, "Add Button");
					Thread.sleep(2000);
					switchIntoFrame(frameParent3Xpath);
					sendKeys(loc_SubMenu_PopUp_TemplateNameInputField, TemplateTestData, TemplateTestData, TemplateTestData);
					clickOn(loc_SubMenu_PopUp_SelectAllButton, "Select All Tempalte");					
					clickOn(loc_SubMenu_PopUp_SaveButtonAtTemplateWindow, "Save Button");
					if(!ClientData.contains("VMN")) {
						clickOn(loc_SubMenu_PopUp_CancelButton, "Cancel Button");
					}
					//verifyElementPresent(loc_SubMenu_PopUp_OptionAtPopUpWindow.replace("@var", TemplateTestData), TemplateTestData);
				} else {
					clickOn(loc_SubMenu_PopUp_CancelButton, "Cancel Button");
				}

			}
		}
	
	
		
	}
	
	public void a() throws Exception{}
}

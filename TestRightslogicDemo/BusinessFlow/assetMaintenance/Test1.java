package assetMaintenance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;

@Listeners(utility.ListenerClass.class)
public class Test1 extends MultiClient_SupportingFunctions {
	ArrayList<String> lines = new ArrayList<String>();
	String line = null;
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	String formattedDate = sdf.format(date);
	
	public Test1() {
		super(RI_EditingRightsColumnXpath_EditMode,
				RI_EditingRightsDataRowXpath_EditMode,
				RI_EditingRightsColumnXpath_ViewMode,
				RI_EditingRightsDataRowXpath_ViewMode);
		className = this.getClass().getName(); 
		classObject = this.getClass();
	}

	@Test(priority = 1, enabled = true, description = "Test script")
	public void TC1_AssetCreationTest( ) throws Exception {
		/*List<WebElement> allElements = driver.findElements(ByLocator(""));
		clickOn(allElements.get(1), "");
		
		AssetMaintenance assetMaintenance = new AssetMaintenance();*/
		String createdSeriesAssetTitle = "AUT_AssetSeries_Contri_" +formattedDate+"";
		String InternDetailFirstname = "InternalRSG_"+formattedDate+"";
		String InternDetailLastname = "InternalMedia_"+formattedDate+"";
		String InternReferencevalue = "REFER_InternalRSG_"+formattedDate+"";
		//createContributorInListMaintenance();
		//assetMaintenance.createProgramAsset(createdSeriesAssetTitle, Series_AssetType);
		verifyTextMatches(loc_Episodes_EditEpisodes, "EditEpisodes Button", Episode_EditEpisodes, "value");
		logger.startTest("Test1.TC1_AssetCreationTest");
		logger.log(LogStatus.INFO, "Browser Opened");
		logger.log(LogStatus.INFO, "entered UserName");
		logger.log(LogStatus.INFO, "entered Password");
		logger.log(LogStatus.FAIL, "Verified HomePage");
		clickOn(loc_Tab.replace("@var", "Episodes"), "Episodes TAB");
		
		
	}
	
	public void doIt()
	{
		try {
		File f1 = new File("C:\\SeleniumProject\\Workspace\\RightsLogic\\test-output\\AdvanceReport.html");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		while ((line = br.readLine()) != null) {
			if (line.contains("AddEpisodes_CheckpointFailure_03-01-2017 7-28-21 PM.jpg"))
				line = line.replace("AddEpisodes_CheckpointFailure_03-01-2017 7-28-21 PM.jpg", "CheckpointFailure_03-06-2017 9-36-20 PM.jpg");
			lines.add(line);
		}
		fr.close();
		br.close();

		FileWriter fw = new FileWriter(f1);
		BufferedWriter out = new BufferedWriter(fw);
		for(String s : lines)
			out.write(s);
		out.flush();
		out.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}

	//@Test
	public void main() throws Exception {
	/*	logger.startTest("Start");
		logger.log(LogStatus.PASS, " is Present");
		getScreenShotOnCheckpointFailure("test");
		logger.attachScreenshot("./AddEpisodes_CheckpointFailure_03-01-2017 7-28-21 PM.jpg");
		//doIt();
		logger.startTest("End");*/
	}
	
	

	

}

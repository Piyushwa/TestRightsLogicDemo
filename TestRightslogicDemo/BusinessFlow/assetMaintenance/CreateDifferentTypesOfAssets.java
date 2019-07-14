package assetMaintenance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExecutionLog;
import utility.PropertyReader;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;

public class CreateDifferentTypesOfAssets extends MultiClient_SupportingFunctions  {
	public static List<String> AllAssetType= new ArrayList<String>();
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	Date date ;
	SimpleDateFormat sdf;
	String formattedDate;
	int RowNumberStart;
	int RowNumberEnd;
	String AssetSubType   = PropertyReader.readApplicationFile("AssetSubType");
	
	@BeforeMethod
	public void initializeBrowser() throws Exception {
		getBrowser();
	}
		
	@DataProvider
	public Object[][] setUp() throws InterruptedException {
		
		if(AssetSubType.contains("Program")) {
			RowNumberStart = 132;
			RowNumberEnd = 148;
		} else if(AssetSubType.contains("Element")) {
			RowNumberStart = 149;
			RowNumberEnd = 165;
		}
		
		for(int i = RowNumberStart; i<=RowNumberEnd; i++) {
			if(xlsInputData.getCellData("AMGeneral", ClientData, i).contains("N/A")){
				break;
			}
			AllAssetType.add(xlsInputData.getCellData("AMGeneral", ClientData, i));
	   }
		
		ExecutionLog.Log("There are total " + AllAssetType.size()  +" Asset Sub Type");
		ExecutionLog.Log(""+AllAssetType);
		Object[][] data = new Object[AllAssetType.size()][1];
		for(int i =0; i<AllAssetType.size(); i++){
			data[i][0] = AllAssetType.get(i);
		}
		return data;
	}
	
	@Test(dataProvider="setUp",priority =1,enabled =true,description = "CreateDifferentTypesOfAssets") 
	public void TC1_CreateAsset(String AssetType) throws Exception {
		
		String assetTitleName = "AUT_";
		   
	    date = new Date();
		sdf = new SimpleDateFormat("MMddyyyyhmmss");   
		formattedDate  = sdf.format(date); 
		assetTitleName = assetTitleName+formattedDate+ AssetType+"";
		
		if(AssetSubType.contains("Program")) {
			assetMaintenance.createProgramAsset(assetTitleName,AssetType);
		} else if(AssetSubType.contains("Element")) {
			
		}
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
		
		


}

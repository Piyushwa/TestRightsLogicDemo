package rightsIN;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Listeners;
import commonFunctions.AssetMaintenance;
import commonFunctions.MultiClient_SupportingFunctions;
import commonFunctions.RightsIN;
@Listeners(utility.ListenerClass.class)
public class RI_Payments extends MultiClient_SupportingFunctions {
	Date date ;
	SimpleDateFormat sdf;
	String formattedDate;
	String CreatedMovieAssetTitle1 = "AUT_AssetMovie_";
	String CreatedMovieAssetTitle12 = "AUT_AssetMovie_";
	String CreatedDeal1;
	AssetMaintenance assetMaintenance = new AssetMaintenance();
	RightsIN rightIN = new RightsIN();
	
}

package commonFunctions;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.DriverHelper;
import utility.ExecutionLog;


public class MultiClient_SupportingFunctions extends DriverHelper {

	// Default constructor
	public MultiClient_SupportingFunctions() {
		
		
	}
	
	// Constructor for Assigning the locator of Edit TAB/View Headers
	public MultiClient_SupportingFunctions(String loc_EditTAB_ColumnHeader,
			String loc_EditTAB_ColumnDataRow,
			String loc_ViewModeTAB_ColumnHeader,
			String loc_ViewMode_ColumnDataRow) {
		
		super(loc_EditTAB_ColumnHeader, loc_EditTAB_ColumnDataRow,
				loc_ViewModeTAB_ColumnHeader, loc_ViewMode_ColumnDataRow);

	}
	
	
	

	
	
	
	
	public static void ScrollbarHorizontalRight(WebElement element) {
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(element,10000,0).build().perform();
	}
	
	public static void ScrollbarHorizontalLeft(WebElement element) {
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(element,-10000,0).build().perform();
	}
	
	
	public static void SelectSearchedValue (String Xpath_val, List<WebElement> ele, String Searchvalue, String Methodname) throws IOException{
		String str_xpath=null;
		boolean found=false;
		int rowCount=ele.size();
		ExecutionLog.Log(rowCount+"");
		for(int i=0;i<rowCount;i++)
		{
			str_xpath=Xpath_val;
			String x=driver.findElement(By.xpath(str_xpath)).getText();
			if(x.equals(Searchvalue))
			{
				found=true;
				break;
			}
		}

		if(found==true)
		{
			WebElement obj_lookingString=driver.findElement(By.xpath(str_xpath));
			obj_lookingString.click();
			ExecutionLog.Log("Clicked on the link :"+Searchvalue);
		}
		else
		{
			ExecutionLog.Log("Not able to find the link :"+Searchvalue+" mentioned");
			getScreenShotOnCheckpointFailure(Methodname);
		}
	}
	public static void AlertMessage (WebElement Ele, String Methodname) throws IOException {
		WebElement alert = Ele;
		if (alert.isDisplayed()){
			ExecutionLog.Log("Alert message is Pass");
			String Alertmsg = Ele.getText();
			ExecutionLog.Log( Alertmsg);

		}
		else
		{
			ExecutionLog.Log("=====Failed=====Alert message is Fail");
			getScreenShotOnCheckpointFailure(Methodname);
		}

	}
	public static void DBConnection() throws Exception {

		ExecutionLog.Log(Class.class.desiredAssertionStatus()+"");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rlv3db39:1521:rlv3db39","rlviewer","rlv2");

		if(con!= null){
			CallableStatement pstmt = con.prepareCall("{call prc_ri_exec_raa_etl(?)}");
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		}else{
			ExecutionLog.Log("Could not Get Connection");
		}
	}
	public static void ReportDBConnection() throws Exception {

		ExecutionLog.Log(Class.class.desiredAssertionStatus()+"");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rlv3db54:1521:rlv3db54","rlanltcs","rlv2");

		if(con!= null){
			CallableStatement pstmt = con.prepareCall("{call rlanltcs.prc_ra_refresh_data(?)}");
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		}else{
			ExecutionLog.Log("Could not Get Connection");
		}
	}
	
	

	public static String ChangeHrstoMin (String str) throws InterruptedException {
		String[] h1=str.split(":");
		int hour=Integer.parseInt(h1[0]);
		int minute=Integer.parseInt(h1[1]);
		int second=Integer.parseInt(h1[2]);
		int temp;
		temp = (60 * hour) + minute ;
		return String.format("%02d:%02d",temp,second);
	}
	public static String Diffruntime (String str, String str2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mmm:ss");
		Date d1 = format.parse(str);
		Date d2 = format.parse(str2);
		long diff = Math.abs(d1.getTime() - d2.getTime());
		final long min = TimeUnit.MILLISECONDS.toMinutes(diff);
		final long sec = TimeUnit.MILLISECONDS.toSeconds(diff -TimeUnit.MINUTES.toMillis(min) );
		return String.format("%03d:%02d", min, sec);

	}
	public static String Differencevalue (String str1, String str2) throws ParseException {
		int Firstvalue1 = Integer.parseInt(str1);
		int Firstvalue2 = Integer.parseInt(str2);
		int diff = Math.abs(Firstvalue1 - Firstvalue2 );
		return Integer.toString(diff);

	}
	public static String findTimeDiff (String str, String str2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SS");
		Date d1 = format.parse(str);
		Date d2 = format.parse(str2);
		long diff = Math.abs(d2.getTime() - d1.getTime());

		final long hr = TimeUnit.MILLISECONDS.toHours(diff);
		final long min = TimeUnit.MILLISECONDS.toMinutes(diff - TimeUnit.HOURS.toMillis(hr));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(diff - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
		final long ms = TimeUnit.MILLISECONDS.toMillis(diff - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
		return String.format("%02d:%02d:%02d:%02d", hr, min, sec, ms);

	}
	 
	
	}


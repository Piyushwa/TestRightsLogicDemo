package rightsIN;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class RI_RightsAvailability {
	
	
	

	public static void main(String[] args) throws InterruptedException  {
		
	
	WebDriver driver = new FirefoxDriver();
		driver.get("http://rlv3wb53/Login.aspx?ReturnUrl=%2fhome.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.id("Loginctrl1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("Loginctrl1_txtTempBox")).sendKeys("admin");
		
	driver.findElement(By.name("Loginctrl1$LOGINBUTNEW")).click();
	
	driver.switchTo().window(driver.getWindowHandle());
	
	WebElement frameParent2 = driver.findElement(By.xpath("//div[@clientid ='RL_SplitterPane_Content']"));
    driver.switchTo().frame(frameParent2.findElement(By.tagName("iframe")));
    ((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[@id='PlainTopMenu1_MainMenu']/div[1]/ul/li[5]/a/span")));
   
driver.findElement(By.xpath("//*[@id='PlainTopMenu1_MainMenu_4']/div/ul/li[1]/a/span")).click();	

driver.switchTo().window(driver.getWindowHandle());
frameParent2 = driver.findElement(By.xpath("//div[@clientid ='RL_SplitterPane_Content']"));
Thread.sleep(1000);




driver.switchTo().frame(frameParent2.findElement(By.tagName("iframe")));
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='txtAssetTitle']")).sendKeys("T.u.f.f Puppy");
Select dropdown = new Select(driver.findElement(By.id("cmbSBU")));
dropdown.selectByVisibleText("Nickelodeon");
driver.findElement(By.xpath("//*[@id='txtLicDateFrom']/tbody/tr/td[1]/input")).sendKeys("01012017");

driver.findElement(By.id("btn_ClientSearch")).click();

Thread.sleep(2000);


WebElement togglebutton = driver.findElement(By.id("ToggleImagebtn"));
Thread.sleep(1000);
for (int i = 0; i < 2; i++) {
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	driver.findElement(By.id("ToggleImagebtn"));
	
	togglebutton.click();
}

String Records = driver.findElement(By.id("lblRecords")).getText();
System.out.println(Records);

Select dropdown1 = new Select(driver.findElement(By.id("cmbRollupLevel")));
java.util.List<WebElement> count = dropdown1.getOptions();
int dropsize =  count.size();
for (int i = 0; i < dropsize; i++) {
	String svalue = dropdown1.getOptions().get(i).getText();
	System.out.println(svalue);
	

	
}

driver.findElement(By.id("btnShowCommonRights")).click();
driver.switchTo().window(driver.getWindowHandle());



driver.findElement(By.id("btnShowCommonRights")).click();
driver.findElement(By.xpath("//*[@id='uwtCMRTabs']/span/span/span[2]/span/span/span")).click();
	
	}	

}

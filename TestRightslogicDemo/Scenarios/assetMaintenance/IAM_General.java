package assetMaintenance;

public interface IAM_General {

	
	public void TC1_AssetCreationTest() throws Exception;
	
	public void TC2_ProgramSummary() throws Exception;
	
	public void TC3_VerifyProgSum() throws Exception;
	
	public void TC4_ChangeAssetSubType() throws Exception;
	
	public void TC5_InternalDealforSeriesassets() throws Exception; 
	
	public void TC6_Series_handling() throws Exception;
	
	public void TC7_Validate_duplicate_Asset() throws Exception;
}

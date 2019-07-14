package rightsIN;

public interface I_RI_MediaRights {
	

	public void TC1_MediaRightsUI () throws Exception;			//To verify all UI Elements of RightsIn Media Rights Tab in View mode and Edit mode
		
	public void TC2_MediaRightsView () throws Exception; 		// To verify behavior of fields RightsIn Media Rights Tab - View Mode
	
	public void TC3_MediaRightsMultiple() throws Exception; 	//Functionality of Row Number in Media Rights Tab
	
	public void TC4_MediaRightsCreateMultipleRows() throws Exception; 	//Create multiple rows with different assets in Applies To
	
	public void TC5_DeleteAssetsFromDeal() throws Exception; 	//Delete an Asset from the Deal that has been used in Applies To
	
	public void TC6_MediaRightsCopyRow() throws Exception;		//Verify Copy Functionality
	
	public void TC7_MediaRightsCopyColumn() throws Exception;	//Verify Copy Column Functionality
	
	public void TC8_MediaRightsDelete() throws Exception;		//Verify Delete Functionality
	
	public void TC9_MediaRightsFilter() throws Exception;  		//TC9_MediaRightsFilter
		
	public void TC10_MediaRightsPagination() throws Exception; //TC10_MediaRightsPagination
	

}

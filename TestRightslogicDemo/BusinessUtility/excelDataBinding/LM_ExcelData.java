package excelDataBinding;

import utility.PropertyReader;

public interface LM_ExcelData {

	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\LM_TestData.xlsx");
	String ClientData = PropertyReader.readApplicationFile("Client");

	//LM_CustomAttributes

		//Keys
		String LM_CustomAttributesModuleKey                         = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 3);
		String LM_CustomAttributesAttributeKey                      = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 4);
		String LM_CustomAttributesTypeKey                           = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 5);
		String LM_CustomAttributesAreasKey                          = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 6);
		String LM_CustomAttributesDataTypeKey                       = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 7);
		String LM_CustomAttributesFormatKey                         = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 8);
		String LM_CustomAttributesListElements_CommaSeparatedKey    = xlsInputData.getCellData("LM_CustomAttributes", "Keys", 9);

		//s
		String LM_CustomAttributesModule                         = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 3);
		String LM_CustomAttributesAttribute                      = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 4);
		String LM_CustomAttributesType                           = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 5);
		String LM_CustomAttributesAreas                          = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 6);
		String LM_CustomAttributesDataType                       = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 7);
		String LM_CustomAttributesFormat                         = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 8);
		String LM_CustomAttributesListElements_CommaSeparated    = xlsInputData.getCellData("LM_CustomAttributes", ClientData, 9);


		//Buttons at  Maintain - Custom Attributes
		String LM_CustomAttributesAdd                                = xlsInputData.getCellData("LM_CustomAttributes",ClientData, 21);
		String LM_CustomAttributesDelete                             = xlsInputData.getCellData("LM_CustomAttributes",ClientData, 22);
		String LM_CustomAttributesSave                               = xlsInputData.getCellData("LM_CustomAttributes",ClientData, 23);

}

package project.fileop;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;
import java.util.Map;

import static project.fileop.FileOperations.*;

public class FileOperationsMainMethod {

    public static String requirementDocFolder = "/TestData/RequirementDocs/";
    public static String requirementDocName = "RequirementDoc.xlsx";
    public static String sheetName = "Sheet1";
    public static int headerRowIndex = 0;
    public static List<String> headerRow;
    public static Map<String, List> dataMap;
    public static String columnName = "Field Name";
    public static List<String> columnDataList;
    public static String flagColumnName = "Mandatory";
    public static String flagColFlagValue = "M";
    public static List<String> columnDataWithFilterList;
    public static String reportFolder = "/TestData/InputFiles/";
    public static String reportName = "student_info.csv";



    public static void main(String[] args)throws Exception {
        XSSFSheet finalSheet =openExcelFile(requirementDocFolder, requirementDocName, sheetName);
//        readExcelFile(requirementDocFolder,requirementDocName, sheetName);

        headerRow = getHeaderRow(finalSheet, headerRowIndex);
        System.out.println("Header values: " + headerRow);

        dataMap = getExcelData(finalSheet,headerRowIndex,headerRow);
        System.out.println("Data Map: "+dataMap);

        columnDataList = getSpecificColumnData(dataMap, columnName);
        System.out.println(columnName + " Records: " + columnDataList);

        columnDataWithFilterList = getSpecificColumnDataWithFilter(finalSheet, headerRow, headerRowIndex,columnName, flagColumnName,  flagColFlagValue);
        System.out.println(columnName + " column records list " + " Having flag " + flagColFlagValue + " in " + flagColumnName + " column: " + columnDataWithFilterList);

        List<String> csvHeaderRow = openCSVFileGetHeaderRow(reportFolder,reportName);
        System.out.println("Header row of CSV file: "+csvHeaderRow);

        String result = valiadateOrderOfTwoLists(columnDataList,csvHeaderRow);
        System.out.println(result);

    }
}

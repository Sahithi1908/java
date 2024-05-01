package project.fileop;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileOperations {

    /*
    Description: Get specified column data using filter of other column
    Params: sheet,headerRow, headerRowIndex, requiredColName, flagColName, flag
    Example: Give field Name records which is having M flag in Mandatory Column
     */
    public static List<String> getSpecificColumnDataWithFilter(XSSFSheet finalSheet, List<String> headerRow, int headerRowIndex, String columnName, String flagColumnName, String flagColFlagValue) {

        int colIndex = headerRowIndex + 1;
        List<String> records = new ArrayList<>();
        for (int i = 0; i < headerRow.size(); i++) {
            int flagColIndex = getColumnIndex(finalSheet, flagColumnName);
            int reqColIndex = getColumnIndex(finalSheet, columnName);
            records = new ArrayList<>();
            for (int j = colIndex; j < finalSheet.getLastRowNum(); j++) {
                Cell flagCell = finalSheet.getRow(j).getCell(flagColIndex);
                if (flagCell.getStringCellValue().equals(flagColFlagValue)) {
                    Cell cell = finalSheet.getRow(j).getCell(reqColIndex);
                    records.add(cell.getStringCellValue().strip());
                }
            }
        }
        return records;
    }

//    private static Map readExcelFileUsingSheet(XSSFSheet finalSheet, List<String> headerRow) {
//
//        dataMap = getExcelData(finalSheet, headerRowIndex, headerRow);
//        return dataMap;
//    }

    /*
    Description: Opens the excel sheet
    Params: folderPath, fileName, sheetName
    Output: sheet
     */
    public static XSSFSheet openExcelFile(String requirementDocFolder, String requirementDocName, String sheetName) throws Exception {
        String filePath = System.getProperty("user.dir") + requirementDocFolder + requirementDocName;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }

    /*
    Description: Get specific column data
    Params: dataMap(entire excel data), columnName(required Column Name)
     */
    public static List<String> getSpecificColumnData(Map<String, List> dataMap, String columnName) {
        List<String> colData = new ArrayList<>();
        colData = dataMap.get(columnName);
        return colData;
    }


    /*
    Deprecated

     */
//    private static void readExcelFile(String requirementDocFolder, String requirementDocName, String sheetName) throws Exception {
//        String filePath = System.getProperty("user.dir") + requirementDocFolder + requirementDocName;
//        FileInputStream fileInputStream = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = workbook.getSheet(sheetName);
//        int headerRowIndex = 0;
//
//        headerRow = getHeaderRow(sheet, headerRowIndex);
//        System.out.println("Header values: " + headerRow);
//
//        dataMap = getExcelData(sheet, headerRowIndex, headerRow);
//        System.out.println("Data Map: " + dataMap);
//
//
//    }
/*
Description: Read data from excel and store into a map key is column header name and value is list of same column records
Params: sheet, headerRowIndex, headerRow

 */
    public static Map<String, List> getExcelData(XSSFSheet sheet, int headerRowIndex, List<String> headerRow) {
        HashMap<String, List> dataMap = new HashMap<>();

        List<List<String>> dataTable = new ArrayList<>();
        String headerName = "";

        for (int j = 0; j < headerRow.size(); j++) {
            List<String> records = new ArrayList<>();
            headerName = headerRow.get(j);
            int index = getColumnIndex(sheet, headerName);
            for (int k = headerRowIndex + 1; k <= sheet.getLastRowNum(); k++) {
                Cell cell = sheet.getRow(k).getCell(index);
                String recordValue = cell.getStringCellValue().strip();
                records.add(recordValue);
            }
            dataTable.add(records);
            dataMap.put(headerName, records);
        }

        return dataMap;
    }

    /*
    Description: Get the header row of sheet and into a list
    Params: sheet, headerRowIndex
    Output: headerRowList

     */
    public static List<String> getHeaderRow(XSSFSheet sheet, int headerRowIndex) {
        List<String> headerRow = new ArrayList<>();
        Row row = sheet.getRow(headerRowIndex);
        for (int i = headerRowIndex; i < row.getLastCellNum(); i++) {
            Cell cell = sheet.getRow(headerRowIndex).getCell(i);
            headerRow.add(cell.getStringCellValue().strip());
        }

        return headerRow;
    }

    public static int getColumnIndex(XSSFSheet sheet, String header) {
        int index = -1;
        int headerRowIndex = 0;

        Row headerRow = sheet.getRow(headerRowIndex);

        for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
            Cell cell = headerRow.getCell(cellIndex);

            if (cell != null && cell.getStringCellValue().equals(header)) {
                index = cellIndex;
                break;
            }
        }
        return index;
    }

   public static List<String> openCSVFileGetHeaderRow(String folderName,String fileName)throws Exception{

        String finalPath = System.getProperty("user.dir")+folderName+fileName;
       System.out.println("Csv file Path "+finalPath);
        Reader reader = new FileReader(finalPath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        List<String> headerRowList = new ArrayList<>();
       List<CSVRecord> records = csvParser.getRecords();
       CSVRecord headerRow = records.get(0);
      headerRowList =  headerRow.toList();

       return headerRowList;
   }

    static String valiadateOrderOfTwoLists(List<String> csvHeader, List<String> columnRecord){


        String result = "";


        if(csvHeader.size()==columnRecord.size()){
            for (int i = 0;i< columnRecord.size();i++){
                if(!columnRecord.get(i).equals(csvHeader.get(i))){
                    result = "Order is not same";
                    break;
                }
                else {
                    result = "Both lists order is same";
                }

            }
        }
        else {
            result = "Size is not same";
        }
        return result;

    }
}

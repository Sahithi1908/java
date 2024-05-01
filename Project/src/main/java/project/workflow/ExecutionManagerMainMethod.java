package project.workflow;

import java.util.List;

import static project.fileop.FileOperations.openCSVFileGetHeaderRow;
import static project.workflow.ExecutionManger.*;

public class ExecutionManagerMainMethod {
    public static String folderPath = "/ExecutionManager/";
    public static String fileName = "ExecutionManager.csv";
    public static List<String> reportNamesList ;
    public static List<String> tagsList;
    public static List<String> headerRowList;


    public static void main(String[] args)throws Exception {
        headerRowList = openExecutionManagerFile(folderPath,fileName);

//        List<String> csvHeaderRow = openCSVFileGetHeaderRow(folderPath,fileName);
//        System.out.println("Execution Manager header row : "+csvHeaderRow);

        readDataAndStoreData(folderPath,fileName,headerRowList,reportNamesList,tagsList);


    }
}

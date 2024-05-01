package project.workflow;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import tech.tablesaw.io.csv.CsvReader;

import java.io.FileReader;
import java.sql.Struct;
import java.util.*;

/*
1. Read execution manager csv file
2. Read header

3. Read next columns and check execute and execute all columns in 2,3 columns
4. According to yes or no take all the values and prepare tags

 */
public class ExecutionManger {
    public static List<String> openExecutionManagerFile(String folderPath, String fileName) throws Exception {

        String finalPath = System.getProperty("user.dir") + folderPath + fileName;
        FileReader reader = new FileReader(finalPath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        List<CSVRecord> allrecords = csvParser.getRecords();
        List<String> headerRow = allrecords.get(0).toList();
        return headerRow;
    }

    public static void readDataAndStoreData(String folderPath, String fileName, List<String> headerRow, List<String> reportsNameList, List<String> tagsList) throws Exception {

        String finalPath = System.getProperty("user.dir") + folderPath + fileName;
        FileReader reader = new FileReader(finalPath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        boolean headerFlag = true;
        List<String> values = new ArrayList<>();
        List<String> tags = new ArrayList<>();

        Map<String, List> reportNameAndTags = new HashMap<>();


        for (CSVRecord record : csvParser) {

            if (headerFlag) {
                headerRow = record.stream().toList();
                System.out.println(headerRow);
                headerFlag = false;
            } else {
                values = record.stream().toList();

                Boolean exceute = values.get(1).equalsIgnoreCase("Yes") && values.get(2).equalsIgnoreCase("No");
                Boolean exceuteAll = values.get(1).equalsIgnoreCase("Yes") && values.get(2).equalsIgnoreCase("Yes");


                if (exceuteAll) {
                    for (int i = 3; i < values.size(); i++) {
                        String tag = headerRow.get(i);
                        tags.add(tag);
                    }
                    reportNameAndTags.put(values.get(0), tags);
                    System.out.println(reportNameAndTags);
                }
                if (exceute) {
                    for (int i = 3; i < values.size(); i++) {
                        if (values.get(i).equalsIgnoreCase("Yes")) {
                            String tag = headerRow.get(i);
                            tags.add(tag);
                        }
                    }
                    reportNameAndTags.put(values.get(0), tags);
                    System.out.println(reportNameAndTags);
                }


            }

        }
    }

}

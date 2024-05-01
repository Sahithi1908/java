package project.database;


import java.sql.Connection;

import static project.database.DataBaseOperations.databaseConnection;
import static project.database.DataBaseOperations.executeQuery;

public class DataBaseOperationsMainMethod {
    public static String url = "jdbc:mysql://localhost:3306/mydatabase";
    public static String userName = "root";
    public static String  password = "root";
    public static Connection connection ;
    public static String query = "" ;

    public static void main(String[] args) throws Exception {
      connection =  databaseConnection(url,userName,password);
      executeQuery(query);
    }



}

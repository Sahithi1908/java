package project.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseOperations {
    public static Connection databaseConnection(String url, String userName, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,userName,password);
        if(connection != null){
            System.out.println("Connected to database");
        }
        else {
            System.out.println("Connection Failure");
        }
        return connection;
    }

    public static void  executeQuery(String query){


    }
}

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "studentDatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private DBConnection(){}

    public static DBConnection getInstance(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

    private static DBConnection dbConnection=null;


    private static Connection connection;

    public static Connection getConnection() {
        try {
//            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME,USERNAME,PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return connection;
    }
}

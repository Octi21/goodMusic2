package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {
    private static DatabaseConn singelton = null;
    private static Connection connection = null;
    private static final String url = "jdbc:mysql://localhost:3307/javadb";
    private static final String user = "root";
    private static final String password = "root123";

    private DatabaseConn()
    {
        try
        {
            connection = DriverManager.getConnection(url,
                    user,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(singelton == null) {
            singelton = new DatabaseConn();
        }
        return connection;
    }

}

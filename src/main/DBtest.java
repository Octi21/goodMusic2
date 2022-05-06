package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBtest {

    public static void main(String[] args) {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/javadb",
                    "root", "root123");

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select * from users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(
                        "lname"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

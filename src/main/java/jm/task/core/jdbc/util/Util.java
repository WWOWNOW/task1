package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.List;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/new_schematest";   //user_table
    private static final String USERNAME = "wownow";
    private static final String PASSWORD = "1488";

    private  Connection connection;

    public Util(){
        try {
             connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

//    public static void getConnection() {
//
//        try {
//            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            Statement statement = connection.createStatement();
//            //ResultSet resultSet = statement.executeQuery("select  * from user_table");
//            //while (resultSet.next()) {
//                //System.out.println(resultSet.getInt("age"));
//            //}
//            System.out.println("Connection is done");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }


//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


}

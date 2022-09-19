package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.*;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class UserDaoJDBCImpl implements UserDao {
    List<User> users = new ArrayList<>();
    private static long USERID = 1;
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {

        //подтянуть поля из Юзера
        String tableName = "demo2";
        String column1 = "Id";
        String column1Type = "int";
        String column2 = "name";
        String column2Type = "varchar(45)";
        String column3 = "lastname";
        String column3Type = "varchar(45)";
        String column4 = "age";
        String column4Type = "int";

//        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Statement stmt = util.getConnection().createStatement();
        String query = "CREATE TABLE " + tableName + " ( " + column1 + " " + column1Type + " , " +
                column2 + " " + column2Type + " ," + column3 + " " + column3Type + " ," + column4 + " " + column4Type + ")";

        System.out.printf(query);
        stmt.executeUpdate(query);
        stmt.close();
    }

    public void dropUsersTable() throws SQLException {

        Statement stmt = util.getConnection().createStatement();
        String sql = "DROP TABLE IF EXISTS `demo2`";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Table deleted in given database...");

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {


        Statement stmt = util.getConnection().createStatement();
        stmt.executeUpdate("INSERT INTO `demo2`(Id,name,lastname,age) VALUE ('" + (USERID) + "','" + name + "','" + lastName + "','" + age + "')");
        USERID++;
    }

    public void removeUserById(long id) throws SQLException {

        String sql = "DELETE FROM `demo2` WHERE Id = '" + id + "'";
        PreparedStatement pstmt = util.getConnection().prepareStatement(sql);
        pstmt.executeUpdate();

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> templist = new ArrayList<>();
        String sql = "SELECT * FROM `demo2`";

        Statement statement = util.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            User tempUser = new User();
            tempUser.setId(rs.getLong(1));
            tempUser.setName(rs.getString(2));
            tempUser.setLastName(rs.getString(3));
            tempUser.setAge(rs.getByte(4));
            users.add(tempUser);

        }
        return users;




    }
        /*user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAge(rs.getByte(4));
            users.add(user);*/

    public void cleanUsersTable() throws SQLException {
        String sql = "TRUNCATE TABLE `demo2`";

        PreparedStatement pstmt = util.getConnection().prepareStatement(sql);
        pstmt.executeUpdate();

    }
}


//Class.forName("com.mysql.jdbc.Driver");
//String url = "jdbc:mysql://localhost:3306/sample";

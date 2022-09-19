package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.DriverManager;



public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserServiceImpl userDao = new UserServiceImpl();
        UserDaoJDBCImpl test = new UserDaoJDBCImpl();
        //Util.getConnection();


        //userDao.dropUsersTable();
        userDao.createUsersTable();

//        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        userDao.saveUser("Name2", "Geoge", (byte) 25);
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        userDao.saveUser("Name4", "Mike", (byte) 38);
//
//
//        userDao.removeUserById(2);
////        userDao.getAllUsers();
//        System.out.println();
//
//        System.out.println(userDao.getAllUsers());
//
//        userDao.cleanUsersTable();

        //System.out.println(userDao.getAllUsers());
//        System.out.println(userDao.getAllUsers());

        //userDao.dropUsersTable();

    }
}

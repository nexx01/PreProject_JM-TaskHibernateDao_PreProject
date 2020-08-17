package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getMySQLConnection() throws SQLException,
                                                                 ClassNotFoundException {
        String dbName = "preprojectDB";
        String connectionProperty="?useSSL=false&serverTimezone=Europe/Moscow";
        String hostName = "jdbc:mysql://127.0.0.1:3306/";
        String userName = "root";
        String password = "1234";
        return DriverManager.getConnection(hostName+dbName+connectionProperty, userName, password);
    }


}

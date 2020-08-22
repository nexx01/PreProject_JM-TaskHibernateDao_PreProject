package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getMySQLConnection() throws SQLException,
                                                                 ClassNotFoundException {
        String dbName = "preprojectDB";
        String connectionProperty = "?useSSL=false&serverTimezone=Europe/Moscow";
        String hostName = "jdbc:mysql://127.0.0.1:3306/";
        String userName = "root";
        String password = "1234";
        return DriverManager.getConnection(hostName + dbName + connectionProperty, userName, password);
    }

    public static SessionFactory getHibernateSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/preprojectDB?useSSL=false&serverTimezone=Europe/Moscow");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "1234");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        SessionFactory hibernateSessionFactory = cfg.buildSessionFactory(builder.build());
        cfg.addAnnotatedClass(User.class);
        return hibernateSessionFactory;
    }
}









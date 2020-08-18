package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

    private static SessionFactory hibernateSessionFactory;

    public static SessionFactory getHibernateSessionFactory() {
        if (hibernateSessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                hibernateSessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return hibernateSessionFactory;
    }


    }









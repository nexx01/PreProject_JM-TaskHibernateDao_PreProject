package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan","Ivanov",(byte)55);
        userService.saveUser("Petr","Petrov",(byte)11);
        userService.saveUser("Alex","Alexeev",(byte)34);
        userService.saveUser("Alex","Ivanov",(byte)34);

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

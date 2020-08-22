package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Ivan", "Ivanov", (byte) 55);
        userServiceImpl.saveUser("Petr", "Petrov", (byte) 11);
        userServiceImpl.saveUser("Alex", "Alexeev", (byte) 34);
        userServiceImpl.saveUser("Alex", "Ivanov", (byte) 34);

        for (User user : userServiceImpl.getAllUsers()) {
            System.out.println(user);
        }

        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}

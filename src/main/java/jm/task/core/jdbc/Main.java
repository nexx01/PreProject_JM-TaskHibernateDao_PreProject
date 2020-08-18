package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
/* Алгоритм работы приложения:
 Создание таблицы User(ов)
 Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
 Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
 Очистка таблицы User(ов)
 Удаление таблицы*/

public class Main {
    public static void main(String[] args) {



    }

    public static void workWithJDBC(){
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

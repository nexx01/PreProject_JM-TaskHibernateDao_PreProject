package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() {
        String SELECT_QUERY = "CREATE TABLE USER  (id INT(6) AUTO_INCREMENT," +
                                      "                           name VARCHAR(6) NOT NULL,age INT," +
                                      "PRIMARY KEY(id));";
      try(Connection connection= Util.getMySQLConnection();
          Statement statement=connection.createStatement()) {

      } catch (SQLException throwables) {
          throwables.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
    }
//drop TABLE USER;
    public void dropUsersTable() {
        String SELECT_QUERY = "drop TABLE USER;";
        try (Connection connection=Util.getMySQLConnection();
        Statement statement=connection.createStatement()){

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}

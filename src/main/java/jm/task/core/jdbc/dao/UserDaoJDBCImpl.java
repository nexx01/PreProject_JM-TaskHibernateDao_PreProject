package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String CREATE_QUERY = "CREATE TABLE  IF NOT EXISTS USER(id INT UNSIGNED AUTO_INCREMENT," +
                                      "                           name VARCHAR(20) NOT NULL,lastName VARCHAR(20) NOT NULL, age TINYINT UNSIGNED,\n" +
                                      " PRIMARY KEY(id));";
        try (Statement statement = Util.getMySQLConnection()
                                           .createStatement()) {
            statement.execute(CREATE_QUERY);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String DELETE_QUERY = "DROP TABLE IF EXISTS USER;";
        try (Statement statement = Util.getMySQLConnection()
                                           .createStatement()) {
            statement.execute(DELETE_QUERY);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL_QUERY = "INSERT INTO USER (name,lastName,age) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = Util.getMySQLConnection().prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String SQL_QUERY = "DELETE FROM USER WHERE id=?;";
        try (PreparedStatement preparedStatement = Util.getMySQLConnection().prepareStatement(SQL_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        String SQL_QUERY = "SELECT * FROM USER;";
        try (Statement statement = Util.getMySQLConnection().createStatement()) {
            List<User> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            while (resultSet.next()) {
                list.add(new User(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getByte(4)));
            }
            return list;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }

    //DELETE FROM tb_name;
    public void cleanUsersTable() {
        String DELETE_QUERY = "TRUNCATE TABLE USER;";
        try (Statement statement = Util.getMySQLConnection()
                                           .createStatement()) {
            statement.execute(DELETE_QUERY);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}

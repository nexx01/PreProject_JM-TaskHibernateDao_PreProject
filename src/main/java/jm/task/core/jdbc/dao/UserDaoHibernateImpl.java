package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE  IF NOT EXISTS USER(id INT UNSIGNED AUTO_INCREMENT," +
                                       "                           name VARCHAR(20) NOT NULL,lastName VARCHAR(20) NOT NULL, age TINYINT UNSIGNED,\n" +
                                       " PRIMARY KEY(id));").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS USER;").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getHibernateSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getHibernateSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("Delete FROM User").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

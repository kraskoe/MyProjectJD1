package dao;

import entities.User;

import java.sql.SQLException;

/**
 * Class UserDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface UserDao extends DAO<User> {
    User getByLogin(String login) throws SQLException;
}

package dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import entities.User;

/**
 * Class UserDaoImpl
 *
 * Created by ykrasko on 15/08/2017.
 */
public class UserDaoImpl extends AbstractDao implements UserDao {
    private static volatile UserDao INSTANCE = null;

    private static final String getUser = "SELECT * FROM users WHERE LOGIN=?";
    private PreparedStatement psGetByLogin;

    @Override
    public User getByLogin(String login) throws SQLException {
        psGetByLogin = prepareStatement(getUser);
        psGetByLogin.setString(1, login);
        ResultSet rs = psGetByLogin.executeQuery();
        if (rs.next()) {
            return fillEntity(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public User save(User user) throws SQLException {
        return null;
    }

    @Override
    public User get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    private User fillEntity(ResultSet rs) throws SQLException {
        User entity = new User();
            entity.setId(rs.getLong(1));
            entity.setName(rs.getString(2));
            entity.setLogin(rs.getString(3));
            entity.setPassword(rs.getString(4));
            entity.setRole(rs.getString(7));
        return entity;
    }

    public static UserDao getInstance() {
        UserDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (ProductDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new UserDaoImpl();
                }
            }
        }

        return productDao;
    }
}
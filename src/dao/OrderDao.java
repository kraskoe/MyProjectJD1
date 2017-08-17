package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Order;

/**
 * Class OrderDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface OrderDao extends DAO <Order> {
    List<Order> getByUserId(long userId) throws SQLException;
}

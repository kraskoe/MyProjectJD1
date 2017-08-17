package dao.impl;

import dao.OrderDao;
import entities.Order;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class OrderDaoImpl
 *
 * Created by ykrasko on 15/08/2017.
 */
public class OrderDaoImpl extends AbstractDao implements OrderDao {
    private static volatile OrderDao INSTANCE = null;

    private static final String saveOrderQuery = "INSERT INTO orders (t_id, u_id, order_date) VALUES (?, ?, now())";
    private static final String getOrderQuery = "SELECT * FROM orders WHERE order_id=?";
    private static final String updateOrderQuery = "UPDATE orders SET t_id=?, u_id=?, order_date=? WHERE order_id=?";
    private static final String deleteOrderQuery = "DELETE FROM orders WHERE order_id=?";
    private static final String getAllByUserQuery = "SELECT * FROM orders WHERE u_id=? ORDER BY order_date DESC";

    private PreparedStatement psSave;
    private PreparedStatement psGet;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    private PreparedStatement psGetAllByUserId;

    public static OrderDao getInstance() {
        OrderDao orderDao = INSTANCE;
        if (orderDao == null) {
            synchronized (OrderDaoImpl.class) {
                orderDao = INSTANCE;
                if (orderDao == null) {
                    INSTANCE = orderDao = new OrderDaoImpl();
                }
            }
        }
        return orderDao;
    }

    @Override
    public Order save(Order order) throws SQLException {
        psSave = prepareStatement(saveOrderQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setLong(1, order.getTourId());
        psSave.setLong(2, order.getUserId());
        psSave.setDate(3, order.getOrderDate());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            order.setId(rs.getLong(1));
        }
        close(rs);
        return order;
    }

    @Override
    public Order get(Serializable id) throws SQLException {
        psGet = prepareStatement(getOrderQuery);
        psGet.setLong(1, (long)id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return fillEntity(rs);
        }
        close(rs);
        return null;
    }

    @Override
    public void update(Order order) throws SQLException {
        psUpdate = prepareStatement(updateOrderQuery);
        psUpdate.setLong(1, order.getTourId());
        psUpdate.setLong(2, order.getUserId());
        psUpdate.setDate(3, order.getOrderDate());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteOrderQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Order> getByUserId(long userId) throws SQLException {
        psGetAllByUserId = prepareStatement(getAllByUserQuery);
        psGetAllByUserId.setLong(1, userId);
        psGetAllByUserId.executeQuery();
        ResultSet rs = psGetAllByUserId.getResultSet();
        List<Order> list = new ArrayList<>();
        while (rs.next()) {
            list.add(fillEntity(rs));
        }
        close(rs);
        return list;
    }

    private Order fillEntity(ResultSet rs) throws SQLException {
        Order entity = new Order();
            entity.setId(rs.getLong(1));
            entity.setTourId(rs.getLong(2));
            entity.setUserId(rs.getLong(3));
            entity.setOrderDate(rs.getDate(4));
        return entity;
    }
}

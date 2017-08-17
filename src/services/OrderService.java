package services;

import entities.Order;

import java.io.Serializable;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface OrderService {

    Order createOrder(long userId, long hotelId, int duration, long boardId, int quantity, long flightId);
    Order get(Serializable id);
    void update(Order order);
    int delete(Serializable id);

    List<Order> getByUserId(long userId);
}

package services.impl;

import dao.OrderDao;
import dao.TourDao;
import dao.impl.OrderDaoImpl;
import dao.impl.TourDaoImpl;
import dto.OrderDto;
import dto.impl.OrderDtoImpl;
import entities.Order;
import entities.Tour;
import services.OrderService;
import services.ServiceException;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public class OrderServiceImpl extends AbstractService implements OrderService {
    private static volatile OrderService INSTANCE = null;
    private OrderDao orderDao = OrderDaoImpl.getInstance();
    private TourDao tourDao = TourDaoImpl.getInstance();
    private OrderDtoImpl orderDto = OrderDtoImpl.getInstance();

    public static OrderService getInstance() {
        OrderService orderService = INSTANCE;
        if (orderService == null) {
            synchronized (OrderServiceImpl.class) {
                orderService = INSTANCE;
                if (orderService == null) {
                    INSTANCE = orderService = new OrderServiceImpl();
                }
            }
        }
        return orderService;
    }

    @Override
    public Order createOrder(long userId, long hotelId, int duration, long boardId, int quantity, long flightId) {
        Tour tour = new Tour();
        Order order = new Order();
        double flightCost = 0, roomPrice = 0, boardPrice = 0;

        try {
            startTransaction();

            String getFlightPriceQuery = "SELECT flight_cost FROM flights WHERE flight_id = ?";
            String getHotelPriceQuery = "SELECT room_price, board_price FROM hotels WHERE hotel_id = ?";

            PreparedStatement psFlightPrice = prepareStatement(getFlightPriceQuery);
            psFlightPrice.setLong(1, flightId);
            psFlightPrice.executeQuery();
            ResultSet rsF = psFlightPrice.getResultSet();
            if (rsF.next()) {
                flightCost = rsF.getDouble(1);
            }
            close(rsF);

            PreparedStatement psHotelPrice = prepareStatement(getHotelPriceQuery);
            psHotelPrice.setLong(1, hotelId);
            psHotelPrice.executeQuery();
            ResultSet rsH = psFlightPrice.getResultSet();
            if (rsH.next()) {
                roomPrice = rsH.getDouble(1);
                boardPrice = rsH.getDouble(2);
            }
            close(rsH);

            tour.setHotelID(hotelId);
            tour.setDuration(duration);
            tour.setBoardID(boardId);
            tour.setQuantity(quantity);
            tour.setFlightID(flightId);
            tour.setFullCost((flightCost * quantity + (roomPrice + boardPrice * quantity) * duration + 50 * quantity)*1.3);

            Tour tempTour = tourDao.save(tour);

            order.setUserId(userId);
            order.setTourId(tempTour.getId());
            order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));

            orderDao.save(order);

            commit();
            return order;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Order " + order, e);
        }
    }

    @Override
    public List<OrderDto> getOrders(Serializable id) {
        try {
            return orderDto.getByUserId(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Order by id" + id);
        }
    }

    @Override
    public void updateOrder(Order order) {
        try {
            orderDao.update(order);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Order " + order);
        }
    }

    @Override
    public int deleteOrder(Serializable id) {
        try {
            return orderDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Order by id" + id);
        }
    }

}

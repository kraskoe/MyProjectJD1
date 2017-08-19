USE travel_agency;

# OrderServiceImpl
SELECT flight_cost FROM flights WHERE flight_id = 2;
SELECT room_price, board_price FROM hotels WHERE hotel_id = 3;

# UserDaoImpl
SELECT * FROM users WHERE LOGIN='admin@mail.ru';
INSERT INTO users (login, password, role) VALUES ('user1', 1, 'user');
SELECT * FROM users WHERE user_id=2;
UPDATE users SET login='user1', password=1, role='admin' WHERE user_id=3;
DELETE FROM users WHERE user_id=3;

# TourDaoImpl
INSERT INTO tours (h_id, duration, b_id, p_quantity, full_cost, f_id) VALUES (2, 3, 4, 5, 10, 2);
SELECT * FROM tours WHERE tour_id=2;
UPDATE tours SET h_id=3, duration=4, b_id=5, p_quantity=6, full_cost=15, f_id=3 WHERE tour_id=1;
DELETE FROM tours WHERE tour_id=1;

# not checked
SELECT * FROM tours, orders WHERE orders.t_id=tours.tour_id AND order_id=2;
SELECT * FROM tours, orders, users WHERE orders.t_id=tours.tour_id AND orders.u_id=users.user_id AND user_id=1;

# OrderDaoImpl
INSERT INTO orders (t_id, u_id, order_date) VALUES (2, 1, now());
SELECT * FROM orders WHERE order_id=2;
    private static final String updateOrderQuery = "UPDATE orders SET t_id=?, u_id=?, order_date=? WHERE order_id=?";
    private static final String deleteOrderQuery = "DELETE FROM orders WHERE order_id=?";
    private static final String getAllByUserQuery = "SELECT * FROM orders WHERE u_id=? ORDER BY order_date DESC";
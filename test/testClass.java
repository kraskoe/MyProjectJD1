//package test;
//
//import dto.OrderDto;
//import services.OrderService;
//import services.impl.OrderServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by User on 20.08.2017.
// */
//public class testClass {
//    public static void main(String[] args) {
//
//        OrderService os = OrderServiceImpl.getInstance();
//
//        os.createOrder(2, 5, 7, 4, 3, 1);
//
//        List<OrderDto> ol = new ArrayList<>();
//        ol = os.getOrders(2);
//        for (OrderDto o:ol) {
//            System.out.println(o);
//        }
//
//    }
//}

//        CityDao cd = CityDaoImpl.getInstance();
//
//        List<City> l = new ArrayList<>();
//        try {
//            l = cd.getByCountry(1);
//        } catch (SQLException se){
//            se.printStackTrace();
//        }
//        for (City o:l) {
//            System.out.println(o);
//        }

//        TourService tourService = TourServiceImpl.getInstance();
//        List<Country> cs = new ArrayList<>();
//        cs = tourService.getAllCountries();
//        for (Country c :cs) {
//            System.out.println(c);
//        }
//        System.out.println(Encoder.encode("admin"));
//        try{
//            DataSource.getInstance().getConnection();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        try{
//            DataSource ds = DataSource.getInstance();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        UserDao userDao = UserDaoImpl.getInstance();
//        User user = new User();
//        user.setLogin("2@mail.ru");
//        user.setPassword("2");
//        user.setRole("user");
//        try{
//            userDao.save(user);
//        } catch (SQLException se){
//            se.printStackTrace();
//        }
//
//        ConnectionManager.getConnection();

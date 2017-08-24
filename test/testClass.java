//package test;
//
//import entities.City;
//import services.TourService;
//import services.impl.TourServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by User on 20.08.2017.
// */
//public class testClass {
//    public static void main(String[] args) {
//        TourService tourService = TourServiceImpl.getInstance();
//        List<City> cs = new ArrayList<>();
//        cs = tourService.getCitiesByCountryId(2);
//        for (City c :cs) {
//            System.out.println(c);
//        }
//
//    }
//
////        OrderService os = OrderServiceImpl.getInstance();
////
////        os.createOrder(2, 5, 7, 4, 3, 1);
////
////        List<OrderDto> ol = new ArrayList<>();
////        ol = os.getOrders(2);
////        for (OrderDto o:ol) {
////            System.out.println(o);
////        }
////
////    }
//}
////
////        System.out.println(Encoder.encode("admin"));
////        try{
////            DataSource.getInstance().getConnection();
////        } catch (Exception e){
////            e.printStackTrace();
////        }
//
////        CityDao cd = CityDaoImpl.getInstance();
////
////        List<City> l = new ArrayList<>();
////        try {
////            l = cd.getByCountry(1);
////        } catch (SQLException se){
////            se.printStackTrace();
////        }
////        for (City o:l) {
////            System.out.println(o);
////        }
////
//
//
//
////        try{
////            DataSource ds = DataSource.getInstance();
////        } catch (Exception e){
////            e.printStackTrace();
////        }
////
////
////        UserDao userDao = UserDaoImpl.getInstance();
////        User user = new User();
////        user.setLogin("2@mail.ru");
////        user.setPassword("2");
////        user.setRole("user");
////        try{
////            userDao.save(user);
////        } catch (SQLException se){
////            se.printStackTrace();
////        }
////
////        ConnectionManager.getConnection();

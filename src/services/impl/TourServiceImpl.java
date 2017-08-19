package services.impl;

import dao.BoardDao;
import dao.CityDao;
import dao.FlightDao;
import dao.HotelDao;
import dao.impl.BoardDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.FlightDaoImpl;
import dao.impl.HotelDaoImpl;
import entities.Board;
import entities.City;
import entities.Flight;
import entities.Hotel;
import services.ServiceException;
import services.TourService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public class TourServiceImpl extends AbstractService implements TourService {
    private static volatile TourService INSTANCE = null;

    private FlightDao flightDao = FlightDaoImpl.getInstance();
    private CityDao cityDao = CityDaoImpl.getInstance();
    private HotelDao hotelDao = HotelDaoImpl.getInstance();
    private BoardDao boardDao = BoardDaoImpl.getInstance();

    public static TourService getInstance() {
        TourService tourService = INSTANCE;
        if (tourService == null) {
            synchronized (TourServiceImpl.class) {
                tourService = INSTANCE;
                if (tourService == null) {
                    INSTANCE = tourService = new TourServiceImpl();
                }
            }
        }
        return tourService;
    }


    @Override
    public List<Flight> getFlightsByCountryId(Serializable id) {
        try {
            return flightDao.getByCountry(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Order by id" + id);
        }
    }

    @Override
    public List<City> getCitiesByCountryId(Serializable id) {
        try {
            return cityDao.getByCountry(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Order by id" + id);
        }
    }

    @Override
    public List<Hotel> getHotelsByCityId(Serializable id) {
        try {
            return hotelDao.getByCity(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Order by id" + id);
        }
    }

    @Override
    public List<Board> getBoardsByHotelId(Serializable id) {
        try {
            return boardDao.getByHotel(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Order by id" + id);
        }
    }

}

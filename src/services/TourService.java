package services;

import entities.Board;
import entities.City;
import entities.Flight;
import entities.Hotel;

import java.io.Serializable;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface TourService {

    List<Flight> getFlightsByCountryId(Serializable id);
    List<City> getCitiesByCountryId(Serializable id);
    List<Hotel> getHotelsByCityId(Serializable id);
    List<Board> getBoardsByHotelId(Serializable id);

}

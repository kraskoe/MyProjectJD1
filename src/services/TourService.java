package services;

import entities.*;

import java.io.Serializable;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface TourService {

    List<Country> getAllCountries();
    List<Flight> getAllFlights();
    List<City> getAllCities();
    List<Hotel> getAllHotels();
    List<Board> getAllBoards();

    List<Flight> getFlightsByCountryId(Serializable id);
    List<City> getCitiesByCountryId(Serializable id);
    List<Hotel> getHotelsByCityId(Serializable id);
    List<Board> getBoardsByHotelId(Serializable id);

}

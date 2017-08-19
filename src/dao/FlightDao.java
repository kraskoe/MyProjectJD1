package dao;

import entities.Flight;

import java.sql.SQLException;
import java.util.List;

/**
 * Class FlightDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface FlightDao extends DAO<Flight> {
    List<Flight> getByCountry(long countryId) throws SQLException;
}

package dao;

import entities.City;

import java.sql.SQLException;
import java.util.List;

/**
 * Class CityDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface CityDao extends DAO<City> {
    List<City> getByCountry(long countryId) throws SQLException;
}

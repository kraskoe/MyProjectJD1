package dao;

import entities.Hotel;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Class HotelDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface HotelDao extends DAO<Hotel> {
    List<Hotel> getAllHotels() throws SQLException;
    List<Hotel> getByCity(Serializable cityId) throws SQLException;
}

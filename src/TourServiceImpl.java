import dao.TourDao;
import dao.impl.TourDaoImpl;
import entities.Tour;
import services.ServiceException;
import services.impl.AbstractService;

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
    private TourDao tourDao = TourDaoImpl.getInstance();

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
    public Tour save(Tour tour) {
        try {
            tour = tourDao.save(tour);
        } catch (SQLException e) {
            throw new ServiceException("Error creating tour" + tour);
        }
        return tour;
    }

    @Override
    public Tour get(Serializable id) {
        try {
            return tourDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error geting tour by id " + id);
        }
    }

    @Override
    public void update(Tour tour) {
        try {
            tourDao.update(tour);
        } catch (SQLException e) {
            throw new ServiceException("Error updating tour" + tour);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            return tourDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting tour by id " + id);
        }
    }

    @Override
    public Tour getByOrderId(long orderId) {
        try {
            return tourDao.getByOrderId(orderId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting all tours");
        }
    }

    @Override
    public List<Tour> getByUserId(long userId) {
        try {
            return tourDao.getByUserId(userId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting all tours");
        }
    }
}

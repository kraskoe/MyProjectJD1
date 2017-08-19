import entities.Tour;

import java.io.Serializable;
import java.util.List;

/**
 * Class TourDao
 *
 * Created by ykrasko on 15/08/2017.
 */
public interface TourService {

    Tour save(Tour tour);

    Tour get(Serializable id);

    void update(Tour tour);

    int delete(Serializable id);

    Tour getByOrderId(long orderId);

    List<Tour> getByUserId(long userId);
}

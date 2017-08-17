package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class Order
 *
 * Created by ykrasko on 15/08/2017.
 */
@Data
@NoArgsConstructor
public class Order {
    private long id;
    private String hotel;
    private int duration;
    private String board;
    private double fullCost;
    private Date departure;
    private Date arrival;
    private User user;
}

package db;

import java.sql.Connection;

/**
 * Class ConnectionManager
 *
 * Created by ykrasko on 16/08/2017.
 */
public class ConnectionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static Connection getConnection() throws DbManagerException {
        try {
            if (tl.get() == null) {
                tl.set(DataSource.getInstance().getConnection());
//                tl.set((new DataSource()).getConnection());
            }
            return tl.get();
        } catch (Exception e) {
            throw new DbManagerException("Ошибка получения соединения " +  e.getMessage());
        }
    }
}

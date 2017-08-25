package web.command.impl;

import com.google.gson.Gson;
import dao.FlightDao;
import dao.impl.FlightDaoImpl;
import services.ServiceException;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Class GetDurationController
 *
 * Created by ykrasko on 15/08/2017.
 */
public class GetDurationController implements Controller {
    private FlightDao flightDao = FlightDaoImpl.getInstance();
    int duration = 0;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("flightId") != null){

            long flightId = Long.parseLong(req.getParameter("flightId"));
            try {
                duration = flightDao.getDuration(flightId);
            } catch (SQLException se){
                throw new ServiceException("Error getting duration " + duration, se);
            }

            writer.print(new Gson().toJson(duration));
        } else {
            writer.print("Error: null cityID");
        }

    }
}

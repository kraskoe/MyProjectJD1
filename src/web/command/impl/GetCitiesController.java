package web.command.impl;

import entities.City;
import services.TourService;
import services.impl.TourServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class GetCitiesController
 *
 * Created by ykrasko on 15/08/2017.
 */
public class GetCitiesController implements Controller {
    private TourService tourService = TourServiceImpl.getInstance();
    List<City> cityList = new ArrayList<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("countryId") != null){

            long countryId = Long.parseLong(req.getParameter("countryId"));
            cityList = tourService.getCitiesByCountryId(countryId);

            for (City c:cityList) {
                writer.print("<option class='cityOption' value=" + c.getId() +">" + c.getName());
            }
        } else {
            writer.print("Error: null countryId");
        }

    }
}

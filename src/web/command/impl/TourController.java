package web.command.impl;

import services.TourService;
import services.impl.TourServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class TourController
 *
 * Created by ykrasko on 15/08/2017.
 */
public class TourController implements Controller {
    private TourService tourService = TourServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("countries", tourService.getAllCountries());
        req.getSession().setAttribute("counter", 2);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}

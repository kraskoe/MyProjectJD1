package web.command.impl;

import com.google.gson.Gson;
import entities.Board;
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
 * Class GetBoardsController
 *
 * Created by ykrasko on 15/08/2017.
 */
public class GetBoardsController implements Controller {
    private TourService tourService = TourServiceImpl.getInstance();
    List<Board> boardList = new ArrayList<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("hotelId") != null){

            long hotelId = Long.parseLong(req.getParameter("hotelId"));
            boardList = tourService.getBoardsByHotelId(hotelId);

            String boardListJson = new Gson().toJson(boardList);
            writer.print(boardListJson);
        } else {
            writer.print("Error: null hotelID");
        }

    }
}

package web.command.impl;

import services.OrderService;
import services.impl.OrderServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class DeleteOrderController
 *
 * Created by ykrasko on 15/08/2017.
 */
public class DeleteOrderController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("orderId") != null){

            long orderId = Long.parseLong(req.getParameter("orderId"));
            orderService.deleteOrder(orderId);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+ "/frontController?command=orders");
        } else {
            writer.print("Error deleting order");
        }

    }

}

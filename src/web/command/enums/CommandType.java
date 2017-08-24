package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

/**
 * Enum CommandType
 *
 * Created by ykrasko on 15/08/2017.
 */
@Getter
@AllArgsConstructor
public enum CommandType {
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
    REGISTER("registration.jsp", "Register", new RegisterController()),
    ORDERS("orders/main.jsp", "Orders", new OrderController()),
    TOURS("tours/main.jsp", "Tours", new TourController()),
    MAKE_ORDER("", "MakeOrder", new MakeOrderController()),
    GET_CITIES_AJAX("", "getCities", new GetCitiesController());

    private String pagePath;
    private String pageName;
    private Controller controller;

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с турами
        return TOURS;
    }
}

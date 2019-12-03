package ua.training.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.training.controller.command.Exception;
import ua.training.controller.command.*;
import ua.training.model.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(Login.class);

    public void init(ServletConfig servletConfig) {

        UserService userService = new UserService();
        ProductService productService = new ProductService();
        ProductOrderService productOrderService = new ProductOrderService();
        BoxService boxService = new BoxService();
        OrderService orderService = new OrderService();


        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("", new ShowBoxes(productService, productOrderService));
        commands.put("local/buy-product", new BuyProduct(productService, boxService, productOrderService, orderService));
        commands.put("local/pay", new PayOrder(orderService, productOrderService, boxService));
        commands.put("local/cancel", new CancelPayment(orderService, boxService));
        commands.put("logout", new LogOut());
        commands.put("login", new Login(userService));
        commands.put("registration", new Registration(userService));
        commands.put("exception", new Exception());

        commands.put("user/empty-boxes", new ManagerEmptyBoxes(boxService));
        commands.put("user/add-product", new AddProductToBox(boxService));
        commands.put("user/get-revenue", new GetLastRevenue(productService));

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        logger.info(path);
        path = path.replaceAll(".*/app/", "");
        logger.info(path);
        Command command = commands.getOrDefault(path,
                (r) -> "/app/");
        String page = command.execute(request);
        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
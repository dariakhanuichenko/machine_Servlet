package ua.training.controller.command;

import ua.training.model.service.ProductService;
import ua.training.model.service.RevenueService;

import javax.servlet.http.HttpServletRequest;

public class ShowBoxes implements Command {

    private ProductService productService;
    private RevenueService revenueService;

    public ShowBoxes(ProductService productService, RevenueService revenueService) {
        this.productService = productService;
        this.revenueService = revenueService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String orderId = (String)request.getSession().getId();
        try {
            request.setAttribute("products",productService.findAllWithCurrentLoad());

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("payment", revenueService.findRevenueByOrderId(orderId).orElse(0L));
        return "/index.jsp";
    }
}

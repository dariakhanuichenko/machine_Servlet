package ua.training.controller.command;

import ua.training.model.service.ProductOrderService;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class ShowBoxes implements Command {

    private ProductService productService;

    private ProductOrderService productOrderService;

    public ShowBoxes(ProductService productService, ProductOrderService productOrderService) {
        this.productService = productService;
        this.productOrderService = productOrderService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String orderId = request.getSession().getId();
        try {
            request.setAttribute("products",productService.findAllWithCurrentLoad());

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("return_", "");
        request.setAttribute("error", false);
        request.setAttribute("payment", productOrderService.findRevenueByOrderId(orderId).orElse(0L));
        return "/index.jsp";
    }
}

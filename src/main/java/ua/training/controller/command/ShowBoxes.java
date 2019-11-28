package ua.training.controller.command;

import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class ShowBoxes implements Command {

    private ProductService productService;

    public ShowBoxes(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setAttribute("products",productService.findAllWithCurrentLoad());

        } catch ( java.lang.Exception e) {
            e.printStackTrace();
        }
        return "/index.jsp";
    }
}

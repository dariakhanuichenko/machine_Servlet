package ua.training.controller.command;

import ua.training.model.entity.ProductOrder;
import ua.training.model.entity.Revenue;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class GetLastRevenue implements Command {

    private ProductService productService;

    public GetLastRevenue(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
            String returnStr = "";
            if (productService.findLastRecord().isPresent()) {
                Revenue revenue = productService.findLastRecord().get();

                productService.deleteRevenueById(revenue.getId());
                returnStr = "redirect:/app/manager/empty-boxes?returnMoney=" + revenue.getPayment();
            } else returnStr = "redirect:/app/manager/empty-boxes";
            return returnStr;

    }
}

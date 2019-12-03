package ua.training.controller.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.training.model.entity.Revenue;
import ua.training.model.service.BoxService;
import ua.training.model.service.OrderService;
import ua.training.model.service.ProductOrderService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class PayOrder implements Command {

    private OrderService orderService;
    private ProductOrderService productOrderService;
    private BoxService boxService;

    public PayOrder(OrderService orderService, ProductOrderService productOrderService, BoxService boxService) {
        this.orderService = orderService;
        this.productOrderService = productOrderService;
        this.boxService = boxService;
    }

    private static final Logger log = LogManager.getLogger(Login.class);

    @Override
    public String execute(HttpServletRequest request) {

        log.info("PAY !!!!!!!");
        Long money = Long.parseLong(request.getParameter("money1"));
        //request.setAttribute("money", money);
        log.info(money);

        final String[] result = new String[1];

        String orderId =  request.getSession().getId();
        orderService.getById(orderId).ifPresent(order -> {
            if (money != null) {

                productOrderService.findRevenueByOrderId(orderId).ifPresent(
                        p -> {
                            if (p == 0) {
                                result[0] = "redirect:/app/?error=false";
                            }
                            if (money >= p) {
                                productOrderService.saveRevenue(new Revenue(p, LocalDateTime.now()));
                              //  deletePaidProducts(orderId);
                                orderService.updateOrderSetPaid(0L, orderId);
                                log.info(orderId);
                                productOrderService.deleteByOrderId(orderId);
                                request.setAttribute("payment", 0);
                                result[0] = "redirect:/app/?error=false&&payment=0";
                            } else {
                                result[0] = "redirect:/app/?error=true";
                                orderService.updateOrderSetPaid((order.getPaid() + money), orderId);
                            }
                        });
            }
        });
        return result[0];
    }

    private void deletePaidProducts(String orderId) {
        productOrderService.findProductIdAndNumberByOrderId(orderId)
                .forEach(in -> boxService.updateBoxSetCurrentLoad(
                        (boxService.findCurrentLoadByProductId(in.getId()).orElse(0))-in.getNumber(),
                        in.getId())
                );
    }
}

package ua.training.controller.command;

import ua.training.model.service.BoxService;
import ua.training.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class CancelPayment implements Command {

    private OrderService orderService;
    private BoxService boxService;

    public CancelPayment(OrderService orderService, BoxService boxService) {
        this.orderService = orderService;
        this.boxService = boxService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String orderId = request.getSession().getId();

        orderService.findBoxListByOrder(orderId).forEach(c -> boxService.updateBoxSetCurrentLoad(boxService.findCurrentLoadById(c.getBoxId()).get()+c.getNumber1(), c.getBoxId()));
        return "redirect:/app/?return_=" + orderService.getPaidById(orderId).orElse(0L);
    }
}


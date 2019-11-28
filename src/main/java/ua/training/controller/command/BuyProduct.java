package ua.training.controller.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.training.model.entity.Box;
import ua.training.model.entity.ProductOrder;
import ua.training.model.service.BoxService;
import ua.training.model.service.OrderService;
import ua.training.model.service.ProductOrderService;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class BuyProduct implements Command {
    private ProductService productService;
    private BoxService boxService;
    private ProductOrderService productOrderService;
    private OrderService orderService;
    private static final Logger log = LogManager.getLogger(Login.class);

    public BuyProduct(ProductService productService, BoxService boxService, ProductOrderService productOrderService, OrderService orderService) {
        this.productService = productService;
        this.boxService = boxService;
        this.productOrderService = productOrderService;
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        log.info(request.getParameter("id"));
        Long productId=Long.parseLong(request.getParameter("id"));

        if (productService.getById(productId).isPresent()) {

            log.info( "product exists" + productId);

            Optional<Box> box = boxService.findByProduct(productId);
            if (box.isPresent() && box.get().getCurrentLoad() > 0) {

                String orderId = (String)request.getSession().getId();

                makeNewOrder(orderId);

                Optional<ProductOrder> productOrder = productOrderService.findByOrderIdAndProductId(orderId, productId);

                addProductToOrder(productOrder, orderId, productId, box);

                box.ifPresent(b ->
                        boxService.updateCurrentLoadById((b.getCurrentLoad()-1), b.getId())
                );
            }
            log.info( "end func");
        }
        return "redirect:/app/?error=false";
    }

    private void makeNewOrder(String orderId) {
        if (!orderService.getById(orderId).isPresent()) {
            orderService.save(orderId,0L);
            log.info( "order was created");
        }
    }

    private void addProductToOrder(Optional<ProductOrder> productOrder, String orderId, Long productId, Optional<Box> box) {
        if (productOrder.isPresent()) {
            log.info( "order with this product exists");
            productOrderService.updateProductOrderSetNumber((productOrder.get().getNumber() + 1), orderId, productId);
        } else {
            log.info( "order with this product  doesn't exist");
            productOrderService.save(orderId, productId, 1);
        }
    }
}

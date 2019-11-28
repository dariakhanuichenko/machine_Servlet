package ua.training.model.entity;

//@NamedNativeQuery(
//        name = "getBoxListByOrder",
//        query = "SELECT b.id, (pr.number + b.current_load) as number1 " +
//                "FROM Box b " +
//                "inner join Product_Order pr on pr.product_id= b.id_product " +
//                "WHERE pr.order_id=? ;",
//        resultSetMapping = "OrderDTO"
//)
//
//@SqlResultSetMapping(
//        name = "OrderDTO",
//        classes = @ConstructorResult(
//                targetClass = OrderDTO.class,
//                columns = {
//                        @ColumnResult(name = "id", type = Long.class),
//                        @ColumnResult(name = "number1", type = Integer.class)
//                }
//        )
//)
public class ProductOrder {

    Long productId;
    String orderId;
    int number;

    // standard constructors, getters, and setters

    public ProductOrder() {
    }

    public ProductOrder(Long productId, String orderId, int number) {
        this.productId = productId;
        this.orderId = orderId;
        this.number = number;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


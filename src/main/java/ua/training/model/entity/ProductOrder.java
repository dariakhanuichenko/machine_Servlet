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

    Product product;
    Order order;
    int number;

    // standard constructors, getters, and setters

    public ProductOrder() {
    }

    public ProductOrder(Product product, Order order, int number) {
        this.product = product;
        this.order = order;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


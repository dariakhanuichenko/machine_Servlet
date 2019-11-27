package ua.training.model.entity;


public class Order {

    private String id;
    private Long paid;
    private ProductOrder product;

    public Order() {
    }

    public Order(String id, Long paid, ProductOrder product) {
        this.id = id;
        this.paid = paid;
        this.product = product;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public ProductOrder getProduct() {
        return product;
    }

    public void setProduct(ProductOrder product) {
        this.product = product;
    }
}

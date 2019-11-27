package ua.training.model.entity;



public class Product {

    private Long id;

    private String name;
    private Long price;
    private ProductOrder order;

    public Product() {
    }

    public Product(Long id, String name, Long price, ProductOrder order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ProductOrder getOrder() {
        return order;
    }

    public void setOrder(ProductOrder order) {
        this.order = order;
    }
}

package ua.training.model.dto;


public class ProductDTO {

    private Long id;
    private String name;
    private Long price;
    private Integer currentLoad;

    public ProductDTO(Long id, String name, Long price, Integer currentLoad) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currentLoad = currentLoad;
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

    public Integer getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(Integer currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", currentLoad=" + currentLoad +
                '}';
    }
}

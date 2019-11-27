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
}

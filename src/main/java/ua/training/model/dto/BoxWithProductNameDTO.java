package ua.training.model.dto;


public class BoxWithProductNameDTO {

    private Long id;
    private String name;
    private Integer totalCapasity;

    public BoxWithProductNameDTO(Long id, String name, Integer totalCapasity) {
        this.id = id;
        this.name = name;
        this.totalCapasity = totalCapasity;
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

    public Integer getTotalCapasity() {
        return totalCapasity;
    }

    public void setTotalCapasity(Integer totalCapasity) {
        this.totalCapasity = totalCapasity;
    }
}

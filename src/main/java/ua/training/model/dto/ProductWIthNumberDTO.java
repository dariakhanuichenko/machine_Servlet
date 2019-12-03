package ua.training.model.dto;


public class ProductWIthNumberDTO {

    Long id;
    int number;

    public ProductWIthNumberDTO() {
    }

    public ProductWIthNumberDTO(Long id, int number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ProductWIthNumberDTO{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}

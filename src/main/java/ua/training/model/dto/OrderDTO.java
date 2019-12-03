package ua.training.model.dto;


public class OrderDTO {

    Long boxId;
    Integer number1;

    public OrderDTO(Long boxId, Integer number1) {
        this.boxId = boxId;
        this.number1 = number1;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "boxId=" + boxId +
                ", number1=" + number1 +
                '}';
    }
}

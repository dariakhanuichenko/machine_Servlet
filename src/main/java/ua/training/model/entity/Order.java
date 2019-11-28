package ua.training.model.entity;


public class Order {

    private String id;
    private Long paid;


    public Order() {
    }

    public Order(String id, Long paid) {
        this.id = id;
        this.paid = paid;

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

}

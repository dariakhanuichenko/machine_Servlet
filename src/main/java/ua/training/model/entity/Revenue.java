package ua.training.model.entity;


import java.time.LocalDateTime;

public class Revenue {

    private Long id;
    private Long payment;
    private LocalDateTime dateTime;

    public Revenue() {
    }

    public Revenue(Long id, Long payment, LocalDateTime dateTime) {
        this.id = id;
        this.payment = payment;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

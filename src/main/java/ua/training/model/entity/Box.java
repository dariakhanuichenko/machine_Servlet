package ua.training.model.entity;


import javax.persistence.*;
//
//
//@NamedNativeQuery(
//        name = "getBoxListByCurrentLoad",
//        query = "SELECT p.name, b.id, b.total_capasity  " +
//                "FROM Box b " +
//                "inner join Product p on p.id= b.id_product " +
//                "WHERE b.current_load=? ;",
//        resultSetMapping = "BoxWithProductNameDTO"
//)
//
//@SqlResultSetMapping(
//        name = "BoxWithProductNameDTO",
//        classes = @ConstructorResult(
//                targetClass = BoxWithProductNameDTO.class,
//                columns = {
//                        @ColumnResult(name = "id", type = Long.class),
//                        @ColumnResult(name = "name", type = String.class),
//                        @ColumnResult(name = "total_capasity", type = Integer.class)
//                }
//        )
//)
public class Box {
    private Long id;

    private Integer currentLoad;
    private Integer totalCapasity;

    private Long productId;

    public Box() {
    }

    public Box(Long id, Integer currentLoad, Integer totalCapasity, Long productId) {
        this.id = id;
        this.currentLoad = currentLoad;
        this.totalCapasity = totalCapasity;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(Integer currentLoad) {
        this.currentLoad = currentLoad;
    }

    public Integer getTotalCapasity() {
        return totalCapasity;
    }

    public void setTotalCapasity(Integer totalCapasity) {
        this.totalCapasity = totalCapasity;
    }



}

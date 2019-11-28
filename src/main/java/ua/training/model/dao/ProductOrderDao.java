package ua.training.model.dao;

import ua.training.model.entity.ProductOrder;

import java.util.Optional;

public interface ProductOrderDao extends  GenericDao<ProductOrder> {

     Optional<ProductOrder> findByOrderAndProduct(String orderId, Long productId);
     int updateProductOrderSetNumber(int number, String orderId, Long productId);

     void save(String orderId, Long productId, int number);
}

package ua.training.model.dao;

import ua.training.model.dto.ProductWIthNumberDTO;
import ua.training.model.entity.ProductOrder;
import ua.training.model.entity.Revenue;

import java.util.List;
import java.util.Optional;

public interface ProductOrderDao extends  GenericDao<ProductOrder> {

     Optional<ProductOrder> findByOrderAndProduct(String orderId, Long productId);
     int updateProductOrderSetNumber(int number, String orderId, Long productId);

     void save(String orderId, Long productId, int number);

     Optional<Long>findRevenueByOrderId(String orderId);

     void saveRevenue(Revenue revenue);

     void deleteProductOrderByOrderId(String orderId);

     Optional<List<ProductWIthNumberDTO>>  findProductOrderByOrderId(String orderId);

}

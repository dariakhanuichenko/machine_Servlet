package ua.training.model.dao;

import ua.training.model.dto.OrderDTO;
import ua.training.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends GenericDao<Order> {

    Optional<Order> findById(String id);

    void save(String id, Long paid);

    int updateOrderSetPaid(Long number, String orderId);

    List<OrderDTO> findBoxListByOrder(String orderId);

    Optional<Long> findPaidById(String orderId);;
}

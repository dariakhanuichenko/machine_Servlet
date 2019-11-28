package ua.training.model.dao;

import ua.training.model.entity.Order;

import java.util.Optional;

public interface OrderDao extends GenericDao<Order> {

    Optional<Order> findById(String id);

    void save(String id, Long paid);
}

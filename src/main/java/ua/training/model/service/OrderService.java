package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.OrderDao;
import ua.training.model.entity.Order;

import java.util.Optional;

public class OrderService {
    private DaoFactory daoFactory;
    private OrderDao orderDao;

    public OrderService() {
        this.daoFactory = DaoFactory.getInstance();
        this.orderDao = daoFactory.createOrderDao();
    }

    public Optional<Order> getById(String id){return  orderDao.findById(id);}

    public void save(String id, Long paid){
        orderDao.save(id, paid);
    }
}

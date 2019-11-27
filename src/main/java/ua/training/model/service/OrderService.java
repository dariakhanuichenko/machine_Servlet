package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.OrderDao;

public class OrderService {
    private DaoFactory daoFactory;
    private OrderDao orderDao;

    public OrderService() {
        this.daoFactory = DaoFactory.getInstance();
        this.orderDao = daoFactory.createOrderDao();
    }
}

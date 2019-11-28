package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RevenueDao;

import java.util.Optional;

public class RevenueService {

    private DaoFactory daoFactory;
    private RevenueDao revenueDao;

    public RevenueService() {
        this.daoFactory = DaoFactory.getInstance();
        this.revenueDao = daoFactory.createRevenueDao();
    }

    public Optional<Long> findRevenueByOrderId(String orderId){return revenueDao.findRevenueByOrderId(orderId);}
}

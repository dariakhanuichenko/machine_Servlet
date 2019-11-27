package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RevenueDao;

public class RevenueService {

    private DaoFactory daoFactory;
    private RevenueDao revenueDao;

    public RevenueService() {
        this.daoFactory = DaoFactory.getInstance();
        this.revenueDao = daoFactory.createRevenueDao();
    }
}

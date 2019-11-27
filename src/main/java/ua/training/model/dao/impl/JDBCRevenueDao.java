package ua.training.model.dao.impl;

import ua.training.model.dao.RevenueDao;
import ua.training.model.entity.Revenue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCRevenueDao implements RevenueDao {

    private Connection connection;

    public JDBCRevenueDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Revenue entity) throws SQLException {

    }

    @Override
    public Revenue findByEmail(String email) {
        return null;
    }

    @Override
    public List<Revenue> findAll(int page, int size) {
        return null;
    }

    @Override
    public void update(Revenue entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public long findCount() {
        return 0;
    }
}

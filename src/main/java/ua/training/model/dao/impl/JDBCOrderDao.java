package ua.training.model.dao.impl;

import ua.training.model.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCOrderDao implements ua.training.model.dao.OrderDao {

    private Connection connection;

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Order entity) throws SQLException {

    }

    @Override
    public Order findByEmail(String email) {
        return null;
    }

    @Override
    public List<Order> findAll(int page, int size) {
        return null;
    }

    @Override
    public void update(Order entity) {

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

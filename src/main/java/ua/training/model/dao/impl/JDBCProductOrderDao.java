package ua.training.model.dao.impl;

import ua.training.model.dao.ProductOrderDao;
import ua.training.model.entity.ProductOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCProductOrderDao implements ProductOrderDao {

    private Connection connection;

    public JDBCProductOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(ProductOrder entity) throws SQLException {

    }

    @Override
    public ProductOrder findByEmail(String email) {
        return null;
    }

    @Override
    public List<ProductOrder> findAll(int page, int size) {
        return null;
    }

    @Override
    public void update(ProductOrder entity) {

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

package ua.training.model.dao.impl;

import ua.training.model.dao.BoxDao;
import ua.training.model.entity.Box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCBoxDao implements BoxDao {

    private String queryFindAll = "select * from box";

    private Connection connection;

    JDBCBoxDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Box entity) throws SQLException {

    }

    @Override
    public Box findByEmail(String email) {
        return null;
    }

    @Override
    public List<Box> findAll(int page, int size) {
        List<Box> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(queryFindAll)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Box result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Box entity) {

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

    private Box extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new Box(rs.getLong("id"),
                rs.getInt("current_load"),
                rs.getInt("total_load"),
                rs.getLong("product_id"));
    }
}

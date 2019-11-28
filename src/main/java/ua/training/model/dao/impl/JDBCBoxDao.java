package ua.training.model.dao.impl;

import ua.training.model.dao.BoxDao;
import ua.training.model.entity.Box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCBoxDao implements BoxDao {

    private String queryFindAll = "select * from box";
    private String queryFindByProduct = "select * from box where product_id=?";
    private String updateSetCurrentLoad="update box set current_load=? where id=?";

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
    public Optional<Box> findByProduct(Long id) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByProduct)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void updateSetCurrentLoad(Integer currentLoad,Long id) {
        try (PreparedStatement ps = connection.prepareStatement(
                updateSetCurrentLoad)) {

                ps.setInt(1, currentLoad);
                ps.setLong(2, id);

                ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                rs.getInt("total_capasity"),
                rs.getLong("product_id"));
    }


}

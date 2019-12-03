package ua.training.model.dao.impl;

import ua.training.model.dao.BoxDao;
import ua.training.model.dto.BoxWithProductNameDTO;
import ua.training.model.entity.Box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCBoxDao implements BoxDao {

    private String queryFindById = "select * from box where id=?";
    private String queryFindAll = "select * from box";
    private String queryFindByProduct = "select * from box where product_id=?";
    private String updateSetCurrentLoad = "update box set current_load=? where id=?";
    private String queryFindByCurrentLoad = "SELECT Product.name, Box.id, Box.total_capasity  FROM Box  inner join Product  on Product.id= Box.product_id WHERE Box.current_load=? ";
    private String queryUpdateBoxSetCurrentLoad = "update Box  set current_load =? where  id=?";
    private String queryFindCurrentLoadByProductId="SELECT current_load FROM Box  WHERE product_id = ?";
    private String queryFindCurrentLoadByBoxtId="SELECT current_load FROM Box  WHERE id = ?";

    private Connection connection;

    JDBCBoxDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Box entity) throws SQLException {

    }

    @Override
    public void updateBoxSetCurrentLoad(int currentLoad, Long id) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateBoxSetCurrentLoad)) {

                ps.setInt(1, currentLoad);
                ps.setLong(2, id);
                ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Integer> findCurrentLoadByProductId(Long productId) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindCurrentLoadByProductId)) {
            ps.setLong(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> findCurrentLoadById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindCurrentLoadByBoxtId)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Box> findById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindById)) {
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
    public List<BoxWithProductNameDTO> findBoxDTOByCurrentLoad(Integer currentLoad) {
        List<BoxWithProductNameDTO> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByCurrentLoad)) {
            ps.setInt(1, currentLoad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoxWithProductNameDTO result = extractFromResultSetToBoxWithProductNameDTO(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void updateSetCurrentLoad(Integer currentLoad, Long id) {
        try (PreparedStatement ps = connection.prepareStatement(
                updateSetCurrentLoad)) {

            ps.setInt(1, currentLoad);
            ps.setLong(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
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

    private BoxWithProductNameDTO extractFromResultSetToBoxWithProductNameDTO(ResultSet rs)
            throws SQLException {
        return new BoxWithProductNameDTO(rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("total_capasity"));
    }

}

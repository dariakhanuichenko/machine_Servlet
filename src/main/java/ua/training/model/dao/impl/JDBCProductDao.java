package ua.training.model.dao.impl;

import ua.training.model.dao.ProductDao;
import ua.training.model.dto.ProductDTO;
import ua.training.model.entity.Product;
import ua.training.model.entity.Revenue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCProductDao implements ProductDao {

    private String queryFindAllWithCurrentLoad = "select p.id, p.name, p.price, b.current_load from product p inner join box b on p.id=b.product_id;";
    private String queryFindById = "select * from product where id=?";

    private String queryFindLastRevenue = "SELECT *  FROM revenue  ORDER BY revenue.date_time DESC limit 1";

    private String queryDeleteRevenueById="DELETE FROM revenue  WHERE id = ?";
    private Connection connection;


    public JDBCProductDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void deleteRevenueById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryDeleteRevenueById)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Revenue> findLastRecord() {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindLastRevenue)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(extractFromResultSetToRevenue(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> findAllWithCurrentLoad() {
        List<ProductDTO> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(queryFindAllWithCurrentLoad)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO result = extractFromResultSetToProductDTO(rs);

                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindById)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(extractFromResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void add(Product entity) throws SQLException {

    }

    @Override
    public Product findByEmail(String email) {
        return null;
    }

    @Override
    public List<Product> findAll(int page, int size) {
        return null;
    }

    @Override
    public void update(Product entity) {

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

    private ProductDTO extractFromResultSetToProductDTO(ResultSet rs)
            throws SQLException {
        return new ProductDTO(rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("price"),
                rs.getInt("current_load"));
    }

    private Product extractFromResultSetToProduct(ResultSet rs)
            throws SQLException {
        return new Product(rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("price")
        );
    }

    private Revenue extractFromResultSetToRevenue(ResultSet rs)
            throws SQLException {
        return new Revenue(rs.getLong("id"),
                rs.getLong("payment"),
                rs.getTimestamp("date_time").toLocalDateTime());
    }
}

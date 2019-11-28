package ua.training.model.dao.impl;

import ua.training.model.dao.ProductOrderDao;
import ua.training.model.entity.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCProductOrderDao implements ProductOrderDao {

    private String queryFindByProductAndOrder = "SELECT * FROM Product_Order  WHERE order_id = ? and product_id=?";

    private String queryUpdateNumberByOrderAndProduct = "update Product_Order  set number_ = ? where order_id = ? and product_id=?";

    private String queryInsert="insert into product_order(order_id, product_id, number_) values(?,?,?)";

    private Connection connection;

    public JDBCProductOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<ProductOrder> findByOrderAndProduct(String orderId, Long productId) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByProductAndOrder)) {
            ps.setString(1, orderId);
            ps.setLong(2, productId);
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
    public int updateProductOrderSetNumber(int number, String orderId, Long productId) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateNumberByOrderAndProduct)) {

            ps.setInt(1, number);
            ps.setString(2, orderId);
            ps.setLong(3, productId);
            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(String orderId, Long productId, int number) {
        try (PreparedStatement ps = connection.prepareStatement(queryInsert)) {

                ps.setString(1, orderId);
                ps.setLong(2, productId);
                ps.setInt(3, number);
                ps.executeUpdate();

            }
        catch (SQLException e) {
            throw new RuntimeException("Invalid input");
        }
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

    private ProductOrder extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new ProductOrder(rs.getLong("product_id"),
                rs.getString("order_id"),
                rs.getInt("number_")
        );
    }

}

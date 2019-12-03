package ua.training.model.dao.impl;


import ua.training.model.dao.ProductOrderDao;
import ua.training.model.dto.ProductWIthNumberDTO;
import ua.training.model.entity.ProductOrder;
import ua.training.model.entity.Revenue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCProductOrderDao implements ProductOrderDao {

    private String queryFindByProductAndOrder = "SELECT * FROM Product_Order  WHERE order_id = ? and product_id=?";

    private String queryUpdateNumberByOrderAndProduct = "update Product_Order  set number_ = ? where order_id = ? and product_id=?";

    private String queryInsert = "insert into product_order(order_id, product_id, number_) values(?,?,?)";

    private String queryFindByOrderId = "SELECT sum(number_ *price) as summ FROM Product_Order  join Product  on Product_Order.product_id=Product.id WHERE Product_Order.order_id = ?";

    private String queryListFindByOrderId = "SELECT * FROM Product_Order  WHERE order_id = ? ";

    private String queryDeleteById = "delete from product_order where order_id= ?";
    private String querySaveRevenue = "insert into revenue(payment, date_time) values (?,?)";
    private Connection connection;

    public JDBCProductOrderDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Optional<Long> findRevenueByOrderId(String orderId) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindByOrderId)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.ofNullable(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return Optional.empty();
    }

    @Override
    public Optional<List<ProductWIthNumberDTO>> findProductOrderByOrderId(String orderId) {
        List<ProductWIthNumberDTO> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryListFindByOrderId)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductWIthNumberDTO result = extractFromResultSetToProductWithNumberDTO(rs);

                resultList.add(result);
            }
            return Optional.of(resultList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveRevenue(Revenue revenue) {
        try (PreparedStatement ps = connection.prepareStatement(querySaveRevenue)) {

            ps.setLong(1, revenue.getPayment());
            ps.setTimestamp(2, Timestamp.valueOf(revenue.getDateTime()));
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Invalid input");
        }
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
    public void deleteProductOrderByOrderId(String orderId) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryDeleteById)) {
            ps.setString(1, orderId);
            ps.executeUpdate();
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

        } catch (SQLException e) {
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
    private ProductWIthNumberDTO extractFromResultSetToProductWithNumberDTO(ResultSet rs)
            throws SQLException {
        return new ProductWIthNumberDTO(rs.getLong("product_id"),
                rs.getInt("number_")
        );
    }

}

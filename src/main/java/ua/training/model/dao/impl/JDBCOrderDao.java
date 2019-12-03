package ua.training.model.dao.impl;

import ua.training.model.dto.OrderDTO;
import ua.training.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOrderDao implements ua.training.model.dao.OrderDao {

    private String queryFindById = "select * from orders where id=?";
    private String queryInsert = "insert into orders(id, paid) values(?,?)";
    private String queryUpdateOrderSetPaid = "update Orders  set paid = ? where id = ?";
    private String queryFindBoxListByOrder = "SELECT Box.id, (Product_Order.number_ + Box.current_load) as number1  FROM Box  " +
            "                inner join Product_Order  on Product_Order.product_id= Box.product_id " +
            "                WHERE Product_Order.order_id=?";

    private String queryFindPaidById = "SELECT paid FROM Orders  WHERE id = ? ";


    private Connection connection;

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Long> findPaidById(String orderId) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindPaidById)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<OrderDTO> findBoxListByOrder(String orderId) {
        List<OrderDTO> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindBoxListByOrder)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO result = extractFromResultSetToOrderDTO(rs);
                System.out.println(result.toString());
                resultList.add(result);
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Order> findById(String id) {
        try (PreparedStatement ps = connection.prepareStatement
                (queryFindById)) {
            ps.setString(1, id);
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
    public void save(String id, Long paid) {
        try (PreparedStatement ps = connection.prepareStatement(queryInsert)) {
            ps.setString(1, id);
            ps.setLong(2, paid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Invalid input");
        }
    }

    @Override
    public int updateOrderSetPaid(Long paid, String orderId) {
        try (PreparedStatement ps = connection.prepareStatement(
                queryUpdateOrderSetPaid)) {

            ps.setLong(1, paid);
            ps.setString(2, orderId);
            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    private Order extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new Order(rs.getString("id"),
                rs.getLong("paid")
        );
    }

    private OrderDTO extractFromResultSetToOrderDTO(ResultSet rs)
            throws SQLException {
        return new OrderDTO(rs.getLong(1),
                rs.getInt(2)
        );
    }
}

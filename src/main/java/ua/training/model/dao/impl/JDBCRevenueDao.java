package ua.training.model.dao.impl;

import ua.training.model.dao.RevenueDao;
import ua.training.model.entity.Revenue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCRevenueDao implements RevenueDao {


  //  private String queryFindByOrderId="SELECT sum(number_ *price) as summ FROM Product_Order  join Product  on Product_Order.product_id=Product.id WHERE Product_Order.order_id = ?";
    private Connection connection;

   public JDBCRevenueDao(Connection connection) {
        this.connection = connection;
    }

    /*@Override
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


        return Optional.empty();
    }}*/

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

    private Revenue extractFromResultSet(ResultSet rs)
            throws SQLException {
        return new Revenue(rs.getLong("id"),
                rs.getLong("payment"),
                rs.getTimestamp("date_time").toLocalDateTime());
    }
}

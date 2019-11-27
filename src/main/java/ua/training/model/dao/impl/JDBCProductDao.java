package ua.training.model.dao.impl;

import ua.training.model.dao.ProductDao;
import ua.training.model.dto.ProductDTO;
import ua.training.model.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDao implements ProductDao {

    private String queryFindAllWithCurrentLoad = "select p.id, p.name, p.price, b.current_load from product p inner join box b on p.id=b.product_id;";
    private Connection connection;

    public JDBCProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ProductDTO> findAllWithCurrentLoad() {
        List<ProductDTO> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(queryFindAllWithCurrentLoad)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO result = extractFromResultSetToProductDTO(rs);
                System.out.println(result.toString());
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
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
}

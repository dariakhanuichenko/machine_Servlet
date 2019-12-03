package ua.training.model.dao;

import ua.training.model.dto.ProductDTO;
import ua.training.model.entity.Product;
import ua.training.model.entity.Revenue;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends GenericDao<Product> {

    List<ProductDTO> findAllWithCurrentLoad();

    Optional<Product> findById(Long id);

    Optional<Revenue> findLastRecord();

    void deleteRevenueById(Long id);
}

package ua.training.model.dao;

import ua.training.model.dto.ProductDTO;
import ua.training.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends GenericDao<Product> {

    List<ProductDTO> findAllWithCurrentLoad();
    Optional<Product> findById(Long id);
}

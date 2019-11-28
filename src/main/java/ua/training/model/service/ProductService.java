package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductDao;
import ua.training.model.dto.ProductDTO;
import ua.training.model.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private DaoFactory daoFactory;
    private ProductDao productDao;

    public ProductService() {
        this.daoFactory = DaoFactory.getInstance();
        this.productDao = daoFactory.createProductDao();
    }

    public List<ProductDTO> findAllWithCurrentLoad(){return productDao.findAllWithCurrentLoad();}

    public Optional<Product> getById(Long id){return productDao.findById(id);}
}

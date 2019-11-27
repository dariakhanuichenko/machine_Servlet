package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductDao;
import ua.training.model.dto.ProductDTO;

import java.util.List;

public class ProductService {

    private DaoFactory daoFactory;
    private ProductDao productDao;

    public ProductService() {
        this.daoFactory = DaoFactory.getInstance();
        this.productDao = daoFactory.createProductDao();
    }

    public List<ProductDTO> findAllWithCurrentLoad(){return productDao.findAllWithCurrentLoad();}
}

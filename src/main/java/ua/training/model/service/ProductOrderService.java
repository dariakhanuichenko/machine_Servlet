package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProductOrderDao;
import ua.training.model.dto.OrderDTO;
import ua.training.model.dto.ProductWIthNumberDTO;
import ua.training.model.entity.Order;
import ua.training.model.entity.ProductOrder;
import ua.training.model.entity.Revenue;

import java.util.List;
import java.util.Optional;

public class ProductOrderService {
    private DaoFactory daoFactory;
    private ProductOrderDao productOrderDao;
    public ProductOrderService() {
        this.daoFactory = DaoFactory.getInstance();
        this.productOrderDao = daoFactory.createProductOrderDao();
    }

    public Optional<ProductOrder> findByOrderIdAndProductId(String orderId, Long  productId){
        return productOrderDao.findByOrderAndProduct(orderId, productId);
    }

    public int updateProductOrderSetNumber(int number, String orderId, Long productId) {
        return productOrderDao.updateProductOrderSetNumber(number, orderId, productId);
    }

    public  void save (String orderId, Long productId, int number){
        productOrderDao.save(orderId, productId, number);
    }

    public Optional<Long> findRevenueByOrderId(String orderId){return productOrderDao.findRevenueByOrderId(orderId);}

    public void  saveRevenue(Revenue revenue){productOrderDao.saveRevenue(revenue);}

    public void deleteByOrderId(String orderId){
        productOrderDao.deleteProductOrderByOrderId(orderId);
    }

    public List<ProductWIthNumberDTO> findProductIdAndNumberByOrderId(String orderId){
        return productOrderDao.findProductOrderByOrderId(orderId).get();
    }


}

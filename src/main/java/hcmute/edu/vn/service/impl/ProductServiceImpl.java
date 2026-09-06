package hcmute.edu.vn.service.impl;

import hcmute.edu.vn.dao.ProductDao;
import hcmute.edu.vn.dao.impl.ProductDaoImpl;
import hcmute.edu.vn.entity.Product;
import hcmute.edu.vn.service.ProductService;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> getTop10Newest() {
        return productDao.getTop10Newest();
    }

    @Override
    public List<Product> getProductsByPage(int page, int pageSize) {
        return productDao.getProductsByPage(page, pageSize);
    }

    @Override
    public int getTotalProducts() {
        return productDao.getTotalProducts();
    }
}
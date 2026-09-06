package hcmute.edu.vn.service;

import hcmute.edu.vn.entity.Product;
import java.util.List;

public interface ProductService {
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
    List<Product> getTop10Newest();
    List<Product> getProductsByPage(int page, int pageSize);
    int getTotalProducts();
}
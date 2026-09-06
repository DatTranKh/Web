package hcmute.edu.vn.dao;

import java.util.List;

import hcmute.edu.vn.entity.Product;

public interface ProductDao {
	void insert(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
    List<Product> getTop10Newest();
    List<Product> getProductsByPage(int page, int pageSize);
    int getTotalProducts();
}

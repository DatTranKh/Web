package hcmute.edu.vn.dao.impl;

import hcmute.edu.vn.config.JpaConfig;
import hcmute.edu.vn.dao.ProductDao;
import hcmute.edu.vn.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
	@Override
    public void insert(Product product) {
        EntityManager enma = JpaConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Product product) {
        EntityManager enma = JpaConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager enma = JpaConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Product product = enma.find(Product.class, id);
            if (product != null) {
                enma.remove(product);
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public Product findById(int id) {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            return enma.find(Product.class, id);
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Product> findAll() {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT p FROM Product p";
            TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
            return query.getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Product> getTop10Newest() {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT p FROM Product p ORDER BY p.createdAt DESC";
            TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
            query.setMaxResults(10);
            return query.getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Product> getProductsByPage(int page, int pageSize) {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT p FROM Product p ORDER BY p.createdAt DESC";
            TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public int getTotalProducts() {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT count(p) FROM Product p";
            return ((Long) enma.createQuery(jpql).getSingleResult()).intValue();
        } finally {
            enma.close();
        }
    }
}
package hcmute.edu.vn.dao.impl;

import hcmute.edu.vn.dao.UserDao;
import hcmute.edu.vn.entity.User;
import hcmute.edu.vn.config.JpaConfig; // Đảm bảo import đúng đường dẫn JpaConfig của bạn
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl implements UserDao {

    public User get(String username) {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            // Giả sử Entity User của bạn có thuộc tính 'username'
            String jpql = "SELECT u FROM User u WHERE u.username = :username";
            TypedQuery<User> query = enma.createQuery(jpql, User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Trả về null nếu không tìm thấy user
        } finally {
            enma.close();
        }
    }

    @Override
    public void insert(User user) {
        EntityManager enma = JpaConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(user);
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
    public void update(User user) {
        EntityManager enma = JpaConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(user);
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
    public User findById(int id) {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            return enma.find(User.class, id);
        } finally {
            enma.close();
        }
    }

    @Override
    public User findByEmail(String email) {
        EntityManager enma = JpaConfig.getEntityManager();
        try {
            String jpql = "SELECT u FROM User u WHERE u.email = :email";
            TypedQuery<User> query = enma.createQuery(jpql, User.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            enma.close();
        }
    }

}
package hcmute.edu.vn.dao;

import hcmute.edu.vn.entity.User;

public interface UserDao {
	void insert(User user);
    void update(User user);
    User findById(int id);
    User findByEmail(String email);
    User get(String username);
}
package hcmute.edu.vn.dao;

import hcmute.edu.vn.entity.User;

public interface UserDao {
    // Phương thức cũ của bạn
    User get(String username);
    
    // Thêm các phương thức mới cho chức năng Profile
    User findById(int id);
    void update(User user);
}
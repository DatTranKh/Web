package hcmute.edu.vn.service.impl;

import hcmute.edu.vn.dao.impl.UserDaoImpl;
import hcmute.edu.vn.dao.UserDao;
import hcmute.edu.vn.entity.User;
import hcmute.edu.vn.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }
}

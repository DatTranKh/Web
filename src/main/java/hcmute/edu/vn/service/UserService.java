package hcmute.edu.vn.service;

import hcmute.edu.vn.entity.User;

public interface UserService {
    User login(String username, String password);
    User get(String username);
}
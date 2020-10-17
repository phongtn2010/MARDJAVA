package com.nsw.service;

import java.util.List;
import com.nsw.user.model.User;
import org.springframework.stereotype.Service;

@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

    public User findById(int id) {
        return null;
    }

    public User findBySSO(String sso) {

        return null;

    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUserBySSO(String sso) {

    }

    public List<User> findAllUsers() {
        return null;
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        return false;
    }

}

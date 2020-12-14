package com.nsw.service;

import com.nsw.user.model.UserProfile;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("userProfileService")
//@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    public UserProfile findById(int id) {
        return null;
    }

    public UserProfile findByType(String type) {
        return null;
    }

    public List<UserProfile> findAll() {
        return null;
    }
}

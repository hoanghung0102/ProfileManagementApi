package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.User;
import com.hoanghung.profilemanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUserNameAndPwd(User user) {
        return userRepository.findUserByUserNameAndPwd(user);
    }

}

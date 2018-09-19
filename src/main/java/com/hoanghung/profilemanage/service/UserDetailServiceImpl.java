package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.User;
import com.hoanghung.profilemanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = getUserByUserName(userName);

        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("Username is " + userName + "was not found in database!");
        }

        // Get all user role name
        List<String> roleNames = getAllRoleNamesByUserId(user.getId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames.size() > 0) {
            roleNames.stream().forEach(role -> {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            });
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantList);
    }

    private User getUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    private List<String> getAllRoleNamesByUserId(Long userId) {
        return userRepository.findRoleNamesByUserId(userId);
    }
}

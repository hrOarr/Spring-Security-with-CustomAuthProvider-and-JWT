package com.astrodust.springsecurity.service;

import com.astrodust.springsecurity.entity.User;
import com.astrodust.springsecurity.security.UserDetailsImp;
import com.astrodust.springsecurity.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImp implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        logger.info("SoA:: " + user);
        if(user==null)throw new UsernameNotFoundException("User is not found with name = " + username);
        return UserDetailsImp.build(user);
    }
}

package com.astrodust.springsecurity.security;

import com.astrodust.springsecurity.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class GoogleCloudAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        log.info("GoogleCloudProvider initializing with username {} and password {}", username, password);

        // We fetch user from Google API "in theory"
        User user = getUserFromGoogleCloud(username, password);
        if (user != null) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        }
        throw new BadCredentialsException("Error!!");
    }

    private User getUserFromGoogleCloud(String username, String password) {
        Map<String, String> users = new HashMap<>();
        users.put("test", "123");
        if (users.get(username) != null){
            return new User(username, null, password);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.equals(authenticationType);
    }
}

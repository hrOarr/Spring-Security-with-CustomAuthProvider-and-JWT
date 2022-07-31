package com.astrodust.springsecurity.security;

import com.astrodust.springsecurity.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class GoogleCloudAuthenticationProvider implements AuthenticationProvider {

    private final static Logger logger = LoggerFactory.getLogger(GoogleCloudAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("SoA:: I am GoogleCloudProvider");
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // We fetch user from Google API "in theory"
        User user = getUserFromGoogleCloud(username, password);
        if (user != null) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            return authenticationToken;
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

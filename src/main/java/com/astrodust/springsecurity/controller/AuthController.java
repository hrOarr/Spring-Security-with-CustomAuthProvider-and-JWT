package com.astrodust.springsecurity.controller;

import com.astrodust.springsecurity.dto.JwtResponseDto;
import com.astrodust.springsecurity.dto.LoginDto;
import com.astrodust.springsecurity.dto.RefreshTokenDto;
import com.astrodust.springsecurity.entity.RefreshToken;
import com.astrodust.springsecurity.exception.RefreshTokenException;
import com.astrodust.springsecurity.security.JwtUtils;
import com.astrodust.springsecurity.service.interfaces.RefreshTokenService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JSONObject> authenticateUser(@RequestBody LoginDto loginDto) {
        logger.info("SoA:: Login method");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateJwtToken(authentication);

        String username = (String) authentication.getPrincipal();
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(username);

        JSONObject jsonObject = new JSONObject();
        JwtResponseDto jwtResponseDto = new JwtResponseDto();
        jwtResponseDto.setAccessToken(jwtToken);
        jwtResponseDto.setUsername(username);
        jwtResponseDto.setRefreshToken(refreshToken.getToken());
        jsonObject.put("data", jwtResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
    }

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        String refreshToken = refreshTokenDto.getRefreshToken();
        logger.info("SoA:: I am Refresh");
        return refreshTokenService.findByToken(refreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    JSONObject jsonObject = new JSONObject();
                    RefreshTokenDto result = new RefreshTokenDto();
                    result.setAccessToken(token);
                    result.setRefreshToken(refreshToken);
                    jsonObject.put("data", result);
                    return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
                })
                .orElseThrow(() -> new RefreshTokenException(refreshToken,
                        "Refresh token is not in database!"));
    }
}

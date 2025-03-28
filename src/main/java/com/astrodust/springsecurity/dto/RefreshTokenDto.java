package com.astrodust.springsecurity.dto;

import lombok.Data;

@Data
public class RefreshTokenDto {
    private String refreshToken;
    private String accessToken;
    private String type = "Bearer";
}

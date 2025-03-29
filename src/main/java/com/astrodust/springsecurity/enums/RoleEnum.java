package com.astrodust.springsecurity.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN(5), USER(4), MODERATOR(3);
    private final int rank;
    RoleEnum(int val){
        this.rank = val;
    }
}

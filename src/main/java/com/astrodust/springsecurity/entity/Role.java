package com.astrodust.springsecurity.entity;

import com.astrodust.springsecurity.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private RoleEnum name;

    public Role(RoleEnum roleEnum){
        this.name = roleEnum;
    }
}

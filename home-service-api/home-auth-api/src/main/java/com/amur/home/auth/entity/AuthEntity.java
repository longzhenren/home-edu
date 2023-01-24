package com.amur.home.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String password;

    private Set<String> permissions;
}

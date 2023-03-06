package com.eateasy.requests;

import lombok.Data;

import javax.persistence.Id;

@Data
public class UserInfo {
    @Id
    private String name;
    private String email;
    private String password;

    private String role;

    private String address;

    private String description;
}

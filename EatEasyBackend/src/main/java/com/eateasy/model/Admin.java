package com.eateasy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Admin {

    @Id
    private String email;

    private String password;
}

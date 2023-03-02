package com.eateasy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Users {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    private String name;
    @Id
    private String email;
    private String password;
    private String phoneNumber;



}

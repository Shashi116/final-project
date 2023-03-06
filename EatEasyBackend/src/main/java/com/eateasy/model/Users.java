package com.eateasy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    private String name;
    @Id
    private String email;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Orders> orders;




}

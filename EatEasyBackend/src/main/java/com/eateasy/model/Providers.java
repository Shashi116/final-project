package com.eateasy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Providers {

    @Id
    private String email;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "providers",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Products> products;
}

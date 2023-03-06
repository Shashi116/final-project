package com.eateasy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String providerEmail;

    private String altName;
    private String altEmail;
    private String altPhoneNumber;
    private String altAddress;
    private String altPostalCode;
    private String instruction;
    private String status;
    private String productName;
    private String productQuantity;
    private String productPrice;
    private String subscription;

    private String placeHolder1;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

}

package com.eateasy.model;

import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String placeholder1;
    private String placeholder2;
    private String placeholder3;
    private String category;
    private String description;
    private String title;
    private String price;


    @ManyToOne(fetch = FetchType.LAZY)
    private Providers providers;
}

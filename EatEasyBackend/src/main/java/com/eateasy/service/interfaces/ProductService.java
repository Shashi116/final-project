package com.eateasy.service.interfaces;

import com.eateasy.model.Products;

import java.util.List;

public interface ProductService {
    public void saveProduct(Products products);

    public List<Products> findAll();

//    public List<ProductInfo> findProductInfo();
}

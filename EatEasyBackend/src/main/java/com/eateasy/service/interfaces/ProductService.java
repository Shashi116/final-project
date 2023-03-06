package com.eateasy.service.interfaces;

import com.eateasy.model.Products;
import com.eateasy.model.Providers;

import java.util.List;

public interface ProductService {
    public void saveProduct(Products products);

    public List<Products> findAll();

    List<Products> findByProviders(Providers providers);

    void deleteById(Integer id);


//    public List<ProductInfo> findProductInfo();
}

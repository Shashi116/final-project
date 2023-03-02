package com.eateasy.service.implementatins;

import com.eateasy.model.Products;
import com.eateasy.repository.ProductRepository;
import com.eateasy.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public void saveProduct (Products products) {
        productRepository.save(products);
    }

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

//    @Override
//    public List<ProductInfo> findProductInfo() {
//        return productRepository.findProductInfo();
//    }
}

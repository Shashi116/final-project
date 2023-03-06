package com.eateasy.service.implementatins;

import com.eateasy.model.Products;
import com.eateasy.model.Providers;
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

    @Override
    public List<Products> findByProviders(Providers providers) {
        return productRepository.findByProviders(providers);
    }

    @Override
    public  void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

}

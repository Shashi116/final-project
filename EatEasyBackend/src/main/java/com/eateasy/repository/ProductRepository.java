package com.eateasy.repository;

import com.eateasy.model.Products;
import com.eateasy.model.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    List<Products> findByProviders(Providers providers);

    Products findById(Long id);
}

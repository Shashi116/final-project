package com.eateasy.repository;

import com.eateasy.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

//    @Query("SELECT new com.eateasy.responses.ProductInfo(p1.id,p1.title,p1.price,p1.placeholder1 as image01,p1.placeholder2 as image02,p1.placeholder3 as image03,p1.category,p1.description as desc,\n"
//            + "p2.name as providerName,p2.description as providerdesc,p2.address as providerAddress,p2.phoneNumber as providerPhone )" +
//            "FROM Products p1\n" +
//            "JOIN Providers p2 ")
//    public List<ProductInfo> findProductInfo();
}

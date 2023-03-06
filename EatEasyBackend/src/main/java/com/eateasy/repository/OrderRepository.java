package com.eateasy.repository;

import com.eateasy.model.Orders;
import com.eateasy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findByUsersAndStatus(Users users, String status);
    List<Orders> findByProviderEmailAndStatus(String providerEmail,String status);

    Orders findById(Long id);
}

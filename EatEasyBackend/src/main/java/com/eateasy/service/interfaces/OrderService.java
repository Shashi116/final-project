package com.eateasy.service.interfaces;

import com.eateasy.model.Orders;
import com.eateasy.model.Users;

import java.util.List;

public interface OrderService {
    public void saveAllOrders(List<Orders> orders);

    public List<Orders> findByUsersAndStatus(Users users, String status);

    public List<Orders> findByProviderEmailAndStatus(String providerEmail,String status);

    public Orders findById(Long id);

    public void save(Orders orders);
}

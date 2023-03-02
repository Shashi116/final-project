package com.eateasy.service.interfaces;

import com.eateasy.model.Orders;
import com.eateasy.model.Products;

import java.util.List;

public interface OrderService {
    public void saveAllOrders(List<Orders> orders);

    public List<Orders> findByUserEmail(String userEmail);
}

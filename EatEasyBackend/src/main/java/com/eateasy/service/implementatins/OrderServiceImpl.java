package com.eateasy.service.implementatins;

import com.eateasy.model.Orders;
import com.eateasy.repository.OrderRepository;
import com.eateasy.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public void saveAllOrders(List<Orders> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public List<Orders> findByUserEmail(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }
}

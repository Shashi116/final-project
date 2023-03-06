package com.eateasy.service.implementatins;

import com.eateasy.model.Orders;
import com.eateasy.model.Users;
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
    public List<Orders> findByUsersAndStatus(Users users, String status) {
        return orderRepository.findByUsersAndStatus(users,status);
    }

    @Override
    public List<Orders> findByProviderEmailAndStatus(String providerEmail, String status) {
        return orderRepository.findByProviderEmailAndStatus(providerEmail,status);
    }

    @Override
    public Orders findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }
}

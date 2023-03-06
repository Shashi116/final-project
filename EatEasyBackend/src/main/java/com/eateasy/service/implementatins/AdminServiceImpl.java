package com.eateasy.service.implementatins;

import com.eateasy.model.Admin;
import com.eateasy.repository.AdminRepository;
import com.eateasy.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin findByEmailAndPassword(String email, String password) {

        return adminRepository.findByEmailAndPassword(email,password);
    }
}

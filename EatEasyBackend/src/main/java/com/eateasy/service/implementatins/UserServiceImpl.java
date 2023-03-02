package com.eateasy.service.implementatins;

import com.eateasy.model.Users;
import com.eateasy.repository.UserRepository;
import com.eateasy.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }




}

package com.eateasy.service.interfaces;

import com.eateasy.model.Users;

import java.util.List;

public interface UserService {
    public void saveUser(Users users);
    public List<Users> findAll();
    Users findByEmailAndPassword(String email, String password);

}

package com.eateasy.service.interfaces;

import com.eateasy.model.Admin;

public interface AdminService {
    Admin findByEmailAndPassword(String email, String password);
}

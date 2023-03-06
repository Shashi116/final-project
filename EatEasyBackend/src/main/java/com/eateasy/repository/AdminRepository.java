package com.eateasy.repository;

import com.eateasy.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByEmailAndPassword(String email, String password);
}

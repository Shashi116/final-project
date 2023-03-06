package com.eateasy.repository;

import com.eateasy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    Users findByEmailAndPassword(String email, String password);


}

package com.eateasy.repository;

import com.eateasy.model.Providers;
import com.eateasy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Providers,String> {
    Providers findByEmail(String email);
}

package com.eateasy.repository;

import com.eateasy.model.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Providers,String> {
    Providers findByEmail(String email);

    Providers findByEmailAndPassword(String email,String password);


}

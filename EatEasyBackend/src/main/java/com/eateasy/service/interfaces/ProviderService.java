package com.eateasy.service.interfaces;

import com.eateasy.model.Products;
import com.eateasy.model.Providers;
import com.eateasy.model.Users;

import java.util.List;

public interface ProviderService {
    public void saveProvider(Providers providers);

    public List<Providers> findAll();

    public void deleteProvider(Providers providers);

    public Providers findByEmail(String email);
}

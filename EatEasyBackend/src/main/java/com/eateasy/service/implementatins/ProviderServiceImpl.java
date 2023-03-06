package com.eateasy.service.implementatins;

import com.eateasy.model.Providers;
import com.eateasy.repository.ProviderRepository;
import com.eateasy.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public void saveProvider(Providers providers) {
         providerRepository.save(providers);
    }

    @Override
    public List<Providers> findAll() {

        return providerRepository.findAll();
    }

    @Override
    public void deleteProvider(Providers providers) {
        providerRepository.delete(providers);
    }

    @Override
    public Providers findByEmail(String email) {
        return providerRepository.findByEmail(email);
    }

    @Override
    public Providers findByEmailAndPassword(String email, String password) {
        return providerRepository.findByEmailAndPassword(email,password);
    }


}

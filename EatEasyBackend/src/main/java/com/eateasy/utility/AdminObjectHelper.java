package com.eateasy.utility;

import com.eateasy.model.Providers;
import com.eateasy.responses.AllProviderResponse;

import java.util.ArrayList;
import java.util.List;

public class AdminObjectHelper {

    public static List<AllProviderResponse> prepareAllProviderObject(List<Providers> providersList) {
        List<AllProviderResponse> responses = new ArrayList<>();
        for(Providers providers:providersList){
            AllProviderResponse allProviderResponse = new AllProviderResponse();
            allProviderResponse.setDescription(providers.getDescription());
            allProviderResponse.setName(providers.getName());
            allProviderResponse.setAddress(providers.getAddress());
            allProviderResponse.setEmail(providers.getEmail());

            responses.add(allProviderResponse);
        }
        return responses;

    }

}

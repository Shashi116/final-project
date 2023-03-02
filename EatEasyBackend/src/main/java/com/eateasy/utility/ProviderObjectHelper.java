package com.eateasy.utility;

import com.eateasy.model.Products;
import com.eateasy.model.Providers;
import com.eateasy.requests.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class ProviderObjectHelper {
    public static Providers prepareProviderObject(UserInfo userInfo) {
        Providers providers = new Providers();
        providers.setEmail(userInfo.getEmail());
        providers.setName(userInfo.getName());
        providers.setPassword(userInfo.getPassword());
        providers.setPhoneNumber(userInfo.getPhoneNumber());
        providers.setAddress(userInfo.getAddress());
        providers.setDescription(userInfo.getDescription());

        Products products1 = new Products();
        products1.setTitle("Burger");
        products1.setProviders(providers);


        Products products2 = new Products();
        products2.setTitle("Burger");
        products2.setProviders(providers);

        List<Products> products = new ArrayList<>();
        products.add(products1);
        products.add(products2);

        providers.setProducts(products);

        return providers;
    }
}

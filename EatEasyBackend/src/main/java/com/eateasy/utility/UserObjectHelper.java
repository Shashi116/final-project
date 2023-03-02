package com.eateasy.utility;

import com.eateasy.controller.UserController;
import com.eateasy.model.Orders;
import com.eateasy.model.Products;
import com.eateasy.model.Users;
import com.eateasy.requests.OrderInfo;
import com.eateasy.requests.OrderProductDetail;
import com.eateasy.requests.UserInfo;
import com.eateasy.responses.OrderResponse;
import com.eateasy.responses.ProductInfo;
import com.eateasy.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public  class UserObjectHelper {

    @Autowired
    static
    ProviderService providerService;

    public static Users prepareUserObject(UserInfo userInfo) {
        Users users = new Users();
        users.setEmail(userInfo.getEmail());
        users.setName(userInfo.getName());
        users.setPassword(userInfo.getPassword());
        users.setPhoneNumber(userInfo.getPhoneNumber());

        return users;
    }
    public static List<ProductInfo> prepareProductInfoObject(List<Products> productsList) {
        List<ProductInfo> productInfoList = new ArrayList<>();

        for (Products products : productsList) {
            ProductInfo productInfo = new ProductInfo(products.getId(), products.getTitle(), products.getPrice(), products.getPlaceholder1(), products.getPlaceholder2(), products.getPlaceholder3()
                    , products.getCategory(), products.getDescription(), products.getProviders().getName(), products.getProviders().getDescription(), products.getProviders().getAddress(), products.getProviders().getEmail());
        productInfoList.add(productInfo);
        }
        return productInfoList;
    }

    public static List<Orders> prepareOrderObject(OrderInfo orderInfo) {
        List<Orders> ordersList = new ArrayList<>();
        for(OrderProductDetail orderProductDetail:orderInfo.getOrderProductDetail()){
            Orders orders = new Orders();
            orders.setProviderEmail(orderProductDetail.getProviderEmail());
            orders.setUserEmail(orderInfo.getUserEmail());
            orders.setAltName(orderInfo.getAltName());
            orders.setAltEmail(orderInfo.getAltEmail());
            orders.setAltPhoneNumber(orderInfo.getAltPhoneNumber());
            orders.setAltAddress(orderInfo.getAltAddress());
            orders.setAltPostalCode(orderInfo.getAltPostalCode());
            orders.setInstruction(orderInfo.getInstruction());
            orders.setStatus(orderInfo.getStatus());
            orders.setProductName(orderProductDetail.getName());
            orders.setProductQuantity(orderProductDetail.getQuantity());
            orders.setProductPrice(orderProductDetail.getPrice());
            orders.setSubscription(orderInfo.getSubscription());
            ordersList.add(orders);
        }

        return ordersList;
    }

    public static List<OrderResponse> prepareOrderResponseObject(List<Orders> ordersList,ProviderService providerService) throws Exception {
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for (Orders orders : ordersList) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setProductName(orders.getProductName());
            orderResponse.setProviderName(getProviderName(orders.getProviderEmail(),providerService));
            orderResponse.setPrice(orders.getProductPrice());
            orderResponse.setSubscription(orders.getSubscription());
            orderResponse.setStatus(orders.getStatus());
            orderResponse.setQuantity(orders.getProductQuantity());
            orderResponseList.add(orderResponse);

        }
        return orderResponseList;
    }

    public static String getProviderName(String providerEmail, ProviderService providerService) throws Exception {
        try {
            return providerService.findByEmail(providerEmail).getName();

        } catch (Exception exception) {
            throw new Exception("Unable to fetch the data");
        }

    }





}

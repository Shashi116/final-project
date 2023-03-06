package com.eateasy.controller;


import com.eateasy.model.Orders;
import com.eateasy.model.Products;
import com.eateasy.model.Providers;
import com.eateasy.requests.ProviderProductDelete;
import com.eateasy.responses.CustomError;
import com.eateasy.responses.ProviderOrderResponse;
import com.eateasy.responses.ProviderProductResponse;
import com.eateasy.responses.SuccessfulMessage;
import com.eateasy.service.interfaces.OrderService;
import com.eateasy.service.interfaces.ProductService;
import com.eateasy.service.interfaces.ProviderService;
import com.eateasy.utility.ProviderObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eateasy")
@CrossOrigin
public class ProviderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    ProviderService providerService;


    @PostMapping("/add-product")
    public ResponseEntity<Object> addProduct(@RequestBody Products products) {
        try {
            productService.saveProduct(products);
            return new ResponseEntity<>(new SuccessfulMessage("Added Entry !"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/provider-orders")
    public ResponseEntity<Object> getProviderOrders(@RequestParam String providerEmail,@RequestParam String status) {
        try {
            List<Orders> orders = orderService.findByProviderEmailAndStatus(providerEmail, status);
            List<ProviderOrderResponse> response = ProviderObjectHelper.prepareProviderOrderObject(orders);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new CustomError("Unable to fetch the data"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/update-flag")
    public ResponseEntity<Object> updateStatusFlag(@RequestParam String id) {
        try {
            Orders orders = orderService.findById(Long.valueOf(id));
            orders.setStatus("CLOSED");
            orderService.save(orders);

            return new ResponseEntity<>(new SuccessfulMessage("Flag Updated"), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new CustomError("Unable to fetch the data"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/provider-products")
    public ResponseEntity<Object> getProviderProducts(@RequestParam String providerEmail) {
        try {
            Providers providers = new Providers();
            providers.setEmail(providerEmail);
            List<ProviderProductResponse> responses =ProviderObjectHelper.prepareProviderProductObject(productService.findByProviders(providers));

            return new ResponseEntity<>(responses, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new CustomError("Unable to fetch the data"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    provider-delete

    @PostMapping("/provider-delete")
    public ResponseEntity<Object> deleteProduct(@RequestBody ProviderProductDelete providerProductDelete) {
        try {
            productService.deleteById(Integer.valueOf(providerProductDelete.getId()));
            return new ResponseEntity<>(new SuccessfulMessage("Added Entry !"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

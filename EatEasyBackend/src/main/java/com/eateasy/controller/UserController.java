package com.eateasy.controller;

import com.eateasy.model.Orders;
import com.eateasy.model.Products;
import com.eateasy.model.Providers;
import com.eateasy.requests.OrderInfo;
import com.eateasy.requests.UserInfo;
import com.eateasy.responses.CustomError;
import com.eateasy.model.Users;
import com.eateasy.responses.OrderResponse;
import com.eateasy.responses.SuccessfulMessage;
import com.eateasy.service.interfaces.OrderService;
import com.eateasy.service.interfaces.ProductService;
import com.eateasy.service.interfaces.ProviderService;
import com.eateasy.service.interfaces.UserService;
import com.eateasy.responses.ProductInfo;
import com.eateasy.utility.ProviderObjectHelper;
import com.eateasy.utility.UserObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("eateasy")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private OrderService orderService;

    private final String ADMIN = "Admin";
    private final String USER = "User";
    private final String PROVIDER = "Provider";

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody UserInfo userInfo) {
        try {

            if (userInfo.getRole().equals(ADMIN)) {
//                if(userService.findAll().stream().filter(obj -> obj.getEmail().equals(users.getEmail())).findAny().isPresent()){
//                    return new ResponseEntity<>(new CustomError("Email is already taken !"), HttpStatus.INTERNAL_SERVER_ERROR);
//                }else{
//                    userService.saveUser(users);
//                }

            } else if (userInfo.getRole().equals(PROVIDER)) {
                Providers providers = ProviderObjectHelper.prepareProviderObject(userInfo);
                if (providerService.findAll().stream().filter(obj -> obj.getEmail().equals(providers.getEmail())).findAny().isPresent()) {
                    return new ResponseEntity<>(new CustomError("Email is already taken !"), HttpStatus.INTERNAL_SERVER_ERROR);
                } else {
                    providerService.saveProvider(providers);
                }
            } else {
                Users users = UserObjectHelper.prepareUserObject(userInfo);
                if (userService.findAll().stream().filter(obj -> obj.getEmail().equals(users.getEmail())).findAny().isPresent()) {
                    return new ResponseEntity<>(new CustomError("Email is already taken !"), HttpStatus.INTERNAL_SERVER_ERROR);
                } else {
                    userService.saveUser(users);
                }
            }
            return new ResponseEntity<>(new SuccessfulMessage("Added Entry !"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        try {
            Object obj;
            if (role.equals(ADMIN)) {
                obj = userService.findByEmailAndPassword(email, password);
            } else if (role.equals(PROVIDER)) {
                obj = userService.findByEmailAndPassword(email, password);
            } else {
                obj = userService.findByEmailAndPassword(email, password);
            }
            if (Objects.nonNull(obj)) {
                return new ResponseEntity<>(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomError("Please check your email and password kindly"), HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        try {
            List<Products> products = productService.findAll();
            List<ProductInfo> productInfo = UserObjectHelper.prepareProductInfoObject(products);
            return new ResponseEntity<>(productInfo,HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new CustomError("Unable to fetch the data"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save-orders")
    public ResponseEntity<Object> saveOrders(@RequestBody OrderInfo orderInfo) {
        try {
            List<Orders> orders = UserObjectHelper.prepareOrderObject(orderInfo);
            orderService.saveAllOrders(orders);
            return new ResponseEntity<>(new SuccessfulMessage("Added Entries !"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getAllOrders(@RequestParam String userEmail) {
        try {
            List<Orders> orders = orderService.findByUserEmail(userEmail);

            List<OrderResponse> orderResponseList = UserObjectHelper.prepareOrderResponseObject(orders,providerService);
            return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new CustomError("Unable to fetch the data"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

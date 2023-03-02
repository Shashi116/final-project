package com.eateasy.controller;

import com.eateasy.model.Providers;
import com.eateasy.responses.CustomError;
import com.eateasy.responses.SuccessfulMessage;
import com.eateasy.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eateasy")
@CrossOrigin
public class AdminController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/remove")
    public ResponseEntity<Object> Remove(@RequestBody Providers providers) {
        try {
            Providers provd=providerService.findByEmail(providers.getEmail());
            providerService.deleteProvider(provd);
            return new ResponseEntity<>(new SuccessfulMessage("Removed Entry !"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CustomError("Something went wrong contact your primary admin"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

package com.eateasy.responses;

import lombok.Data;

@Data
public class AllProviderResponse {
    private String email;
    private String name;
    private String address;

    private String description;
}

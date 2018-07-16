package com.example.billing;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestOperations;

public class Client {

    private final RestOperations restTemplate;
    private final String serviceEndpoint;

    public Client(String serviceEndpoint) {

        this.restTemplate = new RestTemplate();
        this.serviceEndpoint = serviceEndpoint;
    }

    public void billUser(String userId, int amount) {

        restTemplate.postForEntity(serviceEndpoint + "/reocurringPayment", amount, String.class);

    }
}

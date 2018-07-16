package com.example.billing;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestOperations;

public class Client {

    private final RestOperations restTemplate;

    public Client(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void billUser(String userId, int amount) {

        restTemplate.postForEntity("//billing/reocurringPayment", amount, String.class);

    }
}

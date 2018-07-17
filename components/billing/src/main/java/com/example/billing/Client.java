package com.example.billing;

import org.springframework.web.client.RestOperations;

public class Client {

    private final RestOperations restTemplate;

    public Client(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void billUser(String userId, int amount) {
        restTemplate.postForEntity("//billing/reoccurringPayment", amount, String.class);
    }

    public void billUserFallback(String userId, int amount) {
        System.out.println("Executing fallback method for user: " + userId + " and amount: " + amount);
    }
}

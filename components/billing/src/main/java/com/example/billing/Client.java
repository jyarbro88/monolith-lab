package com.example.billing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestOperations;

public class Client {

    private final RestOperations restTemplate;

    public Client(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "billUserFallback")
    public void billUser(String userId, int amount) {
        restTemplate.postForEntity("//billing/reoccurringPayment", amount, String.class);
    }

    public void billUserFallback(String userId, int amount) {
        System.out.println("Executing fallback method for user: " + userId + " and amount: " + amount);
    }
}

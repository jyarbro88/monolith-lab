package com.example.billing.billing;

import com.example.payments.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillingController {

    @Autowired
    private Gateway gateway;

    @RequestMapping(
            value = "/recurringPayment",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<String> createRecurringPayment(
            @RequestBody int amount) {

        ResponseEntity<String> response;

        if (gateway.createReocurringPayment(amount)) {
            response = new ResponseEntity<>("{errors: []}", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("{errors: [\"error1\", \"error2\"]}", HttpStatus.BAD_REQUEST);
        }

        return response;

    }
}

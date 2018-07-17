package com.example.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private com.example.payments.Gateway gateway;

    @RequestMapping(
            value = "/reoccurringPayment",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<String> createReoccurringPayment(@RequestBody int amount){

        ResponseEntity<String> response;

        if(gateway.createReoccurringPayment(amount)) {
            response = new ResponseEntity<>("{errors: []}", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("{errors: [\"error1\", \"error2\"]}", HttpStatus.BAD_REQUEST);
        }

        return response;
    }
}
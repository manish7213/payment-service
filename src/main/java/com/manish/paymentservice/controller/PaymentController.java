package com.manish.paymentservice.controller;

import com.manish.paymentservice.entity.Payment;
import com.manish.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/performPayment")
    public ResponseEntity performPayment(@RequestBody Payment payment) {

        Payment payment1 = paymentService.performPayment(payment);
        return new ResponseEntity(payment1, HttpStatus.CREATED);
    }

}

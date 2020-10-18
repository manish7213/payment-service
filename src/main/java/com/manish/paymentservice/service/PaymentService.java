package com.manish.paymentservice.service;

import com.manish.paymentservice.entity.PaymentStatus;
import com.manish.paymentservice.entity.Payment;
import com.manish.paymentservice.reposiitory.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment performPayment(Payment payment) {

        log.info("PaymentService : performPayment(-)");
        payment.setPaymentStatus(paymentStatus());
        payment.setTransactionId(UUID
                .randomUUID()
                .toString());
        return paymentRepository.save(payment);
    }

    // This should be third party payment gateway
    public PaymentStatus paymentStatus() {

        return new Random().nextBoolean() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }

    public Payment findByOrderId(Long orderId) {

        Payment payment = paymentRepository.findByOrderId(orderId);
        log.info("Payment data for the orderId {0} is {1}", orderId, payment);
        return payment;
    }
}

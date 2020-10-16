package com.manish.paymentservice.service;

import com.manish.paymentservice.entity.PAYMENT_STATUS;
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
    public PAYMENT_STATUS paymentStatus() {

        return new Random().nextBoolean() ? PAYMENT_STATUS.SUCCESS : PAYMENT_STATUS.FAILED;
    }
}

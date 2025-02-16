package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Payment;
import com.bcs.project.stpauls.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Create or Update payment
    public Payment saveOrUpdatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Optional<Payment> getPaymentById(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get payment with ID: " + id);
        Optional<Payment> payment = paymentRepository.findById(id);
        System.out.println("Payment object" + payment);
        if (!payment.isPresent()) {
            return Optional.empty();  // Or throw a custom exception
        }
        return payment;
    }

    // Get payment by ID
    public List<Payment> getPaymentByStudentId(Long studentId) {
        if (studentId == null || studentId == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get payment with ID: " + studentId);
        List<Payment> payments = paymentRepository.findByStudent_StudentId(studentId);
        System.out.println("Payment object" + payments);
        if (payments.isEmpty()) {
            return Collections.emptyList();  // Return an empty list instead of Optional.empty()
        }
        return payments;
    }

    public Payment addPayment(Payment payment) {
        if (payment.getPaymentId() != null && paymentRepository.existsById(payment.getPaymentId())) {
            throw new IllegalArgumentException("Payment with ID already exists");
        }
        return paymentRepository.save(payment);
    }

    // Delete payment by ID
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}

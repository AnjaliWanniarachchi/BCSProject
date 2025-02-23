package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Payment;
import com.bcs.project.stpauls.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create or Update Payment
    @PostMapping("/save-payment")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.saveOrUpdatePayment(payment));
    }

    // Get all Payments
    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get Payment by ID
    @GetMapping("/get-payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        System.out.println("Fetching payment with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);  // Prevent fetching with an invalid ID
        }

        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Payment by Student ID
    @GetMapping("/get-payment-by-student/{studentId}")
    public ResponseEntity<List<Payment>> getPaymentByStudentId(@PathVariable Long studentId) {
        System.out.println("Fetching payment with student ID: " + studentId);

        if (studentId == 0) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<Payment> payments = paymentService.getPaymentByStudentId(studentId);

        if (payments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(payments);
    }

    // Add Payment
    @PostMapping("/add-payment")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        try {
            return ResponseEntity.ok(paymentService.addPayment(payment));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Payment by ID
    @DeleteMapping("/delete-payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-payment")
    public ResponseEntity<Payment> editPayment(@RequestBody Payment payment) {
        try {
            // Check if the payment exists by ID
            Optional<Payment> existingPayment = paymentService.getPaymentById(payment.getPaymentId());

            if (!existingPayment.isPresent()) {
                // Return a 404 if the payment doesn't exist
                return ResponseEntity.notFound().build();
            }

            // Update the payment information
            Payment updatedPayment = paymentService.saveOrUpdatePayment(payment);

            // Return the updated payment
            return ResponseEntity.ok(updatedPayment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

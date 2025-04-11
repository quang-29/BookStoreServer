package org.example.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.bookstore.payload.PaymentDTO;
import org.example.bookstore.service.Interface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment_url")
    public ResponseEntity<?> getPaymentUrl(@RequestParam UUID orderId,
                                           HttpServletRequest request) {
        return ResponseEntity.ok().body(Map.of(
                "url", paymentService.getPaymentUrl(orderId, request)
        ));
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkPayment(@RequestParam String gateway,
                                          @RequestParam Map<String, String> params) {
        boolean ok = paymentService.checkPayment(gateway, params);
        return ResponseEntity.ok().body(Map.of(
                "status", ok ? "success" : "failed"
        ));
    }
}

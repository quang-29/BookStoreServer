package org.example.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.bookstore.payload.PaymentDTO;
import org.example.bookstore.payload.response.DataResponse;
import org.example.bookstore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/vn-pay")
    public ResponseEntity<PaymentDTO> pay(HttpServletRequest request) {
        PaymentDTO paymentDTO = paymentService.createVnPayPayment(request);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }
    @GetMapping("/vn-pay-callback")
    public ResponseEntity<PaymentDTO> payCallbackHandler(HttpServletRequest request) {
        String status = request.getParameter("vnp_ResponseCode");
        if (status.equals("00")) {
            PaymentDTO paymentDTO = new PaymentDTO("00", "Success", "");
            return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
        } else {
            PaymentDTO paymentDTO = new PaymentDTO("00", "Failed", null);
            return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
        }
    }
}

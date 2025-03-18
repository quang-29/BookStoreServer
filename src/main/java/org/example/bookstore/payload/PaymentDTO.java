package org.example.bookstore.payload;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private String code;
    private String message;
    private String paymentUrl;
}

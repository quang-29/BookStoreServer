package org.example.bookstore.payload.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PlaceOrderDTO {

    private UUID cartId;

    @NotBlank
    private long addressId;

    @NotBlank
    private String paymentType;

    private int shippingFee;

    private int totalPrice;


}

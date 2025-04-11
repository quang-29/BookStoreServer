package org.example.bookstore.model.shipment;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.bookstore.model.address.Address;

@Getter
@Setter
@Builder
public class ShipmentInfo {

    private Address from;

    private Address to;

    private int weight ;

}

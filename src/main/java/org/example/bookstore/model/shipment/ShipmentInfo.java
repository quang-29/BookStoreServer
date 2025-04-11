package org.example.bookstore.model.shipment;


import lombok.Getter;
import lombok.Setter;
import org.example.bookstore.model.address.Address;

@Getter
@Setter
public class ShipmentInfo {

    private Address from;

    private Address to;

    private int weight;

}

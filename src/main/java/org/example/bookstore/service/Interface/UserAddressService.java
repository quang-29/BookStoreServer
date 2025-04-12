package org.example.bookstore.service.Interface;

import org.example.bookstore.model.UserAddress;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> getAddressListByUser(String username);

    void save(UserAddress userAddress);


}

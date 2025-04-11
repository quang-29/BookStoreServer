package org.example.bookstore.service.Interface;

import org.example.bookstore.model.UserAddress;

import java.util.List;

public interface UserAddressService {

    public List<UserAddress> getAddressListByUser(String username);

    public void save(UserAddress userAddress);


}

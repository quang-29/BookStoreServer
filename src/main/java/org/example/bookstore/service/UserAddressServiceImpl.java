package org.example.bookstore.service;

import org.example.bookstore.model.UserAddress;
import org.example.bookstore.repository.UserAddressRepository;
import org.example.bookstore.service.Interface.UserAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    private UserAddressRepository userAddressRepository;

    @Override
    public List<UserAddress> getAddressListByUser(String username) {
        return userAddressRepository.findByUsername(username) ;
    }

    @Override
    public void save(UserAddress userAddress) {
        userAddressRepository.save(userAddress);
    }
}

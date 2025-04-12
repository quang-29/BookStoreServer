package org.example.bookstore.controller;

import org.example.bookstore.model.UserAddress;
import org.example.bookstore.payload.response.DataResponse;
import org.example.bookstore.service.Interface.UserAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class UserAddressController {
    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<DataResponse> getUsername(@PathVariable String username) {

        List<UserAddress> userAddressList = userAddressService.getAddressListByUser(username);
        DataResponse dataResponse = DataResponse.builder()
                .code(HttpStatus.OK.value())
                .data(userAddressList)
                .timestamp(LocalDateTime.now())
                .message("Success")
                .build();
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
package org.example.bookstore.service.Interface;

import org.example.bookstore.model.UserAddress;
import org.example.bookstore.model.address.District;
import org.example.bookstore.model.address.Province;
import org.example.bookstore.model.address.Ward;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> getAddressListByUser(String username);

    void save(UserAddress userAddress);

    List<Province> getProvinceList();

    Province findProvinceByName(String name);

    List<District> findDistrictByName(String name);

    List<Ward> findWardByName(String name);

    List<District> findDistrictListByProvinceId(int provinceId);

    List<Ward> findWardListByDistrictId(int districtId);

}

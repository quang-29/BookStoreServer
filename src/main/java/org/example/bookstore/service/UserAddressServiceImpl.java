package org.example.bookstore.service;

import org.example.bookstore.model.UserAddress;
import org.example.bookstore.model.address.District;
import org.example.bookstore.model.address.Province;
import org.example.bookstore.model.address.Ward;
import org.example.bookstore.repository.DistrictRepository;
import org.example.bookstore.repository.ProvinceRepository;
import org.example.bookstore.repository.UserAddressRepository;
import org.example.bookstore.repository.WardRepository;
import org.example.bookstore.service.Interface.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<UserAddress> getAddressListByUser(String username) {
        return userAddressRepository.findByUsername(username) ;
    }

    @Override
    public void save(UserAddress userAddress) {
        userAddressRepository.save(userAddress);
    }

    @Override
    public List<Province> getProvinceList() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findProvinceByName(String name) {
        return provinceRepository.findByName(name);
    }

    @Override
    public List<District> findDistrictByName(String name) {
        return districtRepository.findByName(name);
    }

    @Override
    public List<Ward> findWardByName(String name) {
        return wardRepository.findByName(name);
    }

    @Override
    public List<District> findDistrictListByProvinceId(int provinceId) {
        return districtRepository.findAllByProvinceId(provinceId);
    }

    @Override
    public List<Ward> findWardListByDistrictId(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }
}

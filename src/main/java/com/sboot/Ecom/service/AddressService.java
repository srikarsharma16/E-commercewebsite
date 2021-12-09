package com.sboot.Ecom.service;

import java.util.List;

import com.sboot.Ecom.dao.AddressRepository;
import com.sboot.Ecom.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveCustomerAddress(Address address){
        addressRepository.save(address);
        System.out.println(address);
        //addressRepository.insert(address.getCustomerId(),address.getProdId(),address.getPrice(),address.getQuantity(),address.getCountry(),address.getFullName(),address.getMobileNumber(),address.getPinCode(),address.getHouseNumber(),address.getLandmark(),address.getCity(),address.getState(),address.getAddressType());
    }

    public List<Address> fetchByCustomerId() {
        return addressRepository.findAll();
    }

    
}

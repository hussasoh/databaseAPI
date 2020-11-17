package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Address;
import com.farmer.database.farmerdb.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    //save one address
    public Address saveAddress(Address address){ return addressRepository.save(address); }

    //retrieve address
    public Address getAddressByAddressID(int id){ return addressRepository.findById(id).orElse(null); }
    public Address getAddressByCustomerID(int id){ return addressRepository.findByCustomerID(id);}

    //Delete
    public String deleteAddressByAddressID(int id){
        addressRepository.deleteById(id);
        return "Deleted addressID: " + id;
    }
    public String deleteAddressByCustomerID(int id){
        addressRepository.deleteByCustomerID(id);
        return "Deleted CustomerID: " + id;
    }

    //Update
    public Address updateAddress(Address address){
        Address existingAddress = addressRepository.findByCustomerID(address.CustomerID);
        existingAddress.City =address.City;
        existingAddress.Country =address.Country;
        existingAddress.PostalCode = address.PostalCode;
        existingAddress.Street = address.Street;
        existingAddress.unit = address.unit;
        return addressRepository.save(existingAddress);
    }

}

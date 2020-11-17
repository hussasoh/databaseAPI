package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Address;
import com.farmer.database.farmerdb.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody Address address){ return addressService.saveAddress(address);}

    @GetMapping("/AddressByAddressID/{id}")
    public Address getAddressByAddressID(@PathVariable int id){ return addressService.getAddressByAddressID(id);}

    @GetMapping("/AddressByCustomerID/{id}")
    public Address getAddressByCustomerID(@PathVariable int id){ return addressService.getAddressByCustomerID(id);}

    @PutMapping("/UpdateAddress")
    public Address updateAddress(@RequestBody Address address){ return addressService.updateAddress(address);}

    @PutMapping("/deleteAddressByAddressID")
    public String deleteAddressByAddressID(@PathVariable int id) {return addressService.deleteAddressByAddressID(id);}

    @PutMapping("/deleteAddressByCustomerID")
    public String deleteAddressByCustomerID(@PathVariable int id) {return addressService.deleteAddressByCustomerID(id);}

}

package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Services.CustomerService;
import com.farmer.database.farmerdb.Services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@RestController
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping("/addFarmer")
    public Farmer addFarmer(@RequestBody Farmer farmer){
        return farmerService.saveFarmer(farmer);
    }

    @PostMapping("/addFarmers")
    public List<Farmer> addFarmers(@RequestBody List<Farmer> farmers){
        return farmerService.saveFarmers(farmers);
    }

    @GetMapping("/FarmerByID/{id}")
    public Farmer getFarmerByID(@PathVariable int id){
        return farmerService.getFarmerById(id);
    }

    @GetMapping ("/FarmerByCustomerID/{id}")
    public Farmer getFarmerByCustomerID(@PathVariable int id) { return farmerService.getFarmerByCustomerID(id); }

    @GetMapping ("CustomerByFarmerID/{id}")
    public Customer getCustomerByFarmerID(@PathVariable int id){ return farmerService.getCustomerByFarmerID(id); }

    @PutMapping("/deleteFarmer/{id}")
    public String deleteFarmer(@PathVariable int id){
        return farmerService.deleteFarmer(id);
    }
}

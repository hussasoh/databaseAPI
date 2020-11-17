package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Repositories.CustomerRepository;
import com.farmer.database.farmerdb.Repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    //Save one Farmer
    public Farmer saveFarmer(Farmer farmer){
        return farmerRepository.save(farmer);
    }

    //Save a list of Farmers
    public List<Farmer> saveFarmers(List<Farmer> farmers){
        return farmerRepository.saveAll(farmers);
    }

    //retrieve all Farmers
    public List<Farmer> getAllFarmers(){
        return farmerRepository.findAll();
    }
    public  Farmer getFarmerById(int id){
        return farmerRepository.findById(id).orElse(null);
    }
    public List<Farmer> getFarmersByName(String name){ return farmerRepository.findByName(name); }
    public Farmer getFarmerByCustomerID(int id) {return farmerRepository.findByCustomerID(id);}

    public Customer getCustomerByFarmerID(int id){
        int customerid = farmerRepository.getFarmerCustomerID(id);
        return customerRepository.findById(customerid).orElse(null);
    }

    //Delete
    public String deleteFarmer(int id){
        farmerRepository.deleteById(id);
        return "Farmer Removed! " + id;
    }

    //Update
    public Farmer updateFarmer(Farmer farmer){
        Farmer existingFarmer = farmerRepository.findById(farmer.FarmerID).orElse(null);
        existingFarmer.BusinessName = farmer.BusinessName;
        existingFarmer.BusinessDescription = farmer.BusinessDescription;
        existingFarmer.BusinessRating= farmer.BusinessRating;
        return farmerRepository.save(existingFarmer);
    }
}

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
    public Farmer getFarmerByCustomerID(int id) {return farmerRepository.findByCustomerID(id);}

    public Customer getCustomerByFarmerID(int id){
        try {
            int customerid = farmerRepository.getFarmerCustomerID(id);
            return customerRepository.findById(customerid).orElse(null);
        }catch (Exception ex){
            return null;
        }
    }

    //Delete
    public String deleteFarmer(int id){
        farmerRepository.deleteById(id);
        return "Farmer Removed! " + id;
    }

}

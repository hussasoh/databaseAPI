package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public Farm SaveFarm(Farm farm){
        return farmRepository.save(farm);
    }

    public List<Farm> SaveFarms(List<Farm> farms){
        return farmRepository.saveAll(farms);
    }

    public String deleteFarmByID(int id){
        farmRepository.deleteById(id);
        return "deleted farm successfully! by id: " + id;
    }

    public List<Farm> getAllFarms(){
        return farmRepository.findAll();
    }

    public List<Farm> FarmsByFarmerID(int id){
        return farmRepository.getFarmsByFarmerID(id);
    }

    public Farm UpdateFarmByFarmID(Farm farm){
        Farm existingFarm = farmRepository.findById(farm.FarmID).orElse(null);
        if(existingFarm != null){
            existingFarm.Business_Description = farm.Business_Description;
            existingFarm.Business_Name = farm.Business_Name;
            existingFarm.City = farm.City;
            existingFarm.Country = farm.Country;
            existingFarm.PostalCode = farm.PostalCode;
            existingFarm.Province = farm.Province;
            existingFarm.Street = farm.Street;
            existingFarm.Unit = farm.Unit;
            return farmRepository.save(existingFarm);
        }
        return null;
    }

}

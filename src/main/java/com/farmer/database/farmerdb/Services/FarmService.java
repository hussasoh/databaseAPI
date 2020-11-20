package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String  DeleteAllFarmsByFarmerID(int id){
        String deleteIDs = "";
        List<Farm> farms = farmRepository.getFarmsByFarmerID(id);

        for (Farm f:farms) {
            farmRepository.deleteById(f.Farm_ID);
           deleteIDs +=  "deleted farm successfully! by id: " + id + "\n";
        }

        return deleteIDs;
    }
}

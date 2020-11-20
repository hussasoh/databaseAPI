package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmController {

    @Autowired
    private FarmService farmService;

    @PostMapping("/addFarm")
    public Farm SaveFarm(@RequestBody Farm farm){
        return farmService.SaveFarm(farm);
    }

    @PostMapping("/addFarms")
    public List<Farm> SaveFarms(@RequestBody  List<Farm> farms){
        return farmService.SaveFarms(farms);
    }

    @PutMapping("/deleteFarmByID/{id}")
    public String deleteFarmByID(@PathVariable int id){
        return farmService.deleteFarmByID(id);
    }

    @GetMapping("/Farms")
    public List<Farm> getAllFarms(){
        return farmService.getAllFarms();
    }

    @GetMapping("/FarmsByFarmerID/{id}")
    public List<Farm> FarmsByFarmerID(@PathVariable int id){
        return farmService.FarmsByFarmerID(id);
    }

}

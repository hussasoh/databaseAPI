package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Entities.FarmerProduct;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Services.FarmersProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmersProductController {

    @Autowired
    private FarmersProductService farmersProductService;

    @PostMapping("/AddFarmersProduct")
    public FarmerProduct AddFarmersProduct(@RequestBody FarmerProduct farmerProduct){ return farmersProductService.saveFarmerProduct(farmerProduct); }

    @PostMapping("/AddFarmersProducts")
    public List<FarmerProduct> AddFarmersProduct(@RequestBody List<FarmerProduct> farmerProducts){ return farmersProductService.saveFarmerProducts(farmerProducts); }

    @PutMapping("/deleteFarmersProduct/{id}")
    public String deleteFarmersProduct (@PathVariable int id){
        return farmersProductService.delete(id);
    }

    @PutMapping("/deleteAllFarmersProductByFarmerID/{id}")
    public String deleteAllFarmersProductByFarmerID(@PathVariable int id) { return  farmersProductService.deleteAllProductsOfFarmer(id);}

    @PutMapping("/deleteAllFarmersProductByProductID/{id}")
    public String deleteAllFarmersProductByProductID(@PathVariable int id) { return  farmersProductService.deleteAllFamersProductByProductID(id);}

    @GetMapping("/FarmersByProductID/{id}")
    public List<Farmer> getFarmersByProductID(@PathVariable int id){ return farmersProductService.getFarmersByProduct(id); }

    @GetMapping("/ProductsByFarmerID/{id}")
    public List<Product> getProductsByFarmerID(@PathVariable int id){ return farmersProductService.getProductsByFarmer(id); }







}

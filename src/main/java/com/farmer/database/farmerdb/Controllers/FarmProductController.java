package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Entities.FarmProduct;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Services.FarmProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmProductController {

    @Autowired
    private FarmProductService farmProductService;

    @PostMapping("/AddFarmProduct")
    public FarmProduct AddFarmersProduct(@RequestBody FarmProduct farmProduct){ return farmProductService.saveFarmProduct(farmProduct); }

    @PostMapping("/AddFarmProducts")
    public List<FarmProduct> AddFarmersProduct(@RequestBody List<FarmProduct> farmProducts){ return farmProductService.saveFarmProducts(farmProducts); }

    @PutMapping("/deleteFarmProduct/{id}")
    public String deleteFarmersProduct (@PathVariable int id){
        return farmProductService.delete(id);
    }

    @PutMapping("/deleteAllFarmProductByFarmID/{id}")
    public String deleteAllFarmersProductByFarmerID(@PathVariable int id) { return  farmProductService.deleteAllProductsOfFarmer(id);}

    @PutMapping("/deleteAllFarmProductByProductID/{id}")
    public String deleteAllFarmersProductByProductID(@PathVariable int id) { return  farmProductService.deleteAllFarmProductByProductID(id);}

    @GetMapping("/FarmsByProductID/{id}")
    public List<Farm> getFarmersByProductID(@PathVariable int id){ return farmProductService.getFarmsByProduct(id); }

    @GetMapping("/ProductsByFarmID/{id}")
    public List<Product> getProductsByFarmerID(@PathVariable int id){ return farmProductService.getProductsByFarm(id); }

}

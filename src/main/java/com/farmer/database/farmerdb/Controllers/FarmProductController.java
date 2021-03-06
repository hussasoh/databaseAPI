package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Entities.FarmProduct;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Services.FarmProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
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

    @PutMapping("/deleteFarmProductByFarmIDAndProductID/{FarmID}/{ProductID}")
    public String deleteFarmProductByFarmIDAndProductID(@PathVariable int FarmID,@PathVariable int ProductID){
        return farmProductService.deleteFarmProductByFarmIDAndProductID(FarmID,ProductID);
    }

    @PutMapping("/deleteAllFarmProductByFarmID/{id}")
    public String deleteAllFarmersProductByFarmerID(@PathVariable int id) { return  farmProductService.deleteAllProductsOfFarm(id);}

    @PutMapping("/deleteAllFarmProductByProductID/{id}")
    public String deleteAllFarmersProductByProductID(@PathVariable int id) { return  farmProductService.deleteAllFarmProductByProductID(id);}

    @GetMapping("/FarmsByProductID/{id}")
    public List<Farm> getFarmersByProductID(@PathVariable int id){ return farmProductService.getFarmsByProduct(id); }

    @GetMapping("/FarmProductByFarmIDAndProductID/{farmid}/{productid}")
    public FarmProduct getFarmProductByFarmIDAndProductID(@PathVariable int farmid, @PathVariable int productid){
        return farmProductService.getFarmProductByFarmIDAndProductID(farmid, productid);
    }

    @GetMapping("/ProductsByFarmID/{id}")
    public List<Product> getProductsByFarmerID(@PathVariable int id){ return farmProductService.getProductsByFarm(id); }

    @PutMapping("/UpdateFarmProductStatus")
    public FarmProduct updateStatus(@RequestBody FarmProduct farmProduct){
        return farmProductService.UpdateStatus(farmProduct);
    }

}

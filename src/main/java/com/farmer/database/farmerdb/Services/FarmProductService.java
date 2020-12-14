package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Entities.FarmProduct;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Repositories.FarmProductRepository;
import com.farmer.database.farmerdb.Repositories.FarmRepository;
import com.farmer.database.farmerdb.Repositories.FarmerRepository;
import com.farmer.database.farmerdb.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmProductService {

    @Autowired
    private FarmProductRepository farmProductRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private ProductRepository productRepository;

    //Save one Farmer's Product
    public FarmProduct saveFarmProduct(FarmProduct farmProduct){
        FarmProduct farmProduct1 = farmProductRepository.getFarmProductByFarmIDAndProductID(farmProduct.FarmID,farmProduct.ProductID);
        if(farmProduct1 != null){
            return null;
        }
        return farmProductRepository.save(farmProduct);
    }

    //Save a list of Farmer's Products
    public List<FarmProduct> saveFarmProducts(List<FarmProduct> farmProducts){
        List<FarmProduct> refinedList = new ArrayList();
        for (FarmProduct f: farmProducts) {
            if(farmProductRepository.getFarmProductByFarmIDAndProductID(f.FarmID,f.ProductID) == null){
                refinedList.add(f);
            }
        }
        return farmProductRepository.saveAll(refinedList);
    }

    //retrieve Products By Farm
    public List<Product> getProductsByFarm(int id){
        List<Product> products = new ArrayList();
        List<Integer> farmproductsIDs = farmProductRepository.findProductsByFarmID(id);
        for (int productid: farmproductsIDs) {
            Optional<Product> p = productRepository.findById(productid);
            if(p.isPresent()){
                Product p2 = p.get();
                products.add(p2);
            }
        }

        return products;
    }

    //retrieve Farmers By Product
    public List<Farm> getFarmsByProduct(int id){
        List<Farm> farms = new ArrayList();
        List<Integer> productfarmerIDs = farmProductRepository.findFarmsByProductID(id);
        for (int farmerId: productfarmerIDs) {
            Optional<Farm> p = farmRepository.findById(farmerId);
            if(p.isPresent()){
                Farm p2 = p.get();
                farms.add(p2);
            }
        }

        return farms;
    }

    public FarmProduct getFarmProductByFarmIDAndProductID(int farmid,int productid){
        return farmProductRepository.getFarmProductByFarmIDAndProductID(farmid, productid);
    }

    //Update
    public FarmProduct UpdateQuantity(FarmProduct farmProduct){
        FarmProduct existingfarmProduct = farmProductRepository.findById(farmProduct.FarmProductID).orElse(null);
        if (existingfarmProduct != null){
            existingfarmProduct.Quantity = farmProduct.Quantity;
            existingfarmProduct.Unit = farmProduct.Unit;
            return farmProductRepository.save(existingfarmProduct);
        }
        else{
            return null;
        }
    }

    //Delete
    public String delete(int id){
        farmProductRepository.deleteById(id);
        return "Farmer's Product removed! " + id;
    }
    public String deleteFarmProductByFarmIDAndProductID(int FarmID,int ProductID){
        farmProductRepository.deleteFarmProductByFarmIDAndProductID(FarmID,ProductID);
        return "deleted!";
    }
    public String deleteAllProductsOfFarm(int id){
       farmProductRepository.deleteFarmProductByFarmID(id);
       return "Successfully deleted all FarmProduct of FarmID: " + id;
    }
    public String deleteAllFarmProductByProductID(int id){
        farmProductRepository.deleteFarmProductByProductID(id);
        return "Successfully deleted all FarmProduct of ProductID: " + id;
    }

}

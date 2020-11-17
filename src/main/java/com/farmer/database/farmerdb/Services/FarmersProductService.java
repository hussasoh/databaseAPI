package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farmer;
import com.farmer.database.farmerdb.Entities.FarmerProduct;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Repositories.FarmersProductRepository;
import com.farmer.database.farmerdb.Repositories.FarmerRepository;
import com.farmer.database.farmerdb.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmersProductService {

    @Autowired
    private FarmersProductRepository farmersProductRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private ProductRepository productRepository;

    //Save one Farmer's Product
    public FarmerProduct saveFarmerProduct(FarmerProduct farmerProduct){
        return farmersProductRepository.save(farmerProduct);
    }

    //Save a list of Farmer's Products
    public List<FarmerProduct> saveFarmerProducts(List<FarmerProduct> farmerProducts){
        return farmersProductRepository.saveAll(farmerProducts);
    }

    //retrieve Products By Farmer
    public List<Product> getProductsByFarmer(int id){
        List<Product> products = new ArrayList();
        List<Integer> farmerproductsIDs = farmersProductRepository.findProductsByFarmerID(id);
        for (int productid: farmerproductsIDs) {
            Optional<Product> p = productRepository.findById(productid);
            if(p.isPresent()){
                Product p2 = p.get();
                products.add(p2);
            }
        }

        return products;
    }

    //retrieve Farmers By Product
    public List<Farmer> getFarmersByProduct(int id){
        List<Farmer> farmers = new ArrayList();
        List<Integer> productfarmerIDs = farmersProductRepository.findFarmersByProductID(id);
        for (int farmerId: productfarmerIDs) {
            Optional<Farmer> p = farmerRepository.findById(farmerId);
            if(p.isPresent()){
                Farmer p2 = p.get();
                farmers.add(p2);
            }
        }

        return farmers;
    }

    //Delete
    public String delete(int id){
        farmersProductRepository.deleteById(id);
        return "Farmer's Product removed! " + id;
    }
    public String deleteAllProductsOfFarmer(int id){
        List<Integer> farmerproductids = farmersProductRepository.findFarmersProductByFarmerID(id);
        String deletedIDs = "";
        for (int farmerproductid: farmerproductids) {
            farmersProductRepository.deleteById(farmerproductid);
            deletedIDs += "Deleted id: " + farmerproductid + "\n";
        }
       return  deletedIDs;
    }
    public String deleteAllFamersProductByProductID(int id){
        List<Integer> farmersproductsbyproductids = farmersProductRepository.findFarmersProductByProductID(id);
        String deleteIDs = "";
        for(int farmerproducts: farmersproductsbyproductids){
            farmersProductRepository.deleteById(farmerproducts);
            deleteIDs += "Delete id: " + farmerproducts + "\n";
        }
        return deleteIDs;
    }

}

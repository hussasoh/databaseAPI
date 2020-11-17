package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.FarmerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmersProductRepository extends JpaRepository<FarmerProduct,Integer> {

    @Query(value = "SELECT DISTINCT Product_ID FROM Farmer_Products WHERE Farmer_ID = ?1", nativeQuery = true)
    List<Integer> findProductsByFarmerID(int id);

    @Query(value = "SELECT DISTINCT Farmer_ID FROM Farmer_Products WHERE Product_ID = ?1", nativeQuery = true)
    List<Integer> findFarmersByProductID(int id);

    @Query(value = "SELECT FarmerProduct_ID FROM Farmer_Products WHERE Farmer_ID = ?1", nativeQuery = true)
    List<Integer> findFarmersProductByFarmerID(int id);

    @Query(value = "SELECT FarmerProduct_ID FROM Farmer_Products WHERE Product_ID = ?1", nativeQuery = true)
    List<Integer> findFarmersProductByProductID(int id);
}

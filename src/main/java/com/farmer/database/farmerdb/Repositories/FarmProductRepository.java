package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.FarmProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmProductRepository extends JpaRepository<FarmProduct,Integer> {

    @Query(value = "SELECT DISTINCT Product_ID FROM Farm_Products WHERE Farm_ID = ?1", nativeQuery = true)
    List<Integer> findProductsByFarmID(int id);

    @Query(value = "SELECT DISTINCT Farm_ID FROM Farm_Products WHERE Product_ID = ?1", nativeQuery = true)
    List<Integer> findFarmsByProductID(int id);

    @Query(value = "SELECT FarmProduct_ID FROM Farm_Products WHERE Farm_ID = ?1", nativeQuery = true)
    List<Integer> findFarmProductByFarmID(int id);

    @Query(value = "SELECT FarmProduct_ID FROM Farm_Products WHERE Product_ID = ?1", nativeQuery = true)
    List<Integer> findFarmProductByProductID(int id);
}

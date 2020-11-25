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

    @Query(value = "DELETE FROM Farm_Products WHERE Farm_ID = ?1", nativeQuery = true)
    String deleteFarmProductByFarmID(int id);

    @Query(value = "DELETE FROM Farm_Products WHERE Product_ID = ?1", nativeQuery = true)
    String deleteFarmProductByProductID(int id);

    @Query(value = "DELETE FROM Farm_Products WHERE Farm_ID = ?1 AND Product_ID = ?2", nativeQuery = true)
    String deleteFarmProductByFarmIDAndProductID(int FarmID,int ProductID);

    @Query(value = "SELECT * FROM Farm_Products WHERE Farm_ID = ?1 AND Product_ID = ?2", nativeQuery = true)
    FarmProduct getFarmProductByFarmIDAndProductID(int farmID, int productID);
}

package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.FarmProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface FarmProductRepository extends JpaRepository<FarmProduct,Integer> {

    @Query(value = "SELECT DISTINCT Product_ID FROM Farm_Products WHERE Farm_ID = ?1", nativeQuery = true)
    List<Integer> findProductsByFarmID(int id);

    @Query(value = "SELECT DISTINCT Farm_ID FROM Farm_Products WHERE Product_ID = ?1", nativeQuery = true)
    List<Integer> findFarmsByProductID(int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Farm_Products WHERE Farm_ID = ?1", nativeQuery = true)
    void deleteFarmProductByFarmID(int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Farm_Products WHERE Product_ID = ?1", nativeQuery = true)
    void deleteFarmProductByProductID(int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Farm_Products WHERE Farm_ID = ?1 AND Product_ID = ?2", nativeQuery = true)
    void deleteFarmProductByFarmIDAndProductID(int FarmID,int ProductID);

    @Query(value = "SELECT * FROM Farm_Products WHERE Farm_ID = ?1 AND Product_ID = ?2", nativeQuery = true)
    FarmProduct getFarmProductByFarmIDAndProductID(int farmID, int productID);
}

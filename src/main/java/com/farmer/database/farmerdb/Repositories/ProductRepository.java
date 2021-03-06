package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT * FROM Product WHERE Product_Name = ?1", nativeQuery = true)
    List<Product> findByName(String name);

    @Query(value = "SELECT * FROM Product WHERE Product_Category = ?1", nativeQuery = true)
    List<Product> findByCategory(String category);

    @Query(value = "SELECT DISTINCT Product_Category from Product", nativeQuery = true)
    List<String> getProductOptions();

    @Query(value = "SELECT * from Product WHERE upper(Product_Name) like upper(?1) AND upper(Product_Category) like upper(?2)", nativeQuery = true)
    Product getProductByNameAndCategory(String productName, String productCategory);

    @Query(value = "SELECT Product_ID from Product WHERE upper(Product_Name) like upper(?1) AND upper(Product_Category) like upper(?2)", nativeQuery = true)
    int getProductIDByNameAndCategory(String productName, String productCategory);


}

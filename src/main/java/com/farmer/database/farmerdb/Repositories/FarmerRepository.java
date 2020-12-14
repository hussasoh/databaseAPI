package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

    @Query(value = "SELECT * FROM Farmer WHERE Customer_ID = ?1", nativeQuery = true)
    Farmer findByCustomerID(int id);

    @Query(value = "SELECT Customer_ID FROM Farmer WHERE Farmer_ID = ?1", nativeQuery = true)
    int getFarmerCustomerID(int id);
}

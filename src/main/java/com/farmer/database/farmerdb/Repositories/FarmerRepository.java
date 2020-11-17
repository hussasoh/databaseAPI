package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

    @Query(value = "SELECT * FROM Farmer WHERE Business_Name = ?1", nativeQuery = true)
    List<Farmer> findByName(String name);

    @Query(value = "SELECT * FROM Farmer WHERE Customer_ID = ?1", nativeQuery = true)
    Farmer findByCustomerID(int id);

    @Query(value = "SELECT Customer_ID FROM Farmer WHERE Farmer_ID = ?1", nativeQuery = true)
    int getFarmerCustomerID(int id);
}

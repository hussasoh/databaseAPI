package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface FarmRepository extends JpaRepository<Farm,Integer> {

    @Query(value = "SELECT * FROM Farm WHERE Farmer_ID = ?1", nativeQuery = true)
    List<Farm> getFarmsByFarmerID(int id);
}

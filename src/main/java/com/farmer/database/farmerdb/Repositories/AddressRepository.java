package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Address;
import com.farmer.database.farmerdb.Entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT * FROM Address WHERE Customer_ID = ?1", nativeQuery = true)
    Address findByCustomerID(int id);

    @Query(value = "DELETE FROM Address WHERE Customer_ID = ?1", nativeQuery = true)
    void deleteByCustomerID(int id);
}

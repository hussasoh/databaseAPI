package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM Customer WHERE Customer_Name = ?1", nativeQuery = true)
    List<Customer> findByName(String name);

    @Query(value = "SELECT * FROM Customer WHERE Customer_Email = ?1", nativeQuery = true)
    Customer findByEmail(String email);
}

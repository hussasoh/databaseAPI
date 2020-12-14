package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    @Query(value = "SELECT * FROM Customer_Ratings WHERE Farm_ID = ?1", nativeQuery = true)
    List<Rating> getAllRatingsByFarmID(int id);

    @Query(value = "SELECT * FROM Customer_Ratings WHERE Customer_ID = ?1", nativeQuery = true)
    List<Rating> getAllRatingsByCustomerID(int id);

    @Query(value = "SELECT * FROM Customer_Ratings WHERE Farm_ID = ?1 AND Customer_ID =?2", nativeQuery = true)
    Rating getRatingByCustomerIDAndFarmID(int farmID, int customerID);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Customer_Ratings WHERE Farm_ID = ?1 AND Customer_ID =?2", nativeQuery = true)
    void deleteRatingByCustomerIDAndFarmID(int farmID, int customerID);
}

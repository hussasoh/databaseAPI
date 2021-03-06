package com.farmer.database.farmerdb.Repositories;

import com.farmer.database.farmerdb.Entities.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
public interface FollowingRepository extends JpaRepository<Following,Integer> {

    @Query(value = "SELECT Farm_ID FROM Following_Farms WHERE Customer_ID = ?1", nativeQuery = true)
    List<Integer> getAllFarmIDByCustomerID(int id);

    @Query(value = "SELECT * FROM Following_Farms WHERE Farm_ID = ?1 AND Customer_ID =?2", nativeQuery = true)
    Following getFollowByCustomerIDAndFarmID(int FarmID,int CustomerID);

    @Query(value = "SELECT COUNT(*) FROM Following_Farms WHERE Farm_ID = ?1", nativeQuery = true)
    int getFollowCountByFarmID(int FarmID);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Following_Farms WHERE Farm_ID = ?1 AND Customer_ID =?2", nativeQuery = true)
    void deleteFollowByCustomerIDAndFarmID(int FarmID,int CustomerID);

}

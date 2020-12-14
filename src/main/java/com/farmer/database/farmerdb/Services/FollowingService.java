package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Following;
import com.farmer.database.farmerdb.Repositories.FarmRepository;
import com.farmer.database.farmerdb.Repositories.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Service
public class FollowingService {

    @Autowired
    private FollowingRepository followingRepository;

    @Autowired
    private FarmRepository farmRepository;

    //Save One Follow
    public Following saveFollow(Following following){
        Following following1 = followingRepository.getFollowByCustomerIDAndFarmID(following.FarmID,following.CustomerID);
        if(following1 != null){
            return null;
        }
        return followingRepository.save(following);
    }
    //Save a List of Follows
    public List<Following> saveFollows(List<Following> followings){
        List<Following> refinedList = new ArrayList();
        for (Following f:followings) {
            if(followingRepository.getFollowByCustomerIDAndFarmID(f.FarmID,f.CustomerID) == null){
                refinedList.add(f);
            }
        }
        return followingRepository.saveAll(refinedList);
    }

    //retrieve
    //by Follow ID
    public Following getFollowByID(int id){ return followingRepository.findById(id).orElse(null);}
    //by Customer and Farm ID
    public Following getFollowByCustomerIDAndFarmID(int FarmID,int CustomerID){ return followingRepository.getFollowByCustomerIDAndFarmID(FarmID,CustomerID);}
    //list of farms By Customer ID
    public List<Farm> GetFollowedFarmsByCustomerID(int id){
        List<Integer> FarmIDs = followingRepository.getAllFarmIDByCustomerID(id);
        List<Farm> farms = new ArrayList();
        for (int Farmid:FarmIDs) {
            Farm farm = farmRepository.findById(Farmid).orElse(null);
            if(farm != null){
                farms.add(farm);
            }
        }
        return farms;
    }

    public int getFollowCountForFarm(int id){
        return followingRepository.getFollowCountByFarmID(id);
    }

    //delete
    public String deleteFollowByCustomerIDandFarmID(int FarmID,int CustomerID){
        followingRepository.deleteFollowByCustomerIDAndFarmID(FarmID,CustomerID);
        return  "deleted!";
    }



}

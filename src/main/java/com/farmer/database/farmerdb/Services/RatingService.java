package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Rating;
import com.farmer.database.farmerdb.Repositories.FarmRepository;
import com.farmer.database.farmerdb.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private FarmRepository farmRepository;

    public Rating saveRating(Rating rating) {
        Rating rating1 = ratingRepository.getRatingByCustomerIDAndFarmID(rating.FarmID,rating.CustomerID);
        if(rating1 != null) {
            return null;
        }
        Rating ratingsaved = ratingRepository.save(rating);
        Optional<Farm> farm = farmRepository.findById(rating.FarmID);
        if(farm != null && farm.get() != null){
            List<Rating> farmRatings = getAllFarmRatings(rating.FarmID);
            float acc = 0;
            for (Rating frating:farmRatings) {
                acc += frating.Rating;
            }
            acc = (acc/farmRatings.size());
            Farm existingfarm = farm.get();
            existingfarm.Business_Rating = acc;
            farmRepository.save(existingfarm);
        }
        return ratingsaved;
    }

    public Rating getRatingByID(int id){ return ratingRepository.findById(id).orElse(null); }

    public List<Rating> getAllFarmRatings(int id){ return ratingRepository.getAllRatingsByFarmID(id); }

    public List<Rating> getAllCustomerRatings(int id){ return ratingRepository.getAllRatingsByCustomerID(id); }

    public String deleteRatingByCustomerIDAndFarmID(int FarmID, int CustomerID){
        ratingRepository.deleteRatingByCustomerIDAndFarmID(FarmID,CustomerID);
        return "Deleted Rating with FarmID: "+ FarmID + " CustomerID: "+ CustomerID;
    }

    public Rating getRatingByCustomerIDAndFarmID(int FarmID, int CustomerID){
        return ratingRepository.getRatingByCustomerIDAndFarmID(FarmID, CustomerID);
    }
}

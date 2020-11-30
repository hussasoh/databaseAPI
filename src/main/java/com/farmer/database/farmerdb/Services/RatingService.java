package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Rating;
import com.farmer.database.farmerdb.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        Rating rating1 = ratingRepository.getRatingByCustomerIDAndFarmID(rating.FarmID,rating.CustomerID);
        if(rating1 != null) {
            return null;
        }
        return ratingRepository.save(rating);
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

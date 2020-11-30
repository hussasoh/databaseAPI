package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Rating;
import com.farmer.database.farmerdb.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public Rating saveRating(@RequestBody Rating rating){ return ratingService.saveRating(rating); }

    @GetMapping("/getRatingByID/{id}")
    public Rating getRatingByID(@PathVariable int id){
        return ratingService.getRatingByID(id);
    }

    @GetMapping("/getAllFarmRatings/{id}")
    public List<Rating> getAllFarmRatings(@PathVariable int id){
        return ratingService.getAllFarmRatings(id);
    }

    @GetMapping("/getAllCustomerRatings/{id}")
    public List<Rating> getAllCustomerRatings(@PathVariable int id){
        return ratingService.getAllCustomerRatings(id);
    }

    @GetMapping("/getRatingByCustomerIDAndFarmID/{FarmID}/{CustomerID}")
    public Rating getRatingByCustomerIDAndFarmID(@PathVariable int FarmID,@PathVariable int CustomerID){
        return ratingService.getRatingByCustomerIDAndFarmID(FarmID,CustomerID);
    }

    @PutMapping("/deleteRatingByCustomerIDAndFarmID/{FarmID}/{CustomerID}")
    public String deleteRatingByCustomerIDAndFarmID(@PathVariable int FarmID,@PathVariable int CustomerID){
        return ratingService.deleteRatingByCustomerIDAndFarmID(FarmID,CustomerID);
    }
}

package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Farm;
import com.farmer.database.farmerdb.Entities.Following;
import com.farmer.database.farmerdb.Services.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowingController {

    @Autowired
    private FollowingService followingService;

    @PostMapping("/addFollow")
    public Following addFollow(@RequestBody Following following){return followingService.saveFollow(following);}

    @PostMapping("/addFollows")
    public List<Following> addFollows(@RequestBody List<Following> followings){return followingService.saveFollows(followings);}

    @GetMapping("/getFollowByID/{id}")
    public Following getFollowByID(@PathVariable int id){ return followingService.getFollowByID(id);}

    @GetMapping("/getFollowByCustomerIDAndFarmID/{FarmID}/{CustomerID}")
    public Following getFollowByCustomerIDAndFarmID(@PathVariable int FarmID,@PathVariable int CustomerID){ return followingService.getFollowByCustomerIDAndFarmID(FarmID,CustomerID); }

    @GetMapping("/getFollowedFarmsByCustomerID/{id}")
    public List<Farm> getFollowedFarmsByCustomerID(@PathVariable int id){ return followingService.GetFollowedFarmsByCustomerID(id); }

    @GetMapping("/getFarmFollowers/{id}")
    public int getFarmFollowers(@PathVariable int id){ return followingService.getFollowCountForFarm(id); }

    @PutMapping("/deleteFollowByCustomerIDAndFarmID/{FarmID}/{CustomerID}")
    public String deleteFollowByCustomerIDAndFarmID(@PathVariable int FarmID,@PathVariable int CustomerID){ return followingService.deleteFollowByCustomerIDandFarmID(FarmID, CustomerID); }
}

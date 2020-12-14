package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Entity
@Table(name = "Following_Farms")
public class Following {

    @Id
    @Column(name = "Following_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int FollowingID;
    @Column(name = "Customer_ID")
    public int CustomerID;
    @Column(name = "Farm_ID")
    public int FarmID;
}

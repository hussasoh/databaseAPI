package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

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

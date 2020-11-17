package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Farmer")
public class Farmer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Farmer_ID")
    public int FarmerID;
    @Column(name = "Buisness_Name")
    public String BusinessName;
    @Column(name = "Business_Description")
    public String BusinessDescription;
    @Column(name = "Buisness_Rating")
    public int BusinessRating;
}

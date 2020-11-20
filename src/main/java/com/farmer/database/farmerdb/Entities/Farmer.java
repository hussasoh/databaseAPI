package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Farmer")
public class Farmer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Farmer_ID")
    public int FarmerID;
    @Column(name = "Customer_ID")
    public int CustomerID;
}

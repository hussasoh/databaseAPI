package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Farmer_Products")
public class FarmerProduct {

    @Id
    @Column(name = "FarmerProduct_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int FarmerProductID;

    @Column(name = "Farmer_ID")
    public int FarmerID;

    @Column(name = "Product_ID")
    public int ProductID;
}

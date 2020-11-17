package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    public int ProductID;
    @Column(name = "Product_Name")
    public String ProductName;
    @Column(name = "Product_Category")
    public String ProductCategory;
}

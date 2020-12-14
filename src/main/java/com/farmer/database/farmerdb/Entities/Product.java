package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
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

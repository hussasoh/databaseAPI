package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Entity
@Table(name = "Farm_Products")
public class FarmProduct {

    @Id
    @Column(name = "FarmProduct_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int FarmProductID;

    @Column(name = "Farm_ID")
    public int FarmID;

    @Column(name = "Product_ID")
    public int ProductID;

    @Column(name = "Quantity")
    public int Quantity;

    @Column(name = "Unit")
    public String Unit;

}

package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Entity
@Table(name = "Customer_Ratings")
public class Rating {

    @Id
    @Column(name = "Rating_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int RatingID;
    @Column(name = "Farm_ID")
    public int FarmID;
    @Column(name = "Customer_ID")
    public int CustomerID;
    @Column(name = "Rating")
    public float Rating;
    @Column(name = "Feedback")
    public String Feedback;
}

package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

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
    public int Rating;
    @Column(name = "Feedback")
    public String Feedback;
}

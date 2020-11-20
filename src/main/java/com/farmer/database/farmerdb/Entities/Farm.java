package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Farm")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Farm_ID")
    public int Farm_ID;
    @Column(name = "Business_Name")
    public String Businsess_Name;
    @Column(name = "Business_Description")
    public String Business_Description;
    @Column(name = "Business_Rating")
    public int Business_Rating;
    @Column(name = "City")
    public String City;
    @Column(name = "Street")
    public String Street;
    @Column(name = "Country")
    public String Country;
    @Column(name = "PostalCode")
    public String PostalCode;
    @Column(name = "Unit")
    public int Unit;
    @Column(name = "Farmer_ID")
    public int Farmer_ID;
}

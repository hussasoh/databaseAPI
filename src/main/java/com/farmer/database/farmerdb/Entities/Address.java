package com.farmer.database.farmerdb.Entities;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_ID")
    public int AddressID;
    @Column(name = "Customer_ID")
    public int CustomerID;
    @Column(name = "Street")
    public String Street;
    @Column(name = "City")
    public String City;
    @Column(name = "Country")
    public String Country;
    @Column(name = "PostalCode")
    public String PostalCode;
    @Column(name = "unit")
    public int unit;
}

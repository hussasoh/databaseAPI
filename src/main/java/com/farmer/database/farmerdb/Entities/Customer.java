package com.farmer.database.farmerdb.Entities;

import javax.persistence.*;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    public int CustomerID;
    @Column(name ="Customer_Name" )
    public String CustomerName;
    @Column(name = "Customer_Email")
    public String CustomerEmail;
    @Column(name = "Customer_Password")
    public String CustomerPassword;

}
